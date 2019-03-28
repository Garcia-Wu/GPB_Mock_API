@UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-1767 @Sprint6_iOS
@Story_GPBM-1768 @Sprint6_aOS

Feature: Holdings per Region at Overview level

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S368-AC1-AT1
  Scenario:Check Holdings per Region at Overview level
    Given I login as type "overview_has_allocation_region_holdings"
    Then I can see a list of holdings that they own within that Region across all of their Overview
#  (with the following information displayed in each list item:
#  https://jira-digital.systems.uk.hsbc/jira/browse/GPBM-2081)
#  And the list of holdings is ordered( based on:
#  https://jira-digital.systems.uk.hsbc/jira/browse/GPBM-2075)

  @S368-AC1-AT2
  Scenario:Check No holdings per Region at Overview level
    Given I login as type "overview_no_region"
    When I tap on the Allocation toggle
    And I tap Overview Region tab
    Then I should see the following UI Elements on the Overview Region tab
      | element region | element name   | element value                                                                      |
#      | HK_SG          | region content | Exposure by Region is unavailable as there are no holdings within your Account(s). |
      | UK             | region content | Exposure by region unavailable as you have no holdings in your account(s). |