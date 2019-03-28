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
public class PerformancePage extends BasePage {

    /*
    * Overview Performance
    * */
    @GherkinId(findByObjectId = "overview_main_performance_label")
    private BaseWebElement mainOverViewContent;

    @GherkinId(findByObjectId = "overview_main_performance_btn")
    private BaseWebElement mainOverViewIcon;

    @GherkinId(findByObjectId = "overview_main_performance_amount_label")
    private BaseWebElement mainOverViewAmount;

    @GherkinId(findByObjectId = "overview_main_performance_currency_label")
    private BaseWebElement mainOverViewCurrency;

    /*
     * Account Performance
     * */

    @GherkinId(findByObjectId = "account_main_performance_label")
    private BaseWebElement mainAccountContent;

    @GherkinId(findByObjectId = "account_main_performance_btn")
    private BaseWebElement mainAccountIcon;

    @GherkinId(findByObjectId = "account_main_performance_amount_label")
    private BaseWebElement mainAccountAmount;

    @GherkinId(findByObjectId = "account_main_performance_currency_label")
    private BaseWebElement mainAccountCurrency;

    @GherkinId(findByObjectId = "account_main_performance_weight_label")
    private BaseWebElement mainAccountPercentage;

    /*
     * Portfolio Performance
     * */

    @GherkinId(findByObjectId = "portfolio_main_performance_label")
    private BaseWebElement mainPortfolioContent;

    @GherkinId(findByObjectId = "portfolio_main_performance_btn")
    private BaseWebElement mainPortfolioIcon;

    @GherkinId(findByObjectId = "portfolio_main_performance_amount_label")
    private BaseWebElement mainPortfolioAmount;

    @GherkinId(findByObjectId = "portfolio_main_performance_currency_label")
    private BaseWebElement mainPortfolioCurrency;

    @GherkinId(findByObjectId = "portfolio_main_performance_weight_label")
    private BaseWebElement mainPortfolioPercentage;

    /*
     * Performance overlay   pop-up
     * */

//    @GherkinId(findByObjectId = "performance_overlay_title_label")
//    private BaseWebElement overLayTitle;
//
//    @GherkinId(findByObjectId = "performance_overlay_name_label")
//    private BaseWebElement overLayName;
//
//    @GherkinId(findByObjectId = "performance_overlay_amount_label")
//    private BaseWebElement overLayAmount;
//
//    @GherkinId(findByObjectId = "performance_overlay_currency_label")
//    private BaseWebElement overLayCurrency;
//
//    @GherkinId(findByObjectId = "performance_overlay_weight_label")
//    private BaseWebElement overLayPercentage;
//
//    @GherkinId(findByObjectId = "performance_overlay_calculated_label")
//    private BaseWebElement overLayCalculated;
//
//    @GherkinId(findByObjectId = "performance_overlay_calculated_value_label")
//    private BaseWebElement overLayCalculatedValue;
//
//    @GherkinId(findByObjectId = "performance_overlay_bg_button")
//    private BaseWebElement overLayBG;
//
//    @GherkinId(findByObjectId = "performance_overlay_close_btn")
//    private BaseWebElement overLayCloseBtn;
//
//
//    // only UK pop-up
//    @GherkinId(findByObjectId = "performance_overlay_profit_title_label")
//    private BaseWebElement overLayProfitTxt;
//
//    @GherkinId(findByObjectId = "performance_overlay_performance_title_label")
//    private BaseWebElement overLayPerformanceTitleTxt;
//
//    @GherkinId(findByObjectId = "performance_overlay_performance_calculated_label")
//    private BaseWebElement overLayPerformanceCalculatedTxt;
//
//    @GherkinId(findByObjectId = "performance_overlay_performance_calculated_value_label")
//    private BaseWebElement overLayPerformanceCalculatedValueTxt;
//
//
//    // only ASIA pop-up
//    @GherkinId(findByObjectId = "performance_overlay_content_label")
//    private BaseWebElement overLayContentTxt;
}
