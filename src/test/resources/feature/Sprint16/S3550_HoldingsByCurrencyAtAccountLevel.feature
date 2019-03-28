@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-3550 @Sprint16_iOS
@Story_GPBM-3600 @Sprint16_aOS

Feature: Holdings by Currency at Account level

  As a client I want to see the individual holdings that make up my exposure to each Currency within an account
  So that I know which holdings to review in order to change my Currency exposure as desired

  @SIT
  Scenario: holding by Account allocation currency
    Given I login as type "account_currency_holdings_have_positive"
    Then I should on the allocation holding list

  #  Scenario 1: Access holdings per Currency via Allocation Graphic
  @S3550-AC1-AT1
  @DependsOn('holding_by_Account_allocation_currency')
  Scenario: Check the holding UI by Account allocation currency
    Given I am on the allocation holding list
    Then I am taken to the holdings view that shows a list of my holdings for the particular Currency within my account
    And I should see the wrapper contains the following:
      | element name             | element value |
      | Back button              |               |
      | Name value               |               |
      | Total assets value       |               |
      | Holdings label           | Holdings      |
      | Currency conversion icon |               |
      | donut graphic            |               |
      | More menu icon           |               |
#      | Pips indicating the number of different currencies invested in (informs user that they can swipe across currencies) |               |

  @S3550-AC1-AT2
  @SIT
  @DependsOn('holding_by_Account_allocation_currency')
  Scenario: Check whether the Account allocation currency holdings are ordered from largest to smallest based on market value in Account reference currency
    Given I am on the allocation holding list
    Then I should see the holdings are ordered from largest to smallest based on amount value

  @NotAutomatable
  @S3550-AC1-AT3
  Scenario: Check whether holding list is the same as in GPBM-2081
    Then the holdings detail is the same as in GPBM-2081
  #reason：Tested in Sprint6 S294_HoldingsListViewInAssetAllocationModeAtOverviewLevel.feature

  @S3550-AC1-AT4
  @SIT
  @DependsOn('holding_by_Account_allocation_currency')
  Scenario: Check whether the Account currency amount equals the sum of all holdings list value
    Given I am on the allocation holding list
    Then I should see the currency amount equals the sum of all holdings list value

  @S3550-AC1-AT5
  @SIT
  @DependsOn('holding_by_Account_allocation_currency')
  Scenario: Check format of Account base currency and Account Total assets value for the Region in Account allocation Currency holding wrapper
    Given I am on the allocation holding list
    Then I should see the allocation holdings wrapper base currency are displayed in ISO 3 code and 2 d.p. format
    And the allocation holdings list base currency is displayed in ISO 3 code format and 2 d.p. format

  @S3550-AC1-AT6
  Scenario: Check the graphic view in Account Allocation Currency holding wrapper When the Currency value is positive
    Given I login as type "account_currency_holdings_totalValue_is_positive"
    Then the currency weight is positive in the pie-char
#    Then I should see a graphic pie-char in Account allocation class holding wrapper,and there are one color in the pie-char,
#    And the color in graphic is same to the color that I see in the Account allocation Currency graphic pie-char within the current Currency
#    And the position in graphic is same to the position that I see in the Account allocation Currency graphic pie-char within the current Currency
# Remark:can not check color

  @S3550-AC1-AT7
  Scenario: Check the graphic view in Account Allocation Currency holding wrapper When the Currency value is negative
    Given I login as type "account_currency_holdings_totalValue_is_negative"
#    Then I should see a graphic pie-char in Account Allocation Currency holding wrapper
#  and there are no any color in the pie-char
    And I tap on the Allocation toggle
    And I swipe up from the bottom of the allocation graphic page
    When I tap on the name of a particular Asset within the allocation list
    Then the currency weight is negative in the pie-char
    # Remark:can not check color

  @S3550-AC1-AT8
  Scenario: Check the graphic view in Account Allocation Currency holding wrapper Wen the Currency value is 0.00
    Given I login as type "account_currency_holdings_totalValue_is_zero"
#    Then I should see a graphic pie-char in Account Allocation Currency holding wrapper
#  and there are no any color in the pie-char
    And I tap on the Allocation toggle
    And I swipe up from the bottom of the allocation graphic page
    When I tap on the name of a particular Asset within the allocation list
    Then the currency weight is displayed in the pie-char
    # Remark:can not check color

#  Reason  It's been tested on @S3550-AC1-AT5
#  @S3550-AC1-AT9
#  Scenario: Check the 2dp format of currency weight in Overview allocation currency holding wrapper
#    Then I should the 2dp format of currency weight

  @S3550-AC1-AT10
  Scenario: Check whether currency name/currency amount/graphic pie-char for the currency will be changed when I slide the pips left or right on currency holdings wrapper
    Given I login as type "account_currency_holdings_slide_left_wrapper_change"
    When I swipe left to other currency(wrapper)
    Then I should see the currency name and total currency amount for the currency will be changed
#    And the graphic pie-char will be changged within the currency
#  Remark:can not check graphic color changed

  @S3550-AC1-AT11
  Scenario: Check whether holding list will be changed when I slide the pips left or right on currency holdings wrapper
    Given I login as type "account_currency_holdinglist_slide_left_change"
    When I swipe left to other currency
    Then I should see the holding list will be changed within the currency

  @NotAutomatable
  @S3550-AC1-AT12
  Scenario: Check whether I can swipe the pips from 1st to the last one continuously when the currency list item is N
    Given I am at Account level
    And I tap on the Asset Allocation toggle
    And I am viewing the currency key
    And I tap on the name of a particular Asset within the key
    Then I can swipe the pips from 1st to the last one continuously within currency holding wrapper
    #reason：Cannot check the pips status

  @NotAutomatable
  @S3550-AC1-AT13
  Scenario: Check whether the pip never ending loop
    Given I am at Account level
    And I tap on the Asset Allocation toggle
    And  I am viewing the currency key
    And I tap on the name of a particular Asset within the key
    Then I can be able to swipe left or right the overview allocation currency holding wrapper pips in a never ending loop
    #reason：Cannot check the pips status

#  Scenario 2: Access holdings per Currency via Allocation List
  @S3550-AC2-AT1
  Scenario: Access holdings per Currency via Allocation List at account level
    Given I login as type "account_currency_holdings_totalValue_is_negative"
    And I tap on the Allocation toggle
    And I swipe up from the bottom of the allocation graphic page
    When I tap on the name of a particular Asset within the allocation list
    Then I am taken to the holdings view that shows a list of my holdings for the particular Currency within my account
