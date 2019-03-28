package com.gt.projects.bdd.base.api.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by giotto.chow on 2/12/2018.
 */
@Data
public class TestEvent {
    
    private String listen;
    private TestScript script;
    
    @Data
    public static class TestScript{
        private String id;
        private String type;
        private List<String> exec = new ArrayList<>();
    }
}
