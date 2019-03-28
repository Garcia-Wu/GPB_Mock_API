package com.gt.projects.bdd.base.service;

import com.gt.projects.bdd.base.enums.DriverContext;
import com.gt.projects.bdd.base.enums.ScrollDirection;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

/**
 * Created by giotto.chow on 1/23/2018.
 */
public interface DeviceService {
    
    void resetApp();
    
    Dimension getScreenSize();
    
    File takeScreenShot(String filename);
    
    Object runCommand(String command);
    
    void longpress(int x, int y, long duration);

    void tapXY(int x,int y);
    
    void swipe(int fromX, int fromY, int toX, int toY, long duration);

    void swipeScreen(int fromX, int fromY, int toX, int toY, long duration, ScrollDirection scrollDirection);
    
    Boolean isDeviceLocked();
    
    void unlockDevice(String pin);
    
    Boolean isKeyboardShown();
    
    void hideKeyboard();
    
    void showKeyboard();
    
    void performTouchId(Boolean isCorrectFingerPrint);

    String getPageSource();
}
