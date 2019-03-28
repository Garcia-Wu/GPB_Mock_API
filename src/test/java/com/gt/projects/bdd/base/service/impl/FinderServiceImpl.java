package com.gt.projects.bdd.base.service.impl;

import com.gt.projects.bdd.base.annotation.GherkinId;
import com.gt.projects.bdd.base.config.DriverConfig;
import com.gt.projects.bdd.base.enums.DriverContext;
import com.gt.projects.bdd.base.service.DeviceService;
import com.gt.projects.bdd.base.service.FinderService;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by giotto.chow on 1/23/2018.
 */
@Service
@Scope("thread")
public class FinderServiceImpl implements FinderService {
    
    protected Logger logger = Logger.getLogger(this.getClass());
    
    @Autowired
    private DriverConfig driverConfig;
    
    private DriverContext driverContext = DriverContext.NATIVE_APP;
        
    public void switchDriverContext(DriverContext driverContext) {
    
        if(driverContext != null
                && driverConfig.getDriver() != null
                && BooleanUtils.isTrue(driverConfig.getPlatform().getIsMobileApp())
                && !this.driverContext.equals(driverContext)){
    
            AppiumDriver appiumDriver = (AppiumDriver) driverConfig.getDriver();
            List<String> contextList = new ArrayList<String>(appiumDriver.getContextHandles());
    
            String targetContext;
            if(DriverContext.WEBVIEW.equals(driverContext)){
                targetContext = contextList.get(contextList.size() - 1);
            } else {
                targetContext = contextList.get(0);
            }
            appiumDriver.context(targetContext);
            
            this.driverContext = driverContext;
        }
    }
        
    public WebElement findElement(By by) {
        return driverConfig.getDriver().findElement(by);
    }
    
    
}

