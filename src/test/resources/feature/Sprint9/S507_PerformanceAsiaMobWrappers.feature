@HK @SG
@Epic_GPBM-2010(Performance)
@Story_GPBM-2758 @Sprint9_iOS
@Story_GPBM-3143 @Sprint9_aOS

Feature: Performance - Asia - Mob - Wrappers

  As a Asia business,I only want clients to be able to view their performance figures at the Portfolio level,
  so that we show accurate data

  @SIT
  Scenario: I am on the portfolio warpper for GPBM-2758
    Given I login as type "portfolio_has_performance_asia"
#    When I tap first item of Accounts list
#    And I tap first item of Portfolios list
    Then I should on the Portfolios level

  @S507-AC1-AT1
  @DependsOn('I_am_on_the_portfolio_warpper_for_GPBM-2758')
  Scenario: Check the UI of Asia Performance Wrapper in Portfolio level
    Given I am on the Portfolios level
    Then I can view the performance message in the portfolio warpper:
      | element name                     | element value            |
      | "Performance year to date" label | Performance year to date |
      | Performance icon image           |                          |
      | Performance value                |                          |

  @S507-AC1-AT3
  @SIT
  @DependsOn('I_am_on_the_portfolio_warpper_for_GPBM-2758')
  Scenario: Check the Performance latest month which is followed the DD MMM YYYY format in Portfolio wrapper
    Given I am on the Portfolios level
    Then I should see the latest month included in performance calculation on in DD MMM YYYY format

  @S507-AC1-AT2
  Scenario: Check the UI of Asia Performance Wrapper in Portfolio level when I swipe left or right the portfolio wrapper pips
    Given I login as type "portfolio_swipe_left_has_performance_asia"
    When I swipe left to other portfolio
    Then I can view the performance message in the portfolio warpper:
      | element name                     | element value            |
      | "Performance year to date" label | Performance year to date |
      | Performance icon image           |                          |
      | Performance value                |                          |


  @Sprint20
  @S507-AC1-AT4
  @SIT
  Scenario: Check whether the Portfolio Performance overlay will appear when I select the Performance icon
    Given I login as type "portfolio_has_performance_asia"
#    When I tap first item of Accounts list
#    And I tap second item of Portfolios list
    When I tap portfolios performance
    Then I should on the portfolios performance overlay

  @Sprint20
  @S507-AC1-AT5
  @DependsOn('Check_whether_the_Portfolio_Performance_overlay_will_appear_when_I_select_the_Performance_icon')
  Scenario: Check the UI of Discretionary Portfolio performance overlay
    Given I am on the portfolios performance overlay
    Then I can view the following components in Portfolio performance overlay:
      | element name                | element value                                                                                                                                                                                                                                                                                                                           |
      | overlay title               | Performance                                                                                                                                                                                                                                                                                                                             |
      | overlay name                |                                                                                                                                                                                                                                                                                                                                         |
      | overlay content             |                                                                                                                                                                                                                                                                                                                                         |
      | overlay calculated          | How is this calculated?                                                                                                                                                                                                                                                                                                                 |
      | overlay calculated value    |                                                                                                                                                                                                                                                                                                                                         |
      | overlay advisory            | Advisory portfolio                                                                                                                                                                                                                                                                                                                      |
      | overlay advisory value      | The returns represent the difference between the portfolio value at the end of the month and the portfolio value at the start of the month, after excluding net cash inflows within the month.                                                                                                                                          |
      | overlay discretionary       | Discretionary portfolio                                                                                                                                                                                                                                                                                                                 |
      | overlay discretionary value | The returns represent the difference between the portfolio value at the end of the month and the portfolio value at the start of the month, after excluding net cash inflows within the month, and as with all performance figures shown, are in reporting currency, net of fees and charges (actual and accrual) and associated taxes. |
      | overlay hedge fund          | Hedge Fund only portfolio                                                                                                                                                                                                                                                                                                               |
      | overlay hedge fund value    | The returns represent the difference between the portfolio value at the end of the month and the portfolio value at the start of the month, after excluding net cash inflows within the month, and as with all returns shown here, are after fees and charges (actual and accrual).                                                     |
      | close button                |                                                                                                                                                                                                                                                                                                                                         |

  @S507-AC1-AT6
  @SIT
  @DependsOn('Check_whether_the_Portfolio_Performance_overlay_will_appear_when_I_select_the_Performance_icon')
  Scenario: Check the Performance date which is followed the DD MMM YYYY format in Discretionary  Portfolio performance overlay
    Given I am on the portfolios performance overlay
    Then I should see latest month included in performance calculation on in DD MMM YYYY format in portfolio performance overlay

  @S507-AC1-AT7
  Scenario: Check the UI of Discretionary Portfolio performance overlay when I swipe left or right the portfolio wapper pips
    Given I login as type "portfolio_swipe_left_has_performance_asia"
#    When I tap first item of Accounts list
#    And I tap first item of Portfolios list
    When I swipe left to other portfolio
    And I tap portfolios performance
    Then I can view the following components in Portfolio performance overlay:
      | element name             | element value                                                              |
      | overlay title            | Performance                                                                |
      | overlay name             |                                                                            |
      | overlay content          |                                                                            |
      | overlay calculated       | How is this calculated?                                                    |
      | overlay calculated value | Specify performance is measured from 01 Jan 2018 until defined date above. |
      | close button             |                                                                            |

  @S507-AC1-AT8
  Scenario: Check the UI of Asia Advisory Portfolio performance overlay
    Given I login as type "portfolio_advisory_type_has_performance_asia"
#    When I tap first item of Accounts list
#    And I tap thirdly item of Portfolios list
    When I tap portfolios performance
    Then I can view the following components in Portfolio performance overlay:
      | element name             | element value                                                              |
      | overlay title            | Performance                                                                |
      | overlay name             | Advisory                                                                   |
      | overlay content          |                                                                            |
      | overlay calculated       | How is this calculated?                                                    |
      | overlay calculated value | Specify performance is measured from 01 Jan 2018 until defined date above. |
      | close button             |                                                                            |

  @S507-AC1-AT9
  @SIT
  @DependsOn('Check_the_UI_of_Asia_Advisory_Portfolio_performance_overlay')
  Scenario: Check the Performance date which is following the DD MMM YYYY format in Advisory Portfolio performance overlay
    Given I am on the portfolios performance overlay
    Then I should see latest month included in performance calculation on in DD MMM YYYY format in portfolio performance overlay

  @S507-AC1-AT10
  Scenario: Check the UI of Asia Advisory Portfolio performance overlay when I swipe left or right the portfolio wapper pips
    Given I login as type "portfolio_advisory_type_swipe_left_has_performance_asia"
#    When I tap first item of Accounts list
#    And I tap thirdly item of Portfolios list
    And I swipe left 2th to other portfolio
    And I tap portfolios performance
    Then I can view the following components in Portfolio performance overlay:
      | element name             | element value                                                              |
      | overlay title            | Performance                                                                |
      | overlay name             | Advisory                                                                   |
      | overlay content          |                                                                            |
      | overlay calculated       | How is this calculated?                                                    |
      | overlay calculated value | Specify performance is measured from 01 Jan 2018 until defined date above. |
      | close button             |                                                                            |

  @S507-AC1-AT11
  Scenario: Check whether client can not view Performance in the Asia Overview wrapper container
    Given I login as type "no_account"
    Then I can not view Performance in the overview wrapper container

  Scenario: I am on the account level for GPBM-2758
    Given I login as type "account_no_performance"
#    When I tap first item of Accounts list
    Then I should on the Account level

  @S507-AC1-AT12
  @DependsOn('I_am_on_the_account_level_for_GPBM-2758')
  Scenario: Check whether client can not view Performance in the Asia Account wrapper container
    Given I am on the Account level
    Then I can not view Performance in the account wrapper container

  @S507-AC1-AT13
  @DependsOn('I_am_on_the_account_level_for_GPBM-2758')
  Scenario: Check whether client can not view Performance in the Asia Account wrapper container when client swipes left or right the account wrapper pips
    Given I am on the Account level
    When I swipe left to other account
    Then I can not view Performance in the account wrapper container