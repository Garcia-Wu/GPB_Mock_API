package com.gt.projects.bdd.hsbc_gbm.flow;

import com.gt.projects.bdd.base.BaseFlow;
import com.gt.projects.bdd.base.BaseWebElement;
import com.gt.projects.bdd.base.enums.ScrollDirection;
import com.gt.projects.bdd.hsbc_gbm.page.AllocationListPage;
import com.gt.projects.bdd.hsbc_gbm.util.CheckUtil;
import com.gt.projects.bdd.hsbc_gbm.util.UserProfile;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import com.gt.projects.bdd.hsbc_gbm.util.UserProfileUtil;
import org.junit.Assert;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope("thread")
public class AllocationListFlow extends BaseFlow<AllocationListPage> {

    protected AllocationListFlow(AllocationListPage currentPage) {
        super(currentPage);
    }

    private Map<String, String> elementState = new HashMap<>();

    public void tapOnParticularKey() {
//        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
//        BaseWebElement key = new BaseWebElement("allocation_list_tablecell_view_" + (num-1));
//        key.click();
        currentPage.getAllocationListView0().click();
    }

    public void checkAllocationListViewPage() {
        sleep(500L);
        captureScreen();
        Assert.assertTrue(currentPage.getAllocationListGraphicView0().isVisible());
    }

    public void checkPositiveAllocationListUI(Map<String,String> map) {
        sleep(300L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        if (map.get("Total Asset value") == "0.00"){
            Assert.assertEquals("0.00",CheckUtil.getAmount(new BaseWebElement("allocation_list_tablecell_amount_label_" + (num-1)).getContent()));
        }
        currentPage.getAllocationListTableView().scrollToItem(new BaseWebElement("allocation_list_tablecell_amount_label_" + (num-1)),ScrollDirection.UP);
        Assert.assertTrue(new BaseWebElement("allocation_list_tablecell_name_label_" + (num-1)).isVisible());
        Assert.assertTrue(new BaseWebElement("allocation_list_tablecell_amount_label_" + (num-1)).isVisible());
        Assert.assertTrue(new BaseWebElement("allocation_list_tablecell_weight_label_" + (num-1)).isExisted());
        Assert.assertTrue(new BaseWebElement("allocation_list_tablecell_weight_label_" + (num-1)).getContent().endsWith("%"));
    }

    public void onTheAllocationList() {
        Assert.assertTrue(currentPage.getAllocationListGraphicView0().isVisible());
    }

    public void checkAllocationListWrapperUI(Map<String,String> map) {
        sleep(300L);
        captureScreen();
        this.allocationListWrapperUI(map);
    }

    public void allocationListWrapperUI(Map<String, String> map){
        Map<String, BaseWebElement> elementMap = currentPage.getUniqueKeyElementsMap();
        for (String key : map.keySet()) {
            System.out.println("get element: "+key);
            Assert.assertTrue("The element is not existed: " + key, elementMap.get(key).isExisted());

            if(StringUtils.isNotBlank(map.get(key))){
                Assert.assertEquals("[" + key + "] check content fail", map.get(key).trim(), elementMap.get(key).getContent().replaceAll("\n","").trim());
            }
        }
    }

    public void checkBaseCurrencyFormat() {
        sleep(300L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement amount = new BaseWebElement("allocation_list_tablecell_amount_label_" + (num-1));
        CheckUtil.checkDataFormat(CheckUtil.getAmount(amount.getContent()));
        CheckUtil.checkCurrencyISO3(amount);
        CheckUtil.check2dp(CheckUtil.getAmount(amount.getContent()));
    }

    public void checkPercentageFormat() {
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement amount = new BaseWebElement("allocation_list_tablecell_weight_label_" + (num-1));
        CheckUtil.check2dp(amount.getContent().replaceAll("%",""));
    }

    public void checkWrapperTotalAssetsValueFormat() {
        CheckUtil.checkDataFormat(currentPage.getTotalAssertValue().getContent());
        CheckUtil.check2dp(CheckUtil.getAmount(currentPage.getTotalAssertValue().getContent()));
    }

    public void checkNoAllocationList() {
        sleep(300L);
        captureScreen();
        Assert.assertFalse(currentPage.getAllocationListGraphicView0().isVisible());
    }

    public void checkNoAllocationListCopyMessage(Map<String,String> map) {
        this.assertIsDisplayed(map);
    }

    public void checkLaberNameOthers(String name) {
        sleep(500L);
        captureScreen();
        BaseWebElement nameElement = new BaseWebElement("allocation_list_tablecell_name_label_7");
        currentPage.getAllocationListTableView().scrollToItem(nameElement,ScrollDirection.UP);
        Assert.assertEquals(name,nameElement.getContent());
    }

    public void checkRegionsListOrder() {
        Integer num = UserProfileUtil.getCurrentUserProfile().getTotalNum();
        String amountId = "allocation_list_tablecell_amount_label_";
        BaseWebElement baseWebElement = null;
        Double[] positive = new Double[num];
        Double[] negative = new Double[num];
        int negativeNum = 0;
        for (int i = 0; i < num; i++){
            baseWebElement = new BaseWebElement(amountId+i);
            currentPage.getAllocationListTableView().scrollToItem(baseWebElement,ScrollDirection.UP);
            if (baseWebElement.getContent().startsWith("-")){
                negative[i] = CheckUtil.getNoISOAmount(baseWebElement.getContent());
                negativeNum = negativeNum + 1;
            }else {
                positive[i] = CheckUtil.getNoISOAmount(baseWebElement.getContent());
            }
        }

        for (int i = 0; i < num - 2; i++){

           if (positive[i+1]!= null){

               Assert.assertTrue("The two data in the wrong order are:"+positive[i]+" and "+positive[i+1],positive[i] >= positive[i+1]);
           }else if(positive[i]!= null && positive[i+1] == null){
               Assert.assertTrue("The two data in the wrong order are:"+positive[i]+" and "+negative[i+1],positive[i] >= negative[i+1]);
           }else{
               Assert.assertTrue("The two data in the wrong order are: "+negative[i]+" and "+negative[i+1],negative[i] <= negative[i+1]);
           }
        }
    }

    public void checkAllocationListWrapperChange() {
        sleep(500L);
        captureScreen();
        Assert.assertNotEquals(elementState.get("accountName"),currentPage.getAccountName().getContent());
        Assert.assertNotEquals(elementState.get("amount"),currentPage.getAllocationListPercentage0().getContent());
   }

    public void swipeLeftOnAllocationListWrapper() {
        elementState.put("accountName",currentPage.getAccountName().getContent());
        elementState.put("amount",currentPage.getAllocationListPercentage0().getContent());
        currentPage.getAllocationListTableView().scroll(ScrollDirection.LEFT,500L);
    }

    public void swipeLeftOnAllocationList() {
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        elementState.put("listAmount",new BaseWebElement("allocation_list_tablecell_amount_label_"+(num-1)).getContent());
        currentPage.getAllocationListTableView().scroll(ScrollDirection.LEFT,500L);
    }

    public void checkAllocationListChange() {
        sleep(500L);
        captureScreen();
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        Assert.assertNotEquals(elementState.get("listAmount"),new BaseWebElement("allocation_list_tablecell_amount_label_"+(num-1)).getContent());
    }

    public void tapParticularAssetInAllocationList() {
        Integer num = UserProfileUtil.getCurrentUserProfile().getFinalListNum();
        BaseWebElement allocationList = new BaseWebElement("allocation_list_tablecell_pie_chart_view_"+(num-1));
        currentPage.getAllocationListTableView().scrollToItem(allocationList,ScrollDirection.UP);
        allocationList.click();
    }
}
