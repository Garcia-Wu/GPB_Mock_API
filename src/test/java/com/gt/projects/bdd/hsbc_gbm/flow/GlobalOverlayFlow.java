package com.gt.projects.bdd.hsbc_gbm.flow;

import com.gt.projects.bdd.base.BaseFlow;
import com.gt.projects.bdd.hsbc_gbm.page.GlobalOverlayPage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import java.util.Map;

@Component
@Scope("thread")
public class GlobalOverlayFlow extends BaseFlow<GlobalOverlayPage> {

    protected GlobalOverlayFlow(GlobalOverlayPage currentPage) {
        super(currentPage);
    }

    public void onTheGlobalOverlay() {
        Assert.assertTrue(currentPage.getCloseBtn().isVisible());
    }

    public void checkGlobalLegalUI(Map<String,String> map) {
        sleep(500L);
        captureScreen();
        assertIsDisplayed(map);
    }

    public void tapGlobalLegalDisclaimerBackButton() {
        currentPage.getCloseBtn().click();
    }

    public void onTheDisclaimerOverlay() {
        Assert.assertTrue(currentPage.getCloseBtn().isVisible());
    }

    public void checkPerformanceAnswer(String answerValue) {
        sleep(300L);
        captureScreen();
        Assert.assertEquals(answerValue, currentPage.getCalculatedValueTxt().getContent());
    }
}
