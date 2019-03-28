@UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-1764 @Sprint6_iOS
@Story_GPBM-1765 @Sprint6_aOS

Feature: Holdings per Region at Account level

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S366-AC1-AT1
  Scenario:Check Holdings per Region at Account level
  Given I login as type "account_has_allocation_region_holdings"
    Then I can see a list of holdings that they own within that Region for that Account
#  ( with the following information displayed in each list item:
#  https://jira-digital.systems.uk.hsbc/jira/browse/GPBM-2078)
#  And the list of holdings is ordered( based on:
#  https://jira-digital.systems.uk.hsbc/jira/browse/GPBM-2075)

  @S366-AC1-AT2
  Scenario:Check No holdings per Region at Account level
    Given I login as type "account_no_region"
    When I tap Accounts Allocation toggle
    And I tap Allocation Region tab
    Then I should see the following UI Elements on the Accounts Region tab
      | element region | element name   | element value                                                                   |
#      | HK_SG          | region content | Exposure by Region is unavailable as there are no holdings within this Account. |
      | UK             | region content | Exposure by region is unavailable as there are no holdings within this account. |