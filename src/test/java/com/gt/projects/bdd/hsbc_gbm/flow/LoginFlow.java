package com.gt.projects.bdd.hsbc_gbm.flow;

import com.gt.projects.bdd.base.BaseFlow;
import com.gt.projects.bdd.base.BaseWebElement;
import com.gt.projects.bdd.base.enums.ScrollDirection;
import com.gt.projects.bdd.base.config.DriverConfig;
import com.gt.projects.bdd.base.enums.Platform;
import com.gt.projects.bdd.hsbc_gbm.page.LoginPage;
import com.gt.projects.bdd.hsbc_gbm.page.MenuLegalPage;
import com.gt.projects.bdd.hsbc_gbm.page.OverviewPage;
import com.gt.projects.bdd.hsbc_gbm.util.RegionUtil;
import com.gt.projects.bdd.hsbc_gbm.util.SleepUtil;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("thread")
public class LoginFlow extends BaseFlow<LoginPage> {

    @Autowired
    private DriverConfig driverConfig;

    @Autowired
    private OverviewPage overviewPage;

    @Autowired
    private MenuLegalPage menuLegalPage;

    protected LoginFlow(LoginPage currentPage) {
        super(currentPage);
    }


    public void defaultLogin(){
        captureScreen();
        currentPage.getGoBtn().click();
        sleep(500L);
    }

    public void aosDefaultLogin() {
        captureScreen();
        currentPage.getAosGoBtn().click();
    }

    public void loginAllButtonTaps() {
        captureScreen();
        currentPage.getCustomerIdListView().sendKeys("1");
        currentPage.getClassUnavailable().click();
        currentPage.getCurrencyUnavailable().click();
//        currentPage.getRegionUnavailable().click();

        currentPage.getGoBtn().click();
        sleep(1000L);

    }

    public void aosLoginAllButtonTaps() {
        captureScreen();
        currentPage.getAosCurrencyGreaterEightBtn().click();
        currentPage.getAosClassUnavailable().click();
        currentPage.getAosCurrencyUnavailable().click();
        currentPage.getAosRegionUnavailable().click();

        currentPage.getAosGoBtn().click();
    }


    public void loginNoContingentLiabilities() {
        captureScreen();
        currentPage.getCustomerIdListView().sendKeys("1");
        currentPage.getNoContingentLiabilities().click();
        currentPage.getGoBtn().click();
        sleep(1000L);
    }

    public void aosLoginNoContingentLiabilities() {
//        currentPage.getAosNoContingentLiabilities().click();
        captureScreen();
        currentPage.getAosGoBtn().click();
    }

    public void loginBaseCurrencySameReportingCurrency() {
        captureScreen();
        currentPage.getCustomerIdListView().sendKeys("1");
//        currentPage.getBaseCurrencySameReportingCurrency().click();
        currentPage.getGoBtn().click();
        sleep(1000L);
    }



    public void iosLoginAsOne(){
        captureScreen();
        currentPage.getCustomerIdListView().sendKeys("1");
        currentPage.getGoBtn().click();
        sleep(1000L);
    }

    public void notInvested() {
        captureScreen();
        currentPage.getCustomerIdListView().sendKeys("3");
        currentPage.getGoBtn().click();
        sleep(500L);
    }

    public void aosLoginBaseCurrencySameReportingCurrency() {
        captureScreen();
        currentPage.getAosBaseCurrencySameReportingCurrency().click();
        currentPage.getAosGoBtn().click();
    }

    public boolean checkGoBtn() {
        if(driverConfig.getPlatform().equals(Platform.IOS)) {
            return currentPage.getGoBtn().isExisted();
        } else {
            return currentPage.getAosGoBtn().isExisted();
        }
    }
    public void iosLoginAsThree() {
        captureScreen();
        currentPage.getCustomerIdListView().sendKeys("3");
        currentPage.getGoBtn().click();
        sleep(1000L);
    }

    public void currencyMoreThanEight() {
        currentPage.getCustomerIdListView().sendKeys("6");
        currentPage.getGoBtn().click();
        sleep(500L);
    }

    public void iosLoginAsTwo() {
        currentPage.getCustomerIdListView().sendKeys("2");
        //currentPage.getNoTransactions().click();
        currentPage.getGoBtn().click();
    }

    public void loginNoCLNoHoldings() {
        captureScreen();
        currentPage.getCustomerIdListView().sendKeys("1");
        currentPage.getNoContingentLiabilities().click();
        currentPage.getNoPortfolioHoldings().click();
        currentPage.getGoBtn().click();
        sleep(500L);
    }

    public void loginHasCLNoHoldings() {

        captureScreen();
        currentPage.getCustomerIdListView().sendKeys("1");
        currentPage.getNoPortfolioHoldings().click();
        sleep(500L);
        currentPage.getGoBtn().click();

    }

    public void loginAsIosFive() {
        captureScreen();
        currentPage.getCustomerIdListView().sendKeys("5");
        currentPage.getGoBtn().click();
        sleep(500L);
    }

    public void loginAsNoTransaction() {
        captureScreen();
        currentPage.getCustomerIdListView().sendKeys("2");
        //currentPage.getNoTransactions().click();
        currentPage.getGoBtn().click();
        sleep(500L);
    }

    public void loginSomeAccount() {
        captureScreen();
        currentPage.getCustomerIdListView().sendKeys("2");
        currentPage.getGoBtn().click();
        sleep(500L);
    }

    public void loginAsMoreThanTwelve() {

    }

    public void loginAsOne() {
        captureScreen();
        currentPage.getAosId1().click();
        currentPage.getAosGoBtn().click();
        sleep(500L);
    }

    public void clickAosIdBtn() {
        sleep(500L);
        if(RegionUtil.isUK()){
            currentPage.getUkAosIdTxt().click();
        } else if (RegionUtil.isHK()){
            currentPage.getHkAosIdTxt().click();
        } else if (RegionUtil.isSG()) {
            currentPage.getSgAosIdTxt().click();
        }
    }

    public void loginAsThree() {
        currentPage.getAosId3().click();
        currentPage.getAosGoBtn().click();
        sleep(500L);
    }

    public void loginNoCLNoHoldingsAos() {
        currentPage.getAosId1().click();
//        currentPage.getAosNoContingentLiabilities().click();
        currentPage.getAosGoBtn().click();
        sleep(500L);
    }

    public void loginAsSix() {
        currentPage.getAosId6().click();
        currentPage.getAosGoBtn().click();
        sleep(500L);
    }

    public void loginAsTwo() {
        currentPage.getAosId2().click();
        currentPage.getAosGoBtn().click();
        sleep(500L);
    }

    public void loginAsFive() {
        currentPage.getAosId5().click();
        currentPage.getAosGoBtn().click();
        sleep(500L);
    }

    public void allow() {
        if (currentPage.getLaterBtn().isVisible()){
            currentPage.getLaterBtn().click();
        }
        while (currentPage.getAllowBtn().isVisible()){
            currentPage.getAllowBtn().click();
            sleep(100L);
        }
        if (currentPage.getAcceptAndProceedBtn().isVisible()){
            currentPage.getAcceptAndProceedBtn().click();
            sleep(100L);
        }
        if (currentPage.getOnlyWhileUsingAppBtn().isVisible()) {
            currentPage.getOnlyWhileUsingAppBtn().click();
            sleep(100L);
        }
//        if (currentPage.getOkBtn().isVisible()){
//            currentPage.getOkBtn().click();
//        }
    }

    public void allowAos() {
        sleep(500L);
        while (currentPage.getUkAosNoBtn().isVisible()){
            currentPage.getUkAosNoBtn().click();
            sleep(100L);
        }
        while (currentPage.getHkAosNoBtn().isVisible()){
            currentPage.getHkAosNoBtn().click();
            sleep(100L);
        }
        while (currentPage.getSgAosNoBtn().isVisible()){
            currentPage.getSgAosNoBtn().click();
            sleep(100L);
        }
        RegionUtil.click("UK_HK_SG",currentPage.getUkAosAcceptBtn(),currentPage.getHkAosAcceptBtn(),currentPage.getSgAosAcceptBtn());
    }

    public BaseWebElement getLoginGoBtn() {
        if(driverConfig.getPlatform().equals(Platform.ANDROID)){
            return currentPage.getAosGoBtn();
        } else {
            return currentPage.getGoBtn();
        }
    }

    public void checkLoginStatus() {
        Assert.assertTrue("App login failed!", overviewPage.getUsernameTxt().isExisted());
    }

    public void iosLoginAsSeven() {
        currentPage.getCustomerIdListView().sendKeys("7");
        currentPage.getGoBtn().click();
        sleep(500L);
    }

    public void loginAsSeven() {
        currentPage.getAosId7().click();
        currentPage.getAosGoBtn().click();
        sleep(500L);
    }

    public void iosloginAsFour() {
        currentPage.getCustomerIdListView().sendKeys("4");
        currentPage.getGoBtn().click();
        sleep(500L);
    }

    public void loginAsFour() {
        currentPage.getAosId4().click();
        currentPage.getAosGoBtn().click();
        sleep(500L);
    }

    public void loginAsCustomerId(Integer customerId){
        if(customerId == null){
            customerId = 0;
        }
        if (driverConfig.getPlatform().equals(Platform.IOS)) {
            allow();
            currentPage.getCustomerIdListView().sendKeys(customerId.toString());
            currentPage.getGoBtn().click();
            sleep(500L);
        } else {
            clickAosIdBtn();
            currentPage.getElementById("customer"+customerId).click();
            currentPage.getAosGoBtn().click();
            sleep(500L);
        }

        this.assertLoginStatus();
    }

    private void assertLoginStatus() {
        if(!overviewPage.getUsernameTxt().isVisible()){
            Assert.assertTrue("Login fail! Cannot go to overview screen!", false);
        }
    }

    public void loginAsUserNameAndPassword(String userName, String password) {
        if(driverConfig.getPlatform().equals(Platform.IOS)){
            allow();
            captureScreen();
            currentPage.getEnterUsername().click();
            captureScreen();

            SleepUtil.waitForElement(currentPage.getUserName());
            currentPage.getUserName().sendKeys(userName);
            currentPage.getContinueAction().click();

            captureScreen();
            SleepUtil.waitForElement(currentPage.getVerify());
            currentPage.getVerify().click();

            captureScreen();
            SleepUtil.waitForElement(currentPage.getPassword());
            currentPage.getPassword().sendKeys(password);
            currentPage.getContinueAction().click();

            captureScreen();
            SleepUtil.waitForElement(currentPage.getCreatePasscode());
            currentPage.getCreatePasscode().click();
            currentPage.getPasscode().sendKeys("125634");

            captureScreen();
            SleepUtil.waitForElement(currentPage.getPasscode());
            currentPage.getPasscode().sendKeys("125634");

            captureScreen();
            SleepUtil.waitForElement(currentPage.getLogon());
            currentPage.getLogon().click();

            captureScreen();
            SleepUtil.waitForElement(currentPage.getPasscode());
            currentPage.getPasscode().sendKeys("125634");
            sleep(300L);

        }else {
            allowAos();
            captureScreen();
            currentPage.getAosEnterUsername().click();
            captureScreen();

            RegionUtil.sendCode("UK_HK_SG",currentPage.getUkAosUsername(),currentPage.getHkAosUsername(),currentPage.getSkAosUsername(),userName);
            currentPage.getAosContinueAction().click();

            captureScreen();
            SleepUtil.waitForElement(currentPage.getAosVerify());
            currentPage.getAosVerify().click();

            captureScreen();
            RegionUtil.sendCode("UK_HK_SG",currentPage.getUkAosPassword(),currentPage.getHkAosPassword(),currentPage.getSgAosPassword(),password);
            currentPage.getAosContinueAction().click();

            captureScreen();
            SleepUtil.waitForElement(currentPage.getAosCreatePasscode());
            currentPage.getAosCreatePasscode().click();

            SleepUtil.waitForElement(currentPage.getAosPassCode());
            currentPage.getAosPassCode().sendKeys("125634");
            captureScreen();

            sleep(300L);
            SleepUtil.waitForElement(currentPage.getAosPassCode());
            currentPage.getAosPassCode().sendKeys("125634");

            captureScreen();
            RegionUtil.click("UK_HK_SG",currentPage.getUkAosLogin(),currentPage.getHkAosLogin(),currentPage.getSgAosLogin());

            captureScreen();
            SleepUtil.waitForElement(currentPage.getAosPassCode());
            currentPage.getAosPassCode().sendKeys("125634");
            sleep(300L);
        }



    }

    public void checkTermsOfConditionsIsDisplayed() {
        sleep(500L);
        if (currentPage.getOkBtn().isVisible()){
            currentPage.getOkBtn().click();
        }
        while (currentPage.getAllowBtn().isVisible()){
            currentPage.getAllowBtn().click();
            sleep(100L);
        }
        Assert.assertTrue(menuLegalPage.getTitleTxt().isVisible());
    }
}
