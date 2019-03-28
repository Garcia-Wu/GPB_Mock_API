package com.gt.projects.bdd.hsbc_gbm.flow;

import com.gt.projects.bdd.base.BaseFlow;
import com.gt.projects.bdd.base.BaseWebElement;
import com.gt.projects.bdd.base.enums.ScrollDirection;
import com.gt.projects.bdd.hsbc_gbm.page.*;
import com.gt.projects.bdd.base.config.DriverConfig;
import com.gt.projects.bdd.base.enums.Platform;
import com.gt.projects.bdd.hsbc_gbm.util.*;
import cucumber.api.DataTable;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Rectangle;
import org.testng.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope("thread")
public class OverviewFlow extends BaseFlow<OverviewPage> {

    @Autowired
    private AccountPage accountPage;

    @Autowired
    private PortfoliosPage portfoliosPage;

    private Map<String, String> elementState = new HashMap<>();

    @Autowired
    private DriverConfig driverConfig;

    @Autowired
    private PerformancePage performancePage;

    @Autowired
    private AllocationHoldingListPage allocationHoldingListPage;

    @Autowired
    private ImportantPage importantPage;

    @Autowired
    private GlobalOverlayPage globalOverlayPage;

    @Autowired
    private AllocationGraphicPage allocationGraphicPage;

    @Autowired
    private GlobalOverlayFlow globalOverlayFlow;

    @Autowired
    private AllocationHoldingListFlow allocationHoldingListFlow;

    @Autowired
    private AllocationGraphicFlow allocationGraphicFlow;

    protected OverviewFlow(OverviewPage currentPage) {
        super(currentPage);
    }

    public void assertIsDisplayed(Map<String, String> map){
        Map<String, BaseWebElement> elementMap = currentPage.getUniqueKeyElementsMap();
        for (String key : map.keySet()) {
            if(!key.equals("element name")){
                System.out.println("get element: "+key);

                org.junit.Assert.assertTrue("the element is not existed: " + key, elementMap.get(key).isExisted());
                if(StringUtils.isNotBlank(map.get(key))){
                    org.junit.Assert.assertEquals("[" + key + "] check content fail", map.get(key).trim(), elementMap.get(key).getContent().replaceAll("\n","").trim());
                }
            }
        }
    }

    public void checkClassData(Map<String, String> map) {
        sleep(200L);
        captureScreen();
        if (!currentPage.getClassTotalAssetTxt0().isVisible() && driverConfig.getDeviceName().equals("E2353")) {
            currentPage.getClassListView().scroll(ScrollDirection.UP, 500L, 250);
        }
        Assert.assertTrue(currentPage.getClassTitleTxt0().isVisible());
        Assert.assertTrue(currentPage.getClassTotalAssetTxt0().isVisible());
        Assert.assertTrue(currentPage.getClassPercentageTxt0().isVisible());
    }

    public void checkClassSequence() {
        sleep(200L);
        captureScreen();
        double totalAsset0 = CheckUtil.getTotalAssetNum(currentPage.getClassTotalAssetTxt0().getContent());
        double totalAsset1 = CheckUtil.getTotalAssetNum(currentPage.getClassTotalAssetTxt1().getContent());

        BaseWebElement classListView = currentPage.getClassListView();
        classListView.scroll(ScrollDirection.UP, 2200L);
        sleep(200L);

        double totalAsset2 = CheckUtil.getTotalAssetNum(currentPage.getClassTotalAssetTxt2().getContent());
        double totalAsset3 = CheckUtil.getTotalAssetNum(currentPage.getClassTotalAssetTxt3().getContent());

        classListView.scroll(ScrollDirection.UP, 2200L);
        sleep(200L);

        double totalAsset4 = CheckUtil.getTotalAssetNum(currentPage.getClassTotalAssetTxt4().getContent());
        if (totalAsset0 >= totalAsset1 && totalAsset1 >= totalAsset2 && totalAsset2 >= totalAsset3 && totalAsset3 >= totalAsset4) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    public void tapSubAssetBtn() {
        if (currentPage.getSubClassBtnOff().isVisible()) {
            currentPage.getSubClassBtnOff().click();
        } else {
            currentPage.getSubClassBtnOn().click();
        }
    }

    public void checkUIForTapSubAssert(Map<String, String> map) {
        this.checkOverviewUI(map);
        Assert.assertTrue(currentPage.getClassListView().isDisplayed());
    }

    public void checkSubClassSequence() {
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        this.checkNumberOrderByDesc(currentPage.getClassListView(), "overview_subclass_list_tablecell_amount_label_1_", null, 0, (num-1));
    }

    public void checkAllocationToggleStatus() {
        captureScreen();
        Assert.assertTrue(currentPage.getAllocationActive().isDisplayed());
        Assert.assertTrue(currentPage.getSubClassBtnOff().isDisplayed());
        Assert.assertTrue(currentPage.getClassListView().isDisplayed());
    }

    public void seeAssetClassList() {
        Assert.assertTrue(currentPage.getClassListView().isDisplayed());
    }

    public void tapRegionTab() {
        currentPage.getMainRegionBtn().click();
    }

    public void checkRegionList() {
        Assert.assertTrue(currentPage.getRegionListView().isDisplayed());
    }

    public void checkRegionName() {
        Assert.assertTrue(currentPage.getRegionTitleTxt0().isDisplayed());
    }

    public void checkRegionTotalAssertFormat() {
        String totalAssetTxt = currentPage.getRegionTotalAssetTxt0().getContent();
        String totalAsset = CheckUtil.getAmount(totalAssetTxt);
//                totalAssetTxt.substring(0, totalAssetTxt.indexOf("GBP")).trim();
        CheckUtil.checkDataFormat(totalAsset);
        CheckUtil.check2dp(totalAsset);
    }

    public void checkRegionPercentageFormat() {
        CheckUtil.checkLastPercentage(currentPage.getRegionPercentageTxt0().getContent());
        CheckUtil.checkPercentage2dp(currentPage.getRegionPercentageTxt0().getContent());
    }

    public void checkRegionSequence() {
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        this.checkNumberOrderByDesc(currentPage.getRegionListView(), "overview_region_list_tablecell_amount_label_", null, 0, (num-1));
    }

    public void checkNotSeeRegionList() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(currentPage.getRegionListView().isVisible());
    }

    public void tapCurrencyTab() {
        currentPage.getMainCurrencyBtn().click();
    }

    public void checkAssetCurrencyList() {
        Assert.assertTrue(currentPage.getCurrencyListView().isVisible());
    }

    public void checkCurrencyName() {
        Assert.assertTrue(currentPage.getCurrencyTitleTxt0().isDisplayed());
    }

    public void checkCurrencyTotalAssertFormat() {
        String totalAsset = CheckUtil.getAmount(currentPage.getCurrencyTotalAssetTxt0().getContent());
        CheckUtil.checkDataFormat(totalAsset);
        CheckUtil.check2dp(totalAsset);
    }

    public void checkCurrencyPercentageFormat() {
        CheckUtil.checkLastPercentage(currentPage.getCurrencyPercentageTxt0().getContent());
        CheckUtil.checkPercentage2dp(currentPage.getCurrencyPercentageTxt0().getContent());
    }

    public void checkCurrencySequence() {
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        this.checkNumberOrderByDesc(currentPage.getCurrencyListView(), "overview_currency_list_tablecell_amount_label_", null, 0, (num-1));
    }

    public void overviewScreenElements() {
        sleep(400l);
        captureScreen();
        Assert.assertTrue(currentPage.getUsernameTxt().isVisible());
        Assert.assertTrue(currentPage.getCountryTxt().isVisible());
        Assert.assertTrue(currentPage.getTotalAssetsTxt().isVisible());
        Assert.assertTrue(currentPage.getTotalAssetsImg().isVisible());
        Assert.assertTrue(this.getCurrencyBtn().isVisible());
        Assert.assertTrue(currentPage.getTotalAssetsContentBtn().isVisible());
        Assert.assertTrue(currentPage.getAllocationBtnOff().isVisible());
        Assert.assertTrue(currentPage.getAccountTxt().isVisible());
        Assert.assertTrue(currentPage.getAccountListAccountIdTxt0().isVisible());
        Assert.assertTrue(currentPage.getAccountListPercentageTxt0().isVisible());
        Assert.assertTrue(currentPage.getAccountListTotalAssetsTxt0().isVisible());
        Assert.assertTrue(currentPage.getAccountListUserNameTxt0().isVisible());
    }

    public void clickAllocationButton() {

        if (currentPage.getAllocationBtnOff().isVisible()) {
            currentPage.getAllocationBtnOff().click();
        } else {
            currentPage.getAllocationBtnOn().click();
        }
        sleep(200l);
    }

    public void overviewLevelScreenElements() {
        sleep(200L);
        captureScreen();
        Assert.assertTrue(currentPage.getMainClassBtn().isDisplayed());
        Assert.assertTrue(currentPage.getMainCurrencyBtn().isDisplayed());
        Assert.assertTrue(currentPage.getMainRegionBtn().isDisplayed());
        Assert.assertTrue(currentPage.getSubClassTxt().isDisplayed());
        Assert.assertTrue(currentPage.getSubClassBtnOff().isDisplayed());
    }

    public void checkTotalAssetValueFormat() {
        sleep(200L);
        captureScreen();
        String percentage = currentPage.getClassPercentageTxt0().getContent();
        Assert.assertTrue(percentage.equals("63.83%"));
        String totalAsset = currentPage.getClassTotalAssetTxt0().getContent();
        Assert.assertTrue(totalAsset.equals("248,620,352,212.60  GBP"));
    }

    public void sortByTotalAsset() {
        sleep(200L);
        captureScreen();
        String[] split = currentPage.getClassTotalAssetTxt0().getContent().replaceAll(",", "").split("  ");
        String[] split1 = currentPage.getClassTotalAssetTxt1().getContent().replaceAll(",", "").split("  ");
        Assert.assertTrue(Double.parseDouble(split[0]) > Double.parseDouble(split1[0]));
    }

    public void noHoldingsClass(Map<String, String> map) {
        sleep(200L);
        captureScreen();
        Assert.assertEquals(map.get("class content"), currentPage.getClassUnavailableTitleTxt().getContent());
    }

    public void tapsCurrencyTab() {
        sleep(200L);
        captureScreen();
        currentPage.getMainCurrencyBtn().click();
    }

    public void noHoldingsCurrency(Map<String, String> map) {
        sleep(200L);
        captureScreen();
        Assert.assertEquals(map.get("currency content"), currentPage.getCurrencyUnavailableTitleTxt().getContent());

    }

    public void tapsRegionTab() {
        sleep(200L);
        captureScreen();
        currentPage.getMainRegionBtn().click();

    }

    public void noHoldingsRegion(Map<String, String> map) {
        sleep(200L);
        captureScreen();
        Assert.assertEquals(map.get("region content"), currentPage.getRegionUnavailableTitleTxt().getContent());
    }

    public void tapMenuBtn() {
        sleep(500L);
        currentPage.getMenuBtn().click();
    }

    public void checkNotSeeClassList() {
        sleep(300L);
        captureScreen();
        Assert.assertFalse(currentPage.getClassListView().isVisible());
    }

    public void checkAssertClassName() {
        sleep(500L);
        captureScreen();
        if (driverConfig.getPlatform().equals(Platform.ANDROID)) {
            currentPage.getClassListView().scrollToItem(currentPage.getClassTitleTxt0(), ScrollDirection.DOWN);
            Assert.assertTrue(currentPage.getClassTitleTxt0().isVisible());
        } else {
            Assert.assertTrue(currentPage.getClassTitleTxt0().isVisible());
        }
    }

    public void checkClassTotalAssertFormat() {
        String totalAssetTxt = "";
        if (driverConfig.getPlatform().equals(Platform.ANDROID)) {
            if (driverConfig.getDeviceName().equals("E2353")) {
                currentPage.getClassListView().scroll(ScrollDirection.UP, 500L, 250);
            } else {
                currentPage.getClassListView().scroll(ScrollDirection.UP, 500L, 560);
            }

            totalAssetTxt = currentPage.getClassTotalAssetTxt0().getContent();
        } else {
            totalAssetTxt = currentPage.getClassTotalAssetTxt0().getContent();
        }
        String totalAsset = CheckUtil.getAmount(totalAssetTxt);
        CheckUtil.checkDataFormat(totalAsset);
        CheckUtil.check2dp(totalAsset);
    }

    public void checkTapSubToggleActive() {
        sleep(200L);
        captureScreen();
        Assert.assertTrue(currentPage.getAllocationActive().isDisplayed());
        Assert.assertTrue(currentPage.getSubClassBtnOn().isDisplayed());
        Assert.assertTrue(currentPage.getClassListView().isDisplayed());
    }

    public void checkSubClassName() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(currentPage.getSubClassTitleTxt0().isDisplayed());
    }

    public void checkSubClassTotalAssertFormat() {
        if (!currentPage.getSubClassTotalAssetTxt0().isVisible()) {
            currentPage.getAccountListView().scrollToTopItem(currentPage.getSubClassTotalAssetTxt0());
        }
        String totalAssetTxt = currentPage.getSubClassTotalAssetTxt0().getContent();
        String totalAsset = CheckUtil.getAmount(totalAssetTxt);
        CheckUtil.checkDataFormat(totalAsset);
        CheckUtil.check2dp(totalAsset);
    }

    public void checkSubClassPercentageFormat() {
        CheckUtil.checkLastPercentage(currentPage.getSubClassPercentageTxt0().getContent());
        CheckUtil.checkPercentage2dp(currentPage.getSubClassPercentageTxt0().getContent());
    }

    public void goToPortfolioScreen() {
        sleep(500L);
        captureScreen();
        currentPage.getAllocationActive().click();
        sleep(100L);
        currentPage.getAccountList0().click();
        sleep(100L);
        accountPage.getPortfolioList0().click();
        sleep(100L);
    }

    public void backOverviewAllocationScreen() {
        portfoliosPage.getMainBackBtn().click();
        sleep(200L);
        accountPage.getMainBackBtn().click();
        sleep(200L);
        currentPage.getAllocationDefault().click();
    }

    public void checkSubClassBtnIsOn() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(currentPage.getSubClassBtnOn().isDisplayed());
    }

    public void checkNotSubClassList() {
        Assert.assertFalse(currentPage.getSubClassTitleTxt0().isVisible());
    }

    public void tapSubClassToggleToOff() {
        if (!currentPage.getSubClassBtnOn().isVisible()) {
            currentPage.getClassListView().scrollToTopItem(currentPage.getSubClassBtnOn());
        }
        currentPage.getSubClassBtnOn().click();
    }

    public void checkTapSubToggleDefault() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(currentPage.getAllocationActive().isDisplayed());
        Assert.assertTrue(currentPage.getSubClassBtnOff().isDisplayed());
        Assert.assertTrue(currentPage.getClassListView().isDisplayed());
    }

    public void checkSubClassBtnIsOff() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(currentPage.getSubClassBtnOff().isDisplayed());
    }

    public void checkAssetClassSequence() {
        sleep(500L);
        captureScreen();
        if (!currentPage.getClassTitleTxt0().isVisible()) {
            currentPage.getClassListView().scrollToTopItem(currentPage.getClassTitleTxt0());
        }
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        this.checkNumberOrderByDesc(currentPage.getClassListView(), "overview_class_list_tablecell_amount_label_", "_0", 1, num);
    }

    public void checkCurrencyStatus() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(currentPage.getAllocationActive().isDisplayed());
        Assert.assertTrue(currentPage.getCurrencyListView().isDisplayed());
    }

    public void checkRegionStatus() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(currentPage.getAllocationActive().isDisplayed());
        Assert.assertTrue(currentPage.getRegionListView().isDisplayed());
    }

    public void currencyScrollDownToBottom() {
        currentPage.getCurrencyListView().scrollToItem(currentPage.getCurrencyTotalAssetTxt7(), ScrollDirection.UP);
        currentPage.getCurrencyListView().scroll(ScrollDirection.UP, 2000L);
    }

    public void checkOtherLabel(String otherLabel) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(otherLabel, currentPage.getCurrencyTitleTxt7().getContent());
    }

    public void checkOtherTotalAssertFormat() {
        String totalAsset = CheckUtil.getAmount(currentPage.getCurrencyTotalAssetTxt7().getContent());
        CheckUtil.checkDataFormat(totalAsset);
        CheckUtil.check2dp(totalAsset);
    }

    public void checkOtherPercentageFormat() {
        CheckUtil.checkLastPercentage(currentPage.getCurrencyPercentageTxt7().getContent());
        CheckUtil.checkPercentage2dp(currentPage.getCurrencyPercentageTxt7().getContent());
    }

    public void checkOtherSeat() {
        int otherY = currentPage.getCurrencyTitleTxt7().getRect().getY();
        currentPage.getCurrencyListView().scroll(ScrollDirection.UP, 2000L);
        int newOtherY = currentPage.getCurrencyTitleTxt7().getRect().getY();
        Assert.assertEquals(otherY, newOtherY);
    }

    public void checkNotCurrencyList() {
        Assert.assertFalse(currentPage.getCurrencyListView().isVisible());
    }

    public void checkSeeAccountList() {
        if (!currentPage.getUsernameTxt().isVisible()) {
            if (accountPage.getMainBackBtn().isVisible()) {
                accountPage.getMainBackBtn().click();
            } else if (globalOverlayPage.getCloseBtn().isVisible()) {
                globalOverlayPage.getCloseBtn().click();
            }
        }
        Assert.assertTrue(currentPage.getUsernameTxt().isVisible());
    }

    public void checkInHoldingPage() {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getHoldingBackBtn().isVisible());
    }

    public void checkClassList() {
        Assert.assertTrue(currentPage.getClassListView().isExisted());
    }

    public void clickHoldingBackBtn() {
        currentPage.getHoldingBackBtn().click();
    }

    public void tapFirstSubClass() {
        if (!currentPage.getSubClassTitleTxt0().isVisible()) {
            if (driverConfig.getDeviceName().equals("E2353")) {
                currentPage.getClassListView().scroll(ScrollDirection.UP, 500L, 250);
            } else {
                currentPage.getClassListView().scrollToItem(currentPage.getSubClassTitleTxt0(), ScrollDirection.UP);
            }
        }
        currentPage.getSubClassTitleTxt0().click();
    }

    public void slidesTo2NdItem() {
        currentPage.getAccountListView().scrollToItem(getAccountList(1), ScrollDirection.UP);
    }

    public void taps2ThItemOfAccountsList() {
        getAccountList(1).click();
    }

    public void see6ThItemAndSortOfAdjacentIsVisible() {
        sleep(200L);
        captureScreen();
        Assert.assertTrue(getAccountList(4).isVisible());
        Assert.assertTrue(getAccountList(5).isVisible());
    }

    public void seeTheLastItemAndSortOfAdjacentIsVisible() {
        sleep(200L);
        captureScreen();
        Assert.assertTrue(getAccountList(14).isVisible());
        Assert.assertTrue(getAccountList(15).isVisible());
    }

    public void tap3ThItemOfAccountsList() {
        currentPage.getAccountListView().scrollToItem(getAccountList(2), ScrollDirection.UP);
        getAccountList(2).click();
    }

    public void tapAccountsList15() {
        currentPage.getAccountListView().scrollToItem(getAccountList(14), ScrollDirection.UP);
        getAccountList(14).click();
    }

    public void tapAccountsList16() {
        sleep(500L);
        currentPage.getAccountListView().scrollToItem(getAccountList(15), ScrollDirection.UP);
        getAccountList(15).click();
    }

    public void tapFirstRegion() {
        currentPage.getRegionTitleTxt0().click();
    }

    public void tapFirstCurrency() {
        currentPage.getCurrencyTitleTxt0().click();
    }

    public void checkAccountListFormat() {
        String[] totalAmount = getDateList(currentPage.getAccountListView(), "accountListTotalAssetsTxt", 0);
        for (int i = 0; i < totalAmount.length; i++) {
            CheckUtil.check2dp(totalAmount[i]);
        }
    }

    public void checkAccountListOrder() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        checkNumberOrderByDesc(currentPage.getAccountListView(), "overview_account_list_tablecell_amount_label_", null, 0, (num-1));
    }

    public void tapOverviewTotalAssets() {
        sleep(300L);
        elementState.put("total asset amount",currentPage.getTotalAssetsContentBtn().getContent());
        currentPage.getTotalAssetsContentBtn().click();
    }

    public void checkOverviewOverlayDisplayed() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(globalOverlayPage.getCalculatedTxt().isVisible());
        Assert.assertTrue(globalOverlayPage.getCalculatedValueTxt().isVisible());
        Assert.assertTrue(globalOverlayPage.getCloseBtn().isVisible());
        Assert.assertTrue(globalOverlayPage.getTitleTxt().isVisible());
        Assert.assertTrue(globalOverlayPage.getContentTxt().isVisible());
    }

    public void closeOverlayInOverviewLevel() {
        sleep(300L);
        globalOverlayPage.getCloseBtn().click();
    }

    public void checkOverviewTotalAssetFormat() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(CheckUtil.getAmount(currentPage.getTotalAssetsContentBtn().getContent()).replace("-","").length() <= 18);
    }

    public void checkOverviewTotalAssetISO3() {
        sleep(500L);
        captureScreen();
        CheckUtil.checkDataFormat(currentPage.getTotalAssetsContentBtn().getContent());
        CheckUtil.checkCurrencyISO3(currentPage.getTotalAssetsContentBtn());
    }

    public void checkOverviewTotalAsset2dp() {
        sleep(500L);
        captureScreen();
        CheckUtil.check2dp(CheckUtil.getAmount(currentPage.getTotalAssetsContentBtn().getContent()));
    }

    public void overviewTotalAssetValueEquals() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        String[] accountListTotalAssetsTxt = getDateList(currentPage.getAccountListView(), "accountListTotalAssetsTxt", (num-1));
        Double value = 0.00;
        for (int i = 0; i < accountListTotalAssetsTxt.length; i++) {
            value = value + Double.valueOf(CheckUtil.getAmount(accountListTotalAssetsTxt[i].replace(",", "")));
        }

        Assert.assertTrue(value.doubleValue()==Double.valueOf(CheckUtil.getAmount(currentPage.getTotalAssetsContentBtn().getContent()).replace(",", "")));
    }

    public void checkOverviewTotalAssetsZero() {
        sleep(500L);
        captureScreen();
        String totalAssetsValue = CheckUtil.getAmount(currentPage.getTotalAssetsContentBtn().getContent());
        CheckUtil.check2dp(totalAssetsValue);
        Assert.assertEquals("0.00", totalAssetsValue);
    }

    public void checkOverviewOverlayFormat() {
        sleep(500L);
        captureScreen();
        CheckUtil.check2dp(CheckUtil.getAmount(globalOverlayPage.getContentTxt().getContent()));
    }

    public void checkOverviewOverlayIOS3() {
        sleep(500L);
        captureScreen();
        CheckUtil.checkDataFormat(globalOverlayPage.getContentTxt().getContent());
    }

    public void checkOverviewTotalAssetsOverlayClosed() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(globalOverlayPage.getCalculatedTxt().isVisible());
        Assert.assertFalse(globalOverlayPage.getCalculatedValueTxt().isVisible());
        Assert.assertFalse(globalOverlayPage.getContentTxt().isVisible());
    }

    public void tapOverviewOverlayOutside() {
        sleep(300L);
        if (driverConfig.getPlatform().equals(Platform.IOS)) {
            globalOverlayPage.getTitleTxt().tapXY(50, 50);
        } else {
            globalOverlayPage.getTitleTxt().tapXY(180, 180);
        }
    }

    public void checkOverviewVersionUI(DataTable dataTable) {
        sleep(500L);
        captureScreen();
        if (!globalOverlayPage.getCloseBtn().isVisible()) {
            Assert.assertTrue(currentPage.getTotalAssetsImg().isExisted());
        }
        assertIsDisplayed(RegionUtil.getMap(dataTable));
    }

    public void checkOverviewUI(Map<String, String> map) {
        sleep(500L);
        captureScreen();
        if (!globalOverlayPage.getCloseBtn().isVisible()) {
            Assert.assertTrue(currentPage.getTotalAssetsImg().isExisted());
        }
        if(map.containsKey("Allocation Toggle")){
            Assert.assertTrue(allocationGraphicFlow.getAllocationToggle().isExisted());
        }
        assertIsDisplayed(map,"Allocation Toggle");
    }

    public void tapCurrencyConversion() {
//        this.getCurrencyBtn().click();
        currentPage.getGbpBtn().click();
    }

    public void tap3RDAccount() {
        currentPage.getAccountListView().scrollToItem(getAccountList(2), ScrollDirection.UP);
        getAccountList(2).click();
    }

    public void checkSubClassOrder() {
        sleep(500L);
        captureScreen();
        if (!currentPage.getSubClassTxt().isVisible()) {
            currentPage.getClassListView().scrollToTopItem(currentPage.getSubClassTxt());
        }
        this.checkNumberOrderByDesc(currentPage.getClassListView(), "overview_subclass_list_tablecell_amount_label_1_", null, 0, 2);
        this.checkNumberOrderByDesc(currentPage.getClassListView(), "overview_subclass_list_tablecell_amount_label_2_", null, 0, 1);
        this.checkNumberOrderByDesc(currentPage.getClassListView(), "overview_subclass_list_tablecell_amount_label_3_", null, 0, 0);
        this.checkNumberOrderByDesc(currentPage.getClassListView(), "overview_subclass_list_tablecell_amount_label_4_", null, 0, 1);
        this.checkNumberOrderByDesc(currentPage.getClassListView(), "overview_subclass_list_tablecell_amount_label_5_", null, 0, 2);
    }

    public BaseWebElement getCurrencyBtn() {
        if (driverConfig.getPlatform().equals(Platform.ANDROID)) {
            return currentPage.getGbpBtn();
        } else {
            return currentPage.getIosGbpBtn();
        }
    }

    public void checkAccountListTWRRNegative() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement weight = new BaseWebElement("overview_account_list_tablecell_weight_label_" + (num-1));
        currentPage.getAccountListView().scrollToItem(weight, ScrollDirection.UP);
        if(driverConfig.getPlatform().equals(Platform.ANDROID)){
            Assert.assertTrue(currentPage.getElementById("overview_account_list_tablecell_arrow_Img_" + (num-1)).isExisted());
        }
        Assert.assertTrue(weight.getContent().startsWith("-"));
    }

    public void checkAccountListTWRRPositive() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement weight = new BaseWebElement("overview_account_list_tablecell_weight_label_" + (num-1));
        currentPage.getAccountListView().scrollToItem(weight, ScrollDirection.UP);
        if(driverConfig.getPlatform().equals(Platform.ANDROID)){
            Assert.assertTrue(currentPage.getElementById("overview_account_list_tablecell_arrow_Img_" + (num-1)).isExisted());
        }
        Assert.assertFalse(weight.getContent().startsWith("-"));
    }

    public void checkAccountListTWRRFormat() {
        sleep(500L);
        captureScreen();
        int totalNum = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        if (!currentPage.getAccountList0().isVisible()){
            currentPage.getAccountListView().scrollToTopItem(currentPage.getAccountList0());
        }
        String[] twrr = this.getDateListByObjectId(currentPage.getAccountListView(), "overview_account_list_tablecell_weight_label_", null, (totalNum - 1));
        for (int i = 0; i < twrr.length; i++) {

            CheckUtil.check2dp(
                    CheckUtil.getAmount(twrr[i])
            );
        }
    }

    public void checkAccountListFigureZero() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement percentage = currentPage.getElementById("overview_account_list_tablecell_weight_label_" + (num - 1));
        currentPage.getAccountListView().scrollToItem(percentage, ScrollDirection.UP);
        Assert.assertEquals(percentage.getContent().trim(), "0.00%");
    }

    public void checkAccountListNoSymbolAndNoChevron() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement percentage = currentPage.getElementById("overview_account_list_tablecell_weight_label_" + (num - 1));
        currentPage.getClassListView().scrollToItem(percentage, ScrollDirection.UP);
        if(driverConfig.getPlatform().equals(Platform.ANDROID)){
            Assert.assertFalse(currentPage.getElementById("overview_account_list_tablecell_arrow_Img_" + (num-1)).isExisted());
        }
        Assert.assertFalse(percentage.getContent().startsWith("+"));
        Assert.assertFalse(percentage.getContent().startsWith("-"));
    }

    public void checkOverviewPerformanceUI(Map<String, String> map, int num) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(map.get("Performance label"), performancePage.getMainOverViewContent().getContent());
        Assert.assertTrue(performancePage.getMainOverViewIcon().isExisted());
        if (num == 1) {
            Assert.assertTrue(performancePage.getMainOverViewAmount().getContent().startsWith("+"));
        } else if (num == 2) {
            Assert.assertTrue(performancePage.getMainOverViewAmount().getContent().startsWith("-"));
        }

        Assert.assertTrue(performancePage.getMainOverViewAmount().isVisible());
    }

    public void checkOverviewPerformanceCurrencyISO3() {
        sleep(500L);
        captureScreen();
        String performance = performancePage.getMainOverViewAmount().getContent();
        CheckUtil.checkStringISO3(
                CheckUtil.getCurrency(performance)
        );

        CheckUtil.checkWrapperPerformanceISO3Format(
                CheckUtil.getAmount(performance)
        );

    }

    public void checkOverviewPerformanceValue2dp() {
        sleep(500L);
        captureScreen();
        CheckUtil.check2dp(
                CheckUtil.getAmount(performancePage.getMainOverViewAmount().getContent())
        );
    }

    public void checkOverviewPerformanceValueZero() {
        Assert.assertEquals(CheckUtil.getAmount(performancePage.getMainOverViewAmount().getContent()), "0.00");
    }

    public void checkOverviewPerformanceValueNoSymbol() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(performancePage.getMainOverViewAmount().getContent().startsWith("-"));
        Assert.assertFalse(performancePage.getMainOverViewAmount().getContent().startsWith("+"));
    }

    public void tapOverviewPerformance() {
        elementState.put("performanceValue", performancePage.getMainOverViewAmount().getContent());
        performancePage.getMainOverViewContent().click();
    }

    public void onTheOverviewPerformanceOverlay() {
        Assert.assertTrue(globalOverlayPage.getCloseBtn().isVisible());
    }

    public void checkOverviewPerformanceOverlayUI(Map<String, String> map, int num) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(map.get("Performance YTD label"), globalOverlayPage.getTitleTxt().getContent());
        Assert.assertTrue(globalOverlayPage.getNameTxt().isVisible());
        Assert.assertEquals(map.get("Profit/loss label"), globalOverlayPage.getHeadingTxt().getContent());
        Assert.assertTrue(globalOverlayPage.getContentTxt().isVisible());
        if (num == 1) {
            Assert.assertTrue(globalOverlayPage.getContentTxt().getContent().startsWith("+")
            );
        } else if (num == 2) {
            Assert.assertTrue(globalOverlayPage.getContentTxt().getContent().startsWith("-")
            );
        }

        Assert.assertTrue(globalOverlayPage.getCloseBtn().isVisible());
        Assert.assertEquals(map.get("overlay question"), globalOverlayPage.getCalculatedTxt().getContent());
        Assert.assertEquals(map.get("overlay answer"), globalOverlayPage.getCalculatedValueTxt().getContent());
    }

    public void checkPerformanceOverlayAmount2dp() {
        sleep(500L);
        captureScreen();
        CheckUtil.check2dp(
                CheckUtil.getAmount(globalOverlayPage.getContentTxt().getContent())
        );
    }

    public void checkPerformanceOverlayAmountISO3() {
        sleep(100L);
        captureScreen();
        CheckUtil.checkWrapperPerformanceISO3Format(globalOverlayPage.getContentTxt().getContent());
    }

    public void checkOverviewPerformanceOverlayAmountZero() {
        Assert.assertEquals("0.00", CheckUtil.getAmount(globalOverlayPage.getContentTxt().getContent()));
    }

    public void checkPerformanceAmountNoSymbol() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(globalOverlayPage.getContentTxt().getContent().startsWith("+"));
        Assert.assertFalse(globalOverlayPage.getContentTxt().getContent().startsWith("-"));

    }

    public void checkWelcomeMessage(String message) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(message, currentPage.getCountryTxt().getContent());
    }

    public void tapsCloseOverlay() {
        globalOverlayPage.getCloseBtn().click();
    }

    public void checkOverviewPerformanceOverlayClosed() {
        sleep(500L);
        captureScreen();
//        Assert.assertFalse(globalOverlayPage.getOverLayPercentage().isVisible());
//        Assert.assertFalse(globalOverlayPage.getOverLayAmount().isVisible());
        Assert.assertFalse(globalOverlayPage.getNameTxt().isVisible());
//        Assert.assertFalse(globalOverlayPage.getOverLayCalculatedValue().isVisible());
//        Assert.assertFalse(globalOverlayPage.getOverLayCalculated().isVisible());
        Assert.assertFalse(globalOverlayPage.getTitleTxt().isVisible());
    }

    public void tapsAnywhereOverviewPerformanceOverlay() {
        sleep(300L);
        if (driverConfig.getPlatform().equals(Platform.IOS)) {
            globalOverlayPage.getTitleTxt().tapXY(80, 80);
        } else {
            globalOverlayPage.getTitleTxt().tapXY(3, 180);
        }
    }

    public void onTheAllocationHoldingList() {
        Assert.assertTrue(allocationHoldingListPage.getBackBtn().isVisible());
    }

    public void checkAssetClassHoldingWrapperUI(Map<String, String> map) {
        sleep(500L);
        captureScreen();
        if (driverConfig.getPlatform().equals(Platform.ANDROID)) {
            Assert.assertTrue(allocationHoldingListPage.getAmountCurrency().isExisted());
        }
        Assert.assertTrue(allocationHoldingListPage.getCurrencyBtn().isExisted());
        CheckUtil.checkAllocationHoldingUI(map, allocationHoldingListPage);
    }

    public void checkOverviewHoldingWrapperGBPISO3() {
        sleep(500L);
        captureScreen();
        CheckUtil.checkDataFormat(
                allocationHoldingListPage.getAmountNumber().getContent()
        );

        if (driverConfig.getPlatform().equals(Platform.IOS)) {
            CheckUtil.checkDataFormat(
                    allocationHoldingListPage.getAmountNumber().getContent()
            );

        } else {

            CheckUtil.checkDataFormat(
                    allocationHoldingListPage.getAmountCurrency().getContent()
            );
        }
    }

    public void checkOverviewGlobalLegalDisclaimer(String region,String disclaimer) {
        sleep(500L);
        captureScreen();
        if (!currentPage.getAccountListFootView().isVisible()) {
            currentPage.getAccountListView().scrollToBottomItem(currentPage.getAccountListFootView());
        }

        Assert.assertEquals(RegionUtil.getValue(region, disclaimer), currentPage.getAccountListFootView().getContent());
    }

    public void tapsLinkToGlobalLegalDisclaimer() {

        int x = currentPage.getAccountListFootView().getRect().getX();
        int y = currentPage.getAccountListFootView().getRect().getY();
        int width = currentPage.getAccountListFootView().getRect().getWidth();
        int height = currentPage.getAccountListFootView().getRect().getHeight();

        x = x + width * 9 / 10;
        y = y + height / 2;
        currentPage.getAccountListFootView().tapXY(x, y);
    }

//    public void checkGlobalLegalDisclaimerText(Map<String, String> map) {
//        sleep(500L);
//        captureScreen();
//        Assert.assertEquals(map.get("disclaimer"), globalOverlayPage.getCalculatedValueTxt().getContent().replaceAll("\n", ""));
//    }

    public void checkLegalDisclaimerScreen() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(currentPage.getAccountListFootView().isVisible());
    }

    public void checkAllocationHoldingsList() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(allocationHoldingListPage.getBackBtn().isVisible());
        Assert.assertTrue(allocationHoldingListPage.getAmountNumber().isVisible());
        Assert.assertTrue(allocationHoldingListPage.getMenuBtn().isVisible());
        Assert.assertTrue(allocationHoldingListPage.getTableTitle().isVisible());
        Assert.assertTrue(allocationHoldingListPage.getTitleTxt().isVisible());
        Assert.assertTrue(allocationHoldingListPage.getTableView().isVisible());
    }

    public void tapAnyWhereGlobalLegalDisclaimer() {
        if (driverConfig.getPlatform().equals(Platform.IOS)) {
            importantPage.getMainBG().tapXY(80, 80);
        } else {
            importantPage.getMainContent().tapXY(3, 280);
        }
    }

    public void checkOverviewAllocationHoldingsPositiveAndDIFFERENT() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        allocationHoldingListPage.getTableView().scrollToItem( new BaseWebElement("allocation_holding_list_tablecell_report_amount_label_1_" + (num-1)), ScrollDirection.UP);
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_title_label_1_" + (num-1)).isVisible());
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num-1)).isVisible());
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_weight_label_1_" + (num-1)).isVisible());
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_arrow_img_1_" + (num-1)).isExisted());
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_report_amount_label_1_" + (num-1)).isVisible());

    }

    public void checkOverviewAllocationHoldingsPositiveAndDIFFERENTISO3() {
        sleep(500L);
        captureScreen();

        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement holdingBaseAmount = new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num-1));
        BaseWebElement holdingReportAmount = new BaseWebElement("allocation_holding_list_tablecell_report_amount_label_1_" + (num-1));
        allocationHoldingListPage.getTableView().scrollToItem(holdingReportAmount, ScrollDirection.UP);

        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(holdingBaseAmount.getContent())
        );

        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(holdingReportAmount.getContent())
        );
    }

    public void checkOverviewAllocationHoldingsNegativeAndDIFFERENT() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        allocationHoldingListPage.getTableView().scrollToItem( new BaseWebElement("allocation_holding_list_tablecell_report_amount_label_1_" + (num-1)), ScrollDirection.UP);
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_title_label_1_" + (num-1)).isVisible());
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num-1)).isVisible());
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_weight_label_1_" + (num-1)).isVisible());
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_arrow_img_1_" + (num-1)).isExisted());
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_report_amount_label_1_" + (num-1)).isVisible());
    }

    public void checkOverviewAllocationHoldingsNegativeAndDIFFERENTISO3() {
        sleep(500L);
        captureScreen();

        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement holdingBaseAmount = new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num-1));
        BaseWebElement holdingReportAmount = new BaseWebElement("allocation_holding_list_tablecell_report_amount_label_1_" + (num-1));
        allocationHoldingListPage.getTableView().scrollToItem(holdingReportAmount, ScrollDirection.UP);

        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(holdingBaseAmount.getContent())
        );

        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(holdingReportAmount.getContent())
        );
    }

    public void checkOverviewAllocationHoldingsPositiveAndSAME() {
        sleep(500L);
        captureScreen();
        allocationHoldingListPage.getTableView().scrollToItem(allocationHoldingListFlow.getHoldingBaseAmount(1), ScrollDirection.UP);
        Assert.assertTrue(allocationHoldingListFlow.getHoldingNameTxt(1).isVisible());
        Assert.assertTrue(allocationHoldingListFlow.getHoldingBaseAmount(1).isVisible());
        Assert.assertTrue(allocationHoldingListFlow.getHoldingPercentage(1).isVisible());
        Assert.assertTrue(allocationHoldingListFlow.getHoldingImg(1).isExisted());
    }

    public void checkOverviewAllocationHoldingPositiveAndSAME() {
        sleep(500L);
        captureScreen();

        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement holdingBaseAmount = new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num-1));
        allocationHoldingListPage.getTableView().scrollToItem(holdingBaseAmount, ScrollDirection.DOWN);
        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(holdingBaseAmount.getContent())
        );
    }

    public void checkOverviewAllocationHoldingsNegativeAndSAME() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        allocationHoldingListPage.getTableView().scrollToItem( new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num-1)), ScrollDirection.UP);
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_title_label_1_" + (num-1)).isVisible());
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num-1)).isVisible());
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_weight_label_1_" + (num-1)).isVisible());
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_arrow_img_1_" + (num-1)).isExisted());

    }

    public void checkOverviewAllocationHoldingNegativeAndSAMEISO3() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement holdingBaseAmount = new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num-1));
        allocationHoldingListPage.getTableView().scrollToItem(holdingBaseAmount, ScrollDirection.UP);

        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(holdingBaseAmount.getContent())
        );
    }

    public void checkOverviewAllocationHoldingsNOTRelevantAndDIFFERENT() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        allocationHoldingListPage.getTableView().scrollToItem( new BaseWebElement("allocation_holding_list_tablecell_report_amount_label_1_" + (num-1)), ScrollDirection.UP);
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_title_label_1_" + (num-1)).isVisible());
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num-1)).isVisible());
//        Assert.assertFalse(new BaseWebElement("allocation_holding_list_tablecell_weight_label_1_" + (num-1)).isVisible());
//        Assert.assertFalse(new BaseWebElement("allocation_holding_list_tablecell_arrow_img_1_" + (num-1)).isExisted());
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_report_amount_label_1_" + (num-1)).isVisible());

    }

    public void checkOverviewAllocationHoldingNOTRelevantAndDIFFERENTISO3() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        allocationHoldingListPage.getTableView().scrollToItem( new BaseWebElement("allocation_holding_list_tablecell_report_amount_label_1_" + (num-1)), ScrollDirection.DOWN);
        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num-1)).getContent())
        );

        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(new BaseWebElement("allocation_holding_list_tablecell_report_amount_label_1_" + (num-1)).getContent())
        );
    }

    public void tapOverviewAllocationHoldingList(int num) {
        String allocationHoldingsList = "allocation_holdings_list_tableview_cell_1_";
        BaseWebElement holdingsListElement = new BaseWebElement(allocationHoldingsList+(num-1));

        allocationHoldingListPage.getTableView().scrollToItem(holdingsListElement,ScrollDirection.UP);
        holdingsListElement.click();
    }

    public void checkOverviewReferenceCurrency(String region, String referenceCurrency) {
        sleep(300L);
        captureScreen();
        Assert.assertEquals(RegionUtil.getValue(region, referenceCurrency), CheckUtil.getAmountCurrency(currentPage.getTotalAssetsContentBtn()));
    }

    public void checkTotalAssetISO3() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkDataFormat(currentPage.getTotalAssetsContentBtn().getContent());
        CheckUtil.checkCurrencyISO3(currentPage.getTotalAssetsContentBtn());
    }

    public void tapOnHoldingListCurrencyConversionIcon() {
        Rectangle rectangle = allocationHoldingListPage.getCurrencyBtn().getRect();
        allocationHoldingListPage.getCurrencyBtn().tapXY(rectangle.getX(),rectangle.getY());
        //allocationHoldingListPage.getCurrencyBtn().click();
    }

    public void checkOverviewLiabilitiesUI(Map<String,String> map) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(map.get("header \"Total liabilities\""),currentPage.getMainLiabilitesTitleTxt().getContent());
        Assert.assertTrue(currentPage.getMainLiabilitesIconImg().isExisted());
        Assert.assertTrue(currentPage.getMainLiabilitesAmountBtn().isVisible());
    }

    public void checkOverviewLiabilitiesCharactersMax() {
        sleep(500L);
        captureScreen();
        String amount = currentPage.getMainLiabilitesAmountBtn().getContent().trim();
        if(amount.indexOf(" ") != -1){
            amount = amount.substring(0, amount.indexOf(" ")).trim();
        }
        Assert.assertTrue(amount.length() <= 17);
    }

    public void checkLiabilitiesISO3() {
        sleep(500L);
        captureScreen();
        CheckUtil.checkCurrencyISO3(currentPage.getMainLiabilitesAmountBtn());
        CheckUtil.checkDataFormat(currentPage.getMainLiabilitesAmountBtn().getContent());
    }

    public void checkInAllocation() {
        Assert.assertTrue(currentPage.getAllocationBtnOn().isVisible());
    }

    public void minifilesWrapper() {
        currentPage.getAccountListView().scroll(ScrollDirection.UP, 1000L, 500);
    }

    public void checkMinifilesWapperUI() {
        sleep(500L);
        captureScreen();
//        Assert.assertFalse(currentPage.getUsernameTxt().isVisible());
        Assert.assertFalse(currentPage.getCountryTxt().isVisible());
        Assert.assertFalse(currentPage.getUpdateDateTxt().isVisible());
        Assert.assertFalse(currentPage.getMainLiabilitesTitleTxt().isVisible());
        Assert.assertFalse(currentPage.getMainLiabilitesAmountBtn().isVisible());
        Assert.assertFalse(currentPage.getMainNetTitleTxt().isVisible());
        Assert.assertFalse(currentPage.getMainNetAmountTxt().isVisible());
    }

    public void checkNameAndTotal() {
        Assert.assertTrue(currentPage.getUsernameTxt().isVisible());
        Assert.assertTrue(currentPage.getTotalAssetsContentBtn().isVisible());
        Assert.assertTrue(currentPage.getTotalAssetsTxt().isVisible());
    }

    public void notSeeLiabilities() {
        sleep(300L);
        captureScreen();
        Assert.assertFalse(currentPage.getMainLiabilitesTitleTxt().isVisible());
        Assert.assertFalse(currentPage.getMainLiabilitesAmountBtn().isVisible());
    }

    public void checkTotalLiabilitiesValue(String value) {
        sleep(300L);
        captureScreen();
        Assert.assertEquals(value, CheckUtil.getAmount(currentPage.getMainLiabilitesAmountBtn().getContent()));
    }

    public void notSeeLiabilitiesAndNet() {
        sleep(300L);
        captureScreen();
        Assert.assertFalse(currentPage.getMainLiabilitesTitleTxt().isVisible());
        Assert.assertFalse(currentPage.getMainNetTitleTxt().isVisible());
    }

    public void tapOverviewTotalLiabilitiesOverlay() {
        currentPage.getMainLiabilitesTitleTxt().click();
    }

    public void checkSeeClassAndCurrency() {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getMainClassBtn().isVisible());
        Assert.assertTrue(currentPage.getMainCurrencyBtn().isVisible());
    }

    public void checkNotSeeRegion() {
        Assert.assertFalse(currentPage.getMainRegionBtn().isExisted());
    }

    public void checkOverviewNetAssetsUI(Map<String,String> map) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(map.get("header \"Net assets\""),currentPage.getMainNetTitleTxt().getContent());
        Assert.assertTrue(currentPage.getMainNetAmountTxt().isVisible());
    }

    public void checkNetAssetsMax(int maxNumber) {
        sleep(500L);
        captureScreen();
        String amount = currentPage.getMainNetAmountTxt().getContent().trim();
        if(amount.indexOf(" ") != -1){
            amount = amount.substring(0, amount.indexOf(" ")).trim();
        }
        Assert.assertTrue(amount.length() <= maxNumber);
    }

    public void checkOverviewNetAssetsISO3() {
        sleep(500L);
        captureScreen();
        CheckUtil.checkCurrencyISO3(currentPage.getMainNetAmountTxt());
        CheckUtil.checkDataFormat(currentPage.getMainNetAmountTxt().getContent());
    }

    public void checkNetAssetsEqualTotalAssetsReductionOfTotalLiabilities() {
        sleep(500L);
        captureScreen();
        Double amount = CheckUtil.getNoISOAmount(currentPage.getTotalAssetsContentBtn().getContent())+CheckUtil.getNoISOAmount(currentPage.getMainLiabilitesAmountBtn().getContent());
        Assert.assertTrue(amount==CheckUtil.getNoISOAmount(currentPage.getMainNetAmountTxt().getContent()));
    }

    public void checkNotNetAssets() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(currentPage.getMainNetTitleTxt().isVisible());
        Assert.assertFalse(currentPage.getMainNetAmountTxt().isVisible());
    }

    public void checkOverviewNetAssets(String value) {
        sleep(300L);
        captureScreen();
        Assert.assertEquals(value, CheckUtil.getAmount(currentPage.getMainNetAmountTxt().getContent()));
    }

    public void checkAccountListNotPerformance() {
        sleep(300L);
        captureScreen();
        Integer maxNumber = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        String accountTitlePrefix = "overview_account_list_tablecell_username_label_";
        String accountPerformancePrefix = "overview_account_list_tablecell_weight_label_";
        for (int i = 0; i < maxNumber; i++){
            BaseWebElement title = new BaseWebElement(accountTitlePrefix + i);
            currentPage.getAccountListView().scrollToItem(title, ScrollDirection.UP);
            Assert.assertFalse(new BaseWebElement(accountPerformancePrefix + i).isVisible());
        }
    }

    public void onOverviewAllocationScreen() {
        Assert.assertTrue(currentPage.getAllocationBtnOn().isVisible());
    }

    public void tapShowSubClassToON() {
        if (!currentPage.getSubClassBtnOff().isVisible()) {
            currentPage.getClassListView().scrollToTopItem(currentPage.getSubClassBtnOff());
        }
        sleep(500L);
        currentPage.getSubClassBtnOff().click();
    }

    public void checkNotSeePerformance() {
        sleep(300L);
        captureScreen();
        Assert.assertFalse(performancePage.getMainOverViewContent().isVisible());
    }

    public void clickAccountByNum(Integer accountNum) {
        BaseWebElement account = currentPage.getElementById("overview_main_account_tableview_cell_"+(accountNum-1));
        currentPage.getAccountListView().scrollToItem(account, ScrollDirection.UP);
        account.click();
    }

    public void checkOverviewPerformanceOverlayValue() {
        sleep(300L);
        captureScreen();
        Assert.assertEquals(elementState.get("performanceValue"), globalOverlayPage.getContentTxt().getContent().trim());
    }

    public void checkOverviewTotalAssetsEqualOverviewTotalAssetsOverlay() {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(elementState.get("total asset amount"),globalOverlayPage.getContentTxt().getContent().trim());
    }

    public void checkNoAccountMessage(String message) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(message, currentPage.getNoAccountMessage().getContent());
    }

    public void checkNoPerformance() {
        sleep(300L);
        captureScreen();
        Assert.assertFalse(performancePage.getMainOverViewContent().isVisible());
        Assert.assertFalse(performancePage.getMainOverViewIcon().isVisible());
        Assert.assertFalse(performancePage.getMainOverViewAmount().isVisible());
    }

    public void checkAccountItemNoPerformance() {
        sleep(300L);
        captureScreen();
        UserProfile userProfile = UserProfileUtil.getCurrentUserProfile();
        Assert.assertFalse(currentPage.getElementById("overview_account_list_tablecell_weight_label_"+(userProfile.getFinalListNum() - 1)).isVisible());
    }

    public void checkOverviewPage() {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getTotalAssetsContentBtn().isVisible());
    }

    public void checkOverviewWrapperIsMaximised() {
        Assert.assertTrue(currentPage.getCountryTxt().isVisible());
    }

    public void checkTotalAssetEqualsOverviewAssetAllocationTotalAsset() {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(allocationGraphicPage.getTotalAssertValue().getContent(),elementState.get("totalAssert"));
    }

    public BaseWebElement getAccountList(int index) {
        return currentPage.getElementById("overview_main_account_tableview_cell_" + index);
    }

    public BaseWebElement getAccountListAccountIdTxt(int index) {
        return currentPage.getElementById("overview_account_list_tablecell_code_label_" + index);
    }

    public BaseWebElement getAccountListUserNameTxt(int index) {
        return currentPage.getElementById("overview_account_list_tablecell_username_label_" + index);
    }

    public void theOverviewWrapperIsMinifiles() {
        currentPage.getAccountListView().scroll(ScrollDirection.UP,250L,500);
    }

    public void checkOverviewWrapperMinifiles() {
        Assert.assertFalse(currentPage.getCountryTxt().isVisible());
    }


    public void tapSpecificItemOfAccountsList() {
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement accountList = currentPage.getElementById("overview_main_account_tableview_cell_" + (num - 1));
        accountList.click();

    }
}
