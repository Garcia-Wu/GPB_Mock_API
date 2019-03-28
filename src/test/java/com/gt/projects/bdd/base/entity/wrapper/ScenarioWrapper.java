package com.gt.projects.bdd.base.entity.wrapper;

import com.gt.projects.bdd.base.utils.GherkinUtils;
import cucumber.api.TestCase;
import cucumber.api.testng.PickleEventWrapper;
import gherkin.events.PickleEvent;
import gherkin.pickles.PickleStep;
import gherkin.pickles.PickleTag;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by giotto.chow on 1/31/2018.
 */
public class ScenarioWrapper {
    
    private PickleEvent pickleEvent;
    
    private ScenarioWrapper(PickleEvent pickleEvent){
        this.pickleEvent = pickleEvent;
    }
    
    public String getUri(){ return pickleEvent.uri; }
    
    public String getName(){
        return pickleEvent.pickle == null ? "" : pickleEvent.pickle.getName();
    }
    
    public String getLanguage(){
        return pickleEvent.pickle == null ? "" : pickleEvent.pickle.getLanguage();
    }
    
    public List<String> getTags(){
        if(pickleEvent.pickle != null){
            return GherkinUtils.getTagList(pickleEvent.pickle.getTags());
        } else {
            return Arrays.asList();
        }
    }
    
    public Integer getLine(){
        return pickleEvent.pickle == null ? -1 : pickleEvent.pickle.getLocations().get(0).getLine();
    }
    
    public Integer getColumn(){
        return pickleEvent.pickle == null ? -1 : pickleEvent.pickle.getLocations().get(0).getColumn();
    }
    
    public List<TestStepWrapper> getSteps(){
        List<TestStepWrapper> resultList = new ArrayList<TestStepWrapper>();
    
        if(pickleEvent.pickle != null){
            for(PickleStep step : pickleEvent.pickle.getSteps()){
                resultList.add(TestStepWrapper.newInstance(step));
            }
        }
    
        return resultList;
    }
    
    public static ScenarioWrapper newInstance(PickleEventWrapper pickleEventWrapper){
        return newInstance(pickleEventWrapper.getPickleEvent());
    }
    
    public static ScenarioWrapper newInstance(PickleEvent pickleEvent){
        return new ScenarioWrapper(pickleEvent);
    }
    
    public static ScenarioWrapper newInstance(TestCase testCase) {
        try {
            return newInstance((PickleEvent)FieldUtils.readField(testCase, "pickleEvent", true));
        } catch (ReflectiveOperationException|ClassCastException|NullPointerException ex) {
            return null;
        }
    }
        
}
