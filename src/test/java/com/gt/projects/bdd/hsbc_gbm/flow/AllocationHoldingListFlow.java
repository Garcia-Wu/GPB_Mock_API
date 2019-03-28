package com.gt.projects.bdd.hsbc_gbm.flow;

import com.gt.projects.bdd.base.BaseFlow;
import com.gt.projects.bdd.base.BaseWebElement;
import com.gt.projects.bdd.base.config.DriverConfig;
import com.gt.projects.bdd.base.enums.Platform;
import com.gt.projects.bdd.base.enums.ScrollDirection;
import com.gt.projects.bdd.hsbc_gbm.page.AllocationHoldingListPage;
import com.gt.projects.bdd.hsbc_gbm.util.CheckUtil;
import com.gt.projects.bdd.hsbc_gbm.util.UserProfile;
import com.gt.projects.bdd.hsbc_gbm.util.UserProfileUtil;
import cucumber.api.java.it.Ma;
import cucumber.api.java.sl.In;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Scope("thread")
public class AllocationHoldingListFlow extends BaseFlow<AllocationHoldingListPage> {

    @Autowired
    private DriverConfig driverConfig;

    private Map<String, String> elementState = new HashMap<>();

    protected AllocationHoldingListFlow(AllocationHoldingListPage currentPage) {
        super(currentPage);
    }

    public void checkAllocationHoldingPerformance() {
        sleep(300L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement performance = new BaseWebElement("allocation_holdings_list_tablecell_performance_amount_" + (num - 1));

        currentPage.getTableView().scrollToItem(performance, ScrollDirection.UP);
        Assert.assertTrue(performance.isVisible());
    }

    public void clickBackButton() {
        currentPage.getBackBtn().click();
    }

    public void checkAllocationHoldingNoPerformance() {
        sleep(300L);
        captureScreen();

        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement performance = new BaseWebElement("allocation_holdings_list_tablecell_performance_amount_" + (num - 1));

        currentPage.getTableView().scrollToItem(performance, ScrollDirection.UP);
        Assert.assertFalse(performance.isVisible());
    }

    public void checkOverviewHoldingTWRRPositive() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement percentage = new BaseWebElement("allocation_holding_list_tablecell_weight_label_1_" + (num - 1));
        currentPage.getTableView().scrollToItem(percentage, ScrollDirection.UP);
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_arrow_img_1_" + (num - 1)).isExisted());
        Assert.assertFalse(percentage.getContent().startsWith("-"));
    }

    public void checkOverviewHoldingTWRRNegative() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement percentage = new BaseWebElement("allocation_holding_list_tablecell_weight_label_1_" + (num - 1));
        currentPage.getTableView().scrollToItem(percentage, ScrollDirection.UP);
        Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_arrow_img_1_" + (num - 1)).isExisted());
        Assert.assertTrue(percentage.getContent().startsWith("-"));
    }

    public void checkOverviewHoldingTWRR2dp() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        String performanceId = "allocation_holding_list_tablecell_weight_label_1_";
        String baseAmountId = "allocation_holding_list_tablecell_base_amount_label_1_";
        for (int i = 0; i < num; i++) {
            BaseWebElement performance = currentPage.getElementById(performanceId + i);
            BaseWebElement baseAmount = currentPage.getElementById(baseAmountId + i);
            currentPage.getTableView().scrollToItem(baseAmount, ScrollDirection.UP);
            if (performance.isVisible() && StringUtils.isNotBlank(performance.getContent())) {
                CheckUtil.check2dp(CheckUtil.getAmount(performance.getContent()));
            }
        }
    }

    public void checkOverviewHoldingTWRRZero() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement percentage = new BaseWebElement("allocation_holding_list_tablecell_weight_label_1_" + (num - 1));
        currentPage.getTableView().scrollToItem(percentage, ScrollDirection.UP);
        Assert.assertEquals(percentage.getContent(), "0.00%");
    }

    public void checkOverviewHoldingTWRRNoSymbolAndNoChevron() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement percentage = new BaseWebElement("allocation_holding_list_tablecell_weight_label_1_" + (num - 1));
        currentPage.getTableView().scrollToItem(percentage, ScrollDirection.UP);
        Assert.assertFalse(percentage.getContent().startsWith("+"));
        Assert.assertFalse(percentage.getContent().startsWith("-"));
    }

    public void tapCurrencyIcon() {
        sleep(300L);
        captureScreen();
        currentPage.getCurrencyBtn().click();
    }

    public void checkHoldingWrapperUI(Map<String, String> map) {
        sleep(500L);
        captureScreen();
        this.assertIsDisplayed(map);
    }

    public void checkHoldingListOrdered() {
        sleep(500L);
        captureScreen();
        currentPage.getTableView().scrollToItem(currentPage.getHoldingList0(), ScrollDirection.DOWN);
        Integer itemNum = UserProfileUtil.getCurrentUserProfile().getTotalNum() - 1;

        System.out.println("itemNum:--->" + itemNum);
        Double[] reportAmount = new Double[itemNum + 1];
        String baseAmountId = "allocation_holding_list_tablecell_base_amount_label_1_";
        String reportAmountId = "allocation_holding_list_tablecell_report_amount_label_1_";
        String nextElementTitleId = "allocation_holding_list_tablecell_title_label_1_";
        for (int i = 0; i < itemNum; i++) {
            BaseWebElement reportElement = new BaseWebElement(reportAmountId + i);
            BaseWebElement baseElement = new BaseWebElement(baseAmountId + i);
            if (i < itemNum) {
                BaseWebElement nextElementTitle = new BaseWebElement(nextElementTitleId + (i + 1));
                if (!baseElement.isVisible() || !nextElementTitle.isVisible()) {
                    System.out.println("[" + i + "] item not display, will be scroll");
                    if (i == 15) {
                        sleep(500L);
                        currentPage.getTableView().scrollToItem(nextElementTitle, ScrollDirection.UP);
                    }
                    currentPage.getTableView().scrollToItem(nextElementTitle, ScrollDirection.UP);
                }
            } else if (i == itemNum) {
                currentPage.getTableView().scroll(ScrollDirection.UP, 1000L, 1000);
            }

            if (!reportElement.isVisible()) {
                reportAmount[i] = CheckUtil.getNoISOAmount(baseElement.getContent());
            } else {
                reportAmount[i] = CheckUtil.getNoISOAmount(reportElement.getContent());
            }
        }

        for (int i = 0; i < reportAmount.length - 2; i++) {
            org.junit.Assert.assertTrue("amount order error: [" + reportAmount[i] + "] and [" + reportAmount[i + 1] + "]", reportAmount[i] >= reportAmount[i + 1]);
        }
    }

    public void tapHoldingsGroupedPerSubAssetClass() {
        currentPage.getHoldingGroupTypeBtn().click();
    }

    public void swipeLeftHolingList() {
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        if (num != null) {
            BaseWebElement amount = new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num - 1));
            currentPage.getTableView().scrollToItem(amount, ScrollDirection.UP);
            elementState.put("holdingsAmount", amount.getContent());
        }
        this.swipeWrapper(ScrollDirection.LEFT);
    }

    private void swipeWrapper(ScrollDirection scrollDirection) {
        if (driverConfig.getPlatform().equals(Platform.ANDROID)) {
            currentPage.getHoldingCollection().scroll(scrollDirection, 500L);
        } else {
            JavascriptExecutor js = driverConfig.getDriver();
            HashMap<String, String> swipeObject = new HashMap<String, String>();
            if (scrollDirection.equals(ScrollDirection.LEFT)) {
                swipeObject.put("direction", "right");
                js.executeScript("mobile: scroll", swipeObject);
            } else {
                swipeObject.put("direction", "left");
                js.executeScript("mobile: scroll", swipeObject);
            }
        }
    }

    public void checkHoldingListWillChanged() {
        sleep(3000L);
        captureScreen();
        currentPage.getTableView().scrollToTopItem(currentPage.getHoldingGroupTypeBtn());
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement amount = new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num - 1));
        currentPage.getTableView().scrollToItem(amount, ScrollDirection.UP);
        System.out.println("amount:"+amount.getContent() + "  map: "+elementState.get("holdingsAmount"));
        Assert.assertNotEquals(amount.getContent(), elementState.get("holdingsAmount"));
    }

    public void checkAllocationHoldingsWrapperBaseCurrencyFormat() {
        sleep(500L);
        captureScreen();
        String amount = currentPage.getAmountNumber().getContent();
        CheckUtil.checkDataFormat(CheckUtil.getAmount(amount));
        CheckUtil.check2dp(CheckUtil.getAmount(amount));
        CheckUtil.checkStringISO3(CheckUtil.getCurrency(amount));
    }

    public void checkSubAssetClassesOrdered() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getSubClassTypeNum();
        Integer holdingListNum = UserProfileUtil.getCurrentUserProfile().getGroupHoldingListNum();
        currentPage.getTableView().scrollToItem(currentPage.getHoldingListHeadAmount(), ScrollDirection.DOWN);
        this.checkNumberOrderByDesc(currentPage.getTableView(), "allocation_holding_list_tablecell_base_amount_label_1_", null, 0, holdingListNum - 1);

        currentPage.getTableView().scrollToItem(currentPage.getHoldingListHeadAmount(), ScrollDirection.DOWN);
        this.checkNumberOrderByDesc(currentPage.getTableView(), "allocation_holding_list_tablehead_subasset_amount_label_", null, 1, num);
    }

    public void checkSubClassBaseCurrencyFormat() {
        sleep(500L);
        captureScreen();
        currentPage.getTableView().scrollToTopItem(currentPage.getHoldingGroupTypeBtn());
        Integer num = UserProfileUtil.getCurrentUserProfile().getSubClassTypeNum();
        String amount = "allocation_holding_list_tablehead_subasset_amount_label_";
        BaseWebElement element = null;
        for (int i = 1; i <= num; i++) {
            element = new BaseWebElement(amount + i);
            System.out.println("find ID: "+(amount + i));
            currentPage.getTableView().scrollToItem(element, ScrollDirection.UP);
            CheckUtil.checkDataFormat(CheckUtil.getAmount(
                    element.getContent()
            ));
            CheckUtil.check2dp(CheckUtil.getAmount(
                    element.getContent()
            ));

            CheckUtil.checkCurrencyISO3(element);
        }
    }

    public void checkHoldingsGroupedByEachSubAssetClass() {
        sleep(500L);
        captureScreen();
        currentPage.getTableView().scrollToItem(currentPage.getHoldingListHeadAmount(), ScrollDirection.DOWN);
        Assert.assertTrue(currentPage.getHoldingListHeadAmount().isVisible());
        Assert.assertTrue(currentPage.getHoldingList0().isVisible());
    }

    public void checkTotalValueForEachSubAssetClass() {
        sleep(500L);
        captureScreen();
        currentPage.getTableView().scrollToItem(currentPage.getHoldingListHeadAmount(), ScrollDirection.UP);
        Assert.assertTrue(currentPage.getHoldingListHeadAmount().isVisible());
    }

    public void checkParticularAssetClass() {
        Assert.assertTrue(currentPage.getHoldingList0().isVisible());
    }

    public void swipeLeftWrapper() {
        elementState.put("holdingWrapperName", currentPage.getTitleTxt().getContent());
        elementState.put("totalAmount", currentPage.getAmountNumber().getContent());
        this.swipeWrapper(ScrollDirection.LEFT);
    }

    public void checkWrapperChanged() {
        sleep(3000L);
        captureScreen();
        Assert.assertNotEquals(currentPage.getTitleTxt().getContent(), elementState.get("holdingWrapperName"));
        Assert.assertNotEquals(currentPage.getAmountNumber().getContent(), elementState.get("totalAmount"));
    }

    public void swipeLeftToOtherAssetSubclass() {
        elementState.put("assetHeadName", currentPage.getHoldingListHeadName().getContent());
        elementState.put("totalAssetHeadAmount", currentPage.getHoldingListHeadAmount().getContent());
        this.swipeWrapper(ScrollDirection.LEFT);
    }

    public void checkGroupedBySubclassHoldingListChanged() {
        sleep(500L);
        captureScreen();
        currentPage.getTableView().scrollToTopItem(currentPage.getHoldingGroupTypeBtn());
        //num 从1开始
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement name = new BaseWebElement("allocation_holding_list_tablehead_subasset_name_label_" + num);

        currentPage.getTableView().scrollToItem(name, ScrollDirection.UP);
        Assert.assertNotEquals(name.getContent(), elementState.get("assetHeadName"));
        Assert.assertNotEquals(new BaseWebElement("allocation_holding_list_tablehead_subasset_amount_label_" + num).getContent(), elementState.get("totalAssetHeadAmount"));
    }

    public void swipe1StToLast() {
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        String name = currentPage.getTitleTxt().getContent();
        for (int i = 0; i < num - 1; i++) {
            this.swipeWrapper(ScrollDirection.LEFT);
        }
        sleep(2000L);
        Assert.assertNotEquals(currentPage.getTitleTxt().getContent(), name);
    }

    public void swipeLeftEndingLoop() {
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum() + 1;
        String name = currentPage.getTitleTxt().getContent();
        for (int i = 0; i < num; i++) {
            this.swipeWrapper(ScrollDirection.LEFT);
        }
        Assert.assertEquals(currentPage.getTitleTxt().getContent(), name);
    }

    public BaseWebElement getHoldingNameTxt(int index) {
        return currentPage.getElementById("allocation_holding_list_tablecell_title_label_1_" + index);
    }

    public BaseWebElement getHoldingBaseAmount(int index) {
        return currentPage.getElementById("allocation_holding_list_tablecell_base_amount_label_1_" + index);
    }

    public BaseWebElement getHoldingPercentage(int index) {
        return currentPage.getElementById("allocation_holding_list_tablecell_weight_label_1_" + index);
    }

    public BaseWebElement getHoldingImg(int index) {
        return currentPage.getElementById("allocation_holding_list_tablecell_arrow_img_1_" + index);
    }

    public void checkHoldingsView() {
        Assert.assertTrue(currentPage.getTableView().isVisible());
    }

    public void checkAmountEqualsAllHoldingsListValue() {
        sleep(500L);
        captureScreen();
        currentPage.getTableView().scrollToItem(currentPage.getHoldingList0(), ScrollDirection.DOWN);
        Integer itemNum = UserProfileUtil.getCurrentUserProfile().getTotalNum() - 1;

//        Double[] reportAmount = new Double[itemNum];
        double reportAmount = 0.00;
        String baseAmountId = "allocation_holding_list_tablecell_base_amount_label_1_";
        String reportAmountId = "allocation_holding_list_tablecell_report_amount_label_1_";
        String nextElementTitleId = "allocation_holding_list_tablecell_title_label_1_";
        for (int i = 1; i <= itemNum; i++) {
            BaseWebElement reportElement = new BaseWebElement(reportAmountId + i);
            BaseWebElement baseElement = new BaseWebElement(baseAmountId + i);
            if (i < itemNum) {
                BaseWebElement nextElementTitle = new BaseWebElement(nextElementTitleId + (i + 1));
                if (!baseElement.isVisible() || !nextElementTitle.isVisible()) {
                    System.out.println("[" + i + "] item not display, will be scroll");
                    currentPage.getTableView().scrollToItem(nextElementTitle, ScrollDirection.UP);
                }
            } else if (i == itemNum) {
                currentPage.getTableView().scroll(ScrollDirection.UP, 1000L, 1000);
            }

            if (!reportElement.isVisible()) {
                reportAmount = reportAmount + CheckUtil.getNoISOAmount(baseElement.getContent());
            } else {
                reportAmount = reportAmount + CheckUtil.getNoISOAmount(reportElement.getContent());
            }
        }

        org.testng.Assert.assertEquals(reportAmount, CheckUtil.getNoISOAmount(currentPage.getAmountNumber().getContent()));
    }

    public void checkOverviewBaseCurrencyISO3CodeFormat() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum() - 1;
        String amount = "allocation_holding_list_tablecell_base_amount_label_1_";
        currentPage.getTableView().scrollToItem(currentPage.getHoldingList0(), ScrollDirection.DOWN);
        BaseWebElement element = null;
        for (int i = 1; i <= num; i++) {
            element = new BaseWebElement(amount + i);
            currentPage.getTableView().scrollToItem(element, ScrollDirection.UP);
            if (i == 15) {
                sleep(500L);
                currentPage.getTableView().scrollToItem(element, ScrollDirection.UP);
            }
            CheckUtil.checkDataFormat(CheckUtil.getAmount(
                    element.getContent()
            ));
            CheckUtil.check2dp(CheckUtil.getAmount(
                    element.getContent()
            ));

            CheckUtil.checkCurrencyISO3(element);
        }
    }

    public void checkWeightPositive() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(currentPage.getHoldingPercentage().getContent().startsWith("-"));
    }

    public void checkWeightNegative() {
        sleep(500L);
        captureScreen();
        System.out.println("value: " + currentPage.getHoldingPercentage().getContent());
        Assert.assertTrue(currentPage.getHoldingPercentage().getContent().startsWith("-"));
    }

    public void checkWeightZero() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(currentPage.getHoldingPercentage().isVisible());
    }

    public void checkSubClassAmountSumOfHoldingListAmount() {
        currentPage.getTableView().scrollToItem(currentPage.getHoldingList0(), ScrollDirection.DOWN);
        double subClassAmount = CheckUtil.getNoISOAmount(currentPage.getHoldingListHeadAmount().getContent());

        Integer holdingListNum = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        double reportAmount = 0.00;
        String baseAmountId = "allocation_holding_list_tablecell_base_amount_label_1_";
        String reportAmountId = "allocation_holding_list_tablecell_report_amount_label_1_";
        String nextElementTitleId = "allocation_holding_list_tablecell_title_label_1_";
        for (int i = 0; i < holdingListNum; i++) {
            BaseWebElement reportElement = new BaseWebElement(reportAmountId + i);
            BaseWebElement baseElement = new BaseWebElement(baseAmountId + i);
            if (i < (holdingListNum - 1)) {
                BaseWebElement nextElementTitle = new BaseWebElement(nextElementTitleId + (i + 1));
                if (!baseElement.isVisible() || !nextElementTitle.isVisible()) {
                    System.out.println("[" + i + "] item not display, will be scroll");
                    currentPage.getTableView().scrollToItem(nextElementTitle, ScrollDirection.UP);
                }
            } else if (i == (holdingListNum - 1)) {
                currentPage.getTableView().scroll(ScrollDirection.UP, 1000L, 1000);
            }

            if (!reportElement.isVisible()) {
                reportAmount = reportAmount + CheckUtil.getNoISOAmount(baseElement.getContent());
//                System.out.println("Add baseAmount ["+(i+1)+"]: "+CheckUtil.getNoISOAmount(baseElement.getContent()));
            } else {
                reportAmount = reportAmount + CheckUtil.getNoISOAmount(reportElement.getContent());
//                System.out.println("Add reportAmount ["+(i+1)+"]: "+CheckUtil.getNoISOAmount(reportElement.getContent()));
            }
        }
        org.testng.Assert.assertEquals(reportAmount, subClassAmount);
    }

    public void checkSubClassAmountSumOfHoldingWrapperAmount() {
        currentPage.getTableView().scrollToTopItem(currentPage.getHoldingGroupTypeBtn());

        double wrapperAmount = CheckUtil.getNoISOAmount(currentPage.getAmountNumber().getContent());
        Integer subClassNum = UserProfileUtil.getCurrentUserProfile().getSubClassTypeNum();

        double subClassAmount = 0.0;
        String subClassAmountPrefix = "allocation_holding_list_tablehead_subasset_amount_label_";
        for (int i = 1; i <= subClassNum; i++) {
            BaseWebElement subClassAmountElement = new BaseWebElement(subClassAmountPrefix + i);
            System.out.println("find ID: " + (subClassAmountPrefix + i));
            currentPage.getTableView().scrollToItem(subClassAmountElement, ScrollDirection.UP);
            subClassAmount += CheckUtil.getNoISOAmount(subClassAmountElement.getContent());
            System.out.println("Add amount: "+CheckUtil.getNoISOAmount(subClassAmountElement.getContent()));
        }

        org.testng.Assert.assertEquals(wrapperAmount, subClassAmount);
    }

    public void tapFirstHolding() {
        currentPage.getHoldingList0().click();
    }

    public void onTheAllocationHoldingList() {
        Assert.assertTrue(currentPage.getHoldingGraphic().isExisted());
    }
}
