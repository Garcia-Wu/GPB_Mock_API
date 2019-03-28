package com.gt.projects.bdd.base.api.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by giotto.chow on 2/12/2018.
 */
@Data
public class TestApiCollection {
    
    private String id;
    private String name;
    
    private List<TestEvent> event = new ArrayList<>();
    private List<TestApi> item = new ArrayList<>();
}
