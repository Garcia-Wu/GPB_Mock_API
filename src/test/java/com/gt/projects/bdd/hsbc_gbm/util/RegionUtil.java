package com.gt.projects.bdd.hsbc_gbm.util;

import com.gt.projects.bdd.base.BaseWebElement;
import com.gt.projects.bdd.base.config.DriverConfig;
import com.gt.projects.bdd.base.utils.BeanUtils;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import cucumber.api.DataTable;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.runtime.directive.Foreach;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegionUtil {

    public static final String REGION_UK = "UK";
    public static final String REGION_HK = "HK";
    public static final String REGION_SG = "SG";

    private static DriverConfig driverConfig = BeanUtils.autowire(DriverConfig.class);

    // temp  eg: UK_HK_SG  GBP_USD_JPY
    public static String getValue(String region, String temp) {

        String[] regions = region.split("_");
        String[] temps = temp.split("_");
        for (int i = 0; i < regions.length; i++){
            if(driverConfig.getAppRegion().equals(regions[i])){
                return temps[i];
            }
        }
        return "";
    }

    public static Map<String, String> getMap(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        Map<String, String> resultMap = new HashMap<>();
        for(Map<String, String> map : list){
            if(StringUtils.isBlank(map.get("element region"))){
                resultMap.put(map.get("element name"), map.get("element value"));
            } else {
                String[] regions = map.get("element region").split("_");
                for (String region : regions){
                    if(driverConfig.getAppRegion().equals(region)){
                        resultMap.put(map.get("element name"), map.get("element value"));
                    }
                }
            }
        }
        return resultMap;
    }
    public static void click(String region, BaseWebElement uk, BaseWebElement hk, BaseWebElement sg) {
        String[] regions = region.split("_");
        BaseWebElement[] elements = new BaseWebElement[3];
        elements[0] = uk;
        elements[1] = hk;
        elements[2] = sg;
        for (int i = 0; i < regions.length; i++){
            if(driverConfig.getAppRegion().equals(regions[i])){
                SleepUtil.waitForElement(elements[i]);
                if (elements[i].isVisible()){
                    elements[i].click();
                }
            }
        }
    }
    public static void sendCode(String region, BaseWebElement uk, BaseWebElement hk, BaseWebElement sg,String keyValue) {
        String[] regions = region.split("_");
        BaseWebElement[] elements = new BaseWebElement[3];
        elements[0] = uk;
        elements[1] = hk;
        elements[2] = sg;
        for (int i = 0; i < regions.length; i++){
            if(driverConfig.getAppRegion().equals(regions[i])){
                SleepUtil.waitForElement(elements[i]);
                elements[i].sendKeys(keyValue);
            }
        }
    }



    public static boolean isAisa(){
        return isHK() || isSG();
    }

    public static boolean isUK(){
        return REGION_UK.equals(driverConfig.getAppRegion());
    }

    public static boolean isHK(){
        return REGION_HK.equals(driverConfig.getAppRegion());
    }

    public static boolean isSG(){
        return REGION_SG.equals(driverConfig.getAppRegion());
    }
}
