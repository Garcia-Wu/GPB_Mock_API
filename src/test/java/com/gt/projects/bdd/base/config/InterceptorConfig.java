package com.gt.projects.bdd.base.config;

import com.gt.projects.bdd.base.interceptor.GherkinStepInterceptor;
import com.gt.projects.bdd.base.interceptor.PageElementInterceptor;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class InterceptorConfig{
    
    private Logger logger = Logger.getLogger(this.getClass());
    
    @Bean
    @Scope("thread")
    public PageElementInterceptor pageElementInterceptor(){
        
        PageElementInterceptor tmp = new PageElementInterceptor();
        return tmp;
    }
    
    @Bean
    @Scope("thread")
    public GherkinStepInterceptor gherkinStepInterceptor(){
        
        GherkinStepInterceptor tmp = new GherkinStepInterceptor();
        return tmp;
    }
    
}
