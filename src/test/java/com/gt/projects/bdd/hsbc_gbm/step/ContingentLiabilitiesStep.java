package com.gt.projects.bdd.hsbc_gbm.step;

import com.gt.projects.bdd.base.BaseStep;
import com.gt.projects.bdd.base.annotation.Action;
import com.gt.projects.bdd.hsbc_gbm.flow.ContingentLiabilitiesFlow;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class ContingentLiabilitiesStep extends BaseStep {

    @Autowired
    private ContingentLiabilitiesFlow contingentLiabilitiesFlow;

    @Action("Contingent_liabilities_detail_back_portfolio_list")
    public void clBackToPortfolioList(){
        contingentLiabilitiesFlow.clBackToPortfolioList();
    }

    @Then("^I should see the following Ui Elements on the Contingent Liabilities Screen$")
    public void contingentLiabilitiesScreenHead(Map<String,String> map) {
        contingentLiabilitiesFlow.contingentLiabilitiesScreenHead(map);
    }

    @Given("^I am on the Contingent Liabilities Screen$")
    public void onContingentLiabilities() {
        contingentLiabilitiesFlow.onContingentLiabilities();
    }

    @When("^I tap Total Commitments Remaining value$")
    public void tapTotalCommitmentsRemainingValue() {
        contingentLiabilitiesFlow.tapTotalCommitmentsRemainingValue();
    }

    @Then("^I should see the following UI Elements on the Contingent Liabilities Overlay$")
    public void onTheContingentLiabilitiesOverlay() {
        contingentLiabilitiesFlow.onTheContingentLiabilitiesOverlay();
    }

    @Then("^I should see the following UI Elements on the Contingent Liabilities Overlay Level$")
    public void onContingentLiabilitiesLevel(Map<String,String> map) {
        contingentLiabilitiesFlow.onContingentLiabilitiesLevel(map);
    }

    @Then("^I should see the Total commitments remaining will be shown to 2 decimal places$")
    public void verify2dp() {
        contingentLiabilitiesFlow.verify2dp();
    }

    @Then("^I should see that ISO 3 code of reporting currency for the Portfolio$")
    public void iSO3CodeCurrencyForThePortfolios() {
        contingentLiabilitiesFlow.iSO3CodeCurrencyForThePortfolios();
    }

    @Then("^I should see the following Ui Elements on Contingent Liabilities List screen$")
    public void checkTheContingentLiabilitiesList(Map<String,String> map) {
        contingentLiabilitiesFlow.checkTheContingentLiabilitiesList(map);
    }

    @Then("^I should see ISO 3 code of base currency on Contingent Liabilities List screen$")
    public void iSO3CodeCurrencyForContingentLiabilitiesList(Map<String,String> map) {
        contingentLiabilitiesFlow.iSO3CodeCurrencyForContingentLiabilitiesList(map);
    }

    @Then("^I should see Percentage of commitment remaining value on Contingent Liabilities List screen$")
    public void checkPercentageOfCommitmentRemainingContingentLiabilitiesList(Map<String,String> map) {
        contingentLiabilitiesFlow.checkPercentageOfCommitmentRemainingContingentLiabilitiesList(map);
    }

    @Then("^I should see the following value format to 2 decimal places$")
    public void check2dp(Map<String,String> map) {
        contingentLiabilitiesFlow.check2dp();
    }

    @Then("^I should see the list is ordered by Remaining Commitment value largest first, smallest last$")
    public void orderedByRemainingCommitment() {
        contingentLiabilitiesFlow.orderedByRemainingCommitment();
    }

    @When("^I tap Back button$")
    public void tapBackButton() {
        contingentLiabilitiesFlow.tapBackButton();
    }

    @And("^I tap first item of contingent liabilities list$")
    public void tapFirstItemContingentLiabilitiesList() {
        contingentLiabilitiesFlow.tapFirstItemContingentLiabilitiesList();
    }


    @Then("^I should see the following components on Contingent Liabilities detail$")
    public void checkContingentLiabilitiesDetail(Map<String,String> map) {
        contingentLiabilitiesFlow.checkContingentLiabilitiesDetail(map);
    }

    @Then("^I should see the following data for ISO 3 code all$")
    public void checkISO3codeAll(Map<String,String> map) {
        contingentLiabilitiesFlow.checkISO3codeAll();
    }

    @Given("^I am on the Contingent Liabilities Detail Screen$")
    public void onContingentLiabilitiesDetailScreen() {
        contingentLiabilitiesFlow.onContingentLiabilitiesDetailScreen();
    }


    @Then("^I should see Opening date value \\(format dd.month.yyyy\\)$")
    public void checkDateFormat() {
        contingentLiabilitiesFlow.checkDateFormat();
    }




    @Then("^I should see Percentage of commitment remaining value$")
    public void checkPercentageOfCommitmentRemainingValue() {
        contingentLiabilitiesFlow.checkPercentageOfCommitmentRemainingValue();
    }

    @Then("^I should see the following data for 2 decimal places$")
    public void check2DecimalPlaces(Map<String,String> map) {
        contingentLiabilitiesFlow.check2DecimalPlaces(map);
    }

    @And("^I check element not display on the first detailed view$")
    public void checkFirstDetailElement() {
        contingentLiabilitiesFlow.checkElementNotDisplay();
    }

    @And("^I swipe right to see the detailed view of each Contingent Liability$")
    public void swipeRight() {
        contingentLiabilitiesFlow.swipeRight();
    }

    @Then("^I check element isDisplay on the first detailed view$")
    public void checkElementIsDisplay() {
        contingentLiabilitiesFlow.checkElementIsDisplay();
    }


    @When("^I swipe left to see the detailed view of each Contingent Liability$")
    public void swipeLeft() {
        contingentLiabilitiesFlow.swipeLeft();

    }

    @Then("^I should see the following components on Contingent Liabilities detail as user$")
    public void checkContingentLiabilitiesDetailAsUser(Map<String,String> map) {
        contingentLiabilitiesFlow.checkContingentLiabilitiesDetailAsUserC(map);
    }

    @And("^I tap Back button of detail$")
    public void tapDetailBackButton() {
        contingentLiabilitiesFlow.tapDetailBackButton();
    }

    @And("^I scroll next page$")
    public void scrollNextPage() {
        contingentLiabilitiesFlow.scrollNextPage();
    }

    @And("^I save control state on Contingent Liabilities screen$")
    public void saveControlState() {
        contingentLiabilitiesFlow.saveControlState();
    }

    @And("^I tap eight item of Contingent Liabilities list$")
    public void tapEightItem() {
        contingentLiabilitiesFlow.tapEightItem();
    }

    @Then("^I should see the eight item on the Contingent Liabilities list$")
    public void checkEightItem() {
        contingentLiabilitiesFlow.checkEightItem();
    }

    @Given("^I am on the Contingent Liabilities Overlay Screen$")
    public void onContingentLiabilitiesOverlayScreen() {
        contingentLiabilitiesFlow.onContingentLiabilitiesOverlayScreen();
    }

    @When("^I tap on Contingent Liabilities Overlay close button$")
    public void tapXbutton() {
        contingentLiabilitiesFlow.tapXButton();
    }

    @When("^I taps on any of the items in Contingent liabilities list$")
    public void tapAnyItem() {
        contingentLiabilitiesFlow.tapAnyItem();
    }

    @When("^I Tap on the Contingent Liabilities 2nd item$")
    public void tapTheSecondItem() {
        contingentLiabilitiesFlow.tapTheSecondItem();
    }

    @Then("^I should see the initial list view of their Contingent Liabilities within the Portfolio$")
    public void shouldSeeInitialListView() {
        contingentLiabilitiesFlow.shouldSeeInitialListView();
    }

    @And("^I tap anywhere on the screen outside of the pop up overlay$")
    public void tapGBbutton() {
        contingentLiabilitiesFlow.tapGBButton();
    }

    @And("^slides to the Contingent Liabilities 6th item$")
    public void slideToSixthItem() {
        contingentLiabilitiesFlow.slideToSixthItem();
    }

    @And("^come back the Contingent liabilities item list$")
    public void backToCLList() {
        contingentLiabilitiesFlow.clickDetailBackBtn();
    }

    @And("^I should not see the contingent liabilities list pips$")
    public void checkNotSeePips() {
        contingentLiabilitiesFlow.checkNotSeePips();
    }

    @And("^I should not be able to swipe left of right in contingent liabilities detail view$")
    public void checkDetailNotScroll() {
        contingentLiabilitiesFlow.checkDetailNotScroll();
    }

    @And("^I reach the 15th item within the Contingent liabilities list$")
    public void clListToFifteenItem() {
        contingentLiabilitiesFlow.clListToFifteenItem();
    }

    @And("^I continue to load the list by swipe up the Contingent liabilities list$")
    public void scrollCLList() {
        contingentLiabilitiesFlow.scrollCLList();
    }

    @And("^I tap the 20th item within Contingent liability list$")
    public void tapTwentyItem() {
        contingentLiabilitiesFlow.tapTwentyItem();
    }

    @And("^I go back to the Contingent liability list Level$")
    public void tapDetailBackBtn() {
        contingentLiabilitiesFlow.tapDetailBackBtn();
    }

    @Then("^I should see the following data for ISO 3 code other$")
    public void checkISO3CodeOther(Map<String,String> map) {
        contingentLiabilitiesFlow.checkISO3CodeOther(map);
    }

    @Then("^I should see a detailed view relating to that Contingent liabilities item$")
    public void checkItemDetail() {
        contingentLiabilitiesFlow.checkItemDetail();
    }

    @Then("^I should see the portfolio list$")
    public void checkHasPortfolioList() {
        contingentLiabilitiesFlow.checkHasPortfolioList();
    }

    @Given("^I am see the portfolio list$")
    public void hasPortfolioList() {
        contingentLiabilitiesFlow.checkHasPortfolioList();
    }

    @Then("^I am view the portfolio list Screen$")
    public void seeHasCLList() {
        this.checkHasPortfolioList();
    }

    @Then("^I should see the 6 item in Contingent Liabilities list$")
    public void checkCanSeeSixthItem() {
        contingentLiabilitiesFlow.checkCanSeeSixthItem();
    }

    @Then("^I should see a detailed view relating to contingent liabilities item$")
    public void checkCanSeeFirstItem() {
        contingentLiabilitiesFlow.checkCanSeeFirstItemDetail();
    }

    @Then("^I will see the next 15 Contingent liabilities items are displayed below$")
    public void checkNextFifteenItem() {
        contingentLiabilitiesFlow.checkNextFifteenItem();
    }

    @Then("^I should see the Contingent liability list display the 1st to 15th item default$")
    public void checkInFirstList() {
        contingentLiabilitiesFlow.checkInFirstList();
    }

    @Then("^I should see the 20th item and the Contingent liability list previously loaded \\(16th-30th\\)$")
    public void seeTransactionPreviouslyLoaded() {
        contingentLiabilitiesFlow.seeTransactionPreviouslyLoaded();
    }

    @Given("^I am viewing the Contingent liabilities list has thirty item$")
    public void seeNextFifteenItem() {
        this.checkNextFifteenItem();
    }

    @When("^I come back to the Portfolio Level$")
    public void tapCLBackBtn() {
        contingentLiabilitiesFlow.tapCLBackBtn();
    }


    @Then("^I should viewing the Contingent liabilities list only has one item$")
    public void seeContingentLiabilitiesHasOne() {
        contingentLiabilitiesFlow.seeContingentLiabilitiesHasOne();
    }

    @And("^NO pips to indicate that they can swipe left or right within portfolio contingent liabilities detailed view$")
    public void noPipsContingentLiabilities() {
        contingentLiabilitiesFlow.noPipsContingentLiabilities();
    }

    @And("^I should not be able to swipe left or right in portfolios contingent liabilities detailed view$")
    public void checkRight() {
        contingentLiabilitiesFlow.checkRight();
    }
}
