package com.gt.projects.bdd.hsbc_gbm.flow;


import com.gt.projects.bdd.base.BaseFlow;
import com.gt.projects.bdd.base.BaseWebElement;
import com.gt.projects.bdd.base.config.DriverConfig;
import com.gt.projects.bdd.base.enums.Platform;
import com.gt.projects.bdd.base.enums.ScrollDirection;
import com.gt.projects.bdd.hsbc_gbm.page.AccountPage;
import com.gt.projects.bdd.hsbc_gbm.page.ContingentLiabilitiesPage;
import com.gt.projects.bdd.hsbc_gbm.page.PortfoliosPage;
import com.gt.projects.bdd.hsbc_gbm.util.CheckUtil;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
@Scope("thread")
public class ContingentLiabilitiesFlow extends BaseFlow<ContingentLiabilitiesPage> {

    @Autowired
    private AccountPage accountPage;

    @Autowired
    private PortfoliosPage portfoliosPage;

    @Autowired
    private DriverConfig driverConfig;

    protected ContingentLiabilitiesFlow(ContingentLiabilitiesPage currentPage) {
        super(currentPage);
    }

    private Map<String, String> ContingentLiabilitiesListElement = new HashMap<>();


    public void contingentLiabilitiesScreenHead(Map<String, String> map) {
        sleep(1500L);
        captureScreen();
        Assert.assertTrue(currentPage.getBackBtn().isDisplayed());
        Assert.assertTrue(currentPage.getTitleTxt().isDisplayed());
        Assert.assertTrue(currentPage.getTotalCommitmentsBtn().isDisplayed());
        Assert.assertTrue(currentPage.getTotalCommitmentsBtn().isDisplayed());
        Assert.assertTrue(currentPage.getTotalCommitmentsTxt().isDisplayed());

    }

    public void onContingentLiabilities() {


    }

    public void tapTotalCommitmentsRemainingValue() {
        currentPage.getTotalCommitmentsBtn().click();
    }

    public void onContingentLiabilitiesLevel(Map<String, String> map) {
        sleep(200L);
        captureScreen();
        Assert.assertEquals(currentPage.getPopTitleTxt().getContent(), map.get("Total commitment remaining label"));
        Assert.assertTrue(currentPage.getPopCodeTxt().isVisible());
        Assert.assertTrue(currentPage.getPopTotalAssetsTxt().isVisible());
        Assert.assertEquals(currentPage.getPopQuestionTxt().getContent().trim(), map.get("How is this calculated label"));
    }

    public void verify2dp() {
        sleep(200L);
        captureScreen();
        System.out.println("element:"+currentPage.getTotalCommitmentsBtn());
        System.out.println("element value:"+currentPage.getTotalCommitmentsBtn().getContent());
        String[] split = currentPage.getTotalCommitmentsBtn().getContent().split(" ");
        String[] split1 = split[0].split("\\.");
        Assert.assertTrue(split1[1].length() == 2);

    }

    public void iSO3CodeCurrencyForThePortfolios() {

        sleep(200L);
        captureScreen();
        String trim = currentPage.getTotalCommitmentsBtn().getContent().trim();
        String[] split = trim.split("\\.");
        String[] split1 = split[0].split(",");
        if (split1.length > 1) {
            for (int i = 1; i < split1.length; i++) {
                if (split1[i].length() == 3) {
                    continue;
                } else {
                    Assert.assertTrue(false);
                    return;
                }
            }
            Assert.assertTrue(true);
        }


    }

    public void checkTheContingentLiabilitiesList(Map<String, String> map) {
        sleep(200L);
        captureScreen();
        Assert.assertTrue(getListSubTitleTxt(0).getContent().equals(map.get("header")));
        Assert.assertTrue(getListTitleTxt(0).isExisted());
        Assert.assertTrue(getListWeightTxt(0).isExisted());
        Assert.assertTrue(getListAmountTxt(0).isExisted());
        Assert.assertTrue(getListCurrencyTxt(0).isExisted());
    }

    public void iSO3CodeCurrencyForContingentLiabilitiesList(Map<String, String> map) {
        sleep(200L);
        captureScreen();
        CheckUtil.checkDataFormat(getListAmountTxt(0).getContent().trim());
    }

    public void checkPercentageOfCommitmentRemainingContingentLiabilitiesList(Map<String, String> map) {
        sleep(200L);
        captureScreen();
        CheckUtil.checkLastPercentage(getListWeightTxt(0).getContent().trim());
    }

    public void check2dp() {
        sleep(200L);
        captureScreen();
        CheckUtil.checkPercentage2dp(getListWeightTxt(0).getContent().trim());
        CheckUtil.check2dp(getListAmountTxt(0).getContent().trim());
    }

    public void orderedByRemainingCommitment() {
        sleep(200L);
        captureScreen();
        this.checkNumberOrderByDesc(currentPage.getListView(), "portfolio_contingent_liabilities_list_tablecell_amount_label_", "_0", 0,7);

//        Double mountTxt0 = Check.stringToDouble(getListAmountTxt0().getContent().trim());
//        Double mountTxt1 = Check.stringToDouble(getListAmountTxt1().getContent().trim());
//        Double mountTxt2 = Check.stringToDouble(getListAmountTxt2().getContent().trim());
//
//        currentPage.getListView().scroll(ScrollDirection.UP,2000L);
//
//        Double mountTxt3 = Check.stringToDouble(getListAmountTxt3().getContent().trim());
//        Double mountTxt4 = Check.stringToDouble(getListAmountTxt4().getContent().trim());
//        Double mountTxt5 = Check.stringToDouble(getListAmountTxt5().getContent().trim());
//
//        currentPage.getListView().scroll(ScrollDirection.UP,2000L);
//
//        Double mountTxt6 = Check.stringToDouble(getListAmountTxt6().getContent().trim());
//        Double mountTxt7 = Check.stringToDouble(getListAmountTxt7().getContent().trim());
//        if (mountTxt0 <= mountTxt1 && mountTxt1 <= mountTxt2 && mountTxt2 <= mountTxt3 &&
//                mountTxt3 <= mountTxt4 && mountTxt4 <= mountTxt5 &&
//                mountTxt5 <= mountTxt6 && mountTxt6 <= mountTxt7 ) {
//            Assert.assertTrue(false);
//        }else {
//            Assert.assertTrue(true);
//        }

    }

    public void tapBackButton() {
        currentPage.getBackBtn().click();
    }

    public void tapFirstItemContingentLiabilitiesList() {
        ContingentLiabilitiesListElement.put("amount", getListAmountTxt(0).getContent());
        ContingentLiabilitiesListElement.put("currency", getListCurrencyTxt(0).getContent());
        ContingentLiabilitiesListElement.put("title", getListTitleTxt(0).getContent());
        ContingentLiabilitiesListElement.put("weight", getListWeightTxt(0).getContent());
        getListSubTitleTxt(0).click();
    }

    public void checkContingentLiabilitiesDetail(Map<String, String> map) {
        sleep(200L);
        captureScreen();
        Assert.assertTrue(currentPage.getDetailDescriptionTxt0().isDisplayed());
        Assert.assertTrue(currentPage.getDetailInitialTitleTxt0().isDisplayed());
        Assert.assertTrue(currentPage.getDetailInitialContentTxt0().isDisplayed());
        Assert.assertTrue(currentPage.getDetailInitialReportingTxt0().isDisplayed());

        Assert.assertTrue(currentPage.getDetailRemainingTitleTxt0().isDisplayed());
        Assert.assertTrue(currentPage.getDetailRemainingContentTxt0().isDisplayed());
        Assert.assertTrue(currentPage.getDetailRemainingPercentageTxt0().isDisplayed());
        Assert.assertTrue(currentPage.getDetailRemainingReportingTxt0().isDisplayed());
        captureScreen();
    }

    public void onContingentLiabilitiesDetailScreen() {


    }

    public void iSO3Check(String subject) {
        CheckUtil.checkDataFormat(subject);
    }

    public void iSO3codeBracket(String str) {
        CheckUtil.checkDataFormat(str);
    }


    public void checkPercentageOfCommitmentRemainingValue() {
        CheckUtil.checkLastPercentage(currentPage.getDetailRemainingPercentageTxt0().getContent().trim());
    }

    public void checkInitialCommitments2dp() {
        CheckUtil.check2dp(currentPage.getDetailInitialContentTxt0().getContent().trim());
    }

    public void checkRemainingCommitments2dp() {
        CheckUtil.check2dp(currentPage.getDetailRemainingContentTxt0().getContent().trim());
    }

    public void swipeLeft() {
        if(driverConfig.getPlatform().equals(Platform.ANDROID)){
            currentPage.getAosDetailView().scroll(ScrollDirection.LEFT, 1000L, 1000);
            currentPage.getAosDetailView().scroll(ScrollDirection.LEFT, 1000L, 1000);
        } else {
            this.swipeScreen(ScrollDirection.LEFT);
            this.swipeScreen(ScrollDirection.LEFT);
        }

    }

    public void swipeRight() {
        if(driverConfig.getPlatform().equals(Platform.ANDROID)){
            currentPage.getAosDetailView().scroll(ScrollDirection.RIGHT, 1000L, 1000);
            currentPage.getAosDetailView().scroll(ScrollDirection.RIGHT, 1000L, 1000);
        } else {
            this.swipeScreen(ScrollDirection.RIGHT);
            this.swipeScreen(ScrollDirection.RIGHT);
        }
    }

    public void checkContingentLiabilitiesDetailAsUserC(Map<String, String> map) {
        Assert.assertTrue(currentPage.getDetailDescriptionTxt0().isDisplayed());
        Assert.assertTrue(currentPage.getDetailInitialTitleTxt0().isDisplayed());
        Assert.assertTrue(currentPage.getDetailInitialContentTxt0().isDisplayed());

        Assert.assertTrue(currentPage.getDetailRemainingTitleTxt0().isDisplayed());
        Assert.assertTrue(currentPage.getDetailRemainingContentTxt0().isDisplayed());
        Assert.assertTrue(currentPage.getDetailRemainingPercentageTxt0().isDisplayed());
        captureScreen();
    }

    public void tapDetailBackButton() {
        currentPage.getDetailBackBtn().click();
    }


    public void onContingentLiabilitiesOverlayScreen() {

    }

    public void tapXButton() {
        currentPage.getPopCloseBtn().click();
    }

    public void shouldSeeInitialListView() {
        sleep(200L);
        captureScreen();
        boolean isVisible = currentPage.getListView().isVisible();
        Assert.assertTrue(isVisible);
    }

    public void tapGBButton() {
        currentPage.getPopGbBtn().tapXY(50,120);
    }

    public void onTheContingentLiabilitiesOverlay() {
        sleep(200L);
        captureScreen();
        Assert.assertTrue(currentPage.getPopCloseBtn().isExisted());
    }

    public void checkISO3codeAll() {
        sleep(200L);
        captureScreen();
        this.iSO3Check(currentPage.getDetailInitialContentTxt0().getContent().trim());
        this.iSO3codeBracket(currentPage.getDetailInitialReportingTxt0().getContent().trim());
        this.iSO3Check(currentPage.getDetailRemainingContentTxt0().getContent().trim());
        this.iSO3codeBracket(currentPage.getDetailRemainingReportingTxt0().getContent().trim());

    }

    public void check2DecimalPlaces(Map<String, String> map) {
        checkInitialCommitments2dp();
        checkRemainingCommitments2dp();
    }

    public void checkISO3CodeOther(Map<String, String> map) {
        this.iSO3Check(currentPage.getDetailInitialContentTxt0().getContent().trim());
        this.iSO3Check(currentPage.getDetailRemainingContentTxt0().getContent().trim());
    }

    public void scrollNextPage() {
        currentPage.getListView().scrollToItem(getListTitleTxt(7), ScrollDirection.UP);
    }

    public void tapEightItem() {
        getListTitleTxt(7).click();
    }

    public void saveControlState() {
        ContingentLiabilitiesListElement.clear();
        ContingentLiabilitiesListElement.put("Amount", getListAmountTxt(7).getContent());
        ContingentLiabilitiesListElement.put("Currency", getListCurrencyTxt(7).getContent());
        ContingentLiabilitiesListElement.put("Title", getListTitleTxt(7).getContent());
        ContingentLiabilitiesListElement.put("SubTitle", getListSubTitleTxt(7).getContent());
        ContingentLiabilitiesListElement.put("Weight", getListWeightTxt(7).getContent());
    }

    public void checkEightItem() {
        Assert.assertTrue(getListAmountTxt(7).getContent().equals(ContingentLiabilitiesListElement.get("Amount")));
        Assert.assertTrue(getListCurrencyTxt(7).getContent().equals(ContingentLiabilitiesListElement.get("Currency")));
        Assert.assertTrue(getListTitleTxt(7).getContent().equals(ContingentLiabilitiesListElement.get("Title")));
        Assert.assertTrue(getListSubTitleTxt(7).getContent().equals(ContingentLiabilitiesListElement.get("SubTitle")));
        Assert.assertTrue(getListWeightTxt(7).getContent().equals(ContingentLiabilitiesListElement.get("Weight")));

    }

    public void checkDateFormat() {
        String date = currentPage.getDetailInitialTitleTxt0().getContent();
        CheckUtil.checkSimpleMonthDateFormat(date);
    }

    public void checkElementNotDisplay() {
        Assert.assertFalse(currentPage.getDetailDescriptionTxt0().isExisted());
        Assert.assertFalse(currentPage.getDetailFootTxt0().isExisted());
        Assert.assertFalse(currentPage.getDetailInitialTitleTxt0().isExisted());
//        Assert.assertFalse(currentPage.getDetailPipsBar().isExisted());
        Assert.assertFalse(currentPage.getDetailRemainingContentTxt0().isExisted());
    }

    public void checkElementIsDisplay() {
        Assert.assertTrue(currentPage.getDetailDescriptionTxt0().isVisible());
        Assert.assertTrue(currentPage.getDetailInitialTitleTxt0().isVisible());
        Assert.assertTrue(currentPage.getDetailRemainingContentTxt0().isVisible());
        if(!currentPage.getDetailFootTxt0().isVisible()){
            currentPage.getAosDetailView().scroll(ScrollDirection.UP, 1000L, 1000);
        }
        Assert.assertTrue(currentPage.getDetailFootTxt0().isVisible());
//        if(driverConfig.getPlatform().equals(Platform.IOS)){
            Assert.assertTrue(currentPage.getDetailPipsBar().isVisible());
//        }
    }

    public void tapAnyItem() {
        ContingentLiabilitiesListElement.put("title",getListTitleTxt(1).getContent());
        ContingentLiabilitiesListElement.put("weight",getListWeightTxt(1).getContent());
        ContingentLiabilitiesListElement.put("currency",getListCurrencyTxt(1).getContent());
        ContingentLiabilitiesListElement.put("amount",getListAmountTxt(1).getContent());
        getListTitleTxt(1).click();
    }

    public void checkItemDetail() {
        sleep(200L);
        captureScreen();
        Assert.assertEquals(ContingentLiabilitiesListElement.get("title"), getDetailDescriptionTxt(1).getContent());
        Assert.assertEquals(ContingentLiabilitiesListElement.get("weight"), getDetailRemainingPercentageTxt(1).getContent());
        Assert.assertEquals(ContingentLiabilitiesListElement.get("currency"), getDetailRemainingCurrency(1).getContent());
        Assert.assertEquals(ContingentLiabilitiesListElement.get("amount"), getDetailRemainingContentTxt(1).getContent());
    }

    private BaseWebElement getDetailDescriptionTxt(int index) {
        return currentPage.getElementById("portfolio_contingent_liabilities_detail_description_label_"+index);
    }

    private BaseWebElement getDetailRemainingPercentageTxt(int index) {
        return currentPage.getElementById("portfolio_contingent_liabilities_detail_remaining_commitment_percentage_label_"+index);
    }

    private BaseWebElement getDetailRemainingCurrency(int index) {
        return currentPage.getElementById("portfolio_contingent_liabilities_detail_remaining_commitment_value_Currency_label_"+index);
    }

    private BaseWebElement getDetailRemainingContentTxt(int index) {
        return currentPage.getElementById("portfolio_contingent_liabilities_detail_remaining_commitment_value_label_"+index);
    }

    public void checkHasPortfolioList() {
        sleep(200L);
        Assert.assertTrue(accountPage.getPortfolioListView().isVisible());
    }

    public void clBackToPortfolioList() {
        currentPage.getDetailBackBtn().click();
        currentPage.getBackBtn().click();
        portfoliosPage.getMainBackBtn().click();
    }

    public void tapTheSecondItem() {
        getListTitleTxt(1).click();
    }

    public void slideToSixthItem() {
        currentPage.getDetailView().scroll(ScrollDirection.LEFT, 2000L);
        currentPage.getDetailView().scroll(ScrollDirection.LEFT, 2000L);
        currentPage.getDetailView().scroll(ScrollDirection.LEFT, 2000L);
        currentPage.getDetailView().scroll(ScrollDirection.LEFT, 2000L);
    }

    public void checkCanSeeSixthItem() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(getListTitleTxt(5).isVisible());
    }

    public void checkCanSeeFirstItemDetail() {
        sleep(200L);
        captureScreen();
        Assert.assertEquals(ContingentLiabilitiesListElement.get("title"), currentPage.getDetailDescriptionTxt0().getContent());
        Assert.assertEquals(ContingentLiabilitiesListElement.get("weight"), currentPage.getDetailRemainingPercentageTxt0().getContent());
        Assert.assertEquals(ContingentLiabilitiesListElement.get("currency"), currentPage.getDetailRemainingCurrency0().getContent());
        Assert.assertEquals(ContingentLiabilitiesListElement.get("amount"), currentPage.getDetailRemainingContentTxt0().getContent());
    }

    public void checkNotSeePips() {
        Assert.assertFalse(currentPage.getDetailPipsBar().isVisible());
    }

    public void checkDetailNotScroll() {
        currentPage.getDetailView().scroll(ScrollDirection.LEFT, 2000L);
        Assert.assertEquals(ContingentLiabilitiesListElement.get("title"), currentPage.getDetailDescriptionTxt0().getContent());
        Assert.assertEquals(ContingentLiabilitiesListElement.get("weight"), currentPage.getDetailRemainingPercentageTxt0().getContent());
        Assert.assertEquals(ContingentLiabilitiesListElement.get("currency"), currentPage.getDetailRemainingCurrency0().getContent());
        Assert.assertEquals(ContingentLiabilitiesListElement.get("amount"), currentPage.getDetailRemainingContentTxt0().getContent());
        currentPage.getDetailView().scroll(ScrollDirection.RIGHT, 2000L);
        Assert.assertEquals(ContingentLiabilitiesListElement.get("title"), currentPage.getDetailDescriptionTxt0().getContent());
        Assert.assertEquals(ContingentLiabilitiesListElement.get("weight"), currentPage.getDetailRemainingPercentageTxt0().getContent());
        Assert.assertEquals(ContingentLiabilitiesListElement.get("currency"), currentPage.getDetailRemainingCurrency0().getContent());
        Assert.assertEquals(ContingentLiabilitiesListElement.get("amount"), currentPage.getDetailRemainingContentTxt0().getContent());
    }

    public void clickDetailBackBtn() {
        currentPage.getDetailBackBtn().click();
    }

    public void clListToFifteenItem() {
        currentPage.getListView().scroll(ScrollDirection.UP,2000L);
        currentPage.getListView().scrollToItem(getListTitleTxt(12), ScrollDirection.UP);
    }

    public void scrollCLList() {
        currentPage.getListView().scroll(ScrollDirection.UP, 2000L);
    }

    public void checkNextFifteenItem() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(getListTitleTxt(12).isExisted());
    }

    public void tapCLBackBtn() {
        currentPage.getBackBtn().click();
    }

    public void checkInFirstList() {
        sleep(200L);
        captureScreen();
        Assert.assertTrue(getListTitleTxt(0).isExisted());
        Assert.assertTrue(getListTitleTxt(12).isExisted());
    }

    public void tapTwentyItem() {
        currentPage.getListView().scrollToItem(getListTitleTxt(12), ScrollDirection.UP);
        getListTitleTxt(12).click();
    }

    public void tapDetailBackBtn() {
        currentPage.getDetailBackBtn().click();
    }

    public void seeTransactionPreviouslyLoaded() {
        sleep(200L);
        captureScreen();
        Assert.assertTrue(getListTitleTxt(12).isExisted());
        //Assert.assertTrue(getListTitleTxt29().isExisted());
    }

    public void seeContingentLiabilitiesHasOne() {
        sleep(200L);
        captureScreen();
        Assert.assertTrue(getDetailDescriptionTxt(0).isVisible());
        Assert.assertFalse(getDetailDescriptionTxt(1).isVisible());
    }

    public void noPipsContingentLiabilities() {
        sleep(200L);
        Assert.assertFalse(currentPage.getDetailPipsBar().isVisible());
    }

    public void checkRight() {
        ContingentLiabilitiesListElement.put("DetailDescriptionTxt0",getDetailDescriptionTxt(0).getContent());
        if (driverConfig.getPlatform().equals(Platform.IOS)) {
            currentPage.getDetailView().scroll(ScrollDirection.RIGHT, 2000L);
        }else {
            currentPage.getAosDetailView().scroll(ScrollDirection.RIGHT, 2000L);
        }
        Assert.assertEquals(ContingentLiabilitiesListElement.get("DetailDescriptionTxt0"),getDetailDescriptionTxt(0).getContent());
    }

    private BaseWebElement getListTitleTxt(int index) {
        return currentPage.getElementById("portfolio_contingent_liabilities_list_tablecell_title_label_"+ index +"_0");
    }

    private BaseWebElement getListWeightTxt(int index) {
        return currentPage.getElementById("portfolio_contingent_liabilities_list_tablecell_weight_label_"+index+"_0");
    }

    private BaseWebElement getListSubTitleTxt(int index) {
        return currentPage.getElementById("portfolio_contingent_liabilities_list_tablecell_sub_title_label_"+index+"_0");
    }

    private BaseWebElement getListCurrencyTxt(int index) {
        return currentPage.getElementById("portfolio_contingent_liabilities_list_tablecell_currency_label_"+ index +"_0");
    }

    private BaseWebElement getListAmountTxt(int index) {
        return currentPage.getElementById("portfolio_contingent_liabilities_list_tablecell_amount_label_"+ index +"_0");
    }
}
