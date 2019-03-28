package com.gt.projects.bdd.base.interceptor;

import com.gt.projects.bdd.base.annotation.Const;
import com.gt.projects.bdd.base.annotation.DependsOn;
import com.gt.projects.bdd.base.entity.GherkinScenario;
import com.gt.projects.bdd.base.entity.wrapper.Glue;
import com.gt.projects.bdd.base.entity.wrapper.ScenarioWrapper;
import com.gt.projects.bdd.base.repository.GherkinScenarioRepository;
import com.gt.projects.bdd.base.service.CucumberService;
import com.gt.projects.bdd.base.service.DeviceService;
import com.gt.projects.bdd.base.service.GherkinService;
import com.gt.projects.bdd.base.utils.BeanUtils;
import com.gt.projects.bdd.hsbc_gbm.util.SkipScenarioFactory;
import cucumber.api.Result;
import cucumber.api.event.EventHandler;
import cucumber.api.event.EventPublisher;
import cucumber.api.event.TestCaseFinished;
import cucumber.api.event.TestCaseStarted;
import cucumber.api.formatter.Formatter;
import lombok.Getter;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by giotto.chow on 2/1/2018.
 */
/* This is not a Spring-managed bean */
public class ScenarioInterceptor implements Formatter{
    
    protected Logger logger = Logger.getLogger(this.getClass());
    
    private EventHandler<TestCaseStarted> caseStartedHandler = new EventHandler<TestCaseStarted>() {
        @Override
        public void receive(TestCaseStarted testCaseStarted) {
            beforeCase(testCaseStarted);
        }
    };
    private EventHandler<TestCaseFinished> caseFinishedEventHandler = new EventHandler<TestCaseFinished>() {
        @Override
        public void receive(TestCaseFinished testCaseFinished) {
            afterCase(testCaseFinished);
        }
    };
    
    private GherkinScenarioRepository gherkinScenarioRepository;
    
    private GherkinService gherkinService;
    
    private CucumberService cucumberService;
    
    private DeviceService deviceService;
    
    private GherkinStepInterceptor gherkinStepInterceptor;
    
    private GherkinScenario lastScenario;
    
    private GherkinScenario thisScenario;
    
    private Result.Type lastScenarioResult;
    
    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseStarted.class, this.caseStartedHandler);
        publisher.registerHandlerFor(TestCaseFinished.class, this.caseFinishedEventHandler);
    }
    
    private void beforeCase(TestCaseStarted testCaseStarted){
        if(gherkinScenarioRepository == null){
            gherkinScenarioRepository = BeanUtils.autowire(GherkinScenarioRepository.class);
            gherkinService = BeanUtils.autowire(GherkinService.class);
            cucumberService = BeanUtils.autowire(CucumberService.class);
            deviceService = BeanUtils.autowire(DeviceService.class);
            gherkinStepInterceptor = BeanUtils.autowire(GherkinStepInterceptor.class);
        }
        // TODO: Has ran before
        GherkinScenario currentScenario1 = gherkinScenarioRepository.findByName(testCaseStarted.testCase.getName());
        if(currentScenario1.getResult() != null && currentScenario1.getResult().toLowerCase().equals("passed")){
            gherkinStepInterceptor.setIsSkipped(true, true, true);
            SkipScenarioFactory.put(currentScenario1.getName(),currentScenario1);
            return;
        }
        if(lastScenario != null){
                
            gherkinStepInterceptor.setIsSkipped(false, false, false);
            
            // TODO: Has ran before
            GherkinScenario currentScenario = gherkinScenarioRepository.findByName(testCaseStarted.testCase.getName());
            thisScenario = currentScenario;
            
    //        gherkinStepInterceptor.setIsSkipped(true, true, true);
    
            // Const
            if(Result.Type.PASSED.equals(lastScenarioResult)){
    
                List<String> tagList = StringUtils.isBlank(lastScenario.getTags()) ? Arrays.asList() : Arrays.asList(lastScenario.getTags().split(","));
                Const aConst = Const.getInstance(tagList);
                if(aConst != null){
    
                    if(gherkinService.checkIfScenarioHasSameState(lastScenario, thisScenario)){
    
                        logger.info("Skipped Given Section");
                        gherkinStepInterceptor.setIsSkipped(true, false, false);
    
                        if(StringUtils.isNotBlank(aConst.getAction())){
                            try{
                                Glue glue = gherkinService.findGlueByName(aConst.getAction());
                                cucumberService.runGlue(glue);
                            } catch (Throwable throwable){
                                deviceService.resetApp();
                                gherkinStepInterceptor.setIsSkipped(false, false, false);
                            }
                        }
    
                        return;
                    }
                }
            }
    
            // DependsOn
            List<String> tagList = StringUtils.isBlank(thisScenario.getTags()) ? Arrays.asList() : Arrays.asList(thisScenario.getTags().split(","));
            DependsOn dependsOn = DependsOn.getInstance(tagList);
            List<String> loopDetectList = new ArrayList<>();
            List<GherkinScenario> dependencyList = new ArrayList<>();
//            String LastscenarioName = dependsOn.getValue().replaceAll("_", " ");
//            GherkinScenario LastdependsScenario = gherkinScenarioRepository.findByName(LastscenarioName);
            String LastscenarioName = "";
            GherkinScenario LastdependsScenario = null;
            if(dependsOn != null){
                LastscenarioName = dependsOn.getValue().replaceAll("_", " ");
                LastdependsScenario = gherkinScenarioRepository.findByName(LastscenarioName);
            }
            while(dependsOn != null && StringUtils.isNotBlank(dependsOn.getValue())) {
    
                // Get Dependency
                String scenarioName = dependsOn.getValue().replaceAll("_", " ");
                GherkinScenario dependsScenario = gherkinScenarioRepository.findByName(scenarioName);
    
                if(loopDetectList.contains(scenarioName)){
                    throw new RuntimeException("Dependency loop detected!");
                } else {
                    loopDetectList.add(scenarioName);
                }
    
    
                logger.debug("Depends on last scenario");
                if(Result.Type.PASSED.equals(lastScenarioResult) && scenarioName.equals(lastScenario.getName()) && LastdependsScenario.getResult().equalsIgnoreCase("passed") && SkipScenarioFactory.get(scenarioName) == null) {
                   try{
                       gherkinStepInterceptor.setIsSkipped(true, false, false);
                       for(GherkinScenario dependency : dependencyList){
                           cucumberService.runScenario(dependency);
                       }
                       return;
                   }catch (Throwable throwable){
                       deviceService.resetApp();
                       gherkinStepInterceptor.setIsSkipped(false, false, false);
                   }
                }
                else if(Result.Type.PASSED.equals(lastScenarioResult) && scenarioName.equals(lastScenario.getName()) && LastdependsScenario.getResult().equalsIgnoreCase("passed") && SkipScenarioFactory.get(scenarioName) != null) {
                    try{
                        deviceService.resetApp();
                        dependencyList.add(0,dependsScenario);
                        gherkinStepInterceptor.setIsSkipped(false, false, false);
                        for(GherkinScenario dependency : dependencyList){
                            cucumberService.runScenario(dependency);
                        }
                        return;
                    }catch (Throwable throwable){
                        deviceService.resetApp();
                        gherkinStepInterceptor.setIsSkipped(false, false, false);
                    }
                }
                else if(Result.Type.FAILED.equals(lastScenarioResult) && !scenarioName.equals(lastScenario.getName()) && LastdependsScenario.getResult().equalsIgnoreCase("passed")) {
                    try{
                        for(GherkinScenario dependency : dependencyList){
                            cucumberService.runScenario(dependency);
                        }
                        return;
                    }catch (Throwable throwable){
                        deviceService.resetApp();
                        gherkinStepInterceptor.setIsSkipped(false, false, false);
                    }
                }
                else if(Result.Type.PASSED.equals(lastScenarioResult) && !scenarioName.equals(lastScenario.getName()) && LastdependsScenario.getResult().equalsIgnoreCase("passed")) {
                    dependencyList.add(0,dependsScenario);
                    try{
                        gherkinStepInterceptor.setIsSkipped(false, false, false);
                        for(GherkinScenario dependency : dependencyList){
                            cucumberService.runScenario(dependency);
                        }
                        return;
                    }catch (Throwable throwable){
                        deviceService.resetApp();
                        gherkinStepInterceptor.setIsSkipped(false, false, false);
                    }
                }
    
                // Add into current scenario
                logger.info("Add dependency '" + scenarioName + "' to '" + thisScenario.getName() + "'");
                dependencyList.add(0, dependsScenario);
    
//                // Furthermore?
//                List<String> tags =  Arrays.asList(dependsScenario.getTags().split(","));
//                dependsOn = DependsOn.getInstance(tags);
            }
    
            // Otherwise reset app
            if(lastScenario != null) {
                deviceService.resetApp();
            }

            try{
                for(GherkinScenario dependency : dependencyList){
                    cucumberService.runScenario(dependency);
                }
                return;
            }catch (Throwable throwable){
                deviceService.resetApp();
                gherkinStepInterceptor.setIsSkipped(false, false, false);
            }
    
        }
        else {
            gherkinStepInterceptor.setIsSkipped(false, false, false);

            // TODO: Has ran before
            GherkinScenario currentScenario = gherkinScenarioRepository.findByName(testCaseStarted.testCase.getName());
            thisScenario = currentScenario;
            List<String> tagList = StringUtils.isBlank(thisScenario.getTags()) ? Arrays.asList() : Arrays.asList(thisScenario.getTags().split(","));
            DependsOn dependsOn = DependsOn.getInstance(tagList);
            List<String> loopDetectList = new ArrayList<>();
            List<GherkinScenario> dependencyList = new ArrayList<>();
//            String LastscenarioName = dependsOn.getValue().replaceAll("_", " ");
//            GherkinScenario LastdependsScenario = gherkinScenarioRepository.findByName(LastscenarioName);
            String LastscenarioName = "";
            GherkinScenario LastdependsScenario = null;
            if(dependsOn != null){
                LastscenarioName = dependsOn.getValue().replaceAll("_", " ");
                LastdependsScenario = gherkinScenarioRepository.findByName(LastscenarioName);
            }
            while(dependsOn != null && StringUtils.isNotBlank(dependsOn.getValue())) {

                // Get Dependency
                String scenarioName = dependsOn.getValue().replaceAll("_", " ");
                GherkinScenario dependsScenario = gherkinScenarioRepository.findByName(scenarioName);

                // Add into current scenario
                logger.info("Add dependency '" + scenarioName + "' to '" + thisScenario.getName() + "'");
                dependencyList.add(0, dependsScenario);

                try{
                    for(GherkinScenario dependency : dependencyList){
                        cucumberService.runScenario(dependency);
                    }
                    return;
                }catch (Throwable throwable){
                    deviceService.resetApp();
                    gherkinStepInterceptor.setIsSkipped(false, false, false);
                }

            }

        }
    }
    
    private void afterCase(TestCaseFinished testCaseFinished){
        lastScenario = gherkinScenarioRepository.findByName(testCaseFinished.testCase.getName());
        lastScenarioResult = testCaseFinished.result.getStatus();
    }
    
}
