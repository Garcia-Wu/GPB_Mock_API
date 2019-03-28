@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-1775 @Sprint6_iOS
@Story_GPBM-1776 @Sprint6_aOS

Feature: Holdings per Currency at Portfolio level

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S375-AC1-AT1
  Scenario:Check Holdings per Currency at Portfolio level
    Given I login as type "portfolio_has_allocation_currency_holdings"
    Then I can see a list of holdings that they own in that currency for that Portfolio
#  , with the following information displayed in each list item:
#  https://jira-digital.systems.uk.hsbc/jira/browse/GPBM-1864

  @S375-AC1-AT2
  Scenario:Check No holdings per Currency at Portfolio level
    Given I login as type "portfolio_no_currency"
    When I tap on the Allocation toggle
    And I tap Portfolio Currency tab
    Then I should see the following UI Elements on the Portfolio Currency tab
      | element region | element name     | element value                                                                       |
#      | HK_SG          | currency content | Exposure by Currency is unavailable as there are no holdings within this Portfolio. |
      | UK             | currency content | Exposure by currency is unavailable as there are no holdings within this portfolio. |