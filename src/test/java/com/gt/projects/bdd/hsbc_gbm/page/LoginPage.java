package com.gt.projects.bdd.hsbc_gbm.page;

import com.gt.projects.bdd.base.BasePage;
import com.gt.projects.bdd.base.BaseWebElement;
import com.gt.projects.bdd.base.annotation.GherkinId;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Data
@Scope("thread")
public class LoginPage extends BasePage {

    /*---------虚拟机------------*/
    //UK
//    @GherkinId(findByXPath = "//XCUIElementTypePicker[@name=\"select_mock_data_pickerview\"]/XCUIElementTypePickerWheel")
    @GherkinId(findByXPath = "//XCUIElementTypeApplication[@name=\"HSBC PB UK\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypePicker/XCUIElementTypePickerWheel")
    private BaseWebElement customerIdListView;
    //HK
//    @GherkinId(findByXPath = "//XCUIElementTypePicker[@name=\"select_mock_data_pickerview\"]/XCUIElementTypePickerWheel")
//    private BaseWebElement customerIdListView;
    //SG
//    @GherkinId(findByXPath = "com.hsbc.personalbanking.MobileGPBHK.GTENT:id/spCustomID")
//    private BaseWebElement customerIdListView;



    //真机
//    @GherkinId(findByXPath = "//XCUIElementTypeApplication[@name=\"GPB_Mobile_iOS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypePicker/XCUIElementTypePickerWheel")
//    private BaseWebElement customerIdListView;

    @GherkinId(findByXPath = "//XCUIElementTypeApplication[@name=\"GPB_Mobile_iOS_Debug\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSwitch[1]")
    //    @GherkinId(findByObjectId = "select_mockdata_oneaccount")
    private BaseWebElement onlyOneAccountBtn;

    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBUKUAT:id/accountSwitch")
    private BaseWebElement aosOnlyOneAccountBtn;

    @GherkinId(findByXPath = "//XCUIElementTypeApplication[@name=\"GPB_Mobile_iOS_Debug\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSwitch[2]")
//    @GherkinId(findByObjectId = "select_mockdata_showsubclass")
    private BaseWebElement showSubClassBtn;

    @GherkinId(findByXPath = "//XCUIElementTypeApplication[@name=\"GPB_Mobile_iOS_Debug\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSwitch[4]")
//    @GherkinId(findByObjectId = "select_mockdata_8currency")
    private BaseWebElement notAccountNotAllocation;

    private BaseWebElement currencyGreaterEightBtn;
    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBUKUAT:id/currencySwitch")
    private BaseWebElement aosCurrencyGreaterEightBtn;


    @GherkinId(findByXPath = "//XCUIElementTypeApplication[@name=\"GPB_Mobile_iOS_Debug\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSwitch[1]")
    private BaseWebElement classUnavailable;

    @GherkinId(findByXPath = "//XCUIElementTypeApplication[@name=\"GPB_Mobile_iOS_Debug\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSwitch[2]")
    private BaseWebElement currencyUnavailable;

    @GherkinId(findByXPath = "//XCUIElementTypeApplication[@name=\"GPB_Mobile_iOS_Debug\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSwitch[3]")
    private BaseWebElement regionUnavailable;



    @GherkinId(findByXPath = "//XCUIElementTypeApplication[@name=\"GPB_Mobile_iOS_Debug\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSwitch[6]")
    private BaseWebElement noTransactions;

    @GherkinId(findByXPath = "//XCUIElementTypeApplication[@name=\"GPB_Mobile_iOS_Debug\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSwitch[7]")
    private BaseWebElement noHolding;

    @GherkinId(findByXPath = "//XCUIElementTypeApplication[@name=\"GPB_Mobile_iOS_Debug\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSwitch[2]")
    private BaseWebElement noPortfolioHoldings;

    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBUKUAT:id/classUnSwitch")
    private BaseWebElement aosClassUnavailable;

    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBUKUAT:id/currencyUnSwitch")
    private BaseWebElement aosCurrencyUnavailable;

    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBUKUAT:id/regionUnSwitch")
    private BaseWebElement aosRegionUnavailable;

    @GherkinId(findByXPath = "//XCUIElementTypeApplication[@name=\"GPB_Mobile_iOS_Debug\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSwitch[1]")
    private BaseWebElement noContingentLiabilities;

    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBGTENT:id/switchNoContingent")
    private BaseWebElement aosNoContingentLiabilities;

    @GherkinId(findByXPath = "//XCUIElementTypeApplication[@name=\"GPB_Mobile_iOS_Debug\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSwitch[8]")
    private BaseWebElement baseCurrencySameReportingCurrency;

    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBUKUAT:id/switchSameCurrency")
    private BaseWebElement aosBaseCurrencySameReportingCurrency;

    @GherkinId(findByXPath = "//XCUIElementTypeButton[@name=\"Decrement\"]")
    private BaseWebElement decrement;

    @GherkinId(findByXPath = "//XCUIElementTypeButton[@name=\"Increment\"]")
    private BaseWebElement increment;

//    UK
    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBUK.GTENT:id/spCustomID")
    private BaseWebElement ukAosIdTxt;
    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBUK.GTENT:id/tvDialogCancel")
    private BaseWebElement ukAosNoBtn;
    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBUK.GTENT:id/tvAcceptLegal")
    private BaseWebElement ukAosAcceptBtn;
    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBUK.GTENT:id/username_edit_text")
    private BaseWebElement ukAosUsername;
    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBUK.GTENT:id/enter_password_edit_text")
    private BaseWebElement ukAosPassword;
    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBUK.GTENT:id/primary_button")
    private BaseWebElement ukAosLogin;

//    HK
    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBHK.GTENT:id/spCustomID")
    private BaseWebElement hkAosIdTxt;
    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBHK.GTENT:id/tvDialogCancel")
    private BaseWebElement hkAosNoBtn;
    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBHK.GTENT:id/tvAcceptLegal")
    private BaseWebElement hkAosAcceptBtn;
    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBHK.GTENT:id/username_edit_text")
    private BaseWebElement hkAosUsername;
    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBHK.GTENT:id/enter_password_edit_text")
    private BaseWebElement hkAosPassword;
    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBHK.GTENT:id/primary_button")
    private BaseWebElement hkAosLogin;

//    SG
    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBSG.GTENT:id/spCustomID")
    private BaseWebElement sgAosIdTxt;
    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBSG.GTENT:id/tvDialogCancel")
    private BaseWebElement sgAosNoBtn;
    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBSG.GTENT:id/tvAcceptLegal")
    private BaseWebElement sgAosAcceptBtn;
    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBSG.GTENT:id/username_edit_text")
    private BaseWebElement skAosUsername;
    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBSG.GTENT:id/enter_password_edit_text")
    private BaseWebElement sgAosPassword;
    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBSG.GTENT:id/primary_button")
    private BaseWebElement sgAosLogin;

    @GherkinId(findByObjectId = "customer0")
    private BaseWebElement aosId0;
    @GherkinId(findByObjectId = "customer1")
    private BaseWebElement aosId1;
    @GherkinId(findByObjectId = "customer2")
    private BaseWebElement aosId2;
    @GherkinId(findByObjectId = "customer3")
    private BaseWebElement aosId3;
    @GherkinId(findByObjectId = "customer4")
    private BaseWebElement aosId4;
    @GherkinId(findByObjectId = "customer5")
    private BaseWebElement aosId5;
    @GherkinId(findByObjectId = "customer6")
    private BaseWebElement aosId6;
    @GherkinId(findByObjectId = "customer7")
    private BaseWebElement aosId7;




    @GherkinId(findByObjectId = "GO")
    private BaseWebElement goBtn;

//    @GherkinId(findByAosDevelopId = "GO")
    @GherkinId(findByObjectId = "GO")
    private BaseWebElement aosGoBtn;

    @GherkinId(findByObjectId = "Accept")
    private BaseWebElement acceptAndProceedBtn;
//    HK
//    @GherkinId(findByObjectId = "Accept and proceed")
//    private BaseWebElement acceptAndProceedBtn;
    @GherkinId(findByObjectId = "Allow")
    private BaseWebElement allowBtn;
    @GherkinId(findByObjectId = "Don’t Allow")
    private BaseWebElement notAllowBtn;
    @GherkinId(findByObjectId = "Only While Using the App")
    private BaseWebElement onlyWhileUsingAppBtn;
    @GherkinId(findByObjectId = "Always Allow")
    private BaseWebElement alwaysAllowBtn;
    @GherkinId(findByObjectId = "OK")
    private BaseWebElement okBtn;
    @GherkinId(findByObjectId = "Later")
    private BaseWebElement laterBtn;

    @GherkinId(findByObjectId = "Step 1, Enter username")
    private BaseWebElement enterUsername;
    @GherkinId(findByObjectId = "Step 1 Enter username")
    private BaseWebElement aosEnterUsername;
    @GherkinId(findByObjectId = "Step 2, Verify it's you")
    private BaseWebElement verify;
    @GherkinId(findByObjectId = "Step 2 Verify it's you")
    private BaseWebElement aosVerify;
    @GherkinId(findByObjectId = "Step 3, Create a passcode")
    private BaseWebElement createPasscode;
    @GherkinId(findByObjectId = "Step 3 Create a passcode")
    private BaseWebElement aosCreatePasscode;
    @GherkinId(findByObjectId = "usernameTextBox")
    private BaseWebElement userName;
    @GherkinId(findByObjectId = "passwordTextBox")
    private BaseWebElement password;
    @GherkinId(findByObjectId = "continueAction")
    private BaseWebElement continueAction;
    @GherkinId(findByObjectId = "Continue")
    private BaseWebElement aosContinueAction;
    @GherkinId(findByObjectId = "helpAction")
    private BaseWebElement passcode;
    @GherkinId(findByObjectId = "primaryAction")
    private BaseWebElement logon;
    @GherkinId(findByObjectId = "Passcode input with 6 cells")
    private BaseWebElement aosPassCode;

}
