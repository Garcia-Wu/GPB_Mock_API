@UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-3553 @Sprint16_iOS
@Story_GPBM-3603 @Sprint16_aOS

Feature: Holdings by Region at Account level

  As a client I want to see the individual holdings that make up my exposure to each Region within an account
  So that I know which holdings to review in order to change my Region exposure as desired

  @SIT
  Scenario: holding by Account allocation region
    Given I login as type "account_region_holdings_has_positive"
    Then I should on the allocation holding list

  #  Scenario 1: Access holdings per Region via Allocation Graphic
  @S3553-AC1-AT1
  @DependsOn('holding_by_Account_allocation_region')
  Scenario: Check the holding UI by Account allocation region
    Given I am on the allocation holding list
    Then I am taken to the holdings view that shows a list of my holdings for the particular Region within my account
    And I should see the wrapper contains the following:
      | element name             | element value |
      | Back button              |               |
      | Name value               |               |
      | Total assets value       |               |
      | Holdings label           | Holdings      |
      | Currency conversion icon |               |
      | donut graphic            |               |
      | More menu icon           |               |
#      | Pips indicating the number of different regions invested in (informs user that they can swipe across regions) |               |

  @S3553-AC1-AT2
  @SIT
  @DependsOn('holding_by_Account_allocation_region')
  Scenario: Check whether the Account allocation region holdings are ordered from largest to smallest based on market value in Account reference currency
    Given I am on the allocation holding list
    Then I should see the holdings are ordered from largest to smallest based on amount value

  @NotAutomatable
  @S3553-AC1-AT3
  Scenario: Check whether holding list is the same as in GPBM-2081
    Then I should see the holdings detail is the same as in GPBM-2081
  #reason：Tested in Sprint6 S294_HoldingsListViewInAssetAllocationModeAtOverviewLevel.feature

  @S3553-AC1-AT4
  @SIT
  @DependsOn('holding_by_Account_allocation_region')
  Scenario: Check whether the Account region amount equals the sum of all holdings list value
    Given I am on the allocation holding list
    Then I should see the region amount equals the sum of all holdings list value

  @S3553-AC1-AT5
  @SIT
  @DependsOn('holding_by_Account_allocation_region')
  Scenario: Check format of Account base currency and Account Total assets value for the Region in Account allocation Region holding wrapper
    Given I am on the allocation holding list
    Then I should see the allocation holdings wrapper base currency are displayed in ISO 3 code and 2 d.p. format
    And the allocation holdings list base currency is displayed in ISO 3 code format and 2 d.p. format

  @S3553-AC1-AT6
  Scenario: Check the graphic view in Account Allocation Region holding wrapper When the Region value is positive
    Given I login as type "account_region_holdings_totalValue_is_positive"
    Then the region weight is positive in the pie-char
#    Then I should see a graphic pie-char in Account allocation class holding wrapper,and there are one color in the pie-char
#    And the color in graphic is same to the color that I see in the Account allocation Region graphic pie-char within the current Region
#    And the position in graphic is same to the position that I see in the Account allocation Region graphic pie-char within the current Region
#   Remark:can not check color

  @S3553-AC1-AT7
  Scenario: Check the graphic view in Account Allocation Region holding wrapper When the Region value is negative
    Given I login as type "account_region_holdings_totalValue_is_negative"
    And I tap on the Allocation toggle
    And I swipe up from the bottom of the allocation graphic page
    When I tap on the name of a particular Asset within the allocation list
#    Then I should see a graphic pie-char in Account Allocation Region holding wrapper
#  and there are no any color in the pie-char
    Then the region weight is negative in the pie-char
    # Remark:can not check color and graphic pie-char location

  @S3553-AC1-AT8
  Scenario: Check the graphic view in Account Allocation Region holding wrapper Wen the Region value is 0.00
    Given I login as type "account_region_holdings_totalValue_is_zero"
    And I tap on the Allocation toggle
    And I swipe up from the bottom of the allocation graphic page
    When I tap on the name of a particular Asset within the allocation list
#    Then I should see a graphic pie-char in Account Allocation Region holding wrapper
#  and there are no any color in the pie-char
    Then the region weight is displayed 0.00% in the pie-char
    # Remark:can not check color and graphic pie-char location

  #   It's been tested on @S3553-AC1-AT5
#  @S3553-AC1-AT9
#  Scenario: Check the 2dp format of region weight in Account allocation region holding wrapper
#    Then I should the 2dp format of region weight

  @S3553-AC1-AT10
  Scenario: Check whether region name/region value/graphic pie-char for the region will be changed when I slide the pips left or right on region holdings wrapper
    Given I login as type "account_region_holdings_slide_left_wrapper_change"
    When I swipe left to other region(wrapper)
    Then I should see the region name and total assets value for the asset class will be changed
#    And the graphic pie-char will be changged within the region
#  Remark:can not check graphic pie-char change

  @S3553-AC1-AT11
  Scenario: Check whether holding list will be changed when I slide the pips left or right on region holdings wrapper
    Given I login as type "account_region_holdinglist_slide_left_change"
    When I swipe left to other region
    Then I should see the holding list will be changed within the region

  @NotAutomatable
  @S3553-AC1-AT12
  Scenario: Check whether I can swipe the pips from 1st to the last one continuously when the region list item is N
    Given I am at Account level
    And I tap on the Asset Allocation toggle
    And I am viewing the region key
    When I tap on the name of a particular Region within the key
    Then I can swipe the pips from 1st to the last one continuously within region holding wrapper
    #reason：Cannot check the pips status

  @NotAutomatable
  @S3553-AC1-AT13
  Scenario: Check whether the pip never ending loop
    Given I am at Account level
    And I tap on the Asset Allocation toggle
    And I am viewing the region key
    When I tap on the name of a particular Region within the key
    Then I can be able to swipe left or right the overview allocation region holding wrapper pips in a never ending loop
    #reason：Cannot check the pips status

#  Scenario 2: Access holdings per Region via Allocation List
  @S3553-AC2-AT1
  Scenario: Check whether I can view holding list when I tap on the tile of a particular Region in Account level
    Given I login as type "account_region_holdings_totalValue_is_negative"
    And I tap on the Allocation toggle
    And I swipe up from the bottom of the allocation graphic page
    When I tap on the name of a particular Asset within the allocation list
    Then I am taken to the holdings view that shows a list of my holdings for the particular Region within my account