@HK
@Epic_GPBM-460(Liabilities)
@Story_GPBM-2314 @Sprint8_iOS
@Story_GPBM-2311 @Sprint8_aOS

Feature: Overview Total Liabilities Overlay(Hong Kong)

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @SIT
  Scenario: Overview Total Liabilities Overlay Hong Kong
    Given I login as type "overview_has_total_liabilities"
    When I tap Overview Total Liabilities
    Then I should on the global overlay screen

  @S431-AC1-AT1
  @DependsOn('Overview_Total_Liabilities_Overlay_Hong_Kong')
  Scenario:Check the UI of Overview Total Liabilities Overlay Hong Kong
    Given I am on the global overlay screen
    Then I should see the Total Liabilities Overlay following data is shown:
      | element name             | element value                                                                                                                       |
      | overlay title            | Total liabilities                                                                                                                   |
      | overlay name             |                                                                                                                                     |
      | overlay content          |                                                                                                                                     |
      | overlay calculated       |                                                                                                                                     |
      | overlay calculated value | This figure represents the total value of your outstanding loans across your Hong Kong accounts as at the "Updated" date displayed. |

  @S431-AC1-AT2
  @SIT
  @DependsOn('Overview_Total_Liabilities_Overlay_Hong_Kong')
  Scenario:Check the "USD" ISO 3 code in Overview Total Liabilities Overlay(Hong Kong)
    Given I am on the global overlay screen
    Then I should see Total Liabilities Overlay base currency ISO 3 code

  @S431-AC1-AT3
  @DependsOn('Overview_Total_Liabilities_Overlay_Hong_Kong')
  Scenario:Check whether the Total Liabilities overlay at Overview level will be closed when taps on "X" on overlay
    Given I am on the global overlay screen
    When I tap on "close" on total liabilities overlay
    Then I should see the the total liabilities overlay is closed

#  update in sprint 10
#  @S431-AC1-AT4
#  @DependsOn('Check_the_UI_of_Overview_Total_Liabilities_Overlay_Hong_Kong')
#  Scenario:Check  whether the Total Liabilities overlay at Overview level will be closed when taps anywhere on the screen outside of the overlay frame
#    Given I am see the Total Liabilities Overlay following data is shown:
#      | element name             | element value                                                                                                                       |
#      | overlay title            | Total liabilities                                                                                                                   |
#      | overlay name             |                                                                                                                                     |
#      | overlay content          |                                                                                                                                     |
#      | overlay calculated       |                                                                                                                                     |
#      | overlay calculated value | This figure represents the total value of your outstanding loans across your Hong Kong accounts as at the "Updated" date displayed. |
#    When I tap anywhere on the screen outside of the total liabilities overlay frame
#    Then I should see the the total liabilities overlay is closed