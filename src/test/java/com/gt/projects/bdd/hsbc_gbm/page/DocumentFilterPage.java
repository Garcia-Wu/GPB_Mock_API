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
public class DocumentFilterPage extends BasePage {

    @GherkinId(findByObjectId = "document_filter_close_btn")
    private BaseWebElement closeBtn;

    @GherkinId(findByObjectId = "document_filter_title_label")
    private BaseWebElement titleTxt;

    @GherkinId(findByObjectId = "document_filter_tableview_view")
    private BaseWebElement tableView;

    @GherkinId(findByObjectId = "document_filter_tableview_head_view_0")
    private BaseWebElement headView0;

    @GherkinId(findByObjectId = "document_filter_tableview_head_title_label_0")
    private BaseWebElement accountHeaderTxt;

    @GherkinId(findByObjectId = "document_filter_tableview_head_title_label_1")
    private BaseWebElement categoryHeaderTxt;

    @GherkinId(findByObjectId = "document_filter_tableview_head_sub_title_label_0")
    private BaseWebElement headSubTitleTxt0;

    @GherkinId(findByObjectId = "document_filter_tableview_cell_0_0")
    private BaseWebElement accountView00;

    @GherkinId(findByObjectId = "document_filter_tableview_cell_all_btn_0_0")
    private BaseWebElement accountAllBtn;

    @GherkinId(findByObjectId = "document_filter_tableview_cell_none_btn_0_0")
    private BaseWebElement accountNoneBtn;

    @GherkinId(findByObjectId = "document_filter_tableview_cell_all_btn_1_0")
    private BaseWebElement categoryAllBtn;

    @GherkinId(findByObjectId = "document_filter_tableview_cell_none_btn_1_0")
    private BaseWebElement categoryNoneBtn;

    @GherkinId(findByObjectId = "document_filter_tableview_cell_title_label_0_1")
    private BaseWebElement nameTxt01;

    @GherkinId(findByObjectId = "document_filter_tableview_cell_switch_0_1")
    private BaseWebElement filterBtn01;


    @GherkinId(findByObjectId = "document_filter_footview_title_label")
    private BaseWebElement footTitleTxt;

    @GherkinId(findByObjectId = "document_filter_footview_date_label")
    private BaseWebElement footContextTxt;

    @GherkinId(findByObjectId = "document_filter_footview_set_date_btn")
    private BaseWebElement footSetDateBtn;



    @GherkinId(findByObjectId = "No accounts")
    private BaseWebElement iosNoAccountMessage;

}
