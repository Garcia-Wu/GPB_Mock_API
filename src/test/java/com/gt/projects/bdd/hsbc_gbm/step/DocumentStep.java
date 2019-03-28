package com.gt.projects.bdd.hsbc_gbm.step;

import com.gt.projects.bdd.base.BaseStep;
import com.gt.projects.bdd.hsbc_gbm.flow.DocumentFlow;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class DocumentStep extends BaseStep {

    @Autowired
    private DocumentFlow documentFlow;

    @Then("^The default Documents list view should be displayed$")
    public void checkSeeDocuments(){
        documentFlow.checkSeeDocuments();
    }

    @Given("^I am viewing the Documents list view$")
    public void seeDocuments(){
        this.checkSeeDocuments();
    }

    @Then("^I tap on the back button labelled \"Menu\" in documents screen$")
    public void tapBackButton(){
        documentFlow.tapBackButton();
    }

    @Then("^I should see the following components in document screen:$")
    public void checkDocumentFilter(Map<String, String> map){
        documentFlow.checkDocumentFilter(map);
    }

    @Then("^I should see all documents are displayed by default \\(read and unread\\)$")
    public void checkAllDocuments(){
        documentFlow.checkAllDocuments();
    }

    @Given("^I am viewing default Document screen$")
    public void viewDocumentScreen(){
        documentFlow.checkAllDocuments();
    }

    @When("^I slip to the bottom of \"All\" Document list$")
    public void slipBottomDocumentList(){
        documentFlow.slipBottomDocumentList();
    }

    @Then("^I should see the following disclaimer in document list bottom:$")
    public void seeDisclaimer(Map<String, String> map){
        documentFlow.seeDisclaimer(map);
    }

    @When("^I tap on the document component labelled \"Unread\"$")
    public void tapUnreadTab(){
        documentFlow.tapUnreadTab();
    }

    @Then("^I should see a count adjacent to the label indicating the number of unread documents$")
    public void checkUnreadNumber(){
        documentFlow.checkUnreadNumber();
    }

    @And("^I click one of the \"Unread\" document item which I have not click before$")
    public void clickUnreadDocument(){
        documentFlow.clickUnreadDocument();
    }

    @Then("^I should see the unread count should reduce by -1$")
    public void checkUnReadCount(){
        documentFlow.checkUnReadCount();
    }

    @When("^I view a list item representing one document which belongs to \"([^\"]*)\" categories$")
    public void slipToCategoryItem(String category){
        documentFlow.slipToCategoryItem(category);
    }

    @Then("^I should see the following information within that list item for advice categories:$")
    public void checkAdviceDocumentUI(Map<String, String> map){
        documentFlow.checkAdviceDocumentUI(map);
    }

    @Then("^I should see the following information within that list item for communication categories:$")
    public void checkCommunicationDocumentUI(Map<String, String> map){
        documentFlow.checkCommunicationDocumentUI(map);
    }

    @Then("^I should see the following information within that list item for statement categories:$")
    public void checkStatementDocumentUI(Map<String, String> map){
        documentFlow.checkStatementDocumentUI(map);
    }

    @And("^Document category value is NOT displayed$")
    public void checkNotCategory(){
        documentFlow.checkNotCategory();
    }

    @Then("^I should see that the Document file size value in megabytes shown as \"mb\" 1 d.p.$")
    public void checkDocumentSize(){
        documentFlow.checkDocumentSize();
    }

    @Then("^I should see the date format dd Month yyyy when date > day 9$")
    public void checkDateGreaterThanNine(){
        documentFlow.checkDateGreaterThanNine();
    }

    @Then("^I should see the date format d Month yyyy when date < day 10$")
    public void checkDateLessThanTen(){
        documentFlow.checkDateLessThanTen();
    }

    @When("^I tap on the document filter btn$")
    public void tapDocumentFilter(){
        documentFlow.tapDocumentFilter();
    }

    @When("^I tap \"Flagged\" Filter$")
    public void tapFlaggedFilter(){
        documentFlow.tapFlaggedFilter();
    }

    @Then("^I should on the document list screen$")
    public void checkInDocument(){
        documentFlow.checkInDocument();
    }

    @Given("^I am on the document list screen$")
    public void checkSeeDocument(){
        documentFlow.checkInDocument();
    }

    @When("^I tap on the document \"All\" Filter$")
    public void tapAllFilter(){
        documentFlow.tapAllFilter();
    }

    @Then("^no documents should be displayed$")
    public void noDocumentDisplay(){
        documentFlow.noDocumentDisplay();
    }

    @When("^I exits documents screen$")
    public void exitDocumentScreen(){
        documentFlow.exitDocumentScreen();
    }

    @Then("^all documents available should be displayed$")
    public void checkHasDocument(){
        documentFlow.checkHasDocument();
    }

    @And("^I slip to the date day > 9 document item$")
    public void slipToDayMoreThanNine(){
        documentFlow.slipToDayMoreThanNine();
    }

    @When("^I slip to the date day < 10 document item$")
    public void slipToDayLessThanTen(){
        documentFlow.slipToDayLessThanTen();
    }
}
