package com.gt.projects.bdd.hsbc_gbm.step;

import com.gt.projects.bdd.base.BaseStep;
import com.gt.projects.bdd.base.annotation.Action;
import com.gt.projects.bdd.base.annotation.GherkinId;
import com.gt.projects.bdd.hsbc_gbm.flow.LoginFlow;
import com.gt.projects.bdd.hsbc_gbm.flow.MoreMenuFlow;
import com.gt.projects.bdd.hsbc_gbm.flow.OverviewFlow;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class MoreMenuStep extends BaseStep {

    @Autowired
    private LoginFlow loginFlow;

    @Autowired
    private MoreMenuFlow moreMenuFlow;

    @Autowired
    private OverviewFlow overviewFlow;

    @Action("tap_on_More_Menu_button")
    public void tapOnMenuBtn(){
        overviewFlow.tapMenuBtn();
    }

    @Action("tap_glossary_back_button")
    public void tapGlossaryBackBtn(){
        moreMenuFlow.tapGlossaryBackBtn();
    }

    @Action("tap_on_KRC_login_button")
    public void tapOnKRCLoginBtn(){
        this.tapKRCLoginBtn();
    }

    @When("^I tap on More Menu button$")
    public void tapMenuBtn(){
        overviewFlow.tapMenuBtn();
    }

    @When("^I tap on tap area around a term$")
    public void tapOneTerm(){
        moreMenuFlow.tapOneTerm();
    }

    @When("^I tap on tap area around a new term$")
    public void tapNewTerm(){
        moreMenuFlow.tapNewTerm();
    }

    @When("^I tap on \"Menu\" label top left of Glossary screen$")
    public void tapMenuLabel(){
        moreMenuFlow.tapMenuLabel();
    }

    @When("^I tap on menu \"X\" button$")
    public void tapMenuXButton(){
        moreMenuFlow.tapMenuXButton();
    }

    @When("^I tap the left blank$")
    public void tapLeftBlank(){
        moreMenuFlow.tapLeftBlank();
    }

    @When("^I tap on tap area around a term again$")
    public void tapTermAgain(){
        moreMenuFlow.tapTermAgain();
    }

    @When("^I gesture to slide to the right$")
    public void gestureRight(){
        moreMenuFlow.gestureRight();
    }

    @When("^I tap on Security button$")
    public void tapSecurityBtn(){
        moreMenuFlow.tapSecurityBtn();
    }

    @When("^I tap on Legal button$")
    public void tapLegalBtn(){
        moreMenuFlow.tapLegalBtn();
    }

    @When("^I tap on Glossary of terms$")
    public void tapGlossaryBtn(){
        moreMenuFlow.tapGlossaryBtn();
    }

    @When("^I tap on ‘Knowledge & Research Centre’ More Menu item$")
    public void tapKRCBtn(){
        moreMenuFlow.tapKRCBtn();
    }

    @And("^I tap on Log Out button$")
    public void tapLogOutBtn(){
        moreMenuFlow.tapLogOutBtn();
    }

    @And("^I tap the Touch ID Toggle$")
    public void tapTouchIdToggle(){
        moreMenuFlow.tapTouchIdToggle();
    }

    @And("^I tap on Login CTA in KRC screen$")
    public void tapKRCLoginBtn(){
        moreMenuFlow.tapKRCLoginBtn();
    }

    @When("^I tap “Cancel” on KRC overlay$")
    public void tapCancelBtn(){
        moreMenuFlow.tapCancelBtn();
    }

    @When("^I select \"Don't show me again\"$")
    public void tapAgainBtn(){
        moreMenuFlow.tapAgainBtn();
    }

    @When("^I tap “Back” in KRC screen$")
    public void tapKRCBackBtn(){
        moreMenuFlow.tapKRCBackBtn();
    }

    @And("^the list of terms automatically move up to allow enough space for the user to see the whole definition without having to manually scroll$")
    public void checkLastTermLocation(){
        moreMenuFlow.checkLastTermLocation();
    }

    @And("^login warning overlay is closed$")
    public void checkOverlayIsClose(){
        moreMenuFlow.checkOverlayIsClose();
    }

    @Then("^I remain on the KRC screen$")
    public void remainOnKRCScreen(){
        moreMenuFlow.remainOnKRCScreen();
    }

    @Then("^I return to main More Menu container$")
    public void checkInMenu(){
        moreMenuFlow.checkInMenu();
    }

    @Then("^I should see the following components on the More Menu Screen$")
    public void checkMenuUI(DataTable dataTable){
        moreMenuFlow.checkMenuUI(dataTable);
    }

    @Then("^I should see a list of investment terms$")
    public void checkInvestmentList(Map<String, String> map){
        moreMenuFlow.checkInvestmentList(map);
    }

    @Then("^I should see the More menu will be closed$")
    public void checkMenuIsClose(){
        moreMenuFlow.checkMenuIsClose();
    }

    @Then("^I should see the Touch ID Toggle status is ON$")
    public void checkToggleIsON(){
        moreMenuFlow.checkToggleIsON();
    }

    @Then("^I should see the card should expand so that the definition of that term becomes visible$")
    public void checkIsShowDefinition(){
        moreMenuFlow.checkIsShowDefinition();
    }
    @Given("^I am see the card should expand so that the definition of that term becomes visible$")
    public void checkShowDefinition(){
        moreMenuFlow.checkIsShowDefinition();
    }

    @Then("^I should see other expanded terms remain expanded$")
    public void checkAlsoShowDefinition(){
        moreMenuFlow.checkIsShowDefinition();
    }

    @Then("^I should return to the More menu page$")
    public void onTheMenuPage(){
        moreMenuFlow.onTheMenuPage();
    }

    @Then("^I will return to the login screen$")
    public void onTheLoginPage(){
        moreMenuFlow.onTheLoginPage();
    }

    @Then("^I should see their Username displayed within the fixed wrapper at the top of the menu$")
    public void checkIsShowUsername(){
        moreMenuFlow.checkIsShowUsername();
    }

    @Then("^I should see the format of data and time that they last logged into the Wealth Dashboard on browser OR mobile$")
    public void checkLastLoginTime(){
        moreMenuFlow.checkLastLoginTime();
    }

    @Then("^I should see the red icon when the document has a message$")
    public void checkIconHasMessage(){
        moreMenuFlow.checkIconHasMessage();
    }

    @Then("^I should see the card should collapse so that only the glossary term is visible$")
    public void checkIsHideDefinition(){
        moreMenuFlow.checkIsHideDefinition();
    }
//
//    @Then("^I should see the definition of the (\\d+)th term expands$")
//    public void checkLastDefinition(int num){
//        moreMenuFlow.checkLastDefinition(num);
//    }

    @Then("^I should see the definition of the last term expands$")
    public void checkLastDefinition(){
        moreMenuFlow.checkLastDefinition();
    }

    @Then("^I should see the term label should stay in the same position on the screen as it was when the term was expanded$")
    public void checkItemLocation(){
        moreMenuFlow.checkItemLocation();
    }

    @Then("^I should see an introduction to KRC and a Log on CTA directing the client to the KRC website:$")
    public void checkKRCUI(Map<String, String> map){
        moreMenuFlow.checkKRCUI(map);
    }

    @Then("^I am shown the following warning overlay:$")
    public void checkKRCOverlayUI(Map<String, String> map){
        moreMenuFlow.checkKRCOverlayUI(map);
    }

    @Given("^I am see the KRC overlay:$")
    public void seeOverlayUI(Map<String, String> map){
        this.checkKRCOverlayUI(map);
    }

    @Given("^I am viewing Knowledge & Research Centre screen$")
    public void onKRCScreen(Map<String, String> map){
        this.checkKRCUI(map);
    }

    @Given("^I am viewing list of terms within the Glossary$")
    public void viewGlossaryScreen(){
        boolean checkGoBtn = loginFlow.checkGoBtn();
        if (checkGoBtn) {
            loginFlow.defaultLogin();
            overviewFlow.tapMenuBtn();
            moreMenuFlow.tapGlossaryBtn();
        }
        moreMenuFlow.assertOnThisScreen();
    }

    @Given("^I am on the Menu Screen$")
    public void onTheMenuScreen(){
        boolean checkGoBtn = loginFlow.checkGoBtn();
        if (checkGoBtn) {
            loginFlow.defaultLogin();
            overviewFlow.tapMenuBtn();
        }
        moreMenuFlow.assertOnThisScreen();
    }

    @Then("^I should see legal section with the following links:$")
    public void checkLegalSectionUI(Map<String, String> map) {
        moreMenuFlow.checkMainLegalSectionUI(map);

    }

    @Given("^I am see legal section with the following links:$")
    public void seeLegalSectionUI(Map<String, String> map) {
        moreMenuFlow.checkMainLegalSectionUI(map);
    }

    @When("^I tap \"Menu\" back button on Legal section$")
    public void tapBackButtonLegalSection(){
        moreMenuFlow.tapBackButtonLegalSection();
    }

    @Then("^I should see the More menu container$")
    public void checkMoreMenuContainer() {
        moreMenuFlow.checkMoreMenuContainer();
    }

    @When("^I tap \"Terms & Conditions\" link$")
    public void tapTermsAndConditions() {
        moreMenuFlow.tapTermsAndConditions();
    }

    @Then("^I should taken to the Terms and Conditions screen where they can view the latest version of the T&Cs they have accepted$")
    public void checkTermsAndConditionsContent(Map<String, String> map) {
        moreMenuFlow.checkLegalSectionUI(map);
    }

    @Given("^I am taken to the Terms and Conditions screen where they can view the latest version of the T&Cs they have accepted$")
    public void termsAndConditionsUI(Map<String, String> map) {
        moreMenuFlow.checkLegalSectionUI(map);
    }

    @When("^I tap \"Legal\" back button$")
    public void tapBackLegalButton(){
        moreMenuFlow.tapBackLegalButton();
    }

    @Then("^I should see the Legal screen with Terms and Conditions, Privacy Policy and Accessibility Statement links$")
    public void checkLegalScreen() {
        moreMenuFlow.checkLegalScreen();

    }

    @When("^I tap \"Privacy Policy\" link$")
    public void tapPrivacyPolicyLink() {
        moreMenuFlow.tapPrivacyPolicyLink();
    }

    @Then("^I should taken to the Privacy Policy screen where they can view the latest version of the Privacy Poliy$")
    public void checkPrivacyPolicyScreenUI(Map<String, String> map){
        moreMenuFlow.checkLegalSectionUI(map);
    }

    @Given("^I am taken to the Privacy Policy screen where they can view the latest version of the Privacy Poliy$")
    public void privacyPolicyScreenUI(Map<String, String> map){
        moreMenuFlow.checkLegalSectionUI(map);
    }

    @When("^I taps \"Accessibility Statement\" link$")
    public void tapsAccessibilityStatementLink(){
        moreMenuFlow.tapsAccessibilityStatementLink();
    }

    @Then("^I should taken to the accessibility statement screen where they can view the following copy:$")
    public void checkAccessibilityStatementScreenUI(Map<String, String> map){
        moreMenuFlow.checkLegalSectionUI(map);
    }

    @Then("^I should on the Accessibility Statement page$")
    public void onAccessibilityStatementPage() {
        moreMenuFlow.onAccessibilityStatementPage();
    }

    @Given("^I am on the Accessibility Statement page$")
    public void onTheAccessibilityStatementPage() {
        moreMenuFlow.onAccessibilityStatementPage();
    }

    @When("^I tap on Apple's Accessibility page hyperlink$")
    public void tapAccessibilityPageHyperlink() {
        moreMenuFlow.tapAccessibilityPageHyperlink();
    }

    @Then("^I should shown the following warning overlay: \"([^\"]*)\"$")
    public void checkNoShowMeAgainOverlay(String title){
        moreMenuFlow.checkNoShowMeAgainOverlay(title);
    }

    @Given("^I am shown the following warning overlay: \"([^\"]*)\"$")
    public void noShowMeAgainOverlay(String title){
        moreMenuFlow.checkNoShowMeAgainOverlay(title);
    }

    @And("^a Accessibility Statement CTA \"([^\"]*)\"$")
    public void checkAccessibilityStatementCTA(String overlayContent) {
        moreMenuFlow.checkAccessibilityStatementCTA(overlayContent);
    }

    @When("^I tap 'Cancel' on Apple's Accessibility pag$")
    public void tapCancelOnAppleSAccessibilityPag() {
        moreMenuFlow.tapCancelOnAppleSAccessibilityPag();
    }

    @Then("^I remain on the accessibility statement screen$")
    public void onTheAccessibilityStatementScreen(){
        moreMenuFlow.onAccessibilityStatementPage();
    }

    @Given("^I am remain on the accessibility statement screen$")
    public void onAccessibilityStatementScreen(){
        moreMenuFlow.onAccessibilityStatementPage();
    }

    @And("^accessibility statement warning overlay is closed$")
    public void accessibilityStatementWarningOverlayIsClosed() {
        moreMenuFlow.accessibilityStatementWarningOverlayIsClosed();
    }

    @When("^I select Accessibility \"Don't show me again\"$")
    public void selectAccessibilityNoAgain() {
        moreMenuFlow.selectAccessibilityNoAgain();

    }

    @Then("^I should see the date and time that they last logged into the Wealth Dashboard on browser OR mobile in the format below:$")
    public void checkLastLoginInTime() {
        moreMenuFlow.checkLastLoginInTime();
    }

//    @And("^I tap the (\\d+)th term$")
//    public void tapLastTerm(int num) {
//        moreMenuFlow.tapLastTerm(num);
//    }

    @And("^I tap the last term$")
    public void tapLastTerm() {
        moreMenuFlow.tapLastTermInScreen();
    }

    @Then("^I should see the term message of all$")
    public void checkTermMessage(Map<String, String> map){
        moreMenuFlow.checkTermMessage(map);
    }

    @Then("^I should not see the KRC tab as it is hidden$")
    public void notSeeKRC(){
        moreMenuFlow.notSeeKRC();
    }

    @Then("^I tap on the \"Documents\" more menu tab$")
    public void tapDocumentsBtn(){
        moreMenuFlow.tapDocumentsBtn();
    }

    @Then("^I should on the More Menu$")
    public void onTheMoreMenu() {
        moreMenuFlow.onTheMenuPage();
    }

    @Given("^I am on the More Menu$")
    public void checkTheMoreMenu() {
        moreMenuFlow.onTheMenuPage();
    }

    @Then("^I should on the Glossary of terms$")
    public void checkTheGlossaryOfTerms(){
        moreMenuFlow.onTheGlossaryOfTerms();
    }

    @Given("^I am on the Glossary of terms$")
    public void onTheGlossaryOfTerms(){
        moreMenuFlow.onTheGlossaryOfTerms();
    }

    @Then("^I should on the KRC page$")
    public void checkOnTheKRCPage() {
        moreMenuFlow.checkOnTheKRCPage();
    }
    @Given("^I am on the KRC page$")
    public void onTheKRCPage() {
        moreMenuFlow.checkOnTheKRCPage();
    }

    @Then("^I should on the overlay of Logining CTA at the KRC website page$")
    public void checkTheOverlayOfLoginCTAAtTheKRCWebsitePage(){
        moreMenuFlow.checkTheOverlayOfLoginCTAAtTheKRCWebsitePage();
    }

    @Given("^I am on the overlay of Logining CTA at the KRC website page$")
    public void onTheOverlayOfLoginCTAAtTheKRCWebsitePage(){
        moreMenuFlow.checkTheOverlayOfLoginCTAAtTheKRCWebsitePage();
    }

    @Then("^I should on the Legal section$")
    public void checkTheLegalSection() {
        moreMenuFlow.checkTheLegalSection();
    }

    @Given("^I am on the Legal section$")
    public void onTheLegalSection() {
        moreMenuFlow.checkTheLegalSection();
    }

    @Then("^I should on the Terms & Conditions section$")
    public void checkTheTermsConditionsSection(){
        moreMenuFlow.checkBackLegalBtn();
    }
    @Given("^I am on the Terms & Conditions section$")
    public void onTheTermsConditionsSection(){
        moreMenuFlow.checkBackLegalBtn();
    }

    @Then("^I should on the Privacy Policy section$")
    public void checkThePrivacyPolicySection(){
        moreMenuFlow.checkBackLegalBtn();
    }

    @Given("^I am on the Privacy Policy section$")
    public void onThePrivacyPolicySection(){
        moreMenuFlow.checkBackLegalBtn();
    }

    @Then("^I am not able to view their username, I can instead view - \"([^\"]*)\"$")
    public void checkMenuUserName(String userName){
        moreMenuFlow.checkMenuUserName(userName);
    }

    @Then("^I can see the \"Security tips\" sub menu$")
    public void checkSecuritySubMenu(){
        moreMenuFlow.checkSecuritySubMenu();
    }

    @Then("^I tap \"Security Tips\" link$")
    public void tapSecurityTips(){
        moreMenuFlow.tapSecurityTips();
    }

    @Given("^I am viewing the Security Tips screen$")
    public void viewSecurityTipsScreen(){
        moreMenuFlow.viewSecurityTipsScreen();
    }

    @Then("^I should see the following components on the Legal screen$")
    public void checkLegalSubMenu(Map<String, String> map){
        moreMenuFlow.checkLegalSubMenu(map);
    }

    @Then("^I am taken to the Security Tips screen where they can view the latest version of the Security Tips$")
    public void checkSecurityTipsTitle(){
        moreMenuFlow.checkSecurityTipsTitle();
    }

    @Then("^I am taken to the Privacy Policy screen where they can view the clear header of \"([^\"]*)\"$")
    public void checkPrivacyPolicyTitle(String title) {
        moreMenuFlow.checkPrivacyPolicyTitle(title);
    }

    @Then("^I am taken to the Legal page with Terms and conditions renamed to \"([^\"]*)\"$")
    public void checkTermsOfServiceValue(String value){
        moreMenuFlow.checkTermsOfServiceValue(value);
    }

    @When("^I tap \"Terms of service\" link$")
    public void tapTermsOfService(){
        moreMenuFlow.tapTermsOfService();
    }

    @Then("^I am taken to the Terms of Conditions screen where they can view the tab of \"([^\"]*)\"$")
    public void checkTermsOfConditionsTab(String value){
        moreMenuFlow.checkTermsOfConditionsTab(value);
    }

    @And("^On the right,they can also view the tab of \"([^\"]*)\"$")
    public void checkTermsOfUseTab(String value){
        moreMenuFlow.checkTermsOfUseTab(value);
    }

    //crete by yippee
    @When("^I tap on cancel button of Log Out pop up page$")
    public void tapOnCancelBtnLogout()  {
        moreMenuFlow.tapOnlogoutBtn();
        moreMenuFlow.tapOnCancelBtnLogout();
    }

    @Then("^I will return back more menu screen$")
    public void iWillReturnBackMoreMenuScreen() {
        moreMenuFlow.onTheMenuPage();    }

    @When("^I slide to the bottom of the Glossary of Terms screen$")
    public void slideToGlossaryBottom() {
        moreMenuFlow.slideToGlossaryBottom();    }

    @Then("^I should see the following message on the Glossary of Terms screen$")
    public void checkGlossaryDisclaimerMessage(Map<String, String> map){
        moreMenuFlow.checkGlossaryDisclaimerMessage(map);
    }

}
