package com.gt.projects.bdd.base;

import com.gt.projects.bdd.base.config.DriverConfig;
import com.gt.projects.bdd.base.enums.KeyboardType;
import com.gt.projects.bdd.base.enums.Platform;
import com.gt.projects.bdd.base.enums.ScrollDirection;
import com.gt.projects.bdd.base.service.CucumberService;
import com.gt.projects.bdd.base.service.DeviceService;
import com.gt.projects.bdd.base.service.ReportService;
import com.gt.projects.bdd.hsbc_gbm.util.CheckUtil;
import io.appium.java_client.MobileBy;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.text.Collator;
import java.util.*;

public abstract class BaseFlow<T extends BasePage> {


    @Autowired
    private CucumberService cucumberService;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private ReportService reportService;

    @Autowired
    private DriverConfig driverConfig;

    protected Logger logger = Logger.getLogger(this.getClass());

    protected T currentPage;

    public static final String DESC = "desc";
    public static final String ASC = "asc";

    protected BaseFlow(T currentPage) {
        this.currentPage = currentPage;
    }

//    private void inputFieldByGherkinKeyNValue(String key, String value){
//
//        try {
//            Map.Entry<GherkinId, Field> gherkinMap = getGherkinMapByKeyNValue(key, value);
//
//            GherkinId gherkinId = gherkinMap.getKey();
//            Field field = gherkinMap.getValue();
//
//            BaseWebElement element = (BaseWebElement) field.get(currentPage);
//
//            //TODO: enum => event handler mapping
//            // ClickEventHandler : BaseEventHandler
//            // SendKeyEventHandler : BaseEventHandler
//            // BaseEventHandler.perform(element, ...parameters);
//
//            InputType inputType = gherkinId.type();
//            if (InputType.CLICK.equals(inputType)) {
//                element.click();
//            } else if (InputType.SENDKEY.equals(inputType)) {
//                element.sendKeys(value);
//            }
//        } catch(IllegalAccessException ex){
//            logger.error("Cannot access to " + key, ex);
//        }
//
//    }
//
//    protected void inputForm(Map<String, String> inputMap){
//        if(inputMap != null){
//            for(Map.Entry<String, String> item : inputMap.entrySet()){
//                inputFieldByGherkinKeyNValue(item.getKey(), item.getValue());
//            }
//        }
//    }
//
//    protected void inputForm(Integer rowNum, DataTable dataTable){
//        if(dataTable != null){
//
//            if(rowNum == null) rowNum = 1;
//
//            List<List<String>> table = dataTable.asLists(String.class);
//            List<String> header = table.get(0);
//            List<String> value = table.get(rowNum);
//
//            for(int i = 0 ; i < header.size(); i++){
//                inputFieldByGherkinKeyNValue(header.get(i), value.get(i));
//            }
//        }
//    }
//

    protected void captureScreen() {
//        File screenshot = deviceService.takeScreenShot("");
//        reportService.embed(screenshot.getPath().getBytes(), "image/url");
    }

    protected void sleep(Long ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error(ex);
        }

    }

    protected void navigateTo(BaseWebElement webElement) {
        //TODO:
    }

    protected void hasKeyboard(KeyboardType type) {
        //TODO:
    }

    public void assertElementIsExist(String gherkinId) {
        captureScreen();
        Assert.assertTrue(gherkinId + " does not exist", currentPage.getElementByGherkinId(gherkinId).isDisplayed());
    }

    public void assertOnThisScreen() {
        for (BaseWebElement item : currentPage.getUniqueKeyElements()) {
//            Assert.assertTrue(item.getFinder() + " does not found.", item.isDisplayed());
        }

        captureScreen();
    }

    public void assertIsDisplayed(Map<String, String> map) {
        Map<String, BaseWebElement> elementMap = currentPage.getUniqueKeyElementsMap();
        BaseWebElement LastKey = null;
        for (String key : map.keySet())
            if (key.endsWith("image") || key.endsWith("icon")) {
                Assert.assertTrue("The element is not existed: " + key, elementMap.get(key).isExisted());
            } else if (!key.equals("element name")) {

                if (false == elementMap.get(key).isVisible()) {
                    for (int i = 0; i < 10; i++) {
                        LastKey.scroll(ScrollDirection.UP, 1000L, 300);
                        if (elementMap.get(key).isVisible()) {
                            break;
                        }
                    }
                }

                System.out.println("get element: " + key);

                Assert.assertTrue("the element is not displayed: " + key, elementMap.get(key).isVisible());

                LastKey = elementMap.get(key);
                System.out.println(LastKey);

                if (StringUtils.isNotBlank(map.get(key))) {
                    Assert.assertEquals("[" + key + "] check content fail", map.get(key).trim(), elementMap.get(key).getContent().replaceAll("\n", "").trim());
                }
            }
    }


    public void assertIsDisplayed(Map<String, String> map, Integer num) {
        Map<String, BaseWebElement> elementMap = currentPage.getUniqueKeyElementsMap();
        for (String key : map.keySet()) {
            String elementKey = key;
            if (num != 1) {
                elementKey = key + (num - 1);
            }
            if (key.endsWith("image")) {
                Assert.assertTrue("The element is not existed: " + elementKey, elementMap.get(elementKey).isExisted());
            } else if (!key.equals("element name")) {
                System.out.println("get element: " + key);
                Assert.assertTrue("the element is not displayed: " + elementKey, elementMap.get(elementKey).isVisible());
                if (StringUtils.isNotBlank(map.get(key))) {
                    Assert.assertEquals("[" + key + "] check content fail", map.get(key), elementMap.get(elementKey).getContent().replaceAll("\n", ""));
                }
            }
        }
    }

    public void assertIsDisplayed(Map<String, String> map, String... excepts) {
        System.out.println("map :" + map.getClass().getSimpleName());
        if (map.getClass().toString().contains("Collections$UnmodifiableMap")) {
            Map<String, String> hashMap = new HashMap<>();
            for (String key : map.keySet()) {
                hashMap.put(key, map.get(key));
            }
            map = hashMap;
        }
        Iterator<String> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            for (String except : excepts) {
                if (key.equals(except)) {
                    iter.remove();
                }
            }
        }

        assertIsDisplayed(map);
    }

    /**
     * check number list descending order
     *
     * @param listView
     * @param idPrefix The prefix definition in the objectID of the page class.
     * @param maxIndex target index
     */
    public void checkNumberOrderByDesc(BaseWebElement listView, String idPrefix, String idSuffix, int startIndex, int maxIndex) {
        this.checkNumberOrder(listView, idPrefix, idSuffix, startIndex, maxIndex, DESC);
    }

    /**
     * check number list ascending order
     *
     * @param listView
     * @param idPrefix The prefix definition in the objectID of the page class.
     * @param maxIndex target index
     */
    public void checkNumberOrderByAsc(BaseWebElement listView, String idPrefix, String idSuffix, int startIndex, int maxIndex) {
        this.checkNumberOrder(listView, idPrefix, idSuffix, startIndex, maxIndex, ASC);
    }

    private void checkNumberOrder(BaseWebElement listView, String idPrefix, String idSuffix, int startIndex, int maxIndex, String orderBy) {
        int index = startIndex;
        java.util.List<Double> numList = new ArrayList<>();
        while (index <= maxIndex) {
            String id = idPrefix + index;
            if (idSuffix != null) {
                id = id + idSuffix;
            }
            BaseWebElement amountElement = new BaseWebElement(id);
            if (amountElement.isVisible()) {
                double itemNumber = 0;
                itemNumber = CheckUtil.getNoISOAmount(amountElement.getContent());
                numList.add(itemNumber);
                index++;
            } else {
                System.out.println("The index[" + id + "] element not display, Will be sliding.");
                if (driverConfig.getDeviceName().equals("E2353")) {
                    listView.scroll(ScrollDirection.UP, 1000L, 250);
                } else {
                    listView.scroll(ScrollDirection.UP, 1000L, 300);
                }

            }
        }
//        System.out.println("result："+numList);

        if (ASC.equals(orderBy)) {
            for (int i = 0; i < numList.size() - 1; i++) {
                if (numList.get(i) >= numList.get(i + 1)) {
                    Assert.assertTrue(false);
                }
            }
        } else {
            for (int i = 0; i < numList.size() - 1; i++) {
                if (numList.get(i) < numList.get(i + 1)) {
                    Assert.assertTrue(false);
                }
            }
        }
    }


    public String[] getDateList(BaseWebElement listView, String namePrefix, int maxIndex) {
        Map<String, BaseWebElement> elementMap = currentPage.getUniqueKeyElementsMap();
        String[] data = new String[maxIndex + 1];
        int index = 0;
        while (index <= maxIndex) {
            String name = namePrefix + "_" + index;
            if (elementMap.get(name).isVisible()) {
                data[index] = elementMap.get(name).getContent();
                index++;
            } else {
                System.out.println("element [" + name + "] not existed, Will be sliding.");
                listView.scroll(ScrollDirection.UP, 1000L, 300);
            }
        }

        return data;
    }

    public String[] getDateListByObjectId(BaseWebElement listView, String idPrefix, String idSuffix, int maxIndex) {
        Map<String, BaseWebElement> elementMap = currentPage.getUniqueKeyElementsMap();
        String[] data = new String[maxIndex + 1];
        int index = 0;
        while (index <= maxIndex) {
            String id = idPrefix + index;
            if (idSuffix != null) {
                id = id + idSuffix;
            }
            BaseWebElement amountElement;
            amountElement = new BaseWebElement(id);
            if (amountElement.isVisible()) {
                data[index] = amountElement.getContent();
                index++;
            } else {
                System.out.println("element [" + id + "] not existed, Will be sliding.");
                listView.scroll(ScrollDirection.UP, 1000L, 300);
            }
        }

        return data;
    }


    public void swipeScreen(ScrollDirection scrollDirection) {
        JavascriptExecutor js = driverConfig.getDriver();
        HashMap<String, String> swipeObject = new HashMap<String, String>();
        String direction = "";
        if (ScrollDirection.UP.equals(scrollDirection)) {
            direction = "up";
        } else if (ScrollDirection.DOWN.equals(scrollDirection)) {
            direction = "down";
        } else if (ScrollDirection.LEFT.equals(scrollDirection)) {
            direction = "left";
        } else if (ScrollDirection.RIGHT.equals(scrollDirection)) {
            direction = "right";
        }
        swipeObject.put("direction", direction);
        js.executeScript("mobile: swipe", swipeObject);
    }
}