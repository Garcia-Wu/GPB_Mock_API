package com.gt.projects.bdd.hsbc_gbm.flow;

import com.gt.projects.bdd.base.BaseFlow;
import com.gt.projects.bdd.base.config.DriverConfig;
import com.gt.projects.bdd.base.enums.ScrollDirection;
import com.gt.projects.bdd.hsbc_gbm.page.HoldingsDetailPage;
import com.gt.projects.bdd.hsbc_gbm.util.CheckUtil;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Scope("thread")
public class HoldingsDetailFlow extends BaseFlow<HoldingsDetailPage> {

    @Autowired
    private DriverConfig driverConfig;

    @Autowired
    private AllocationGraphicFlow allocationGraphicFlow;

    protected HoldingsDetailFlow(HoldingsDetailPage currentPage) {
        super(currentPage);
    }

    public void onPortfoliosHoldingsDetailsLevel() {
        sleep(300L);
        Assert.assertTrue(currentPage.getNameTxt().isExisted());
    }

    public void checkEquitiesDetailUI(Map<String,String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getNameTxt().isVisible());
        Assert.assertTrue(currentPage.getIsinTxt().isVisible());

        Assert.assertEquals(map.get("\"Number of shares\" label"),(currentPage.getEquitiesNumber().getContent()));
        Assert.assertTrue(currentPage.getEquitiesNumberValue().isVisible());
//        Assert.assertEquals(map.get("\"Total value\" label"),(currentPage.getEquitiesMarket().getContent()));
        Assert.assertTrue(currentPage.getEquitiesMarketBaseAmount().isVisible());
        if (currentPage.getEquitiesMarketReportAmount().isVisible()) {
            Assert.assertTrue(currentPage.getEquitiesMarketReportAmount().isVisible());
        }
        Assert.assertEquals(map.get("\"Unrealised P/L\" label"),(currentPage.getEquitiesPL().getContent()));
        Assert.assertTrue(currentPage.getEquitiesPLValue().isVisible());
        Assert.assertEquals(map.get("\"Average Purchase Price\" label"),(currentPage.getEquitiesPurchasePrice().getContent()));
        Assert.assertTrue(currentPage.getEquitiesPurchasePriceAmount().isVisible());
        Assert.assertEquals(map.get("\"Last closing price\" label"),(currentPage.getEquitiesClosingPrice().getContent()));
        Assert.assertTrue(currentPage.getEquitiesClosingPriceAmount().isVisible());
        Assert.assertEquals(map.get("\"Last closing price date\" label"),(currentPage.getEquitiesMarketPriceDate().getContent()));
        Assert.assertTrue(currentPage.getEquitiesMarketPriceDateValue().isVisible());
        Assert.assertEquals(map.get("\"Sector\" label"),(currentPage.getEquitiesSector().getContent()));
        Assert.assertTrue(currentPage.getEquitiesSectorValue().isVisible());
        Assert.assertEquals(map.get("\"Last purchase date\" label"),(currentPage.getEquitiesPurchaseDate().getContent()));
        Assert.assertTrue(currentPage.getEquitiesPurchaseDateValue().isVisible());
        Assert.assertEquals(map.get("\"Country\" label"),(currentPage.getEquitiesCountry().getContent()));
        Assert.assertTrue(currentPage.getEquitiesCountryValue().isVisible());
        Assert.assertTrue(currentPage.getEquitiesCountryValue().isVisible());

        if(!currentPage.getDisclaimer().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);
        }
        Assert.assertEquals(map.get("Disclaimer label"), currentPage.getDisclaimer().getContent());
    }

    public void checkEquitiesNum() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkDetailDateFormat(currentPage.getEquitiesMarketBaseAmount().getContent());
        CheckUtil.checkDetailDateFormat(currentPage.getEquitiesPurchasePriceAmount().getContent());
        CheckUtil.checkDetailDateFormat(currentPage.getEquitiesClosingPriceAmount().getContent());

        CheckUtil.checkCurrencyISO3(currentPage.getEquitiesMarketBaseAmount(), currentPage.getEquitiesMarketBaseCurrency());
        CheckUtil.checkCurrencyISO3(currentPage.getEquitiesPurchasePriceAmount(), currentPage.getEquitiesPurchasePriceCurrency());
        CheckUtil.checkCurrencyISO3(currentPage.getEquitiesClosingPriceAmount(), currentPage.getEquitiesClosingPriceCurrency());

        if (currentPage.getEquitiesMarketReportAmount().isVisible()){
            CheckUtil.checkCurrencyISO3(currentPage.getEquitiesMarketReportAmount(), currentPage.getEquitiesMarketReportCurrency());
            CheckUtil.checkDetailDateFormat(currentPage.getEquitiesMarketReportAmount().getContent());
        }

    }

    public void checkEquitiesDateFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getEquitiesPurchaseDateValue().getContent());
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getEquitiesMarketPriceDateValue().getContent());
    }

    public void checkPreciousMetalsDetailUI(Map<String,String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getNameTxt().isVisible());
        Assert.assertTrue(currentPage.getIsinTxt().isVisible());
        Assert.assertEquals(map.get("“Quantity” label"), currentPage.getPreciousMetalsQuantity().getContent());
        Assert.assertTrue(currentPage.getPreciousMetalsQuantityValue().isVisible());
        Assert.assertEquals(map.get("\"Unrealised P/L\" label"), currentPage.getPreciousMetalsPL().getContent());
        Assert.assertTrue(currentPage.getPreciousMetalsPLValue().isVisible());
//        Assert.assertEquals(map.get("“Total value” label"), currentPage.getPreciousMetalsMarket().getContent());
        Assert.assertTrue(currentPage.getPreciousMetalsMarketBaseAmount().isVisible());
        if (currentPage.getPreciousMetalsMarketReportAmount().isVisible()) {
            Assert.assertTrue(currentPage.getPreciousMetalsMarketReportAmount().isVisible());
        }
        Assert.assertEquals(map.get("\"Average purchase price\" label"), currentPage.getPreciousMetalsPurchasePrice().getContent());
        Assert.assertTrue(currentPage.getPreciousMetalsPurchasePriceAmount().isVisible());
        Assert.assertEquals(map.get("“Last purchase date” label"), currentPage.getPreciousMetalsPurchaseDate().getContent());
        Assert.assertTrue(currentPage.getPreciousMetalsPurchaseDateValue().isVisible());
        Assert.assertEquals(map.get("\"Market price\" label"), currentPage.getPreciousMetalsClosingPrice().getContent());
        Assert.assertTrue(currentPage.getPreciousMetalsClosingPriceAmount().isVisible());
        Assert.assertEquals(map.get("\"Market price date\" label"), currentPage.getPreciousMetalsClosingPriceDate().getContent());
        Assert.assertTrue(currentPage.getPreciousMetalsClosingPriceDateValue().isVisible());
        if(!currentPage.getDisclaimer().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);
        }
        Assert.assertEquals(map.get("Disclaimer"), currentPage.getDisclaimer().getContent());
    }

    public void checkPreciousMetalsDataFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkDetailDateFormat(currentPage.getPreciousMetalsMarketBaseAmount().getContent());
        if (currentPage.getPreciousMetalsMarketReportAmount().isVisible()) {
            CheckUtil.checkDetailDateFormat(currentPage.getPreciousMetalsMarketReportAmount().getContent());
            CheckUtil.checkCurrencyISO3(currentPage.getPreciousMetalsMarketReportAmount(),currentPage.getPreciousMetalsMarketReportCurrency());
        }
        CheckUtil.checkDetailDateFormat(currentPage.getPreciousMetalsPurchasePriceAmount().getContent());
        CheckUtil.checkDetailDateFormat(currentPage.getPreciousMetalsClosingPriceAmount().getContent());
        CheckUtil.checkCurrencyISO3(currentPage.getPreciousMetalsMarketBaseAmount(),currentPage.getPreciousMetalsMarketBaseCurrency());
        CheckUtil.checkCurrencyISO3(currentPage.getPreciousMetalsPurchasePriceAmount(),currentPage.getPreciousMetalsPurchasePriceCurrency());
        CheckUtil.checkCurrencyISO3(currentPage.getPreciousMetalsClosingPriceAmount(),currentPage.getPreciousMetalsClosingPriceCurrency());
    }

    public void checkPreciousMetalsDateFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getPreciousMetalsClosingPriceDateValue().getContent());
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getPreciousMetalsPurchaseDateValue().getContent());
    }

    public void checkFundsDateUI(Map<String,String> map) {
        sleep(300L);

        captureScreen();
        Assert.assertTrue(currentPage.getNameTxt().isVisible());
        Assert.assertTrue(currentPage.getIsinTxt().isVisible());
        Assert.assertEquals(map.get("\"Units\" label"),(currentPage.getFundsNumber().getContent()));
        Assert.assertTrue(currentPage.getFundsNumberValue().isVisible());
        Assert.assertEquals(map.get("\"Total value\" label"),(currentPage.getFundsMarket().getContent()));
        Assert.assertTrue(currentPage.getFundsMarketBaseAmount().isVisible());
        if (currentPage.getFundsMarketReportAmount().isVisible()) {
            Assert.assertTrue(currentPage.getFundsMarketReportAmount().isVisible());
        }
        Assert.assertEquals(map.get("\"Unrealised P/L\" label"),(currentPage.getFundsPL().getContent()));
        Assert.assertTrue(currentPage.getFundsPLValue().isVisible());
        Assert.assertEquals(map.get("\"Average purchase price\" label"),(currentPage.getFundsPurchasePrice().getContent()));
        Assert.assertTrue(currentPage.getFundsPurchasePriceAmount().isVisible());
        Assert.assertEquals(map.get("\"Last purchase date\" label"),(currentPage.getFundsPurchaseDate().getContent()));
        Assert.assertTrue(currentPage.getFundsPurchaseDateValue().isVisible());
        Assert.assertEquals(map.get("\"Market price\" label"),(currentPage.getFundsClosingPrice().getContent()));
        Assert.assertTrue(currentPage.getFundsClosingPriceAmount().isVisible());
        Assert.assertEquals(map.get("\"Market price date\" label"),(currentPage.getFundsMarketPriceDate().getContent()));
        Assert.assertTrue(currentPage.getFundsMarketPriceDateValue().isVisible());
        Assert.assertEquals(map.get("\"Sector\" label"),(currentPage.getFundsSector().getContent()));
        Assert.assertTrue(currentPage.getFundsSectorValue().isVisible());

        if(!currentPage.getDisclaimer().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);
        }
        Assert.assertEquals(map.get("Disclaimer"),(currentPage.getDisclaimer().getContent()));

    }

    public void checkFundsDataFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkDetailDateFormat(currentPage.getFundsMarketBaseAmount().getContent());
        CheckUtil.checkDetailDateFormat(currentPage.getFundsPurchasePriceAmount().getContent());
        CheckUtil.checkDetailDateFormat(currentPage.getFundsClosingPriceAmount().getContent());

        CheckUtil.checkCurrencyISO3(currentPage.getFundsMarketBaseAmount(), currentPage.getFundsMarketBaseCurrency());

        if (currentPage.getFundsMarketReportAmount().isVisible()) {
            CheckUtil.checkDetailDateFormat(currentPage.getFundsMarketReportAmount().getContent());
            CheckUtil.checkCurrencyISO3(currentPage.getFundsMarketReportAmount(), currentPage.getFundsMarketReportCurrency());
        }
        CheckUtil.checkCurrencyISO3(currentPage.getFundsPurchasePriceAmount(), currentPage.getFundsPurchasePriceCurrency());
        CheckUtil.checkCurrencyISO3(currentPage.getFundsClosingPriceAmount(), currentPage.getFundsClosingPriceCurrency());
    }

    public void checkFundsDateFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getFundsMarketPriceDateValue().getContent());
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getFundsPurchaseDateValue().getContent());
    }

    public void checkFundsPart2DateUI(Map<String,String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getNameTxt().isVisible());
        Assert.assertTrue(currentPage.getIsinTxt().isVisible());
        Assert.assertEquals(map.get("\"Total value\" label"),(currentPage.getFundsMarket().getContent()));
        Assert.assertTrue(currentPage.getFundsMarketBaseAmount().isVisible());
        if (currentPage.getFundsMarketReportAmount().isVisible()) {
            Assert.assertTrue(currentPage.getFundsMarketReportAmount().isVisible());
        }
        Assert.assertEquals(map.get("\"Market price\" label"),(currentPage.getFundsClosingPrice().getContent()));
        Assert.assertTrue(currentPage.getFundsClosingPriceAmount().isVisible());
        Assert.assertEquals(map.get("\"Market price date\" label"),(currentPage.getFundsMarketPriceDate().getContent()));
        Assert.assertTrue(currentPage.getFundsMarketPriceDateValue().isVisible());
        Assert.assertEquals(map.get("\"Amount\" label"),(currentPage.getFundsAmount().getContent()));
        Assert.assertTrue(currentPage.getFundsAmountValue().isVisible());
        Assert.assertEquals(map.get("\"Last purchase date\" label"),(currentPage.getFundsPurchaseDate().getContent()));
        Assert.assertTrue(currentPage.getFundsPurchaseDateValue().isVisible());
        Assert.assertEquals(map.get("\"Sector\" label"),(currentPage.getFundsSector().getContent()));
        Assert.assertTrue(currentPage.getFundsSectorValue().isVisible());

        if(!currentPage.getDisclaimer().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);
        }
        Assert.assertEquals(map.get("Disclaimer"),(currentPage.getDisclaimer().getContent()));
    }

    public void checkFundsPart2DataFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkDetailDateFormat(currentPage.getFundsMarketBaseAmount().getContent());

        CheckUtil.checkDetailDateFormat(currentPage.getFundsClosingPriceAmount().getContent());

        CheckUtil.checkCurrencyISO3(currentPage.getFundsMarketBaseAmount(), currentPage.getFundsMarketBaseCurrency());

        if (currentPage.getFundsMarketReportAmount().isVisible()) {
            CheckUtil.checkDetailDateFormat(currentPage.getFundsMarketReportAmount().getContent());
            CheckUtil.checkCurrencyISO3(currentPage.getFundsMarketReportAmount(), currentPage.getFundsMarketReportCurrency());
        }

        CheckUtil.checkCurrencyISO3(currentPage.getFundsClosingPriceAmount(), currentPage.getFundsClosingPriceCurrency());
    }

    public void checkFundsPart2DateFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getFundsMarketPriceDateValue().getContent());
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getFundsPurchaseDateValue().getContent());
    }

    public void checkCurrentAccountsDataUI(Map<String,String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getNameTxt().isVisible());
        Assert.assertTrue(currentPage.getIsinTxt().isVisible());
        Assert.assertEquals(map.get("\"Balance\" label"),(currentPage.getBlockedCurrentBalance().getContent()));
        Assert.assertTrue(currentPage.getBlockedCurrentBalanceBaseAmount().isVisible());
        if (currentPage.getBlockedCurrentBalanceReportAmount().isVisible()) {
            Assert.assertTrue(currentPage.getBlockedCurrentBalanceReportAmount().isVisible());
        }
//        Assert.assertEquals(map.get("\"Average price\" label"),(currentPage.getBlockedCurrentAveragePrice().getContent()));
//        Assert.assertTrue(currentPage.getBlockedCurrentAveragePriceAmount().isVisible());

        if(!currentPage.getDisclaimer().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);
        }
        Assert.assertEquals(map.get("Disclaimer"),currentPage.getDisclaimer().getContent());
    }

    public void checkCurrentAccountsBlockedCurrentAccountsDataFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkDetailDateFormat(currentPage.getBlockedCurrentBalanceBaseAmount().getContent());
//        CheckUtil.checkDetailDateFormat(currentPage.getBlockedCurrentAveragePriceAmount().getContent());

        CheckUtil.checkCurrencyISO3(currentPage.getBlockedCurrentBalanceBaseAmount(), currentPage.getBlockedCurrentBalanceBaseCurrency());

        if (currentPage.getBlockedCurrentBalanceReportAmount().isVisible()) {
            CheckUtil.checkDetailDateFormat(currentPage.getBlockedCurrentBalanceReportAmount().getContent());
            CheckUtil.checkCurrencyISO3(currentPage.getBlockedCurrentBalanceReportAmount(), currentPage.getBlockedCurrentBalanceReportCurrency());
        }

    }

    public void checkMetalOuncesDataUI(Map<String,String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getNameTxt().isVisible());
        Assert.assertTrue(currentPage.getIsinTxt().isVisible());
        Assert.assertEquals(map.get("\"Quantity\" label"),(currentPage.getMetalOuncesQuantity().getContent()));
        Assert.assertTrue(currentPage.getMetalOuncesQuantityValue().isVisible());
//        Assert.assertEquals(map.get("\"Total value\" label"),(currentPage.getMetalOuncesMarket().getContent()));
        Assert.assertTrue(currentPage.getMetalOuncesMarketAmount().isVisible());
        if(!currentPage.getDisclaimer().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);
        }
        Assert.assertEquals(map.get("\"Disclaimer\" label"),(currentPage.getDisclaimer().getContent()));
    }

    public void checkMetalOuncesDataFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkDetailDateFormat(currentPage.getMetalOuncesMarketAmount().getContent());
        CheckUtil.checkCurrencyISO3(currentPage.getMetalOuncesMarketAmount(), currentPage.getMetalOuncesMarketCurrency());
    }

    public void checkDirectInvestmentsDataUI(Map<String,String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getNameTxt().isVisible());
        Assert.assertTrue(currentPage.getIsinTxt().isVisible());
        Assert.assertEquals(map.get("\"Total amount\" label"),(currentPage.getDirectInvestmentsTotal().getContent()));
        Assert.assertTrue(currentPage.getDirectInvestmentsTotalBaseAmount().isVisible());
        if (currentPage.getDirectInvestmentsTotalReportAmount().isVisible()) {
            Assert.assertTrue(currentPage.getDirectInvestmentsTotalReportAmount().isVisible());
        }
        if(!currentPage.getDisclaimer().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);
        }
        Assert.assertEquals(map.get("Disclaimer"),(currentPage.getDisclaimer().getContent()));
    }

    public void checkDirectInvestmentsDataFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkDetailDateFormat(currentPage.getDirectInvestmentsTotalBaseAmount().getContent());

        if (currentPage.getDirectInvestmentsTotalReportAmount().isVisible()) {
            CheckUtil.checkDetailDateFormat(currentPage.getDirectInvestmentsTotalReportAmount().getContent());
            CheckUtil.checkCurrencyISO3(currentPage.getDirectInvestmentsTotalReportAmount(), currentPage.getDirectInvestmentsTotalReportCurrency());
        }

        CheckUtil.checkCurrencyISO3(currentPage.getDirectInvestmentsTotalBaseAmount(), currentPage.getDirectInvestmentsTotalBaseCurrency());
    }

    public void checkDerivativesDataUI(Map<String,String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getNameTxt().isVisible());
        Assert.assertTrue(currentPage.getIsinTxt().isVisible());
        Assert.assertEquals(map.get("\"Quantity\" label"),(currentPage.getDerivativesQuantity().getContent()));
        Assert.assertTrue(currentPage.getDerivativesQuantityValue().isVisible());
        Assert.assertEquals(map.get("\"Expiry date\" label"),(currentPage.getDerivativesExpiryDate().getContent()));
        Assert.assertTrue(currentPage.getDerivativesExpiryDateValue().isVisible());
        Assert.assertEquals(map.get("\"Total value\" (label)"),(currentPage.getDerivativesMarket().getContent()));
        Assert.assertTrue(currentPage.getDerivativesMarketBaseAmount().isVisible());
        if (currentPage.getDerivativesMarketReportAmount().isVisible()) {
            Assert.assertTrue(currentPage.getDerivativesMarketReportAmount().isVisible());
        }
        Assert.assertEquals(map.get("\"Unrealised P/L\" label"),(currentPage.getDerivativesPL().getContent()));
        Assert.assertTrue(currentPage.getDerivativesPLValue().isVisible());

        Assert.assertEquals(map.get("\"Average option premium\" label"),(currentPage.getDerivativesAverageOptionPremium().getContent()));
        Assert.assertTrue(currentPage.getDerivativesAverageOptionPremiumValue().isVisible());

        currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);

        Assert.assertEquals(map.get("\"Last transaction date\" label"),(currentPage.getDerivativesTransactionDate().getContent()));
        Assert.assertTrue(currentPage.getDerivativesTransactionDateValue().isVisible());
        Assert.assertEquals(map.get("\"Indicative market price\" label"),(currentPage.getDerivativesIndicativeMarketPrice().getContent()));
        Assert.assertTrue(currentPage.getDerivativesIndicativeMarketPriceValue().isVisible());
        Assert.assertEquals(map.get("\"Indicative market price date\" label"),(currentPage.getDerivativesIndicativeMarketPriceDate().getContent()));
        Assert.assertTrue(currentPage.getDerivativesIndicativeMarketPriceDateValue().isVisible());

        if(!currentPage.getDisclaimer().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);
        }
        Assert.assertEquals(map.get("Disclaimer"),(currentPage.getDisclaimer().getContent()));
    }

    public void checkDerivatives1DataFormat() {
        sleep(300L);
        captureScreen();
        if (!currentPage.getDerivativesMarketBaseAmount().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.DOWN, 1000L, 1000);
        }
        CheckUtil.checkDetailDateFormat(currentPage.getDerivativesMarketBaseAmount().getContent());

        if (currentPage.getDerivativesMarketReportAmount().isVisible()) {
            CheckUtil.checkDetailDateFormat(currentPage.getDerivativesMarketReportAmount().getContent());
            CheckUtil.checkCurrencyISO3(currentPage.getDerivativesMarketReportAmount(), currentPage.getDerivativesMarketReportCurrency());
        }

        CheckUtil.checkCurrencyISO3(currentPage.getDerivativesMarketBaseAmount(), currentPage.getDerivativesMarketBaseCurrency());
    }

    public void checkDerivatives1DateFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getDerivativesExpiryDateValue().getContent());
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getDerivativesTransactionDateValue().getContent());
        if (!currentPage.getDerivativesIndicativeMarketPriceDateValue().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);
        }
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getDerivativesIndicativeMarketPriceDateValue().getContent());
    }

    public void checkDerivatives2DataUI(Map<String,String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getNameTxt().isVisible());
        Assert.assertTrue(currentPage.getIsinTxt().isVisible());
        Assert.assertEquals(map.get("\"Total value\" label"),currentPage.getDerivativesMarket().getContent());
        Assert.assertTrue(currentPage.getDerivativesMarketBaseAmount().isVisible());
        if (currentPage.getDerivativesMarketReportAmount().isVisible()) {
            Assert.assertTrue(currentPage.getDerivativesMarketReportAmount().isVisible());
        }
        Assert.assertEquals(map.get("\"Unrealised P/L\" label"),(currentPage.getDerivativesPL().getContent()));
        Assert.assertTrue(currentPage.getDerivativesPLValue().isVisible());
        Assert.assertEquals(map.get("\"Notional amount\" label"),(currentPage.getDerivativesNominalAmount().getContent()));
        Assert.assertTrue(currentPage.getDerivativesNominalAmountAmount().isVisible());
        Assert.assertEquals(map.get("\"Maturity date\" label"),(currentPage.getDerivativesMaturityDate().getContent()));
        Assert.assertTrue(currentPage.getDerivativesMaturityDateValue().isVisible());

        currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);

        Assert.assertEquals(map.get("\"Average premium paid\" label"),(currentPage.getDerivativesAveragePremiumPaid().getContent()));
        Assert.assertTrue(currentPage.getDerivativesAveragePremiumPaidValue().isVisible());
        Assert.assertEquals(map.get("\"Last purchase date\" label"),(currentPage.getDerivativesLastPurchaseDate().getContent()));
        Assert.assertTrue(currentPage.getDerivativesLastPurchaseDateValue().isVisible());
        Assert.assertEquals(map.get("\"Indicative market price\" label"),(currentPage.getDerivativesIndicativeMarketPrice().getContent()));
        Assert.assertTrue(currentPage.getDerivativesIndicativeMarketPriceValue().isVisible());
        Assert.assertEquals(map.get("\"Indicative market price date\" label"),(currentPage.getDerivativesIndicativeMarketPriceDate().getContent()));
        Assert.assertTrue(currentPage.getDerivativesIndicativeMarketPriceDateValue().isVisible());

        if(!currentPage.getDisclaimer().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);
        }
        Assert.assertEquals(map.get("Disclaimer"),(currentPage.getDisclaimer().getContent()));
    }

    public void checkDerivatives2DataFormat() {
        sleep(300L);
        captureScreen();
        if (!currentPage.getDerivativesMarketBaseAmount().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.DOWN, 1000L, 1000);
        }
        CheckUtil.checkDetailDateFormat(currentPage.getDerivativesMarketBaseAmount().getContent());
        CheckUtil.checkDetailDateFormat(currentPage.getDerivativesNominalAmountAmount().getContent());
        CheckUtil.checkCurrencyISO3(currentPage.getDerivativesMarketBaseAmount(), currentPage.getDerivativesMarketBaseCurrency());

        if (currentPage.getDerivativesMarketReportAmount().isVisible()) {
            CheckUtil.checkDetailDateFormat(currentPage.getDerivativesMarketReportAmount().getContent());
            CheckUtil.checkCurrencyISO3(currentPage.getDerivativesMarketReportAmount(), currentPage.getDerivativesMarketReportCurrency());
        }

        CheckUtil.checkCurrencyISO3(currentPage.getDerivativesNominalAmountAmount(), currentPage.getDerivativesNominalAmountCurrency());
    }

    public void checkDerivatives2DateFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getDerivativesMaturityDateValue().getContent());
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getDerivativesLastPurchaseDateValue().getContent());
        if (!currentPage.getDerivativesIndicativeMarketPriceDateValue().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);
        }
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getDerivativesIndicativeMarketPriceDateValue().getContent());
    }

    public void checkInterestRateSwapsDataUI(Map<String,String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getNameTxt().isVisible());
        Assert.assertTrue(currentPage.getIsinTxt().isVisible());
        //Assert.assertEquals(map.get("\"Total value\" label"),(currentPage.getInterestRateSwapsMarket().getContent()));
        Assert.assertTrue(currentPage.getInterestRateSwapsMarketBaseAmount().isVisible());
        if (currentPage.getInterestRateSwapsMarketReportAmount().isVisible()) {
            Assert.assertTrue(currentPage.getInterestRateSwapsMarketReportAmount().isVisible());
        }
        Assert.assertEquals(map.get("\"Expiry date\" label"),(currentPage.getInterestRateSwapsExpiryDate().getContent()));
        Assert.assertTrue(currentPage.getInterestRateSwapsExpiryDateValue().isVisible());
        Assert.assertEquals(map.get("\"Notional amount\" label"),(currentPage.getInterestRateSwapsNominalAmount().getContent()));
        Assert.assertTrue(currentPage.getInterestRateSwapsNominalAmountAmount().isVisible());
//        Assert.assertEquals(map.get("\"Fixed rate\" label"),(currentPage.getInterestRateSwapsFixedRate().getContent()));
//        Assert.assertTrue(currentPage.getInterestRateSwapsFixedRateValue().isVisible());
        Assert.assertEquals(map.get("\"Indicative price\" label"),(currentPage.getInterestRateSwapsIndicativePrice().getContent()));
        Assert.assertTrue(currentPage.getInterestRateSwapsIndicativePriceValue().isVisible());
        Assert.assertEquals(map.get("\"Indicative price date\" label"),(currentPage.getInterestRateSwapsIndicativePriceDate().getContent()));
        Assert.assertTrue(currentPage.getInterestRateSwapsIndicativePriceDateValue().isVisible());

        if(!currentPage.getDisclaimer().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);
        }
        Assert.assertEquals(map.get("Disclaimer"),(currentPage.getDisclaimer().getContent()));
    }

    public void checkInterestRateSwapsDataFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkDetailDateFormat(currentPage.getInterestRateSwapsMarketBaseAmount().getContent());
        CheckUtil.checkDetailDateFormat(currentPage.getInterestRateSwapsNominalAmountAmount().getContent());

        CheckUtil.checkCurrencyISO3(currentPage.getInterestRateSwapsMarketBaseAmount(), currentPage.getInterestRateSwapsMarketBaseCurrency());
        if (currentPage.getInterestRateSwapsMarketReportAmount().isVisible()) {
            CheckUtil.checkDetailDateFormat(currentPage.getInterestRateSwapsMarketReportAmount().getContent());
            CheckUtil.checkCurrencyISO3(currentPage.getInterestRateSwapsMarketReportAmount(), currentPage.getInterestRateSwapsMarketReportCurrency());
        }

        CheckUtil.checkCurrencyISO3(currentPage.getInterestRateSwapsNominalAmountAmount(), currentPage.getInterestRateSwapsNominalAmountCurrency());
    }

    public void checkInterestRateSwapsDateFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getInterestRateSwapsIndicativePriceDateValue().getContent());
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getInterestRateSwapsExpiryDateValue().getContent());
    }

    public void checkFuturesDataUI(Map<String,String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getNameTxt().isVisible());
        Assert.assertTrue(currentPage.getIsinTxt().isVisible());
        Assert.assertEquals(map.get("\"Number of contracts\" label"),currentPage.getFuturesNumber().getContent());
        Assert.assertTrue(currentPage.getFuturesNumberValue().isVisible());
        Assert.assertEquals(map.get("\"Expiry date\" label"),currentPage.getFuturesExpiryDate().getContent());
        Assert.assertTrue(currentPage.getFuturesExpiryDateValue().isVisible());
        Assert.assertEquals(map.get("\"Unrealised P/L\" label"),currentPage.getFuturesPl().getContent());
        Assert.assertTrue(currentPage.getFuturesPlValue().isVisible());
        Assert.assertEquals(map.get("\"Average transaction price\" label"),currentPage.getFuturesTransactionPrice().getContent());
        Assert.assertTrue(currentPage.getFuturesTransactionPriceAmount().isVisible());
        currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);
        Assert.assertEquals(map.get("\"Last transaction date\" label"),currentPage.getFuturesTransactionDate().getContent());
        Assert.assertTrue(currentPage.getFuturesTransactionDateValue().isVisible());
        Assert.assertEquals(map.get("\"Last contract price\" label"),currentPage.getFuturesContractPricePrice().getContent());
        Assert.assertTrue(currentPage.getFuturesContractPricePriceAmount().isVisible());
        Assert.assertEquals(map.get("\"Indicative contract price date\" label"),currentPage.getFuturesContractPriceDate().getContent());
        Assert.assertTrue(currentPage.getFuturesContractPriceDateValue().isVisible());

        if(!currentPage.getDisclaimer().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);
        }
        Assert.assertEquals(map.get("Disclaimer"),(currentPage.getDisclaimer().getContent()));
    }


    public void checkFuturesDataFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkDetailDateFormat(currentPage.getFuturesTransactionPriceAmount().getContent());
        CheckUtil.checkDetailDateFormat(currentPage.getFuturesContractPricePriceAmount().getContent());
        CheckUtil.checkCurrencyISO3(currentPage.getFuturesTransactionPriceAmount(), currentPage.getFuturesTransactionPriceCurrency());
        CheckUtil.checkCurrencyISO3(currentPage.getFuturesContractPricePriceAmount(), currentPage.getFuturesContractPricePriceCurrency());
    }

    public void checkFuturesDateFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getFuturesTransactionDateValue().getContent());
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getFuturesContractPriceDateValue().getContent());

        if (!currentPage.getFuturesExpiryDateValue().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.DOWN, 1000L, 1000);
        }
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getFuturesExpiryDateValue().getContent());
    }

    public void checkForeignExchangeDataUI(Map<String,String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getNameTxt().isVisible());
        Assert.assertTrue(currentPage.getIsinTxt().isVisible());
        Assert.assertEquals(map.get("Nominal Amount (Buy) label"),currentPage.getForeignExchangeBuy().getContent());
        Assert.assertTrue(currentPage.getForeignExchangeBuyAmount().isVisible());
        Assert.assertEquals(map.get("Nominal Amount (Sell) label"),currentPage.getForeignExchangeSell().getContent());
        Assert.assertTrue(currentPage.getForeignExchangeSellAmount().isVisible());
        Assert.assertEquals(map.get("P/L label"),currentPage.getForeignExchangeProfitLoss().getContent());
        Assert.assertTrue(currentPage.getForeignExchangeProfitLossAmount().isVisible());
        Assert.assertEquals(map.get("Trade Date label"),currentPage.getForeignExchangeTradeDate().getContent());
        Assert.assertTrue(currentPage.getForeignExchangeTradeDateValue().isVisible());
        Assert.assertEquals(map.get("Maturity Date label"),currentPage.getForeignExchangeMaturity().getContent());
        Assert.assertTrue(currentPage.getForeignExchangeMaturityValue().isVisible());
        Assert.assertEquals(map.get("Deal Exchange Rate label"),currentPage.getForeignExchangeExchangeRate().getContent());
        Assert.assertTrue(currentPage.getForeignExchangeExchangeRateValue().isVisible());
        Assert.assertEquals(map.get("Forward Mark to Market label"),currentPage.getForeignExchangeForwardMark().getContent());
        Assert.assertTrue(currentPage.getForeignExchangeForwardMarkValue().isVisible());
        if(!currentPage.getDisclaimer().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);
        }
        Assert.assertEquals(map.get("Disclaimer"),(currentPage.getDisclaimer().getContent()));
    }

    public void checkForeignExchangeDataFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkDetailDateFormat(currentPage.getForeignExchangeSellAmount().getContent());
        CheckUtil.checkDetailDateFormat(currentPage.getForeignExchangeProfitLossAmount().getContent());
        CheckUtil.checkCurrencyISO3(currentPage.getForeignExchangeSellAmount(), currentPage.getForeignExchangeSellCurrency());
        CheckUtil.checkCurrencyISO3(currentPage.getForeignExchangeProfitLossAmount(), currentPage.getForeignExchangeProfitLossCurrency());

        if (!currentPage.getForeignExchangeBuyAmount().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.DOWN, 1000L, 1000);
        }
        CheckUtil.checkDetailDateFormat(currentPage.getForeignExchangeBuyAmount().getContent());
        CheckUtil.checkCurrencyISO3(currentPage.getForeignExchangeBuyAmount(), currentPage.getForeignExchangeBuyCurrency());
    }

    public void checkForeignExchangeDateFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getForeignExchangeTradeDateValue().getContent());
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getForeignExchangeMaturityValue().getContent());
    }

    public void checkPrivateEquityAndRealEstateFundsDataUI(Map<String,String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getNameTxt().isVisible());
        Assert.assertTrue(currentPage.getIsinTxt().isVisible());
        Assert.assertEquals(map.get("Total value label"),currentPage.getPrivateEquityMarket().getContent());
        Assert.assertTrue(currentPage.getPrivateEquityMarketBaseAmount().isVisible());
        if (currentPage.getPrivateEquityMarketReportAmount().isVisible()) {
            Assert.assertTrue(currentPage.getPrivateEquityMarketReportAmount().isVisible());
        }
        Assert.assertEquals(map.get("Initial Commitment label"),currentPage.getPrivateEquityCommitment().getContent());
        Assert.assertTrue(currentPage.getPrivateEquityCommitmentAmount().isVisible());
        if(!currentPage.getDisclaimer().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);
        }
        Assert.assertEquals(map.get("Disclaimer"),(currentPage.getDisclaimer().getContent()));
    }

    public void checkPrivateEquityAndRealEstateFundsDataFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkDetailDateFormat(currentPage.getPrivateEquityMarketBaseAmount().getContent());
        CheckUtil.checkDetailDateFormat(currentPage.getPrivateEquityCommitmentAmount().getContent());
        CheckUtil.checkCurrencyISO3(currentPage.getPrivateEquityMarketBaseAmount(), currentPage.getPrivateEquityMarketBaseCurrency());

        if (currentPage.getPrivateEquityMarketReportAmount().isVisible()) {
            CheckUtil.checkDetailDateFormat(currentPage.getPrivateEquityMarketReportAmount().getContent());
            CheckUtil.checkCurrencyISO3(currentPage.getPrivateEquityMarketReportAmount(), currentPage.getPrivateEquityMarketReportCurrency());
        }

        CheckUtil.checkCurrencyISO3(currentPage.getPrivateEquityCommitmentAmount(), currentPage.getPrivateEquityCommitmentCurrency());
    }

    public void checkDeposits1DataUI(Map<String,String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getNameTxt().isVisible());
        Assert.assertTrue(currentPage.getIsinTxt().isVisible());
        Assert.assertEquals(map.get("Total value label"), currentPage.getDepositsTotal().getContent());
        Assert.assertTrue(currentPage.getDepositsTotalBaseAmount().isVisible());
        if (currentPage.getDepositsTotalReportAmount().isExisted()) {
            Assert.assertTrue(currentPage.getDepositsTotalReportAmount().isVisible());
        }
        Assert.assertEquals(map.get("Accrued Interest label"), currentPage.getDepositsAccruedInterest().getContent());
        Assert.assertTrue(currentPage.getDepositsAccruedInterestAmount().isVisible());
        Assert.assertEquals(map.get("Balance label"),currentPage.getDepositsBalance().getContent());
        Assert.assertTrue(currentPage.getDepositsBalanceAmount().isVisible());
        Assert.assertEquals(map.get("Maturity Date label"),currentPage.getDepositsMaturityDate().getContent());
        Assert.assertTrue(currentPage.getDepositsMaturityDateValue().isVisible());
        if(!currentPage.getDisclaimer().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);
        }
        Assert.assertEquals(map.get("Disclaimer"),currentPage.getDisclaimer().getContent());
    }

    public void checkDeposits1DateFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getDepositsMaturityDateValue().getContent());
    }

    public void checkDeposits1DataFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkDetailDateFormat(currentPage.getDepositsTotalBaseAmount().getContent());

        if (currentPage.getDepositsTotalReportAmount().isVisible()) {
            CheckUtil.checkDetailDateFormat(currentPage.getDepositsTotalReportAmount().getContent());
            CheckUtil.checkCurrencyISO3(currentPage.getDepositsTotalReportAmount(), currentPage.getDepositsTotalReportCurrency());
        }
        CheckUtil.checkDetailDateFormat(currentPage.getDepositsAccruedInterestAmount().getContent());
        CheckUtil.checkCurrencyISO3(currentPage.getDepositsAccruedInterestAmount(), currentPage.getDepositsAccruedInterestCurrency());

        CheckUtil.checkDetailDateFormat(currentPage.getDepositsBalanceAmount().getContent());
        CheckUtil.checkCurrencyISO3(currentPage.getDepositsTotalBaseAmount(), currentPage.getDepositsTotalBaseCurrency());
        CheckUtil.checkCurrencyISO3(currentPage.getDepositsBalanceAmount(), currentPage.getDepositsBalanceCurrency());
    }

    public void checkDeposits2DataUI(Map<String,String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getNameTxt().isVisible());
        Assert.assertTrue(currentPage.getIsinTxt().isVisible());
        Assert.assertEquals(map.get("Total value label"),currentPage.getDepositsTotal().getContent());
        Assert.assertTrue(currentPage.getDepositsTotalBaseAmount().isVisible());
        if (currentPage.getDepositsTotalReportAmount().isExisted()) {
            Assert.assertTrue(currentPage.getDepositsTotalReportAmount().isVisible());
        }
        Assert.assertEquals(map.get("Unrealised P/L label"),currentPage.getDepositsPL().getContent());
        Assert.assertTrue(currentPage.getDepositsPLValue().isVisible());
        Assert.assertEquals(map.get("Accrued Interest label"), currentPage.getDepositsAccruedInterest().getContent());
        Assert.assertTrue(currentPage.getDepositsAccruedInterestAmount().isVisible());
        Assert.assertEquals(map.get("Balance label"),currentPage.getDepositsBalance().getContent());
        Assert.assertTrue(currentPage.getDepositsBalanceAmount().isVisible());
        Assert.assertEquals(map.get("Average Price label"),currentPage.getDepositsAveragePrice().getContent());
        Assert.assertTrue(currentPage.getDepositsAveragePriceValue().isVisible());
        Assert.assertEquals(map.get("Last Purchase Date"),currentPage.getDepositsPurchaseDate().getContent());
        Assert.assertTrue(currentPage.getDepositsPurchaseDateValue().isVisible());
        Assert.assertEquals(map.get("Maturity Date label"),currentPage.getDepositsMaturityDate().getContent());
        Assert.assertTrue(currentPage.getDepositsMaturityDateValue().isVisible());
        if(!currentPage.getDisclaimer().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);
        }
        Assert.assertEquals(map.get("Disclaimer"),(currentPage.getDisclaimer().getContent()));
    }

    public void checkDeposits2DateFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getDepositsPurchaseDateValue().getContent());
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getDepositsMaturityDateValue().getContent());
    }

    public void checkDeposits2DataFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkDetailDateFormat(currentPage.getDepositsTotalBaseAmount().getContent());

        if (currentPage.getDepositsTotalReportAmount().isVisible()) {
            CheckUtil.checkDetailDateFormat(currentPage.getDepositsTotalReportAmount().getContent());
            CheckUtil.checkCurrencyISO3(currentPage.getDepositsTotalReportAmount(), currentPage.getDepositsTotalReportCurrency());
        }
        CheckUtil.checkDetailDateFormat(currentPage.getDepositsAccruedInterestAmount().getContent());
        CheckUtil.checkCurrencyISO3(currentPage.getDepositsAccruedInterestAmount(), currentPage.getDepositsAccruedInterestCurrency());

        CheckUtil.checkDetailDateFormat(currentPage.getDepositsBalanceAmount().getContent());
        CheckUtil.checkDetailDateFormat(currentPage.getDepositsAveragePriceValue().getContent());
        CheckUtil.checkCurrencyISO3(currentPage.getDepositsTotalBaseAmount(), currentPage.getDepositsTotalBaseCurrency());
        CheckUtil.checkCurrencyISO3(currentPage.getDepositsBalanceAmount(), currentPage.getDepositsBalanceCurrency());
        CheckUtil.checkCurrencyISO3(currentPage.getDepositsAveragePriceValue(), currentPage.getDepositsAveragePriceCurrency());

    }

    public void checkDeposits3DataUI(Map<String,String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getNameTxt().isVisible());
        Assert.assertTrue(currentPage.getIsinTxt().isVisible());
        Assert.assertEquals(map.get("Total value label"), currentPage.getDepositsTotal().getContent());
        Assert.assertTrue(currentPage.getDepositsTotalBaseAmount().isVisible());
        if (currentPage.getDepositsTotalReportAmount().isExisted()) {
            Assert.assertTrue(currentPage.getDepositsTotalReportAmount().isVisible());
        }
        Assert.assertEquals(map.get("Accrued Interest label"), currentPage.getDepositsAccruedInterest().getContent());
        Assert.assertTrue(currentPage.getDepositsAccruedInterestAmount().isVisible());
        Assert.assertEquals(map.get("Balance label"), currentPage.getDepositsBalance().getContent());
        Assert.assertTrue(currentPage.getDepositsBalanceAmount().isVisible());

        if (!currentPage.getDisclaimer().isVisible()) {
            currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);
        }
        Assert.assertEquals(map.get("Disclaimer"), currentPage.getDisclaimer().getContent());
    }

    public void checkDeposits3DataFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkDetailDateFormat(currentPage.getDepositsTotalBaseAmount().getContent());
        if (currentPage.getDepositsTotalReportAmount().isVisible()) {
            CheckUtil.checkDetailDateFormat(currentPage.getDepositsTotalReportAmount().getContent());
            CheckUtil.checkCurrencyISO3(currentPage.getDepositsTotalReportAmount(), currentPage.getDepositsTotalReportCurrency());
        }
        CheckUtil.checkDetailDateFormat(currentPage.getDepositsAccruedInterestAmount().getContent());
        CheckUtil.checkCurrencyISO3(currentPage.getDepositsAccruedInterestAmount(), currentPage.getDepositsAccruedInterestCurrency());

        CheckUtil.checkDetailDateFormat(currentPage.getDepositsBalanceAmount().getContent());
        CheckUtil.checkCurrencyISO3(currentPage.getDepositsTotalBaseAmount(), currentPage.getDepositsTotalBaseCurrency());
        CheckUtil.checkCurrencyISO3(currentPage.getDepositsBalanceAmount(), currentPage.getDepositsBalanceCurrency());
    }

    public void checkDeposits3DateFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getDepositsMaturityDateValue().getContent());
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getDerivativesLastPurchaseDateValue().getContent());
    }

    public void checkDeposits4DataUI(Map<String,String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getNameTxt().isVisible());
        Assert.assertTrue(currentPage.getIsinTxt().isVisible());
        Assert.assertEquals(map.get("Total value label"), currentPage.getDepositsTotal().getContent());
        Assert.assertTrue(currentPage.getDepositsTotalBaseAmount().isVisible());
        if (currentPage.getDepositsTotalReportAmount().isExisted()) {
            Assert.assertTrue(currentPage.getDepositsTotalReportAmount().isVisible());
        }
        Assert.assertEquals(map.get("Accrued Profit label"), currentPage.getDepositsAccruedProfit().getContent());
        Assert.assertTrue(currentPage.getDepositsAccruedProfitAmount().isVisible());
        Assert.assertEquals(map.get("Balance label"),currentPage.getDepositsBalance().getContent());
        Assert.assertTrue(currentPage.getDepositsBalanceAmount().isVisible());
        Assert.assertEquals(map.get("Maturity Date label"),currentPage.getDepositsMaturityDate().getContent());
        Assert.assertTrue(currentPage.getDepositsMaturityDateValue().isVisible());
        Assert.assertEquals(map.get("Average Price label"),currentPage.getDepositsAveragePrice().getContent());
        Assert.assertTrue(currentPage.getDepositsAveragePriceValue().isVisible());
        Assert.assertEquals(map.get("Last Purchase Date"),currentPage.getDepositsPurchaseDate().getContent());
        Assert.assertTrue(currentPage.getDepositsPurchaseDateValue().isVisible());

        if (!currentPage.getDisclaimer().isVisible()) {
            currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);
        }
        Assert.assertEquals(map.get("Disclaimer"), (currentPage.getDisclaimer().getContent()));
    }

    public void checkDeposits4DateFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getDepositsPurchaseDateValue().getContent());
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getDepositsMaturityDateValue().getContent());
    }

    public void checkDeposits4DataFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkDetailDateFormat(currentPage.getDepositsTotalBaseAmount().getContent());
        CheckUtil.checkDetailDateFormat(currentPage.getDepositsBalanceAmount().getContent());
        CheckUtil.checkDetailDateFormat(currentPage.getDepositsAveragePriceValue().getContent());

        CheckUtil.checkCurrencyISO3(currentPage.getDepositsTotalBaseAmount(), currentPage.getDepositsTotalBaseCurrency());

        if (currentPage.getDepositsTotalReportAmount().isVisible()) {
            CheckUtil.checkDetailDateFormat(currentPage.getDepositsTotalReportAmount().getContent());
            CheckUtil.checkCurrencyISO3(currentPage.getDepositsTotalReportAmount(), currentPage.getDepositsTotalReportCurrency());
        }
        CheckUtil.checkDetailDateFormat(currentPage.getDepositsAccruedProfitAmount().getContent());
        CheckUtil.checkCurrencyISO3(currentPage.getDepositsAccruedProfitAmount(), currentPage.getDepositsAccruedProfitCurrency());

        CheckUtil.checkCurrencyISO3(currentPage.getDepositsBalanceAmount(), currentPage.getDepositsBalanceCurrency());
        CheckUtil.checkCurrencyISO3(currentPage.getDepositsAveragePriceValue(), currentPage.getDepositsAveragePriceCurrency());
    }

    public void checkBondsDataUI(Map<String,String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getNameTxt().isVisible());
        Assert.assertTrue(currentPage.getIsinTxt().isVisible());
        Assert.assertEquals(map.get("\"Total value\" label"),currentPage.getBondsTotal().getContent());
        Assert.assertTrue(currentPage.getBondsTotalBaseAmount().isVisible());
        if (currentPage.getBondsTotalReportAmount().isVisible()) {
            Assert.assertTrue(currentPage.getBondsTotalReportAmount().isVisible());
        }
        Assert.assertEquals(map.get("\"Accrued Interest\" label"),currentPage.getBondsAccruedInterest().getContent());
        Assert.assertTrue(currentPage.getBondsAccruedInterestAmount().isVisible());
        Assert.assertEquals(map.get("\"Duration\" label"),currentPage.getBondsDuration().getContent());
        Assert.assertTrue(currentPage.getBondsDurationValue().isVisible());

        Assert.assertEquals(map.get("\"Nominal Amount\" label"),currentPage.getBondsNominal().getContent());
        Assert.assertTrue(currentPage.getBondsNominalAmount().isVisible());
        Assert.assertEquals(map.get("\"Average Purchase Price\" label"),currentPage.getBondsAveragePurchasePrice().getContent());
        Assert.assertTrue(currentPage.getBondsAveragePurchasePriceValue().isVisible());
        Assert.assertEquals(map.get("\"Last Buy Date\" label"),currentPage.getBondsBuyDate().getContent());
        Assert.assertTrue(currentPage.getBondsBuyDateValue().isVisible());
        Assert.assertEquals(map.get("\"Indicative Market Price\" label"),currentPage.getBondsIndicitiveMarketPrice().getContent());
        Assert.assertTrue(currentPage.getBondsIndicitiveMarketPriceValue().isVisible());
        Assert.assertEquals(map.get("\"Market Price Date\" label"),currentPage.getBondsMarketPriceDate().getContent());
        Assert.assertTrue(currentPage.getBondsMarketPriceDateValue().isVisible());
        Assert.assertEquals(map.get("\"YTM\" label"),currentPage.getBondsYtwYtm().getContent());
        Assert.assertTrue(currentPage.getBondsYtwYtmValue().isVisible());
        Assert.assertEquals(map.get("\"Duration\" label"),currentPage.getBondsDuration().getContent());
        Assert.assertTrue(currentPage.getBondsDurationValue().isVisible());

        currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);

        Assert.assertEquals(map.get("\"Issuer\" label"),currentPage.getBondsIssuer().getContent());
        Assert.assertTrue(currentPage.getBondsIssuerValue().isVisible());
        Assert.assertEquals(map.get("\"Rating Moody’s\" label"),currentPage.getBondsRatingMoody().getContent());
        Assert.assertTrue(currentPage.getBondsRatingMoodyValue().isVisible());

        Assert.assertEquals(map.get("\"Rating S&P\" label"),currentPage.getBondsRatingRP().getContent());
        Assert.assertTrue(currentPage.getBondsRatingRPValue().isVisible());
        Assert.assertEquals(map.get("\"Country of Risk\" label"),currentPage.getBondsCountryRisk().getContent());
        Assert.assertTrue(currentPage.getBondsCountryRiskValue().isVisible());
        Assert.assertEquals(map.get("\"Maturity Date\" label"),currentPage.getBondsMaturityDate().getContent());
        Assert.assertTrue(currentPage.getBondsMaturityDateValue().isVisible());
        Assert.assertEquals(map.get("\"Minimum investment amount\" label"),currentPage.getBondsMinimumInvestment().getContent());
        Assert.assertTrue(currentPage.getBondsMinimumInvestmentAmount().isVisible());

        if (!currentPage.getDisclaimer().isVisible()) {
            currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);
        }
        Assert.assertEquals(map.get("Disclaimer"), (currentPage.getDisclaimer().getContent()));
    }

    public void checkBondsDataFormat() {
        sleep(300L);
        captureScreen();

        if (!currentPage.getBondsTotalBaseAmount().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.DOWN, 1000L, 1000);
            currentPage.getScrollBtn().scroll(ScrollDirection.DOWN, 1000L, 1000);
        }
        CheckUtil.checkDetailDateFormat(currentPage.getBondsTotalBaseAmount().getContent());
        CheckUtil.checkDetailDateFormat(currentPage.getBondsAccruedInterestAmount().getContent());
        CheckUtil.checkCurrencyISO3(currentPage.getBondsAccruedInterestAmount(), currentPage.getBondsAccruedInterestCurrency());
        CheckUtil.checkDetailDateFormat(currentPage.getBondsNominalAmount().getContent());

        CheckUtil.checkCurrencyISO3(currentPage.getBondsTotalBaseAmount(), currentPage.getBondsTotalBaseCurrency());
        if (!currentPage.getBondsTotalReportAmount().isVisible()) {
            CheckUtil.checkDetailDateFormat(currentPage.getBondsTotalReportAmount().getContent());
            CheckUtil.checkCurrencyISO3(currentPage.getBondsTotalReportAmount(), currentPage.getBondsTotalReportCurrency());
        }
        CheckUtil.checkCurrencyISO3(currentPage.getBondsNominalAmount(), currentPage.getBondsNominalCurrency());

        if (!currentPage.getBondsMinimumInvestmentAmount().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);
        }
        CheckUtil.checkDetailDateFormat(currentPage.getBondsMinimumInvestmentAmount().getContent());
        CheckUtil.checkCurrencyISO3(currentPage.getBondsMinimumInvestmentAmount(), currentPage.getBondsMinimumInvestmentCurrency());

    }

    public void checkBondsDateFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getBondsBuyDateValue().getContent());
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getBondsMarketPriceDateValue().getContent());
        if (!currentPage.getBondsMaturityDateValue().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);
            currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);
        }
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getBondsMaturityDateValue().getContent());
    }

    public void checkBonds2DataUI(Map<String,String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getNameTxt().isVisible());
        Assert.assertTrue(currentPage.getIsinTxt().isVisible());

        Assert.assertEquals(map.get("\"Total value\" label"), currentPage.getBondsTotal().getContent());
        Assert.assertTrue(currentPage.getBondsTotalBaseAmount().isVisible());
        if (currentPage.getBondsTotalReportAmount().isVisible()){
            Assert.assertTrue(currentPage.getBondsTotalReportAmount().isVisible());
        }
        Assert.assertEquals(map.get("\"Accrued Profit\" label"),currentPage.getBondsAccruedProfit().getContent());
        Assert.assertTrue(currentPage.getBondsAccruedProfitAmount().isVisible());
        Assert.assertEquals(map.get("\"Nominal Amount\" label"),currentPage.getBondsNominal().getContent());
        Assert.assertTrue(currentPage.getBondsNominalAmount().isVisible());
        Assert.assertEquals(map.get("\"Average Purchase Price\" label"),currentPage.getBondsAveragePurchasePrice().getContent());
        Assert.assertTrue(currentPage.getBondsAveragePurchasePriceValue().isVisible());
        Assert.assertEquals(map.get("\"Last Buy Date\" label"),currentPage.getBondsBuyDate().getContent());
        Assert.assertTrue(currentPage.getBondsBuyDateValue().isVisible());
        Assert.assertEquals(map.get("\"Indicative Market Price\" label"),currentPage.getBondsIndicitiveMarketPrice().getContent());
        Assert.assertTrue(currentPage.getBondsIndicitiveMarketPriceValue().isVisible());
        Assert.assertEquals(map.get("\"Market Price Date\" label"),currentPage.getBondsMarketPriceDate().getContent());
        Assert.assertTrue(currentPage.getBondsMarketPriceDateValue().isVisible());
        Assert.assertEquals(map.get("\"YTM\" label"),currentPage.getBondsYtwYtm().getContent());
        Assert.assertTrue(currentPage.getBondsYtwYtmValue().isVisible());
        Assert.assertEquals(map.get("\"Duration\" label"),currentPage.getBondsDuration().getContent());
        Assert.assertTrue(currentPage.getBondsDurationValue().isVisible());

        currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);

        Assert.assertEquals(map.get("\"Issuer\" label"),currentPage.getBondsIssuer().getContent());
        Assert.assertTrue(currentPage.getBondsIssuerValue().isVisible());
        Assert.assertEquals(map.get("\"Rating Moody’s\" label"),currentPage.getBondsRatingMoody().getContent());
        Assert.assertTrue(currentPage.getBondsRatingMoodyValue().isVisible());
        Assert.assertEquals(map.get("\"Rating S&P\" label"),currentPage.getBondsRatingRP().getContent());
        Assert.assertTrue(currentPage.getBondsRatingRPValue().isVisible());
        Assert.assertEquals(map.get("\"Country of Risk\" label"),currentPage.getBondsCountryRisk().getContent());
        Assert.assertTrue(currentPage.getBondsCountryRiskValue().isVisible());


        Assert.assertEquals(map.get("\"Maturity Date\" label"),currentPage.getBondsMaturityDate().getContent());
        Assert.assertTrue(currentPage.getBondsMaturityDateValue().isVisible());
        Assert.assertEquals(map.get("\"Minimum investment amount\" label"),currentPage.getBondsMinimumInvestment().getContent());
        Assert.assertTrue(currentPage.getBondsMinimumInvestmentAmount().isVisible());

        Assert.assertEquals(map.get("Disclaimer"), (currentPage.getDisclaimer().getContent()));
    }

    public void checkBonds2DataFormat() {
        sleep(300L);
        captureScreen();

        if (!currentPage.getBondsTotalBaseAmount().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.DOWN, 1000L, 1000);
            currentPage.getScrollBtn().scroll(ScrollDirection.DOWN, 1000L, 1000);
        }
        CheckUtil.checkDetailDateFormat(currentPage.getBondsTotalBaseAmount().getContent());
        CheckUtil.checkDetailDateFormat(currentPage.getBondsAccruedProfitAmount().getContent());
        CheckUtil.checkCurrencyISO3(currentPage.getBondsAccruedProfitAmount(), currentPage.getBondsAccruedProfitCurrency());
        CheckUtil.checkDetailDateFormat(currentPage.getBondsNominalAmount().getContent());

        CheckUtil.checkCurrencyISO3(currentPage.getBondsTotalBaseAmount(), currentPage.getBondsTotalBaseCurrency());
        if (!currentPage.getBondsTotalReportAmount().isVisible()) {
            CheckUtil.checkDetailDateFormat(currentPage.getBondsTotalReportAmount().getContent());
            CheckUtil.checkCurrencyISO3(currentPage.getBondsTotalReportAmount(), currentPage.getBondsTotalReportCurrency());
        }
        CheckUtil.checkCurrencyISO3(currentPage.getBondsNominalAmount(), currentPage.getBondsNominalCurrency());

        if (!currentPage.getBondsMinimumInvestmentAmount().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);
        }
        CheckUtil.checkDetailDateFormat(currentPage.getBondsMinimumInvestmentAmount().getContent());
        CheckUtil.checkCurrencyISO3(currentPage.getBondsMinimumInvestmentAmount(), currentPage.getBondsMinimumInvestmentCurrency());
    }

    public void checkBonds2DateFormat() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getBondsBuyDateValue().getContent());
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getBondsMarketPriceDateValue().getContent());
        if(!currentPage.getBondsMaturityDateValue().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);
        }
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getBondsMaturityDateValue().getContent());
    }

    public void checkStructuredProductsPart1UI(Map<String,String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getNameTxt().isVisible());
        Assert.assertTrue(currentPage.getIsinTxt().isVisible());
        Assert.assertEquals(map.get("Total value label"), currentPage.getStructuredProductsTotal().getContent());
        Assert.assertTrue(currentPage.getStructuredProductsTotalBaseAmount().isVisible());
        Assert.assertTrue(currentPage.getStructuredProductsTotalReportAmount().isVisible());
        Assert.assertEquals(map.get("Unrealised P/L"), currentPage.getStructuredProductsPL().getContent());
        Assert.assertTrue(currentPage.getStructuredProductsPLValue().isVisible());
        Assert.assertEquals(map.get("\"Accrued Interest\" label"), currentPage.getStructuredProductsAccruedInterest().getContent());
        Assert.assertTrue(currentPage.getStructuredProductsAccruedInterestAmount().isVisible());
        Assert.assertEquals(map.get("Nominal Amount label"), currentPage.getStructuredProductsNominalAmount().getContent());
        Assert.assertTrue(currentPage.getStructuredProductsNominalAmountAmount().isVisible());
        Assert.assertEquals(map.get("Average Purchase Price label"), currentPage.getStructuredProductsPurchasePrice().getContent());
        Assert.assertTrue(currentPage.getStructuredProductsPurchasePriceValue().isVisible());
        Assert.assertEquals(map.get("Last Buy Date label"), currentPage.getStructuredProductsBuyDate().getContent());
        Assert.assertTrue(currentPage.getStructuredProductsBuyDateValue().isVisible());

        currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);

        Assert.assertEquals(map.get("Indicative Price label"), currentPage.getStructuredProductsIndicativePrice().getContent());
        Assert.assertTrue(currentPage.getStructuredProductsIndicativePriceValue().isVisible());
        Assert.assertEquals(map.get("Indicative Price Date label"), currentPage.getStructuredProductsIndicativePriceDate().getContent());
        Assert.assertTrue(currentPage.getStructuredProductsIndicativePriceDateValue().isVisible());
        Assert.assertEquals(map.get("Maturity Date label"), currentPage.getStructuredProductsMaturityDate().getContent());
        Assert.assertTrue(currentPage.getStructuredProductsMaturityDateValue().isVisible());
        Assert.assertEquals(map.get("Issuer"), currentPage.getStructuredProductsIssuer().getContent());
        Assert.assertTrue(currentPage.getStructuredProductsIssuerValue().isVisible());
        Assert.assertEquals(map.get("Rating Moody’s"), currentPage.getStructuredProductsRatingMoody().getContent());
        Assert.assertTrue(currentPage.getStructuredProductsRatingMoodyValue().isVisible());
        Assert.assertEquals(map.get("Rating S&P"), currentPage.getStructuredProductsRatingSP().getContent());
        Assert.assertTrue(currentPage.getStructuredProductsRatingSPValue().isVisible());
        Assert.assertTrue(currentPage.getDisclaimer().isVisible());
    }

    public void checkStructuredProductsPart1Date() {
        sleep(300L);
        captureScreen();
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getStructuredProductsMaturityDateValue().getContent());
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getStructuredProductsBuyDateValue().getContent());
        CheckUtil.checkSimpleMonthDateFormat(currentPage.getStructuredProductsIndicativePriceDateValue().getContent());
    }

    public void checkStructuredProductsPart2UI(Map<String,String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertTrue(currentPage.getNameTxt().isVisible());
        Assert.assertTrue(currentPage.getIsinTxt().isVisible());
        Assert.assertEquals(map.get("Total value label"), currentPage.getStructuredProductsTotal().getContent());
        Assert.assertTrue(currentPage.getStructuredProductsTotalBaseAmount().isVisible());
        if (currentPage.getStructuredProductsTotalReportAmount().isVisible()) {
            Assert.assertTrue(currentPage.getStructuredProductsTotalReportAmount().isVisible());
        }
        Assert.assertEquals(map.get("Unrealised P/L"), currentPage.getStructuredProductsPL().getContent());
        Assert.assertTrue(currentPage.getStructuredProductsPLValue().isVisible());
        Assert.assertEquals(map.get("Nominal Amount label"), currentPage.getStructuredProductsNominalAmount().getContent());
        Assert.assertTrue(currentPage.getStructuredProductsNominalAmountAmount().isVisible());
        Assert.assertEquals(map.get("Maturity Date label"), currentPage.getStructuredProductsMaturityDate().getContent());
        Assert.assertTrue(currentPage.getStructuredProductsMaturityDateValue().isVisible());

        Assert.assertEquals(map.get("Average Purchase Price label"), currentPage.getStructuredProductsPurchasePrice().getContent());
        Assert.assertTrue(currentPage.getStructuredProductsPurchasePriceValue().isVisible());

        Assert.assertEquals(map.get("Last Buy Date label"), currentPage.getStructuredProductsBuyDate().getContent());
        Assert.assertTrue(currentPage.getStructuredProductsBuyDateValue().isVisible());

        currentPage.getScrollBtn().scroll(ScrollDirection.UP, 1000L, 1000);

        Assert.assertEquals(map.get("Indicative Price label"), currentPage.getStructuredProductsIndicativePrice().getContent());
        Assert.assertTrue(currentPage.getStructuredProductsIndicativePriceValue().isVisible());
        Assert.assertEquals(map.get("Indicative Price Date label"), currentPage.getStructuredProductsIndicativePriceDate().getContent());
        Assert.assertTrue(currentPage.getStructuredProductsIndicativePriceDateValue().isVisible());
        Assert.assertEquals(map.get("Issuer"), currentPage.getStructuredProductsIssuer().getContent());
        Assert.assertTrue(currentPage.getStructuredProductsIssuerValue().isVisible());
        Assert.assertEquals(map.get("Rating Moody’s"), currentPage.getStructuredProductsRatingMoody().getContent());
        Assert.assertTrue(currentPage.getStructuredProductsRatingMoodyValue().isVisible());
        Assert.assertEquals(map.get("Rating S&P"), currentPage.getStructuredProductsRatingSP().getContent());
        Assert.assertTrue(currentPage.getStructuredProductsRatingSPValue().isVisible());
        Assert.assertEquals(map.get("Disclaimer"),currentPage.getDisclaimer().getContent());
    }

    public void checkStructuredProductsPart2Date() {
        this.checkStructuredProductsPart1Date();
    }

    public void checkStructuredProductsISO3() {
        sleep(300L);
        captureScreen();
        if (!currentPage.getStructuredProductsTotalBaseAmount().isVisible()){
            currentPage.getScrollBtn().scroll(ScrollDirection.DOWN, 1000L, 1000);
        }
        CheckUtil.checkDetailDateFormat(currentPage.getStructuredProductsTotalBaseAmount().getContent());

        CheckUtil.checkCurrencyISO3(currentPage.getStructuredProductsNominalAmountAmount(), currentPage.getStructuredProductsNominalAmountCurrency());
        CheckUtil.checkCurrencyISO3(currentPage.getStructuredProductsTotalBaseAmount(), currentPage.getStructuredProductsTotalBaseCurrency());

        if (currentPage.getStructuredProductsAccruedInterest().isVisible()){
            CheckUtil.checkDetailDateFormat(currentPage.getStructuredProductsAccruedInterestAmount().getContent());
            CheckUtil.checkCurrencyISO3(currentPage.getStructuredProductsAccruedInterestAmount(), currentPage.getStructuredProductsAccruedInterestCurrency());
        }

        if (currentPage.getStructuredProductsTotalReportAmount().isVisible()) {
            CheckUtil.checkDetailDateFormat(currentPage.getStructuredProductsTotalReportAmount().getContent());
            CheckUtil.checkCurrencyISO3(currentPage.getStructuredProductsTotalReportAmount(), currentPage.getStructuredProductsTotalReportCurrency());
        }

        if(!currentPage.getStructuredProductsNominalAmountAmount().isVisible()){
            CheckUtil.checkDetailDateFormat(currentPage.getStructuredProductsNominalAmountAmount().getContent());
        }
    }

    public void checkNotSeeReportCurrency() {
        sleep(300L);
        captureScreen();
        Assert.assertFalse(currentPage.getBlockedCurrentBalanceReportAmount().isVisible());
    }

    public void checkSeeBaseCurrency() {
        Assert.assertTrue(currentPage.getBlockedCurrentBalanceBaseAmount().isVisible());
    }

    public void checkDiscretionaryAllocationHoldingDetail() {
        sleep(300L);
        captureScreen();
        Assert.assertFalse(currentPage.getBackBtn().getContent().isEmpty());
    }

    public void checkAdvisoryAllocationHoldingDetail(Map<String,String> map) {
        sleep(300L);
        captureScreen();
        Assert.assertEquals(map.get("back button label"), currentPage.getBackBtn().getContent().trim());
    }

    public void checkOverviewBackButton(String value) {
        sleep(300L);
        captureScreen();
        Assert.assertEquals(value, currentPage.getBackBtn().getContent().trim());
    }

    public void tapBackButton() {
        currentPage.getBackBtn().click();
    }

    public void checkAccountBackButton() {
        sleep(300L);
        captureScreen();
        Assert.assertEquals(allocationGraphicFlow.getElementState().get("nameLabel").trim(), currentPage.getBackBtn().getContent().trim());
    }

    public void checkPortfolioBackButton() {
        sleep(300L);
        captureScreen();
        Assert.assertEquals(allocationGraphicFlow.getElementState().get("nameLabel").trim(), currentPage.getBackBtn().getContent().trim());
    }
}
