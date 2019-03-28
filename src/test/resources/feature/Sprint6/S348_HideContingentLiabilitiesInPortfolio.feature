@HK @SG @UK
@Epic_GPBM-458(Contingent_Liabilities)
@Story_GPBM-2050 @Sprint6_iOS
@Story_GPBM-2051 @Sprint6_aOS

Feature: Hide Contingent Liabilities in Portfolio

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S348-AC1-AT1
  Scenario:Check whether Contingent Liabilities has been hide when Finantix can not provide data
    Given I login as type "portfolio_has_holdings"
    Then I should NOT see the Contingent Liabilities component below "Holdings" and "Transactions" components