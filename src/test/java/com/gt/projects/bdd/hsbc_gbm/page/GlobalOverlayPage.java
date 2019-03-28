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
public class GlobalOverlayPage extends BasePage {

    @GherkinId(name = "close button", findByObjectId = "global_overlay_close_btn")
    private BaseWebElement closeBtn;

    @GherkinId(name = "overlay title", findByObjectId = "global_overlay_title_label")
    private BaseWebElement titleTxt;

    @GherkinId(name = "overlay name", findByObjectId = "global_overlay_name_label")
    private BaseWebElement nameTxt;

    @GherkinId(name = "overlay content", findByObjectId = "global_overlay_content_label")
    private BaseWebElement contentTxt;

    @GherkinId(name = "overlay calculated", findByObjectId = "global_overlay_calculated_label")
    private BaseWebElement calculatedTxt;

    @GherkinId(name = "overlay calculated value", findByObjectId = "global_overlay_calculated_value_label")
    private BaseWebElement calculatedValueTxt;

    @GherkinId(name = "overlay advisory", findByObjectId = "global_overlay_advisory_label")
    private BaseWebElement advisoryTxt;

    @GherkinId(name = "overlay advisory value", findByObjectId = "global_overlay_advisory_value_label")
    private BaseWebElement advisoryValueTxt;

    @GherkinId(name = "overlay discretionary", findByObjectId = "global_overlay_discretionary_label")
    private BaseWebElement discretionaryTxt;

    @GherkinId(name = "overlay discretionary value", findByObjectId = "global_overlay_discretionary_value_label")
    private BaseWebElement discretionaryValueTxt;

    @GherkinId(name = "overlay hedge fund", findByObjectId = "global_overlay_hedge_fund_label")
    private BaseWebElement hedgeFundTxt;

    @GherkinId(name = "overlay hedge fund value", findByObjectId = "global_overlay_hedge_fund_value_label")
    private BaseWebElement hedgeFundValueTxt;



    @GherkinId(name = "overlay heading", findByObjectId = "global_overlay_heading_label")
    private BaseWebElement headingTxt;

    @GherkinId(name = "overlay bottom content", findByObjectId = "global_overlay_bottom_content_label")
    private BaseWebElement bottomContentTxt;

    @GherkinId(name = "overlay bottom calculated", findByObjectId = "global_overlay_bottom_calculated_label")
    private BaseWebElement bottomCalculatedTxt;

    @GherkinId(name = "overlay bottom calculated value", findByObjectId = "global_overlay_bottom_calculated_value_label")
    private BaseWebElement bottomCalculatedValueTxt;

    @GherkinId(name = "overlay bottom heading", findByObjectId = "global_overlay_bottom_heading_label")
    private BaseWebElement bottomHeadingTxt;
}
