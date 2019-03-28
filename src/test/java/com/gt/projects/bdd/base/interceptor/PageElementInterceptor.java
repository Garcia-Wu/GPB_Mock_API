package com.gt.projects.bdd.base.interceptor;

import com.gt.projects.bdd.base.BaseWebElement;
import com.gt.projects.bdd.base.annotation.GherkinId;
import com.gt.projects.bdd.base.annotation.WebView;
import com.gt.projects.bdd.base.config.DriverConfig;
import com.gt.projects.bdd.base.enums.DriverContext;
import com.gt.projects.bdd.base.utils.AnnotationUtils;
import com.gt.projects.bdd.base.utils.GherkinUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;

@Aspect
public class PageElementInterceptor {
    
    protected Logger logger = Logger.getLogger(this.getClass());
            
    @Around("execution(public com.gt.projects.bdd.base.BaseWebElement+ com.gt.projects.bdd.base.BasePage+.get*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
    
        Object result = joinPoint.proceed(joinPoint.getArgs());
        
        if(result == null){
    
            // Is this field annotated with @GherkinId
            Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
            GherkinId gherkinId = AnnotationUtils.getAnnotation(GherkinId.class, method);
            if(gherkinId != null){
    
                // Is return type annotated with @WebView
                Object target = joinPoint.getTarget();
                Class targetClazz = target.getClass();
                DriverContext driverContext = targetClazz.isAnnotationPresent(WebView.class) ? DriverContext.WEBVIEW : DriverContext.NATIVE_APP;
    
                result = new BaseWebElement(driverContext, gherkinId);
            }
        }
        
        return result;
    }
    
}
