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
public class OverviewPage extends BasePage {

    /* ---  Overview Main  --- */


    @GherkinId(name = "Greeting message", findByObjectId = "overview_main_username_label")
    private BaseWebElement usernameTxt;

    @GherkinId(name = "Country", findByObjectId = "overview_main_country_label")
    private BaseWebElement countryTxt;

    @GherkinId(findByObjectId = "overview_main_date_label")
    private BaseWebElement updateDateTxt;

    @GherkinId(name = "Total assets title", findByObjectId = "overview_main_total_assets_label")
    private BaseWebElement totalAssetsTxt;

    @GherkinId(name = "Total assets icon", findByObjectId = "overview_main_total_assets_img")
    private BaseWebElement totalAssetsImg;
//
    @GherkinId(findByObjectId = "overview_main_gbp_btn")
    private BaseWebElement gbpBtn;

    @GherkinId(findByObjectId = "cc_icon")
    private BaseWebElement iosGbpBtn;

    @GherkinId(name = "Total assets amount", findByObjectId = "overview_main_total_assets_content_btn")
    private BaseWebElement totalAssetsContentBtn;

    @GherkinId(findByObjectId = "overview_main_total_assets_currency_btn")
    private BaseWebElement totalAssetsCurrency;

    @GherkinId(name = "Allocation Toggle", findByObjectId = "overview_main_allocation_off_btn")
    private BaseWebElement allocationBtnOff;

    @GherkinId(findByObjectId = "allocation_main_toggle_btn")
    private BaseWebElement allocationBtnOn;

    @GherkinId(findByObjectId = "overview_main_account_label")
    private BaseWebElement accountTxt;

    @GherkinId(name = "Account list", findByObjectId = "overview_main_account_tableview")
    private BaseWebElement accountListView;
    @GherkinId(name = "Account header", findByObjectId = "overview_account_list_title_label")
    private BaseWebElement overviewAccountHeader;

    //Account List

    @GherkinId(findByObjectId = "There are no accounts to display.")
    private BaseWebElement noAccountMessage;

    @GherkinId(findByObjectId = "overview_account_list_footview")
    private BaseWebElement accountListFootView;

    @GherkinId(findByObjectId = "overview_main_account_tableview_cell_0")
    private BaseWebElement accountList0;
//    @GherkinId(findByObjectId = "overview_main_account_tableview_cell_1")
//    private BaseWebElement accountList1;
//    @GherkinId(findByObjectId = "overview_main_account_tableview_cell_2")
//    private BaseWebElement accountList2;
//    @GherkinId(findByObjectId = "overview_main_account_tableview_cell_3")
//    private BaseWebElement accountList3;
//    @GherkinId(findByObjectId = "overview_main_account_tableview_cell_4")
//    private BaseWebElement accountList4;
//    @GherkinId(findByObjectId = "overview_main_account_tableview_cell_5")
//    private BaseWebElement accountList5;
//    @GherkinId(findByObjectId = "overview_main_account_tableview_cell_6")
//    private BaseWebElement accountList6;
//    @GherkinId(findByObjectId = "overview_main_account_tableview_cell_7")
//    private BaseWebElement accountList7;
//    @GherkinId(findByObjectId = "overview_main_account_tableview_cell_8")
//    private BaseWebElement accountList8;
//    @GherkinId(findByObjectId = "overview_main_account_tableview_cell_9")
//    private BaseWebElement accountList9;
//    @GherkinId(findByObjectId = "overview_main_account_tableview_cell_10")
//    private BaseWebElement accountList10;
//    @GherkinId(findByObjectId = "overview_main_account_tableview_cell_11")
//    private BaseWebElement accountList11;
//    @GherkinId(findByObjectId = "overview_main_account_tableview_cell_12")
//    private BaseWebElement accountList12;
//    @GherkinId(findByObjectId = "overview_main_account_tableview_cell_13")
//    private BaseWebElement accountList13;
//    @GherkinId(findByObjectId = "overview_main_account_tableview_cell_14")
//    private BaseWebElement accountList14;
//    @GherkinId(findByObjectId = "overview_main_account_tableview_cell_15")
//    private BaseWebElement accountList15;
//    @GherkinId(findByObjectId = "overview_main_account_tableview_cell_16")
//    private BaseWebElement accountList16;

    //OverView  Class
    @GherkinId(findByObjectId = "overview_class_list_tableview_cell_1_0")
    private BaseWebElement overviewClassList0;
    @GherkinId(findByObjectId = "overview_class_list_tableview_cell_2_0")
    private BaseWebElement overviewClassList1;
    @GherkinId(findByObjectId = "overview_class_list_tableview_cell_3_0")
    private BaseWebElement overviewClassList2;
    @GherkinId(findByObjectId = "overview_class_list_tableview_cell_4_0")
    private BaseWebElement overviewClassList3;
    @GherkinId(findByObjectId = "overview_class_list_tableview_cell_5_0")
    private BaseWebElement overviewClassList4;
    @GherkinId(findByObjectId = "overview_class_list_tableview_cell_6_0")
    private BaseWebElement overviewClassList5;
    @GherkinId(findByObjectId = "overview_class_list_tableview_cell_7_0")
    private BaseWebElement overviewClassList6;
    @GherkinId(findByObjectId = "overview_class_list_tableview_cell_8_0")
    private BaseWebElement overviewClassList7;
    @GherkinId(findByObjectId = "overview_class_list_tableview_cell_9_0")
    private BaseWebElement overviewClassList8;
    @GherkinId(findByObjectId = "overview_class_list_tableview_cell_10_0")
    private BaseWebElement overviewClassList9;
    @GherkinId(findByObjectId = "overview_class_list_tableview_cell_11_0")
    private BaseWebElement overviewClassList10;
    @GherkinId(findByObjectId = "overview_class_list_tableview_cell_12_0")
    private BaseWebElement overviewClassList11;
    @GherkinId(findByObjectId = "overview_class_list_tableview_cell_13_0")
    private BaseWebElement overviewClassList12;
    @GherkinId(findByObjectId = "overview_class_list_tableview_cell_14_0")
    private BaseWebElement overviewClassList13;
    @GherkinId(findByObjectId = "overview_class_list_tableview_cell_15_0")
    private BaseWebElement overviewClassList14;
    @GherkinId(findByObjectId = "overview_class_list_tableview_cell_16_0")
    private BaseWebElement overviewClassList15;

//    //OverView Sub-Asset Class
//    private BaseWebElement overviewSubAssetClass0;

    //OverView Currency
    @GherkinId(findByObjectId = "overview_currency_tableview_cell_0_0")
    private BaseWebElement overviewCurrencyList0;
    @GherkinId(findByObjectId = "overview_currency_tableview_cell_0_1")
    private BaseWebElement overviewCurrencyList1;
    @GherkinId(findByObjectId = "overview_currency_tableview_cell_0_2")
    private BaseWebElement overviewCurrencyList2;
    @GherkinId(findByObjectId = "overview_currency_tableview_cell_0_3")
    private BaseWebElement overviewCurrencyList3;
    @GherkinId(findByObjectId = "overview_currency_tableview_cell_0_4")
    private BaseWebElement overviewCurrencyList4;
    @GherkinId(findByObjectId = "overview_currency_tableview_cell_0_5")
    private BaseWebElement overviewCurrencyList5;
    @GherkinId(findByObjectId = "overview_currency_tableview_cell_0_6")
    private BaseWebElement overviewCurrencyList6;
    @GherkinId(findByObjectId = "overview_currency_tableview_cell_0_7")
    private BaseWebElement overviewCurrencyList7;
    @GherkinId(findByObjectId = "overview_currency_tableview_cell_0_8")
    private BaseWebElement overviewCurrencyList8;
    @GherkinId(findByObjectId = "overview_currency_tableview_cell_0_9")
    private BaseWebElement overviewCurrencyList9;
    @GherkinId(findByObjectId = "overview_currency_tableview_cell_0_10")
    private BaseWebElement overviewCurrencyList10;
    @GherkinId(findByObjectId = "overview_currency_tableview_cell_0_11")
    private BaseWebElement overviewCurrencyList11;
    @GherkinId(findByObjectId = "overview_currency_tableview_cell_0_12")
    private BaseWebElement overviewCurrencyList12;
    @GherkinId(findByObjectId = "overview_currency_tableview_cell_0_13")
    private BaseWebElement overviewCurrencyList13;
    @GherkinId(findByObjectId = "overview_currency_tableview_cell_0_14")
    private BaseWebElement overviewCurrencyList14;
    @GherkinId(findByObjectId = "overview_currency_tableview_cell_0_15")
    private BaseWebElement overviewCurrencyList15;

    //OverView Region
    @GherkinId(findByObjectId = "overview_region_tableview_cell_0_0")
    private BaseWebElement overviewRegionList0;
    @GherkinId(findByObjectId = "overview_region_tableview_cell_0_1")
    private BaseWebElement overviewRegionList1;
    @GherkinId(findByObjectId = "overview_region_tableview_cell_0_2")
    private BaseWebElement overviewRegionList2;
    @GherkinId(findByObjectId = "overview_region_tableview_cell_0_3")
    private BaseWebElement overviewRegionList3;
    @GherkinId(findByObjectId = "overview_region_tableview_cell_0_4")
    private BaseWebElement overviewRegionList4;
    @GherkinId(findByObjectId = "overview_region_tableview_cell_0_5")
    private BaseWebElement overviewRegionList5;
    @GherkinId(findByObjectId = "overview_region_tableview_cell_0_6")
    private BaseWebElement overviewRegionList6;
    @GherkinId(findByObjectId = "overview_region_tableview_cell_0_7")
    private BaseWebElement overviewRegionList7;
    @GherkinId(findByObjectId = "overview_region_tableview_cell_0_8")
    private BaseWebElement overviewRegionList8;
    @GherkinId(findByObjectId = "overview_region_tableview_cell_0_9")
    private BaseWebElement overviewRegionList9;
    @GherkinId(findByObjectId = "overview_region_tableview_cell_0_10")
    private BaseWebElement overviewRegionList10;
    @GherkinId(findByObjectId = "overview_region_tableview_cell_0_11")
    private BaseWebElement overviewRegionList11;
    @GherkinId(findByObjectId = "overview_region_tableview_cell_0_12")
    private BaseWebElement overviewRegionList12;
    @GherkinId(findByObjectId = "overview_region_tableview_cell_0_13")
    private BaseWebElement overviewRegionList13;
    @GherkinId(findByObjectId = "overview_region_tableview_cell_0_14")
    private BaseWebElement overviewRegionList14;
    @GherkinId(findByObjectId = "overview_region_tableview_cell_0_15")
    private BaseWebElement overviewRegionList15;

    @GherkinId(name = "Account name",findByObjectId = "overview_account_list_tablecell_username_label_0")
    private BaseWebElement accountListUserNameTxt0;

//    @GherkinId(findByObjectId = "overview_account_list_tablecell_username_label_1")
//    private BaseWebElement accountListUserNameTxt1;

    @GherkinId(findByObjectId = "overview_account_list_tablecell_arrow_Img_0")
    private BaseWebElement accountListArrowImg0;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_arrow_Img_1")
//    private BaseWebElement accountListArrowImg1;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_arrow_Img_2")
//    private BaseWebElement accountListArrowImg2;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_arrow_Img_3")
//    private BaseWebElement accountListArrowImg3;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_arrow_Img_4")
//    private BaseWebElement accountListArrowImg4;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_arrow_Img_5")
//    private BaseWebElement accountListArrowImg5;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_arrow_Img_6")
//    private BaseWebElement accountListArrowImg6;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_arrow_Img_7")
//    private BaseWebElement accountListArrowImg7;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_arrow_Img_8")
//    private BaseWebElement accountListArrowImg8;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_arrow_Img_9")
//    private BaseWebElement accountListArrowImg9;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_arrow_Img_10")
//    private BaseWebElement accountListArrowImg10;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_arrow_Img_11")
//    private BaseWebElement accountListArrowImg11;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_arrow_Img_12")
//    private BaseWebElement accountListArrowImg12;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_arrow_Img_13")
//    private BaseWebElement accountListArrowImg13;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_arrow_Img_14")
//    private BaseWebElement accountListArrowImg14;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_arrow_Img_15")
//    private BaseWebElement accountListArrowImg15;

    @GherkinId(name = "Account Id",findByObjectId = "overview_account_list_tablecell_code_label_0")
    private BaseWebElement accountListAccountIdTxt0;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_code_label_16")
//    private BaseWebElement accountListAccountIdTxt16;
//
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_code_label_1")
//    private BaseWebElement accountListAccountIdTxt1;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_code_label_2")
//    private BaseWebElement accountListAccountIdTxt2;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_code_label_3")
//    private BaseWebElement accountListAccountIdTxt3;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_code_label_4")
//    private BaseWebElement accountListAccountIdTxt4;

    @GherkinId(name = "accountListTotalAssetsTxt_0",findByObjectId = "overview_account_list_tablecell_amount_label_0")
    private BaseWebElement accountListTotalAssetsTxt0;
    @GherkinId(name = "accountListTotalAssetsTxt_1",findByObjectId = "overview_account_list_tablecell_amount_label_1")
    private BaseWebElement accountListTotalAssetsTxt1;
    @GherkinId(name = "accountListTotalAssetsTxt_2",findByObjectId = "overview_account_list_tablecell_amount_label_2")
    private BaseWebElement accountListTotalAssetsTxt2;
    @GherkinId(name = "accountListTotalAssetsTxt_3",findByObjectId = "overview_account_list_tablecell_amount_label_3")
    private BaseWebElement accountListTotalAssetsTxt3;

    @GherkinId(findByObjectId = "overview_account_list_tablecell_weight_label_0")
    private BaseWebElement accountListPercentageTxt0;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_weight_label_1")
//    private BaseWebElement accountListPercentageTxt1;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_weight_label_2")
//    private BaseWebElement accountListPercentageTxt2;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_weight_label_3")
//    private BaseWebElement accountListPercentageTxt3;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_weight_label_4")
//    private BaseWebElement accountListPercentageTxt4;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_weight_label_5")
//    private BaseWebElement accountListPercentageTxt5;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_weight_label_6")
//    private BaseWebElement accountListPercentageTxt6;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_weight_label_7")
//    private BaseWebElement accountListPercentageTxt7;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_weight_label_8")
//    private BaseWebElement accountListPercentageTxt8;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_weight_label_9")
//    private BaseWebElement accountListPercentageTxt9;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_weight_label_10")
//    private BaseWebElement accountListPercentageTxt10;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_weight_label_11")
//    private BaseWebElement accountListPercentageTxt11;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_weight_label_12")
//    private BaseWebElement accountListPercentageTxt12;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_weight_label_13")
//    private BaseWebElement accountListPercentageTxt13;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_weight_label_14")
//    private BaseWebElement accountListPercentageTxt14;
//    @GherkinId(findByObjectId = "overview_account_list_tablecell_weight_label_15")
//    private BaseWebElement accountListPercentageTxt15;

    @GherkinId(name = "Menu icon", findByObjectId = "overview_main_menu_btn")
    private BaseWebElement menuBtn;


    /* ---  Overview Total assets pop-up  --- */

//    @GherkinId(name = "Total Assets header",findByObjectId = "overviewlayer_main_title_label")
//    private BaseWebElement popTitleTxt;
//
//    @GherkinId(name = "Total assets value",findByObjectId = "overviewlayer_main_total_assets_label")
//    private BaseWebElement popTotalAssetsTxt;
//
//    @GherkinId(name = "close button",findByObjectId = "overviewlayer_main_close_btn")
//    private BaseWebElement popCloseBtn;
//
//    @GherkinId(findByObjectId = "overviewlayer_main_gb_btn")  // 弹出框外面部分，点击可关闭弹出框
//    private BaseWebElement popGbBtn;
//
//    @GherkinId(name = "How is this calculated header",findByObjectId = "overviewlayer_main_question")
//    private BaseWebElement popQuestionTxt;
//
//    @GherkinId(name = "Copy indicating how this figure has been calculated",findByObjectId = "overviewlayer_mian_answer")
//    private BaseWebElement popAnswerTxt;
//
//    @GherkinId(findByObjectId = "overviewlayer_mian_gbp")  // 数字的单位（GBP）
//    private BaseWebElement popGbpTxt;
//
//    @GherkinId(name = "Overview header",findByObjectId = "overviewlayer_main_name_label")
//    private BaseWebElement popHeaderTxt;


    /* ---  Overview Allocation  --- */

    @GherkinId(name="Allocation button active",findByObjectId = "overview_main_allocation_on_btn")
    private BaseWebElement allocationActive;
    @GherkinId(name="Allocation button default", findByObjectId = "overview_main_allocation_off_btn")
    private BaseWebElement allocationDefault;

    @GherkinId(name = "Class Tab",findByObjectId = "allocation_tab_asset_class_btn")
    private BaseWebElement mainClassBtn;

    @GherkinId(name="Currency Tab",findByObjectId = "allocation_tab_currency_btn")
    private BaseWebElement mainCurrencyBtn;

    @GherkinId(name="Region Tab",findByObjectId = "allocation_tab_region_btn")
    private BaseWebElement mainRegionBtn;


    @GherkinId(findByObjectId = "overview_allocation_class_sub_class_label")
    private BaseWebElement subClassTxt;

    @GherkinId(name = "Show Sub-Asset Class toggle on",findByObjectId = "overview_allocation_class_sub_class_on_btn")
    private BaseWebElement subClassBtnOn;

    @GherkinId(name = "Show Sub-Asset Class toggle off",findByObjectId = "overview_allocation_class_sub_class_off_btn")
    private BaseWebElement subClassBtnOff;

    @GherkinId(findByObjectId = "overview_main_class_tableview")
    private BaseWebElement classListView;

    @GherkinId(name = "aosTitleName_0",findByObjectId = "overview_subclass_list_tablecell_head_title_1_0")
    private BaseWebElement aosClassTitleTxt0;

    @GherkinId(name = "aosTitleName_1",findByObjectId = "overview_subclass_list_tablecell_head_title_2_0")
    private BaseWebElement aosClassTitleTxt1;


    @GherkinId(name = "titleName_0",findByObjectId = "overview_class_list_tablecell_title_label_1_0")
    private BaseWebElement classTitleTxt0;
    @GherkinId(name = "titleName_1",findByObjectId = "overview_class_list_tablecell_title_label_2_0")
    private BaseWebElement classTitleTxt1;
    @GherkinId(name = "titleName_2",findByObjectId = "overview_class_list_tablecell_title_label_3_0")
    private BaseWebElement classTitleTxt2;
    @GherkinId(name = "titleName_3",findByObjectId = "overview_class_list_tablecell_title_label_4_0")
    private BaseWebElement classTitleTxt4;
    @GherkinId(name = "titleName_4",findByObjectId = "overview_class_list_tablecell_title_label_5_0")
    private BaseWebElement classTitleTxt5;

    @GherkinId(name = "percentage_0",findByObjectId = "overview_class_list_tablecell_weight_label_1_0")
    private BaseWebElement classPercentageTxt0;
    @GherkinId(name = "percentage_1",findByObjectId = "overview_class_list_tablecell_weight_label_2_0")
    private BaseWebElement classPercentageTxt1;
    @GherkinId(name = "percentage_2",findByObjectId = "overview_class_list_tablecell_weight_label_3_0")
    private BaseWebElement classPercentageTxt2;
    @GherkinId(name = "percentage_3",findByObjectId = "overview_class_list_tablecell_weight_label_4_0")
    private BaseWebElement classPercentageTxt3;
    @GherkinId(name = "percentage_4",findByObjectId = "overview_class_list_tablecell_weight_label_5_0")
    private BaseWebElement classPercentageTxt4;


    @GherkinId(name = "classAmount_0", findByObjectId = "overview_class_list_tablecell_amount_label_1_0")
    private BaseWebElement classTotalAssetTxt0;
    @GherkinId(name = "classAmount_0", findByObjectId = "overview_class_list_tablecell_amount_label_2_0")
    private BaseWebElement classTotalAssetTxt1;
    @GherkinId(name = "classAmount_0", findByObjectId = "overview_class_list_tablecell_amount_label_3_0")
    private BaseWebElement classTotalAssetTxt2;
    @GherkinId(name = "classAmount_0", findByObjectId = "overview_class_list_tablecell_amount_label_4_0")
    private BaseWebElement classTotalAssetTxt3;
    @GherkinId(name = "classAmount_0", findByObjectId = "overview_class_list_tablecell_amount_label_5_0")
    private BaseWebElement classTotalAssetTxt4;

    @GherkinId(findByObjectId = "overview_class_list_tablecell_percentage_view_1_0")
    private BaseWebElement classPercentageView0;

    @GherkinId(findByObjectId = "overview_subclass_list_tablecell_title_label_1_0")
    private BaseWebElement subClassTitleTxt0;

    @GherkinId(findByObjectId = "overview_subclass_list_tablecell_weight_label_1_0")
    private BaseWebElement subClassPercentageTxt0;

    @GherkinId(name = "subClassAmount_0", findByObjectId = "overview_subclass_list_tablecell_amount_label_1_0")
    private BaseWebElement subClassTotalAssetTxt0;

    @GherkinId(name = "subClassAmount_1", findByObjectId = "overview_subclass_list_tablecell_amount_label_1_1")
    private BaseWebElement subClassTotalAssetTxt1;

    @GherkinId(findByObjectId = "overview_subclass_list_tablecell_amount_label_2_0")
    private BaseWebElement subClassTotalAssetTxt2;

    @GherkinId(findByObjectId = "overview_subclass_list_tablecell_amount_label_2_1")
    private BaseWebElement subClassTotalAssetTxt3;

    @GherkinId(findByObjectId = "overview_subclass_list_tablecell_amount_label_3_0")
    private BaseWebElement subClassTotalAssetTxt4;

    @GherkinId(findByObjectId = "overview_subclass_list_tablecell_amount_label_3_1")
    private BaseWebElement subClassTotalAssetTxt5;

    @GherkinId(findByObjectId = "overview_subclass_list_tablecell_amount_label_4_0")
    private BaseWebElement subClassTotalAssetTxt6;

    @GherkinId(findByObjectId = "overview_subclass_list_tablecell_amount_label_4_1")
    private BaseWebElement subClassTotalAssetTxt7;

    @GherkinId(findByObjectId = "overview_subclass_list_tablecell_amount_label_5_0")
    private BaseWebElement subClassTotalAssetTxt8;

    @GherkinId(findByObjectId = "overview_subclass_list_tablecell_amount_label_5_1")
    private BaseWebElement subClassTotalAssetTxt9;

    @GherkinId(findByObjectId = "overview_subclass_list_tablecell_percentage_view_1_0")
    private BaseWebElement subClassPercentageView0;


    @GherkinId(findByObjectId = "overview_main_currency_tableview")
    private BaseWebElement currencyListView;

    @GherkinId(findByObjectId = "overview_currency_list_tablecell_title_label_0")
    private BaseWebElement currencyTitleTxt0;

    @GherkinId(findByObjectId = "overview_currency_list_tablecell_title_label_7")
    private BaseWebElement currencyTitleTxt7;

    @GherkinId(findByObjectId = "overview_currency_list_tablecell_weight_label_0")
    private BaseWebElement currencyPercentageTxt0;

    @GherkinId(name = "",findByObjectId = "overview_currency_list_tablecell_weight_label_7")
    private BaseWebElement currencyPercentageTxt7;

    @GherkinId(name = "currencyAmount_0", findByObjectId = "overview_currency_list_tablecell_amount_label_0")
    private BaseWebElement currencyTotalAssetTxt0;

    @GherkinId(findByObjectId = "overview_currency_list_tablecell_percentage_view_0")
    private BaseWebElement currencyPercentageView0;

    @GherkinId(name = "currencyAmount_1", findByObjectId = "overview_currency_list_tablecell_amount_label_1")
    private BaseWebElement currencyTotalAssetTxt1;

    @GherkinId(name = "currencyAmount_2", findByObjectId = "overview_currency_list_tablecell_amount_label_2")
    private BaseWebElement currencyTotalAssetTxt2;

    @GherkinId(name = "currencyAmount_3", findByObjectId = "overview_currency_list_tablecell_amount_label_3")
    private BaseWebElement currencyTotalAssetTxt3;

    @GherkinId(name = "currencyAmount_4", findByObjectId = "overview_currency_list_tablecell_amount_label_4")
    private BaseWebElement currencyTotalAssetTxt4;

    @GherkinId(name = "currencyAmount_5", findByObjectId = "overview_currency_list_tablecell_amount_label_5")
    private BaseWebElement currencyTotalAssetTxt5;

    @GherkinId(name = "currencyAmount_6", findByObjectId = "overview_currency_list_tablecell_amount_label_6")
    private BaseWebElement currencyTotalAssetTxt6;

    @GherkinId(name = "currencyAmount_7", findByObjectId = "overview_currency_list_tablecell_amount_label_7")
    private BaseWebElement currencyTotalAssetTxt7;


    @GherkinId(findByObjectId = "overview_main_region_tableview")
    private BaseWebElement regionListView;

    @GherkinId(name = "regionTitleTxt_0",findByObjectId = "overview_region_list_tablecell_title_label_0")
    private BaseWebElement regionTitleTxt0;
    @GherkinId(name = "regionTitleTxt_1",findByObjectId = "overview_region_list_tablecell_title_label_1")
    private BaseWebElement regionTitleTxt1;
    @GherkinId(name = "regionTitleTxt_2",findByObjectId = "overview_region_list_tablecell_title_label_2")
    private BaseWebElement regionTitleTxt2;
    @GherkinId(name = "regionTitleTxt_3",findByObjectId = "overview_region_list_tablecell_title_label_3")
    private BaseWebElement regionTitleTxt3;
    @GherkinId(name = "regionTitleTxt_4",findByObjectId = "overview_region_list_tablecell_title_label_4")
    private BaseWebElement regionTitleTxt4;

    @GherkinId(name = "regionPercentageTxt_0",findByObjectId = "overview_region_list_tablecell_weight_label_0")
    private BaseWebElement regionPercentageTxt0;
    @GherkinId(name = "regionPercentageTxt_1",findByObjectId = "overview_region_list_tablecell_weight_label_1")
    private BaseWebElement regionPercentageTxt1;
    @GherkinId(name = "regionPercentageTxt_2",findByObjectId = "overview_region_list_tablecell_weight_label_2")
    private BaseWebElement regionPercentageTxt2;
    @GherkinId(name = "regionPercentageTxt_3",findByObjectId = "overview_region_list_tablecell_weight_label_3")
    private BaseWebElement regionPercentageTxt3;
    @GherkinId(name = "regionPercentageTxt_4",findByObjectId = "overview_region_list_tablecell_weight_label_4")
    private BaseWebElement regionPercentageTxt4;

    @GherkinId(name = "regionTotalAssert_0",findByObjectId = "overview_region_list_tablecell_amount_label_0")
    private BaseWebElement regionTotalAssetTxt0;

    @GherkinId(findByObjectId = "overview_region_list_tablecell_percentage_view_0")
    private BaseWebElement regionPercentageView0;

    @GherkinId(name = "regionTotalAssert_1",findByObjectId = "overview_region_list_tablecell_amount_label_1")
    private BaseWebElement regionTotalAssetTxt1;

    @GherkinId(name = "regionTotalAssert_2",findByObjectId = "overview_region_list_tablecell_amount_label_2")
    private BaseWebElement regionTotalAssetTxt2;

    @GherkinId(name = "regionTotalAssert_3",findByObjectId = "overview_region_list_tablecell_amount_label_3")
    private BaseWebElement regionTotalAssetTxt3;

    @GherkinId(name = "regionTotalAssert_4",findByObjectId = "overview_region_list_tablecell_amount_label_4")
    private BaseWebElement regionTotalAssetTxt4;

    @GherkinId(name = "regionTotalAssert_5",findByObjectId = "overview_region_list_tablecell_amount_label_5")
    private BaseWebElement regionTotalAssetTxt5;


    /* ---  Overview Allocation holding  --- */
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
    @GherkinId(findByObjectId = "allocation_hint_msg_label")
    private BaseWebElement classUnavailableTitleTxt;

//    @GherkinId(findByObjectId = "overview_allocation_class_list_unavailable_content")
//    private BaseWebElement classUnavailableContentTxt;


    @GherkinId(findByObjectId = "allocation_hint_msg_label")
    private BaseWebElement currencyUnavailableTitleTxt;

//    @GherkinId(findByObjectId = "overview_allocation_currency_list_unavailable_content")
//    private BaseWebElement currencyUnavailableContentTxt;


    @GherkinId(findByObjectId = "allocation_hint_msg_label")
    private BaseWebElement regionUnavailableTitleTxt;

//    @GherkinId(findByObjectId = "overview_allocation_region_list_unavailable_content")
//    private BaseWebElement regionUnavailableContentTxt;


    /** Overview Liabilities,Net for asia */
    @GherkinId(name = "header \"Total liabilities\"", findByObjectId = "overview_main_libilities_title_btn")
    private BaseWebElement mainLiabilitesTitleTxt;

    @GherkinId(name = "Total liabilities icon", findByObjectId = "overview_main_libilities_chevron_btn")
    private BaseWebElement mainLiabilitesIconImg;

    @GherkinId(name = "Total liabilities value", findByObjectId = "overview_main_libilities_amount_btn")
    private BaseWebElement mainLiabilitesAmountBtn;

    @GherkinId(findByObjectId = "overview_main_libilities_currency_btn")
    private BaseWebElement mainLiabilitesCurrencyBtn;

    @GherkinId(findByObjectId = "overview_main_net_title_label")
    private BaseWebElement mainNetTitleTxt;

    @GherkinId(findByObjectId = "overview_main_net_amount_label")
    private BaseWebElement mainNetAmountTxt;

    @GherkinId(findByObjectId = "overview_main_net_currency_label")
    private BaseWebElement mainNetCurrencyTxt;

}
