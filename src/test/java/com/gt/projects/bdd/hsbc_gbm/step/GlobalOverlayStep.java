package com.gt.projects.bdd.hsbc_gbm.step;

import com.gt.projects.bdd.base.BaseStep;
import com.gt.projects.bdd.hsbc_gbm.flow.GlobalOverlayFlow;
import com.gt.projects.bdd.hsbc_gbm.util.RegionUtil;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class GlobalOverlayStep extends BaseStep {

    @Autowired
    private GlobalOverlayFlow globalOverlayFlow;

    @Then("^I should on the global overlay screen$")
    public void checkGlobalOverlay() {
        globalOverlayFlow.onTheGlobalOverlay();
    }

    @Given("^I am on the global overlay screen$")
    public void onTheGlobalOverlay() {
        globalOverlayFlow.onTheGlobalOverlay();
    }

    @Then("^I will see a full screen takeover showing the following global legal UI$")
    public void checkGlobalLegalUI(DataTable dataTable) {
        globalOverlayFlow.checkGlobalLegalUI(RegionUtil.getMap(dataTable));
    }

    @When("^I tap on close button in global legal overlay calculated value$")
    public void tapGlobalLegalDisclaimerBackButton() {
        globalOverlayFlow.tapGlobalLegalDisclaimerBackButton();
    }


    @Given("^I am on the disclaimer overlay$")
    public void onTheDisclaimerOverlay() {
        globalOverlayFlow.onTheDisclaimerOverlay();
    }

    @Then("^the following copy is displayed underneath 'How is this calculated' on portfolio performance overlay \"([^\"]*)\"$")
    public void checkPerformanceAnswer(String answerValue){
        globalOverlayFlow.checkPerformanceAnswer(answerValue);
    }
}
