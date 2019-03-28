package com.gt.projects.bdd.base.service;

import com.gt.projects.bdd.base.entity.GherkinScenario;
import com.gt.projects.bdd.base.entity.GherkinStep;
import com.gt.projects.bdd.base.entity.wrapper.Glue;

/**
 * Created by giotto.chow on 1/23/2018.
 */
public interface GherkinService {
    
    Glue findGlueByName(String name);
    
    Boolean checkIfScenarioHasSameState(GherkinScenario from, GherkinScenario to);
    
}
