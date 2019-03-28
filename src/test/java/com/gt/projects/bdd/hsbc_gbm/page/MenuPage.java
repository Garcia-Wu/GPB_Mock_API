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
public class MenuPage extends BasePage {

    /* --  More Menu  -- */

    @GherkinId(findByObjectId = "menu_main_close_btn")
    private BaseWebElement closeBtn;

    @GherkinId(name = "Username", findByObjectId = "menu_main_user_name_label")
    private BaseWebElement userNameTxt;

    @GherkinId(name = "Last login time", findByObjectId = "menu_main_last_login_label")
    private BaseWebElement lastLoginTimeTxt;

    @GherkinId(findByObjectId = "menu_main_documents_btn")
    private BaseWebElement documentsTxt;

    @GherkinId(findByObjectId = "menu_main_documents_count_label")
    private BaseWebElement documentsCountTxt;

    @GherkinId(name = "Security label", findByObjectId = "menu_main_table_head_security_label")
    private BaseWebElement headSecurityTxt;

    @GherkinId(findByObjectId = "menu_main_table_head_security_img")
    private BaseWebElement headSecurityImg;

    @GherkinId(findByObjectId = "menu_main_table_cell_touchId_label")
    private BaseWebElement touchIdTxt;

    @GherkinId(findByObjectId = "menu_main_table_cell_touchId_off_btn")
    private BaseWebElement touchIdOff;

    @GherkinId(findByObjectId = "menu_main_table_cell_touchId_on_btn")
    private BaseWebElement touchIdOn;

    @GherkinId(findByObjectId = "menu_main_table_cell_change_pin_label")
    private BaseWebElement changPinTxt;

    @GherkinId(findByObjectId = "menu_main_table_head_notifications_label")
    private BaseWebElement notificationsTxt;

    @GherkinId(findByObjectId = "menu_main_table_head_frequently_label")
    private BaseWebElement frequentlyTxt;

    @GherkinId(name = "Glossary of terms label", findByObjectId = "menu_main_table_head_glossary_label")
    private BaseWebElement glossaryTxt;

    @GherkinId(name = "Feedback label", findByObjectId = "menu_main_table_head_feedback_label")
    private BaseWebElement feedbackTxt;

    @GherkinId(name = "Legal label", findByObjectId = "menu_main_table_head_legal_label")
    private BaseWebElement legalTxt;

    @GherkinId(findByObjectId = "menu_main_table_head_legal_img")
    private BaseWebElement legalImg;

    @GherkinId(findByObjectId = "menu_main_table_cell_terms_label")
    private BaseWebElement termsTxt;

    @GherkinId(findByObjectId = "menu_main_table_cell_privacy_label")
    private BaseWebElement privacyTxt;

    @GherkinId(findByObjectId = "menu_main_table_cell_about_label")
    private BaseWebElement aboutTxt;

    @GherkinId(name = "Knowledge & research Centre label", findByObjectId = "menu_main_table_foot_title_label")
    private BaseWebElement krcTxt;

    @GherkinId(findByObjectId = "menu_main_table_foot_description_label")
    private BaseWebElement footContent;

    @GherkinId(name = "Log Out button", findByObjectId = "menu_main_log_out_btn")
    private BaseWebElement logoutBtn;

    @GherkinId(findByXPath = "//XCUIElementTypeButton[@name=\"Log off\"]")
    private BaseWebElement verifyLogoutBtn;

    @GherkinId(findByObjectId = "Log on again")
    private BaseWebElement verifyLogonBtn;
    @GherkinId(findByObjectId = "again_alert_ok_btn")
    private BaseWebElement aosLogonBtn;
    @GherkinId(findByObjectId = "error_main_return_btn")
    private BaseWebElement returnLoginBtn;

    @GherkinId(findByObjectId = "menu_main_bg_btn")
    private BaseWebElement bgBtn;

    @GherkinId(findByObjectId = "menu_main_table_view")
    private BaseWebElement menuListView;


    /* --  Menu: Glossary of terms  -- */

    @GherkinId(findByObjectId = "glossary_main_back_btn")
    private BaseWebElement glossaryBackBtn;

    @GherkinId(findByObjectId = "glossary_main_title_label")
    private BaseWebElement glossaryTitleTxt;

    @GherkinId(findByObjectId = "glossary_main_table_head_name_label_0_0")
    private BaseWebElement glossaryListNameTxt0;


    @GherkinId(findByObjectId = "glossary_main_table_head_arrow_img_0_0")
    private BaseWebElement glossaryListArrowImg0;

    @GherkinId(findByObjectId = "glossary_main_table_cell_content_label_0_0")
    private BaseWebElement glossaryListContentTxt0;


    @GherkinId(findByObjectId = "glossary_main_table_view")
//    @GherkinId(findByXPath = "//XCUIElementTypeTable[@name=\"AX error -25205\"]\n") // iphone 7 plus test
    private BaseWebElement glossaryListView;

    @GherkinId(findByObjectId = "glossary_main_table_foot_view")
    private BaseWebElement glossaryFootMessageTxt;


    /* --  Menu: Knowledge & Research Centre  -- */

    @GherkinId(name = "KRC back button", findByObjectId = "menu_main_back_btn")
    private BaseWebElement krcBackBtn;

    @GherkinId(findByObjectId = "menu_main_back_btn")
    private BaseWebElement aosKRCBackBtnTxt;

    @GherkinId(name = "head title label", findByObjectId = "krc_main_title_label")
    private BaseWebElement krcTitleTxt;

    @GherkinId(name = "Background image", findByObjectId = "krc_main_bg_img")
    private BaseWebElement krcBgImg;

    @GherkinId(name = "Background image text", findByObjectId = "krc_main_bg_label")
    private BaseWebElement krcBgTxt;

    @GherkinId(name = "exclusive image", findByObjectId = "krc_main_exclusive_img")
    private BaseWebElement krcExclusiveImg;

    @GherkinId(name = "exclusive label", findByObjectId = "krc_main_exclusive_label")
    private BaseWebElement krcExclusiveTxt;

    @GherkinId(name = "comment image", findByObjectId = "krc_main_comment_img")
    private BaseWebElement krcCommentImg;

    @GherkinId(name = "comment label", findByObjectId = "krc_main_comment_label")
    private BaseWebElement krcCommentTxt;

    @GherkinId(name = "investment image", findByObjectId = "krc_main_investment_img")
    private BaseWebElement krcInvestmentImg;

    @GherkinId(name = "investment label", findByObjectId = "krc_main_investment_label")
    private BaseWebElement krcInvestmentTxt;

    @GherkinId(name = "register label", findByObjectId = "krc_main_register_label")
    private BaseWebElement krcRegisterTxt;

    @GherkinId(name = "login button", findByObjectId = "krc_main_login_btn")
    private BaseWebElement krcLoginBtn;

    @GherkinId(name = "foot label", findByObjectId = "krc_main_foot_label")
    private BaseWebElement krcFootTxt;


    /* --  Menu: Knowledge & Research Centre: Overlay -- */

    @GherkinId(name = "overlay title", findByObjectId = "login_alert_title_label")
    private BaseWebElement krcOverlayTitleTxt;

    @GherkinId(findByObjectId = "login_alert_checkbox_off_button")
    private BaseWebElement krcOverlayCheckOffBtn;

    @GherkinId(findByObjectId = "login_alert_checkbox_on_button")
    private BaseWebElement krcOverlayCheckOnBtn;

    @GherkinId(name = "\"Don't show me again\" button", findByObjectId = "login_alert_checkbox_title_label")
    private BaseWebElement krcOverlayCheckTitle;

    @GherkinId(name = "\"OK\" button", findByObjectId = "login_alert_ok_btn")
    private BaseWebElement krcOverlayOkBtn;

    @GherkinId(name = "\"Cancel\" button", findByObjectId = "login_alert_cancel_btn")
    private BaseWebElement krcOverlayCancelBtn;

    //add by yippee for cancel button in log out pop up page
    @GherkinId(name = "Cancel",findByObjectId = "Cancel")
    private BaseWebElement cancelBtn;
    @GherkinId(findByObjectId = "again_alert_cancel_btn")
    private BaseWebElement aosCancelBtn;

}
