@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-3563 @Sprint16_iOS
@Story_GPBM-3608 @Sprint16_aOS

Feature: Currency list at Account level

  As a Client I want a view of my entire currency exposure in an account, regardless of negative or positive holdings
  So that I have the full information of my currency exposure to make any required investment decisions


#  Scenario 1: Access list view via Asset Allocation graphic
  @S3563-AC1-AT1
  Scenario: Check whether I can be taken to the Account Currency Allocation list view page when I swipe up from the bottom of the Account Allocation Currency graphic view page
    Given I login as type "account_currency_has_positive"
    And I tap on the Allocation toggle
    And I tap on Currency tab
    When I swipe up from the bottom of the allocation graphic page
    Then I am taken to the Asset Allocation list view page
#    And the Currency tab is displayed by default
#  Reason：Reason: can not check tab selected

#  Scenario 2: Access list view via overview page
  @S3563-AC2-AT1
  Scenario: Check whether I can be taken to the Account Currency Allocation list view page when I tap the Asset Allocation toggle
    Given I login as type "account_currency_has_positive"
    And the Account wrapper is minifiles
    And I tap on the Allocation toggle
    When I tap on Currency tab
#    Then the toggle becomes ACTIVE
    Then I am taken to the Asset Allocation list view page
#    And the Currency tab is displayed
#  Reason：Reason: can not check tab selected and toggle status

#  Scenario 3: Positive Currency total holding value
  @SIT
  Scenario: Positive Currency in Account Allocation Currency list
    Given I login as type "account_currency_list_has_positive"
    And I tap on the Allocation toggle
    And I tap on Currency tab
    When I swipe up from the bottom of the allocation graphic page
    Then I should see the allocation list

  @S3563-AC3-AT1
  @DependsOn('Positive_Currency_in_Account_Allocation_Currency_list')
  Scenario: Check the Positive Currency in Account Allocation Currency list
    Given I am see the allocation list
    Then I should see the following information:
      | element name                              | element value |
      | Currency name label                       |               |
      | Total Currency value (for account)        |               |
      | Account base currency                     |               |
      | Total Currency value (for account) as a % |               |
#      | Donut bar representing % of assets owned for particular Currency                                  |               |
#      | Donut bar for the currency matches the position shown in the graphic to represent positive assets |               |

  @S3563-AC3-AT2
  @DependsOn('Positive_Currency_in_Account_Allocation_Currency_list')
  Scenario: Check the Positive Currency wrapper above Account Allocation Currency list
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


  @S3563-AC3-AT3
  @SIT
  @DependsOn('Positive_Currency_in_Account_Allocation_Currency_list')
  Scenario: Check the format of Total Asset Class value/ Account base currency/weight in Account Allocation Currency list and "Account Assets" value/Account base currency in the wrapper when Currency value is Positive
    Given I am see the allocation list
    Then I should see Total Currency value in base currency(ISO 3 format and 2dp format)
    And I should see Total Currency value as a %(2dp format)
#   And I should see Total Assets value in base currency(ISO 3 format and 2dp format) in the allocation wrapper

  @NotAutomatable
  @S3563-AC3-AT4
  Scenario: Check the color and the position of the pie-char in the Account Allocation Currency list view when the Currency value is Positive
    Then I should see there are one color in the pie-char
    And the color in pie-char is same to the color that I see in the Account Allocation Currency graphic pie-char within the current Account
    And the position in pie-char is same to the position that I see in the Account Allocation Currency graphic pie-char within the current Account
    #    Reason: can not check the graphic pie-char color and position

#  Scenario 4: Negative Currency total holding value
  @SIT
  Scenario: Negative Currency in Account Allocation Currency list
    Given I login as type "account_currency_list_has_negative"
    When I tap on the Allocation toggle
    And I tap on Currency tab
    And I swipe up from the bottom of the allocation graphic page
    Then I should see the allocation list

  @S3563-AC4-AT1
  @DependsOn('Negative_Currency_in_Account_Allocation_Currency_list')
  Scenario: Check the Negative Currency in Account Allocation Currency list
    Given I am see the allocation list
    Then I should see the following information:
      | element name                              | element value |
      | Currency name label                       |               |
      | Total Currency value (for account)        |               |
      | Account base currency                     |               |
      | Total Currency value (for account) as a % |               |
#      | Donut bar representing % of assets owned for particular Currency |               |
#      | Donut bar is an empty circle to represent negative assets        |               |

  @S3563-AC4-AT2
  @DependsOn('Negative_Currency_in_Account_Allocation_Currency_list')
  Scenario: Check the Negative Currency wrapper above Account Allocation Currency list
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

  @S3563-AC4-AT3
  @SIT
  @DependsOn('Negative_Currency_in_Account_Allocation_Currency_list')
  Scenario: Check the format of Total Asset Class value/ Account base currency/weight in Account Allocation Currency list and "Account Assets" value/Account base currency in the wrapper when Currency value is Negative
    Given I am see the allocation list
    Then I should see Total Currency value in base currency(ISO 3 format and 2dp format)
    And I should see Total Currency value as a %(2dp format)
#   And I should see Total Assets value in base currency(ISO 3 format and 2dp format) in the allocation wrapper

#  Scenario 5: Client does not have holdings in a Currency
  @NotAutomatable
  @S3563-AC5-AT1
  Scenario: Check whether the Currency is NOT shown on the list when Client does not have holdings in an Currency
    Given I am at Account level
    And I am on the Asset Allocation list view page
    And I am entitled to view an account
    And the Currency tab is selected
    And I do not have any holdings in a particular Currency
    When I view the page
    Then The Currency is NOT shown on the list
#    Reason: don't know which region not have holdings

#  Scenario 6: Client does not have any holdings in any Currency - Edge
  @Sprint18
  @S3563-AC6-AT1
  Scenario: Check whether There is no Currency list to be displayed when Client does not have any holdings in any Currency at account
    Given I login as type "account_currency_all_no_holdings"
    And I tap on the Allocation toggle
    And I tap on Currency tab
    And I swipe up from the bottom of the allocation graphic page
    When There is no Currency list to be displayed
    Then there is copy to state that I have not got any investments:
      | element name | element value                                                              |
      | state copy   | Exposure by currency unavailable as there are no holdings in your account. |

#  Scenario 7: Exit Asset Allocation Mode via toggle
  @S3563-AC7-AT1
  Scenario: Check whether I can exit Account Currency Allocation Mode when I tap on the Asset Allocation toggle
    Given I login as type "account_currency_list_has_positive"
    And I tap on the Allocation toggle
    And I tap on Currency tab
    And I swipe up from the bottom of the allocation graphic page
#    And Asset Allocation toggle is ACTIVE
    When I tap on the Allocation toggle
#    Then The toggle becomes the INACTIVE state
    Then I am returned back to the Account page
    And the Account wrapper should be minifiles
#  Reason：Reason: can not check toggle status

#  Scenario 8: Exit Asset Allocation Mode via breadcrumb
  @S3563-AC8-AT1
  Scenario: Check whether I can exit Account Currency Allocation Mode when When I tap on the breadcrumb
    Given I login as type "account_currency_list_has_positive"
    And I tap on the Allocation toggle
    And I tap on Currency tab
    And I swipe up from the bottom of the allocation graphic page
    When I tap on the account breadcrumb (back button)
    Then I am returned back to the Overview page
    And the Overview wrapper is maximised

  @S3563-AC8-AT2
  Scenario: Check whether the Account name/Account assets/Base Currency in the Account alloation Currency wrapper willl be changed with the current account when I swipe left or right the pips above Account allocation Currency list view
    Given I login as type "account_currency_list_wrapper_left_change"
    And I tap on the Allocation toggle
    And I tap on Currency tab
    And I swipe up from the bottom of the allocation graphic page
    When I swipe left the pips on allocation list(wrapper)
    Then I should see the Account name/Account assets in the allocation Currency wrapper will be changed with the current account

  @S3563-AC8-AT3
  Scenario: Check whether the Account allocation Currency list view willl be changed with the current account when I swipe left or right the pips above Account allocation Currency list view
    Given I login as type "account_currency_list_left_change"
    And I tap on the Allocation toggle
    And I tap on Currency tab
    And I swipe up from the bottom of the allocation graphic page
    When I swipe left the pips on allocation list
    Then I should see the Account allocation Currency list view will be changed with the current account

  @S3563-AC8-AT4
  Scenario: Check whether the "Others" Currency will be displayed in 8th position of the Account Allocation Currency list view
    Given I login as type "account_currency_list_more_than_8_item"
    And I tap on the Allocation toggle
    And I tap on Currency tab
    When I swipe up from the bottom of the allocation graphic page
    Then I should see the "Others" Currency will be displayed in 8th position of the Allocation Currency list view

  @S3563-AC8-AT5
  Scenario: Check whether the "Others" Currency key will be displayed in 8th position of the Account Allocation Currency key view
    Given I login as type "account_currency_list_more_than_8_item_position"
    And I tap on the Allocation toggle
    When I tap on Currency tab
    Then I should see the "Others" Currency key will be display last in the Allocation Currency key view

  @S3563-AC8-AT6
  @SIT
  Scenario: Check the order of Account Allocation Currency list
    Given I login as type "account_currency_list_order"
    And I tap on the Allocation toggle
    And I tap on Currency tab
    When I swipe up from the bottom of the allocation graphic page
    Then The Regions will be ordered from largest to smallest based on market value in reference currency,then by alphabetical order, and negative values are present, negative values will be listed AFTER all positive values have been listed, with the largest negative value shown first
#  (Example with 6 asset classes, 3 positive, 3 negative: 300 > 250 > 100 > -200 > -100 > -50)

  @S3563-AC8-AT7
  Scenario: Check the Currency in Account Allocation Currency list when the Asset Currency value is 0.00
    Given I login as type "account_currency_list_one_zero"
    And I tap on the Allocation toggle
    And I tap on Currency tab
    When I swipe up from the bottom of the allocation graphic page
    Then I should see the following information:
      | element name              | element value |
      | Region name label         |               |
      | Total Asset value         | 0.00          |
      | Overview base currency    |               |
      | Total Region value as a % |               |
#      | Donut bar representing % of assets owned for particular Currency |               |
#      | Donut bar is an empty circle to represent negative assets        |               |
