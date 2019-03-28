package com.gt.projects.bdd.base.utils;

import com.gt.projects.bdd.base.annotation.GherkinId;
import com.gt.projects.bdd.base.config.DriverConfig;
import com.gt.projects.bdd.base.enums.Platform;
import gherkin.pickles.PickleTag;
import io.appium.java_client.MobileBy;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by giotto.chow on 1/12/2018.
 */
public class GherkinUtils {

    protected static Logger logger = Logger.getLogger(GherkinUtils.class);



    public static String findPatternFromTags(Collection<String> tags, String annotationPattern) {

        if (tags == null) return "";

        for (String tag : tags) {
            if (tag.matches(annotationPattern)) {
                return tag;
            }
        }

        return "";
    }

    public static By toFinder(GherkinId gherkinId, String defaultId) {
        DriverConfig driverConfig = BeanUtils.autowire(DriverConfig.class);
        if(driverConfig.getPlatform().equals(Platform.ANDROID)){
            if (StringUtils.isNotBlank(gherkinId.findByObjectId())) {
                return new MobileBy.ByAccessibilityId(gherkinId.findByObjectId());
            } else if (StringUtils.isNotBlank(gherkinId.findByAosDevelopId())){
                return new MobileBy.ById(gherkinId.findByAosDevelopId());
            }
        } else {
            if (StringUtils.isNotBlank(gherkinId.findByObjectId())) {
                return By.id(gherkinId.findByObjectId());
            }
        }


        if (StringUtils.isNotBlank(gherkinId.findByXPath())) {
            return By.xpath(gherkinId.findByXPath());
        }

        if (StringUtils.isNotBlank(gherkinId.findByName())) {
            return By.name(gherkinId.findByName());
        } else {
            return By.id(defaultId);
        }
    }

    public static List<String> getTagList(List<PickleTag> tagList) {
        List<String> result = new ArrayList<>();
        for (PickleTag item : tagList) {
            result.add(item.getName());
        }
        return result;
    }




}