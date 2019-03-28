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
public class AllocationHoldingListPage extends BasePage {

    @GherkinId(name = "More menu icon", findByObjectId = "overview_main_menu_btn")
    private BaseWebElement menuBtn;

    @GherkinId(name = "Back button",findByObjectId = "allocation_main_holding_back_btn")
    private BaseWebElement backBtn;

    @GherkinId(name = "Name value",findByObjectId = "allocation_holding_title_label")
    private BaseWebElement titleTxt;

    @GherkinId(name = "Currency conversion icon",findByObjectId = "allocation_holding_currency_btn")
    private BaseWebElement currencyBtn;

    @GherkinId(name = "Total assets value",findByObjectId = "allocation_holding_amount_label")
    private BaseWebElement amountNumber;

    @GherkinId(findByObjectId = "allocation_holding_currency_label")
    private BaseWebElement amountCurrency;

    @GherkinId(name = "Holdings label",findByObjectId = "allocation_holding_table_title_label")
    private BaseWebElement tableTitle;

    @GherkinId(findByObjectId = "allocation_holding_list_tableview")
    private BaseWebElement tableView;

    @GherkinId(findByObjectId = "allocation_holdings_list_tableview_cell_1_0")
    private BaseWebElement holdingList0;

    @GherkinId(findByObjectId = "allocation_holding_list_tablecell_title_label_1_0")
    private BaseWebElement holdingNameTxt0;

    @GherkinId(findByObjectId = "allocation_holding_list_tablecell_arrow_img_1_0")
    private BaseWebElement holdingImg0;

    @GherkinId(findByObjectId = "allocation_holding_list_tablecell_weight_label_1_0")
    private BaseWebElement holdingPercentage0;

    @GherkinId(findByObjectId = "allocation_holding_list_tablecell_base_amount_label_1_0")
    private BaseWebElement holdingBaseAmount0;

    @GherkinId(findByObjectId = "allocation_holding_list_tablecell_base_currency_label_1_0")
    private BaseWebElement holdingBaseCurrency0;

    @GherkinId(findByObjectId = "allocation_holding_list_tablecell_report_amount_label_1_0")
    private BaseWebElement holdingReportAmount0;

    /**
     * FOR ASIA
     */
    @GherkinId(findByObjectId = "allocation_holdings_list_tablecell_performance_amount_1_0")
    private BaseWebElement holdingPerformanceAmount0;

    @GherkinId(findByObjectId = "allocation_holdings_list_tablecell_performance_amount_2_0")
    private BaseWebElement holdingPerformanceAmount1;

    @GherkinId(findByObjectId = "allocation_holdings_list_tablecell_performance_currency_1_0")
    private BaseWebElement holdingPerformanceCurrency0;

    @GherkinId(findByObjectId = "allocation_holdings_list_tablecell_performance_currency_2_0")
    private BaseWebElement holdingPerformanceCurrency1;


    //Holding by group
    @GherkinId(findByObjectId = "allocation_holding_collection_view")
    private BaseWebElement holdingCollection;
    @GherkinId(findByObjectId = "allocation_holding_page_control_view")
    private BaseWebElement holdingPageControl;
    @GherkinId(findByObjectId = "allocation_holding_sub_asset_class_label")
    private BaseWebElement holdingSubAssertClassLabel;
    @GherkinId(name = "sub asset class toggle",findByObjectId = "allocation_holding_group_type_btn")
    private BaseWebElement holdingGroupTypeBtn;

    //sub-assert class on
    @GherkinId(findByObjectId = "allocation_holding_list_tablehead_subasset_name_label_1")
    private BaseWebElement holdingListHeadName;
    @GherkinId(findByObjectId = "allocation_holding_list_tablehead_subasset_amount_label_1")
    private BaseWebElement holdingListHeadAmount;

//    Wrapper
    @GherkinId(findByObjectId = "allocation_holding_weight_label")
    private BaseWebElement holdingPercentage;
    @GherkinId(name = "donut graphic",findByObjectId = "allocation_holding_pie_chart_view")
    private BaseWebElement holdingGraphic;

}
