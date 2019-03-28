package com.gt.projects.bdd.base.repository;

import com.gt.projects.bdd.base.entity.GherkinEmbedding;
import com.gt.projects.bdd.base.entity.GherkinScenario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by giotto.chow on 3/7/2018.
 */

public interface GherkinScenarioRepository extends JpaRepository<GherkinScenario, Long>{
    
    @Query("SELECT t FROM GherkinScenario t WHERE t.id in (SELECT max(d.id) FROM GherkinScenario d WHERE d.name = :name group by d.name)")
    public GherkinScenario findByName(@Param("name") String name);
    
    @Query("SELECT t FROM GherkinScenario t WHERE t.id in (SELECT max(d.id) FROM GherkinScenario d group by d.name) order by t.id")
    public List<GherkinScenario> findAllLatest();
}
