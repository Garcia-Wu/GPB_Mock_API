package com.gt.projects.bdd.hsbc_gbm.flow;

import com.gt.projects.bdd.base.BaseFlow;
import com.gt.projects.bdd.base.BaseWebElement;
import com.gt.projects.bdd.base.config.DriverConfig;
import com.gt.projects.bdd.base.enums.Platform;
import com.gt.projects.bdd.base.enums.ScrollDirection;
import com.gt.projects.bdd.hsbc_gbm.page.CurrencyConversionPage;
import com.gt.projects.bdd.hsbc_gbm.util.CheckUtil;
import com.gt.projects.bdd.hsbc_gbm.util.RegionUtil;
import com.gt.projects.bdd.hsbc_gbm.util.UserProfileUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Scope("thread")
public class CurrencyConversionFlow extends BaseFlow<CurrencyConversionPage> {

    @Autowired
    private DriverConfig driverConfig;

    public static final int CURRENCY = 1;
    public static final int RATE = 2;

    protected CurrencyConversionFlow(CurrencyConversionPage currentPage) {
        super(currentPage);
    }

    @Override
    public void assertIsDisplayed(Map<String, String> map) {
        Map<String, BaseWebElement> elementMap = currentPage.getUniqueKeyElementsMap();
        for (String key : map.keySet()) {
            if (!key.equals("element name")) {
                System.out.println("get element: " + key);
                Assert.assertTrue("the element is not existed: " + key, elementMap.get(key).isExisted());
                if (StringUtils.isNotBlank(map.get(key))) {
                    Assert.assertEquals("[" + key + "] check content fail", map.get(key), elementMap.get(key).getContent().replaceAll("\n", ""));
                }
            }
        }
    }

    private List<String> getCurrencyList(int type, int maxIndex) {
        List<String> list = new ArrayList<>();
        String currencyPrefix = "currency_conversion_currency_label_";
        String ratePrefix = "currency_conversion_rate_label_";
        for (int i = 0; i < maxIndex; i++) {
            BaseWebElement baseWebElement = null;
            if (type == CURRENCY) {
                baseWebElement = new BaseWebElement(currencyPrefix + i);
            } else if (type == RATE) {
                baseWebElement = new BaseWebElement(ratePrefix + i);
            }
            list.add(baseWebElement.getContent());
        }
        return list;
    }

    public void checkConversationOverlayUI(Map<String, String> map) {
        sleep(300L);
        captureScreen();
        this.assertIsDisplayed(map);
    }

    public void checkConversionList() {
        String flagImgPrefix = "currency_conversion_flag_img_";
        String currencyPrefix = "currency_conversion_currency_label_";
        String ratePrefix = "currency_conversion_rate_label_";
        Map<String, BaseWebElement> baseWebElements = new HashMap<>();
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        for (int i = 0; i < num; i++) {
            BaseWebElement flagImg = new BaseWebElement(flagImgPrefix + i);
            BaseWebElement currency = new BaseWebElement(currencyPrefix + i);
            BaseWebElement rate = new BaseWebElement(ratePrefix + i);
            baseWebElements.put(flagImgPrefix + i, flagImg);
            baseWebElements.put(currencyPrefix + i, currency);
            baseWebElements.put(ratePrefix + i, rate);
        }

        for (String elementId : baseWebElements.keySet()) {
            Assert.assertTrue("The element not existed: " + elementId, baseWebElements.get(elementId).isExisted());
        }
    }

    public void checkNotGBP() {
        String currencyPrefix = "currency_conversion_currency_label_";
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        for (int i = 0; i < num; i++) {
            BaseWebElement currency = new BaseWebElement(currencyPrefix + i);
            if ("GBP".equals(currency.getContent().trim())) {
                Assert.assertTrue("The currency list is GBP: " + currency.getContent(), false);
            }
        }
    }

    public void viewConversationOverlay() {
        Assert.assertTrue(currentPage.getCloseBtn().isExisted());
        Assert.assertTrue(currentPage.getTitleTxt().isExisted());
    }

    public void checkCurrency4DP() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        List<String> rateList = this.getCurrencyList(RATE, num - 1);
        for (String rate : rateList) {
            CheckUtil.checkNumber4DP(rate);
        }
    }

    public void checkCurrencyOrder() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        List<String> currencyList = this.getCurrencyList(CURRENCY, num - 1);
        for (int i = 0; i < currencyList.size() - 1; i++) {
            Assert.assertTrue("currency order error! item is [" + currencyList.get(i) + "] and [" + currencyList.get(i + 1) + "]", currencyList.get(i).compareTo(currencyList.get(i + 1)) < 0);
        }
    }

    public void checkCurrencyISO(boolean hasCurrencyList) {
        sleep(500L);
        captureScreen();
        CheckUtil.checkStringISO3(currentPage.getBaseCurrency().getContent());
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        if (hasCurrencyList) {
            List<String> currencyList = this.getCurrencyList(CURRENCY, num - 1);
            for (String currency : currencyList) {
                CheckUtil.checkStringISO3(currency);
            }
        }
    }

    public void tapCloseButton() {
        currentPage.getCloseBtn().click();
    }

    public void checkOverlayClose() {
        sleep(200L);
        captureScreen();
        Assert.assertFalse(currentPage.getCloseBtn().isVisible());
        Assert.assertFalse(currentPage.getTitleTxt().isVisible());
    }

    public void checkNotRetrievableMessage(Map<String, String> map) {
        sleep(300L);
        captureScreen();
        String content1 = currentPage.getWrongMsgTxt().getContent();
        String content2 = currentPage.getWrongRelationshipTxt().getContent();
        Assert.assertEquals(map.get("wrong message text"), content1 + content2);
        this.assertIsDisplayed(map, "wrong message text");

    }

    public void checkNoCurrencyMessage(Map<String, String> map) {
        sleep(300L);
        captureScreen();
        this.assertIsDisplayed(map);
    }

    public void checkDisclaimerMessage(Map<String, String> map) {
        sleep(200L);
        captureScreen();
        if (!currentPage.getInformTxt().isVisible()) {
            currentPage.getTableView().scroll(ScrollDirection.UP, 1000L, 1000);
        }
        Assert.assertEquals(map.get("disclaimer Message"), currentPage.getInformTxt().getContent());
    }

    public void checkDateFormat() {
        sleep(200L);
        captureScreen();
        if (!currentPage.getUpdateDate().isVisible()) {
            currentPage.getTableView().scroll(ScrollDirection.UP, 1000L, 1000);
        }
        String date = currentPage.getUpdateDate().getContent();
        if (driverConfig.getPlatform().equals(Platform.IOS)) {
            date = date.substring(date.indexOf(": ") + 2, date.indexOf(" GMT"));

        } else {
            date = date.substring(date.indexOf(": ") + 2, date.indexOf("  GMT"));
        }
        CheckUtil.checkCurrencyDateFormat(date);
    }


    public void checkCurrencyDisclaimer(Map<String, String> map) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(map.get("disclaimer"), currentPage.getInformTxt().getContent());
    }

    public void checkOverviewCurrencyHeaderTitle(String headerTitle) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(headerTitle, currentPage.getTitleTxt().getContent());
    }
}
