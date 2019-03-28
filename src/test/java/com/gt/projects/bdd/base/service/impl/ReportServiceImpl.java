package com.gt.projects.bdd.base.service.impl;

import org.codehaus.plexus.util.Base64;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.gt.projects.bdd.RunnerClass;
import com.gt.projects.bdd.base.entity.*;
import com.gt.projects.bdd.base.enums.Platform;
import com.gt.projects.bdd.base.repository.GherkinEmbeddingRepository;
import com.gt.projects.bdd.base.repository.GherkinStepRepository;
import com.gt.projects.bdd.base.service.ReportService;
import com.gt.projects.bdd.base.utils.CmdUtils;
import cucumber.api.event.EmbedEvent;
import cucumber.runner.EventBus;
import cucumber.runtime.Runtime;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by giotto.chow on 1/23/2018.
 */
@Service
@Scope("thread")
public class ReportServiceImpl implements ReportService{
    
    @Autowired
    private GherkinStepRepository gherkinStepRepository;
    
    @Autowired
    private GherkinEmbeddingRepository gherkinEmbeddingRepository;
    
    protected Logger logger = Logger.getLogger(this.getClass());
    
    private Map<String, ExecuteWatchdog> videoRecordingSession;
    
    public void generateReport(String platform, String version, String app, String jsonFilePath, String targetFolder, String udid){
        
        File file = new File(jsonFilePath);
        List<String> jsonFiles = Arrays.asList(file.getAbsolutePath());
        
        File outputDir = new File(targetFolder + "/" + file.getName());
        
        String projectName = "BDD";
        
        Configuration configuration = new Configuration(outputDir, projectName);
        configuration.setParallelTesting(false);
        configuration.setRunWithJenkins(false);
        configuration.setBuildNumber("1");
        if(StringUtils.isNotBlank(platform))    configuration.addClassifications("Platform", platform);
        if(StringUtils.isNotBlank(version))    configuration.addClassifications("OS Version", version);
        if(StringUtils.isNotBlank(app))    configuration.addClassifications("App Version", app);
        if(StringUtils.isNotBlank(udid))  configuration.addClassifications("Udid", udid);
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();
    }
    
    @Override
    public void saveToJsonFile(String fileName) {
        try {
            File jsonFile = new File(fileName);
            jsonFile.deleteOnExit();
            jsonFile.createNewFile();
            FileWriter fileWriter = new FileWriter(jsonFile);
//            fileWriter.write(new Gson().toJson(featureList));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ex){
            logger.error(ex);
        }
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void generateHtmlReportJson(String targetFile, List<GherkinScenario> scenarioList){
    
        List<Map<String, Object>> resultFeatureList = new ArrayList<>();
        List<Map<String, Object>> resultScenarioList = new ArrayList<>();

        String previousUri = "";
        int  count  = 0;
        //Scenario List
        for(GherkinScenario scenario : scenarioList){

            // Feature (-1 Level)
            if(!scenario.getUri().equals(previousUri)){
                count++;
                // Feature file changed
                Map<String, Object> resultFeature = new HashMap();
                resultFeature.put("line" , count);
                int intexStart = scenario.getUri().lastIndexOf("/");
                String name = scenario.getUri().substring(intexStart+1,scenario.getUri().lastIndexOf("."));
                resultFeature.put("name" , name);
                resultFeature.put("description" , "");
                resultFeature.put("id" , "BDD Report");
                resultFeature.put("keyword" , "Feature");
                resultFeature.put("uri" , scenario.getUri());
                previousUri = scenario.getUri();
                resultFeatureList.add(resultFeature);
                // Move to new feature tree

                resultScenarioList = new ArrayList<>();
                resultFeature.put("elements", resultScenarioList);
            }

            // Scenario
            Map<String, Object> resultScenario = new HashMap<>();
            resultScenario.put("line" , scenario.getLine());
            resultScenario.put("name" , scenario.getName());
            resultScenario.put("description" , "");
            resultScenario.put("id" , scenario.getName());
            resultScenario.put("type" , "scenario");
            resultScenario.put("keyword" , "Scenario");
            resultScenarioList.add(resultScenario);

            // Scenario Tags
            List<Map<String, Object>> resultScenarioTagList = new ArrayList<>();

            String scenarioTags = scenario.getTags();
            if(StringUtils.isNotBlank(scenarioTags)){
                for(String tag : scenarioTags.split(",")){
                    Map<String, Object> resultScenarioTag = new HashMap<>();
                    resultScenarioTag.put("line", 1);
                    resultScenarioTag.put("name", tag);
                    resultScenarioTagList.add(resultScenarioTag);
                }
            }
            resultScenario.put("tags", resultScenarioTagList);


            // Step List
            List<Map<String, Object>> resultStepList = new ArrayList<>();
            List<GherkinStep> gherkinStepList = gherkinStepRepository.findAllByScenario(scenario);
            boolean isRet = false;
            if(scenario.getResult().equalsIgnoreCase("passed"))
            {
                isRet = true;
            }
            for(GherkinStep step : gherkinStepList){

                // Step
                Map<String, Object> resultStep = new HashMap();
                resultStepList.add(resultStep);
                if(step.getType() == null)
                {
                    continue;
                }
                resultStep.put("keyword" , step.getType());
                resultStep.put("name" , step.getName());
                resultStep.put("line" , step.getLine());

                Map<String, Object> stepMatch = new HashMap<>();
                stepMatch.put("location" , step.getCodeLocation());
                resultStep.put("match" , stepMatch);

                Map<String, Object> stepResult = new HashMap<>();
                stepResult.put("duration" , step.getDuration());
                if(isRet)
                {
                    stepResult.put("status" , "Passed");
                }
                else {
                    stepResult.put("status" , step.getStatus());
                }
                if(step.getStatus() != null && !step.getStatus().toLowerCase().equals("passed") && !isRet)
                {
                    stepResult.put("error_message" , step.getErrorMessage());
                }
                resultStep.put("result" , stepResult);

                if(step.getDataTable() != null && step.getDataTable().length != 0) {
                    List<Map<String, Object>> resultStepRow = new ArrayList<>();

                    List<List<String>> datatable = new Gson().fromJson(new String(step.getDataTable()), new TypeToken<List<List<String>>>(){}.getType());
                    for (List<String> row : datatable) {
                        Map<String, Object> cell = new HashMap<String, Object>();
                        cell.put("line", 1);
                        cell.put("cells", row);
                        resultStepRow.add(cell);
                    }
                    resultStep.put("rows", resultStepRow);
                }

                List<Map<String, Object>> resultEmbedding = new ArrayList<>();
                List<GherkinEmbedding> embeddingList = gherkinEmbeddingRepository.findByStep(step);
                for(GherkinEmbedding embedding : embeddingList){
                    try{
                        Map<String, Object> embedded = new HashMap<String, Object>();
                        embedded.put("data", new String(Base64.encodeBase64(Files.readAllBytes(Paths.get(new String(embedding.getData()))))));
                        embedded.put("mime_type", "image/png");
                        resultEmbedding.add(embedded);
                    } catch(IOException ex){
                        ex.printStackTrace();
                    }
                }
                resultStep.put("embeddings" , resultEmbedding);
            }

            resultScenario.put("steps", resultStepList);
        }

        try {
            Files.write(Paths.get(targetFile), new Gson().toJson(resultFeatureList).getBytes());
        } catch(Exception ex){
            ex.printStackTrace();
            logger.error(ex);
        }
    }

//
//
//    public void generateReport(File targetFile, List<GherkinFeature> featuresList){
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        Workbook workbook = null;
//        try{
//            BufferedInputStream buffIn = new BufferedInputStream(new FileInputStream("src/test/resources/reportTemplate.xlsx"));
//            workbook = new HSSFWorkbook(buffIn);
//        } catch(IOException | OfficeXmlFileException ex){
//            try {
//                BufferedInputStream buffIn = new BufferedInputStream(new FileInputStream("src/test/resources/reportTemplate.xlsx"));
//                workbook = new XSSFWorkbook(buffIn);
//            } catch(IOException ex2){
//                ex2.printStackTrace();
//            }
//        }
//
//        Map<String, List<Integer>> sprintMap = new HashMap<>();
//        Map<String, List<Integer>> epicMap = new HashMap<>();
//
//        Row row;
//        Cell cell;
//
//        int rowCount = 1;
//        int columnCount = 0;
//
//        Sheet scenarioSummary = workbook.getSheetAt(2);
//        for(GherkinFeature feature : featuresList){
//
//            row = scenarioSummary.createRow(rowCount++);
//            cell = row.createCell(columnCount++);
//            cell.setCellValue(feature.getUri());
//
//            for(GherkinScenario scenario : feature.getScenarios()){
//                cell = row.createCell(columnCount++);
//                cell.setCellValue(scenario.getLine());
//
//                cell = row.createCell(columnCount++);
//                cell.setCellValue(sdf.format(new Date(scenario.getDateStart())));
//
//                cell = row.createCell(columnCount++);
//                cell.setCellValue(scenario.getName());
//
//                /* Type, Epic, AC, AT */
//
//                List<String> sprint = new ArrayList<>();
//                cell = row.createCell(columnCount++);
//                for(String tag : scenario.getTags()) {
//                    if(tag.toUpperCase().contains("SPRINT")) {
//                        sprint.add(tag);
//                    }
//                }
//                cell.setCellValue(sprint.toString());
//
//                List<String> epic = new ArrayList<>();
//                cell = row.createCell(columnCount++);
//                for(String tag : scenario.getTags()) {
//                    if(tag.toUpperCase().contains("EPIC")) {
//                        epic.add(tag);
//                    }
//                }
//                cell.setCellValue(epic.toString());
//
//
//                int noOfAt = 0;
//                String at = "";
//                for(String tag : scenario.getTags()) {
//                    at += ", " + tag.toLowerCase().contains("at");
//                    noOfAt++;
//                }
//
//                cell = row.createCell(columnCount++);
//                cell.setCellValue(noOfAt);
//
//                cell = row.createCell(columnCount++);
//                cell.setCellValue(StringUtils.isNotBlank(at) ? at.substring(1) : "");
//
//                int noOfAc = 0;
//                String ac = "";
//                for(String tag : scenario.getTags()) {
//                    ac += ", " + tag.toLowerCase().contains("ac");
//                    noOfAc++;
//                }
//
//                cell = row.createCell(columnCount++);
//                cell.setCellValue(noOfAc);
//
//                cell = row.createCell(columnCount++);
//                cell.setCellValue(StringUtils.isNotBlank(ac) ? ac.substring(1) : "");
//
//                /* Result */
//                cell = row.createCell(columnCount++);
//                cell.setCellValue(scenario.getResult());
//
//                cell = row.createCell(columnCount++);
//                cell.setCellValue(scenario.getErrorMessage());
//
//                cell = row.createCell(columnCount++);
//                cell.setCellValue(scenario.getDuration());
//
//                int totalCount = scenario.getSteps().size();
//                int successCount = 0;
//                for(GherkinStep step : scenario.getSteps()){
//                    if("PASSED".equalsIgnoreCase(step.getStatus()))
//                        successCount++;
//                }
//                cell = row.createCell(columnCount++);
//                cell.setCellValue(successCount + " / " + totalCount);
//
//                for(String tag : scenario.getTags()) {
//                    cell = row.createCell(columnCount++);
//                    cell.setCellValue(tag);
//                }
//
//                if(sprint.size() != 0 && totalCount != 0) {
//                    for(String tmpSprint : sprint){
//                        if(!sprintMap.containsKey(tmpSprint)){
//                            sprintMap.put(tmpSprint, Arrays.asList(noOfAc, noOfAt, successCount == totalCount ?  noOfAt : 0));
//                        } else {
//                            List<Integer> sprintStat = sprintMap.get(tmpSprint);
//                            sprintMap.put(tmpSprint, Arrays.asList(sprintStat.get(0) + noOfAc, sprintStat.get(1) + noOfAt, sprintStat.get(2) + (successCount == totalCount ?  noOfAt : 0)));
//                        }
//                    }
//                }
//
//                if(epic.size() != 0 && totalCount != 0) {
//                    for(String tmpEpic : epic) {
//                        if (!epicMap.containsKey(tmpEpic)) {
//                            epicMap.put(tmpEpic, Arrays.asList(noOfAc, noOfAt, successCount == totalCount ? noOfAt : 0));
//                        } else {
//                            List<Integer> epicStat = epicMap.get(tmpEpic);
//                            epicMap.put(tmpEpic, Arrays.asList(epicStat.get(0) + noOfAc, epicStat.get(1) + noOfAt, epicStat.get(2) + (successCount == totalCount ? noOfAt : 0)));
//                        }
//                    }
//                }
//            }
//
//            columnCount = 0;
//        }
//
//
//        Sheet epicSummary = workbook.getSheetAt(0);
//        rowCount = 1;
//        columnCount = 0;
//        for(Map.Entry<String, List<Integer>> item : epicMap.entrySet()){
//
//            row = epicSummary.createRow(rowCount++);
//
//            cell = row.createCell(columnCount++);
//            cell.setCellValue(item.getKey());
//
//            List<Integer> stat = item.getValue();
//            cell = row.createCell(columnCount++);
//            cell.setCellValue(stat.get(0));
//
//            cell = row.createCell(columnCount++);
//            cell.setCellValue(stat.get(1));
//
//            cell = row.createCell(columnCount++);
//            cell.setCellValue(stat.get(2));
//
//            columnCount = 0;
//        }
//
//        Sheet sprintSummary = workbook.getSheetAt(1);
//        rowCount = 1;
//        columnCount = 0;
//        for(Map.Entry<String, List<Integer>> item : sprintMap.entrySet()){
//
//            row = sprintSummary.createRow(rowCount++);
//
//            cell = row.createCell(columnCount++);
//            cell.setCellValue(item.getKey());
//
//            List<Integer> stat = item.getValue();
//            cell = row.createCell(columnCount++);
//            cell.setCellValue(stat.get(0));
//
//            cell = row.createCell(columnCount++);
//            cell.setCellValue(stat.get(1));
//
//            cell = row.createCell(columnCount++);
//            cell.setCellValue(stat.get(2));
//
//            columnCount = 0;
//        }
//
//        try {
//            targetFile.deleteOnExit();
//            targetFile.createNewFile();
//            workbook.write(new FileOutputStream(targetFile));
//        } catch(IOException ex){
//            ex.printStackTrace();
//        }
//    }
//
    public static void main(String[] args) throws Exception{
//        new ReportServiceImpl().generateReport("AOS","1.0","Testing", "./target/cucumber.json", "target2");
//        File srcFile = new File(new String("target/screen-capture-record/2018-02-08 16-40-085951842586764958.png"));
//        System.out.println("SASA");
            CmdUtils.runCommandAsync("java -jar C:\\Users\\giotto.chow\\Desktop\\backup\\jmeter\\JMeter\\apache-jmeter-2.11\\bin\\ApacheJMeter.jar");
        System.out.println("SASA");
        Thread.sleep(50000L);
    }
    
    public void embed(byte[] data, String mimeType) {
        Runtime runtime = RunnerClass.getCurrentRuntime();
        if(runtime != null){
            EventBus eventBus = runtime.getEventBus();
            if(eventBus != null){
                eventBus.send(new EmbedEvent(eventBus.getTime(), data, mimeType));
            }
        }
    }
    
    @Override
    public void startVideoRecording(String reportName) {
        
        if(videoRecordingSession == null)   videoRecordingSession = new HashMap<>();
    
        RunnerClass runnerClass = ((RunnerClass)RunnerClass.getCurrentRunner());
        
        String uuid = runnerClass.getUdid();
        Platform platform = Platform.valueOf(runnerClass.getPlatform());
        
        ExecuteWatchdog videoRecorder;
        if(Platform.IOS.equals(platform)){
            videoRecorder = CmdUtils.runCommandAsync("xcrun simctl io booted recordVideo " + reportName + ".mp4");
        } else if (Platform.ANDROID.equals(platform)){
            videoRecorder = CmdUtils.runCommandAsync("adb -s " + uuid + " shell screenrecord /sdcard/" + reportName + ".mp4");
        } else {
            //TODO
            videoRecorder = null;
        }
        videoRecordingSession.put(reportName, videoRecorder);
    }
    
    @Override
    public File stopVideoRecording(String reportName) {
        ExecuteWatchdog process = videoRecordingSession.get(reportName);
        process.destroyProcess();
    
        RunnerClass runnerClass = ((RunnerClass)RunnerClass.getCurrentRunner());
    
        String uuid = runnerClass.getUdid();
        Platform platform = Platform.valueOf(runnerClass.getPlatform());
        
        if(Platform.IOS.equals(platform)){
        } else if (Platform.ANDROID.equals(platform)) {
            CmdUtils.runCommandAsync("adb -s " + uuid + " pull /sdcard/" + reportName + ".mp4");
        } else {
        }
        return new File(reportName + ".mp4");
    }
}

