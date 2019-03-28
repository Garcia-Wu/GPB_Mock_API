package com.gt.projects.bdd.hsbc_gbm.flow;


import com.gt.projects.bdd.base.BaseFlow;
import com.gt.projects.bdd.base.BaseWebElement;
import com.gt.projects.bdd.base.enums.ScrollDirection;
import com.gt.projects.bdd.hsbc_gbm.page.*;
import com.gt.projects.bdd.base.config.DriverConfig;
import com.gt.projects.bdd.base.enums.Platform;
import com.gt.projects.bdd.hsbc_gbm.util.CheckUtil;
import com.gt.projects.bdd.hsbc_gbm.util.RegionUtil;
import com.gt.projects.bdd.hsbc_gbm.util.UserProfileUtil;
import cucumber.api.DataTable;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.Rectangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
@Scope("thread")
public class PortfoliosFlow extends BaseFlow<PortfoliosPage> {

    @Autowired
    private AccountPage accountPage;

    @Autowired
    private DriverConfig driverConfig;

    @Autowired
    private OverviewPage overviewPage;

    @Autowired
    private ContingentLiabilitiesPage contingentLiabilitiesPage;

    @Autowired
    private AllocationHoldingListPage allocationHoldingListPage;

    @Autowired
    private AllocationGraphicPage allocationGraphicPage;

    @Autowired
    private PerformancePage performancePage;

    @Autowired
    private LiabilitiesOverlayPage liabilitiesOverlayPage;

    @Autowired
    private GlobalOverlayPage globalOverlayPage;

    @Autowired
    private GlobalOverlayFlow globalOverlayFlow;

    @Autowired
    private ImportantPage importantPage;

    @Autowired
    private OverviewFlow overviewFlow;

    @Autowired
    private AccountsFlow accountsFlow;
    
    @Autowired
    private AllocationHoldingListFlow allocationHoldingListFlow;

    @Autowired
    private AllocationGraphicFlow allocationGraphicFlow;

    private Map<String, String> elementState = new HashMap<>();
    private int CoordsX;
    private int CoordsY;

    protected PortfoliosFlow(PortfoliosPage currentPage) {
        super(currentPage);
    }

    public void assertIsDisplayed(Map<String, String> map){
        Map<String, BaseWebElement> elementMap = currentPage.getUniqueKeyElementsMap();
        for (String key : map.keySet()) {
            if(!key.equals("element name")){
                System.out.println("get element: "+key);

                org.junit.Assert.assertTrue("the element is not existed: " + key, elementMap.get(key).isExisted());
                if(org.apache.commons.lang3.StringUtils.isNotBlank(map.get(key))){
                    org.junit.Assert.assertEquals("[" + key + "] check content fail", map.get(key).trim(), elementMap.get(key).getContent().replaceAll("\n","").trim());
                }
            }
        }
    }

    //Sprint 1 start
    public void tabAssetAllocation() {
//            currentPage.getAllocationBtnOn().click();
            Rectangle rectangle = currentPage.getAllocationBtnOn().getRect();
            currentPage.getAllocationBtnOn().tapXY(rectangle.getX(),rectangle.getY());

    }

    public void checkPortfoliosVersionUI(DataTable dataTable) {
        sleep(200L);
        captureScreen();
        if (currentPage.getMainTotalAssetsImg().isExisted()){
            Assert.assertTrue(currentPage.getMainTotalAssetsImg().isExisted());
        }
        if (currentPage.getMainTotalAssetsImg().isExisted()){
            Assert.assertTrue(currentPage.getMainTotalAssetsImg().isExisted());
        }
        sleep(100L);
        this.assertIsDisplayed(RegionUtil.getMap(dataTable));
    }

    public void checkPortfoliosUI(Map<String,String> map) {
        sleep(200L);
        captureScreen();
        if (currentPage.getMainTotalAssetsImg().isExisted()){
            Assert.assertTrue(currentPage.getMainTotalAssetsImg().isExisted());
        }
        if (currentPage.getMainTotalAssetsImg().isExisted()){
            Assert.assertTrue(currentPage.getMainTotalAssetsImg().isExisted());
        }
        sleep(100L);

        Assert.assertTrue(allocationGraphicFlow.getAllocationToggle().isExisted());
        this.assertIsDisplayed(map, "Allocation Toggle");
    }

    public void checkClassTabDataFormat() {
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        currentPage.getPortfolioClassView().scrollToItem(currentPage.getClassTitleTxt0(),ScrollDirection.DOWN);
        String[] titleName =  this.getDateList(currentPage.getPortfolioClassView(),"titleName",(num-1));
        currentPage.getPortfolioClassView().scrollToItem(currentPage.getClassTitleTxt0(),ScrollDirection.DOWN);

        String[] percentage = this.getDateList(currentPage.getPortfolioClassView(),"percentage",(num-1));
        currentPage.getPortfolioClassView().scrollToItem(currentPage.getClassTitleTxt0(),ScrollDirection.DOWN);

        String[] totalAmount = this.getDateList(currentPage.getPortfolioClassView(),"totalAmount",(num-1));

        if (titleName.length < num || percentage.length < num || totalAmount.length < num)
            Assert.assertTrue(false);

        for (int i = 0; i < num; i++){
            CheckUtil.checkPercentage(percentage[i]);
            CheckUtil.checkTotalAmount(totalAmount[i]);
        }
    }


    public void checkTotalDataOrder() {
        if (!currentPage.getSubClassTxt().isVisible()){
            currentPage.getPortfolioClassView().scrollToTopItem(currentPage.getSubClassTxt());
        }
        this.checkNumberOrderByDesc(currentPage.getPortfolioClassView(),"portfolios_class_list_tablecell_amount_label_","_0",1,5);
    }

    public void tapAccountsList4() {
        sleep(500L);
        overviewPage.getAccountListView().scrollToItem(overviewFlow.getAccountList(3),ScrollDirection.UP);
        overviewFlow.getAccountList(3).click();
    }

    public void tapPortfolioList16() {
        sleep(300L);
        accountPage.getPortfolioListView().scrollToItem(accountsFlow.getPortfolioList(15),ScrollDirection.UP);
        accountsFlow.getPortfolioList(15).click();
    }

    public void checkNotSeeClassList() {
        sleep(300L);
        captureScreen();
        Assert.assertFalse(currentPage.getPortfolioClassView().isVisible());
    }

    public void tapPortfolioShowSubAssetClass() {
        if (!currentPage.getSubClassTxt().isVisible()){
            currentPage.getPortfolioClassView().scrollToTopItem(currentPage.getSubClassTxt());
        }
        if (currentPage.getSubClassOnBtn().isVisible()) {
            currentPage.getSubClassOnBtn().click();
        }else {
            currentPage.getSubClassOffBtn().click();
        }
    }

    public void checkSubClassHeadDateFormat() {

        sleep( 500L);
        captureScreen();
        if (driverConfig.getPlatform().equals(Platform.IOS)){

            if (!currentPage.getClassTotalAmountTxt0().isVisible()){
                currentPage.getPortfolioClassView().scrollToTopItem(currentPage.getClassTotalAmountTxt0());
            }

            String[] subClassHeadTitle = this.getDateList(currentPage.getPortfolioClassView(),"titleName",4);
            currentPage.getPortfolioClassView().scrollToTopItem(currentPage.getClassTotalAmountTxt0());

            String[] subClassHeadCurrency = this.getDateList(currentPage.getPortfolioClassView(),"totalAmount",4);
            if (subClassHeadTitle.length < 5 || subClassHeadCurrency.length < 5)
                Assert.assertTrue(false);

            for (int i = 0; i < 5; i++){
                CheckUtil.checkTotalAmount(subClassHeadCurrency[i]);
            }
        }else {
            if (!currentPage.getSubClassHeadCurrencyTxt0().isVisible()){
                currentPage.getPortfolioClassView().scrollToTopItem(currentPage.getSubClassHeadCurrencyTxt0());
            }

            String[] subClassHeadTitle = this.getDateList(currentPage.getPortfolioClassView(),"subClassHeadTitle",4);
            currentPage.getPortfolioClassView().scrollToTopItem(currentPage.getSubClassHeadCurrencyTxt0());

            String[] subClassHeadCurrency = this.getDateList(currentPage.getPortfolioClassView(),"subClassHeadCurrency",4);
            if (subClassHeadTitle.length < 5 || subClassHeadCurrency.length < 5)
                Assert.assertTrue(false);

            for (int i = 0; i < 5; i++){
                CheckUtil.checkTotalAmount(subClassHeadCurrency[i]);
            }
        }
    }

    public void checkSubClassDateFormat() {

        sleep(200L);
        captureScreen();
        if (!currentPage.getSubClassTotalAssetTxt0().isVisible()){
            currentPage.getPortfolioClassView().scrollToTopItem(currentPage.getSubClassTotalAssetTxt0());
        }
        String[] subClassTotalAsset = this.getDateList(currentPage.getPortfolioClassView(),"subClassTotalAsset",4);
        currentPage.getPortfolioClassView().scrollToTopItem(currentPage.getSubClassTotalAssetTxt0());

        String[] subClassPercentage = this.getDateList(currentPage.getPortfolioClassView(),"subClassPercentage",4);
        currentPage.getPortfolioClassView().scrollToTopItem(currentPage.getSubClassTotalAssetTxt0());

        String[] subClassTotalAmount = this.getDateList(currentPage.getPortfolioClassView(),"subClassTotalAmount",4);

        if (subClassTotalAsset.length < 5 || subClassPercentage.length < 5 || subClassTotalAmount.length < 5)
            Assert.assertTrue(false);

        for (int i = 0; i < 5; i++){
            CheckUtil.checkPercentage(subClassPercentage[i]);
            CheckUtil.checkTotalAmount(subClassTotalAmount[i]);
        }


    }

    public void checkSubClassDataOrder() {
        sleep(200L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        currentPage.getPortfolioClassView().scrollToItem(currentPage.getSubClassTotalAssetTxt0(),ScrollDirection.DOWN);
        this.checkNumberOrderByDesc(currentPage.getPortfolioClassView(),"portfolios_subclass_list_tablecell_amount_label_1_",null,0,(num-1));
//        this.checkNumberOrderByDesc(currentPage.getPortfolioClassView(),"portfolios_subclass_list_tablecell_amount_label_2_",null,0,1);
//        this.checkNumberOrderByDesc(currentPage.getPortfolioClassView(),"portfolios_subclass_list_tablecell_amount_label_3_",null,0,0);
//        this.checkNumberOrderByDesc(currentPage.getPortfolioClassView(),"portfolios_subclass_list_tablecell_amount_label_4_",null,0,1);
//        this.checkNumberOrderByDesc(currentPage.getPortfolioClassView(),"portfolios_subclass_list_tablecell_amount_label_5_",null,0,2);
    }

    public void tapToAnotherPortfolioAccount() {
        currentPage.getAllocationBtnOn().click();
        currentPage.getMainBackBtn().click();
        accountPage.getMainBackBtn().click();
        sleep(20L);
        overviewFlow.getAccountList(1).click();
        accountsFlow.getPortfolioList(1).click();
        sleep(20L);
        currentPage.getAllocationBtnOff().click();
    }

    public void backToPortfolioLevel() {
        currentPage.getAllocationBtnOn().click();
        currentPage.getMainBackBtn().click();
        accountPage.getMainBackBtn().click();
        sleep(20L);
        overviewPage.getAccountList0().click();
        accountPage.getPortfolioList0().click();
        sleep(20L);
    }

    public void checkSubAssetClassON_OtherPortfolioAccount() {
//        currentPage.getAllocationBtnOff().click();
        sleep(200L);
        captureScreen();
        Assert.assertTrue(allocationGraphicPage.getAllocationBarKeyName0().isVisible());
    }

    public void checkPortfolioShowSubAssetClassIsOFF() {
        sleep(200L);
        captureScreen();
        Assert.assertTrue(currentPage.getSubClassOffBtn().isVisible());
    }

    public void checkTotalAssetEqualsTheSumOfAllTheSubAssetClass() {

        sleep(200L);
        captureScreen();

        String[] subClassHeadCurrency = new String[5];

        if (!currentPage.getSubClassTotalAssetTxt0().isVisible()){
            currentPage.getPortfolioClassView().scrollToTopItem(currentPage.getSubClassTotalAssetTxt0());
        }

        if (driverConfig.getPlatform().equals(Platform.IOS)) {

            subClassHeadCurrency = this.getDateList(currentPage.getPortfolioClassView(), "totalAmount", 4);
        }else {

            subClassHeadCurrency = this.getDateList(currentPage.getPortfolioClassView(),"subClassHeadCurrency",4);
        }

        currentPage.getPortfolioClassView().scrollToItem(currentPage.getSubClassTotalAssetTxt0(),ScrollDirection.DOWN);
        String[] subClassTotalAmount = this.getDateList(currentPage.getPortfolioClassView(),"subClassTotalAmount",10);

        Assert.assertTrue(CheckUtil.getNoISOAmount(subClassHeadCurrency[0]) ==
                CheckUtil.getNoISOAmount(subClassTotalAmount[0]) + CheckUtil.getNoISOAmount(subClassTotalAmount[1])+CheckUtil.getNoISOAmount(subClassTotalAmount[2]));

        Assert.assertTrue(CheckUtil.getNoISOAmount(subClassHeadCurrency[1]) ==
                CheckUtil.getNoISOAmount(subClassTotalAmount[3]) + CheckUtil.getNoISOAmount(subClassTotalAmount[4]));

        Assert.assertTrue(CheckUtil.getNoISOAmount(subClassHeadCurrency[2]) ==
                CheckUtil.getNoISOAmount(subClassTotalAmount[5]));

        Assert.assertTrue(CheckUtil.getNoISOAmount(subClassHeadCurrency[3]) ==
                CheckUtil.getNoISOAmount(subClassTotalAmount[6]) + CheckUtil.getNoISOAmount(subClassTotalAmount[7]));

        Assert.assertTrue(CheckUtil.getNoISOAmount(subClassHeadCurrency[4]) ==
                CheckUtil.getNoISOAmount(subClassTotalAmount[8]) + CheckUtil.getNoISOAmount(subClassTotalAmount[9])+CheckUtil.getNoISOAmount(subClassTotalAmount[10]));


    }



    public void tapsOnRegionTab() {
        currentPage.getAllocationRegionBtn().click();
    }

    public void checkPortfolioRegionDataFormat() {
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        sleep(200L);
        captureScreen();
        String[] regionTitleTxt = this.getDateList(currentPage.getPortfolioRegionListView(),"regionTitleTxt",(num-1));
        currentPage.getPortfolioRegionListView().scrollToItem(currentPage.getRegionPercentageTxt0(),ScrollDirection.DOWN);

        String[] regionPercentageTxt = this.getDateList(currentPage.getPortfolioRegionListView(),"regionPercentageTxt",(num-1));
        currentPage.getPortfolioRegionListView().scrollToItem(currentPage.getRegionTotalAmountTxt0(),ScrollDirection.DOWN);

        String[] regionTotalAmountTxt = this.getDateList(currentPage.getPortfolioRegionListView(),"regionTotalAmountTxt",(num-1));

        if (regionTitleTxt.length < num || regionPercentageTxt.length < num || regionTotalAmountTxt.length < num)
            Assert.assertTrue(false);

        for (int i = 0; i < num; i++){
            CheckUtil.checkPercentage(regionPercentageTxt[i]);
            CheckUtil.checkTotalAmount(regionTotalAmountTxt[i]);
        }

    }

    public void checkPortfolioRegionTotalAmountDataOrder() {
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        currentPage.getPortfolioRegionListView().scrollToItem(currentPage.getRegionTitleTxt0(),ScrollDirection.DOWN);
        this.checkNumberOrderByDesc(currentPage.getPortfolioRegionListView(),"portfolios_region_list_tablecell_amount_label_",null,0,(num-1));
    }

    public void checkNotSeeRegionList() {
        sleep(300L);
        captureScreen();
        Assert.assertFalse(currentPage.getPortfolioRegionListView().isVisible());
    }
    //Sprint 1 end



    public void onThePortfoliosScreen() {

        sleep(400l);
        captureScreen();
        Assert.assertTrue(currentPage.getMainBackBtn().isVisible());

    }

    public void notSeeContingentLiabilitiesTab() {
        sleep(200L);
        captureScreen();
        Assert.assertFalse(currentPage.getListContingentLiabilitiesArrowImg().isExisted());
    }

    public void noHoldingsClass(Map<String, String> map) {
        sleep(200L);
        captureScreen();
        Assert.assertEquals(map.get("class content"),currentPage.getClassUnavailableTitleTxt().getContent());

    }

    public void noHoldingsCurrency(Map<String, String> map) {
        sleep(200L);
        captureScreen();
        Assert.assertEquals(map.get("currency content"),currentPage.getCurrencyUnavailableContentTxt().getContent());

    }

    public void noHoldingsRegion(Map<String,String> map) {
        sleep(200L);
        captureScreen();
        Assert.assertEquals(map.get("region content"),currentPage.getRegionUnavailableTitleTxt().getContent());

    }

    public void portfolioScreenAndTapPortfoliosAllocationToggle() {
        Assert.assertTrue(currentPage.getAllocationBtnOn().isExisted());
    }

    public void tapPortfolioCurrencyTab() {
        sleep(200l);
        currentPage.getAllocationCurrencyBtn().click();
    }

    public void tapPortfolioRegionTab() {
        sleep(200l);
        currentPage.getAllocationRegionBtn().click();
    }

    public void tapContingentLiabilitiesTab() {
        currentPage.getListContingentLiabilitiesTitleTxt().click();
        sleep(2000L);
    }

    public void showContingentLiabilitiesListWithin() {
        sleep(200L);
        captureScreen();
        if(driverConfig.getPlatform().equals(Platform.IOS)){
            Assert.assertTrue(currentPage.getMainHoldingTableview().isDisplayed());
        }
        Assert.assertTrue(currentPage.getMainHoldingsBtn().getContent().equals(elementState.get("ContingentLiabilities")));
        Assert.assertTrue(currentPage.getMainTitleTxt().getContent().equals(elementState.get("MainTitle")));

    }

    public void saveControlStateOnPortfolios() {
        elementState.clear();
        elementState.put("ContingentLiabilities", currentPage.getMainHoldingsBtn().getContent());
        elementState.put("MainTitle", currentPage.getMainTitleTxt().getContent());
    }

    public void tapTransactionsBtn() {
        sleep(100L);
        currentPage.getMainTransactionsBtn().click();
    }

    public void checkFirstItemTransactionListVersion(DataTable dataTable) {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement transactionsListCurrency = new BaseWebElement("portfolio_transactions_list_tablecell_currency_" + (num-1));
        currentPage.getMainTransactionsTableView().scrollToItem(transactionsListCurrency,ScrollDirection.UP);

        this.assertIsDisplayed(RegionUtil.getMap(dataTable),num);
    }

    public void checkFirstItemTradeDate() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement tradeDate = new BaseWebElement("portfolio_transactions_list_tablecell_trade_date_" + (num-1));
        currentPage.getMainTransactionsTableView().scrollToItem(tradeDate,ScrollDirection.UP);
        Assert.assertTrue(CheckUtil.checkMonthFormat(tradeDate.getContent()));
    }


    public void orderedByDate() {
        sleep(200L);
        captureScreen();
        int listNum = UserProfileUtil.getCurrentUserProfile().getTotalNum();

        currentPage.getMainTransactionsTableView().scrollToItem(currentPage.getTransactionsListTradeDate0(), ScrollDirection.DOWN);
        String datePrefix = "portfolio_transactions_list_tablecell_trade_date_";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy",Locale.US);
        List<Date> dateList = new ArrayList<>();
        for (int i=0;i < listNum; i++){
            String dateId = datePrefix + i;
            BaseWebElement dateElement = new BaseWebElement(dateId);
            if(!dateElement.isVisible()){
                System.out.println("["+i+"] item not display, will be scroll");
                if(driverConfig.getPlatform().equals(Platform.ANDROID)) {
                    currentPage.getMainTransactionsTableView().scroll(ScrollDirection.UP, 1000L, 400);
                }else {
                    currentPage.getMainTransactionsTableView().scroll(ScrollDirection.UP, 1000L, 300);
                }
                i--;
                continue;
            }
            try {
                Date tradeDate = simpleDateFormat.parse(dateElement.getContent());
                dateList.add(tradeDate);
            }catch (ParseException e){
                e.printStackTrace();
                Assert.assertTrue("The ["+i+"] item date format is error! value is ["+dateElement.getContent()+"]", false);
            }
        }
//        System.out.println("dateList: "+dateList);

        for (int j = 0 ;j < dateList.size() - 1; j++){
            Date nowDate = dateList.get(j);
            Date nextDate = dateList.get(j + 1);
            if(nowDate.getTime() >= nextDate.getTime()){
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue("DateOrderByDateDESC error! "+j+":["+dateList.get(j)+"] and "+(j+1)+":["+dateList.get(j+1)+"]",false);
            }
        }
    }

    public void tapTransactionsFilter() {
        currentPage.getMainTransactionsTableView().scrollToItem(currentPage.getTransactionsHeadTitle(), ScrollDirection.DOWN);
        sleep(300L);
        currentPage.getTransactionsHeadTitle().click();
    }

    public void checkTransactionsFilter(Map<String, String> map) {
        sleep(200L);
        captureScreen();
        if (driverConfig.getPlatform().equals(Platform.IOS)){
            Assert.assertEquals(map.get("OK button"), currentPage.getTransactionsFilterOkBtn().getContent());
            currentPage.getTransactionsPickerView().sendKeys(map.get("All Type"));
            Assert.assertEquals(map.get("All Type"), currentPage.getTransactionsPickerView().getContent());

            currentPage.getTransactionsPickerView().sendKeys(map.get("Purchase Type"));
            Assert.assertEquals(map.get("Purchase Type"), currentPage.getTransactionsPickerView().getContent());

            currentPage.getTransactionsPickerView().sendKeys(map.get("Sales Type"));
            Assert.assertEquals(map.get("Sales Type"), currentPage.getTransactionsPickerView().getContent());

            currentPage.getTransactionsPickerView().sendKeys(map.get("Cash movements Type"));
            Assert.assertEquals(map.get("Cash movements Type"), currentPage.getTransactionsPickerView().getContent());

            Assert.assertTrue(currentPage.getTransactionsPickerView().isExisted());
        }
        else if (driverConfig.getPlatform().equals(Platform.ANDROID) && currentPage.getTransactionsHeadTitle().isVisible()) {
            Assert.assertEquals(map.get("All Type"), currentPage.getTransactionsPickerItemAllAos().getContent());
            Assert.assertEquals(map.get("Purchase Type"), currentPage.getTransactionsPickerItemPurchasesAos().getContent());
            Assert.assertEquals(map.get("Sales Type"), currentPage.getTransactionsPickerItemSalesAos().getContent());
            Assert.assertEquals(map.get("Cash movements Type"), currentPage.getTransactionsPickerItemCashMovementsAos().getContent());
        }


    }

    public void scrollTransactionFilter() {
        this.CoordsX = currentPage.getTransactionsFilterOkBtn().getRect().getX();
        this.CoordsY = currentPage.getTransactionsFilterOkBtn().getRect().getY();
        currentPage.getTransactionsPickerView().sendKeys("Income");
    }

    public void checkFilterOKCoords() {
        sleep(500L);
        int okBtnX = currentPage.getTransactionsFilterOkBtn().getRect().getX();
        int okBtnY = currentPage.getTransactionsFilterOkBtn().getRect().getY();
        if (this.CoordsX - okBtnX > -5 && this.CoordsX - okBtnX < 5 && this.CoordsY - okBtnY > -5 && this.CoordsY - okBtnY < 5) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    public void scrollTransactionsList() {
        currentPage.getMainTransactionsTableView().scroll(ScrollDirection.UP, 2000L,300);
        sleep(200L);
        currentPage.getMainTransactionsTableView().scroll(ScrollDirection.UP, 2000L,300);
    }

    public void checkFilterBarNotInTop() {
        sleep(300L);
        captureScreen();
        Assert.assertFalse(currentPage.getTransactionsHeadTitle().isVisible());
    }

    public void tapHeadTitle() {
        currentPage.getTransactionsHeadTitle().click();
    }

    public void tapFilterOkBtn() {
        if (driverConfig.getPlatform().equals(Platform.IOS))
            currentPage.getTransactionsFilterOkBtn().click();
        else
            currentPage.getTransactionsPickerItemAllAos().click();
    }

    public void saveElement() {
        elementState.clear();
        elementState.put("HeadTitle",currentPage.getTransactionsHeadTitle().getContent());
        currentPage.getMainTransactionsTableView().scrollToItem(currentPage.getTransactionsListAmount0(), ScrollDirection.UP);
        elementState.put("TransactionType",currentPage.getTransactionsListType0().getContent());
        elementState.put("DescriptionValue",currentPage.getTransactionsListDescription0().getContent());
        elementState.put("TradeDate",currentPage.getTransactionsListTradeDate0().getContent());
        elementState.put("TransactionValue",currentPage.getTransactionsListAmount0().getContent());

//        if(!currentPage.getTransactionsListAmount1().isVisible()){
//            currentPage.getMainTransactionsTableView().scroll(ScrollDirection.UP, 1000L, 500);
//        }
//        elementState.put("TransactionType1",currentPage.getTransactionsListType1().getContent());
//        elementState.put("DescriptionValue1",currentPage.getTransactionsListDescription1().getContent());
//        elementState.put("TradeDate1",currentPage.getTransactionsListTradeDate1().getContent());
//        elementState.put("TransactionValue1",currentPage.getTransactionsListAmount1().getContent());

    }

    public void tapBackButton() {
        currentPage.getMainBackBtn().click();
    }

    public void affirmElement() {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(currentPage.getTransactionsHeadTitle().getContent(),elementState.get("HeadTitle"));
        currentPage.getMainTransactionsTableView().scrollToItem(currentPage.getTransactionsListAmount0(), ScrollDirection.UP);
        Assert.assertEquals(currentPage.getTransactionsListType0().getContent(),elementState.get("TransactionType"));
        Assert.assertEquals(currentPage.getTransactionsListDescription0().getContent(),elementState.get("DescriptionValue"));
        Assert.assertEquals(currentPage.getTransactionsListTradeDate0().getContent(),elementState.get("TradeDate"));
        Assert.assertEquals(currentPage.getTransactionsListAmount0().getContent(),elementState.get("TransactionValue"));
//
//        if(!currentPage.getTransactionsListAmount1().isVisible()){
//            currentPage.getMainTransactionsTableView().scroll(ScrollDirection.UP, 1000L, 500);
//        }
//        Assert.assertEquals(currentPage.getTransactionsListType1().getContent(),elementState.get("TransactionType1"));
//        Assert.assertEquals(currentPage.getTransactionsListTradeDate1().getContent(),elementState.get("TradeDate1"));
//        Assert.assertEquals(currentPage.getTransactionsListAmount1().getContent(),elementState.get("TransactionValue1"));


    }

    public void seeTransactionList() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(currentPage.getMainTransactionsTableView().isExisted());
        Assert.assertTrue(currentPage.getMainTransactionsBtn().isExisted());
    }

    public void tapTransactionPortfolio() {
//        accountPage.getPortfolioClassView().scrollToItem(accountPage.getPortfolioList3(), ScrollDirection.UP);
        sleep(300L);
        accountsFlow.getPortfolioList(3).scrollTillFound(accountPage.getPortfolioListView(), 2000L);
        accountsFlow.getPortfolioList(3).click();
    }

    public void checkNotTransactionMessage(Map<String,String> map) {
        sleep(1000L);
        captureScreen();
        if (RegionUtil.isUK()){
            Assert.assertEquals(map.get("UK transaction content"),currentPage.getTransactionsUnavailableTitle().getContent());
        }else {
            Assert.assertEquals(map.get("transaction content"),currentPage.getTransactionsUnavailableContent().getContent());
        }
    }

    public void checkNoTransactionList() {
        Assert.assertFalse(currentPage.getTransactionsListType0().isVisible());
    }

    public void swipeRightPortfolioView() {
        currentPage.getMainTopView().scroll(ScrollDirection.RIGHT, 2000L);
    }

    public void tapTheSecondAccount() {
        overviewPage.getAccountListView().scrollToItem(overviewFlow.getAccountListAccountIdTxt(1), ScrollDirection.UP);
        elementState.put("accountName", overviewFlow.getAccountListUserNameTxt(1).getContent());
        elementState.put("accountId", overviewFlow.getAccountListAccountIdTxt(1).getContent());
        overviewFlow.getAccountListUserNameTxt(1).click();
    }

    public void checkTheSecondAccountDetail() {
        sleep(300L);
        Assert.assertEquals(elementState.get("accountName"), accountPage.getMainUsernameTxt().getContent());
        Assert.assertEquals(elementState.get("accountId"), accountPage.getMainUserIdTxt().getContent());
    }

    public void slideRight() {
        currentPage.getMainTopView().scroll(ScrollDirection.RIGHT,1500L);
    }

    public void slideLeft() {
        currentPage.getMainTopView().scroll(ScrollDirection.LEFT,1500L);
    }

    public void checkTitleIsPurchases() {
        sleep(500L);
        captureScreen();
        String content = currentPage.getTransactionsHeadTitle().getContent();
        if(content.contains(":")){
            content = CheckUtil.checkHeadTitle(content);
        }
        Assert.assertEquals(content,"Purchases");
    }

    public void checkTitleIsCashMovements() {
        sleep(500L);
        captureScreen();
        String content = currentPage.getTransactionsHeadTitle().getContent();
        if(content.contains(":")){
            content = CheckUtil.checkHeadTitle(content);
        }
        Assert.assertEquals(content,"Cash movements");
    }

    public void selectPrevious(String all) {
        if (driverConfig.getPlatform().equals(Platform.IOS)) {
            currentPage.getTransactionsPickerView().sendKeys(all);
            tapFilterOkBtn();
        }
        else {
            if (all.equals("All"))
                currentPage.getTransactionsPickerItemAllAos().click();
            if (all.equals("Purchases"))
                currentPage.getTransactionsPickerItemPurchasesAos().click();
            if (all.equals("Sales"))
                currentPage.getTransactionsPickerItemSalesAos().click();
            if (all.equals("Cash movements"))
                currentPage.getTransactionsPickerItemCashMovementsAos().click();
        }


        sleep(1000L);
    }

    public void checkListOfAll() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        BaseWebElement transactionsListAmount = new BaseWebElement("portfolio_transactions_list_tablecell_amount_" + (num-1));


        currentPage.getMainTransactionsTableView().scrollToItem(transactionsListAmount,ScrollDirection.UP);
        Assert.assertTrue(transactionsListAmount.isExisted());
    }

    public void checkNegativeValues() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement transactionsListAmount = new BaseWebElement("portfolio_transactions_list_tablecell_amount_" + (num-1));

        currentPage.getMainTransactionsTableView().scrollToItem(transactionsListAmount, ScrollDirection.DOWN);
        Assert.assertTrue(transactionsListAmount.getContent().startsWith("-"));
    }

    public void checkFilterIsAll() {
        String content = currentPage.getTransactionsHeadTitle().getContent();
        if(content.contains(":")){
            content = CheckUtil.checkHeadTitle(content);
        }
        Assert.assertEquals(content,"All");
    }

    public void noTransactions(Map<String, String> map) {
        sleep(500L);
        captureScreen();
        if (RegionUtil.isUK()){
            //Shell
            //Assert.assertEquals(map.get("UK transaction content")+map.get("UK transaction description"), currentPage.getTransactionsUnavailableTitle().getContent().replaceAll("\n", "").trim());
            Assert.assertEquals(map.get("UK transaction content"), currentPage.getTransactionsUnavailableTitle().getContent().replaceAll("\n", "").trim());
        }else {
            Assert.assertEquals(map.get("Title"), currentPage.getNoTransactionsTitle().getContent().replaceAll("\n", "").trim());
        }
    }

    public void notTransactions() {
        Assert.assertTrue(currentPage.getMainTransactionsBtn().isExisted());
        Assert.assertFalse(currentPage.getMainTransactionsTableView().isExisted());
    }


    public void checkListPurchases(Map<String, String> map) {
        sleep(500L);
        captureScreen();
        currentPage.getMainTransactionsTableView().scrollToItem(currentPage.getTransactionsListAmount3(),ScrollDirection.UP);
        Assert.assertEquals(currentPage.getTransactionsListType3().getContent(),map.get("Transaction Type"));
        Assert.assertEquals(currentPage.getTransactionsListDescription3().getContent(),map.get("Description value"));
        Assert.assertEquals(currentPage.getTransactionsListTradeDate3().getContent(),map.get("Trade date"));
        Assert.assertEquals(currentPage.getTransactionsListAmount3().getContent(),map.get("Transaction value"));
        Assert.assertEquals(currentPage.getTransactionsListCurrency3().getContent(),map.get("base currency"));

    }

    public void purchasesNegativeValues() {
        sleep(500L);
        captureScreen();
        currentPage.getMainTransactionsTableView().scrollToItem(currentPage.getTransactionsListAmount0(), ScrollDirection.UP);
        Assert.assertTrue(currentPage.getTransactionsListAmount0().getContent().startsWith("-"));
    }

    public void checkListSales(Map<String, String> map) {
        sleep(500L);
        captureScreen();
        currentPage.getMainTransactionsTableView().scrollToItem(currentPage.getTransactionsListCurrency2(),ScrollDirection.UP);
        Assert.assertEquals(currentPage.getTransactionsListType2().getContent(),map.get("Transaction Type"));
        Assert.assertEquals(currentPage.getTransactionsListDescription2().getContent(),map.get("Description value"));
        Assert.assertEquals(currentPage.getTransactionsListTradeDate2().getContent(),map.get("Trade date"));
        Assert.assertEquals(currentPage.getTransactionsListStatus2().getContent(),map.get("status"));
        Assert.assertEquals(currentPage.getTransactionsListAmount2().getContent(),map.get("Transaction value"));
        Assert.assertEquals(currentPage.getTransactionsListCurrency2().getContent(),map.get("base currency"));

    }

    public void salesNegativeValues() {
        sleep(500L);
        captureScreen();
        currentPage.getMainTransactionsTableView().scrollToItem(currentPage.getTransactionsListAmount1(), ScrollDirection.UP);
        Assert.assertTrue(currentPage.getTransactionsListAmount1().getContent().startsWith("-"));
    }

    public void cashMovementsNegativeValues() {
        sleep(500L);
        captureScreen();
        currentPage.getMainTransactionsTableView().scrollToItem(currentPage.getTransactionsListAmount1(), ScrollDirection.UP);
        Assert.assertTrue(currentPage.getTransactionsListAmount1().getContent().startsWith("-"));
    }

    public void checkListFees(Map<String, String> map) {
        sleep(500L);
        captureScreen();
        currentPage.getMainTransactionsTableView().scrollToItem(currentPage.getTransactionsListCurrency3(),ScrollDirection.UP);
        Assert.assertEquals(currentPage.getTransactionsListType3().getContent(),map.get("Transaction Type"));
        Assert.assertEquals(currentPage.getTransactionsListDescription3().getContent(),map.get("Description value"));
        Assert.assertEquals(currentPage.getTransactionsListTradeDate3().getContent(),map.get("Trade date"));
        Assert.assertEquals(currentPage.getTransactionsListStatus3().getContent(),map.get("status"));
        Assert.assertEquals(currentPage.getTransactionsListAmount3().getContent(),map.get("Transaction value"));
        Assert.assertEquals(currentPage.getTransactionsListCurrency3().getContent(),map.get("base currency"));

    }

    public void feesNegativeValues() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(currentPage.getTransactionsListAmount3().getContent().contains("-"));
    }

    public void checkListIncome(Map<String, String> map) {
        sleep(500L);
        captureScreen();
        currentPage.getMainTransactionsTableView().scrollToItem(currentPage.getTransactionsListCurrency3(),ScrollDirection.UP);
        Assert.assertEquals(currentPage.getTransactionsListType3().getContent(),map.get("Transaction Type"));
        Assert.assertEquals(currentPage.getTransactionsListDescription3().getContent(),map.get("Description value"));
        Assert.assertEquals(currentPage.getTransactionsListTradeDate3().getContent(),map.get("Trade date"));
        Assert.assertEquals(currentPage.getTransactionsListAmount3().getContent(),map.get("Transaction value"));
        Assert.assertEquals(currentPage.getTransactionsListCurrency3().getContent(),map.get("base currency"));

    }

    public void incomeNegativeValues() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(currentPage.getTransactionsListAmount3().getContent().contains("-"));
    }

    public void slideToThirdly() {
        elementState.put("portfolioId", accountPage.getPortfolioPortfolioIdTxt0().getContent());
        accountPage.getMainTopView().scroll(ScrollDirection.LEFT, 2000L);
        accountPage.getMainTopView().scroll(ScrollDirection.LEFT, 2000L);
    }

    public void checkPortfolioListChange() {
        Assert.assertNotEquals(elementState.get("portfolioId"), accountPage.getPortfolioPortfolioIdTxt0().getContent());
    }

    public void tapAccountClassTab() {
        accountPage.getMainClassBtn().click();
    }

    public void accountSlideTwoRightAndOneLeft() {
        if(accountPage.getSubClassTitleTxt0().isVisible()){
            elementState.put("startSubClassTitle", accountPage.getSubClassTitleTxt0().getContent());
        } else if (accountPage.getClassTitleTxt0().isVisible()){
            elementState.put("startClassTitle", accountPage.getClassTitleTxt0().getContent());
        } else if (accountPage.getCurrencyTitleTxt0().isVisible()){
            elementState.put("startCurrencyTitle", accountPage.getCurrencyTitleTxt0().getContent());
        } else if (accountPage.getRegionTitleTxt0().isVisible()){
            elementState.put("startRegionTitle", accountPage.getRegionTitleTxt0().getContent());
        }

        accountPage.getMainTopView().scroll(ScrollDirection.LEFT, 2000L);
        accountPage.getMainTopView().scroll(ScrollDirection.LEFT, 2000L);
        if(accountPage.getSubClassTitleTxt0().isVisible()){
            elementState.put("rightSubClassTitle", accountPage.getSubClassTitleTxt0().getContent());
        } else if(accountPage.getClassTitleTxt0().isVisible()){
            elementState.put("rightClassTitle", accountPage.getClassTitleTxt0().getContent());
        } else if (accountPage.getCurrencyTitleTxt0().isVisible()){
            elementState.put("rightCurrencyTitle", accountPage.getCurrencyTitleTxt0().getContent());
        } else if (accountPage.getRegionTitleTxt0().isVisible()){
            elementState.put("rightRegionTitle", accountPage.getRegionTitleTxt0().getContent());
        }

        accountPage.getMainTopView().scroll(ScrollDirection.RIGHT, 2000L);
        if(accountPage.getSubClassTitleTxt0().isVisible()){
            elementState.put("leftSubClassTitle", accountPage.getSubClassTitleTxt0().getContent());
        } else if(accountPage.getClassTitleTxt0().isVisible()){
            elementState.put("leftClassTitle", accountPage.getClassTitleTxt0().getContent());
        } else if (accountPage.getCurrencyTitleTxt0().isVisible()){
            elementState.put("leftCurrencyTitle", accountPage.getCurrencyTitleTxt0().getContent());
        } else if (accountPage.getRegionTitleTxt0().isVisible()){
            elementState.put("leftRegionTitle", accountPage.getRegionTitleTxt0().getContent());
        }
    }

    public void checkClassHasChange() {
        sleep(200L);
        captureScreen();
        Assert.assertNotEquals(elementState.get("startClassTitle"), elementState.get("rightClassTitle"));
        Assert.assertNotEquals(elementState.get("startClassTitle"), elementState.get("leftClassTitle"));
    }

    public void checkSubClassHasChange() {
        sleep(200L);
        captureScreen();
        Assert.assertNotEquals(elementState.get("startSubClassTitle"), elementState.get("rightSubClassTitle"));
        Assert.assertNotEquals(elementState.get("startSubClassTitle"), elementState.get("leftSubClassTitle"));
    }

    public void checkAccountCurrencyChange() {
        sleep(200L);
        captureScreen();
        Assert.assertNotEquals(elementState.get("startCurrencyTitle"), elementState.get("rightCurrencyTitle"));
        Assert.assertNotEquals(elementState.get("startCurrencyTitle"), elementState.get("leftCurrencyTitle"));
    }

    public void tapAccountRegionTab() {
        accountPage.getMainRegionBtn().click();
    }

    public void checkAccountRegionChange() {
        sleep(200L);
        captureScreen();
        Assert.assertNotEquals(elementState.get("startRegionTitle"), elementState.get("rightRegionTitle"));
        Assert.assertNotEquals(elementState.get("startRegionTitle"), elementState.get("leftRegionTitle"));
    }

    public void tapHoldings() {
        currentPage.getMainHoldingsBtn().click();
    }

    public void checkNotHoldingMessage(Map<String,String> map) {
        if(driverConfig.getPlatform().equals(Platform.ANDROID)){
            Assert.assertEquals(map.get("Android Holdings title"), currentPage.getNoHoldingMessageTitle().getContent());
        } else {
            Assert.assertEquals(map.get("Holdings title"),currentPage.getNoHoldingMessageTitle().getContent());
        }
//        if(!currentPage.getNoHoldingMessageContent().isVisible()){
//            currentPage.getListContingentLiabilitiesTitleTxt().scroll(ScrollDirection.UP, 1000L, 500);
//        }
        //Assert.assertEquals(map.get("Holdings content"), currentPage.getNoHoldingMessageContent().getContent());
    }

    public void checkNoHoldings() {
        Assert.assertFalse(currentPage.getPortfolioHoldingsList0().isVisible());
    }

    public void checkHasContingentLiabilities() {
        Assert.assertTrue(currentPage.getListContingentLiabilitiesTitleTxt().isVisible());
    }

    public void holdingReachTheFifteen() {
        sleep(200L);
        captureScreen();
        currentPage.getMainHoldingTableview().scrollToItem(getMainHoldingTitleTxt(14), ScrollDirection.UP);
    }

    public void continueLoadHoldingList() {
        sleep(200L);
        captureScreen();
        currentPage.getMainHoldingTableview().scroll(ScrollDirection.UP, 2000L,300);

    }

    public void seeThirtyHoldingItem() {
        Assert.assertTrue(getMainHoldingTitleTxt(29).isExisted());
    }

    public void tapTwentyHoldingItem() {
        sleep(200L);
        captureScreen();
        currentPage.getMainHoldingTableview().scrollToItem(getMainHoldingTitleTxt(19), ScrollDirection.UP);
        getMainHoldingTitleTxt(19).click();
    }

    public void checkHoldingHasTwentyAndLoadedThirty() {
        sleep(200L);
        captureScreen();
        Assert.assertTrue(getMainHoldingTitleTxt(19).isVisible());
        Assert.assertTrue(getMainHoldingTitleTxt(29).isExisted());
    }

    public void tapPortfolioBackBtn() {
        currentPage.getMainBackBtn().click();
    }

    public void checkHoldingListIsDefault() {
        sleep(200L);
        captureScreen();
        Assert.assertTrue(currentPage.getMainHoldingTitleTxt0().isVisible());
        Assert.assertTrue(getMainHoldingTitleTxt(14).isExisted());
        Assert.assertFalse(getMainHoldingTitleTxt(15).isExisted());
    }

    public void transactionToFifteenItem() {
        currentPage.getMainTransactionsTableView().scroll(ScrollDirection.UP,2000L,300);
        currentPage.getMainTransactionsTableView().scrollToItem(getTransactionsTableList(14), ScrollDirection.UP);
    }

    public void scrollUpTransactionList() {
        currentPage.getMainTransactionsTableView().scroll(ScrollDirection.UP, 2000L,300);
    }

    public void seeNextTransactionList() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(getTransactionsTableList(15).isExisted());
    }

    public void seeFirstTransactionList() {
        sleep(200L);
        captureScreen();
        currentPage.getMainTransactionsTableView().scroll(ScrollDirection.UP,2000L,300);
        currentPage.getMainTransactionsTableView().scrollToItem(getTransactionsTableList(14), ScrollDirection.UP);
        Assert.assertTrue(currentPage.getTransactionsTableList0().isExisted());
        Assert.assertTrue(getTransactionsTableList(14).isExisted());
    }

    public void scrollToTop() {
        currentPage.getMainTransactionsTableView().scrollToTopItem(currentPage.getTransactionsHeadTitle());
    }

    public void noPips() {
        sleep(200L);
        if(currentPage.getPortfolioPips().isExisted()){
            Assert.assertTrue(currentPage.getPortfolioPips().getRect().getWidth() < 20);
        }
    }

    public void checkNotSwipeLeftOrRight() {
        sleep(500L);
        elementState.put("portfolioList0 id",currentPage.getMainPortfolioIdTxt().getContent());

//        currentPage.getMainTopView().scroll(ScrollDirection.RIGHT,1500L);
//        if (!currentPage.getMainPortfolioIdTxt().getContent().equals(elementState.get("portfolioList0 id")))
//            Assert.assertTrue(false);

        currentPage.getMainTopView().scroll(ScrollDirection.LEFT,1500L);
        Assert.assertTrue(currentPage.getMainPortfolioIdTxt().getContent().equals(elementState.get("portfolioList0 id")));

    }

    public void pipSaveHoldingOrTransationData() {
        elementState.put("PortfolioHoldingsTitleName0",currentPage.getPortfolioHoldingsTitleName0().getContent());
        currentPage.getMainTransactionsBtn().click();
        elementState.put("transactionsDescription0",currentPage.getTransactionsListDescription0().getContent());
        currentPage.getPortfolioPips().scroll(ScrollDirection.LEFT,1500L);
    }

    public void checkHoldingAndTransationDataChange() {
        sleep(300L);
        captureScreen();
        Assert.assertEquals(currentPage.getPortfolioHoldingsTitleName0().getContent(),elementState.get("PortfolioHoldingsTitleName0"));
        Assert.assertEquals(currentPage.getTransactionsListDescription0().getContent(),elementState.get("transactionsDescription0"));
    }

    public void tapsPortfolioClassTap() {
        currentPage.getAllocationClassBtn().click();
    }


    public void pipRightSavePortfolioData(String str){

        if ("Class".equals(str)){

//            elementState.put("ClassPercentageTxt0",currentPage.getClassPercentageTxt0().getContent());
            elementState.put("ClassTitleTxt0",currentPage.getClassTitleTxt0().getContent());

        }else if ("SubClass".equals(str)){

            elementState.put("SubClassHeadTitleTxt0",currentPage.getSubClassHeadTitleTxt0().getContent());
//            elementState.put("SubClassHeadCurrencyTxt0",currentPage.getSubClassHeadCurrencyTxt0().getContent());

        }else if ("Region".equals(str)){

//            elementState.put("RegionPercentageTxt0",currentPage.getRegionPercentageTxt0().getContent());
            elementState.put("RegionTitleTxt0",currentPage.getRegionTitleTxt0().getContent());
        }else if ("Currency".equals(str)){

//            elementState.put("CurrencyPercentageTxt0",currentPage.getCurrencyPercentageTxt0().getContent());
            elementState.put("CurrencyTitleTxt0",currentPage.getCurrencyTitleTxt0().getContent());
        }

        currentPage.getMainTopView().scroll(ScrollDirection.RIGHT,1500L);
    }

    public void checkPortfolioClassPercentageDataChange() {
        sleep(300L);
        captureScreen();
//        Assert.assertNotEquals(currentPage.getClassPercentageTxt0().getContent(),elementState.get("ClassPercentageTxt0"));
        Assert.assertNotEquals(currentPage.getClassTitleTxt0().getContent(),elementState.get("ClassTitleTxt0"));
    }

    public void checkSubAssetClassHeadTitleData() {
        sleep(300L);
        captureScreen();
        Assert.assertNotEquals(elementState.get("SubClassHeadTitleTxt0"),currentPage.getSubClassHeadTitleTxt0().getContent());
//        Assert.assertNotEquals(elementState.get("SubClassHeadCurrencyTxt0"),currentPage.getSubClassHeadCurrencyTxt0().getContent());
    }

    public void tapsCurrencyTapInPortfolioLevel() {
        currentPage.getAllocationCurrencyBtn().click();
    }

    public void checkCurrencyTitleAndPercentageDataChange() {
        sleep(300L);
        captureScreen();
//        Assert.assertNotEquals(elementState.get("CurrencyPercentageTxt0"),currentPage.getCurrencyPercentageTxt0().getContent());
        Assert.assertNotEquals(elementState.get("CurrencyTitleTxt0"),currentPage.getCurrencyTitleTxt0().getContent());

    }

    public void tapPortfolioRegion() {
        currentPage.getAllocationRegionBtn().click();
    }

    public void viewPortfoliosLevel() {
        Assert.assertTrue(currentPage.getMainBackBtn().isVisible());
    }

    public void portfolioPipFrom1ToLastPortfolio() {
        sleep(300L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        for (int i =0; i < num; i++){
            currentPage.getMainTopView().scroll(ScrollDirection.LEFT,500L);
        }
    }

    public void tapPortfoliosHoldingTab() {
        currentPage.getMainHoldingsBtn().click();
    }

    public void tapPortfoliosTransactionsTab() {
        currentPage.getMainTransactionsBtn().click();
    }

    public void checkContingentLiabilityBar() {
        sleep(800L);
        captureScreen();
        sleep(200L);
        Assert.assertTrue(currentPage.getListContingentLiabilitiesTitleTxt().isVisible());
    }

    public void portfolioScrollLeft(int num,String tab) {
        sleep(300L);
        if (num == 1){
            if ("Holdings".equals(tab))
                elementState.put("PortfolioHoldingsTitleName0",currentPage.getPortfolioHoldingsTitleName0().getContent());
            else if ("Transaction".equals(tab))
                elementState.put("TransactionsListType0",currentPage.getTransactionsListType0().getContent());
            else if ("Class".equals(tab))
                elementState.put("ClassTitleTxt0",currentPage.getClassTitleTxt0().getContent());
            else if ("Currency".equals(tab))
                elementState.put("CurrencyTotalAmountTxt0",currentPage.getCurrencyTotalAmountTxt0().getContent());
            else if ("Region".equals(tab))
                elementState.put("RegionTitleTxt0",currentPage.getRegionTitleTxt0().getContent());
            else if ("Total Assets".equals(tab))
                elementState.put("MainTotalAssetsContentTxt",currentPage.getMainTotalAssetsContentTxt().getContent());
            else if ("Wrapper".equals(tab)){
                elementState.put("MainTotalAssetsContentTxt",currentPage.getMainTotalAssetsContentTxt().getContent());
                elementState.put("MainTitleTxt",currentPage.getMainTitleTxt().getContent());
                elementState.put("MainPortfolioIdTxt",currentPage.getMainPortfolioIdTxt().getContent());
            }
        }
        for (int i=0;i<num;i++){
            currentPage.getMainTopView().scroll(ScrollDirection.LEFT,500L);
        }
    }

    public void checkPortfoliosTabData0(String tab) {

        sleep(300L);
        captureScreen();
        if ("Holdings".equals(tab) && currentPage.getPortfolioHoldingsTitleName0().isVisible())
            Assert.assertNotEquals(elementState.get("PortfolioHoldingsTitleName0"),currentPage.getPortfolioHoldingsTitleName0().getContent());

        else if ("Transaction".equals(tab) && currentPage.getTransactionsListType0().isVisible())
            Assert.assertNotEquals(elementState.get("TransactionsListType0"),currentPage.getTransactionsListType0().getContent());

        else if ("Class".equals(tab) && currentPage.getClassTitleTxt0().isVisible())
            Assert.assertNotEquals(elementState.get("ClassTitleTxt0"),currentPage.getClassTitleTxt0().getContent());

        else if ("Currency".equals(tab)&& currentPage.getCurrencyTitleTxt0().isVisible())
            Assert.assertNotEquals(elementState.get("CurrencyTotalAmountTxt0"),currentPage.getCurrencyTotalAmountTxt0().getContent());

        else if ("Region".equals(tab)&& currentPage.getRegionTitleTxt0().isVisible())
            Assert.assertNotEquals(elementState.get("RegionTitleTxt0"),currentPage.getRegionTitleTxt0().getContent());

    }

    public void tapProtfolioAssetsValue2() {
        sleep(300L);
        currentPage.getMainPortfolioAssetsTxt().click();
    }

    public void seePortfolioOverlayRelating() {
        sleep(300L);
        captureScreen();
        Assert.assertNotEquals(elementState.get("MainTotalAssetsContentTxt"), globalOverlayPage.getContentTxt().getContent());
    }

    public void checkPortfolioWrapperChange() {
        sleep(1000L);
        captureScreen();
        Assert.assertNotEquals(elementState.get("MainTotalAssetsContentTxt"),currentPage.getMainTotalAssetsContentTxt().getContent());
        Assert.assertNotEquals(elementState.get("MainTitleTxt"),currentPage.getMainTitleTxt().getContent());
        Assert.assertNotEquals(elementState.get("MainPortfolioIdTxt"),currentPage.getMainPortfolioIdTxt().getContent());

    }

    public void pipLeftSaveOverlayData3() {
        elementState.put("MainTotalAssetsContentTxt2",currentPage.getMainTotalAssetsContentTxt().getContent());
        this.slideLeft();
    }

    public void checkPortfolioOverlay() {
        sleep(300L);
        Assert.assertNotEquals(elementState.get("MainTotalAssetsContentTxt"),currentPage.getMainTotalAssetsContentTxt().getContent());
    }

    public void checkPortfolioTransactionsSelected() {
        sleep(300L);
        Assert.assertTrue(currentPage.getTransactionsListType0().isVisible());
    }

    public void tabPTransactionsHeadTitle() {
        currentPage.getTransactionsHeadTitle().click();
    }

    public void checkPurchaseSelect() {
        sleep(300L);
        captureScreen();
        Assert.assertEquals("Purchases",currentPage.getTransactionsHeadTitle().getContent().replace("View: ", ""));
    }

    public void closeOverlay() {
        globalOverlayPage.getCloseBtn().click();
    }

    public void pipsFrom1ToLastContingentLiabilityDetail() {
        sleep(300L);
        captureScreen();
        for (int i = 0; i < 12; i++){
            if (driverConfig.getPlatform().equals(Platform.ANDROID)){
                contingentLiabilitiesPage.getAosDetailView().scroll(ScrollDirection.LEFT,200L);
            } else {
                this.swipeScreen(ScrollDirection.LEFT);
            }
        }
    }

    public void seePortfolioLevel() {
        Assert.assertTrue(currentPage.getMainBackBtn().isVisible());
    }

    public void checkTransactionOrderLogic() {
        sleep(200L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
            if(RegionUtil.isUK()){
            currentPage.getMainTransactionsTableView().scrollToItem(currentPage.getTransactionsHeadTitle(), ScrollDirection.DOWN);
        }
        String datePrefix = "portfolio_transactions_list_tablecell_trade_date_";
        String typePrefix = "portfolio_transactions_list_tablecell_transaction_type_";
        String descriptionPrefix = "portfolio_transactions_list_tablecell_description_";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy",Locale.ENGLISH);
        List<Date> dateList = new ArrayList<>();
        List<String> typeList = new ArrayList<>();
        List<String> descriptionList = new ArrayList<>();
        for (int i=0;i < num; i++){
            String dateId = datePrefix + i;
            String typeId = typePrefix + i;
            String descriptionId = descriptionPrefix + i;
            BaseWebElement dateElement = new BaseWebElement(dateId);
            BaseWebElement typeElement = new BaseWebElement(typeId);
            BaseWebElement descriptionElement = new BaseWebElement(descriptionId);
            if(!descriptionElement.isVisible()){
                System.out.println("["+i+"] item not display, will be scroll");

                if (driverConfig.getDeviceName().equals("E2353")){
                    currentPage.getMainTransactionsTableView().scroll(ScrollDirection.UP, 1000L, 250);
                }else {
                    currentPage.getMainTransactionsTableView().scroll(ScrollDirection.UP, 1000L, 300);
                }

                i--;
                continue;
            }
            try {
                Date tradeDate = simpleDateFormat.parse(dateElement.getContent());
                dateList.add(tradeDate);
            }catch (ParseException e){
                e.printStackTrace();
                Assert.assertTrue("The ["+i+"] item date format is error! value is ["+dateElement.getContent()+"]", false);
            }
            // for UK
            if(RegionUtil.isUK()){
                typeList.add(typeElement.getContent());
            }
            descriptionList.add(descriptionElement.getContent());
        }
//        System.out.println("dateList: "+dateList);
//        System.out.println("typeList: "+typeList);
//        System.out.println("descriptionList: "+descriptionList);

        for (int j = 0 ;j < dateList.size() - 1; j++){
            Date nowDate = dateList.get(j);
            Date nextDate = dateList.get(j + 1);
            if(nowDate.getTime() >= nextDate.getTime()){
                if(nowDate.getTime() == nextDate.getTime()){
                    if(RegionUtil.isUK()){
                        // for UK
                        if(typeList.get(j).equals(typeList.get(j + 1))){
                            boolean boo = CheckUtil.checkAlphabetOrderByASC(descriptionList.subList(j, j + 2));
                            Assert.assertTrue("AlphabetOrderByASC error! "+j+":["+descriptionList.get(j)+"] and "+(j+1)+":["+descriptionList.get(j+1)+"]", boo);
                        } else {
                            boolean boo = CheckUtil.checkAlphabetOrderByASC(typeList.subList(j, j + 2));
                            Assert.assertTrue("AlphabetOrderByASC error! "+j+":["+typeList.get(j)+"] and "+(j+1)+":["+typeList.get(j+1)+"]", boo);
                        }
                    } else {
                        // for ASIA
                        boolean boo = CheckUtil.checkAlphabetOrderByASC(descriptionList.subList(j, j + 2));
                        Assert.assertTrue("AlphabetOrderByASC error! "+j+":["+descriptionList.get(j)+"] and "+(j+1)+":["+descriptionList.get(j+1)+"]", boo);
                    }
                }
            } else {
                Assert.assertTrue("DateOrderByDateDESC error! "+j+":["+dateList.get(j)+"] and "+(j+1)+":["+dateList.get(j+1)+"]",false);
            }
        }
    }

    public void swipeLeftPortfolio() {
        currentPage.getMainTopView().scroll(ScrollDirection.LEFT, 1000L);
    }

    public void checkTransactionType(String type) {
        sleep(300L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        String typePrefix = "portfolio_transactions_list_tablecell_transaction_type_";
        for (int i=0;i < num; i++){
            String typeId = typePrefix + i;
            BaseWebElement typeElement = new BaseWebElement(typeId);
            if(!typeElement.isVisible()){
                System.out.println("["+i+"] item not display, will be scroll");
                if (driverConfig.getDeviceName().equals("E2353")){
                    currentPage.getMainTransactionsTableView().scroll(ScrollDirection.UP, 1000L, 250);
                }else {
                    currentPage.getMainTransactionsTableView().scroll(ScrollDirection.UP, 1000L, 300);
                }
                i--;
                continue;
            }
            Assert.assertTrue(typeElement.getContent().contains(type));
        }
    }

    public void checkPortfoliosCurrencyUI(Map<String,String> map) {
        sleep(500L);
        captureScreen();
        this.assertIsDisplayed(map);
    }

    public void checkPortfolioCurrencyDataFormat() {
        sleep(500L);
        captureScreen();
        int dateLength = UserProfileUtil.getCurrentUserProfile().getTotalNum()-1;
        currentPage.getCurrencyPortfolioView().scrollToItem(currentPage.getCurrencyTitleTxt0(),ScrollDirection.DOWN);
        String[] titleName =  this.getDateList(currentPage.getCurrencyPortfolioView(),"currencyTitleTxt",dateLength);
        currentPage.getCurrencyPortfolioView().scrollToItem(currentPage.getCurrencyPercentageTxt0(),ScrollDirection.DOWN);

        String[] percentage = this.getDateList(currentPage.getCurrencyPortfolioView(),"currencyPercentageTxt",dateLength);
        currentPage.getCurrencyPortfolioView().scrollToItem(currentPage.getCurrencyTotalAmountTxt0(),ScrollDirection.DOWN);

        String[] totalAmount = this.getDateList(currentPage.getCurrencyPortfolioView(),"currencyTotalAmountTxt",dateLength);

        if (titleName.length < (dateLength+1) || percentage.length < (dateLength+1) || totalAmount.length < (dateLength+1))
            Assert.assertTrue(false);

        for (int i = 0; i < (dateLength+1); i++){
            CheckUtil.checkPercentage(percentage[i]);
            CheckUtil.checkTotalAmount(totalAmount[i]);
        }
    }

    public void orderedByCurrencyList() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        currentPage.getCurrencyPortfolioView().scrollToItem(currentPage.getCurrencyTotalAmountTxt0(),ScrollDirection.DOWN);
        this.checkNumberOrderByDesc(currentPage.getCurrencyPortfolioView(),"portfolios_currency_list_tablecell_amount_label_",null,0,(num-1));
    }

    public void scrollDownPortfoliosCurrencyBottom() {
        currentPage.getCurrencyPortfolioView().scrollToItem(getPortfolioCurrencyList(7),ScrollDirection.UP);
    }

    public void checkCurrencyLastData(Map<String,String> map) {
        sleep(500L);
        captureScreen();
        currentPage.getCurrencyPortfolioView().scrollToItem(currentPage.getElementById("portfolios_currency_list_tablecell_amount_label_7"), ScrollDirection.UP);
        Assert.assertEquals(map.get("Other label"),currentPage.getElementById("portfolios_currency_list_tablecell_title_label_7").getContent());
        String currency = "GBP";
        if (driverConfig.getPlatform().equals(Platform.ANDROID)){
            currency = null;
        }
        CheckUtil.checkTotalAmount(currentPage.getElementById("portfolios_currency_list_tablecell_amount_label_7").getContent());
        CheckUtil.checkPercentage(currentPage.getElementById("portfolios_currency_list_tablecell_weight_label_7").getContent());
    }

    public void checkHasClassList() {
        Assert.assertTrue(currentPage.getPortfolioClassView().isVisible());
    }

    public void tapFirstClass() {
        currentPage.getPortfolioClassView().scrollToItem(currentPage.getClassList0(), ScrollDirection.UP);
        currentPage.getClassList0().click();
    }

    public void tapFirstSubClass() {
        if (!currentPage.getSubClassTotalAssetTxt0().isVisible()){
            currentPage.getPortfolioClassView().scrollToItem(currentPage.getSubClassTotalAssetTxt0(), ScrollDirection.UP);
        }
        currentPage.getSubClassTotalAssetTxt0().click();
    }

    public void checkInClassHolding() {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getHoldingBackBtn().isVisible());
    }

    public void tapFirstCurrency() {
        currentPage.getCurrencyTitleTxt0().click();
    }

    public void checkNotCurrencyList() {
        Assert.assertFalse(currentPage.getCurrencyPortfolioView().isVisible());
    }

    public void checkPortfolioTotalAssetsFormat() {
        sleep(500L);
        captureScreen();
        String totalAssets = currentPage.getMainTotalAssetsContentTxt().getContent();
        CheckUtil.check2dp(CheckUtil.getAmount(totalAssets));
        Assert.assertTrue(CheckUtil.getAmount(totalAssets).replace("-","").length() <= 18);
    }

    public void checkPortfolioTotalAssetsISO3() {
        sleep(500L);
        captureScreen();
        CheckUtil.checkDataFormat(currentPage.getMainTotalAssetsContentTxt().getContent());
    }

    public void tapPortfolioTotalAssetsValue() {
        sleep(300L);
        elementState.put("portfolio total assets",currentPage.getMainTotalAssetsContentTxt().getContent());
        Rectangle rectangle = currentPage.getMainTotalAssetsTxt().getRect();
        currentPage.getMainTotalAssetsTxt().tapXY(rectangle.getX(),rectangle.getY());
        //currentPage.getMainTotalAssetsTxt().click();
    }

    public void checkPortfoliosOverlayDisplayed() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(globalOverlayPage.getContentTxt().isVisible());
        Assert.assertTrue(globalOverlayPage.getCalculatedValueTxt().isVisible());
        Assert.assertTrue(globalOverlayPage.getCloseBtn().isVisible());
        Assert.assertTrue(globalOverlayPage.getNameTxt().isVisible());
        Assert.assertTrue(globalOverlayPage.getCalculatedTxt().isVisible());
        Assert.assertTrue(globalOverlayPage.getTitleTxt().isVisible());
    }

    public void checkPortfolioOverlayUI(Map<String,String> map) {
        sleep(300L);
        captureScreen();
        globalOverlayFlow.assertIsDisplayed(map);
    }

    public void checkOverlayDP() {
        sleep(500L);
        captureScreen();
        CheckUtil.check2dp(CheckUtil.getAmount(globalOverlayPage.getContentTxt().getContent()));
    }

    public void checkOverlayISO() {
        sleep(500L);
        captureScreen();
        CheckUtil.checkDataFormat(globalOverlayPage.getContentTxt().getContent());
    }

    public void tapOverlayCloseBtn() {
        globalOverlayPage.getCloseBtn().click();
    }

    public void seePortfolioScreen() {
        Assert.assertTrue(currentPage.getMainPortfolioIdTxt().isVisible());
    }

    public void checkOverLayClose() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(globalOverlayPage.getTitleTxt().isVisible());
    }

    public void tapOverlayOutside() {
        if (driverConfig.getPlatform().equals(Platform.IOS)) {
            globalOverlayPage.getTitleTxt().tapXY(50, 50);
        }else {
            globalOverlayPage.getTitleTxt().tapXY(180, 180);
        }
    }

    public void checkPortfolioTotalAssets16() {
        sleep(500L);
        captureScreen();
        String totalAssets = CheckUtil.getAmount(currentPage.getMainTotalAssetsContentTxt().getContent());
        Assert.assertEquals(totalAssets,"0.00");
        CheckUtil.check2dp(totalAssets);

    }

    public void checkPortfolioTotalAssets16IOS3() {
        sleep(500L);
        captureScreen();
        CheckUtil.checkDataFormat(currentPage.getMainTotalAssetsContentTxt().getContent());
    }

    public void checkHoldingListDifferentDisplayed() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        currentPage.getPortfolioHoldingsListTableview().scrollToItem(new BaseWebElement("portfolio_holdings_list_tablecell_report_amount_label_" + (num-1)) , ScrollDirection.UP);
        Assert.assertTrue(new BaseWebElement("portfolio_holdings_list_tablecell_base_amount_label_" + (num-1)).isVisible());
        Assert.assertTrue(new BaseWebElement("portfolio_holdings_list_tablecell_report_amount_label_" + (num-1)).isVisible());

        Assert.assertTrue(new BaseWebElement("portfolio_holdings_list_tablecell_weight_label_" + (num-1)).isVisible());
        Assert.assertTrue(new BaseWebElement("portfolio_holdings_list_tablecell_title_label_" + (num-1)).isVisible());
    }

    public void checkHoldingsDataDifferentFormatISO3() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();

        currentPage.getPortfolioHoldingsListTableview().scrollToItem(new BaseWebElement("portfolio_holdings_list_tablecell_report_amount_label_" + (num-1)),ScrollDirection.UP);

        String baseAmount = new BaseWebElement("portfolio_holdings_list_tablecell_base_amount_label_" + (num-1)).getContent();

        String reportAmount = new BaseWebElement("portfolio_holdings_list_tablecell_report_amount_label_" + (num-1)).getContent();


        if (driverConfig.getPlatform().equals(Platform.IOS)){
            CheckUtil.checkDataFormat(
                    baseAmount.substring(0, baseAmount.indexOf(" ")).trim()
            );


        }else {
            CheckUtil.checkDataFormat(baseAmount);
        }


        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(reportAmount)
        );

    }

    public void checkHoldingsDataFormat() {

        sleep(500L);
        captureScreen();
        currentPage.getPortfolioHoldingsListTableview().scrollToItem(currentPage.getPortfolioHoldingsTitleName0(),ScrollDirection.DOWN);
        int itemNum = UserProfileUtil.getCurrentUserProfile().getTotalNum();

        Double[] reportAmount = new Double[itemNum];
        String baseAmountId = "portfolio_holdings_list_tablecell_base_amount_label_";
        String reportAmountId = "portfolio_holdings_list_tablecell_report_amount_label_";
        String nextElementTitleId = "portfolio_holdings_list_tablecell_title_label_";
        for (int i = 0; i < itemNum; i++){
            BaseWebElement reportElement = new BaseWebElement(reportAmountId+i);
            BaseWebElement baseElement = new BaseWebElement(baseAmountId+i);
            if(i < (itemNum - 1)){
                BaseWebElement nextElementTitle = new BaseWebElement(nextElementTitleId + (i+1));
                if (!baseElement.isVisible() || !nextElementTitle.isVisible()){
                    System.out.println("["+i+"] item not display, will be scroll");
                    if(driverConfig.getDeviceName().equals("E2353")){
                        currentPage.getPortfolioHoldingsListTableview().scroll(ScrollDirection.UP, 1000L, 300);
                    }else if(driverConfig.getPlatform().equals(Platform.IOS)){
                        currentPage.getPortfolioHoldingsListTableview().scroll(ScrollDirection.UP, 1000L, 300);
                    }else {
                        currentPage.getPortfolioHoldingsListTableview().scroll(ScrollDirection.UP, 1000L, 400);
                    }
                }
            } else if (i == (itemNum - 1)){
                currentPage.getPortfolioHoldingsListTableview().scroll(ScrollDirection.UP, 1000L, 1000);
            }

            if (!reportElement.isVisible()){
                CheckUtil.checkDataFormat(baseElement.getContent());
            }else {
                CheckUtil.checkDataFormat(baseElement.getContent());
                CheckUtil.checkDataFormat(reportElement.getContent());
            }
        }

    }

    public void checkHoldingsListReportAmountOrder() {

        sleep(500L);
        captureScreen();
        currentPage.getPortfolioHoldingsListTableview().scrollToItem(currentPage.getPortfolioHoldingsTitleName0(),ScrollDirection.DOWN);
        int itemNum = UserProfileUtil.getCurrentUserProfile().getTotalNum();

        Double[] reportAmount = new Double[itemNum];
        String baseAmountId = "portfolio_holdings_list_tablecell_base_amount_label_";
        String reportAmountId = "portfolio_holdings_list_tablecell_report_amount_label_";
        String nextElementTitleId = "portfolio_holdings_list_tablecell_title_label_";
        for (int i = 0; i < itemNum; i++){
            BaseWebElement reportElement = new BaseWebElement(reportAmountId+i);
            BaseWebElement baseElement = new BaseWebElement(baseAmountId+i);
            if(i < (itemNum - 1)){
                BaseWebElement nextElementTitle = new BaseWebElement(nextElementTitleId + (i+1));
                if (!baseElement.isVisible() || !nextElementTitle.isVisible()){
                    System.out.println("["+i+"] item not display, will be scroll");
                    if(driverConfig.getDeviceName().equals("E2353")){
                        currentPage.getPortfolioHoldingsListTableview().scroll(ScrollDirection.UP, 1000L, 300);
                    }else if(driverConfig.getPlatform().equals(Platform.IOS)){
                        currentPage.getPortfolioHoldingsListTableview().scroll(ScrollDirection.UP, 1000L, 300);
                    }else {
                        currentPage.getPortfolioHoldingsListTableview().scroll(ScrollDirection.UP, 1000L, 400);
                    }
                }
            } else if (i == (itemNum - 1)){
                currentPage.getPortfolioHoldingsListTableview().scroll(ScrollDirection.UP, 1000L, 1000);
            }

            if (!reportElement.isVisible()){
                reportAmount[i] = CheckUtil.getNoISOAmount(baseElement.getContent());
            }else {
                reportAmount[i] = CheckUtil.getNoISOAmount(reportElement.getContent());
            }
        }

        for (int i = 0; i < reportAmount.length - 1; i++){
            Assert.assertTrue("amount order error: ["+reportAmount[i]+"] and ["+reportAmount[i + 1]+"]", reportAmount[i] >= reportAmount[i + 1]);
        }
    }

    public void checkHoldingListSameDisplayed() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        currentPage.getPortfolioHoldingsListTableview().scrollToItem(new BaseWebElement("portfolio_holdings_list_tablecell_base_amount_label_" + (num-1)) , ScrollDirection.UP);
        Assert.assertTrue(new BaseWebElement("portfolio_holdings_list_tablecell_base_amount_label_" + (num-1)).isVisible());
//        Assert.assertFalse(new BaseWebElement("portfolio_holdings_list_tablecell_report_amount_label_" + (num-1)).isVisible());

        Assert.assertTrue(new BaseWebElement("portfolio_holdings_list_tablecell_weight_label_" + (num-1)).isVisible());
        Assert.assertTrue(new BaseWebElement("portfolio_holdings_list_tablecell_title_label_" + (num-1)).isVisible());

    }

    public void checkHoldingsDataSameFormatISO3() {
        sleep(500L);
        captureScreen();

        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();

        currentPage.getPortfolioHoldingsListTableview().scrollToItem(new BaseWebElement("portfolio_holdings_list_tablecell_base_amount_label_" + (num-1)),ScrollDirection.DOWN);

        String baseAmount = new BaseWebElement("portfolio_holdings_list_tablecell_base_amount_label_" + (num-1)).getContent();

        if (driverConfig.getPlatform().equals(Platform.IOS)){
            CheckUtil.checkDataFormat(
                    baseAmount.substring(0, baseAmount.indexOf(" ")).trim()
            );

        }else {
            CheckUtil.checkDataFormat(baseAmount);
        }
    }

    public void checkHoldingListPercentageZeroDisplayed() {
        sleep(500L);
        captureScreen();

        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        currentPage.getPortfolioHoldingsListTableview().scrollToItem(new BaseWebElement("portfolio_holdings_list_tablecell_report_amount_label_" + (num-1)) , ScrollDirection.UP);
        Assert.assertTrue(new BaseWebElement("portfolio_holdings_list_tablecell_base_amount_label_" + (num-1)).isVisible());
        Assert.assertTrue(new BaseWebElement("portfolio_holdings_list_tablecell_report_amount_label_" + (num-1)).isVisible());

        Assert.assertFalse(new BaseWebElement("portfolio_holdings_list_tablecell_weight_label_" + (num-1)).isVisible());
        Assert.assertTrue(new BaseWebElement("portfolio_holdings_list_tablecell_title_label_" + (num-1)).isVisible());

    }

    public void checkHoldingsDataPercentageZeroFormatISO3() {
        sleep(500L);
        captureScreen();

        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();

        currentPage.getPortfolioHoldingsListTableview().scrollToItem(new BaseWebElement("portfolio_holdings_list_tablecell_report_amount_label_" + (num-1)),ScrollDirection.DOWN);

        String baseAmount = new BaseWebElement("portfolio_holdings_list_tablecell_base_amount_label_" + (num-1)).getContent();

        String reportAmount = new BaseWebElement("portfolio_holdings_list_tablecell_report_amount_label_" + (num-1)).getContent();

        if (driverConfig.getPlatform().equals(Platform.IOS)){
            CheckUtil.checkDataFormat(
                    baseAmount.substring(0, baseAmount.indexOf(" ")).trim()
            );

        }else {
            CheckUtil.checkDataFormat(baseAmount);
        }


        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(reportAmount)
        );

    }

    public void checkHoldingListSAMEPercentageZeroDisplayed() {
        sleep(500L);
        captureScreen();

        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        currentPage.getPortfolioHoldingsListTableview().scrollToItem(new BaseWebElement("portfolio_holdings_list_tablecell_base_amount_label_" + (num-1)) , ScrollDirection.UP);
        Assert.assertTrue(new BaseWebElement("portfolio_holdings_list_tablecell_base_amount_label_" + (num-1)).isVisible());
//        Assert.assertFalse(new BaseWebElement("portfolio_holdings_list_tablecell_report_amount_label_" + (num-1)).isVisible());

//        Assert.assertFalse(new BaseWebElement("portfolio_holdings_list_tablecell_weight_label_" + (num-1)).isVisible());
        Assert.assertTrue(new BaseWebElement("portfolio_holdings_list_tablecell_title_label_" + (num-1)).isVisible());
    }

    public void checkHoldingsDataSAMEPercentageZeroFormatISO3() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();

        currentPage.getPortfolioHoldingsListTableview().scrollToItem(new BaseWebElement("portfolio_holdings_list_tablecell_base_amount_label_" + (num-1)),ScrollDirection.DOWN);

        String baseAmount = new BaseWebElement("portfolio_holdings_list_tablecell_base_amount_label_" + (num-1)).getContent();

        if (driverConfig.getPlatform().equals(Platform.IOS)){
            CheckUtil.checkDataFormat(
                    baseAmount.substring(0, baseAmount.indexOf(" ")).trim()
            );

        }else {
            CheckUtil.checkDataFormat(baseAmount);
        }
    }

    public void tapsTransactionList0() {
        currentPage.getTransactionsTableList0().click();
    }

    public void tapsSettledTransactionListDIFFERENT() {
        sleep(200L);
        if (RegionUtil.isUK()){
            currentPage.getMainTransactionsTableView().scrollToItem(getTransactionsTableList(5),ScrollDirection.UP);
            getTransactionsTableList(5).click();
        }else if (RegionUtil.isAisa()){
            currentPage.getMainTransactionsTableView().scrollToItem(getTransactionsTableList(3),ScrollDirection.UP);
            getTransactionsTableList(3).click();
        }

    }

    public void tapsSettledTransactionListSAME() {
        sleep(200L);
        if (RegionUtil.isUK()) {
            currentPage.getMainTransactionsTableView().scrollToItem(getTransactionsTableList(8), ScrollDirection.UP);
            getTransactionsTableList(8).click();
        }else if (RegionUtil.isAisa()){
            currentPage.getMainTransactionsTableView().scrollToItem(getTransactionsTableList(9), ScrollDirection.UP);
            getTransactionsTableList(9).click();
        }
    }

    public void tapsPendingTransactionListDIFFERENT() {
        sleep(200L);
        if (RegionUtil.isUK()) {
            currentPage.getMainTransactionsTableView().scrollToItem(getTransactionsTableList(1), ScrollDirection.UP);
            getTransactionsTableList(1).click();
        }else if (RegionUtil.isAisa()){
            currentPage.getMainTransactionsTableView().scrollToItem(currentPage.getTransactionsTableList0(), ScrollDirection.UP);
            currentPage.getTransactionsTableList0().click();
        }
    }

    public void tapsPendingTransactionListSAME() {
        sleep(200L);
        if (RegionUtil.isUK()) {
            currentPage.getMainTransactionsTableView().scrollToItem(getTransactionsTableList(4), ScrollDirection.UP);
            getTransactionsTableList(4).click();
        }else if (RegionUtil.isAisa()){
            currentPage.getMainTransactionsTableView().scrollToItem(getTransactionsTableList(1), ScrollDirection.UP);
            getTransactionsTableList(1).click();
        }
    }

    public void tapHoldingsList(int num) {

        String portfolioHoldingsList = "portfolio_holdings_list_tableview_cell_";
        BaseWebElement holdingsListElement = new BaseWebElement(portfolioHoldingsList+(num-1));

        if (!holdingsListElement.isVisible()){
            currentPage.getMainHoldingTableview().scrollToItem(holdingsListElement,ScrollDirection.UP);
            holdingsListElement = new BaseWebElement(portfolioHoldingsList+(num-1));
        }

        holdingsListElement.click();

    }

    public void tapCurrencyConversion(){
        currentPage.getMainGbpBtn().click();
    }

    public void tapSubClassToggle() {
        this.tapPortfolioShowSubAssetClass();
    }

    public void checkHoldingsListTWRRNegative() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement percentage = currentPage.getElementById("portfolio_holdings_list_tablecell_weight_label_"+(num - 1));
        if (!percentage.isVisible()){
            if (driverConfig.getDeviceName().equals("E2353")){
                currentPage.getMainHoldingTableview().scroll(ScrollDirection.UP,500L,250);
            }else {
                currentPage.getMainHoldingTableview().scrollToItem(percentage, ScrollDirection.UP);
            }
        }
        Assert.assertTrue(currentPage.getElementById("portfolio_holdings_list_tablecell_arrow_img_"+(num - 1)).isExisted());
        Assert.assertTrue(percentage.getContent().startsWith("-"));
    }

    public void checkHoldingsListTWRRPositive() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement percentage = currentPage.getElementById("portfolio_holdings_list_tablecell_weight_label_"+(num - 1));
        if (!percentage.isVisible()){
            if (driverConfig.getDeviceName().equals("E2353")){
                currentPage.getMainHoldingTableview().scroll(ScrollDirection.UP,500L,250);
            }else {
                currentPage.getMainHoldingTableview().scrollToItem(percentage, ScrollDirection.UP);
            }
        }
        Assert.assertTrue(currentPage.getElementById("portfolio_holdings_list_tablecell_arrow_img_"+(num - 1)).isExisted());
        Assert.assertFalse(percentage.getContent().startsWith("-"));
    }

    public void checkHoldingsListTWRRFormat() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        String performanceId = "portfolio_holdings_list_tablecell_weight_label_";
        String baseAmountId = "portfolio_holdings_list_tablecell_base_amount_label_";
        for (int i = 0; i < num; i++){
            BaseWebElement performance = currentPage.getElementById(performanceId + i);
            BaseWebElement baseAmount = currentPage.getElementById(baseAmountId + i);
            if(!baseAmount.isVisible()){
                currentPage.getMainHoldingTableview().scrollToItem(baseAmount, ScrollDirection.UP);
            }
            if(performance.isVisible() && StringUtils.isNotBlank(performance.getContent())){
                CheckUtil.check2dp(CheckUtil.getAmount(performance.getContent()));
            }
        }
    }

    public void checkHoldingsListTWRRZero() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement percentage = currentPage.getElementById("portfolio_holdings_list_tablecell_weight_label_"+(num - 1));
        if (!percentage.isVisible()){
            currentPage.getMainHoldingTableview().scrollToItem(percentage ,ScrollDirection.UP);
        }
        Assert.assertEquals(percentage.getContent(),"0.00%");
    }

    public void checkHoldingsListNoSymbolAndNoChevron() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement percentage = currentPage.getElementById("portfolio_holdings_list_tablecell_weight_label_"+(num - 1));
        if (!percentage.isVisible()){
            currentPage.getMainHoldingTableview().scrollToItem(percentage, ScrollDirection.UP);
        }
        Assert.assertFalse(percentage.getContent().startsWith("+"));
        Assert.assertFalse(percentage.getContent().startsWith("-"));
        if(driverConfig.getPlatform().equals(Platform.ANDROID)){
            Assert.assertFalse(currentPage.getElementById("portfolio_holdings_list_tablecell_arrow_img_"+(num - 1)).isExisted());
        }
    }

    public void checkPortfolioPerformance(Map<String,String> map, int num) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(map.get("Performance label"),performancePage.getMainPortfolioContent().getContent());
        Assert.assertTrue(performancePage.getMainPortfolioIcon().isExisted());
        if (num == 1){
            Assert.assertTrue(performancePage.getMainPortfolioAmount().getContent().startsWith("-"));
            Assert.assertTrue(performancePage.getMainPortfolioPercentage().getContent().startsWith("-"));
        }else if (num == 2){
            Assert.assertTrue(performancePage.getMainPortfolioAmount().getContent().startsWith("+"));
            Assert.assertTrue(performancePage.getMainPortfolioPercentage().getContent().startsWith("+"));
        }

        Assert.assertTrue(performancePage.getMainPortfolioAmount().isVisible());

    }

    public void checkPortfolioPerformanceCurrencyISO3() {
        sleep(500L);
        captureScreen();
        String performance = performancePage.getMainPortfolioAmount().getContent();
        CheckUtil.checkStringISO3(
                CheckUtil.getCurrency(performance)
        );

        CheckUtil.checkWrapperPerformanceISO3Format(
                performance
        );

    }


    public void checkPortfolioPerformanceValue2pd() {
        sleep(500L);
        captureScreen();
        CheckUtil.check2dp(
                CheckUtil.getAmount(performancePage.getMainPortfolioAmount().getContent())
        );

        CheckUtil.check2dp(
                performancePage.getMainPortfolioPercentage().getContent().replace("%","")
        );
    }

    public void checkPortfolioTWRRZero() {
        Assert.assertEquals(performancePage.getMainPortfolioPercentage().getContent(),"0.00%");
    }

    public void checkPortfolioPerformanceValueZero() {
        Assert.assertEquals(CheckUtil.getAmount(performancePage.getMainPortfolioAmount().getContent()),"0.00");
    }

    public void checkPortfolioTWRRPerformanceNoSymbol() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(performancePage.getMainPortfolioAmount().getContent().startsWith("-"));
        Assert.assertFalse(performancePage.getMainPortfolioAmount().getContent().startsWith("+"));
    }

    public void tapPortfoliosPerformance() {
        elementState.put("performanceValue", performancePage.getMainPortfolioPercentage().getContent());
        performancePage.getMainPortfolioPercentage().click();
    }

    public void onPortfoliosPerformanceOverlay() {
        Assert.assertTrue(globalOverlayPage.getCloseBtn().isVisible());
    }

    public void checkPortfoliosPerformanceOverlayUI(Map<String,String> map,int num) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(map.get("Performance YTD label"),globalOverlayPage.getTitleTxt().getContent());
        Assert.assertTrue(globalOverlayPage.getNameTxt().isVisible());
        Assert.assertEquals(map.get("Profit/loss label"), globalOverlayPage.getHeadingTxt().getContent());
        Assert.assertTrue(globalOverlayPage.getContentTxt().isVisible());
        if (num == 1){
            Assert.assertTrue(globalOverlayPage.getContentTxt().getContent().startsWith("-"));
            Assert.assertTrue(globalOverlayPage.getBottomContentTxt().getContent().startsWith("-"));
        }else if (num == 2){
            Assert.assertTrue(globalOverlayPage.getContentTxt().getContent().startsWith("+"));
            Assert.assertTrue(globalOverlayPage.getBottomContentTxt().getContent().startsWith("+"));
        }

        Assert.assertTrue(globalOverlayPage.getCloseBtn().isVisible());
        Assert.assertEquals(map.get("overlay question"), globalOverlayPage.getCalculatedTxt().getContent());
        Assert.assertEquals(map.get("overlay answer"), globalOverlayPage.getCalculatedValueTxt().getContent());

        Assert.assertEquals(map.get("Performance label"), globalOverlayPage.getBottomHeadingTxt().getContent());
        Assert.assertEquals(map.get("overlay bottom question"), globalOverlayPage.getBottomCalculatedTxt().getContent());
        Assert.assertEquals(map.get("overlay bottom answer"), globalOverlayPage.getBottomCalculatedValueTxt().getContent());
    }

    public void checkPortfoliosPerformanceOverlay2dp() {
        sleep(500L);
        captureScreen();
        CheckUtil.check2dp(
                CheckUtil.getAmount(globalOverlayPage.getContentTxt().getContent())
        );
        CheckUtil.check2dp(
                globalOverlayPage.getBottomContentTxt().getContent().replace("%","")
        );

    }

    public void checkPortfoliosPerformanceOverlayISO3() {
        sleep(100L);
        captureScreen();
        CheckUtil.checkWrapperPerformanceISO3Format(globalOverlayPage.getContentTxt().getContent());
    }

    public void checkPortfoliosPerformanceOverlayTWRRZero() {
        Assert.assertEquals(globalOverlayPage.getBottomContentTxt().getContent(),"0.00%");
    }

    public void checkPortfoliosPerformanceOverlayPerformanceZero() {
        Assert.assertEquals(CheckUtil.getAmount(globalOverlayPage.getContentTxt().getContent()),"0.00");
    }

    public void checkPortfoliosPerformanceOverlayNoSymbol() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(globalOverlayPage.getContentTxt().getContent().startsWith("+"));
        Assert.assertFalse(globalOverlayPage.getContentTxt().getContent().startsWith("-"));
        Assert.assertFalse(globalOverlayPage.getBottomContentTxt().getContent().startsWith("+"));
        Assert.assertFalse(globalOverlayPage.getBottomContentTxt().getContent().startsWith("-"));
    }

    public void checkPortfolioAssetOverlay(String str) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(str,globalOverlayPage.getTitleTxt().getContent());
    }

    public void checkPortfoliosAssert(String asset) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(asset,currentPage.getMainTotalAssetsTxt().getContent());
    }

    public void tapsClosePortfoliosPerformanceOverlay() {
        globalOverlayPage.getCloseBtn().click();
    }

    public void checkPortfoliosPerformanceOverlayClosed() {
        sleep(500L);
        captureScreen();
//        Assert.assertFalse(globalOverlayPage.getOverLayPercentage().isVisible());
//        Assert.assertFalse(globalOverlayPage.getOverLayAmount().isVisible());
        Assert.assertFalse(globalOverlayPage.getContentTxt().isVisible());
//        Assert.assertFalse(globalOverlayPage.getOverLayCalculatedValue().isVisible());
//        Assert.assertFalse(globalOverlayPage.getOverLayCalculated().isVisible());
        Assert.assertFalse(globalOverlayPage.getTitleTxt().isVisible());
    }

    public void tapAnywherePortfoliosPerformanceOverlay() {
        sleep(300L);
        if (driverConfig.getPlatform().equals(Platform.IOS)) {
            globalOverlayPage.getTitleTxt().tapXY(80, 80);
        }else {
            globalOverlayPage.getTitleTxt().tapXY(120, 100);
        }
    }

    public void checkNotContingentLiabilities() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(currentPage.getListContingentLiabilitiesTitleTxt().isVisible());
    }

    public void checkPortfolioHoldingTWRRPositive() {
        sleep(500L);
        captureScreen();
        if (!allocationHoldingListFlow.getHoldingPercentage(3).isVisible()){
            allocationHoldingListPage.getTableView().scroll(ScrollDirection.UP,500L,300);
        }
        Assert.assertTrue(allocationHoldingListFlow.getHoldingImg(3).isExisted());
        Assert.assertFalse(allocationHoldingListFlow.getHoldingPercentage(3).getContent().startsWith("-"));
    }

    public void checkPortfolioHoldingTWRRNegative() {
        sleep(500L);
        captureScreen();
        if (!allocationHoldingListFlow.getHoldingPercentage(2).isVisible()){
            allocationHoldingListPage.getTableView().scroll(ScrollDirection.UP,500L,300);
        }
        Assert.assertTrue(allocationHoldingListFlow.getHoldingImg(2).isExisted());
        Assert.assertTrue(allocationHoldingListFlow.getHoldingPercentage(2).getContent().startsWith("-"));
    }

    public void checkPortfolioHoldingTWRR2dp() {
        sleep(500L);
        captureScreen();
        if (!allocationHoldingListFlow.getHoldingPercentage(2).isVisible()){
            allocationHoldingListPage.getTableView().scrollToTopItem(allocationHoldingListFlow.getHoldingPercentage(2));
        }
        CheckUtil.check2dp(
                CheckUtil.getAmount(allocationHoldingListFlow.getHoldingPercentage(2).getContent())
        );
    }

    public void checkPortfolioHoldingTWRRZero() {
        sleep(500L);
        captureScreen();
        if (!allocationHoldingListFlow.getHoldingPercentage(14).isVisible()){
            allocationHoldingListPage.getTableView().scrollToItem(allocationHoldingListFlow.getHoldingPercentage(14),ScrollDirection.UP);
        }
        Assert.assertEquals(allocationHoldingListFlow.getHoldingPercentage(14).getContent(),"0.00%");
    }

    public void checkPortfolioHoldingTWRRNoSymbolNoChevron() {
        sleep(500L);
        captureScreen();
        if (!allocationHoldingListFlow.getHoldingPercentage(14).isVisible()){
            allocationHoldingListPage.getTableView().scrollToItem(allocationHoldingListFlow.getHoldingPercentage(14),ScrollDirection.UP);
        }

        Assert.assertFalse(allocationHoldingListFlow.getHoldingPercentage(14).getContent().startsWith("+"));
        Assert.assertFalse(allocationHoldingListFlow.getHoldingPercentage(14).getContent().startsWith("-"));
    }

    public void checkPortfolioHoldingWrapperISO3() {
        sleep(500L);
        captureScreen();
        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(allocationHoldingListPage.getAmountNumber().getContent())
        );

        if (driverConfig.getPlatform().equals(Platform.IOS)){
            CheckUtil.checkDataFormat(
                    allocationHoldingListPage.getAmountNumber().getContent()
            );

        }else {

            CheckUtil.checkDataFormat(
                    allocationHoldingListPage.getAmountCurrency().getContent()
            );
        }
    }

    public void viewingTheEndOfHoldingList() {
        currentPage.getMainHoldingTableview().scrollToBottomItem(currentPage.getPortfolioHoldingsListFootView());
    }

    public void checkHoldingListGlobalLegalDisclaimer(String region, String disclaimer) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(RegionUtil.getValue(region, disclaimer),currentPage.getPortfolioHoldingsListFootView().getContent());
    }


    public void viewingTheEndOfTransactionsList() {
        currentPage.getMainTransactionsTableView().scrollToBottomItem(currentPage.getTransactionsFootView());
    }

    public void checkTransactionsListGlobalLegalDisclaimer(String region, String disclaimer) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(RegionUtil.getValue(region, disclaimer),currentPage.getTransactionsFootView().getContent());
    }

    public void viewingTheEndOfLiabilityList() {
        currentPage.getMainLiabilitiesTableView().scrollToBottomItem(currentPage.getLiabilitiesListFootView());
    }

    public void checkLiabilityListGlobalLegalDisclaimer(String region, String disclaimer) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(RegionUtil.getValue(region, disclaimer),currentPage.getLiabilitiesListFootView().getContent());
    }

    public void checkPortfolioHolding() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(allocationHoldingListPage.getBackBtn().isVisible());
        Assert.assertTrue(allocationHoldingListPage.getAmountNumber().isVisible());
        Assert.assertTrue(allocationHoldingListPage.getMenuBtn().isVisible());
        Assert.assertTrue(allocationHoldingListPage.getTableTitle().isVisible());
        Assert.assertTrue(allocationHoldingListPage.getTitleTxt().isVisible());
        Assert.assertTrue(allocationHoldingListPage.getTableView().isVisible());
    }

    public void checkPortfolioAllocationHoldingsPositiveAndDIFFERENT() {
        sleep(500L);
        captureScreen();

        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        allocationHoldingListPage.getTableView().scrollToItem( new BaseWebElement("allocation_holding_list_tablecell_report_amount_label_1_" + (num-1)), ScrollDirection.UP);
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_title_label_1_" + (num-1) ).isVisible());
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num-1)).isVisible());
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_weight_label_1_" + (num-1)).isVisible());
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_arrow_img_1_" + (num-1)).isExisted());
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_report_amount_label_1_" + (num-1)).isVisible());

    }

    public void checkPortfolioAllocationHoldingsPositiveAndDIFFERENTISO3() {
        sleep(500L);
        captureScreen();

        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement holdingBaseAmount = new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num-1));
        BaseWebElement holdingReportAmount = new BaseWebElement("allocation_holding_list_tablecell_report_amount_label_1_" + (num-1));
        allocationHoldingListPage.getTableView().scrollToItem(holdingReportAmount, ScrollDirection.UP);

        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(holdingBaseAmount.getContent())
        );

        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(holdingReportAmount.getContent())
        );
    }

    public void checkPortfolioAllocationHoldingsNegativeAndDIFFERENT() {
        sleep(500L);
        captureScreen();

        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        allocationHoldingListPage.getTableView().scrollToItem( new BaseWebElement("allocation_holding_list_tablecell_report_amount_label_1_" + (num-1)), ScrollDirection.UP);
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_title_label_1_" + (num-1)).isVisible());
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num-1)).isVisible());
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_weight_label_1_" + (num-1)).isVisible());
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_arrow_img_1_" + (num-1)).isExisted());
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_report_amount_label_1_" + (num-1)).isVisible());
    }

    public void checkPortfolioAllocationHoldingNegativeAndDIFFERENT() {
        sleep(500L);
        captureScreen();

        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement holdingBaseAmount = new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num-1));
        BaseWebElement holdingReportAmount = new BaseWebElement("allocation_holding_list_tablecell_report_amount_label_1_" + (num-1));
        allocationHoldingListPage.getTableView().scrollToItem(holdingReportAmount, ScrollDirection.UP);

        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(holdingBaseAmount.getContent())
        );

        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(holdingReportAmount.getContent())
        );
    }

    public void checkPortfolioAllocationHoldingsPositiveAndSAME() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        allocationHoldingListPage.getTableView().scrollToItem( new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num-1)), ScrollDirection.UP);
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_title_label_1_" + (num-1)).isVisible());
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num-1)).isVisible());
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_weight_label_1_" + (num-1)).isVisible());
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_arrow_img_1_" + (num-1)).isExisted());

    }

    public void checkPortfolioAllocationHoldingPositiveAndSAMEISO3() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement holdingBaseAmount = new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num-1));
        allocationHoldingListPage.getTableView().scrollToItem(holdingBaseAmount, ScrollDirection.UP);

        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(holdingBaseAmount.getContent())
        );
    }

    public void checkPortfolioAllocationHoldingsNegativeAndSAME() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        allocationHoldingListPage.getTableView().scrollToItem( new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num-1)), ScrollDirection.DOWN);
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_title_label_1_" + (num-1)).isVisible());
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num-1)).isVisible());
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_weight_label_1_" + (num-1)).isVisible());
        org.testng.Assert.assertTrue(new BaseWebElement("allocation_holding_list_tablecell_arrow_img_1_" + (num-1)).isExisted());

    }

    public void checkPortfolioAllocationHoldingsNegativeAndSAMEISO3() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();

        BaseWebElement holdingBaseAmount = new BaseWebElement("allocation_holding_list_tablecell_base_amount_label_1_" + (num-1));
        allocationHoldingListPage.getTableView().scrollToItem(holdingBaseAmount, ScrollDirection.UP);

        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(holdingBaseAmount.getContent())
        );
    }

    public void tapPortfolioAllocationHoldingList(int num) {
        String allocationHoldingsList = "allocation_holdings_list_tableview_cell_1_";
        BaseWebElement holdingsListElement = new BaseWebElement(allocationHoldingsList+(num-1));

        allocationHoldingListPage.getTableView().scrollToItem(holdingsListElement,ScrollDirection.UP);

        holdingsListElement.click();
    }

    public void checkPortfolioReferenceCurrency(String referenceCurrency) {
        sleep(300L);
        captureScreen();
        Assert.assertEquals(referenceCurrency, CheckUtil.getAmountCurrency(currentPage.getMainTotalAssetsContentTxt()));
    }

    public void checkTotalAssetISO3() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkDataFormat(currentPage.getMainTotalAssetsContentTxt().getContent());
        CheckUtil.checkCurrencyISO3(currentPage.getMainTotalAssetsContentTxt());
    }

    public void checkInAllocation() {
        Assert.assertTrue(currentPage.getAllocationBtnOn().isVisible());
    }

    public void tapPortfolioTotalLiabilities() {
        currentPage.getMainLiabilitesTitleTxt().click();
    }

    public void swapLeftPortfolioTotalLiabilitiesOverlay() {
        sleep(800L);
        captureScreen();
        elementState.put("totalLiabilitiesAmount",CheckUtil.getAmount(currentPage.getMainLiabilitesAmountBtn().getContent()));
        currentPage.getMainTopView().scroll(ScrollDirection.LEFT,500L);

    }

    public void checkPortfolioTotalLiabilitiesOverlayChanged() {
        sleep(500L);
        captureScreen();
        Assert.assertNotEquals(elementState.get("totalLiabilitiesAmount"),CheckUtil.getAmount(globalOverlayPage.getContentTxt().getContent()));
    }

    public void checkPortfolioLiabilitiesUI(Map<String,String> map) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(map.get("header \"Total liabilities\""),currentPage.getMainLiabilitesTitleTxt().getContent());
        Assert.assertTrue(currentPage.getMainLiabilitesIconImg().isExisted());
        Assert.assertTrue(currentPage.getMainLiabilitesAmountBtn().isVisible());
    }

    public void checkClassAndCurrency() {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getAllocationClassBtn().isVisible());
        Assert.assertTrue(currentPage.getAllocationCurrencyBtn().isVisible());
    }

    public void checkNotRegion() {
        Assert.assertFalse(currentPage.getAllocationRegionBtn().isExisted());
    }

    public void swipeLeft() {
        currentPage.getMainTopView().scroll(ScrollDirection.LEFT,500L);
    }

    public void notTransactionFilter() {
        sleep(500L);
        Assert.assertFalse(currentPage.getTransactionsHeadTitle().isVisible());
    }

    public void checkTotalLiabilitiesTMax(int maxNumber) {
        sleep(500L);
        captureScreen();
        String amount = currentPage.getMainLiabilitesAmountBtn().getContent().trim();
        if(amount.indexOf(" ") != -1){
            amount = amount.substring(0, amount.indexOf(" ")).trim();
        }
        Assert.assertTrue(amount.length() <= maxNumber);
    }

    public void checkPortfolioTotalLiabilitiesData() {
        sleep(500L);
        captureScreen();
        CheckUtil.checkCurrencyISO3(currentPage.getMainLiabilitesAmountBtn());
        CheckUtil.checkDataFormat(currentPage.getMainLiabilitesAmountBtn().getContent());
    }

    public void checkPortfolioWrapperTotalLiabilitiesInChanged() {
        sleep(500L);
        captureScreen();
        Assert.assertNotEquals(elementState.get("totalLiabilitiesAmount"),CheckUtil.getAmount(currentPage.getMainLiabilitesAmountBtn().getContent()));
    }

    public void minifilesThePortfolioWrapper() {
        currentPage.getMainHoldingTableview().scroll(ScrollDirection.UP,500L,550);
    }

    public void checkMinifilesPortfolioWrapperUI() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(currentPage.getMainPortfolioIdTxt().isVisible());
        Assert.assertFalse(currentPage.getMainUpdateTimeBtn().isVisible());
        Assert.assertFalse(currentPage.getMainLiabilitesTitleTxt().isVisible());
        Assert.assertFalse(currentPage.getMainLiabilitesAmountBtn().isVisible());
        Assert.assertFalse(currentPage.getMainNetTitleTxt().isVisible());
        Assert.assertFalse(currentPage.getMainNetAmountTxt().isVisible());
    }

    public void checkPortfolioNameAndPortfolioAssets() {
        Assert.assertTrue(currentPage.getMainTitleTxt().isVisible());
        Assert.assertTrue(currentPage.getMainTotalAssetsContentTxt().isVisible());
        Assert.assertTrue(currentPage.getMainTotalAssetsTxt().isVisible());
    }

    public void checkPortfolioLiabilitiesDisplayed(String value) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(value,CheckUtil.getAmount(currentPage.getMainLiabilitesAmountBtn().getContent()));
    }

    public void checkNotPortfoliosTotalLiabilities() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(currentPage.getMainLiabilitesTitleTxt().isVisible());
        Assert.assertFalse(currentPage.getMainLiabilitesAmountBtn().isVisible());
    }

    public void checkNotPortfolioLiabilitiesAndNetAssets() {
        sleep(500L);
        captureScreen();

        Assert.assertFalse(currentPage.getMainLiabilitesTitleTxt().isVisible());
        Assert.assertFalse(currentPage.getMainLiabilitesAmountBtn().isVisible());
        Assert.assertFalse(currentPage.getMainNetTitleTxt().isVisible());
        Assert.assertFalse(currentPage.getMainNetAmountTxt().isVisible());
    }

    public void checkPortfolioNetAssetsUI(Map<String,String> map) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(map.get("header \"Net assets\""),currentPage.getMainNetTitleTxt().getContent());
        Assert.assertEquals(map.get("Net assets currency"),CheckUtil.getCurrency(currentPage.getMainNetAmountTxt().getContent()));
        Assert.assertTrue(currentPage.getMainNetAmountTxt().isVisible());
    }

    public void checkNetAssetsMax(int maxNumber) {
        sleep(500L);
        captureScreen();
        String amount = currentPage.getMainNetAmountTxt().getContent().trim();
        if(amount.indexOf(" ") != -1){
            amount = amount.substring(0, amount.indexOf(" ")).trim();
        }
        Assert.assertTrue(amount.length() <= maxNumber);
    }

    public void checkPortfolioNetAssetsISO3() {
        sleep(500L);
        captureScreen();
        CheckUtil.checkCurrencyISO3(currentPage.getMainNetAmountTxt());
        CheckUtil.checkDataFormat(currentPage.getMainNetAmountTxt().getContent());
    }

    public void checkNetPortfolioAssetsEqualTotalAssetsReductionOfTotalLiabilities() {
        sleep(500L);
        captureScreen();
        Double amount = CheckUtil.getNoISOAmount(currentPage.getMainTotalAssetsContentTxt().getContent())+CheckUtil.getNoISOAmount(currentPage.getMainLiabilitesAmountBtn().getContent());
        Assert.assertTrue(amount==CheckUtil.getNoISOAmount(currentPage.getMainNetAmountTxt().getContent()));
    }

    public void swapLeftPortfolioNetAssets() {
        sleep(800L);
        captureScreen();
        elementState.put("netAssetAmount",CheckUtil.getAmount(currentPage.getMainNetAmountTxt().getContent()));
        currentPage.getMainTopView().scroll(ScrollDirection.LEFT,500L);

    }

    public void checkPortfolioNetAssetsChanged() {
        sleep(500L);
        captureScreen();
        Assert.assertNotEquals(elementState.get("netAssetAmount"),CheckUtil.getAmount(currentPage.getMainNetAmountTxt().getContent()));
    }

    public void checkNotPortfoliosNetAssets() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(currentPage.getMainNetTitleTxt().isVisible());
        Assert.assertFalse(currentPage.getMainNetAmountTxt().isVisible());
    }

    public void checkPortfoliosNetAssets(String value) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(value, CheckUtil.getAmount(currentPage.getMainNetAmountTxt().getContent()));
    }

    public void checkInTransaction() {
        Assert.assertTrue(currentPage.getTransactionsListType0().isExisted());
    }

    public void notSeePendingAndType(int listNum) {
        sleep(200L);
        captureScreen();
        String typePrefix = "portfolio_transactions_list_tablecell_transaction_type_";
        String statusPrefix = "portfolio_transactions_list_tablecell_status_";
        String amountPrefix = "portfolio_transactions_list_tablecell_amount_";
        for (int i=0;i < listNum; i++){
            String typeId = typePrefix + i;
            String statusId = statusPrefix + i;
            String amountId = amountPrefix + i;
            BaseWebElement typeElement = new BaseWebElement(typeId);
            BaseWebElement statusElement = new BaseWebElement(statusId);
            BaseWebElement amountElement = new BaseWebElement(amountId);
            if(!amountElement.isVisible()){
                System.out.println("["+i+"] item not display, will be scroll");
                if (driverConfig.getDeviceName().equals("E2353")){
                    currentPage.getMainTransactionsTableView().scroll(ScrollDirection.UP, 1000L, 250);
                }
                if (driverConfig.getPlatform().equals(Platform.ANDROID)){
                    currentPage.getMainTransactionsTableView().scroll(ScrollDirection.UP, 1000L, 400);
                }else {
                    currentPage.getMainTransactionsTableView().scroll(ScrollDirection.UP, 1000L, 300);
                }
                i--;
                continue;
            }
            Assert.assertFalse("["+i+"] item typeElement is display!", typeElement.isVisible());
            Assert.assertFalse("["+i+"] item status is display!", statusElement.isVisible());
        }
    }

    public void tapFourTransactionItem() {
        if (driverConfig.getPlatform().equals(Platform.ANDROID)){
            currentPage.getMainTransactionsTableView().scroll(ScrollDirection.UP, 1000L, 400);
        }
        currentPage.getMainTransactionsTableView().scrollToItem(getTransactionsTableList(3), ScrollDirection.UP);
        getTransactionsTableList(3).click();
    }

    public void checkLiabilitiesTabs() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(currentPage.getMainLiabilitiesBtn().isVisible());
    }

    public void checkNOTLiabilitiesTabs() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(currentPage.getMainLiabilitiesBtn().isVisible());
    }

    public void checkLiabilityListedUI(Map<String,String> map) {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        //num 从1开始
        BaseWebElement liabilitiesType = new BaseWebElement("portfolio_liabilities_tableview_cell_liability_type_label_" + num);
        if (currentPage.getMainLiabilitiesTableView().isVisible()) {
            currentPage.getMainLiabilitiesTableView().scrollToItem(liabilitiesType, ScrollDirection.UP);
        }else {
            currentPage.getMainTopView().scrollToItem(liabilitiesType,ScrollDirection.UP);
        }

        Assert.assertTrue(new BaseWebElement("portfolio_liabilities_tableview_cell_liability_desciption_label_" + num).isVisible());
        Assert.assertTrue(liabilitiesType.isVisible());
        Assert.assertTrue(new BaseWebElement("portfolio_liabilities_tableview_cell_liability_Ioan_amount_label_" + num).isVisible());
        Assert.assertFalse(new BaseWebElement("portfolio_liabilities_tableview_cell_liability_base_amount_label_" + num).isVisible());
    }

    public void totalValueNegative() {
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        //num 从1开始
        BaseWebElement amount = new BaseWebElement("portfolio_liabilities_tableview_cell_liability_Ioan_amount_label_" + num);
        currentPage.getMainLiabilitiesTableView().scrollToItem(amount, ScrollDirection.UP);
        Assert.assertTrue(amount.getContent().startsWith("-"));
    }

    public void checkLiabilitiesISO3() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        //num 从1开始
        BaseWebElement amount = new BaseWebElement("portfolio_liabilities_tableview_cell_liability_Ioan_amount_label_" + num);
        currentPage.getMainLiabilitiesTableView().scrollToItem(amount, ScrollDirection.UP);

        BaseWebElement currency = new BaseWebElement("portfolio_liabilities_tableview_cell_liability_Ioan_currency_label_" + num);
        CheckUtil.checkCurrencyISO3(amount,currency);
        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(amount.getContent())
        );
    }


    public void checkLiabilitiesOrderedINACTIVE() {
        sleep(500L);
        captureScreen();
        if (!currentPage.getLiabilitiesDescriptionTxt0().isVisible()){
            currentPage.getMainLiabilitiesTableView().scrollToItem(currentPage.getLiabilitiesDescriptionTxt0(),ScrollDirection.DOWN);
        }
        int itemNum = 6;

        Double[] liabilitiesAmount = new Double[itemNum];
        String loadAmountId = "portfolio_liabilities_tableview_cell_liability_Ioan_amount_label_";
        String baseAmountId = "portfolio_liabilities_tableview_cell_liability_base_amount_label_";

        String nextElementTitleId = "portfolio_liabilities_tableview_cell_liability_desciption_label_";
        for (int i = 1; i <= itemNum; i++){
            BaseWebElement loadElement = new BaseWebElement(loadAmountId+i);
            BaseWebElement baseElement = new BaseWebElement(baseAmountId+i);
            if(i < itemNum){
                BaseWebElement nextElementTitle = new BaseWebElement(nextElementTitleId + (i+1));
                if (!loadElement.isVisible() || !nextElementTitle.isVisible()){
                    System.out.println("["+i+"] item not display, will be scroll");
                    if(driverConfig.getDeviceName().equals("E2353")){

                        currentPage.getMainLiabilitiesTableView().scroll(ScrollDirection.UP, 1000L, 300);

                    }else if(driverConfig.getPlatform().equals(Platform.IOS)){
                        currentPage.getMainLiabilitiesTableView().scroll(ScrollDirection.UP, 1000L, 300);
                    }else {
                        currentPage.getMainLiabilitiesTableView().scroll(ScrollDirection.UP, 1000L, 400);
                    }

                    loadElement = new BaseWebElement( loadAmountId+i);
                    baseElement = new BaseWebElement(baseAmountId+i);
                }
            } else if (i == itemNum) {
                currentPage.getMainLiabilitiesTableView().scroll(ScrollDirection.UP, 1000L, 1000);
            }
            if (!baseElement.isVisible()){
                liabilitiesAmount[i-1] = CheckUtil.getNoISOAmount(loadElement.getContent());
            }else {
                liabilitiesAmount[i-1] = CheckUtil.getNoISOAmount(baseElement.getContent());
            }
        }

        for (int i = 0; i < liabilitiesAmount.length - 1; i++){
            Assert.assertTrue("amount order error: ["+liabilitiesAmount[i]+"] and ["+liabilitiesAmount[i + 1]+"]", liabilitiesAmount[i] <= liabilitiesAmount[i + 1]);
        }
    }

    public void checkNoLiabilitiesList(Map<String,String> map) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(map.get("no liability message"),currentPage.getMainLiabilitiesUnavailableTxt().getContent());
    }

    public void checkLiabilityListUIDIFFERENT(Map<String,String> map) {
        sleep(500L);
        captureScreen();

        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        //num 从1开始
        BaseWebElement liabilitiesType = new BaseWebElement("portfolio_liabilities_tableview_cell_liability_type_label_" + num);
        if (currentPage.getMainLiabilitiesTableView().isVisible()) {
            currentPage.getMainLiabilitiesTableView().scrollToItem(liabilitiesType, ScrollDirection.UP);
        }else {
            currentPage.getMainTopView().scrollToItem(liabilitiesType,ScrollDirection.UP);
        }

        Assert.assertTrue(new BaseWebElement("portfolio_liabilities_tableview_cell_liability_desciption_label_" + num).isVisible());
        Assert.assertTrue(liabilitiesType.isVisible());
        Assert.assertTrue(new BaseWebElement("portfolio_liabilities_tableview_cell_liability_Ioan_amount_label_" + num).isVisible());
        Assert.assertTrue(new BaseWebElement("portfolio_liabilities_tableview_cell_liability_base_amount_label_" + num).isVisible());

    }

    public void totalValuesNegative0() {
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        //num 从1开始
        BaseWebElement amount = new BaseWebElement("portfolio_liabilities_tableview_cell_liability_Ioan_amount_label_" + num);
        currentPage.getMainLiabilitiesTableView().scrollToItem(amount, ScrollDirection.UP);
        Assert.assertTrue(amount.getContent().startsWith("-"));
    }

    public void checkLoanCurrencyAndPortfolioBaseCurrencyISO3() {
        sleep(500L);
        captureScreen();
        //Loan Currency
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        //从1开始
        BaseWebElement amount = new BaseWebElement("portfolio_liabilities_tableview_cell_liability_Ioan_amount_label_" + num);
        currentPage.getMainLiabilitiesTableView().scrollToItem(amount, ScrollDirection.UP);

        BaseWebElement currency = new BaseWebElement("portfolio_liabilities_tableview_cell_liability_Ioan_currency_label_" + num);

        CheckUtil.checkCurrencyISO3(amount,currency);
        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(amount.getContent())
        );
        //Base Currency
        CheckUtil.checkCurrencyISO3(new BaseWebElement("portfolio_liabilities_tableview_cell_liability_base_amount_label_" + num));
        CheckUtil.checkDataFormat(
                CheckUtil.getAmount(new BaseWebElement("portfolio_liabilities_tableview_cell_liability_base_amount_label_" + num).getContent())
        );
    }

    public void checkLiabilitiesBaseCurrencyIsZero(String value) {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        //num 从1开始
        BaseWebElement baseAmount = new BaseWebElement("portfolio_liabilities_tableview_cell_liability_base_amount_label_" + num);

        if (currentPage.getMainLiabilitiesTableView().isVisible()) {
            currentPage.getMainLiabilitiesTableView().scrollToItem(baseAmount, ScrollDirection.UP);
        }else {
            currentPage.getMainTopView().scrollToItem(baseAmount,ScrollDirection.UP);
        }
        Assert.assertEquals(value,CheckUtil.getAmount(baseAmount.getContent()));

    }

    public void tapPortfolioTab() {
        currentPage.getMainLiabilitiesBtn().click();
        if (currentPage.getMainLiabilitiesTableView().isVisible()) {
            currentPage.getMainLiabilitiesTableView().scrollToItem(currentPage.getMainLiabilitiesBtn(), ScrollDirection.UP);
        }else {
            currentPage.getWrapperScrollTopView().scroll(ScrollDirection.UP,500L,900);
        }
    }

    public void tapsLiabilityList() {
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();

        //num从1开始
        BaseWebElement liabilities = new BaseWebElement("portfolio_liabilities_tableview_cell_" + num);

        if (currentPage.getMainLiabilitiesTableView().isVisible()) {
            currentPage.getMainLiabilitiesTableView().scrollToItem(liabilities, ScrollDirection.UP);
        }else {
            currentPage.getWrapperScrollTopView().scroll(ScrollDirection.UP,500L,900);
            currentPage.getMainLiabilitiesTableView().scrollToItem(liabilities, ScrollDirection.UP);
        }
        liabilities.click();
    }

    public void tapSubLiability1() {
        if (!currentPage.getSubLiabilitiesList0().isVisible()){
            if (currentPage.getMainLiabilitiesTableView().isVisible()) {
                currentPage.getMainLiabilitiesTableView().scrollToItem(currentPage.getSubLiabilitiesList0(), ScrollDirection.DOWN);
            }else {
                currentPage.getWrapperScrollTopView().scroll(ScrollDirection.UP,500L,900);
                currentPage.getMainLiabilitiesTableView().scrollToItem(currentPage.getSubLiabilitiesList0(), ScrollDirection.DOWN);
            }
        }
        currentPage.getSubLiabilitiesList0().click();
    }

    public void tapLiabilityList1() {
        if (!currentPage.getLiabilitiesList0().isVisible()){
            if (currentPage.getMainLiabilitiesTableView().isVisible()) {
                currentPage.getMainLiabilitiesTableView().scrollToItem(currentPage.getLiabilitiesList0(), ScrollDirection.DOWN);
            }else {
                currentPage.getWrapperScrollTopView().scroll(ScrollDirection.UP,500L,900);
                currentPage.getMainLiabilitiesTableView().scrollToItem(currentPage.getLiabilitiesList0(), ScrollDirection.DOWN);
            }
        }
        currentPage.getLiabilitiesList0().click();
    }

    public void checkLiabilitiesListSwitchingValue(String value) {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(value,currentPage.getLiabilitiesGroupByTypeTxt().getContent());
    }

    public void checkDefaultStateOfLiabilitiesToggle() {
        Assert.assertTrue(currentPage.getLiabilitiesGroupByTypeBtnOff().isVisible());
    }

    public void tapLiabilitiesToggle() {
        if (currentPage.getMainLiabilitiesTableView().isVisible()) {
            currentPage.getMainLiabilitiesTableView().scrollToItem(currentPage.getLiabilitiesGroupByTypeTxt(), ScrollDirection.UP);
        }else {
            currentPage.getWrapperScrollTopView().scrollToItem(currentPage.getLiabilitiesGroupByTypeTxt(),ScrollDirection.UP);
        }
        if (currentPage.getLiabilitiesGroupByTypeBtnOff().isVisible()){
            currentPage.getLiabilitiesGroupByTypeBtnOff().click();
        }else {
            currentPage.getLiabilitiesGroupByTypeBtnOn().click();
        }


    }

    public void checkGroupByLiabilityTypeToggleACTIVE() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(currentPage.getLiabilitiesGroupByTypeBtnOn().isVisible());
    }

    public void checkSubHeaderEqualLiabilityTypeValueSumHideToggle() {
        sleep(500L);
        captureScreen();

        if (!currentPage.getLiabilitiesHeaderAmount0().isVisible()){
            currentPage.getMainLiabilitiesTableView().scrollToItem(currentPage.getLiabilitiesHeaderAmount0(), ScrollDirection.UP);
        }

        double headerValue1 = CheckUtil.getNoISOAmount(currentPage.getLiabilitiesHeaderAmount0().getContent());
        String[] child1 = new String[2];
        child1[0] = currentPage.getSubLiabilitiesBaseAmountTxt0().getContent();

        if (!currentPage.getSubLiabilitiesLoanAmountTxt1().isVisible()){
            currentPage.getMainLiabilitiesTableView().scrollToItem(currentPage.getSubLiabilitiesLoanAmountTxt1(), ScrollDirection.UP);
        }
        child1[1] = currentPage.getSubLiabilitiesLoanAmountTxt1().getContent();
        Assert.assertTrue(headerValue1 == CheckUtil.getNoISOAmount(child1[0])+CheckUtil.getNoISOAmount(child1[1]));

    }

    public void checkLiabilitiesListGroupedByType() {

        sleep(500L);
        captureScreen();

        if (!currentPage.getLiabilitiesHeaderAmount0().isVisible()){
            currentPage.getMainLiabilitiesTableView().scrollToItem(currentPage.getLiabilitiesHeaderAmount0(), ScrollDirection.UP);
        }
        String headerType = currentPage.getLiabilitiesHeaderType0().getContent();
        String[] type = this.getDateListByObjectId(currentPage.getMainLiabilitiesTableView(),"portfolio_liabilities_tableview_cell_liability_type_label_1_",null,1);


        Assert.assertEquals(headerType,type[0]);
        Assert.assertEquals(headerType,type[1]);

        BaseWebElement liabilitiesHeaderAmount1 = currentPage.getElementById("portfolio_liabilities_tableview_header_amount_label_2");
        if (!liabilitiesHeaderAmount1.isVisible()){
            currentPage.getMainLiabilitiesTableView().scrollToItem(liabilitiesHeaderAmount1, ScrollDirection.UP);
        }
        headerType = liabilitiesHeaderAmount1.getContent();
        String[] type2 = this.getDateListByObjectId(currentPage.getMainLiabilitiesTableView(),"portfolio_liabilities_tableview_cell_liability_type_label_2_",null,3);

        Assert.assertEquals(headerType,type2[0]);
        Assert.assertEquals(headerType,type2[1]);
        Assert.assertEquals(headerType,type2[2]);
        Assert.assertEquals(headerType,type2[3]);


    }

    public void checkSubHeaderEqualLiabilityTypeValueSum() {
        sleep(500L);
        captureScreen();
        if (!currentPage.getLiabilitiesHeaderAmount0().isVisible()){
            currentPage.getMainLiabilitiesTableView().scrollToItem(currentPage.getLiabilitiesHeaderAmount0(), ScrollDirection.DOWN);
        }
        double headerValue1 = CheckUtil.getNoISOAmount(currentPage.getLiabilitiesHeaderAmount0().getContent());

        String[] child1 = new String[2];
        child1[0] = currentPage.getSubLiabilitiesBaseAmountTxt0().getContent();

        if (!currentPage.getSubLiabilitiesLoanAmountTxt1().isVisible()){
            currentPage.getMainLiabilitiesTableView().scrollToItem(currentPage.getSubLiabilitiesLoanAmountTxt1(), ScrollDirection.UP);
        }
        child1[1] = currentPage.getSubLiabilitiesLoanAmountTxt1().getContent();

        Assert.assertTrue(headerValue1 == CheckUtil.getNoISOAmount(child1[0])+CheckUtil.getNoISOAmount(child1[1]));

        BaseWebElement liabilitiesHeaderAmount1 = currentPage.getElementById("portfolio_liabilities_tableview_header_amount_label_2");
        if (!liabilitiesHeaderAmount1.isVisible()){
            currentPage.getMainLiabilitiesTableView().scrollToItem(liabilitiesHeaderAmount1, ScrollDirection.UP);
        }

        double headerValue2 = CheckUtil.getNoISOAmount(liabilitiesHeaderAmount1.getContent());
        String[] child2 = new String[4];

        if (!currentPage.getSubLiabilitiesBaseAmountTxt2().isVisible()){
            currentPage.getMainLiabilitiesTableView().scrollToItem(currentPage.getSubLiabilitiesBaseAmountTxt2(), ScrollDirection.UP);
        }
        child2[0] = currentPage.getSubLiabilitiesBaseAmountTxt2().getContent();

        if (!currentPage.getSubLiabilitiesLoanAmountTxt3().isVisible()){
            currentPage.getMainLiabilitiesTableView().scrollToItem(currentPage.getSubLiabilitiesLoanAmountTxt3(), ScrollDirection.UP);
        }
        child2[1] = currentPage.getSubLiabilitiesLoanAmountTxt3().getContent();

        if (!currentPage.getSubLiabilitiesBaseAmountTxt4().isVisible()){
            currentPage.getMainLiabilitiesTableView().scrollToItem(currentPage.getSubLiabilitiesBaseAmountTxt4(), ScrollDirection.UP);
        }
        child2[2] = currentPage.getSubLiabilitiesBaseAmountTxt4().getContent();

        if (!currentPage.getSubLiabilitiesLoanAmountTxt5().isVisible()){
            currentPage.getMainLiabilitiesTableView().scrollToItem(currentPage.getSubLiabilitiesLoanAmountTxt5(), ScrollDirection.UP);
        }
        child2[3] = currentPage.getSubLiabilitiesLoanAmountTxt5().getContent();

        Assert.assertTrue(
                headerValue2 ==
                        CheckUtil.getNoISOAmount(child2[0])+CheckUtil.getNoISOAmount(child2[1])+CheckUtil.getNoISOAmount(child2[2])+CheckUtil.getNoISOAmount(child2[3])
        );


    }

    public void checkLiabilitiesHeaderTypesOrdered() {
        sleep(500L);
        captureScreen();
        if (!currentPage.getLiabilitiesHeaderAmount0().isVisible()){
            currentPage.getMainLiabilitiesTableView().scrollToItem(currentPage.getLiabilitiesHeaderAmount0(), ScrollDirection.DOWN);
        }

        Double headerAmount = CheckUtil.getNoISOAmount(currentPage.getLiabilitiesHeaderAmount0().getContent());
        BaseWebElement liabilitiesHeaderAmount1 = currentPage.getElementById("portfolio_liabilities_tableview_header_amount_label_2");
        if (!liabilitiesHeaderAmount1.isVisible()){
            currentPage.getMainLiabilitiesTableView().scrollToItem(liabilitiesHeaderAmount1, ScrollDirection.UP);
        }
        Assert.assertTrue(headerAmount < CheckUtil.getNoISOAmount(liabilitiesHeaderAmount1.getContent()));
    }

    public void checkLiabilitiesChildOrder() {
        sleep(500L);
        captureScreen();

        if (!currentPage.getSubLiabilitiesLoanAmountTxt0().isVisible()){
            currentPage.getMainLiabilitiesTableView().scrollToItem(currentPage.getSubLiabilitiesLoanAmountTxt0(), ScrollDirection.DOWN);
        }
        Double[] child1 = new Double[2];
        child1[0] = CheckUtil.getNoISOAmount(currentPage.getSubLiabilitiesBaseAmountTxt0().getContent());

        if (!currentPage.getSubLiabilitiesLoanAmountTxt1().isVisible()){
            currentPage.getMainLiabilitiesTableView().scrollToItem(currentPage.getSubLiabilitiesLoanAmountTxt1(), ScrollDirection.UP);
        }
        child1[1] = CheckUtil.getNoISOAmount(currentPage.getSubLiabilitiesLoanAmountTxt1().getContent());

        Assert.assertTrue(child1[0] <= child1[1]);

        Double[] child2 = new Double[4];

        if (!currentPage.getSubLiabilitiesBaseAmountTxt2().isVisible()){
            currentPage.getMainLiabilitiesTableView().scrollToItem(currentPage.getSubLiabilitiesBaseAmountTxt2(), ScrollDirection.UP);
        }
        child2[0] = CheckUtil.getNoISOAmount(currentPage.getSubLiabilitiesBaseAmountTxt2().getContent());

        if (!currentPage.getSubLiabilitiesLoanAmountTxt3().isVisible()){
            currentPage.getMainLiabilitiesTableView().scrollToItem(currentPage.getSubLiabilitiesLoanAmountTxt3(), ScrollDirection.UP);
        }
        child2[1] = CheckUtil.getNoISOAmount(currentPage.getSubLiabilitiesLoanAmountTxt3().getContent());

        if (!currentPage.getSubLiabilitiesBaseAmountTxt4().isVisible()){
            currentPage.getMainLiabilitiesTableView().scrollToItem(currentPage.getSubLiabilitiesBaseAmountTxt4(), ScrollDirection.UP);
        }
        child2[2] = CheckUtil.getNoISOAmount(currentPage.getSubLiabilitiesBaseAmountTxt4().getContent());

        if (!currentPage.getSubLiabilitiesLoanAmountTxt5().isVisible()){
            currentPage.getMainLiabilitiesTableView().scrollToItem(currentPage.getSubLiabilitiesLoanAmountTxt5(), ScrollDirection.UP);
        }
        child2[3] = CheckUtil.getNoISOAmount(currentPage.getSubLiabilitiesLoanAmountTxt5().getContent());

        for(int i = 0; i < child2.length-1;i++ ){

            Assert.assertTrue("Amount["+i+"]: "+child2[i]+"Amount["+(i+1)+"]: "+child2[i+1],child2[i] <= child2[i+1]);
        }
    }

    public void tapPortfolioLiabilitiesTabOff() {
        if (!currentPage.getLiabilitiesGroupByTypeTxt().isVisible()){
            currentPage.getMainLiabilitiesTableView().scrollToItem(currentPage.getLiabilitiesGroupByTypeTxt(),ScrollDirection.DOWN);
        }
        currentPage.getLiabilitiesGroupByTypeBtnOn().click();

    }

    public void checkLiabilitiesToggleINACTIVE() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(currentPage.getLiabilitiesGroupByTypeBtnOff().isVisible());
    }

    public void checkLiabilityToggleNOTSticky() {
        sleep(500L);
        captureScreen();
        currentPage.getMainLiabilitiesTableView().scroll(ScrollDirection.UP,500L,900);
        Assert.assertFalse(currentPage.getLiabilitiesGroupByTypeTxt().isVisible());
    }

    public void checkLiabilitiesReturnDefaultState() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(currentPage.getLiabilitiesHeaderAmount0().isVisible());
        Assert.assertFalse(currentPage.getLiabilitiesHeaderType0().isVisible());
    }

    public void checkLiabilitiesListedNOTGroupedByType() {
        sleep(500L);
        captureScreen();
        if (!currentPage.getLiabilitiesTypeTxt0().isVisible()){
            currentPage.getWrapperScrollTopView().scroll(ScrollDirection.UP,500L,900);
        }

        String type0 = currentPage.getLiabilitiesTypeTxt0().getContent();
        BaseWebElement liabilitiesHeaderType1 = currentPage.getElementById("portfolio_liabilities_tableview_header_liability_type_label_2");
        if (!liabilitiesHeaderType1.isVisible()){
            if (!currentPage.getMainLiabilitiesTableView().isVisible()) {
                currentPage.getWrapperScrollTopView().scroll(ScrollDirection.UP, 500L, 900);
            }
            currentPage.getMainLiabilitiesTableView().scrollToItem(liabilitiesHeaderType1, ScrollDirection.DOWN);
        }
        String type1 = liabilitiesHeaderType1.getContent();

        Assert.assertNotEquals(type0,type1);
    }

    public void swipeLeftSubLiabilityList() {
        sleep(500L);
        captureScreen();
        if (!currentPage.getSubLiabilitiesTypeTxt0().isVisible()){
            if (currentPage.getMainLiabilitiesTableView().isVisible()) {
                currentPage.getMainLiabilitiesTableView().scrollToItem(currentPage.getSubLiabilitiesTypeTxt0(), ScrollDirection.UP);
            }else {
                currentPage.getWrapperScrollTopView().scroll(ScrollDirection.UP,500L,900);
            }
        }
        elementState.put("LiabilitiesTypeTxt",currentPage.getSubLiabilitiesTypeTxt0().getContent());
        currentPage.getMainTopView().scroll(ScrollDirection.LEFT, 2000L);
    }

    public void checkSubLiabilityListChanged() {
        sleep(500L);
        captureScreen();
        if (!currentPage.getSubLiabilitiesTypeTxt0().isVisible()){
            if (currentPage.getMainLiabilitiesTableView().isVisible()) {
                currentPage.getMainLiabilitiesTableView().scrollToItem(currentPage.getSubLiabilitiesTypeTxt0(), ScrollDirection.UP);
            }else {
                currentPage.getWrapperScrollTopView().scroll(ScrollDirection.UP,500L,900);
            }
        }
        Assert.assertNotEquals(elementState.get("LiabilitiesTypeTxt"),currentPage.getSubLiabilitiesTypeTxt0().getContent());
    }

    public void tapsLiabilityList2() {
        if (currentPage.getMainLiabilitiesTableView().isVisible()) {
            currentPage.getMainLiabilitiesTableView().scrollToItem(getLiabilitiesList(1), ScrollDirection.UP);
        } else {
            currentPage.getWrapperScrollTopView().scroll(ScrollDirection.UP, 500L, 900);
            currentPage.getMainLiabilitiesTableView().scrollToItem(getLiabilitiesList(1), ScrollDirection.UP);
        }
        getLiabilitiesList(1).click();
    }

    public void checkDiscretionaryWrapper(int number) {
        sleep(1000L);
        captureScreen();
        Assert.assertTrue(new BaseWebElement("portfolio_holdings_title_label_"+(number-1)).isVisible());
    }

    public void swipeLeftOtherPortfolio(int num) {
        for (int i = 0; i < num; i++){
            currentPage.getMainTopView().scroll(ScrollDirection.LEFT,500L);
        }
    }

    public void swipeRightOtherPortfolio(int num) {
        for (int i = 0; i < num; i++){
            currentPage.getMainTopView().scroll(ScrollDirection.RIGHT,500L);
        }
    }

    public void checkAdvisoryWrapper(int number, Map<String, String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertEquals(map.get("portfolio name"), new BaseWebElement("portfolio_holdings_title_label_"+(number-1)).getContent());
    }

    public void tapPortfolioTotalAsset(int num) {
        new BaseWebElement("portfolio_holdings_total_assets_label_"+(num-1)).click();
    }

    public void checkDiscretionaryOverlay() {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(globalOverlayPage.getNameTxt().isVisible());
    }

    public void checkAdvisoryOverlay(Map<String,String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertEquals(map.get("portfolio name"), globalOverlayPage.getNameTxt().getContent());
    }

    public void clickLiabilityOverlayCloseButton() {
        globalOverlayPage.getCloseBtn().click();
    }

    public void checkDiscretionaryLiabilityOverlay() {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(globalOverlayPage.getNameTxt().isVisible());
    }

    public void checkAdvisoryLiabilityOverlay(Map<String,String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertEquals(map.get("portfolio name"), globalOverlayPage.getNameTxt().getContent());
    }

    public void checkDiscretionaryAllocationHoldingList() {
        sleep(300L);
        captureScreen();
        Assert.assertFalse(allocationHoldingListPage.getBackBtn().getContent().isEmpty());
    }

    public void checkAdvisoryAllocationHoldingList(Map<String,String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertEquals(map.get("back button label"), allocationHoldingListPage.getBackBtn().getContent().trim());
    }

    public void checkNotPerformance() {
        sleep(300L);
        captureScreen();
        Assert.assertFalse(performancePage.getMainPortfolioContent().isExisted());
    }

    public void checkHoldingPerformance() {
        sleep(300L);
        captureScreen();

        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement performance = new BaseWebElement("portfolio_holdings_list_tablecell_performance_amount_" + (num-1));
        currentPage.getMainHoldingTableview().scrollToItem(performance, ScrollDirection.UP);
        Assert.assertTrue(performance.isVisible());
    }

    public void checkHoldingNotPerformance() {
        sleep(300L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement performance = new BaseWebElement("portfolio_holdings_list_tablecell_performance_amount_" + (num-1));
        currentPage.getMainHoldingTableview().scrollToItem(performance, ScrollDirection.UP);

        Assert.assertFalse(performance.isVisible());
    }

    public void tapShowSubClassToON() {
        currentPage.getSubClassOffBtn().click();
    }

    public void checkPortfolioWarpperPerformance(Map<String, String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertEquals(map.get("\"Performance year to date\" label"), performancePage.getMainPortfolioContent().getContent());
        Assert.assertTrue(performancePage.getMainPortfolioIcon().isExisted());
        Assert.assertTrue(performancePage.getMainPortfolioAmount().isExisted());
    }

    public void checkPerformanceDateFormat() {
        sleep(100L);
        captureScreen();
        String performanceValue = performancePage.getMainPortfolioAmount().getContent();
        System.out.println("value:"+performanceValue);
        System.out.println("indexOf:"+performanceValue.indexOf("as of"));
        CheckUtil.checkSimpleMonthDateFormat(performanceValue.substring(performanceValue.indexOf("of") + 2).trim());
    }

    public void checkDiscretionaryPerformanceOverlayUI(Map<String, String> map) {
        sleep(300L);
        captureScreen();
        globalOverlayFlow.assertIsDisplayed(map);
    }

    public void checkDiscretionaryPerformanceOverlayDateFormat() {
        sleep(100L);
        captureScreen();
        String performanceOverlayContent = globalOverlayPage.getContentTxt().getContent();
        CheckUtil.checkSimpleMonthDateFormat(performanceOverlayContent.substring(performanceOverlayContent.indexOf("of") + 2).trim());
    }

    public void clickLegalDisclaimerOverlayCloseButton() {
        importantPage.getMainCloseBtn().click();
    }

    public void tapsPortfolioHoldingListLinkToLegalDisclaimer() {

        int x = currentPage.getPortfolioHoldingsListFootView().getRect().getX();
        int y = currentPage.getPortfolioHoldingsListFootView().getRect().getY();
        int width = currentPage.getPortfolioHoldingsListFootView().getRect().getWidth();
        int height = currentPage.getPortfolioHoldingsListFootView().getRect().getHeight();

        x = x + width * 9 / 10;
        y = y + height / 2;
        currentPage.getPortfolioHoldingsListFootView().tapXY(x, y);
    }

    public void tapsPortfolioTransactionsListLinkToLegalDisclaimer() {

        int x = currentPage.getTransactionsFootView().getRect().getX();
        int y = currentPage.getTransactionsFootView().getRect().getY();
        int width = currentPage.getTransactionsFootView().getRect().getWidth();
        int height = currentPage.getTransactionsFootView().getRect().getHeight();

        x = x + width * 9 / 10;
        y = y + height / 2;
        currentPage.getTransactionsFootView().tapXY(x, y);
    }

    public void tapsPortfolioLiabilitiesListLinkToLegalDisclaimer() {

        int x = currentPage.getLiabilitiesListFootView().getRect().getX();
        int y = currentPage.getLiabilitiesListFootView().getRect().getY();
        int width = currentPage.getLiabilitiesListFootView().getRect().getWidth();
        int height = currentPage.getLiabilitiesListFootView().getRect().getHeight();

        x = x + width * 9 / 10;
        y = y + height / 2;
        currentPage.getLiabilitiesListFootView().tapXY(x, y);
    }

    public void returnToPortfolioLiabilityList() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(currentPage.getLiabilitiesListFootView().isVisible());
    }

    public void returnToPortfolioTransactionList() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(currentPage.getTransactionsFootView().isVisible());
    }

    public void returnToPortfolioHoldingList() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(currentPage.getPortfolioHoldingsListFootView().isVisible());
    }

    public void checkPortfolioPerformanceValue() {
        sleep(300L);
        captureScreen();
        Assert.assertEquals(elementState.get("performanceValue"), globalOverlayPage.getContentTxt().getContent().trim());
    }

    public void checkPortfolioTotalAssetsEqualPortfolioTotalAssetsOverlay() {
        sleep(500L);
        captureScreen();
        Assert.assertEquals(elementState.get("portfolio total assets"),globalOverlayPage.getContentTxt().getContent().trim());
    }

    private BaseWebElement getMainHoldingTitleTxt(int index) {
        return currentPage.getElementById("portfolio_holdings_list_tablecell_title_label_" + index);
    }

    private BaseWebElement getTransactionsTableList(int index) {
        return currentPage.getElementById("portfolio_transactions_list_tablecell_" + index);
    }

    private BaseWebElement getPortfolioCurrencyList(int index) {
        return currentPage.getElementById("portfolios_currency_tableview_cell_0_" + index);
    }

    private BaseWebElement getLiabilitiesList(int index) {
        return currentPage.getElementById("portfolio_liabilities_tableview_cell_" + index);
    }

    public void returnedBackToPortfolioPage() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(currentPage.getMainTotalAssetsTxt().isVisible());
    }

    public void checkPortfolioWrapperMaximised() {
        Assert.assertTrue(currentPage.getMainPortfolioIdTxt().isVisible());
    }

    public void slidingUpOnPortfolio() {
        if(driverConfig.getPlatform().equals(Platform.ANDROID)){
            currentPage.getMainHoldingTableview().scroll(ScrollDirection.UP,250L,670);
        } else {
            currentPage.getMainHoldingTableview().scrollIOS(ScrollDirection.UP,250L,670);
        }

    }

    public void checkPortfolioWrapperMinimised() {
        Assert.assertFalse(currentPage.getMainPortfolioIdTxt().isVisible());
    }

}
