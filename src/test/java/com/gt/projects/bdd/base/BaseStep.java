package com.gt.projects.bdd.base;

import com.gt.projects.bdd.base.config.AppConfig;
import com.gt.projects.bdd.base.config.DriverConfig;
import org.apache.log4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;

@ContextHierarchy(@ContextConfiguration(classes = AppConfig.class))
public abstract class BaseStep {
    
    protected Logger logger = Logger.getLogger(this.getClass());
    
}
