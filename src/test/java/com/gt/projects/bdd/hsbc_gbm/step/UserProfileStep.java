package com.gt.projects.bdd.hsbc_gbm.step;

import com.gt.projects.bdd.base.BaseStep;
import com.gt.projects.bdd.base.BaseWebElement;
import com.gt.projects.bdd.base.enums.ScrollDirection;
import com.gt.projects.bdd.hsbc_gbm.flow.AccountsFlow;
import com.gt.projects.bdd.hsbc_gbm.flow.AllocationGraphicFlow;
import com.gt.projects.bdd.hsbc_gbm.flow.LoginFlow;
import com.gt.projects.bdd.hsbc_gbm.flow.OverviewFlow;
import com.gt.projects.bdd.hsbc_gbm.page.AllocationGraphicPage;
import com.gt.projects.bdd.hsbc_gbm.page.AllocationHoldingListPage;
import com.gt.projects.bdd.hsbc_gbm.page.AllocationListPage;
import com.gt.projects.bdd.hsbc_gbm.page.PortfoliosPage;
import com.gt.projects.bdd.hsbc_gbm.util.UserProfile;
import com.gt.projects.bdd.hsbc_gbm.util.UserProfileUtil;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class UserProfileStep extends BaseStep {

    @Autowired
    private LoginFlow loginFlow;

    @Autowired
    private OverviewFlow overviewFlow;

    @Autowired
    private AccountsFlow accountsFlow;

    @Autowired
    private AllocationGraphicFlow allocationGraphicFlow;

    @Autowired
    private AllocationHoldingListPage allocationHoldingListPage;

    @Autowired
    private PortfoliosPage portfoliosPage;

    @Autowired
    private AllocationListPage allocationListPage;

    @Given("^I login as type \"([^\"]*)\"$")
    public void loginAsType(String type) {
        UserProfile userProfile = UserProfileUtil.getUserProfileByType(type.replaceAll(" ", "_"));
        UserProfileUtil.setCurrentUserProfile(userProfile);
        System.out.println("Get userProfile:" + userProfile);

//        if (userProfile.getUserName() == null) {
//            // select customer ID
            loginFlow.loginAsCustomerId(userProfile.getCustomerId());
//        } else {
            // input userName and password
//            loginFlow.loginAsUserNameAndPassword(userProfile.getUserName(), userProfile.getPassword());
//        }

        if (userProfile.getAccountNum() != null) {
            // select account item
            overviewFlow.clickAccountByNum(userProfile.getAccountNum());
        }
        if (userProfile.getPortfolioNum() != null) {
            // select portfolio item
            accountsFlow.clickPortfolioByNum(userProfile.getPortfolioNum());
        }

        if (userProfile.getClassNum() != null || userProfile.getCurrencyNum() != null || userProfile.getRegionNum() != null || userProfile.getAllocationHoldingNum() != null) {
            executeAllocation(userProfile);
        } else if (userProfile.getHoldingNum() != null){
            portfoliosPage.getMainHoldingsBtn().click();
            BaseWebElement holdingItem = new BaseWebElement("portfolio_holdings_list_tableview_cell_"+(userProfile.getHoldingNum() - 1));
            tapTargetElement(portfoliosPage.getMainHoldingTableview(), holdingItem);
        } else if (userProfile.getTransactionNum() != null){
            portfoliosPage.getMainTransactionsBtn().click();
            BaseWebElement transactionItem = new BaseWebElement("portfolio_transactions_list_tablecell_"+(userProfile.getTransactionNum() - 1));
            tapTargetElement(portfoliosPage.getMainTransactionsTableView(), transactionItem);
        } else if (userProfile.getLiabilitiesNum() != null){
            portfoliosPage.getMainLiabilitiesBtn().click();
            if(userProfile.getSubLiabilitiesNum() == null){
                BaseWebElement liabilitiesItem = new BaseWebElement("portfolio_liabilities_tableview_cell_"+userProfile.getLiabilitiesNum());
                tapTargetElement(portfoliosPage.getPortfolioHoldingsListTableview(), liabilitiesItem);
            } else {
                if(portfoliosPage.getLiabilitiesGroupByTypeBtnOff().isVisible()){
                    portfoliosPage.getLiabilitiesGroupByTypeBtnOff().click();
                }
                BaseWebElement subLiabilitiesItem = new BaseWebElement("portfolio_liabilities_tableview_cell_"+ userProfile.getLiabilitiesNum() +"_"+(userProfile.getSubLiabilitiesNum() - 1));
                tapTargetElement(portfoliosPage.getMainLiabilitiesTableView(), subLiabilitiesItem);
            }
        }

    }

//    private void executeAllocation(UserProfile userProfile) {
//        String level = "";
//        String allocationBtnId = "";
//        String listViewId = "";
//        String elementId = "";
//        switch (userProfile.getScreenLevel()) {
//            case UserProfileUtil.CUSTOMER_LEVEL:
//                level = "overview";
//                allocationBtnId = "overview_main_allocation_off_btn";
//                break;
//            case UserProfileUtil.ACCOUNT_LEVEL:
//                level = "account";
//                allocationBtnId = "account_main_allocation_off_btn";
//                break;
//            case UserProfileUtil.PORTFOLIO_LEVEL:
//                level = "portfolios";
//                allocationBtnId = "portfolio_holdings_allocation_off_btn";
//                break;
//            default:
//                Assert.assertTrue("Levels beyond expectations! Screen Level [" + userProfile.getScreenLevel() + "]", false);
//                break;
//        }
//
//        BaseWebElement allocationBtn = new BaseWebElement(allocationBtnId);
//        if(allocationBtn.isVisible()){
//            allocationBtn.click();
//        }
//
//        if (userProfile.getClassNum() != null) {
//            new BaseWebElement(level + "_main_class_btn").click();
//            listViewId = level + "_main_class_tableview";
//            if (userProfile.getSubClassNum() == null){
//                elementId = level + "_class_list_tableview_cell_" + userProfile.getClassNum() + "_0";
//            } else {
//                BaseWebElement subClassOffBtn = new BaseWebElement(level + "_allocation_class_sub_class_off_btn");
//                if (subClassOffBtn.isVisible()) {
//                    subClassOffBtn.click();
//                }
//                elementId = level + "_subclass_list_tableview_cell_" + userProfile.getClassNum() + "_" + (userProfile.getSubClassNum() - 1);
//            }
//        } else if (userProfile.getCurrencyNum() != null) {
//            new BaseWebElement(level + "_main_currency_btn").click();
//            listViewId = level + "_main_currency_tableview";
//            elementId = level + "_currency_tableview_cell_0_" + (userProfile.getCurrencyNum() - 1);
//        } else if (userProfile.getRegionNum() != null){
//            new BaseWebElement(level + "_main_region_btn").click();
//            listViewId = level + "_main_region_tableview";
//            elementId = level + "_region_tableview_cell_0_" + (userProfile.getRegionNum() - 1);
//        }
//
//        BaseWebElement listView = new BaseWebElement(listViewId);
//        BaseWebElement targetElement = new BaseWebElement(elementId);
//        listView.scrollToItem(targetElement, ScrollDirection.UP);
//        targetElement.click();
//
//        if (userProfile.getAllocationHoldingNum() != null){
//            BaseWebElement holdingElement = new BaseWebElement("allocation_holdings_list_tableview_cell_" + (userProfile.getAllocationHoldingNum() - 1));
//            tapTargetElement(allocationHoldingListPage.getTableView(), holdingElement);
//        }
//    }

    private void executeAllocation(UserProfile userProfile) {
        String targetElementId = "allocation_list_tablecell_pie_chart_view_";

        BaseWebElement allocationBtn = allocationGraphicFlow.getAllocationToggle();

        allocationBtn.click();
        allocationGraphicFlow.swipeUpAllocationGraphicPage();

        if (userProfile.getClassNum() != null) {
            new BaseWebElement("allocation_tab_asset_class_btn").click();
            int num = (userProfile.getClassNum() - 1);
            targetElementId += (userProfile.getClassNum() - 1);
//            if(num == 0)
//            {
//                targetElementId = targetElementId.replace("_0","");
//            }
            if(userProfile.getAllocationHoldingNum() != null && userProfile.getSubAllocationHoldingNum() != null){
                new BaseWebElement(targetElementId).click();
                new BaseWebElement("allocation_holding_group_type_btn").click();
                BaseWebElement holdingListView = new BaseWebElement("allocation_holding_list_tableview");
                BaseWebElement targetSubHolding = new BaseWebElement("allocation_holdings_list_tableview_cell_"+userProfile.getAllocationHoldingNum()+"_"+(userProfile.getSubAllocationHoldingNum() - 1));
                tapTargetElement(holdingListView, targetSubHolding);
                return;
            }
        } else if (userProfile.getCurrencyNum() != null) {
            new BaseWebElement("allocation_tab_currency_btn").click();
            targetElementId += (userProfile.getCurrencyNum() - 1);
        } else if (userProfile.getRegionNum() != null){
            new BaseWebElement("allocation_tab_region_btn").click();
            targetElementId += (userProfile.getRegionNum() - 1);
        }


//        new BaseWebElement(targetElementId).click();
        tapTargetElement(allocationListPage.getAllocationListTableView(), new BaseWebElement(targetElementId));

        if (userProfile.getAllocationHoldingNum() != null){
            BaseWebElement holdingElement = new BaseWebElement("allocation_holdings_list_tableview_cell_1_" + (userProfile.getAllocationHoldingNum() - 1));
            tapTargetElement(allocationHoldingListPage.getTableView(), holdingElement);
        }
    }

    public void tapTargetElement(BaseWebElement listView, BaseWebElement targetElement){
        listView.scrollToItem(targetElement, ScrollDirection.UP);
        targetElement.click();
    }
}
