package com.gt.projects.bdd.base.service.impl;

import com.google.gson.Gson;
import com.gt.projects.bdd.RunnerClass;
import com.gt.projects.bdd.base.AbstractCucumberRunner;
import com.gt.projects.bdd.base.annotation.Action;
import com.gt.projects.bdd.base.entity.GherkinDevice;
import com.gt.projects.bdd.base.entity.GherkinEmbedding;
import com.gt.projects.bdd.base.entity.GherkinScenario;
import com.gt.projects.bdd.base.entity.GherkinStep;
import com.gt.projects.bdd.base.entity.wrapper.Glue;
import com.gt.projects.bdd.base.repository.GherkinDeviceRepository;
import com.gt.projects.bdd.base.repository.GherkinEmbeddingRepository;
import com.gt.projects.bdd.base.repository.GherkinScenarioRepository;
import com.gt.projects.bdd.base.repository.GherkinStepRepository;
import com.gt.projects.bdd.base.service.GherkinService;
import com.gt.projects.bdd.base.utils.GherkinUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.testng.PickleEventWrapper;
import gherkin.pickles.Pickle;
import gherkin.pickles.PickleStep;
import lombok.Getter;
import org.apache.log4j.Logger;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by giotto.chow on 1/23/2018.
 */
@Service
@Scope("thread")
public class GherkinServiceImpl implements GherkinService, InitializingBean{
    
    protected Logger logger = Logger.getLogger(this.getClass());
            
    @Getter
    private List<Glue> glueList;
    
    @Autowired
    private GherkinDeviceRepository gherkinDeviceRepository;
    
    @Autowired
    protected GherkinScenarioRepository gherkinScenarioRepository;
    
    @Autowired
    protected GherkinStepRepository gherkinStepRepository;
    
    @Autowired
    protected GherkinEmbeddingRepository gherkinEmbeddingRepository;
    
    private void registerGlue(){
        glueList = new ArrayList<Glue>();

        List<Method> methodList = new ArrayList<>();
        Reflections reflections = new Reflections("^com.gt", new MethodAnnotationsScanner());
        methodList.addAll(reflections.getMethodsAnnotatedWith(Given.class));
        methodList.addAll(reflections.getMethodsAnnotatedWith(When.class));
        methodList.addAll(reflections.getMethodsAnnotatedWith(Then.class));
        methodList.addAll(reflections.getMethodsAnnotatedWith(And.class));
        methodList.addAll(reflections.getMethodsAnnotatedWith(Action.class));

        for(Method method : methodList){
            if(method.isAnnotationPresent(Given.class)){
                Given annotation = method.getAnnotation(Given.class);
                glueList.add(Glue.newInstance(annotation.value(), Given.class, annotation, method));
            } else if(method.isAnnotationPresent(When.class)){
                When annotation = method.getAnnotation(When.class);
                glueList.add(Glue.newInstance(annotation.value(), When.class, annotation, method));
            } else if(method.isAnnotationPresent(Then.class)){
                Then annotation = method.getAnnotation(Then.class);
                glueList.add(Glue.newInstance(annotation.value(), Then.class, annotation, method));
            } else if(method.isAnnotationPresent(And.class)){
                And annotation = method.getAnnotation(And.class);
                glueList.add(Glue.newInstance(annotation.value(), And.class, annotation, method));
            } else if(method.isAnnotationPresent(Action.class)){
                Action annotation = method.getAnnotation(Action.class);
                glueList.add(Glue.newInstance(annotation.value(), Action.class, annotation, method));
            }
        }
    }
    
    @Override
    //@Transactional
    public void afterPropertiesSet() throws Exception {
    
        registerGlue();
        
        Gson gson = new Gson();

        AbstractCucumberRunner runnerClass = RunnerClass.getCurrentRunner();
        GherkinDevice device = new GherkinDevice();
        device.setPlatform(runnerClass.getPlatform());
        device.setPlatformVersion(runnerClass.getPlatformVersion());
        device.setAppBuild(runnerClass.getAppPath());
        device.setDeviceName(runnerClass.getDeviceName());
        gherkinDeviceRepository.save(device);
        
        List<GherkinScenario> scenarioList = new ArrayList<>();
        List<GherkinStep> stepList = new ArrayList<>();
        
        GherkinScenario scenario = null;
        GherkinStep step = null;
        
        List<PickleEventWrapper> itemList = RunnerClass.getCurrentRunner().getScenarioList();
        if(gherkinScenarioRepository.findAllLatest().size() <= 0)
        {
            for(PickleEventWrapper item : itemList){

                Pickle pickle = item.getPickleEvent().pickle;

                String tagStr = "";
                for(String tag : GherkinUtils.getTagList(pickle.getTags())){
                    tagStr += "," + tag;
                }

                scenario = GherkinScenario.newInstance(item.getPickleEvent().uri,
                        pickle.getLocations().get(0).getLine(),
                        pickle.getName(),
                        pickle.getLanguage(),
                        tagStr.substring(1)
                );
                scenario.setGherkinDevice(device);
                scenarioList.add(scenario);
                // Step
                for(PickleStep itemStep : pickle.getSteps()) {
                    step = GherkinStep.newInstance(
                            itemStep.getLocations().get(0).getLine(),
                            stepList.size(),
                            itemStep.getText()
                    );
                    step.setGherkinScenario(scenario);
                    stepList.add(step);

                    // Update Glue
                    Glue glue = findGlueByName(step.getName());
                    if(glue != null){
                        glue.setPickleStep(itemStep);
                        glue.setLanguage(scenario.getLanguage());
                    }
                }

            }

            gherkinScenarioRepository.saveAll(scenarioList);
            gherkinStepRepository.saveAll(stepList);
        }else {
            for(PickleEventWrapper item : itemList){

                Pickle pickle = item.getPickleEvent().pickle;

                String tagStr = "";
                for(String tag : GherkinUtils.getTagList(pickle.getTags())){
                    tagStr += "," + tag;
                }

                scenario = GherkinScenario.newInstance(item.getPickleEvent().uri,
                        pickle.getLocations().get(0).getLine(),
                        pickle.getName(),
                        pickle.getLanguage(),
                        tagStr.substring(1)
                );
                scenario.setGherkinDevice(device);

                GherkinScenario db_gherkinScenario = gherkinScenarioRepository.findByName(scenario.getName());
                List<GherkinStep> curStepList = new ArrayList<>();
                // Step
                for(PickleStep itemStep : pickle.getSteps()) {
                    step = GherkinStep.newInstance(
                            itemStep.getLocations().get(0).getLine(),
                            curStepList.size(),
                            itemStep.getText()
                    );
                    curStepList.add(step);

                    Glue glue = findGlueByName(step.getName());
                    if(glue != null){
                        glue.setPickleStep(itemStep);
                        glue.setLanguage(scenario.getLanguage());
                    }

                }
                if(db_gherkinScenario != null)
                {
                    boolean isPass = true;
                    List<GherkinStep> db_stepList = gherkinStepRepository.findAllByScenario(db_gherkinScenario);
                    if(db_gherkinScenario.getResult() == null || !db_gherkinScenario.getResult().toLowerCase().equals("passed"))
                    {
                        isPass = false;
                    }
                    if(isPass)
                    {
                        if(db_stepList != null && db_stepList.size() == curStepList.size())
                        {
                            boolean isMatch = true;
                            for(int i = 0; i < db_stepList.size();i++) {
                                GherkinStep dbStep = db_stepList.get(i);
                                GherkinStep thisStep = curStepList.get(i);
                                if (!dbStep.getName().equals(thisStep.getName()) )
//                                        || !dbStep.getLine().equals(thisStep.getLine())) {
                                {
                                    isMatch = false;
                                }
                                dbStep.setLine(thisStep.getLine());
                                gherkinStepRepository.save(dbStep);
                            }

                            if(isMatch)
                            {
                                // skip
                            }
                            else {
                                System.out.println("Rerun due to not match " + scenario.getName() + ":" + scenario.getLine());
                                //log.info("Rerun due to not match " + thisScenario.getName() + ":" + thisScenario.getLine());
                                db_gherkinScenario.setResult("");
                                db_gherkinScenario.setDateStart(System.currentTimeMillis());
                                db_gherkinScenario.setDuration(null);
                                gherkinScenarioRepository.save(db_gherkinScenario);

                                for(GherkinStep step1 : curStepList){
                                    step1.setGherkinScenario(db_gherkinScenario);
                                }
                                gherkinStepRepository.saveAll(curStepList);

                                // Unlink old steps
                                for (GherkinStep dbStep : db_stepList) {
                                    dbStep.setGherkinScenario(null);
//                                            dbStep.setStatus("");
//                                            dbStep.setDuration(null);
//                                            dbStep.setOutput("");
//                                            dbStep.setErrorMessage("");
                                }
                                gherkinStepRepository.saveAll(db_stepList);
                            }

                        }
                        else {
                            System.out.println("Rerun due to not match " + scenario.getName() + ":" + scenario.getLine());
                            //log.info("Rerun due to not match " + thisScenario.getName() + ":" + thisScenario.getLine());
                            db_gherkinScenario.setResult("");
                            db_gherkinScenario.setDateStart(System.currentTimeMillis());
                            db_gherkinScenario.setDuration(null);
                            gherkinScenarioRepository.save(db_gherkinScenario);

                            for(GherkinStep step1 : curStepList){
                                step1.setGherkinScenario(db_gherkinScenario);
                            }
                            gherkinStepRepository.saveAll(curStepList);

                            // Unlink old steps
                            for (GherkinStep dbStep : db_stepList) {
                                dbStep.setGherkinScenario(null);
//                                            dbStep.setStatus("");
//                                            dbStep.setDuration(null);
//                                            dbStep.setOutput("");
//                                            dbStep.setErrorMessage("");
                            }
                            gherkinStepRepository.saveAll(db_stepList);
                        }
                    }
                    else {
                        db_gherkinScenario.setResult("");
                        db_gherkinScenario.setDateStart(System.currentTimeMillis());
                        db_gherkinScenario.setDuration(null);
                        gherkinScenarioRepository.save(db_gherkinScenario);

                        for (GherkinStep dbStep : db_stepList) {
                            dbStep.setStatus("");
                            dbStep.setDuration(null);
                            dbStep.setOutput("");
                            dbStep.setErrorMessage("");

                            List<GherkinEmbedding> gherkinEmbeddingList = gherkinEmbeddingRepository.findByStep(dbStep);
                            gherkinEmbeddingRepository.deleteAll(gherkinEmbeddingList);
                        }
                        for(GherkinStep step1 : curStepList){
                            step1.setGherkinScenario(db_gherkinScenario);
                        }
                        gherkinStepRepository.saveAll(curStepList);
                    }
                }
                else
                {
                    for(GherkinStep step1 : curStepList){
                        step1.setGherkinScenario(scenario);
                    }
                    gherkinScenarioRepository.save(scenario);
                    gherkinStepRepository.saveAll(curStepList);
                }
            }
        }
    }
    
    public Glue findGlueByName(String name){
        for(Glue glue : glueList) {
            if(name.matches(glue.getRegex())){
                return glue;
            }
        }

        return null;
    }
    
    @Transactional
    public Boolean checkIfScenarioHasSameState(GherkinScenario from, GherkinScenario to) {
        
        List<Glue> fromList = new ArrayList<>();
        List<Glue> toList = new ArrayList<>();
    
        List<GherkinStep> fromStepList = gherkinStepRepository.findAllByScenario(from);
        for (GherkinStep testStep : fromStepList) {
            Glue glue = findGlueByName(testStep.getName());
            if(glue != null){
                Object anno = glue.getAnnotation();
                if (anno instanceof Given || anno instanceof And) {
                    fromList.add(glue);
                } else {
                    break;
                }
            }
        }
    
        List<GherkinStep> toStepList = gherkinStepRepository.findAllByScenario(to);
        for (GherkinStep testStep : toStepList) {
            Glue glue = findGlueByName(testStep.getName());
            if(glue != null){
                Object anno = glue.getAnnotation();
                if (anno instanceof Given || anno instanceof And) {
                    toList.add(glue);
                } else {
                    break;
                }
            }
        }
        
        return !fromList.isEmpty() && fromList.equals(toList);
    }

    
}

