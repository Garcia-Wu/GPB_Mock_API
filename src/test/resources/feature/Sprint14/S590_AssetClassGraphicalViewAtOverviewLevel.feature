@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-3477 @Sprint14_iOS
@Story_GPBM-3595 @Sprint14_aOS

Feature: Asset Class graphical view at Overview Level

  As a Client I want to be able to graphically view my exposure to different asset classes across all of my accounts, regarding my positive asset holdings
  So that I can instantly gain an understanding of the key information regarding my asset class exposure

#  Scenario 1:Client only owns positive total holding values for their Asset Classes
  @SIT
  Scenario: only owns positive total holding values for their Asset Classes at Overview Level
    Given I login as type "overview_class_only_positive"
    When I tap on the Allocation toggle
    Then I should on the Allocation graphical view

  @S590-AC1-AT1
  @DependsOn('only_owns_positive_total_holding_values_for_their_Asset_Classes_at_Overview_Level')
  Scenario: Check the Asset Allocation Graphic mode wrapper UI at the overview When only owns positive total holding values for their Asset Classes
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

  @S590-AC1-AT2
  @DependsOn('only_owns_positive_total_holding_values_for_their_Asset_Classes_at_Overview_Level')
  Scenario: Check the Graphic UI at the overview When only owns positive total holding values for their Asset Classes
    Given I am on the Allocation graphical view
    Then I should view a graphic following:
      | element name       | element value |
      | Graphic            |               |
      | Total assets label | Total assets  |
      | Total assets value |               |
      | key                |               |

  @S590-AC1-AT3
  @SIT
  @DependsOn('only_owns_positive_total_holding_values_for_their_Asset_Classes_at_Overview_Level')
  Scenario: Check the "Total assets" value and the format of "Total assets" value at the overview When only owns positive total holding values for their Asset Classes
    Given I am on the Allocation graphical view
    Then I should see the allocation total assets are displayed in ISO 3 code and 2 d.p. format

#   Scenario 2:Client owns both positive and negative total holding values in different Asset Classes
  @SIT
  @Sprint18
  Scenario: owns both positive and negative total holding values in different Asset Classes at Overview Level
    Given I login as type "overview_class_positive_and_negative_net_positive"
    When I tap on the Allocation toggle
    Then I should on the Allocation graphical view

  @S590-AC2-AT1
  @DependsOn('owns_both_positive_and_negative_total_holding_values_in_different_Asset_Classes_at_Overview_Level')
  Scenario: Check the Asset Allocation Graphic mode wrapper UI at the overview When owns both positive and negative total holding values in different Asset Classes
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
  @S590-AC2-AT2
  @DependsOn('owns_both_positive_and_negative_total_holding_values_in_different_Asset_Classes_at_Overview_Level')
  Scenario: Check the Graphic UI at the overview When owns both positive and negative total holding values in different Asset Classes
    Given I am on the Allocation graphical view
    Then I should view a graphic following:
      | element name          | element value                |
      | Graphic               |                              |
      | Total assets label    | Total assets                 |
      | Total assets value    |                              |
      | Total assets currency |                              |
      | graphic includes copy | Positive exposures displayed |
      | key                   |                              |

  @S590-AC2-AT3
  @SIT
  @DependsOn('owns_both_positive_and_negative_total_holding_values_in_different_Asset_Classes_at_Overview_Level')
  Scenario: Check the "Total assets" value and the format of "Total assets" value at the overview When owns both positive and negative total holding values in different Asset Classes
    Given I am on the Allocation graphical view
    Then I should see the allocation total assets are displayed in ISO 3 code and 2 d.p. format

# Remove sprint 15，"Others" is a normal assert class
#  @S590-AC2-AT4
#  @DependsOn('owns_both_positive_and_negative_total_holding_values_in_different_Asset_Classes_at_Overview_Level')
#  Scenario: Check the key of each asset classes they are invested in when securities purchased in >=8 classes and only owns positive total holding values for their Asset Classes.
#    Given I am on the Allocation graphical view
#    Then I should not see the asset class label of "Others"

##    Scenario 3: Client does not have holdings in an Asset Class
#  Scenario: not have holdings in an Asset Class at Overview Level
#    Given I login as type "overview_allocation_one_class_not_have_holdings"
#    When I tap on the Allocation toggle
#    Then I should on the Allocation graphical view
#
#  @S590-AC3-AT1
#  @DependsOn('not_have_holdings_in_an_Asset_Class_at_Overview_Level')
#  Scenario: Check the Asset Allocation Graphic mode wrapper UI at the overview When not have holdings in an Asset Class
#    Given I am on the Allocation graphical view
##    And the wrapper is maximised
##    And I am entitled to view one or more accounts
##    And I only have positive total values for each Asset Class I am exposed to
#    Then I should see the wrapper above the graphic contains the following:
#      | element region | element name            | element value    |
#      |                | Asset allocation label  | Asset allocation |
#      |                | Name label            |                  |
#      | UK             | Region Or ID            | UK Accounts      |
#      | SG             | Region Or ID            | SG Accounts      |
#      | HK             | Region Or ID            | HK Accounts      |
#      |                | Asset Class             | Asset class            |
#      |                | Currency                | Currency         |
#      | UK             | Region                  | Region           |
#      |                | More menu icon          |                  |
#      |                | Asset Allocation toggle |                  |
#
#  @NotAutomatable
#  Scenario: Check the Graphic UI at the overview When not have holdings in an Asset Class
#    Given I am on the Allocation graphical view
#    Then I should view a graphic
#    And not have holdings Asset Class is NOT represented on the graphic donut chart
#    And I can NOT see the asset class in a key below the tab
##  @S590-AC3-AT2
##  Reason: don't know which asset class not have holdings
#
#  @S590-AC3-AT3
#  @DependsOn('not_have_holdings_in_an_Asset_Class_at_Overview_Level')
#  Scenario: Check the "Total assets" value and the format of "Total assets" value at the overview When not have holdings in an Asset Class
#    Given I am on the Allocation graphical view
#    Then I should see the allocation total assets are displayed in ISO 3 code and 2 d.p. format

#  Scenario 4: Exit Asset Allocation Graphic mode
  @S590-AC4-AT1
  Scenario: Check Exit Asset Allocation Graphic mode
    Given I login as type "has_account"
    And I tap on the Allocation toggle
    When I tap on the Allocation toggle
    Then I am returned back to the Overview page
    And the Overview wrapper is maximised
#    And the toggle becomes the INACTIVE state

#  Scenario 5: Client only holds negative holdings in their Asset Classes
  @SIT
  @Sprint18
  Scenario: only holds negative holdings in their Asset Classes at Overview Level
    Given I login as type "overview_class_only_negative"
    When I tap on the Allocation toggle
    Then I should on the Allocation graphical view

  @S590-AC5-AT1
  @DependsOn('only_holds_negative_holdings_in_their_Asset_Classes_at_Overview_Level')
  Scenario: Check the Asset Allocation Graphic mode wrapper UI at the overview When only holds negative holdings in their Asset Classes
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
  @S590-AC5-AT2
  @DependsOn('only_holds_negative_holdings_in_their_Asset_Classes_at_Overview_Level')
  Scenario: Check the Graphic UI at the overview When only holds negative holdings in their Asset Classes
    Given I am on the Allocation graphical view
    Then I should view a graphic following:
      | element name          | element value                                                                      |
      | Graphic               |                                                                                    |
      | Total assets label    | Total assets                                                                       |
      | Total assets value    |                                                                                    |
      | Total assets currency |                                                                                    |
      | graphic includes copy | Negative values not shown                                                          |
      | state copy            | All investment holdings across account(s) are negative. Swipe up for more details. |

  @S590-AC5-AT3
  @SIT
  @DependsOn('only_holds_negative_holdings_in_their_Asset_Classes_at_Overview_Level')
  Scenario: Check the "Total assets" value and the format of "Total assets" value at the overview When only holds negative holdings in their Asset Classes at Overview Level
    Given I am on the Allocation graphical view
    Then I should see the allocation total assets are displayed in ISO 3 code and 2 d.p. format

#  Scenario 6: Client's net holdings are negative
  @Sprint17
  @SIT
  @Sprint18
  Scenario: net holdings are negative at Overview Level
    Given I login as type "overview_class_positive_and_negative_net_negative"
    When I tap on the Allocation toggle
    Then I should on the Allocation graphical view

  @S590-AC6-AT1
  @Sprint17
  @DependsOn('net_holdings_are_negative_at_Overview_Level')
  Scenario: Check the Asset Allocation Graphic mode wrapper UI at the overview When net holdings are negative
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
  @S590-AC6-AT2
  @DependsOn('net_holdings_are_negative_at_Overview_Level')
  Scenario:Check the Graphic UI at the overview When net holdings are negative
    Given I am on the Allocation graphical view
    Then I should view a graphic following:
      | element name          | element value                |
      | Graphic               |                              |
      | Total assets label    | Total assets                 |
      | Total assets value    |                              |
      | Total assets currency |                              |
      | graphic includes copy | Positive exposures displayed |
#      | state copy            | Net investment holdings across account(s) are negative. Swipe up for more details. |

  @S590-AC6-AT3
  @SIT
  @Sprint17
  @DependsOn('net_holdings_are_negative_at_Overview_Level')
  Scenario: Check the "Total assets" value and the format of "Total assets" value at the overview When net holdings are negative at Overview Level
    Given I am on the Allocation graphical view
    Then I should see the allocation total assets are displayed in ISO 3 code and 2 d.p. format

  @Sprint18
#  Scenario 7: Client does not have any holdings in any Asset Class
  @SIT
  Scenario: does not have any holdings in any Asset Class at Overview Level
    Given I login as type "overview_class_all_no_holdings"
    When I tap on the Allocation toggle
    Then I should on the Allocation graphical view

  @S590-AC7-AT1
  @DependsOn('does_not_have_any_holdings_in_any_Asset_Class_at_Overview_Level')
  Scenario: Check the Asset Allocation Graphic mode wrapper UI at the overview When does not have any Asset Class at Overview Level
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
  @S590-AC7-AT2
  @DependsOn('does_not_have_any_holdings_in_any_Asset_Class_at_Overview_Level')
  Scenario: Check the Graphic UI at the overview When does not have any Asset Class at Overview Level
    Given I am on the Allocation graphical view
    Then I should view a graphic following:
      | element name          | element value                                                                   |
      | Graphic               |                                                                                 |
      | Total assets label    | Total assets                                                                    |
      | Total assets value    | 0.00                                                                            |
      | Total assets currency |                                                                                 |
      | state copy            | Exposure by asset class unavailable as you have no holdings in your account(s). |

  @S590-AC7-AT3
  @SIT
  @('does_not_have_any_holdings_in_any_Asset_Class_at_Overview_Level')
  @DependsOn('does_not_have_any_holdings_in_any_Asset_Class_at_Overview_Level')
  Scenario: Check the "Total assets" value and the format of "Total assets" value at the overview When does not have any holdings in any Asset Class at Overview Level
    Given I am on the Allocation graphical view
    Then I should see the allocation total assets are displayed in ISO 3 code and 2 d.p. format

#   It's not specified in the story

  @ReTest
  @S590-AC8-AT1
  Scenario: Check whether the Total asset value at the overview Asset Allocation Graphic mode equals the Total asset value at overview wrapper
    Given I login as type "has_account"
    When I tap on the Allocation toggle and remember "Overview" Total asset value
    Then I should see total asset value at the Asset Allocation Graphic mode equals the Total asset value at wrapper

  @S590-AC8-AT2
  Scenario: Check the format of Total asset at the overview
    Given I login as type "has_account"
    When I tap on the Allocation toggle
    Then the value for the Total assets they own within all of the accounts is displayed, which will be 18 characters max. including commas and decimal point
#, e.g. 999,999,999,999.99


  @NotAutomatable
  Scenario: Check whether the graphic show asset class when it amount is equal to the "0.111"
    Given I am at Overview level
    And I tap on the Asset Allocation toggle
    Then I should see the graphic show asset class
#  @S590-AC8-AT3
#  Reason: can not check the graphic show asset class

  @NotAutomatable
  Scenario: Check whether the graphic not show asset class when it amount is equal to the "0.00"
    Given I am at Overview level
    And I tap on the Asset Allocation toggle
    Then I should see the graphic not show asset class
#  @S590-AC8-AT4
#  Reason: can not check the graphic not show asset class

  @S590-AC8-AT5
  Scenario: Check whether the "Total assets" value equal to the "0.00" When owns both positive and negative total holding values net holdings are "0.00”
    Given I login as type "overview_class_net_zero"
    When I tap on the Allocation toggle
    Then I am on the Allocation graphical view
    And I should see the Total assets value equal to the "0.00"