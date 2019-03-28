package com.gt.projects.bdd.hsbc_gbm.step;

import com.gt.projects.bdd.base.BaseStep;
import com.gt.projects.bdd.base.annotation.Action;
import com.gt.projects.bdd.hsbc_gbm.flow.ErrorFlow;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class ErrorStep  extends BaseStep {

    @Autowired
    private ErrorFlow errorFlow;

    @Then("^display the following Gateway Timeout error message screen:$")
    public void checkGatewayTimeout(Map<String,String> map){
        errorFlow.checkGatewayTimeout(map);
    }

    @And("^include a CTA \"Return to log on\" within error message screen allowing the user to be redirected to the login screen$")
    public void tabReturnToLogOn(){
        errorFlow.tabReturnToLogOn();
    }

    @And("^log user out of the app when Gateway Timeout$")
    public void logUserOutOfTheAppWhenGatewayTimeout() {
        errorFlow.logUserOutOfTheAppWhenGatewayTimeout();
    }
}
