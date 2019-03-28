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
public class CurrencyConversionPage  extends BasePage {

    @GherkinId(name = "\"X\" button", findByObjectId = "currency_conversion_close_btn")
    private BaseWebElement closeBtn;

    @GherkinId(name = "Currency Conversion title", findByObjectId = "currency_conversion_title_label")
    private BaseWebElement titleTxt;

    @GherkinId(name = "Base currency title", findByObjectId = "currency_conversion_title_category_label")
    private BaseWebElement titleCategoryTxt;

    @GherkinId(name = "Base national flag", findByObjectId = "currency_conversion_base_flag_img")
    private BaseWebElement baseFlagImg;

    @GherkinId(name = "the default currency", findByObjectId = "currency_conversion_base_currency_label")
    private BaseWebElement baseCurrency;

    @GherkinId(name = "1.0 value", findByObjectId = "currency_conversion_base_rate_label")
    private BaseWebElement baseRate;

    @GherkinId(name = "Exchange rates copy content",findByObjectId = "currency_conversion_exchange_rates_label")
    private BaseWebElement ratesCopyContent;

    @GherkinId(findByObjectId = "currency_conversion_flag_img_0")
    private BaseWebElement flagImg;

    @GherkinId(findByObjectId = "currency_conversion_currency_label_row")
    private BaseWebElement currencyTxt;

    @GherkinId(findByObjectId = "currency_conversion_rate_label_row")
    private BaseWebElement rateNumber;

    @GherkinId(findByObjectId = "currency_conversion_ inform_label")
    private BaseWebElement informTxt;

    @GherkinId(findByObjectId = "currency_conversion_update_date_label")
    private BaseWebElement updateDate;

    @GherkinId(name = "wrong icon image", findByObjectId = "currency_conversion_wrong_icon_img")
    private BaseWebElement wrongIconImg;

    @GherkinId(findByObjectId = "currency_conversion_wrong_title_label")
    private BaseWebElement wrongTitle;

    @GherkinId(name = "wrong message text", findByObjectId = "currency_conversion_wrong_msg_label")
    private BaseWebElement wrongMsgTxt;

    @GherkinId(findByObjectId = "currency_conversion_wrong_relationship_msg_label")
    private BaseWebElement wrongRelationshipTxt;

    @GherkinId(findByObjectId = "currency_conversion_table_view")
    private BaseWebElement tableView;

    @GherkinId(findByObjectId = "currency_conversion_table_view_cell_row")
    private BaseWebElement tableViewCell;
}
