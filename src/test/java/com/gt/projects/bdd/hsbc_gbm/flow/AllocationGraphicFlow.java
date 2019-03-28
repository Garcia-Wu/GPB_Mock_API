package com.gt.projects.bdd.hsbc_gbm.flow;

import com.gt.projects.bdd.base.BaseFlow;
import com.gt.projects.bdd.base.BaseWebElement;
import com.gt.projects.bdd.base.config.DriverConfig;
import com.gt.projects.bdd.base.enums.Platform;
import com.gt.projects.bdd.base.enums.ScrollDirection;
import com.gt.projects.bdd.hsbc_gbm.page.AccountPage;
import com.gt.projects.bdd.hsbc_gbm.page.AllocationGraphicPage;
import com.gt.projects.bdd.hsbc_gbm.page.OverviewPage;
import com.gt.projects.bdd.hsbc_gbm.page.PortfoliosPage;
import com.gt.projects.bdd.hsbc_gbm.util.CheckUtil;
import com.gt.projects.bdd.hsbc_gbm.util.SleepUtil;
import com.gt.projects.bdd.hsbc_gbm.util.UserProfileUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope("thread")
public class AllocationGraphicFlow extends BaseFlow<AllocationGraphicPage> {

    @Autowired
    private DriverConfig driverConfig;

    @Autowired
    private PortfoliosPage portfoliosPage;

    @Autowired
    private OverviewPage overviewPage;

    @Autowired
    private AccountPage accountPage;

    private Map<String, String> elementState = new HashMap<>();

    protected AllocationGraphicFlow(AllocationGraphicPage currentPage) {
        super(currentPage);
    }

    public void assertIsDisplayed(Map<String, String> map){
        Map<String, BaseWebElement> elementMap = currentPage.getUniqueKeyElementsMap();
        for (String key : map.keySet()) {
            if(!key.equals("element name")){
                System.out.println("get element: "+key);
                sleep(50L);
                Assert.assertTrue("the element is not existed: " + key, elementMap.get(key).isExisted());
                if(StringUtils.isNotBlank(map.get(key))){
                    Assert.assertEquals("[" + key + "] check content fail", map.get(key).trim(), elementMap.get(key).getContent().replaceAll("\n","").trim());
                }
            }
        }
    }

    public Map<String, String> getElementState() {
        return elementState;
    }

    public void CheckGraphicWrapperUI(Map<String,String> map) {
        sleep(500L);
        captureScreen();
        this.assertIsDisplayed(map);
    }

    public void checkGraphicUI(Map<String,String> map) {
        sleep(500L);
        captureScreen();
        this.assertIsDisplayed(map);
    }

    public void checkBaseCurrencyFormat() {
        sleep(500L);
        captureScreen();
        CheckUtil.checkDataFormat(CheckUtil.getAmount(currentPage.getTotalAssertValue().getContent()));
        CheckUtil.check2dp(CheckUtil.getAmount(currentPage.getTotalAssertValue().getContent()));

        CheckUtil.checkStringISO3(currentPage.getTotalAssertCurrency().getContent());

    }

    public void checkLabelName(String name) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(name,new BaseWebElement("allocation_bar_name_label_7").getContent());

    }

    public void onOverviewAssetClassGraphicalView() {
        Assert.assertTrue(currentPage.getAccountName().isVisible());
    }

    public void tapAllocationToggle() {
        this.getAllocationToggle().click();
    }

    public void tapAllocationToggleRememberTotalAssetValue(String level) {
        String totalAsset = "";
        if (level.equals("Overview")){
            totalAsset = CheckUtil.getAmount(overviewPage.getTotalAssetsContentBtn().getContent());
        }
        else if (level.equals("Account")){
            totalAsset = CheckUtil.getAmount(accountPage.getMainTotalAssetsContentTxt().getContent());
        }
        else if (level.equals("Portfolio")){
            totalAsset = CheckUtil.getAmount(portfoliosPage.getMainTotalAssetsContentTxt().getContent());
        }

        System.out.println("totalAsset: "+totalAsset);
        elementState.put("totalAssert", totalAsset);

        this.getAllocationToggle().click();
    }

    public void tapAllocationToggleAndRememberBaseCurrency(String level) {

        String currency = "";
        if (level.equals("Overview")){
            currency = CheckUtil.getCurrency(overviewPage.getTotalAssetsContentBtn().getContent());
        }
        else if (level.equals("Account")){
            currency = CheckUtil.getCurrency(accountPage.getMainTotalAssetsContentTxt().getContent());
        }
        else if (level.equals("Portfolio")){
            currency = CheckUtil.getCurrency(portfoliosPage.getMainTotalAssetsContentTxt().getContent());
        }

        elementState.put("baceCurrency",currency);

        this.getAllocationToggle().click();
    }

    public void checkTotalValueMax(int max) {
        sleep(500L);
        captureScreen();
        String totalAssetValue = currentPage.getTotalAssertValue().getContent().replaceAll("-","");
        if(totalAssetValue.contains(" ")){
            totalAssetValue = totalAssetValue.substring(0, totalAssetValue.indexOf(" "));
        }
        Assert.assertTrue(totalAssetValue.length() <= max);
    }

    public void checkTotalAssetCurrencyFormat() {
        CheckUtil.checkStringISO3(currentPage.getTotalAssertCurrency().getContent());
    }

    public void tapOnRegionTab() {
        currentPage.getRegionBtn().click();
    }

    public void checkAccountAssetsZeroFormat() {
        sleep(500L);
        captureScreen();
        CheckUtil.check2dp(currentPage.getTotalAssertValue().getContent());
    }

    public void tapOnCurrencyTab() {
        currentPage.getCurrencyBtn().click();
    }

    public void tapAccountBackButton() {
        currentPage.getAccountAllocationBackBtn().click();
    }

    public void tapPortfolioBackButton() {
        currentPage.getPortfolioAllocationBackBtn().click();
    }

    public void totalAssetsValueEqualZero() {
        Assert.assertEquals(CheckUtil.getAmount(currentPage.getTotalAssertValue().getContent()),"0.00");
    }

    public BaseWebElement getAllocationToggle() {
        if(driverConfig.getPlatform().equals(Platform.IOS)){
            BaseWebElement allocationToggleXpath = new BaseWebElement(By.xpath("//XCUIElementTypeOther[@name=\"allocation_main_toggle_btn\"]"));
            if(allocationToggleXpath.isVisible()){
                SleepUtil.waitForElement(allocationToggleXpath);
                return allocationToggleXpath;
            }
        }
        SleepUtil.waitForElement(currentPage.getAllocationToggleBtn());
        return currentPage.getAllocationToggleBtn();
    }

    public void swipeUpAllocationGraphicPage() {
        currentPage.getAllocationBarTableView().scroll(ScrollDirection.UP,250L,1060);
    }

    public void checkCurrencyAndCopy(Map<String,String> map) {
        String message = map.get("state copy prefix")+" "+elementState.get("baceCurrency")+map.get("state copy suffix");
        Assert.assertEquals(message,currentPage.getAllocationMessage().getContent());
    }

    public void tapFirstKey() {
        elementState.put("nameLabel", currentPage.getAccountName().getContent());
        currentPage.getAllocationBarKey0().click();
    }

    public void checkTotalAssetsValueZero(String amount) {
        Assert.assertEquals(amount,currentPage.getTotalAssertValue().getContent());
    }
}
