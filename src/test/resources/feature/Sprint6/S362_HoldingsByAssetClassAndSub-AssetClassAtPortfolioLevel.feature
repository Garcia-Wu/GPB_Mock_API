@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-1760 @Sprint6_iOS
@Story_GPBM-1761 @Sprint6_aOS

Feature: Holdings by Asset Class and Sub-Asset Class at Portfolio level

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S362-AC1-AT1
  Scenario:Check Holdings per Asset Class  at Portfolio level
    Given I login as type "portfolio_has_allocation_class_holdings"
    Then I can see a list of holdings that they own within that Asset Class for that Portfolio
#  (with the following information displayed in each list item:
#  https://jira-digital.systems.uk.hsbc/jira/browse/GPBM-1742)

  @S362-AC1-AT2
  Scenario:Check No holdings per Asset Class at Portfolio level
    Given I login as type "portfolio_no_class"
    When I tap on the Allocation toggle
    Then I should see the following UI Elements on the Portfolios Class tab
      | element region | element name  | element value                                                                          |
#      | HK_SG          | class content | Exposure by Asset Class is unavailable as there are no holdings within this Portfolio. |
      | UK             | class content | Exposure by asset class unavailable as there are no holdings in your portfolio. |

  @S362-AC1-AT3
  Scenario:Check Holdings per Sub-Asset Class  Portfolio level
    Given I login as type "portfolio_has_allocation_subClass_holdings"
    Then I can see a list of holdings that they own within that sub-asset class for that Portfolio
#  ( with the following information displayed in each list item:
#  https://jira-digital.systems.uk.hsbc/jira/browse/GPBM-1742)
