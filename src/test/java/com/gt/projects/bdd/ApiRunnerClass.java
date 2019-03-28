package com.gt.projects.bdd;

import com.gt.projects.bdd.base.AbstractCucumberRunner;
import com.gt.projects.bdd.base.BaseStep;
import com.gt.projects.bdd.base.config.AppConfig;
import com.gt.projects.bdd.base.config.DriverConfig;
import com.gt.projects.bdd.base.enums.Platform;
import com.gt.projects.bdd.base.interceptor.ReportEventListener;
import com.gt.projects.bdd.base.utils.CmdUtils;
import cucumber.api.CucumberOptions;
import cucumber.api.formatter.Formatter;
import lombok.Data;
import org.apache.commons.exec.ExecuteWatchdog;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

@Test
@Data
@EnableAutoConfiguration
@ComponentScan(value = "com.gt.projects.**", excludeFilters = { @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BaseStep.class}),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {DriverConfig.class})})
public class ApiRunnerClass extends AbstractTestNGSpringContextTests {
    
    private String environment;
    
    private String collectionFile;
    
    
    private String reportName;
    
    @Parameters({"environment", "collectionFile"})
    @BeforeTest
    public void setRunner(
            String environment,
            String collectionFile){
    
        setEnvironment(environment);
        setCollectionFile(collectionFile);
        
        Thread currentThread = Thread.currentThread();
        currentThread.setName(currentThread.getName() + "-" + environment + "-" + collectionFile);
    
        // For Reporting
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        reportName = environment + "_" + collectionFile + "_" + sdf.format(new Date());
    }
    
    @Test
    public void runCollection(){
        CmdUtils.runCommand("newman run " + collectionFile + " -e " + environment + " --export-collection " + reportName + ".json");
        
    }
    
    public static void main(String[] args) throws Exception{
        String json = new String(Files.readAllBytes(Paths.get("CMB.postman_collection.json")));
        System.out.println(json);
    }
    
}
