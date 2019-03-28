package com.gt.projects.bdd.base.service;

import com.gt.projects.bdd.base.annotation.GherkinId;
import com.gt.projects.bdd.base.enums.DriverContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by giotto.chow on 1/23/2018.
 */
public interface FinderService {
    
    void switchDriverContext(DriverContext driverContext);
        
    WebElement findElement(By by);
}
