@NotAutomatable
# Reason：This function has been modified in sprint14 or sprint15
@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-308 @Sprint1_iOS
@Story_GPBM-803 @Sprint1_aOS

Feature: View sub-asset class breakdown at Overview level

  As a client I want to view my sub-asset allocation across all of my accounts,
  so that I have a high level view of my investments by sub-asset class

  userE: show sub class user
  userD: not invested in class user

  Scenario: login userE for GPBM308
    Given I login as type "overview_has_subclass"
    When I tap on the Allocation toggle
    Then I should on the Overview screen

  @S2-AC1-AT1
  @DependsOn('login_userE_for_GPBM308')
  Scenario: View Overview show sub-class screen UI.
    Given I am on the Overview screen
    Then I should see the following components on Overview Screen
      | element region | element name                    | element value |
      |                | Greeting message                |               |
      |                | Country                         |               |
      |                | Total assets title              | Total assets  |
#      | Total assets icon               |               |
      |                | Total assets amount             |               |
      |                | Allocation button active        |               |
      |                | Class Tab                       | Class         |
      |                | Currency Tab                    | Currency      |
      | UK             | Region Tab                      | Region        |
      |                | Show Sub-Asset Class toggle off |               |
      |                | Menu icon                       |               |
    And I should see the Asset breakdown list of Class


  @S2-AC1-AT2
  @DependsOn('login_userE_for_GPBM308')
  Scenario: Check the state of Allocation Toggle & Class & Sub-asset Class Toggle.
    Given I am on the Overview screen
    When I tap on "Show Sub-Asset Class" toggle
    Then I should see the following states when tap "Show Sub-Asset Class" toggle
      | element name                | states |
      | Allocation Toggle           | active |
      | Class Tab                   | active |
      | Show Sub-Asset Class Toggle | active |


  @NotAutomatable
  Scenario: Check whether the "Show sub-asset class" toggle become a fixed/sticky header.
    When dummy
  # S2-AC1-AT3
  # Reason: Next sprint is change (sub-asset class Toggle not's fixed header)

  @S2-AC1-AT4
  @DependsOn('Check_the_state_of_Allocation_Toggle_&_Class_&_Sub-asset_Class_Toggle.')
  Scenario: Check the following data for each asset class they are invested in, within each Asset Class.
    Given I see the following states when tap "Show Sub-Asset Class" toggle
      | element name                | states |
      | Allocation Toggle           | active |
      | Class Tab                   | active |
      | Show Sub-Asset Class Toggle | active |
    Then I should see the sub-asset class name for each sub-asset class
    And sub-asset class Total asset value in reporting currency (ISO 3 format) selected to 2 d.p.

  @S2-AC1-AT5
  @DependsOn('Check_the_state_of_Allocation_Toggle_&_Class_&_Sub-asset_Class_Toggle.')
  Scenario: Check the following data for each sub-asset class they are invested in, within each Asset Class.
    Given I see the following states when tap "Show Sub-Asset Class" toggle
      | element name                | states |
      | Allocation Toggle           | active |
      | Class Tab                   | active |
      | Show Sub-Asset Class Toggle | active |
    Then I should see the sub-asset class name for each sub-asset class
    And sub-asset class Total asset value in reporting currency (ISO 3 format) selected to 2 d.p.
    And sub-asset class Total asset value as a % of all assets owned to 2 d.p.

  @NotAutomatable
  Scenario: Check the processing bar status Class when sub-asset class toggle is active at Overview Level Screen.
    When dummy
  # S2-AC1-AT6
  # Reason: cannot check the bar


  @S2-AC1-AT7
  @DependsOn('Check_the_state_of_Allocation_Toggle_&_Class_&_Sub-asset_Class_Toggle.')
  Scenario: Check the sequence of Total Asset value when sub-asset class toggle is active at Overview Level Screen.
    Given I see the following states when tap "Show Sub-Asset Class" toggle
      | element name                | states |
      | Allocation Toggle           | active |
      | Class Tab                   | active |
      | Show Sub-Asset Class Toggle | active |
    Then I should see the sub-asset classes are ordered by Total Asset value - largest to smallest

  @S2-AC1-AT10
  @DependsOn('Check_the_state_of_Allocation_Toggle_&_Class_&_Sub-asset_Class_Toggle.')
  Scenario: Check the state of Allocation Toggle&Class&Sub-asset Class Toggle when toggle is off.
    Given I see the following states when tap "Show Sub-Asset Class" toggle
      | element name                | states |
      | Allocation Toggle           | active |
      | Class Tab                   | active |
      | Show Sub-Asset Class Toggle | active |
    When I tap on "Show Sub-Asset Class" toggle to off
    Then I should see the following states when tap "Show Sub-Asset Class" toggle
      | element name                | states   |
      | Allocation Toggle           | active   |
      | Class Tab                   | active   |
      | Show Sub-Asset Class Toggle | inactive |

  @NotAutomatable
  Scenario: check whether the "Show sub-asset class" toggle is NOT a fixed/sticky header when user scrolls down list
    When dummy

  # @S2-AC1-AT11
  # Reason: Next sprint is change (sub-asset class Toggle not's fixed header)

  @S2-AC1-AT13
  @DependsOn('Check_the_state_of_Allocation_Toggle&Class&Sub-asset_Class_Toggle_when_toggle_is_off.')
  Scenario: Check the following data for each Asset Class they are invested in, within each Asset Class
    Given I see the following states when tap "Show Sub-Asset Class" toggle
      | element name                | states   |
      | Allocation Toggle           | active   |
      | Class Tab                   | active   |
      | Show Sub-Asset Class Toggle | inactive |
#    When I tap on "Show Sub-Asset Class" toggle
    Then I should see the Asset Class name
    And Asset Class Total asset value in reporting currency (ISO 3 format) selected to 2 d.p.

  @NotAutomatable
  Scenario: Check the processing bar status when sub-asset class toggle is inactive at Overview Level Screen.
    Given I am on overview screen,
    Then I should see the horizontal bar representing % of assets owned
  # S2-AC1-AT14
  # Reason: cannot check the bar

#  @NotAutomatable
#  object id 有问题
  @S2-AC1-AT15
  Scenario: Check the sequence of Total Asset value when sub-asset class toggle is inactive at Overview Level Screen.
    Given I login as type "overview_has_subclass"
    When I tap on the Allocation toggle
    When I tap on overview "Show Sub-Asset Class" toggle to ON
    Then I should see the sub asset classes are ordered by Total Asset value - largest to smallest
    #  @S2-AC1-AT15
    #  IOS: Because we can't get the object id

  @S2-AC1-AT8
  Scenario: Check whether the state of sub-asset class toggle is ON at the Overview level (only) during the current app session (only).
    Given I login as type "overview_has_subclass"
    And I tap on the Allocation toggle
    And I tap on "Show Sub-Asset Class" toggle
    When I go to Portfolio level Screen
    And I back to Overview Allocation class screen
    Then The sub-asset class toggle should stay ON at the Overview level (only) during the current app session (only)

  @S2-AC1-AT12
  Scenario: Check whether the state of sub-asset class toggle is OFF at the Overview level (only) during the current app session (only).
    Given I login as type "overview_has_subclass"
    And I tap on the Allocation toggle
    When I go to Portfolio level Screen
    And I back to Overview Allocation class screen
    Then The sub-asset class toggle should stay OFF at the Overview level (only) during the current app session (only)


#  update in new sprint (class must has subClass)
#  @S2-AC1-AT9
#  Scenario: Check if not invested in a specific Asset Class within all of their Accounts.
#    Given I login as type "overview_has_subclass"
#    When I tap on the Allocation toggle
#    Then I should not see that sub-asset class listed
