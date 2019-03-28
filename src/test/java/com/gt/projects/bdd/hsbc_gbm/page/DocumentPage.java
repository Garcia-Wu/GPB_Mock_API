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
public class DocumentPage extends BasePage {

    @GherkinId(findByObjectId = "document_main_back_btn")
    private BaseWebElement backBtn;

    @GherkinId(findByObjectId = "document_main_title_label")
    private BaseWebElement titleTxt;

    @GherkinId(findByObjectId = "document_main_filter_btn")
    private BaseWebElement filterBtn;

    @GherkinId(name = "All tab", findByObjectId = "document_main_all_btn")
    private BaseWebElement allBtn;

    @GherkinId(name = "Unread tab", findByObjectId = "document_main_unread_btn")
    private BaseWebElement unreadBtn;

    @GherkinId(findByObjectId = "document_main_flagged_btn")
    private BaseWebElement flaggedBtn;

    @GherkinId(findByObjectId = "document_main_list_tableview")
    private BaseWebElement listView;

    @GherkinId(findByObjectId = "document_list_taleview_head_date_label_0")
    private BaseWebElement tableHeadTxt0;

    @GherkinId(findByObjectId = "document_list_taleview_head_date_label_2")
    private BaseWebElement tableHeadTxt2;

    @GherkinId(findByObjectId = "document_list_tableview_cell_0_0")
    private BaseWebElement documentCell0;


    @GherkinId(findByObjectId = "document_list_tableview_category_label_0_0")
    private BaseWebElement category00;

    @GherkinId(findByObjectId = "document_list_tableview_category_label_1_0")
    private BaseWebElement category10;

    @GherkinId(findByObjectId = "document_list_tableview_category_label_1_2")
    private BaseWebElement category12;


    @GherkinId(findByObjectId = "document_list_tableview_name_label_0_0")
    private BaseWebElement name00;

    @GherkinId(findByObjectId = "document_list_tableview_name_label_1_0")
    private BaseWebElement name10;

    @GherkinId(findByObjectId = "document_list_tableview_name_label_1_2")
    private BaseWebElement name12;


    @GherkinId(findByObjectId = "document_list_tableview_account_name_label_0_0")
    private BaseWebElement accountName00;

    @GherkinId(findByObjectId = "document_list_tableview_account_name_label_1_0")
    private BaseWebElement accountName10;

    @GherkinId(findByObjectId = "document_list_tableview_account_name_label_1_2")
    private BaseWebElement accountName12;


    @GherkinId(findByObjectId = "document_list_tableview_size_label_0_0")
    private BaseWebElement size00;

    @GherkinId(findByObjectId = "document_list_tableview_size_label_1_0")
    private BaseWebElement size10;

    @GherkinId(findByObjectId = "document_list_tableview_size_label_1_2")
    private BaseWebElement size12;

    @GherkinId(name = "disclaimer", findByObjectId = "document_list_tableview_footview")
    private BaseWebElement footTxt;

    @GherkinId(findByObjectId = "document_main_no_documents_msg_label")
    private BaseWebElement noDocumentTopMessageTxt;

    @GherkinId(findByObjectId = "document_main_no_documents_tips_label")
    private BaseWebElement noDocumentBottomMessageTxt;

}
