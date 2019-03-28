package com.gt.projects.bdd.base.api.entity;

import com.gt.projects.bdd.base.entity.GherkinStep;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by giotto.chow on 2/12/2018.
 */
@Data
public class TestApi {
    
    private String id;
    private String name;
    private List<TestEvent> event = new ArrayList<>();
    
    private TestApiReq request;
    private List<TestApiResp> response = new ArrayList<>();
    
}
