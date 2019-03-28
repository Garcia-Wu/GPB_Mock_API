package com.gt.projects.bdd.base.entity.wrapper;

import gherkin.pickles.PickleStep;

/**
 * Created by giotto.chow on 1/31/2018.
 */
public class TestStepWrapper {
    
    private PickleStep pickleStep;
    
    private TestStepWrapper(PickleStep pickleStep){
        this.pickleStep = pickleStep;
    }
    
    public String getText(){ return pickleStep.getText(); }
    
    public Integer getLine(){ return pickleStep.getLocations().get(0).getLine(); }
    
    public Integer getColumn(){ return pickleStep.getLocations().get(0).getColumn(); }
    
    @Override
    public boolean equals(Object item){
        if(item != null && item instanceof PickleStep){
            return this.pickleStep.getText().equals(((PickleStep) item).getText());
        }
        return false;
    }
    
    public static TestStepWrapper newInstance(PickleStep pickleStep){
        return new TestStepWrapper(pickleStep);
    }
}
