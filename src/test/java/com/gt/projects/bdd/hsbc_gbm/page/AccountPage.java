package com.gt.projects.bdd.hsbc_gbm.page;

import com.gt.projects.bdd.base.BasePage;
import com.gt.projects.bdd.base.BaseWebElement;
import com.gt.projects.bdd.base.annotation.GherkinId;
import cucumber.api.java.en.Given;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.print.attribute.standard.PrinterURI;

@Component
@Data
@Scope("thread")
public class AccountPage extends BasePage {

    /* ---  Account Main  -   wrapper-- */

    //back to overview level
    @GherkinId(name = "back overview button",findByObjectId = "account_main_back_btn")
    private BaseWebElement mainBackBtn;

    //menu
    @GherkinId(name = "menu icon",findByObjectId = "overview_main_menu_btn")
    private BaseWebElement mainMenuBtn;

    //update time
    @GherkinId(findByObjectId = "account_main_date_label")
    private BaseWebElement mainUpdateTimeBtn;

    //name
    @GherkinId(name = "Account name",findByObjectId = "account_main_username_label")
    private BaseWebElement mainUsernameTxt;

    //ID
    @GherkinId(name = "Account id",findByObjectId = "account_main_userId_label")
    private BaseWebElement mainUserIdTxt;

    //Total assets title
    @GherkinId(name = "Total assets title",findByObjectId = "account_main_total_assets_label")
    private BaseWebElement mainTotalAssetsTxt;

    //Total assets image
    @GherkinId(name = "info icon",findByObjectId = "account_main_total_assets_img")
    private BaseWebElement mainTotalAssetsImg;

    //Total assets GBP
    @GherkinId(name = "currency label",findByObjectId = "account_main_gbp_btn")
    private BaseWebElement mainGbpBtn;

    @GherkinId(findByObjectId = "cc_icon")
    private BaseWebElement iosMainGbpBtn;

    //Total assets value
    @GherkinId(name = "Total assets amount",findByObjectId = "account_main_total_assets_content_btn")
    private BaseWebElement mainTotalAssetsContentTxt;
    @GherkinId(findByObjectId = "account_main_total_assets_currency_btn")
    private BaseWebElement mainTotalAssetsCurrencyTxt;
    //

    /* -------------click total assets 出现的弹出框--------------- */
    //Total assets pop-up
//    @GherkinId(name = "close button",findByObjectId = "overviewlayer_main_close_btn")
//    private BaseWebElement accountTotalAssetsClose;
//    @GherkinId(name = "Total Assets header",findByObjectId = "overviewlayer_main_title_label")
//    private BaseWebElement accountTotalAssetsTitle;
//    @GherkinId(findByObjectId = "overviewlayer_mian_gbp")  // 数字的单位（GBP）
//    private BaseWebElement accountTotalAssetsGbpTxt;
//    @GherkinId(name = "Account Total Assets name",findByObjectId = "overviewlayer_main_name_label")
//    private BaseWebElement accountTotalAssetsName;
//    @GherkinId(name = "Total assets value",findByObjectId = "overviewlayer_main_total_assets_label")
//    private BaseWebElement accountTotalAssetsAmount;
//    @GherkinId(name = "How is the calculated header",findByObjectId = "overviewlayer_main_question")
//    private BaseWebElement accountTotalAssetsQuestion;
//    @GherkinId(name = "Copy indicating how this figure has been calculated",findByObjectId = "overviewlayer_mian_answer")
//    private BaseWebElement accountTotalAssetsAnswer;

    @GherkinId(name = "Portfolios header",findByObjectId = "portfolio_list_title_label")
    private BaseWebElement portfolioListTitle;

    @GherkinId(name = "Allocation button default",findByObjectId = "account_main_allocation_off_btn")
    private BaseWebElement mainAllocationBtn;

    @GherkinId(name = "Allocation button active",findByObjectId = "account_main_allocation_on_btn")
    private BaseWebElement mainAllocationActiveBtn;

//Shell
//    @GherkinId(name = "Allocation Toggle",findByObjectId = "account_main_allocation_off_btn")
//    private BaseWebElement allocationBtnOff;
    @GherkinId(name = "Allocation Toggle",findByObjectId = "allocation_main_toggle_btn",findByName = "allocation_main_toggle_btn")
    private BaseWebElement allocationBtnOff;
//Shell
//    @GherkinId(findByObjectId = "account_main_allocation_on_btn")
//    private BaseWebElement allocationBtnOn;
    @GherkinId(findByObjectId = "allocation_main_toggle_btn")
    private BaseWebElement allocationBtnOn;

    @GherkinId(findByObjectId = "account_main_portfolio_label")
    private BaseWebElement mainPortfolioOrAllocationTxt;  // 点击按钮前为Portfolio，点击后为Allocation

    @GherkinId(name = "Portfolio lists",findByObjectId = "portfolio_main_portfolio_tableview")
    private BaseWebElement portfolioListView;

    //Portfolio List
    @GherkinId(findByObjectId = "There are no portfolios to display within this account.")
    private BaseWebElement noPortfolioMessage;

    @GherkinId(findByObjectId = "account_portfolio_list_footview")
    private BaseWebElement portfolioListFootView;

    @GherkinId(findByObjectId = "portfolio_main_portfolio_tableview_cell_0")
    private BaseWebElement portfolioList0;

    @GherkinId(name = "portfolioListID_0", findByObjectId = "portfolio_list_tablecell_code_label_0")
    private BaseWebElement portfolioListID0;

    @GherkinId(findByObjectId = "portfolio_list_tablecell_category_label_0")
    private BaseWebElement portfolioListCategory0;

    @GherkinId(name = "portfolioTitleTxt_0",findByObjectId = "portfolio_list_tablecell_title_label_0")
    private BaseWebElement portfolioTitleTxt0;

    @GherkinId(name = "portfolioTotalAssetsTxt_0",findByObjectId = "portfolio_list_tablecell_amount_label_0")
    private BaseWebElement portfolioTotalAssetsTxt0;


    @GherkinId(findByObjectId = "portfolio_list_tablecell_arrow_img_0")
    private BaseWebElement portfolioArrowImg0;

    @GherkinId(findByObjectId = "portfolio_list_tablecell_weight_label_0")
    private BaseWebElement portfolioListPercentage0;

    @GherkinId(findByObjectId = "portfolio_list_tablecell_portfolioID_label_0")
    private BaseWebElement portfolioPortfolioIdTxt0;

    @GherkinId(findByObjectId = "portfolio_list_tablecell_percentage_label_0")
    private BaseWebElement portfolioPercentageTxt0;

    @GherkinId(findByObjectId = "account_main_page_control_view")
    private BaseWebElement mainPips;

    @GherkinId(findByObjectId = "account_main_collection_view")
    private BaseWebElement mainTopView;


    /* ---  Account: Allocation  --- */

    @GherkinId(name = "Class tab",findByObjectId = "account_main_class_btn")
    private BaseWebElement mainClassBtn;

    @GherkinId(name = "Currency tab",findByObjectId = "allocation_tab_currency_btn")
    private BaseWebElement mainCurrencyBtn;

    @GherkinId(name = "Region tab",findByObjectId = "account_main_region_btn")
    private BaseWebElement mainRegionBtn;

    @GherkinId(findByObjectId = "account_main_class_tableview")
    private BaseWebElement mainClassListView;

    @GherkinId(findByObjectId = "account_allocation_class_sub_class_label")
    private BaseWebElement subClassTxt;

    @GherkinId(findByObjectId = "account_allocation_class_sub_class_off_btn")
    private BaseWebElement subClassOffBtn;

    @GherkinId(findByObjectId = "account_allocation_class_sub_class_on_btn")
    private BaseWebElement subClassOnBtn;

    @GherkinId(findByObjectId = "account_class_list_tableview_cell_1_0")
    private BaseWebElement classList0;


    @GherkinId(findByObjectId = "account_subclass_list_tablecell_head_title_1_0")
    private BaseWebElement subclassHeadTitleTxt0;

    @GherkinId(findByObjectId = "account_subclass_list_tablecell_head_currency_1_0")
    private BaseWebElement subclassCurrency0;


    @GherkinId(findByObjectId = "allocation_list_tablecell_name_label_0")
    private BaseWebElement classTitleTxt0;

//    @GherkinId(findByObjectId = "account_class_list_tablecell_title_label_2_0")
//    private BaseWebElement classTitleTxt1;
//
//    @GherkinId(findByObjectId = "account_class_list_tablecell_title_label_3_0")
//    private BaseWebElement classTitleTxt2;
//
//    @GherkinId(findByObjectId = "account_class_list_tablecell_title_label_4_0")
//    private BaseWebElement classTitleTxt3;
//
//    @GherkinId(findByObjectId = "account_class_list_tablecell_title_label_5_0")
//    private BaseWebElement classTitleTxt4;
//
//    @GherkinId(findByObjectId = "account_class_list_tablecell_title_label_6_0")
//    private BaseWebElement classTitleTxt5;

    @GherkinId(findByObjectId = "allocation_list_tablecell_weight_label_0")
    private BaseWebElement classPercentageTxt0;

    @GherkinId(name = "classTotalAssetTxt_0",findByObjectId = "allocation_list_tablecell_amount_label_0")
    private BaseWebElement classTotalAssetTxt0;

//    @GherkinId(name = "classTotalAssetTxt_1",findByObjectId = "account_class_list_tablecell_amount_label_2_0")
//    private BaseWebElement classTotalAssetTxt1;
//
//    @GherkinId(name = "classTotalAssetTxt_2",findByObjectId = "account_class_list_tablecell_amount_label_3_0")
//    private BaseWebElement classTotalAssetTxt2;
//
//    @GherkinId(name = "classTotalAssetTxt_3",findByObjectId = "account_class_list_tablecell_amount_label_4_0")
//    private BaseWebElement classTotalAssetTxt3;
//
//    @GherkinId(name = "classTotalAssetTxt_4",findByObjectId = "account_class_list_tablecell_amount_label_5_0")
//    private BaseWebElement classTotalAssetTxt4;
//
//    @GherkinId(name = "classTotalAssetTxt_5",findByObjectId = "account_class_list_tablecell_amount_label_6_0")
//    private BaseWebElement classTotalAssetTxt5;

    @GherkinId(findByObjectId = "account_class_list_tablecell_percentage_view_1_0")
    private BaseWebElement classPercentageView0;

    @GherkinId(findByObjectId = "account_subclass_list_tablecell_title_label_1_0")
    private BaseWebElement subClassTableCellTitle0;

    @GherkinId(findByObjectId = "account_subclass_list_tablecell_amount_label_1_0")
    private BaseWebElement subClassTableCellAmount0;

    @GherkinId(findByObjectId = "account_subclass_list_tablecell_title_label_1_0")
    private BaseWebElement subClassTitleTxt0;

    @GherkinId(findByObjectId = "account_subclass_list_tablecell_weight_label_1_0")
    private BaseWebElement subClassPercentageTxt0;

    @GherkinId(name = "subClassTotalAssetTxt1_0",findByObjectId = "account_subclass_list_tablecell_amount_label_1_0")
    private BaseWebElement subClassTotalAssetTxt0;

    @GherkinId(findByObjectId = "account_subclass_list_tablecell_title_label_1_1")
    private BaseWebElement subClassTitleTxt1;

    @GherkinId(findByObjectId = "account_subclass_list_tablecell_weight_label_1_1")
    private BaseWebElement subClassPercentageTxt1;

    @GherkinId(name = "subClassTotalAssetTxt1_1",findByObjectId = "account_subclass_list_tablecell_amount_label_1_1")
    private BaseWebElement subClassTotalAssetTxt1;

    @GherkinId(findByObjectId = "account_subclass_list_tablecell_title_label_2_0")
    private BaseWebElement subClassTableCellTitle1;

    @GherkinId(findByObjectId = "account_subclass_list_tablecell_amount_label_2_0")
    private BaseWebElement subClassTableCellAmount2;

    @GherkinId(findByObjectId = "account_subclass_list_tablecell_title_label_2_0")
    private BaseWebElement subClassTitleTxt2;

    @GherkinId(findByObjectId = "account_subclass_list_tablecell_weight_label_2_0")
    private BaseWebElement subClassPercentageTxt20;

    @GherkinId(name = "subClassTotalAssetTxt2_0",findByObjectId = "account_subclass_list_tablecell_amount_label_2_0")
    private BaseWebElement subClassTotalAssetTxt20;

    @GherkinId(findByObjectId = "account_subclass_list_tablecell_title_label_2_1")
    private BaseWebElement subClassTitleTxt21;

    @GherkinId(findByObjectId = "account_subclass_list_tablecell_weight_label_2_1")
    private BaseWebElement subClassPercentageTxt21;

    @GherkinId(name = "subClassTotalAssetTxt2_1",findByObjectId = "account_subclass_list_tablecell_amount_label_2_1")
    private BaseWebElement subClassTotalAssetTxt21;

    @GherkinId(findByObjectId = "account_main_currency_tableview")
    private BaseWebElement mainCurrencyListView;

    @GherkinId(findByObjectId = "account_currency_list_tablecell_title_label_0")
    private BaseWebElement currencyTitleTxt0;

    @GherkinId(findByObjectId = "allocation_list_tablecell_weight_label_0")
    private BaseWebElement currencyPercentageTxt0;

    @GherkinId(name = "currencyTotalAssetTxt_0",findByObjectId = "allocation_list_tablecell_amount_label_0")
    private BaseWebElement currencyTotalAssetTxt0;

    @GherkinId(findByObjectId = "account_currency_list_tablecell_title_label_1")
    private BaseWebElement currencyTitleTxt1;

    @GherkinId(findByObjectId = "account_currency_list_tablecell_weight_label_1")
    private BaseWebElement currencyPercentageTxt1;

    @GherkinId(name = "currencyTotalAssetTxt_1",findByObjectId = "account_currency_list_tablecell_amount_label_1")
    private BaseWebElement currencyTotalAssetTxt1;

    @GherkinId(findByObjectId = "account_currency_list_tablecell_title_label_2")
    private BaseWebElement currencyTitleTxt2;

    @GherkinId(findByObjectId = "account_currency_list_tablecell_weight_label_2")
    private BaseWebElement currencyPercentageTxt2;

    @GherkinId(name = "currencyTotalAssetTxt_2",findByObjectId = "account_currency_list_tablecell_amount_label_2")
    private BaseWebElement currencyTotalAssetTxt2;

    @GherkinId(findByObjectId = "account_currency_list_tablecell_title_label_3")
    private BaseWebElement currencyTitleTxt3;

    @GherkinId(findByObjectId = "account_currency_list_tablecell_weight_label_3")
    private BaseWebElement currencyPercentageTxt3;

    @GherkinId(name = "currencyTotalAssetTxt_3",findByObjectId = "account_currency_list_tablecell_amount_label_3")
    private BaseWebElement currencyTotalAssetTxt3;

    @GherkinId(findByObjectId = "account_currency_list_tablecell_title_label_6")
    private BaseWebElement currencyTitleTxt6;

    @GherkinId(findByObjectId = "account_currency_list_tablecell_weight_label_6")
    private BaseWebElement currencyPercentageTxt6;

    @GherkinId(name = "currencyTotalAssetTxt_6",findByObjectId = "account_currency_list_tablecell_amount_label_6")
    private BaseWebElement currencyTotalAssetTxt6;

    @GherkinId(findByObjectId = "account_currency_list_tablecell_title_label_7")
    private BaseWebElement currencyTitleTxt7;

    @GherkinId(findByObjectId = "account_currency_list_tablecell_weight_label_7")
    private BaseWebElement currencyPercentageTxt7;

    @GherkinId(name = "currencyTotalAssetTxt_7",findByObjectId = "account_currency_list_tablecell_amount_label_7")
    private BaseWebElement currencyTotalAssetTxt7;


    @GherkinId(findByObjectId = "account_currency_list_tablecell_percentage_view_0")
    private BaseWebElement currencyPercentageView0;

    @GherkinId(findByObjectId = "account_main_region_tableview")
    private BaseWebElement mainRegionListView;


    @GherkinId(name = "Region Title name zero",findByObjectId = "account_region_list_tablecell_title_label_0")
    private BaseWebElement regionTitleTxt0;

    @GherkinId(findByObjectId = "account_region_list_tablecell_weight_label_0")
    private BaseWebElement regionPercentageTxt0;

    @GherkinId(findByObjectId = "account_region_list_tablecell_amount_label_0")
    private BaseWebElement regionTotalAssetTxt0;

    @GherkinId(name = "Region Title name first",findByObjectId = "account_region_list_tablecell_title_label_1")
    private BaseWebElement regionTitleTxt1;

    @GherkinId(findByObjectId = "account_region_list_tablecell_weight_label_1")
    private BaseWebElement regionPercentageTxt1;

    @GherkinId(findByObjectId = "account_region_list_tablecell_amount_label_1")
    private BaseWebElement regionTotalAssetTxt1;

    @GherkinId(name = "Region Title name two",findByObjectId = "account_region_list_tablecell_title_label_2")
    private BaseWebElement regionTitleTxt2;

    @GherkinId(findByObjectId = "account_region_list_tablecell_weight_label_2")
    private BaseWebElement regionPercentageTxt2;

    @GherkinId(findByObjectId = "account_region_list_tablecell_amount_label_2")
    private BaseWebElement regionTotalAssetTxt2;

    @GherkinId(name = "Region Title name three",findByObjectId = "account_region_list_tablecell_title_label_3")
    private BaseWebElement regionTitleTxt3;

    @GherkinId(findByObjectId = "account_region_list_tablecell_weight_label_3")
    private BaseWebElement regionPercentageTxt3;

    @GherkinId(findByObjectId = "account_region_list_tablecell_amount_label_3")
    private BaseWebElement regionTotalAssetTxt3;

    @GherkinId(name = "Region Title name four",findByObjectId = "account_region_list_tablecell_title_label_4")
    private BaseWebElement regionTitleTxt4;

    @GherkinId(findByObjectId = "account_region_list_tablecell_weight_label_4")
    private BaseWebElement regionPercentageTxt4;

    @GherkinId(findByObjectId = "account_region_list_tablecell_amount_label_4")
    private BaseWebElement regionTotalAssetTxt4;

    @GherkinId(name = "Region Title name five",findByObjectId = "account_region_list_tablecell_title_label_5")
    private BaseWebElement regionTitleTxt5;

    @GherkinId(findByObjectId = "account_region_list_tablecell_weight_label_5")
    private BaseWebElement regionPercentageTxt5;

    @GherkinId(findByObjectId = "account_region_list_tablecell_amount_label_5")
    private BaseWebElement regionTotalAssetTxt5;





    /* ---  Account Allocation holding  --- */
    // 左上角Holdings标签
    @GherkinId(findByObjectId = "allocation_main_holding_holdings_label")
    private BaseWebElement holdingHoldingsTxt;

    @GherkinId(findByObjectId = "allocation_main_holding_back_btn")
    private BaseWebElement holdingBackBtn;

    @GherkinId(findByObjectId = "allocation_main_holding_menu_btn")
    private BaseWebElement holdingMenuBtn;

    @GherkinId(findByObjectId = "allocation_main_holding_classname_label")
    private BaseWebElement holdingClassnameTxt;

    @GherkinId(findByObjectId = "allocation_main_holding_gbp_label")
    private BaseWebElement holdingGbpTxt;

    @GherkinId(findByObjectId = "allocation_main_holding_total_assets_context_label")
    private BaseWebElement holdingTotalAssetsTxt;

    @GherkinId(findByObjectId = "allocation_main_holding_list_tablecell_title_label_0")
    private BaseWebElement holdingTitleTxt0;

    @GherkinId(findByObjectId = "allocation_main_holding_list_tablecell_total_assets_label_0")
    private BaseWebElement holdingTotalAssetTxt0;

    @GherkinId(findByObjectId = "allocation_main_holding_list_tablecell_assetsID_label_0")
    private BaseWebElement holdingAssetsIDTxt0;

    @GherkinId(findByObjectId = "allocation_main_holding_list_tablecell_percentage_img_0")
    private BaseWebElement holdingPercentageImg0;

    @GherkinId(findByObjectId = "allocation_main_holding_list_tablecell_percentage_label_0")
    private BaseWebElement holdingPercentageTxt0;


    /* Allocation Unavailable message */

    @GherkinId(findByObjectId = "There are no portfolios to display within this account.")
    private BaseWebElement classUnavailableTitleTxt;

    @GherkinId(findByObjectId = "account_allocation_class_list_unavailable_content")
    private BaseWebElement classUnavailableContentTxt;


    @GherkinId(findByXPath = "(//XCUIElementTypeStaticText[@name=\"allocation_hint_msg_label\"])[1]")
    private BaseWebElement currencyUnavailableTitleTxt;

    @GherkinId(findByObjectId = "account_allocation_currency_list_unavailable_content")
    private BaseWebElement currencyUnavailableContentTxt;


    @GherkinId(findByObjectId = "account_allocation_region_list_unavailable_title")
    private BaseWebElement regionUnavailableTitleTxt;

    @GherkinId(findByObjectId = "account_allocation_region_list_unavailable_content")
    private BaseWebElement regionUnavailableContentTxt;


    /** Account Liabilities,Net for asia */
    @GherkinId(name = "header \"Total liabilities\"",findByObjectId = "account_main_libilities_title_btn")
    private BaseWebElement mainLiabilitesTitleTxt;

    @GherkinId(name = "Total liabilities icon",findByObjectId = "account_main_libilities_chevron_btn")
    private BaseWebElement mainLiabilitesIconImg;

    @GherkinId(name = "Total liabilities value",findByObjectId = "account_main_libilities_amount_btn")
    private BaseWebElement mainLiabilitesAmountBtn;

    @GherkinId(findByObjectId = "account_main_libilities_currency_btn")
    private BaseWebElement mainLiabilitesCurrencyBtn;

    @GherkinId(findByObjectId = "account_main_net_title_label")
    private BaseWebElement mainNetTitleTxt;

    @GherkinId(findByObjectId = "account_main_net_amount_label")
    private BaseWebElement mainNetAmountTxt;

    @GherkinId(findByObjectId = "account_main_net_currency_label")
    private BaseWebElement mainNetCurrencyTxt;

}
