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

public class OverviewStep extends BaseStep {

    @Autowired
    private OverviewFlow overviewFlow;

    @Autowired
    private AccountsFlow accountsFlow;

    @Autowired
    private GlobalOverlayFlow globalOverlayFlow;

    @Action("click_holdings_back_button")
    public void clickHoldingBackBtn(){
        overviewFlow.clickHoldingBackBtn();
    }

    @Action("close_overlay_in_overview_level")
    public void closeOverlayInOverviewLevel(){
        overviewFlow.closeOverlayInOverviewLevel();
    }

    @Action("click_overview_total_assets")
    public void clickOverviewTotalAssets(){
        overviewFlow.tapOverviewTotalAssets();
    }

    @Action("open_total_liabilities_overlay_on_overview")
    public void closeOverlay() {
        overviewFlow.tapOverviewTotalLiabilitiesOverlay();
    }


    @Given("^I am on the Overview Allocation show sub-assert Screen$")
    public void onShowSubAssertScreen(){
        overviewFlow.assertOnThisScreen();
    }

    @Given("^I see the following components$")
    public void seeMainUI(Map<String, String> map){
        this.checkMainUI(map);
    }

    @Given("^I see the following components on Overview Screen$")
    public void seeAllocationUI(DataTable dataTable){
        overviewFlow.checkOverviewVersionUI(dataTable);
    }

    @Given("^I see the following components with turn on \"Show Sub-Asset Class\" toggle$")
    public void seeRegionUI(Map<String, String> map){
        this.checkRegionUI(map);
    }

    @Given("^I see the following components when the region tab is active:$")
    public void seeUIForTapRegion(Map<String, String> map){
        this.checkRegionUI(map);
    }

    @Given("^I see the following states when tap \"Show Sub-Asset Class\" toggle$")
    public void seeTapSubToggleStatus(Map<String, String> map) {
        this.checkTapSubToggleStatus(map);
    }

    @When("^I tap on \"Show Sub-Asset Class\" toggle$")
    public void tapSubAssetBtn(){
        overviewFlow.tapSubAssetBtn();
    }

    @When("^I go to Portfolio level Screen$")
    public void goToPortfolioScreen(){
        overviewFlow.goToPortfolioScreen();
    }

    @When("^I tap on \"Currency\" tab$")
    public void tapCurrencyTab(){
        overviewFlow.tapCurrencyTab();
    }

    @Then("^I should see the following components$")
    public void checkMainUI(Map<String, String> map){
        overviewFlow.checkOverviewUI(map);
    }

    @Then("^I should see the following components on Overview Screen$")
    public void checkAllocationUI(DataTable dataTable){
        overviewFlow.checkOverviewVersionUI(dataTable);
    }

    @Then("^I should see the following data in Overview class list$")
    public void checkClassData(Map<String, String> map){
        overviewFlow.checkClassData(map);
    }

    @Then("^I should see asset classes are ordered by Total Asset value - largest to smallest$")
    public void checkClassSequence(){
        overviewFlow.checkClassSequence();
    }

    @Then("^I should see the following components with turn on \"Show Sub-Asset Class\" toggle$")
    public void checkUIForTapSubAssert(Map<String, String> map){
        overviewFlow.checkUIForTapSubAssert(map);
    }

    @Then("^I should see the sub-asset classes are ordered by Total Asset value - largest to smallest$")
    public void checkSubClassSequence(){
        overviewFlow.checkSubClassSequence();
    }

    @Then("^I should see the following states:$")
    public void checkAllocationToggleStatus(Map<String, String> map) {
        overviewFlow.checkAllocationToggleStatus();
    }

    @Then("^I should see the following states when tap \"Show Sub-Asset Class\" toggle$")
    public void checkTapSubToggleStatus(Map<String, String> map) {
        if(map.get("Show Sub-Asset Class Toggle").equals("active")){
            overviewFlow.checkTapSubToggleActive();
        } else {
            overviewFlow.checkTapSubToggleDefault();
        }

    }

    @Then("^I should see the Region name$")
    public void checkRegionName(){
        overviewFlow.checkRegionName();
    }

    @Then("^I should see the currency name$")
    public void checkCurrencyName(){
        overviewFlow.checkCurrencyName();
    }

    @Then("^I should see the regions are ordered by Total Asset value - largest to smallest$")
    public void checkRegionSequence(){
        overviewFlow.checkRegionSequence();
    }

    @Then("^I should not see that Region listed$")
    public void checkNotSeeRegionList(){
        overviewFlow.checkNotSeeRegionList();
    }

    @Then("^I should not see that Class listed$")
    public void checkNotSeeClassList(){
        overviewFlow.checkNotSeeClassList();
    }

    @Then("^I should see the following components when the region tab is active:$")
    public void checkRegionUI(Map<String, String> map){
        overviewFlow.checkOverviewUI(map);
    }

    @Then("^I should see the following components when the currency tab is active:$")
    public void checkCurrencyUI(DataTable dataTable){
        overviewFlow.checkOverviewVersionUI(dataTable);
    }

    @Given("^I see the following components when the currency tab is active:$")
    public void seeCurrencyUI(DataTable dataTable){
        overviewFlow.checkOverviewVersionUI(dataTable);
    }

    @Then("^I should see the currencies are ordered by Total Asset value - largest to smallest$")
    public void checkCurrencySequence(){
        overviewFlow.checkCurrencySequence();
    }

    @Then("^I should see the Asset Class name$")
    public void checkAssertClassName(){
        overviewFlow.checkAssertClassName();
    }

    @Then("^I should see the sub-asset class name for each sub-asset class$")
    public void checkSubClassName(){
        overviewFlow.checkSubClassName();
    }

    @Then("^I should not see that sub-asset class listed$")
    public void checkNotSubClassList(){
        overviewFlow.checkNotSubClassList();
    }

    @Then("^The sub-asset class toggle should stay ON at the Overview level \\(only\\) during the current app session \\(only\\)$")
    public void checkSubClassBtnIsOn(){
        overviewFlow.checkSubClassBtnIsOn();
    }

    @Then("^The sub-asset class toggle should stay OFF at the Overview level \\(only\\) during the current app session \\(only\\)$")
    public void checkSubClassBtnIsOff(){
        overviewFlow.checkSubClassBtnIsOff();
    }

    @Then("^I should see the asset classes are ordered by Total Asset value - largest to smallest$")
    public void checkAssetClassSequence(){
        overviewFlow.checkAssetClassSequence();
    }

    @Then("^I should see the following states when tap Currency Tab$")
    public void checkCurrencyStatus(Map<String, String> map){
        overviewFlow.checkCurrencyStatus();
    }

    @Then("^I should see the following states when tap Region Tab$")
    public void checkRegionStatus(Map<String, String> map){
        overviewFlow.checkRegionStatus();
    }

    @Then("^I should see the Grouping label of \"([^\"]*)\"$")
    public void checkOtherLabel(String otherLabel){
        overviewFlow.checkOtherLabel(otherLabel);
    }

    @Then("^I should see‘Other’ category is always at the bottom of the list$")
    public void checkOtherSeat(){
        overviewFlow.checkOtherSeat();
    }

    @Then("^I should not see that currency listed$")
    public void checkNotCurrencyList(){
        overviewFlow.checkNotCurrencyList();
    }

    @And("^I should see the Asset breakdown list of Class$")
    public void checkAssetClassList(){
        overviewFlow.seeAssetClassList();
    }

    @And("^I should see the Card list of different asset currency$")
    public void checkAssetCurrencyList(){
        overviewFlow.checkAssetCurrencyList();
    }

    @And("^I see the Card list of different asset currency$")
    public void seeAssetCurrencyList(){
        overviewFlow.checkAssetCurrencyList();
    }

    @And("^I see the Asset breakdown list of Class$")
    public void seeAssetClassList(){
        overviewFlow.seeAssetClassList();
    }

    @And("^I tap on \"Region\" tab$")
    public void tapRegionTab(){
        overviewFlow.tapRegionTab();
    }

    @And("^I should see the Card list of different asset region$")
    public void checkRegionList(){
        overviewFlow.checkRegionList();
    }

    @And("^I see the Card list of different asset region$")
    public void seeRegionList(){
        overviewFlow.checkRegionList();
    }

    @And("^Region item Total asset value in reporting currency \\(ISO 3 format\\) selected to 2 d.p.$")
    public void checkRegionTotalAssertFormat(){
        overviewFlow.checkRegionTotalAssertFormat();
    }

    @And("^Grouping \"Other\" Total asset value in reporting currency \\(ISO 3 format\\) selected to 2 d.p.$")
    public void checkOtherTotalAssertFormat(){
        overviewFlow.checkOtherTotalAssertFormat();
    }

    @And("^Asset Class Total asset value in reporting currency \\(ISO 3 format\\) selected to 2 d.p.$")
    public void checkClassTotalAssertFormat(){
        overviewFlow.checkClassTotalAssertFormat();
    }

    @And("^sub-asset class Total asset value in reporting currency \\(ISO 3 format\\) selected to 2 d.p.$")
    public void checkSubClassTotalAssertFormat(){
        overviewFlow.checkSubClassTotalAssertFormat();
    }

    @And("^Region item Total asset value as a % of all assets owned to 2 d.p.$")
    public void checkRegionPercentageFormat(){
        overviewFlow.checkRegionPercentageFormat();
    }

    @And("^sub-asset class Total asset value as a % of all assets owned to 2 d.p.$")
    public void checkSubClassPercentageFormat(){
        overviewFlow.checkSubClassPercentageFormat();
    }

    @And("^currency item Total asset value in reporting currency \\(ISO 3 format\\) selected to 2 d.p.$")
    public void checkCurrencyTotalAssertFormat(){
        overviewFlow.checkCurrencyTotalAssertFormat();
    }

    @And("^currency item Total asset value as a % of all assets owned to 2 d.p.$")
    public void checkCurrencyPercentageFormat(){
        overviewFlow.checkCurrencyPercentageFormat();
    }

    @Then("^I should see the following UI Elements on the OverView screen$")
    public void overviewScreenElements(Map<String,String> map){
        overviewFlow.overviewScreenElements();
    }

    @Then("^I should on the Overview screen$")
    public void onOverView() {
        overviewFlow.checkSeeAccountList();
    }
    @Given("^I am on the Overview screen$")
    public void onTheOverView() {
        overviewFlow.checkSeeAccountList();
    }


    @Given("^I am on the Overview Allocation Screen$")
    public void onTheOverviewAndTapAllocationToggle() {
        overviewFlow.onOverviewAllocationScreen();
    }

    @Then("^I should on the Overview Allocation Screen$")
    public void shouldOnOverviewAllocation() {
        overviewFlow.onOverviewAllocationScreen();
    }


    @When("^I tap Asset Overview Allocation toggle$")
    public void clickAllocationButton() {
        overviewFlow.clickAllocationButton();
    }

    @Then("^I should see the following UI Elements on the Overview Level screen$")
    public void overViewLevelScreenElements(Map<String,String> map) {
        overviewFlow.overviewLevelScreenElements();
    }

    @Then("^I check the format of the data of Total asset value$")
    public void checkTotalAssetValueFormat(Map<String,String> map) {
        overviewFlow.checkTotalAssetValueFormat();
    }

    @Then("^Asset classes are ordered by Total Asset value$")
    public void sortByTotalAsset() {
        overviewFlow.sortByTotalAsset();
    }

    @Then("^I should see the following UI Elements on the Overview Class tab$")
    public void noHoldingsClass(DataTable dataTable) {
        overviewFlow.noHoldingsClass(RegionUtil.getMap(dataTable));
    }

    @When("^I tap Overview Currency tab$")
    public void tapsCurrencyTab() {
        overviewFlow.tapsCurrencyTab();
    }

    @Then("^I should see the following UI Elements on the Overview Currency tab$")
    public void noHoldingsCurrency(DataTable dataTable) {
        overviewFlow.noHoldingsCurrency(RegionUtil.getMap(dataTable));
    }

    @When("^I tap Overview Region tab$")
    public void tapsRegionTab() {
        overviewFlow.tapsRegionTab();
    }

    @Then("^I should see the following UI Elements on the Overview Region tab$")
    public void noHoldingsRegion(DataTable dataTable) {
        overviewFlow.noHoldingsRegion(RegionUtil.getMap(dataTable));
    }

    @And("^Grouping \"Other\" Total asset value as a % of all assets owned to 2 d.p.$")
    public void checkOtherPercentageFormat(){
        overviewFlow.checkOtherPercentageFormat();
    }

    @When("^I tap first item of Accounts list$")
    public void tapFirstItemAccountsList() {
        accountsFlow.tapFirstItemAccountsList();
    }
    @When("^I tap 17th item of Accounts list$")
    public void tap17thItemAccountsList() {
        accountsFlow.tap17thItemAccountsList();
    }

    @When("^I tap last item of Accounts list$")
    public void tapLastItemAccountsList() {
        accountsFlow.tapLastItemAccountsList();
    }

    @When("^I tap four item of Accounts list$")
    public void tapFourItemAccountsList() {
        accountsFlow.tapFourItemAccountsList();
    }

    @When("^I tap on \"Show Sub-Asset Class\" toggle to off$")
    public void tapSubClassToggleToOff() {
        overviewFlow.tapSubClassToggleToOff();
    }

    @When("^I back to Overview Allocation class screen$")
    public void backOverviewAllocationScreen() {
        overviewFlow.backOverviewAllocationScreen();
    }

    @When("^I scroll down to the bottom$")
    public void currencyScrollDownToBottom() {
        overviewFlow.currencyScrollDownToBottom();
    }

    @Then("^I should see the account list$")
    public void checkSeeAccountList() {
        overviewFlow.checkSeeAccountList();
    }
    @Given("^I see the account list$")
    public void seeTheAccountList() {
        overviewFlow.checkSeeAccountList();
    }
    @Then("^I should see a list of holdings that they own across all of their Accounts within that Asset Class at overview level$")
    public void checkAllocationHolding() {
        overviewFlow.checkInHoldingPage();
    }

    @Then("^I should see a list of holdings that they own across all of their Accounts within that sub-asset class at overview level$")
    public void checkInHoldingForTapSubClass() {
        this.checkAllocationHolding();
    }

    @Then("^I should see a list of holdings that they own within that Region for that Overview$")
    public void checkRegionHolding() {
        this.checkAllocationHolding();
    }

    @Then("^I should see a list of holdings that they own within that currency for that Overview$")
    public void checkCurrencyHolding() {
        this.checkAllocationHolding();
    }

    @Then("^I should see the class list at overview level$")
    public void checkClassList() {
        overviewFlow.checkClassList();
    }
    @Given("^I am see the class list at Overview Screen$")
    public void seeClassList() {
        this.checkClassList();
    }

    @And("^I tap first Sub-Asset class item at overview screen$")
    public void tapFirstSubClass(){
        overviewFlow.tapFirstSubClass();
    }

    @When("^I slides to the 2nd item$")
    public void slidesTo2NdItem() {
        overviewFlow.slidesTo2NdItem();
    }

    @And("^I taps on the 2nd item$")
    public void taps2ThItemOfAccountsList(){
        overviewFlow.taps2ThItemOfAccountsList();
    }

    @And("^I tap first item of Overview region list$")
    public void tapFirstRegion(){
        overviewFlow.tapFirstRegion();
    }

    @And("^I tap first item of Overview currency list$")
    public void tapFirstCurrency(){
        overviewFlow.tapFirstCurrency();
    }

    @Then("^I should see the 6th item and sort of adjacent is visible$")
    public void see6ThItemAndSortOfAdjacentIsVisible(){
        overviewFlow.see6ThItemAndSortOfAdjacentIsVisible();
    }


    @Then("^I should see the last item and sort of adjacent is visible$")
    public void seeTheLastItemAndSortOfAdjacentIsVisible() {
        overviewFlow.seeTheLastItemAndSortOfAdjacentIsVisible();
    }

    @When("^I tap 3th item of Accounts list$")
    public void tap3ThItemOfAccountsList(){
        overviewFlow.tap3ThItemOfAccountsList();
    }

    @When("^I tap 15th item of Accounts List$")
    public void tapAccountsList15(){
        overviewFlow.tapAccountsList15();
    }

    @When("^I tap 16th item of Accounts List$")
    public void tapAccountsList16(){
        overviewFlow.tapAccountsList16();
    }

    @Then("^I should see the following UI Elements on the account list$")
    public void checkAccountListUI(Map<String,String> map) {
        overviewFlow.checkOverviewUI(map);
    }

    @Given("^I see the following UI Elements on the account list$")
    public void seeAccountListUI(Map<String,String> map){
        overviewFlow.checkOverviewUI(map);
    }

    @Then("^I should see account list Total assets \\(value in reporting currency to 2dp\\)$")
    public void checkAccountListFormat() {
        overviewFlow.checkAccountListFormat();
    }

    @Then("^I should see the accounts list are ordered by Total Assets value \\(largest first, smallest last and then in alphabetical order based on first letter of Account Name value\\)$")
    public void checkAccountListOrder() {
        overviewFlow.checkAccountListOrder();
    }

    @When("^I click on the overview Total Assets value\\(has investment\\)$")
    public void tapOverviewTotalAssetsInvestment() {
        overviewFlow.tapOverviewTotalAssets();
    }

    @When("^I click on the overview Total Assets value$")
    public void tapOverviewTotalAssets(){
        overviewFlow.tapOverviewTotalAssets();
    }

    @Then("^I should see a link to an overview overlay showing how this value has been calculated is displayed$")
    public void checkOverviewOverlayDisplayed() {
        overviewFlow.checkOverviewOverlayDisplayed();
    }

    @Then("^I should see the value for the overview \"Total assets\" they own within all of the accounts is displayed, which will be 18 characters max$")
    public void checkOverviewTotalAssetFormat() {
        overviewFlow.checkOverviewTotalAssetFormat();
    }

    @Then("^I should see the overview reporting currency is displayed in ISO 3 code format$")
    public void checkOverviewTotalAssetISO3(){
        overviewFlow.checkOverviewTotalAssetISO3();
    }

    @Then("^I should see the overview Total Assets value is shown in full to 2dp$")
    public void checkOverviewTotalAsset2dp(){
        overviewFlow.checkOverviewTotalAsset2dp();
    }

    @Then("^I should see the overview Total asset value at the overview level Overlay equals the sum of all assets\\(markValue\\)in reporting currency$")
    public void overviewTotalAssetValueEquals() {
        overviewFlow.overviewTotalAssetValueEquals();
    }

    @Then("^I should see a value of \"0\\.00\" for the \"Total assets\" they own within all of the accounts is displayed$")
    public void checkOverviewTotalAssetsZero(){
        overviewFlow.checkOverviewTotalAssetsZero();

    }

    @Then("^I should see the following overview overlay UI$")
    public void checkOverviewOverLayUI(DataTable dataTable){
        globalOverlayFlow.checkGlobalLegalUI(RegionUtil.getMap(dataTable));
    }

    @Then("^I should see Overview Total Assets value for the account in current reporting currency to 2dp$")
    public void checkOverviewOverlayFormat(){
        overviewFlow.checkOverviewOverlayFormat();
    }

    @Then("^I should see the Overview Overlay Reporting Currency ISO3 code format$")
    public void checkOverviewOverlayIOS3() {
        overviewFlow.checkOverviewOverlayIOS3();
    }

    @When("^I tap on close button of overview overlay$")
    public void closeOverviewOverlay() {
        overviewFlow.closeOverlayInOverviewLevel();
    }

    @Then("^I should see the Overview Total Assets overlay is closed$")
    public void checkOverviewTotalAssetsOverlayClosed() {
        overviewFlow.checkOverviewTotalAssetsOverlayClosed();
    }

    @When("^I tap anywhere on the screen outside of the overview overlay frame$")
    public void tapOverviewOverlayOutside() {
        overviewFlow.tapOverviewOverlayOutside();
    }

    @When("^I tap on overview \"Currency Conversion\" icon$")
    public void tapCurrencyConversion() {
        overviewFlow.tapCurrencyConversion();
    }

    @When("^I taps on 3rd items in Accounts list$")
    public void tap3RDAccount() {
        overviewFlow.tap3RDAccount();
    }

    @Then("^I should see the sub asset classes are ordered by Total Asset value - largest to smallest$")
    public void checkSubClassOrder() {
        overviewFlow.checkSubClassOrder();

    }

    @Then("^I should see the account list specific item following datas: a downward pointing chevron、a negative TWRR % figure with a symbol -$")
    public void checkAccountListTWRRNegative() {
        overviewFlow.checkAccountListTWRRNegative();
    }

    @Then("^I should see the account list specific item following datas: a upward pointing chevron、a positive TWRR % figure$")
    public void checkAccountListTWRRPositive() {
        overviewFlow.checkAccountListTWRRPositive();
    }

    @Then("^I should see the account list total all item following datas: TWRR % figure are recorded as % to 2\\.d\\.p$")
    public void checkAccountListTWRRFormat() {
        overviewFlow.checkAccountListTWRRFormat();
    }

    @Then("^the account list specific item % figure is 0\\.00%$")
    public void checkAccountListFigureZero() {
        overviewFlow.checkAccountListFigureZero();
    }

    @Then("^I should see account list specific item there is no - symbol and no chevron$")
    public void checkAccountListNoSymbolAndNoChevron() {
        overviewFlow.checkAccountListNoSymbolAndNoChevron();
    }

    @Then("^I shuold view the overview 1 following information:$")
    public void checkOverviewPerformanceUI(Map<String,String> map){
        overviewFlow.checkOverviewPerformanceUI(map,1);
    }

    @Then("^I shuold view the overview 2 following information:$")
    public void checkOverviewPerformanceUI2(Map<String,String> map){
        overviewFlow.checkOverviewPerformanceUI(map,2);
    }

    @Then("^I should see the ISO 3 format of overview performance currency$")
    public void checkOverviewPerformanceCurrencyISO3(){
        overviewFlow.checkOverviewPerformanceCurrencyISO3();
    }

    @Then("^I should see the 2dp format of overview performance value$")
    public void checkOverviewPerformanceValue2dp(){
        overviewFlow.checkOverviewPerformanceValue2dp();

    }

    @And("^the overview Performance value is 0\\.00$")
    public void checkOverviewPerformanceValueZero(){
        overviewFlow.checkOverviewPerformanceValueZero();
    }

    @Then("^I should see overview there is no \\+ symbol or - symbol before the Performance value$")
    public void checkOverviewPerformanceValueNoSymbol() {
        overviewFlow.checkOverviewPerformanceValueNoSymbol();
    }

    @When("^I tap overview performance$")
    public void tapOverviewPerformance() {
        overviewFlow.tapOverviewPerformance();
    }

    @Then("^I should see overview wrapper performance corresponding overlay performance$")
    public void checkOverviewPerformanceOverlayValue() {
        overviewFlow.checkOverviewPerformanceOverlayValue();
    }

    @Then("^I should on the overview performance overlay$")
    public void onTheOverviewPerformanceOverlay() {
        overviewFlow.onTheOverviewPerformanceOverlay();
    }

    @Given("^I am on the overview performance overlay$")
    public void onOverviewPerformanceOverlay() {
        overviewFlow.onTheOverviewPerformanceOverlay();
    }

    @Then("^I should see the overview performance overlay 1 following datas:$")
    public void checkOverviewPerformanceOverlayUI(Map<String,String> map){
        overviewFlow.checkOverviewPerformanceOverlayUI(map,1);
    }
    @Then("^I should see the overview performance overlay 2 following datas:$")
    public void checkOverviewPerformanceOverlayUI2(Map<String,String> map){
        overviewFlow.checkOverviewPerformanceOverlayUI(map,2);
    }

    @Then("^I should see 2dp format of Performance overlay amount value$")
    public void checkPerformanceOverlayAmount2dp(){
        overviewFlow.checkPerformanceOverlayAmount2dp();
    }

    @Then("^I should see ISO3 format of Performance overlay amount value$")
    public void checkPerformanceOverlayAmountISO3(){
        overviewFlow.checkPerformanceOverlayAmountISO3();
    }

    @When("^the overview performance overlay amount value is 0\\.00$")
    public void checkOverviewPerformanceOverlayAmountZero() {
        overviewFlow.checkOverviewPerformanceOverlayAmountZero();
    }

    @Then("^I should see there is no \\+ symbol or - symbol before the Performance amount value$")
    public void checkPerformanceAmountNoSymbol() {
        overviewFlow.checkPerformanceAmountNoSymbol();
    }

    @Then("^below the welcome message they should see the following label \"([^\"]*)\"$")
    public void checkWelcomeMessage(String message) {
        overviewFlow.checkWelcomeMessage(message);
    }

    @When("^I taps on \"x\" top right of overview performance overlay$")
    public void tapsCloseOverlay(){
        overviewFlow.tapsCloseOverlay();
    }

    @Then("^I should see the overview performance overlay is closed$")
    public void checkOverviewPerformanceOverlayClosed() {
        overviewFlow.checkOverviewPerformanceOverlayClosed();
    }

    @When("^I taps anywhere on the screen outside of the overview performance overlay frame$")
    public void tapsAnywhereOverviewPerformanceOverlay(){
        overviewFlow.tapsAnywhereOverviewPerformanceOverlay();
    }

    @Then("^I should on the allocation holding list$")
    public void onTheAllocationHoldingList() {
        overviewFlow.onTheAllocationHoldingList();
    }

    @Given("^I am on the allocation holding list$")
    public void onAllocationHoldingList() {
        overviewFlow.onTheAllocationHoldingList();
    }

    @Then("^I should see the allocation Holding wrapper following information displayed:$")
    public void checkAssetClassHoldingWrapperUI(Map<String,String> map) {
        overviewFlow.checkAssetClassHoldingWrapperUI(map);
    }

    @Then("^I should see overview holding wrapper GBP ISO 3 code$")
    public void checkOverviewHoldingWrapperGBPISO3() {
        overviewFlow.checkOverviewHoldingWrapperGBPISO3();
    }


//    @Then("^I will see a full screen takeover showing the following global legal disclaimer text:$")
//    public void checkGlobalLegalDisclaimerText(Map<String,String> map){
//        overviewFlow.checkGlobalLegalDisclaimerText(map);
//    }
//
//    @Given("^I see a full screen takeover showing the following global legal disclaimer text:$")
//    public void globalLegalDisclaimerText(Map<String,String> map){
//        overviewFlow.checkGlobalLegalDisclaimerText(map);
//    }

    @Then("^I should return to the screen they were on when they tapped \"tap here\" to access the overview legal overlay calculated value screen$")
    public void checkLegalDisclaimerScreen() {
        overviewFlow.checkLegalDisclaimerScreen();
    }

    @Then("^I can see a list of holdings that they own across all of their Overview within that Asset Class$")
    public void checkOverviewAssetClassHoldingsList() {
        overviewFlow.checkAllocationHoldingsList();
    }

    @Then("^I can see a list of holdings that they own across all of their Overview within that sub-asset class$")
    public void checkOverviewSubAssetClassHoldingsList() {
        overviewFlow.checkAllocationHoldingsList();
    }

    @Then("^I can see a list of holdings that they own in that currency across all of their Overview$")
    public void checkOverviewCurrencyHoldings(){
        overviewFlow.checkAllocationHoldingsList();
    }

    @Then("^I can see a list of holdings that they own within that Region across all of their Overview$")
    public void checkOverviewRegionHoldings() {
        overviewFlow.checkAllocationHoldingsList();
    }

    @And("^I tap on any where in global legal disclaimer$")
    public void tapAnyWhereGlobalLegalDisclaimer(){
        overviewFlow.tapAnyWhereGlobalLegalDisclaimer();
    }

    @Then("^I can see a list of overview allocation holdings with the following details when P/L is positive AND holding ccy is DIFFERENT$")
    public void checkOverviewAllocationHoldingsPositiveAndDIFFERENT(){
        overviewFlow.checkOverviewAllocationHoldingsPositiveAndDIFFERENT();
    }

    @Then("^I can see ISO 3 code of overview allocation holding currency、Overview reference currency$")
    public void checkOverviewAllocationHoldingsPositiveAndDIFFERENTISO3(){
        overviewFlow.checkOverviewAllocationHoldingsPositiveAndDIFFERENTISO3();
    }

    @Then("^I can see a list of overview allocation holdings with the following details when P/L is negative AND holding ccy is DIFFERENT$")
    public void checkOverviewAllocationHoldingsNegativeAndDIFFERENT() {
        overviewFlow.checkOverviewAllocationHoldingsNegativeAndDIFFERENT();
    }

    @Then("^I can see ISO 3 code of overview allocation holding currency、Overview reference currency when P/L is negative AND holding ccy is DIFFERENT$")
    public void checkOverviewAllocationHoldingsNegativeAndDIFFERENTISO3(){
        overviewFlow.checkOverviewAllocationHoldingsNegativeAndDIFFERENTISO3();
    }

    @Then("^I can see a list of overview allocation holdings with the following details when P/L is positive AND holding ccy is the SAME$")
    public void checkOverviewAllocationHoldingsPositiveAndSAME() {
        overviewFlow.checkOverviewAllocationHoldingsPositiveAndSAME();
    }

    @Then("^I can see ISO 3 code of overview allocation holding currency when P/L is positive AND holding ccy is the SAME$")
    public void checkOverviewAllocationHoldingPositiveAndSAME(){
        overviewFlow.checkOverviewAllocationHoldingPositiveAndSAME();

    }

    @Then("^I can see a list of overview allocation holdings with the following details When P/L is negative AND holding ccy is the SAME$")
    public void checkOverviewAllocationHoldingsNegativeAndSAME() {
        overviewFlow.checkOverviewAllocationHoldingsNegativeAndSAME();
    }

    @Then("^I can see ISO 3 code of overview allocation holding currency When P/L is negative AND holding ccy is the SAME$")
    public void checkOverviewAllocationHoldingNegativeAndSAMEISO3(){
        overviewFlow.checkOverviewAllocationHoldingNegativeAndSAMEISO3();
    }

    @Then("^I can see a list of overview allocation holdings with the following details when P/L figure is relevant And holding ccy is DIFFERENT$")
    public void checkOverviewAllocationHoldingsRelevantAndDIFFERENT(){
        overviewFlow.checkOverviewAllocationHoldingsNegativeAndDIFFERENT();
    }

    @Given("^I see a list of overview allocation holdings with the following details when P/L figure is relevant And holding ccy is DIFFERENT$")
    public void overviewAllocationHoldingsRelevantAndDIFFERENT(){
        overviewFlow.checkOverviewAllocationHoldingsNegativeAndDIFFERENT();
    }

    @Then("^I can see ISO 3 code of overview allocation holding currency and GPB ISO 3 code when P/L figure is relevant And holding ccy is DIFFERENT$")
    public void checkOverviewAllocationHoldingRelevantAndDIFFERENT(){
        overviewFlow.checkOverviewAllocationHoldingsNegativeAndDIFFERENTISO3();
    }

    @Then("^I can see a list of overview allocation holdings with the following details when P/L figure is NOT relevant And holding ccy is DIFFERENT$")
    public void checkOverviewAllocationHoldingsNOTRelevantAndDIFFERENT(){
        overviewFlow.checkOverviewAllocationHoldingsNOTRelevantAndDIFFERENT();
    }

    @Given("^I see a list of overview allocation holdings with the following details when P/L figure is NOT relevant And holding ccy is DIFFERENT$")
    public void overviewAllocationHoldingsNOTRelevantAndDIFFERENT(){
        overviewFlow.checkOverviewAllocationHoldingsNOTRelevantAndDIFFERENT();
    }

    @Then("^I can see ISO 3 code of overview allocation holding currency、GPB ISO 3 code when P/L figure is NOT relevant And holding ccy is DIFFERENT$")
    public void checkOverviewAllocationHoldingNOTRelevantAndDIFFERENTISO3() {
        overviewFlow.checkOverviewAllocationHoldingNOTRelevantAndDIFFERENTISO3();
    }

    @And("^I tap (\\d+)th item of overview allocation holding list$")
    public void tapOverviewAllocationHoldingList(int num) {
        overviewFlow.tapOverviewAllocationHoldingList(num);
    }

    @Then("^I should see \"([^\"]*)\" Total assets value is displayed based on the reference currency \"([^\"]*)\"$")
    public void checkOverviewReferenceCurrency(String region, String referenceCurrency){
        overviewFlow.checkOverviewReferenceCurrency(region, referenceCurrency);
    }

    @Then("^I should see the follow element on overview liabilities:$")
    public void checkOverviewLiabilitiesUI(Map<String, String> map){
        overviewFlow.checkOverviewLiabilitiesUI(map);
    }

    @Given("^I am see the follow element on overview liabilities:$")
    public void seeOverviewLiabilitiesUI(Map<String, String> map){
        this.checkOverviewLiabilitiesUI(map);
    }

    @Then("^I should see the value for the total liabilities will be 17 characters max$")
    public void checkOverviewLiabilitiesCharactersMax(){
        overviewFlow.checkOverviewLiabilitiesCharactersMax();
    }

    @Then("^I should see the Overview base currency is displayed in ISO 3 code format$")
    public void checkLiabilitiesISO3(){
        overviewFlow.checkLiabilitiesISO3();
    }

    @Then("^I should see the overview allocation screen$")
    public void checkInAllocation(){
        overviewFlow.checkInAllocation();
    }

    @Given("^I see the overview allocation screen$")
    public void seeInAllocation(){
        this.checkInAllocation();
    }

    @And("^The reporting currency is displayed in ISO 3 code format adjacent to the total assets value$")
    public void checkTotalAssetISO3(){
        overviewFlow.checkTotalAssetISO3();
    }

    @When("^I tap on holding list \"Currency Conversion\" icon$")
    public void tapOnHoldingListCurrencyConversionIcon(){
        overviewFlow.tapOnHoldingListCurrencyConversionIcon();
    }

    @When("^I minifiles the Overview wrapper$")
    public void minifilesWrapper(){
        overviewFlow.minifilesWrapper();
    }

    @Then("^I should see the Welcome Message/Country/Update time/Total Liabilities/Net Assets will be fade and they will be disappeared$")
    public void checkMinifilesWapperUI(){
        overviewFlow.checkMinifilesWapperUI();
    }

    @And("^I should see the customer name and Total Assets$")
    public void checkNameAndTotal(){
        overviewFlow.checkNameAndTotal();
    }

    @And("^the client should NOT see a Total Liabilities label,chervon or figure displayed$")
    public void notSeeLiabilities(){
        overviewFlow.notSeeLiabilities();
    }

    @Then("^I should see the Total Liabilities is displayed \"([^\"]*)\"$")
    public void checkTotalLiabilitiesValue(String value){
        overviewFlow.checkTotalLiabilitiesValue(value);
    }

    @Then("^I should not see the Total Liabilities and the Net Assets in overview level$")
    public void notSeeLiabilitiesAndNet() {
        overviewFlow.notSeeLiabilitiesAndNet();
    }

    @When("^I tap Overview Total Liabilities$")
    public void tapOverviewTotalLiabilitiesOverlay(){
        overviewFlow.tapOverviewTotalLiabilitiesOverlay();
    }

    @Then("^I can see the Class and Currency tap at overview level$")
    public void checkSeeClassAndCurrency(){
        overviewFlow.checkSeeClassAndCurrency();
    }

    @And("^I should not see the Region tap at overview level$")
    public void checkNotSeeRegion() {
        overviewFlow.checkNotSeeRegion();
    }

    @Then("^I should see the follow element on overview net assets:$")
    public void checkOverviewNetAssetsUI(Map<String, String> map) {
        overviewFlow.checkOverviewNetAssetsUI(map);
    }
    @Then("^I am see the follow element on overview net assets:$")
    public void seeOverviewNetAssetsUI(Map<String, String> map) {
        overviewFlow.checkOverviewNetAssetsUI(map);
    }

    @Then("^I should see the value for the net assets they own within all of their accounts is displayed,which will be (\\d+) characters max,including commas and decimal point$")
    public void checkNetAssetsMax(int maxNumber) {
        overviewFlow.checkNetAssetsMax(maxNumber);
    }

    @Then("^I should see the overview net assets base currency is displayed in ISO 3 code format$")
    public void checkOverviewNetAssetsISO3() {
        overviewFlow.checkOverviewNetAssetsISO3();
    }

    @Then("^I should see that Net Assets = Total Assets\\(overview value\\) - Total Liabilities\\(overview value\\)$")
    public void checkNetAssetsEqualTotalAssetsReductionOfTotalLiabilities() {
        overviewFlow.checkNetAssetsEqualTotalAssetsReductionOfTotalLiabilities();
    }

    @Then("^I should not see a overview Net assets label or figure displayed$")
    public void checkNotNetAssets() {
        overviewFlow.checkNotNetAssets();
    }

    @Then("^I should see a overview Net assets label or figure displayed \"([^\"]*)\"$")
    public void checkOverviewNetAssets(String value) {
        overviewFlow.checkOverviewNetAssets(value);
    }

    @Then("^I can not view individual performance figures for each account of proper number of item$")
    public void checkAccountListNotPerformance() {
        overviewFlow.checkAccountListNotPerformance();
    }

    @When("^I tap on overview \"Show Sub-Asset Class\" toggle to ON$")
    public void tapShowSubClassToON() {
        overviewFlow.tapShowSubClassToON();
    }

    @Then("^I can not view Performance in the overview wrapper container$")
    public void checkNotSeePerformance() {
        overviewFlow.checkNotSeePerformance();
    }

    @Then("^I can see the \"([^\"]*)\" Overview following link to a legal overlay calculated value:\"([^\"]*)\"$")
    public void checkOverviewFollowingLinkValue(String region, String disclaimer) {
        overviewFlow.checkOverviewGlobalLegalDisclaimer(region,disclaimer);
    }
    @Given("^I am viewing the \"([^\"]*)\" Overview \"([^\"]*)\" link at the bottom of the account list$")
    public void seeOverviewFollowingLinkValue(String region, String disclaimer) {
        overviewFlow.checkOverviewGlobalLegalDisclaimer(region,disclaimer);
    }

    @And("^I taps on overview \"tap here\" link to legal overlay calculated value$")
    public void tapsOverviewLinkToGlobalLegalDisclaimer() {
        overviewFlow.tapsLinkToGlobalLegalDisclaimer();
    }

    @Then("^I should see the Overview Total Assets equal to the Overview Total Assets Overlay$")
    public void checkOverviewTotalAssetsEqualOverviewTotalAssetsOverlay(){
        overviewFlow.checkOverviewTotalAssetsEqualOverviewTotalAssetsOverlay();
    }

    @Then("^I should see the following empty state copy in account list view:\"([^\"]*)\"$")
    public void checkNoAccountMessage(String message){
        overviewFlow.checkNoAccountMessage(message);
    }

    @Then("^I will not view overview warpper performance$")
    public void checkNoPerformance(Map<String, String> map){
        overviewFlow.checkNoPerformance();
    }

    @Then("^I will not the Performance % value in the Account list views$")
    public void checkAccountItemNoPerformance(){
        overviewFlow.checkAccountItemNoPerformance();
    }

    @Then("^I am returned back to the Overview page$")
    public void checkOverviewPage() {
        overviewFlow.checkOverviewPage();
    }

    @And("^the Overview wrapper is maximised$")
    public void checkOverviewWrapperIsMaximised() {
        overviewFlow.checkOverviewWrapperIsMaximised();
    }

    @Then("^I should see total asset value at the Asset Allocation Graphic mode equals the Total asset value at wrapper$")
    public void checkTotalAssetEqualsOverviewAssetAllocationTotalAsset() {
        overviewFlow.checkTotalAssetEqualsOverviewAssetAllocationTotalAsset();
    }

    @And("^the Overview wrapper is minifiles$")
    public void theOverviewWrapperIsMinifiles(){
        overviewFlow.theOverviewWrapperIsMinifiles();
    }

    @And("^the Overview wrapper should be minifiles$")
    public void checkOverviewWrapperMinifiles(){
        overviewFlow.checkOverviewWrapperMinifiles();
    }

    @And("^I tap specific item of Accounts list$")
    public void tapSpecificItemOfAccountsList() {
        overviewFlow.tapSpecificItemOfAccountsList();
    }
}
