package com.gt.projects.bdd.hsbc_gbm.step;

import com.gt.projects.bdd.base.BaseStep;
import com.gt.projects.bdd.base.annotation.Action;
import com.gt.projects.bdd.hsbc_gbm.flow.LiabilitiesOverlayFlow;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class LiabilitiesOverlayStep extends BaseStep {

    @Autowired
    private LiabilitiesOverlayFlow liabilitiesOverlayFlow;

    @Then("^I should see the Total Liabilities Overlay following data is shown:$")
    public void checkAccountTotalLiabilitiesOverlayUI(Map<String,String> map) {
        liabilitiesOverlayFlow.checkAccountTotalLiabilitiesOverlayUI(map);
    }
    @Given("^I am see the Total Liabilities Overlay following data is shown:$")
    public void seeAccountTotalLiabilitiesOverlayUI(Map<String,String> map) {
        liabilitiesOverlayFlow.checkAccountTotalLiabilitiesOverlayUI(map);
    }

    @Then("^I should see Total Liabilities Overlay base currency ISO 3 code$")
    public void checkTotalLiabilitiesOverlayDataISO3(){
        liabilitiesOverlayFlow.checkTotalLiabilitiesOverlayDataISO3();
    }

    @When("^I tap on \"close\" on total liabilities overlay$")
    public void closeTotalLiabilitiesOverlay(){
        liabilitiesOverlayFlow.closeTotalLiabilitiesOverlay();
    }

    @Then("^I should see the the total liabilities overlay is closed$")
    public void checkTotalLiabilitiesOverlayIsClosed() {
        liabilitiesOverlayFlow.checkTotalLiabilitiesOverlayIsClosed();
    }

    @When("^I tap anywhere on the screen outside of the total liabilities overlay frame$")
    public void tapAnywhereOnTheScreenOutsideOfTheTotalLiabilitiesOverlay() {
        liabilitiesOverlayFlow.tapAnywhereOnTheScreenOutsideOfTheTotalLiabilitiesOverlay();
    }
}
