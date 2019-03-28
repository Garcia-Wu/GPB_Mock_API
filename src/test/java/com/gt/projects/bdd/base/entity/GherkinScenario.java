package com.gt.projects.bdd.base.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by giotto.chow on 2/12/2018.
 */
@Data
@Entity
@ToString(exclude = {"steps", "gherkinDevice"})
@EqualsAndHashCode(exclude = {"steps", "gherkinDevice"})
public class GherkinScenario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private Integer id;

    @Column(length = 4000)
    private String uri;
    private Integer line;
    private Long dateStart;

    @Column(length = 4000)
    private String name;
    private String language;

    @Column(length = 4000)
    private String tags;

    @Column(length = 4000)
    private String result;
    
    @Column(length = 100000)
    private String errorMessage;
    private Long duration;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
    @JoinColumn(name = "device_id")
    private GherkinDevice gherkinDevice;
    
    public static GherkinScenario newInstance(String uri, Integer line, String name, String language, String tags){
        GherkinScenario result = new GherkinScenario();
        result.setUri(uri);
        result.setLine(line);
        result.setName(name);
        result.setLanguage(language);
        result.setTags(tags);
        return result;
    }
    
    
    public static void main(String[] args){
        String tmp = "a";
        System.out.println(tmp.split(",").length);
    }
}
