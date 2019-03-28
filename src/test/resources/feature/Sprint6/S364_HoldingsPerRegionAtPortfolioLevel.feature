@UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-1762 @Sprint6_iOS
@Story_GPBM-1763 @Sprint6_aOS

Feature: Holdings per Region at Portfolio level

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S364-AC1-AT1
  Scenario:Check Holdings per Region at Portfolio level
    Given I login as type "portfolio_has_allocation_region_holdings"
    Then I can see a list of holdings that they own within that Region for that Portfolio
#  , with the following information displayed in each list item:
#  https://jira-digital.systems.uk.hsbc/jira/browse/GPBM-1742

  @S364-AC1-AT2
  Scenario:Check No holdings per Region at Portfolio level
    Given I login as type "portfolio_no_region"
    When I tap on the Allocation toggle
    And I tap Portfolio Region tab
    Then I should see the following UI Elements on the Portfolio Region tab
      | element region | element name   | element value                                                                     |
#      | HK_SG          | region content | Exposure by Region is unavailable as there are no holdings within this Portfolio. |
      | UK             | region content | Exposure by region unavailable as there are no holdings in your portfolio. |