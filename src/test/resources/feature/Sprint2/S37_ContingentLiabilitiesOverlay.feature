@HK @SG @UK
@Epic_GTMB-458(Contingent_Liabilities)
@Story_GTMB-603 @Sprint2_iOS
@Story_GTMB-1063 @Sprint2_aOS

Feature: Contingent Liabilities Overlay

  As a client I want to understand what "Total Remaining Commitments" means and how this figure is calculated when viewing my Contingent Liabilities,
  so that I am not confused by the information displayed

  @S37-AC1-AT1
  Scenario: Check the Contingent Liabilities Overlay UI
    Given I login as User
      | element name | element value |
      | Name         | userE         |
      | Password     | 123           |
    When I tap first item of Accounts list
    And I tap first item of Portfolios list
    And I tap on the Contingent Liabilities tab
    And I tap Total Commitments Remaining value
    Then I should see the following UI Elements on the Contingent Liabilities Overlay Level
      | element name                     | element value               |
      | Total commitment remaining label | Total commitments remaining |
      | Portfolio name                   |                             |
      | Total Remaining Commitment       |                             |
      | How is this calculated label     | How is this calculated?     |

  @S37-AC1-AT2
  @DependsOn('Check_the_Contingent_Liabilities_Overlay_UI')
  Scenario: Check whether the Contingent Liabilities Overlay can be closed with taps on X button
    Given I am on the Contingent Liabilities Overlay Screen
    When I tap on Contingent Liabilities Overlay close button
    Then I should see the initial list view of their Contingent Liabilities within the Portfolio

  @S37-AC1-AT3
  @DependsOn('Check_the_Contingent_Liabilities_Overlay_UI')
  Scenario: Check whether the Contingent Liabilities Overlay can be closed with taps anywhere on the screen outside
    Given I am on the Contingent Liabilities Overlay Screen
    When I tap Total Commitments Remaining value
    And I tap anywhere on the screen outside of the pop up overlay
    Then I should see the initial list view of their Contingent Liabilities within the Portfolio

