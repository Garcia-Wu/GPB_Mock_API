@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-1757 @Sprint6_iOS
@Story_GPBM-1759 @Sprint6_aOS

Feature: Holdings by Asset Class and Sub-Asset Class at Account level

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S360-AC1-AT1
  Scenario:Check Holdings per Asset Class at Account level
    Given I login as type "account_has_allocation_class_holdings"
    Then I can see a list of holdings that they own across all of their Accounts within that Asset Class
#  ( with the following information displayed in each list item
#  https://jira-digital.systems.uk.hsbc/jira/browse/GPBM-2078）
#    And the list of holdings is ordered( based on:
#  https://jira-digital.systems.uk.hsbc/jira/browse/GPBM-2075）

  @S360-AC1-AT2
  Scenario:Check No holdings per Asset Class at Account level
    Given I login as type "account_no_class"
    When I tap on the Allocation toggle
#    When I tap Accounts Allocation toggle
    Then I should see the following UI Elements on the Accounts Class tab
      | element region | element name  | element value                                                                        |
#      | HK_SG          | class content | Exposure by Asset Class is unavailable as there are no holdings within this Account. |
      | UK             | class content | Exposure by asset class is unavailable as there are no holdings within this account. |

  @S360-AC1-AT3
  Scenario:Check Holdings per Sub-Asset Class Account level
    Given I login as type "account_has_allocation_subClass_holdings"
    Then client can see a list of holdings that they own across all of their Accounts within that sub-asset class
#  ,(with the following information displayed in each list item:
#  https://jira-digital.systems.uk.hsbc/jira/browse/GPBM-2078）
#    And the list of holdings is ordered（ based on:
#  https://jira-digital.systems.uk.hsbc/jira/browse/GPBM-2075）
