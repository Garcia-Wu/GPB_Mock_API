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
public class LiabilitiesDetailPage extends BasePage {

    @GherkinId(findByObjectId = "liability_detail_back_btn")
    private BaseWebElement backBtn;

    @GherkinId(name = "Liability Description value",findByObjectId = "liability_detail_description_label")
    private BaseWebElement descriptionTxt;

    @GherkinId(name = "Liability type value",findByObjectId = "liability_detail_type_label")
    private BaseWebElement typeTxt;

    @GherkinId(name = "Principal header",findByObjectId = "liability_detail_principal_label")
    private BaseWebElement principalTitleTxt;

    @GherkinId(name = "Principal value in the currency of the liability", findByObjectId = "liability_detail_principal_amount_label")
    private BaseWebElement principalAmountTxt;

    @GherkinId(findByObjectId = "liability_detail_principal_currency_label")
    private BaseWebElement principalCurrencyTxt;

    @GherkinId(name = "Accrued interest header", findByObjectId = "liability_detail_accrued_interest_label")
    private BaseWebElement accruedInterestTitleTxt;

    @GherkinId(name = "Accrued interest value in the currency of the liability", findByObjectId = "liability_detail_accrued_interest_amount_label")
    private BaseWebElement accruedInterestAmountTxt;

    @GherkinId(findByObjectId = "liability_detail_accrued_interest_currency_label")
    private BaseWebElement accruedInterestCurrencyTxt;

    @GherkinId(name = "Total header", findByObjectId = "liability_detail_total_label")
    private BaseWebElement totalTitleTxt;

    @GherkinId(name = "Total in loan currency value", findByObjectId = "liability_detail_total_amount_label")
    private BaseWebElement totalAmountTxt;

    @GherkinId(findByObjectId = "liability_detail_total_currency_label")
    private BaseWebElement totalCurrencyTxt;

    @GherkinId(name = "Total in portfolio base currency value in brackets", findByObjectId = "liability_detail_total_base_amount_label")
    private BaseWebElement totalBaseAmountTxt;

    @GherkinId(name = "explain", findByObjectId = "liability_detail_explain_label")
    private BaseWebElement explainTxt;
}
