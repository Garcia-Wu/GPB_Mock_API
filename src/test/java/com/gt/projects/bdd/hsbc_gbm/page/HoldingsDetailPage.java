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
public class HoldingsDetailPage extends BasePage {

    @GherkinId(findByObjectId = "holding_detail_back_btn")
    private BaseWebElement backBtn;

    @GherkinId(findByObjectId = "holding_detail_scroll_view")
    private BaseWebElement scrollBtn;

    @GherkinId(name = "Holdings name", findByObjectId = "holding_detail_name_label")
    private BaseWebElement nameTxt;

    @GherkinId(name = "ISIN value", findByObjectId = "holding_detail_isin_label")
    private BaseWebElement isinTxt;

    @GherkinId(name = "Disclaimer label", findByObjectId = "holding_detail_disclaimer_label")
    private BaseWebElement disclaimer;

    @GherkinId(name = "Disclaimer label", findByObjectId = "holding_detail_disclaimer2_label")
    private BaseWebElement disclaimer2;

    /*
     *   Equities
     * */
    @GherkinId(name = "\"Number of shares\" label", findByObjectId = "holding_detail_number_label")
    private BaseWebElement equitiesNumber;

    @GherkinId(name = "Number of shares value", findByObjectId = "holding_detail_number_value_label")
    private BaseWebElement equitiesNumberValue;

    @GherkinId(name = "\"Market value\" label", findByObjectId = "holding_detail_market_label")
    private BaseWebElement equitiesMarket;

    @GherkinId(name = "Market value in holding currency", findByObjectId = "holding_detail_market_base_amount_label")
    private BaseWebElement equitiesMarketBaseAmount;

    @GherkinId(findByObjectId = "holding_detail_market_base_currency_label")
    private BaseWebElement equitiesMarketBaseCurrency;

    @GherkinId(name = "Market value in portfolio reference currency", findByObjectId = "holding_detail_market_report_amount_label")
    private BaseWebElement equitiesMarketReportAmount;

    @GherkinId(findByObjectId = "holding_detail_market_report_currency_label")
    private BaseWebElement equitiesMarketReportCurrency;

    @GherkinId(name = "\"Unrealised P/L\" label", findByObjectId = "holding_detail_p/l_label")
    private BaseWebElement equitiesPL;

    @GherkinId(name = "Unrealised Profit/Loss value as a % based on holding currency", findByObjectId = "holding_detail_p/l_value_label")
    private BaseWebElement equitiesPLValue;

    @GherkinId(name = "\"Average Purchase Price\" label", findByObjectId = "holding_detail_purchase_price_label")
    private BaseWebElement equitiesPurchasePrice;

    @GherkinId(name = "Average Purchase Price value in holding currency", findByObjectId = "holding_detail_purchase_price_amount_label")
    private BaseWebElement equitiesPurchasePriceAmount;

    @GherkinId(findByObjectId = "holding_detail_purchase_price_currency_label")
    private BaseWebElement equitiesPurchasePriceCurrency;

    @GherkinId(name = "\"Last purchase date\" label", findByObjectId = "holding_detail_purchase_date_label")
    private BaseWebElement equitiesPurchaseDate;

    @GherkinId(name = "Last buy Date value", findByObjectId = "holding_detail_purchase_date_value_label")
    private BaseWebElement equitiesPurchaseDateValue;

    @GherkinId(name = "\"Last closing price\" label", findByObjectId = "holding_detail_closing_price_label")
    private BaseWebElement equitiesClosingPrice;

    @GherkinId(name = "Last closing price value", findByObjectId = "holding_detail_closing_price_amount_label")
    private BaseWebElement equitiesClosingPriceAmount;

    @GherkinId(findByObjectId = "holding_detail_closing_price_currency_label")
    private BaseWebElement equitiesClosingPriceCurrency;
    
    @GherkinId(name = "\"Market price date\" label", findByObjectId = "holding_detail_market_price_date_label")
    private BaseWebElement equitiesMarketPriceDate;

    @GherkinId(name = "Market price date value", findByObjectId = "holding_detail_market_price_date_value_label")
    private BaseWebElement equitiesMarketPriceDateValue;

    @GherkinId(name = "\"Sector\" label", findByObjectId = "holding_detail_sector_label")
    private BaseWebElement equitiesSector;

    @GherkinId(name = "Sector value", findByObjectId = "holding_detail_sector_value_label")
    private BaseWebElement equitiesSectorValue;

    @GherkinId(name = "\"Country\" label", findByObjectId = "holding_detail_country_label")
    private BaseWebElement equitiesCountry;

    @GherkinId(name = "Country value", findByObjectId = "holding_detail_country_value_label")
    private BaseWebElement equitiesCountryValue;


    /*
     *   Holding detail:Precious metals
     * */
    @GherkinId(findByObjectId = "holding_detail_quantity_label")
    private BaseWebElement preciousMetalsQuantity;

    @GherkinId(findByObjectId = "holding_detail_quantity_value_label")
    private BaseWebElement preciousMetalsQuantityValue;

    @GherkinId(findByObjectId = "holding_detail_p/l_label")
    private BaseWebElement preciousMetalsPL;

    @GherkinId(findByObjectId = "holding_detail_p/l_value_label")
    private BaseWebElement preciousMetalsPLValue;

    @GherkinId(findByObjectId = "holding_detail_market_label")
    private BaseWebElement preciousMetalsMarket;

    @GherkinId(findByObjectId = "holding_detail_market_base_amount_label")
    private BaseWebElement preciousMetalsMarketBaseAmount;

    @GherkinId(findByObjectId = "holding_detail_market_base_currency_label")
    private BaseWebElement preciousMetalsMarketBaseCurrency;

    @GherkinId(findByObjectId = "holding_detail_market_report_amount_label")
    private BaseWebElement preciousMetalsMarketReportAmount;

    @GherkinId(findByObjectId = "holding_detail_market_report_currency_label")
    private BaseWebElement preciousMetalsMarketReportCurrency;

    @GherkinId(findByObjectId = "holding_detail_purchase_price_label")
    private BaseWebElement preciousMetalsPurchasePrice;

    @GherkinId(findByObjectId = "holding_detail_purchase_price_amount_label")
    private BaseWebElement preciousMetalsPurchasePriceAmount;

    @GherkinId(findByObjectId = "holding_detail_purchase_price_currency_label")
    private BaseWebElement preciousMetalsPurchasePriceCurrency;

    @GherkinId(findByObjectId = "holding_detail_purchase_date_label")
    private BaseWebElement preciousMetalsPurchaseDate;

    @GherkinId(findByObjectId = "holding_detail_purchase_date_value_label")
    private BaseWebElement preciousMetalsPurchaseDateValue;

    @GherkinId(findByObjectId = "holding_detail_closing_price_label")
    private BaseWebElement preciousMetalsClosingPrice;

    @GherkinId(findByObjectId = "holding_detail_closing_price_amount_label")
    private BaseWebElement preciousMetalsClosingPriceAmount;

    @GherkinId(findByObjectId = "holding_detail_closing_price_currency_label")
    private BaseWebElement preciousMetalsClosingPriceCurrency;

    @GherkinId(findByObjectId = "holding_detail_market_price_date_label")
    private BaseWebElement preciousMetalsClosingPriceDate;

    @GherkinId(findByObjectId = "holding_detail_market_price_date_value_label")
    private BaseWebElement preciousMetalsClosingPriceDateValue;


    /*
     * Holding detail:Funds,part1、part2
     * */

    @GherkinId(findByObjectId = "holding_detail_number_label")
    private BaseWebElement fundsNumber;

    @GherkinId(findByObjectId = "holding_detail_number_value_label")
    private BaseWebElement fundsNumberValue;

    @GherkinId(findByObjectId = "holding_detail_market_label")
    private BaseWebElement fundsMarket;

    @GherkinId(findByObjectId = "holding_detail_market_base_amount_label")
    private BaseWebElement fundsMarketBaseAmount;

    @GherkinId(findByObjectId = "holding_detail_market_base_currency_label")
    private BaseWebElement fundsMarketBaseCurrency;

    @GherkinId(findByObjectId = "holding_detail_market_report_amount_label")
    private BaseWebElement fundsMarketReportAmount;

    @GherkinId(findByObjectId = "holding_detail_market_report_currency_label")
    private BaseWebElement fundsMarketReportCurrency;

    @GherkinId(findByObjectId = "holding_detail_p/l_label")
    private BaseWebElement fundsPL;

    @GherkinId(findByObjectId = "holding_detail_p/l_value_label")
    private BaseWebElement fundsPLValue;

    @GherkinId(findByObjectId = "holding_detail_purchase_price_label")
    private BaseWebElement fundsPurchasePrice;

    @GherkinId(findByObjectId = "holding_detail_purchase_price_amount_label")
    private BaseWebElement fundsPurchasePriceAmount;

    @GherkinId(findByObjectId = "holding_detail_purchase_price_currency_label")
    private BaseWebElement fundsPurchasePriceCurrency;

    @GherkinId(findByObjectId = "holding_detail_purchase_date_label")
    private BaseWebElement fundsPurchaseDate;

    @GherkinId(findByObjectId = "holding_detail_purchase_date_value_label")
    private BaseWebElement fundsPurchaseDateValue;

    @GherkinId(findByObjectId = "holding_detail_closing_price_label")
    private BaseWebElement fundsClosingPrice;

    @GherkinId(findByObjectId = "holding_detail_closing_price_amount_label")
    private BaseWebElement fundsClosingPriceAmount;

    @GherkinId(findByObjectId = "holding_detail_closing_price_currency_label")
    private BaseWebElement fundsClosingPriceCurrency;

    @GherkinId(findByObjectId = "holding_detail_market_price_date_label")
    private BaseWebElement fundsMarketPriceDate;

    @GherkinId(findByObjectId = "holding_detail_market_price_date_value_label")
    private BaseWebElement fundsMarketPriceDateValue;

    @GherkinId(findByObjectId = "holding_detail_sector_label")
    private BaseWebElement fundsSector;

    @GherkinId(findByObjectId = "holding_detail_sector_value_label")
    private BaseWebElement fundsSectorValue;

    @GherkinId(findByObjectId = "holding_detail_market_price_label")
    private BaseWebElement fundsMarketPrice;

    @GherkinId(findByObjectId = "holding_detail_market_price_amount_label")
    private BaseWebElement fundsMarketPriceAmount;

    @GherkinId(findByObjectId = "holding_detail_market_price_currency_label")
    private BaseWebElement fundsMarketPriceCurrency;

    @GherkinId(findByObjectId = "holding_detail_amount_label")
    private BaseWebElement fundsAmount;

    @GherkinId(findByObjectId = "holding_detail_amount_value_label")
    private BaseWebElement fundsAmountValue;

    /*
     * Holding detail:Structured Products1、Holding detail:Structured Products2
     * */

    @GherkinId(findByObjectId = "holding_detail_market_label")
    private BaseWebElement structuredProductsTotal;

    @GherkinId(findByObjectId = "holding_detail_market_base_amount_label")
    private BaseWebElement structuredProductsTotalBaseAmount;

    @GherkinId(findByObjectId = "holding_detail_market_base_currency_label")
    private BaseWebElement structuredProductsTotalBaseCurrency;

    @GherkinId(findByObjectId = "holding_detail_market_report_amount_label")
    private BaseWebElement structuredProductsTotalReportAmount;

    @GherkinId(findByObjectId = "holding_detail_market_report_currency_label")
    private BaseWebElement structuredProductsTotalReportCurrency;

    @GherkinId(findByObjectId = "holding_detail_p/l_label")
    private BaseWebElement structuredProductsPL;

    @GherkinId(findByObjectId = "holding_detail_p/l_value_label")
    private BaseWebElement structuredProductsPLValue;

    @GherkinId(findByObjectId = "holding_detail_accrued_interest_label")
    private BaseWebElement structuredProductsAccruedInterest;

    @GherkinId(findByObjectId = "holding_detail_accrued_interest_amount_label")
    private BaseWebElement structuredProductsAccruedInterestAmount;

    @GherkinId(findByObjectId = "holding_detail_accrued_interest_currency_label")
    private BaseWebElement structuredProductsAccruedInterestCurrency;

    @GherkinId(findByObjectId = "holding_detail_nominal_amount_label")
    private BaseWebElement structuredProductsNominalAmount;

    @GherkinId(findByObjectId = "holding_detail_nominal_amount_amount_label")
    private BaseWebElement structuredProductsNominalAmountAmount;

    @GherkinId(findByObjectId = "holding_detail_nominal_amount_currency_label")
    private BaseWebElement structuredProductsNominalAmountCurrency;

    @GherkinId(findByObjectId = "holding_detail_maturity_date_label")
    private BaseWebElement structuredProductsMaturityDate;

    @GherkinId(findByObjectId = "holding_detail_maturity_date_value_label")
    private BaseWebElement structuredProductsMaturityDateValue;

    @GherkinId(findByObjectId = "holding_detail_purchase_price_label")
    private BaseWebElement structuredProductsPurchasePrice;

    //百分比
    @GherkinId(findByObjectId = "holding_detail_purchase_price_value_label")
    private BaseWebElement structuredProductsPurchasePriceValue;

    @GherkinId(findByObjectId = "holding_detail_buy_date_label")
    private BaseWebElement structuredProductsBuyDate;

    @GherkinId(findByObjectId = "holding_detail_buy_date_value_label")
    private BaseWebElement structuredProductsBuyDateValue;

    @GherkinId(findByObjectId = "holding_detail_indicative_price_label")
    private BaseWebElement structuredProductsIndicativePrice;

    @GherkinId(findByObjectId = "holding_detail_indicative_price_value_label")
    private BaseWebElement structuredProductsIndicativePriceValue;

    @GherkinId(findByObjectId = "holding_detail_indicative_price_date_label")
    private BaseWebElement structuredProductsIndicativePriceDate;

    @GherkinId(findByObjectId = "holding_detail_indicative_price_date_value_label")
    private BaseWebElement structuredProductsIndicativePriceDateValue;

    @GherkinId(findByObjectId = "holding_detail_issuer_label")
    private BaseWebElement structuredProductsIssuer;

    @GherkinId(findByObjectId = "holding_detail_issuer_value_label")
    private BaseWebElement structuredProductsIssuerValue;

    @GherkinId(findByObjectId = "holding_detail_rating_moody_label")
    private BaseWebElement structuredProductsRatingMoody;

    @GherkinId(findByObjectId = "holding_detail_rating_moody_value_label")
    private BaseWebElement structuredProductsRatingMoodyValue;

    @GherkinId(findByObjectId = "holding_detail_rating_s&p_label")
    private BaseWebElement structuredProductsRatingSP;

    @GherkinId(findByObjectId = "holding_detail_rating_s&p_value_label")
    private BaseWebElement structuredProductsRatingSPValue;

//    @GherkinId(findByObjectId = "holding_detail_coupon_frequency_label")
//    private BaseWebElement structuredProductsCouponFrequency;
//
//    @GherkinId(findByObjectId = "holding_detail_coupon_frequency_value_label")
//    private BaseWebElement structuredProductsCouponFrequencyValue;

    @GherkinId(findByObjectId = "holding_detail_disclaimer2_label")
    private BaseWebElement structuredProductsDisclaimer2;

    /*
    * Holding detail:Current Accounts, Blocked Current Accounts
    * */
    @GherkinId(findByObjectId = "holding_detail_balance_label")
    private BaseWebElement blockedCurrentBalance;

    @GherkinId(findByObjectId = "holding_detail_balance_base_amount_label")
    private BaseWebElement blockedCurrentBalanceBaseAmount;

    @GherkinId(findByObjectId = "holding_detail_balance_base_currency_label")
    private BaseWebElement blockedCurrentBalanceBaseCurrency;

    @GherkinId(findByObjectId = "holding_detail_balance_report_amount_label")
    private BaseWebElement blockedCurrentBalanceReportAmount;

    @GherkinId(findByObjectId = "holding_detail_balance_report_currency_label")
    private BaseWebElement blockedCurrentBalanceReportCurrency;

//    sprint 6 remove
//    @GherkinId(findByObjectId = "holding_detail_average_price_label")
//    private BaseWebElement blockedCurrentAveragePrice;
//
//    @GherkinId(findByObjectId = "holding_detail_average_price_amount_label")
//    private BaseWebElement blockedCurrentAveragePriceAmount;

    @GherkinId(findByObjectId = "holding_detail_average_price_currency_label")
    private BaseWebElement blockedCurrentAveragePriceCurrency;

    /*
    *   Holding detail:Metal ounces
    * */

    @GherkinId(findByObjectId = "holding_detail_quantity_label")
    private BaseWebElement metalOuncesQuantity;

    @GherkinId(findByObjectId = "holding_detail_quantity_value_label")
    private BaseWebElement metalOuncesQuantityValue;

    @GherkinId(findByObjectId = "holding_detail_market_label")
    private BaseWebElement metalOuncesMarket;

    @GherkinId(findByObjectId = "holding_detail_market_amount_label")
    private BaseWebElement metalOuncesMarketAmount;

    @GherkinId(findByObjectId = "holding_detail_market_currency_label")
    private BaseWebElement metalOuncesMarketCurrency;

    /*
    *
    * Holding detail:Derivatives1、Derivatives2
    * */

    @GherkinId(findByObjectId = "holding_detail_quantity_label")
    private BaseWebElement derivativesQuantity;

    @GherkinId(findByObjectId = "holding_detail_quantity_value_label")
    private BaseWebElement derivativesQuantityValue;

    @GherkinId(findByObjectId = "holding_detail_expiry_date_label")
    private BaseWebElement derivativesExpiryDate;

    @GherkinId(findByObjectId = "holding_detail_expiry_date_value_label")
    private BaseWebElement derivativesExpiryDateValue;

    @GherkinId(findByObjectId = "holding_detail_market_label")
    private BaseWebElement derivativesMarket;

    @GherkinId(findByObjectId = "holding_detail_market_base_amount_label")
    private BaseWebElement derivativesMarketBaseAmount;

    @GherkinId(findByObjectId = "holding_detail_market_base_currency_label")
    private BaseWebElement derivativesMarketBaseCurrency;

    @GherkinId(findByObjectId = "holding_detail_market_report_amount_label")
    private BaseWebElement derivativesMarketReportAmount;

    @GherkinId(findByObjectId = "holding_detail_market_report_currency_label")
    private BaseWebElement derivativesMarketReportCurrency;

    @GherkinId(findByObjectId = "holding_detail_p/l_label")
    private BaseWebElement derivativesPL;

    @GherkinId(findByObjectId = "holding_detail_p/l_value_label")
    private BaseWebElement derivativesPLValue;

    @GherkinId(findByObjectId = "holding_detail_average_option_premium_label")
    private BaseWebElement derivativesAverageOptionPremium;

    @GherkinId(findByObjectId = "holding_detail_average_option_premium_value_label")
    private BaseWebElement derivativesAverageOptionPremiumValue;

    @GherkinId(findByObjectId = "holding_detail_transaction_date_label")
    private BaseWebElement derivativesTransactionDate;

    @GherkinId(findByObjectId = "holding_detail_transaction_date_value_label")
    private BaseWebElement derivativesTransactionDateValue;

    @GherkinId(findByObjectId = "holding_detail_indicative_market_price_label")
    private BaseWebElement derivativesIndicativeMarketPrice;

    @GherkinId(findByObjectId = "holding_detail_indicative_market_price_value_label")
    private BaseWebElement derivativesIndicativeMarketPriceValue;

    @GherkinId(findByObjectId = "holding_detail_indicative_market_price_date_label")
    private BaseWebElement derivativesIndicativeMarketPriceDate;

    @GherkinId(findByObjectId = "holding_detail_indicative_market_price_date_value_label")
    private BaseWebElement derivativesIndicativeMarketPriceDateValue;

    @GherkinId(findByObjectId = "holding_detail_nominal_amount_label")
    private BaseWebElement derivativesNominalAmount;

    @GherkinId(findByObjectId = "holding_detail_nominal_amount_amount_label")
    private BaseWebElement derivativesNominalAmountAmount;

    @GherkinId(findByObjectId = "holding_detail_nominal_amount_currency_label")
    private BaseWebElement derivativesNominalAmountCurrency;

    @GherkinId(findByObjectId = "holding_detail_maturity_date_label")
    private BaseWebElement derivativesMaturityDate;

    @GherkinId(findByObjectId = "holding_detail_maturity_date_value_label")
    private BaseWebElement derivativesMaturityDateValue;

    @GherkinId(findByObjectId = "holding_detail_average_premium_paid_label")
    private BaseWebElement derivativesAveragePremiumPaid;

    @GherkinId(findByObjectId = "holding_detail_average_premium_paid_value_label")
    private BaseWebElement derivativesAveragePremiumPaidValue;

    @GherkinId(findByObjectId = "holding_detail_purchase_date_label")
    private BaseWebElement derivativesLastPurchaseDate;

    @GherkinId(findByObjectId = "holding_detail_purchase_date_value_label")
    private BaseWebElement derivativesLastPurchaseDateValue;

    /*
    * Holding detail:Direct Investments (Private Equity), Promemoria and Other
    * */

    @GherkinId(findByObjectId = "holding_detail_total_label")
    private BaseWebElement directInvestmentsTotal;

    //totalt
    @GherkinId(findByObjectId = "holding_detail_total_base_amount_label")
    private BaseWebElement directInvestmentsTotalBaseAmount;

    @GherkinId(findByObjectId = "holding_detail_total_base_currency_label")
    private BaseWebElement directInvestmentsTotalBaseCurrency;

    @GherkinId(findByObjectId = "holding_detail_total_report_amount_label")
    private BaseWebElement directInvestmentsTotalReportAmount;

    @GherkinId(findByObjectId = "holding_detail_total_report_currency_label")
    private BaseWebElement directInvestmentsTotalReportCurrency;

    /*
    * Holding detail:Interest Rate Swaps
    * */

    @GherkinId(findByObjectId = "holding_detail_market_label")
    private BaseWebElement interestRateSwapsMarket;

    @GherkinId(findByObjectId = "holding_detail_market_base_amount_label")
    private BaseWebElement interestRateSwapsMarketBaseAmount;

    @GherkinId(findByObjectId = "holding_detail_market_base_currency_label")
    private BaseWebElement interestRateSwapsMarketBaseCurrency;

    @GherkinId(findByObjectId = "holding_detail_market_report_amount_label")
    private BaseWebElement interestRateSwapsMarketReportAmount;

    @GherkinId(findByObjectId = "holding_detail_market_report_currency_label")
    private BaseWebElement interestRateSwapsMarketReportCurrency;

    @GherkinId(findByObjectId = "holding_detail_expiry_date_label")
    private BaseWebElement interestRateSwapsExpiryDate;

    @GherkinId(findByObjectId = "holding_detail_expiry_date_value_label")
    private BaseWebElement interestRateSwapsExpiryDateValue;

    @GherkinId(findByObjectId = "holding_detail_nominal_amount_label")
    private BaseWebElement interestRateSwapsNominalAmount;

    @GherkinId(findByObjectId = "holding_detail_nominal_amount_amount_label")
    private BaseWebElement interestRateSwapsNominalAmountAmount;

    @GherkinId(findByObjectId = "holding_detail_nominal_amount_currency_label")
    private BaseWebElement interestRateSwapsNominalAmountCurrency;

//    sprint 6 remove
//    @GherkinId(findByObjectId = "holding_detail_fixed_rate_label")
//    private BaseWebElement interestRateSwapsFixedRate;
//
//    @GherkinId(findByObjectId = "holding_detail_fixed_rate_value_label")
//    private BaseWebElement interestRateSwapsFixedRateValue;

    @GherkinId(findByObjectId = "holding_detail_indicative_price_label")
    private BaseWebElement interestRateSwapsIndicativePrice;

    @GherkinId(findByObjectId = "holding_detail_indicative_price_value_label")
    private BaseWebElement interestRateSwapsIndicativePriceValue;

    @GherkinId(findByObjectId = "holding_detail_indicative_price_date_label")
    private BaseWebElement interestRateSwapsIndicativePriceDate;

    @GherkinId(findByObjectId = "holding_detail_indicative_price_date_value_label")
    private BaseWebElement interestRateSwapsIndicativePriceDateValue;

    /*
    * Holding detail:Futures
    * */

    @GherkinId(findByObjectId = "holding_detail_number_label")
    private BaseWebElement futuresNumber;

    @GherkinId(findByObjectId = "holding_detail_number_value_label")
    private BaseWebElement futuresNumberValue;

    @GherkinId(findByObjectId = "holding_detail_expiry_date_label")
    private BaseWebElement futuresExpiryDate;

    @GherkinId(findByObjectId = "holding_detail_expiry_date_value_label")
    private BaseWebElement futuresExpiryDateValue;

    @GherkinId(findByObjectId = "holding_detail_p/l_label")
    private BaseWebElement futuresPl;

    @GherkinId(findByObjectId = "holding_detail_p/l_value_label")
    private BaseWebElement futuresPlValue;

    @GherkinId(findByObjectId = "holding_detail_transaction_price_label")
    private BaseWebElement futuresTransactionPrice;

    @GherkinId(findByObjectId = "holding_detail_transaction_price_amount_label")
    private BaseWebElement futuresTransactionPriceAmount;

    @GherkinId(findByObjectId = "holding_detail_transaction_price_currency_label")
    private BaseWebElement futuresTransactionPriceCurrency;

    @GherkinId(findByObjectId = "holding_detail_transaction_date_label")
    private BaseWebElement futuresTransactionDate;

    @GherkinId(findByObjectId = "holding_detail_transaction_date_value_label")
    private BaseWebElement futuresTransactionDateValue;

    @GherkinId(findByObjectId = "holding_detail_contract_price_price_label")
    private BaseWebElement futuresContractPricePrice;

    @GherkinId(findByObjectId = "holding_detail_contract_price_price_amount_label")
    private BaseWebElement futuresContractPricePriceAmount;

    @GherkinId(findByObjectId = "holding_detail_contract_price_price_currency_label")
    private BaseWebElement futuresContractPricePriceCurrency;

    @GherkinId(findByObjectId = "holding_detail_contract_price_date_label")
    private BaseWebElement futuresContractPriceDate;

    @GherkinId(findByObjectId = "holding_detail_contract_price_date_value_label")
    private BaseWebElement futuresContractPriceDateValue;

    /*
    * Holding detail:Foreign Exchange
    * */

    //numinal
    @GherkinId(findByObjectId = "holding_detail_nominal_amount_label")
    private BaseWebElement foreignExchangeNominalAmount;

    @GherkinId(findByObjectId = "holding_detail_buy_label")
    private BaseWebElement foreignExchangeBuy;

    @GherkinId(findByObjectId = "holding_detail_buy_amount_label")
    private BaseWebElement foreignExchangeBuyAmount;

    @GherkinId(findByObjectId = "holding_detail_buy_currency_label")
    private BaseWebElement foreignExchangeBuyCurrency;

    @GherkinId(findByObjectId = "holding_detail_sell_label")
    private BaseWebElement foreignExchangeSell;

    @GherkinId(findByObjectId = "holding_detail_sell_amount_label")
    private BaseWebElement foreignExchangeSellAmount;

    @GherkinId(findByObjectId = "holding_detail_sell_currency_label")
    private BaseWebElement foreignExchangeSellCurrency;

    @GherkinId(findByObjectId = "holding_detail_p/l_label")
    private BaseWebElement foreignExchangeProfitLoss;

    @GherkinId(findByObjectId = "holding_detail_p/l_value_label")
    private BaseWebElement foreignExchangeProfitLossAmount;

    @GherkinId(findByObjectId = "holding_detail_p/l_currency_label")
    private BaseWebElement foreignExchangeProfitLossCurrency;

    @GherkinId(findByObjectId = "holding_detail_trade_date_label")
    private BaseWebElement foreignExchangeTradeDate;

    @GherkinId(findByObjectId = "holding_detail_trade_date_value_label")
    private BaseWebElement foreignExchangeTradeDateValue;

    @GherkinId(findByObjectId = "holding_detail_maturity_date_label")
    private BaseWebElement foreignExchangeMaturity;

    @GherkinId(findByObjectId = "holding_detail_maturity_date_value_label")
    private BaseWebElement foreignExchangeMaturityValue;

    @GherkinId(findByObjectId = "holding_detail_forward_mark_label")
    private BaseWebElement foreignExchangeForwardMark;

    @GherkinId(findByObjectId = "holding_detail_forward_mark_value_label")
    private BaseWebElement foreignExchangeForwardMarkValue;

    @GherkinId(findByObjectId = "holding_detail_exchange_rate_label")
    private BaseWebElement foreignExchangeExchangeRate;

    @GherkinId(findByObjectId = "holding_detail_exchange_rate_value_label")
    private BaseWebElement foreignExchangeExchangeRateValue;

    /*
    * Holding detail :Private Equity & Real Estate Funds
    * */

    @GherkinId(findByObjectId = "holding_detail_market_label")
    private BaseWebElement privateEquityMarket;

    @GherkinId(findByObjectId = "holding_detail_market_base_amount_label")
    private BaseWebElement privateEquityMarketBaseAmount;

    @GherkinId(findByObjectId = "holding_detail_market_base_currency_label")
    private BaseWebElement privateEquityMarketBaseCurrency;

    @GherkinId(findByObjectId = "holding_detail_market_report_amount_label")
    private BaseWebElement privateEquityMarketReportAmount;

    @GherkinId(findByObjectId = "holding_detail_market_report_currency_label")
    private BaseWebElement privateEquityMarketReportCurrency;

    @GherkinId(findByObjectId = "holding_detail_commitment_label")
    private BaseWebElement privateEquityCommitment;

    @GherkinId(findByObjectId = "holding_detail_commitment_amount_label")
    private BaseWebElement privateEquityCommitmentAmount;

    @GherkinId(findByObjectId = "holding_detail_commitment_currency_label")
    private BaseWebElement privateEquityCommitmentCurrency;

    /*
    *  Holding detail:Deposits
    * */

    @GherkinId(findByObjectId = "holding_detail_p/l_label")
    private BaseWebElement depositsPL;

    @GherkinId(findByObjectId = "holding_detail_p/l_value_label")
    private BaseWebElement depositsPLValue;

    @GherkinId(findByObjectId = "holding_detail_market_label")
    private BaseWebElement depositsTotal;

    @GherkinId(findByObjectId = "holding_detail_market_base_amount_label")
    private BaseWebElement depositsTotalBaseAmount;

    @GherkinId(findByObjectId = "holding_detail_market_base_currency_label")
    private BaseWebElement depositsTotalBaseCurrency;

    @GherkinId(findByObjectId = "holding_detail_market_report_amount_label")
    private BaseWebElement depositsTotalReportAmount;

    @GherkinId(findByObjectId = "holding_detail_market_report_currency_label")
    private BaseWebElement depositsTotalReportCurrency;

    @GherkinId(findByObjectId = "holding_detail_balance_label")
    private BaseWebElement depositsBalance;

    @GherkinId(findByObjectId = "holding_detail_balance_amount_label")
    private BaseWebElement depositsBalanceAmount;

    @GherkinId(findByObjectId = "holding_detail_balance_currency_label")
    private BaseWebElement depositsBalanceCurrency;

    @GherkinId(findByObjectId = "holding_detail_amount_maturity_label")
    private BaseWebElement depositsAmountMaturity;

//    @GherkinId(findByObjectId = "holding_detail_amount_maturity_amount_label")
//    private BaseWebElement depositsAmountMaturityAmount;
//
//    @GherkinId(findByObjectId = "holding_detail_amount_maturity_currency_label")
//    private BaseWebElement depositsAmountMaturityCurrency;

    @GherkinId(findByObjectId = "holding_detail_accrued_interest_label")
    private BaseWebElement depositsAccruedInterest;

    @GherkinId(findByObjectId = "holding_detail_accrued_interest_amount_label")
    private BaseWebElement depositsAccruedInterestAmount;

    @GherkinId(findByObjectId = "holding_detail_accrued_interest_currency_label")
    private BaseWebElement depositsAccruedInterestCurrency;

    @GherkinId(findByObjectId = "holding_detail_maturity_date_label")
    private BaseWebElement depositsMaturityDate;

    @GherkinId(findByObjectId = "holding_detail_maturity_date_value_label")
    private BaseWebElement depositsMaturityDateValue;

    @GherkinId(findByObjectId = "holding_detail_accrued_interest_label")
    private BaseWebElement depositsAccruedProfit;

    @GherkinId(findByObjectId = "holding_detail_accrued_interest_amount_label")
    private BaseWebElement depositsAccruedProfitAmount;

    @GherkinId(findByObjectId = "holding_detail_accrued_interest_currency_label")
    private BaseWebElement depositsAccruedProfitCurrency;

    @GherkinId(findByObjectId = "holding_detail_average_price_label")
    private BaseWebElement depositsAveragePrice;

    @GherkinId(findByObjectId = "holding_detail_average_price_value_label")
    private BaseWebElement depositsAveragePriceValue;

    @GherkinId(findByObjectId = "holding_detail_average_price_currency_label")
    private BaseWebElement depositsAveragePriceCurrency;

    @GherkinId(findByObjectId = "holding_detail_purchase_date_label")
    private BaseWebElement depositsPurchaseDate;

    @GherkinId(findByObjectId = "holding_detail_purchase_date_value_label")
    private BaseWebElement depositsPurchaseDateValue;

    /*
    *  Holding detail:Bonds
    * */

    @GherkinId(findByObjectId = "holding_detail_market_label")
    private BaseWebElement bondsTotal;

    @GherkinId(findByObjectId = "holding_detail_market_base_amount_label")
    private BaseWebElement bondsTotalBaseAmount;

    @GherkinId(findByObjectId = "holding_detail_market_base_currency_label")
    private BaseWebElement bondsTotalBaseCurrency;

    @GherkinId(findByObjectId = "holding_detail_market_report_amount_label")
    private BaseWebElement bondsTotalReportAmount;

    @GherkinId(findByObjectId = "holding_detail_market_report_currency_label")
    private BaseWebElement bondsTotalReportCurrency;

//    sprint 6 remove
    @GherkinId(findByObjectId = "holding_detail_accrued_interest_label")
    private BaseWebElement bondsAccruedInterest;

    @GherkinId(findByObjectId = "holding_detail_accrued_interest_amount_label")
    private BaseWebElement bondsAccruedInterestAmount;

    @GherkinId(findByObjectId = "holding_detail_accrued_interest_currency_label")
    private BaseWebElement bondsAccruedInterestCurrency;

    @GherkinId(findByObjectId = "holding_detail_accrued_interest_label")
    private BaseWebElement bondsAccruedProfit;

    @GherkinId(findByObjectId = "holding_detail_accrued_interest_amount_label")
    private BaseWebElement bondsAccruedProfitAmount;

    @GherkinId(findByObjectId = "holding_detail_accrued_interest_currency_label")
    private BaseWebElement bondsAccruedProfitCurrency;

    @GherkinId(findByObjectId = "holding_detail_maturity_date_label")
    private BaseWebElement bondsMaturityDate;

    @GherkinId(findByObjectId = "holding_detail_maturity_date_value_label")
    private BaseWebElement bondsMaturityDateValue;

    @GherkinId(findByObjectId = "holding_detail_duration_label")
    private BaseWebElement bondsDuration;

    @GherkinId(findByObjectId = "holding_detail_duration_value_label")
    private BaseWebElement bondsDurationValue;

    @GherkinId(findByObjectId = "holding_detail_ytw/ytm_label")
    private BaseWebElement bondsYtwYtm;

    @GherkinId(findByObjectId = "holding_detail_ytw/ytm_value_label")
    private BaseWebElement bondsYtwYtmValue;

    @GherkinId(findByObjectId = "holding_detail_nominal_label")
    private BaseWebElement bondsNominal;

    @GherkinId(findByObjectId = "holding_detail_nominal_amount_label")
    private BaseWebElement bondsNominalAmount;

    @GherkinId(findByObjectId = "holding_detail_nominal_currency_label")
    private BaseWebElement bondsNominalCurrency;

    @GherkinId(findByObjectId = "holding_detail_average_purchase_price_label")
    private BaseWebElement bondsAveragePurchasePrice;

    @GherkinId(findByObjectId = "holding_detail_average_purchase_price_value_label")
    private BaseWebElement bondsAveragePurchasePriceValue;

    @GherkinId(findByObjectId = "holding_detail_buy_date_label")
    private BaseWebElement bondsBuyDate;

    @GherkinId(findByObjectId = "holding_detail_buy_date_value_label")
    private BaseWebElement bondsBuyDateValue;

    @GherkinId(findByObjectId = "holding_detail_indicative_market_price_label")
    private BaseWebElement bondsIndicitiveMarketPrice;

    @GherkinId(findByObjectId = "holding_detail_indicative_market_price_value_label")
    private BaseWebElement bondsIndicitiveMarketPriceValue;

    @GherkinId(findByObjectId = "holding_detail_market_price_date_label")
    private BaseWebElement bondsMarketPriceDate;

    @GherkinId(findByObjectId = "holding_detail_market_price_date_value_label")
    private BaseWebElement bondsMarketPriceDateValue;

    @GherkinId(findByObjectId = "holding_detail_issuer_label")
    private BaseWebElement bondsIssuer;

    @GherkinId(findByObjectId = "holding_detail_issuer_value_label")
    private BaseWebElement bondsIssuerValue;

    @GherkinId(findByObjectId = "holding_detail_rating_moody_label")
    private BaseWebElement bondsRatingMoody;

    @GherkinId(findByObjectId = "holding_detail_rating_moody_value_label")
    private BaseWebElement bondsRatingMoodyValue;

    @GherkinId(findByObjectId = "holding_detail_rating_s&p_label")
    private BaseWebElement bondsRatingRP;

    @GherkinId(findByObjectId = "holding_detail_rating_s&p_value_label")
    private BaseWebElement bondsRatingRPValue;

//    sprint 6 remove
//    @GherkinId(findByObjectId = "holding_detail_coupon_frequency_label")
//    private BaseWebElement bondsCouponFrequency;
//
//    @GherkinId(findByObjectId = "holding_detail_coupon_frequency_value_label")
//    private BaseWebElement bondsCouponFrequencyValue;

    @GherkinId(findByObjectId = "holding_detail_country_risk_label")
    private BaseWebElement bondsCountryRisk;

    @GherkinId(findByObjectId = "holding_detail_country_risk_value_label")
    private BaseWebElement bondsCountryRiskValue;

    @GherkinId(findByObjectId = "holding_detail_minimum_investment_label")
    private BaseWebElement bondsMinimumInvestment;

    @GherkinId(findByObjectId = "holding_detail_minimum_investment_amount_label")
    private BaseWebElement bondsMinimumInvestmentAmount;

    @GherkinId(findByObjectId = "holding_detail_minimum_investment_currency_label")
    private BaseWebElement bondsMinimumInvestmentCurrency;

}
