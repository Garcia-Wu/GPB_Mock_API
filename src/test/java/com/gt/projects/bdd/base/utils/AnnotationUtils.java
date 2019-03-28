package com.gt.projects.bdd.base.utils;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.codehaus.plexus.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by giotto.chow on 2/14/2018.
 */
public class AnnotationUtils {
    
    /**
     * Search the annotation from the method, or the field if it is a getter method
     * @param annotationClass
     * @param method
     * @param <A>
     * @return
     */
    public static <A extends Annotation> A getAnnotation(Class<A> annotationClass, Method method){
    
        // Search method
        A result = MethodUtils.getAnnotation(method, annotationClass, false, true);
    
        // Search field for getter method
        if(result == null && method.getName().startsWith("get")){
            
            Class clazz = method.getDeclaringClass();
            String fieldName = StringUtils.uncapitalise(method.getName().replaceFirst("get", ""));
            
            Field field = FieldUtils.getField(clazz, fieldName, true);
            if(field != null && field.isAnnotationPresent(annotationClass)){
                result = field.getAnnotation(annotationClass);
            }
        }
        
        return result;
    }
    
}
