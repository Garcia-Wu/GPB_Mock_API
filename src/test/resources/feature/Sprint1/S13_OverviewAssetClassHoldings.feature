@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-396 @Sprint1_iOS
@Story_GPBM-752 @Sprint1_aOS
@NotAutomatable

Feature: Holdings by Asset Class and Sub-Asset Class at Overview level

  As a client I want to see the individual holdings that make up my exposure to each Asset Class AND sub-asset class at Overview level,
  so that I know which holdings to review in order to change my class exposure as desired

  Scenario: I am see the class list at overview allocation screen
    Given I login as type "overview_has_class"
    When I tap on the Allocation toggle
    Then I should see the class list at overview level

  @S13-AC1-AT1
  @DependsOn('I_am_see_the_class_list_at_overview_allocation_screen')
  @Const(action="click_holdings_back_button")
  Scenario: Check a list of holding within that Asset Class
    Given I am see the class list at Overview Screen
    When I tap first item of class list
    Then I should see a list of holdings that they own across all of their Accounts within that Asset Class at overview level

  @S13-AC1-AT2
  @DependsOn('I_am_see_the_class_list_at_overview_allocation_screen')
  Scenario: Check a list of holding within that Sub-asset Class
    Given I am see the class list at Overview Screen
    When I tap on "Show Sub-Asset Class" toggle
    And I tap first Sub-Asset class item at overview screen
    Then I should see a list of holdings that they own across all of their Accounts within that sub-asset class at overview level