package com.gt.projects.bdd.base.service;

import com.gt.projects.bdd.base.entity.GherkinScenario;

import java.io.File;
import java.util.List;

/**
 * Created by giotto.chow on 1/23/2018.
 */
public interface ReportService {
    
    void embed(byte[] data, String mimeType);
    
    void saveToJsonFile(String fileName);
    
    void startVideoRecording(String reportName);

    File stopVideoRecording(String reportName);
    
    void generateHtmlReportJson(String targetFile, List<GherkinScenario> scenarioList);
}
