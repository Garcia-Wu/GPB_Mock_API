package com.gt.projects.bdd.base.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Tags {
    
    String[] value() default {};
    
}