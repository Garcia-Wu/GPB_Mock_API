@NotAutomatable
# Reason：This function has been modified in sprint14 or sprint15
@UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-318 @Sprint1_iOS
@Story_GPBM-746 @Sprint1_aOS

Feature: View asset breakdown by Region at Portfolio level

  As a client I want to see which geographic regions I have invested my money in within one Portfolio,
  so that I can make decisions regarding my investments based on regional factors that may influence investment performance

  Scenario: login in as userE for GPBM318
    Given I login as type "portfolio_has_region"
#    When I tap first item of Accounts list
#    And I tap first item of Portfolios list
    Then I should on the Portfolios level

  @S11-AC1-AT1
  @DependsOn('login_in_as_userE_for_GPBM318')
  Scenario: Check the Portfolio Level Screen UI for region
    Given I am on the Portfolios level
    When I tap on Asset Allocation toggle
    And I taps on "Region" tab
    Then I should see the following UI Elements on the Portfolios Class Level
      | element name                   | element value    |
      | Portfolio name                 |                  |
      | Portfolio id                   |                  |
      | Total Assets title             | Portfolio assets |
#      | info icon                     |               |
      | Total Assets value             |                  |
#      | Currency label                |               |
      | Allocation button              |                  |
      | Class tab                      | Class            |
      | Currency tab                   | Currency         |
      | Region tab                     | Region           |
      | Asset Breakdown list of Region |                  |
      | back button                    |                  |
      | menu icon                      |                  |

  @NotAutomatable
  Scenario: Check the statues of Allocation & Region tab
    Given I am on the Portfolio level screen
    Then I should see the following states:
  # Allocation Toggle = ACTIVE
  # Region tab = ACTIVE
  # S11-AC1-AT2
  # Reason: cannot check the state of Allocation&Region


  @S11-AC1-AT3
  @DependsOn('login_in_as_userE_for_GPBM318')
  Scenario: Check the data of each asset Region that they are invested in
    Given I am on the Portfolios level
    Then I should see Region tab the following data format:Region name、Total asset ISO3 format value、Total asset 2dp format value、Total asset 2dp percentage value

  @NotAutomatable
  Scenario: Check the horizontal bar
    Given I am on the Portfolio level screen
    Then I should see horizontal bar representing % of assets owned
  # S11-AC1-AT4
  # Reason: cannot check the bar



  @S11-AC1-AT5
  @DependsOn('login_in_as_userE_for_GPBM318')
  Scenario: Check the sequence of the Portfolios Asset Region By Total Assets
    Given I am on the Portfolios level
    Then I should see the regions are ordered by Total Asset value - largest (first) to smallest (last) on Region module


  @S11-AC1-AT6
  Scenario: Check if not invested in a specific Region
    Given I login as type "portfolio_no_region"
#    When I tap fourth item of Accounts List
#    And I tap 16th item of Portfolio List
    And I tap on Asset Allocation toggle
    And I taps on "Region" tab
    Then I should not see Portfolio that Region listed

