@NotAutomatable
# Reason：This function has been modified in sprint14 or sprint15
@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-315 @Sprint2_iOS
@Story_GPBM-810 @Sprint1_aOS

Feature: View sub-asset class breakdown at Portfolio level

  As a client I want to view my sub-asset allocation within one of my portfolios,
  so that I have a high level view of my investments by sub-asset class

  @S10-AC1-AT1
  Scenario: Check the Portfolio Level Screen UI for sub-class
    Given I login as type "more_account_portfolio_has_subclass"
#    When I tap first item of Accounts list
#    And I tap first item of Portfolios list
    And I tap on Asset Allocation toggle
    And I taps "Show Sub-Asset Class" toggle ON within default Asset Class view
    Then I should see the following UI Elements on the Portfolios Class Level
      | element region | element name                  | element value    |
      |                | Portfolio name                |                  |
      |                | Portfolio id                  |                  |
      |                | Total Assets title            | Portfolio assets |
#      | info icon                     |               |
      |                | Total Assets value            |                  |
#      | Currency label                |               |
      |                | Allocation button             |                  |
      |                | Class tab                     | Class            |
      |                | Currency tab                  | Currency         |
      | UK             | Region tab                    | Region           |
      |                | Sub-Asset Class toggle        |                  |
      |                | Asset Breakdown list of Class |                  |
      |                | back button                   |                  |
      |                | menu icon                     |                  |

  @NotAutomatable
  Scenario: Check the statues of Allocation $ Class & Sub-asset Class Toggle
    Given I am on the Portfolio level screen
    Then I should see the following states:
  # Allocation Toggel = ACTIVE
  # Class = Active
  # Sub-Asset Class Toggle = ACTIVE
  # S10-AC1-AT2
  # Reason: cannot check the bar

  @NotAutomatable
  Scenario: Check whether the "Show sub-asset class" Toggle is a fixed/sticky header
    Given I am on the Portfolio level screen
    When I scroll down to the bottom
    Then I should see  "Show sub-asset class" toggle should become a fixed/sticky header when user scrolls down list
  # S10-AC1-AT3
  # Reason: cannot check the bar

  @S10-AC1-AT7
  Scenario: Check the page switching for the sub asset class
    Given I login as type "more_account_portfolio_has_subclass"
#    When I tap first item of Accounts list
#    And I tap first item of Portfolios list
    And I tap on Asset Allocation toggle
    And I taps "Show Sub-Asset Class" toggle ON within default Asset Class view
    And I navigates away to another Portfolio、 Account
    And I come back to the previouse Portfolio level screen
    And I tap on Asset Allocation toggle
    Then I should see the sub-asset class toggle should stay ON for this Portfolio (only) during the current app session (only),even if the user navigates away to another Portfolio, Account or Overview screen


  Scenario: login in as userE for GPBM315
    Given I login as type "more_account_portfolio_has_subclass"
#    When I tap first item of Accounts list
#    And I tap first item of Portfolios list
    And I tap on Asset Allocation toggle
    And I taps "Show Sub-Asset Class" toggle ON within default Asset Class view
    Then I should on the Portfolios level

#   class title id 有问题
  @S10-AC1-AT4
  @DependsOn('login_in_as_userE_for_GPBM315')
  Scenario: Check the data of each Portfolio Sub Asset Class that they are invested in
    Given I am on the Portfolios level
    Then I should see the following data:Asset Class name、Total asset ISO3 format value、Total asset 2dp format value


  @S10-AC1-AT5
  @DependsOn('login_in_as_userE_for_GPBM315')
  Scenario: Check the data of each Sub-Asset Class
    Given I am on the Portfolios level
    Then I should see the following data:Sub-Asset Class name、Total asset 2dp format value、Total assets 2dp percentage value

  @S10-AC1-AT6
  @DependsOn('login_in_as_userE_for_GPBM315')
  Scenario: Check the sequence of the Sub-asset Class By Total Assets
    Given I am on the Portfolios level
    Then I should see the sub-asset classes are ordered by Total Asset value - largest (first) to smallest (last), then by alphabetical order on Portfolios

#
##  class  id 有问题
  @S10-AC1-AT14
  @DependsOn('login_in_as_userE_for_GPBM315')
  Scenario: Check whether the Total asset value equals the sum of all the sub-asset class value
    Given I am on the Portfolios level
    Then I should see the Total asset value equals the sum of all the sub-asset class value


  @NotAutomatable
  Scenario: Check if not invested in a specific Sub-asset Class
    Given Client is not invested in a specific sub-asset class within all of their portfolios
    And client is viewing that portfolio
    When Client taps on Asset Allocation toggle
    And taps on "Class" tab
    And taps "show sub-asset class" toggle
    Then I should not see that sub-asset class listed
  # S10-AC1-AT8
  # Reason: cannot check the bar

  @S10-AC1-AT9
  Scenario: Check the statues of Portfolios Sub-asset Class Toggle
    Given I login as type "more_account_portfolio_has_subclass"
    And I tap on Asset Allocation toggle
    And I taps "Show Sub-Asset Class" toggle ON within default Asset Class view
    When I taps "Show Sub-Asset Class" toggle OFF within default Asset Class view
    Then I should see the following states:"show sub-asset class" toggle = INACTIVE

  @NotAutomatable
  Scenario: Check whether the "Show sub-asset class" Toggle is a fixed/sticky header
    Given I am on the Portfolio level screen
    When I scroll down to the bottom
    Then I should see  "Show sub-asset class" toggle should NOT be a fixed/sticky header when user scrolls down list
  # S10-AC1-AT10
  # Reason: cannot check whether the "Show sub-asset class" toggle is fixed

#  class ID 有问题
  @S10-AC1-AT11
  @DependsOn('Check_the_statues_of_Portfolios_Sub-asset_Class_Toggle')
  Scenario: Check the data of each Portfolios Sub-Asset Class that they are invested in
    Given I should see the following states:"show sub-asset class" toggle = INACTIVE
    Then I should see the following data for Asset Class name、Total asset ISO3 format value、Total asset 2dp format value、Total assets 2dp percentage value


  @NotAutomatable
  Scenario: Check the horizontal bar
    Given I am on the Portfolio level screen
    Then I should horizontal bar representing % of assets owned
#   S10-AC1-AT12
#   Reason: cannot check the bar status

  @NotAutomatable
  Scenario: Check the session of Sub-asset Class Toggle
    Given I am on the Portfolio level screen
    When I navigate away to another Portfolio, Account or Overview screen
    And I come back to the previouse Portfolio level screen
    Then I should the sub-asset class toggle should stay OFF for this Portfolio (only) during the current app session (only), even if the user navigates away to another Portfolio, Account or Overview screen
  # S10-AC1-AT13
  # Reason: cannot check the status of sub-asset class toggle

