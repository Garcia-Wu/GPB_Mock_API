@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-1769 @Sprint6_iOS
@Story_GPBM-1771 @Sprint6_aOS

Feature: Holdings per Currency at Overview level

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S370-AC1-AT1
  Scenario:Check Holdings per Currency at Overview level
    Given I login as type "overview_has_allocation_currency_holdings"
    Then I can see a list of holdings that they own in that currency across all of their Overview
#  (with the following information displayed in each list item:
#  https://jira-digital.systems.uk.hsbc/jira/browse/GPBM-2081
#    And the list of holdings is ordered (based on:
#  https://jira-digital.systems.uk.hsbc/jira/browse/GPBM-2075 )

  @S370-AC1-AT2
  Scenario:Check No holdings per Currency at Overview level
    Given I login as type "overview_no_currency"
    When I tap Asset Overview Allocation toggle
    And I tap Overview Currency tab
    Then I should see the following UI Elements on the Overview Currency tab
      | element region | element name     | element value                                                                        |
#      | HK_SG          | currency content | Exposure by Currency is unavailable as there are no holdings within your Account(s). |
      | UK             | currency content | Exposure by asset class unavailable as you have no holdings in your account(s). |
