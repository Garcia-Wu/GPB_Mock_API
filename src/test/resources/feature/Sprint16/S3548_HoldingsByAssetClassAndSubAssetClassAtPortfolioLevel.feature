@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-3548 @Sprint16_iOS
@Story_GPBM-3598 @Sprint16_aOS

Feature: Holdings by Asset Class and Sub-Asset Class at Portfolio level

  As a client I want to see the individual holdings that make up my exposure to each Asset Class AND sub-asset class within a portfolio
  So that I know which holdings to review in order to change my Asset Class exposure as desired


  #  Scenario 1: Access holdings per Asset Class via Allocation Graphic
  @SIT
  Scenario: holding by portfolio asset class
    Given I login as type "portfolio_class_holdings_have_positive"
    Then I should on the allocation holding list

  @S3548-AC1-AT1
  @DependsOn('holding_by_portfolio_asset_class')
  Scenario: Check the holding UI by Portfolio allocation asset class
    Given I am on the allocation holding list
    Then I should see the wrapper contains the following:
      | element name             | element value |
      | Back button              |               |
      | Name value               |               |
      | Total assets value       |               |
#      | Holdings label         | Holdings      |
      | Currency conversion icon |               |
      | donut graphic            |               |
      | sub asset class toggle   |               |
      | More menu icon           |               |
#      | Pips indicating the number of different asset classes invested in (informs user that they can swipe across asset classes) |               |


  @S3548-AC1-AT2
  @SIT
  @DependsOn('holding_by_portfolio_asset_class')
  Scenario: Check whether the Portfolio allocation asset class holdings are ordered from largest to smallest based on market value in Portfolio reference currency
    Given I am on the allocation holding list
    Then I should see the holdings are ordered from largest to smallest based on amount value

  @NotAutomatable
  @S3548-AC1-AT3
  Scenario: Check whether holding list is the same as in GPBM-2081
    Then the holdings detail is the same as in GPBM-2081
  #reason：Tested in Sprint6 S294_HoldingsListViewInAssetAllocationModeAtOverviewLevel.feature

  @S3548-AC1-AT5
  @SIT
  @DependsOn('holding_by_portfolio_asset_class')
  Scenario: Check format of Portfolio base currency and Portfolio Total assets value for the Asset Class in Portfolio allocation Asset Class holding wrapper
    Given I am on the allocation holding list
    Then I should see the allocation holdings wrapper base currency are displayed in ISO 3 code and 2 d.p. format
    And the allocation holdings list base currency is displayed in ISO 3 code format and 2 d.p. format

  @NotInMock
  @S3548-AC1-AT4
  @SIT
  @DependsOn('holding_by_portfolio_asset_class')
  Scenario: Check whether the asset classes amount equals the sum of all holdings list value when the Group by sub-asset class toggle is OFF
    Given I am on the allocation holding list
    Then I should see the asset class amount equals the sum of all holdings list value

  @S3548-AC1-AT6
  Scenario: Check the graphic view in Portfolio Allocation Asset Class holding wrapper When the asset class value is positive
    Given I login as type "portfolio_class_holdings_weight_is_positive"
    Then the asset class weight is positive in the pie-char
#   can not check color
#    Then I should see a graphic pie-char in Portfolio allocation class holding wrapper,and there are one color in the pie-char,and there is an asset class weight in the pie-char
#    And the color in graphic is same to the color that I see in the Portfolio allocation Asset Class graphic pie-char within the current asset class
#    And the position in graphic is same to the position that I see in the Portfolio allocation Asset Class graphic pie-char within the current asset class


  @S3548-AC1-AT7
  Scenario: Check the graphic view in Portfolio Allocation Asset Class holding wrapper When the asset class value is negative
    Given I login as type "portfolio_class_holdings_weight_is_negative"
#    Then I should see a graphic pie-char in Portfolio Allocation Asset Class holding wrapper
#  and there are no any color in the pie-char
    Then the asset class weight is negative in the pie-char
    # Remark:can not check color


  @S3548-AC1-AT8
  Scenario: Check the graphic view in Portfolio Allocation Asset Class holding wrapper Wen the asset class value is 0.00
    Given I login as type "portfolio_class_holdings_weight_is_zero"
#    Then I should see a graphic pie-char in Portfolio Allocation Asset Class holding wrapper
#  and there are no any color in the pie-char
    Then the asset class weight is displayed 0.00% in the pie-char
    # Remark:can not check color


  #   It's been tested on AT5
#  @S3548-AC1-AT9
#  Scenario: Check the 2dp format of asset class weight in Portfolio allocation class holding wrapper
#    Then I should the 2dp format of asset class weight

  @S3548-AC1-AT10
  Scenario: Check whether asset class name/Asset Class amount/graphic pie-char for the asset class will be changed when I slide the pips left or right on asset class holdings wrapper
    Given I login as type "portfolio_class_holdings_wrapper_swipe_left_changed"
    When I swipe left to other asset class(wrapper)
    Then I should see the asset class name and total assets value for the asset class will be changed
#    And the graphic pie-char will be changged within the  asset class

#  Scenario 2: Access holdings per Asset Class via Allocation List
  @S3548-AC2-AT1
  Scenario: Check whether I can view holding list when I tap on the tile of a particular Asset Class in Portfolio level
    Given I login as type "portfolio_asset_class_only_positive"
    When I tap on the Allocation toggle
    And I swipe up from the bottom of the allocation graphic page
    And I tap on the name of a particular Asset within the key
    Then I am taken to the holdings view that shows a list of my holdings for the particular Asset Class within my portfolio


#  Scenario 3: Holdings grouped per Sub-Asset Class
  @SIT
  Scenario: holding by portfolio asset subclass
    # totalNum, subClassNum
    Given I login as type "portfolio_class_holdings_have_positive"
    When I tap on holdings grouped per Sub Asset class
    Then I should on the allocation holding list

  @S3548-AC3-AT1
  @SIT
  @DependsOn('holding_by_portfolio_asset_subclass')
  Scenario: Check whether the sub asset class are ordered from largest to smallest based on sub asset class amount,then by sub asset class name alphabetical a-z
    Given I am on the allocation holding list
    Then I should see the sub-asset classes are ordered from largest to smallest, based on the sub-asset class total value in reference currency

    #   It's been tested on AC3-AT1
#  @S3548-AC3-AT2
#  @DependsOn('holding_by_portfolio_asset_subclass')
#  Scenario: Check whether holding lists are ordered from largest to smallest based on market value in Overview reference currency in every sub-asset class
#    Then I should  see the Group by sub-asset class toggle is ACTIVE
#    And the Holding lists are group by Sub Asset Class to display
#    And the holdings are ordered within each sub-asset class from largest to smallest based on market value in Portfolio reference currency

  @S3548-AC3-AT3
  @SIT
  @DependsOn('holding_by_portfolio_asset_subclass')
  Scenario: Check whether the sub asset classes amount equals the sum of its  all holdings list value when the Group by sub-asset class toggle is ON
    Given I am on the allocation holding list
    Then I should see the sub asset classes amount equals the sum of its all holdings list value

  @NotInMock
  @S3548-AC3-AT4
  @SIT
  @DependsOn('holding_by_portfolio_asset_subclass')
  Scenario: Check whether the asset classes amount in the holding wrapper equals the sum of sub-asset class amount when I tap the Group by sub-asset class toggle ON
    Given I am on the allocation holding list
    Then I should see the asset classes amount in the holding wrapper equals the sum of sub-asset class amount

  @S3548-AC3-AT5
  @SIT
  @DependsOn('holding_by_portfolio_asset_subclass')
  Scenario: Check format of Overview base currency and Overview Sub-asset Class amount for the Asset Class in Overview allocation Asset Class holding wrapper
    Given I am on the allocation holding list
    Then I should see the allocation holdings wrapper base currency are displayed in ISO 3 code and 2 d.p. format
    And I should see the base currency ISO 3 code and 2 d.p. format for the sub-asset class

  @S3548-AC3-AT6
  Scenario: Check whether holding list will be changed and the sub-asset class toggle is OFF  when I slide the pips left or right on asset class holdings wrapper
    Given I login as type "portfolio_class_holdings_swipe_left_changed"
    When I swipe left to other asset class
    Then I should see the holding list will be changed
#    And the sub-asset class toggle is OFF within current asset class
    #Remark：cannot check the toggle status

  @S3548-AC3-AT7
  Scenario: Check whether holding list will be changed and the sub-asset class toggle is ON when I slide the pips left or right on asset class holdings wrapper
    Given I login as type "portfolio_holdings_subClass_swipe_left_changed"
    When I tap on holdings grouped per Sub Asset class
    And I swipe left to other asset subclass
    Then I should see the grouped by subclass holding list will be changed
#    And the sub-asset class toggle is ON within current asset class
    #Remark：cannot check the toggle status

  @NotAutomatable
  @S3548-AC3-AT8
  Scenario: Check whether I can swipe the pips from 1st to the last one continuously when the asset class list item is N and the sub-asset class toggle is OFF
    Given I am at Portfolio level
    And I tap on the Asset Allocation toggle
    And I tap on the tile of a particular Asset Class
    Then I should swipe the pips from 1st to the last one continuously within asset class holding wrapper
    And I should see the sub-asset class toggle is OFF in every asset class
  #reason：cannot check the pips status

  @NotAutomatable
  @S3548-AC3-AT9
  Scenario: Check whether I can swipe the pips from 1st to the last one continuously when the asset class list item is N and the sub-asset class toggle is ON
    Given I am at Portfolio level
    And I tap on the Asset Allocation toggle
    And I tap on the tile of a particular Asset Class
    And I tap the sub-asset class toggle in the asset class holdings list
    Then I should swipe the pips from 1st to the last one continuously within asset class holding wrapper
    And I should see the sub-asset class toggle is ON in every asset class
  #reason：cannot check the pips status

  @NotAutomatable
  @S3548-AC3-AT10
  Scenario: Check whether holding list is the same as in GPBM-2081
    Then I should see  the holdings detail is the same as in GPBM-2081
  #reason：Tested in Sprint6 S294_HoldingsListViewInAssetAllocationModeAtOverviewLevel.feature