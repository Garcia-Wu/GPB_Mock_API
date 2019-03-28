package com.gt.projects.bdd.hsbc_gbm.util;

import com.gt.projects.bdd.base.entity.GherkinScenario;

import java.util.HashMap;
import java.util.Map;

public class SkipScenarioFactory {
    private static Map<String,GherkinScenario> map = new HashMap<>();

    public static void put(String name,GherkinScenario gherkinScenario)
    {
        map.put(name,gherkinScenario);
    }

    public static GherkinScenario get(String name)
    {
        return map.get(name);
    }
}
