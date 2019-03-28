package com.gt.projects.bdd.base;

import com.gt.projects.bdd.base.annotation.GherkinId;
import com.gt.projects.bdd.base.config.DriverConfig;
import com.gt.projects.bdd.base.enums.DriverContext;
import com.gt.projects.bdd.base.enums.Platform;
import com.gt.projects.bdd.base.enums.ScrollDirection;
import com.gt.projects.bdd.base.service.DeviceService;
import com.gt.projects.bdd.base.service.FinderService;
import com.gt.projects.bdd.base.utils.BeanUtils;
import com.gt.projects.bdd.base.utils.GherkinUtils;
import io.appium.java_client.MobileBy;
import lombok.Getter;
import org.apache.commons.lang3.BooleanUtils;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.concurrent.Callable;

/**
 * Lazy object
 */
public class BaseWebElement {

    private GherkinId gherkinId;

    private String name;

    @Getter
    private By finderPath;

    private DriverContext driverContext;

    private DriverConfig driverConfig = BeanUtils.autowire(DriverConfig.class);

    @Getter
    private WebElement webElement;

    public BaseWebElement(DriverContext driverContext, GherkinId gherkinId) {
        this.driverContext = driverContext;
        this.gherkinId = gherkinId;
        this.finderPath = GherkinUtils.toFinder(gherkinId, "");
        refresh();
    }

    public BaseWebElement(DriverContext driverContext, GherkinId gherkinId, String name) {
        this.driverContext = driverContext;
        this.gherkinId = gherkinId;
        this.name = name;
        this.finderPath = GherkinUtils.toFinder(gherkinId, "");
        refresh();
    }

    public BaseWebElement(DriverContext driverContext, By by) {
        this.driverContext = driverContext;
        this.finderPath = by;
        refresh();
    }

    public BaseWebElement(By by) {
        this.finderPath = by;
        refresh();
    }

    public BaseWebElement(String elementId) {
        DriverConfig driverConfig = BeanUtils.autowire(DriverConfig.class);
        if(driverConfig.getPlatform().equals(Platform.ANDROID)){
            this.finderPath = new MobileBy.ByAccessibilityId(elementId);
        } else {
            this.finderPath = By.id(elementId);
        }
        refresh();
    }

    public void refresh() {
        this.webElement = BeanUtils.proxy(WebElement.class, new Callable<WebElement>() {
            @Override
            public WebElement call() throws Exception {
                FinderService finderService = BeanUtils.autowire(FinderService.class);
                finderService.switchDriverContext(driverContext);
                return finderService.findElement(finderPath);
            }
        });
    }

    public boolean isExisted() {
        try {
            webElement.isDisplayed();
            return true;
        } catch (NoSuchElementException wdp) {
            return false;
        } catch (WebDriverException ex) {
            return false;
        }
    }

    public boolean isVisible() {
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException wdp) {
            return false;
        } catch (WebDriverException ex) {
            return false;
        }
    }

    public void click() {
        webElement.click();
    }

    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    public boolean isSelected() {
        return webElement.isSelected();
    }

    public String getTag() {
        return webElement.getTagName();
    }

    public String getContent() {
        return webElement.getText();
    }

    public Rectangle getRect() {
        Rectangle rectangle = new Rectangle(webElement.getLocation().getX(), webElement.getLocation().getY(), webElement.getSize().height, webElement.getSize().width);
        return rectangle;
//        return webElement.getRect();
    }

    public void sendKeys(String value) {

        DeviceService deviceService = BeanUtils.autowire(DeviceService.class);
        if (BooleanUtils.isNotTrue(deviceService.isKeyboardShown())) {
            deviceService.showKeyboard();
        }

        webElement.sendKeys(value);

//        deviceService.hideKeyboard();
    }

    public void longPress(long duration) {
        DeviceService deviceService = BeanUtils.autowire(DeviceService.class);
        Point location = webElement.getLocation();

        deviceService.longpress(location.getX(), location.getY(), duration);
    }

    public void tapXY(int x, int y) {
        DeviceService deviceService = BeanUtils.autowire(DeviceService.class);
        deviceService.tapXY(x, y);
    }

    public void scrollToItem(BaseWebElement element, ScrollDirection scrollDirection) {
        boolean isFind = false;
        int i = 0;
        while (!isFind) {
            if (!element.isVisible()) {
                if(driverConfig.getPlatform().equals(Platform.ANDROID)){
                    scroll(scrollDirection, 1000L, 450);
                } else {
                    scroll(scrollDirection, 1000L,250);
                }
                i++;
            } else {
                isFind = true;
            }
            try {
                Thread.sleep(200);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (i == 20){
                Assert.fail("can not find this element:" + element.gherkinId.findByObjectId());
            }
        }
    }

    public void scrollToBottomItem(BaseWebElement element) {
        boolean isFind = false;
        int i = 0;
        while (!isFind) {
            if (!element.isVisible()) {
                scroll(ScrollDirection.UP, 1000l, 1100);
                i++;
            } else {
                isFind = true;
            }
            try {
                Thread.sleep(200);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (i == 20){
                Assert.assertTrue("can not find this element:"+element.gherkinId.findByObjectId(),false);
            }
        }
    }

    public void scrollToTopItem(BaseWebElement element) {
        boolean isFind = false;
        int i = 0;
        while (!isFind) {
            if (!element.isVisible()) {
                scroll(ScrollDirection.DOWN, 1000l, 1100);
                i++;
            } else {
                isFind = true;
            }
            try {
                Thread.sleep(200);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (i == 20){
                Assert.assertTrue("can not find this element:"+element.gherkinId.findByObjectId(),false);
            }
        }
    }

    public void scroll(ScrollDirection scrollDirection, Long duration){
        scroll(scrollDirection,duration,0);
    }

    public void scroll(ScrollDirection scrollDirection, Long duration,int offset) {

        DeviceService deviceService = BeanUtils.autowire(DeviceService.class);

        Point location = webElement.getLocation();
        Dimension size = webElement.getSize();

//        TODO: endX & endY is using relative position, waiting for fix @version 1.8 to use absolute position, see
//        https://github.com/appium/appium/issues/7486
        double startX = 0, startY = 0, endX = 0, endY = 0;

        if (ScrollDirection.LEFT.equals(scrollDirection)) {
            startX = location.getX() + (size.getWidth() * 0.89);
            if(startX > deviceService.getScreenSize().width)
            {
                startX = deviceService.getScreenSize().width* 0.89;
            }
//            endX = -1 * size.getWidth() * 0.6;
            endX = location.getX() + (size.getWidth() * 0.01);
            if(offset > 0)
            {
                endX = startX - offset;
            }
            startY = location.getY() + (size.getHeight() / 2);       // Centre
//            endY = 0;  // No move Y
            endY = startY;  // No move Y
        } else if (ScrollDirection.RIGHT.equals(scrollDirection)) {
            startX = location.getX() + (size.getWidth() * 0.01);
//            endX = size.getWidth() * 0.6;
            endX = location.getX() + (size.getWidth() * 0.89);
            if(offset > 0)
            {
                endX = startX + offset;
            }
            if(endX > deviceService.getScreenSize().width)
            {
                endX = deviceService.getScreenSize().width*0.89;
            }

            startY = location.getY() + (size.getWidth() / 2);
//            endY = 0;  // No move Y
            endY = startY; // No move Y
        } else if (ScrollDirection.UP.equals(scrollDirection)) {
            startY = location.getY() + (size.getHeight() * 0.89);
            if(startY > deviceService.getScreenSize().height)
            {
                startY =  deviceService.getScreenSize().height*0.89;
            }
//            endY = -1 * size.getHeight() * 0.6;
            if(offset > 0)
            {
                endY = startY - offset;
            }
            if(endY <= 0)
            {
                endY = deviceService.getScreenSize().height*0.2;
            }
            if(endY > deviceService.getScreenSize().height)
            {
                endY = deviceService.getScreenSize().height*0.2;
            }

            startX = location.getX() + (size.getHeight() / 2);
//            endX = 0;  // No move X
            endX = startX;
        } else {
            startY = location.getY() + (size.getHeight() * 0.01);
//            endY = size.getHeight() * 0.6;
            endY = location.getY() + (size.getHeight() * 0.89);
            if(offset > 0)
            {
                endY = startY + offset;
            }
            if(endY > deviceService.getScreenSize().height)
            {
                endY = deviceService.getScreenSize().height*0.89;

            }

            startX = location.getX() + (size.getHeight() / 2);
//            endX = 0;  // No move X
            endX = startX;
        }

        deviceService.swipeScreen((int) startX, (int) startY, (int) endX, (int) endY, duration, scrollDirection);

    }

    public void scrollIOS(ScrollDirection scrollDirection, Long duration,int offset) {

        DeviceService deviceService = BeanUtils.autowire(DeviceService.class);

        Point location = webElement.getLocation();
        Dimension size = webElement.getSize();

//        TODO: endX & endY is using relative position, waiting for fix @version 1.8 to use absolute position, see
//        https://github.com/appium/appium/issues/7486
        double startX = 0, startY = 0, endX = 0, endY = 0;

        if (ScrollDirection.LEFT.equals(scrollDirection)) {
            startX = location.getX() + (size.getWidth() * 0.89);
            if(startX > deviceService.getScreenSize().width)
            {
                startX = deviceService.getScreenSize().width* 0.89;
            }
//            endX = -1 * size.getWidth() * 0.6;
            endX = location.getX() + (size.getWidth() * 0.01);
            if(offset > 0)
            {
                endX = startX - offset;
            }
            startY = location.getY() + (size.getWidth() / 2);       // Centre
//            endY = 0;  // No move Y
            endY = startY;  // No move Y
        } else if (ScrollDirection.RIGHT.equals(scrollDirection)) {
            startX = location.getX() + (size.getWidth() * 0.01);
//            endX = size.getWidth() * 0.6;
            endX = location.getX() + (size.getWidth() * 0.89);
            if(offset > 0)
            {
                endX = startX + offset;
            }
            if(endX > deviceService.getScreenSize().width)
            {
                endX = deviceService.getScreenSize().width*0.89;
            }

            startY = location.getY() + (size.getWidth() / 2);
//            endY = 0;  // No move Y
            endY = startY; // No move Y
        } else if (ScrollDirection.UP.equals(scrollDirection)) {
            startY = location.getY() + (size.getHeight() * 0.5);
            if(startY > deviceService.getScreenSize().height)
            {
                startY =  deviceService.getScreenSize().height*0.6;
            }
//            endY = -1 * size.getHeight() * 0.6;
            if(offset > 0)
            {
                endY = startY - offset;
            }
            if(endY > deviceService.getScreenSize().height)
            {
                endY = deviceService.getScreenSize().height*0.89;
            }

            startX = location.getX() + (size.getHeight() / 2);
//            endX = 0;  // No move X
            endX = startX;
        } else {
            startY = location.getY() + (size.getHeight() * 0.01);
//            endY = size.getHeight() * 0.6;
            endY = location.getY() + (size.getHeight() * 0.89);
            if(offset > 0)
            {
                endY = startY + offset;
            }
            if(endY > deviceService.getScreenSize().height)
            {
                endY = deviceService.getScreenSize().height*0.89;
            }

            startX = location.getX() + (size.getHeight() / 2);
//            endX = 0;  // No move X
            endX = startX;
        }

        deviceService.swipeScreen((int) startX, (int) startY, (int) endX, (int) endY, duration, scrollDirection);

    }

    public void smallScroll(ScrollDirection scrollDirection, Long duration) {

        DeviceService deviceService = BeanUtils.autowire(DeviceService.class);

        Point location = webElement.getLocation();
        Dimension size = webElement.getSize();

//        TODO: endX & endY is using relative position, waiting for fix @version 1.8 to use absolute position, see
//        https://github.com/appium/appium/issues/7486
        double startX = 0, startY = 0, endX = 0, endY = 0;

        if (ScrollDirection.LEFT.equals(scrollDirection)) {
            startX = location.getX() + (size.getWidth() * 0.7);
//            endX = -1 * size.getWidth() * 0.6;
            endX = location.getX() + (size.getWidth() * 0.4);
            startY = location.getY() + (size.getWidth() / 2);       // Centre
//            endY = 0;  // No move Y
            endY = startY;  // No move Y
        } else if (ScrollDirection.RIGHT.equals(scrollDirection)) {
            startX = location.getX() + (size.getWidth() * 0.4);
//            endX = size.getWidth() * 0.6;
            endX = location.getX() + (size.getWidth() * 0.7);
            startY = location.getY() + (size.getWidth() / 2);
//            endY = 0;  // No move Y
            endY = startY; // No move Y
        } else if (ScrollDirection.UP.equals(scrollDirection)) {
            startY = location.getY() + (size.getHeight() * 0.7);
//            endY = -1 * size.getHeight() * 0.6;
            endY = location.getY() + (size.getHeight() * 0.4);
            startX = location.getX() + (size.getHeight() / 2);
//            endX = 0;  // No move X
            endX = startX;
        } else {
            startY = location.getY() + (size.getHeight() * 0.4);
//            endY = size.getHeight() * 0.6;
            endY = location.getY() + (size.getHeight() * 0.7);
            startX = location.getX() + (size.getHeight() / 2);
//            endX = 0;  // No move X
            endX = startX;
        }

        deviceService.swipe((int) startX, (int) startY, (int) endX, (int) endY, duration);
    }

    public void scrollTillFound(BaseWebElement container, Long duration) {

        if (gherkinId == null) return;   //TODO

        DeviceService deviceService = BeanUtils.autowire(DeviceService.class);

        Point location = webElement.getLocation();
        Dimension size = webElement.getSize();

//        TODO: endX & endY is using relative position, waiting for fix @version 1.8 to use absolute position, see
//        https://github.com/appium/appium/issues/7486
        double startX = 0, startY = 0, endX = 0, endY = 0;


        if (ScrollDirection.LEFT.equals(gherkinId.scrollDirection())) {
            startX = location.getX() + (size.getWidth() * 0.9);
//            endX = -1 * size.getWidth() * 0.6;
            endX = location.getX() + (size.getWidth() * 0.1);
            startY = location.getY() + (size.getWidth() / 2);       // Centre
//            endY = 0;  // No move Y
            endY = startY;  // No move Y
        } else if (ScrollDirection.RIGHT.equals(gherkinId.scrollDirection())) {
            startX = location.getX() + (size.getWidth() * 0.1);
//            endX = size.getWidth() * 0.6;
            endX = location.getX() + (size.getWidth() * 0.9);
            startY = location.getY() + (size.getWidth() / 2);
//            endY = 0;  // No move Y
            endY = startY; // No move Y
        } else if (ScrollDirection.UP.equals(gherkinId.scrollDirection())) {
            startY = location.getY() + (size.getHeight() * 0.9);
//            endY = -1 * size.getHeight() * 0.6;
            endY = location.getY() + (size.getHeight() * 0.1);
            startX = location.getX() + (size.getHeight() / 2);
//            endX = 0;  // No move X
            endX = startX;
        } else {
            startY = location.getY() + (size.getHeight() * 0.1);
//            endY = size.getHeight() * 0.6;
            endY = location.getY() + (size.getHeight() * 0.9);
            startX = location.getX() + (size.getHeight() / 2);
//            endX = 0;  // No move X
            endX = startX;
        }

        int tryCount = gherkinId.scrollTryCount();
        while (tryCount-- > 0 && isElementOutOfScreenBounds()) {
            deviceService.swipe((int) startX, (int) startY, (int) endX, (int) endY, duration);
        }
    }

    public Boolean isElementOutOfScreenBounds() {

        DeviceService deviceService = BeanUtils.autowire(DeviceService.class);
        Dimension boundary = deviceService.getScreenSize();

        Point location = webElement.getLocation();
        if (!webElement.isDisplayed() && location.getX() == 0 && location.getY() == 0) return true;

        int x = location.getX();
        int y = location.getY();
        int x1 = boundary.getWidth();
        int y1 = boundary.getHeight();

        if (x > x1 || y > y1) {
            return true;
        } else {
            return false;
        }
    }

}
