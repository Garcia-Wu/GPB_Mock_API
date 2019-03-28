package com.gt.projects.bdd.hsbc_gbm.flow;

import com.gt.projects.bdd.base.BaseFlow;
import com.gt.projects.bdd.base.BaseWebElement;
import com.gt.projects.bdd.base.config.DriverConfig;
import com.gt.projects.bdd.base.enums.Platform;
import com.gt.projects.bdd.base.enums.ScrollDirection;
import com.gt.projects.bdd.hsbc_gbm.page.LoginPage;
import com.gt.projects.bdd.hsbc_gbm.page.MenuLegalPage;
import com.gt.projects.bdd.hsbc_gbm.page.MenuPage;
import com.gt.projects.bdd.hsbc_gbm.page.OverviewPage;
import com.gt.projects.bdd.hsbc_gbm.util.RegionUtil;
import cucumber.api.DataTable;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Scope("thread")
public class MoreMenuFlow extends BaseFlow<MenuPage> {

    @Autowired
    private OverviewPage overviewPage;

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private DriverConfig driverConfig;

    @Autowired
    private LoginFlow loginFlow;

    @Autowired
    private MenuLegalPage menuLegalPage;

    private int termX;
    private int termY;

    private int lastTermY;
    private int lastTermIndex;

    protected MoreMenuFlow(MenuPage currentPage) {
        super(currentPage);
    }

    public void checkMenuUI(DataTable dataTable) {
        sleep(200L);
        captureScreen();
        assertIsDisplayed(RegionUtil.getMap(dataTable), "IOS \"X\" button");
//        Assert.assertTrue(currentPage.getUserNameTxt().isVisible());
//        Assert.assertTrue(currentPage.getLastLoginTimeTxt().isVisible());
//        Assert.assertEquals(map.get("Glossary of terms label"), currentPage.getGlossaryTxt().getContent());
//        Assert.assertEquals(map.get("Security label"), currentPage.getHeadSecurityTxt().getContent());
//        Assert.assertEquals(map.get("Feedback label"), currentPage.getFeedbackTxt().getContent());
//        Assert.assertEquals(map.get("Legal label"), currentPage.getLegalTxt().getContent());
//        if (!currentPage.getKrcTxt().isVisible()) {
//            currentPage.getMenuListView().scroll(ScrollDirection.UP, 1000L, 500);
//        }
//        Assert.assertEquals(map.get("Knowledge & research Centre label"), currentPage.getKrcTxt().getContent());
//        Assert.assertEquals(map.get("Log Out button"), currentPage.getLogoutBtn().getContent());
        if (driverConfig.getPlatform().equals(Platform.IOS)) {
            Assert.assertTrue(currentPage.getCloseBtn().isVisible());
        }
    }

    public void tapSecurityBtn() {
        if (!currentPage.getHeadSecurityTxt().isVisible()) {
            currentPage.getMenuListView().scroll(ScrollDirection.DOWN, 1000L, 500);
        }
        currentPage.getHeadSecurityTxt().click();
    }

    public void tapLegalBtn() {
        if (!currentPage.getLegalTxt().isVisible()) {
            currentPage.getMenuListView().scroll(ScrollDirection.DOWN, 500L, 500);
        }
        currentPage.getLegalTxt().click();
    }

    public void tapGlossaryBtn() {
        currentPage.getGlossaryTxt().click();
    }

    public void checkInvestmentList(Map<String, String> map) {
        sleep(500L);
        captureScreen();
        String prefix = "glossary_main_table_head_name_label_";
        String suffix = "_0";
        int i = 0;
        for (String key : map.keySet()) {
            if (!key.equals("element name")) {
                String elementId = prefix + i + suffix;
                BaseWebElement element = new BaseWebElement(elementId);
                if (!element.isVisible()) {
                    if (driverConfig.getPlatform().equals(Platform.ANDROID)) {
                        currentPage.getGlossaryListView().scroll(ScrollDirection.UP, 1000L);
                    } else {
                        this.swipeScreen(ScrollDirection.UP);
                    }
                }
                Assert.assertEquals(map.get(key), element.getContent());
                i++;
            }
        }
    }

    public void tapOneTerm() {
        currentPage.getGlossaryListNameTxt0().click();
    }

    public void checkIsShowDefinition() {
        sleep(200L);
        captureScreen();
        Assert.assertTrue(currentPage.getGlossaryListContentTxt0().isDisplayed());
    }

    public void tapNewTerm() {
        getGlossaryListNameTxt(1).click();
    }

    public void tapMenuLabel() {
        currentPage.getGlossaryBackBtn().click();
    }

    public void tapLogOutBtn() {
        currentPage.getLogoutBtn().click();
        if (driverConfig.getPlatform().equals(Platform.IOS)){
            if (currentPage.getVerifyLogoutBtn().isExisted()) {
                currentPage.getVerifyLogoutBtn().click();
            }
            if (currentPage.getVerifyLogonBtn().isExisted()) {
                currentPage.getVerifyLogonBtn().click();
            }
        }
        else {
            if (currentPage.getAosLogonBtn().isExisted()) {
                currentPage.getAosLogonBtn().click();
            }
        }

        if(currentPage.getReturnLoginBtn().isExisted()){
            currentPage.getReturnLoginBtn().click();
        }

        sleep(500L);
    }

    public void checkIsShowUsername() {
        sleep(200L);
        captureScreen();
        Assert.assertTrue(currentPage.getUserNameTxt().isVisible());
    }

    public void checkLastLoginTime() {
        sleep(200L);
        captureScreen();
        String lastLoginTimeTxt = currentPage.getLastLoginTimeTxt().getContent();
        String lastLoginTime = lastLoginTimeTxt.substring(lastLoginTimeTxt.indexOf("Last log on: ") + "Last log on: ".length(), lastLoginTimeTxt.indexOf("(") - 1);
        System.out.println("lastLoginTime:"+lastLoginTime);
        // 10 Aug 2018, 02:31 pm
        String regEx = "^(0?[1-9]|[12][0-9]|3[01])[ ](Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)[ ](\\d+)[,][ ]([0-1][0-9]|[2][0-3])[:][0-5][0-9]( ?)(am|pm)$";
        Assert.assertTrue(lastLoginTime.matches(regEx));
    }

    public void checkToggleIsON() {
        sleep(100L);
        captureScreen();
        Assert.assertTrue(currentPage.getTouchIdOn().isExisted());
    }

    public void tapMenuXButton() {
        currentPage.getCloseBtn().click();
    }

    public void checkMenuIsClose() {
        sleep(200L);
        captureScreen();
        Assert.assertFalse(currentPage.getUserNameTxt().isVisible());
    }

    public void tapLeftBlank() {
        currentPage.getBgBtn().tapXY(10, 190);
    }

    public void gestureRight() {
        BaseWebElement menuListView = currentPage.getMenuListView();
        menuListView.scroll(ScrollDirection.RIGHT, 2000L);
    }

    public void checkIconHasMessage() {
        Assert.assertFalse(currentPage.getDocumentsCountTxt().getContent().isEmpty());
    }

    public void tapTouchIdToggle() {
        currentPage.getTouchIdOff().click();
    }

    public void checkIsHideDefinition() {
        sleep(200L);
        captureScreen();
        Assert.assertFalse(getGlossaryListContentTxt(1).isExisted());
    }

    public void checkItemLocation() {
        int lastX = getGlossaryListNameTxt(1).getRect().getX();
        int lastY = getGlossaryListNameTxt(1).getRect().getY();
        System.out.println("termx:" + termX);
        System.out.println("termy:" + termY);
        System.out.println("lastX:" + lastX);
        System.out.println("lastY:" + lastY);
        if ((this.termX - lastX >= -5 || this.termX - lastX <= 5) && (this.termY - lastY >= -5 || this.termY - lastY <= 5)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    public void tapTermAgain() {
        this.termX = getGlossaryListNameTxt(1).getRect().getX();
        this.termY = getGlossaryListNameTxt(1).getRect().getY();
        getGlossaryListNameTxt(1).click();
    }

    public void tapLastTermInScreen() {
        sleep(200L);
        int i = 0;
        BaseWebElement nextElement = getGlossaryListNameTxt(i);
        while (nextElement.isVisible()){
            i++;
            nextElement = getGlossaryListNameTxt(i);
        }

        BaseWebElement lastElement = getGlossaryListNameTxt(i - 1);
        this.lastTermIndex = i - 1;
        this.lastTermY = lastElement.getRect().getY();

        lastElement.click();
    }

    public void tapLastTerm(int num) {
        sleep(200L);
        String prefix = "glossary_main_table_head_name_label_";
        String suffix = "_0";
        BaseWebElement lastElement = null;
        for (int i = 0; i < num; i++) {
            String elementId = prefix + i + suffix;
            BaseWebElement element = new BaseWebElement(elementId);
            if (!element.isVisible()) {
                lastElement.click();
                if (driverConfig.getPlatform().equals(Platform.ANDROID)) {
                    currentPage.getGlossaryListView().scrollToItem(getGlossaryListNameTxt(20), ScrollDirection.UP);
                    element = new BaseWebElement(prefix + (num-1) + suffix);
                    i = num-1;
                }else {
                    lastElement.click();
                    lastElement = element;
                }
                if (i == num-1){
                    this.lastTermY = element.getRect().getY();
                    sleep(300L);
                    element.click();
                }
            }
            else {
                lastElement = element;
            }
        }
    }

    public void checkLastDefinition() {
        sleep(200L);
        captureScreen();
        Assert.assertTrue(getGlossaryListContentTxt(lastTermIndex).isDisplayed());
    }

    public void checkLastTermLocation() {
        sleep(200L);
        captureScreen();
        int lastY = getGlossaryListNameTxt(20).getRect().getY();
        if (this.lastTermY <= lastY) {
            Assert.assertTrue(false);
        }
    }

    public void tapGlossaryBackBtn() {
        currentPage.getGlossaryBackBtn().click();
    }

    public void tapKRCBtn() {
        if (!currentPage.getKrcTxt().isVisible())
            currentPage.getMenuListView().scroll(ScrollDirection.UP, 1000L, 500);
        currentPage.getKrcTxt().click();
    }

    public void checkKRCUI(Map<String, String> map) {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(currentPage.getKrcBackBtn().isVisible());
        Assert.assertEquals(map.get("head title label"), currentPage.getKrcTitleTxt().getContent());
        Assert.assertTrue(currentPage.getKrcBgImg().isExisted());
        String bgTxt = currentPage.getKrcBgTxt().getContent();
        if (bgTxt.contains("  ")) {
            bgTxt = bgTxt.replaceAll("  ", " ");
        }
        Assert.assertEquals(map.get("Background image text"), bgTxt.replaceAll("\n", ""));
        Assert.assertTrue(currentPage.getKrcExclusiveImg().isExisted());
        Assert.assertEquals(map.get("exclusive label"), currentPage.getKrcExclusiveTxt().getContent());
        Assert.assertTrue(currentPage.getKrcCommentImg().isExisted());
        Assert.assertEquals(map.get("comment label"), currentPage.getKrcCommentTxt().getContent());
        Assert.assertTrue(currentPage.getKrcInvestmentImg().isExisted());
        Assert.assertEquals(map.get("investment label"), currentPage.getKrcInvestmentTxt().getContent());
        Assert.assertEquals(map.get("register label"), currentPage.getKrcRegisterTxt().getContent());
        if (!currentPage.getKrcFootTxt().isVisible()) {
            currentPage.getKrcBgImg().scroll(ScrollDirection.UP, 1000L, 500);
        }
        Assert.assertEquals(map.get("login button"), currentPage.getKrcLoginBtn().getContent());
        Assert.assertEquals(map.get("foot label"), currentPage.getKrcFootTxt().getContent());
    }

    public void tapKRCLoginBtn() {
        currentPage.getKrcLoginBtn().click();
    }

    public void checkKRCOverlayUI(Map<String, String> map) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(map.get("overlay title"), currentPage.getKrcOverlayTitleTxt().getContent());
        Assert.assertEquals(map.get("\"Don't show me again\" button"), currentPage.getKrcOverlayCheckTitle().getContent());
        Assert.assertEquals(map.get("\"OK\" button"), currentPage.getKrcOverlayOkBtn().getContent());
        if (driverConfig.getPlatform().equals(Platform.ANDROID)) {
            Assert.assertEquals(map.get("Android \"Cancel\" button"), currentPage.getKrcOverlayCancelBtn().getContent());
        } else {
            Assert.assertEquals(map.get("IOS \"Cancel\" button"), currentPage.getKrcOverlayCancelBtn().getContent());

        }
    }

    public void tapCancelBtn() {
        currentPage.getKrcOverlayCancelBtn().click();
    }

    public void remainOnKRCScreen() {
        System.out.println("visible: " + currentPage.getKrcTitleTxt().isVisible());
        Assert.assertTrue(currentPage.getKrcTitleTxt().isVisible());
    }

    public void checkOverlayIsClose() {
        System.out.println("visible: " + currentPage.getKrcOverlayTitleTxt().isVisible());
        Assert.assertFalse(currentPage.getKrcOverlayTitleTxt().isVisible());
    }

    public void tapAgainBtn() {
        currentPage.getKrcOverlayCheckOffBtn().click();
    }

    public void tapKRCBackBtn() {
        currentPage.getKrcBackBtn().click();
    }

    public void checkInMenu() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(currentPage.getUserNameTxt().isVisible());
    }

    public void onTheLoginPage() {
        sleep(300L);
        captureScreen();
        Assert.assertFalse(currentPage.getUserNameTxt().isExisted());
    }

    public void checkLegalSectionUI(Map<String, String> map) {
        sleep(500L);
        captureScreen();
        if (driverConfig.getPlatform().equals(Platform.IOS)) {
            Assert.assertEquals(map.get("ios content"), menuLegalPage.getContentTxt().getContent());
        } else {
            Assert.assertEquals(map.get("aos content"), menuLegalPage.getContentTxt().getContent().replaceAll("\n", " "));
        }
        Assert.assertEquals(map.get("back legal button"), menuLegalPage.getBackLegalBtn().getContent());
        Assert.assertEquals(map.get("title"), menuLegalPage.getTitleTxt().getContent());

    }

    public void checkLegalUI(Map<String, String> map) {
        Map<String, BaseWebElement> elementMap = menuLegalPage.getUniqueKeyElementsMap();
        for (String key : map.keySet()) {
            if (!key.equals("element name")) {
                System.out.println("get element: " + key);

                Assert.assertTrue("the element is not displayed: " + key, elementMap.get(key).isExisted());
                if (StringUtils.isNotBlank(map.get(key))) {
                    Assert.assertEquals("[" + key + "] check content fail", map.get(key), elementMap.get(key).getContent().replaceAll("\n", ""));
                }
            }
        }
    }

    public void tapBackButtonLegalSection() {
        menuLegalPage.getMainBackBtn().click();
    }

    public void checkMoreMenuContainer() {
        sleep(500L);
        captureScreen();
        if(!RegionUtil.isUK()){
            Assert.assertTrue(currentPage.getKrcTxt().isVisible());
        }
        Assert.assertTrue(currentPage.getGlossaryTxt().isVisible());
        Assert.assertTrue(currentPage.getHeadSecurityTxt().isVisible());
        Assert.assertTrue(currentPage.getFeedbackTxt().isVisible());
        Assert.assertTrue(currentPage.getLegalTxt().isVisible());
    }

    public void tapTermsAndConditions() {
        menuLegalPage.getMainLegalList0().click();
    }

    public void tapBackLegalButton() {
        menuLegalPage.getBackLegalBtn().click();
    }

    public void checkLegalScreen() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(menuLegalPage.getTermsAndConditions().isExisted());
        Assert.assertTrue(menuLegalPage.getPrivacyPolicy().isExisted());
        Assert.assertTrue(menuLegalPage.getAccessibilityStatement().isExisted());
    }

    public void tapPrivacyPolicyLink() {
        getMainLegalList(1).click();
    }

    public void tapsAccessibilityStatementLink() {
        getMainLegalList(2).click();
    }

    public void onAccessibilityStatementPage() {
        Assert.assertEquals(menuLegalPage.getTitleTxt().getContent(), "Accessibility statement");
    }

    public void tapAccessibilityPageHyperlink() {
        menuLegalPage.getContentTxt().click();
    }

    public void checkNoShowMeAgainOverlay(String title) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(title, menuLegalPage.getAgainTitleTxt().getContent());
    }

    public void checkAccessibilityStatementCTA(String overlayContent) {
        if (overlayContent.equals("Don’t show me again")) {
            Assert.assertEquals(overlayContent, menuLegalPage.getAgainCheckboxTitle().getContent());
        } else if (overlayContent.equals("OK")) {
            Assert.assertEquals(overlayContent, menuLegalPage.getAgainOkBtn().getContent());
        } else if (overlayContent.equals("Cancel")) {
            Assert.assertEquals(overlayContent, menuLegalPage.getAgainCancelBtn().getContent());
        }

    }

    public void tapCancelOnAppleSAccessibilityPag() {
        menuLegalPage.getAgainCancelBtn().click();
    }

    public void accessibilityStatementWarningOverlayIsClosed() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(menuLegalPage.getAgainCancelBtn().isVisible());
        Assert.assertFalse(menuLegalPage.getAgainCheckboxTitle().isVisible());
        Assert.assertFalse(menuLegalPage.getAgainOffBtn().isVisible());
        Assert.assertFalse(menuLegalPage.getAgainOkBtn().isVisible());
        Assert.assertFalse(menuLegalPage.getAgainOnBtn().isVisible());
        Assert.assertFalse(menuLegalPage.getAgainTitleTxt().isVisible());
    }

    public void selectAccessibilityNoAgain() {
        menuLegalPage.getAgainOnBtn().click();
    }

    public void checkLastLoginInTime() {
        sleep(500L);
        captureScreen();
        String lastLoginTimeTxt = currentPage.getLastLoginTimeTxt().getContent();

        String lastLoginTime = lastLoginTimeTxt.substring(lastLoginTimeTxt.indexOf("Last log on: ") + "Last log on: ".length(), lastLoginTimeTxt.indexOf("(") - 1);

        String regEx = "^(0?[1-9]|[12][0-9]|3[01])[ ](Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)[ ](\\d+)[,][ ]([0-1][0-9]|[2][0-3])[:][0-5][0-9]( ?)(am|pm)$";

        Assert.assertTrue(lastLoginTime.matches(regEx));


    }

    public void checkMainLegalSectionUI(Map<String,String> map) {
        sleep(500L);
        captureScreen();
        checkLegalUI(map);
    }

    public void checkTermMessage(Map<String,String> map) {
        sleep(200L);
        captureScreen();
        String prefix = "glossary_main_table_head_name_label_";
        String suffix = "_0";
        String textPrefix = "glossary_main_table_cell_content_label_";
        String textSuffix = "_0";
        String key = "";
        String elementId = "";
        String contextElementId = "";
        System.out.println("map size:--->"+map.size());
        for (int i = 0; i < map.size()-3; i++) {
            elementId = prefix + i + suffix;
            System.out.println("check "+elementId+" context.");
            contextElementId = textPrefix + i + textSuffix;
            sleep(500L);
            new BaseWebElement(elementId).click();
            key = "Glossary of terms"+i;
            if (driverConfig.getPlatform().equals(Platform.ANDROID) && (i == 3 || i==11 )){
                key = "AOSGlossary of terms"+i;
                Assert.assertEquals(map.get(key).trim(),new BaseWebElement(contextElementId).getContent().trim());
            }else {
                Assert.assertEquals(map.get(key).trim(), new BaseWebElement(contextElementId).getContent().trim());
            }sleep(500L);
            new BaseWebElement(elementId).click();
        }
    }

    public void notSeeKRC() {
        sleep(300L);
        captureScreen();
        Assert.assertFalse(currentPage.getKrcTxt().isVisible());
    }

    public void tapDocumentsBtn() {
        currentPage.getDocumentsTxt().click();
        sleep(1500L);
    }

    public void onTheMenuPage() {
        Assert.assertTrue(currentPage.getLastLoginTimeTxt().isVisible());
    }

    public void onTheGlossaryOfTerms() {
        Assert.assertTrue(currentPage.getGlossaryBackBtn().isVisible());
    }

    public void checkOnTheKRCPage() {
        Assert.assertTrue(currentPage.getKrcBackBtn().isVisible());
    }

    public void checkTheOverlayOfLoginCTAAtTheKRCWebsitePage() {
        Assert.assertTrue(currentPage.getKrcOverlayTitleTxt().isVisible());
    }

    public void checkTheLegalSection() {
        Assert.assertTrue(menuLegalPage.getMainBackBtn().isVisible());
    }

    public void checkBackLegalBtn() {
        Assert.assertTrue(menuLegalPage.getBackLegalBtn().isVisible());
    }

    public void checkMenuUserName(String userName) {
        sleep(200L);
        captureScreen();
        Assert.assertEquals(userName, currentPage.getUserNameTxt().getContent());
    }

    public void checkSecuritySubMenu() {
        sleep(200L);
        captureScreen();
        Assert.assertTrue(menuLegalPage.getSecurityTips().isVisible());
    }

    public void tapSecurityTips() {
        sleep(200L);
        captureScreen();
        menuLegalPage.getSecurityTips().click();
    }

    public void viewSecurityTipsScreen() {
        Assert.assertTrue(menuLegalPage.getBackLegalBtn().isVisible());
    }

    public void checkLegalSubMenu(Map<String, String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertEquals(map.get("Terms and Conditions"), menuLegalPage.getTermsAndConditions().getContent());
        Assert.assertEquals(map.get("Privacy Policy"), menuLegalPage.getPrivacyPolicy().getContent());
        Assert.assertEquals(map.get("Accessibility Statement"), menuLegalPage.getAccessibilityStatement().getContent());
        Assert.assertEquals(map.get("Security Tips"), menuLegalPage.getSecurityTips().getContent());
    }

    public void checkSecurityTipsTitle() {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(menuLegalPage.getMainTitle().isVisible());
    }

    public void checkPrivacyPolicyTitle(String title) {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(menuLegalPage.getTitleTxt().isVisible());
        Assert.assertEquals(title, menuLegalPage.getMainTitle().getContent());
    }

    public void checkTermsOfServiceValue(String value) {
        sleep(200L);
        captureScreen();
        Assert.assertEquals(value, menuLegalPage.getTermsAndConditions().getContent());
    }

    public void tapTermsOfService() {
        menuLegalPage.getTermsAndConditions().click();
    }

    public void checkTermsOfConditionsTab(String value) {
        sleep(200L);
        captureScreen();
        Assert.assertEquals(value, menuLegalPage.getTermsAndConditionsTabTxt().getContent());
    }

    public void checkTermsOfUseTab(String value) {
        Assert.assertEquals(value, menuLegalPage.getTermOfUseTabTxt().getContent());
    }

    public BaseWebElement getGlossaryListNameTxt(int index) {
        return currentPage.getElementById("glossary_main_table_head_name_label_"+ index +"_0");
    }

    public BaseWebElement getGlossaryListContentTxt(int index) {
        return currentPage.getElementById("glossary_main_table_cell_content_label_"+ index +"_0");
    }

    private BaseWebElement getMainLegalList(int index) {
        return menuLegalPage.getElementById("legal_main_tabelview_cell_" + index);
    }

    //create by yippee
    public void tapOnCancelBtnLogout() {
        if(driverConfig.getPlatform().equals(Platform.IOS)){
            currentPage.getCancelBtn().click();
        } else {
            currentPage.getAosCancelBtn().click();
        }
    }
    public void tapOnlogoutBtn()
    {
        sleep(500l);
        currentPage.getLogoutBtn().click();
        captureScreen();

    }

    public void slideToGlossaryBottom() {
        currentPage.getGlossaryListView().scrollToBottomItem(currentPage.getGlossaryFootMessageTxt());
    }

    public void checkGlossaryDisclaimerMessage(Map<String, String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertEquals(map.get("disclaimer message"), currentPage.getGlossaryFootMessageTxt().getContent().trim());
    }
}
