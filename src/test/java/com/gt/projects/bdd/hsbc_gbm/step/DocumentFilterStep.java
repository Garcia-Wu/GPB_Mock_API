package com.gt.projects.bdd.hsbc_gbm.step;

import com.gt.projects.bdd.base.BaseStep;
import com.gt.projects.bdd.base.annotation.Action;
import com.gt.projects.bdd.hsbc_gbm.flow.DocumentFilterFlow;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en_lol.AN;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class DocumentFilterStep extends BaseStep {

    @Autowired
    private DocumentFilterFlow documentFilterFlow;

    @Then("^a list of accounts that the client is entitled to view online is displayed with the following information:Account name value$")
    public void checkDisplayAccount(){
        documentFilterFlow.checkDisplayAccount();
    }

    @And("^I should see the list of accounts has a header \"([^\"]*)\"$")
    public void checkAccountHeader(String headerValue){
        documentFilterFlow.checkAccountHeader(headerValue);
    }

    @When("^I tap on the filter header \"([^\"]*)\"$")
    public void tapFilterHeader(String headerValue){
        documentFilterFlow.tapFilterHeader(headerValue);
    }

    @When("^I slip down the Accounts list for some distance$")
    public void slipDownTheAccounts(){
        documentFilterFlow.slipDownTheAccounts();
    }

    @And("^closes the filter by tapping \"X\"$")
    public void tapCloseButton(){
        documentFilterFlow.tapCloseButton();
    }

    @And("^I tap the first account filter button$")
    public void tapFirstAccount(){
        documentFilterFlow.tapFirstAccount();
    }

    @Then("^I should see other document Accounts list below$")
    public void checkDisplayMoreAccount(){
        documentFilterFlow.checkDisplayAccount();
    }

    @Then("^I can see the Categories list$")
    public void seeCategories(){
        documentFilterFlow.seeCategories();
    }

    @Then("^I should only see all documents related to the account\\(s\\) that I have selected should be displayed$")
    public void filterAccount(){
        documentFilterFlow.filterAccount();
    }

    @And("^the \"Filter\" component should indicate that a filter has been \"([^\"]*)\"$")
    public void checkFilterApplied(String filterValue){
        documentFilterFlow.checkFilterApplied(filterValue);
    }

    @Then("^I should only see unread documents related to the account\\(s\\) that I have selected should be displayed$")
    public void checkUnreadFilterAccount(){
        documentFilterFlow.filterAccount();
    }

    @Then("^I should only see flagged documents related to the account\\(s\\) that I have selected should be displayed$")
    public void checkFlaggedFilterAccount(){
        documentFilterFlow.filterAccount();
    }

    @When("^I tap on the account \"None\" button$")
    public void tapAccountNoneBtn(){
        documentFilterFlow.tapAccountNoneBtn();
    }

    @Then("^the following message should be displayed instead of the documents list:$")
    public void checkUnreadNoDocumentMessage(Map<String, String> map){
        documentFilterFlow.checkUnreadNoDocumentMessage(map);
    }

    @Then("^I should see the following message instead of an accounts list$")
    public void checkNoAccountMessage(Map<String, String> map){
        documentFilterFlow.checkNoAccountMessage(map);
    }

    @And("^I Adjust the filter to leave only accounts with no corresponding documents$")
    public void tapFilterToOnlyNoHasDocumentAccount(){
        documentFilterFlow.tapFilterToOnlyNoHasDocumentAccount();
    }

    @Then("^\"All\" and \"None\" sub-filters should be hidden adjacent to the Account header$")
    public void checkNoAccountFilter(){
        documentFilterFlow.checkNoAccountFilter();
    }

    @Then("^I should see Accounts list is expand$")
    public void checkAccountListExpand(){
        documentFilterFlow.checkAccountListExpand();
    }

    @Then("^I should see documents Accounts list is collapse$")
    public void checkAccountListCollapse(){
        documentFilterFlow.checkAccountListCollapse();
    }

    @And("^I should see Account name value$")
    public void checkSeeAllAccountName(){
        documentFilterFlow.checkSeeAllAccountName();
    }

    @Then("^I should on the document filter screen$")
    public void onTheDocumentFilter(){
        documentFilterFlow.onTheDocumentFilter();
    }

    @Given("^I am on the document filter screen$")
    public void seeOnTheDocumentFilter(){
        documentFilterFlow.onTheDocumentFilter();
    }

    @When("^I expand document Accounts filter list$")
    public void expandAccountFilter(){
        documentFilterFlow.expandAccountFilter();
    }

    @And("^I collapse document Accounts filter list$")
    public void collapseAccountFilter(){
        documentFilterFlow.collapseAccountFilter();
    }

    @Then("^the Accounts section should expand to show all of the clients accounts$")
    public void showAllAccount(){
        documentFilterFlow.checkSeeAllAccountName();
    }

    @Then("^the Accounts section should collapse to show all of the clients accounts$")
    public void noShowAllAccount(){
        documentFilterFlow.noShowAllAccount();
    }
}
