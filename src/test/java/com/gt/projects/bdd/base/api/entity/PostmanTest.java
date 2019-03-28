package com.gt.projects.bdd.base.api.entity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.gt.projects.bdd.base.entity.GherkinStep;
import lombok.Data;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.persistence.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by giotto.chow on 2/12/2018.
 */
@Data
public class PostmanTest {
    
    @Data
    public static class TestDescription {
        
        private String content;
        
        private String type;
    }
    
    
    private TestDescription description;
    
    
    @Data
    public static class TestInfo {
        
        private String id;
        
        private String name;
        
        private String schema;
    }
    
    private List<TestApi> item = new ArrayList<>();
//    private List<TestApiCollection> item = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
//        System.out.println(Arrays.asList("1","2"));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String content = new String(Files.readAllBytes(Paths.get("C:\\Users\\giotto.chow\\Documents\\TahoeAutomationTesting\\src\\test\\resources\\CMB.postman_collection.json")));
        PostmanTest test = objectMapper.readValue(content, new TypeReference<PostmanTest>() {});
        System.out.println(Arrays.asList("1","2"));
    }
    
//    public void generateReport(File targetFile, List<PostmanTest> testResult) {
//
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Workbook workbook = null;
//        try {
//            BufferedInputStream buffIn = new BufferedInputStream(new FileInputStream("src/test/resources/apiReportTemplate.xlsx"));
//            workbook = new HSSFWorkbook(buffIn);
//        } catch (IOException | OfficeXmlFileException ex) {
//            try {
//                BufferedInputStream buffIn = new BufferedInputStream(new FileInputStream("src/test/resources/apiReportTemplate.xlsx"));
//                workbook = new XSSFWorkbook(buffIn);
//            } catch (IOException ex2) {
//                ex2.printStackTrace();
//            }
//        }
//
//        int apiCount = 1;
//        Map<String, List<String>> apiDetail = new HashMap<>();
//
//        for(PostmanTest item : testResult){
//            for(TestApiCollection collection : item.getItem()){
//                String collectionName = collection.getName();
//
//                for(TestApi api : collection.getItem()){
//                    String apiName = api.getName();
//
//                    String fullPath = "";
//                    for(String path : api.getRequest().getUrl().getPath()){
//                        fullPath += "/" + path;
//                    }
//
//                    String key = collectionName + apiName;
//                    if(!apiDetail.containsKey(key)){
//                        apiDetail.put(key, Arrays.asList(collectionName, "" + apiCount++, apiName, fullPath));
//                    }
//                }
//            }
//        }
//
//        Row row;
//        Cell cell;
//        int rowCount = 1;
//        int columnCount = 0;
//
//        Sheet apiSummary = workbook.getSheetAt(0);
//        rowCount = 1;
//        columnCount = 0;
////        for (Map.Entry<String, List<Integer>> item : apiDetail.entrySet()) {
////            row = epicSummary.createRow(rowCount++);
////            cell = row.createCell(columnCount++);
////            cell.setCellValue(item.getKey());
////            List<Integer> stat = item.getValue();
////            cell = row.createCell(columnCount++);
////            cell.setCellValue(stat.get(0));
////            cell = row.createCell(columnCount++);
////            cell.setCellValue(stat.get(1));
////            cell = row.createCell(columnCount++);
////            cell.setCellValue(stat.get(2));
////            columnCount = 0;
////        }
////        Sheet sprintSummary = workbook.getSheetAt(1);
////        rowCount = 1;
////        columnCount = 0;
////        for (Map.Entry<String, List<Integer>> item : sprintMap.entrySet()) {
////            row = sprintSummary.createRow(rowCount++);
////            cell = row.createCell(columnCount++);
////            cell.setCellValue(item.getKey());
////            List<Integer> stat = item.getValue();
////            cell = row.createCell(columnCount++);
////            cell.setCellValue(stat.get(0));
////            cell = row.createCell(columnCount++);
////            cell.setCellValue(stat.get(1));
////            cell = row.createCell(columnCount++);
////            cell.setCellValue(stat.get(2));
////            columnCount = 0;
////        }
////        try {
////            targetFile.deleteOnExit();
////            targetFile.createNewFile();
////            workbook.write(new FileOutputStream(targetFile));
////        } catch (IOException ex) {
////            ex.printStackTrace();
////        }
//    }
}
