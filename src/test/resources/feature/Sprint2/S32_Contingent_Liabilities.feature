@HK @SG @UK
@Epic_GPBM-458(Contingent_Liabilities)
@Story_GPBM-577 @Sprint2_iOS
@Story_GPBM-1053 @Sprint2_aOS

Feature: Access to Contingent Liabilities within a Portfolio

  As a client I want to be able to access information regarding my commitments to invest in Private
  Equity or Real Estate funds within each Portfolio I own, so that I understand my Contingent Liabilities

  @S32-AC1-AT1
  Scenario:Check the Contingent Liabilities Screen UI
    Given I login as User
      | element name | element value |
      | Name         | userE         |
      | Password     | 123           |
    When I tap first item of Accounts list
    And I tap first item of Portfolios list
    And I tap on the Contingent Liabilities tab
    Then I should see the following Ui Elements on the Contingent Liabilities Screen
      | element name                      | element value |
      | Back button                       |               |
      | Contingent Liabilities            |               |
      | Total Commitments Remaining       |               |
      | info icon                         |               |
      | Total commitments remaining value |               |
      | currency label                    |               |

  @S32-AC1-AT3
  @DependsOn('Check_the_Contingent_Liabilities_Screen_UI')
  Scenario: Check the Total assets value format for 2dp
    Given I am on the Contingent Liabilities Overlay Screen
    Then I should see the Total commitments remaining will be shown to 2 decimal places

  @S32-AC1-AT4
  @DependsOn('Check_the_Contingent_Liabilities_Screen_UI')
  Scenario: Check the Total assets value format for ISO 3
    Given I am on the Contingent Liabilities Screen
    Then I should see that ISO 3 code of reporting currency for the Portfolio

  @S32-AC1-AT2
  @DependsOn('Check_the_Contingent_Liabilities_Screen_UI')
  Scenario: Check the Overlay at Portfolio Contingent Liabilities Level
    Given I am on the Contingent Liabilities Screen
    When I tap Total Commitments Remaining value
    Then I should see the following UI Elements on the Contingent Liabilities Overlay



