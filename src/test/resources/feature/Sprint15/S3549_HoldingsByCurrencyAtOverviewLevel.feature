@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-3549 @Sprint15_iOS
@Story_GPBM-3615 @Sprint15_aOS

Feature: Holdings by Currency at Overview level

  As a client I want to see the individual holdings that make up my exposure to each Currency across my accounts
  So that I know which holdings to review in order to change my Currency exposure as desired

  @SIT
  Scenario: holding by Overview allocation currency
    Given I login as type "overview_currency_holdings_have_positive"
    Then I should on the allocation holding list

#  Scenario 1: Access holdings per Currency via Allocation Graphic
  @S3549-AC1-AT1
  @DependsOn('holding_by_Overview_allocation_currency')
  Scenario: Check the holding UI by Overview allocation currency
    Given I am on the allocation holding list
    Then I am taken to the holdings view that shows a list of my holdings for the particular Currency across all of my accounts
    And I should see the wrapper contains the following:
      | element name             | element value |
      | Back button              | Overview      |
      | Name value               |               |
      | Total assets value       |               |
      | More menu icon           |               |
      | donut graphic            |               |
      | Holdings label           |               |
      | Currency conversion icon |               |

  @S3549-AC1-AT2
  @SIT
  @DependsOn('holding_by_Overview_allocation_currency')
  Scenario: Check whether the Overview allocation currency holdings are ordered from largest to smallest based on market value in Overview reference currency
    Given I am on the allocation holding list
    Then I should see the holdings are ordered from largest to smallest based on amount value

  @S3549-AC1-AT3
  @SIT
  @DependsOn('holding_by_Overview_allocation_currency')
  Scenario: Check whether the currency amount equals the sum of all holdings list value
    Given I am on the allocation holding list
    Then I should see the currency amount equals the sum of all holdings list value

  @S3549-AC1-AT4
  @SIT
  @DependsOn('holding_by_Overview_allocation_currency')
  Scenario: Check format of Overview base currency and Overview Total assets value for the Region in Overview allocation Currency holding wrapper
    Given I am on the allocation holding list
    Then I should see the allocation holdings wrapper base currency are displayed in ISO 3 code and 2 d.p. format
    And the allocation holdings list base currency is displayed in ISO 3 code format and 2 d.p. format

  @S3549-AC1-AT5
  Scenario: Check the graphic view in Overview allocation currency holding wrapper When the currency weight is positive
    Given I login as type "overview_currency_holdings_weight_is_positive"
    Then the currency weight is positive in the pie-char
#    can not check color
#    And I should see a graphic pie-char in Overview allocation currency holding wrapper,and there are one color in the pie-char,
#    And the color in graphic is same to the color that I see in the Overview allocation Currency graphic pie-char within the current currency
#    And the position in graphic is same to the position that I see in the Overview allocation Currency graphic pie-char within the current currency

  @S3549-AC1-AT6
  Scenario: Check the graphic view in Overview allocation currency holding wrapper When the currency weight is negative
    Given I login as type "overview_currency_holdings_weight_is_negative"
    When I swipe left to other currency
    Then the currency weight is negative in the pie-char
#    can not check color
#    And I should see a graphic pie-char in Overview allocation currency holding wrapper
#    And there are no any color in the pie-char


  @S3549-AC1-AT7
  Scenario: Check the graphic view in Overview allocation currency holding wrapper When the currency weight is 0.00%
    Given I login as type "overview_currency_hodlings_weight_is_zero"
    Then the currency weight is displayed in the pie-char
#     can not check color
#    And I should see a graphic pie-char in Overview allocation currency holding wrapper
#    And there are no any color in the pie-char

#   It's been tested on @S3549-AC1-AT4
#  @S3549-AC1-AT8
#  Scenario: Check the 2dp format of currency weight in Overview allocation currency holding wrapper
#    Then I should the 2dp format of currency weight

  @S3549-AC1-AT9
  Scenario: Check whether currency name/currency amount/graphic pie-char for the currency will be changed when I slide the pips left or right on currency holdings wrapper
    Given I login as type "overview_currency_holdings_slide_left_wrapper_change"
    When I swipe left to other currency(wrapper)
    Then I should see the currency name and total currency amount for the currency will be changed
#    And the graphic pie-char will be changged within the currency

  @S3549-AC1-AT10
  Scenario: Check whether holding list will be changed when I slide the pips left or right on currency holdings wrapper
    Given I login as type "overview_currency_holdinglist_slide_left_change"
    When I swipe left to other currency
    Then I should see the holding list will be changed within the currency

  @S3549-AC1-AT11
  Scenario: Check whether I can swipe the pips from 1st to the last one continuously when the currency list item is N
    Given I login as type "overview_currency_holdings_has_deserved_item_pip"
    Then I can swipe the pips from 1st to the last one continuously within currency holding wrapper

  @S3549-AC1-AT12
  Scenario: Check whether the pip never ending loop
    Given I login as type "overview_currency_holdings_has_deserved_item_pip"
    Then I can be able to swipe left or right the overview allocation currency holding wrapper pips in a never ending loop