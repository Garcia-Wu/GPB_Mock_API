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
public class ImportantPage extends BasePage {

    @GherkinId(findByObjectId = "important_main_title_label")
    private BaseWebElement mainTitleTxt;

    @GherkinId(findByObjectId = "important_main_close_btn")
    private BaseWebElement mainCloseBtn;

    @GherkinId(findByObjectId = "important_main_content_textview")
    private BaseWebElement mainContent;

    @GherkinId(findByObjectId = "important_main_bg_btn")
    private BaseWebElement mainBG;
}
