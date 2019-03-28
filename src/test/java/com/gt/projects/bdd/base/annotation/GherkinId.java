package com.gt.projects.bdd.base.annotation;

import com.google.common.collect.ImmutableMap;
import com.gt.projects.bdd.base.enums.InputType;
import com.gt.projects.bdd.base.enums.ScrollDirection;

import java.lang.annotation.*;
import java.util.HashMap;
import java.util.Map;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface GherkinId {
    String name() default "";   // field name binding, e.g. Gender
    String value() default "";  // field value binding, e.g. Male, Female
    String findByObjectId() default "";
    String findByXPath() default "";
    String findByName() default "";
    String findByAosDevelopId() default "";
    InputType type() default InputType.CLICK; // action binding, e.g. send key, click
    boolean isUniqueKey() default false;
    ScrollDirection scrollDirection() default ScrollDirection.RIGHT;
    int scrollTryCount() default 5;
    String textContains() default "";
    String descriptionContains() default "";
    String tagClass() default "";

}
