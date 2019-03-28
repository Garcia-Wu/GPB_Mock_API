package com.gt.projects.bdd.hsbc_gbm.flow;

import com.gt.projects.bdd.base.BaseFlow;
import com.gt.projects.bdd.base.BaseWebElement;
import com.gt.projects.bdd.base.enums.ScrollDirection;
import com.gt.projects.bdd.hsbc_gbm.page.DocumentPage;
import com.gt.projects.bdd.hsbc_gbm.util.CheckUtil;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import java.util.Map;

@Component
@Scope("thread")
public class DocumentFlow extends BaseFlow<DocumentPage> {

    private int unReadCount;

    private int categoryDateIndex;
    private int categoryDocumentIndex;

    private int moreThanNineDateIndex;
    private int lessThanTenDateIndex;

    protected DocumentFlow(DocumentPage currentPage) {
        super(currentPage);
    }

    public void checkSeeDocuments() {
        Assert.assertTrue(currentPage.getListView().isVisible());
    }

    public void tapBackButton() {
        currentPage.getBackBtn().click();
    }

    public void checkDocumentFilter(Map<String, String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertEquals(map.get("All tab"), currentPage.getAllBtn().getContent());
        String unreadValue = currentPage.getUnreadBtn().getContent();
        if(unreadValue.contains("(")){
            unreadValue = unreadValue.substring(0, unreadValue.indexOf("(")).trim();
        }
        String flaggedValue = currentPage.getFlaggedBtn().getContent();
        if(flaggedValue.contains("(")){
            flaggedValue = flaggedValue.substring(0, flaggedValue.indexOf("(")).trim();
        }
        Assert.assertEquals(map.get("Unread tab"), unreadValue);
        Assert.assertEquals(map.get("Flagged tab"), flaggedValue);
    }

    public void checkAllDocuments() {
        checkSeeDocuments();
    }

    public void slipBottomDocumentList() {
        currentPage.getListView().scrollToBottomItem(currentPage.getFootTxt());
    }

    public void seeDisclaimer(Map<String, String> map) {
        sleep(300L);
        captureScreen();
        assertIsDisplayed(map);
    }

    public void tapUnreadTab() {
        currentPage.getUnreadBtn().click();
    }

    public void checkUnreadNumber() {
        sleep(200L);
        captureScreen();
        String unRead = currentPage.getUnreadBtn().getContent();
        String count = unRead.substring(unRead.indexOf("(") + 1, unRead.indexOf(")"));
        String numberRegex = "^(\\d+)$";
        Assert.assertTrue(count.matches(numberRegex));
    }

    public void clickUnreadDocument() {
        String unRead = currentPage.getUnreadBtn().getContent();
        String count = unRead.substring(unRead.indexOf("(") + 1, unRead.indexOf(")"));
        unReadCount = Integer.valueOf(count);
        currentPage.getDocumentCell0().click();
    }

    public void checkUnReadCount() {
        sleep(500L);
        captureScreen();
        String unRead = currentPage.getUnreadBtn().getContent();
        System.out.println("unRead: "+unRead);
        String count = unRead.substring(unRead.indexOf("(") + 1, unRead.indexOf(")"));
        System.out.println("count: "+count);
        Assert.assertTrue((unReadCount - 1) == Integer.valueOf(count));
    }

    public void slipToCategoryItem(String category) {
//        if(category.equals("Advice")){
//            currentPage.getListView().scrollToItem(currentPage.getCategory00(), ScrollDirection.UP);
//        } else if (category.equals("Communication")){
//            currentPage.getListView().scrollToItem(currentPage.getSize10(), ScrollDirection.UP);
//        } else if (category.equals("Statement")){
//            currentPage.getListView().scrollToItem(currentPage.getSize12(), ScrollDirection.UP);
//        }

        int dateIndex = 0;
        BaseWebElement dateElement = this.getDateHeader(dateIndex);
        while (dateElement.isVisible()){

            // find the subDocument
            int subDocumentIndex = 0;
            BaseWebElement subDocumentCategories = this.getSubDocumentCategories(dateIndex, subDocumentIndex);
            while (subDocumentCategories.isVisible()){

                // save the index
                if(subDocumentCategories.getContent().contains(category)){
                    System.out.println("Find in categories: "+subDocumentCategories.getContent());
                    categoryDateIndex = dateIndex;
                    categoryDocumentIndex = subDocumentIndex;
                    return;
                }

                subDocumentIndex++;
                subDocumentCategories = this.getSubDocumentCategories(dateIndex, subDocumentIndex);
                if(!subDocumentCategories.isVisible()){
                    System.out.println("Find subDocumentCategories: {"+dateIndex+"} ["+subDocumentIndex+"]");
                    currentPage.getListView().scroll(ScrollDirection.UP, 1000L,200);
                }
            }

            // find next date header
            dateIndex++;
            dateElement = this.getDateHeader(dateIndex);
            if(!dateElement.isVisible()){
                System.out.println("Find date document: {"+dateIndex+"}");
                currentPage.getListView().scroll(ScrollDirection.UP, 1000L,200);
            }
        }
        System.out.println("category not find: " + category);
    }

    public void checkAdviceDocumentUI(Map<String, String> map) {
        sleep(300L);
        captureScreen();
        String categorys = getSubDocumentCategories(categoryDateIndex, categoryDocumentIndex).getContent();
        String category = categorys.substring(0, categorys.indexOf("-")).trim();
//        String subCategory = categorys.substring(categorys.indexOf("-") + 1).trim();
        Assert.assertEquals(map.get("Document category value"), category);
//        Assert.assertEquals(map.get("Document sub-category value"), subCategory);
        Assert.assertTrue(getSubDocumentName(categoryDateIndex, categoryDocumentIndex).isVisible());
        Assert.assertTrue(getSubDocumentAccountName(categoryDateIndex, categoryDocumentIndex).isVisible());
        Assert.assertTrue(getSubDocumentSize(categoryDateIndex, categoryDocumentIndex).isVisible() && getSubDocumentSize(categoryDateIndex, categoryDocumentIndex).getContent().endsWith("mb"));
    }

    public void checkCommunicationDocumentUI(Map<String, String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertEquals(map.get("Document sub-category value"), currentPage.getCategory10().getContent());
        Assert.assertTrue(getSubDocumentName(categoryDateIndex, categoryDocumentIndex).isVisible());
        Assert.assertTrue(getSubDocumentAccountName(categoryDateIndex, categoryDocumentIndex).isVisible());
        Assert.assertTrue(getSubDocumentSize(categoryDateIndex, categoryDocumentIndex).isVisible() && getSubDocumentSize(categoryDateIndex, categoryDocumentIndex).getContent().endsWith("mb"));
    }

    public void checkNotCategory() {
        Assert.assertFalse(currentPage.getCategory10().getContent().contains("-"));
    }

    public void checkStatementDocumentUI(Map<String, String> map) {
        sleep(300L);
        captureScreen();
        String categorys = getSubDocumentCategories(categoryDateIndex, categoryDocumentIndex).getContent();
        String category = categorys.substring(0, categorys.indexOf("-")).trim();
//        String subCategory = categorys.substring(categorys.indexOf("-") + 1).trim();
        Assert.assertEquals(map.get("Document category value"), category);
//        Assert.assertEquals(map.get("Document sub-category value"), subCategory);
        Assert.assertTrue(getSubDocumentName(categoryDateIndex, categoryDocumentIndex).isVisible());
        Assert.assertTrue(getSubDocumentAccountName(categoryDateIndex, categoryDocumentIndex).isVisible());
        Assert.assertTrue(getSubDocumentSize(categoryDateIndex, categoryDocumentIndex).isVisible() && getSubDocumentSize(categoryDateIndex, categoryDocumentIndex).getContent().endsWith("mb"));
    }

    public void checkDocumentSize() {
        sleep(300L);
        captureScreen();
        String size = currentPage.getSize00().getContent();
        String oneDpRegex = "^[0-9]+.[0-9]{1}$";
        Assert.assertTrue(size.substring(0, size.indexOf("m")).matches(oneDpRegex));
    }

    public void checkDateGreaterThanNine() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkTwoDayFormat(this.getDateHeader(moreThanNineDateIndex).getContent());
    }

    public void checkDateLessThanTen() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkOneDayFormat(this.getDateHeader(lessThanTenDateIndex).getContent());
    }

    public void tapDocumentFilter() {
        currentPage.getFilterBtn().click();
        sleep(1500L);
    }

    public BaseWebElement getDateHeader(int index){
        return new BaseWebElement("document_list_taleview_head_date_label_" + index);
    }

    public BaseWebElement getSubDocumentAccountName(int dateIndex, int subDocumentIndex){
        return new BaseWebElement("document_list_tableview_account_name_label_"+ dateIndex +"_" + subDocumentIndex);
    }

    private BaseWebElement getSubDocumentCategories(int dateIndex, int subDocumentIndex) {
        return new BaseWebElement("document_list_tableview_category_label_" + dateIndex + "_" + subDocumentIndex);
    }

    private BaseWebElement getSubDocumentName(int dateIndex, int subDocumentIndex) {
        return new BaseWebElement("document_list_tableview_name_label_" + dateIndex + "_" + subDocumentIndex);
    }

    private BaseWebElement getSubDocumentSize(int dateIndex, int subDocumentIndex) {
        return new BaseWebElement("document_list_tableview_size_label_" + dateIndex + "_" + subDocumentIndex);
    }

    public void tapFlaggedFilter() {
        currentPage.getFlaggedBtn().click();
    }

    public void checkInDocument() {
        Assert.assertTrue(currentPage.getTitleTxt().isVisible());
    }

    public void tapAllFilter() {
        currentPage.getAllBtn().click();
    }

    public void noDocumentDisplay() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(currentPage.getListView().isVisible());
    }

    public void exitDocumentScreen() {
        currentPage.getBackBtn().click();
    }

    public void checkHasDocument() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(currentPage.getListView().isVisible());
    }

    public void slipToDayMoreThanNine() {
        int dateIndex = 0;
        BaseWebElement dateElement = this.getDateHeader(dateIndex);
        while (dateElement.isVisible()){
            Integer day = Integer.valueOf(dateElement.getContent().substring(0, dateElement.getContent().indexOf(" ")).trim());
            if(day > 9){
                System.out.println("Find day > 9 element: "+dateElement.getContent());
                moreThanNineDateIndex = dateIndex;
                return;
            }

            dateIndex++;
            dateElement = this.getDateHeader(dateIndex);
            if(!dateElement.isVisible()){
                System.out.println("Find date document: {"+dateIndex+"}");
                currentPage.getListView().scroll(ScrollDirection.UP, 1000L,200);
            }
        }
        System.out.println("not find day > 9!!!!");
    }

    public void slipToDayLessThanTen() {
        int dateIndex = 0;
        BaseWebElement dateElement = this.getDateHeader(dateIndex);
        while (dateElement.isVisible()){
            Integer day = Integer.valueOf(dateElement.getContent().substring(0, dateElement.getContent().indexOf(" ")).trim());
            if(day < 10){
                System.out.println("Find day < 10 element: "+dateElement.getContent());
                lessThanTenDateIndex = dateIndex;
                return;
            }

            dateIndex++;
            dateElement = this.getDateHeader(dateIndex);
            if(!dateElement.isVisible()){
                System.out.println("Find date document: {"+dateIndex+"}");
                currentPage.getListView().scroll(ScrollDirection.UP, 1000L,200);
            }
        }
        System.out.println("not find day < 10!!!!");
    }
}
