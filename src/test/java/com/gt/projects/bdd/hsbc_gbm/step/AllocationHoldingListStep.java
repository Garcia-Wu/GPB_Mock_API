package com.gt.projects.bdd.hsbc_gbm.step;

import com.gt.projects.bdd.base.BaseStep;
import com.gt.projects.bdd.base.annotation.Action;
import com.gt.projects.bdd.hsbc_gbm.flow.AllocationHoldingListFlow;
import com.gt.projects.bdd.hsbc_gbm.flow.OverviewFlow;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class AllocationHoldingListStep extends BaseStep {

    @Autowired
    private AllocationHoldingListFlow allocationHoldingListFlow;

    @Autowired
    private OverviewFlow overviewFlow;

    @Action("click_allocation_holding_back_button")
    public void clickBackButton(){
        allocationHoldingListFlow.clickBackButton();
    }

    @Then("^I must view an unrealised profit/loss amount in the purchase currency of the allocation holding$")
    public void checkAllocationHoldingPerformance() {
        allocationHoldingListFlow.checkAllocationHoldingPerformance();
    }

    @Then("^I must not view a performance value at the allocation holding$")
    public void checkAllocationHoldingNoPerformance() {
        allocationHoldingListFlow.checkAllocationHoldingNoPerformance();
    }

    @Then("^I can view the allocation specific item holding following information:a upward pointing chevron、a positive % figure$")
    public void checkOverviewHoldingTWRRPositive() {
        allocationHoldingListFlow.checkOverviewHoldingTWRRPositive();
    }

    @Then("^I can view the allocation specific item holding following information:a downward pointing chevron、a negative % figure with a symbol -$")
    public void checkOverviewHoldingTWRRNegative(){
        allocationHoldingListFlow.checkOverviewHoldingTWRRNegative();
    }

    @Then("^I can view the allocation holding total all item following information:2dp format of % figure$")
    public void checkOverviewHoldingTWRR2dp(){
        allocationHoldingListFlow.checkOverviewHoldingTWRR2dp();
    }

    @Then("^the allocation specific item holding % figure is 0\\.00%$")
    public void checkOverviewHoldingTWRRZero(){
        allocationHoldingListFlow.checkOverviewHoldingTWRRZero();
    }

    @Then("^I should see allocation specific item holding there is no - symbol and no chevron$")
    public void checkOverviewHoldingTWRRNoSymbolAndNoChevron() {
        allocationHoldingListFlow.checkOverviewHoldingTWRRNoSymbolAndNoChevron();
    }

    @Then("^I taps on allocation holding \"Exchange rates\" icon$")
    public void tapCurrencyIcon() {
        allocationHoldingListFlow.tapCurrencyIcon();
    }

    @Then("^I should see the wrapper contains the following:$")
    public void checkHoldingWrapperUI(Map<String,String> map) {
        allocationHoldingListFlow.checkHoldingWrapperUI(map);
    }

    @Then("^I should see the holdings are ordered from largest to smallest based on amount value$")
    public void checkHoldingListOrdered() {
        allocationHoldingListFlow.checkHoldingListOrdered();
    }

    @And("^I tap on holdings grouped per Sub Asset class$")
    public void tapHoldingsGroupedPerSubAssetClass(){
        allocationHoldingListFlow.tapHoldingsGroupedPerSubAssetClass();
    }


    @When("^I swipe left to other asset class$")
    public void swipeLeftToOtherAssetClass() {
        allocationHoldingListFlow.swipeLeftHolingList();
    }

    @Then("^I should see the holding list will be changed$")
    public void checkHoldingListWillChanged() {
        allocationHoldingListFlow.checkHoldingListWillChanged();
    }

    @Then("^I should see the allocation holdings wrapper base currency are displayed in ISO 3 code and 2 d\\.p\\. format$")
    public void checkAllocationHoldingsWrapperBaseCurrencyFormat() {
        allocationHoldingListFlow.checkAllocationHoldingsWrapperBaseCurrencyFormat();
    }

    @Then("^I should see the sub-asset classes are ordered from largest to smallest, based on the sub-asset class total value in reference currency$")
    public void checkSubAssetClassesOrdered() {
        allocationHoldingListFlow.checkSubAssetClassesOrdered();
    }

    @Then("^I should see the base currency ISO 3 code and 2 d\\.p\\. format for the sub-asset class$")
    public void checkSubClassBaseCurrencyFormat() {
        allocationHoldingListFlow.checkSubClassBaseCurrencyFormat();
    }

    @Then("^I should see the holdings are grouped by each sub-asset class$")
    public void checkHoldingsGroupedByEachSubAssetClass(){
        allocationHoldingListFlow.checkHoldingsGroupedByEachSubAssetClass();
    }

    @Then("^I should see the total value for each sub-asset class$")
    public void checkTotalValueForEachSubAssetClass() {
        allocationHoldingListFlow.checkTotalValueForEachSubAssetClass();
    }

    @And("^a list of my holdings for a particular asset class across all of my accounts$")
    public void checkParticularAssetClass(){
        allocationHoldingListFlow.checkParticularAssetClass();
    }

    @When("^I swipe left to other asset class\\(wrapper\\)$")
    public void swipeLeftWrapper() {
        allocationHoldingListFlow.swipeLeftWrapper();
    }

    @Then("^I should see the asset class name and total assets value for the asset class will be changed$")
    public void checkWrapperChanged() {
        allocationHoldingListFlow.checkWrapperChanged();
    }

    @When("^I swipe left to other asset subclass$")
    public void swipeLeftToOtherAssetSubclass(){
        allocationHoldingListFlow.swipeLeftToOtherAssetSubclass();
    }

    @Then("^I should see the grouped by subclass holding list will be changed$")
    public void checkGroupedBySubclassHoldingListChanged(){
        allocationHoldingListFlow.checkGroupedBySubclassHoldingListChanged();
    }

    @Then("^I should swipe the pips from 1st to the last one continuously within asset class holding wrapper$")
    public void swipe1StToLast(){
        allocationHoldingListFlow.swipe1StToLast();
    }

    @Then("^I am taken to the holdings view that shows a list of my holdings for the particular Currency across all of my accounts$")
    public void checkHoldingsView() {
        allocationHoldingListFlow.checkHoldingsView();
    }

    @Then("^I should see the currency amount equals the sum of all holdings list value$")
    public void checkCurrencyAmountEqualsAllHoldingsListValue() {
        allocationHoldingListFlow.checkAmountEqualsAllHoldingsListValue();
    }

    @And("^the allocation holdings list base currency is displayed in ISO 3 code format and 2 d.p. format$")
    public void checkOverviewBaseCurrencyISO3CodeFormat(){
        allocationHoldingListFlow.checkOverviewBaseCurrencyISO3CodeFormat();
    }

    @Then("^the currency weight is positive in the pie-char$")
    public void checkCurrencyWeightPositive() {
        allocationHoldingListFlow.checkWeightPositive();
    }

    @Then("^the currency weight is negative in the pie-char$")
    public void checkCurrencyWeightNegative(){
        allocationHoldingListFlow.checkWeightNegative();
    }

    @Then("^the currency weight is displayed in the pie-char$")
    public void checkCurrencyWeightZero() {
        allocationHoldingListFlow.checkWeightZero();
    }

    @When("^I swipe left to other currency\\(wrapper\\)$")
    public void swipeLeftToOtherCurrencyWrapper() {
        allocationHoldingListFlow.swipeLeftWrapper();
    }

    @Then("^I should see the currency name and total currency amount for the currency will be changed$")
    public void checkCurrencyNameAndTotalCurrencyAmountChanged() {
        allocationHoldingListFlow.checkWrapperChanged();
    }

    @When("^I swipe left to other currency$")
    public void swipeLeftOtherCurrency() {
        allocationHoldingListFlow.swipeLeftHolingList();
    }

    @Then("^I should see the holding list will be changed within the currency$")
    public void checkHoldingListChangedCurrency(){
        allocationHoldingListFlow.checkHoldingListWillChanged();
    }

    @Then("^I can swipe the pips from 1st to the last one continuously within currency holding wrapper$")
    public void checkCurrencyHoldingPip() {
        allocationHoldingListFlow.swipe1StToLast();
    }

    @Then("^I can be able to swipe left or right the overview allocation currency holding wrapper pips in a never ending loop$")
    public void checkCurrencyHoldingPipsNeverEndingLoop() {
        allocationHoldingListFlow.swipe1StToLast();
    }

    @Then("^I am taken to the holdings view that shows a list of my holdings for the particular Region across all of my accounts$")
    public void checkHoldingsViewRegion(){
        allocationHoldingListFlow.checkHoldingsView();
    }

    @Then("^I should see the region amount equals the sum of all holdings list value$")
    public void checkRegionAmountEqualsHoldingsListValue() {
        allocationHoldingListFlow.checkAmountEqualsAllHoldingsListValue();
    }

    @Then("^the region weight is positive in the pie-char$")
    public void checkRegionWeightPositive(){
        allocationHoldingListFlow.checkWeightPositive();
    }

    @Then("^the region weight is negative in the pie-char$")
    public void checkRegionWeightNegative() {
        allocationHoldingListFlow.checkWeightNegative();
    }

    @And("^the region weight is displayed 0\\.00% in the pie-char$")
    public void checkRegionWeightZero(){
        allocationHoldingListFlow.checkWeightZero();
    }

    @When("^I swipe left to other region\\(wrapper\\)$")
    public void swipeLeftToOtherRegionWrapper(){
        allocationHoldingListFlow.swipeLeftWrapper();
    }

    @Then("^I should see the region name and total assets value for the asset class will be changed$")
    public void checkRegionNameAndTotalAssetsValueChanged() {
        allocationHoldingListFlow.checkWrapperChanged();
    }

    @When("^I swipe left to other region$")
    public void swipeLeftOtherRegion() {
        allocationHoldingListFlow.swipeLeftHolingList();
    }

    @Then("^I should see the holding list will be changed within the region$")
    public void checkHoldingListChangedRegion() {
        allocationHoldingListFlow.checkHoldingListWillChanged();
    }

    @Then("^I can swipe the pips from 1st to the last one continuously within region holding wrapper$")
    public void swipe1ToLastRegionHoldingWrapper(){
        allocationHoldingListFlow.swipe1StToLast();
    }

    @Then("^I can be able to swipe left or right the overview allocation region holding wrapper pips in a never ending loop$")
    public void swipeLeftEndingLoop() {
        allocationHoldingListFlow.swipeLeftEndingLoop();
    }

    @Then("^I should see the asset class amount equals the sum of all holdings list value$")
    public void assetClassAmountEqualsAllHoldingsListValue() {
        allocationHoldingListFlow.checkAmountEqualsAllHoldingsListValue();
    }

    @Then("^the asset class weight is positive in the pie-char$")
    public void checkAssetClassWeightPositive() {
        allocationHoldingListFlow.checkWeightPositive();
    }

    @Then("^the asset class weight is negative in the pie-char$")
    public void checkAssetClassWeightNegative() {
        allocationHoldingListFlow.checkWeightNegative();
    }

    @Then("^the asset class weight is displayed 0\\.00% in the pie-char$")
    public void checkAssetClassWeightZero(){
        allocationHoldingListFlow.checkWeightZero();
    }

    @Then("^I am taken to the holdings view that shows a list of my holdings for the particular Currency within my account$")
    public void checkAccountCurrencyHoldingsView(){
        allocationHoldingListFlow.checkHoldingsView();
    }

    @Then("^I am taken to the holdings view that shows a list of my holdings for the particular Currency within my portfolio$")
    public void checkPortfolioCurrencyHoldingsView() {
        allocationHoldingListFlow.checkHoldingsView();
    }

    @Then("^I am taken to the holdings view that shows a list of my holdings for the particular Region within my account$")
    public void checkAccountRegionHoldingsView() {
        allocationHoldingListFlow.checkHoldingsView();
    }

    @Then("^I am taken to the holdings view that shows a list of my holdings for the particular Region within my portfolio$")
    public void checkPortfolioRegionHoldingsView() {
        allocationHoldingListFlow.checkHoldingsView();
    }

    @Then("^I am taken to the holdings view that shows a list of my holdings for the particular Asset Class within my account$")
    public void checkAccountClassHoldingsView() {
        allocationHoldingListFlow.checkHoldingsView();
    }

    @Then("^I am taken to the holdings view that shows a list of my holdings for the particular Asset Class within my portfolio$")
    public void checkPortfolioClassHoldingsView() {
        allocationHoldingListFlow.checkHoldingsView();
    }

    @Then("^I should see the sub asset classes amount equals the sum of its all holdings list value$")
    public void checkSubClassAmountSumOfHoldingListAmount() {
        allocationHoldingListFlow.checkSubClassAmountSumOfHoldingListAmount();
    }

    @Then("^I should see the asset classes amount in the holding wrapper equals the sum of sub-asset class amount$")
    public void checkSubClassAmountSumOfHoldingWrapperAmount() {
        allocationHoldingListFlow.checkSubClassAmountSumOfHoldingWrapperAmount();
    }

    @When("^I tap first item of allocation holding list$")
    public void tapFirstHolding() {
        allocationHoldingListFlow.tapFirstHolding();
    }

    @Then("^I should see the allocation holding list$")
    public void iShouldSeeTheAllocationHoldingList() {
        allocationHoldingListFlow.onTheAllocationHoldingList();
    }

    @Given("^I am see the allocation holding list$")
    public void iAmSeeTheAllocationHoldingList()  {
        allocationHoldingListFlow.onTheAllocationHoldingList();
    }
}
