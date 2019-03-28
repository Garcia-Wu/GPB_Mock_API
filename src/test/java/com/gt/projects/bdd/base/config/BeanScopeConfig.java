package com.gt.projects.bdd.base.config;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.SimpleThreadScope;

@Configuration
public class BeanScopeConfig implements BeanFactoryPostProcessor {
    
    private Logger logger = Logger.getLogger(this.getClass());
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        factory.registerScope("thread", new SimpleThreadScope());
    }
    
}