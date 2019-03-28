@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-397 @Sprint1_iOS
@Story_GPBM-755 @Sprint1_aOS
@NotAutomatable

Feature: Holdings by Asset Class and Sub-Asset Class at Account level

  As a client I want to see the individual holdings that make up my exposure to each Asset Class AND sub-asset class within each Account,
  so that I know which holdings to review in order to change my class exposure as desired

  Scenario: I am see the class list at account allocation screen
    Given I login as type "account_has_class"
#    When I tap first item of Accounts list
    And I tap on the Allocation toggle
    Then I should see the class list at account level

  @S14-AC1-AT1
  @DependsOn('I_am_see_the_class_list_at_account_allocation_screen')
  @Const(action="click_holdings_back_button")
  Scenario: Check a list of holdings within that Asset Class at Account Level Screen
    Given I am see the class list at account Screen
    When I tap first item of class list at account level
    Then I should see a list of holdings that they own within that Asset Class for that Account

  @S14-AC1-AT2
  @DependsOn('I_am_see_the_class_list_at_account_allocation_screen')
  Scenario: Check a list of holdings within that Sub-asset Class at Account Level Screen
    Given I am see the class list at account Screen
    When I tap on "Show Sub-Asset Class" toggle of Accounts level
    And I tap first Sub-Asset class item at account level
    Then I should see a list of holdings that they own within that sub-asset class for that Account
