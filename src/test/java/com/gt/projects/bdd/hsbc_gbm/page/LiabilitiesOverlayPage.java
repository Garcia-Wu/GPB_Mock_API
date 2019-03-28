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
public class LiabilitiesOverlayPage extends BasePage {

//    @GherkinId(name = "\"Total liabilities\" header", findByObjectId = "liability_overlay_title_label")
//    private BaseWebElement titleTxt;
//
//    @GherkinId(name = "Total name value", findByObjectId = "liability_overlay_name_label")
//    private BaseWebElement nameTxt;
//
//    @GherkinId(name = "Total Liabilities value", findByObjectId = "liability_overlay_amount_label")
//    private BaseWebElement amountTxt;
//
//    @GherkinId(findByObjectId = "liability_overlay_currency_label")
//    private BaseWebElement currencyTxt;
//
//    @GherkinId(name = "\"How is the caculated?\" header", findByObjectId = "liability_overlay_weight_label")
//    private BaseWebElement questionTxt;
//
//    @GherkinId(name = "Total Liabilities answer", findByObjectId = "liability_overlay_text_label")
//    private BaseWebElement answerTxt;
//
//    @GherkinId(findByObjectId = "liability_overlay_bg_button")
//    private BaseWebElement bgBtn;
//
//    @GherkinId(findByObjectId = "liability_overlay_close_btn")
//    private BaseWebElement closeBtn;
}
