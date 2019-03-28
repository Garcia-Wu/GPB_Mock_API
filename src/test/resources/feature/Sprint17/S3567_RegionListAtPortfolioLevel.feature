@UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-3567 @Sprint17_iOS
@Story_GPBM-3612 @Sprint17_aOS

Feature: Region list at Portfolio level

  As a Client I want a view of my entire region exposure in a portfolio, regardless of negative or positive holdings
  So that I have the full information of my region exposure to make any required investment decisions


#  Scenario 1: Access list view via Asset Allocation graphic
  @S3567-AC1-AT1
  Scenario: Check whether I can be taken to the Portfolio Region Allocation list view page when I swipe up from the bottom of the Portfolio Allocation Region graphic view page
    Given I login as type "portfolio_region_list_has_positive"
    And I tap on the Allocation toggle
    And I tap on Region tab
    When I swipe up from the bottom of the allocation graphic page
    Then I am taken to the Asset Allocation list view page

#  Scenario 2: Access list view via overview page
  @S3567-AC2-AT1
  Scenario: Check whether I can be taken to the Portfolio Region Allocation list view page when I tap the Asset Allocation toggle
    Given I login as type "portfolio_region_has_positive"
    And the Portfolio wrapper is minimised
    When I tap on the Allocation toggle
    And I tap on Region tab
    Then I am taken to the Asset Allocation list view page

#  Scenario 3: Positive Region total holding value
  @SIT
  Scenario: Positive Region in Portfolio Allocation Region list
    Given I login as type "portfolio_region_list_has_positive"
    When I tap on the Allocation toggle
    And I tap on Region tab
    When I swipe up from the bottom of the allocation graphic page
    Then I should see the allocation list

  @S3567-AC3-AT1
  @DependsOn('Positive_Region_in_Portfolio_Allocation_Region_list')
  Scenario: Check the Positive Region in Portfolio Allocation Region list
    Given I am see the allocation list
    Then I should see the following information:
      | element name                            | element value |
      | Region name label                       |               |
      | Total Region value (for account)        |               |
      | Portfolio base currency                 |               |
      | Total Region value (for account) as a % |               |

  @S3567-AC3-AT2
  @DependsOn('Positive_Region_in_Portfolio_Allocation_Region_list')
  Scenario: Check the Positive Region wrapper above Portfolio Allocation Region list
    Given I am see the allocation list
    Then I should see the wrapper above the list contains the following:
      | element region | element name            | element value    |
      |                | Asset allocation label  | Asset allocation |
      |                | Asset Allocation toggle |                  |
      |                | Portfolio Back button   |                  |
      |                | Name label              |                  |
      |                | Total Assets label      | Portfolio assets |
      |                | Total Assets value      |                  |
#      |                | Total Assets currency   |                  |
      |                | Asset Class             | Asset class      |
      |                | Currency                | Currency         |
      | UK             | Region                  | Region           |
      |                | More menu icon          |                  |

  @S3567-AC3-AT3
  @SIT
  @DependsOn('Positive_Region_in_Portfolio_Allocation_Region_list')
  Scenario: Check the format of Total Asset Class value/ Portfolio base currency/weight in Portfolio Allocation Region list and "Portfolio Assets" value/Portfolio base currency in the wrapper when Region value is Positive
    Given I am see the allocation list
    Then I should see Total Region value in base currency(ISO 3 format and 2dp format)
    And I should see Total Region value as a %(2dp format)
    And I should see Total Assets value in base currency(ISO 3 format and 2dp format) in the allocation wrapper

  @NotAutomatable
  @S3567-AC3-AT4
  Scenario: Check the color and the position of the pie-char in the Portfolio Allocation Region list view when the Region value is Positive
    Then I should see there are one color in the pie-char
    And the color in pie-char is same to the color that I see in the Portfolio Allocation Region graphic pie-char within the current Portfolio
    And the position in pie-char is same to the position that I see in the Portfolio Allocation Region graphic pie-char within the current Portfolio
    #    Reason: can not check the graphic pie-char color and position

#  Scenario 4: Negative Region total holding value
  @SIT
  Scenario: Negative Region in Portfolio Allocation Region list
    Given I login as type "portfolio_region_list_has_negative"
    When I tap on the Allocation toggle
    And I tap on Region tab
    And I swipe up from the bottom of the allocation graphic page
    Then I should see the allocation list

  @S3567-AC4-AT1
  @DependsOn('Negative_Region_in_Portfolio_Allocation_Region_list')
  Scenario: Check the Negative Region in Portfolio Allocation Region list
    Given I am see the allocation list
    Then I should see the following information:
      | element name                            | element value |
      | Region name label                       |               |
      | Total Region value (for account)        |               |
      | Portfolio base currency                 |               |
      | Total Region value (for account) as a % |               |
#      |  Donut bar representing % of assets owned for particular Region            |               |
#      |  Donut bar is an empty circle to represent negative assets            |               |

  @S3567-AC4-AT2
  @DependsOn('Negative_Region_in_Portfolio_Allocation_Region_list')
  Scenario: Check the Negative Region wrapper above Portfolio Allocation Region list
    Given I am see the allocation list
    Then I should see the wrapper above the list contains the following:
      | element region | element name            | element value    |
      |                | Asset allocation label  | Asset allocation |
      |                | Asset Allocation toggle |                  |
      |                | Portfolio Back button   |                  |
      |                | Name label              |                  |
      |                | Total Assets label      | Portfolio assets |
      |                | Total Assets value      |                  |
#      |                | Total Assets currency   |                  |
      |                | Asset Class             | Asset class      |
      |                | Currency                | Currency         |
      | UK             | Region                  | Region           |
      |                | More menu icon          |                  |

  @S3567-AC4-AT3
  @SIT
  @DependsOn('Negative_Region_in_Portfolio_Allocation_Region_list')
  Scenario: Check the format of Total Asset Class value/ Portfolio base currency/weight in Portfolio Allocation Region list and "Portfolio Assets" value/Portfolio base currency in the wrapper when Region value is Negative
    Given I am see the allocation list
    Then I should see Total Region value in base currency(ISO 3 format and 2dp format)
    And I should see Total Region value as a %(2dp format)
    And I should see Total Assets value in base currency(ISO 3 format and 2dp format) in the allocation wrapper

#  Scenario 5: Client does not have holdings in a Region
  @NotAutomatable
  @S3567-AC5-AT1
  Scenario: Check whether the Region is NOT shown on the list when Client does not have holdings in an Region
    Given I am at Portfolio level
    And I am on the Asset Allocation list view page
    And I am entitled to view an account
    And the Region tab is selected
    And I do not have any holdings in a particular Region
    When I view the page
    Then The Region is NOT shown on the list
#    Reason: don't know which region not have holdings

#  Scenario 6: Client does not have any holdings in any Region - Edge
  @Sprint18
  @S3567-AC6-AT1
  Scenario: Check whether There is no Region list to be displayed when Client does not have any holdings in any Region at portfolio
    Given I login as type "portfolio_region_all_no_holdings"
    When I tap on the Allocation toggle
    And I tap on Region tab
    And I swipe up from the bottom of the allocation graphic page
    Then There is no Region list to be displayed
    And there is copy to state that I have not got any investments:
      | element name | element value                                                              |
      | state copy   | Exposure by region unavailable as there are no holdings in your portfolio. |

#  Scenario 7: Exit Asset Allocation Mode via toggle
  @S3567-AC7-AT1
  Scenario: Check whether I can exit Portfolio Region Allocation Mode when I tap on the Asset Allocation toggle
    Given I login as type "portfolio_region_list_has_positive"
    And I tap on the Allocation toggle
    And I tap on Region tab
    And I swipe up from the bottom of the allocation graphic page
    When I tap on the Allocation toggle
    And I am returned back to the Portfolio page
    And the Portfolio wrapper should be minimised

#  Scenario 8: Exit Asset Allocation Mode via breadcrumb
  @S3567-AC8-AT1
  Scenario: Check whether I can exit Portfolio Region Allocation Mode when When I tap on the breadcrumb
    Given I login as type "account_wrapper_max"
    And I tap on the Allocation toggle
    And I tap on Region tab
    And I swipe up from the bottom of the allocation graphic page
    When I tap on the portfolio breadcrumb (back button)
    And I am returned back to the Account page
    And the Account wrapper should be maximised

  @S3567-AC8-AT2
  Scenario: Check whether the Portfolio name/Portfolio assets/Base Currency in the Portfolio alloation Region wrapper willl be changed with the current account when I swipe left or right the pips above Portfolio allocation Region list view
    Given I login as type "portfolio_region_list_wrapper_left_change"
    And I tap on the Allocation toggle
    And I tap on Region tab
    And I swipe up from the bottom of the allocation graphic page
    When I swipe left the pips on allocation list(wrapper)
    Then I should see the Portfolio name/Portfolio assets in the allocation Region wrapper will be changed with the current account

  @S3567-AC8-AT3
  Scenario: Check whether the Portfolio allocation Region list view will be changed with the current account when I swipe left or right the pips above Portfolio allocation Region list view
    Given I login as type "portfolio_region_list_left_change"
    And I tap on the Allocation toggle
    And I tap on Region tab
    And I swipe up from the bottom of the allocation graphic page
    When I swipe left the pips on allocation list
    Then I should see the Portfolio allocation Region list view will be changed with the current account

  @S3567-AC8-AT4
  Scenario: Check whether the "Others" Region will be displayed in 8th position of the Portfolio Allocation Region list view
    Given I login as type "portfolio_region_list_more_than_8_item"
    And I tap on the Allocation toggle
    And I tap on Region tab
    And I swipe up from the bottom of the allocation graphic page
    Then I should see the "Others" Region will be displayed in 8th position of the Allocation Region list view

  @S3567-AC8-AT5
  Scenario: Check whether the "Others" Region key will be displayed in 8th position of the Portfolio Allocation Region key view
    Given I login as type "portfolio_region_list_more_than_8_item_positive"
    And I tap on the Allocation toggle
    And I tap on Region tab
    Then I should see the "Others" Region key will be displayed in 8th position of the Allocation Region key view

  @S3567-AC8-AT6
  @SIT
  Scenario: Check the order of Portfolio Allocation Region list
    Given I login as type "portfolio_region_list_order"
    And I tap on the Allocation toggle
    And I tap on Region tab
    And I swipe up from the bottom of the allocation graphic page
    Then The Regions will be ordered from largest to smallest based on market value in reference currency,then by alphabetical order, and negative values are present, negative values will be listed AFTER all positive values have been listed, with the largest negative value shown first
#  (Example with 6 asset classes, 3 positive, 3 negative: 300 > 250 > 100 > -200 > -100 > -50)

  @S3567-AC8-AT7
  Scenario: Check the Region in Portfolio Allocation Region list when the Asset Region value is 0.00
    Given I login as type "portfolio_region_list_one_zero"
    And I tap on the Allocation toggle
    And I tap on Region tab
    And I swipe up from the bottom of the allocation graphic page
    Then I should see the following information:
      | element name              | element value |
      | Region name label         |               |
      | Total Asset value         | 0.00          |
      | Overview base currency    |               |
      | Total Region value as a % |               |
#      | Donut bar representing % of assets owned for particular Region |               |
#      | Donut bar is an empty circle to represent negative assets      |               |
