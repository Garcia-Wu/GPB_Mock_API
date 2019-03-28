package com.gt.projects.bdd.hsbc_gbm.util;

import com.gt.projects.bdd.base.BaseWebElement;
import com.gt.projects.bdd.base.config.DriverConfig;
import com.gt.projects.bdd.base.enums.Platform;
import com.gt.projects.bdd.base.utils.BeanUtils;
import com.gt.projects.bdd.hsbc_gbm.page.AllocationHoldingListPage;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.testng.reporters.jq.Main;

import javax.xml.crypto.Data;
import java.text.Collator;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckUtil {

    private static String[] monthArray = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    // 10 Aug 2018
    private static String dateRegex = "^(0?[1-9]|[12][0-9]|3[01])[ ](Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)[ ](\\d+)$";
    // 10 Aug 2018, 02:31
    private static String currencyDateRegex = "^(0?[1-9]|[12][0-9]|3[01])[ ](Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)[ ](\\d+)[,][ ]([0-1][0-9]|[2][0-3])[:][0-5][0-9]$";

    // 9 Aug 2018  (day must < 10)
    private static String oneDayRegex = "^[1-9][ ](January|February|March|April|May|June|July|August|September|October|November|December)[ ](\\d+)$";
    // 11 Aug 2018  (day must > 9)
    private static String twoDayRegex = "^([12][0-9]|3[01])[ ](January|February|March|April|May|June|July|August|September|October|November|December)[ ](\\d+)$";

    // 正负均有符号的amount
    public static void checkWrapperPerformanceISO3Format(String str) {
        Pattern p = Pattern.compile("(^[-|+]{1}?[1-9]\\d{0,2}($|(\\,\\d{3})*($|(\\.\\d{1,2}$))))|((^[0](\\.\\d{1,2})?)|(^[-][0]\\.\\d{1,2}))$");
        Assert.assertTrue(p.matcher(str.replaceAll("[ |A-Z]","")).matches());
    }

    // 正数没有+号的amount
    public static void checkDataFormat(String str) {
        Pattern p = Pattern.compile("(^[-]?[1-9]\\d{0,2}($|(\\,\\d{3})*($|(\\.\\d{1,2}$))))|((^[0](\\.\\d{1,2})?)|(^[-][0]\\.\\d{1,2}))$");
        Assert.assertTrue(p.matcher(str.replaceAll("[ |A-Z]","")).matches());
    }

    // 正数没有+号的amount，可能有括号跟 * 号
    public static void checkDetailDateFormat(String str) {
        Pattern p = Pattern.compile("(^[-]?[1-9]\\d{0,2}($|(\\,\\d{3})*($|(\\.\\d{1,2}$))))|((^[0](\\.\\d{1,2})?)|(^[-][0]\\.\\d{1,2}))$");
        Assert.assertTrue(p.matcher(str.replaceAll("[ |A-Z|\\*|\\(|\\)]", "")).matches());
    }

    public static boolean check2dpCurrency(String str) {
        if (str.contains(" ")) {
            str = str.replace("", " ").replaceAll("[ |A-Z]","");
        }
        String[] split1 = str.split("\\.");
        Pattern p = Pattern.compile("[0-9]{2}");
        return p.matcher(split1[1]).matches();
    }

    public static Double stringToDouble(String string) {
        String replaceAll = string.trim().replaceAll(",", "");
        return Double.valueOf(replaceAll);
    }

    public static Double getTotalAssetNum(String totalAsset) {
        String result = getAmount(totalAsset);
        return stringToDouble(result);
    }

    public static boolean check2Number(String number) {
        if (number.matches("^\\d{2}$")) {
            return true;
        }
        return false;
    }

    public static boolean check4Number(String number) {
        if (number.matches("^\\d{4}$")) {
            return true;
        }
        return false;
    }

//    public static boolean checkISO3(String str) {
//
//        if (str.contains("-")) {
//            str = str.replaceAll("-", "");
//        }
//        String[] split = str.trim().split("\\.");
//        String[] split1 = split[0].split(",");
//        if (split1[0].length() > 3) {
//            return false;
//        }
//
//        if (split1.length > 1) {
//            for (int i = 1; i < split1.length; i++) {
//                if (split1[i].length() == 3) {
//                    continue;
//                } else {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    public static void assertCheckISO3(String number) {
//        String amount = getAmount(number);
//        Assert.assertTrue("ISO3 format error! number: " + amount, checkISO3(amount));
//    }

    public static boolean checkISO3Inarentheses(String str) {
        String[] split = str.trim().split("\\.");
        String[] split1 = split[0].split(",");

        if (split1.length > 1) {
            for (int i = 1; i < split1.length; i++) {
                if (split1[i].length() == 3) {
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void checkTotalAmount(String str) {
        String data = getAmount(str);
        check2dp(data);
        checkDataFormat(data);
    }

    public static void checkPercentage(String str) {
        checkLastPercentage(str);
        String data = str.substring(0, str.indexOf("%")).trim();
        check2dp(data);
    }

    public static void checkLastPercentage(String string) {
        if (!string.trim().endsWith("%")) {
            Assert.assertTrue("The item is not the Percentage! [" + string + "]", false);
        }
    }

    public static void checkPercentage2dp(String string) {
        String substring = string.trim().substring(0, string.length() - 1);
        String[] split = substring.split("\\.");
        Assert.assertTrue("The Percentage is not format to 2dp! [" + string + "]", split[1].length() == 2);
    }

    public static void check2dp(String string) {
        if (string.contains(" ")) {
            string = string.replace("", " ").replaceAll("[ |A-Z]","");
        }
        String[] split = string.trim().split("\\.");
        Pattern p = Pattern.compile("[0-9]{2}");
        Assert.assertTrue("The item format 2dp error! [" + string + "]", p.matcher(split[1]).matches());
    }


    public static boolean checkMonth(String month) {
        if (month == null) {
            return false;
        }
        for (int i = 0; i < monthArray.length; i++) {
            if (monthArray[i].equals(month)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkMonthFormat(String month) {
        String[] split = month.split(" ");
        boolean check2Number = check2Number(split[0]);
        boolean checkMonth = checkMonth(split[1]);
        boolean check4Number = check4Number(split[2]);
        if (check2Number && checkMonth && check4Number) {
            return true;
        }
        return false;
    }

    public static long dateToLong(String date) {
        return new Date(date).getTime();
    }

    public static boolean orderedByDate(ArrayList<String> monthList) {
        if (monthList == null && monthList.size() > 2) {
            return false;
        }
        List<Long> monArray = new ArrayList<>();
        for (int i = 0; i < monthList.size(); i++) {
            monArray.add(dateToLong(monthList.get(i)));
        }

        for (int y = 0; y < monArray.size() - 2; y++) {
            if (monArray.get(y) >= monArray.get(y + 1)) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public static String checkHeadTitle(String head) {
        String[] split = head.split(":");
        return split[1].trim();
    }

    public static boolean checkAlphabetOrderByASC(List<String> stringList) {
        List<String> orderList = new ArrayList<>();
        orderList.addAll(stringList);
        Comparator<Object> com = Collator.getInstance(Locale.ENGLISH);
        Collections.sort(orderList, com);
        return stringList.equals(orderList);
//        Assert.assertTrue("AlphabetOrderByASC error!",stringList.equals(orderList));
    }

    public static double getNoISOAmount(String amount) {
        amount = amount.replace("  ", " ").replace("%", "").replace("+", "").replace("(", "").replaceAll(",", "");
        if (amount.contains(" ")) {
            amount = amount.substring(0, amount.indexOf(" "));
        }
        return Double.valueOf(amount.trim());
    }

    public static String getAmount(String amount) {
        amount = amount.replace("  ", " ").replace("%", "").replace("+", "").replace("(", "").trim();
        if (amount.contains(" ")) {
            amount = amount.substring(0, amount.indexOf(" "));
        }
        return amount.trim();
    }

    public static void checkSimpleMonthDateFormat(String date) {
        Assert.assertTrue("This date format error: " + date, date.matches(dateRegex));
    }

    public static void checkOneDayFormat(String date) {
        Assert.assertTrue("This date format error: " + date, date.matches(oneDayRegex));
    }

    public static void checkTwoDayFormat(String date) {
        Assert.assertTrue("This date format error: " + date, date.matches(twoDayRegex));
    }

    public static void checkNumber4DP(String number) {
        int dpLength = number.substring(number.indexOf(".") + 1).length();
        Assert.assertTrue("The Number not shown to 4 decimal places: " + number, dpLength == 4);
    }

    public static void checkStringISO3(String currency) {
        Assert.assertTrue("currency length error! currency is " + currency, currency.length() == 3);
        for (int i = 0; i < currency.length(); i++) {
            Assert.assertTrue("currency uppercase check error! currency is " + currency, Character.isUpperCase(currency.charAt(i)));
        }
    }

    public static void checkCurrencyDateFormat(String date) {
        Assert.assertTrue("This date format error: " + date, date.matches(currencyDateRegex));
    }

    public static String getCurrency(String amount) {
        amount = amount.replaceAll("[0-9()*-/+,/. ]", "");
        return amount;
    }

    public static void checkAllocationHoldingUI(Map<String, String> map, AllocationHoldingListPage allocationHoldingListPage) {
        Map<String, BaseWebElement> elementMap = allocationHoldingListPage.getUniqueKeyElementsMap();
        for (String key : map.keySet()) {
            if (!key.equals("element name")) {
                System.out.println("get element: " + key);

                Assert.assertTrue("the element is not displayed: " + key, elementMap.get(key).isVisible());
                if (StringUtils.isNotBlank(map.get(key))) {
                    Assert.assertEquals("[" + key + "] check content fail", map.get(key), elementMap.get(key).getContent().replaceAll("\n", "").trim());
                }
            }
        }
    }

    public static void checkCurrencyISO3(BaseWebElement amount, BaseWebElement currency) {
        String strCurrency = getAmountCurrency(amount, currency);
        checkStringISO3(strCurrency.trim());
    }

    public static String getAmountCurrency(BaseWebElement amount, BaseWebElement currency) {
        String strCurrency;
        DriverConfig driverConfig = BeanUtils.autowire(DriverConfig.class);
        if (driverConfig.getPlatform().equals(Platform.IOS)) {
            strCurrency = getCurrency(amount.getContent());
        } else {
            strCurrency = currency.getContent();
        }
        return strCurrency;
    }

    public static void checkCurrencyISO3(BaseWebElement amount) {
        String strCurrency = getAmountCurrency(amount);
        checkStringISO3(strCurrency.trim());
    }

    public static String getAmountCurrency(BaseWebElement amount) {
        String strCurrency;
        DriverConfig driverConfig = BeanUtils.autowire(DriverConfig.class);
        strCurrency = getCurrency(amount.getContent());

        return strCurrency;
    }
}
