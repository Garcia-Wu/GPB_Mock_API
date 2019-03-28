package com.gt.projects.bdd.base.entity.wrapper;

import gherkin.events.PickleEvent;
import gherkin.pickles.PickleStep;
import lombok.Data;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by giotto.chow on 2/1/2018.
 */
@Data
public class Glue {
    
    private String regex;
    
    private Class annotationType;
    
    private Object annotation;
    
    private Method method;
        
    private PickleStep pickleStep;
    
    private String language;
    
    public static Glue newInstance(String regex, Class annotationType, Object annotation, Method method){
        Glue glue = new Glue();
        glue.setRegex(regex);
        glue.setAnnotationType(annotationType);
        glue.setAnnotation(annotation);
        glue.setMethod(method);
        return glue;
    }
}
