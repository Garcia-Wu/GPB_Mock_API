@NotAutomatable
# Reason：This function has been modified in sprint14 or sprint15
@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-319 @Sprint1_iOS
@Story_GPBM-725 @Sprint1_aOS

Feature: View asset currency breakdown at Overview level

  As a client I want to view a summary of my assets grouped by currency,
  so that I know which currencies my assets were purchased in

  userD: not invested in class user
  userE: invested in securities purchased in <9 currencies;
  userF: invested in securities purchased in >8 currencies.

  Scenario: login userE for GPBM319
    Given I login as type "overview_currency_list_less_than_9"
    When I tap on the Allocation toggle
    And I tap on Currency tab
    Then I should on the Overview screen

  @S4-AC1-AT1
  @DependsOn('login_userE_for_GPBM319')
  Scenario: Check the Overview Currency UI when <9 currencies.
    Given I am on the Overview screen
    Then I should see the following components when the currency tab is active:
      | element region | element name             | element value |
      |                | Greeting message         |               |
      |                | Country                  |               |
      |                | Total assets title       | Total assets  |
#      | Total assets icon        |               |
      |                | Total assets amount      |               |
#      | Total assets currency    |               |
      |                | Allocation button active |               |
      |                | Class Tab                | Class         |
      |                | Currency Tab             | Currency      |
      | UK             | Region Tab               | Region        |
    And I should see the Card list of different asset currency

  @S4-AC1-AT2
  @DependsOn('login_userE_for_GPBM319')
  Scenario: Check the status of Allocation $ Currency when securities purchased in <9 currencies.
    Given I am on the Overview screen
    Then I should see the following states when tap Currency Tab
      | element name      | states |
      | Allocation Toggle | active |
      | Currency Tab      | active |

  @S4-AC1-AT3
  @DependsOn('login_userE_for_GPBM319')
  Scenario: Check the data of each asset Currency they are invested in.
    Given I am on the Overview screen
    Then I should see the currency name
    And currency item Total asset value in reporting currency (ISO 3 format) selected to 2 d.p.
    And currency item Total asset value as a % of all assets owned to 2 d.p.

  @NotAutomatable
  Scenario: Check the horizontal bar.
    Given I am on the Overview level screen
    Then I should see a horizontal bar reflecting the % of all assets owned
  # S4-AC1-AT4
  # Reason: cannot check the bar

  @S4-AC1-AT5
  @DependsOn('login_userE_for_GPBM319')
  Scenario: Check the sequence of the Currency By Total Assets.
    Given I am on the Overview screen
    Then I should see the currencies are ordered by Total Asset value - largest to smallest

  Scenario: login userF for GPBM319
    Given I login as type "overview_currency_list_greater_than_8"
    When I tap on the Allocation toggle
    And I tap on Currency tab
    Then I should on the Overview screen

  @S4-AC1-AT6
  @DependsOn('login_userF_for_GPBM319')
  Scenario: Check the Overview Currency UI when >8 currencies.
    Given I am on the Overview screen
    Then I should see the following components when the currency tab is active:
      | element region | element name             | element value |
      |                | Greeting message         |               |
      |                | Total assets title       | Total assets  |
#      | Total assets icon        |               |
      |                | Total assets amount      |               |
#      | Total assets currency    |               |
      |                | Allocation button active |               |
      |                | Class Tab                | Class         |
      |                | Currency Tab             | Currency      |
      | UK             | Region Tab               | Region        |
    And I should see the Card list of different asset currency

  @S4-AC1-AT7
  @DependsOn('login_userF_for_GPBM319')
  Scenario: Check the status of Allocation $ Currency when securities purchased in >8 currencies.
    Given I am on the Overview screen
    Then I should see the following states when tap Currency Tab
      | element name      | states |
      | Allocation Toggle | active |
      | Currency Tab      | active |


  @S4-AC1-AT8
  @DependsOn('Check_the_Overview_Currency_UI_when_>8_currencies.')
  Scenario: Check the data of each asset Currency they are invested in when securities purchased in >8 currencies.
    Given I am on the Overview screen
    When I scroll down to the bottom
    Then I should see the Grouping label of "Other"
    And Grouping "Other" Total asset value in reporting currency (ISO 3 format) selected to 2 d.p.
    And Grouping "Other" Total asset value as a % of all assets owned to 2 d.p.

  @NotAutomatable
  Scenario: Check the horizontal bar at Currency Tab under Overview Level Screen.
    When dummy
  # S4-AC1-AT9
  # Reason: cannot check the bar

  @S4-AC1-AT10
  @DependsOn('Check_the_Overview_Currency_UI_when_>8_currencies.')
  Scenario: Check whether the "Other" category is on the bottom at Currency Tab under Overview Level Screen.
    Given I am on the Overview screen
    When I scroll down to the bottom
    Then I should see‘Other’ category is always at the bottom of the list

  @S4-AC1-AT11
  Scenario: Check if not invested in a specific Currency.
    Given I login as type "overview_no_currency"
    When I tap on the Allocation toggle
    And I tap on Currency tab
    Then I should not see that currency listed


