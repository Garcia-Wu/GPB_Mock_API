package com.gt.projects.bdd.hsbc_gbm.util;

import lombok.Data;

@Data
public class UserProfile {

    private String type;
    private String userName;
    private String password;
    private Integer customerId;
    private Integer accountNum;
    private Integer portfolioNum;
    private Integer screenLevel;

    /**
     * Allocation
     */
    private Integer classNum;
    private Integer subClassNum;
    private Integer currencyNum;
    private Integer regionNum;
    private Integer allocationHoldingNum;
    private Integer subAllocationHoldingNum;

    /**
     * portfolio screen list
     */
    private Integer holdingNum;
    private Integer transactionNum;
    private Integer liabilitiesNum;
    private Integer subLiabilitiesNum;

    private Integer finalListNum;

    private Integer totalNum;

    private Integer subClassTypeNum;
    private Integer groupHoldingListNum;

    private Integer documentAccountNum;
    private Integer documentCategoryNum;
}
