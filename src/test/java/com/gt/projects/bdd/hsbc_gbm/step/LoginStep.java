package com.gt.projects.bdd.hsbc_gbm.step;

import com.gt.projects.bdd.base.BaseStep;
import com.gt.projects.bdd.base.config.DriverConfig;
import com.gt.projects.bdd.base.enums.Platform;
import com.gt.projects.bdd.hsbc_gbm.flow.LoginFlow;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.es.E;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class LoginStep extends BaseStep {

    @Autowired
    private LoginFlow loginFlow;

    @Autowired
    private DriverConfig driverConfig;

    @Then("^I login as default$")
    public void loginAs() {
        if (driverConfig.getPlatform().equals(Platform.IOS)) {
            loginFlow.allow();
            loginFlow.defaultLogin();
        } else {
            loginFlow.aosDefaultLogin();
        }

    }

    @Then("^I login as showSubClass User$")
    public void loginAsShowSubClass() {
        loginFlow.iosLoginAsOne();
    }

    @Given("^I login as User$")
    public void login(Map<String, String> map) {
        String name = map.get("Name");
        if (driverConfig.getPlatform().equals(Platform.IOS)) {
            loginFlow.allow();
            switch (name) {
                case "userA":
                    loginFlow.loginAllButtonTaps();
                    break;
                case "userB":
                    loginFlow.loginNoContingentLiabilities();
                    break;
                case "userC":
                    loginFlow.loginBaseCurrencySameReportingCurrency();
                    break;
                case "userD":
                    loginFlow.defaultLogin();
                    break;
                case "userE":
                    loginFlow.iosLoginAsOne();
                    break;
                case "userF":
                    loginFlow.iosLoginAsThree();
                    break;
                case "userH":
                    loginFlow.currencyMoreThanEight();
                    break;
                case "userJ":
                    loginFlow.iosloginAsFour();
                    break;
                case "userM":
                    loginFlow.loginAsIosFive();
                    break;
                case "userN":
                    loginFlow.iosLoginAsTwo();
                    break;
                case "userO":
                    loginFlow.iosLoginAsSeven();
                    break;
                default:
                    loginFlow.defaultLogin();
                    break;
            }
        } else {
            if (!"userD".equals(name)) {
                loginFlow.clickAosIdBtn();
            }
            switch (name) {
                case "userA":
                    loginFlow.aosLoginAllButtonTaps();
                    break;
                case "userB":
                    loginFlow.aosLoginNoContingentLiabilities();
                    break;
                case "userC":
                    loginFlow.aosLoginBaseCurrencySameReportingCurrency();
                    break;
                case "userD":
                    loginFlow.aosDefaultLogin();
                    break;
                case "userE":
                    loginFlow.loginAsOne();
                    break;
                case "userF":
                    loginFlow.loginAsThree();
                    break;
                case "userH":
                    loginFlow.loginAsSix();
                    break;
                case "userJ":
                    loginFlow.loginAsFour();
                    break;
                case "userM":
                    loginFlow.loginAsFive();
                    break;
                case "userN":
                    loginFlow.loginAsTwo();
                    break;
                case "userO":
                    loginFlow.loginAsSeven();
                    break;
                default:
                    loginFlow.aosDefaultLogin();
                    break;
            }
        }
//        loginFlow.checkLoginStatus();
    }

    @Given("^I am in the registration flow in mobile app$")
    public void iAmInTheRegistrationFlowInMobileApp(){
        loginFlow.assertOnThisScreen();
    }

    @When("^\"Terms of Conditions\" is displayed$")
    public void checkTermsOfConditionsIsDisplayed(){
        loginFlow.checkTermsOfConditionsIsDisplayed();
    }
}
