package com.gt.projects.bdd.hsbc_gbm.step;

import com.gt.projects.bdd.base.BaseStep;
import com.gt.projects.bdd.hsbc_gbm.flow.CurrencyConversionFlow;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class CurrencyConversionStep extends BaseStep {

    @Autowired
    private CurrencyConversionFlow currencyConversionFlow;

    @Then("^I should see the following datas in Conversation overlay:$")
    public void checkConversationOverlayUI(Map<String, String> map) {
        currencyConversionFlow.checkConversationOverlayUI(map);
    }

    @And("^a list of each currencies and national flag$")
    public void checkConversionList() {
        currencyConversionFlow.checkConversionList();
    }

    @And("^GPB is NOT shown in the currency list$")
    public void checkNotGBP() {
        currencyConversionFlow.checkNotGBP();
    }

    @Then("^the latest available exchange rate for each currency compared to GPB shown to 4 decimal places$")
    public void checkCurrency4DP() {
        currencyConversionFlow.checkCurrency4DP();
    }

    @Then("^I should see the list of currencies are displayed in alphabetical order$")
    public void checkCurrencyOrder() {
        currencyConversionFlow.checkCurrencyOrder();
    }

    @Then("^I should see Conversation overlay currency in ISO 3 code$")
    public void checkCurrencyISO() {
        currencyConversionFlow.checkCurrencyISO(true);
    }

    @Then("^I should see Conversation overlay currency in ISO 3 code with no currency list$")
    public void checkCurrencyISONoCurrencyList() {
        currencyConversionFlow.checkCurrencyISO(false);
    }


    @When("^I tap on \"X\" button in currency Conversation overlay$")
    public void tapCloseButton() {
        currencyConversionFlow.tapCloseButton();
    }

    @Then("^I should see the Currency Conversion overlay should be closed$")
    public void checkOverlayClose() {
        currencyConversionFlow.checkOverlayClose();
    }

    @Then("^I should see the following message in Currency Conversion at Overview level:$")
    public void checkNotRetrievableMessage(Map<String, String> map) {
        currencyConversionFlow.checkNotRetrievableMessage(map);
    }

    @Then("^I should see the following message in Currency Conversion at Account level:$")
    public void checkAccountNotRetrievableMessage(Map<String, String> map) {
        this.checkNotRetrievableMessage(map);
    }

    @Then("^I should see the following message in Currency Conversion at portfolio level:$")
    public void checkPortfolioNotRetrievableMessage(Map<String, String> map) {
        this.checkNotRetrievableMessage(map);
    }

    @Then("^I should see the following message in Conversation overlay UI at Overview Level\\(2\\) when there are no currencies to display:$")
    public void checkNoCurrencyMessage(Map<String, String> map) {
        currencyConversionFlow.checkNoCurrencyMessage(map);
    }

    @Then("^I should see the following message in Conversation overlay UI at Account Level\\(2\\) when there are no currencies to display:$")
    public void checkAccountNoCurrencyMessage(Map<String, String> map) {
        this.checkNoCurrencyMessage(map);
    }

    @Then("^I should see the following message in Conversation overlay UI at Portfolio Level\\(2\\) when there are no currencies to display:$")
    public void checkPortfolioNoCurrencyMessage(Map<String, String> map) {
        this.checkNoCurrencyMessage(map);
    }

    @Given("^I see the following message in Conversation overlay UI at Overview Level\\(2\\) when there are no currencies to display:$")
    public void seeOverviewNoCurrencyMessage(Map<String, String> map) {
        this.checkNoCurrencyMessage(map);
    }

    @Given("^I see the following message in Conversation overlay UI at Account Level\\(2\\) when there are no currencies to display:$")
    public void seeAccountNoCurrencyMessage(Map<String, String> map) {
        this.checkNoCurrencyMessage(map);
    }

    @Given("^I see the following message in Conversation overlay UI at Portfolio Level\\(2\\) when there are no currencies to display:$")
    public void seePortfolioNoCurrencyMessage(Map<String, String> map) {
        this.checkNoCurrencyMessage(map);
    }

    @Then("^I should see the overview Conversion overlay following disclaimer:$")
    public void checkDisclaimerMessage(Map<String, String> map) {
        currencyConversionFlow.checkDisclaimerMessage(map);
    }

    @Then("^I should see Conversation overlay Updated: dd Mmm yyyy, hh:mm \\(12 hour clock\\) Time Zone$")
    public void checkDateFormat() {
        currencyConversionFlow.checkDateFormat();
    }

    @Then("^they should see the overview following disclaimer:$")
    public void checkOverviewCurrencyDisclaimer(Map<String,String> map){
        currencyConversionFlow.checkCurrencyDisclaimer(map);
    }

    @Then("^they should see the account following disclaimer:$")
    public void checkAccountCurrencyDisclaimer(Map<String,String> map) {
        currencyConversionFlow.checkCurrencyDisclaimer(map);
    }

    @Then("^they should see the portfolio following disclaimer:$")
    public void checkPortfolioCurrencyDisclaimer(Map<String,String> map) {
        currencyConversionFlow.checkCurrencyDisclaimer(map);
    }

    @Then("^I should see a header \"([^\"]*)\" NOT \"Currency Conversion\"$")
    public void checkOverviewCurrencyHeaderTitle(String headerTitle) {
        currencyConversionFlow.checkOverviewCurrencyHeaderTitle(headerTitle);
    }

    @Then("^I should on the Conversation overlay$")
    public void checkTheConversationOverlay() {
        currencyConversionFlow.viewConversationOverlay();
    }

    @Given("^I am on the Conversation overlay$")
    public void onTheConversationOverlay() {
        currencyConversionFlow.viewConversationOverlay();
    }

    @Then("^The following message on allocation holding screen should be displayed instead of showing the list of exchange rates$")
    public void checkAllocationNotRetrievableMessage(Map<String, String> map) {
        this.checkNotRetrievableMessage(map);
    }

    @Then("^I should see the following message on allocation holding screen should be displayed instead of showing the list of exchange rates:$")
    public void checkHoldingNoCurrencyMessage(Map<String, String> map) {
        this.checkNoCurrencyMessage(map);
    }
}
