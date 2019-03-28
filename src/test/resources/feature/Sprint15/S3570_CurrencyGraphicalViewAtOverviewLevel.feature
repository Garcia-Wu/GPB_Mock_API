@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-3570 @Sprint15_iOS
@Story_GPBM-3615 @Sprint15_aOS

Feature: Currency graphical view at Overview Level

  As a Client I want to be able to graphically view my exposure to different currencies across all of my accounts, regarding my positive asset holdings
  So that I can instantly gain an understanding of the key information regarding my currency exposure

  @SIT
  Scenario: only owns positive total holding values for their Currency at Overview Level
    Given I login as type "overview_currency_only_positive"
    When I tap on the Allocation toggle
    And I tap on Currency tab
    Then I should on the Allocation graphical view

  @S3570-AC1-AT1
  @DependsOn('only_owns_positive_total_holding_values_for_their_Currency_at_Overview_Level')
  Scenario: Check the Overview Allocation Currency Graphic mode wrapper UI When only owns positive total holding values for their Currencies
    Given I am on the Allocation graphical view
    Then I should see the wrapper above the graphic contains the following:
      | element region | element name            | element value    |
      |                | Asset allocation label  | Asset allocation |
      |                | Name label              |                  |
      | UK             | Region Or ID            | UK Accounts      |
      | SG             | Region Or ID            | SG Accounts      |
      | HK             | Region Or ID            | HK Accounts      |
      |                | Asset Class             | Asset class      |
      |                | Currency                | Currency         |
      | UK             | Region                  | Region           |
      |                | More menu icon          |                  |
      |                | Asset Allocation toggle |                  |

  @S3570-AC1-AT2
  @DependsOn('only_owns_positive_total_holding_values_for_their_Currency_at_Overview_Level')
  Scenario: Check the Overview allocation Currency Graphic UI When only owns positive total holding values for their Currencies
    Given I am on the Allocation graphical view
    Then I should view a graphic following:
      | element name       | element value |
      | Graphic            |               |
      | Total assets label | Total assets  |
      | Total assets value |               |
      | key                |               |

  @S3570-AC1-AT3
  @SIT
  @DependsOn('only_owns_positive_total_holding_values_for_their_Currency_at_Overview_Level')
  Scenario: Check the ISO 3 code format of "Total assets" value and the 2dp format of Overview base currency at the Overview allocation currency wrapper When only owns positive total holding values for their Currencies
    Given I am on the Allocation graphical view
    Then I should see the allocation total assets are displayed in ISO 3 code and 2 d.p. format

  @NotAutomatable
  Scenario: Check the status of Asset Allocation toggle and Currency tab at the Overview allocation currency wrapper When only owns positive total holding values for their Currencies
    Given I am on the Allocation graphical view
    Then the Asset Allocation toggle is ACTIVE
    And The currency tab becomes the ACTIVE state
  #@S3570-AC1-AT4
  #Reason: Cannot check the toggle state

  @SIT
  @Sprint18
  Scenario: owns both positive and negative total holding values in different Currencies at Overview Level
    Given I login as type "overview_currency_positive_and_negative_net_positive"
    When I tap on the Allocation toggle
    And I tap on Currency tab
    Then I should on the Allocation graphical view

  @S3570-AC2-AT1
  @DependsOn('owns_both_positive_and_negative_total_holding_values_in_different_Currencies_at_Overview_Level')
  Scenario: Check the Overview Allocation Currency Graphic mode wrapper UI When owns both positive and negative total holding values in different Currencies
    Given I am on the Allocation graphical view
#    And the wrapper is maximised
#    And I am entitled to view one or more accounts
#    And I only have positive total values for each Asset Class I am exposed to
    Then I should see the wrapper above the graphic contains the following:
      | element region | element name            | element value    |
      |                | Asset allocation label  | Asset allocation |
      |                | Name label              |                  |
      | UK             | Region Or ID            | UK Accounts      |
      | SG             | Region Or ID            | SG Accounts      |
      | HK             | Region Or ID            | HK Accounts      |
      |                | Asset Class             | Asset class      |
      |                | Currency                | Currency         |
      | UK             | Region                  | Region           |
      |                | More menu icon          |                  |
      |                | Asset Allocation toggle |                  |

  @Sprint18
  @S3570-AC2-AT2
  @DependsOn('owns_both_positive_and_negative_total_holding_values_in_different_Currencies_at_Overview_Level')
  Scenario: Check the Overview allocation Currency Graphic UI When owns both positive and negative total holding values in different Currencies
    Given I am on the Allocation graphical view
    Then I should view a graphic following:
      | element name          | element value                |
      | Graphic               |                              |
      | Total assets label    | Total assets                 |
      | Total assets value    |                              |
      | Total assets currency |                              |
      | graphic includes copy | Positive exposures displayed |
      | key                   |                              |

  @S3570-AC2-AT3
  @SIT
  @DependsOn('owns_both_positive_and_negative_total_holding_values_in_different_Currencies_at_Overview_Level')
  Scenario: Check the ISO 3 code format of "Total assets" value and the  2dp format of Overview base currency at the Overview allocation currency wrapper When owns both positive and negative total holding values in different Currencies
    Given I am on the Allocation graphical view
    Then I should see the allocation total assets are displayed in ISO 3 code and 2 d.p. format

  @NotAutomatable
  Scenario: Check the Check the status of Asset Allocation toggle and Currency tab at the Overview allocation currency wrapper When owns both positive and negative total holding values in different Currencies
    Given I am on the Allocation graphical view
    Then  the Asset Allocation toggle is ACTIVE
    And The currency tab becomes the ACTIVE state
#  @S3570-AC2-AT4
#  Reason: Cannot check the toggle state
  
#  Scenario: not have holdings in an Currency at Overview Level
#    Given I login as type "overview_currency_one_class_not_have_holdings"
#    When I tap on the Allocation toggle
#    Then I should on the Allocation graphical view
#
#  @S3570-AC3-AT1
#  Scenario: Check the Overview Allocation Currency Graphic mode wrapper UI When not have holdings in an Currency
#    Given I am on the Allocation graphical view
#    Then I should view a graphic following:
#      | element region | element name            | element value    |
#      |                | Asset allocation label  | Asset allocation |
#      |                | Name label            |                  |
#      | UK             | Region Or ID         | UK Accounts      |
#      | SG             | Region Or ID         | SG Accounts      |
#      | HK             | Region Or ID         | HK Accounts      |
#      |                | Asset Class             | Asset class            |
#      |                | Currency                | Currency         |
#      | UK             | Region                  | Region           |
#      |                | More menu icon          |                  |
#      |                | Asset Allocation toggle |                  |
#
#  @NotAutomatable
#  Scenario: Check the Graphic UI at the overview When not have holdings in an Currency
#    Given I am at Overview level
#    When I tap on the Allocation toggle
#    And then I tap on Currency tab
#    Then I should view a graphic
#    And The Currency is NOT represented on the graphic donut chart
#    And I can NOT see the currency in a key below the tab
##  @S3570-AC3-AT2
##  Reason: don't know which currency not have holdings
#
#  @S3570-AC3-AT3
#  Scenario: Check the ISO 3 code format of "Total assets" value and the  2dp format of Overview base currency at the Overview allocation currency wrapper When not have holdings in an Currency
#    Given I am at Overview level
#    When I tap on the Allocation toggle
#    And then I tap on Currency tab
#    Then I should see the allocation total assets are displayed in ISO 3 code and 2 d.p. format
#
#  @NotAutomatable
#  Scenario: Check the Check the status of Asset Allocation toggle and Currency tab at the Overview allocation currency wrapper When not have holdings in an Currency
#    Given I am on the Allocation graphical view
#    Then  the Asset Allocation toggle is ACTIVE
#    And The currency tab becomes the ACTIVE state
#  #@S3570-AC3-AT4
#  #Reason: Cannot check the toggle state
#
#  @S3570-AC3-AT5
#  Scenario: Check the key of each Overview allocation currency they are invested in when securities purchased in >=8 currencies And owns both positive and negative total holding values in different Currencies
#    Given I am at Overview level
#    And there are more than 8 currencies
#    And the "Others" Asset Class net is positive
#    When I tap on the Allocation toggle
#    And then I tap on Currency tab
#    Then I should see the currency label of "Others"
#    And the 8th currency item and more than 8th currency item will be included in "Others"
#
#  @S3570-AC3-AT6
#  Scenario: Check whether the key and graphic no shown when Overview allocation "Others" Currency net is negative
#    Given I am at Overview level
#    And there are more than 8 currencies
#    And the "Others" Asset Class net is negative
#    When I tap on the Allocation toggle
#    And then I tap on Currency tab
#    Then my negative Currencies "Others" are NOT shown in the key
#    And my negative Currencies "Others" are NOT represented on the graphic

  @S3570-AC4-AT1
  Scenario: Check Exit Overview Allocation Currency Graphic mode and whether the Overview wrapper can keep previous maximised status
  #Background：the overview wrapper is maximised
    Given I login as type "has_account"
    And I tap on the Allocation toggle
    And I tap on Currency tab
    When I tap on the Allocation toggle
    Then I am returned back to the Overview page
    And the Overview wrapper is maximised
#    And The toggle becomes the INACTIVE state
  #Remark: Cannot check the toggle state

  @S3570-AC4-AT2
  Scenario: Check Exit Overview Allocation Currency Graphic mode and whether the Overview wrapper can keep previous minifiles status
  #Background：the overview wrapper is minifiled
    Given I login as type "has_account"
    And the Overview wrapper is minifiles
    And I tap on the Allocation toggle
    And I tap on Currency tab
    When I tap on the Allocation toggle
    Then I am returned back to the Overview page
    And the Overview wrapper should be minifiles
#    And The toggle becomes the INACTIVE state
  #Remark: Cannot check the toggle state

  @SIT
  @Sprint18
  Scenario: only holds negative holdings in their Currency at Overview Level
    Given I login as type "overview_currency_only_negative"
    When I tap on the Allocation toggle
    And I tap on Currency tab
    Then I should on the Allocation graphical view

  @S3570-AC5-AT1
  @DependsOn('only_holds_negative_holdings_in_their_Currency_at_Overview_Level')
  Scenario: Check the Overview Allocation Currency Graphic mode wrapper UI When only holds negative holdings in their Currencies
    Given I am on the Allocation graphical view
    Then I should see the wrapper above the graphic contains the following:
      | element region | element name            | element value    |
      |                | Asset allocation label  | Asset allocation |
      |                | Name label              |                  |
      | UK             | Region Or ID            | UK Accounts      |
      | SG             | Region Or ID            | SG Accounts      |
      | HK             | Region Or ID            | HK Accounts      |
      |                | Asset Class             | Asset class      |
      |                | Currency                | Currency         |
      | UK             | Region                  | Region           |
      |                | More menu icon          |                  |
      |                | Asset Allocation toggle |                  |

  @Sprint18
  @S3570-AC5-AT2
  @DependsOn('only_holds_negative_holdings_in_their_Currency_at_Overview_Level')
  Scenario: Check the Overview allocation Currency Graphic UI When only holds negative holdings in their Currencies
    Given I am on the Allocation graphical view
    Then I should view a graphic following:
      | element name          | element value                                                                      |
      | Graphic               |                                                                                    |
      | Total assets label    | Total assets                                                                       |
      | Total assets value    |                                                                                    |
      | Total assets currency |                                                                                    |
      | graphic includes copy | Negative values not shown                                                          |
      | state copy            | All investment holdings across account(s) are negative. Swipe up for more details. |

  @S3570-AC5-AT3
  @SIT
  @DependsOn('only_holds_negative_holdings_in_their_Currency_at_Overview_Level')
  Scenario: Check the ISO 3 code format of "Total assets" value and the  2dp format of Overview base currency at the Overview allocation currency wrapper When only holds negative holdings in their Currencies
    Given I am on the Allocation graphical view
    Then I should see the allocation total assets are displayed in ISO 3 code and 2 d.p. format

  @NotAutomatable
  Scenario: Check the Check the status of Asset Allocation toggle and Currency tab at the Overview allocation currency wrapper When only holds negative holdings in their Currencies
    Given I am on the Allocation graphical view
    Then  the Asset Allocation toggle is ACTIVE
    And The currency tab becomes the ACTIVE state
      #@S3570-AC5-AT4
      #Reason: Cannot check the toggle state

  @Sprint17
  @SIT
  @Sprint18
  Scenario: Currency net holdings are negative at Overview Level
    Given I login as type "overview_currency_positive_and_negative_net_negative"
    When I tap on the Allocation toggle
    And I tap on Currency tab
    Then I should on the Allocation graphical view

  @Sprint17
  @S3570-AC6-AT1
  @DependsOn('Currency_net_holdings_are_negative_at_Overview_Level')
  Scenario: Check the Overview Allocation Currency Graphic mode wrapper UI When net holdings are negative
    Given I am on the Allocation graphical view
    Then I should see the wrapper above the graphic contains the following:
      | element region | element name            | element value    |
      |                | Asset allocation label  | Asset allocation |
      |                | Name label              |                  |
      | UK             | Region Or ID            | UK Accounts      |
      | SG             | Region Or ID            | SG Accounts      |
      | HK             | Region Or ID            | HK Accounts      |
      |                | Asset Class             | Asset class      |
      |                | Currency                | Currency         |
      | UK             | Region                  | Region           |
      |                | More menu icon          |                  |
      |                | Asset Allocation toggle |                  |

  @Sprint17
  @Sprint18
  @S3570-AC6-AT2
  @DependsOn('Currency_net_holdings_are_negative_at_Overview_Level')
  Scenario: Check the Overview allocation Currency Graphic UI When net holdings are negative
    Given I am on the Allocation graphical view
    Then I should view a graphic following:
      | element name          | element value                |
      | Graphic               |                              |
      | Total assets label    | Total assets                 |
      | Total assets value    |                              |
      | Total assets currency |                              |
      | graphic includes copy | Positive exposures displayed |
#      | state copy            | Net investment holdings across account(s) are negative. Swipe up for more details. |

  @S3570-AC6-AT3
  @SIT
  @DependsOn('Currency_net_holdings_are_negative_at_Overview_Level')
  Scenario: Check the ISO 3 code format of "Total assets" value and the  2dp format of Overview base currency at the Overview allocation currency wrapper When net holdings are negative
    Given I am on the Allocation graphical view
    Then I should see the allocation total assets are displayed in ISO 3 code and 2 d.p. format

  @NotAutomatable
  Scenario: Check the Check the status of Asset Allocation toggle and Currency tab at the Overview allocation currency wrapper When net holdings are negative
    Given I am at Overview level
    When I tap on the Allocation toggle
    And then I tap on Currency tab
    Then  the Asset Allocation toggle is ACTIVE
    And The asset class tab becomes the ACTIVE state
      #@S3570-AC6-AT4
      #Reason: Cannot check the toggle state

  @SIT
  @Sprint18
  Scenario: does not have any holdings in any Currency at Overview Level
    Given I login as type "overview_currency_all_no_holdings"
    When I tap on the Allocation toggle
    And I tap on Currency tab
    Then I should on the Allocation graphical view

  @S3570-AC7-AT1
  @DependsOn('does_not_have_any_holdings_in_any_Currency_at_Overview_Level')
  Scenario: Check the Overview Allocation Currency Graphic mode wrapper UI When  Client does not have any holdings in any Currency - Edge
    Given I am on the Allocation graphical view
    Then I should see the wrapper above the graphic contains the following:
      | element region | element name            | element value    |
      |                | Asset allocation label  | Asset allocation |
      |                | Name label              |                  |
      | UK             | Region Or ID            | UK Accounts      |
      | SG             | Region Or ID            | SG Accounts      |
      | HK             | Region Or ID            | HK Accounts      |
      |                | Asset Class             | Asset class      |
      |                | Currency                | Currency         |
      | UK             | Region                  | Region           |
      |                | More menu icon          |                  |
      |                | Asset Allocation toggle |                  |

  @Sprint18
  @S3570-AC7-AT2
  @DependsOn('does_not_have_any_holdings_in_any_Currency_at_Overview_Level')
  Scenario: Check the Overview allocation Currency Graphic UI When Client does not have any holdings in any Currency
    Given I am on the Allocation graphical view
    Then I should view a graphic following:
      | element name          | element value                                                                |
      | Graphic               |                                                                              |
      | Total assets label    | Total assets                                                                 |
      | Total assets value    | 0.00                                                                         |
      | Total assets currency |                                                                              |
      | state copy            | Exposure by currency unavailable as you have no holdings in your account(s). |

  @S3570-AC7-AT3
  @SIT
  @DependsOn('does_not_have_any_holdings_in_any_Currency_at_Overview_Level')
  Scenario: Check the ISO 3 code format of "Total assets" value and the  2dp format of Overview base currency at the Overview allocation currency wrapper When not have holdings in an Currency
    Given I am on the Allocation graphical view
    Then I should see the allocation total assets are displayed in ISO 3 code and 2 d.p. format

  @NotAutomatable
  Scenario: Check the Check the status of Asset Allocation toggle and Currency tab at the Overview allocation currency wrapper When not have holdings in an Currency
    Given I am at Overview level
    When I tap on the Allocation toggle
    Then  the Asset Allocation toggle is ACTIVE
    And then I tap on Currency tab
    And The asset class tab becomes the ACTIVE state
      #@S3570-AC7-AT4
      #Reason: Cannot check the toggle state

  @S3570-AC7-AT4
  @SIT
  Scenario: Check whether the Total asset value at the overview Asset Allocation currency Graphic mode equals the Total asset value at overview wrapper
    Given I login as type "overview_currency_only_positive"
    When I tap on the Allocation toggle and remember "Overview" Total asset value
    And I tap on Currency tab
    Then I should see total asset value at the Asset Allocation Graphic mode equals the Total asset value at wrapper