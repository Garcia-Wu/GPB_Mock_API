package com.gt.projects.bdd.hsbc_gbm.step;

import com.gt.projects.bdd.base.BaseStep;
import com.gt.projects.bdd.hsbc_gbm.flow.HoldingsDetailFlow;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class HoldingsDetailStep extends BaseStep {

    @Autowired
    private HoldingsDetailFlow holdingsDetailFlow;

    @Then("^I should on the Portfolios Holdings Details level$")
    public void onPortfoliosHoldingsDetailsLevel() {
        holdingsDetailFlow.onPortfoliosHoldingsDetailsLevel();
    }

    @Given("^I am on the Portfolios Holdings Details level$")
    public void portfoliosHoldingsDetailsLevel() {
        holdingsDetailFlow.onPortfoliosHoldingsDetailsLevel();
    }

    @Then("^I am taken to a Equities detailed holdings screen displaying the following data:$")
    public void checkEquitiesDetailUI(Map<String, String> map) {
        holdingsDetailFlow.checkEquitiesDetailUI(map);
    }

    @Then("^I should see the following ISO 3 format in Equities detail datas:$")
    public void checkEquitiesNum(Map<String, String> map) {
        holdingsDetailFlow.checkEquitiesNum();
    }

    @Then("^I should see the following date format in Equities detail datas:$")
    public void checkEquitiesDateFormat(Map<String, String> map) {
        holdingsDetailFlow.checkEquitiesDateFormat();
    }

    @Then("^I am taken to a Precious metals detailed holdings screen displaying the following data:$")
    public void checkPreciousMetalsDetailUI(Map<String, String> map) {
        holdingsDetailFlow.checkPreciousMetalsDetailUI(map);
    }

    @Then("^I should see the holdings precious metals following ISO 3 format datas:holding currency、reference currency、Unrealised Profit/Loss value、Market Price value、Average Purchase Price value$")
    public void checkPreciousMetalsDataFormat(){
        holdingsDetailFlow.checkPreciousMetalsDataFormat();
    }

    @Then("^I should see the holdings precious metals date following datas:Last purchase date、Market price date$")
    public void checkPreciousMetalsDateFormat() {
        holdingsDetailFlow.checkPreciousMetalsDateFormat();
    }

    @Then("^I am taken to a detailed holdings funds screen displaying the following data:$")
    public void checkFundsDateUI(Map<String, String> map) {
        holdingsDetailFlow.checkFundsDateUI(map);
    }

    @Then("^I should see the holdings funds following ISO 3 format datas:holding currency、reference currency、Market value in holding currency、Market value in portfolio reference currency、Market price value in holding currency$")
    public void checkFundsDataFormat(){
        holdingsDetailFlow.checkFundsDataFormat();
    }

    @Then("^I should see the holdings funds date following datas:Market Price Date、Last buy Date$")
    public void checkFundsDateFormat() {
        holdingsDetailFlow.checkFundsDateFormat();
    }

    @Then("^I am taken to a detailed holdings funds part2 screen displaying the following data:$")
    public void checkFundsPart2DataUI(Map<String, String> map){
        holdingsDetailFlow.checkFundsPart2DateUI(map);

    }

    @Then("^I should see the holdings funds part2 following ISO 3 format datas:holding currency、reference currency、Market value in holding currency、Market value in portfolio reference currency、Market price value in holding currency$")
    public void checkFundsPart2DataFormatISO3() {
        holdingsDetailFlow.checkFundsPart2DataFormat();
    }

    @Then("^I should see the holdings funds part2 date following datas:Market Price Date、Last buy Date$")
    public void checkFundsPart2DateFormat() {
        holdingsDetailFlow.checkFundsPart2DateFormat();
    }

    @Then("^I am taken to a detailed holdings current accounts screen displaying the following data:$")
    public void checkCurrentAccountsDataUI(Map<String,String> map) {
        holdingsDetailFlow.checkCurrentAccountsDataUI(map);
    }

    @Then("^I should see the holdings current accounts, blocked current accounts following ISO 3 format datas:holding currency、reference currency、Balance value in holding currency、Balance value in portfolio reference currency$")
    public void checkCurrentAccountsBlockedCurrentAccountsDataFormat() {
        holdingsDetailFlow.checkCurrentAccountsBlockedCurrentAccountsDataFormat();
    }

    @Then("^I am taken to a detailed holdings metal ounces screen displaying the following data:$")
    public void checkMetalOuncesDataUI(Map<String, String> map){
        holdingsDetailFlow.checkMetalOuncesDataUI(map);
    }

    @Then("^I should see the holdings metal ounces following ISO 3 format datas:holding currency、portfolio reference currency$")
    public void checkMetalOuncesDataFormat() {
        holdingsDetailFlow.checkMetalOuncesDataFormat();
    }

    @Then("^I am taken to a detailed holdings direct investments screen displaying the following data:$")
    public void checkDirectInvestmentsDataUI(Map<String,String> map) {
        holdingsDetailFlow.checkDirectInvestmentsDataUI(map);
    }

    @Then("^I should see the holdings direct investments following ISO 3 format datas:holding currency、portfolio reference currency$")
    public void checkDirectInvestmentsDataFormat(){
        holdingsDetailFlow.checkDirectInvestmentsDataFormat();
    }

    @Then("^I am taken to a detailed holdings derivatives1 screen displaying the following data:$")
    public void checkDerivatives1DataUI(Map<String,String> map) {
        holdingsDetailFlow.checkDerivativesDataUI(map);
    }

    @Then("^I should see the holdings derivatives1 following ISO 3 format data:holding currency、portfolio reference currency、Market value in portfolio reference currency、Indicative market price value in holding currency$")
    public void checkDerivatives1DataFormatISO3() {
        holdingsDetailFlow.checkDerivatives1DataFormat();
    }

    @Then("^I should see the holdings derivatives1 following data:Expiry date value、Last transaction date、Indicative market price date$")
    public void checkDerivatives1DateFormat() {
        holdingsDetailFlow.checkDerivatives1DateFormat();
    }

    @Then("^I am taken to a detailed holdings derivatives2 screen displaying the following data:$")
    public void checkDerivatives2DataUI(Map<String,String> map) {
        holdingsDetailFlow.checkDerivatives2DataUI(map);
    }

    @Then("^I should see the holdings derivatives2 following ISO 3 format datas:holding currency、portfolio reference currency、Market value in portfolio reference currency、Indicative market price value in holding currency$")
    public void checkDerivatives2DataFormatISO3() {
        holdingsDetailFlow.checkDerivatives2DataFormat();
    }

    @Then("^I should see the holdings derivatives2 following datas:Maturity date、Last purchase date、Indicative market price date$")
    public void checkDerivatives2DateFormat(){
        holdingsDetailFlow.checkDerivatives2DateFormat();
    }

    @Then("^I am taken to a detailed holdings interest rate swaps screen displaying the following data:$")
    public void checkInterestRateSwapsDataUI(Map<String,String> map) {
        holdingsDetailFlow.checkInterestRateSwapsDataUI(map);
    }

    @Then("^I should see the holdings interest rate swaps following ISO 3 format datas:holding currency、portfolio reference currency、Market value in holding currency、Market value in portfolio reference currency、Indicative price value in holding currency$")
    public void checkInterestRateSwapsDataFormat() {
        holdingsDetailFlow.checkInterestRateSwapsDataFormat();
    }

    @Then("^I should see the holdings interest rate swaps following datas:Indicative Price Date、Expiry date$")
    public void checkInterestRateSwapsDateFormat() {
        holdingsDetailFlow.checkInterestRateSwapsDateFormat();
    }

    @Then("^I am taken to detailed holdings futures screen displaying the following data:$")
    public void checkFuturesDataUI(Map<String,String> map) {
        holdingsDetailFlow.checkFuturesDataUI(map);
    }

    @Then("^I should see ISO 3 code of holding futures currency$")
    public void checkFuturesDataFormat() {
        holdingsDetailFlow.checkFuturesDataFormat();
    }

    @Then("^I should see the holdings futures following datas$")
    public void checkFuturesDateFormat(){
        holdingsDetailFlow.checkFuturesDateFormat();
    }

    @Then("^Client is taken to a detailed holdings foreign exchange screen displaying the following data:$")
    public void checkForeignExchangeDataUI(Map<String,String> map) {
        holdingsDetailFlow.checkForeignExchangeDataUI(map);
    }

    @Then("^I can see ISO 3 code of holdings foreign exchange currency$")
    public void checkForeignExchangeDataFormat(){
        holdingsDetailFlow.checkForeignExchangeDataFormat();
    }

    @Then("^I can see holdings foreign exchange date value Format is \"([^\"]*)\"$")
    public void checkForeignExchangeDateFormat(String format) {
        holdingsDetailFlow.checkForeignExchangeDateFormat();
    }

    @Then("^I am taken to a detailed holdings private equity and real estate funds screen displaying the following data:$")
    public void checkPrivateEquityAndRealEstateFundsDataUI(Map<String,String> map) {
        holdingsDetailFlow.checkPrivateEquityAndRealEstateFundsDataUI(map);
    }

    @Then("^I can see ISO 3 code of holdings private equity and real estate funds currency$")
    public void checkPrivateEquityAndRealEstateFundsDataFormat() {
        holdingsDetailFlow.checkPrivateEquityAndRealEstateFundsDataFormat();
    }

    @Then("^I am taken to a detailed holdings deposits1 screen displaying the following data:$")
    public void checkDeposits1DataUI(Map<String,String> map){
        holdingsDetailFlow.checkDeposits1DataUI(map);
    }

    @Then("^I can see deposits1 date value Format is \"dd MMM yyyy\"$")
    public void checkDeposits1DateFormat(){
        holdingsDetailFlow.checkDeposits1DateFormat();
    }

    @Then("^I am taken to a allocation Deposits1 detailed holdings deposits1 screen displaying the following data:$")
    public void checkAllocationDeposits1UI(Map<String,String> map){
        holdingsDetailFlow.checkDeposits1DataUI(map);
    }

    @Then("^I can see allocation holdings deposits1 date value Format is \"dd MMM yyyy\"$")
    public void checkAllocationDeposits1DateFormat(){
        holdingsDetailFlow.checkDeposits1DateFormat();
    }

    @Then("^I can see ISO 3 code of holdings deposits1 currency$")
    public void checkDeposits1DataFormat() {
        holdingsDetailFlow.checkDeposits1DataFormat();
    }

    @Then("^I can see ISO 3 code of allocation holdings deposits1 currency$")
    public void checkAllocationDeposits1DataFormat() {
        holdingsDetailFlow.checkDeposits1DataFormat();
    }

    @Then("^I am taken to a detailed holdings deposits2 screen displaying the following data:$")
    public void checkDeposits2DataUI(Map<String,String> map) {
        holdingsDetailFlow.checkDeposits2DataUI(map);
    }

    @Then("^I am taken to a allocation detailed holdings deposits2 screen displaying the following data:$")
    public void checkAllocationDeposits2DataUI(Map<String,String> map) {
        holdingsDetailFlow.checkDeposits2DataUI(map);
    }

    @Then("^I can see holdings deposits2 date value Format is \"dd MMM yyyy\"$")
    public void checkDeposits2DateFormat(){
        holdingsDetailFlow.checkDeposits2DateFormat();
    }

    @Then("^I can see allocation holdings deposits2 date value Format is \"dd MMM yyyy\"$")
    public void checkAllocationDeposits2DateFormat(){
        holdingsDetailFlow.checkDeposits2DateFormat();
    }

    @Then("^I can see ISO 3 code of holdings deposits2 currency$")
    public void checkDeposits2DataFormat(){
        holdingsDetailFlow.checkDeposits2DataFormat();
    }

    @Then("^I can see ISO 3 code of allocation holdings deposits2 currency$")
    public void checkAllocationDeposits2DataFormat(){
        holdingsDetailFlow.checkDeposits2DataFormat();
    }

    @Then("^I am taken to a detailed holdings deposits3 screen displaying the following data:$")
    public void checkDeposits3DataUI(Map<String,String> map){
        holdingsDetailFlow.checkDeposits3DataUI(map);
    }

    @Then("^I am taken to a allocation deposits3 detailed holdings screen displaying the following data:$")
    public void checkAllocationDeposits3DataUI(Map<String,String> map){
        holdingsDetailFlow.checkDeposits3DataUI(map);
    }

    @Then("^I can see ISO 3 code of holdings deposits3 currency$")
    public void checkDeposits3DataFormat() {
        holdingsDetailFlow.checkDeposits3DataFormat();
    }

    @Then("^I can see ISO 3 code of allocation holdings deposits3 currency$")
    public void checkAllocationDeposits3DataFormat() {
        holdingsDetailFlow.checkDeposits3DataFormat();
    }

    @Then("^I am taken to a detailed holdings deposits4 screen displaying the following data:$")
    public void checkDeposits4DataUI(Map<String,String> map) {
        holdingsDetailFlow.checkDeposits4DataUI(map);
    }

    @Then("^I am taken to a allocation deposits4 detailed holdings screen displaying the following data:$")
    public void checkAllocationDeposits4DataUI(Map<String,String> map) {
        holdingsDetailFlow.checkDeposits4DataUI(map);
    }

    @Then("^I can see holdings deposits4 date value Format is \"dd MMM yyyy\"$")
    public void checkDeposits4DateFormat() {
        holdingsDetailFlow.checkDeposits4DateFormat();
    }

    @Then("^I can see allocation holdings deposits4 date value Format is \"dd MMM yyyy\"$")
    public void checkAllocationDeposits4DateFormat() {
        holdingsDetailFlow.checkDeposits4DateFormat();
    }

    @Then("^I can see ISO 3 code of holdings deposits4 currency$")
    public void checkDeposits4DataFormat(){
        holdingsDetailFlow.checkDeposits4DataFormat();
    }

    @Then("^I can see ISO 3 code of allocation holdings deposits4 currency$")
    public void checkAllocationDeposits4DataFormat(){
        holdingsDetailFlow.checkDeposits4DataFormat();
    }

    @Then("^I am taken to a detailed holdings bonds screen displaying the following data:$")
    public void checkBondsDataUI(Map<String, String> map) {
        holdingsDetailFlow.checkBondsDataUI(map);
    }

    @Then("^I am taken to a allocation bonds detailed holdings screen displaying the following data:$")
    public void checkAllocationBondsDataUI(Map<String, String> map) {
        holdingsDetailFlow.checkBondsDataUI(map);
    }

    @Then("^I am taken to a Structured Products part1 detailed holdings screen displaying the following data:$")
    public void checkStructuredProductsPart1UI(Map<String, String> map) {
        holdingsDetailFlow.checkStructuredProductsPart1UI(map);
    }

    @Then("^I am taken to a Structured Products part2 detailed holdings screen displaying the following data:$")
    public void checkStructuredProductsPart2UI(Map<String, String> map) {
        holdingsDetailFlow.checkStructuredProductsPart2UI(map);
    }

    @Then("^I can see Structured Products part1 detailed date value Format is \"dd MMM yyyy\"$")
    public void checkStructuredProductsPart1Date() {
        holdingsDetailFlow.checkStructuredProductsPart1Date();
    }

    @Then("^I can see Structured Products part2 detailed date value Format is \"dd MMM yyyy\"$")
    public void checkStructuredProductsPart2Date() {
        holdingsDetailFlow.checkStructuredProductsPart2Date();
    }

    @Then("^I can see ISO 3 code of holdings bonds currency$")
    public void checkBondsDataFormat() {
        holdingsDetailFlow.checkBondsDataFormat();
    }

    @Then("^I can see ISO 3 code of allocation bonds holdings bonds currency$")
    public void checkAllocationBondsDataFormat() {
        holdingsDetailFlow.checkBondsDataFormat();
    }

    @Then("^I can see holdings bonds date value Format is \"dd Mmm yyyy\"$")
    public void checkBondsDateFormat() {
        holdingsDetailFlow.checkBondsDateFormat();
    }

    @Then("^I can see allocation holdings bonds date value Format is \"dd Mmm yyyy\"$")
    public void checkAllocationBondsDateFormat() {
        holdingsDetailFlow.checkBondsDateFormat();
    }

    @Then("^I am taken to a detailed holdings bonds2 screen displaying the following data:$")
    public void checkBonds2DataUI(Map<String,String> map){
        holdingsDetailFlow.checkBonds2DataUI(map);

    }

    @Then("^I can see ISO 3 code of holdings bonds2 currency$")
    public void checkBonds2DataFormat() {
        holdingsDetailFlow.checkBonds2DataFormat();
    }

    @Then("^I can see holdings bonds2 date value Format is \"([^\"]*)\"$")
    public void checkBonds2DateFormat(String Format){
        holdingsDetailFlow.checkBonds2DateFormat();
    }

    @Then("^I am taken to a detailed allocation Equities holdings screen displaying the following data:$")
    public void checkAllocationHoldingsEquitiesUI(Map<String,String> map) {
        holdingsDetailFlow.checkEquitiesDetailUI(map);
    }

    @Then("^I should on the allocation holding details$")
    public void onTheAllocationHoldingDetails(){
        holdingsDetailFlow.onPortfoliosHoldingsDetailsLevel();
    }

    @Given("^I am on the allocation holding details$")
    public void allocationHoldingDetails(){
        holdingsDetailFlow.onPortfoliosHoldingsDetailsLevel();
    }

    @Then("^I should see the allocation Equities following data format ISO3$")
    public void checkAllocationEquitiesISO3(){
        holdingsDetailFlow.checkEquitiesNum();
    }

    @Then("^I should see the allocation Equities following data:Last closing price date value \\(format: dd Mmm yyyy\\)、Last purchase date value \\(format: dd Mmm yyyy\\)$")
    public void checkAllocationEquitiesDateFormat(){
        holdingsDetailFlow.checkEquitiesDateFormat();
    }

    @Then("^I am taken to a allocation Private Equity Funds detailed holdings screen displaying the following data:$")
    public void checkPrivateEquityFundsDetailUI(Map<String, String> map){
        holdingsDetailFlow.checkPrivateEquityAndRealEstateFundsDataUI(map);
    }

    @Then("^I should see the allocation Private Equity Funds holding currency and account reference currency format ISO 3 code$")
    public void checkPrivateEquityFundsDetailCurrencyFormat(){
        holdingsDetailFlow.checkPrivateEquityAndRealEstateFundsDataFormat();
    }

    @Then("^I should see the allocation holdings interest rate swaps following ISO 3 format datas:holding currency、portfolio reference currency、Notional amount value$")
    public void checkInterestRateSwapsDetailCurrencyFormat(){
        holdingsDetailFlow.checkInterestRateSwapsDataFormat();
    }

    @Then("^I should see the allocation Interest Rate Swaps date format dd MMM yyyy$")
    public void checkInterestRateSwapsDetailDateFormat(){
        holdingsDetailFlow.checkInterestRateSwapsDateFormat();
    }

    @Then("^I should see the allocation holdings direct investments following ISO 3 format datas:holding currency、portfolio reference currency$")
    public void checkDirectInvestmentsDetailCurrencyFormat(){
        holdingsDetailFlow.checkDirectInvestmentsDataFormat();
    }

    @Then("^I am taken to a allocation Interest Rate Swaps detailed holdings screen displaying the following data:$")
    public void checkInterestRateSwapsDetailUI(Map<String, String> map){
        holdingsDetailFlow.checkInterestRateSwapsDataUI(map);
    }

    @Then("^I am taken to a allocation Direct Investments detailed holdings screen displaying the following data:$")
    public void checkDirectInvestmentsDetailUI(Map<String, String> map) {
        holdingsDetailFlow.checkDirectInvestmentsDataUI(map);
    }

    @Then("^I am taken to a detailed allocation Precious metals holdings screen displaying the following data:$")
    public void checkAccountAllocationPreciousMetalsHoldingsUI(Map<String,String> map) {
        holdingsDetailFlow.checkPreciousMetalsDetailUI(map);
    }

    @Then("^I should see the allocation Precious metals following datas format ISO3$")
    public void checkAllocationPreciousMetalsISO3(){
        holdingsDetailFlow.checkPreciousMetalsDataFormat();
    }

    @Then("^I should see the allocation Precious metals following datas:Last Purchase Date value \\(format: dd Mmm yyyy\\)、Market Price Date value \\(format: dd Mmm yyyy\\)$")
    public void checkAllocationPreciousMetalsDateFormat(){
        holdingsDetailFlow.checkPreciousMetalsDateFormat();
    }

    @Then("^I am taken to a detailed allocation Funds1 holdings screen displaying the following data:$")
    public void checkAllocationFunds1HoldingsUI(Map<String,String> map){
        holdingsDetailFlow.checkFundsDateUI(map);
    }

    @Then("^I should see the allocation Funds1 following datas format: ISO 3$")
    public void checkAllocationFunds1ISO3(){
        holdingsDetailFlow.checkFundsDataFormat();
    }

    @Then("^I should see the allocation Funds1 following data:Market Price Date value \\(format: dd Mmm yyyy\\)、Last buy Date value \\(format: dd Mmm yyyy\\)$")
    public void checkAllocationFunds1DateFormat(){
        holdingsDetailFlow.checkFundsDateFormat();
    }

    @Then("^I am taken to a detailed allocation Funds2 holdings screen displaying the following data:$")
    public void checkAllocationFunds2HoldingsUI(Map<String,String> map){
        holdingsDetailFlow.checkFundsPart2DateUI(map);
    }

    @Then("^I should see the allocation Funds2 following datas format: ISO 3$")
    public void checkAllocationFunds2ISO3(){
        holdingsDetailFlow.checkFundsPart2DataFormat();
    }

    @Then("^I should see the allocation Funds2 following datas:Market Price Date value \\(format: dd Mmm yyyy\\)、Last buy Date value \\(format: dd Mmm yyyy\\)$")
    public void checkAllocationFundsDateFormat(){
        holdingsDetailFlow.checkFundsPart2DateFormat();
    }

    @Then("^I am taken to a detailed allocation structured products holdings screen displaying the following data:$")
    public void checkAllocationStructuredProductsHoldingsUI(Map<String,String> map){
        holdingsDetailFlow.checkStructuredProductsPart2UI(map);
    }

    @Then("^I should see the allocation structured products following datas format:ISO 3$")
    public void checkAllocationStructuredProductsISO3(){
        holdingsDetailFlow.checkStructuredProductsISO3();
    }

    @Then("^I should see the structured products following currency format:ISO 3$")
    public void checkStructuredProductsISO3(){
        holdingsDetailFlow.checkStructuredProductsISO3();
    }

    @Then("^I should see the allocation structured products following date format:dd MMM yyyy$")
    public void checkAllocationStructuredProductsDateFormat() {
        holdingsDetailFlow.checkStructuredProductsPart2Date();
    }

    @Then("^I am taken to a detailed allocation Current Accounts holdings screen displaying the following data:$")
    public void checkAllocationCurrentAccountsHoldingsUI(Map<String,String> map) {
        holdingsDetailFlow.checkCurrentAccountsDataUI(map);
    }

    @Then("^I should see the allocation Current Accounts following datas format:ISO 3$")
    public void checkAllocationCurrentAccountsDataISO3(){
        holdingsDetailFlow.checkCurrentAccountsBlockedCurrentAccountsDataFormat();
    }

    @Then("^I am taken to a detailed allocation Metal ounces holdings screen displaying the following data:$")
    public void checkAllocationMetalOuncesHoldingsUI(Map<String,String> map){
        holdingsDetailFlow.checkMetalOuncesDataUI(map);
    }

    @Then("^I should see the allocation Metal ounces following datas format:ISO 3$")
    public void checkAllocationMetalOuncesISO3(){
        holdingsDetailFlow.checkMetalOuncesDataFormat();
    }

    @Then("^I am taken to a detailed allocation Derivatives1 holdings screen displaying the following data:$")
    public void checkAllocationDerivatives1HoldingsUI(Map<String,String> map){
        holdingsDetailFlow.checkDerivativesDataUI(map);
    }

    @Then("^I should see the allocation Derivatives1 following datas format:ISO 3$")
    public void checkAllocationDerivatives1HoldingsISO3(){
        holdingsDetailFlow.checkDerivatives1DataFormat();
    }

    @Then("^I should see the allocation Derivatives1 following date format:dd MMM yyyy$")
    public void checkAllocationDerivatives1DateFormat(){
        holdingsDetailFlow.checkDerivatives1DateFormat();
    }

    @Then("^I am taken to a detailed allocation Derivatives2 holdings screen displaying the following data:$")
    public void checkAllocationDerivatives2HoldingsUI(Map<String,String> map){
        holdingsDetailFlow.checkDerivatives2DataUI(map);
    }

    @Then("^I should see the allocation Derivatives2 following datas format:ISO 3$")
    public void checkAllocationDerivatives2HoldingsISO3(){
        holdingsDetailFlow.checkDerivatives2DataFormat();
    }

    @Then("^I should see the allocation Derivatives2 following date format:dd MMM yyyy$")
    public void checkAllocationDerivatives2DateFormat(){
        holdingsDetailFlow.checkDerivatives2DateFormat();
    }

    @Then("^I can see holdings deposits3 date value Format is \"dd MMM yyyy\"$")
    public void checkDeposits3DateFormat(){
        holdingsDetailFlow.checkDeposits3DateFormat();
    }

    @Then("^I should not see the value of that holding in base currency$")
    public void checkNotSeeReportCurrency() {
        holdingsDetailFlow.checkNotSeeReportCurrency();
    }

    @Then("^only see the value of that holding in holding currency$")
    public void checkSeeBaseCurrency() {
        holdingsDetailFlow.checkSeeBaseCurrency();
    }

    @Then("^I can see the following components in Discretionary portfolio holding detail screen:$")
    public void checkDiscretionaryAllocationHoldingDetail(Map<String, String> map){
        holdingsDetailFlow.checkDiscretionaryAllocationHoldingDetail();
    }

    @Then("^I can see the following components in Advisory portfolio holding detail screen:$")
    public void checkAdvisoryAllocationHoldingDetail(Map<String, String> map){
        holdingsDetailFlow.checkAdvisoryAllocationHoldingDetail(map);
    }

    @Then("^I can see the holding detail back button label is \"([^\"]*)\"$")
    public void checkOverviewBackButton(String value){
        holdingsDetailFlow.checkOverviewBackButton(value);
    }

    @When("^I tap the holding detail back button$")
    public void tapBackButton(){
        holdingsDetailFlow.tapBackButton();
    }

    @Then("^I can see the holding detail back button label of the current Account name$")
    public void checkAccountBackButton(){
        holdingsDetailFlow.checkAccountBackButton();
    }

    @Then("^I can see the holding detail back button label of the current Portfolio name$")
    public void checkPortfolioBackButton(){
        holdingsDetailFlow.checkPortfolioBackButton();
    }
}
