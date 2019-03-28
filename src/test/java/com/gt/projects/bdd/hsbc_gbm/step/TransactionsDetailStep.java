package com.gt.projects.bdd.hsbc_gbm.step;

import com.gt.projects.bdd.base.BaseStep;
import com.gt.projects.bdd.hsbc_gbm.flow.TransactionsDetailFlow;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.bs.A;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class TransactionsDetailStep extends BaseStep {

    @Autowired
    private TransactionsDetailFlow transactionsDetailFlow;

    @Then("I am taken to this transaction detailed view")
    public void seeTransactionsDetail() {
        transactionsDetailFlow.seeTransactionsDetail();
    }

    @Then("^I should on the transaction detail$")
    public void onTransactionDetail(){
        transactionsDetailFlow.onTransactionDetail();

    }
    @Given("^I am on the transaction detail$")
    public void transactionDetail(){
        transactionsDetailFlow.onTransactionDetail();
    }

    @Then("^I can see the following data regarding the transaction:$")
    public void checkTransactionUI(DataTable dataTable) {
        transactionsDetailFlow.checkTransactionUI(dataTable);
    }

    @Then("^I can see ISO 3 code of transaction currency SAME$")
    public void checkTransactionCurrencyISO3SAME() {
        transactionsDetailFlow.checkTransactionCurrencyISO3SAME();
    }

    @Then("^I can see transaction date value Format is \"([^\"]*)\" settled$")
    public void checkTransactionDateFormatSettled(String date){
        transactionsDetailFlow.checkTransactionDateFormatSettled(date);
    }

    @Then("^I can see ISO 3 code of transaction currency DIFFERENT$")
    public void checkTransactionCurrencyISO3DIFFERENT() {
        transactionsDetailFlow.checkTransactionCurrencyISO3DIFFERENT();

    }

    @Then("^I can see transaction date value Format is \"([^\"]*)\" pending")
    public void checkTransactionDateFormatPending(String date){
        transactionsDetailFlow.checkTransactionDateFormatPending(date);
    }


    @When("^I taps on the transaction Back button$")
    public void tapsBackButton() {
        transactionsDetailFlow.tapsBackButton();
    }

    @Then("^I should see \"([^\"]*)\" in transaction detail screen$")
    public void seeSettlementForAsia(String settleTitleValue) {
        transactionsDetailFlow.seeSettlementForAsia(settleTitleValue);
    }

    @And("^I can not see the Transaction type$")
    public void checkNotSeeType() {
        transactionsDetailFlow.checkNotSeeType();
    }

    @Then("^I can see the following components in Discretionary portfolio transaction detail screen:$")
    public void checkDiscretionaryTransactionDetail(Map<String, String> map) {
        transactionsDetailFlow.checkDiscretionaryTransactionDetail();
    }

    @Then("^I can see the following components in Advisory portfolio transaction detail screen:$")
    public void checkAdvisoryTransactionDetail(Map<String, String> map) {
        transactionsDetailFlow.checkAdvisoryTransactionDetail(map);
    }
}
