package com.gt.projects.bdd.hsbc_gbm.util;

import com.gt.projects.bdd.base.BaseWebElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;

public class SleepUtil {

    protected static Logger logger = Logger.getLogger(SleepUtil.class);


    private static Integer lastTime = 1000;


    public static void waitForElement(BaseWebElement element){
        Integer endTime = 0;
        while (!element.isVisible()){
            if (endTime.equals(lastTime)){

                throw timeoutException("The element that causes the failure: "+element.getContent(),new Throwable());
            }
            sleep(100L);
            endTime += 100;
        }
    }

    protected static RuntimeException timeoutException(String message, Throwable lastException) {
        throw new TimeoutException(message, lastException);
    }

    protected static void sleep(Long ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error(ex);
        }

    }
}
