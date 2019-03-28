package com.gt.projects.bdd.base.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by giotto.chow on 2/12/2018.
 */
@Data
@Entity
@ToString(exclude = {"gherkinScenario", "embeddings"})
@EqualsAndHashCode(exclude = {"gherkinScenario", "embeddings"})
public class GherkinStep implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private Integer id;
    
    private Integer line;
    private Integer sortOrder;

    @Column(length = 4000)
    private String name;

    @Column(length = 500)
    private String type;

    @Column(length = 2000)
    private String pattern;

    @Column(length = 2000)
    private String stepLocation;

    @Column(length = 2000)
    private String codeLocation;

    @Column(length = 4000)
    private String args;
    
    private Long dateStart;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
    @JoinColumn(name = "scenario_id")
    private GherkinScenario gherkinScenario;
    
    @Lob
    private byte[] dataTable;
    
    private Long duration;
    private String status;
    private String errorMessage;
    
    private String output;
            
    public static GherkinStep newInstance(Integer line,
            Integer sortOrder,
            String name){
        GherkinStep result = new GherkinStep();
        result.setLine(line);
        result.setSortOrder(sortOrder);
        result.setName(name);
        return result;
    }
}

