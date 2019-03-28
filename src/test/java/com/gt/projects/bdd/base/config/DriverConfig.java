package com.gt.projects.bdd.base.config;

import com.gt.projects.bdd.RunnerClass;
import com.gt.projects.bdd.base.AbstractCucumberRunner;
import com.gt.projects.bdd.base.enums.Platform;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.Getter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Scope("thread")
@Configuration
public class DriverConfig implements InitializingBean{
    
    protected Logger logger = Logger.getLogger(this.getClass());
    
    @Value("${implicit.wait}")
    private int implicitWaitTime;
    
    @Value("${explicit.wait}")
    private int explicitWaitTime;
    
    @Value("${default.wait}")
    private int defaultWaitTime;
    
    @Getter
    private Dimension screenSize;
    
    private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    
    private static ThreadLocal<Platform> platform = new ThreadLocal<>();

    private static ThreadLocal<String> deviceName = new ThreadLocal<>();

    private static ThreadLocal<String> appRegion = new ThreadLocal<>();

    private void setDriverProps(Platform platform){
        
        String osName = System.getProperty("os.name").toLowerCase();
        String osArch = System.getProperty("sun.arch.data.model");
        String driverExt = "";
        if(osName.startsWith("win")) {
            osName = "win";
            driverExt = ".exe";
        } else if(osName.startsWith("mac")){
            osName = "osx";
            driverExt = "";
        } else {
            osName = "linux";
            driverExt = "";
        }
    
        logger.debug("OS: " + osName + osArch);
    
        if(StringUtils.isNotBlank(platform.getPropertyName())){
        
            File serverDir = new File("target/server");
            List<File> fileList = (List<File>) FileUtils.listFiles(serverDir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
            for(File file : fileList){
            
                String filePath = file.getPath();
                if(filePath.contains(osName)
                        && filePath.contains(osArch)
                        && filePath.contains(driverExt)
                        && filePath.contains(platform.getDriverName())
                        && !filePath.contains(".zip")) {
                
                    System.setProperty(platform.getPropertyName(), filePath);
                    logger.debug("Select driver: " + filePath);
                }
            }
        }
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
    
        try {
            logger.info("---------- Driver Configuration ----------");
        
            AbstractCucumberRunner runner = RunnerClass.getCurrentRunner();
        
            String automationServer = runner.getAutomationServer();
            String instrumentation = runner.getInstrumentation();
            String platformVersion = runner.getPlatformVersion();
            String deviceName = runner.getDeviceName();
            String appPath = runner.getAppPath();
            String baseUrl = runner.getBaseUrl();
            String pin = runner.getPin();
            String udid = runner.getUdid();
            String wdaLocalPort = runner.getWdaLocalPort();
            String xcodeOrgId = runner.getXcodeOrgId();
            String xcodeSigningId = runner.getXcodeSigningId();
            String newCommandTimeout = runner.getNewCommandTimeout();
            String appRegion = runner.getAppRegion();
        
            logger.info("BDD Server: " + automationServer);
            logger.info("Instrumentation: " + instrumentation);
            logger.info("Platform Version: " + platformVersion);
            logger.info("Device Name: " + deviceName);
            logger.info("App Path: " + appPath);
        
            Platform platform = Platform.valueOf(runner.getPlatform());
            logger.info("Platform: " + platform.getName());
            DriverConfig.platform.set(platform);
            DriverConfig.deviceName.set(deviceName);
            DriverConfig.appRegion.set(appRegion);

        
            // Mobile App
            RemoteWebDriver tmpDriver = null;
            DesiredCapabilities capabilities = null;
            if(platform.getIsMobileApp()){
                capabilities = new DesiredCapabilities();

                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, instrumentation);
                capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
                capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
                capabilities.setCapability("clearSystemFiles", true);
                capabilities.setCapability(MobileCapabilityType.ACCEPT_INSECURE_CERTS, true);

            
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platform.getName());
                capabilities.setCapability(MobileCapabilityType.APP, (new File(appPath)).getAbsolutePath());

                if(StringUtils.isNotBlank(newCommandTimeout)) {
                    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, newCommandTimeout);
                }

                if(StringUtils.isNotBlank(platformVersion)) {
                    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
                }

                if(StringUtils.isNotBlank(udid)){
                    capabilities.setCapability(MobileCapabilityType.UDID, udid);
                }
            
                if(StringUtils.isNotBlank(pin)){
                    capabilities.setCapability("skipUnlock", true);
                }
            
                if(Platform.ANDROID.equals(platform)) {
                    tmpDriver = new AndroidDriver(new URL(automationServer), capabilities);
                } else if (Platform.IOS.equals(platform)){

//                    capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, false);
                    tmpDriver = new IOSDriver<>(new URL(automationServer), capabilities);
//                    ((IOSDriver)tmpDriver).switchTo().alert().accept();
                    if(StringUtils.isNotBlank(wdaLocalPort)) {

                        capabilities.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT, wdaLocalPort);
                        if(StringUtils.isNotBlank(xcodeOrgId)){
                            capabilities.setCapability(IOSMobileCapabilityType.XCODE_ORG_ID, xcodeOrgId);
                        }
                        if(StringUtils.isNotBlank(xcodeSigningId)){
                            capabilities.setCapability(IOSMobileCapabilityType.XCODE_SIGNING_ID, xcodeSigningId);
                        }

                        capabilities.setCapability(IOSMobileCapabilityType.COMMAND_TIMEOUTS, newCommandTimeout);
                        capabilities.setCapability(IOSMobileCapabilityType.WDA_CONNECTION_TIMEOUT, newCommandTimeout);
                        capabilities.setCapability(IOSMobileCapabilityType.WDA_LAUNCH_TIMEOUT, newCommandTimeout);
                    }


                } else {
                    throw new UnsupportedOperationException();
                }

                //                if(StringUtils.isNotBlank(pin)){
                //                    InteractionUtils.unlockByPin(tmpDriver, pin);
                //                }
            
                //                ((AppiumDriver)tmpDriver).resetApp();
            
            } else {
            
                setDriverProps(platform);
                //                TODO:
                //                capabilities = new DesiredCapabilities();
                //                capabilities.setCapability(CapabilityType.BROWSER_NAME, browserName);
            
                // Web
                if(Platform.EDGE.equals(platform)){
                    tmpDriver = new EdgeDriver();
                } else if(Platform.CHROME.equals(platform)){
                    tmpDriver = new ChromeDriver();
                } else if(Platform.FIREFOX.equals(platform)){
                    tmpDriver = new FirefoxDriver();
                } else if(Platform.SAFARI.equals(platform)){
                    tmpDriver = new SafariDriver();
                    // Need to install plugin
                }
            
                tmpDriver.manage().window().fullscreen();
            }
        
            tmpDriver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
            screenSize = tmpDriver.manage().window().getSize();
            driver.set(tmpDriver);
        
            logger.info("Setup driver Successfully, session ID: " + tmpDriver.getSessionId());
        
        } catch(Throwable ex){
            logger.error("Fail to setup automation server, please check the web driver configuration", ex);
        }
    }
    
    public RemoteWebDriver getDriver() {
        return driver.get();
    }
    
    public Platform getPlatform(){
        return platform.get();
    }

    public String getDeviceName(){
        return deviceName.get();
    }

    public String getAppRegion(){
        return appRegion.get();
    }
}
