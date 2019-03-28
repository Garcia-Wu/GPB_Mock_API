package com.gt.projects.bdd.hsbc_gbm.flow;


import com.gt.projects.bdd.base.BaseFlow;
import com.gt.projects.bdd.base.BaseWebElement;
import com.gt.projects.bdd.base.enums.ScrollDirection;
import com.gt.projects.bdd.base.config.DriverConfig;
import com.gt.projects.bdd.base.enums.Platform;
import com.gt.projects.bdd.hsbc_gbm.page.*;
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
public class AccountsFlow extends BaseFlow<AccountPage> {

    @Autowired
    private PortfoliosPage portfoliosPage;

    @Autowired
    private OverviewPage overviewPage;

    @Autowired
    private DriverConfig driverConfig;

    @Autowired
    private PerformancePage performancePage;

    @Autowired
    private LiabilitiesOverlayPage liabilitiesOverlayPage;

    @Autowired
    private AllocationHoldingListPage allocationHoldingListPage;

    @Autowired
    private GlobalOverlayPage globalOverlayPage;

    @Autowired
    private GlobalOverlayFlow globalOverlayFlow;

    @Autowired
    private OverviewFlow overviewFlow;

    @Autowired
    private AllocationHoldingListFlow allocationHoldingListFlow;

    @Autowired
    private AllocationGraphicFlow allocationGraphicFlow;

    protected AccountsFlow(AccountPage currentPage) {
        super(currentPage);
    }

    private Map<String, String> elementState = new HashMap<>();

    public BaseWebElement getPortfolioList(int index) {
        return currentPage.getElementById("portfolio_main_portfolio_tableview_cell_" + index);
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

    public void tapsPortfoliosList0() {
        sleep(1000L);
        if (!getPortfolioList(0).isVisible()) {
            if (portfoliosPage.getMainBackBtn().isVisible()) {
                portfoliosPage.getMainBackBtn().click();
            } else {
                currentPage.getPortfolioListView().scrollToTopItem(getPortfolioList(0));
            }
        }
        String id0 = currentPage.getPortfolioListID0().getContent();
        elementState.put("portfolioList0 id", id0.substring(id0.indexOf(" ") + 1));
        getPortfolioList(0).click();
    }

    public void tapsPortfoliosList1() {
        sleep(1000L);
        currentPage.getPortfolioListView().scrollToItem(getPortfolioList(1), ScrollDirection.UP);
        getPortfolioList(1).click();
    }

    public void checkPortfolios0IdVisible() {
        sleep(200L);
        captureScreen();
        Assert.assertEquals(portfoliosPage.getMainPortfolioIdTxt().getContent(), elementState.get("portfolioList0 id").replace("Fund","").replace(" ",""));
    }

    public void checkPortfolioList0IsVisible() {
        sleep(200L);
        captureScreen();
        Assert.assertTrue(getPortfolioList(0).isVisible());
    }

    public void tapDefaultAccountsAllocationToggle() {
        currentPage.getMainAllocationBtn().click();
        sleep(200l);
        captureScreen();
    }

    public void tapAccountsAllocationToggle() {
        if (currentPage.getAllocationBtnOff().isVisible()) {
            currentPage.getAllocationBtnOff().click();
        } else {
            currentPage.getAllocationBtnOn().click();
        }
//        if(driverConfig.getPlatform().equals(Platform.ANDROID)){
//            if(currentPage.getAllocationBtnOff().isVisible()){
//                currentPage.getAllocationBtnOff().click();
//            } else {
//                currentPage.getAllocationBtnOn().click();
//            }
//        } else {
//            currentPage.getMainAllocationBtn().click();
//        }
        sleep(200l);

    }

    public void noHoldingsClass(Map<String, String> map) {
        sleep(200L);
        captureScreen();
        Assert.assertEquals(map.get("class content"), currentPage.getClassUnavailableTitleTxt().getContent());

    }

    public void noHoldingsCurrency(Map<String, String> map) {
        sleep(200L);
        captureScreen();
        Assert.assertEquals(map.get("currency content"), currentPage.getCurrencyUnavailableTitleTxt().getContent());
    }

    public void allocationScreenAndTapAllocationToggle() {

    }

    public void tapAllocationCurrencyTab() {
        currentPage.getMainCurrencyBtn().click();
        sleep(200L);
        captureScreen();
    }

    public void tapAllocationRegionTab() {
        currentPage.getMainRegionBtn().click();
        sleep(200l);
        captureScreen();
    }

    public void noRegion(Map<String, String> map) {
        sleep(200l);
        captureScreen();
        Assert.assertEquals(map.get("region content"), currentPage.getRegionUnavailableTitleTxt().getContent());
    }

    public void tapPortfoliosListFirst() {
        currentPage.getPortfolioTitleTxt0().click();
        sleep(200l);
        captureScreen();
    }

    public void checkAccountsLeveVersion(DataTable dataTable) {
        if (currentPage.getMainTotalAssetsImg().isExisted()) {
            Assert.assertTrue(currentPage.getMainTotalAssetsImg().isExisted());
        }
        if (currentPage.getMainTotalAssetsImg().isExisted()) {
            Assert.assertTrue(currentPage.getMainTotalAssetsImg().isExisted());
        }
        this.assertIsDisplayed(RegionUtil.getMap(dataTable));
    }

    public void checkDifferentAssetClass() {
        Assert.assertTrue(currentPage.getMainClassListView().isExisted());
    }

    public void classButtonByDefault() {
        Assert.assertTrue(currentPage.getMainAllocationActiveBtn().isExisted());
        Assert.assertTrue(currentPage.getMainClassListView().isExisted());
    }

    public void checkFirstItemClassListFormat() {
        while (true) {
            currentPage.getMainClassListView().scroll(ScrollDirection.DOWN, 2000L);
            sleep(200L);
            if (currentPage.getClassTitleTxt0().isDisplayed()) {
                break;
            }
        }

        Assert.assertTrue(currentPage.getClassTitleTxt0().isDisplayed());
        if (!currentPage.getClassPercentageTxt0().isVisible() && driverConfig.getDeviceName().equals("E2353")) {
            currentPage.getMainClassListView().scroll(ScrollDirection.UP, 500L, 250);
        }
        String[] split = currentPage.getClassTotalAssetTxt0().getContent().split(" ");
        CheckUtil.check2dp(split[0]);
        CheckUtil.checkPercentage2dp(currentPage.getClassPercentageTxt0().getContent());

    }

    public void assetClassesOrdered() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        this.checkNumberOrderByDesc(currentPage.getMainClassListView(), "account_class_list_tablecell_amount_label_", "_0", 1, num);
    }

    public void notAssetClassList() {
        Assert.assertFalse(currentPage.getMainClassListView().isExisted());
    }

    public void tapRegionButton() {
        currentPage.getMainRegionBtn().click();
    }

    public void checkElementsOnAccountsRegion(Map<String, String> map) {
        this.assertIsDisplayed(map);
    }

    public void checkDifferentRegionList(Map<String, String> map) {

        currentPage.getMainRegionListView().scroll(ScrollDirection.UP, 2000L, 300);
        Assert.assertTrue(currentPage.getRegionTitleTxt0().getContent().equals(map.get("Region Title name zero")));
        Assert.assertTrue(currentPage.getRegionTitleTxt1().getContent().equals(map.get("Region Title name first")));
        Assert.assertTrue(currentPage.getRegionTitleTxt2().getContent().equals(map.get("Region Title name two")));
        currentPage.getMainRegionListView().scroll(ScrollDirection.UP, 2000L, 300);
        Assert.assertTrue(currentPage.getRegionTitleTxt3().getContent().equals(map.get("Region Title name three")));
        Assert.assertTrue(currentPage.getRegionTitleTxt4().getContent().equals(map.get("Region Title name four")));
        Assert.assertTrue(currentPage.getRegionTitleTxt5().getContent().equals(map.get("Region Title name five")));
    }


    public void checkDifferentRegionList() {
        sleep(500L);
        Assert.assertTrue(currentPage.getMainRegionListView().isVisible());
        captureScreen();
    }

    public void checkRegionActive() {
        Assert.assertTrue(currentPage.getMainRegionListView().isDisplayed());
    }

    public void checkFirstItemRegionFormat() {
        Assert.assertTrue(currentPage.getRegionTitleTxt0().isDisplayed());
        String content = currentPage.getRegionTotalAssetTxt0().getContent();

        CheckUtil.check2dp(CheckUtil.getAmount(content));
        CheckUtil.checkPercentage2dp(currentPage.getRegionPercentageTxt0().getContent());
    }

    public void scrollToFirstOfRegionList() {
        while (true) {
            currentPage.getMainRegionListView().scroll(ScrollDirection.DOWN, 2000L);
            sleep(200L);
            if (currentPage.getRegionTitleTxt0().isDisplayed()) {
                break;
            }
        }
    }

    public void orderedRegionsList() {
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        this.checkNumberOrderByDesc(currentPage.getMainRegionListView(), "account_region_list_tablecell_amount_label_", null, 0, (num - 1));

//        if (driverConfig.getDeviceName().equals("E2353")){
//            currentPage.getMainRegionListView().scroll(ScrollDirection.UP,500L,250);
//
//        }else if (driverConfig.getPlatform().equals(Platform.IOS)){
//            currentPage.getMainRegionListView().scroll(ScrollDirection.UP, 500L, 500);
//        }else {
//            currentPage.getMainRegionListView().scroll(ScrollDirection.UP, 500L, 600);
//        }
//        Double totalAsset0 = CheckUtil.getTotalAssetNum(currentPage.getRegionTotalAssetTxt0().getContent());
//        Double totalAsset1 = CheckUtil.getTotalAssetNum(currentPage.getRegionTotalAssetTxt1().getContent());
//
//        if (driverConfig.getDeviceName().equals("E2353")){
//            currentPage.getMainRegionListView().scroll(ScrollDirection.UP,500L,250);
//        }else if (driverConfig.getPlatform().equals(Platform.IOS)){
//            currentPage.getMainRegionListView().scroll(ScrollDirection.UP, 500L, 500);
//        }else {
//            currentPage.getMainRegionListView().scroll(ScrollDirection.UP, 500L, 600);
//        }
//
//        Double totalAsset2 = CheckUtil.getTotalAssetNum(currentPage.getRegionTotalAssetTxt2().getContent());
//
//        if (driverConfig.getDeviceName().equals("E2353")){
//            currentPage.getMainRegionListView().scroll(ScrollDirection.UP,500L,250);
//
//        }else if (driverConfig.getPlatform().equals(Platform.IOS)){
//            currentPage.getMainRegionListView().scroll(ScrollDirection.UP, 500L, 500);
//        }else {
//            currentPage.getMainRegionListView().scroll(ScrollDirection.UP, 500L, 600);
//        }
//
//        Double totalAsset3 = CheckUtil.getTotalAssetNum(currentPage.getRegionTotalAssetTxt3().getContent());
//        Double totalAsset4 = CheckUtil.getTotalAssetNum(currentPage.getRegionTotalAssetTxt4().getContent());
//
//        if (totalAsset0>=totalAsset1 && totalAsset1>=totalAsset2 &&
//                totalAsset2>=totalAsset3 && totalAsset3>=totalAsset4) {
//            Assert.assertTrue(true);
//        }else {
//            Assert.assertTrue(false);
//        }

    }

    public void noRegionListOfAccounts() {
        Assert.assertFalse(currentPage.getMainRegionListView().isExisted());
    }

    public void tapSubAssetClassToggle() {
        if (currentPage.getSubClassOnBtn().isVisible())
            currentPage.getSubClassOnBtn().click();

        else if (currentPage.getSubClassOffBtn().isVisible())
            currentPage.getSubClassOffBtn().click();
    }

    public void checkSubAssetClassList() {

        Assert.assertTrue(currentPage.getMainClassListView().isExisted());
    }

    public void checkAllocationClassSubClassStatus() {
        Assert.assertTrue(currentPage.getMainAllocationActiveBtn().isExisted());
        Assert.assertTrue(currentPage.getMainClassListView().isExisted());
        Assert.assertTrue(currentPage.getSubClassOnBtn().isDisplayed());
    }


    public void checkFirstTableCellItemSubClassFormat() {
        currentPage.getMainClassListView().scrollToItem(currentPage.getSubClassTableCellTitle0(), ScrollDirection.UP);
        Assert.assertTrue(currentPage.getSubClassTableCellTitle0().isExisted());
        currentPage.getMainClassListView().scrollToItem(currentPage.getSubClassTableCellAmount2(), ScrollDirection.UP);
        Assert.assertTrue(CheckUtil.check2dpCurrency(currentPage.getSubClassTableCellAmount2().getContent()));

    }

    public void checkFirstItemSubClassFormat() {

        currentPage.getMainClassListView().scrollToItem(currentPage.getSubClassTitleTxt0(), ScrollDirection.DOWN);
        Assert.assertTrue(currentPage.getSubClassTitleTxt0().isExisted());
        Assert.assertTrue(CheckUtil.check2dpCurrency(currentPage.getSubClassTotalAssetTxt0().getContent()));
        CheckUtil.checkPercentage2dp(currentPage.getSubClassPercentageTxt0().getContent());
    }

    public void subAssetOrdered() {
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        this.checkNumberOrderByDesc(currentPage.getMainClassListView(), "account_subclass_list_tablecell_amount_label_1_", null, 0, (num - 1));
//        this.checkNumberOrderByDesc(currentPage.getMainClassListView(),"account_subclass_list_tablecell_amount_label_2_",null,0,1);
    }

    public void tapBackButton() {
        currentPage.getMainBackBtn().click();
    }

    public void checkSubAssetClassState() {
        if (currentPage.getSubClassOnBtn().isVisible()) {
            Assert.assertTrue(currentPage.getSubClassOnBtn().isVisible());
        } else {
            Assert.assertTrue(currentPage.getSubClassOffBtn().isVisible());
        }
    }

    public void tapBackButtonPortfoliosLevel() {
        portfoliosPage.getMainBackBtn().click();
    }

    public void tapOnSubAssetClass() {
        if (currentPage.getSubClassOffBtn().isVisible()) {
            currentPage.getSubClassOffBtn().click();
        } else {
            currentPage.getSubClassOnBtn().click();
        }

    }

    public void checkSubAssetClassOff() {
        Assert.assertTrue(currentPage.getSubClassOffBtn().isExisted());
    }

    public void checkClassList() {
        if (!currentPage.getClassTotalAssetTxt0().isVisible() && driverConfig.getDeviceName().equals("E2353")) {
            currentPage.getMainClassListView().scroll(ScrollDirection.UP, 500L, 250);
        }
        if (driverConfig.getPlatform().equals(Platform.IOS)) {
            Assert.assertTrue(currentPage.getClassTitleTxt0().isVisible());
            Assert.assertTrue(CheckUtil.check2dpCurrency(currentPage.getClassTotalAssetTxt0().getContent()));
            CheckUtil.checkDataFormat(currentPage.getClassTotalAssetTxt0().getContent());
        } else {
            Assert.assertTrue(currentPage.getSubclassHeadTitleTxt0().isVisible());
            Assert.assertTrue(CheckUtil.check2dpCurrency(currentPage.getSubclassCurrency0().getContent()));
            CheckUtil.checkDataFormat(currentPage.getSubclassCurrency0().getContent());
        }


    }

    public void tapCurrencyBtn() {
        currentPage.getMainCurrencyBtn().click();
    }

    public void checkAllocationAndCurrencyState() {
        Assert.assertTrue(currentPage.getMainAllocationActiveBtn().isExisted());
        Assert.assertTrue(currentPage.getMainCurrencyListView().isExisted());
    }

    public void checkFirstItemCurrencyListFormat() {
        Assert.assertTrue(currentPage.getCurrencyTitleTxt0().isExisted());
        CheckUtil.checkDataFormat(currentPage.getCurrencyTotalAssetTxt0().getContent());
        System.out.println("con:" + currentPage.getCurrencyTotalAssetTxt0().getContent());
        String currencyTotalAsset = currentPage.getCurrencyTotalAssetTxt0().getContent();
        if (currentPage.getCurrencyTotalAssetTxt0().getContent().contains(" ")) {
            Assert.assertTrue(CheckUtil.check2dpCurrency(currencyTotalAsset.substring(0, currencyTotalAsset.indexOf(" "))));
        } else {
            Assert.assertTrue(CheckUtil.check2dpCurrency(currencyTotalAsset));
        }

        CheckUtil.checkPercentage2dp(currentPage.getCurrencyPercentageTxt0().getContent());
    }

    public void orderedByCurrencyList() {
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        this.checkNumberOrderByDesc(currentPage.getMainCurrencyListView(), "account_currency_list_tablecell_amount_label_", null, 0, (num - 1));
    }

    public void checkMoreCurrencyState() {
        Assert.assertTrue(currentPage.getMainAllocationActiveBtn().isExisted());
        Assert.assertTrue(currentPage.getMainCurrencyListView().isExisted());
        currentPage.getMainCurrencyListView().scrollToItem(currentPage.getCurrencyTitleTxt7(), ScrollDirection.UP);
        Assert.assertTrue(currentPage.getCurrencyTitleTxt7().getContent().equals("Other"));
    }

    public void checkOtherCurrencyElement(Map<String, String> map) {
        if (!currentPage.getCurrencyTotalAssetTxt7().isVisible()) {
            currentPage.getMainCurrencyListView().scrollToBottomItem(currentPage.getCurrencyTotalAssetTxt7());
        }
        Assert.assertTrue(currentPage.getCurrencyTitleTxt7().getContent().equals(map.get("Other label")));
        CheckUtil.checkDataFormat(currentPage.getCurrencyTotalAssetTxt7().getContent());
        Assert.assertTrue(CheckUtil.check2dpCurrency(currentPage.getCurrencyTotalAssetTxt7().getContent()));
        CheckUtil.checkPercentage2dp(currentPage.getCurrencyPercentageTxt7().getContent());
    }

    public void scrollDownOnAccountsCurrency() {
        currentPage.getMainCurrencyListView().scrollToItem(currentPage.getCurrencyTitleTxt7(), ScrollDirection.UP);
    }

    public void checkOtherDown() {

        System.out.println("con:" + currentPage.getCurrencyTotalAssetTxt6().getContent());
        Double totalAsset6 = CheckUtil.getTotalAssetNum(currentPage.getCurrencyTotalAssetTxt6().getContent());
        Double totalAsset7 = CheckUtil.getTotalAssetNum(currentPage.getCurrencyTotalAssetTxt7().getContent());
        Assert.assertTrue(totalAsset7 >= totalAsset6);

    }

    public void notCurrencyList() {
        Assert.assertFalse(currentPage.getMainCurrencyListView().isExisted());
    }

    public void tapFirstItemAccountsList() {
        sleep(500L);
        if (!overviewPage.getAccountListAccountIdTxt0().isVisible()) {
            overviewPage.getAccountListView().scrollToTopItem(overviewPage.getAccountListAccountIdTxt0());
        }
        elementState.put("accountId", overviewPage.getAccountListAccountIdTxt0().getContent());
        overviewPage.getAccountList0().click();
        sleep(1000L);
    }

    public void tap17thItemAccountsList() {
        if (!overviewFlow.getAccountList(16).isVisible()) {
            overviewPage.getAccountListView().scrollToBottomItem(overviewFlow.getAccountList(16));
        }
        overviewFlow.getAccountList(16).click();
    }

    public void checkOneAccountItem() {
        sleep(200L);
        captureScreen();
        Assert.assertEquals(elementState.get("accountId"), currentPage.getMainUserIdTxt().getContent());
    }

    public void checkNotAccountPips() {
        Assert.assertFalse(currentPage.getMainPips().isVisible());
    }

    public void checkNotScrollAccountPips() {
        currentPage.getMainTopView().scroll(ScrollDirection.LEFT, 2000L);
        sleep(200L);
        Assert.assertEquals(elementState.get("accountId"), currentPage.getMainUserIdTxt().getContent());
        currentPage.getMainTopView().scroll(ScrollDirection.RIGHT, 2000L);
        sleep(200L);
        Assert.assertEquals(elementState.get("accountId"), currentPage.getMainUserIdTxt().getContent());
    }

    public void backTwoScroll() {
        currentPage.getMainTopView().scroll(ScrollDirection.RIGHT, 2000L);
        currentPage.getMainTopView().scroll(ScrollDirection.RIGHT, 2000L);
    }

    public void scrollAndTapAllocation() {
        currentPage.getMainAllocationActiveBtn().click();
        currentPage.getMainTopView().scroll(ScrollDirection.RIGHT, 2000L);
    }

    public void tapFourItemAccountsList() {
        sleep(1000L);
        overviewPage.getAccountListView().scrollToItem(overviewFlow.getAccountList(3), ScrollDirection.UP);
        overviewFlow.getAccountList(3).click();
        sleep(1000L);
    }

    public void tapsPortfoliosListLast() {
        currentPage.getPortfolioListView().scrollToBottomItem(getPortfolioList(15));
        getPortfolioList(15).click();
        sleep(2000L);
    }

    public void tapsPortfoliosList0AndScroll() {
        currentPage.getPortfolioListView().scroll(ScrollDirection.UP, 2000L, 300);
        getPortfolioList(0).click();
        sleep(1000L);
    }

    public void tapsPortfoliosListFifteen() {
        currentPage.getPortfolioListView().scrollToItem(getPortfolioList(14), ScrollDirection.UP);
        getPortfolioList(14).click();
        sleep(2000L);
    }

    public void secondSlidesTo6ThPip() {

        for (int i = 2; i < 6; i++) {
            currentPage.getMainTopView().scroll(ScrollDirection.LEFT, 200L);
        }

    }

    public void backToTheAccountList() {
        currentPage.getMainBackBtn().click();
    }

    public void slideToRight() {
        currentPage.getMainTopView().scroll(ScrollDirection.RIGHT, 200L);
    }

    public void slideToLeft() {
        currentPage.getMainTopView().scroll(ScrollDirection.LEFT, 200L);
    }

    public void tapsTotalAssetsValue3() {
        currentPage.getElementById("account_class_list_tablecell_amount_label_3_0").click();
    }

    public void seeOverlayRelatingToThatItem() {
        Assert.assertTrue(globalOverlayPage.getContentTxt().isVisible());
    }

    public void seeTheAccountLevel() {
        if (!currentPage.getMainBackBtn().isVisible() && portfoliosPage.getMainBackBtn().isVisible()) {
            portfoliosPage.getMainBackBtn().click();
        }
        Assert.assertTrue(currentPage.getMainBackBtn().isExisted());
    }

//    public void seeAccount() {
//        Assert.assertTrue(getPortfolioList(0).isVisible());
//    }

    public void tapPortfoliosList3() {
        sleep(300L);
        if (!getPortfolioList(2).isVisible()) {
            currentPage.getPortfolioListView().scrollToItem(getPortfolioList(2), ScrollDirection.UP);
        }
        getPortfolioList(2).click();
    }

    public void checkPortfolioListVisible() {
        currentPage.getPortfolioListView().scrollToItem(getPortfolioList(1), ScrollDirection.UP);
        Assert.assertTrue(getPortfolioList(0).isVisible());
        Assert.assertTrue(getPortfolioList(1).isVisible());
    }

    public void checkPortfolioListVisible13() {
        currentPage.getPortfolioListView().scrollToItem(getPortfolioList(12), ScrollDirection.UP);
        Assert.assertTrue(getPortfolioList(12).isVisible());
    }


    public void checkNotSwipeLeftOrRight() {
        sleep(500L);
        elementState.put("account0 id", currentPage.getMainUserIdTxt().getContent());

//        currentPage.getMainTopView().scroll(ScrollDirection.RIGHT,1500L);
//        if (!currentPage.getMainUserIdTxt().getContent().equals(elementState.get("account0 id")))
//            Assert.assertTrue(false);

        currentPage.getMainTotalAssetsContentTxt().scroll(ScrollDirection.LEFT, 1500L);
        Assert.assertTrue(currentPage.getMainUserIdTxt().getContent().equals(elementState.get("account0 id")));

        captureScreen();
    }

    public void tapsPortfolioList2() {
        currentPage.getPortfolioListView().scrollToItem(getPortfolioList(1), ScrollDirection.UP);
        getPortfolioList(1).click();
    }

    public void tapsPortfoliosList3() {
        currentPage.getPortfolioListView().scrollToItem(getPortfolioList(2), ScrollDirection.UP);
        getPortfolioList(2).click();
    }

    public void tapLastItemAccountsList() {
        overviewPage.getAccountListView().scrollToBottomItem(overviewFlow.getAccountList(15));
        overviewFlow.getAccountList(15).click();
    }

    public void swipePipsFrom1StToLast() {
        Integer lastNum = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        for (int i = 1; i < lastNum; i++) {
            currentPage.getMainTotalAssetsContentTxt().scroll(ScrollDirection.LEFT, 500L);
        }
        sleep(300L);
        captureScreen();
    }

    public void pipLeftLargestSize(int largestSize) {
        for (int i = 0; i < largestSize; i++)
            currentPage.getMainTotalAssetsContentTxt().scroll(ScrollDirection.LEFT, 500L);

        sleep(500L);

    }

    public void TapAccountRegionTab() {
        currentPage.getMainRegionBtn().click();
    }


    public void checkSubAssetClassToggleIsON() {
        Assert.assertTrue(currentPage.getSubClassOnBtn().isVisible());
    }

    public void checkNoSubClass() {
        Assert.assertFalse(currentPage.getSubClassTxt().isVisible());
        sleep(300L);
        captureScreen();
    }

    public void accountSwipeLeft(String tab) {
        sleep(1500L);
        int num = 0;
        if ("Class".equals(tab)) {
            if (!currentPage.getClassPercentageTxt0().isVisible() && driverConfig.getDeviceName().equals("E2353")) {
                currentPage.getMainClassListView().scroll(ScrollDirection.UP, 500L, 250);
            }
            elementState.put("ClassTitleTxt0", currentPage.getClassTitleTxt0().getContent());
            elementState.put("ClassPercentageTxt0", currentPage.getClassPercentageTxt0().getContent());
            elementState.put("ClassTotalAssetTxt0", currentPage.getClassTotalAssetTxt0().getContent());
            num = 1;

        } else if ("Currency".equals(tab)) {
            if (!currentPage.getCurrencyPercentageTxt0().isVisible() && driverConfig.getDeviceName().equals("E2353")) {
                currentPage.getMainCurrencyListView().scroll(ScrollDirection.UP, 500L, 250);
            }
//            elementState.put("CurrencyTitleTxt0", currentPage.getCurrencyTitleTxt0().getContent());
            elementState.put("CurrencyPercentageTxt0", currentPage.getCurrencyTotalAssetTxt0().getContent());
            elementState.put("CurrencyTotalAssetTxt0", currentPage.getCurrencyPercentageTxt0().getContent());
            sleep(200L);
            num = 1;

        } else if ("Region".equals(tab)) {
            if (!currentPage.getRegionPercentageTxt0().isVisible() && driverConfig.getDeviceName().equals("E2353")) {
                currentPage.getMainRegionListView().scroll(ScrollDirection.UP, 500L, 250);
            }
            elementState.put("RegionTitleTxt0", currentPage.getRegionTitleTxt0().getContent());
            elementState.put("RegionPercentageTxt0", currentPage.getRegionPercentageTxt0().getContent());
            elementState.put("RegionTotalAssetTxt0", currentPage.getRegionTotalAssetTxt0().getContent());
            num = 1;

        } else if ("Account".equals(tab)) {
            elementState.put("PortfolioListID0", currentPage.getPortfolioListID0().getContent());
            sleep(200L);
            num = 1;

        } else if ("Wrapper".equals(tab)) {
            elementState.put("MainUserIdTxt", currentPage.getMainUserIdTxt().getContent());
            elementState.put("MainTotalAssetsContentTxt", currentPage.getMainTotalAssetsContentTxt().getContent());
            elementState.put("getMainUsernameTxt", currentPage.getMainUsernameTxt().getContent());
            num = 1;
        } else if ("Total Assets".equals(tab)) {
            num = 1;
            elementState.put("MainUserIdTxt", currentPage.getMainTotalAssetsContentTxt().getContent());
        }

        for (int i = 0; i < num; i++) {
            currentPage.getMainTotalAssetsContentTxt().scroll(ScrollDirection.LEFT, 500L);
        }

    }


    public void checkAccountClassData0() {
        sleep(1500L);
        if (currentPage.getMainClassListView().isVisible()) {
            Assert.assertNotEquals(elementState.get("ClassTitleTxt0"), currentPage.getClassTitleTxt0().getContent());
            Assert.assertNotEquals(elementState.get("ClassPercentageTxt0"), currentPage.getClassPercentageTxt0().getContent());
            Assert.assertNotEquals(elementState.get("ClassTotalAssetTxt0"), currentPage.getClassTotalAssetTxt0().getContent());
        }
        captureScreen();
    }

    public void checkAccountCurrencyData0() {
        sleep(500L);

        if (currentPage.getMainCurrencyListView().isVisible()) {
//            Assert.assertNotEquals(elementState.get("CurrencyTitleTxt0"),currentPage.getCurrencyTitleTxt0().getContent());
            Assert.assertNotEquals(elementState.get("CurrencyTotalAssetTxt0"), currentPage.getCurrencyTotalAssetTxt0().getContent());
            Assert.assertNotEquals(elementState.get("CurrencyPercentageTxt0"), currentPage.getCurrencyPercentageTxt0().getContent());
        }
        captureScreen();
    }

    public void checkAccountRegionData0() {
        sleep(500L);

        if (currentPage.getMainRegionListView().isVisible()) {
            Assert.assertNotEquals(elementState.get("RegionTitleTxt0"), currentPage.getRegionTitleTxt0().getContent());
            Assert.assertNotEquals(elementState.get("RegionPercentageTxt0"), currentPage.getRegionPercentageTxt0().getContent());
            Assert.assertNotEquals(elementState.get("RegionTotalAssetTxt0"), currentPage.getRegionTotalAssetTxt0().getContent());
        }
        captureScreen();
    }

    public void checkPortfolioListDateChange() {
        sleep(500L);
        if (getPortfolioList(0).isVisible()) {
            Assert.assertNotEquals(elementState.get("PortfolioListID0"), currentPage.getPortfolioListID0().getContent());
        }
        captureScreen();
    }


    public void tapPortfoliosList5() {
        currentPage.getPortfolioListView().scrollToItem(getPortfolioList(4), ScrollDirection.UP);
        getPortfolioList(4).click();
    }

    public void tapPortfoliosList14() {
        currentPage.getPortfolioListView().scrollToItem(getPortfolioList(15), ScrollDirection.UP);
        currentPage.getPortfolioListView().scrollToItem(getPortfolioList(13), ScrollDirection.DOWN);
        getPortfolioList(13).click();
    }

    public void tapPortfoliosList15() {
        currentPage.getPortfolioListView().scrollToItem(getPortfolioList(15), ScrollDirection.UP);
        getPortfolioList(14).click();
    }

    public void checkAccountWrapperChange() {
        sleep(300L);
        captureScreen();
        if (!currentPage.getPortfolioListView().isVisible()) {
            Assert.assertNotEquals(elementState.get("MainUserIdTxt"), currentPage.getMainUserIdTxt().getContent());
            Assert.assertNotEquals(elementState.get("MainTotalAssetsContentTxt"), currentPage.getMainTotalAssetsContentTxt().getContent());
            Assert.assertNotEquals(elementState.get("getMainUsernameTxt"), currentPage.getMainUsernameTxt().getContent());

        }
    }

    public void tapPortfoliosList4() {
        sleep(500L);
        currentPage.getPortfolioListView().scrollToItem(getPortfolioList(3), ScrollDirection.UP);
        getPortfolioList(3).click();
    }

    public void noPips() {
        if (currentPage.getMainPips().isExisted()) {
            Assert.assertTrue(currentPage.getMainPips().getRect().getWidth() < 20);
        }
    }

    public void tapPortfoliosListDown() {
        sleep(500L);
        currentPage.getPortfolioListView().scrollToItem(getPortfolioList(2), ScrollDirection.DOWN);
        getPortfolioList(2).click();
    }

    public void tapAccountsList5() {
        sleep(500L);
        if (!overviewFlow.getAccountList(4).isVisible()) {
            overviewPage.getAccountListView().scrollToItem(overviewFlow.getAccountList(4), ScrollDirection.UP);
        }
        overviewFlow.getAccountList(4).click();
    }

    public void tapAccountsList1Down() {
        sleep(500L);
        if (getPortfolioList(0).isVisible()) {
            currentPage.getPortfolioListView().scrollToItem(getPortfolioList(2), ScrollDirection.DOWN);
        }
        getPortfolioList(2).click();
    }

    public void checkAccountOverlayRelating() {
        sleep(500L);
        Assert.assertNotEquals(elementState.get("AccountTotalAssetsAmount"), globalOverlayPage.getContentTxt().getContent());
    }

    public void checkAccountClassList() {
        Assert.assertTrue(currentPage.getMainClassListView().isExisted());
    }

    public void tapFirstClass() {
        currentPage.getClassList0().click();
    }

    public void tapFirstSubClass() {
        if (!currentPage.getSubClassTitleTxt0().isVisible()) {
            currentPage.getMainClassListView().scroll(ScrollDirection.UP, 500L, 300);
        }
        currentPage.getSubClassTitleTxt0().click();
    }

    public void checkAllocationHolding() {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getHoldingBackBtn().isVisible());
    }

    public void tapFirstRegion() {
        currentPage.getRegionTitleTxt0().click();
    }

    public void tapAccountCurrencyTab() {
        currentPage.getMainCurrencyBtn().click();
    }

    public void tapPortfoliosList16() {
        sleep(500L);
        currentPage.getPortfolioListView().scrollToItem(getPortfolioList(15), ScrollDirection.UP);
        getPortfolioList(15).click();
    }

    public void checkPortfolioListData() {
        sleep(500L);
        captureScreen();
        if (!currentPage.getPortfolioTotalAssetsTxt0().isVisible()) {
            currentPage.getPortfolioListView().scrollToItem(currentPage.getPortfolioTotalAssetsTxt0(), ScrollDirection.DOWN);
        }
        Assert.assertTrue(currentPage.getPortfolioTotalAssetsTxt0().isVisible());
        Assert.assertTrue(currentPage.getPortfolioListID0().isVisible());
        Assert.assertTrue(currentPage.getPortfolioTitleTxt0().isVisible());

        if (!currentPage.getElementById("portfolio_list_tablecell_amount_label_1").isVisible()) {
            currentPage.getPortfolioListView().scrollToItem(currentPage.getElementById("portfolio_list_tablecell_amount_label_1"), ScrollDirection.UP);
        }
        Assert.assertTrue(currentPage.getElementById("portfolio_list_tablecell_amount_label_1").isVisible());
        Assert.assertTrue(currentPage.getElementById("portfolio_list_tablecell_code_label_1").isVisible());
        Assert.assertTrue(currentPage.getElementById("portfolio_list_tablecell_title_label_1").isVisible());

        if (!currentPage.getElementById("portfolio_list_tablecell_amount_label_2").isVisible()) {
            currentPage.getPortfolioListView().scrollToItem(currentPage.getElementById("portfolio_list_tablecell_amount_label_2"), ScrollDirection.UP);
        }
        Assert.assertTrue(currentPage.getElementById("portfolio_list_tablecell_amount_label_2").isVisible());
        Assert.assertTrue(currentPage.getElementById("portfolio_list_tablecell_code_label_2").isVisible());
        Assert.assertTrue(currentPage.getElementById("portfolio_list_tablecell_title_label_2").isVisible());

//        if (!currentPage.getPortfolioTotalAssetsTxt3().isVisible()){
//            currentPage.getPortfolioListView().scrollToItem(currentPage.getPortfolioTotalAssetsTxt3(),ScrollDirection.UP);
//        }
//        Assert.assertTrue(currentPage.getPortfolioTotalAssetsTxt3().isVisible());
//        Assert.assertTrue(currentPage.getPortfolioListID3().isVisible());
//        Assert.assertTrue(currentPage.getPortfolioTitleTxt3().isVisible());
//
//        if (!currentPage.getPortfolioTotalAssetsTxt4().isVisible()){
//            currentPage.getPortfolioListView().scrollToItem(currentPage.getPortfolioTotalAssetsTxt4(),ScrollDirection.UP);
//        }
//        Assert.assertTrue(currentPage.getPortfolioTotalAssetsTxt4().isVisible());
//        Assert.assertTrue(currentPage.getPortfolioListID4().isVisible());
//        Assert.assertTrue(currentPage.getPortfolioTitleTxt4().isVisible());
    }

    public void checkPortfolioListAmountFormat() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        for (int i = 0; i < num; i++) {
            CheckUtil.check2dpCurrency(currentPage.getElementById("portfolio_list_tablecell_amount_label_"+i).getContent());
        }
    }

    public void checkPortfolioListAmountOrder() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        if (!currentPage.getPortfolioTitleTxt0().isVisible()) {
            currentPage.getPortfolioListView().scrollToItem(currentPage.getPortfolioTitleTxt0(), ScrollDirection.DOWN);
        }
        checkNumberOrderByDesc(currentPage.getPortfolioListView(), "portfolio_list_tablecell_amount_label_", null, 0, (num - 1));

    }

    public void checkAccountLevelUI(Map<String, String> map) {
        sleep(500L);
        captureScreen();
        BaseWebElement totalAssetImg = currentPage.getMainTotalAssetsImg();
        if (!totalAssetImg.isExisted()) {
            totalAssetImg = currentPage.getMainTotalAssetsImg();
        }
        Assert.assertTrue(totalAssetImg.isExisted());
        Assert.assertTrue(allocationGraphicFlow.getAllocationToggle().isExisted());
        assertIsDisplayed(map, "Allocation Toggle");
    }

    public void seeAccountOverlay2() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(globalOverlayPage.getCloseBtn().isVisible());
        Assert.assertTrue(globalOverlayPage.getCalculatedValueTxt().isVisible());
        Assert.assertTrue(globalOverlayPage.getContentTxt().isVisible());
        Assert.assertTrue(globalOverlayPage.getCalculatedTxt().isVisible());
        Assert.assertTrue(globalOverlayPage.getTitleTxt().isVisible());
    }

    public void closeOverlayInAccountLevel() {
        sleep(100L);
        globalOverlayPage.getCloseBtn().click();
    }

    public void checkAccountTotalAssetsValue2Format() {
        sleep(500L);
        captureScreen();
        String TotalAssetsValue = currentPage.getMainTotalAssetsContentTxt().getContent();
        CheckUtil.check2dp(CheckUtil.getAmount(TotalAssetsValue));
        System.out.println("TotalAssetsValue: "+TotalAssetsValue);
        System.out.println("replace TotalAssetsValue: "+TotalAssetsValue.replaceAll("[ \\-|A-Z]",""));
        Assert.assertTrue(TotalAssetsValue.replaceAll("[ \\-|A-Z]","").length() <= 18);
    }

    public void checkTotalAssetEquals() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        if (!currentPage.getPortfolioTotalAssetsTxt0().isVisible()) {
            currentPage.getPortfolioListView().scrollToItem(currentPage.getPortfolioTotalAssetsTxt0(), ScrollDirection.DOWN);
        }
        Double value = 0.00;
        for (int i = 0; i < num; i++) {
            currentPage.getPortfolioListView().scrollToItem(currentPage.getElementById("portfolio_list_tablecell_amount_label_"+i), ScrollDirection.UP);
            value = value + CheckUtil.getNoISOAmount(currentPage.getElementById("portfolio_list_tablecell_amount_label_"+i).getContent());
        }
        Assert.assertTrue(value.doubleValue() == Double.valueOf(CheckUtil.getAmount(currentPage.getMainTotalAssetsContentTxt().getContent()).replace(",", "")));
    }

    public void checkTotalAssetsValue16Format() {
        sleep(500L);
        captureScreen();
        String totalAssetsValue = CheckUtil.getAmount(currentPage.getMainTotalAssetsContentTxt().getContent());
        CheckUtil.check2dp(totalAssetsValue);
        Assert.assertEquals(totalAssetsValue, "0.00");
    }

    public void checkTotalAssetsISO3() {
        sleep(300L);
        CheckUtil.checkDataFormat(currentPage.getMainTotalAssetsContentTxt().getContent());
    }

    public void tapsAccountTotalAssets() {
        sleep(300L);
        elementState.put("account total assets", currentPage.getMainTotalAssetsContentTxt().getContent().trim());
        Rectangle rectangle = currentPage.getMainTotalAssetsTxt().getRect();
        currentPage.getMainTotalAssetsTxt().tapXY(rectangle.getX(),rectangle.getY());
//        currentPage.getMainTotalAssetsTxt().click();
    }

    public void checkAccountTotalAssetsUI(Map<String, String> map) {
        sleep(500L);
        captureScreen();
        globalOverlayFlow.assertIsDisplayed(map);
    }

    public void checkAccountPopUpTotalAssetsValueFormat() {
        sleep(300L);
        CheckUtil.check2dp(CheckUtil.getAmount(globalOverlayPage.getContentTxt().getContent()));
    }

    public void checkAccountPopUpTotalAssetsValueIOS3() {
        sleep(300L);
        CheckUtil.checkDataFormat(globalOverlayPage.getContentTxt().getContent());
    }

    public void checkAccountTotalAssetsOverlayClose() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(globalOverlayPage.getContentTxt().isVisible());
        Assert.assertFalse(globalOverlayPage.getCloseBtn().isVisible());
        Assert.assertFalse(globalOverlayPage.getCalculatedTxt().isVisible());
        Assert.assertFalse(globalOverlayPage.getCalculatedValueTxt().isVisible());
        Assert.assertFalse(globalOverlayPage.getNameTxt().isVisible());
        Assert.assertFalse(globalOverlayPage.getTitleTxt().isVisible());
    }

    public void tapAccountOverlayOutside() {
        sleep(300L);
        if (driverConfig.getPlatform().equals(Platform.IOS)) {
            globalOverlayPage.getTitleTxt().tapXY(50, 50);
        } else {
            globalOverlayPage.getTitleTxt().tapXY(180, 180);
        }
    }

    public void tapAccountTotalAssetsValue() {
        sleep(300L);
        currentPage.getMainTotalAssetsContentTxt().click();
    }

    public void tapThirdlyPortfolio() {
        currentPage.getPortfolioListView().scrollToItem(getPortfolioList(2), ScrollDirection.UP);
        getPortfolioList(2).click();
    }

    public void tapAccountConversion() {
        currentPage.getMainGbpBtn().click();
    }

    public void checkPortfolioListTWRRNegative() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        if (driverConfig.getPlatform().equals(Platform.ANDROID)) {
            Assert.assertTrue(currentPage.getElementById("portfolio_list_tablecell_arrow_img_" + (num - 1)).isExisted());
        }
        Assert.assertTrue(currentPage.getElementById("portfolio_list_tablecell_weight_label_" + (num - 1)).getContent().startsWith("-"));
    }

    public void checkPortfolioListTWRRPositive() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        if (driverConfig.getPlatform().equals(Platform.ANDROID)) {
            Assert.assertTrue(currentPage.getElementById("portfolio_list_tablecell_arrow_img_" + (num - 1)).isExisted());
        }
        Assert.assertFalse(currentPage.getElementById("portfolio_list_tablecell_weight_label_" + (num - 1)).getContent().startsWith("+"));

    }

    public void checkPortfolioListTWRRFormat() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        String[] twrr = this.getDateListByObjectId(currentPage.getPortfolioListView(), "portfolio_list_tablecell_weight_label_", null, num - 1);
        for (int i = 0; i < twrr.length; i++) {
            CheckUtil.check2dp(CheckUtil.getAmount(twrr[i]));
        }
    }

    public void checkPortfolioListTWRRZero() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement percentage = new BaseWebElement("portfolio_list_tablecell_weight_label_" + (num - 1));
        currentPage.getPortfolioListView().scrollToItem(percentage, ScrollDirection.UP);
        Assert.assertEquals(percentage.getContent().trim(), "0.00%");
    }

    public void checkPortfolioListNoSymbolAndNoChevron() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement percentage = new BaseWebElement("portfolio_list_tablecell_weight_label_" + (num - 1));
        currentPage.getPortfolioListView().scrollToItem(percentage, ScrollDirection.UP);
        Assert.assertFalse(new BaseWebElement("portfolio_list_tablecell_arrow_img_" + (num - 1)).isExisted());
        Assert.assertFalse(percentage.getContent().startsWith("+"));
        Assert.assertFalse(percentage.getContent().startsWith("-"));
    }

    public void checkAccountPerformanceUI(Map<String, String> map, int num) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(map.get("Performance label"), performancePage.getMainAccountContent().getContent());
        Assert.assertTrue(performancePage.getMainAccountIcon().isExisted());
        if (num == 1) {
            Assert.assertTrue(performancePage.getMainAccountAmount().getContent().startsWith("-"));
            Assert.assertTrue(performancePage.getMainAccountPercentage().getContent().startsWith("-"));
        } else if (num == 2) {
            Assert.assertTrue(performancePage.getMainAccountAmount().getContent().startsWith("+"));
            Assert.assertTrue(performancePage.getMainAccountPercentage().getContent().startsWith("+"));
        }

        Assert.assertTrue(performancePage.getMainAccountAmount().isVisible());
    }

    public void checkAccountPerformanceISO3() {
        sleep(500L);
        captureScreen();
        String performance = performancePage.getMainAccountAmount().getContent();
        CheckUtil.checkStringISO3(
                CheckUtil.getCurrency(performance)
        );

        CheckUtil.checkWrapperPerformanceISO3Format(
                CheckUtil.getAmount(performance)
        );
    }

    public void checkAccountPerformance2dp() {
        sleep(500L);
        captureScreen();
        CheckUtil.check2dp(
                CheckUtil.getAmount(performancePage.getMainAccountAmount().getContent())
        );

        CheckUtil.check2dp(
                performancePage.getMainAccountPercentage().getContent().replace("%", "")
        );
    }

    public void checkAccountTWRRZero() {
        Assert.assertEquals(performancePage.getMainAccountPercentage().getContent(), "0.00%");
    }

    public void checkPerformanceValueZero() {
        Assert.assertEquals(CheckUtil.getAmount(performancePage.getMainAccountAmount().getContent()), "0.00");
    }

    public void checkTWRRPerformanceNoSymbol() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(performancePage.getMainAccountAmount().getContent().startsWith("-"));
        Assert.assertFalse(performancePage.getMainAccountAmount().getContent().startsWith("+"));
        Assert.assertFalse(performancePage.getMainAccountAmount().getContent().startsWith("-"));
        Assert.assertFalse(performancePage.getMainAccountAmount().getContent().startsWith("+"));

    }

    public void checkAccountPerformanceOverlayUI(Map<String, String> map, int num) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(map.get("Performance YTD label"), globalOverlayPage.getTitleTxt().getContent());
        Assert.assertTrue(globalOverlayPage.getNameTxt().isVisible());
        Assert.assertEquals(map.get("Profit/loss label"), globalOverlayPage.getHeadingTxt().getContent());
        Assert.assertTrue(globalOverlayPage.getContentTxt().isVisible());
        if (num == 1) {
            Assert.assertTrue(globalOverlayPage.getContentTxt().getContent().startsWith("-"));
            Assert.assertTrue(globalOverlayPage.getBottomContentTxt().getContent().startsWith("-"));
        } else if (num == 2) {
            Assert.assertTrue(globalOverlayPage.getContentTxt().getContent().startsWith("+"));
            Assert.assertTrue(globalOverlayPage.getBottomContentTxt().getContent().startsWith("+"));
        }
        Assert.assertTrue(globalOverlayPage.getCloseBtn().isVisible());
        Assert.assertEquals(map.get("overlay question"), globalOverlayPage.getCalculatedTxt().getContent());
        Assert.assertEquals(map.get("overlay answer"), globalOverlayPage.getCalculatedValueTxt().getContent());

        Assert.assertEquals(map.get("Performance label"), globalOverlayPage.getBottomHeadingTxt().getContent());
        Assert.assertEquals(map.get("overlay bottom question"), globalOverlayPage.getBottomCalculatedTxt().getContent());
        Assert.assertEquals(map.get("overlay bottom answer"), globalOverlayPage.getBottomCalculatedValueTxt().getContent());
    }

    public void tapAccountPerformance() {
        elementState.put("performanceValue", performancePage.getMainAccountAmount().getContent());
        performancePage.getMainAccountContent().click();
    }

    public void checkAccountPerformanceOverlay2dp() {
        sleep(500L);
        captureScreen();
        CheckUtil.check2dp(
                CheckUtil.getAmount(globalOverlayPage.getContentTxt().getContent())
        );
        CheckUtil.check2dp(
                globalOverlayPage.getBottomContentTxt().getContent().replace("%", "")
        );

    }

    public void checkAccountPerformanceOverlayISO3() {
        sleep(100L);
        captureScreen();
        CheckUtil.checkWrapperPerformanceISO3Format(globalOverlayPage.getContentTxt().getContent());
    }

    public void checkAccountPerformanceOverlay() {
        Assert.assertTrue(globalOverlayPage.getCloseBtn().isVisible());
    }

    public void checkAccountPerformanceOverlayTWRRZero() {
        Assert.assertEquals(globalOverlayPage.getBottomContentTxt().getContent(), "0.00%");
    }

    public void checkAccountPerformanceOverlayPerformanceZero() {
        Assert.assertEquals(CheckUtil.getAmount(globalOverlayPage.getContentTxt().getContent()), "0.00");
    }

    public void checkAccountPerformanceOverlayThereIsNoSymbol() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(globalOverlayPage.getContentTxt().getContent().startsWith("+"));
        Assert.assertFalse(globalOverlayPage.getContentTxt().getContent().startsWith("-"));
        Assert.assertFalse(globalOverlayPage.getBottomContentTxt().getContent().startsWith("+"));
        Assert.assertFalse(globalOverlayPage.getBottomContentTxt().getContent().startsWith("-"));
    }

    public void checkAccountAssetTitleOverlay(String title) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(title, globalOverlayPage.getTitleTxt().getContent());
    }

    public void checkAccountAssets(String asset) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(asset, currentPage.getMainTotalAssetsTxt().getContent());
    }

    public void tapCloseAccountPerformanceOverlay() {
        globalOverlayPage.getCloseBtn().click();
    }

    public void checkAccountPerformanceOverlayClosed() {
        sleep(500L);
        captureScreen();
//        Assert.assertFalse(globalOverlayPage.getOverLayPercentage().isVisible());
//        Assert.assertFalse(globalOverlayPage.getOverLayAmount().isVisible());
        Assert.assertFalse(globalOverlayPage.getNameTxt().isVisible());
//        Assert.assertFalse(globalOverlayPage.getOverLayCalculatedValue().isVisible());
//        Assert.assertFalse(globalOverlayPage.getOverLayCalculated().isVisible());
        Assert.assertFalse(globalOverlayPage.getTitleTxt().isVisible());
    }

    public void tapAnywhereAccountPerformanceOverlay() {
        sleep(300L);
        if (driverConfig.getPlatform().equals(Platform.IOS)) {
            globalOverlayPage.getTitleTxt().tapXY(80, 80);
        } else {
            globalOverlayPage.getTitleTxt().tapXY(120, 100);
        }
    }

    public void checkAccountHoldingTWRRPositive() {
        sleep(500L);
        captureScreen();
        if (!allocationHoldingListFlow.getHoldingPercentage(3).isVisible()) {
            allocationHoldingListPage.getTableView().scroll(ScrollDirection.UP, 500L, 300);
        }
        Assert.assertTrue(allocationHoldingListFlow.getHoldingImg(3).isExisted());
        Assert.assertFalse(allocationHoldingListFlow.getHoldingPercentage(3).getContent().startsWith("-"));

    }

    public void checkAccountHoldingTWRRNegative() {
        sleep(500L);
        captureScreen();
        if (!allocationHoldingListFlow.getHoldingPercentage(2).isVisible()) {
            allocationHoldingListPage.getTableView().scroll(ScrollDirection.UP, 500L, 300);
        }
        Assert.assertTrue(allocationHoldingListFlow.getHoldingImg(2).isExisted());
        Assert.assertTrue(allocationHoldingListFlow.getHoldingPercentage(2).getContent().startsWith("-"));

    }

    public void checkAccountHoldingTWRR2dp() {
        sleep(500L);
        captureScreen();
        if (!allocationHoldingListFlow.getHoldingPercentage(2).isVisible()) {
            allocationHoldingListPage.getTableView().scrollToTopItem(allocationHoldingListFlow.getHoldingPercentage(2));
        }
        CheckUtil.check2dp(
                CheckUtil.getAmount(allocationHoldingListFlow.getHoldingPercentage(2).getContent())
        );
    }

    public void checkAccountHoldingTWRRZero() {
        sleep(500L);
        captureScreen();
        if (!allocationHoldingListFlow.getHoldingPercentage(14).isVisible()) {
            allocationHoldingListPage.getTableView().scrollToItem(allocationHoldingListFlow.getHoldingPercentage(14), ScrollDirection.UP);
        }
        Assert.assertEquals(allocationHoldingListFlow.getHoldingPercentage(14).getContent(), "0.00%");
    }

    public void checkAccountHoldingTWRRNoSymbolNoChevron() {
        sleep(500L);
        captureScreen();
        if (!allocationHoldingListFlow.getHoldingPercentage(14).isVisible()) {
            allocationHoldingListPage.getTableView().scrollToItem(allocationHoldingListFlow.getHoldingPercentage(14), ScrollDirection.UP);
        }
        Assert.assertFalse(allocationHoldingListFlow.getHoldingPercentage(14).getContent().startsWith("+"));
        Assert.assertFalse(allocationHoldingListFlow.getHoldingPercentage(14).getContent().startsWith("-"));
    }

    public void checkAccountHoldingWrapperISO3() {
        sleep(500L);
        captureScreen();
        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(allocationHoldingListPage.getAmountNumber().getContent())
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

    public void viewEndOfPortfolioList() {
        currentPage.getPortfolioListView().scrollToBottomItem(currentPage.getPortfolioListFootView());
    }

    public void checkAccountGlobalLegalDisclaimer(String region, String disclaimer) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(RegionUtil.getValue(region, disclaimer), currentPage.getPortfolioListFootView().getContent());
    }

    public void checkAccountAllocationHoldings() {
        SleepUtil.waitForElement(allocationHoldingListPage.getAmountNumber());
        captureScreen();
        Assert.assertTrue(allocationHoldingListPage.getBackBtn().isVisible());
        Assert.assertTrue(allocationHoldingListPage.getAmountNumber().isVisible());
        Assert.assertTrue(allocationHoldingListPage.getMenuBtn().isVisible());
        Assert.assertTrue(allocationHoldingListPage.getTableTitle().isVisible());
        Assert.assertTrue(allocationHoldingListPage.getTitleTxt().isVisible());
        Assert.assertTrue(allocationHoldingListPage.getTableView().isVisible());
    }

    public void checkAccountAllocationHoldingsPositiveAndDIFFERENT() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        allocationHoldingListPage.getTableView().scrollToItem(new BaseWebElement("allocation_holding_list_tablecell_report_amount_label_1_" + (num - 1)), ScrollDirection.UP);
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_title_label_1_" + (num - 1)).isVisible());
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num - 1)).isVisible());
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_weight_label_1_" + (num - 1)).isVisible());
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_arrow_img_1_" + (num - 1)).isExisted());
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_report_amount_label_1_" + (num - 1)).isVisible());
    }

    public void checkAccountAllocationHoldingsPositiveAndDIFFERENTISO3() {
        sleep(500L);
        captureScreen();

        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement holdingBaseAmount = new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num - 1));
        BaseWebElement holdingReportAmount = new BaseWebElement("allocation_holding_list_tablecell_report_amount_label_1_" + (num - 1));
        allocationHoldingListPage.getTableView().scrollToItem(holdingReportAmount, ScrollDirection.UP);

        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(holdingBaseAmount.getContent())
        );

        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(holdingReportAmount.getContent())
        );
    }

    public void checkAccountAllocationHoldingsNegativeAndDIFFERENT() {
        sleep(500L);
        captureScreen();

        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        allocationHoldingListPage.getTableView().scrollToItem(new BaseWebElement("allocation_holding_list_tablecell_report_amount_label_1_" + (num - 1)), ScrollDirection.UP);
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_title_label_1_" + (num - 1)).isVisible());
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num - 1)).isVisible());
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_weight_label_1_" + (num - 1)).isVisible());
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_arrow_img_1_" + (num - 1)).isExisted());
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_report_amount_label_1_" + (num - 1)).isVisible());

    }

    public void checkAccountAllocationHoldingsNegativeAndDIFFERENTISO3() {
        sleep(500L);
        captureScreen();

        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement holdingBaseAmount = new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num - 1));
        BaseWebElement holdingReportAmount = new BaseWebElement("allocation_holding_list_tablecell_report_amount_label_1_" + (num - 1));
        allocationHoldingListPage.getTableView().scrollToItem(holdingReportAmount, ScrollDirection.UP);

        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(holdingBaseAmount.getContent())
        );

        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(holdingReportAmount.getContent())
        );
    }

    public void checkAccountAllocationHoldingsPositiveAndSAME() {
        sleep(500L);
        captureScreen();
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        allocationHoldingListPage.getTableView().scrollToItem(new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num - 1)), ScrollDirection.DOWN);
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_title_label_1_" + (num - 1)).isVisible());
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num - 1)).isVisible());
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_weight_label_1_" + (num - 1)).isVisible());
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_arrow_img_1_" + (num - 1)).isExisted());

    }

    public void checkAccountAllocationHoldingPositiveAndSAMEISO3() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement holdingBaseAmount = new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num - 1));
        allocationHoldingListPage.getTableView().scrollToItem(holdingBaseAmount, ScrollDirection.UP);

        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(holdingBaseAmount.getContent())
        );
    }

    public void checkAccountAllocationHoldingsNegativeAndSAME() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        allocationHoldingListPage.getTableView().scrollToItem(new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num - 1)), ScrollDirection.DOWN);
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_title_label_1_" + (num - 1)).isVisible());
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num - 1)).isVisible());
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_weight_label_1_" + (num - 1)).isVisible());
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_arrow_img_1_" + (num - 1)).isExisted());

    }

    public void checkAccountAllocationHoldingsNegativeAndSAMEISO3() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement holdingBaseAmount = new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num - 1));
        allocationHoldingListPage.getTableView().scrollToItem(holdingBaseAmount, ScrollDirection.UP);

        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(holdingBaseAmount.getContent())
        );
    }

    public void checkAccountsAllocationHoldingsNotRelevantAndDIFFERENT() {
        sleep(500L);
        captureScreen();

        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        allocationHoldingListPage.getTableView().scrollToItem(new BaseWebElement("allocation_holding_list_tablecell_report_amount_label_1_" + (num - 1)), ScrollDirection.UP);
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_title_label_1_" + (num - 1)).isVisible());
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num - 1)).isVisible());
        Assert.assertFalse(new BaseWebElement("allocation_holding_list_tablecell_weight_label_1_" + (num - 1)).isVisible());
        Assert.assertFalse(new BaseWebElement("allocation_holding_list_tablecell_arrow_img_1_" + (num - 1)).isExisted());
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_report_amount_label_1_" + (num - 1)).isVisible());
    }

    public void checkAccountsAllocationHoldingsNotRelevantAndDIFFERENTISO3() {
        sleep(500L);
        captureScreen();

        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        allocationHoldingListPage.getTableView().scrollToItem(new BaseWebElement("allocation_holding_list_tablecell_report_amount_label_1_" + (num - 1)), ScrollDirection.DOWN);
        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num - 1)).getContent())
        );

        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(new BaseWebElement("allocation_holding_list_tablecell_report_amount_label_1_" + (num - 1)).getContent())
        );

    }

    public void tapAccountAllocationHoldingList(int num) {
        String allocationHoldingsList = "allocation_holdings_list_tableview_cell_1_";
        BaseWebElement holdingsListElement;
        holdingsListElement = new BaseWebElement(allocationHoldingsList + (num - 1));

        allocationHoldingListPage.getTableView().scrollToItem(holdingsListElement, ScrollDirection.UP);

        holdingsListElement.click();
    }

    public void checkAccountReferenceCurrency(String referenceCurrency) {
        sleep(300L);
        captureScreen();
        Assert.assertEquals(referenceCurrency, CheckUtil.getAmountCurrency(currentPage.getMainTotalAssetsContentTxt()));

    }

    public void checkTotalAssetISO3() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkDataFormat(CheckUtil.getAmount(currentPage.getMainTotalAssetsContentTxt().getContent()));
        CheckUtil.checkCurrencyISO3(currentPage.getMainTotalAssetsContentTxt());

    }

    public void checkInAllocation() {
        Assert.assertTrue(currentPage.getAllocationBtnOn().isVisible());
    }

    public void tapAccountTotalLiabilities() {
        currentPage.getMainLiabilitesTitleTxt().click();
    }

    public void swapLeftAccountTotalLiabilitiesOverlay() {
        sleep(800L);
        captureScreen();
        elementState.put("totalLiabilitiesAmount", CheckUtil.getAmount(currentPage.getMainLiabilitesAmountBtn().getContent()));
        currentPage.getMainTopView().scroll(ScrollDirection.LEFT, 500L);
    }

    public void checkAccountTotalLiabilitiesOverlayChanged() {
        sleep(500L);
        captureScreen();
        Assert.assertNotEquals(elementState.get("totalLiabilitiesAmount"), CheckUtil.getAmount(globalOverlayPage.getContentTxt().getContent()));
    }

    public void checkAccountLiabilitiesUI(Map<String, String> map) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(map.get("header \"Total liabilities\""), currentPage.getMainLiabilitesTitleTxt().getContent());
        Assert.assertTrue(currentPage.getMainLiabilitesIconImg().isExisted());
        Assert.assertTrue(currentPage.getMainLiabilitesAmountBtn().isVisible());
    }

    public void checkTotalLiabilitiesValueMaxIncludingCommasAndDecimalPoint(int maxNumber) {
        sleep(500L);
        captureScreen();
        String amount = currentPage.getMainLiabilitesAmountBtn().getContent().trim();
        if (amount.indexOf(" ") != -1) {
            amount = amount.substring(0, amount.indexOf(" ")).trim();
        }
        Assert.assertTrue(amount.length() <= maxNumber);
    }

    public void checkAccountLiabilitiesISO3() {
        sleep(500L);
        captureScreen();
        CheckUtil.checkCurrencyISO3(currentPage.getMainLiabilitesAmountBtn());
        CheckUtil.checkDataFormat(currentPage.getMainLiabilitesAmountBtn().getContent());
    }

    public void checkAccountWrapperTotalLiabilitiesChanged() {
        sleep(500L);
        captureScreen();
        Assert.assertNotEquals(elementState.get("totalLiabilitiesAmount"), CheckUtil.getAmount(currentPage.getMainLiabilitesAmountBtn().getContent()));

    }

    public void minifilesTheAccountWrapper() {
        currentPage.getPortfolioListView().scroll(ScrollDirection.UP, 500L, 300);
    }

    public void checkMinifilesAccountWrapperUI() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(currentPage.getMainUserIdTxt().isVisible());
        Assert.assertFalse(currentPage.getMainUpdateTimeBtn().isVisible());
        Assert.assertFalse(currentPage.getMainLiabilitesTitleTxt().isVisible());
        Assert.assertFalse(currentPage.getMainLiabilitesAmountBtn().isVisible());
        Assert.assertFalse(currentPage.getMainNetTitleTxt().isVisible());
        Assert.assertFalse(currentPage.getMainNetAmountTxt().isVisible());
    }

    public void checkAccountNameAndAccountAssets() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(currentPage.getMainUsernameTxt().isVisible());
        Assert.assertTrue(currentPage.getMainTotalAssetsTxt().isVisible());
        Assert.assertTrue(currentPage.getMainTotalAssetsContentTxt().isVisible());
    }

    public void checkNoTotalLiabilities() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(currentPage.getMainLiabilitesTitleTxt().isVisible());
        Assert.assertFalse(currentPage.getMainLiabilitesAmountBtn().isVisible());
        Assert.assertFalse(currentPage.getMainLiabilitesIconImg().isExisted());
    }

    public void checkAccountLiabilitiesZero(String value) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(value, CheckUtil.getAmount(currentPage.getMainLiabilitesAmountBtn().getContent()));

    }

    public void checkNoAccountLiabilitiesAndNetAssets() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(currentPage.getMainLiabilitesTitleTxt().isVisible());
        Assert.assertFalse(currentPage.getMainLiabilitesAmountBtn().isVisible());
        Assert.assertFalse(currentPage.getMainNetTitleTxt().isVisible());
        Assert.assertFalse(currentPage.getMainNetAmountTxt().isVisible());
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

    public void swipeLeftScreen() {
        currentPage.getMainTopView().scroll(ScrollDirection.LEFT, 500L);
    }

    public void checkAccountNetAssetsUI(Map<String, String> map) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(map.get("header \"Net assets\""), currentPage.getMainNetTitleTxt().getContent());
        Assert.assertTrue(currentPage.getMainNetAmountTxt().isVisible());
    }

    public void checkAccountNetAssetsMax(int maxNumber) {
        sleep(500L);
        captureScreen();
        String amount = currentPage.getMainNetAmountTxt().getContent().trim();
        if (amount.indexOf(" ") != -1) {
            amount = amount.substring(0, amount.indexOf(" ")).trim();
        }
        Assert.assertTrue(amount.length() <= maxNumber);
    }

    public void checkAccountNetAssetsISO3() {
        sleep(500L);
        captureScreen();
        CheckUtil.checkCurrencyISO3(currentPage.getMainNetAmountTxt());
        CheckUtil.checkDataFormat(currentPage.getMainNetAmountTxt().getContent());
    }

    public void checkAccountNetAssetsEqualTotalAssetsReductionOfTotalLiabilities() {
        sleep(500L);
        captureScreen();
        Double amount = CheckUtil.getNoISOAmount(currentPage.getMainTotalAssetsContentTxt().getContent()) + CheckUtil.getNoISOAmount(currentPage.getMainLiabilitesAmountBtn().getContent());
        Assert.assertTrue(amount == CheckUtil.getNoISOAmount(currentPage.getMainNetAmountTxt().getContent()));
    }

    public void swapLeftAccountNetAssets() {
        sleep(800L);
        captureScreen();
        elementState.put("netAssetAmount", CheckUtil.getAmount(currentPage.getMainNetAmountTxt().getContent()));
        currentPage.getMainTopView().scroll(ScrollDirection.LEFT, 500L);
    }

    public void checkAccountNetAssetsChanged() {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(elementState.get("netAssetAmount"), CheckUtil.getAmount(currentPage.getMainNetAmountTxt().getContent()));
    }

    public void checkNotNetAssets() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(currentPage.getMainNetTitleTxt().isVisible());
        Assert.assertFalse(currentPage.getMainNetAmountTxt().isVisible());
    }

    public void checkAccountNetAssets(String value) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(value, CheckUtil.getAmount(currentPage.getMainNetAmountTxt().getContent()));

    }

    public void checkDiscretionaryUI(Map<String, String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getElementById("portfolio_list_tablecell_title_label_1").isVisible());
        String category;
        if (driverConfig.getPlatform().equals(Platform.IOS)) {
            category = currentPage.getElementById("portfolio_list_tablecell_code_label_1").getContent();
            category = category.substring(0, category.indexOf(" ")).trim();
        } else {
            category = currentPage.getElementById("portfolio_list_tablecell_category_label_1").getContent();
        }
        Assert.assertEquals(map.get("Portfolio type"), category);
        Assert.assertTrue(currentPage.getElementById("portfolio_list_tablecell_code_label_1").isVisible());
    }

    public void checkAdvisoryUI(Map<String, String> map) {
        sleep(300L);
        captureScreen();
        currentPage.getPortfolioListView().scrollToItem(getPortfolioList(2), ScrollDirection.UP);
        Assert.assertEquals(map.get("Portfolio name"), currentPage.getElementById("portfolio_list_tablecell_title_label_2").getContent());
        Assert.assertTrue(currentPage.getElementById("portfolio_list_tablecell_code_label_2").isVisible());
    }

    public void swapLeftNthAccount(int num) {
        for (int i = 0; i < num; i++) {
            currentPage.getMainTopView().scroll(ScrollDirection.LEFT, 500L);
        }
    }

    public void checkSlipDiscretionaryUI(Map<String, String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getPortfolioTitleTxt0().isVisible());
        String category;
        if (driverConfig.getPlatform().equals(Platform.IOS)) {
            category = currentPage.getPortfolioListID0().getContent();
            category = category.substring(0, category.indexOf(" ")).trim();
        } else {
            category = currentPage.getPortfolioListCategory0().getContent();
        }
        Assert.assertEquals(map.get("Portfolio type"), category);
        Assert.assertTrue(currentPage.getPortfolioListID0().isVisible());
    }

    public void swapRightNthAccount(int num) {
        for (int i = 0; i < num; i++) {
            currentPage.getMainTopView().scroll(ScrollDirection.RIGHT, 500L);
        }
    }

    public void checkSlipAdvisoryUI(Map<String, String> map) {
        sleep(300L);
        captureScreen();
        currentPage.getPortfolioListView().scrollToItem(getPortfolioList(0), ScrollDirection.UP);
        Assert.assertEquals(map.get("Portfolio name"), currentPage.getPortfolioTitleTxt0().getContent());
        Assert.assertTrue(currentPage.getPortfolioListID0().isVisible());
    }

    public void slipToLastPortfolio() {
        currentPage.getPortfolioListView().scrollToBottomItem(getPortfolioList(15));
    }

    public void checkPortfolioItemNotPerformance() {
        sleep(300L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        Assert.assertFalse(new BaseWebElement("portfolio_list_tablecell_weight_label_" + (num - 1)).isVisible());
    }

    public void checkPortfolioListHasPerformance() {
        sleep(300L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();

        String portfolioTitlePrefix = "portfolio_list_tablecell_title_label_";
        String portfolioPerformancePrefix = "portfolio_list_tablecell_weight_label_";
        for (int i = 0; i < num; i++) {
            BaseWebElement title = new BaseWebElement(portfolioTitlePrefix + i);
            currentPage.getPortfolioListView().scrollToItem(title, ScrollDirection.UP);
            BaseWebElement performance = new BaseWebElement(portfolioPerformancePrefix + i);
            Assert.assertTrue(performance.isVisible() && performance.getContent().endsWith("%"));
        }
    }

    public void tapShowSubClassToON() {
        currentPage.getSubClassOffBtn().click();
    }

    public void checkNotSeePerformance() {
        sleep(300L);
        captureScreen();
        Assert.assertFalse(performancePage.getMainAccountContent().isVisible());
    }

    public void clickPortfolioByNum(Integer portfolioNum) {
        BaseWebElement portfolio = currentPage.getElementById("portfolio_main_portfolio_tableview_cell_" + (portfolioNum - 1));
        sleep(500L);
        currentPage.getPortfolioListView().scrollToItem(portfolio, ScrollDirection.UP);
        if(portfolioNum < 2 && !portfolio.isVisible()){
            currentPage.getPortfolioListView().scroll(ScrollDirection.UP,1000L,1000);
            currentPage.getPortfolioListView().scroll(ScrollDirection.DOWN,1000L,1000);
        } else {
            currentPage.getPortfolioListView().scrollToItem(portfolio, ScrollDirection.UP);
        }
        portfolio.click();
    }

    public void tapsOnAccountLinkToLegalDisclaimer() {
        int x = currentPage.getPortfolioListFootView().getRect().getX();
        int y = currentPage.getPortfolioListFootView().getRect().getY();
        int width = currentPage.getPortfolioListFootView().getRect().getWidth();
        int height = currentPage.getPortfolioListFootView().getRect().getHeight();

        x = x + width * 9 / 10;
        y = y + height / 2;
        currentPage.getPortfolioListFootView().tapXY(x, y);
    }

    public void returnToPortfolioList() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(currentPage.getPortfolioListFootView().isVisible());
    }

    public void checkAccountPerformanceValue() {
        sleep(300L);
        captureScreen();
        Assert.assertEquals(elementState.get("performanceValue"), globalOverlayPage.getContentTxt().getContent().trim());
    }

    public void checkAccountTotalAssetsEqualAccountTotalAssetsOverlay() {
        sleep(500L);
        captureScreen();
        String key = elementState.get("account total assets");
        String value = globalOverlayPage.getContentTxt().getContent();
        Assert.assertEquals(key, value.trim());
    }

    public void checkNoPortfolioMessage(String message) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(message, currentPage.getNoPortfolioMessage().getContent());
    }

    public void checkAccountNoPerformance() {
        sleep(300L);
        captureScreen();
        Assert.assertFalse(performancePage.getMainAccountContent().isVisible());
        Assert.assertFalse(performancePage.getMainAccountIcon().isVisible());
        Assert.assertFalse(performancePage.getMainAccountAmount().isVisible());
    }

    public void theAccountWrapperIsMinifiles() {
        currentPage.getPortfolioListView().scroll(ScrollDirection.UP, 250L, 300);
    }

    public void checkAccountWrapperMinifiles() {
        Assert.assertFalse(currentPage.getMainUpdateTimeBtn().isVisible());
    }

    public void checkOnAccountLevel() {
        Assert.assertTrue(currentPage.getMainBackBtn().isVisible());
    }

    public void checkAccountWrapperMaximised() {
        Assert.assertTrue(currentPage.getMainUserIdTxt().isVisible());
    }

    public void tapSpecificItemOfPortfoliosList() {
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement portfoliosList = currentPage.getElementById("portfolio_main_portfolio_tableview_cell_" + (num - 1));
        portfoliosList.click();
    }
}
