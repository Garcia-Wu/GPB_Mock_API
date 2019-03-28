package com.gt.projects.bdd.base.entity;

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
public class GherkinDevice implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private Integer id;

    @Column(length = 2000)
    private String platform;

    @Column(length = 2000)
    private String platformVersion;

    @Column(length = 2000)
    private String deviceName;

    @Column(length = 4000)
    private String appBuild;
    
}

