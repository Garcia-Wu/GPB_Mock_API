package com.gt.projects.bdd.base.repository;

import com.gt.projects.bdd.base.entity.GherkinEmbedding;
import com.gt.projects.bdd.base.entity.GherkinScenario;
import com.gt.projects.bdd.base.entity.GherkinStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by giotto.chow on 3/7/2018.
 */

public interface GherkinStepRepository extends JpaRepository<GherkinStep, Long>{
    
    @Query("SELECT t FROM GherkinStep t WHERE t.gherkinScenario = :scenario and t.line = :line and rowNum = 1 order by t.id desc")
    public GherkinStep findByScenarioNLine(@Param("scenario") GherkinScenario scenario, @Param("line") Integer line);
    
    @Query("SELECT t FROM GherkinStep t WHERE t.gherkinScenario = :scenario and t.type Is Not Null order by t.id")
    public List<GherkinStep> findAllByScenario(@Param("scenario") GherkinScenario scenario);
}
