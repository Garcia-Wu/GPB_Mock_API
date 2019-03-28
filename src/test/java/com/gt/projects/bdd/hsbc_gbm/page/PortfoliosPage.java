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
public class PortfoliosPage extends BasePage {


    @GherkinId(name = "Asset Breakdown list of Class",findByObjectId = "portfolios_main_class_tableview")
    private BaseWebElement portfolioClassView;


    //Portfolio pips
    @GherkinId(findByObjectId = "portfolio_main_page_control_view")
    private BaseWebElement portfolioPips;

    /* ---  Account: Portfolios(点击其中一个portfolio)  --- */

    @GherkinId(findByObjectId = "portfolio_main_collection_view")
    private BaseWebElement mainTopView;

    /*-----------------Portfolio Wrapper--------------------*/
    // back to account page
    @GherkinId(name = "back button",findByObjectId = "portfolio_holdings_back_btn")
    private BaseWebElement mainBackBtn;

    //update time
    @GherkinId(findByObjectId = "portfolio_main_date_label")
    private BaseWebElement mainUpdateTimeBtn;

    // menu
    @GherkinId(name = "menu icon",findByObjectId = "overview_main_menu_btn")
    private BaseWebElement mainMenuBtn;
    // title
    @GherkinId(name = "Portfolio name",findByObjectId = "portfolio_holdings_title_label")
    private BaseWebElement mainTitleTxt;

    // Id
    @GherkinId(name = "Portfolio id",findByObjectId = "portfolio_holdings_portfolioId_label")
    private BaseWebElement mainPortfolioIdTxt;

    // Total assets
    @GherkinId(name = "Total Assets title",findByObjectId = "portfolio_holdings_total_assets_label")
    private BaseWebElement mainTotalAssetsTxt;

    // Portfolio assets
    @GherkinId(name = "Portfolio Assets title",findByObjectId = "portfolio_holdings_total_assets_content_btn")
    private BaseWebElement mainPortfolioAssetsTxt;

    // Total assets image
    @GherkinId(name = "info icon",findByObjectId = "portfolio_holdings_total_assets_img")
    private BaseWebElement mainTotalAssetsImg;

    // Total assets GBP
    @GherkinId(name = "Currency label",findByObjectId = "portfolio_holdings_gbp_btn")
    private BaseWebElement mainGbpBtn;
//    @GherkinId(findByObjectId = "portfolio_holdings_gbp_btn_1")
//    private BaseWebElement mainGbpBtn;
//    @GherkinId(findByObjectId = "portfolio_holdings_gbp_btn_2")
//    private BaseWebElement mainGbpBtn;
//    @GherkinId(name = "Currency label3",findByObjectId = "portfolio_holdings_gbp_btn_3")
//    private BaseWebElement mainGbpBtn3;
//    @GherkinId(name = "Currency label16",findByObjectId = "portfolio_holdings_gbp_btn_15")
//    private BaseWebElement mainGbpBtn;

    @GherkinId(findByObjectId = "cc_icon")
    private BaseWebElement iosMainGbpBtn;

    // Total Assets Content
    @GherkinId(name = "Total Assets value",findByObjectId = "portfolio_holdings_total_assets_content_btn")
    private BaseWebElement mainTotalAssetsContentTxt;
    @GherkinId(findByObjectId = "portfolio_holdings_total_assets_currency_btn")
    private BaseWebElement mainTotalAssetsCurrencyTxt;



    /*-------------portfolio 上半页------ TotalAssets-----*/

    //Total assets pop-up 点击total assets 出现的弹出框
//    @GherkinId(name = "overlay close button", findByObjectId = "overviewlayer_main_close_btn")
//    private BaseWebElement portfolioTotalAssetsClose;
//    @GherkinId(name = "overlay total assets", findByObjectId = "overviewlayer_main_title_label")
//    private BaseWebElement portfolioTotalAssetsTitle;
//    @GherkinId(name = "overlay Portfolio name", findByObjectId = "overviewlayer_main_name_label")
//    private BaseWebElement portfolioTotalAssetsName;
//    @GherkinId(name = "overlay total Assets", findByObjectId = "overviewlayer_main_total_assets_label")
//    private BaseWebElement portfolioTotalAssetsAmount;
//    @GherkinId(name = "overlay reporting Currency", findByObjectId = "overviewlayer_mian_gbp")
//    private BaseWebElement portfolioTotalAssetsGbp;
//    @GherkinId(name = "overlay question", findByObjectId = "overviewlayer_main_question")
//    private BaseWebElement portfolioTotalAssetsQuestion;
//    @GherkinId(name = "overlay answer", findByObjectId = "overviewlayer_mian_answer")
//    private BaseWebElement portfolioTotalAssetsAnswer;
//    @GherkinId(findByObjectId = "overviewlayer_main_gb_btn")
//    private BaseWebElement portfolioTotalBgView;
//  Total assets pop-up



    @GherkinId(name = "Allocation Toggle",findByObjectId = "allocation_main_toggle_btn")
    private BaseWebElement allocationBtnOff;

    @GherkinId(name = "Allocation button", findByObjectId = "allocation_main_toggle_btn")
    private BaseWebElement allocationBtnOn;

    @GherkinId(findByObjectId = "portfolio_holdings_holdings_btn")
    private BaseWebElement mainHoldingsBtn;

    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecell_title_label_0")
    private BaseWebElement mainHoldingTitleTxt0;

//    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecell_title_label_14")
//    private BaseWebElement mainHoldingTitleTxt14;
//
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecell_title_label_15")
//    private BaseWebElement mainHoldingTitleTxt15;
//
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecell_title_label_19")
//    private BaseWebElement mainHoldingTitleTxt19;
//
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecell_title_label_14")
//    private BaseWebElement mainHoldingTitleTxt29;

    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecell_arrow_img_0")
    private BaseWebElement mainHoldingArrowImg0;

    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecell_holdingID_label_0")
    private BaseWebElement mainHoldingIdTxt0;

    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecell_total_assets_label_0")
    private BaseWebElement mainHoldingTotalAssetsTxt0;

    @GherkinId(findByObjectId = "portfolio_holdings_list tablecell_percentage_label_0")
    private BaseWebElement mainHoldingPercentageTxt0;

    @GherkinId(findByObjectId = "portfolio_main_holdings_tableview")
    private BaseWebElement mainHoldingTableview;

    @GherkinId(findByObjectId = "portfolio_holdings_list_unavailable_title_label")
    private BaseWebElement noHoldingMessageTitle;

    @GherkinId(findByObjectId = "portfolio_holdings_list_unavailable_description_label")
    private BaseWebElement noHoldingMessageContent;


    @GherkinId(findByObjectId = "holding_detail_back")
    private BaseWebElement holdingDetailBackBtn;

    /* ---  Portfolio: Allocation  --- */

    @GherkinId(findByObjectId = "portfolio_allocation_class_alloction_Label")
    private BaseWebElement allocationTxt;

    @GherkinId(name = "Class tab",findByObjectId = "allocation_tab_asset_class_btn")
    private BaseWebElement allocationClassBtn;

    @GherkinId(name = "Currency tab",findByObjectId = "allocation_tab_currency_btn")
    private BaseWebElement allocationCurrencyBtn;

    @GherkinId(name = "Region tab",findByObjectId = "allocation_tab_region_btn")
    private BaseWebElement allocationRegionBtn;


    @GherkinId(name = "Sub-Asset Class toggle",findByObjectId = "portfolios_allocation_class_sub_class_label")
    private BaseWebElement subClassTxt;

    @GherkinId(findByObjectId = "portfolios_allocation_class_sub_class_off_btn")
    private BaseWebElement subClassOffBtn;
    @GherkinId(findByObjectId = "portfolios_allocation_class_sub_class_on_btn")
    private BaseWebElement subClassOnBtn;


    /*
    * Portfolio Allocation Class
    * */

    @GherkinId(findByObjectId = "portfolios_class_list_tableview_cell_1_0")
    private BaseWebElement classList0;

    //Asset Class name
    @GherkinId(name = "titleName_0",findByObjectId = "portfolio_holdings_list_tablecell_base_amount_label_0")
    private BaseWebElement classTitleTxt0;
    @GherkinId(name = "titleName_1",findByObjectId = "portfolios_class_list_tablecell_title_label_2_0")
    private BaseWebElement classTitleTxt1;
    @GherkinId(name = "titleName_2",findByObjectId = "portfolios_class_list_tablecell_title_label_3_0")
    private BaseWebElement classTitleTxt2;
    @GherkinId(name = "titleName_3",findByObjectId = "portfolios_class_list_tablecell_title_label_4_0")
    private BaseWebElement classTitleTxt3;
    @GherkinId(name = "titleName_4",findByObjectId = "portfolios_class_list_tablecell_title_label_5_0")
    private BaseWebElement classTitleTxt4;

    // Class   Percentage
    @GherkinId(name = "percentage_0", findByObjectId = "portfolios_class_list_tablecell_weight_label_1_0")
    private BaseWebElement classPercentageTxt0;
    @GherkinId(name = "percentage_1", findByObjectId = "portfolios_class_list_tablecell_weight_label_2_0")
    private BaseWebElement classPercentageTxt1;
    @GherkinId(name = "percentage_2", findByObjectId = "portfolios_class_list_tablecell_weight_label_3_0")
    private BaseWebElement classPercentageTxt2;
    @GherkinId(name = "percentage_3", findByObjectId = "portfolios_class_list_tablecell_weight_label_4_0")
    private BaseWebElement classPercentageTxt3;
    @GherkinId(name = "percentage_4", findByObjectId = "portfolios_class_list_tablecell_weight_label_5_0")
    private BaseWebElement classPercentageTxt4;

    //total amount
    @GherkinId(name = "totalAmount_0", findByObjectId = "portfolios_class_list_tablecell_amount_label_1_0")
    private BaseWebElement classTotalAmountTxt0;
    @GherkinId(name = "totalAmount_1", findByObjectId = "portfolios_class_list_tablecell_amount_label_2_0")
    private BaseWebElement classTotalAmountTxt1;
    @GherkinId(name = "totalAmount_2", findByObjectId = "portfolios_class_list_tablecell_amount_label_3_0")
    private BaseWebElement classTotalAmountTxt2;
    @GherkinId(name = "totalAmount_3", findByObjectId = "portfolios_class_list_tablecell_amount_label_4_0")
    private BaseWebElement classTotalAmountTxt3;
    @GherkinId(name = "totalAmount_4", findByObjectId = "portfolios_class_list_tablecell_amount_label_5_0")
    private BaseWebElement classTotalAmountTxt4;
    @GherkinId(name = "totalAmount_5", findByObjectId = "portfolios_class_list_tablecell_amount_label_6_0")
    private BaseWebElement classTotalAmountTxt5;
    @GherkinId(name = "totalAmount_6", findByObjectId = "portfolios_class_list_tablecell_amount_label_7_0")
    private BaseWebElement classTotalAmountTxt6;
    @GherkinId(name = "totalAmount_7", findByObjectId = "portfolios_class_list_tablecell_amount_label_8_0")
    private BaseWebElement classTotalAmountTxt7;
    @GherkinId(name = "totalAmount_8", findByObjectId = "portfolios_class_list_tablecell_amount_label_9_0")
    private BaseWebElement classTotalAmountTxt8;
    @GherkinId(name = "totalAmount_9", findByObjectId = "portfolios_class_list_tablecell_amount_label_10_0")
    private BaseWebElement classTotalAmountTxt9;


    //subclass on
    // Class name
    @GherkinId(name = "subClassHeadTitle_0", findByObjectId = "portfolios_subclass_list_tablecell_head_title_1_0")
    private BaseWebElement subClassHeadTitleTxt0;
    @GherkinId(name = "subClassHeadTitle_1", findByObjectId = "portfolios_subclass_list_tablecell_head_title_2_0")
    private BaseWebElement subClassHeadTitleTxt1;
    @GherkinId(name = "subClassHeadTitle_2", findByObjectId = "portfolios_subclass_list_tablecell_head_title_3_0")
    private BaseWebElement subClassHeadTitleTxt2;
    @GherkinId(name = "subClassHeadTitle_3", findByObjectId = "portfolios_subclass_list_tablecell_head_title_4_0")
    private BaseWebElement subClassHeadTitleTxt3;
    @GherkinId(name = "subClassHeadTitle_4", findByObjectId = "portfolios_subclass_list_tablecell_head_title_5_0")
    private BaseWebElement subClassHeadTitleTxt4;

    //subClass currency amount
    @GherkinId(name = "subClassHeadCurrency_0", findByObjectId = "portfolios_subclass_list_tablecell_head_currency_1_0")
    private BaseWebElement subClassHeadCurrencyTxt0;
    @GherkinId(name = "subClassHeadCurrency_1", findByObjectId = "portfolios_subclass_list_tablecell_head_currency_2_0")
    private BaseWebElement subClassHeadCurrencyTxt1;
    @GherkinId(name = "subClassHeadCurrency_2", findByObjectId = "portfolios_subclass_list_tablecell_head_currency_3_0")
    private BaseWebElement subClassHeadCurrencyTxt2;
    @GherkinId(name = "subClassHeadCurrency_3", findByObjectId = "portfolios_subclass_list_tablecell_head_currency_4_0")
    private BaseWebElement subClassHeadCurrencyTxt3;
    @GherkinId(name = "subClassHeadCurrency_4", findByObjectId = "portfolios_subclass_list_tablecell_head_currency_5_0")
    private BaseWebElement subClassHeadCurrencyTxt4;


    //subClass Total Asset name
    @GherkinId(name = "subClassTotalAsset_0", findByObjectId = "portfolios_subclass_list_tablecell_title_label_1_0")
    private BaseWebElement subClassTotalAssetTxt0;
    @GherkinId(name = "subClassTotalAsset_1", findByObjectId = "portfolios_subclass_list_tablecell_title_label_1_1")
    private BaseWebElement subClassTotalAssetTxt1;
    @GherkinId(name = "subClassTotalAsset_2", findByObjectId = "portfolios_subclass_list_tablecell_title_label_2_0")
    private BaseWebElement subClassTotalAssetTxt2;
    @GherkinId(name = "subClassTotalAsset_3", findByObjectId = "portfolios_subclass_list_tablecell_title_label_2_1")
    private BaseWebElement subClassTotalAssetTxt3;
    @GherkinId(name = "subClassTotalAsset_4", findByObjectId = "portfolios_subclass_list_tablecell_title_label_3_0")
    private BaseWebElement subClassTotalAssetTxt4;
    @GherkinId(name = "subClassTotalAsset_5", findByObjectId = "portfolios_subclass_list_tablecell_title_label_3_1")
    private BaseWebElement subClassTotalAssetTxt5;
    @GherkinId(name = "subClassTotalAsset_6", findByObjectId = "portfolios_subclass_list_tablecell_title_label_4_0")
    private BaseWebElement subClassTotalAssetTxt6;
    @GherkinId(name = "subClassTotalAsset_7", findByObjectId = "portfolios_subclass_list_tablecell_title_label_4_1")
    private BaseWebElement subClassTotalAssetTxt7;
    @GherkinId(name = "subClassTotalAsset_8", findByObjectId = "portfolios_subclass_list_tablecell_title_label_4_0")
    private BaseWebElement subClassTotalAssetTxt8;
    @GherkinId(name = "subClassTotalAsset_9", findByObjectId = "portfolios_subclass_list_tablecell_title_label_5_1")
    private BaseWebElement subClassTotalAssetTxt9;


    //subClass Percentage
    @GherkinId(name = "subClassPercentage_0", findByObjectId = "portfolios_subclass_list_tablecell_weight_label_1_0")
    private BaseWebElement subClassPercentageTxt0;
    @GherkinId(name = "subClassPercentage_1", findByObjectId = "portfolios_subclass_list_tablecell_weight_label_1_1")
    private BaseWebElement subClassPercentageTxt1;
    @GherkinId(name = "subClassPercentage_2", findByObjectId = "portfolios_subclass_list_tablecell_weight_label_2_0")
    private BaseWebElement subClassPercentageTxt2;
    @GherkinId(name = "subClassPercentage_3", findByObjectId = "portfolios_subclass_list_tablecell_weight_label_2_1")
    private BaseWebElement subClassPercentageTxt3;
    @GherkinId(name = "subClassPercentage_4", findByObjectId = "portfolios_subclass_list_tablecell_weight_label_3_0")
    private BaseWebElement subClassPercentageTxt4;
    @GherkinId(name = "subClassPercentage_5", findByObjectId = "portfolios_subclass_list_tablecell_weight_label_3_1")
    private BaseWebElement subClassPercentageTxt5;
    @GherkinId(name = "subClassPercentage_6", findByObjectId = "portfolios_subclass_list_tablecell_weight_label_4_0")
    private BaseWebElement subClassPercentageTxt6;
    @GherkinId(name = "subClassPercentage_7", findByObjectId = "portfolios_subclass_list_tablecell_weight_label_4_1")
    private BaseWebElement subClassPercentageTxt7;
    @GherkinId(name = "subClassPercentage_8", findByObjectId = "portfolios_subclass_list_tablecell_weight_label_5_0")
    private BaseWebElement subClassPercentageTxt8;
    @GherkinId(name = "subClassPercentage_9", findByObjectId = "portfolios_subclass_list_tablecell_weight_label_5_1")
    private BaseWebElement subClassPercentageTxt9;

    //subClass total amount
    @GherkinId(name = "subClassTotalAmount_0", findByObjectId = "portfolios_subclass_list_tablecell_amount_label_1_0")
    private BaseWebElement subClassTotalAmountTxt0;
    @GherkinId(name = "subClassTotalAmount_1", findByObjectId = "portfolios_subclass_list_tablecell_amount_label_1_1")
    private BaseWebElement subClassTotalAmountTxt1;
    @GherkinId(name = "subClassTotalAmount_2", findByObjectId = "portfolios_subclass_list_tablecell_amount_label_1_2")
    private BaseWebElement subClassTotalAmountTxt2;
    @GherkinId(name = "subClassTotalAmount_3", findByObjectId = "portfolios_subclass_list_tablecell_amount_label_2_0")
    private BaseWebElement subClassTotalAmountTxt3;
    @GherkinId(name = "subClassTotalAmount_4", findByObjectId = "portfolios_subclass_list_tablecell_amount_label_2_1")
    private BaseWebElement subClassTotalAmountTxt4;
    @GherkinId(name = "subClassTotalAmount_5", findByObjectId = "portfolios_subclass_list_tablecell_amount_label_3_0")
    private BaseWebElement subClassTotalAmountTxt5;
    @GherkinId(name = "subClassTotalAmount_6", findByObjectId = "portfolios_subclass_list_tablecell_amount_label_4_0")
    private BaseWebElement subClassTotalAmountTxt6;
    @GherkinId(name = "subClassTotalAmount_7", findByObjectId = "portfolios_subclass_list_tablecell_amount_label_4_1")
    private BaseWebElement subClassTotalAmountTxt7;
    @GherkinId(name = "subClassTotalAmount_8", findByObjectId = "portfolios_subclass_list_tablecell_amount_label_5_0")
    private BaseWebElement subClassTotalAmountTxt8;
    @GherkinId(name = "subClassTotalAmount_9", findByObjectId = "portfolios_subclass_list_tablecell_amount_label_5_1")
    private BaseWebElement subClassTotalAmountTxt9;
    @GherkinId(name = "subClassTotalAmount_10", findByObjectId = "portfolios_subclass_list_tablecell_amount_label_5_2")
    private BaseWebElement subClassTotalAmountTxt10;


    //Portfolio Page: return to Portfolio Level
    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBUKUAT:id/ivBack")
    private BaseWebElement backPortfolioLevel;


    @GherkinId(findByObjectId = "portfolio_allocation_subclass_list_tablecell_percentage_view_section_0")
    private BaseWebElement subClassPercentageView0;

    @GherkinId(name = "Asset Breakdown list of Currency",findByObjectId = "portfolios_main_currency_tableview")
    private BaseWebElement currencyPortfolioView;

    /*----Currency----*/
    //currencyList
    @GherkinId(name = "portfolioCurrencyList_0", findByObjectId = "portfolios_currency_tableview_cell_0_0")
    private BaseWebElement portfolioCurrencyList0;
//    @GherkinId(name = "portfolioCurrencyList_1", findByObjectId = "portfolios_currency_tableview_cell_0_1")
//    private BaseWebElement portfolioCurrencyList1;
//    @GherkinId(name = "portfolioCurrencyList_2", findByObjectId = "portfolios_currency_tableview_cell_0_2")
//    private BaseWebElement portfolioCurrencyList2;
//    @GherkinId(name = "portfolioCurrencyList_3", findByObjectId = "portfolios_currency_tableview_cell_0_3")
//    private BaseWebElement portfolioCurrencyList3;
//    @GherkinId(name = "portfolioCurrencyList_4", findByObjectId = "portfolios_currency_tableview_cell_0_4")
//    private BaseWebElement portfolioCurrencyList4;
//    @GherkinId(name = "portfolioCurrencyList_5", findByObjectId = "portfolios_currency_tableview_cell_0_5")
//    private BaseWebElement portfolioCurrencyList5;
//    @GherkinId(name = "portfolioCurrencyList_6", findByObjectId = "portfolios_currency_tableview_cell_0_6")
//    private BaseWebElement portfolioCurrencyList6;
//    @GherkinId(name = "portfolioCurrencyList_7", findByObjectId = "portfolios_currency_tableview_cell_0_7")
//    private BaseWebElement portfolioCurrencyList7;

    //currency title name
    @GherkinId(name = "currencyTitleTxt_0", findByObjectId = "portfolios_currency_list_tablecell_title_label_0")
    private BaseWebElement currencyTitleTxt0;
//    @GherkinId(name = "currencyTitleTxt_1", findByObjectId = "portfolios_currency_list_tablecell_title_label_1")
//    private BaseWebElement currencyTitleTxt1;
//    @GherkinId(name = "currencyTitleTxt_2", findByObjectId = "portfolios_currency_list_tablecell_title_label_2")
//    private BaseWebElement currencyTitleTxt2;
//    @GherkinId(name = "currencyTitleTxt_3", findByObjectId = "portfolios_currency_list_tablecell_title_label_3")
//    private BaseWebElement currencyTitleTxt3;
//    @GherkinId(name = "currencyTitleTxt_4", findByObjectId = "portfolios_currency_list_tablecell_title_label_4")
//    private BaseWebElement currencyTitleTxt4;
//    @GherkinId(name = "currencyTitleTxt_5", findByObjectId = "portfolios_currency_list_tablecell_title_label_5")
//    private BaseWebElement currencyTitleTxt5;
//    @GherkinId(name = "currencyTitleTxt_6", findByObjectId = "portfolios_currency_list_tablecell_title_label_6")
//    private BaseWebElement currencyTitleTxt6;
//    @GherkinId(name = "currencyTitleTxt_7", findByObjectId = "portfolios_currency_list_tablecell_title_label_7")
//    private BaseWebElement currencyTitleTxt7;

    //currency percentage
    @GherkinId(name = "currencyPercentageTxt_0", findByObjectId = "portfolios_currency_list_tablecell_weight_label_0")
    private BaseWebElement currencyPercentageTxt0;
//    @GherkinId(name = "currencyPercentageTxt_1", findByObjectId = "portfolios_currency_list_tablecell_weight_label_1")
//    private BaseWebElement currencyPercentageTxt1;
//    @GherkinId(name = "currencyPercentageTxt_2", findByObjectId = "portfolios_currency_list_tablecell_weight_label_2")
//    private BaseWebElement currencyPercentageTxt2;
//    @GherkinId(name = "currencyPercentageTxt_3", findByObjectId = "portfolios_currency_list_tablecell_weight_label_3")
//    private BaseWebElement currencyPercentageTxt3;
//    @GherkinId(name = "currencyPercentageTxt_4", findByObjectId = "portfolios_currency_list_tablecell_weight_label_4")
//    private BaseWebElement currencyPercentageTxt4;
//    @GherkinId(name = "currencyPercentageTxt_5", findByObjectId = "portfolios_currency_list_tablecell_weight_label_5")
//    private BaseWebElement currencyPercentageTxt5;
//    @GherkinId(name = "currencyPercentageTxt_6", findByObjectId = "portfolios_currency_list_tablecell_weight_label_6")
//    private BaseWebElement currencyPercentageTxt6;
//    @GherkinId(name = "currencyPercentageTxt_7", findByObjectId = "portfolios_currency_list_tablecell_weight_label_7")
//    private BaseWebElement currencyPercentageTxt7;

    //currency total amount
    @GherkinId(name="currencyTotalAmountTxt_0", findByObjectId = "allocation_list_tablecell_amount_label_0")
    private BaseWebElement currencyTotalAmountTxt0;
//    @GherkinId(name="currencyTotalAmountTxt_1", findByObjectId = "portfolios_currency_list_tablecell_amount_label_1")
//    private BaseWebElement currencyTotalAmountTxt1;
//    @GherkinId(name="currencyTotalAmountTxt_2", findByObjectId = "portfolios_currency_list_tablecell_amount_label_2")
//    private BaseWebElement currencyTotalAmountTxt2;
//    @GherkinId(name="currencyTotalAmountTxt_3", findByObjectId = "portfolios_currency_list_tablecell_amount_label_3")
//    private BaseWebElement currencyTotalAmountTxt3;
//    @GherkinId(name="currencyTotalAmountTxt_4", findByObjectId = "portfolios_currency_list_tablecell_amount_label_4")
//    private BaseWebElement currencyTotalAmountTxt4;
//    @GherkinId(name="currencyTotalAmountTxt_5", findByObjectId = "portfolios_currency_list_tablecell_amount_label_5")
//    private BaseWebElement currencyTotalAmountTxt5;
//    @GherkinId(name="currencyTotalAmountTxt_6", findByObjectId = "portfolios_currency_list_tablecell_amount_label_6")
//    private BaseWebElement currencyTotalAmountTxt6;
//    @GherkinId(name="currencyTotalAmountTxt_7", findByObjectId = "portfolios_currency_list_tablecell_amount_label_7")
//    private BaseWebElement currencyTotalAmountTxt7;
//    @GherkinId(name="currencyTotalAmountTxt_8", findByObjectId = "portfolios_currency_list_tablecell_amount_label_8")
//    private BaseWebElement currencyTotalAmountTxt8;


    /*----Region----*/
    @GherkinId(name = "Asset Breakdown list of Region",findByObjectId = "portfolios_main_region_tableview")
    private BaseWebElement portfolioRegionListView;

    //Title
    @GherkinId(name = "regionTitleTxt_0", findByObjectId = "allocation_list_tablecell_name_label_0")
    private BaseWebElement regionTitleTxt0;
//    @GherkinId(name = "regionTitleTxt_1", findByObjectId = "portfolios_region_list_tablecell_title_label_1")
//    private BaseWebElement regionTitleTxt1;
//    @GherkinId(name = "regionTitleTxt_2", findByObjectId = "portfolios_region_list_tablecell_title_label_2")
//    private BaseWebElement regionTitleTxt2;
//    @GherkinId(name = "regionTitleTxt_3", findByObjectId = "portfolios_region_list_tablecell_title_label_3")
//    private BaseWebElement regionTitleTxt3;
//    @GherkinId(name = "regionTitleTxt_4", findByObjectId = "portfolios_region_list_tablecell_title_label_4")
//    private BaseWebElement regionTitleTxt4;
//    @GherkinId(name = "regionTitleTxt_5", findByObjectId = "portfolios_region_list_tablecell_title_label_5")
//    private BaseWebElement regionTitleTxt5;

    //Percentage
    @GherkinId(name = "regionPercentageTxt_0", findByObjectId = "portfolios_region_list_tablecell_weight_label_0")
    private BaseWebElement regionPercentageTxt0;
//    @GherkinId(name = "regionPercentageTxt_1", findByObjectId = "portfolios_region_list_tablecell_weight_label_1")
//    private BaseWebElement regionPercentageTxt1;
//    @GherkinId(name = "regionPercentageTxt_2", findByObjectId = "portfolios_region_list_tablecell_weight_label_2")
//    private BaseWebElement regionPercentageTxt2;
//    @GherkinId(name = "regionPercentageTxt_3", findByObjectId = "portfolios_region_list_tablecell_weight_label_3")
//    private BaseWebElement regionPercentageTxt3;
//    @GherkinId(name = "regionPercentageTxt_4", findByObjectId = "portfolios_region_list_tablecell_weight_label_4")
//    private BaseWebElement regionPercentageTxt4;
//    @GherkinId(name = "regionPercentageTxt_5", findByObjectId = "portfolios_region_list_tablecell_weight_label_5")
//    private BaseWebElement regionPercentageTxt5;

    //Total Amount
    @GherkinId(name = "regionTotalAmountTxt_0", findByObjectId = "portfolios_region_list_tablecell_amount_label_0")
    private BaseWebElement regionTotalAmountTxt0;
//    @GherkinId(name = "regionTotalAmountTxt_1", findByObjectId = "portfolios_region_list_tablecell_amount_label_1")
//    private BaseWebElement regionTotalAmountTxt1;
//    @GherkinId(name = "regionTotalAmountTxt_2", findByObjectId = "portfolios_region_list_tablecell_amount_label_2")
//    private BaseWebElement regionTotalAmountTxt2;
//    @GherkinId(name = "regionTotalAmountTxt_3", findByObjectId = "portfolios_region_list_tablecell_amount_label_3")
//    private BaseWebElement regionTotalAmountTxt3;
//    @GherkinId(name = "regionTotalAmountTxt_4", findByObjectId = "portfolios_region_list_tablecell_amount_label_4")
//    private BaseWebElement regionTotalAmountTxt4;
//    @GherkinId(name = "regionTotalAmountTxt_5", findByObjectId = "portfolios_region_list_tablecell_amount_label_5")
//    private BaseWebElement regionTotalAmountTxt5;
//    @GherkinId(findByObjectId = "portfolio_allocation_region_list_tablecell_total_assets_label_0")
//    private BaseWebElement regionTotalAssetTxt0;

    @GherkinId(findByObjectId = "portfolios_region_list_tablecell_weight_view_0")
    private BaseWebElement regionPercentageView0;


    /* --- portfolio page:
     portfolio holding List --- */

    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecell_arrow_img_0")
    private BaseWebElement holdingsListArrowImg0;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecell_arrow_img_1")
//    private BaseWebElement holdingsListArrowImg1;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecell_arrow_img_2")
//    private BaseWebElement holdingsListArrowImg2;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecell_arrow_img_15")
//    private BaseWebElement holdingsListArrowImg15;

    @GherkinId(findByObjectId = "portfolio_holding_list_footview")
    private BaseWebElement portfolioHoldingsListFootView;

    //向上/下滑动
    @GherkinId(name = "Holding lists", findByObjectId = "portfolio_main_holdings_tableview")
    private BaseWebElement portfolioHoldingsListTableview;

    //portfolio holding List
    @GherkinId(findByObjectId = "portfolio_holdings_list_tableview_cell_0")
    private BaseWebElement portfolioHoldingsList0;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tableview_cell_1")
//    private BaseWebElement portfolioHoldingsList1;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tableview_cell_2")
//    private BaseWebElement portfolioHoldingsList2;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tableview_cell_3")
//    private BaseWebElement portfolioHoldingsList3;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tableview_cell_4")
//    private BaseWebElement portfolioHoldingsList4;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tableview_cell_5")
//    private BaseWebElement portfolioHoldingsList5;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tableview_cell_6")
//    private BaseWebElement portfolioHoldingsList6;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tableview_cell_7")
//    private BaseWebElement portfolioHoldingsList7;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tableview_cell_8")
//    private BaseWebElement portfolioHoldingsList8;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tableview_cell_9")
//    private BaseWebElement portfolioHoldingsList9;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tableview_cell_10")
//    private BaseWebElement portfolioHoldingsList10;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tableview_cell_11")
//    private BaseWebElement portfolioHoldingsList11;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tableview_cell_12")
//    private BaseWebElement portfolioHoldingsList12;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tableview_cell_13")
//    private BaseWebElement portfolioHoldingsList13;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tableview_cell_14")
//    private BaseWebElement portfolioHoldingsList14;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tableview_cell_15")
//    private BaseWebElement portfolioHoldingsList15;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tableview_cell_16")
//    private BaseWebElement portfolioHoldingsList16;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tableview_cell_17")
//    private BaseWebElement portfolioHoldingsList17;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tableview_cell_18")
//    private BaseWebElement portfolioHoldingsList18;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tableview_cell_19")
//    private BaseWebElement portfolioHoldingsList19;


    @GherkinId(name = "portfolioHoldingsPercentage_0",findByObjectId = "portfolio_holdings_list_tablecell_weight_label_0")
    private BaseWebElement portfolioHoldingsPercentage0;
//    @GherkinId(name = "portfolioHoldingsPercentage_1",findByObjectId = "portfolio_holdings_list_tablecell_weight_label_1")
//    private BaseWebElement portfolioHoldingsPercentage1;
//    @GherkinId(name = "portfolioHoldingsPercentage_2",findByObjectId = "portfolio_holdings_list_tablecell_weight_label_2")
//    private BaseWebElement portfolioHoldingsPercentage2;
//    @GherkinId(name = "portfolioHoldingsPercentage_3",findByObjectId = "portfolio_holdings_list_tablecell_weight_label_3")
//    private BaseWebElement portfolioHoldingsPercentage3;
//    @GherkinId(name = "portfolioHoldingsPercentage_4",findByObjectId = "portfolio_holdings_list_tablecell_weight_label_4")
//    private BaseWebElement portfolioHoldingsPercentage4;
//    @GherkinId(name = "portfolioHoldingsPercentage_5",findByObjectId = "portfolio_holdings_list_tablecell_weight_label_5")
//    private BaseWebElement portfolioHoldingsPercentage5;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecell_weight_label_6")
//    private BaseWebElement portfolioHoldingsPercentage6;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecell_weight_label_7")
//    private BaseWebElement portfolioHoldingsPercentage7;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecell_weight_label_8")
//    private BaseWebElement portfolioHoldingsPercentage8;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecell_weight_label_9")
//    private BaseWebElement portfolioHoldingsPercentage9;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecell_weight_label_10")
//    private BaseWebElement portfolioHoldingsPercentage10;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecell_weight_label_11")
//    private BaseWebElement portfolioHoldingsPercentage11;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecell_weight_label_12")
//    private BaseWebElement portfolioHoldingsPercentage12;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecell_weight_label_13")
//    private BaseWebElement portfolioHoldingsPercentage13;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecell_weight_label_14")
//    private BaseWebElement portfolioHoldingsPercentage14;
//    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecell_weight_label_15")
//    private BaseWebElement portfolioHoldingsPercentage15;


    //portfolio holding List Title name
    @GherkinId(name = "portfolioHoldingsTitleName_0",findByObjectId = "portfolio_holdings_list_tablecell_title_label_0")
    private BaseWebElement portfolioHoldingsTitleName0;
//    @GherkinId(name = "portfolioHoldingsTitleName_1",findByObjectId = "portfolio_holdings_list_tablecell_title_label_1")
//    private BaseWebElement portfolioHoldingsTitleName1;
//    @GherkinId(name = "portfolioHoldingsTitleName_2",findByObjectId = "portfolio_holdings_list_tablecell_title_label_2")
//    private BaseWebElement portfolioHoldingsTitleName2;
//    @GherkinId(name = "portfolioHoldingsTitleName_3",findByObjectId = "portfolio_holdings_list_tablecell_title_label_3")
//    private BaseWebElement portfolioHoldingsTitleName3;
//    @GherkinId(name = "portfolioHoldingsTitleName_4",findByObjectId = "portfolio_holdings_list_tablecell_title_label_4")
//    private BaseWebElement portfolioHoldingsTitleName4;
//    @GherkinId(name = "portfolioHoldingsTitleName_5",findByObjectId = "portfolio_holdings_list_tablecell_title_label_5")
//    private BaseWebElement portfolioHoldingsTitleName5;


    //portfolio holding List --- Market value of holding in holding currency
    @GherkinId(name = "portfolioHoldingsBaseAmount_0",findByObjectId = "portfolio_holdings_list_tablecell_base_amount_label_0")
    private BaseWebElement portfolioHoldingsBaseAmount0;
//    @GherkinId(name = "portfolioHoldingsBaseAmount_1",findByObjectId = "portfolio_holdings_list_tablecell_base_amount_label_1")
//    private BaseWebElement portfolioHoldingsBaseAmount1;
//    @GherkinId(name = "portfolioHoldingsBaseAmount_2",findByObjectId = "portfolio_holdings_list_tablecell_base_amount_label_2")
//    private BaseWebElement portfolioHoldingsBaseAmount2;
//    @GherkinId(name = "portfolioHoldingsBaseAmount_3",findByObjectId = "portfolio_holdings_list_tablecell_base_amount_label_3")
//    private BaseWebElement portfolioHoldingsBaseAmount3;
//    @GherkinId(name = "portfolioHoldingsBaseAmount_4",findByObjectId = "portfolio_holdings_list_tablecell_base_amount_label_4")
//    private BaseWebElement portfolioHoldingsBaseAmount4;
//    @GherkinId(name = "portfolioHoldingsBaseAmount_5",findByObjectId = "portfolio_holdings_list_tablecell_base_amount_label_5")
//    private BaseWebElement portfolioHoldingsBaseAmount5;
//    @GherkinId(name = "portfolioHoldingsBaseAmount_6",findByObjectId = "portfolio_holdings_list_tablecell_base_amount_label_6")
//    private BaseWebElement portfolioHoldingsBaseAmount6;
//    @GherkinId(name = "portfolioHoldingsBaseAmount_7",findByObjectId = "portfolio_holdings_list_tablecell_base_amount_label_7")
//    private BaseWebElement portfolioHoldingsBaseAmount7;
//    @GherkinId(name = "portfolioHoldingsBaseAmount_8",findByObjectId = "portfolio_holdings_list_tablecell_base_amount_label_8")
//    private BaseWebElement portfolioHoldingsBaseAmount8;
//    @GherkinId(name = "portfolioHoldingsBaseAmount_9",findByObjectId = "portfolio_holdings_list_tablecell_base_amount_label_9")
//    private BaseWebElement portfolioHoldingsBaseAmount9;
//    @GherkinId(name = "portfolioHoldingsBaseAmount_14",findByObjectId = "portfolio_holdings_list_tablecell_base_amount_label_14")
//    private BaseWebElement portfolioHoldingsBaseAmount14;

    //portfolio holding List -----Market value of holding in portfolio reference currency

//    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecell_report_amount_label_0")
//    private BaseWebElement portfolioHoldingsAosReportAmount0;

    @GherkinId(name = "portfolioHoldingsReportAmount_0",findByObjectId = "portfolio_holdings_list_tablecell_report_amount_label_0")
    private BaseWebElement portfolioHoldingsReportAmount0;
//    @GherkinId(name = "portfolioHoldingsReportAmount_1",findByObjectId = "portfolio_holdings_list_tablecell_report_amount_label_1")
//    private BaseWebElement portfolioHoldingsReportAmount1;
//    @GherkinId(name = "portfolioHoldingsReportAmount_2",findByObjectId = "portfolio_holdings_list_tablecell_report_amount_label_2")
//    private BaseWebElement portfolioHoldingsReportAmount2;
//    @GherkinId(name = "portfolioHoldingsReportAmount_3",findByObjectId = "portfolio_holdings_list_tablecell_report_amount_label_3")
//    private BaseWebElement portfolioHoldingsReportAmount3;
//    @GherkinId(name = "portfolioHoldingsReportAmount_4",findByObjectId = "portfolio_holdings_list_tablecell_report_amount_label_4")
//    private BaseWebElement portfolioHoldingsReportAmount4;
//    @GherkinId(name = "portfolioHoldingsReportAmount_5",findByObjectId = "portfolio_holdings_list_tablecell_report_amount_label_5")
//    private BaseWebElement portfolioHoldingsReportAmount5;
//    @GherkinId(name = "portfolioHoldingsReportAmount_6",findByObjectId = "portfolio_holdings_list_tablecell_report_amount_label_6")
//    private BaseWebElement portfolioHoldingsReportAmount6;
//    @GherkinId(name = "portfolioHoldingsReportAmount_7",findByObjectId = "portfolio_holdings_list_tablecell_report_amount_label_7")
//    private BaseWebElement portfolioHoldingsReportAmount7;
//    @GherkinId(name = "portfolioHoldingsReportAmount_8",findByObjectId = "portfolio_holdings_list_tablecell_report_amount_label_8")
//    private BaseWebElement portfolioHoldingsReportAmount8;
//    @GherkinId(name = "portfolioHoldingsReportAmount_9",findByObjectId = "portfolio_holdings_list_tablecell_report_amount_label_9")
//    private BaseWebElement portfolioHoldingsReportAmount9;

    /**
     * FOR ASIA
     */
    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecell_performance_amount_0")
    private BaseWebElement portfolioHoldingsPerformanceAmount0;

    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecell_performance_amount_1")
    private BaseWebElement portfolioHoldingsPerformanceAmount1;

    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecell_performance_currency_0")
    private BaseWebElement portfolioHoldingsPerformanceCurrency0;


    /* ---  portfolio holding  --- */
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



    /* ---  portfolio transaction  --- */

    @GherkinId(findByObjectId = "portfolio_transactions_list_tablecell_status_img_row")
    private  BaseWebElement transactionsStatusImg;

    @GherkinId(findByObjectId = "portfolio_transaction_list_footview")
    private  BaseWebElement transactionsFootView;

    @GherkinId(findByObjectId = "portfolio_main_transactions_btn")
    private  BaseWebElement mainTransactionsBtn;

    @GherkinId(findByObjectId = "portfolio_transactions_list_tableview")
    private  BaseWebElement mainTransactionsTableView;

    @GherkinId(findByObjectId = "portfolio_transactions_list_head_title_view")
    private  BaseWebElement transactionsHeadTitle;

    @GherkinId(findByObjectId = "portfolio_transactions_list_head_arrow_img")
    private  BaseWebElement transactionsHeadImg;


    @GherkinId(findByObjectId = "portfolio_transactions_list_tablecell_0")
    private  BaseWebElement transactionsTableList0;
//    @GherkinId(findByObjectId = "portfolio_transactions_list_tablecell_1")
//    private  BaseWebElement transactionsTableList1;
//    @GherkinId(findByObjectId = "portfolio_transactions_list_tablecell_3")
//    private  BaseWebElement transactionsTableList3;
//    @GherkinId(findByObjectId = "portfolio_transactions_list_tablecell_4")
//    private  BaseWebElement transactionsTableList4;
//    @GherkinId(findByObjectId = "portfolio_transactions_list_tablecell_5")
//    private  BaseWebElement transactionsTableList5;
//    @GherkinId(findByObjectId = "portfolio_transactions_list_tablecell_8")
//    private  BaseWebElement transactionsTableList8;
//    @GherkinId(findByObjectId = "portfolio_transactions_list_tablecell_9")
//    private  BaseWebElement transactionsTableList9;

//    @GherkinId(findByObjectId = "portfolio_transactions_list_tablecell_11")
//    private  BaseWebElement transactionsTableList11;
//
//    @GherkinId(findByObjectId = "portfolio_transactions_list_tablecell_14")
//    private  BaseWebElement transactionsTableList14;
//
//    @GherkinId(findByObjectId = "portfolio_transactions_list_tablecell_15")
//    private  BaseWebElement transactionsTableList15;
//
//    @GherkinId(findByObjectId = "portfolio_transactions_list_tablecell_21")
//    private  BaseWebElement transactionsTableList21;

    @GherkinId(name = "Transaction Type",findByObjectId = "portfolio_transactions_list_tablecell_transaction_type_0")
    private  BaseWebElement transactionsListType0;

    @GherkinId(name = "Trade date",findByObjectId = "portfolio_transactions_list_tablecell_trade_date_0")
    private  BaseWebElement transactionsListTradeDate0;

    @GherkinId(name = "Description value",findByObjectId = "portfolio_transactions_list_tablecell_description_0")
    private  BaseWebElement transactionsListDescription0;

    @GherkinId(name = "status",findByObjectId = "portfolio_transactions_list_tablecell_status_0")
    private  BaseWebElement transactionsListStatus0;

    @GherkinId(name = "Transaction value",findByObjectId = "portfolio_transactions_list_tablecell_amount_0")
    private  BaseWebElement transactionsListAmount0;

    @GherkinId(name = "base currency",findByObjectId = "portfolio_transactions_list_tablecell_currency_0")
    private  BaseWebElement transactionsListCurrency0;

    @GherkinId(name = "Transaction Type1",findByObjectId = "portfolio_transactions_list_tablecell_transaction_type_1")
    private  BaseWebElement transactionsListType1;

    @GherkinId(name = "Trade date1",findByObjectId = "portfolio_transactions_list_tablecell_trade_date_1")
    private  BaseWebElement transactionsListTradeDate1;

    @GherkinId(name = "Description value1",findByObjectId = "portfolio_transactions_list_tablecell_description_1")
    private  BaseWebElement transactionsListDescription1;

    @GherkinId(name = "status1",findByObjectId = "portfolio_transactions_list_tablecell_status_1")
    private  BaseWebElement transactionsListStatus1;

    @GherkinId(name = "Transaction value1",findByObjectId = "portfolio_transactions_list_tablecell_amount_1")
    private  BaseWebElement transactionsListAmount1;

    @GherkinId(name = "Transaction value4",findByObjectId = "portfolio_transactions_list_tablecell_amount_4")
    private  BaseWebElement transactionsListAmount4;

    @GherkinId(name = "Transaction value20",findByObjectId = "portfolio_transactions_list_tablecell_amount_20")
    private  BaseWebElement transactionsListAmount20;

    @GherkinId(name = "base currency1",findByObjectId = "portfolio_transactions_list_tablecell_currency_1")
    private  BaseWebElement transactionsListCurrency1;

    @GherkinId(name = "Transaction Type2",findByObjectId = "portfolio_transactions_list_tablecell_transaction_type_2")
    private  BaseWebElement transactionsListType2;

    @GherkinId(name = "Trade date2",findByObjectId = "portfolio_transactions_list_tablecell_trade_date_2")
    private  BaseWebElement transactionsListTradeDate2;

    @GherkinId(name = "Description value2",findByObjectId = "portfolio_transactions_list_tablecell_description_2")
    private  BaseWebElement transactionsListDescription2;

    @GherkinId(name = "status2",findByObjectId = "portfolio_transactions_list_tablecell_status_2")
    private  BaseWebElement transactionsListStatus2;

    @GherkinId(name = "Transaction value2",findByObjectId = "portfolio_transactions_list_tablecell_amount_2")
    private  BaseWebElement transactionsListAmount2;

    @GherkinId(name = "base currency2",findByObjectId = "portfolio_transactions_list_tablecell_currency_2")
    private  BaseWebElement transactionsListCurrency2;


    @GherkinId(name = "Transaction Type3",findByObjectId = "portfolio_transactions_list_tablecell_transaction_type_3")
    private  BaseWebElement transactionsListType3;

    @GherkinId(name = "Trade date3",findByObjectId = "portfolio_transactions_list_tablecell_trade_date_3")
    private  BaseWebElement transactionsListTradeDate3;

    @GherkinId(name = "Description value3",findByObjectId = "portfolio_transactions_list_tablecell_description_3")
    private  BaseWebElement transactionsListDescription3;

    @GherkinId(name = "status3",findByObjectId = "portfolio_transactions_list_tablecell_status_3")
    private  BaseWebElement transactionsListStatus3;

    @GherkinId(name = "Transaction value3",findByObjectId = "portfolio_transactions_list_tablecell_amount_3")
    private  BaseWebElement transactionsListAmount3;

    @GherkinId(name = "base currency3",findByObjectId = "portfolio_transactions_list_tablecell_currency_3")
    private  BaseWebElement transactionsListCurrency3;

    @GherkinId(name = "Transaction Type4",findByObjectId = "portfolio_transactions_list_tablecell_transaction_type_4")
    private  BaseWebElement transactionsListType4;

    @GherkinId(name = "Trade date4",findByObjectId = "portfolio_transactions_list_tablecell_trade_date_4")
    private  BaseWebElement transactionsListTradeDate4;

    @GherkinId(name = "Description value4",findByObjectId = "portfolio_transactions_list_tablecell_description_4")
    private  BaseWebElement transactionsListDescription4;

    @GherkinId(name = "status4",findByObjectId = "portfolio_transactions_list_tablecell_status_4")
    private  BaseWebElement transactionsListStatus4;

    @GherkinId(name = "base currency4",findByObjectId = "portfolio_transactions_list_tablecell_currency_4")
    private  BaseWebElement transactionsListCurrency4;

    @GherkinId(name = "Transaction Type5",findByObjectId = "portfolio_transactions_list_tablecell_transaction_type_5")
    private  BaseWebElement transactionsListType5;

    @GherkinId(name = "Trade date5",findByObjectId = "portfolio_transactions_list_tablecell_trade_date_5")
    private  BaseWebElement transactionsListTradeDate5;

    @GherkinId(name = "Description value5",findByObjectId = "portfolio_transactions_list_tablecell_description_5")
    private  BaseWebElement transactionsListDescription5;

    @GherkinId(name = "status5",findByObjectId = "portfolio_transactions_list_tablecell_status_5")
    private  BaseWebElement transactionsListStatus5;

    @GherkinId(name = "base currency5",findByObjectId = "portfolio_transactions_list_tablecell_currency_5")
    private  BaseWebElement transactionsListCurrency5;

    @GherkinId(name = "Transaction Type6",findByObjectId = "portfolio_transactions_list_tablecell_transaction_type_6")
    private  BaseWebElement transactionsListType6;

    @GherkinId(name = "Trade date6",findByObjectId = "portfolio_transactions_list_tablecell_trade_date_6")
    private  BaseWebElement transactionsListTradeDate6;

    @GherkinId(name = "Description value6",findByObjectId = "portfolio_transactions_list_tablecell_description_6")
    private  BaseWebElement transactionsListDescription6;

    @GherkinId(name = "status6",findByObjectId = "portfolio_transactions_list_tablecell_status_6")
    private  BaseWebElement transactionsListStatus6;

    @GherkinId(name = "base currency6",findByObjectId = "portfolio_transactions_list_tablecell_currency_6")
    private  BaseWebElement transactionsListCurrency6;

    @GherkinId(name = "Transaction Type14",findByObjectId = "portfolio_transactions_list_tablecell_transaction_type_14")
    private  BaseWebElement transactionsListType14;

    @GherkinId(name = "Trade date14",findByObjectId = "portfolio_transactions_list_tablecell_trade_date_14")
    private  BaseWebElement transactionsListTradeDate14;

    @GherkinId(name = "Description value14",findByObjectId = "portfolio_transactions_list_tablecell_description_14")
    private  BaseWebElement transactionsListDescription14;

    @GherkinId(name = "status14",findByObjectId = "portfolio_transactions_list_tablecell_status_14")
    private  BaseWebElement transactionsListStatus14;

    @GherkinId(name = "Transaction value14",findByObjectId = "portfolio_transactions_list_tablecell_amount_14")
    private  BaseWebElement transactionsListAmount14;

    @GherkinId(name = "base currency14",findByObjectId = "portfolio_transactions_list_tablecell_currency_14")
    private  BaseWebElement transactionsListCurrency14;

    @GherkinId(name = "Transaction value12",findByObjectId = "portfolio_transactions_list_tablecell_amount_12")
    private  BaseWebElement transactionsListAmount12;

    @GherkinId(name = "Transaction value13",findByObjectId = "portfolio_transactions_list_tablecell_amount_13")
    private  BaseWebElement transactionsListAmount13;

    @GherkinId(name = "OK button", findByObjectId = "portfolio_transactions_filter_ok_btn")
    private BaseWebElement transactionsFilterOkBtn;

    @GherkinId(findByXPath = "//XCUIElementTypePicker[@name=\"portfolio_transactions_picker_view\"]/XCUIElementTypePickerWheel")
    private BaseWebElement transactionsPickerView;

    @GherkinId(findByXPath = "//XCUIElementTypePicker[@name=\"portfolio_transactions_picker_view\"]/XCUIElementTypePickerWheel/XCUIElementTypeOther[1]")
    private BaseWebElement transactionsPickerItemAll;

    @GherkinId(findByXPath = "//XCUIElementTypePicker[@name=\"portfolio_transactions_picker_view\"]/XCUIElementTypePickerWheel/XCUIElementTypeOther[2]")
    private BaseWebElement transactionsPickerItemIncome;

    @GherkinId(findByXPath = "//XCUIElementTypePicker[@name=\"portfolio_transactions_picker_view\"]/XCUIElementTypePickerWheel/XCUIElementTypeOther[3]")
    private BaseWebElement transactionsPickerItemFees;

    @GherkinId(findByXPath = "//XCUIElementTypePicker[@name=\"portfolio_transactions_picker_view\"]/XCUIElementTypePickerWheel/XCUIElementTypeOther[4]")
    private BaseWebElement transactionsPickerItemSales;

    @GherkinId(findByXPath = "//XCUIElementTypePicker[@name=\"portfolio_transactions_picker_view\"]/XCUIElementTypePickerWheel/XCUIElementTypeOther[5]")
    private BaseWebElement transactionsPickerItemPurchases;

    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBUK.GTENT:id/tvAll")
    private BaseWebElement transactionsPickerItemAllAos;
    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBUK.GTENT:id/tvSales")
    private BaseWebElement transactionsPickerItemSalesAos;
    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBUK.GTENT:id/tvPurchases")
    private BaseWebElement transactionsPickerItemPurchasesAos;
    @GherkinId(findByAosDevelopId = "com.hsbc.personalbanking.MobileGPBUK.GTENT:id/tvCashMovements")
    private BaseWebElement transactionsPickerItemCashMovementsAos;

    @GherkinId(findByObjectId = "portfolio_transactions_list_unavailable_title_label")
    private BaseWebElement transactionsUnavailableTitle;

    @GherkinId(findByObjectId = "portfolio_transactions_list_unavailable_description_label")
    private BaseWebElement transactionsUnavailableContent;

    @GherkinId(findByObjectId = "portfolio_transactions_list_unavailable_title_label")
    private BaseWebElement noTransactionsTitle;

    @GherkinId(findByObjectId = "portfolio_transactions_list_unavailable_ description_label")
    private BaseWebElement noTransactionsDescription;


    /* Allocation Unavailable message */

    @GherkinId(findByXPath = "(//XCUIElementTypeStaticText[@name=\"allocation_hint_msg_label\"])[1]")
    private BaseWebElement classUnavailableTitleTxt;

    @GherkinId(findByObjectId = "portfolio_allocation_class_list_unavailable_content")
    private BaseWebElement classUnavailableContentTxt;


    @GherkinId(findByObjectId = "portfolio_allocation_currency_list_unavailable_title")
    private BaseWebElement currencyUnavailableTitleTxt;

    @GherkinId(findByObjectId = "allocation_hint_msg_label")
    private BaseWebElement currencyUnavailableContentTxt;


    @GherkinId(findByObjectId = "allocation_hint_msg_label")
    private BaseWebElement regionUnavailableTitleTxt;

    @GherkinId(findByObjectId = "portfolio_allocation_region_list_unavailable_content")
    private BaseWebElement regionUnavailableContentTxt;


    /* Portfolio Holding Contingent liabilities */

    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecellhead_title_label")
    private BaseWebElement listContingentLiabilitiesTitleTxt;


    @GherkinId(findByObjectId = "portfolio_holdings_list_tablecellhead_arrow_img")
    private BaseWebElement listContingentLiabilitiesArrowImg;


    /** Portfolio Liabilities,Net for asia */
    @GherkinId(findByObjectId = "portfolio_main_libilities_title_btn")
    private BaseWebElement mainLiabilitesTitleTxt;

    @GherkinId(findByObjectId = "portfolio_main_libilities_chevron_btn")
    private BaseWebElement mainLiabilitesIconImg;

    @GherkinId(findByObjectId = "portfolio_main_libilities_amount_btn")
    private BaseWebElement mainLiabilitesAmountBtn;

    @GherkinId(findByObjectId = "portfolio_main_libilities_currency_btn")
    private BaseWebElement mainLiabilitesCurrencyBtn;

    @GherkinId(findByObjectId = "portfolio_main_net_title_label")
    private BaseWebElement mainNetTitleTxt;

    @GherkinId(findByObjectId = "portfolio_main_net_amount_label")
    private BaseWebElement mainNetAmountTxt;

    @GherkinId(findByObjectId = "portfolio_main_net_currency_label")
    private BaseWebElement mainNetCurrencyTxt;


    /** portfolio liabilities list for asia */
    @GherkinId(findByObjectId = "portfolio_main_liabilities_btn")
    private BaseWebElement mainLiabilitiesBtn;

    @GherkinId(findByObjectId = "portfolio_liabilities_list_tableview")
    private BaseWebElement mainLiabilitiesTableView;

    @GherkinId(findByObjectId = "portfolio_liabilities_list_unavailable_text")
    private BaseWebElement mainLiabilitiesUnavailableTxt;

    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_1")
    private BaseWebElement liabilitiesList0;
//    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_2")
//    private BaseWebElement liabilitiesList1;
//    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_3")
//    private BaseWebElement liabilitiesList2;
//    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_4")
//    private BaseWebElement liabilitiesList3;

    @GherkinId(findByObjectId = "portfolio_liabilities_group_type_name_label")
    private BaseWebElement liabilitiesGroupByTypeTxt;

    @GherkinId(findByObjectId = "portfolio_liabilities_group_type_on_btn")
    private BaseWebElement liabilitiesGroupByTypeBtnOn;

    @GherkinId(findByObjectId = "portfolio_liabilities_group_type_off_btn")
    private BaseWebElement liabilitiesGroupByTypeBtnOff;

    //header
    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_header_liability_type_label_1")
    private BaseWebElement liabilitiesHeaderType0;
//    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_header_liability_type_label_2")
//    private BaseWebElement liabilitiesHeaderType1;


    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_header_amount_label_1")
    private BaseWebElement liabilitiesHeaderAmount0;
//    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_header_amount_label_2")
//    private BaseWebElement liabilitiesHeaderAmount1;

    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_header_currency_label_1")
    private BaseWebElement liabilitiesHeaderCurrency0;


    //sub-liabilities


    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_1_0")
    private BaseWebElement subLiabilitiesList0;
    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_2_0")
    private BaseWebElement subLiabilitiesList1;
    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_3_0")
    private BaseWebElement subLiabilitiesList2;
    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_4_0")
    private BaseWebElement subLiabilitiesList3;
    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_5_0")
    private BaseWebElement subLiabilitiesList4;

    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_desciption_label_1_0")
    private BaseWebElement subLiabilitiesDescriptionTxt0;
    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_desciption_label_1_1")
    private BaseWebElement subLiabilitiesDescriptionTxt1;
    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_desciption_label_2_0")
    private BaseWebElement subLiabilitiesDescriptionTxt2;
    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_desciption_label_2_1")
    private BaseWebElement subLiabilitiesDescriptionTxt3;
    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_desciption_label_2_2")
    private BaseWebElement subLiabilitiesDescriptionTxt4;
    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_desciption_label_2_3")
    private BaseWebElement subLiabilitiesDescriptionTxt5;


    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_type_label_1_0")
    private BaseWebElement subLiabilitiesTypeTxt0;
    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_type_label_1_1")
    private BaseWebElement subLiabilitiesTypeTxt1;


//    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_Ioan_amount_label_0_0")
//    private BaseWebElement subLiabilitiesLoanAmountTxt00;
//    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_Ioan_amount_label_0_1")
//    private BaseWebElement subLiabilitiesLoanAmountTxt01;
    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_Ioan_amount_label_1_0")
    private BaseWebElement subLiabilitiesLoanAmountTxt0;
    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_Ioan_amount_label_1_1")
    private BaseWebElement subLiabilitiesLoanAmountTxt1;
    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_Ioan_amount_label_2_0")
    private BaseWebElement subLiabilitiesLoanAmountTxt2;
    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_Ioan_amount_label_2_1")
    private BaseWebElement subLiabilitiesLoanAmountTxt3;
    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_Ioan_amount_label_2_2")
    private BaseWebElement subLiabilitiesLoanAmountTxt4;
    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_Ioan_amount_label_2_3")
    private BaseWebElement subLiabilitiesLoanAmountTxt5;

//    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_base_amount_label_0_0")
//    private BaseWebElement subLiabilitiesBaseAmountTxt00;
//    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_base_amount_label_0_1")
//    private BaseWebElement subLiabilitiesBaseAmountTxt01;
    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_base_amount_label_1_0")
    private BaseWebElement subLiabilitiesBaseAmountTxt0;
    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_base_amount_label_1_1")
    private BaseWebElement subLiabilitiesBaseAmountTxt1;
    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_base_amount_label_2_0")
    private BaseWebElement subLiabilitiesBaseAmountTxt2;
    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_base_amount_label_2_1")
    private BaseWebElement subLiabilitiesBaseAmountTxt3;
    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_base_amount_label_2_2")
    private BaseWebElement subLiabilitiesBaseAmountTxt4;
    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_base_amount_label_2_3")
    private BaseWebElement subLiabilitiesBaseAmountTxt5;

    //Description
    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_desciption_label_1")
    private BaseWebElement liabilitiesDescriptionTxt0;
//    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_desciption_label_2")
//    private BaseWebElement liabilitiesDescriptionTxt1;
//    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_desciption_label_3")
//    private BaseWebElement liabilitiesDescriptionTxt2;

    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_type_label_1")
    private BaseWebElement liabilitiesTypeTxt0;
//    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_type_label_2")
//    private BaseWebElement liabilitiesTypeTxt1;
//    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_type_label_3")
//    private BaseWebElement liabilitiesTypeTxt2;

    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_Ioan_amount_label_1")
    private BaseWebElement liabilitiesLoanAmountTxt0;
//    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_Ioan_amount_label_2")
//    private BaseWebElement liabilitiesLoanAmountTxt1;
//    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_Ioan_amount_label_3")
//    private BaseWebElement liabilitiesLoanAmountTxt2;
//    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_Ioan_amount_label_6")
//    private BaseWebElement liabilitiesLoanAmountTxt5;

    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_Ioan_currency_label_1")
    private BaseWebElement liabilitiesLoanCurrencyTxt0;
//    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_Ioan_currency_label_3")
//    private BaseWebElement liabilitiesLoanCurrencyTxt2;

    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_base_amount_label_1")
    private BaseWebElement liabilitiesBaseAmountTxt0;
//    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_base_amount_label_2")
//    private BaseWebElement liabilitiesBaseAmountTxt1;
//    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_base_amount_label_3")
//    private BaseWebElement liabilitiesBaseAmountTxt2;
//    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_base_amount_label_4")
//    private BaseWebElement liabilitiesBaseAmountTxt3;
//    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_base_amount_label_5")
//    private BaseWebElement liabilitiesBaseAmountTxt4;
//    @GherkinId(findByObjectId = "portfolio_liabilities_tableview_cell_liability_base_amount_label_6")
//    private BaseWebElement liabilitiesBaseAmountTxt5;

    @GherkinId(findByObjectId = "portfolio_liabilities_list_footview")
    private BaseWebElement liabilitiesListFootView;

    @GherkinId(findByAosDevelopId = "scroll")
    private BaseWebElement wrapperScrollTopView;


}
