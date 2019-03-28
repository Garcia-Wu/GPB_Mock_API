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
public class ContingentLiabilitiesPage extends BasePage {

    /*--- Contingent liabilities list ---*/
    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_back_btn")
    //@GherkinId(findByObjectId = "Holiday Home Fund")
    private BaseWebElement backBtn;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_title_label")
    private BaseWebElement titleTxt;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_totlal_commitments_label")
    private BaseWebElement totalCommitmentsTxt;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_totlal_commitments_Img")
    private BaseWebElement totalCommitmentsImg;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_totlal_commitments_btn")
    private BaseWebElement totalCommitmentsBtn;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_totlal_currency_label")
    private BaseWebElement totalCurrencyTxt;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_list_tablecell_title_label_0_0")
    private BaseWebElement listTitleTxt0;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_list_tablecell_sub_title_label_0_0")
    private BaseWebElement listSubTitleTxt0;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_list_tablecell_weight_label_0_0")
    private BaseWebElement listWeightTxt0;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_list_tablecell_amount_label_0_0")
    private BaseWebElement listAmountTxt0;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_list_tablecell_currency_label_0_0")
    private BaseWebElement listCurrencyTxt0;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_list_tableview")
    private BaseWebElement listView;


    /*--- Contingent liabilities pop-up ---*/

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_layer_title_label", findByName = "portfolio_contingent_liabilities_title_label")
    private BaseWebElement popTitleTxt;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_code_label")
    private BaseWebElement popCodeTxt;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_total_assets_label")
    private BaseWebElement popTotalAssetsTxt;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_currency_label")  // 数字的单位（GBP）
    private BaseWebElement popGbpTxt;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_close_btn")
    private BaseWebElement popCloseBtn;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_question_label")
    private BaseWebElement popQuestionTxt;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_answer_label")
    private BaseWebElement popAnswerTxt;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_bg_btn")  // 弹出框外面部分，点击可关闭弹出框
    private BaseWebElement popGbBtn;


    /*--- Contingent liabilities detail ---*/

    @GherkinId(findByXPath = "//XCUIElementTypeCollectionView[@name=\"portfolio_contingent_liabilities_detail_horizontal_view\"]/XCUIElementTypeCell/XCUIElementTypeOther")
    private BaseWebElement detailView;

    @GherkinId(findByXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.FrameLayout")
    private BaseWebElement aosDetailView;

    @GherkinId(findByXPath = "//XCUIElementTypeCollectionView[@name=\"portfolio_contingent_liabilities_detail_horizontal_view\"]/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeScrollView")
    private BaseWebElement iosDetailView;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_detail_back_btn")
    private BaseWebElement detailBackBtn;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_detail_description_label_0")
    private BaseWebElement detailDescriptionTxt0;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_detail_horizontal_line_view")
    private BaseWebElement detailHorizontalLineBar;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_detail_initial_commitment_title_label_0")
    private BaseWebElement detailInitialTitleTxt0;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_detail_initial_commitment_value_label_0")
    private BaseWebElement detailInitialContentTxt0;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_detail_initial_commitment_reporting_label_0")
    private BaseWebElement detailInitialReportingTxt0;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_detail_horizontal_bar_view_0")
    private BaseWebElement detailHorizontalBar0;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_detail_remaining_title_label_0")
    private BaseWebElement detailRemainingTitleTxt0;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_detail_remaining_commitment_value_label_0")
    private BaseWebElement detailRemainingContentTxt0;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_detail_remaining_commitment_value_Currency_label_0")
    private BaseWebElement detailRemainingCurrency0;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_detail_remaining_commitment_reporting_label_0")
    private BaseWebElement detailRemainingReportingTxt0;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_detail_remaining_commitment_percentage_label_0")
    private BaseWebElement detailRemainingPercentageTxt0;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_detail_more_details_label_0")
    private BaseWebElement detailMoreDetailTitleTxt0;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_detail_more_description_label_0")
    private BaseWebElement detailMoreDetailContentTxt0;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_detail_foot_text_label_0")
    private BaseWebElement detailFootTxt0;

    @GherkinId(findByObjectId = "portfolio_contingent_liabilities_detail_pips_bar")
    private BaseWebElement detailPipsBar;
}
