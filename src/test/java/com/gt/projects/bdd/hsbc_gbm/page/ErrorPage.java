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
public class ErrorPage extends BasePage {

    @GherkinId(findByObjectId = "error_main_icon_img")
    private BaseWebElement mainIconImg;

    @GherkinId(name = "Page Title",findByObjectId = "error_main_title_label")
    private BaseWebElement mainTitle;

    @GherkinId(name = "More Information",findByObjectId = "error_main_description_label")
    private BaseWebElement mainDescription;

    @GherkinId(findByObjectId = "error_main_return_btn")
    private BaseWebElement mainBackBtn;

}
