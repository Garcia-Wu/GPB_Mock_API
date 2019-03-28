package com.gt.projects.bdd.base.repository;

import com.gt.projects.bdd.base.entity.GherkinDevice;
import com.gt.projects.bdd.base.entity.GherkinScenario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by giotto.chow on 3/7/2018.
 */

public interface GherkinDeviceRepository extends JpaRepository<GherkinDevice, Long>{
    
    @Query("SELECT t FROM GherkinDevice t WHERE t.id in (SELECT max(d.id) FROM GherkinDevice d WHERE d.deviceName = :name group by d.deviceName)")
    public GherkinDevice findByDeviceName(@Param("name") String name);
    
}
