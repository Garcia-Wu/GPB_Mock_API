@UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-3566 @Sprint16_iOS
@Story_GPBM-3611 @Sprint16_aOS

Feature: Region list at Account level

  As a Client I want a view of my entire region exposure in an account, regardless of negative or positive holdings
  So that I have the full information of my region exposure to make any required investment decisions


#  Scenario 1: Access list view via Asset Allocation graphic
  @S3566-AC1-AT1
  Scenario: Check whether I can be taken to the Account Region Allocation list view page when I swipe up from the bottom of the Account Allocation Region graphic view page
    Given I login as type "account_region_has_positive"
    And I tap on the Allocation toggle
    And I tap on Region tab
    When I swipe up from the bottom of the allocation graphic page
    Then I am taken to the Asset Allocation list view page
#    And the Region tab is displayed by default
#   Reason: can not check tab selected

#  Scenario 2: Access list view via overview page
  @S3566-AC2-AT1
  Scenario: Check whether I can be taken to the Account Region Allocation list view page when I tap the Asset Allocation toggle
    Given I login as type "account_region_has_positive"
    And the Account wrapper is minifiles
    When I tap on the Allocation toggle
    And I tap on Region tab
#    Then the toggle becomes ACTIVE
    Then I am taken to the Asset Allocation list view page
#    And the Region tab is displayed
#  Reason: can not check toggle status and region tab is selected

#  Scenario 3: Positive Region total holding value
  @SIT
  Scenario: Positive Region in Account Allocation Region list
    Given I login as type "account_region_list_has_positive"
    When I tap on the Allocation toggle
    And I tap on Region tab
    And I swipe up from the bottom of the allocation graphic page
    Then I should see the allocation list

  @S3566-AC3-AT1
  @DependsOn('Positive_Region_in_Account_Allocation_Region_list')
  Scenario: Check the Positive Region in Account Allocation Region list
    Given I am see the allocation list
    Then I should see the following information:
      | element name                            | element value |
      | Region name label                       |               |
      | Total Region value (for account)        |               |
      | Account base currency                   |               |
      | Total Region value (for account) as a % |               |
#      | Donut bar representing % of assets owned for particular Region                                  |               |
#      | Donut bar for the region matches the position shown in the graphic to represent positive assets |               |

  @S3566-AC3-AT2
  @DependsOn('Positive_Region_in_Account_Allocation_Region_list')
  Scenario: Check the Positive Region wrapper above Account Allocation Region list
    Given I am see the allocation list
    Then I should see the wrapper above the list contains the following:
      | element region | element name            | element value  |
      |                | Asset allocation label  |                |
      |                | Asset Allocation toggle |                |
#      |                | Account Back button     |                |
      |                | Name label              |                |
#      |                | Total Assets label      | Account assets |
#      |                | Total Assets value      |                |
#      |                | Total Assets currency   |                |
      |                | Asset Class             | Asset class    |
      |                | Currency                | Currency       |
      | UK             | Region                  | Region         |
      |                | More menu icon          |                |

  @S3566-AC3-AT3
  @SIT
  @DependsOn('Positive_Region_in_Account_Allocation_Region_list')
  Scenario: Check the format of Total Asset Class value/ Account base currency/weight in Account Allocation Region list and "Account Assets" value/Account base currency in the wrapper when Region value is Positive
    Given I am see the allocation list
    Then I should see Total Region value in base currency(ISO 3 format and 2dp format)
    And I should see Total Region value as a %(2dp format)
#   And I should see Total Assets value in base currency(ISO 3 format and 2dp format) in the allocation wrapper

  @NotAutomatable
  @S3566-AC3-AT4
  Scenario: Check the color and the position of the pie-char in the Account Allocation Region list view when the Region value is Positive
    Then I should see there are one color in the pie-char
    And the color in pie-char is same to the color that I see in the Account Allocation Region graphic pie-char within the current Account
    And the position in pie-char is same to the position that I see in the Account Allocation Region graphic pie-char within the current Account
    #    Reason: can not check the graphic pie-char color and position

#  Scenario 4: Negative Region total holding value
  @SIT
  Scenario: Negative Region in Account Allocation Region list
    Given I login as type "account_region_list_has_negative"
    When I tap on the Allocation toggle
    And I tap on Region tab
    And I swipe up from the bottom of the allocation graphic page
    Then I should see the allocation list

  @S3566-AC4-AT1
  @DependsOn('Negative_Region_in_Account_Allocation_Region_list')
  Scenario: Check the Negative Region in Account Allocation Region list
    Given I am see the allocation list
    Then I should see the following information:
      | element name                            | element value |
      | Region name label                       |               |
      | Total Region value (for account)        |               |
      | Account base currency                   |               |
      | Total Region value (for account) as a % |               |
#      |  Donut bar representing % of assets owned for particular Region            |               |
#      |  Donut bar is an empty circle to represent negative assets            |               |

  @S3566-AC4-AT2
  @DependsOn('Negative_Region_in_Account_Allocation_Region_list')
  Scenario: Check the Negative Region wrapper above Account Allocation Region list
    Given I am see the allocation list
    Then I should see the wrapper above the list contains the following:
      | element region | element name            | element value  |
      |                | Asset allocation label  |                |
      |                | Asset Allocation toggle |                |
#      |                | Account Back button     |                |
      |                | Name label              |                |
#      |                | Total Assets label      | Account assets |
#      |                | Total Assets value      |                |
#      |                | Total Assets currency   |                |
      |                | Asset Class             | Asset class    |
      |                | Currency                | Currency       |
      | UK             | Region                  | Region         |
      |                | More menu icon          |                |

  @S3566-AC4-AT3
  @SIT
  @DependsOn('Negative_Region_in_Account_Allocation_Region_list')
  Scenario: Check the format of Total Asset Class value/ Account base currency/weight in Account Allocation Region list and "Account Assets" value/Account base currency in the wrapper when Region value is Negative
    Given I am see the allocation list
    Then I should see Total Region value in base currency(ISO 3 format and 2dp format)
    And I should see Total Region value as a %(2dp format)
#   And I should see Total Assets value in base currency(ISO 3 format and 2dp format) in the allocation wrapper

#  Scenario 5: Client does not have holdings in a Region
  @NotAutomatable
  @S3566-AC5-AT1
  Scenario: Check whether the Region is NOT shown on the list when Client does not have holdings in an Region
    Given I am at Account level
    And I am on the Asset Allocation list view page
    And I am entitled to view an account
    And the Region tab is selected
    And I do not have any holdings in a particular Region
    When I view the page
    Then The Region is NOT shown on the list
#    Reason: don't know which region not have holdings

#  Scenario 6: Client does not have any holdings in any Region - Edge
  @Sprint18
  @S3566-AC6-AT1
  Scenario: Check whether There is no Region list to be displayed when Client does not have any holdings in any Region at account
    Given I login as type "account_region_all_no_holdings"
    When I tap on the Allocation toggle
    And I tap on Region tab
    And I swipe up from the bottom of the allocation graphic page
    Then There is no Region list to be displayed
    And there is copy to state that I have not got any investments:
      | element name | element value                                                            |
      | state copy   | Exposure by region unavailable as there are no holdings in your account. |

#  Scenario 7: Exit Asset Allocation Mode via toggle
  @S3566-AC7-AT1
  Scenario: Check whether I can exit Account Region Allocation Mode when I tap on the Asset Allocation toggle
    Given I login as type "account_region_list_has_positive"
    And I tap on the Allocation toggle
    And I tap on Region tab
    And I swipe up from the bottom of the allocation graphic page
    When I tap on the Allocation toggle
#    Then The toggle becomes the INACTIVE state
    Then I am returned back to the Account page
    And the Account wrapper should be minifiles
#    Reason:can not check toggle state

#  Scenario 8: Exit Asset Allocation Mode via breadcrumb
  @S3566-AC8-AT1
  Scenario: Check whether I can exit Account Region Allocation Mode when When I tap on the breadcrumb
    Given I login as type "account_region_list_has_positive"
    And I tap on the Allocation toggle
    And I tap on Region tab
    And I swipe up from the bottom of the allocation graphic page
    When I tap on the account breadcrumb (back button)
    Then I am returned back to the Overview page
    And the Overview wrapper is maximised

  @S3566-AC8-AT2
  Scenario: Check whether the Account name/Account assets/Base Currency in the Account alloation Region wrapper willl be changed with the current account when I swipe left or right the pips above Account allocation Region list view
    Given I login as type "account_region_list_wrapper_left_change"
    And I tap on the Allocation toggle
    And I tap on Region tab
    And I swipe up from the bottom of the allocation graphic page
    When I swipe left the pips on allocation list(wrapper)
    Then I should see the Account name/Account assets in the allocation Region wrapper will be changed with the current account

  @S3566-AC8-AT3
  Scenario: Check whether the Account allocation Region list view will be changed with the current account when I swipe left or right the pips above Account allocation Region list view
    Given I login as type "account_region_list_left_change"
    And I tap on the Allocation toggle
    And I tap on Region tab
    And I swipe up from the bottom of the allocation graphic page
    When I swipe left the pips on allocation list
    Then I should see the Account allocation Region list view will be changed with the current account

  @S3566-AC8-AT4
  Scenario: Check whether the "Others" Region will be displayed in 8th position of the Account Allocation Region list view
    Given I login as type "account_region_list_more_than_8_item"
    And I tap on the Allocation toggle
    And I tap on Region tab
    When I swipe up from the bottom of the allocation graphic page
    Then I should see the "Others" Region will be displayed in 8th position of the Allocation Region list view

  @S3566-AC8-AT5
  Scenario: Check whether the "Others" Region key will be displayed in 8th position of the Account Allocation Region key view
    Given I login as type "account_region_list_more_than_8_item_position"
    And I tap on the Allocation toggle
    When I tap on Region tab
    Then I should see the "Others" Region key will be displayed in 8th position of the Allocation Region key view

  @S3566-AC8-AT6
  @SIT
  Scenario: Check the order of Account Allocation Region list
    Given I login as type "account_region_list_order"
    And I tap on the Allocation toggle
    And I tap on Region tab
    When I swipe up from the bottom of the allocation graphic page
    Then The Regions will be ordered from largest to smallest based on market value in reference currency,then by alphabetical order, and negative values are present, negative values will be listed AFTER all positive values have been listed, with the largest negative value shown first
#  (Example with 6 asset classes, 3 positive, 3 negative: 300 > 250 > 100 > -200 > -100 > -50)

  @S3566-AC8-AT7
  Scenario: Check the Regio in Account Allocation Region list when the Asset Region value is 0.00
    Given I login as type "account_region_list_one_zero"
    And I tap on the Allocation toggle
    And I tap on Region tab
    When I swipe up from the bottom of the allocation graphic page
    Then I should see the following information:
      | element name              | element value |
      | Region name label         |               |
      | Total Asset value         | 0.00          |
      | Overview base currency    |               |
      | Total Region value as a % |               |
#      | Donut bar representing % of assets owned for particular Region |               |
#      | Donut bar is an empty circle to represent negative assets      |               |


