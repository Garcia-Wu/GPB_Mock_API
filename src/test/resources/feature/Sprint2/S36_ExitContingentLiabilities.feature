@HK @SG @UK
@Epic_GTMB-458(Contingent_Liabilities)
@Story_GTMB-592 @Sprint2_iOS
@Story_GTMB-1061 @Sprint2_aOS

Feature: Exiting initial list view of Contingent Liabilities

  As a client I want to be able to exit the list view of my Contingent Liabilities within a portfolio,
  so that I can return to the holdings OR transactions list that I was viewing before I tapped on the Contingents Liabilities tab

  @S36-AC1-AT1
  Scenario: Check the Portfolio Contingent Liabilities lists
    Given I login as User
      | element name | element value |
      | Name         | userE         |
      | Password     | 123           |
    When I tap first item of Accounts list
    And I tap first item of Portfolios list
    And I tap on the Contingent Liabilities tab
    And I scroll next page
    And I save control state on Contingent Liabilities screen
    And I tap eight item of Contingent Liabilities list
    And I tap Back button of detail
    Then I should see the eight item on the Contingent Liabilities list




