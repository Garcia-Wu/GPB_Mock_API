@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-566 @Sprint2_iOS
@Story_GPBM-758 @Sprint1_aOS
@NotAutomatable

Feature: Holdings by Asset Class and Sub-Asset Class at Portfolio level

  As a client I want to see the individual holdings that make up my exposure to each Asset Class AND sub-asset class within each Portfolio,
  so that I know which holdings to review in order to change my class exposure as desired

  Scenario: I am see the class list at portfolio allocation screen
    Given I login as type "portfolio_has_class"
#    When I tap first item of Accounts list
#    And I tap first item of Portfolios list
    And I tap on the Allocation toggle
    Then I should see the class list at portfolio level

  @S15-AC1-AT1
  @DependsOn('I_am_see_the_class_list_at_portfolio_allocation_screen')
  @Const(action="click_holdings_back_button")
  Scenario: Check a list of holdings within that Asset Class at Portfolio Level Screen
    Given I am see the class list at portfolio Screen
    When I tap first item of class list at portfolio level
    Then I should see a list of holdings that they own within that Asset Class for that Portfolio

  @S15-AC1-AT2
  @DependsOn('I_am_see_the_class_list_at_portfolio_allocation_screen')
  Scenario: Check a list of holdings within that Sub-asset Class at Portfolio Level Screen
    Given I am see the class list at portfolio Screen
    When I taps "Show Sub-Asset Class" toggle ON within default Asset Class view
    And I tap first Sub-Asset class item at portfolio level
    Then I should see a list of holdings that they own within that sub-asset class for that Portfolio