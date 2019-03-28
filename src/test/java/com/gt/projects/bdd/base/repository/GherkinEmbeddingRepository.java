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

public interface GherkinEmbeddingRepository extends JpaRepository<GherkinEmbedding, Long>{
    
    @Query("SELECT t FROM GherkinEmbedding t WHERE t.gherkinStep = :step order by t.id")
    public List<GherkinEmbedding> findByStep(@Param("step") GherkinStep step);
    
}
