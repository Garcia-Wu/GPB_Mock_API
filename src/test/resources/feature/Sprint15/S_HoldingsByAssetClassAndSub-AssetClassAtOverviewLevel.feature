@NotAutomatable
#  Reason This update to S3592_HoldingsByAssetClassAndSub-AssetClassAtOverviewLevel
@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-3592 @Sprint15_iOS
@Story_GPBM-3582 @Sprint15_aOS

Feature: Holdings by Asset Class and Sub-Asset Class at Overview level

  As a client I want to see the individual holdings that make up my exposure to each Asset Class AND sub-asset class across my accounts
  So that I know which holdings to review in order to change my Asset Class exposure as desired

#  Scenario 1: Access holdings per Asset Class via Allocation Graphic
  @S3592-AC1-AT1
  Scenario: Check the holding UI by Overview allocation asset class
    Given I am at Overview level
    And I am entitled to view one or more accounts
    And I have invested in one or more holdings within a particular asset class
    And I am within Asset Allocation Mode
    And I am viewing the Asset Class Graphic
    When I tap on the name of a particular Asset Class within the key
    Then I am taken to the holdings view that shows a list of my holdings for the particular Asset Class across all of my accounts
    And I should see the wrapper contains the following:
      | element name           | element value |
      | Back button            | Overview      |
      | Asset class name       |               |
      | Total assets value     |               |
      | Overview base currency |               |
      | More menu icon         |               |
      | donut graphic          |               |
      | Holdings label         |               |
      | Currency exchange icon |               |
      | sub-asset class toggle |               |

  @S3592-AC1-AT2
  Scenario: Check whether the Overview allocation asset class holdings are ordered from largest to smallest based on market value in Overview reference currency
    Given I am viewing Overview allocation Asset Class list view
    When I tap one of asset class key
    Then the holdings are ordered from largest to smallest based on market value in Overview reference currency

  @S3592-AC1-AT3
  Scenario: Check whether the asset classs amount equals the sum of all holdings list value when the Group by sub-asset class toggle is OFF
    Then I should see the asset class amount equals the sum of all holdings list value

  @S3592-AC1-AT4
  Scenario: Check format of Overview base currency and Overview Total assets value for the Asset Class in Overview allocation Asset Class holding wrapper
    Then I should see Overview Total assets value for the Asset Class displayed in ISO 3 code and 2dp format
    And the Overview base currency is displayed in ISO 3 code format

  @S3592-AC1-AT5
  Scenario: Check the graphic view in Overview allocation class holding wrapper When the asset class weight is positive
    Given I am at Overview level
    And I am entitled to view one or more accounts
    And I have invested in one or more holdings within a particular asset class
    And I am within Asset Allocation Mode
    And I am viewing the Asset Class Graphic
    When I tap on the name of a particular Asset Class within the key
    Then I should see a graphic pie-char in Overview allocation class holding wrapper,and the asset class weight is positive in the pie-char
    And the color in graphic is same to the color that I see in the Overview allocation Asset Class graphic pie-char within the current asset class
    And the position in graphic is same to the position that I see in the Overview allocation Asset Class graphic pie-char within the current asset class

  @S3592-AC1-AT6
  Scenario: Check the graphic view in Overview allocation class holding wrapper When the asset class weight is negative
    Then I should see a graphic pie-char in Overview allocation class holding wrapper
    And there are no any color in the pie-char
    And the asset class weight is negative in the pie-char

  @S3592-AC1-AT7
  Scenario: Check the graphic view in Overview allocation class holding wrapper When the asset class weight is 0.00%
    Then I should see a graphic pie-char in Overview allocation class holding wrapper
    And there are no any color in the pie-char
    And the asset class weight is displayed 0.00% in the pie-char

  @S3592-AC1-AT8
  Scenario: Check the 2dp format of asset class weight in Overview allocation class holding wrapper
    Then I should the 2dp format of asset class weight

  @S3592-AC1-AT9
  Scenario: Check whether asset class name/Asset Class amount/graphic pie-char for the asset class will be changed when I slide the pips left or right on asset class holdings wrapper
    Given I am at Overview level
    And I tap on the Asset Allocation toggle
    And I tap on the tile of a particular Asset Class
    When I swipe left or rigth to other asset class
    Then I should see the asset class name and Asset Class value for the asset class will be changed
    And the graphic pie-char will be changged within the  asset class

#  Scenario 3: Holdings grouped per Sub-Asset Class

  @S3592-AC3-AT1
  Scenario: Check whether the sub asset class are ordered from largest to smallest based on sub asset class amount,then by sub asset class name alphabetical a-z
    Given I am at Overview level
    And I am entitled to view one or more accounts
    And I have invested in one or more holdings within a particular asset class
    And I am within the Asset Allocation Mode holding list for a particular asset class
    And there is a Group by sub-asset class toggle
    When I tap the sub-asset class toggle in the asset class holdings list
    Then I should see the Group by sub-asset class toggle is ACTIVE
    And the Holding lists are group by Sub Asset Class to display
    And the sub asset class are ordered from largest to smallest based on sub asset class amount,then by sub asset class name alphabetical a-z

  @S3592-AC3-AT2
  Scenario: Check whether holding lists are ordered from largest to smallest based on market value in Overview reference currency in every sub-asset class
    Then I should  see the Group by sub-asset class toggle is ACTIVE
    And the Holding lists are group by Sub Asset Class to display
    And in every sub-asset class group,the holding lists are ordered from largest to smallest based on market value in Overview reference currency

  @S3592-AC3-AT3
  Scenario: Check whether the sub asset classs amount equals the sum of its  all holdings list value when the Group by sub-asset class toggle is ON
    Then I should see the sub asset class amount equals the sum of its  all holdings list value

  @S3592-AC3-AT4
  Scenario: Check whether the asset classs amount in the holding wrapper equals the sum of sub-asset class amount when I tap the Group by sub-asset class toggle ON
    Then I should see the asset class amount in the holding wrapper equals the sum of sub-asset class amount

  @S3592-AC3-AT5
  Scenario: Check format of Overview base currency and Overview Sub-asset Class amount for the Asset Class in Overview allocation Asset Class holding wrapper
    Then I should see Overview Sub-asset Class amount for the Asset Class displayed in ISO 3 code and 2dp format
    And the Overview base currency is displayed in ISO 3 code format

  @S3592-AC3-AT6
  Scenario: Check whether holding list will be changed and the sub-asset class toggle is OFF  when I slide the pips left or right on asset class holdings wrapper
    Given I am at Overview level
    And I tap on the Asset Allocation toggle
    And I tap on the tile of a particular Asset Class
    And the sub-asset class toggle is OFF by default
    When I swipe left or rigth to other asset class
    Then I should see the holding list will be changed
    And the sub-asset class toggle is OFF in current asset class

  @S3592-AC3-AT7
  Scenario: Check whether holding list will be changed and the sub-asset class toggle is ON when I slide the pips left or right on asset class holdings wrapper
    Given I am at Overview level
    And I tap on the Asset Allocation toggle
    And I tap on the tile of a particular Asset Class
    And I tap the sub-asset class toggle in the asset class holdings list
    When I swipe left or rigth to other asset class
    Then I should see the holding list and sub-asset class will be changed
    And the sub-asset class toggle is ON in current asset class

  @S3592-AC3-AT8
  Scenario: Check whether I can swipe the pips from 1st to the last one continuously when the asset class list item is N and the sub-asset class toggle is OFF
    Given I am at Overview level
    And I tap on the Asset Allocation toggle
    And I tap on the tile of a particular Asset Class
    Then I should swipe the pips from 1st to the last one continuously within asset class holding wrapper
    And I should see the sub-asset class toggle is OFF in every asset class

  @S3592-AC3-AT9
  Scenario: Check whether I can swipe the pips from 1st to the last one continuously when the asset class list item is N and the sub-asset class toggle is ON
    Given I am at Overview level
    And I tap on the Asset Allocation toggle
    And I tap on the tile of a particular Asset Class
    And I tap the sub-asset class toggle in the asset class holdings list
    Then I should swipe the pips from 1st to the last one continuously within asset class holding wrapper
    And I should see the sub-asset class toggle is ON in every asset class

