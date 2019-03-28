@NotAutomatable
# Reason：This function has been modified in sprint14 or sprint15
@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-313 @Sprint1_iOS
@Story_GPBM-807 @Sprint1_aOS

Feature: View sub-asset class breakdown at Account level

  As a client I want to view my sub-asset allocation within one of my accounts,
  so that I have a high level view of my investments by sub-asset class

  Scenario: login userE for GPBM313
    Given I login as type "account_has_subclass"
#    When I tap first item of Accounts list
    And I tap default Accounts Allocation toggle
    And I tap "Show Sub-Asset Class" toggle of Accounts level
    Then I should on the Account level

  @S6-AC1-AT1
  @DependsOn('login_userE_for_GPBM313')
  Scenario: Check the Accounts Level screen UI
    Given I am on the Account level
    Then I should see the following UI Elements on the Accounts Class Level
      | element region | element name             | element value  |
      |                | Account name             |                |
      |                | Account id               |                |
      |                | Total assets title       | Account assets |
#      | info icon                |               |
      |                | Total assets amount      |                |
#      | currency label           |               |
      |                | Allocation button active |                |
      |                | Class tab                | Class          |
      |                | Currency tab             | Currency       |
      | UK             | Region tab               | Region         |
    And I should see the Card list of different asset subAsset class list


  @S6-AC1-AT2
  @DependsOn('login_userE_for_GPBM313')
  Scenario: Check the status of Allocation And Class And Sub-asset Class
    Given I am on the Account level
    Then I should see the Allocation And Class And Sub-asset Class is active


  @NotAutomatable
  Scenario: Check whether the "Show sub-asset class" Toggle is a fixed/sticky header at class Tab under breakdown Account Level Screen
  # S6-AC1-AT3
  # Reason: Next sprint is change (sub-asset class Toggle not's fixed header)

  @S6-AC1-AT4
  @DependsOn('login_userE_for_GPBM313')
  Scenario: Check the data of each Asset Class they are invested in
    Given I am on the Account level
    Then I check the first TableCell item of SubClass list：Asset class name、Total asset value 2dp format

  @S6-AC1-AT5
  @DependsOn('login_userE_for_GPBM313')
  Scenario: Check the data of each Sub-asset Class they are invested in when sub-asset class tab is Active
    Given I am on the Account level
    Then I check the first item of SubClass list：Sub-asset Class name、Total asset value 2dp format、Total asset 2dp format percentage

  @NotAutomatable
  Scenario: Check the horizontal bar when sub-asset class tab is Active
  # S6-AC1-AT6
  # Reason: cannot check the bar

  @S6-AC1-AT7
  @DependsOn('login_userE_for_GPBM313')
  Scenario: Check the sequence of the Sub-asset Classes By Total Assets at class Tab under breakdown Account Level Screen
    Given I am on the Account level
    Then I should see the sub-asset classes are ordered by Total Asset value - largest (first) to smallest (last), then by alphabetical order

  @S6-AC1-AT8
  @DependsOn('login_userE_for_GPBM313')
  Scenario: Check the session of Sub-asset Class Toggle ON
    Given I am on the Account level
    When I tap the Back Button of Accounts Level
    And I tap first item of Accounts list
    And I tap default Accounts Allocation toggle
    And I should see the Sub-asset Class Toggle is ON
    And I tap on the Allocation toggle
    And I tap first item of Portfolios list
    And I tap the Back Button of Portfolios Level
    And I tap default Accounts Allocation toggle
    Then I should see the Sub-asset Class Toggle is ON

  @S6-AC1-AT12
  @DependsOn('login_userE_for_GPBM313')
  Scenario: Check the data of each Asset Class they are invested in when sub-asset class tab is Inactive
    Given I am on the Account level
    Then I should see the following data on Class List：Asset Class name、Total asset value 2dp format


#  @S6-AC1-AT9  (现在还没有这种账户测试,需要API)
#  Scenario: Check if not invested in a specific Sub-asset Class
#    Given Client is not invested in a specific sub-asset class within one of their Accounts
#    And client is viewing that account
#    When Client taps on Asset Allocation toggle
#    And taps on "Class" tab
#    And taps "show sub-asset class" toggle
#    Then I should not see that sub-asset class listed

  @NotAutomatable
  Scenario: Check whether the "Show sub-asset class" Toggle is a fixed/sticky header
  # S6-AC1-AT11
  # Reason: Next sprint is change (sub-asset class Toggle not's fixed header)

  @NotAutomatable
  Scenario: Check the horizontal bar when sub-asset class tab is Inactive
  # S6-AC1-AT13
  # Reason: cannot check the bar

  @S6-AC1-AT14
  @DependsOn('login_userE_for_GPBM313')
  Scenario: Check the session of Sub-asset Class Toggle OFF
    Given I am on the Account level
    When I tap the Back Button of Accounts Level
    And I tap first item of Accounts list
    And I tap default Accounts Allocation toggle
    And I tap "Show Sub-Asset Class" toggle of Accounts level
    And I should see the Sub-Asset Class Toggle is off
    And I tap on the Allocation toggle
    And I tap first item of Portfolios list
    And I tap the Back Button of Portfolios Level
    And I tap default Accounts Allocation toggle
    Then I should see the Sub-Asset Class Toggle is off

  @S6-AC1-AT10
  Scenario: Check the statues of Accounts Sub-asset Class Toggle
    Given I login as type "more_account_has_portfolio_list"
#    When I tap first item of Accounts list
    And I tap default Accounts Allocation toggle
    And I tap "Show Sub-Asset Class" toggle of Accounts level
    And I tap on "Show Sub-Asset Class" toggle of Accounts level
    Then I should see the Sub-Asset Class Toggle is off
