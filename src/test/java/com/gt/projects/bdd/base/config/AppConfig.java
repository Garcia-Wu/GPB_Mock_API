package com.gt.projects.bdd.base.config;

import com.gt.projects.bdd.RunnerClass;
import com.gt.projects.bdd.base.AbstractCucumberRunner;
import com.gt.projects.bdd.base.BaseStep;
import com.gt.projects.bdd.base.utils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Scope;

@Scope("thread")
@Configuration
@EnableAutoConfiguration
@ComponentScan(value = "com.gt.projects.**", excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BaseStep.class})})
public class AppConfig implements InitializingBean{
    
    protected Logger logger = Logger.getLogger(this.getClass());
    
    @Override
    public void afterPropertiesSet() throws Exception {
        AbstractCucumberRunner runner = RunnerClass.getCurrentRunner();
        BeanUtils.autowire(runner.getScenarioInterceptor());
        BeanUtils.autowire(((RunnerClass)runner).getCucumberReport());
    }
}
