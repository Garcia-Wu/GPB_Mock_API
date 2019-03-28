package com.gt.projects.bdd.hsbc_gbm.step;

import com.gt.projects.bdd.base.BaseStep;
import com.gt.projects.bdd.hsbc_gbm.flow.AllocationListFlow;
import com.gt.projects.bdd.hsbc_gbm.util.RegionUtil;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class AllocationListStep extends BaseStep {

    @Autowired
    private AllocationListFlow allocationListFlow;

    @When("^I tap on the name of a particular Asset within the key$")
    public void tapOnParticularKey() {
        allocationListFlow.tapOnParticularKey();
    }

    @Then("^I am taken to the Asset Allocation list view page$")
    public void checkAllocationListViewPage() {
        allocationListFlow.checkAllocationListViewPage();
    }

    @Then("^I should see the allocation list$")
    public void onTheAllocationList() {
        allocationListFlow.onTheAllocationList();
    }

    @Given("^I am see the allocation list$")
    public void onAllocationList() {
        allocationListFlow.onTheAllocationList();
    }

    @Then("^I should see the following information:$")
    public void checkPositiveAllocationListUI(Map<String,String> map){
        allocationListFlow.checkPositiveAllocationListUI(map);
    }

    @Then("^I should see the wrapper above the list contains the following:$")
    public void checkAllocationListWrapperUI(DataTable dataTable) {
        allocationListFlow.checkAllocationListWrapperUI(RegionUtil.getMap(dataTable));
    }

    @Then("^I should see Total Region value in base currency\\(ISO 3 format and 2dp format\\)$")
    public void checkRegionBaseCurrencyFormat(){
        allocationListFlow.checkBaseCurrencyFormat();
    }

    @And("^I should see Total Region value as a %\\(2dp format\\)$")
    public void checkRegionValueFormat(){
        allocationListFlow.checkPercentageFormat();
    }

    @And("^I should see Total Assets value in base currency\\(ISO 3 format and 2dp format\\) in the allocation wrapper$")
    public void checkWrapperTotalAssetsValueFormat(){
        allocationListFlow.checkWrapperTotalAssetsValueFormat();
    }

    @Then("^I should see Total Currency value in base currency\\(ISO 3 format and 2dp format\\)$")
    public void checkCurrencyBaseCurrencyFormat(){
        allocationListFlow.checkBaseCurrencyFormat();
    }

    @And("^I should see Total Currency value as a %\\(2dp format\\)$")
    public void checkCurrencyValueFormat(){
        allocationListFlow.checkPercentageFormat();
    }

    @Then("^There is no Region list to be displayed$")
    public void checkNoRegionList(){
        allocationListFlow.checkNoAllocationList();
    }

    @Then("^There is no Currency list to be displayed$")
    public void checkNoCurrencyList() {
        allocationListFlow.checkNoAllocationList();
    }

    @Then("^There is no Asset Class list to be displayed$")
    public void checkNoAssetClassList() {
        allocationListFlow.checkNoAllocationList();
    }

    @Then("^there is copy to state that I have not got any investments:$")
    public void checkNoRegionListCopyMessage(Map<String,String> map) {
        allocationListFlow.checkNoAllocationListCopyMessage(map);
    }

    @Then("^I should see the \"([^\"]*)\" Region will be displayed in 8th position of the Allocation Region list view$")
    public void checkRegionOthers(String name){
        allocationListFlow.checkLaberNameOthers(name);
    }

    @Then("^I should see the \"([^\"]*)\" Currency will be displayed in 8th position of the Allocation Currency list view$")
    public void checkCurrencyOthers(String name){
        allocationListFlow.checkLaberNameOthers(name);
    }

    @Then("^I should see the \"([^\"]*)\" Asset Class will be displayed in 8th position of the Allocation Asset Class list view$")
    public void checkClassOthers(String name){
        allocationListFlow.checkLaberNameOthers(name);
    }

    @Then("^The Regions will be ordered from largest to smallest based on market value in reference currency,then by alphabetical order, and negative values are present, negative values will be listed AFTER all positive values have been listed, with the largest negative value shown first$")
    public void checkRegionsListOrder(){
        allocationListFlow.checkRegionsListOrder();
    }

    @Then("^I should see the Account name/Account assets in the allocation Region wrapper will be changed with the current account$")
    public void checkAccountRegionListWrapperChange(){
        allocationListFlow.checkAllocationListWrapperChange();
    }

    @Then("^I should see the Account name/Account assets in the allocation Currency wrapper will be changed with the current account$")
    public void checkAccountCurrencyListWrapperChange(){
        allocationListFlow.checkAllocationListWrapperChange();
    }

    @Then("^I should see the Portfolio name/Portfolio assets in the allocation Region wrapper will be changed with the current account$")
    public void checkPortfolioRegionListWrapperChange(){
        allocationListFlow.checkAllocationListWrapperChange();
    }

    @Then("^I should see the Portfolio name/Portfolio assets in the allocation Currency wrapper will be changed with the current account$")
    public void checkPortfolioCurrencyListWrapperChange(){
        allocationListFlow.checkAllocationListWrapperChange();
    }

    @Then("^I should see the Portfolio name/Portfolio assets in the allocation Asset Class wrapper will be changed with the current account$")
    public void checkPortfolioAssetClassListWrapperChange(){
        allocationListFlow.checkAllocationListWrapperChange();
    }

    @When("^I swipe left the pips on allocation list\\(wrapper\\)$")
    public void swipeLeftOnAllocationListWrapper(){
        allocationListFlow.swipeLeftOnAllocationListWrapper();
    }

    @When("^I swipe left the pips on allocation list$")
    public void swipeLeftOnAllocationList() {
        allocationListFlow.swipeLeftOnAllocationList();
    }

    @Then("^I should see the Account allocation Region list view will be changed with the current account$")
    public void checkAccountRegionListChange() {
        allocationListFlow.checkAllocationListChange();
    }

    @Then("^I should see the Account allocation Currency list view will be changed with the current account$")
    public void checkAccountCurrencyListChange() {
        allocationListFlow.checkAllocationListChange();
    }


    @Then("^I should see the Portfolio allocation Region list view will be changed with the current account$")
    public void checkPortfolioRegionListChange() {
        allocationListFlow.checkAllocationListChange();
    }

    @Then("^I should see the Portfolio allocation Currency list view will be changed with the current account$")
    public void checkPortfolioCurrencyListChange() {
        allocationListFlow.checkAllocationListChange();
    }

    @Then("^I should see the Portfolio allocation Asset Class list view will be changed with the current account$")
    public void checkPortfolioAssetClassListChange() {
        allocationListFlow.checkAllocationListChange();
    }

    @When("^I tap on the name of a particular Asset within the allocation list$")
    public void tapParticularAssetInAllocationList() {
        allocationListFlow.tapParticularAssetInAllocationList();
    }

    @Then("^I should see the positive allocation list contains the following:$")
    public void checkAllocationListContainsPositive(Map<String,String> map) {
        allocationListFlow.checkPositiveAllocationListUI(map);
    }

    @Then("^I should see Total Assets Class value in base currency \\(ISO 3 format and 2dp format\\)$")
    public void checkTotalAssetClassBaseCurrencyValueFormat() {
        allocationListFlow.checkBaseCurrencyFormat();
    }

    @And("^I should see Total Assets Class value as a %\\(2dp format\\)$")
    public void checkAssetClassValueFormat(){
        allocationListFlow.checkPercentageFormat();
    }


    @Then("^The Class will be ordered from largest to smallest based on market value in reference currency,then by alphabetical order, and negative values are present, negative values will be listed AFTER all positive values have been listed, with the largest negative value shown first$")
    public void checkAssetClassesListOrder(){
        allocationListFlow.checkRegionsListOrder();
    }

    @Then("^I should see the Account name/Account assets in the allocation Asset Class wrapper will be changed with the current account$")
    public void checkAccountClassListWrapperChange(){
        allocationListFlow.checkAllocationListWrapperChange();
    }

    @Then("^I should see the Account allocation Asset Class list view will be changed with the current account$")
    public void checkAccountClassListChange() {
        allocationListFlow.checkAllocationListChange();
    }

}
