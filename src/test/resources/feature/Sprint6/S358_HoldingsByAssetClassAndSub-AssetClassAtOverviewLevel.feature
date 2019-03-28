@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-1756 @Sprint6_iOS
@Story_GPBM-1758 @Sprint6_aOS

Feature: Holdings by Asset Class and Sub-Asset Class at Overview level

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S358-AC1-AT1
  Scenario:Check Holdings per Asset Class at Overview level
    Given I login as type "overview_has_allocation_class_holdings"
    Then I can see a list of holdings that they own across all of their Overview within that Asset Class
#  （ with the following information displayed in each list item https://jira-digital.systems.uk.hsbc/jira/browse/GPBM-2081）
#    And the list of holdings is ordered（ based on:
#  https://jira-digital.systems.uk.hsbc/jira/browse/GPBM-2075）

  @S358-AC1-AT2
  Scenario:Check No holdings per Asset Class at Overview level
    Given I login as type "overview_no_class"
    When I tap on the Allocation toggle
    Then I should see the following UI Elements on the Overview Class tab
      | element region | element name  | element value                                                                           |
#      | HK_SG          | class content | Exposure by Asset Class is unavailable as there are no holdings within your Account(s). |
      | UK             | class content | Exposure by asset class unavailable as you have no holdings in your account(s). |


  @S358-AC1-AT3
  Scenario:Check Holdings per Sub-Asset Class at Overview level
    Given I login as type "overview_has_allocation_subClass_holdings"
    Then I can see a list of holdings that they own across all of their Overview within that sub-asset class
#  （with the following information displayed in each list item:
#  https://jira-digital.systems.uk.hsbc/jira/browse/GPBM-2078）
#    And the list of holdings is ordered（ based on:
#  https://jira-digital.systems.uk.hsbc/jira/browse/GPBM-2075）
