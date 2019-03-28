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
public class TransactionDetailPage extends BasePage {

    /*
     * Transaction detail
     * */

    @GherkinId(findByObjectId = "transaction_main_status_img")
    private  BaseWebElement mainStatusImg;

    @GherkinId(findByXPath = "transaction_main_scroll_view")
    private BaseWebElement mainSliding;

    @GherkinId(findByObjectId = "transaction_main_back_btn")
    private BaseWebElement mainTransactionBack;

    @GherkinId(name = "Type value",findByObjectId = "transaction_main_trade_type_label")
    private BaseWebElement mainTransactionType;

    @GherkinId(name = "Transaction ID value",findByObjectId = "transaction_main_id_label")
    private BaseWebElement mainTransactionId;

    @GherkinId(name = "Trade date value",findByObjectId = "transaction_main_trade_date_label")
    private BaseWebElement mainTransactionDate;

    @GherkinId(name = "Transaction description value",findByObjectId = "transaction_main_description_label")
    private BaseWebElement mainTransactionDescription;

    @GherkinId(name = "Units value",findByObjectId = "transaction_main_units_label")
    private BaseWebElement mainTransactionUnits;

    @GherkinId(name = "Transaction value in holding currency",findByObjectId = "transaction_main_base_amount_label")
    private BaseWebElement mainTransactionBaseAmount;

    @GherkinId(findByObjectId = "transaction_main_base_currency_label")
    private BaseWebElement mainTransactionBaseCurrencyAos;

    @GherkinId(name = "Transaction value in portfolio reference currency",findByObjectId = "transaction_main_report_currency_label")
    private BaseWebElement mainTransactionReportCurrency;

    @GherkinId(name = "Status label",findByObjectId = "transaction_main_status_label")
    private BaseWebElement mainTransactionStatus;

    @GherkinId(name = "Settlement date value",findByObjectId = "transaction_main_settled_date_label")
    private  BaseWebElement mainTransactionSetDate;

    @GherkinId(name = "Disclaimer",findByObjectId = "transaction_main_explain_label")
    private BaseWebElement mainTransactionExplain;

    /*
     * Transaction detail end
     * */

}
