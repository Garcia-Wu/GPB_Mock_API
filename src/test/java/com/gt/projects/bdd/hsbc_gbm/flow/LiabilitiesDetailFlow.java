package com.gt.projects.bdd.hsbc_gbm.flow;

import com.gt.projects.bdd.base.BaseFlow;
import com.gt.projects.bdd.hsbc_gbm.page.LiabilitiesDetailPage;
import com.gt.projects.bdd.hsbc_gbm.util.CheckUtil;
import org.junit.Assert;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Scope("thread")
public class LiabilitiesDetailFlow extends BaseFlow<LiabilitiesDetailPage> {

    protected LiabilitiesDetailFlow(LiabilitiesDetailPage currentPage) {
        super(currentPage);
    }

    public void onLiabilityDetailView() {
        Assert.assertTrue(currentPage.getBackBtn().isVisible());
    }

    public void checkLiabilityDetailHeaderSAMEUI(Map<String,String> map) {
        sleep(500L);
        captureScreen();
        this.assertIsDisplayed(map);
    }

    public void checkLiabilityDetailsUISAME(Map<String,String> map) {
        sleep(500L);
        captureScreen();
        this.assertIsDisplayed(map);
    }

    public void liabilityValuesAreNegative() {
        Assert.assertTrue(currentPage.getAccruedInterestAmountTxt().getContent().startsWith("-"));
        Assert.assertTrue(currentPage.getPrincipalAmountTxt().getContent().startsWith("-"));
        Assert.assertTrue(currentPage.getTotalAmountTxt().getContent().startsWith("-"));
    }

    public void checkLiabilityISO3Same() {
        sleep(500L);
        captureScreen();
        CheckUtil.checkCurrencyISO3(currentPage.getAccruedInterestAmountTxt());
        CheckUtil.checkDetailDateFormat(
                CheckUtil.getAmount(currentPage.getAccruedInterestAmountTxt().getContent())
        );

        CheckUtil.checkCurrencyISO3(currentPage.getPrincipalAmountTxt());
        CheckUtil.checkDetailDateFormat(
                CheckUtil.getAmount(currentPage.getPrincipalAmountTxt().getContent())
        );

        CheckUtil.checkCurrencyISO3(currentPage.getTotalAmountTxt());
        CheckUtil.checkDetailDateFormat(
                CheckUtil.getAmount(currentPage.getTotalAmountTxt().getContent())
        );
    }

    public void checkLiabilityISO3Different() {
        sleep(500L);
        captureScreen();
        CheckUtil.checkCurrencyISO3(currentPage.getAccruedInterestAmountTxt());
        CheckUtil.checkDetailDateFormat(
                CheckUtil.getAmount(currentPage.getAccruedInterestAmountTxt().getContent())
        );

        CheckUtil.checkCurrencyISO3(currentPage.getPrincipalAmountTxt());
        CheckUtil.checkDetailDateFormat(
                CheckUtil.getAmount(currentPage.getPrincipalAmountTxt().getContent())
        );

        CheckUtil.checkCurrencyISO3(currentPage.getTotalAmountTxt());
        CheckUtil.checkDetailDateFormat(
                CheckUtil.getAmount(currentPage.getTotalAmountTxt().getContent())
        );

        CheckUtil.checkCurrencyISO3(currentPage.getTotalBaseAmountTxt());
        CheckUtil.checkDetailDateFormat(
                CheckUtil.getAmount(currentPage.getTotalBaseAmountTxt().getContent())
        );
    }

    public void tapsBackButton() {
        currentPage.getBackBtn().click();
    }

}
