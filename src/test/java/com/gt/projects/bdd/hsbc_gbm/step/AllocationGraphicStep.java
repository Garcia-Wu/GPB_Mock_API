package com.gt.projects.bdd.hsbc_gbm.step;

import com.gt.projects.bdd.base.BaseStep;
import com.gt.projects.bdd.hsbc_gbm.flow.AllocationGraphicFlow;
import com.gt.projects.bdd.hsbc_gbm.util.RegionUtil;
import com.gt.projects.bdd.hsbc_gbm.util.SleepUtil;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class AllocationGraphicStep extends BaseStep {

    @Autowired
    private AllocationGraphicFlow allocationGraphicFlow;

    @Then("^I should on the Allocation graphical view$")
    public void onOverviewAssetClassGraphicalView() {
        allocationGraphicFlow.onOverviewAssetClassGraphicalView();
    }
    @Given("^I am on the Allocation graphical view$")
    public void OverviewAssetClassGraphicalView() {
        allocationGraphicFlow.onOverviewAssetClassGraphicalView();
    }

    @Then("^I should see the wrapper above the graphic contains the following:$")
    public void CheckGraphicWrapperUI(DataTable dataTable){
        allocationGraphicFlow.CheckGraphicWrapperUI(RegionUtil.getMap(dataTable));
    }

    @Then("^I should view a graphic following:$")
    public void checkGraphicUI(Map<String,String> map) {
        allocationGraphicFlow.checkGraphicUI(map);
    }

    @When("^I tap on the Allocation toggle$")
    public void tapAllocationToggle() {
        allocationGraphicFlow.tapAllocationToggle();
    }

    @When("^I tap on the Allocation toggle and remember \"([^\"]*)\" Total asset value$")
    public void tapAllocationToggleRememberTotalAssetValue(String  level) {
        allocationGraphicFlow.tapAllocationToggleRememberTotalAssetValue(level);
    }

    @When("^I tap on the Allocation toggle and remember \"([^\"]*)\" base currency$")
    public void tapAllocationToggleAndRememberBaseCurrency(String level) {
        allocationGraphicFlow.tapAllocationToggleAndRememberBaseCurrency(level);
    }

    @Then("^the value for the Total assets they own within all of the accounts is displayed, which will be (\\d+) characters max\\. including commas and decimal point$")
    public void checkTotalValueMax(int max){
        allocationGraphicFlow.checkTotalValueMax(max);
    }

    @Then("^the base currency value is displayed ISO 3 code$")
    public void checkTotalAssetCurrencyFormat() {
        allocationGraphicFlow.checkTotalAssetCurrencyFormat();
    }

    @When("^I tap on Region tab$")
    public void tapOnRegionTab() {
        allocationGraphicFlow.tapOnRegionTab();
    }

    @When("^I tap on Currency tab$")
    public void tapOnCurrencyTab() {
        allocationGraphicFlow.tapOnCurrencyTab();
    }

    @Then("^I should see the allocation total assets are displayed in ISO 3 code and 2 d\\.p\\. format$")
    public void checkAccountAssetsValueFormat(){
        allocationGraphicFlow.checkBaseCurrencyFormat();
    }

    @When("^I tap on the account breadcrumb \\(back button\\)$")
    public void tapAccountBackButton(){
        allocationGraphicFlow.tapAccountBackButton();
    }

    @When("^I tap on the portfolio breadcrumb \\(back button\\)$")
    public void tapPortfolioBackButton(){
        allocationGraphicFlow.tapPortfolioBackButton();
    }

    @Then("^I should see the allocation total assets is displayed in 2 d\\.p\\. format$")
    public void checkAccountAssetsZeroFormat(){
        allocationGraphicFlow.checkAccountAssetsZeroFormat();
    }

    @And("^the allocation total assets base currency value is displayed ISO 3 code$")
    public void checkAccountBaseCurrencyZeroISO3(){
        allocationGraphicFlow.checkTotalAssetCurrencyFormat();
    }

    @Then("^I should see the Total assets value equal to the 0\\.00$")
    public void totalAssetsValueEqualZero() {
        allocationGraphicFlow.totalAssetsValueEqualZero();
    }

    @When("^I swipe up from the bottom of the allocation graphic page$")
    public void swipeUpAllocationGraphicPage(){
        allocationGraphicFlow.swipeUpAllocationGraphicPage();
    }

    @Then("^I should see the \"([^\"]*)\" Region key will be displayed in 8th position of the Allocation Region key view$")
    public void checkRegionKeyOthers(String name){
        allocationGraphicFlow.checkLabelName(name);
    }

    @Then("^I should see the \"([^\"]*)\" Currency key will be display last in the Allocation Currency key view$")
    public void checkCurrencyKeyOthers(String name){
        allocationGraphicFlow.checkLabelName(name);
    }

    @Then("^I should see the \"([^\"]*)\" Asset Class key will be display last in the Allocation Asset Class key view$")
    public void checkClassKeyOthers(String name){
        allocationGraphicFlow.checkLabelName(name);
    }


    @Then("^the base currency same as overview wrapper base currency,and key would usually be displayed,there is copy:$")
    public void checkCurrencyAndCopy(Map<String,String> map) {
        allocationGraphicFlow.checkCurrencyAndCopy(map);
    }

    @When("^I tap first item of class list$")
    public void tapFirstClass() {
        allocationGraphicFlow.tapFirstKey();
    }

    @When("^I tap first item of currency list")
    public void tapFirstCurrency() {
        allocationGraphicFlow.tapFirstKey();
    }

    @When("^I tap first item of region list")
    public void tapFirstRegion() {
        allocationGraphicFlow.tapFirstKey();
    }

    @Then("^I should see the Total assets value equal to the \"([^\"]*)\"$")
    public void checkTotalAssetsValueZero(String amount) {
        allocationGraphicFlow.checkTotalAssetsValueZero(amount);
    }
}
