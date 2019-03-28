@HK
@Epic_GPBM-460(Liabilities)
@Story_GPBM-2326 @Sprint8_iOS
@Story_GPBM-2323 @Sprint8_aOS

Feature: Account Total Liabilities Overlay(Hong Kong)

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @SIT
  Scenario: Account Total Liabilities Overlay Hong Kong
    Given I login as type "account_has_total_liabilities"
    When I tap Account Total Liabilities
    Then I should on the global overlay screen

  @S437-AC1-AT1
  @DependsOn('Account_Total_Liabilities_Overlay_Hong_Kong')
  Scenario:Check the UI of Account Total Liabilities Overlay Hong Kong
    Given I am on the global overlay screen
    Then I should see the Total Liabilities Overlay following data is shown:
      | element name             | element value                                                                                                                       |
      | overlay title            | Account liabilities                                                                                                                 |
      | overlay name             |                                                                                                                                     |
      | overlay content          |                                                                                                                                     |
      | overlay calculated       |                                                                                                                                     |
      | overlay calculated value | This figure represents the total value of your outstanding loans across your Hong Kong accounts as at the "Updated" date displayed. |

  @S437-AC1-AT2
  @SIT
  @DependsOn('Account_Total_Liabilities_Overlay_Hong_Kong')
  Scenario:Check the Account base currency ISO 3 code in Account Total Liabilities Overlay(Hong Kong)
    Given I am on the global overlay screen
    Then I should see Total Liabilities Overlay base currency ISO 3 code

  @S437-AC1-AT4
  @DependsOn('Account_Total_Liabilities_Overlay_Hong_Kong')
  Scenario:Check whether the Total Liabilities overlay at Account level will be closed when taps on "X" on overlay
    Given I am on the global overlay screen
    When I tap on "close" on total liabilities overlay
    Then I should see the the total liabilities overlay is closed

#  update in sprint 10
#  @S437-AC1-AT5
#  @DependsOn('Check_the_UI_of_Account_Total_Liabilities_Overlay_Hong_Kong')
#  Scenario:Check  whether the Total Liabilities overlay at Account level will be closed when taps anywhere on the screen outside of the overlay frame
#    Given I am see the Total Liabilities Overlay following data is shown:
#      | element name             | element value                                                                                                                       |
#      | overlay title            | Account liabilities                                                                                                                 |
#      | overlay name             |                                                                                                                                     |
#      | overlay content          |                                                                                                                                     |
#      | overlay calculated       |                                                                                                                                     |
#      | overlay calculated value | This figure represents the total value of your outstanding loans across your Hong Kong accounts as at the "Updated" date displayed. |
#    When I tap anywhere on the screen outside of the total liabilities overlay frame
#    Then I should see the the total liabilities overlay is closed

  @S437-AC1-AT3
  Scenario:Check whether Account Total Liabilities overlay(Hong Kong) will be cahnged when I swap the pips
    Given I login as type "account_swap_left_total_liabilities_changed"
#    And I tap first item of Accounts list
    When I swap left the pips for account total liabilities overlay
    And I tap Account Total Liabilities
    Then I should see the Account Total Liabilities overlay will be changed

