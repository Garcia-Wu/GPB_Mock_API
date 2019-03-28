package com.gt.projects.bdd.hsbc_gbm.flow;

import com.gt.projects.bdd.base.BaseFlow;
import com.gt.projects.bdd.base.config.DriverConfig;
import com.gt.projects.bdd.hsbc_gbm.page.GlobalOverlayPage;
import com.gt.projects.bdd.hsbc_gbm.page.LiabilitiesOverlayPage;
import com.gt.projects.bdd.hsbc_gbm.util.CheckUtil;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Scope("thread")
public class LiabilitiesOverlayFlow extends BaseFlow<LiabilitiesOverlayPage> {

    @Autowired
    private DriverConfig driverConfig;

    @Autowired
    private GlobalOverlayPage globalOverlayPage;

    @Autowired
    private GlobalOverlayFlow globalOverlayFlow;

    protected LiabilitiesOverlayFlow(LiabilitiesOverlayPage currentPage) {
        super(currentPage);
    }

    public void checkAccountTotalLiabilitiesOverlayUI(Map<String,String> map) {
        sleep(500L);
        captureScreen();
        globalOverlayFlow.assertIsDisplayed(map);
    }

    public void checkTotalLiabilitiesOverlayDataISO3() {
        sleep(500L);
        captureScreen();
        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(globalOverlayPage.getContentTxt().getContent()));
        CheckUtil.checkCurrencyISO3(globalOverlayPage.getContentTxt());
;
    }

    public void closeTotalLiabilitiesOverlay() {
        globalOverlayPage.getCloseBtn().click();
    }

    public void checkTotalLiabilitiesOverlayIsClosed() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(globalOverlayPage.getCalculatedTxt().isVisible());
        Assert.assertFalse(globalOverlayPage.getCalculatedValueTxt().isVisible());
    }

    public void tapAnywhereOnTheScreenOutsideOfTheTotalLiabilitiesOverlay() {
        sleep(400L);
        globalOverlayPage.getTitleTxt().tapXY(2,180);
    }
}
