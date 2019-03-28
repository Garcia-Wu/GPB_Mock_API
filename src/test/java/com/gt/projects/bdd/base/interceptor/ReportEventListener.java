package com.gt.projects.bdd.base.interceptor;

import com.google.gson.Gson;
import com.gt.projects.bdd.base.entity.*;
import com.gt.projects.bdd.base.repository.GherkinEmbeddingRepository;
import com.gt.projects.bdd.base.repository.GherkinScenarioRepository;
import com.gt.projects.bdd.base.repository.GherkinStepRepository;
import com.gt.projects.bdd.base.service.DeviceService;
import com.gt.projects.bdd.base.service.GherkinService;
import com.gt.projects.bdd.base.service.ReportService;
import com.gt.projects.bdd.base.utils.BeanUtils;
import com.gt.projects.bdd.base.utils.GherkinUtils;
import cucumber.api.Result;
import cucumber.api.TestCase;
import cucumber.api.TestStep;
import cucumber.api.event.*;
import cucumber.api.formatter.Formatter;
import cucumber.runtime.Argument;
import cucumber.runtime.Glue;
import gherkin.pickles.*;
import lombok.Setter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.service.DriverService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by giotto.chow on 2/12/2018.
 */
/* This is not a Spring-managed bean*/
public class ReportEventListener implements Formatter{
    
    protected Logger logger = Logger.getLogger(this.getClass());
    
    private EventHandler<TestCaseStarted> caseStartedHandler = new EventHandler<TestCaseStarted>() {
        @Override
        public void receive(TestCaseStarted testCaseStarted) {
            beforeCase(testCaseStarted);
        }
    };
    private EventHandler<TestStepStarted> stepStartedEventHandler = new EventHandler<TestStepStarted>() {
        @Override
        public void receive(TestStepStarted testStepStarted) {
            beforeStep(testStepStarted);
        }
    };
    private EventHandler<TestStepFinished> stepFinishedEventHandler = new EventHandler<TestStepFinished>() {
        @Override
        public void receive(TestStepFinished testStepFinished) {
            afterStep(testStepFinished);
        }
    };
    private EventHandler<TestCaseFinished> caseFinishedEventHandler = new EventHandler<TestCaseFinished>() {
        @Override
        public void receive(TestCaseFinished testCaseFinished) {
            afterCase(testCaseFinished);
        }
    };
    private EventHandler<TestRunFinished> runFinishedEventHandler = new EventHandler<TestRunFinished>() {
        @Override
        public void receive(TestRunFinished testRunFinished) {
            afterRun(testRunFinished);
        }
    };
    private EventHandler<WriteEvent> writeEventHandler = new EventHandler<WriteEvent>() {
        @Override
        public void receive(WriteEvent writeEvent) {
            write(writeEvent);
        }
    };
    private EventHandler<EmbedEvent> embedEventEventHandler = new EventHandler<EmbedEvent>() {
        @Override
        public void receive(EmbedEvent embedEvent) {
            embed(embedEvent);
        }
    };
    
    protected GherkinService gherkinService;
    
    protected ReportService reportService;
    
    protected GherkinScenarioRepository scenarioRepository;
    
    protected GherkinStepRepository stepRepository;
    
    protected GherkinEmbeddingRepository embeddingRepository;
    
    private GherkinScenario currentScenario;
    
    private GherkinStep currentStep;

        
    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseStarted.class, this.caseStartedHandler);
        publisher.registerHandlerFor(TestStepStarted.class, this.stepStartedEventHandler);
        publisher.registerHandlerFor(TestStepFinished.class, this.stepFinishedEventHandler);
        publisher.registerHandlerFor(TestCaseFinished.class, this.caseFinishedEventHandler);
        publisher.registerHandlerFor(TestRunFinished.class, this.runFinishedEventHandler);
        publisher.registerHandlerFor(WriteEvent.class, this.writeEventHandler);
        publisher.registerHandlerFor(EmbedEvent.class, this.embedEventEventHandler);

    }

    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected void beforeCase(TestCaseStarted testCaseStarted){
    
        if(gherkinService == null){
            gherkinService = BeanUtils.autowire(GherkinService.class);
            reportService = BeanUtils.autowire(ReportService.class);
            scenarioRepository = BeanUtils.autowire(GherkinScenarioRepository.class);
            stepRepository = BeanUtils.autowire(GherkinStepRepository.class);
            embeddingRepository = BeanUtils.autowire(GherkinEmbeddingRepository.class);
        }
        
        Gson gson = new Gson();
        
        GherkinScenario scenario = scenarioRepository.findByName(testCaseStarted.testCase.getName());
        scenario.setDateStart(System.currentTimeMillis());
        scenarioRepository.save(scenario);
    
        for(TestStep testStep : testCaseStarted.testCase.getTestSteps()){
            
            GherkinStep step = stepRepository.findByScenarioNLine(scenario, testStep.getStepLine());
            step.setPattern(testStep.getPattern());
            step.setStepLocation(testStep.getStepLocation());
            step.setCodeLocation(testStep.getCodeLocation());
    
            // Args of Step
            List<String> args = new ArrayList<>();
            for(Argument argument : testStep.getDefinitionArgument()){
                args.add(argument.getVal());
            }
            step.setArgs(gson.toJson(args));
    
            // Data of Step
            List<List<String>> dataTable = new ArrayList<>();
            for(gherkin.pickles.Argument argument : testStep.getStepArgument()){
        
                if(argument instanceof PickleString) {
                    PickleString pickleString = (PickleString)argument;
                    dataTable.add(Arrays.asList(pickleString.getContent()));
                } else if(argument instanceof PickleTable) {
                    PickleTable pickleTable = ((PickleTable)argument);
                    for(PickleRow row : pickleTable.getRows()){
    
                        List<String> resultRow = new ArrayList<>();
                        for(PickleCell cell : row.getCells()){
                            resultRow.add(cell.getValue());
                        }
                        dataTable.add(resultRow);
                    }
                }
            }
            step.setDataTable(gson.toJson(dataTable).getBytes());
    
            com.gt.projects.bdd.base.entity.wrapper.Glue glue = gherkinService.findGlueByName(step.getName());
            if(glue != null){
                step.setType(glue.getAnnotationType().getSimpleName());
            }
            
            stepRepository.saveAndFlush(step);
        }
        
//        reportService.startVideoRecording(scenario.getName());
        
        currentScenario = scenario;
    }
    
    protected void beforeStep(TestStepStarted testStepStarted){
        currentStep = stepRepository.findByScenarioNLine(currentScenario, testStepStarted.testStep.getStepLine());
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected void afterStep(TestStepFinished testStepFinished){
        Result result = testStepFinished.result;
        if(currentStep.getDuration() != null && currentStep.getDuration() > 0)
        {

        }
        else {
            currentStep.setDuration(result.getDuration());
        }
        currentStep.setStatus(result.getStatus().firstLetterCapitalizedName());
        
        String errMsg = result.getErrorMessage();
        if(StringUtils.isNotBlank(errMsg)){
            currentStep.setErrorMessage(errMsg.length() > 200 ? errMsg.substring(0, 200) : errMsg);
        }


        stepRepository.saveAndFlush(currentStep);
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected void afterCase(TestCaseFinished testCaseFinished){
        Result result = testCaseFinished.result;
        currentScenario.setResult(result.getStatus().firstLetterCapitalizedName());
        if(currentScenario.getDuration() == null || currentScenario.getDuration() <= 0)
        {
            currentScenario.setDuration(result.getDuration());
        }
    
        if(!result.getStatus().equals(Result.Type.PASSED))
        {
            DeviceService deviceService = BeanUtils.autowire(DeviceService.class);
            String errMsg = result.getErrorMessage();
            errMsg = errMsg +"\n"+deviceService.getPageSource();
            if(StringUtils.isNotBlank(errMsg)){
                currentScenario.setErrorMessage(errMsg);
            }
        }
        scenarioRepository.saveAndFlush(currentScenario);
    
        
//        try {
//            File videoFile = reportService.stopVideoRecording(currentScenario.getName());
//            reportService.embed(videoFile.getCanonicalPath().getBytes(), "video/mp4");
//        } catch(IOException ex){
//            ex.printStackTrace();
//        }
    }
    
    protected void afterRun(TestRunFinished testRunFinished){
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected void write(WriteEvent writeEvent){
        currentStep.setOutput((StringUtils.isBlank(currentStep.getOutput()) ? "" : currentStep.getOutput()) + writeEvent.text);
        stepRepository.saveAndFlush(currentStep);
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected void embed(EmbedEvent embedEvent){
        GherkinEmbedding embedding = GherkinEmbedding.newInstance(embedEvent.mimeType, embedEvent.data);
        embedding.setGherkinStep(currentStep);
        embeddingRepository.saveAndFlush(embedding);
    }
    
}
