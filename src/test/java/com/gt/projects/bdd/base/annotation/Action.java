package com.gt.projects.bdd.base.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Action {
    
    String value() default "";
}
