@NotAutomatable
# Reason：This function has been modified in sprint14 or sprint15
@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-321 @Sprint1_iOS
@Story_GPBM-749 @Sprint1_aOS

Feature: View asset currency breakdown at Portfolio level

  As a client I want to view a Portfolio summary of my assets grouped by currency,
  so that I know which currencies I am invested in

  userM: has more account、more portfolios and no currency

#  securities purchased in <9 currencies within a portfolio

  @S12-AC1-AT1
  Scenario: Check the Portfolio Level Screen UI for currency
    Given I login as type "portfolio_currency_list_less_than_9"
    And I tap on the Allocation toggle
    And I taps the Currency tap in Portfolio level
    Then I should see the following UI Elements on the Portfolios Currency
      | element region | element name                     | element value    |
      |                | Portfolio name                   |                  |
      |                | Portfolio id                     |                  |
      |                | Total Assets title               | Portfolio assets |
#      | info icon                        |               |
      |                | Total Assets value               |                  |
#      | Currency label                   |               |
      |                | Allocation button                |                  |
      |                | Class tab                        | Class            |
      |                | Currency tab                     | Currency         |
      | UK             | Region tab                       | Region           |
      |                | Asset Breakdown list of Currency |                  |
      |                | back button                      |                  |
      |                | menu icon                        |                  |

  @NotAutomatable
  Scenario: Check the statues of Allocation $ Currency tab
    Given I am on the Portfolio level
    Then I should see the following states:
  # Allocation Toggle = ACTIVE
  # Currency tab = ACTIVE
  # S12-AC1-AT2
  # Reason: cannot check the state of Allocation&Currency

  Scenario: login in as userM for GPBM321
    Given I login as type "portfolio_currency_list_less_than_9"
#    When I taps on 2nd items in Accounts list
#    And I tap first item of Portfolios list
    Then I should on the Portfolios level


  @S12-AC1-AT3
  @DependsOn('login_in_as_userM_for_GPBM321')
  Scenario: Check the data of each asset Currency that they are invested in
    Given I am on the Portfolios level
    When I tap on the Allocation toggle
    And I taps the Currency tap in Portfolio level
    Then I should see the following data for Portfolios Currency name、Total asset ISO3 format value、Total asset 2dp format value、Total assets 2dp percentage value

  @NotAutomatable
  Scenario: Check the horizontal bar
    Given I am on the Portfolio level
    Then I should see A horizontal bar reflecting the % of assets owned
  # S12-AC1-AT4
  # Reason: cannot check the bar

  @S12-AC1-AT5
  @DependsOn('login_in_as_userM_for_GPBM321')
  Scenario: Check the sequence of the Asset Currency By Total Assets
    Given I am on the Portfolios level
    Then I should see the portfolios currencies are ordered by Total Asset value - largest (first) to smallest (last), then by alphabetical order

# Currency label id 不存在，info icon visible 属性为false
  @S12-AC1-AT6
  Scenario: Check the Portfolio Level Screen UI courses greater than 8 courses
    Given I login as type "portfolio_currency_list_greater_than_8"
#    When I taps on 2nd items in Accounts list
#    And I tap 3rd of Portfolios List
    And I tap on the Allocation toggle
    And I taps the Currency tap in Portfolio level
    Then I should see the following UI Elements on the Portfolios Currency
      | element region | element name                     | element value    |
      |                | Portfolio name                   |                  |
      |                | Portfolio id                     |                  |
      |                | Total Assets title               | Portfolio assets |
#      | info icon3                       |               |
      |                | Total Assets value               |                  |
#      | Currency label3                  |               |
      |                | Allocation button                |                  |
      |                | Class tab                        | Class            |
      |                | Currency tab                     | Currency         |
      | UK             | Region tab                       | Region           |
      |                | Asset Breakdown list of Currency |                  |
      |                | back button                      |                  |
      |                | menu icon                        |                  |

#  securities purchased in >8 currencies within a portfolio
  @NotAutomatable
  Scenario: Check the statues of Allocation $ Currency tab
    Given I am on the Portfolio level
    Then I should see the following states:
  # Allocation Toggle = ACTIVE
  # Currency tab = ACTIVE
  # S12-AC1-AT7
  # Reason: cannot check the state of Allocation&Currency

  @S12-AC1-AT8
  Scenario: Check the data of "Other" in Asset Currency
    Given I login as type "portfolio_currency_list_greater_than_8"
#    When I tap first item of Accounts list
#    And I tap 3rd of Portfolios List
    And I tap on the Allocation toggle
    And I taps the Currency tap in Portfolio level
    And I scroll down to the portfolios currency bottom
    Then I should see the portfolio currency following data:
      | element name                     | element value |
      | Other label                      | Other         |
      | Total asset ISO3 format value    |               |
      | Total asset 2dp format value     |               |
      | Total asset 2dp percentage value |               |

  @NotAutomatable
  Scenario: Check the horizontal bar
    Given I am on the Portfolio level
    When I scroll down to the bottom
    Then I should see A horizontal bar reflecting the % of assets owned
  # S12-AC1-AT9
  # Reason: cannot check the bar


  @NotAutomatable
  Scenario: Check whether the "Other" category is at the bottom
    Given I am on the Portfolio level
    When I scroll down to the bottom
    Then I should see‘Other’ category is always at the bottom of the list, even if its combined total has a higher value than 1 or more of the 7 currencies already listed.
  # S12-AC1-AT10
  # Reason: cannot check Other position

  @S12-AC1-AT11
  Scenario: Check if not invested in specific Currency
    Given I login as type "portfolio_no_currency"
#    And I tap fourth item of Accounts List
#    And I tap 16th item of Portfolios list
    When I taps the Allocation Toggle ON in Portfolio level
    And I taps the Currency tap in Portfolio level
    Then I should not see that portfolio currency listed
