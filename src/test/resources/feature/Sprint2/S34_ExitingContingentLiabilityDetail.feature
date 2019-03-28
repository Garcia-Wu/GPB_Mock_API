@HK @SG @UK
@Epic_GPBM-458(Contingent_Liabilities)
@Story_GPBM-580 @Sprint2_iOS
@Story_GPBM-1057 @Sprint2_aOS

Feature: Exiting detailed view of a Contingent Liability

  As a client I want to be able to exit the detailed view of a Contingent Liability,
  so that I can return to the list of all Contingent Liabilities I own within one Portfolio

  @S34-AT1-AC1
  Scenario:Check whether I can exit the detail view of a Contingent Liabilities
    Given I login as User
      | element name | element value |
      | Name         | userE         |
      | Password     | 123           |
    When I tap first item of Accounts list
    And I tap first item of Portfolios list
    And I save control state on Portfolios Screen
    And I tap on the Contingent Liabilities tab
    When I tap Back button
    Then I should return to list view of all Contingent Liabilities within the Portfolio
