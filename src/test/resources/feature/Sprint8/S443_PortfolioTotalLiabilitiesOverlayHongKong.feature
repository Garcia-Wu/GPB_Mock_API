@HK
@Epic_GPBM-460(Liabilities)
@Story_GPBM-2336 @Sprint8_iOS
@Story_GPBM-2333 @Sprint8_aOS

Feature: Portfolio Total Liabilities Overlay(Hong Kong)

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @SIT
  Scenario: Portfolio Total Liabilities Overlay Hong Kong
    Given I login as type "portfolio_has_total_liabilities"
    When I tap Portfolio Total Liabilities
    Then I should on the global overlay screen

  @S443-AC1-AT1
  @DependsOn('Portfolio_Total_Liabilities_Overlay_Hong_Kong')
  Scenario:Check the UI of Portfolio Total Liabilities Overlay Hong Kong
    Given I am on the global overlay screen
    Then I should see the Total Liabilities Overlay following data is shown:
      | element name             | element value                                                                                                                       |
      | overlay title            | Portfolio liabilities                                                                                                               |
      | overlay name             |                                                                                                                                     |
      | overlay content          |                                                                                                                                     |
      | overlay calculated       |                                                                                                                                     |
      | overlay calculated value | This figure represents the total value of your outstanding loans across your Hong Kong accounts as at the "Updated" date displayed. |

  @S443-AC1-AT2
  @SIT
  @DependsOn('Portfolio_Total_Liabilities_Overlay_Hong_Kong')
  Scenario:Check the Portfolio base curreny ISO 3 code in Portfolio Total Liabilities Overlay(Hong Kong)
    Given I am on the global overlay screen
    Then I should see Total Liabilities Overlay base currency ISO 3 code

  @S443-AC1-AT4
  @DependsOn('Portfolio_Total_Liabilities_Overlay_Hong_Kong')
  Scenario:Check  whether the Total Liabilities overlay at Portfolio level will be closed when taps on "X" on overlay
    Given I am on the global overlay screen
    When I tap on "close" on total liabilities overlay
    Then I should see the the total liabilities overlay is closed

#  update in sprint 10
#  @S443-AC1-AT5
#  @DependsOn('Check_the_UI_of_Portfolio_Total_Liabilities_Overlay_Hong_Kong')
#  Scenario:Check  whether the Total Liabilities overlay at Portfolio level will be closed when taps anywhere on the screen outside of the overlay frame
#    Given I am see the Total Liabilities Overlay following data is shown:
#      | element name             | element value                                                                                                                       |
#      | overlay title            | Portfolio liabilities                                                                                                               |
#      | overlay name             |                                                                                                                                     |
#      | overlay content          |                                                                                                                                     |
#      | overlay calculated       |                                                                                                                                     |
#      | overlay calculated value | This figure represents the total value of your outstanding loans across your Hong Kong accounts as at the "Updated" date displayed. |
#    When I tap anywhere on the screen outside of the total liabilities overlay frame
#    Then I should see the the total liabilities overlay is closed

  @S443-AC1-AT3
  Scenario:Check whether Portfolio Total Liabilities overlay(Hong Kong) will be cahnged when I swap the pips
    Given I login as type "portfolio_swap_left_total_liabilities_changed"
#    And I tap first item of Accounts list
#    And I tap first item of Portfolios list
    When I swap left the pips for portfolio total liabilities overlay
    And I tap Portfolio Total Liabilities
    Then I should see the Portfolio Total Liabilities overlay will be changed