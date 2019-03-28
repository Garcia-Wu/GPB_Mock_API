package com.gt.projects.bdd.base.service.impl;

import com.gt.projects.bdd.RunnerClass;
import com.gt.projects.bdd.base.AbstractCucumberRunner;
import com.gt.projects.bdd.base.annotation.Action;
import com.gt.projects.bdd.base.entity.GherkinScenario;
import com.gt.projects.bdd.base.entity.GherkinStep;
import com.gt.projects.bdd.base.entity.wrapper.Glue;
import com.gt.projects.bdd.base.repository.GherkinStepRepository;
import com.gt.projects.bdd.base.service.CucumberService;
import com.gt.projects.bdd.base.service.GherkinService;
import com.gt.projects.bdd.base.utils.BeanUtils;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.runtime.DefinitionMatch;
import gherkin.pickles.Pickle;
import gherkin.pickles.PickleStep;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by giotto.chow on 1/23/2018.
 */
@Service
@Scope("thread")
public class CucumberServiceImpl implements CucumberService{
    
    protected Logger logger = Logger.getLogger(this.getClass());
    
    @Autowired
    protected GherkinService gherkinService;
    
    @Autowired
    private GherkinStepRepository gherkinStepRepository;
    
    @Transactional
    public Throwable runScenario(GherkinScenario scenario) {
        List<GherkinStep> gherkinStepList = gherkinStepRepository.findAllByScenario(scenario);
        for(GherkinStep step : gherkinStepList){
            Throwable throwable = runStep(step);
            if(throwable != null) return throwable;
        }
        
        return null;
    }
    
    public Throwable runStep(GherkinStep step) {
//        Glue glue = gherkinService.findGlueByName(step.getName());
//        return runGlue(glue);
        PickleStep pickleStep = findPickleStepByNameNLine(step.getName(), step.getLine());
        return runPickleStep(pickleStep);
    }

    private PickleStep findPickleStepByNameNLine(String name, Integer line) {

        // Scenarios
        List<PickleEventWrapper> list = AbstractCucumberRunner.getCurrentRunner().getScenarioList();
        for (PickleEventWrapper scenario : list) {
            if (scenario != null) {

                // Steps
                PickleEventWrapper pickleEventWrapper = scenario;
                Pickle pickle = pickleEventWrapper.getPickleEvent().pickle;
                for (PickleStep pickleStep : pickle.getSteps()) {

                    if (name.equals(pickleStep.getText())       //Name
                            && pickle.getLocations() != null && !pickle.getLocations().isEmpty()){     // Filter Empty Location
//                            && line.equals(pickle.getLocations().get(0).getLine())) {                   // Line
                        return pickleStep;
                    }
                }
            }
        }

        return null;
    }

    private Throwable runPickleStep(PickleStep stepPickle) {
        try{
            cucumber.runtime.Glue runtimeGlue = AbstractCucumberRunner.getCurrentRuntime().getGlue();
            DefinitionMatch definitionMatch = runtimeGlue.stepDefinitionMatch(stepPickle.getText(), stepPickle);
            definitionMatch.runStep("", null);
        }catch (Throwable ex){
            return ex;
        }
        return null;
    }

    public Throwable runGlue(Glue glue){
        
        if(glue.getAnnotation() instanceof Action) {
            try {
                Method method = glue.getMethod();
                Class clazz = method.getDeclaringClass();
                Object instance = BeanUtils.autowire(clazz);
                method.invoke(instance, new Object[]{});
            } catch (ReflectiveOperationException ex) {
                return ex;
            }
        } else {
            PickleStep pickleStep = glue.getPickleStep();
            
            try {
                cucumber.runtime.Glue runtimeGlue = RunnerClass.getCurrentRuntime().getGlue();
                DefinitionMatch definitionMatch = runtimeGlue.stepDefinitionMatch(pickleStep.getText(), pickleStep);
                definitionMatch.runStep(glue.getLanguage(), null);
            } catch(Throwable ex){
                return ex;
            }
        }
        
        return null;
    }
    
}

