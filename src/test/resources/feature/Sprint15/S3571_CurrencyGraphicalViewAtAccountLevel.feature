@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-3571 @Sprint15_iOS
@Story_GPBM-3616 @Sprint15_aOS

Feature: Currency graphical view at Account Level

  As a Client I want to be able to graphically view my exposure to different currencies within an account, regarding my positive asset holdings
  So that I can instantly gain an understanding of the key information regarding my currency exposure

  @SIT
  Scenario: only owns positive total holding values for their Currency at Account Level
    Given I login as type "account_currency_only_positive"
    When I tap on the Allocation toggle
    And I tap on Currency tab
    Then I should on the Allocation graphical view

  @S3571-AC1-AT1
  @DependsOn('only_owns_positive_total_holding_values_for_their_Currency_at_Account_Level')
  Scenario: Check the Account Allocation Currency Graphic mode wrapper UI When only owns positive total holding values for their Currencies
    Given I am on the Allocation graphical view
    Then I should see the wrapper above the graphic contains the following:
      | element region | element name            | element value    |
      |                | Asset allocation label  | Asset allocation |
      |                | Name label              |                  |
      |                | Region Or ID            |                  |
      |                | Account Back button     |                  |
      |                | Asset Class             | Asset class      |
      |                | Currency                | Currency         |
      | UK             | Region                  | Region           |
      |                | More menu icon          |                  |
      |                | Asset Allocation toggle |                  |

  @S3571-AC1-AT2
  @DependsOn('only_owns_positive_total_holding_values_for_their_Currency_at_Account_Level')
  Scenario: Check the Account allocation Currency Graphic UI When only owns positive total holding values for their Currencies
    Given I am on the Allocation graphical view
    Then I should view a graphic following:
      | element name       | element value  |
      | Graphic            |                |
      | Total assets label | Account assets |
      | Total assets value |                |
      | key                |                |

  @S3571-AC1-AT3
  @SIT
  @DependsOn('only_owns_positive_total_holding_values_for_their_Currency_at_Account_Level')
  Scenario: Check the ISO 3 code format of "Account assets" value and the  2dp format of Account base currency at the Account allocation currency wrapper When only owns positive total holding values for their Currencies
    Given I am on the Allocation graphical view
    Then I should see the allocation total assets are displayed in ISO 3 code and 2 d.p. format

  @NotAutomatable
  Scenario: Check the status of Asset Allocation toggle and Currency tab at the Account allocation currency wrapper When only owns positive total holding values for their Currencies
    Given I am at Account level
    When I tap on the Allocation toggle
    Then the Asset Allocation toggle is ACTIVE
    And The currency tab becomes the ACTIVE state
  #@S3571-AC1-AT4
  #Reason: Cannot check the toggle state

  @SIT
  @Sprint18
  Scenario: owns both positive and negative total holding values in different Currencies at Account Level
    Given I login as type "account_currency_positive_and_negative_net_positive"
    When I tap on the Allocation toggle
    And I tap on Currency tab
    Then I should on the Allocation graphical view

  @S3571-AC2-AT1
  @DependsOn('owns_both_positive_and_negative_total_holding_values_in_different_Currencies_at_Account_Level')
  Scenario: Check the Account Allocation Currency Graphic mode wrapper UI When owns both positive and negative total holding values in different Currencies
    Given I am on the Allocation graphical view
    Then I should see the wrapper above the graphic contains the following:
      | element region | element name            | element value    |
      |                | Asset allocation label  | Asset allocation |
      |                | Name label              |                  |
      |                | Region Or ID            |                  |
      |                | Account Back button     |                  |
      |                | Asset Class             | Asset class      |
      |                | Currency                | Currency         |
      | UK             | Region                  | Region           |
      |                | More menu icon          |                  |
      |                | Asset Allocation toggle |                  |

  @Sprint18
  @S3571-AC2-AT2
  @DependsOn('owns_both_positive_and_negative_total_holding_values_in_different_Currencies_at_Account_Level')
  Scenario: Check the Account allocation Currency Graphic UI When owns both positive and negative total holding values in different Currencies
    Given I am on the Allocation graphical view
    Then I should view a graphic following:
      | element name          | element value                |
      | Graphic               |                              |
      | Total assets label    | Account assets               |
      | Total assets value    |                              |
      | Total assets currency |                              |
      | graphic includes copy | Positive exposures displayed |
      | key                   |                              |

  @S3571-AC2-AT3
  @SIT
  @DependsOn('owns_both_positive_and_negative_total_holding_values_in_different_Currencies_at_Account_Level')
  Scenario: Check the ISO 3 code format of "Account assets" value and the  2dp format of Account base currency at the Account allocation currency wrapper When owns both positive and negative total holding values in different Currencies
    Given I am on the Allocation graphical view
    Then I should see the allocation total assets are displayed in ISO 3 code and 2 d.p. format

  @NotAutomatable
  Scenario: Check the Check the status of Asset Allocation toggle and Currency tab at the Account allocation currency wrapper When owns both positive and negative total holding values in different Currencies
    Given I am on the Allocation graphical view
    Then the Asset Allocation toggle is ACTIVE
    And The Currency tab becomes the ACTIVE state
  #@S3571-AC2-AT4
  #Reason: Cannot check the toggle state

#  @S3571-AC3-AT1
#  Scenario: Check the Account Allocation Currency Graphic mode wrapper UI When not have holdings in an Currency
#    Given I am on the Allocation graphical view
#    Then I should view a graphic following:
#      | element region | element name            | element value    |
#      |                | Asset allocation label  | Asset allocation |
#      |                | Name label            |                  |
#      |                | Region Or ID            |                  |
#      |                | Asset Class             | Asset class            |
#      |                | Currency                | Currency         |
#      | UK             | Region                  | Region           |
#      |                | More menu icon          |                  |
#      |                | Asset Allocation toggle |                  |
#
#  @NotAutomatable
#  Scenario: Check the Account allocation Currency Graphic UI When not have holdings in an Currency
#    Given I am at Account level
#    When I tap on the Allocation toggle
#    And I tap the account Allocation Currency Tab
#    Then I should view a graphic
#    And the Currency which does not have holdings is NOT represented on the graphic donut chart
#    And I can NOT see the currency which does not have holdings in a key below the tab
##  @S3571-AC3-AT2
##  Reason: don't know which currency not have holdings
#
#  @S3571-AC3-AT3
#  Scenario: Check the ISO 3 code format of "Account assets" value and the  2dp format of Account base currency at the Account allocation currency wrapper When not have holdings in an Currency
#    Then I should see the Account assets value is displayed in ISO 3 code and 2 d.p. format
#    And the Account base currency is displayed ISO 3 code
#
#  @NotAutomatable
#  Scenario: Check the Check the status of Asset Allocation toggle and Currency tab at the Account allocation currency wrapper When not have holdings in an Currency
#    Given I am at Account level
#    When I tap on the Allocation toggle
#    And I tap on Currency tab
#    Then  the Asset Allocation toggle is ACTIVE
#    And The currency tab becomes the ACTIVE state
#  #@S3571-AC3-AT4
#  #Reason: Cannot check the toggle state
#
#  @S3571-AC3-AT5
#  Scenario: Check the key of each Account allocation currency they are invested in when securities purchased in >=8 currencies And owns both positive and negative total holding values in different Currencies
#    Given I am at Account level
#    And there are more than 8 currencies
#    And the "Others" Currency net is positive
#    When I tap on the Allocation toggle
#    And I tap on Currency tab
#    Then I should see the currency label of "Others"
#    And the 8th currency item and more than 8th currency item will be included in "Others"
#
#  @S3571-AC3-AT6
#  Scenario: Check whether the key and graphic no shown when Account allocation "Others" Currency net is negative
#    Given I am at Account level
#    And there are more than 8 currencies
#    And the "Others" Currency net is negative
#    When I tap on the Allocation toggle
#    And I tap on Currency tab
#    Then my negative Currencies "Others" are NOT shown in the key
#    And my negative Currencies "Others" are NOT represented on the graphic

  @S3571-AC4-AT1
  Scenario: Check Exit Account Allocation Currency Graphic mode and whether the Account wrapper can keep previous maximised status
    Given I login as type "has_account"
    And I tap first item of Accounts list
    And I tap on the Allocation toggle
    And I tap on Currency tab
    When I tap on the Allocation toggle
    Then I am returned back to the Account page
    And the Account wrapper should be maximised
#    And the toggle becomes the INACTIVE state
  #Remark: Cannot check the toggle state

  @S3571-AC4-AT2
  Scenario: Check Exit Account Allocation Currency Graphic mode and whether the Account wrapper can keep previous minifiles status
    Given I login as type "has_account"
    And I tap first item of Accounts list
    And the Account wrapper is minifiles
    And I tap on the Allocation toggle
    And I tap on Currency tab
    When I tap on the Allocation toggle
    Then I am returned back to the Account page
    And the Account wrapper is minifiles
#    And the toggle becomes the INACTIVE state
  #Remark: Cannot check the toggle state

  @S3571-AC5-AT1
  Scenario: Check Exit Account Allocation Currency Graphic mode via breadcrumb and whether the Account wrapper can keep previous maximised status
#  Background：the overview wrapper is maximised
    Given I login as type "has_account"
    And I tap first item of Accounts list
    And I tap on the Allocation toggle
    And I tap on Currency tab
    When I tap on the account breadcrumb (back button)
    Then I am returned back to the Overview page
    And the Overview wrapper is maximised
#    And the toggle becomes the INACTIVE state
  #Remark: Cannot check the toggle state

  @S3571-AC5-AT2
  Scenario: Check Exit Account Allocation Currency Graphic mode via breadcrumb and whether the Account wrapper can keep previous minifiles status
#  Background：the overview wrapper is minifiles
    Given I login as type "has_account"
    And the Overview wrapper is minifiles
    And I tap first item of Accounts list
    And I tap on the Allocation toggle
    And I tap on Currency tab
    When I tap on the account breadcrumb (back button)
    Then I am returned back to the Overview page
    And the Overview wrapper should be minifiles
#    And the toggle becomes the INACTIVE state
  #Remark: Cannot check the toggle state

  @SIT
  @Sprint18
  Scenario: only holds negative holdings in their Currency at Account Level
    Given I login as type "account_currency_only_negative"
    When I tap on the Allocation toggle
    And I tap on Currency tab
    Then I should on the Allocation graphical view

  @S3571-AC6-AT1
  @DependsOn('only_holds_negative_holdings_in_their_Currency_at_Account_Level')
  Scenario: Check the Account Allocation Currency Graphic mode wrapper UI When only holds negative holdings in their Currencies
    Given I am on the Allocation graphical view
    Then I should see the wrapper above the graphic contains the following:
      | element region | element name            | element value    |
      |                | Asset allocation label  | Asset allocation |
      |                | Name label              |                  |
      |                | Region Or ID            |                  |
      |                | Account Back button     |                  |
      |                | Asset Class             | Asset class      |
      |                | Currency                | Currency         |
      | UK             | Region                  | Region           |
      |                | More menu icon          |                  |
      |                | Asset Allocation toggle |                  |

  @Sprint18
  @S3571-AC6-AT2
  @DependsOn('only_holds_negative_holdings_in_their_Currency_at_Account_Level')
  Scenario: Check the Account allocation Currency Graphic UI When only holds negative holdings in their Currencies
    Given I am on the Allocation graphical view
    Then I should view a graphic following:
      | element name          | element value                                                                        |
      | Graphic               |                                                                                      |
      | Total assets label    | Account assets                                                                       |
      | Total assets value    |                                                                                      |
      | Total assets currency |                                                                                      |
      | graphic includes copy | Negative values not shown                                                            |
      | state copy            | All investment holdings within this account are negative. Swipe up for more details. |

  @S3571-AC6-AT3
  @SIT
  @DependsOn('only_holds_negative_holdings_in_their_Currency_at_Account_Level')
  Scenario: Check the ISO 3 code format of "Account assets" value and the  2dp format of Account base currency at the Account allocation currency wrapper When only holds negative holdings in their Currencies
    Given I am on the Allocation graphical view
    Then I should see the allocation total assets are displayed in ISO 3 code and 2 d.p. format

  @NotAutomatable
  Scenario: Check the Check the status of Asset Allocation toggle and Currency tab at the Account allocation currency wrapper When only holds negative holdings in their Currencies
    Given I am on the Allocation graphical view
    Then  the Asset Allocation toggle is ACTIVE
    And The Currency tab becomes the ACTIVE state
      #@S3571-AC6-AT4
      #Reason: Cannot check the toggle state

  @Sprint17
  @SIT
  @Sprint18
  Scenario: Currency net holdings are negative at Account Level
    Given I login as type "account_currency_positive_and_negative_net_negative"
    When I tap on the Allocation toggle
    And I tap on Currency tab
    Then I should on the Allocation graphical view

  @Sprint17
  @S3571-AC7-AT1
  @DependsOn('Currency_net_holdings_are_negative_at_Account_Level')
  Scenario: Check the Account Allocation Currency Graphic mode wrapper UI When net holdings are negative
    Given I am on the Allocation graphical view
    Then I should see the wrapper above the graphic contains the following:
      | element region | element name            | element value    |
      |                | Asset allocation label  | Asset allocation |
      |                | Name label              |                  |
      |                | Region Or ID            |                  |
      |                | Account Back button     |                  |
      |                | Asset Class             | Asset class      |
      |                | Currency                | Currency         |
      | UK             | Region                  | Region           |
      |                | More menu icon          |                  |
      |                | Asset Allocation toggle |                  |

  @Sprint17
  @Sprint18
  @S3571-AC7-AT2
  @DependsOn('Currency_net_holdings_are_negative_at_Account_Level')
  Scenario: Check the Account allocation Currency Graphic UI When net holdings are negative
    Given I am on the Allocation graphical view
    Then I should view a graphic following:
      | element name          | element value                |
      | Graphic               |                              |
      | Total assets label    | Account assets               |
      | Total assets value    |                              |
      | Total assets currency |                              |
      | graphic includes copy | Positive exposures displayed |
#      | state copy            | Net investment holdings within this account are negative. Swipe up for more details. |

  @S3571-AC7-AT3
  @SIT
  @DependsOn('Currency_net_holdings_are_negative_at_Account_Level')
  Scenario: Check the ISO 3 code format of "Account assets" value and the  2dp format of Account base currency at the Account allocation currency wrapper When net holdings are negative
    Given I am on the Allocation graphical view
    Then I should see the allocation total assets are displayed in ISO 3 code and 2 d.p. format

  @NotAutomatable
  Scenario: Check the Check the status of Asset Allocation toggle and Currency tab at the Account allocation currency wrapper When net holdings are negative
    Given I am on the Allocation graphical view
    Then  the Asset Allocation toggle is ACTIVE
    And The Currency tab becomes the ACTIVE state
      #@S3571-AC7-AT4
      #Reason: Cannot check the toggle state

  @SIT
  @Sprint18
  Scenario: does not have any holdings in any Currency at Account Level
    Given I login as type "account_currency_all_no_holdings"
    When I tap on the Allocation toggle
    And I tap on Currency tab
    Then I should on the Allocation graphical view

  @S3571-AC8-AT1
  @DependsOn('does_not_have_any_holdings_in_any_Currency_at_Account_Level')
  Scenario: Check the Account Allocation Currency Graphic mode wrapper UI When  Client does not have any holdings in any Currency - Edge
    Given I am on the Allocation graphical view
    Then I should see the wrapper above the graphic contains the following:
      | element region | element name            | element value    |
      |                | Asset allocation label  | Asset allocation |
      |                | Name label              |                  |
      |                | Region Or ID            |                  |
      |                | Account Back button     |                  |
      |                | Asset Class             | Asset class      |
      |                | Currency                | Currency         |
      | UK             | Region                  | Region           |
      |                | More menu icon          |                  |
      |                | Asset Allocation toggle |                  |

  @Sprint18
  @S3571-AC8-AT2
  @DependsOn('does_not_have_any_holdings_in_any_Currency_at_Account_Level')
  Scenario: Check the Account allocation Currency Graphic UI When Client does not have any holdings in any Currency
    Given I am on the Allocation graphical view
    Then I should view a graphic following:
      | element name          | element value                                                              |
      | Graphic               |                                                                            |
      | Total assets label    | Account assets                                                             |
      | Total assets value    | 0.00                                                                       |
      | Total assets currency |                                                                            |
      | state copy            | Exposure by currency unavailable as there are no holdings in your account. |

  @S3571-AC8-AT3
  @SIT
  @DependsOn('does_not_have_any_holdings_in_any_Currency_at_Account_Level')
  Scenario: Check the ISO 3 code format of "Account assets" value and the  2dp format of Account base currency at the Account allocation currency wrapper When not have holdings in an Currency
    Given I am on the Allocation graphical view
    Then I should see the allocation total assets are displayed in ISO 3 code and 2 d.p. format

  @NotAutomatable
  Scenario: Check the Check the status of Asset Allocation toggle and Currency tab at the Account allocation currency wrapper When not have holdings in an Currency
    Given I am on the Allocation graphical view
    Then  the Asset Allocation toggle is ACTIVE
    And The Currency tab becomes the ACTIVE state
      #@S3571-AC8-AT4
      #Reason: Cannot check the toggle state

  @S3571-AC8-AT4
  @SIT
  Scenario: Check whether the Total asset value at the Account Asset Allocation currency Graphic mode equals the Total asset value at Account wrapper
    Given I login as type "account_currency_only_positive"
    When I tap on the Allocation toggle and remember "Account" Total asset value
    And I tap on Currency tab
    Then I should see total asset value at the Asset Allocation Graphic mode equals the Total asset value at wrapper
