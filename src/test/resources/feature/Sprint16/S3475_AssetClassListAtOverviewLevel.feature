@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-3475 @Sprint16_iOS
@Story_GPBM-3540 @Sprint16_aOS

Feature: Asset Class list at Overview level

  As a Client I want a view of my entire asset class exposure, regardless of negative or positive holdings
  So that I have the full information of my asset class exposure to make any required investment decisions


#  Scenario 1: Access list view via Asset Allocation graphic

  @S3475-AC1-AT1
  Scenario: Check whether I can be taken to the Overview Asset Allocation list view page when I swipe up from the bottom of the Overview Allocation asset class graphic view page
    Given I login as type "has_account"
    When I tap on the Allocation toggle
#    And the “Asset Class” tab is selected
    And I swipe up from the bottom of the allocation graphic page
    Then I am taken to the Asset Allocation list view page
#    And the Asset Class tab is displayed by default
  #Remark: Cannot check the tab status

#  Scenario 2: Access list view via overview page

  @S3475-AC2-AT1
  Scenario: Check whether I can be taken to the Overview Asset Allocation list view page when I tap the Asset Allocation toggle
    Given I login as type "has_account"
    And the Overview wrapper is minifiles
    When I tap on the Allocation toggle
    Then I am taken to the Asset Allocation list view page
#    And the toggle becomes ACTIVE
#    And the Asset Class tab is displayed by default
  #Remark: Cannot check the tab status


  @SIT
  Scenario: login as user has overview Positive Asset Class on allocation list view
    Given I login as type "overview_class_has_positive"
    When I tap on the Allocation toggle
    And I swipe up from the bottom of the allocation graphic page
    Then I am taken to the Asset Allocation list view page

#  Scenario 3: Positive Asset Class total holding value

  @S3475-AC3-AT1
  @DependsOn('login_as_user_has_overview_Positive_Asset_Class_on_allocation_list_view')
  Scenario: Check the Positive Asset Class in Overview Allocation Asset Class list
    Given I am see the allocation list
    Then I should see the positive allocation list contains the following:
      | element name                   | element value |
      | Asset Class name label         |               |
      | Total Asset Class value        |               |
      | Overview base currency         |               |
      | Total Asset Class value as a % |               |
#      | Donut bar representing % of assets owned for particular Asset Class                                  |               |
#      | Donut bar for the asset class matches the position shown in the graphic to represent positive assets |               |


  @S3475-AC3-AT2
  @DependsOn('login_as_user_has_overview_Positive_Asset_Class_on_allocation_list_view')
  Scenario: Check the Positive Asset Class wrapper above Overview Allocation Asset Class list
    Given I am see the allocation list
    Then I should see the wrapper above the list contains the following:
      | element region | element name            | element value |
      |                | Asset allocation label  |               |
      |                | Asset Allocation toggle |               |
      |                | Name label              |               |
#      |                | Total Assets label      |               |
#      |                | Total Assets value      |               |
      |                | Asset Class             | Asset class   |
      |                | Currency                | Currency      |
      | UK             | Region                  | Region        |
      |                | More menu icon          |               |


  @S3475-AC3-AT3
  @SIT
  @DependsOn('login_as_user_has_overview_Positive_Asset_Class_on_allocation_list_view')
  Scenario: Check the format of Total Asset Class value/ Overview base currency/weight in Overview Allocation Asset Class list and "Total Assets" value/Overview base currency in the wrapper when Asset Class value is
    Given I am see the allocation list
    Then I should see Total Assets Class value in base currency (ISO 3 format and 2dp format)
    And I should see Total Assets Class value as a %(2dp format)
#   And I should see Total Assets value in base currency(ISO 3 format and 2dp format) in the allocation wrapper


  @NotAutomatable
  @S3475-AC3-AT4
  Scenario: Check the color and the position of the pie-char in the Overview Allocation Asset Class list view when the Asset Class value is Positive
    Then I should see there are one color in the pie-char
    And the color in pie-char is same to the color that I see in the Overview allocation Asset Class graphic pie-char
    And the position in pie-char is same to the position that I see in the Overview allocation Asset Class graphic pie-char
#    Reason: can not check the graphic pie-char color and position


  @SIT
  Scenario: Negative Asset Class in Overview Allocation Asset Class list
    Given I login as type "overview_class_only_negative"
    When I tap on the Allocation toggle
    And I swipe up from the bottom of the allocation graphic page
    Then I am taken to the Asset Allocation list view page

#  Scenario 4: Negative Asset Class total holding value
  @S3475-AC4-AT1
  @DependsOn('Negative_Asset_Class_in_Overview_Allocation_Asset_Class_list')
  Scenario: Check the Negative Asset Class in Overview Allocation Asset Class list
    Given I am see the allocation list
#    Then I am presented with the following information for the particular asset class or as part of “Others”, aligned to the current rules of ordering the 7 highest value asset classes before grouping any remaining into “Others” if there are more than 8 asset classes or insufficient product information:
    Then I should see the following information:
      | element name                   | element value |
      | Asset Class name label         |               |
      | Total Asset Class value        |               |
      | Overview base currency         |               |
      | Total Asset Class value as a % |               |
#      | Donut bar representing % of assets owned for particular Asset Class                    |               |
#      | Donut bar is an empty circle to represent negative assets                              |               |


  @S3475-AC4-AT2
  @DependsOn('Negative_Asset_Class_in_Overview_Allocation_Asset_Class_list')
  Scenario: Check the Negative Asset Class wrapper above Overview Allocation Asset Class list
    Given I am see the allocation list
    Then I should see the wrapper above the list contains the following:
      | element region | element name            | element value |
      |                | Asset allocation label  |               |
      |                | Asset Allocation toggle |               |
      |                | Name label              |               |
#      |                | Total Assets label      |               |
#      |                | Total Assets value      |               |
#      |                | Overview base currency ISO 3 code |               |
      |                | Asset Class             | Asset class   |
      |                | Currency                | Currency      |
      | UK             | Region                  | Region        |
      |                | More menu icon          |               |


  @S3475-AC4-AT3
  @SIT
  @DependsOn('Negative_Asset_Class_in_Overview_Allocation_Asset_Class_list')
  Scenario: Check the format of Total Asset Class value/ Overview base currency/weight in Overview Allocation Asset Class list and "Total Assets" value/Overview base currency in the wrapper when Asset Class value is Negative
    Given I am see the allocation list
    Then I should see Total Assets Class value in base currency (ISO 3 format and 2dp format)
    And I should see Total Assets Class value as a %(2dp format)
#   And I should see Total Assets value in base currency(ISO 3 format and 2dp format) in the allocation wrapper


#  Scenario 5: Client does not have holdings in an Asset Class
  @NotAutomatable
  @S3475-AC5-AT1
  Scenario: Check whether the Asset Class is NOT shown on the list when Client does not have holdings in an Asset Class
    Given I am at Overview level
    And I am see the allocation list
    And I am entitled to view one or more accounts
    And the Asset Class tab is selected
    And I do not have any holdings in a particular Asset Class
    When I view the page
    Then The Asset Class is NOT shown on the list


#  Scenario 6: Client does not have any holdings in any Asset Class - Edge
  @Sprint18
  @S3475-AC6-AT1
  Scenario: Check whether There is no Asset Class list at Overview to be displayed when Client does not have any holdings in any Asset Class
    Given I login as type "overview_class_all_no_holdings"
    And I tap on the Allocation toggle
    And I swipe up from the bottom of the allocation graphic page
    When There is no Asset Class list to be displayed
    Then there is copy to state that I have not got any investments:
      | element name | element value                                                                      |
      | state copy   | Exposure by asset class unavailable as you have no holdings in your account(s). |

#  Scenario 7: Exit Asset Allocation Mode
  @S3475-AC7-AT1
  Scenario: Check whether I can exit Overview Asset Allocation Mode when I tap on the Asset Allocation toggle
    Given I login as type "overview_class_has_positive"
    And I tap on the Allocation toggle
    And I swipe up from the bottom of the allocation graphic page
    When I tap on the Allocation toggle
#    Then The toggle becomes the INACTIVE state
    Then I am returned back to the Overview page
    And the Overview wrapper should be minifiles
#    And the Overview wrapper is minimised
#  Reason：Reason: can not check toggle status


  @NotAutomatable
  @S3475-AC7-AT2
  Scenario: Check whether the "Others" Asset Class will be displayed last in the Overview Allocation Asset Class list view
    Then I should see the "Others" Asset Class will be displayed last in the Overview Allocation Asset Class list view

  @NotAutomatable
  @S3475-AC7-AT3
  Scenario: Check whether the "Others" Asset Class key will be displayed last in the Overview Allocation Asset Class key view
    Then I should see the "Others" Asset Class key will be displayed last in the Overview Allocation Asset Class list key view

  @S3475-AC7-AT4
  @SIT
  Scenario: Check the order of Overview Allocation Asset Class list
    Given I login as type "overview_class_list_order"
    And I tap on the Allocation toggle
    And I swipe up from the bottom of the allocation graphic page
    Then The Class will be ordered from largest to smallest based on market value in reference currency,then by alphabetical order, and negative values are present, negative values will be listed AFTER all positive values have been listed, with the largest negative value shown first
#  will be ordered from largest to smallest based on market value in reference currency,then by alphabetical order, and negative values are present, negative values will be listed AFTER all positive values have been listed, with the largest negative value shown first
#  (Example with 6 asset classes, 3 positive, 3 negative: 300 > 250 > 100 > -200 > -100 > -50)

  @NotAutomatable
  @S3475-AC7-AT5
  Scenario: Check row of the Asset Class list when the number of asset classes = 1 or 2
    Then I should see there is 1 row
#    Reason: can not check the row number

  @NotAutomatable
  @S3475-AC7-AT6
  Scenario: Check row of the Asset Class list when the number of asset classes = 3 or 4
    Then I should see there are 2 rows
#  Reason: can not check the row number

  @NotAutomatable
  @S3475-AC7-AT7
  Scenario: Check row of the Asset Class list when the number of asset classes = 5 or 6
    Then I should see there are 3 rows
    And The user will scroll down to view rows 1 and 2 if applicable
#  Reason: can not check the row number

  @NotAutomatable
  @S3475-AC7-AT8
  Scenario: Check row of the Asset Class list when the number of asset classes = 7 or 8+
    Then I should see there is 4 rows
    And The user will scroll down to view rows 1 and 2 if applicable
#  Reason: can not check the row number

  @S3475-AC7-AT9
  Scenario: Check the Asset Class in Overview Allocation Region list when the Asset Class value is 0.00
    Given I login as type "overview_class_list_one_zero"
    When I tap on the Allocation toggle
    And I swipe up from the bottom of the allocation graphic page
    Then I should see the following information:
      | element name                    | element value |
      | Assert Class name label         |               |
      | Total Asset value               | 0.00          |
      | Overview base currency          |               |
      | Total Assert Class value as a % |               |
#      | Donut bar representing % of assets owned for particular Asset Class                    |               |
#      | Donut bar is an empty circle to represent the assets                                   |               |

