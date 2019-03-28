@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-3592 @Sprint14_iOS
@Story_GPBM-3476 @Sprint14_aOS

Feature: Holdings by Asset Class and Sub-Asset Class at Overview level

  As a client I want to see the individual holdings that make up my exposure to each Asset Class AND sub-asset class across my accounts
  So that I know which holdings to review in order to change my Asset Class exposure as desired

# Scenario 1: Access holdings per Asset Class via Allocation List
  @SIT
  Scenario: holding by overview asset class
    Given I login as type "overview_class_holdings_have_positive"
    Then I should on the allocation holding list

  @S3592-AC1-AT1
  @DependsOn('holding_by_overview_asset_class')
  Scenario: Check the holding by asset class UI
    Given I am on the allocation holding list
    Then I should see the wrapper contains the following:
      | element name             | element value |
      | Back button              | Overview      |
      | Name value               |               |
      | Total assets value       |               |
      | More menu icon           |               |
      | donut graphic            |               |
      | Holdings label           |               |
      | sub asset class toggle   |               |
      | Currency conversion icon |               |

  @S3592-AC1-AT2
  @SIT
  @DependsOn('holding_by_overview_asset_class')
  Scenario: Check the sequence of holding basic amount value
    Given I am on the allocation holding list
    Then I should see the holdings are ordered from largest to smallest based on amount value

  @S3592-AC1-AT3
  @SIT
  @DependsOn('holding_by_overview_asset_class')
  Scenario: Check Overview base currency format When Access holdings per Asset Class via Allocation List
    Given I am on the allocation holding list
    Then I should see the allocation holdings wrapper base currency are displayed in ISO 3 code and 2 d.p. format
    And the allocation holdings list base currency is displayed in ISO 3 code format and 2 d.p. format

#    update for sprint 15
  @S3592-AC1-AT5
  @SIT
  Scenario: Check whether the asset classes amount equals the sum of all holdings list value when the Group by sub-asset class toggle is OFF
    Given I am on the allocation holding list
    Then I should see the asset class amount equals the sum of all holdings list value

#    update for sprint 15
  @S3592-AC1-AT6
  Scenario: Check the graphic view in Overview allocation class holding wrapper When the asset class weight is positive
    Given I login as type "overview_class_holdings_weight_is_positive"
    Then the asset class weight is positive in the pie-char
#   can not check color
#    Then I should see a graphic pie-char in Overview allocation class holding wrapper,
#    And the color in graphic is same to the color that I see in the Overview allocation Asset Class graphic pie-char within the current asset class
#    And the position in graphic is same to the position that I see in the Overview allocation Asset Class graphic pie-char within the current asset class

#    update for sprint 15
  @S3592-AC1-AT7
  Scenario: Check the graphic view in Overview allocation class holding wrapper When the asset class weight is negative
    Given I login as type "overview_class_holdings_weight_is_negative"
#  can not check color
#    Then I should see a graphic pie-char in Overview allocation class holding wrapper
#    And there are no any color in the pie-char
    Then the asset class weight is negative in the pie-char

#    update for sprint 15
  @S3592-AC1-AT8
  Scenario: Check the graphic view in Overview allocation class holding wrapper When the asset class weight is 0.00%
    Given I login as type "overview_class_holdings_weight_is_zero"
#  can not check color
#    Then I should see a graphic pie-char in Overview allocation class holding wrapper
#    And there are no any color in the pie-char
    Then the asset class weight is displayed 0.00% in the pie-char

  @ReTest
  @S3592-AC1-AT4
  Scenario: Check the sub-asset class toggle is OFF whether holding list will be changed when I slide the pips left or right on asset class holdings wrapper
    Given I login as type "overview_class_holdings_swipe_left_changed"
    When I swipe left to other asset class
    Then I should see the holding list will be changed

#    Scenario 2: Holdings grouped per Sub-Asset Class
  @SIT
  Scenario: holding by overview asset subclass
    Given I login as type "overview_class_holdings_have_positive"
    When I tap on holdings grouped per Sub Asset class
    Then I should on the allocation holding list

  @S3592-AC2-AT1
  @DependsOn('holding_by_overview_asset_subclass')
  Scenario: Check holding by asset subclass UI
    Given I am on the allocation holding list
    Then I should see the wrapper contains the following:
      | element name             | element value |
      | Back button              | Overview      |
      | Name value               |               |
      | Total assets value       |               |
      | More menu icon           |               |
      | donut graphic            |               |
      | Holdings label           |               |
      | sub asset class toggle   |               |
      | Currency conversion icon |               |

  @S3592-AC2-AT6
  @DependsOn('holding_by_overview_asset_subclass')
  Scenario: Check the holding list UI
    Given I am on the allocation holding list
    Then I should see the total value for each sub-asset class
    And a list of my holdings for a particular asset class across all of my accounts
#    And toggle is switched to ACTIVE state

  @S3592-AC2-AT2
  @SIT
  @DependsOn('holding_by_overview_asset_subclass')
  Scenario: Check the wrapper Overview base currency format When Holdings grouped per Sub-Asset Class
    Given I am on the allocation holding list
    Then I should see the allocation holdings wrapper base currency are displayed in ISO 3 code and 2 d.p. format

  @S3592-AC2-AT3
  @SIT
  @DependsOn('holding_by_overview_asset_subclass')
  Scenario: Check Overview base currency ISO 3 code for the sub-asset class
    Given I am on the allocation holding list
    Then I should see the base currency ISO 3 code and 2 d.p. format for the sub-asset class

  @S3592-AC2-AT4
  @SIT
  @DependsOn('holding_by_overview_asset_subclass')
  Scenario: Check the sequence of that sub-asset classes are ordered from largest to smallest, based on the sub-asset class total value in Overview reference currency
    Given I am on the allocation holding list
    Then I should see the sub-asset classes are ordered from largest to smallest, based on the sub-asset class total value in reference currency

  @S3592-AC2-AT5
  @DependsOn('holding_by_overview_asset_subclass')
  Scenario: Check the holdings are grouped by each sub-asset class
    Given I am on the allocation holding list
    Then I should see the holdings are grouped by each sub-asset class

  @S3592-AC2-AT7
  Scenario: Check the sub-asset class toggle is ON whether holding list will be changed when I slide the pips left or right on asset class holdings wrapper
    Given I login as type "overview_holdings_subClass_swipe_left_changed"
    When I tap on holdings grouped per Sub Asset class
    And I swipe left to other asset subclass
    Then I should see the grouped by subclass holding list will be changed

  @NotAutomatable
  Scenario: Check whether the state of sub-asset class toggle is ON at the Overview asset class holdings list(only) during the current app session (only).
    Given I am at Overview level
    And I tap on the Asset Allocation toggle
    And I tap on the tile of a particular Asset Class
    And I tap the sub-asset class toggle in the asset class holdings list
    And I back to overview level
    When I tap on the tile of a particular Asset Class
    Then I should see the state of sub-asset class toggle is ON at the Overview asset class holdings list
#    @S3592-AC3-AT1
#    reason：testing to detect switch status does not make much sense

  @NotAutomatable
  Scenario: Check whether the state of sub-asset class toggle is ON at the Overview asset class holdings list(only) during the current app session (only) when I swipe left or rigth.
    Given I am at Overview level
    And I tap on the Asset Allocation toggle
    And I tap on the tile of a particular Asset Class
    And I tap the sub-asset class toggle in the asset class holdings list
    When I swipe left or right to other asset class
    Then I should see the state of sub-asset class toggle is ON at the Overview asset class holdings list
#   @S3592-AC3-AT2
#   reason：testing to detect switch status does not make much sense

  @S3592-AC3-AT3
  Scenario: Check whether asset class name and Total assets value for the asset class will be changed when I slide the pips left or right on asset class holdings wrapper
    Given I login as type "overview_class_holdings_wrapper_swipe_left_changed"
    When I swipe left to other asset class(wrapper)
    Then I should see the asset class name and total assets value for the asset class will be changed

  @S3592-AC3-AT4
  Scenario: Check whether I can swipe the pips from 1st to the last one continuously when the asset class list item is N
    Given I login as type "overview_class_holdings_have_deserved_item_pip"
    Then I should swipe the pips from 1st to the last one continuously within asset class holding wrapper
    