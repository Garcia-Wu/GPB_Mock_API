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
public class MenuLegalPage extends BasePage {

    /*
    * main Legal list
    * */
    @GherkinId(name = "Back button", findByObjectId = "legal_main_back_btn")
    private BaseWebElement mainBackBtn;

    @GherkinId(name = "Legal title",findByObjectId = "legal_main_title_label")
    private BaseWebElement mainTitle;

    @GherkinId(findByObjectId = "legal_main_tabel_view")
    private BaseWebElement mainTabelView;

    @GherkinId(findByObjectId = "legal_main_tabelview_cell_0")
    private BaseWebElement mainLegalList0;

    @GherkinId(name = "Terms and Conditions", findByObjectId = "legal_main_tableview_cell_title_Label_0")
    private BaseWebElement termsAndConditions;
    @GherkinId(name = "Privacy Policy", findByObjectId = "legal_main_tableview_cell_title_Label_1")
    private BaseWebElement privacyPolicy;
    @GherkinId(name = "Accessibility Statement", findByObjectId = "legal_main_tableview_cell_title_Label_2")
    private BaseWebElement accessibilityStatement;
    @GherkinId(name = "Security Tips", findByObjectId = "legal_main_tableview_cell_title_Label_3")
    private BaseWebElement securityTips;

    @GherkinId(findByObjectId = "legal_main_tableview_cell_arrow_img_0")
    private BaseWebElement mainLegalArrowImg0;

    /*
     * Privacy policy   T&C   Accessibility statement
     * */
    @GherkinId(name = "back legal button", findByObjectId = "legal_main_back_btn")
    private BaseWebElement backLegalBtn;

    @GherkinId(name = "title", findByObjectId = "legal_main_title_label")
    private BaseWebElement titleTxt;

    @GherkinId(name = "content", findByObjectId = "legal_main_content_textview")
    private BaseWebElement contentTxt;

    @GherkinId(findByObjectId = "legal_main_mask_view")
    private BaseWebElement maskTxt;

    /* ASIA Terms of service */
    @GherkinId(findByObjectId = "")
    private BaseWebElement termsAndConditionsTabTxt;

    @GherkinId(findByObjectId = "")
    private BaseWebElement termOfUseTabTxt;

    /*
    * don’t show me again
    * */
    @GherkinId(findByObjectId = "again_alert_title_label")
    private BaseWebElement againTitleTxt;

    @GherkinId(findByObjectId = "again_alert_checkbox_on_button")
    private BaseWebElement againOnBtn;

    @GherkinId(findByObjectId = "again_alert_checkbox_off_button")
    private BaseWebElement againOffBtn;

    @GherkinId(findByObjectId = "again_alert_checkbox_title_label")
    private BaseWebElement againCheckboxTitle;

    @GherkinId(findByObjectId = "again_alert_ok_btn")
    private BaseWebElement againOkBtn;

    @GherkinId(findByObjectId = "again_alert_cancel_btn")
    private BaseWebElement againCancelBtn;


}
