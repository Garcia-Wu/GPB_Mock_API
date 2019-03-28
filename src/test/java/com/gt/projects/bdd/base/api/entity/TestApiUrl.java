package com.gt.projects.bdd.base.api.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by giotto.chow on 2/12/2018.
 */
@Data
public class TestApiUrl {
    
    private String raw;
    private String protocol;
    private List<String> path = new ArrayList<>();
    private List<String> host = new ArrayList<>();
    private List<TestApiParam> query = new ArrayList<>();
    private List<TestApiParam> variable = new ArrayList<>();//TODO
    
}
