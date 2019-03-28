@UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-3552 @Sprint15_iOS
@Story_GPBM-3518 @Sprint15_aOS

Feature: Holdings by Region at Overview level

  As a client I want to see the individual holdings that make up my exposure to each Region across my accounts
  So that I know which holdings to review in order to change my Region exposure as desired

  @SIT
  Scenario: holding by Overview allocation region
    Given I login as type "overview_region_holdings_has_positive"
    Then I should on the allocation holding list

#  Scenario 1: Access holdings per Region via Allocation Graphic
  @S3552-AC1-AT1
  @DependsOn('holding_by_Overview_allocation_region')
  Scenario: Check the holding UI by Overview allocation region
    Given I am on the allocation holding list
    Then I am taken to the holdings view that shows a list of my holdings for the particular Region across all of my accounts
    And I should see the wrapper contains the following:
      | element name             | element value |
      | Back button              | Overview      |
      | Name value               |               |
      | Total assets value       |               |
      | More menu icon           |               |
      | donut graphic            |               |
      | Holdings label           |               |
      | Currency conversion icon |               |

  @S3552-AC1-AT2
  @SIT
  @DependsOn('holding_by_Overview_allocation_region')
  Scenario: Check whether the Overview allocation region holdings are ordered from largest to smallest based on market value in Overview reference currency
    Given I am on the allocation holding list
    Then I should see the holdings are ordered from largest to smallest based on amount value

  @S3552-AC1-AT3
  @SIT
  @DependsOn('holding_by_Overview_allocation_region')
  Scenario: Check whether the region amount equals the sum of all holdings list value
    Given I am on the allocation holding list
    Then I should see the region amount equals the sum of all holdings list value

  @S3552-AC1-AT4
  @SIT
  @DependsOn('holding_by_Overview_allocation_region')
  Scenario: Check format of Overview base currency and Overview Total assets value for the Region in Overview allocation Region holding wrapper
    Given I am on the allocation holding list
    Then I should see the allocation holdings wrapper base currency are displayed in ISO 3 code and 2 d.p. format
    And the allocation holdings list base currency is displayed in ISO 3 code format and 2 d.p. format

  @S3552-AC1-AT5
  Scenario: Check the graphic view in Overview allocation region holding wrapper When the region weight is positive
    Given I login as type "overview_region_holdings_weight_is_positive"
    Then the region weight is positive in the pie-char
#    can not check color
#    And I should see a graphic pie-char in Overview allocation region holding wrapper,and there are one color in the pie-char,and
#    And the color in graphic is same to the color that I see in the Overview allocation Region graphic pie-char within the current region
#    And the position in graphic is same to the position that I see in the Overview allocation Region graphic pie-char within the current region

  @S3552-AC1-AT6
  Scenario: Check the graphic view in Overview allocation region holding wrapper When the region weight is negative
    Given I login as type "overview_region_holdings_weight_is_negative"
    When I swipe left to other region(wrapper)
#    can not check color
#    Then I should see a graphic pie-char in Overview allocation region holding wrapper
#    And there are no any color in the pie-char
    Then the region weight is negative in the pie-char

  @S3552-AC1-AT7
  Scenario: Check the graphic view in Overview allocation region holding wrapper When the region weight is 0.00%
    Given I login as type "overview_region_holdings_weight_is_zero"
#  can not check color and graphic location
#    Then I should see a graphic pie-char in Overview allocation region holding wrapper
#    And there are no any color in the pie-char
    And the region weight is displayed 0.00% in the pie-char

#    It's been tested on @S3552-AC1-AT4
#  @S3552-AC1-AT8
#  Scenario: Check the 2dp format of region weight in Overview allocation region holding wrapper
#    Then I should the 2dp format of region weight

  @S3552-AC1-AT9
  Scenario: Check whether region name/region value/graphic pie-char for the region will be changed when I slide the pips left or right on region holdings wrapper
    Given I login as type "overview_region_holdings_slide_left_wrapper_change"
    When I swipe left to other region(wrapper)
    Then I should see the region name and total assets value for the asset class will be changed
#    can not check graphic change
#    And the graphic pie-char will be changged within the region

  @S3552-AC1-AT10
  Scenario: Check whether holding list will be changed when I slide the pips left or right on region holdings wrapper
    Given I login as type "overview_region_holdinglist_slide_left_wrapper_change"
    When I swipe left to other region
    Then I should see the holding list will be changed within the region

  @S3552-AC1-AT11
  Scenario: Check whether I can swipe the pips from 1st to the last one continuously when the region list item is N
    Given I login as type "overview_region_holdings_has_deserved_item"
    Then I can swipe the pips from 1st to the last one continuously within region holding wrapper

  @S3552-AC1-AT12
  Scenario: Check whether the pip never ending loop
    Given I login as type "overview_region_holdings_has_deserved_item"
    Then I can be able to swipe left or right the overview allocation region holding wrapper pips in a never ending loop