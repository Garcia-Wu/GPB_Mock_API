package com.gt.projects.bdd.hsbc_gbm.flow;

import com.gt.projects.bdd.base.BaseFlow;
import com.gt.projects.bdd.base.BaseWebElement;
import com.gt.projects.bdd.base.config.DriverConfig;
import com.gt.projects.bdd.base.enums.Platform;
import com.gt.projects.bdd.base.enums.ScrollDirection;
import com.gt.projects.bdd.hsbc_gbm.page.TransactionDetailPage;
import com.gt.projects.bdd.hsbc_gbm.util.CheckUtil;
import com.gt.projects.bdd.hsbc_gbm.util.RegionUtil;
import cucumber.api.DataTable;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;

@Component
@Scope("thread")
public class TransactionsDetailFlow extends BaseFlow<TransactionDetailPage> {

    protected TransactionsDetailFlow(TransactionDetailPage currentPage) {
        super(currentPage);
    }

    @Autowired
    private DriverConfig driverConfig;

    public void TransactionsDetailsIsDisplayed(Map<String, String> map){
        Map<String, BaseWebElement> elementMap = currentPage.getUniqueKeyElementsMap();
        for (String key : map.keySet()) {
            if(!key.equals("element name")){
                System.out.println("get element: "+key);
                if(!elementMap.get(key).isVisible()){
                    currentPage.getMainSliding().scroll(ScrollDirection.UP,1000L,700);
                }
                Assert.assertTrue("the element is not displayed: " + key, elementMap.get(key).isVisible());
                if(StringUtils.isNotBlank(map.get(key))){
                    Assert.assertEquals("[" + key + "] check content fail", map.get(key), elementMap.get(key).getContent().replaceAll("\n",""));
                }
            }
        }
    }

    public void onTransactionDetail() {
        sleep(200L);
        Assert.assertTrue(currentPage.getMainTransactionBack().isVisible());
    }

    public void seeTransactionsDetail() {
        Assert.assertTrue(currentPage.getMainTransactionBack().isVisible());
    }

    public void checkTransactionUI(DataTable dataTable) {
        sleep(500L);
        captureScreen();
        this.TransactionsDetailsIsDisplayed(RegionUtil.getMap(dataTable));
    }

    public void checkTransactionCurrencyISO3SAME() {
        sleep(500L);
        captureScreen();
        Assert.assertFalse(currentPage.getMainTransactionReportCurrency().isVisible());

        if (driverConfig.getPlatform().equals(Platform.IOS)){

            CheckUtil.checkDetailDateFormat(
                    currentPage.getMainTransactionBaseAmount().getContent().substring(0, currentPage.getMainTransactionBaseAmount().getContent().indexOf(" ")).trim()
            );
        }else {

            CheckUtil.checkDetailDateFormat(
                    currentPage.getMainTransactionBaseAmount().getContent()
            );
        }
    }

    public void checkTransactionCurrencyISO3DIFFERENT() {
        sleep(500L);

        captureScreen();
        String reportCurrency = currentPage.getMainTransactionReportCurrency().getContent().replaceAll("[A-Za-z()*/-]", "");
        CheckUtil.checkDetailDateFormat(reportCurrency);

        CheckUtil.checkDetailDateFormat(CheckUtil.getAmount(
                    currentPage.getMainTransactionBaseAmount().getContent())
        );

    }

    public void checkTransactionDateFormatSettled(String date) {
        sleep(500L);
        captureScreen();
        SimpleDateFormat format = new SimpleDateFormat(date, Locale.US);
        try {
            format.parse(currentPage.getMainTransactionDate().getContent());
            format.parse(currentPage.getMainTransactionSetDate().getContent());
            Assert.assertTrue(true);

        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    public void checkTransactionDateFormatPending(String date) {
        sleep(500L);
        captureScreen();
        SimpleDateFormat format = new SimpleDateFormat(date, Locale.US);
        try {
            format.parse(currentPage.getMainTransactionDate().getContent());
            Assert.assertTrue(true);

        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    public void tapsBackButton() {
        sleep(200L);
        currentPage.getMainTransactionBack().click();
    }

    public void seeSettlementForAsia(String settleTitleValue) {
        sleep(300L);
        captureScreen();
        Assert.assertEquals(settleTitleValue, currentPage.getMainTransactionStatus().getContent());
    }

    public void checkNotSeeType() {
        Assert.assertFalse(currentPage.getMainTransactionType().isVisible());
    }

    public void checkDiscretionaryTransactionDetail() {
        sleep(300l);
        captureScreen();
        Assert.assertFalse(currentPage.getMainTransactionBack().getContent().isEmpty());
    }

    public void checkAdvisoryTransactionDetail(Map<String, String> map) {
        sleep(300l);
        captureScreen();
        Assert.assertEquals(map.get("back button label"), currentPage.getMainTransactionBack().getContent());
    }
}
