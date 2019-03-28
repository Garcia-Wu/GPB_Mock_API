package com.gt.projects.bdd.base.utils;

import org.apache.log4j.Logger;
import org.codehaus.plexus.util.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.cglib.proxy.Dispatcher;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;

/**
 * Created by giotto.chow on 1/12/2018.
 */
@Service
public class BeanUtils implements ApplicationContextAware{
    
    protected static Logger logger = Logger.getLogger(BeanUtils.class);
    
    private static ThreadLocal<ApplicationContext> context = new ThreadLocal<ApplicationContext>();
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context.set(applicationContext);
    }
    
    /**
     * Designated for non-spring managed classes to access spring managed bean
     * @param classType
     * @param <T>
     * @return
     */
    public static <T> T autowire(Class<T> classType){
        return context.get().getBean(classType);
    }
    
    /**
     * Designated for non-spring managed classes to access spring managed bean
     * @param instance
     */
    public static void autowire(Object instance){
        context.get().getAutowireCapableBeanFactory().autowireBean(instance);
    }
    
    /**
     * Helper method use to generate lazy object by a factory method
     * @param classOfT
     * @param callback
     * @param <T>
     * @return
     */
    public static <T> T proxy(Class<T> classOfT, Callable<T> callback){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(classOfT);
        enhancer.setCallback(new Dispatcher() {
            @Override
            public Object loadObject() throws Exception {
                return callback.call();
            }
        });
        
        return (T)enhancer.create();
    }

}
