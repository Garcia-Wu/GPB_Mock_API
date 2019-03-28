package com.gt.projects.bdd.hsbc_gbm.step;

import com.gt.projects.bdd.base.BaseStep;
import com.gt.projects.bdd.hsbc_gbm.flow.LiabilitiesDetailFlow;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class LiabilitiesDetailStep extends BaseStep {

    @Autowired
    private LiabilitiesDetailFlow liabilitiesDetailFlow;

    @Then("^I should on the liability detail view$")
    public void onLiabilityDetailView() {
        liabilitiesDetailFlow.onLiabilityDetailView();
    }

    @Given("^I am on the liability detail view$")
    public void onTheLiabilityDetailView() {
        liabilitiesDetailFlow.onLiabilityDetailView();
    }

    @Then("^I should see the following liability detail view headers:$")
    public void checkLiabilityDetailHeaderUI(Map<String, String> map) {
        liabilitiesDetailFlow.checkLiabilityDetailHeaderSAMEUI(map);
    }
    @Given("^I am see the following liability detail view headers:$")
    public void liabilityDetailHeaderUI(Map<String, String> map) {
        liabilitiesDetailFlow.checkLiabilityDetailHeaderSAMEUI(map);
    }

    @And("^the following details displayed regarding the individual liability:$")
    public void checkLiabilityDetailsUI(Map<String, String> map) {
        liabilitiesDetailFlow.checkLiabilityDetailsUISAME(map);
    }

    @And("^all liability values are displayed as negative figures using a minus sign$")
    public void liabilityValuesAreNegative() {
        liabilitiesDetailFlow.liabilityValuesAreNegative();
    }

    @Then("^I should see ISO 3 code of liability currency and loan currency$")
    public void checkLiabilityISO3Same(){
        liabilitiesDetailFlow.checkLiabilityISO3Same();
    }

    @Then("^I should see ISO 3 code of liability currency and portfolio base currency$")
    public void checkLiabilityISO3SameDifferent(){
        liabilitiesDetailFlow.checkLiabilityISO3Different();
    }

    @When("^I taps on the back button labelled with Portfolio name value$")
    public void tapsBackButton(){
        liabilitiesDetailFlow.tapsBackButton();
    }
}
