package com.gt.projects.bdd.hsbc_gbm.step;

import com.gt.projects.bdd.base.BaseStep;
import com.gt.projects.bdd.base.annotation.Action;
import com.gt.projects.bdd.hsbc_gbm.flow.AccountsFlow;
import com.gt.projects.bdd.hsbc_gbm.flow.GlobalOverlayFlow;
import com.gt.projects.bdd.hsbc_gbm.flow.OverviewFlow;
import com.gt.projects.bdd.hsbc_gbm.util.RegionUtil;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class AccountsStep extends BaseStep {

    @Autowired
    private AccountsFlow accountsFlow;

    @Autowired
    private OverviewFlow overviewFlow;

    @Autowired
    private GlobalOverlayFlow globalOverlayFlow;

    @Action("back_overView_level")
    public void backToTheOverviewLevel() {
        accountsFlow.backToTheAccountList();
    }

    @Action("back_overView_level_in_overlay")
    public void backOverviewLevelInOverlay() {
        accountsFlow.closeOverlayInAccountLevel();
        accountsFlow.backToTheAccountList();
    }

    @Action("close_Overlay_In_Account_Level")
    public void closeOverlayInAccountLevel() {
        accountsFlow.closeOverlayInAccountLevel();
    }

    @Action("click_account_total_assets")
    public void clickAccountTotalAssets() {
        accountsFlow.tapsAccountTotalAssets();
    }

    @Action("open_total_liabilities_overlay_on_account")
    public void closeOverlay() {
        accountsFlow.tapAccountTotalLiabilities();
    }


    @When("^I tap first item of Portfolios list$")
    public void tapsPortfoliosList0() {
        accountsFlow.tapsPortfoliosList0();
    }

    @When("^I tap second item of Portfolios list$")
    public void tapsPortfoliosList1() {
        accountsFlow.tapsPortfoliosList1();
    }

    @And("^I tap first item of Portfolios list and scroll$")
    public void tapsPortfoliosList0AndScroll() {
        accountsFlow.tapsPortfoliosList0AndScroll();
    }

    @And("^I tap last item of Portfolios list$")
    public void tapsPortfoliosListLast() {
        accountsFlow.tapsPortfoliosListLast();
    }

    @And("^I tap fifteen item of Portfolios list$")
    public void tapsPortfoliosListFifteen() {
        accountsFlow.tapsPortfoliosListFifteen();
    }

    @And("^I tap first item of Portfolios list again$")
    public void tapsPortfoliosList0Again() {
        this.tapsPortfoliosList0();
    }

    @And("^I tap default Accounts Allocation toggle$")
    public void tapDefaultAccountsAllocationToggle() {
        accountsFlow.tapDefaultAccountsAllocationToggle();
    }

    @When("^I tap Accounts Allocation toggle$")
    public void tapAccountsAllocationToggle() {
        accountsFlow.tapAccountsAllocationToggle();
    }

    @And("^I tap on \"Currency\" tab of Account Level$")
    public void tapAccountCurrencyBtn() {
        accountsFlow.tapCurrencyBtn();
    }

    @And("^I should see the Sub-asset Class Toggle is ON$")
    public void checkSubAssetClassState() {
        accountsFlow.checkSubAssetClassState();
    }

    @And("^I tap the Back Button of Portfolios Level$")
    public void tapBackButtonPortfoliosLevel() {
        accountsFlow.tapBackButtonPortfoliosLevel();
    }

    @Then("^I should see the following UI Elements on the Accounts Class tab$")
    public void noHoldingsClass(DataTable dataTable) {
        accountsFlow.noHoldingsClass(RegionUtil.getMap(dataTable));
    }

    @Given("^I am on the Accounts Allocation Screen$")
    public void allocationScreenAndTapAllocationToggle() {
        accountsFlow.allocationScreenAndTapAllocationToggle();
    }

    @When("^I tap Allocation Currency tab$")
    public void tapAllocationCurrencyTab() {
        accountsFlow.tapAllocationCurrencyTab();
    }

    @Then("^I should see the following UI Elements on the Accounts Currency tab$")
    public void noHoldingsCurrency(DataTable dataTable) {
        accountsFlow.noHoldingsCurrency(RegionUtil.getMap(dataTable));
    }

    @When("^I tap Allocation Region tab$")
    public void tapAllocationRegionTab() {
        accountsFlow.tapAllocationRegionTab();
    }

    @Then("^I should see the following UI Elements on the Accounts Region tab$")
    public void noRegion(DataTable dataTable) {
        accountsFlow.noRegion(RegionUtil.getMap(dataTable));
    }

    @And("^I tap Portfolios list first item$")
    public void tapPortfoliosListFirst() {
        accountsFlow.tapPortfoliosListFirst();
    }

    @Then("^I should see the following UI Elements on the Accounts Class Level$")
    public void checkAccountsLeveVersion(DataTable dataTable) {
        accountsFlow.checkAccountsLeveVersion(dataTable);
    }

    @Then("^I should see the following UI Elements on the Accounts Currency Level$")
    public void checkAccountElementsMore(DataTable dataTable) {
        accountsFlow.checkAccountsLeveVersion(dataTable);
    }

    @Given("^I see the following UI Elements on the Accounts Currency Level$")
    public void seeUIElements(DataTable dataTable) {
        accountsFlow.checkAccountsLeveVersion(dataTable);
    }

    @And("^I should see the Card list of different asset subAsset class list$")
    public void checkSubAssetClassList() {
        accountsFlow.checkSubAssetClassList();
    }

    @And("^I should see the Card list of different asset class list$")
    public void checkDifferentAssetClass() {
        accountsFlow.checkDifferentAssetClass();
    }

    @Given("^I see the the following UI Elements on the Accounts Level$")
    public void accountsLeveVersion(DataTable dataTable) {
        accountsFlow.checkAccountsLeveVersion(dataTable);
    }

    @When("^I tap the Back Button of Accounts Level$")
    public void tapBackButton() {
        accountsFlow.tapBackButton();
    }

    @Then("^I should see the sub-asset classes are ordered by Total Asset value - largest \\(first\\) to smallest \\(last\\), then by alphabetical order$")
    public void subAssetOrdered() {
        accountsFlow.subAssetOrdered();
    }

    @Then("^I should see the following data on Class List：Asset Class name、Total asset value 2dp format$")
    public void checkClassList() {
        accountsFlow.checkClassList();
    }

    @Then("^I check the first TableCell item of SubClass list：Asset class name、Total asset value 2dp format$")
    public void checkFirstTableCellItemSubClassFormat() {
        accountsFlow.checkFirstTableCellItemSubClassFormat();
    }

    @Then("^I check the first item of SubClass list：Sub-asset Class name、Total asset value 2dp format、Total asset 2dp format percentage$")
    public void checkFirstItemSubClassFormat() {
        accountsFlow.checkFirstItemSubClassFormat();
    }

    @Then("^The Class Button is selected by default$")
    public void classButtonByDefault() {
        accountsFlow.classButtonByDefault();
    }

    @Then("^I check the first item of class list:Asset Class name、Total asset value 2dp format and Total asset 2dp format percentage$")
    public void checkFirstItemClassListFormat() {
        accountsFlow.checkFirstItemClassListFormat();
    }

    @Then("^I should see the asset classes are ordered by Total Asset value - largest \\(first\\) to smallest \\(last\\), then by alphabetical order$")
    public void assetClassesOrdered() {
        accountsFlow.assetClassesOrdered();
    }

    @Then("^I should not see that Asset Class listed$")
    public void notAssetClassList() {
        accountsFlow.notAssetClassList();
    }

    @And("^I tap Account Region button$")
    public void tapRegionButton() {
        accountsFlow.tapRegionButton();
    }

    @Then("^I should not see that Region listed of Accounts level$")
    public void noRegionListOfAccounts() {
        accountsFlow.noRegionListOfAccounts();
    }

    @Then("^I should see the following UI Elements on the Accounts Region Level$")
    public void checkElementsOnAccountsRegion(Map<String,String> map) {
        accountsFlow.checkElementsOnAccountsRegion(map);
    }

    @And("^I should see the Card list of different Accounts Region Level$")
    public void checkDifferentRegionList() {
        accountsFlow.checkDifferentRegionList();
    }

    @Then("^I should see the Region tab is active$")
    public void checkRegionActive() {
        accountsFlow.checkRegionActive();
    }

    @When("^I scroll to first Item of Region list$")
    public void scrollToFirstOfRegionList() {
        accountsFlow.scrollToFirstOfRegionList();
    }

    @Then("^I check the first item of Region list：Region name、Total asset value 2dp format、Total asset 2dp format percentage$")
    public void checkFirstItemRegionFormat() {
        accountsFlow.checkFirstItemRegionFormat();
    }

    @Then("^I should see the regions are ordered by Total Asset value - largest \\(first\\) to smallest \\(last\\), then by alphabetical order$")
    public void orderedRegionsList() {
        accountsFlow.orderedRegionsList();
    }


    @And("^I tap \"Show Sub-Asset Class\" toggle of Accounts level$")
    public void tapSubAssetClassToggle() {
        accountsFlow.tapSubAssetClassToggle();
    }

    @And("^I should see the Allocation And Class And Sub-asset Class is active$")
    public void checkAllocationClassSubClassStatus() {
        accountsFlow.checkAllocationClassSubClassStatus();
    }

    @Then("^I tap on \"Show Sub-Asset Class\" toggle of Accounts level$")
    public void tapOnSubAssetClass() {
        accountsFlow.tapOnSubAssetClass();
    }

    @Then("^I should see the Sub-Asset Class Toggle is off$")
    public void checkSubAssetClassOff() {
        accountsFlow.checkSubAssetClassOff();
    }

    @Then("^I check Allocation and Currency Button state$")
    public void checkAllocationAndCurrencyState() {
        accountsFlow.checkAllocationAndCurrencyState();
    }

    @Then("^I check the first item data of Currency list：Currency name、Total asset ISO3 value、Total asset 2dp report currency value、Total asset 2dp percentage value$")
    public void checkFirstItemCurrencyListFormat() {
        accountsFlow.checkFirstItemCurrencyListFormat();
    }

    @Then("^I should see the currencies are ordered by Total Asset value - largest \\(first\\) to smallest \\(last\\), then by alphabetical order$")
    public void orderedByCurrencyList() {
        accountsFlow.orderedByCurrencyList();
    }


    @Then("^I check Allocation Button state and more Currency state$")
    public void checkMoreCurrencyState() {
        accountsFlow.checkMoreCurrencyState();
    }

    @Then("^I should see the eight item Currency List$")
    public void checkOtherCurrencyElement(Map<String,String> map) {
        accountsFlow.checkOtherCurrencyElement(map);
    }

    @Then("^I scroll down to the bottom on the Accounts Currency Level$")
    public void scrollDownOnAccountsCurrency() {
        accountsFlow.scrollDownOnAccountsCurrency();
    }

    @Then("^I should see ‘Other’ category is always at the bottom of the list, even if its combined total has a higher value than 1 or more of the 7 currencies already listed$")
    public void checkOtherDown() {
        accountsFlow.checkOtherDown();
    }

    @Then("^I should not see that currency listed on the Accounts Level$")
    public void notCurrencyList() {
        accountsFlow.notCurrencyList();
    }

    @And("^I slides to the 6th pip$")
    public void secondSlidesTo6ThPip() {
        accountsFlow.secondSlidesTo6ThPip();
    }

    @And("^I come back to the account List$")
    public void backToTheAccountList() {
        accountsFlow.backToTheAccountList();
    }

    @When("^I slide to right$")
    public void slideToRight() {
        accountsFlow.slideToRight();
    }

    @And("^I slide to left$")
    public void slideToLeft() {
        accountsFlow.slideToLeft();
    }

    @Then("^I should see Overlay relating to that item$")
    public void seeOverlayRelatingToThatItem(){
        accountsFlow.seeOverlayRelatingToThatItem();
    }

    @Then("^I should on the Account level$")
    public void seeTheAccountLevel() {
        accountsFlow.seeTheAccountLevel();
    }

    @Given("^I am on the Account level$")
    public void viewingTheAccountLevel() {
        accountsFlow.seeTheAccountLevel();
    }

    @When("^I tap the Account Allocation Toggle ON$")
    public void tapTheAllocationToggleON() {
        accountsFlow.tapAccountsAllocationToggle();
    }

    @Then("^I should see the Portfolio list by default$")
    public void checkPortfolioList0IsVisible() {
        accountsFlow.checkPortfolioList0IsVisible();
    }

    @Then("^I should viewing Portfolio list with only 1$")
    public void seePortfolioListWithOnly1() {
        //accountsFlow.seePortfolioListWithOnly1();
    }

    @Given("^I am viewing Portfolio list with only 1$")
    public void iAmViewingPortfolioListWithOnly(){
        //accountsFlow.seePortfolioListWithOnly1();
    }

    @When("^I tap 3rd of Portfolios List$")
    public void tapPortfoliosList3() {
        accountsFlow.tapPortfoliosList3();
    }

    @Then("^I should viewing Portfolio list between 2 and 12 items$")
    public void checkPortfolioListBetween2And12Items() {
        accountsFlow.checkPortfolioListVisible();
    }

    @Given("^I am viewing Portfolio list between 2 and 12 items$")
    public void viewingPortfolioListVisible(){
        accountsFlow.checkPortfolioListVisible();
    }

    @Then("^I should see a detailed view relating to that item on the portfolios page$")
    public void checkPortfolios0IdVisible() {
        accountsFlow.checkPortfolios0IdVisible();
    }

    @Given("^I see a detailed view relating to that item on the portfolios page$")
    public void seePortfolios0IdVisible() {
        accountsFlow.checkPortfolios0IdVisible();
    }

    @And("^I should not be able to swipe left or right in account detailed view$")
    public void checkNotSwipeLeftOrRight() {
        accountsFlow.checkNotSwipeLeftOrRight();
    }


    @When("^I taps on 2nd items in Portfolio list$")
    public void tapsPortfolioList2() {
        accountsFlow.tapsPortfolioList2();
    }

    @When("^I taps on third item of Portfolios list$")
    public void tapsPortfoliosList3(){
        accountsFlow.tapsPortfoliosList3();
    }

    @Then("^I should viewing Portfolio with 13 items$")
    public void checkPortfolioListVisible13(){
        accountsFlow.checkPortfolioListVisible13();
    }

    @Given("^I am viewing Portfolio with 13 items$")
    public void viewingPortfolioListVisible13(){
        accountsFlow.checkPortfolioListVisible13();
    }

//    @When("^I swipe right to another account$")
//    public void swipeRight(){
//        accountsFlow.slideToRight();
//    }


    @Then("^I can swipe the pips from 1st to the last one continuously within account wrapper$")
    public void swipePipsFrom1StToLast() {
        accountsFlow.swipePipsFrom1StToLast();
    }

    @And("^I swipe left to the (\\d+)th account within account wrapper$")
    public void pipLeftLargestSize(int largestSize) {
        accountsFlow.pipLeftLargestSize(largestSize);

    }

    @And("^I tap on \"Region\" tab of Account Level$")
    public void TapAccountRegionTab(){
        accountsFlow.TapAccountRegionTab();
    }

    @Then("^I can see the related content in the Asset Class list$")
    public void checkAccountClassData0() {
        accountsFlow.checkAccountClassData0();
    }

    @Then("^I can see the 1th account's Sub asset Class Toggle is ON$")
    public void checkSubAssetClassToggleIsON() {
        accountsFlow.checkSubAssetClassToggleIsON();
    }

    @Then("^I can not see the Sub-asset Class list Under its Class list item$")
    public void checkNoSubClass(){
        accountsFlow.checkNoSubClass();
    }

    @Then("^I can see the related content in the Asset Currency list$")
    public void checkAccountCurrencyData0(){
        accountsFlow.checkAccountCurrencyData0();
    }

    @Then("^I can see the related content in the Asset Region list$")
    public void checkAccountRegionData0(){
        accountsFlow.checkAccountRegionData0();
    }

    @And("^I can see the related content in the Portfolio list$")
    public void checkPortfolioListDateChange(){
        accountsFlow.checkPortfolioListDateChange();
    }

    @And("^I swipe left to other account on \"([^\"]*)\" tab$")
    public void accountSwipeLeftRegion(String tab){
        accountsFlow.accountSwipeLeft(tab);
    }

    @When("^I tap 5th item of Portfolios list$")
    public void tapPortfoliosList5(){
        accountsFlow.tapPortfoliosList5();
    }

    @When("^I tap 14th item of Portfolios list$")
    public void tapPortfoliosList14(){
        accountsFlow.tapPortfoliosList14();
    }

    @When("^I tap 15th item of Portfolios list$")
    public void tapPortfoliosList15(){
        accountsFlow.tapPortfoliosList15();
    }

    @Then("^I should see the account name and account number and total assets value and updated time in the account wrapper will be changed$")
    public void checkAccountWrapperChange() {
        accountsFlow.checkAccountWrapperChange();
    }


    @When("^I tap fourth item of Portfolios list$")
    public void tapPortfoliosList4() {
        accountsFlow.tapPortfoliosList4();
    }

    @Then("^I should see a detailed view relating to that account$")
    public void seeAccount(){
        seeTheAccountLevel();
    }

    @And("^NO pips to indicate that they can swipe left or right within account view$")
    public void noPips() {
        accountsFlow.noPips();
    }

    @Given("^I am on the account level in UserE$")
    public void iAmOnTheAccountLevelInUserE() {
        accountsFlow.seeTheAccountLevel();
    }

    @When("^I tap 3rd of Portfolios List down$")
    public void tapPortfoliosListDown() {
        accountsFlow.tapPortfoliosListDown();
    }

    @When("^I tap five item of Accounts List$")
    public void tapAccountsList5(){
        accountsFlow.tapAccountsList5();
    }

    @When("^I tap first item of Portfolios list down$")
    public void tapAccountsList1Down(){
        accountsFlow.tapAccountsList1Down();
    }

    @When("^I tap first item of class list at account level$")
    public void tapFirstClass(){
        accountsFlow.tapFirstClass();
    }

    @And("^I tap first Sub-Asset class item at account level$")
    public void tapFirstSubClass(){
        accountsFlow.tapFirstSubClass();
    }

    @And("^I tap first item of Account region list$")
    public void tapFirstRegion(){
        accountsFlow.tapFirstRegion();
    }

    @And("^I tap the account Allocation Currency Tab$")
    public void tapAccountCurrencyTab(){
        accountsFlow.tapAccountCurrencyTab();
    }

    @Then("^I should see account Overlay relating to that item$")
    public void checkAccountOverlayRelating(){
        accountsFlow.checkAccountOverlayRelating();
    }

    @Then("^I should see the class list at account level$")
    public void checkAccountClassList(){
        accountsFlow.checkAccountClassList();
    }

    @Then("^I should see a list of holdings that they own within that Asset Class for that Account$")
    public void checkAllocationHolding(){
        accountsFlow.checkAllocationHolding();
    }

    @Then("^I should see a list of holdings that they own within that sub-asset class for that Account$")
    public void checkAllocationSubClassHolding(){
        this.checkAllocationHolding();
    }

    @Then("^I should see a list of holdings that they own within that Region for that Account$")
    public void checkRegionHolding(){
        this.checkAllocationHolding();
    }

    @Then("^I should see a list of holdings that they own within that Currency for that Account$")
    public void checkCurrencyHolding(){
        this.checkAllocationHolding();
    }

    @Given("^I am see the class list at account Screen$")
    public void seeAccountClassList() {
        this.checkAccountClassList();
    }

    @And("^I tap 16th item of Portfolios list$")
    public void tapPortfoliosList16(){
        accountsFlow.tapPortfoliosList16();
    }

    @Then("^I should see the portfolio lists following data portfolio name、portfolio number、management type、total assets value$")
    public void checkPortfolioListData() {
        accountsFlow.checkPortfolioListData();
    }

    @Then("^I should see portfolio total assets \\(value in reporting currency to 2 d\\.p\\.\\)$")
    public void checkPortfolioListAmountFormat(){
        accountsFlow.checkPortfolioListAmountFormat();
    }

    @Then("^I should see the portfolios list are ordered by Total Assets value \\(largest first, smallest last and then in alphabetical order based on first letter of Portfolio Name value\\)$")
    public void checkPortfolioListAmountOrder() {
        accountsFlow.checkPortfolioListAmountOrder();
    }

    @Then("^I should see the following UI Elements on the Accounts Level$")
    public void checkAccountLevelUI(Map<String,String> map) {
        accountsFlow.checkAccountLevelUI(map);
    }

    @Then("^I should see a link to an account overlay showing how this value has been calculated is displayed$")
    public void seeAccountOverlay2(){
        accountsFlow.seeAccountOverlay2();
    }

    @Then("^I should see the value for the \"Total assets\" the client owns within that Account is displayed in full to 2 d\\.p\\., which will be 18 characters max$")
    public void checkAccountTotalAssetsValue2Format() {
        accountsFlow.checkAccountTotalAssetsValue2Format();
    }

    @Then("^I should see the accounts Total asset value at the Account Level Overlay equals the sum of each Portfolio asset value$")
    public void checkTotalAssetEquals() {
        accountsFlow.checkTotalAssetEquals();
    }

    @Then("^I should see a value of \"0\\.00\" for the \"Total assets\" they own within that Account is displayed$")
    public void checkTotalAssetsValue16Format()  {
        accountsFlow.checkTotalAssetsValue16Format();
    }

    @And("^I should see the accounts reporting currency is displayed in ISO3 code format$")
    public void checkTotalAssetsISO3(){
        accountsFlow.checkTotalAssetsISO3();
    }

    @And("^I taps on the account total assets value$")
    public void tapsAccountTotalAssets() {
        accountsFlow.tapsAccountTotalAssets();
    }

    @Then("^I should see the account total assets data is show$")
    public void checkAccountTotalAssetsUI(DataTable dataTable){
        globalOverlayFlow.checkGlobalLegalUI(RegionUtil.getMap(dataTable));
    }

    @Given("^I am see the account total assets data is show$")
    public void seeAccountTotalAssetsUI(Map<String,String> map){
        accountsFlow.checkAccountTotalAssetsUI(map);

    }

    @Then("^I should see Total Assets value for the Account in current reporting currency to 2dp$")
    public void checkAccountPopUpTotalAssetsValueFormat(){
        accountsFlow.checkAccountPopUpTotalAssetsValueFormat();
    }

    @Then("^I should see Account Reporting Currency ISO 3 code$")
    public void checkAccountPopUpTotalAssetsValueIOS3() {
        accountsFlow.checkAccountPopUpTotalAssetsValueIOS3();

    }

    @When("^I taps on close button of account overlay$")
    public void closeAccountOverlay(){
        accountsFlow.closeOverlayInAccountLevel();
    }

    @When("^I tap anywhere on the screen outside of the account overlay frame$")
    public void tapAccountOverlayOutside(){
        accountsFlow.tapAccountOverlayOutside();
    }

    @Then("^I should see the Account Total Assets overlay is closed$")
    public void checkAccountTotalAssetsOverlayClose(){
        accountsFlow.checkAccountTotalAssetsOverlayClose();
    }

    @When("^I tap on the account total assets value$")
    public void tapAccountTotalAssetsValue(){
        accountsFlow.tapAccountTotalAssetsValue();
    }

    @When("^I tap thirdly item of Portfolios list$")
    public void tapThirdlyPortfolio() {
        accountsFlow.tapThirdlyPortfolio();
    }

    @When("^I tap on account \"Currency Conversion\" icon$")
    public void tapAccountConversion() {
        accountsFlow.tapAccountConversion();
    }

    @Then("^I should see the portfolio list specific item following datas: a downward pointing chevron、TWRR % figure with a symbol -$")
    public void checkPortfolioListTWRRNegative(){
        accountsFlow.checkPortfolioListTWRRNegative();
    }

    @Then("^I should see the portfolio list specific item following datas: a upward pointing chevron、a positive TWRR % figure$")
    public void checkPortfolioListTWRRPositive() {
        accountsFlow.checkPortfolioListTWRRPositive();
    }

    @Then("^I should see the portfolio list total all item following datas: TWRR % figure are recorded as % to 2\\.d\\.p$")
    public void checkPortfolioListTWRRFormat() {
        accountsFlow.checkPortfolioListTWRRFormat();
    }

    @Then("^the portfolio list specific item TWRR % figure is 0\\.00%$")
    public void checkPortfolioListTWRRZero() {
        accountsFlow.checkPortfolioListTWRRZero();
    }

    @Then("^I should see portfolio list specific item is no - symbol and no chevron$")
    public void checkPortfolioListNoSymbolAndNoChevron() {
        accountsFlow.checkPortfolioListNoSymbolAndNoChevron();
    }

    @Then("^I should see the account 2 following information:$")
    public void checkAccountPerformanceUI2(Map<String,String> map) {
        accountsFlow.checkAccountPerformanceUI(map, 2);
    }

    @Then("^I should see the account 1 following information:$")
    public void checkAccountPerformanceUI(Map<String,String> map) {
        accountsFlow.checkAccountPerformanceUI(map, 1);
    }

    @Then("^I should see the account following datas: ISO 3 format of performance currency$")
    public void checkAccountPerformanceISO3(){
        accountsFlow.checkAccountPerformanceISO3();
    }

    @Then("^I should see the account following datas: 2dp format of performance value、2dp format of TWRR % figure$")
    public void checkAccountPerformance2dp(){
        accountsFlow.checkAccountPerformance2dp();
    }

    @Then("^the account TWRR % figure is 0\\.00$")
    public void checkAccountTWRRZero() {
        accountsFlow.checkAccountTWRRZero();
    }

    @And("^the account Performance value is 0\\.00$")
    public void checkPerformanceValueZero(){
        accountsFlow.checkPerformanceValueZero();
    }

    @Then("^I should see there is no \\+ symbol or - symbol before the TWRR % figure and Performance value$")
    public void checkTWRRPerformanceNoSymbol(){
        accountsFlow.checkTWRRPerformanceNoSymbol();
    }

    @Then("^I should see the account performance overlay 1 following datas:$")
    public void checkAccountPerformanceOverlayUI(Map<String,String> map) {
        accountsFlow.checkAccountPerformanceOverlayUI(map,1);
    }

    @Then("^I should see the account performance overlay 2 following datas:$")
    public void checkAccountPerformanceOverlayUI2(Map<String,String> map) {
        accountsFlow.checkAccountPerformanceOverlayUI(map,2);
    }

    @When("^I tap account performance$")
    public void tapAccountPerformance() {
        accountsFlow.tapAccountPerformance();
    }

    @Then("^I should see account wrapper performance corresponding overlay performance$")
    public void checkAccountPerformanceValue() {
        accountsFlow.checkAccountPerformanceValue();
    }

    @Then("^I should see the account performance overlay following datas: 2dp format of Performance value、2dp format of TWRR % figure$")
    public void checkAccountPerformanceOverlay2dp() {
        accountsFlow.checkAccountPerformanceOverlay2dp();
    }

    @Then("^I should see the account performance overlay following datas: ISO3 format of Performance value$")
    public void checkAccountPerformanceOverlayISO3() {
        accountsFlow.checkAccountPerformanceOverlayISO3();
    }

    @Then("^I should on the account performance overlay$")
    public void onTheAccountPerformanceOverlay(){
        accountsFlow.checkAccountPerformanceOverlay();
    }
    @Given("^I am on the account performance overlay$")
    public void onAccountPerformanceOverlay(){
        accountsFlow.checkAccountPerformanceOverlay();
    }

    @Then("^the account performance overlay TWRR % figure is 0\\.00$")
    public void checkAccountPerformanceOverlayTWRRZero(){
        accountsFlow.checkAccountPerformanceOverlayTWRRZero();
    }

    @And("^the account performance overlay Performance value is 0\\.00$")
    public void checkAccountPerformanceOverlayPerformanceZero(){
        accountsFlow.checkAccountPerformanceOverlayPerformanceZero();
    }

    @Then("^I should see account performance overlay there is no \\+ symbol or - symbol before the TWRR % figure and Perfermance value$")
    public void checkAccountPerformanceOverlayThereIsNoSymbol() {
        accountsFlow.checkAccountPerformanceOverlayThereIsNoSymbol();
    }

    @Then("^I should see the \"([^\"]*)\" title in Account asset Overlay$")
    public void checkAccountAssetTitleOverlay(String title){
        accountsFlow.checkAccountAssetTitleOverlay(title);
    }

    @Then("^I should see account a header \"([^\"]*)\" is displayed instead of Total assets$")
    public void checkAccountAssets(String asset) {
        accountsFlow.checkAccountAssets(asset);
    }

    @When("^I taps on \"x\" top right of account performance overlay$")
    public void tapCloseAccountPerformanceOverlay(){
        accountsFlow.tapCloseAccountPerformanceOverlay();
    }

    @Then("^I should see the account performance overlay is closed$")
    public void checkAccountPerformanceOverlayClosed(){
        accountsFlow.checkAccountPerformanceOverlayClosed();
    }

    @And("^I taps anywhere on the screen outside of the account performance overlay frame$")
    public void tapAnywhereAccountPerformanceOverlay() {
        accountsFlow.tapAnywhereAccountPerformanceOverlay();
    }

    @Then("^I can view the account holding following information:a upward pointing chevron、a positive % figure$")
    public void checkAccountHoldingTWRRPositive() {
        accountsFlow.checkAccountHoldingTWRRPositive();

    }

    @Then("^I can view the account holding following information:a downward pointing chevron、a negative % figure with a symbol -$")
    public void checkAccountHoldingTWRRNegative(){
        accountsFlow.checkAccountHoldingTWRRNegative();
    }

    @Then("^I can view the account holding following information:2dp format of % figure$")
    public void checkAccountHoldingTWRR2dp(){
        accountsFlow.checkAccountHoldingTWRR2dp();
    }

    @When("^the account holding % figure is 0\\.00%$")
    public void checkAccountHoldingTWRRZero() {
        accountsFlow.checkAccountHoldingTWRRZero();
    }

    @Then("^I should see account holding there is no - symbol and no chevron$")
    public void checkAccountHoldingTWRRNoSymbolNoChevron() {
        accountsFlow.checkAccountHoldingTWRRNoSymbolNoChevron();
    }

    @Then("^I should see account holding wrapper ISO 3 code of account reference currency$")
    public void checkAccountHoldingWrapperISO3(){
        accountsFlow.checkAccountHoldingWrapperISO3();
    }

    @And("^I am viewing the end of Portfolio list$")
    public void viewEndOfPortfolioList() {
        accountsFlow.viewEndOfPortfolioList();
    }

    @Then("^I can see the \"([^\"]*)\" Account following link to a legal overlay calculated value:\"([^\"]*)\"$")
    public void checkAccountGlobalLegalDisclaimer(String region,String disclaimer) {
        accountsFlow.checkAccountGlobalLegalDisclaimer(region,disclaimer);
    }
    @Given("^I am viewing the \"([^\"]*)\" Account \"([^\"]*)\" link at the bottom of the portfolio list$")
    public void seePortfolioListGlobalLegalDisclaimer(String region,String disclaimer) {
        accountsFlow.checkAccountGlobalLegalDisclaimer(region,disclaimer);
    }

    @Then("^I can see a list of holdings that they own across all of their Accounts within that Asset Class$")
    public void checkAccountAssetClassHoldings() {
        accountsFlow.checkAccountAllocationHoldings();
    }

    @Then("^client can see a list of holdings that they own across all of their Accounts within that sub-asset class$")
    public void checkAccountSubAssetClassHoldings() {
        accountsFlow.checkAccountAllocationHoldings();
    }

    @Then("^client can see a list of holdings that they own in that currency for that Account$")
    public void checkAccountCurrencyHoldings() {
        accountsFlow.checkAccountAllocationHoldings();
    }

    @Then("^I can see a list of holdings that they own within that Region for that Account$")
    public void checkAccountRegionHoldings() {
        accountsFlow.checkAccountAllocationHoldings();
    }

    @Then("^I can see a list of account allocation holdings with the following details when P/L is positive AND holding ccy is DIFFERENT$")
    public void checkAccountAllocationHoldingsPositiveAndDIFFERENT(){
        accountsFlow.checkAccountAllocationHoldingsPositiveAndDIFFERENT();
    }

    @Then("^I can see ISO 3 code of account allocation holding currency、Account reference currency$")
    public void checkAccountAllocationHoldingsPositiveAndDIFFERENTISO3(){
        accountsFlow.checkAccountAllocationHoldingsPositiveAndDIFFERENTISO3();
    }

    @Then("^I can see a list of account allocation holdings with the following details when P/L is negative AND holding ccy is DIFFERENT$")
    public void checkAccountAllocationHoldingsNegativeAndDIFFERENT(){
        accountsFlow.checkAccountAllocationHoldingsNegativeAndDIFFERENT();
    }

    @Then("^I can see ISO 3 code of account allocation holding currency、Account reference currency when P/L is negative AND holding ccy is DIFFERENT$")
    public void checkAccountAllocationHoldingsNegativeAndDIFFERENTISO3() {
        accountsFlow.checkAccountAllocationHoldingsNegativeAndDIFFERENTISO3();
    }

    @Then("^I can see a list of account allocation holdings with the following details when P/L is positive AND holding ccy is the SAME$")
    public void checkAccountAllocationHoldingsPositiveAndSAME(){
        accountsFlow.checkAccountAllocationHoldingsPositiveAndSAME();
    }

    @Then("^I can see ISO 3 code of account allocation holding currency when P/L is positive AND holding ccy is the SAME$")
    public void checkAccountAllocationHoldingPositiveAndSAMEISO3(){
        accountsFlow.checkAccountAllocationHoldingPositiveAndSAMEISO3();
    }

    @Then("^I can see a list of account allocation holdings with the following details when P/L is negative AND holding ccy is the SAME$")
    public void checkAccountAllocationHoldingsNegativeAndSAME(){
        accountsFlow.checkAccountAllocationHoldingsNegativeAndSAME();
    }

    @Then("^I can see ISO 3 code of account allocation holding currency when P/L is negative AND holding ccy is the SAME$")
    public void checkAccountAllocationHoldingsNegativeAndSAMEISO3(){
        accountsFlow.checkAccountAllocationHoldingsNegativeAndSAMEISO3();
    }

    @Then("^I can see a list of accounts allocation holdings with the following details when P/L figure is relevant And holding ccy is DIFFERENT$")
    public void checkAccountsAllocationHoldingsRelevantAndDIFFERENT(){
        accountsFlow.checkAccountAllocationHoldingsNegativeAndDIFFERENT();
    }

    @Given("^I see a list of accounts allocation holdings with the following details when P/L figure is relevant And holding ccy is DIFFERENT$")
    public void accountsAllocationHoldingsRelevantAndDIFFERENT(){
        accountsFlow.checkAccountAllocationHoldingsNegativeAndDIFFERENT();
    }

    @Then("^I can see ISO 3 code of accounts allocation holding currency and ISO 3 code of ACCOUNT reference currency when P/L figure is relevant And holding ccy is DIFFERENT$")
    public void checkAccountsAllocationHoldingsRelevantAndDIFFERENTISO3(){
        accountsFlow.checkAccountAllocationHoldingsNegativeAndDIFFERENTISO3();
    }

    @Then("^I can see a list of accounts allocation holdings with the following details when P/L figure is NOT relevant AND holding ccy is DIFFERENT$")
    public void checkAccountsAllocationHoldingsNotRelevantAndDIFFERENT(){
        accountsFlow.checkAccountsAllocationHoldingsNotRelevantAndDIFFERENT();
    }

    @Given("^I see a list of accounts allocation holdings with the following details when P/L figure is NOT relevant AND holding ccy is DIFFERENT$")
    public void accountsAllocationHoldingsNotRelevantAndDIFFERENT(){
        accountsFlow.checkAccountsAllocationHoldingsNotRelevantAndDIFFERENT();
    }

    @Then("^I can see ISO 3 code of accounts allocation holding currency and ISO 3 code of ACCOUNT reference currency when P/L figure is NOT relevant AND holding ccy is DIFFERENT$")
    public void checkAccountsAllocationHoldingsNotRelevantAndDIFFERENTISO3(){
        accountsFlow.checkAccountsAllocationHoldingsNotRelevantAndDIFFERENTISO3();
    }

    @When("^I tap (\\d+)th item of account allocation holding list$")
    public void tapAccountAllocationHoldingList(int num){
        accountsFlow.tapAccountAllocationHoldingList(num);
    }

    @Then("^I should see the Account assets value is displayed based on the Account reference currency \"([^\"]*)\"$")
    public void checkAccountReferenceCurrency(String referenceCurrency){
        accountsFlow.checkAccountReferenceCurrency(referenceCurrency);
    }

    @Then("^ISO 3 code of the Account reference currency is displayed adjacent to the Account assets value.$")
    public void checkTotalAssetISO3(){
        accountsFlow.checkTotalAssetISO3();
    }

    @Then("^I should see the account allocation screen$")
    public void checkInAllocation(){
        accountsFlow.checkInAllocation();
    }

    @Given("^I see the account allocation screen$")
    public void seeInAllocation(){
        this.checkInAllocation();
    }

    @When("^I tap Account Total Liabilities$")
    public void tapAccountTotalLiabilities(){
        accountsFlow.tapAccountTotalLiabilities();
    }

    @When("^I swap left the pips for account total liabilities overlay$")
    public void swapLeftAccountTotalLiabilitiesOverlay() {
        accountsFlow.swapLeftAccountTotalLiabilitiesOverlay();
    }

    @Then("^I should see the Account Total Liabilities overlay will be changed$")
    public void checkAccountTotalLiabilitiesOverlayChanged() {
        accountsFlow.checkAccountTotalLiabilitiesOverlayChanged();
    }

    @Then("^I should see the follow element on account liabilities:$")
    public void checkAccountLiabilitiesUI(Map<String,String> map){
        accountsFlow.checkAccountLiabilitiesUI(map);
    }

    @Then("^I am see the follow element on account liabilities:$")
    public void seeAccountLiabilitiesUI(Map<String,String> map){
        accountsFlow.checkAccountLiabilitiesUI(map);
    }

    @Then("^I should see the value for the Total Liabilities they own within the account is displayed,which will be (\\d+) characters max,including commas and decimal point$")
    public void checkTotalLiabilitiesValueMaxIncludingCommasAndDecimalPoint(int maxNumber) {
        accountsFlow.checkTotalLiabilitiesValueMaxIncludingCommasAndDecimalPoint(maxNumber);
    }

    @Then("^I should see the account liabilities base currency is displayed in ISO 3 code format$")
    public void checkAccountLiabilitiesISO3(){
        accountsFlow.checkAccountLiabilitiesISO3();
    }

    @Then("^I should see the Account Total Liabilities in Account wrapper will be changed$")
    public void checkAccountWrapperTotalLiabilitiesChanged() {
        accountsFlow.checkAccountWrapperTotalLiabilitiesChanged();
    }

    @When("^I minifiles the Account wrapper$")
    public void minifilesTheAccountWrapper(){
        accountsFlow.minifilesTheAccountWrapper();
    }

    @Then("^I should see the Account name/External Id/Update time/Account Liabilities/Net account Assets will be fade in and they will be disappeared$")
    public void checkMinifilesAccountWrapperUI() {
        accountsFlow.checkMinifilesAccountWrapperUI();
    }

    @And("^I should see the account name and Account Assets$")
    public void checkAccountNameAndAccountAssets() {
        accountsFlow.checkAccountNameAndAccountAssets();
    }

    @Then("^I should not see a Total Liabilities label,chervon or figure displayed$")
    public void checkNoTotalLiabilities(){
        accountsFlow.checkNoTotalLiabilities();
    }

    @Then("^I am not see a Total Liabilities label,chervon or figure displayed$")
    public void noTotalLiabilities(){
        accountsFlow.checkNoTotalLiabilities();
    }

    @Then("^I should see the Account Liabilities is displayed \"([^\"]*)\"$")
    public void checkAccountLiabilitiesZero(String value){
        accountsFlow.checkAccountLiabilitiesZero(value);
    }

    @Then("^I should not see the Account Liabilities and the Net Assets$")
    public void checkNoAccountLiabilitiesAndNetAssets() {
        accountsFlow.checkNoAccountLiabilitiesAndNetAssets();
    }

    @Then("^I can see the Class and Currency tap at account level$")
    public void checkSeeClassAndCurrency() {
        accountsFlow.checkSeeClassAndCurrency();
    }

    @And("^I should not see the Region tap at account level$")
    public void checkNotSeeRegion() {
        accountsFlow.checkNotSeeRegion();
    }

    @When("^I swipe left to other account$")
    public void swipeLeftScreen() {
        accountsFlow.swipeLeftScreen();
    }

    @Then("^I should see the follow element on account net assets:$")
    public void checkAccountNetAssetsUI(Map<String, String> map) {
        accountsFlow.checkAccountNetAssetsUI(map);
    }

    @Then("^I am see the follow element on account net assets:$")
    public void seeAccountNetAssetsUI(Map<String, String> map) {
        accountsFlow.checkAccountNetAssetsUI(map);
    }

    @Then("^I should see the value for the net assets they own within the account is displayed,which will be (\\d+) characters max,including commas and decimal point$")
    public void checkAccountNetAssetsMax(int maxNumber) {
        accountsFlow.checkAccountNetAssetsMax(maxNumber);
    }

    @Then("^I should see the account net assets base currency is displayed in ISO 3 code format$")
    public void checkAccountNetAssetsISO3(){
        accountsFlow.checkAccountNetAssetsISO3();
    }

    @Then("^I should see that Account Net Assets = Account Total Assets - Account liabilities$")
    public void checkAccountNetAssetsEqualTotalAssetsReductionOfTotalLiabilities(){
        accountsFlow.checkAccountNetAssetsEqualTotalAssetsReductionOfTotalLiabilities();
    }

    @When("^I swap left the pips for account net assets$")
    public void swapLeftAccountNetAssets() {
        accountsFlow.swapLeftAccountNetAssets();
    }

    @When("^I swipe left (\\d+)th to other account$")
    public void swapLeftNthAccount(int num) {
        accountsFlow.swapLeftNthAccount(num);
    }

    @When("^I swipe right (\\d+)th to other account$")
    public void swapRightNthAccount(int num) {
        accountsFlow.swapRightNthAccount(num);
    }

    @Then("^I should see the Account Net Assets will be changed$")
    public void checkAccountNetAssetsChanged() {
        accountsFlow.checkAccountNetAssetsChanged();
    }

    @Then("^I should not see a Net assets label or figure displayed$")
    public void checkNotNetAssets() {
        accountsFlow.checkNotNetAssets();
    }

    @Then("^I should see a Account Net assets label or figure displayed \"([^\"]*)\"$")
    public void checkAccountNetAssets(String value){
        accountsFlow.checkAccountNetAssets(value);
    }

    @Then("^I can see the following components for discretionary portfolio:$")
    public void checkDiscretionaryUI(Map<String, String> map){
        accountsFlow.checkDiscretionaryUI(map);
    }

    @Then("^I can see the following components for Advisory portfolio:$")
    public void checkAdvisoryUI(Map<String, String> map){
        accountsFlow.checkAdvisoryUI(map);
    }

    @Then("^I should see the Discretionary portfolio item include:$")
    public void checkSlipDiscretionaryUI(Map<String, String> map){
        accountsFlow.checkSlipDiscretionaryUI(map);
    }

    @Then("^I should see the Advisory portfolio item include:$")
    public void checkSlipAdvisoryUI(Map<String, String> map){
        accountsFlow.checkSlipAdvisoryUI(map);
    }

    @Then("^I should see that proper number of portfolio item will not display a performance figure in the Portfolio list \\(under the Account page\\)$")
    public void checkPortfolioItemNotPerformance(){
        accountsFlow.checkPortfolioItemNotPerformance();
    }

    @When("^I slide up to the last portfolio item$")
    public void slipToLastPortfolio(){
        accountsFlow.slipToLastPortfolio();
    }

    @Then("^I can view individual performance % figures for each portfolio as per UK requirements of proper number of item$")
    public void checkPortfolioListHasPerformance(){
        accountsFlow.checkPortfolioListHasPerformance();
    }

    @When("^I tap on account \"Show Sub-Asset Class\" toggle to ON$")
    public void tapShowSubClassToON() {
        accountsFlow.tapShowSubClassToON();
    }

    @Then("^I can not view Performance in the account wrapper container$")
    public void checkNotSeePerformance() {
        accountsFlow.checkNotSeePerformance();
    }

    @And("^I taps on account \"tap here\" link to legal overlay calculated value$")
    public void tapsOnAccountLinkToLegalDisclaimer(){
        accountsFlow.tapsOnAccountLinkToLegalDisclaimer();
    }

    @Then("^I should return to the screen they were on when they tapped \"tap here\" to portfolio list access the legal overlay calculated value screen$")
    public void returnToPortfolioList(){
        accountsFlow.returnToPortfolioList();
    }

    @Then("^I should see the Account Total Assets equal to the Account Total Assets Overlay$")
    public void checkAccountTotalAssetsEqualAccountTotalAssetsOverlay(){
        accountsFlow.checkAccountTotalAssetsEqualAccountTotalAssetsOverlay();
    }

    @Then("^I should see the following empty state copy in portfolio list view:\"([^\"]*)\"$")
    public void checkNoPortfolioMessage(String message){
        accountsFlow.checkNoPortfolioMessage(message);
    }

    @Then("^I will not view account warpper performance$")
    public void checkAccountNoPerformance(Map<String, String> map){
        accountsFlow.checkAccountNoPerformance();
    }

    @And("^the Account wrapper is minifiles$")
    public void theAccountWrapperIsMinifiles(){
        accountsFlow.theAccountWrapperIsMinifiles();
    }

    @And("^the Account wrapper should be minifiles$")
    public void checkAccountWrapperMinifiles(){
        accountsFlow.checkAccountWrapperMinifiles();
    }

    @Then("^I am returned back to the Account page$")
    public void returnedBackToTheAccountPage() {
        accountsFlow.checkOnAccountLevel();
    }

    @And("^the Account wrapper should be maximised$")
    public void checkAccountWrapperMaximised(){
        accountsFlow.checkAccountWrapperMaximised();
    }

    @And("^I tap specific item of Portfolios list$")
    public void tapSpecificItemOfPortfoliosList() {
        accountsFlow.tapSpecificItemOfPortfoliosList();
    }
}
