package com.gt.projects.bdd.base.service.impl;

import com.gt.projects.bdd.base.config.DriverConfig;
import com.gt.projects.bdd.base.enums.DriverContext;
import com.gt.projects.bdd.base.enums.Platform;
import com.gt.projects.bdd.base.enums.ScrollDirection;
import com.gt.projects.bdd.base.service.DeviceService;
import com.gt.projects.bdd.hsbc_gbm.step.PortfoliosStep;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by giotto.chow on 1/23/2018.
 */
@Service
@Scope("thread")
public class DeviceServiceImpl implements DeviceService {
    
    private static final String ERR_CODE = "ERR_CODE";
    
    protected Logger logger = Logger.getLogger(this.getClass());
    
    @Autowired
    private DriverConfig driverConfig;
        
    public void resetApp() {
        if(driverConfig.getPlatform().getIsMobileApp()){
            AppiumDriver appiumDriver = ((AppiumDriver) driverConfig.getDriver());
            logger.info("Reset App");
            appiumDriver.resetApp();
        } else {
            //TODO
        }
    }
    
    public Dimension getScreenSize() {
//        return driverConfig.getDriver().manage().window().getSize();
        return driverConfig.getScreenSize();
    }
    
    public File takeScreenShot(String filename) {
        if(StringUtils.isEmpty(filename)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            filename = sdf.format(new Date()) + RandomStringUtils.randomNumeric(16) + ".png";
        }
        
        File tmpFile = driverConfig.getDriver().getScreenshotAs(OutputType.FILE);
        File file = new File("target/screen-capture-record/" + filename);
        
        try {
            FileUtils.copyFile(tmpFile, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return file;
    }
    
    public Object runCommand(String command){
        RemoteWebDriver driver = driverConfig.getDriver();
        if(driver instanceof AppiumDriver){
            AppiumDriver appiumDriver = (AppiumDriver)driver;
            
            try {
                Response response = appiumDriver.execute(command);
                if(response.getStatus() == 0){
                    if(response.getValue() == null){
                        return "";
                    } else {
                        return response.getValue();
                    }
                }
            } catch(Exception ex){
                ex.printStackTrace();
                logger.error(ex);
            }
        }
        
        return ERR_CODE;
    }
    
    
    public Boolean isDeviceLocked(){
        
        RemoteWebDriver driver = driverConfig.getDriver();
        if(driver instanceof AndroidDriver){
            return ((AndroidDriver)driver).isDeviceLocked();
        } else if (driver instanceof IOSDriver) {
            Object result = runCommand( "isLocked");
            return ERR_CODE.equals(result) ? false : (Boolean) result;
        }
        
        return false;
    }
    
    public void unlockDevice(String pin) {
        if(driverConfig.getPlatform().getIsMobileApp()){
            //            AndroidDriver androidDriver = ((AndroidDriver) appConfig.getDriver());
            //            androidDriver.unlockDevice();
            //            androidDriver.getSessionId()
            //            TouchAction touchAction = new TouchAction()
            //            androidDriver.pressKeyCode(AndroidKeyCode.ENTER);
        }
    }
    
//
//    public void unlockByPin(RemoteWebDriver driver, String pin){
//
//        if(isDeviceLocked(driver)) {
//            if (driver instanceof AndroidDriver) {
//                AndroidDriver androidDriver = (AndroidDriver) driver;
//
//                //                adb -s 85b54e4f4f543238 shell
//                //
//                //                wm size 	# Get Screen Size
//                //                am start -n io.appium.unlock/.Unlock
//                //                input touchscreen swipe 720 2000 720 1000
//                //                input text 1234
//                //                input keyevent 66
//
//                Dimension screenSize = androidDriver.manage().window().getSize();
//                int x = screenSize.getWidth() / 2;
//                int y1 = (int)(screenSize.getHeight() * 0.75);
//                int y2 = (int)(screenSize.getHeight() * 0.25);
//                androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_POWER);
//                new TouchAction(androidDriver).press(x, y1).moveTo(x, y2).release().perform();
//                androidDriver.getKeyboard().sendKeys(pin);
//                androidDriver.pressKeyCode(AndroidKeyCode.ENTER);
//
//            } else if (driver instanceof IOSDriver) {
//                IOSDriver iosDriver = (IOSDriver) driver;
//            }
//        }
//    }
    
    
    
    public Boolean isKeyboardShown(){
        RemoteWebDriver driver = driverConfig.getDriver();
        if(driver instanceof AndroidDriver){
            return ((AndroidDriver)driver).isKeyboardShown();
        } else if (driver instanceof IOSDriver) {
            Object result = runCommand( "isKeyboardShown");
            return ERR_CODE.equals(result) ? false : (Boolean) result;
        }
        
        //
        //        if (appUtils.isIOS()) {
        //            try {
        //                driver.getKeyboard();
        //
        //                if (KeyboardType.ALPHANUMERIC.equals(type)
        //                        && driver.findElementByAccessibilityId("delete") != null
        //                        && driver.findElementByAccessibilityId("space") != null
        //                        && driver.findElementByAccessibilityId("shift") != null
        //                        ) {
        //                    return true;
        //                } else if (KeyboardType.NUMPAD.equals(type)
        //                        && driver.findElementByAccessibilityId("1") != null
        //                        && driver.findElementByAccessibilityId("2") != null
        //                        && driver.findElementByAccessibilityId("3") != null
        //                        && driver.findElementByAccessibilityId("4") != null
        //                        ) {
        //                    return true;
        //                }
        //            } catch (Exception ex) {
        //                return false;
        //            }
        //        } else if (appUtils.isAndroid()) {
        //            try {
        //                appUtils.sleep(2000);
        //                driver.hideKeyboard();
        //                return true;
        //            } catch (Exception ex) {
        //                System.out.println("Keyboard not show");
        //                return false;
        //            }
        //        }
        //        return false;
        
        return false;
    }
    
    public void hideKeyboard() {
        
        RemoteWebDriver driver = driverConfig.getDriver();
        if(driver instanceof AndroidDriver){
            ((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.KEYCODE_ESCAPE);
        } else if (driver instanceof IOSDriver){
            ((IOSDriver)driver).hideKeyboard();
        } else {
            
        }
    }
    
    public void showKeyboard(){
        //TODO
    }
    

    public void longpress(int x, int y, long duration) {
        if(BooleanUtils.isTrue(driverConfig.getPlatform().getIsMobileApp())){
            TouchAction touchAction = new TouchAction((AppiumDriver)driverConfig.getDriver());
            touchAction.press(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration))).release().perform();
        }
    }

    @Override
    public void tapXY(int x, int y) {
        if(BooleanUtils.isTrue(driverConfig.getPlatform().getIsMobileApp())){
            TouchAction touchAction = new TouchAction((AppiumDriver)driverConfig.getDriver());
            touchAction.tap(PointOption.point(x, y)).perform();
        }
    }


    public void swipe(int fromX, int fromY, int toX, int toY, long duration){
        if(BooleanUtils.isTrue(driverConfig.getPlatform().getIsMobileApp())){
            TouchAction touchAction = new TouchAction((AppiumDriver)driverConfig.getDriver());
            touchAction.press(PointOption.point(fromX, fromY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                    .moveTo(PointOption.point(toX, toY))
                    .release()
                    .perform();
        }
    }

    @Override
    public void swipeScreen(int fromX, int fromY, int toX, int toY, long duration, ScrollDirection scrollDirection) {
        if(BooleanUtils.isTrue(driverConfig.getPlatform().getIsMobileApp())){
            TouchAction touchAction = new TouchAction((AppiumDriver)driverConfig.getDriver());
            touchAction.press(PointOption.point(fromX, fromY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                    .moveTo(PointOption.point(toX, toY))
                    .release()
                    .perform();
//            if (driverConfig.getPlatform().equals(Platform.IOS) && (scrollDirection.equals(ScrollDirection.LEFT) || scrollDirection.equals(ScrollDirection.RIGHT))) {
//                JavascriptExecutor js = driverConfig.getDriver();
//                HashMap<String, Object> swipeObject = new HashMap<String, Object>();
//                String direction;
//                if (ScrollDirection.LEFT.equals(scrollDirection)){
//                    direction = "left";
//                } else if (ScrollDirection.RIGHT.equals(scrollDirection)){
//                    direction = "right";
//                } else if (ScrollDirection.UP.equals(scrollDirection)){
//                    direction = "up";
//                } else {
//                    direction = "down";
//                }
//                swipeObject.put("startX", fromX);
//                swipeObject.put("startY", fromY);
//                swipeObject.put("endX", toX);
//                swipeObject.put("endY", toY);
//                swipeObject.put("duration", duration);
//                swipeObject.put("direction", direction);
//                js.executeScript("mobile: swipe", swipeObject);
//
//            } else {
//                TouchAction touchAction = new TouchAction((AppiumDriver)driverConfig.getDriver());
//                touchAction.press(PointOption.point(fromX, fromY))
//                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
//                        .moveTo(PointOption.point(toX, toY))
//                        .release()
//                        .perform();
//            }
        }
    }

    public void performTouchId(Boolean isCorrectFingerPrint){
        ((IOSDriver)driverConfig.getDriver()).performTouchID(isCorrectFingerPrint);
    }

    @Override
    public String getPageSource() {
       return driverConfig.getDriver().getPageSource();
    }


}

