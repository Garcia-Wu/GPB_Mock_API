package com.gt.projects.bdd;

import com.gt.projects.bdd.base.AbstractCucumberRunner;
import com.gt.projects.bdd.base.BaseStep;
import com.gt.projects.bdd.base.config.DriverConfig;
import com.gt.projects.bdd.base.entity.GherkinScenario;
import com.gt.projects.bdd.base.enums.Platform;
import com.gt.projects.bdd.base.interceptor.ReportEventListener;
import com.gt.projects.bdd.base.repository.GherkinScenarioRepository;
import com.gt.projects.bdd.base.service.ReportService;
import com.gt.projects.bdd.base.utils.CmdUtils;
import cucumber.api.CucumberOptions;
import cucumber.api.formatter.Formatter;
import lombok.Data;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import org.apache.commons.exec.ExecuteWatchdog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Test
@EnableAutoConfiguration
@ComponentScan(value = "com.gt.projects.**", excludeFilters = { @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BaseStep.class}),
                                                                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {DriverConfig.class})})
public class GenerateReportRunner extends AbstractTestNGSpringContextTests {
    
    @Autowired
    private GherkinScenarioRepository gherkinScenarioRepository;
    
    @Autowired
    private ReportService reportService;
    
    @Test
    @Transactional
    public void generateReport(){
        List<GherkinScenario> gherkinScenarioList = gherkinScenarioRepository.findAllLatest();
        reportService.generateHtmlReportJson("target/cucumber_.json", gherkinScenarioList);
    
    
    
        File reportOutputDirectory = new File("target");  //report file name
        List<String> jsonFiles = Arrays.asList("target/cucumber_.json");
        
    
        String jenkinsBasePath = "";
        String buildNumber = "1";
        String projectName = "GPB Mobile";
        boolean runWithJenkins = false;
        boolean parallelTesting = false;
    
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        // optional configuration
        configuration.setParallelTesting(parallelTesting);
        configuration.setRunWithJenkins(runWithJenkins);
        configuration.setBuildNumber(buildNumber);
        // addidtional metadata presented on main page
        //        configuration.addClassifications("Platform", "iOS");
        //        configuration.addClassifications("OS Version", "iOS 10.2");
        //        configuration.addClassifications("Branch", "Sprint 14");
        //        configuration.addClassifications("App Version", "api_hsbc-fx_20170908_1600_71a1feb.app");
    
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();
    }
    
}
