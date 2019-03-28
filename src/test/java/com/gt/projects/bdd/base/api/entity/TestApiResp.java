package com.gt.projects.bdd.base.api.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by giotto.chow on 2/12/2018.
 */
@Data
public class TestApiResp {
    
    private String id;
    private String name;
    private String status;
    private Integer code;
    
    private List<TestEvent> event = new ArrayList<>();
    
    private String body;
    
}
