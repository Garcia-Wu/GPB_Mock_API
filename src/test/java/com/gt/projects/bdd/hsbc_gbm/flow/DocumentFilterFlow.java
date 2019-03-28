package com.gt.projects.bdd.hsbc_gbm.flow;

import com.gt.projects.bdd.base.BaseFlow;
import com.gt.projects.bdd.base.BaseWebElement;
import com.gt.projects.bdd.base.config.DriverConfig;
import com.gt.projects.bdd.base.enums.Platform;
import com.gt.projects.bdd.base.enums.ScrollDirection;
import com.gt.projects.bdd.hsbc_gbm.page.DocumentFilterPage;
import com.gt.projects.bdd.hsbc_gbm.page.DocumentPage;
import com.gt.projects.bdd.hsbc_gbm.util.UserProfileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Scope("thread")
public class DocumentFilterFlow extends BaseFlow<DocumentFilterPage> {

    @Autowired
    private DocumentFilterPage documentFilterPage;

    @Autowired
    private DocumentFlow documentFlow;

    @Autowired
    private DocumentPage documentPage;

    @Autowired
    private DriverConfig driverConfig;

    private Map<String, Object> elementState = new HashMap<>();

    protected DocumentFilterFlow(DocumentFilterPage currentPage) {
        super(currentPage);
    }

    public BaseWebElement getAccountName(int accountNum){
        if(UserProfileUtil.getCurrentUserProfile().getDocumentAccountNum() == 1){
            accountNum = 0;
        }
        String prefix = "document_filter_tableview_cell_title_label_";
        if(driverConfig.getPlatform().equals(Platform.ANDROID)){
            prefix += "_";
        }
        return new BaseWebElement(prefix + "0_" + accountNum);
    }

    public BaseWebElement getAccountFilterBtn(int accountNum){
        if(UserProfileUtil.getCurrentUserProfile().getDocumentAccountNum() == 1){
            accountNum = 0;
        }
        return new BaseWebElement("document_filter_tableview_cell_switch_0_"+accountNum);
    }

    public BaseWebElement getCategoryName(int categoryNum){
        return new BaseWebElement("document_filter_tableview_cell_title_label_1_"+categoryNum);
    }

    public BaseWebElement getCategoryFilterBtn(int categoryNum){
        return new BaseWebElement("document_filter_tableview_cell_switch_1_"+categoryNum);
    }

    public void checkDisplayAccount() {
        sleep(500L);
        if(UserProfileUtil.getCurrentUserProfile().getDocumentAccountNum() > 1){
            if(!getAccountName(1).isVisible()){
                currentPage.getAccountHeaderTxt().click();
            }
        } else {
            if(!getAccountName(0).isVisible()){
                currentPage.getAccountHeaderTxt().click();
            }
        }

        sleep(500L);
        captureScreen();
        int totalNum = UserProfileUtil.getCurrentUserProfile().getDocumentAccountNum();
        for(int i = 1; i <= totalNum; i++){
            Assert.assertTrue(getAccountName(i).isVisible());
        }
    }

    public void checkAccountHeader(String headerValue) {
        Assert.assertEquals(headerValue, currentPage.getAccountHeaderTxt().getContent());
    }

    public void tapFilterHeader(String headerValue) {
        if(headerValue.equalsIgnoreCase("Account")){
            currentPage.getAccountHeaderTxt().click();
        } else {
            currentPage.getCategoryHeaderTxt().click();
        }
    }

    public void seeCategories() {
        if(driverConfig.getPlatform().equals(Platform.ANDROID)){
            if(!getCategoryName(2).isVisible()){
                currentPage.getCategoryHeaderTxt().click();
            }
            Assert.assertTrue(getCategoryName(2).isVisible());
        }
    }

    public void slipDownTheAccounts() {
        if(driverConfig.getPlatform().equals(Platform.ANDROID)){
            currentPage.getTableView().scrollToItem(currentPage.getCategoryHeaderTxt(), ScrollDirection.UP);
        }
    }

    public void tapCloseButton() {
        currentPage.getCloseBtn().click();

        // temp for aos ObjectID error
        if(driverConfig.getPlatform().equals(Platform.ANDROID)){
            currentPage.getTitleTxt().click();
        }
    }

    public void tapFirstAccount() {
        List<String> accountNames = new ArrayList<>();
        int accountNum = UserProfileUtil.getCurrentUserProfile().getDocumentAccountNum();
        this.getAccountFilterBtn(1).click();
        for (int i = 2; i <= accountNum; i++){
            accountNames.add(this.getAccountName(i).getContent());
        }
        elementState.put("FilterAccounts", accountNames);
    }

    public void filterAccount() {
        sleep(5000L);
        captureScreen();
        int dateIndex = 0;
        BaseWebElement dateElement = documentFlow.getDateHeader(dateIndex);
        while (dateElement.isVisible()){

            // find and check the subDocument
            int subDocumentIndex = 0;
            BaseWebElement subDocumentAccount = documentFlow.getSubDocumentAccountName(dateIndex, subDocumentIndex);
            while (subDocumentAccount.isVisible()){
                this.assertAccountName(subDocumentAccount.getContent());
                subDocumentIndex++;
                subDocumentAccount = documentFlow.getSubDocumentAccountName(dateIndex, subDocumentIndex);
                if(!subDocumentAccount.isVisible()){
                    System.out.println("Find sub document: {"+dateIndex+"} ["+subDocumentIndex+"]");
                    documentPage.getListView().scroll(ScrollDirection.UP, 1000L,200);
                }
            }

            // find next date header
            dateIndex++;
            dateElement = documentFlow.getDateHeader(dateIndex);
            if(!dateElement.isVisible()){
                System.out.println("Find date document: {"+dateIndex+"}");
                documentPage.getListView().scroll(ScrollDirection.UP, 1000L,200);
            }
        }
    }

    private void assertAccountName(String accountName) {
        List<String> accountNames = (List<String>) elementState.get("FilterAccounts");
        boolean find = false;
        for (String name : accountNames) {
            if(name.equals(accountName)){
                find = true;
                break;
            }
        }
        Assert.assertTrue("AccountName not in active account filter: ["+ accountName +"]", find);
    }

    public void checkFilterApplied(String filterValue) {
        String content = documentPage.getFilterBtn().getContent().trim();
        if(filterValue.equalsIgnoreCase("Filter")){
            content = content.replaceAll(" ","");
        }
        Assert.assertEquals(filterValue, content);
    }

    public void tapAccountNoneBtn() {
        currentPage.getAccountNoneBtn().click();
    }

    public void checkUnreadNoDocumentMessage(Map<String, String> map) {
        sleep(500L);
        captureScreen();
        if(driverConfig.getPlatform().equals(Platform.IOS)){
            Assert.assertEquals(map.get("top message") + map.get("bottom message"), documentPage.getNoDocumentTopMessageTxt().getContent().replaceAll("\n",""));
        } else {
            Assert.assertEquals(map.get("top message"), documentPage.getNoDocumentTopMessageTxt().getContent().trim());
            Assert.assertEquals(map.get("bottom message"), documentPage.getNoDocumentBottomMessageTxt().getContent().trim());
        }
    }

    public void tapFilterToOnlyNoHasDocumentAccount() {
        // mock temp
        this.getAccountFilterBtn(2).click();
        this.getAccountFilterBtn(3).click();
    }

    public void checkNoAccountMessage(Map<String, String> map) {
        sleep(500L);
        captureScreen();
        if(driverConfig.getPlatform().equals(Platform.IOS)){
            Assert.assertEquals(map.get("tip message"), currentPage.getIosNoAccountMessage().getContent().trim());
        } else {
            Assert.assertEquals(map.get("tip message"), currentPage.getHeadSubTitleTxt0().getContent().trim());
        }
    }

    public void checkNoAccountFilter() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(currentPage.getAccountAllBtn().isVisible());
        Assert.assertFalse(currentPage.getAccountNoneBtn().isVisible());
    }

    public void checkAccountListExpand() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(this.getAccountName(1).isVisible());
    }

    public void checkSeeAllAccountName() {
        int accountNum = UserProfileUtil.getCurrentUserProfile().getDocumentAccountNum();
        for (int i = 1; i <= accountNum; i++){
            Assert.assertTrue("Account ["+i+"] no display!", this.getAccountName(i).isVisible());
        }
    }

    public void checkAccountListCollapse() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(this.getAccountName(1).isVisible());
    }

    public void onTheDocumentFilter() {
        Assert.assertTrue(currentPage.getCloseBtn().isVisible());
    }

    public void noShowAllAccount() {
        sleep(500L);
        captureScreen();
        int accountNum = UserProfileUtil.getCurrentUserProfile().getDocumentAccountNum();
        for (int i = 1; i <= accountNum; i++){
            Assert.assertFalse(this.getAccountName(i).isVisible());
        }
    }

    public void expandAccountFilter() {
        if(!this.getAccountName(1).isVisible()){
            currentPage.getAccountHeaderTxt().click();
        }
    }

    public void collapseAccountFilter() {
        if(this.getAccountName(1).isVisible()){
            currentPage.getAccountHeaderTxt().click();
        }
    }
}
