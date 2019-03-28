@HK @SG @UK
@Epic_GPBM-385(Global_Interactions_and_Animations)
@Story_GPBM-977 @Sprint4_iOS
@Story_GPBM-1357 @Sprint4-aOS

Feature:Pip animation

  userE: has one account and has more portfolio user
  userM: has more account and has more portfolio user

  Scenario: on the overview screen by userE
    Given I login as type "one_account_on_account"
    Then I should see the portfolio list

  @S129-AC2-AT1
  @DependsOn('on_the_overview_screen_by_userE')
  @Const(action="back_overView_level")
  Scenario: Check the Pip animation when Account list with only 1
    Given I am see the portfolio list
    Then I should see a detailed view relating to that account
    And NO pips to indicate that they can swipe left or right within account view
    And I should not be able to swipe left or right in account detailed view

  @S129-AC3-AT2
  @DependsOn('on_the_overview_screen_by_userE')
  Scenario: Check the Pip animation when Portfolio list between 2 and 12 items
    Given I see the account list
    When I tap first item of Accounts list
    And I tap first item of Portfolios list
    Then I should see a detailed view relating to that item on the portfolios page

#    Update for sprint6
#  @S129-AC1-AT1
#  @DependsOn('Check_the_Pip_animation_when_Portfolio_list_between_2_and_12_items')
#  Scenario: Check the Pip animation when Contingent liabilities list with only 1
#    Given I see a detailed view relating to that item on the portfolios page
#    When  I come back to the Account Level
#    And I tap 3rd of Portfolios List
#    And I tap on the Contingent Liabilities tab
#    And I tap first item of contingent liabilities list
#    Then NO pips to indicate that they can swipe left or right within portfolio contingent liabilities detailed view
#    And I should not be able to swipe left or right in portfolios contingent liabilities detailed view

  @S129-AC2-AT2
  Scenario: Check the Pip animation when Account list between 2 and 12 items
    Given I login as type "more_account"
    When I taps on 2nd items in Accounts list
    Then I should see a detailed view relating to that item

  @S129-AC3-AT1
  Scenario: Check the Pip animation when Portfolio list with only 1
    Given I login as type "one_portfolio_on_portfolio"
#    When I tap 3th item of Accounts list
#    And I tap first item of Portfolios list
    Then I should see a detailed view relating to portfolio item
    And NO pips to indicate that they can swipe left or right within portfolio detailed view
    And I should not be able to swipe left or right in portfolios detailed view


  @NotAutomatable
  Scenario: Check the Pip animation when Contingent liabilities list between 2 and 12 items
    When dummy
#    S129-AC1-AT2
#    Reason: Cannot check the pip status

  @NotAutomatable
  Scenario:  Check whether the pip never ending loop when Contingent liabilities list between 2 and 12 items
    When dummy
  #    S129-AC1-AT3
  #    Reason：Cannot a never ending loop

  @NotAutomatable
  Scenario: Check the status of the pip in Contingent liability detail view when Contingent liabilities list between 2 and 12 items
    When dummy
    #  S129-AC1-AT4
    #  Reason: Cannot check the pip opacity is 25%、inactive(5x5px,#FFF 50%)

  @NotAutomatable
  Scenario: Check the Pip animation when Contingent liabilities list with 13 or more than 13 items
    Given client is viewing Contigent liabilities list with 13 or more than 13 items
    When dummy
#    S129-AC1-AT5
#    Cannot check the pip status

  @NotAutomatable
  Scenario: Check whether the pip never ending loop when Contingent liabilities list  with 13 or more than 13 items
    Then dummy
  #    S129-AC1-AT6
  #    Reason：Cannot a never ending loop

  @NotAutomatable
  Scenario: Check the status of the pip when Contingent liabilities list with 13 or more than 13 items
    When dummy
    #  S129-AC12-AT7
    #  Reason: Cannot check the pip opacity is 30%、opacity is 20%、inactive(5x5px,#FFF 50%)

  @NotAutomatable
  Scenario: Check the status of the pip when Contingent liabilities list with 13 or more than 13 items
    When dummy
    #  S129-AC1-AT8
    #  Reason: Cannot check the pip opacity is 25%、inactive(5x5px,#FFF 50%)

  @NotAutomatable
  Scenario: Check the status of the pip when Contingent liabilities list with 13 or more than 13 items
    When dummy
    #  S129-AC1-AT9
    #  Reason: Cannot check the pip opacity is 25%、inactive(5x5px,#FFF 50%)

  @NotAutomatable
  Scenario: Check the status of the pip when Contingent liabilities list with 13 or more than 13 items
    When dummy
    #  S129-AC1-AT10
    #  Reason: Cannot check the pip opacity is 30%、opacity is 20%、inactive(5x5px,#FFF 50%)

  @NotAutomatable
  Scenario: Check whether the pip never ending loop when Account list between 2 and 12 items
    When dummy
    #    S129-AC2-AT3
    #    Reason：Cannot a never ending loop

  @NotAutomatable
  Scenario: Check the status of the pip in Account wrapper at Account level when Account list between 2 and 12 items
    When dummy
    #  129-AC2-AT4
    #  Reason: Cannot check the pip is active(7x7px,#FFF 100%)、inactive(5x5px,#FFF 50%)

  @NotAutomatable
  Scenario: Check the Pip animation when Account list with 13 or more than 13 items
    Given client is viewing Account list with 13 or more than 13 items
    When dummy
#    S129-AC2-AT13
#    Cannot check the pip status

  @NotAutomatable
  Scenario: Check whether the pip never ending loop when Account list  with 13 or more than 13 items
    When dummy
  #    S129-AC2-AT14
  #    Reason：Cannot a never ending loop

  @NotAutomatable
  Scenario: Check the status of the pip when Account list with 13 or more than 13 items
    When dummy
    #  S129-AC2-AT15
    #  Reason: Cannot check the pip opacity is 30%、opacity is 20%、inactive(5x5px,#FFF 50%)

  @NotAutomatable
  Scenario: Check the status of the pip when Account list with 13 or more than 13 items
    When dummy
    #  S129-AC2-AT16
    #  Reason: Cannot check the pip opacity is 25%、inactive(5x5px,#FFF 50%)

  @NotAutomatable
  Scenario: Check the status of the pip when Account list with 13 or more than 13 items
    When dummy
    #  S129-AC3-AT17
    #  Reason: Cannot check the pip opacity is 25%、inactive(5x5px,#FFF 50%)

  @NotAutomatable
  Scenario: Check the status of the pip when Account list with 13 or more than 13 items
    When dummy
    #  S129-AC2-AT18
    #  Reason: Cannot check the pip opacity is 30%、opacity is 20%、inactive(5x5px,#FFF 50%)

  @NotAutomatable
  Scenario: Check whether the pip never ending loop when Portfolio list between 2 and 12 items
    Then dummy
  #    S129-AC3-AT3
  #    Reason：Cannot a never ending loop

  @NotAutomatable
  Scenario: Check the status of the pip in Portfolio wrapper at Portfolio level when Portfolio list between 2 and 12 items
    When dummy
    #    S129-AC3-AT4
    #  Reason: Cannot check the pip is active(7x7px,#FFF 100%)、inactive（5x5px,#FFF 50%）

  @NotAutomatable
  Scenario: Check the Pip animation when Portfolio list with 13 or more than 13 items
    Given client is viewing Portfolio list with 13 or more than 13 items
    When dummy
#    S129-AC3-AT13
#    Cannot check the pip status

  @NotAutomatable
  Scenario: Check whether the pip never ending loop when Portfolio list  with 13 or more than 13 items
    Then dummy
  #    S129-AC3-AT14
  #    Reason：Cannot a never ending loop

  @NotAutomatable
  Scenario:  Check the status of the pip when Portfolio list with 13 or more than 13 items
    When dummy
    #  S129-AC3-AT15
    #  Reason: Cannot check the pip opacity is 30%、opacity is 20%、inactive(5x5px,#FFF 50%)

  @NotAutomatable
  Scenario: Check the status of the pip when Portfolio list with 13 or more than 13 items
    When dummy
  #  S129-AC3-AT16
  #  Reason: Cannot check the pip opacity is 25%、inactive(5x5px,#FFF 50%)

  @NotAutomatable
  Scenario: Check the status of the pip when Portfolio list with 13 or more than 13 items
    When dummy
  #  S129-AC3-AT17
  #  Reason: Cannot check the pip opacity is 25%、inactive(5x5px,#FFF 50%)


  @NotAutomatable
  Scenario:Check the status of the pip when Portfolio list with 13 or more than 13 items
    When dummy
    #  S129-AC3-AT18
    #  Reason: Cannot check the pip opacity is 30%、opacity is 20%、inactive(5x5px,#FFF 50%)











