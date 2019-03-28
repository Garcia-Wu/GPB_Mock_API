package com.gt.projects.bdd.base.utils;

import com.gt.projects.bdd.base.enums.DataFormat;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;

/**
 * Created by giotto.chow on 1/12/2018.
 */
public class ValidUtils {
    
    public static Boolean assertFormat(String data, DataFormat format){
        if(StringUtils.isNotBlank(data)) {
            if(data.matches(format.getRegex())){
                Assert.assertTrue(true);
                return true;
            }
        }
        
        Assert.assertTrue("Invalid data format, '" + data + "' should be " + format.toString(), false);
        return false;
    }
}