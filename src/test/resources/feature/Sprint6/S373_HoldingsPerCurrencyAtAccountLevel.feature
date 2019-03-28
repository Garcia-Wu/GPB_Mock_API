@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-1772 @Sprint6_iOS
@Story_GPBM-1773 @Sprint6_aOS

Feature: Holdings per Currency at Account level

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S373-AC1-AT1
  Scenario:Check Holdings per Currency at Account level
    Given I login as type "account_has_allocation_currency_holdings"
    Then client can see a list of holdings that they own in that currency for that Account
#  , with the following information displayed in each list item:
#  https://jira-digital.systems.uk.hsbc/jira/browse/GPBM-2078
#    And the list of holdings is ordered based on:
#  https://jira-digital.systems.uk.hsbc/jira/browse/GPBM-2075

  @S373-AC1-AT2
  Scenario:Check No holdings per  Currency  at Account level
    Given I login as type "account_no_currency"
    When I tap Accounts Allocation toggle
    And I tap Allocation Currency tab
    Then I should see the following UI Elements on the Accounts Currency tab
      | element region | element name     | element value                                                                     |
#      | HK_SG          | currency content | Exposure by Currency is unavailable as there are no holdings within this Account. |
      | UK             | currency content | Exposure by asset class unavailable as there are no holdings in your account. |