package com.gt.projects.bdd.hsbc_gbm.page;

import com.gt.projects.bdd.base.BasePage;
import com.gt.projects.bdd.base.BaseWebElement;
import com.gt.projects.bdd.base.annotation.GherkinId;
import lombok.Data;
import org.openqa.selenium.internal.FindsById;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Data
@Scope("thread")
public class AllocationGraphicPage extends BasePage {

    /*
    * asset allocation expansion
    * */
    @GherkinId(name = "More menu icon", findByObjectId = "overview_main_menu_btn")
    private BaseWebElement menuBtn;

    @GherkinId(name = "Name label", findByObjectId = "allocation_main_title_label")
    private BaseWebElement accountName;

    @GherkinId(name = "Region Or ID", findByObjectId = "allocation_main_common_label")
    private BaseWebElement accountRegion;

    @GherkinId(name = "Asset allocation label", findByObjectId = "allocation_main_toggle_title_label")
    private BaseWebElement allocationToggleLabel;

    @GherkinId(name = "Asset Allocation toggle", findByObjectId = "allocation_main_toggle_btn")
//    @GherkinId(name = "Asset Allocation toggle", findByXPath = "//XCUIElementTypeOther[@name=\"allocation_main_toggle_btn\"]")
    private BaseWebElement allocationToggleBtn;

    @GherkinId(name = "Asset Class", findByObjectId = "allocation_tab_asset_class_btn")
    private BaseWebElement assertClassBtn;

    @GherkinId(name = "Currency", findByObjectId = "allocation_tab_currency_btn")
    private BaseWebElement currencyBtn;

    @GherkinId(name = "Region", findByObjectId = "allocation_tab_region_btn")
    private BaseWebElement regionBtn;

    @GherkinId(name = "Graphic", findByObjectId = "allocation_pie_chart_view")
    private BaseWebElement graphicView;

    @GherkinId(name = "Total assets label", findByObjectId = "allocation_main_totol_asset_title_label")
    private BaseWebElement totalAssertLabel;

    @GherkinId(name = "Total assets value", findByObjectId = "allocation_main_totol_asset_value_label")
    private BaseWebElement totalAssertValue;

    @GherkinId(name = "Total assets currency", findByObjectId = "allocation_main_totol_asset_currency_label")
    private BaseWebElement totalAssertCurrency;

    @GherkinId(name = "graphic includes copy", findByObjectId = "allocation_main_negative_title_label")
    private BaseWebElement negativeMessage;

    @GherkinId(name = "key", findByObjectId = "allocation_bar_key_view_0")
    private BaseWebElement allocationBarKey0;

    @GherkinId(findByObjectId = "allocation_bar_name_label_0")
    private BaseWebElement allocationBarKeyName0;

    @GherkinId(name = "Account Back button", findByObjectId = "account_main_back_btn")
    private BaseWebElement accountAllocationBackBtn;

    @GherkinId(name = "Portfolio Back button", findByObjectId = "portfolio_holdings_back_btn")
    private BaseWebElement portfolioAllocationBackBtn;

    @GherkinId(findByObjectId="allocation_bar_key_tableview")
    private BaseWebElement allocationBarTableView;


    /*
    * asset allocation hint message
    * */
    @GherkinId(name = "state copy", findByObjectId = "allocation_hint_msg_label")
    private BaseWebElement allocationMessage;

}
