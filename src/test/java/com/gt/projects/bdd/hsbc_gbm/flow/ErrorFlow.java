package com.gt.projects.bdd.hsbc_gbm.flow;

import com.gt.projects.bdd.base.BaseFlow;
import com.gt.projects.bdd.base.config.DriverConfig;
import com.gt.projects.bdd.base.enums.Platform;
import com.gt.projects.bdd.hsbc_gbm.page.ErrorPage;
import com.gt.projects.bdd.hsbc_gbm.page.LoginPage;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Scope("thread")
public class ErrorFlow extends BaseFlow<ErrorPage> {

    @Autowired
    private ErrorPage errorPage;

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private DriverConfig driverConfig;

    protected ErrorFlow(ErrorPage currentPage) {
        super(currentPage);
    }

    public void checkGatewayTimeout(Map<String,String> map) {
        sleep(80000L);
        this.assertIsDisplayed(map);
        captureScreen();
    }

    public void tabReturnToLogOn() {
        errorPage.getMainBackBtn().click();
    }

    public void logUserOutOfTheAppWhenGatewayTimeout() {
        sleep(500L);
        if (driverConfig.getPlatform().equals(Platform.ANDROID)){
            Assert.assertTrue(loginPage.getAosGoBtn().isVisible());
        }else {
            Assert.assertTrue(loginPage.getGoBtn().isVisible());
        }
        captureScreen();
    }
}
