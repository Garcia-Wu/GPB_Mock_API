@NotAutomatable
# Reason：This function has been modified in sprint14 or sprint15
@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-314 @Sprint1_iOS
@Story_GPBM-740 @Sprint1_aOS

Feature: View asset class breakdown at Portfolio level

  As a client I want to view my asset allocation within one of my portfolios,
  so that I have a high level view of my investments by asset class

  @S9-AC1-AT1
  Scenario: Check the Portfolio Level Screen UI for class
    Given I login as type "portfolio_has_class"
#    When I tap first item of Accounts list
#    And I tap first item of Portfolios list
    And I tap on Asset Allocation toggle
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
  Scenario: Check the statues of Allocation & Class & Sub-asset Class Toggle
    Given I am on the Portfolio level screen
    Then I should see the following states:
  # Allocation Toggle = ACTIVE
  # Sub-Asset Class Toggle = Inactive
  # Class tab = ACTIVE
  # S9-AC1-AT2
  # Reason: cannot check the state of Allocation&Class&Sub-asset Class Toggle

  Scenario: login in as userE for GPBM314
    Given I login as type "portfolio_has_class"
#    When I tap first item of Accounts list
#    And I tap first item of Portfolios list
    Then I should on the Portfolios level

  @S9-AC1-AT3
  @DependsOn('login_in_as_userE_for_GPBM314')
  Scenario: Check the data of each Portfolio Asset Class that they are invested in
    Given I am on the Portfolios level
    When I taps the Allocation Toggle ON in Portfolio level
    Then I should see the following data for Asset Class name、Total asset ISO3 format value、Total asset 2dp format value、Total assets 2dp percentage value


  @NotAutomatable
  Scenario: Check the horizontal bar
    Given I am on the Portfolio level screen
    Then I should see A horizontal bar representing % of assets owned
  # S9-AC1-AT4
  # Reason: cannot check the bar


  @S9-AC1-AT5
  @DependsOn('login_in_as_userE_for_GPBM314')
  Scenario: Check the sequence of the Asset Class By Portfolio Total Assets
    Given I am on the Portfolios level
    Then I should see the asset classes are ordered by Total Asset value - largest first to smallest last, then by alphabetical order


  @S9-AC1-AT6
  Scenario: Check if not invested in a specific Asset Class within a portfolio
    Given I login as type "portfolio_no_class"
#    When I tap fourth item of Accounts List
#    And I tap 16th item of Portfolio List
    And I tap on Asset Allocation toggle
    Then I shouldn't see the asset classes listed in portfolio
