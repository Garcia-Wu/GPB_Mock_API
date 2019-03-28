package com.gt.projects.bdd.base;

import com.gt.projects.bdd.base.annotation.GherkinId;
import com.gt.projects.bdd.base.config.DriverConfig;
import com.gt.projects.bdd.base.enums.DriverContext;
import com.gt.projects.bdd.base.enums.Platform;
import com.gt.projects.bdd.base.utils.BeanUtils;
import com.gt.projects.bdd.base.utils.GherkinUtils;
import io.appium.java_client.MobileBy;
import lombok.Data;
import net.sf.cglib.proxy.CallbackHelper;
import net.sf.cglib.proxy.Dispatcher;
import net.sf.cglib.proxy.Enhancer;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public abstract class BasePage {
    
    @Value("default.timeout")
    private String defaultTimeout;
    
    protected Logger logger = Logger.getLogger(this.getClass());
        
    protected List<GherkinId> gherkinIdList;

    protected Map<String,BaseWebElement> hasElementNameList;
    
    protected BasePage(){
        Class clazz = this.getClass();
        String className = clazz.getSimpleName();
        
        logger.debug("Loading page : " + className);
    
        gherkinIdList = new ArrayList<GherkinId>();
        
        for(Field field : FieldUtils.getFieldsListWithAnnotation(clazz, GherkinId.class)){
            GherkinId gherkinId = field.getAnnotation(GherkinId.class);
//            if (StringUtils.isBlank(gherkinId.name())) {
//                logger.warn("Invalid gherkin ID format, the name of '" + field.getName() + "' should not be blank.");
//                continue;
//            }
            gherkinIdList.add(gherkinId);
        }
    
        for(Method method : MethodUtils.getMethodsListWithAnnotation(clazz, GherkinId.class)){
            GherkinId gherkinId = method.getAnnotation(GherkinId.class);
//            if (StringUtils.isBlank(gherkinId.name())) {
//                logger.warn("Invalid gherkin ID format, the name of '" + method.getName() + "' should not be blank.");
//                continue;
//            }
            gherkinIdList.add(gherkinId);
        }
    }


    
    public BaseWebElement getElementByGherkinId(String gherkinId){
        return getElementByGherkinIdNValue(gherkinId, "");
    }
    
    public BaseWebElement getElementByGherkinIdNValue(String gherkinId, String value){
        
        for(GherkinId annotation : gherkinIdList) {
            if(annotation.name().equals(gherkinId) && annotation.value().equals(value)){
                return getElementByGherkinId(annotation);
            }
        }
        
        return null;
    }
    
    public BaseWebElement getElementByGherkinId(GherkinId gherkinId){
        return new BaseWebElement(GherkinUtils.toFinder(gherkinId, ""));
    }
    
    public BaseWebElement getElementById(String id){
        DriverConfig driverConfig = BeanUtils.autowire(DriverConfig.class);
        if(driverConfig.getPlatform().equals(Platform.ANDROID)){
            return getElement(new MobileBy.ByAccessibilityId(id));
        } else {
            return getElement(By.id(id));
        }
    }

//    public BaseWebElement getElementByName(String name){
//        return getElement(By.name(name));
//    }
//
//    public BaseWebElement getElementByXpath(String xpath){
//        return getElement(By.xpath(xpath));
//    }
//
//    public BaseWebElement getElementByAosAccessibilityId(String id){
//        return getElement(new MobileBy.ByAccessibilityId(id));
//    }
    
    public BaseWebElement getElement(By by){
        return new BaseWebElement(null, by);
    }
    
    public List<BaseWebElement> getUniqueKeyElements(){
        
        List<BaseWebElement> resultList = new ArrayList<BaseWebElement>();
        for(GherkinId gherkinId : gherkinIdList){
            if(gherkinId.isUniqueKey()) {
                resultList.add(getElementByGherkinId(gherkinId));
            }
        }
        
        return resultList;
    }
    public Map<String,BaseWebElement> getUniqueKeyElementsMap(){

        if(hasElementNameList == null){
            hasElementNameList = new HashMap<>();
            for(GherkinId gherkinId : gherkinIdList){
                if(gherkinId.name() != null) {
                    hasElementNameList.put(gherkinId.name(), getElementByGherkinId(gherkinId));
                }
            }
        }

        return hasElementNameList;
    }
}
