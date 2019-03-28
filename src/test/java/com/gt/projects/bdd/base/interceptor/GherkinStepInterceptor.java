package com.gt.projects.bdd.base.interceptor;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Interceptor to controller whether step should be skipped.
 */
@Aspect
public class GherkinStepInterceptor {
    
    protected Logger logger = Logger.getLogger(this.getClass());
    
    private Boolean isSkippedPreviousSection;
    
    private Boolean isSkippedGivenSection;
    
    private Boolean isSkippedWhenSection;
    
    private Boolean isSkippedThenSection;
    
    public void setIsSkipped(Boolean given, Boolean when, Boolean then){
        isSkippedGivenSection = given;
        isSkippedWhenSection = when;
        isSkippedThenSection = then;
        isSkippedPreviousSection = false;
    }
        
    private Boolean isSkipped(Boolean flag){
        if(BooleanUtils.isTrue(flag)){
            isSkippedPreviousSection = true;
            return true;
        } else {
            isSkippedPreviousSection = false;
            return false;
        }
    }
    
    @Around("@annotation(given)")
    public void interceptGiven(ProceedingJoinPoint jp, Given given) throws Throwable{
        if(!isSkipped(isSkippedGivenSection)){
            jp.proceed(jp.getArgs());
        }
    }
        
    @Around("@annotation(when)")
    public void interceptWhen(ProceedingJoinPoint jp, When when) throws Throwable {
        if(!isSkipped(isSkippedWhenSection)){
            jp.proceed(jp.getArgs());
        }
    }
    
    @Around("@annotation(then)")
    public void interceptThen(ProceedingJoinPoint jp, Then then) throws Throwable {
        if(!isSkipped(isSkippedThenSection)){
            jp.proceed(jp.getArgs());
        }
    }
    
    @Around("@annotation(and)")
    public void interceptAnd(ProceedingJoinPoint jp, And and) throws Throwable {
        if(!isSkipped(isSkippedPreviousSection)){
            jp.proceed(jp.getArgs());
        }
    }
        
}
