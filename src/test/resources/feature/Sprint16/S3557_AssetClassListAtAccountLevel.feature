@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-3557 @Sprint16_iOS
@Story_GPBM-3605 @Sprint16_aOS

Feature: Asset Class list at Account level

  As a Client I want a view of my entire asset class exposure in an account, regardless of negative or positive holdings
  So that I have the full information of my asset class exposure to make any required investment decisions


#  Scenario 1: Access list view via Asset Allocation graphic
  @S3557-AC1-AT1
  Scenario: Check whether I can be taken to the Account Asset Allocation list view page when I swipe up from the bottom of the Account Allocation asset class graphic view page
    Given I login as type "account_class_has_positive"
    And I tap on the Allocation toggle
    When I swipe up from the bottom of the allocation graphic page
    Then I am taken to the Asset Allocation list view page
#    And the Asset Class tab is displayed by default


#  Scenario 2: Access list view via overview page
  @S3557-AC2-AT1
  Scenario: Check whether I can be taken to the Account Asset Allocation list view page when I tap the Asset Allocation toggle
    Given I login as type "account_class_has_positive"
    And the Account wrapper is minifiles
    When I tap on the Allocation toggle
    Then I am taken to the Asset Allocation list view page

#    Then the toggle becomes ACTIVE
#    And the Asset Class tab is displayed by default



#  Scenario 3: Positive Asset Class total holding value
  @SIT
  Scenario: Positive Asset Class in Account Allocation Currency list
    Given I login as type "account_class_list_has_positive"
    And I tap on the Allocation toggle
    When I swipe up from the bottom of the allocation graphic page
    Then I should see the allocation list

  @S3557-AC3-AT1
  @DependsOn('Positive_Asset_Class_in_Account_Allocation_Currency_list')
  Scenario: Check the Positive Asset Class in Account Allocation Asset Class list
    Given I am see the allocation list
    Then I should see the following information:
      | element name                                 | element value |
      | Asset Class name label                       |               |
      | Total Asset Class value                      |               |
      | Account base currency                        |               |
      | Total Asset Class value (for account) as a % |               |
#      | Donut bar representing % of assets owned for particular Asset Class                                  |               |
#      | Donut bar for the asset class matches the position shown in the graphic to represent positive assets |               |


  @S3557-AC3-AT2
  @DependsOn('Positive_Asset_Class_in_Account_Allocation_Currency_list')
  Scenario: Check the Positive Asset Class wrapper above Account Allocation Asset Class list
    Given I am see the allocation list
    Then I should see the wrapper above the list contains the following:
      | element region | element name            | element value |
      |                | Asset allocation label  |               |
      |                | Asset Allocation toggle |               |
      |                | Account Back button     |               |
      |                | Name label              |               |
#      |                | Total Assets label      | Account assets |
#      |                | Total Assets value      |                |
#      |                | Total Assets currency   |                |
      |                | Asset Class             | Asset class   |
      |                | Currency                | Currency      |
      | UK             | Region                  | Region        |
      |                | More menu icon          |               |


  @S3557-AC3-AT3
  @SIT
  @DependsOn('Positive_Asset_Class_in_Account_Allocation_Currency_list')
  Scenario: Check the format of Total Asset Class value/ Account base currency/weight in Account Allocation Asset Class list and "Account Assets" value/Account base currency in the wrapper when Asset Class value is Positive
    Given I am see the allocation list
    Then I should see Total Assets Class value in base currency (ISO 3 format and 2dp format)
    And I should see Total Assets Class value as a %(2dp format)
#   And I should see Total Assets value in base currency(ISO 3 format and 2dp format) in the allocation wrapper

  @NotAutomatable
  @S3557-AC3-AT4
  Scenario: Check the color and the position of the pie-char in the Account Allocation Asset Class list view when the Asset Class value is Positive
    Then I should see there are one color in the pie-char
    And the color in pie-char is same to the color that I see in the Account Allocation Asset Class graphic pie-char within the current Account
    And the position in pie-char is same to the position that I see in the Account Allocation Asset Class graphic pie-char within the current Account
    #    Reason: can not check the graphic pie-char color and position


#  Scenario 4: Negative Asset Class total holding value
  @SIT
  Scenario: Negative Asset Class in Account Allocation Asset Class list
    Given I login as type "account_class_list_has_negative"
    When I tap on the Allocation toggle
    And I swipe up from the bottom of the allocation graphic page
    Then I am see the allocation list


  @S3557-AC4-AT1
  @DependsOn('Negative_Asset_Class_in_Account_Allocation_Asset_Class_list')
  Scenario: Check the Negative Asset Class in Account Allocation Asset Class list
    Given I am see the allocation list
    Then I should see the following information:
      | element name                                 | element value |
      | Asset Class name label                       |               |
      | Total Asset Class value                      |               |
      | Account base currency                        |               |
      | Total Asset Class value (for account) as a % |               |
#      | Donut bar representing % of assets owned for particular Asset Class                                  |               |
#      | Donut bar is an empty circle to represent negative assets                                            |               |


  @S3557-AC4-AT2
  @DependsOn('Negative_Asset_Class_in_Account_Allocation_Asset_Class_list')
  Scenario: Check the Negative Asset Class wrapper above Account Allocation Asset Class list
    Given I am see the allocation list
    Then I should see the wrapper above the list contains the following:
      | element region | element name            | element value |
      |                | Asset allocation label  |               |
      |                | Asset Allocation toggle |               |
      |                | Account Back button     |               |
      |                | Name label              |               |
#      |                | Total Assets label      | Account assets |
#      |                | Total Assets value      |                |
#      |                | Total Assets currency   |                |
      |                | Asset Class             | Asset class   |
      |                | Currency                | Currency      |
      | UK             | Region                  | Region        |
      |                | More menu icon          |               |


  @S3557-AC4-AT3
  @SIT
  @DependsOn('Negative_Asset_Class_in_Account_Allocation_Asset_Class_list')
  Scenario: Check the format of Total Asset Class value/ Account base currency/weight in Account Allocation Asset Class list and "Account Assets" value/Account base currency in the wrapper when Asset Class value is Negative
    Given I am see the allocation list
    Then I should see Total Assets Class value in base currency (ISO 3 format and 2dp format)
    And I should see Total Assets Class value as a %(2dp format)
#   And I should see Total Assets value in base currency(ISO 3 format and 2dp format) in the allocation wrapper


#  Scenario 5: Client does not have holdings in an Asset Class
  @NotAutomatable
  @S3557-AC5-AT1
  Scenario: Check whether the Asset Class is NOT shown on the list when Client does not have holdings in an Asset Class
    Given I am at Account level
    And I am on the Asset Allocation list view page
    And I am entitled to view an account
    And the Asset Class tab is selected
    And I do not have any holdings in a particular Asset Class
    When I view the page
    Then The Asset Class is NOT shown on the list


#  Scenario 6: Client does not have any holdings in any Asset Class - Edge
  @Sprint18
  @S3557-AC6-AT1
  Scenario: Check whether There is no Asset Class list to be displayed when Client does not have any holdings in any Asset Class
    Given I login as type "account_class_all_no_holdings"
    And I tap on the Allocation toggle
    And I swipe up from the bottom of the allocation graphic page
    When There is no Asset Class list to be displayed
    Then there is copy to state that I have not got any investments:
      | element name | element value                                                                 |
      | state copy   | Exposure by asset class unavailable as there are no holdings in your account. |
#    And there is copy to state that I have not got any investments:"Exposure by asset class is unavailable because there are no holdings within your account"


#  Scenario 7: Exit Asset Allocation Mode via toggle
  @S3557-AC7-AT1
  Scenario: Check whether I can exit Account Asset Allocation Mode when I tap on the Asset Allocation toggle
    Given I login as type "account_class_list_has_positive"
    And I tap on the Allocation toggle
    And I swipe up from the bottom of the allocation graphic page
#    And Asset Allocation toggle is ACTIVE
    When I tap on the Allocation toggle
#    Then The toggle becomes the INACTIVE state
    Then I am returned back to the Account page
    And the Account wrapper should be minifiles
#    And the Account wrapper is minimised


#  Scenario 8: Exit Asset Allocation Mode via breadcrumb
  @S3557-AC8-AT1
  Scenario: Check whether I can exit Account Asset Class Allocation Mode when When I tap on the breadcrumb
    Given I login as type "account_class_list_has_positive"
    And I tap on the Allocation toggle
    And I swipe up from the bottom of the allocation graphic page
    When I tap on the account breadcrumb (back button)
    Then I am returned back to the Overview page
    And the Overview wrapper is maximised

  @S3557-AC8-AT2
  Scenario: Check whether the Account name/Account assets/Base Currency in the Account alloation Asset Class wrapper willl be changed with the current account when I swipe left or right the pips above Account allocation Asset Class list view
    Given I login as type "account_class_list_wrapper_left_change"
    And I tap on the Allocation toggle
    And I swipe up from the bottom of the allocation graphic page
    When I swipe left the pips on allocation list(wrapper)
    Then I should see the Account name/Account assets in the allocation Asset Class wrapper will be changed with the current account

  @S3557-AC1-AT3
  Scenario: Check whether the Account allocation Asset Class list view willl be changed with the current account when I swipe left or right the pips above Account allocation Asset Class list view
    Given I login as type "account_class_list_left_change"
    And I tap on the Allocation toggle
    And I swipe up from the bottom of the allocation graphic page
    When I swipe left the pips on allocation list
    Then I should see the Account allocation Currency list view will be changed with the current account

  @S3557-AC1-AT4
  Scenario: Check whether the "Others" Asset Class will be displayed last in the Account Allocation Asset Class list view
    Given I login as type "account_class_list_more_than_8_item"
    And I tap on the Allocation toggle
    When I swipe up from the bottom of the allocation graphic page
    Then I should see the "Others" Asset Class will be displayed in 8th position of the Allocation Asset Class list view
#    Then I should see the "Others" Asset Class will be displayed last in the Account Allocation Asset Class list view

  @S3557-AC1-AT5
  Scenario: Check whether the "Others" Asset Class key will be displayed last in the Account Allocation Asset Class key view
    Given I login as type "account_class_list_more_than_8_item_position"
    When I tap on the Allocation toggle
    Then I should see the "Others" Asset Class key will be display last in the Allocation Asset Class key view
#    Then I should see the "Others" Asset Class key will be displayed last in the Account Allocation Asset Class key view

  @S3557-AC1-AT6
  @SIT
  Scenario: Check the order of Account Allocation Asset Class list
    Given I login as type "account_class_list_order"
    And I tap on the Allocation toggle
    When I swipe up from the bottom of the allocation graphic page
    Then The Regions will be ordered from largest to smallest based on market value in reference currency,then by alphabetical order, and negative values are present, negative values will be listed AFTER all positive values have been listed, with the largest negative value shown first
#    Then The Asset Classes will be ordered from largest to smallest (left to right, top to bottom) based on market value in Account reference currency,then by alphabetical order
#    And negative values are present, negative values will be listed AFTER all positive values have been listed, with the largest negative value shown first
#  (Example with 6 asset classes, 3 positive, 3 negative: 300 > 250 > 100 > -200 > -100 > -50)


  @S3557-AC1-AT7
  Scenario: Check the Asset Class in Account Allocation Asset Class list when the Asset Class value is 0.00
    Given I login as type "account_class_list_one_zero"
    And I tap on the Allocation toggle
    When I swipe up from the bottom of the allocation graphic page
    Then I should see the following information:
      | element name              | element value |
      | Region name label         |               |
      | Total Asset value         | 0.00          |
      | Overview base currency    |               |
      | Total Region value as a % |               |

#      | Donut bar representing % of assets owned for particular Asset Class                    |               |
#      | Donut bar is an empty circle to represent the assets                                   |               |
