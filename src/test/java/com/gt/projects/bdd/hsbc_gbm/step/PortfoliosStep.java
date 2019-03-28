package com.gt.projects.bdd.hsbc_gbm.step;

import com.gt.projects.bdd.base.BaseStep;
import com.gt.projects.bdd.base.annotation.Action;
import com.gt.projects.bdd.hsbc_gbm.flow.AccountsFlow;
import com.gt.projects.bdd.hsbc_gbm.flow.ContingentLiabilitiesFlow;
import com.gt.projects.bdd.hsbc_gbm.flow.PortfoliosFlow;
import com.gt.projects.bdd.hsbc_gbm.util.RegionUtil;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.it.Ma;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class PortfoliosStep extends BaseStep {

    @Autowired
    private PortfoliosFlow portfoliosFlow;

    @Autowired
    private AccountsFlow accountsFlow;

    @Autowired
    private ContingentLiabilitiesFlow contingentLiabilitiesFlow;

    @Action("back_to_account_default")
    public void backTwoScroll(){
        accountsFlow.backTwoScroll();
    }

    @Action("transactions_scroll_to_top")
    public void scrollToTop(){
        portfoliosFlow.scrollToTop();
    }

    @Action("back_scroll_default_and_click_allocation")
    public void scrollAndTapAllocation(){
        accountsFlow.scrollAndTapAllocation();
    }

    @Action("back_account_level")
    public void backAccountLevel(){portfoliosFlow.tapBackButton();}

    @Action("back_account_level_that_in_Overlay")
    public void backAccountLevelOverlay(){
        portfoliosFlow.closeOverlay();
        portfoliosFlow.tapBackButton();
    }

    @Action("tap_filter_Ok_Btn")
    public void tapFilterOkBtn(){portfoliosFlow.tapFilterOkBtn();}

    @Action("portfolio_back_overview_level")
    public void backOverviewLevel(){
        portfoliosFlow.tapBackButton();
        accountsFlow.tapBackButton();
    }

    @Action("click_portfolio_amount")
    public void clickPortfolioAmount(){
        this.tapPortfolioTotalAssetsValue();
    }

    @Action("open_total_liabilities_overlay_on_portfolio")
    public void closeOverlay() {
        portfoliosFlow.tapPortfolioTotalLiabilities();
    }

    @Action("click_asset_overlay_close_button")
    public void clickOverlayCloseButton(){
        portfoliosFlow.closeOverlay();
    }

    @Action("click_liability_overlay_close_button")
    public void clickLiabilityOverlayCloseButton(){
        portfoliosFlow.clickLiabilityOverlayCloseButton();
    }

    @Action("click_legal_disclaimer_overlay_close_button")
    public void clickLegalDisclaimerOverlayCloseButton(){
        portfoliosFlow.clickLegalDisclaimerOverlayCloseButton();
    }



    //Sprint 1 start
    @When("^I tap on Asset Allocation toggle$")
    public void tabAssetAllocation(){
        portfoliosFlow.tabAssetAllocation();
    }


    @Then("^I should see the following UI Elements on the Portfolios Class Level$")
    public void checkPortfoliosVersionUI(DataTable dataTable){
        portfoliosFlow.checkPortfoliosVersionUI(dataTable);
    }
//
//    @Given("^I see the following UI Elements on the Portfolios Class Level$")
//    public void portfoliosVersionUI(DataTable dataTable){
//        portfoliosFlow.checkPortfoliosVersionUI(dataTable);
//    }

    @Then("^I should see the following data for Asset Class name、Total asset ISO3 format value、Total asset 2dp format value、Total assets 2dp percentage value$")
    public void checkPortfolioClassTabDataFormat() {
        portfoliosFlow.checkClassTabDataFormat();
    }

    @Then("^I should see the asset classes are ordered by Total Asset value - largest first to smallest last, then by alphabetical order$")
    public void checkPortfolioClassTotalAmountDataOrder(){
        portfoliosFlow.checkTotalDataOrder();
    }

    @When("^I tap fourth item of Accounts List$")
    public void tapAccountsList4(){
        portfoliosFlow.tapAccountsList4();
    }

    @And("^I tap 16th item of Portfolio List$")
    public void tapPortfolioList16() {
        portfoliosFlow.tapPortfolioList16();
    }

    @Then("^I shouldn't see the asset classes listed in portfolio$")
    public void checkNotSeeClassList() {
        portfoliosFlow.checkNotSeeClassList();
    }

    @When("^I taps \"Show Sub-Asset Class\" toggle ON within default Asset Class view$")
    public void tapPortfolioShowSubAssetClassON(){
        portfoliosFlow.tapPortfolioShowSubAssetClass();
    }

    @Then("^I should see the following data:Asset Class name、Total asset ISO3 format value、Total asset 2dp format value$")
    public void checkSubClassHeadDateFormat(){
        portfoliosFlow.checkSubClassHeadDateFormat();
    }

    @Then("^I should see the following data:Sub-Asset Class name、Total asset 2dp format value、Total assets 2dp percentage value$")
    public void checkSubClassDateFormat(){
        portfoliosFlow.checkSubClassDateFormat();
    }

    @Then("^I should see the sub-asset classes are ordered by Total Asset value - largest \\(first\\) to smallest \\(last\\), then by alphabetical order on Portfolios$")
    public void checkSubClassDataOrder(){
        portfoliosFlow.checkSubClassDataOrder();
    }

    @When("^I navigates away to another Portfolio、 Account$")
    public void tapToAnotherPortfolioAccount() {
        portfoliosFlow.tapToAnotherPortfolioAccount();
    }

    @And("^I come back to the previouse Portfolio level screen$")
    public void backToPortfolioLevel() {
        portfoliosFlow.backToPortfolioLevel();
    }

    @Then("^I should see the sub-asset class toggle should stay ON for this Portfolio \\(only\\) during the current app session \\(only\\),even if the user navigates away to another Portfolio, Account or Overview screen$")
    public void checkSubAssetClassON_OtherPortfolioAccount() {
        portfoliosFlow.checkSubAssetClassON_OtherPortfolioAccount();
    }

    @When("^I taps \"Show Sub-Asset Class\" toggle OFF within default Asset Class view$")
    public void tapPortfolioShowSubAssetClassOFF() {
        portfoliosFlow.tapPortfolioShowSubAssetClass();
    }

    @Then("^I should see the following states:\"show sub-asset class\" toggle = INACTIVE$")
    public void checkPortfolioShowSubAssetClassIsOFF() {
        portfoliosFlow.checkPortfolioShowSubAssetClassIsOFF();
    }

    @Then("^I should see the following data for Sub-Asset Class name、Total Sub-asset 2dp format value、Total Sub-assets 2dp percentage value$")
    public void checkPortfolioDataFormat(){
        portfoliosFlow.checkClassTabDataFormat();

    }

    @Then("^I should see the Total asset value equals the sum of all the sub-asset class value$")
    public void checkTotalAssetEqualsTheSumOfAllTheSubAssetClass(){
        portfoliosFlow.checkTotalAssetEqualsTheSumOfAllTheSubAssetClass();
    }

    @And("^I taps on \"Region\" tab$")
    public void tapsOnRegionTab(){
        portfoliosFlow.tapsOnRegionTab();
    }

    @Then("^I should see Region tab the following data format:Region name、Total asset ISO3 format value、Total asset 2dp format value、Total asset 2dp percentage value$")
    public void checkPortfolioRegionDataFormat(){
        portfoliosFlow.checkPortfolioRegionDataFormat();
    }

    @Then("^I should see the regions are ordered by Total Asset value - largest \\(first\\) to smallest \\(last\\) on Region module$")
    public void checkPortfolioRegionTotalAmountDataOrder() {
        portfoliosFlow.checkPortfolioRegionTotalAmountDataOrder();
    }

    @Then("^I should not see Portfolio that Region listed$")
    public void checkNotSeeRegionList() {
        portfoliosFlow.checkNotSeeRegionList();

    }
    //Sprint 1 end


    @Then("^I am on the Portfolios Screen$")
    public void onThePortfoliosScreen() {

        portfoliosFlow.onThePortfoliosScreen();
    }

    @Then("^I should not see the Contingent Liabilities tab$")
    public void notSeeContingentLiabilitiesTab(){
        portfoliosFlow.notSeeContingentLiabilitiesTab();
    }

    @Then("^I should see the following UI Elements on the Portfolios Class tab$")
    public void noHoldingsClass(DataTable dataTable) {
        portfoliosFlow.noHoldingsClass(RegionUtil.getMap(dataTable));
    }

    @Given("^I am on the Portfolios Allocation Screen$")
    public void portfolioScreenAndTapPortfoliosAllocationToggle() {
        portfoliosFlow.portfolioScreenAndTapPortfoliosAllocationToggle();
    }

    @Then("^I should on the portfolio allocation screen$")
    public void onPortfolioAllocationScreen() {
        portfoliosFlow.portfolioScreenAndTapPortfoliosAllocationToggle();
    }

    @When("^I tap Portfolio Currency tab$")
    public void tapPortfolioCurrencyTab() {
        portfoliosFlow.tapPortfolioCurrencyTab();
    }

    @Then("^I should see the following UI Elements on the Portfolio Currency tab$")
    public void noHoldingsCurrency(DataTable dataTable) {
        portfoliosFlow.noHoldingsCurrency(RegionUtil.getMap(dataTable));
    }

    @When("^I tap Portfolio Region tab$")
    public void tapPortfolioRegionTab() {
        portfoliosFlow.tapPortfolioRegionTab();
    }

    @Then("^I should see the following UI Elements on the Portfolio Region tab$")
    public void noHoldingsRegion(DataTable dataTable) {
        portfoliosFlow.noHoldingsRegion(RegionUtil.getMap(dataTable));
    }

    @And("^I save control state on Portfolios Screen$")
    public void saveControlStateOnPortfolios() {
        portfoliosFlow.saveControlStateOnPortfolios();
    }

    @And("^I tap on the Contingent Liabilities tab$")
    public void tapContingentLiabilitiesTab() {
        portfoliosFlow.tapContingentLiabilitiesTab();
    }

    @Then("^I should return to list view of all Contingent Liabilities within the Portfolio$")
    public void showContingentLiabilitiesListWithin() {
        portfoliosFlow.showContingentLiabilitiesListWithin();
    }

    @When("^I tap the Transactions button$")
    public void tapTransactionsBtn() {
        portfoliosFlow.tapTransactionsBtn();
    }

    @Given("^I should not see Transactions list$")
    public void notTransactions() {
        portfoliosFlow.notTransactions();
    }

    @When("^I tap the head title$")
    public void tapHeadTitle() {
//        portfoliosFlow.scrollUpTransactionList();
        portfoliosFlow.tapHeadTitle();
    }

    @Then("^I should see four item of transactions list of \"Purchases\" filter are displayed$")
    public void checkListPurchases(Map<String,String> map) {
        portfoliosFlow.checkListPurchases(map);
    }

    @Then("^I should see three item of transactions list of \"Sales\" filter are displayed$")
    public void checkListSales(Map<String,String> map) {
        portfoliosFlow.checkListSales(map);
    }

    @Then("^I should see four item of transactions list of \"Fees\" filter are displayed$")
    public void checkListFees(Map<String,String> map) {
        portfoliosFlow.checkListFees(map);
    }

    @Then("^I should see four item of transactions list of \"Income\" filter are displayed$")
    public void checkListIncome(Map<String,String> map) {
        portfoliosFlow.checkListIncome(map);
    }

    @Then("^I should see Purchases first item negative values are displayed using a minus sign before the value$")
    public void purchasesNegativeValues() {
        portfoliosFlow.purchasesNegativeValues();
    }

    @Then("^I should see Sales second item negative values are displayed using a minus sign before the value$")
    public void salesNegativeValues() {
        portfoliosFlow.salesNegativeValues();
    }

    @Then("^I should see Cash movements second item negative values are displayed using a minus sign before the value$")
    public void cashMovementsNegativeValues() {
        portfoliosFlow.cashMovementsNegativeValues();
    }

    @Then("^I should see Fees four item negative values are displayed using a minus sign before the value$")
    public void feesNegativeValues() {
        portfoliosFlow.feesNegativeValues();
    }

    @Then("^I should see Income four item negative values are displayed using a minus sign before the value$")
    public void incomeNegativeValues() {
        portfoliosFlow.incomeNegativeValues();
    }

    @Then("^I should see specific item transaction list that contain the following details$")
    public void checkFirstItemTransactionList(DataTable dataTable) {
        portfoliosFlow.checkFirstItemTransactionListVersion(dataTable);
    }

    @Then("^I should see the specific item trade date following the format of DD Mmm YYYY$")
    public void checkTradeDate() {
        portfoliosFlow.checkFirstItemTradeDate();
    }

    @And("^I save first and two item element$")
    public void saveElementAtPurchases() {
        portfoliosFlow.saveElement();
    }

    @Then("^The filter is applied for the Transactions list within that individual portfolio for the entire app session at Purchases$")
    public void affirmElementAtTransactionPurchases() {
        affirmItemElement();
    }

    @Then("^The filter is applied for the Transactions list within that individual portfolio for the entire app session at Sales$")
    public void affirmElementAtTransactionSales() {
        affirmItemElement();
    }

    @Then("^The filter is applied for the Transactions list within that individual portfolio for the entire app session at Fees$")
    public void affirmElementAtTransactionFees() {
        affirmItemElement();
    }

    @Then("^The filter is applied for the Transactions list within that individual portfolio for the entire app session at Income$")
    public void affirmElementAtTransactionIncome() {
        affirmItemElement();
    }

    @Then("^I should see the filter is applied for the Transactions list within that portfolio for the entire app session at All$")
    public void affirmElementAtTransactionAll() {
        affirmItemElement();
    }

    private void affirmItemElement() {
        portfoliosFlow.tapBackButton();
        accountsFlow.tapPortfoliosListFirst();
        portfoliosFlow.tapTransactionsBtn();
        portfoliosFlow.affirmElement();
    }

    @Then("^I should see all transactions \\(pending and settled\\) are ordered by trade date \\(default\\), most recent first, oldest date last for item num is (\\d+)$")
    public void orderedByDate(int listNum) {
        portfoliosFlow.orderedByDate();
    }

    @Then("^I should see the following filter list of values in Transactions filter:$")
    public void checkTransactionsFilter(Map<String, String> map) {
        portfoliosFlow.checkTransactionsFilter(map);
    }

    @Given("^I see the following filter list of values in Transactions filter:$")
    public void seeTransactionsFilter(Map<String, String> map) {
        this.checkTransactionsFilter(map);
    }

    @Then("^I can see the \"OK\" button is fixed on top of the Transaction filter list$")
    public void checkFilterOKCoords() {
        portfoliosFlow.checkFilterOKCoords();
    }

    @Then("^I should see the filter bar will not be sticky on the top$")
    public void checkFilterBarNotInTop() {
        portfoliosFlow.checkFilterBarNotInTop();
    }

    @When("^I tap on Transactions filter labelled \"Type\"$")
    public void tapTransactionsFilter(){
        portfoliosFlow.tapTransactionsFilter();
    }

    @When("^I scroll the transactions list$")
    public void scrollTransactionsList(){
        portfoliosFlow.scrollTransactionsList();
    }

    @When("^I scroll the Transaction filter list$")
    public void scrollTransactionFilter(){
        portfoliosFlow.scrollTransactionFilter();
    }

    @Given("^I see the transaction list$")
    public void seeTransactionList() {
        portfoliosFlow.seeTransactionList();
    }

    @And("^I tap no portfolio for it no has transactions$")
    public void tapTransactionPortfolio(){
        portfoliosFlow.tapTransactionPortfolio();
    }

    @And("^no transactions are displayed$")
    public void checkNoTransactionList(){
        portfoliosFlow.checkNoTransactionList();
    }

    @And("^I swipe right the top pips$")
    public void swipeRightPortfolioView(){
        portfoliosFlow.swipeRightPortfolioView();
    }

    @And("^I should not see the account list pips$")
    public void checkNotAccountPips(){
        accountsFlow.checkNotAccountPips();
    }

    @And("^I should not be able to swipe left of right in account detail view$")
    public void checkNotScrollAccountPips(){
        accountsFlow.checkNotScrollAccountPips();
    }

    @And("^I tap the account Allocation Class Tab$")
    public void tapAccountClassTab(){
        portfoliosFlow.tapAccountClassTab();
    }

    @And("^I tap the account Allocation Region Tab$")
    public void tapAccountRegionTab(){
        portfoliosFlow.tapAccountRegionTab();
    }

    @And("^I slides to the 3rd account item or 2nd account item$")
    public void slideTwoRightAndOneLeft(){
        portfoliosFlow.accountSlideTwoRightAndOneLeft();
    }

    @When("^I tap on portfolio \"Holdings\" tab$")
    public void tapHoldings(){
        portfoliosFlow.tapHoldings();
    }

    @And("^no holdings are displayed$")
    public void checkNoHoldings(){
        portfoliosFlow.checkNoHoldings();
    }

    @And("^I should see Contingent liabilities bar is displayed$")
    public void checkHasContingentLiabilities(){
        portfoliosFlow.checkHasContingentLiabilities();
    }

    @Then("^I should see the following message is displayed in the transactions tab:$")
    public void checkNotTransactionMessage(Map<String, String> map){
        portfoliosFlow.checkNotTransactionMessage(map);
    }

    @Then("^I should see a detailed view relating to account item$")
    public void checkOneAccountItem(){
        accountsFlow.checkOneAccountItem();
    }

    @Then("^I should see a detailed view relating to that item$")
    public void checkTheSecondAccountDetail(){
        portfoliosFlow.checkTheSecondAccountDetail();
    }

    @Then("^The following Portfolio list data will be changed when slides the item$")
    public void checkPortfolioListChange(){
        portfoliosFlow.checkPortfolioListChange();
    }

    @Then("^The following Asset Class list data will be changed when slides the pip$")
    public void checkClassHasChange(){
        portfoliosFlow.checkClassHasChange();
    }

    @Then("^The following Sub Asset Class list data will be changed when slides the pip$")
    public void checkSubClassHasChange(){
        portfoliosFlow.checkSubClassHasChange();
    }

    @Then("^The following Asset Currency list data will be changed when slides the pip$")
    public void checkAccountCurrencyChange(){
        portfoliosFlow.checkAccountCurrencyChange();
    }

    @Then("^The following Asset Region list data will be changed when slides the pip$")
    public void checkAccountRegionChange(){
        portfoliosFlow.checkAccountRegionChange();
    }

    @Then("^I should see the following message under the holdings is displayed:$")
    public void checkNoHoldingNoCLMessage(Map<String, String> map){
        portfoliosFlow.checkNotHoldingMessage(map);
    }

    @Then("^I should see the following message under the Contingent liabilities is displayed:$")
    public void checkNoHoldingHasCLMessage(Map<String, String> map){
        this.checkNoHoldingNoCLMessage(map);
    }

    @Then("^I will see the next 15 holding list items are displayed below$")
    public void checkThirtyHoldingItem(){
        portfoliosFlow.seeThirtyHoldingItem();
    }

    @Then("^I should see the 20th item and the Holding list at Portfolio Level previously loaded \\(16th-30th\\)$")
    public void checkHoldingHasTwentyAndLoadedThirty(){
        portfoliosFlow.checkHoldingHasTwentyAndLoadedThirty();
    }

    @Then("^I should see the Holding list display the 1st to 15th item default$")
    public void checkHoldingListIsDefault(){
        portfoliosFlow.checkHoldingListIsDefault();
    }

    @When("^I taps on 2nd items in Accounts list$")
    public void tapTheSecondAccount() {
        portfoliosFlow.tapTheSecondAccount();
    }

    @When("^I reach the 15th item within the Transaction list at Portfolio Level$")
    public void transactionToFifteenItem() {
        portfoliosFlow.transactionToFifteenItem();
    }

    @When("^I slide right to the next item$")
    public void slideRight() {
        portfoliosFlow.slideRight();
    }

    @And("^I slide left to previous item$")
    public void slideLeft() {
        portfoliosFlow.slideLeft();
    }

    @Then("^I should see the filter type is Purchases$")
    public void checkTitleIsPurchases() {
        portfoliosFlow.checkTitleIsPurchases();
    }

    @Then("^I should see the filter type is Cash movements")
    public void checkTitleIsCashMovements() {
        portfoliosFlow.checkTitleIsCashMovements();
    }

    @When("^I tap Back button at portfolio level$")
    public void tapBackButton() {
        portfoliosFlow.tapBackButton();
    }

    @Then("^I should see a list of all transactions within that portfolio are displayed$")
    public void checkListOfAll() {
        portfoliosFlow.checkListOfAll();
    }

    @Then("^I should see negative values are displayed using a minus sign before the value$")
    public void checkNegativeValues() {
        portfoliosFlow.checkNegativeValues();
    }

    @And("^\"All\" filter option is already applied by default$")
    public void checkFilterIsAll() {
        portfoliosFlow.checkFilterIsAll();
    }

    @And("^I continue to load the list by swipe up the Transaction list at Portfolio Level$")
    public void scrollUpTransactionList() {
        portfoliosFlow.scrollUpTransactionList();
    }

    @Then("^I should see the following message is displayed$")
    public void noTransactions(Map<String,String> map) {
        portfoliosFlow.noTransactions(map);
    }

    @Then("^I will see the next 15 transaction list items are displayed below$")
    public void seeNextTransactionList() {
        portfoliosFlow.seeNextTransactionList();
    }

    @Then("^I should see the Transaction list previously loaded \\(16th-30th\\)$")
    public void seeTransactionPreviouslyLoaded() {
        this.seeNextTransactionList();
    }

    @Then("^I should see the Transaction list at Portfolio Level display the 1st to 15th item default$")
    public void seeFirstTransactionList() {
        portfoliosFlow.seeFirstTransactionList();
    }

    @Given("^I see a detailed view relating to account item$")
    public void seeTheSecondAccountDetail() {
        this.checkTheSecondAccountDetail();
    }

    @Given("^I am viewing the Transaction list has thirty item at Portfolio Level$")
    public void seeThirtyTransactionList() {
        this.seeNextTransactionList();
    }

    @Given("^I am viewing the Holding list are thirty item at Portfolio Level$")
    public void seeThirtyHoldingItem() {
        this.checkThirtyHoldingItem();
    }

    @When("^I slides to the 3rd account item$")
    public void slideToThirdly() {
        portfoliosFlow.slideToThirdly();
    }

    @When("^I reach the 15th item within the Holding list at Portfolio Level$")
    public void holdingReachTheFifteen() {
        portfoliosFlow.holdingReachTheFifteen();
    }

    @When("^I tap the 20th item within Holding list at Portfolio Level$")
    public void tapTwentyHoldingItem() {
        portfoliosFlow.tapTwentyHoldingItem();
    }

    @And("^I continue to load the list by swipe up the Holding list at Portfolio Level$")
    public void continueLoadHoldingList() {
        portfoliosFlow.continueLoadHoldingList();
    }

    @And("^I go back to the Portfolio Level$")
    public void tapHoldingDetailBackBtn() {
        //portfoliosFlow.tapHoldingDetailBackBtn();
        contingentLiabilitiesFlow.tapBackButton();

    }

    @When("^I come back to the Account Level$")
    public void tapPortfolioBackBtn() {
        portfoliosFlow.tapPortfolioBackBtn();
    }

    @And("^I tap the Contingent liability bar again$")
    public void tapCLBtnAgain() {
        this.tapContingentLiabilitiesTab();
    }


    @And("^NO pips to indicate that they can swipe left or right within portfolio detailed view$")
    public void noPips() {
        portfoliosFlow.noPips();
    }

    @And("^I should not be able to swipe left or right in portfolios detailed view$")
    public void checkNotSwipeLeftOrRight() {
        portfoliosFlow.checkNotSwipeLeftOrRight();
    }

    @And("^I slides to the 2th pip in Holding/Transation list and save pre-slide data$")
    public void pipSaveHoldingOrTransationData() {
        portfoliosFlow.pipSaveHoldingOrTransationData();
    }

    @Then("^the following Holding list data and Transation list data will be changed when slides the pip$")
    public void checkHoldingAndTransationDataChange() {
        portfoliosFlow.checkHoldingAndTransationDataChange();
    }

    @When("^I taps the Allocation Toggle ON in Portfolio level$")
    public void tapAllocationInPortfolioLevel() {
        portfoliosFlow.tabAssetAllocation();
    }

    @And("^I taps the Class tap in Portfolio level$")
    public void tapsPortfolioClassTap() {
        portfoliosFlow.tapsPortfolioClassTap();
    }

    @And("^I slides to the 2th pip by sliding right that save \"([^\"]*)\" data$")
    public void pipRightSaveData(String str) {
        portfoliosFlow.pipRightSavePortfolioData(str);
    }

    @Then("^The following Asset Class list percentage data will be changed when slides the pip in the Portfolio level$")
    public void checkPortfolioClassPercentageDataChange(){
        portfoliosFlow.checkPortfolioClassPercentageDataChange();
    }

    @Then("^The following Sub Asset Class list head title data will be changed when slides the pip$")
    public void checkSubAssetClassHeadTitleData() {
        portfoliosFlow.checkSubAssetClassHeadTitleData();
    }

    @And("^I taps the Currency tap in Portfolio level$")
    public void tapsCurrencyTapInPortfolioLevel() {
        portfoliosFlow.tapsCurrencyTapInPortfolioLevel();
    }


    @Then("^The following Asset Currency list title and percentage data will be changed when slides the pip$")
    public void checkCurrencyTitleAndPercentageDataChange() {
        portfoliosFlow.checkCurrencyTitleAndPercentageDataChange();
    }

    @And("^I taps the Region tap in Portfolio level$")
    public void tapPortfolioRegion() {
        portfoliosFlow.tapPortfolioRegion();
    }

    @Then("^I should on the Portfolios level$")
    public void viewPortfoliosLevel() {
        portfoliosFlow.viewPortfoliosLevel();
    }

    @Given("^I am on the Portfolios level$")
    public void seePortfoliosLevel() {
        portfoliosFlow.viewPortfoliosLevel();
    }

    @Then("^I can swipe the pips from 1st to the last one continuously within portfolio wrapper$")
    public void portfolioPipFrom1ToLastPortfolio() {
        portfoliosFlow.portfolioPipFrom1ToLastPortfolio();
    }

    @And("^I click the Portfolios Holding tab$")
    public void tapPortfoliosHoldingTab() {
        portfoliosFlow.tapPortfoliosHoldingTab();
    }

    @And("^I scroll left (\\d+) times on the portfolio \"([^\"]*)\" page$")
    public void portfolioScrollLeft(int num,String tab){
        portfoliosFlow.portfolioScrollLeft(num,tab);
    }


    @Then("^I can see the contingent liability bar$")
    public void checkContingentLiabilityBar(){
        portfoliosFlow.checkContingentLiabilityBar();
    }

    @And("^I click the Portfolios Transactions tab$")
    public void tapPortfoliosTransactionsTab() {
        portfoliosFlow.tapPortfoliosTransactionsTab();
    }

    @Then("^I can see the related content in the portfolios \"([^\"]*)\" tab")
    public void checkPortfoliosTabData0(String tab) {
        portfoliosFlow.checkPortfoliosTabData0(tab);
    }

    @And("^I tap on the Protfolio assets value2$")
    public void tapProtfolioAssetsValue2(){
        portfoliosFlow.tapProtfolioAssetsValue2();
    }

    @Then("^I should see Overlay relating to that item on portfolio level$")
    public void seePortfolioOverlayRelating() {
        portfoliosFlow.seePortfolioOverlayRelating();
    }

    @Then("^I should see the portfolio name and portfolio number and total assets value and updated time and in the portfolio wrapper will be changed$")
    public void checkPortfolioWrapperChange() {
        portfoliosFlow.checkPortfolioWrapperChange();
    }

    @Then("^I can see the 3rd portfolio's Sub asset Class Toggle is ON$")
    public void checkSubAssetClassToggleON(){
        portfoliosFlow.checkSubAssetClassON_OtherPortfolioAccount();
    }

    @And("^I slide to left on Portfolios level and save Overlay data$")
    public void pipLeftSaveOverlayData3(){
        portfoliosFlow.pipLeftSaveOverlayData3();
    }

    @Then("^I should see portfolio Overlay relating to that item$")
    public void checkPortfolioOverlay() {
        portfoliosFlow.checkPortfolioOverlay();
    }

    @Given("^I see the following message under the holdings is displayed:$")
    public void checkHoldingsIsDisplayed(Map<String, String> map){
        checkNoHoldingNoCLMessage(map);
    }

    @Then("^I should see the transactions list within a selected portfolio$")
    public void checkPortfolioTransactionsSelected() {
        portfoliosFlow.checkPortfolioTransactionsSelected();
    }

    @Given("^I see the transactions list within a selected portfolio$")
    public void portfolioTransactionsSelected(){
        checkPortfolioTransactionsSelected();
    }

    @And("^I click the Portfolios Transactions tab and transactions head title$")
    public void clickPortfoliosTransactionsAndHeadTitle() {
        portfoliosFlow.tapPortfoliosTransactionsTab();
        portfoliosFlow.tabPTransactionsHeadTitle();
    }

    @Then("^I should see the filter type is \"Purchase\"$")
    public void checkPurchaseSelect(){
        portfoliosFlow.checkPurchaseSelect();
    }

    @When("^I am on the Contingent liability list view$")
    public void tabContingentLiability() {
        portfoliosFlow.tapContingentLiabilitiesTab();
    }

    @Then("^I can swipe the pips from 1st to the last one continuously within Contingent liability detail$")
    public void pipsFrom1ToLastContingentLiabilityDetail() {
        portfoliosFlow.pipsFrom1ToLastContingentLiabilityDetail();
    }

    @Then("^I should see a detailed view relating to portfolio item$")
    public void seePortfolioLevel() {
        portfoliosFlow.seePortfolioLevel();
    }

    @Then("^I should see that transactions are ordered initially by trade date \\(recent first - oldest date last\\), then order by Transaction Type value \\(a-z\\), last order by Transaction Description value \\(a-z\\) for list$")
    public void checkTransactionOrderLogic() {
        portfoliosFlow.checkTransactionOrderLogic();
    }

    @And("^I swipe left the portfolio screen$")
    public void swipeLeftPortfolio(){
        portfoliosFlow.swipeLeftPortfolio();
    }

    @And("^I tap first item of Portfolio currency list$")
    public void tapFirstCurrency(){
        portfoliosFlow.tapFirstCurrency();
    }

    @When("^I select filter \"([^\"]*)\" type$")
    public void selectFilterType(String type) {
        portfoliosFlow.selectPrevious(type);
    }

    @Then("^I should see all \"([^\"]*)\" type transaction list will be listed for list number are (\\d+)$")
    public void checkTransactionType(String type, int listNum){
        portfoliosFlow.checkTransactionType(type);
    }

    @Then("^I should see the following UI Elements on the Portfolios Currency")
    public void checkPortfoliosCurrencyUI(DataTable dataTable) {
        portfoliosFlow.checkPortfoliosVersionUI(dataTable);
    }

    @Then("^I should see the following data for Portfolios Currency name、Total asset ISO3 format value、Total asset 2dp format value、Total assets 2dp percentage value$")
    public void checkPortfolioCurrencyDataFormat(){
        portfoliosFlow.checkPortfolioCurrencyDataFormat();
    }

    @Then("^I should see the portfolios currencies are ordered by Total Asset value - largest \\(first\\) to smallest \\(last\\), then by alphabetical order$")
    public void checkCurrenyDataOrder() {
        portfoliosFlow.orderedByCurrencyList();
    }

    @When("^I scroll down to the portfolios currency bottom$")
    public void scrollDownPortfoliosCurrencyBottom() {
        portfoliosFlow.scrollDownPortfoliosCurrencyBottom();
    }

    @When("^I tap first item of class list at portfolio level$")
    public void tapFirstClass() {
        portfoliosFlow.tapFirstClass();
    }

    @When("^I tap first Sub-Asset class item at portfolio level$")
    public void tapFirstSubClass() {
        portfoliosFlow.tapFirstSubClass();
    }

    @Then("^I should see the portfolio currency following data:$")
    public void checkCurrencyLastData(Map<String,String> map) {
        portfoliosFlow.checkCurrencyLastData(map);
    }

    @Then("^I should see the class list at portfolio level$")
    public void checkHasClassList() {
        portfoliosFlow.checkHasClassList();
    }

    @Then("^I should see a list of holdings that they own within that Asset Class for that Portfolio$")
    public void checkAllocationHolding() {
        portfoliosFlow.checkInClassHolding();
    }

    @Then("^I should see a list of holdings that they own within that sub-asset class for that Portfolio$")
    public void checkClassHolding() {
        this.checkAllocationHolding();
    }

    @Then("^I should see a list of holdings that they own within that Region for that Portfolio$")
    public void checkRegionHolding() {
        this.checkAllocationHolding();
    }

    @Then("^I should see a list of holdings that they own within that currency for that Portfolio$")
    public void checkCurrencyHolding() {
        this.checkAllocationHolding();
    }

    @Given("^I am see the class list at portfolio Screen$")
    public void seeClassList() {
        this.checkHasClassList();
    }

    @Then("^I should not see that portfolio currency listed$")
    public void checkNotCurrencyList() {
        portfoliosFlow.checkNotCurrencyList();
    }

    @Then("^I should see the following UI Elements on the Portfolios Level$")
    public void checkPortfoliosLevelUI(Map<String,String> map) {
        portfoliosFlow.checkPortfoliosUI(map);
    }

    @Then("^I should see the value for the \"Total assets\" the client owns within that Portfolio is displayed in full to 2dp, which will be 18 characters max$")
    public void checkPortfolioTotalAssetsFormat(){
        portfoliosFlow.checkPortfolioTotalAssetsFormat();
    }

    @Then("^I should see the portfolios reporting currency is displayed in ISO3 code format$")
    public void checkPortfolioTotalAssetsISO3(){
        portfoliosFlow.checkPortfolioTotalAssetsISO3();
    }

    @When("^I click on the Portfolio Total Assets value$")
    public void tapPortfolioTotalAssetsValue(){
        portfoliosFlow.tapPortfolioTotalAssetsValue();
    }

    @Then("^I should see a link to an portfolios overlay showing how this value has been calculated is displayed$")
    public void checkPortfoliosOverlayDisplayed() {
        portfoliosFlow.checkPortfoliosOverlayDisplayed();
    }

    @Then("^I should see the following data in portfolio total asset overlay:$")
    public void checkPortfolioOverlayUI(DataTable dataTable) {
        portfoliosFlow.checkPortfolioOverlayUI(RegionUtil.getMap(dataTable));
    }

    @Then("^I should see Total Assets value for the Portfolio overlay in current reporting currency to 2 d\\.p\\.$")
    public void checkOverlayDP() {
        portfoliosFlow.checkOverlayDP();
    }

    @Then("^I should see Total Assets value for the Portfolio overlay in exporting Currency ISO 3 code$")
    public void checkOverlayISO() {
        portfoliosFlow.checkOverlayISO();
    }

    @Then("^I should see the main Portfolio screen should come back into focus$")
    public void seePortfolioScreen() {
        portfoliosFlow.seePortfolioScreen();
    }

    @Then("^the portfolio overlay is closed$")
    public void checkOverLayClose() {
        portfoliosFlow.checkOverLayClose();
    }

    @Given("^I see a link to an portfolios overlay showing how this value has been calculated is displayed$")
    public void seePortfoliosOverlayDisplayed() {
        this.checkPortfoliosOverlayDisplayed();
    }

    @When("^I tap on close button of portfolio overlay$")
    public void tapOverlayCloseBtn(){
        portfoliosFlow.tapOverlayCloseBtn();
    }

    @When("^I taps anywhere on the screen outside of the portfolio overlay frame$")
    public void tapOverlayOutside() {
        portfoliosFlow.tapOverlayOutside();
    }

    @Then("^I should see a value of \"0\\.00\" for the \"Total assets\" they own within that portfolio total assets is displayed$")
    public void checkPortfolioTotalAssets16() {
        portfoliosFlow.checkPortfolioTotalAssets16();
    }

    @Then("^I should see the portfolios reporting currency16 is displayed in ISO3 code format$")
    public void checkPortfolioTotalAssets16IOS3(){
        portfoliosFlow.checkPortfolioTotalAssets16IOS3();
    }

    @Then("^I can see a list of holdings with the following details displayed$")
    public void checkHoldingListDifferentDisplayed() {
        portfoliosFlow.checkHoldingListDifferentDisplayed();
    }

    @Then("^I should see a list of holdings bace currency value and report currency value format with the following format$")
    public void checkHoldingsDataFormat(){
        portfoliosFlow.checkHoldingsDataFormat();
    }

    @Then("^I should see a list of holdings with the following ISO 3 format data$")
    public void checkHoldingsDataDifferentFormatISO3(){
        portfoliosFlow.checkHoldingsDataDifferentFormatISO3();
    }

    @Then("^I should see the holdings list items are ordered largest to smallest based on market value in portfolio references currency$")
    public void checkHoldingsListReportAmountOrder() {
        portfoliosFlow.checkHoldingsListReportAmountOrder();
    }

    @Then("^I can see a list of holdings with the following details displayed with SAME$")
    public void checkHoldingListSameDisplayed(){
        portfoliosFlow.checkHoldingListSameDisplayed();
    }

    @Then("^I should see the SAME following ISO 3 format data$")
    public void checkHoldingsDataSameFormatISO3(){
        portfoliosFlow.checkHoldingsDataSameFormatISO3();
    }

    @Then("^I can see a list of holdings with the following details displayed when percentage is zero$")
    public void checkHoldingListPercentageZeroDisplayed() {
        portfoliosFlow.checkHoldingListPercentageZeroDisplayed();
    }

    @Then("^I should see the holdings following ISO 3 format datas when percentage is zero$")
    public void checkHoldingsDataPercentageZeroFormatISO3() {
        portfoliosFlow.checkHoldingsDataPercentageZeroFormatISO3();
    }

    @Then("^I can see a list of holdings with the following details displayed when percentage is zero and SAME$")
    public void checkHoldingListSAMEPercentageZeroDisplayed(){
        portfoliosFlow.checkHoldingListSAMEPercentageZeroDisplayed();
    }

    @Then("^I should see the holdings following ISO 3 format datas when percentage is zero and SAME$")
    public void checkHoldingsDataSAMEPercentageZeroFormatISO3(){
        portfoliosFlow.checkHoldingsDataSAMEPercentageZeroFormatISO3();
    }

    @When("^I tap on portfolio \"Currency Conversion\" icon$")
    public void tapCurrencyConversion() {
        portfoliosFlow.tapCurrencyConversion();
    }

    @When("^I taps first on a transaction list item$")
    public void tapsTransactionList0() {
        portfoliosFlow.tapsTransactionList0();
    }

    @When("^I taps settled transaction AND base and reporting currency of transaction are DIFFERENT on a transaction list item$")
    public void tapsSettledTransactionListDIFFERENT(){
        portfoliosFlow.tapsSettledTransactionListDIFFERENT();
    }

    @When("^I taps settled transaction AND base and reporting currency of transaction are the SAME on a transaction list item$")
    public void tapsSettledTransactionListSAME() {
        portfoliosFlow.tapsSettledTransactionListSAME();
    }

    @When("^I taps pending transaction AND base and reporting currency of transaction are DIFFERENT on a transaction list item$")
    public void tapsPendingTransactionListDIFFERENT(){
        portfoliosFlow.tapsPendingTransactionListDIFFERENT();
    }

    @When("^I taps pending transaction AND base and reporting currency of transaction are the SAME on a transaction list item$")
    public void tapsPendingTransactionListSAME(){
        portfoliosFlow.tapsPendingTransactionListSAME();
    }

    @Then("^I returns to Transactions list view within that portfolio$")
    public void returnsTransactionsListView() {
        portfoliosFlow.seeTransactionList();
    }

    @And("^I tap (\\d+)th item of holdings list$")
    public void tapHoldingsList(int num){
        portfoliosFlow.tapHoldingsList(num);
    }

    @When("^I tap \"Show Sub-Asset Class\" toggle of Portfolio level$")
    public void tapSubClassToggle(){
        portfoliosFlow.tapSubClassToggle();
    }

    @Then("^I should view the holdings list specific item following information: a downward pointing chevron、a negative % figure with a symbol -$")
    public void checkHoldingsListTWRRNegative() {
        portfoliosFlow.checkHoldingsListTWRRNegative();
    }

    @Then("^I should view the holdings list specific item following information: a upward pointing chevron、a positive % figure$")
    public void checkHoldingsListTWRRPositive() {
        portfoliosFlow.checkHoldingsListTWRRPositive();

    }

    @Then("^I should view the holdings list total all item following datas: 2dp format of TWRR % figure$")
    public void checkHoldingsListTWRRFormat(){
        portfoliosFlow.checkHoldingsListTWRRFormat();
    }

    @Then("^the holdings list specific item TWRR % figure is 0\\.00%$")
    public void checkHoldingsListTWRRZero() {
        portfoliosFlow.checkHoldingsListTWRRZero();
    }

    @Then("^I should see holdings list specific item there is no - symbol and no chevron$")
    public void checkHoldingsListNoSymbolAndNoChevron() {
        portfoliosFlow.checkHoldingsListNoSymbolAndNoChevron();
    }

    @Then("^I should view the portfolio 1 following information:$")
    public void checkPortfolioPerformance(Map<String,String> map) {
        portfoliosFlow.checkPortfolioPerformance(map,1);
    }

    @Then("^I should view the portfolio 2 following information:$")
    public void checkPortfolioPerformance2(Map<String,String> map) {
        portfoliosFlow.checkPortfolioPerformance(map,2);
    }

    @Then("^I should see the portfolio following datas: ISO 3 format of performance currency$")
    public void checkPortfolioPerformanceCurrencyISO3(){
        portfoliosFlow.checkPortfolioPerformanceCurrencyISO3();
    }

    @Then("^I should see the portfolio following datas: 2dp format of performance value、2dp format of TWRR % figure$")
    public void checkPortfolioPerformanceValue2pd() {
        portfoliosFlow.checkPortfolioPerformanceValue2pd();
    }

    @And("^the portfolio TWRR % figure is 0\\.00$")
    public void checkPortfolioTWRRZero(){
        portfoliosFlow.checkPortfolioTWRRZero();
    }

    @Then("^the portfolio Performance value is 0\\.00$")
    public void checkPortfolioPerformanceValueZero(){
        portfoliosFlow.checkPortfolioPerformanceValueZero();
    }

    @And("^I should see portfolio there is no \\+ symbol or - symbol before the TWRR % figure and Perfermance value$")
    public void checkPortfolioTWRRPerformanceNoSymbol() {
        portfoliosFlow.checkPortfolioTWRRPerformanceNoSymbol();
    }

    @When("^I tap portfolios performance$")
    public void tapPortfoliosPerformance(){
        portfoliosFlow.tapPortfoliosPerformance();

    }

    @Then("^I should on the portfolios performance overlay$")
    public void onPortfoliosPerformanceOverlay() {
        portfoliosFlow.onPortfoliosPerformanceOverlay();
    }

    @Given("^I am on the portfolios performance overlay$")
    public void onThePortfoliosPerformanceOverlay() {
        portfoliosFlow.onPortfoliosPerformanceOverlay();
    }

    @Then("^I should see the portfolios performance overlay 1 following datas:$")
    public void checkPortfoliosPerformanceOverlayUI(Map<String,String> map){
        portfoliosFlow.checkPortfoliosPerformanceOverlayUI(map,1);

    }

    @Then("^I should see the portfolios performance overlay 2 following datas:$")
    public void checkPortfoliosPerformanceOverlayUI2(Map<String,String> map){
        portfoliosFlow.checkPortfoliosPerformanceOverlayUI(map,2);

    }

    @Then("^I should see the portfolios performance overlay following datas: 2dp format of Performance amount value、2dp format of TWRR % figure$")
    public void checkPortfoliosPerformanceOverlay2dp(){
        portfoliosFlow.checkPortfoliosPerformanceOverlay2dp();
    }

    @Then("^I should see the portfolios performance overlay following datas: ISO3 format of Performance amount value$")
    public void checkPortfoliosPerformanceOverlayISO3(){
        portfoliosFlow.checkPortfoliosPerformanceOverlayISO3();
    }

    @Then("^the portfolios performance overlay TWRR % figure is 0\\.00$")
    public void checkPortfoliosPerformanceOverlayTWRRZero(){
        portfoliosFlow.checkPortfoliosPerformanceOverlayTWRRZero();
    }

    @And("^the portfolios performance overlay Performance value is 0\\.00$")
    public void checkPortfoliosPerformanceOverlayPerformanceZero(){
        portfoliosFlow.checkPortfoliosPerformanceOverlayPerformanceZero();
    }

    @Then("^I should see portfolios performance overlay there is no \\+ symbol or - symbol before the TWRR % figure and Performance value$")
    public void checkPortfoliosPerformanceOverlayNoSymbol() {
        portfoliosFlow.checkPortfoliosPerformanceOverlayNoSymbol();
    }

    @Then("^I should see the \"([^\"]*)\" title in Portfolio asset Overlay$")
    public void checkPortfolioAssetOverlay(String str) {
        portfoliosFlow.checkPortfolioAssetOverlay(str);
    }

    @Then("^I should see portfolios a header \"([^\"]*)\" is displayed instead of \"Total assets\"$")
    public void checkPortfoliosAssert(String asset) {
        portfoliosFlow.checkPortfoliosAssert(asset);
    }

    @When("^client taps on \"x\" top right of portfolios performance overlay$")
    public void tapsClosePortfoliosPerformanceOverlay(){
        portfoliosFlow.tapsClosePortfoliosPerformanceOverlay();
    }

    @Then("^I should see the portfolios performance overlay is closed$")
    public void checkPortfoliosPerformanceOverlayClosed(){
        portfoliosFlow.checkPortfoliosPerformanceOverlayClosed();
    }

    @When("^I taps anywhere on the screen outside of the portfolios performance overlay frame$")
    public void tapAnywherePortfoliosPerformanceOverlay() {
        portfoliosFlow.tapAnywherePortfoliosPerformanceOverlay();
    }

    @Then("^I should NOT see the Contingent Liabilities component below \"Holdings\" and \"Transactions\" components$")
    public void checkNotContingentLiabilities() {
        portfoliosFlow.checkNotContingentLiabilities();
    }

    @Then("^I can view the portfolio holding following information:a upward pointing chevron、a positive % figure$")
    public void checkPortfolioHoldingTWRRPositive(){
        portfoliosFlow.checkPortfolioHoldingTWRRPositive();

    }

    @Then("^I can view the portfolio holding following information:a downward pointing chevron、a negative % figure with a symbol -$")
    public void checkPortfolioHoldingTWRRNegative(){
        portfoliosFlow.checkPortfolioHoldingTWRRNegative();
    }

    @Then("^I can view the portfolio holding following information:2dp format of % figure$")
    public void checkPortfolioHoldingTWRR2dp(){
        portfoliosFlow.checkPortfolioHoldingTWRR2dp();
    }

    @When("^the portfolio holding % figure is 0\\.00%$")
    public void checkPortfolioHoldingTWRRZero(){
        portfoliosFlow.checkPortfolioHoldingTWRRZero();
    }

    @Then("^I should see portfolio holding there is no - symbol and no chevron$")
    public void checkPortfolioHoldingTWRRNoSymbolNoChevron(){
        portfoliosFlow.checkPortfolioHoldingTWRRNoSymbolNoChevron();
    }

    @Then("^I should see portfolio holding wrapper ISO 3 code of portfolio reference currency$")
    public void checkPortfolioHoldingWrapperISO3(){
        portfoliosFlow.checkPortfolioHoldingWrapperISO3();
    }

    @And("^I am viewing the end of Holding list$")
    public void viewingTheEndOfHoldingList() {
        portfoliosFlow.viewingTheEndOfHoldingList();
    }

    @Then("^I can see the \"([^\"]*)\" Holding list following link to a legal overlay calculated value:\"([^\"]*)\"$")
    public void checkHoldingListGlobalLegalDisclaimer(String region, String disclaimer) {
        portfoliosFlow.checkHoldingListGlobalLegalDisclaimer(region,disclaimer);
    }

    @Given("^I am viewing the \"([^\"]*)\" \"([^\"]*)\" link at the bottom of the portfolio holding list$")
    public void seeHoldingListGlobalLegalDisclaimer(String region, String disclaimer) {
        portfoliosFlow.checkHoldingListGlobalLegalDisclaimer(region,disclaimer);
    }

    @And("^I am viewing the end of Transaction list at Portfolio level$")
    public void viewingTheEndOfTransactionList() {
        portfoliosFlow.viewingTheEndOfTransactionsList();
    }

    @Then("^I can see the \"([^\"]*)\" Transaction list following link to a legal overlay calculated value:\"([^\"]*)\"$")
    public void checkTransactionListGlobalLegalDisclaimer(String region, String disclaimer) {
        portfoliosFlow.checkTransactionsListGlobalLegalDisclaimer(region,disclaimer);
    }

    @Given("^I am viewing the \"([^\"]*)\" \"([^\"]*)\" link at the bottom of the portfolio transaction list$")
    public void seeTransactionListGlobalLegalDisclaimer(String region, String disclaimer) {
        portfoliosFlow.checkTransactionsListGlobalLegalDisclaimer(region,disclaimer);
    }

    @And("^I taps on portfolio holding list \"tap here\" link to legal overlay calculated value$")
    public void tapsPortfolioHoldingListLinkToLegalDisclaimer(){
        portfoliosFlow.tapsPortfolioHoldingListLinkToLegalDisclaimer();
    }

    @And("^I taps on portfolio transactions list \"tap here\" link to legal overlay calculated value$")
    public void tapsPortfolioTransactionsListLinkToLegalDisclaimer(){
        portfoliosFlow.tapsPortfolioTransactionsListLinkToLegalDisclaimer();
    }

    @And("^I taps on portfolio liabilities list \"tap here\" link to legal overlay calculated value$")
    public void tapsPortfolioLiabilitiesListLinkToLegalDisclaimer(){
        portfoliosFlow.tapsPortfolioLiabilitiesListLinkToLegalDisclaimer();
    }

    @And("^I am viewing the end of Liability list at Portfolio level$")
    public void viewingTheEndOfLiabilityList() {
        portfoliosFlow.viewingTheEndOfLiabilityList();
    }

    @Then("^I can see the \"([^\"]*)\" Liability list following link to a legal overlay calculated value:\"([^\"]*)\"$")
    public void checkLiabilityListGlobalLegalDisclaimer(String region, String disclaimer) {
        portfoliosFlow.checkLiabilityListGlobalLegalDisclaimer(region,disclaimer);
    }

    @Given("^I am viewing the \"([^\"]*)\" \"([^\"]*)\" link at the bottom of the portfolio liability list$")
    public void seeLiabilityListGlobalLegalDisclaimer(String region, String disclaimer) {
        portfoliosFlow.checkLiabilityListGlobalLegalDisclaimer(region,disclaimer);
    }

    @Then("^I should return to the screen they were on when they tapped \"tap here\" to portfolio liability access the legal overlay calculated value screen$")
    public void returnToPortfolioLiabilityList(){
        portfoliosFlow.returnToPortfolioLiabilityList();
    }

    @Then("^I should return to the screen they were on when they tapped \"tap here\" to portfolio transaction list access the legal overlay calculated value screen$")
    public void returnToPortfolioTransactionList(){
        portfoliosFlow.returnToPortfolioTransactionList();
    }

    @Then("^I should return to the screen they were on when they tapped \"tap here\" to portfolio holding list access the legal overlay calculated value screen$")
    public void returnToPortfolioHoldingList(){
        portfoliosFlow.returnToPortfolioHoldingList();
    }

    @Then("^I can see a list of holdings that they own within that Asset Class for that Portfolio$")
    public void checkPortfolioAssetClassHolding() {
        portfoliosFlow.checkPortfolioHolding();
    }

    @Then("^I can see a list of holdings that they own within that sub-asset class for that Portfolio$")
    public void checkPortfolioSubAssetClassHoldings() {
        portfoliosFlow.checkPortfolioHolding();
    }

    @Then("^I can see a list of holdings that they own in that currency for that Portfolio$")
    public void checkPortfolioCurrencyHoldings() {
        portfoliosFlow.checkPortfolioHolding();
    }

    @Then("^I can see a list of holdings that they own within that Region for that Portfolio$")
    public void checkPortfolioRegionHoldings() {
        portfoliosFlow.checkPortfolioHolding();
    }

    @Then("^I can see a list of portfolio allocation holdings with the following details when P/L is positive AND holding ccy is DIFFERENT$")
    public void checkPortfolioAllocationHoldingsPositiveAndDIFFERENT(){
        portfoliosFlow.checkPortfolioAllocationHoldingsPositiveAndDIFFERENT();
    }

    @Then("^I can see ISO 3 code of portfolio allocation holding currency、portfolio reference currency$")
    public void checkPortfolioAllocationHoldingsPositiveAndDIFFERENTISO3(){
        portfoliosFlow.checkPortfolioAllocationHoldingsPositiveAndDIFFERENTISO3();
    }

    @Then("^Client can see a list of portfolio allocation holdings with the following details when P/L is negative AND holding ccy is DIFFERENT$")
    public void checkPortfolioAllocationHoldingsNegativeAndDIFFERENT() {
        portfoliosFlow.checkPortfolioAllocationHoldingsNegativeAndDIFFERENT();
    }

    @Then("^I can se ISO 3 code of portfolio allocation holding currency、portfolio reference currency when P/L is negative AND holding ccy is DIFFERENT$")
    public void checkPortfolioAllocationHoldingNegativeAndDIFFERENT(){
        portfoliosFlow.checkPortfolioAllocationHoldingNegativeAndDIFFERENT();
    }

    @Then("^I can see a list of portfolio allocation holdings with the following details when P/L is positive AND holding ccy is the SAME$")
    public void checkPortfolioAllocationHoldingsPositiveAndSAME() {
        portfoliosFlow.checkPortfolioAllocationHoldingsPositiveAndSAME();
    }

    @Then("^I can see ISO 3 code of portfolio allocation holding currency when P/L is positive AND holding ccy is the SAME$")
    public void checkPortfolioAllocationHoldingPositiveAndSAMEISO3(){
        portfoliosFlow.checkPortfolioAllocationHoldingPositiveAndSAMEISO3();
    }

    @Then("^I can see a list of portfolio allocation holdings with the following details when P/L is negative AND holding ccy is the SAME$")
    public void checkPortfolioAllocationHoldingsNegativeAndSAME(){
        portfoliosFlow.checkPortfolioAllocationHoldingsNegativeAndSAME();
    }

    @Then("^I can see ISO 3 code of portfolio allocation holding currency when P/L is negative AND holding ccy is the SAME$")
    public void checkPortfolioAllocationHoldingsNegativeAndSAMEISO3(){
        portfoliosFlow.checkPortfolioAllocationHoldingsNegativeAndSAMEISO3();
    }

    @And("^I tap (\\d+)th item of portfolio allocation holding list$")
    public void tapPortfolioAllocationHoldingList(int num) {
        portfoliosFlow.tapPortfolioAllocationHoldingList(num);
    }

    @Then("^I should see the Portfolio assets value is displayed based on the Portfolio reference currency \"([^\"]*)\"$")
    public void checkPortfolioReferenceCurrency(String referenceCurrency){
        portfoliosFlow.checkPortfolioReferenceCurrency(referenceCurrency);
    }

    @Then("^the ISO 3 code of the portfolio reference currency is displayed adjacent to the Portfolio assets figure.$")
    public void checkTotalAssetISO3(){
        portfoliosFlow.checkTotalAssetISO3();
    }

    @Then("^I should see the portfolio allocation screen$")
    public void checkInAllocation(){
        portfoliosFlow.checkInAllocation();
    }

    @Given("^I see the portfolio allocation screen$")
    public void seeInAllocation(){
        this.checkInAllocation();
    }

    @When("^I tap Portfolio Total Liabilities$")
    public void tapPortfolioTotalLiabilities() {
        portfoliosFlow.tapPortfolioTotalLiabilities();
    }

    @When("^I swap left the pips for portfolio total liabilities overlay$")
    public void swapLeftPortfolioTotalLiabilitiesOverlay(){
        portfoliosFlow.swapLeftPortfolioTotalLiabilitiesOverlay();
    }

    @Then("^I should see the Portfolio Total Liabilities overlay will be changed$")
    public void checkPortfolioTotalLiabilitiesOverlayChanged() {
        portfoliosFlow.checkPortfolioTotalLiabilitiesOverlayChanged();
    }

    @Then("^I should see the follow element on portfolio liabilities:$")
    public void checkPortfolioLiabilitiesUI(Map<String,String> map){
        portfoliosFlow.checkPortfolioLiabilitiesUI(map);
    }

    @Then("^I am see the follow element on portfolio liabilities:$")
    public void seePortfolioLiabilitiesUI(Map<String,String> map){
        portfoliosFlow.checkPortfolioLiabilitiesUI(map);
    }

    @Then("^I can see the Class and Currency tap at portfolio level$")
    public void checkClassAndCurrency(){
        portfoliosFlow.checkClassAndCurrency();
    }

    @And("^I should not see the Region tap at portfolio level$")
    public void checkNotRegion(){
        portfoliosFlow.checkNotRegion();
    }

    @When("^I swipe left to other portfolio$")
    public void swipeLeft(){
        portfoliosFlow.swipeLeft();
    }

    @Then("^I am not able to view the transaction filter$")
    public void notTransactionFilter() {
        portfoliosFlow.notTransactionFilter();
    }

    @Then("^I should see the value for the total liabilities they own within the Portfolio is displayed,which will be (\\d+) characters max,including commas and decimal point$")
    public void checkTotalLiabilitiesTMax(int maxNumber) {
        portfoliosFlow.checkTotalLiabilitiesTMax(maxNumber);
    }

    @Then("^I should see the portfolio total liabilities base currency is displayed in ISO 3 code format$")
    public void checkPortfolioTotalLiabilitiesData(){
        portfoliosFlow.checkPortfolioTotalLiabilitiesData();
    }

    @Then("^I should see the Total Liabilities in Portfolio wrapper will be changed$")
    public void checkPortfolioWrapperTotalLiabilitiesInChanged() {
        portfoliosFlow.checkPortfolioWrapperTotalLiabilitiesInChanged();

    }

    @When("^I minifiles the Portfolio wrapper$")
    public void minifilesThePortfolioWrapper() {
        portfoliosFlow.minifilesThePortfolioWrapper();
    }

    @Then("^I should see the External Id/Update time/Portfolio Liabilities/Net portfolio Assets will be fade in and they will be disappeared$")
    public void checkMinifilesPortfolioWrapperUI() {
        portfoliosFlow.checkMinifilesPortfolioWrapperUI();
    }

    @And("^I should see the portfolio name and Portfolio Assets$")
    public void checkPortfolioNameAndPortfolioAssets(){
        portfoliosFlow.checkPortfolioNameAndPortfolioAssets();
    }

    @Then("^I should see the Portfolio Liabilities is displayed \"([^\"]*)\"$")
    public void checkPortfolioLiabilitiesDisplayed(String value){
        portfoliosFlow.checkPortfolioLiabilitiesDisplayed(value);
    }

    @Then("^I should not see a Portfolios Total Liabilities label,chervon or figure displayed$")
    public void checkNotPortfoliosTotalLiabilities() {
        portfoliosFlow.checkNotPortfoliosTotalLiabilities();
    }

    @Then("^I am not see a Portfolios Total Liabilities label,chervon or figure displayed$")
    public void notSeePortfoliosTotalLiabilities() {
        portfoliosFlow.checkNotPortfoliosTotalLiabilities();
    }

    @Then("^I should not see the Portfolio Liabilities and the Net Assets$")
    public void checkNotPortfolioLiabilitiesAndNetAssets() {
        portfoliosFlow.checkNotPortfolioLiabilitiesAndNetAssets();
    }

    @Then("^I should see the follow element on portfolio net assets:$")
    public void checkPortfolioNetAssetsUI(Map<String,String> map){
        portfoliosFlow.checkPortfolioNetAssetsUI(map);
    }

    @Then("^I am see the follow element on portfolio net assets:$")
    public void seePortfolioNetAssetsUI(Map<String,String> map){
        portfoliosFlow.checkPortfolioNetAssetsUI(map);
    }

    @Then("^I should see the value for the net assets they own within the Portfolio is displayed which will be (\\d+) characters max,including commas and decimal point$")
    public void checkNetAssetsMax(int maxNumber){
        portfoliosFlow.checkNetAssetsMax(maxNumber);
    }

    @Then("^I should see the portfolio net assets base currency is displayed in ISO 3 code format$")
    public void checkPortfolioNetAssetsISO3(){
        portfoliosFlow.checkPortfolioNetAssetsISO3();
    }

    @Then("^I should see that Net portfolio Assets = Portfolio Assets - Portfolio liabilities$")
    public void checkNetPortfolioAssetsEqualTotalAssetsReductionOfTotalLiabilities() {
        portfoliosFlow.checkNetPortfolioAssetsEqualTotalAssetsReductionOfTotalLiabilities();
    }

    @When("^I swap left the pips for portfolio net assets$")
    public void swapLeftPortfolioNetAssets() {
        portfoliosFlow.swapLeftPortfolioNetAssets();
    }

    @Then("^I should see the Portfolio Net Assets will be changed$")
    public void checkPortfolioNetAssetsChanged(){
        portfoliosFlow.checkPortfolioNetAssetsChanged();
    }

    @Then("^I should not see a Portfolios Net assets label or figure displayed$")
    public void checkNotPortfoliosNetAssets(){
        portfoliosFlow.checkNotPortfoliosNetAssets();
    }

    @Then("^I should see a Portfolios Net assets label or figure displayed \"([^\"]*)\"$")
    public void checkPortfoliosNetAssets(String value){
        portfoliosFlow.checkPortfoliosNetAssets(value);
    }

    @Given("^I am on the asia transaction screen$")
    public void checkInTransaction(){
        portfoliosFlow.checkInTransaction();
    }
    @Then("^I should on the asia transaction screen$")
    public void onTransaction(){
        portfoliosFlow.checkInTransaction();
    }

    @Then("^I am not able to see the Pending status label for Pending transactions and transaction type label for transaction list number is \"([^\"]*)\"$")
    public void notSeePendingAndType(int num){
        portfoliosFlow.notSeePendingAndType(num);
    }

    @And("^I tap four item of transaction list$")
    public void tapFourTransactionItem(){
        portfoliosFlow.tapFourTransactionItem();
    }

    @Then("^I should see a tab labelled \"Liabilities\" adjacent to Holdings and Transactions tabs$")
    public void checkLiabilitiesTabs(){
        portfoliosFlow.checkLiabilitiesTabs();
    }
    @Then("^I am see a tab labelled \"Liabilities\" adjacent to Holdings and Transactions tabs$")
    public void liabilitiesTabs(){
        portfoliosFlow.checkLiabilitiesTabs();
    }

    @Then("^I should NOT see a tab labelled \"Liabilities\" adjacent to Holdings and Transactions tabs$")
    public void checkNOTLiabilitiesTabs(){
        portfoliosFlow.checkNOTLiabilitiesTabs();
    }

    @Then("^I should see the liability listed with the following information displayed:$")
    public void checkLiabilityListedUI(Map<String,String> map){
        portfoliosFlow.checkLiabilityListedUI(map);
    }

    @And("^\"Total\" value is shown as a negative value using a minus sign$")
    public void totalValueNegative() {
        portfoliosFlow.totalValueNegative();
    }

    @Then("^I should see ISO 3 code of Loan currency for liabilities$")
    public void checkLiabilitiesISO3(){
        portfoliosFlow.checkLiabilitiesISO3();
    }

    @Then("^I should see all liabilities within the portfolio are ordered by Total in portfolio base currency value \\(largest absolute value first, smallest absolute value last\\) by default$")
    public void checkLiabilitiesOrderedINACTIVE() {
        portfoliosFlow.checkLiabilitiesOrderedINACTIVE();
    }

    @Then("^I should see the following copy instead of a liabilities list$")
    public void checkNoLiabilitiesList(Map<String,String> map) {
        portfoliosFlow.checkNoLiabilitiesList(map);
    }

    @Then("^I should see the liability listed with the following information displayed when loan ccy and  base ccy is DIFFERENT:$")
    public void checkLiabilityListUIDIFFERENT(Map<String,String> map) {
        portfoliosFlow.checkLiabilityListUIDIFFERENT(map);

    }

    @Then("^I am see the liability listed with the following information displayed when loan ccy and  base ccy is DIFFERENT:$")
    public void liabilityListUIDIFFERENT(Map<String,String> map) {
        portfoliosFlow.checkLiabilityListUIDIFFERENT(map);

    }

    @And("^Total values are shown as a negative values using a minus sign$")
    public void totalValuesNegative0(){
        portfoliosFlow.totalValuesNegative0();
    }

    @Then("^I should see ISO 3 code of Loan currency and Portfolio base currency$")
    public void checkLoanCurrencyAndPortfolioBaseCurrencyISO3(){
        portfoliosFlow.checkLoanCurrencyAndPortfolioBaseCurrencyISO3();
    }

    @Then("^I should see Total liabilities within the portfolio base currency is \"([^\"]*)\"$")
    public void checkLiabilitiesBaseCurrencyIsZero(String value){
        portfoliosFlow.checkLiabilitiesBaseCurrencyIsZero(value);
    }

    @When("^I tap on portfolio \"Liabilities\" tab$")
    public void tapPortfolioTab() {
        portfoliosFlow.tapPortfolioTab();
    }

    @When("^I taps on a liability list item which has the same currency as the portfolio base currency$")
    public void tapsLiabilityList() {
        portfoliosFlow.tapsLiabilityList();
    }


    @When("^I taps on a liability list item which has a different currency to the portfolio base currency$")
    public void tapLiabilityList1() {
        portfoliosFlow.tapLiabilityList1();
    }

    @Then("^I should return to the liability list view within that portfolio$")
    public void seeLiabilityListOnPortfolio() {
        portfoliosFlow.checkLiabilitiesTabs();
    }

    @Then("^I should see a toggle above the liabilities list labelled \"([^\"]*)\"$")
    public void checkLiabilitiesListSwitchingValue(String value) {
        portfoliosFlow.checkLiabilitiesListSwitchingValue(value);
    }

    @Given("^I am see a toggle above the liabilities list labelled \"([^\"]*)\"$")
    public void liabilitiesListSwitchingValue(String value) {
        portfoliosFlow.checkLiabilitiesListSwitchingValue(value);
    }

    @And("^the default state of this toggle should be INACTIVE every time the user starts a new app session$")
    public void checkDefaultStateOfLiabilitiesToggle() {
        portfoliosFlow.checkDefaultStateOfLiabilitiesToggle();
    }

    @Then("^the liabilities should be ordered by base currency of the portfolio value \\(largest absolute value first,smallest last \\)$")
    public void checkLiabilitiesOrderINACTIVE() {
        portfoliosFlow.checkLiabilitiesOrderedINACTIVE();
    }

    @And("^I tap on liabilities toggle on$")
    public void tapLiabilitiesToggleOn() {
        portfoliosFlow.tapLiabilitiesToggle();
    }

    @Then("^the Group by liability type toggle should became ACTIVE$")
    public void checkGroupByLiabilityTypeToggleACTIVE(){
        portfoliosFlow.checkGroupByLiabilityTypeToggleACTIVE();
    }

    @Given("^the \"Group by liability type toggle\" is ACTIVE$")
    public void groupByLiabilityTypeToggleACTIVE(){
        portfoliosFlow.checkGroupByLiabilityTypeToggleACTIVE();
    }

    @Then("^show a sub-header labelled with the liability type value and sum total of all liabilities in portfolio base currency value for that type when \"Group by liability type\" toggle hide$")
    public void checkSubHeaderEqualLiabilityTypeValueSumHideToggle() {
        portfoliosFlow.checkSubHeaderEqualLiabilityTypeValueSumHideToggle();
    }

    @And("^the liabilities list should be grouped by Type$")
    public void checkLiabilitiesListGroupedByType() {
        portfoliosFlow.checkLiabilitiesListGroupedByType();
    }

    @Then("^at the top of each grouping of liabilities should be a sub-header labelled with liability Type value and sum total of all liabilities in portfolio base currency value for that type$")
    public void checkSubHeaderEqualLiabilityTypeValueSum(){
        portfoliosFlow.checkSubHeaderEqualLiabilityTypeValueSum();
    }


    @Then("^the types should be ordered by the sum total of all liabilities in portfolio base currency within each type\\(Largest absolute value first, smallest last\\)$")
    public void checkLiabilitiesHeaderTypesOrdered(){
        portfoliosFlow.checkLiabilitiesHeaderTypesOrdered();
    }

    @Then("^the liabilities within each type should be ordered by Total in base currency of the portfolio value \\(largest absolute value first,smallest last \\)$")
    public void checkLiabilitiesChildOrder() {
        portfoliosFlow.checkLiabilitiesChildOrder();
    }

    @When("^I tap on portfolio \"Liabilities\" tab off$")
    public void tapPortfolioLiabilitiesTabOff() {
        portfoliosFlow.tapPortfolioLiabilitiesTabOff();
    }

    @Then("^the Group by liability type toggle should NOT be a sticky header in the list$")
    public void checkLiabilityToggleNOTSticky() {
        portfoliosFlow.checkLiabilityToggleNOTSticky();
    }

    @Then("^The toggle should become INACTIVE$")
    public void checkLiabilitiesToggleINACTIVE(){
        portfoliosFlow.checkLiabilitiesToggleINACTIVE();
    }

    @Given("^the \"Group by liability type toggle\" is INACTIVE$")
    public void liabilitiesToggleINACTIVE(){
        portfoliosFlow.checkLiabilitiesToggleINACTIVE();
    }

    @And("^the list of liabilities should return to the default state where all liabilities are listed by Total in base currency of the Portfolio value$")
    public void checkLiabilitiesReturnDefaultState() {
        portfoliosFlow.checkLiabilitiesReturnDefaultState();
    }

    @And("^liabilities listed should NOT be grouped by Type in that portfolio$")
    public void checkLiabilitiesListedNOTGroupedByType(){
        portfoliosFlow.checkLiabilitiesListedNOTGroupedByType();
    }

    @When("^I select first sub liability to go to the detail view$")
    public void tapFirstSubLiability1(){
        portfoliosFlow.tapSubLiability1();
    }

    @When("^I swipe left to other portfolio for liability list$")
    public void swipeLeftLiabilityList(){
        portfoliosFlow.swipeLeftSubLiabilityList();
    }

    @When("^I swipe left (\\d+)th to other portfolio$")
    public void swipeLeftOtherPortfolio(int num){
        portfoliosFlow.swipeLeftOtherPortfolio(num);
    }

    @When("^I swipe right (\\d+)th to other portfolio$")
    public void swipeRightOtherPortfolio(int num){
        portfoliosFlow.swipeRightOtherPortfolio(num);
    }

    @When("^I tap (\\d+)th portfolio total asset$")
    public void tapPortfolioTotalAsset(int num){
        portfoliosFlow.tapPortfolioTotalAsset(num);
    }

    @Then("^I should see the liability list will be changed$")
    public void checkSubLiabilityListChanged() {
        portfoliosFlow.checkSubLiabilityListChanged();
    }

    @When("^I taps on a liability list item which has a different currency to the portfolio base currency for Fixed loan$")
    public void tapsLiabilityList2() {
        portfoliosFlow.tapsLiabilityList();
    }

    @Then("^I can see the following components in Discretionary portfolio wrapper on (\\d+)th item:$")
    public void checkDiscretionaryWrapper(int number, Map<String, String> map) {
        portfoliosFlow.checkDiscretionaryWrapper(number);
    }

    @Then("^I can see the following components in Advisory portfolio wrapper on (\\d+)th item:$")
    public void checkAdvisoryWrapper(int number, Map<String, String> map){
        portfoliosFlow.checkAdvisoryWrapper(number, map);
    }

    @Then("^I can see the following components for Discretionary portfolio overlay:$")
    public void checkDiscretionaryOverlay(Map<String, String> map){
        portfoliosFlow.checkDiscretionaryOverlay();
    }

    @Then("^I can see the following components for Advisory portfolio overlay:$")
    public void checkAdvisoryOverlay(Map<String, String> map){
        portfoliosFlow.checkAdvisoryOverlay(map);
    }

    @Then("^I can see the following components for Discretionary portfolio Liability overlay:$")
    public void checkDiscretionaryLiabilityOverlay(Map<String, String> map){
        portfoliosFlow.checkDiscretionaryLiabilityOverlay();
    }

    @Then("^I can see the following components for Advisory portfolio Liabilities overlay:$")
    public void checkAdvisoryLiabilityOverlay(Map<String, String> map){
        portfoliosFlow.checkAdvisoryLiabilityOverlay(map);
    }

    @Then("^I can see the following components in Discretionary portfolio allocation holding list screen:$")
    public void checkDiscretionaryAllocationHoldingList(Map<String, String> map){
        portfoliosFlow.checkDiscretionaryAllocationHoldingList();
    }

    @Then("^I can see the following components in Advisory portfolio allocation holding list screen:$")
    public void checkAdvisoryAllocationHoldingList(Map<String, String> map){
        portfoliosFlow.checkAdvisoryAllocationHoldingList(map);
    }

    @Then("^I can not view Performance in the Portfolio wrapper$")
    public void checkNotPerformance(){
        portfoliosFlow.checkNotPerformance();
    }

    @Then("^I must view an unrealised profit/loss amount in the purchase currency of the portfolio holding$")
    public void checkHoldingPerformance(){
        portfoliosFlow.checkHoldingPerformance();
    }

    @Then("^I must not view a performance value of the portfolio holding$")
    public void checkHoldingNotPerformance(){
        portfoliosFlow.checkHoldingNotPerformance();
    }

    @When("^I tap on portfolio \"Show Sub-Asset Class\" toggle to ON$")
    public void tapShowSubClassToON() {
        portfoliosFlow.tapShowSubClassToON();
    }

    @Then("^I can view the performance message in the portfolio warpper:$")
    public void checkPortfolioWarpperPerformance(Map<String, String> map) {
        portfoliosFlow.checkPortfolioWarpperPerformance(map);
    }

    @Then("^I should see the latest month included in performance calculation on in DD MMM YYYY format$")
    public void checkPerformanceDateFormat() {
        portfoliosFlow.checkPerformanceDateFormat();
    }

    @Then("^I can view the following components in Portfolio performance overlay:$")
    public void checkDiscretionaryPerformanceOverlayUI(Map<String, String> map) {
        portfoliosFlow.checkDiscretionaryPerformanceOverlayUI(map);
    }

    @Then("^I should see latest month included in performance calculation on in DD MMM YYYY format in portfolio performance overlay$")
    public void checkDiscretionaryPerformanceOverlayDateFormat() {
        portfoliosFlow.checkDiscretionaryPerformanceOverlayDateFormat();
    }

    @Then("^I should see portfolio wrapper performance corresponding overlay performance$")
    public void checkPortfolioPerformanceValue() {
        portfoliosFlow.checkPortfolioPerformanceValue();
    }

    @Then("^I should see the Portfolio Total Assets equal to the Portfolio Total Assets Overlay$")
    public void checkPortfolioTotalAssetsEqualPortfolioTotalAssetsOverlay() {
        portfoliosFlow.checkPortfolioTotalAssetsEqualPortfolioTotalAssetsOverlay();
    }

    @Then("^I am returned back to the Portfolio page$")
    public void returnedBackToPortfolioPage() {
        portfoliosFlow.returnedBackToPortfolioPage();
    }

    @And("^the Portfolio wrapper should be maximised$")
    public void checkPortfolioWrapperMaximised() {
        portfoliosFlow.checkPortfolioWrapperMaximised();
    }

    @And("^the Portfolio wrapper is minimised")
    public void slidingUpOnPortfolio() {
        portfoliosFlow.slidingUpOnPortfolio();
    }

    @And("^the Portfolio wrapper should be minimised")
    public void checkPortfolioWrapperMinimised() {
        portfoliosFlow.checkPortfolioWrapperMinimised();
    }
}
