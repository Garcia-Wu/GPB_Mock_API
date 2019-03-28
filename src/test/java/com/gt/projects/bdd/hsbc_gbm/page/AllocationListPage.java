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
public class AllocationListPage extends BasePage {

    @GherkinId(name = "More menu icon", findByObjectId = "overview_main_menu_btn")
    private BaseWebElement menuBtn;

    @GherkinId(name = "Name label", findByObjectId = "allocation_main_title_label")
    private BaseWebElement accountName;

    @GherkinId(name = "Asset allocation label", findByObjectId = "allocation_main_toggle_title_label")
    private BaseWebElement allocationToggleLabel;

    @GherkinId(name = "Asset Allocation toggle", findByObjectId = "allocation_main_toggle_btn")
    private BaseWebElement allocationToggleBtn;

    @GherkinId(name = "Total Assets label", findByObjectId = "allocation_main_totol_asset_title_label")
    private BaseWebElement totalAssertLabel;

    @GherkinId(name = "Total Assets value", findByObjectId = "allocation_main_totol_asset_value_label")
    private BaseWebElement totalAssertValue;

    @GherkinId(name = "Total Assets currency", findByObjectId = "allocation_main_totol_asset_currency_label")
    private BaseWebElement totalAssertCurrency;

    @GherkinId(name = "Account Back button", findByObjectId = "account_main_back_btn")
    private BaseWebElement accountAllocationBackBtn;

    @GherkinId(name = "Portfolio Back button", findByObjectId = "portfolio_holdings_back_btn")
    private BaseWebElement portfolioAllocationBackBtn;

    @GherkinId(name = "Asset Class", findByObjectId = "allocation_tab_asset_class_btn")
    private BaseWebElement assertClassBtn;

    @GherkinId(name = "Currency", findByObjectId = "allocation_tab_currency_btn")
    private BaseWebElement currencyBtn;

    @GherkinId(name = "Region", findByObjectId = "allocation_tab_region_btn")
    private BaseWebElement regionBtn;

    /*
     * asset allocation collapse
     * */
    @GherkinId(findByObjectId = "allocation_list_tablecell_pie_chart_view_0")
    private BaseWebElement allocationListGraphicView0;

    @GherkinId(findByObjectId = "allocation_list_tablecell_weight_label_0")
    private BaseWebElement allocationListPercentage0;

    @GherkinId(findByObjectId = "allocation_list_tablecell_name_label_0")
    private BaseWebElement allocationListName0;

    @GherkinId(findByObjectId = "allocation_list_tablecell_amount_label_0")
    private BaseWebElement allocationListAmount0;

    @GherkinId(findByObjectId = "allocation_list_tablecell_view_0")
    private BaseWebElement allocationListView0;

    @GherkinId(findByObjectId="allocation_list_tableview")
    private BaseWebElement allocationListTableView;

    @GherkinId(name = "state copy", findByObjectId = "allocation_hint_msg_label")
    private BaseWebElement allocationMessage;

}
