@UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-3574 @Sprint15_iOS
@Story_GPBM-3618 @Sprint15_aOS

Feature: Region graphical view at Overview Level

  As a Client I want to be able to graphically view my exposure to different regions across all of my accounts, regarding my positive asset holdings
  So that I can instantly gain an understanding of the key information regarding my region exposure


  @SIT
  Scenario: only owns positive total holding values for their Region at Overview Level
    Given I login as type "overview_region_only_positive"
    When I tap on the Allocation toggle
    And I tap on Region tab
    Then I should on the Allocation graphical view

  @S3574-AC1-AT1
  @DependsOn('only_owns_positive_total_holding_values_for_their_Region_at_Overview_Level')
  Scenario: Check the Overview Allocation Region Graphic mode wrapper UI When only owns positive total holding values for their Regions
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

  @S3574-AC1-AT2
  @DependsOn('only_owns_positive_total_holding_values_for_their_Region_at_Overview_Level')
  Scenario: Check the Overview allocation Region Graphic UI When only owns positive total holding values for their Regions
    Given I am on the Allocation graphical view
    Then I should view a graphic following:
      | element name       | element value |
      | Graphic            |               |
      | Total assets label | Total assets  |
      | Total assets value |               |
      | key                |               |

  @S3574-AC1-AT3
  @SIT
  @DependsOn('only_owns_positive_total_holding_values_for_their_Region_at_Overview_Level')
  Scenario: Check the ISO 3 code format of "Total assets" value and the  2dp format of Overview base currency at the Overview allocation region wrapper When only owns positive total holding values for their Regions
    Given I am on the Allocation graphical view
    Then I should see the allocation total assets are displayed in ISO 3 code and 2 d.p. format

  @NotAutomatable
  Scenario: Check the status of Asset Allocation toggle and Region tab at the Overview allocation currency wrapper When only owns positive total holding values for their Regions
    Given I am on the Allocation graphical view
    Then the Asset Allocation toggle is ACTIVE
    And The currency tab becomes the ACTIVE state
  #S3574-AC1-AT4
  #Reason: Cannot check the toggle state

  @SIT
  @Sprint18
  Scenario: owns both positive and negative total holding values in different Regions at Overview Level
    Given I login as type "overview_region_positive_and_negative_net_positive"
    When I tap on the Allocation toggle
    And I tap on Region tab
    Then I should on the Allocation graphical view

  @S3574-AC2-AT1
  @DependsOn('owns_both_positive_and_negative_total_holding_values_in_different_Regions_at_Overview_Level')
  Scenario: Check the Overview Allocation Region Graphic mode wrapper UI When owns both positive and negative total holding values in different Regions
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
  @S3574-AC2-AT2
  @DependsOn('owns_both_positive_and_negative_total_holding_values_in_different_Regions_at_Overview_Level')
  Scenario: Check the Overview allocation Region Graphic UI When owns both positive and negative total holding values in different Regions
    Given I am on the Allocation graphical view
    Then I should view a graphic following:
      | element name          | element value                |
      | Graphic               |                              |
      | Total assets label    | Total assets                 |
      | Total assets value    |                              |
      | Total assets currency |                              |
      | graphic includes copy | Positive exposures displayed |
      | key                   |                              |

  @S3574-AC2-AT3
  @SIT
  @DependsOn('owns_both_positive_and_negative_total_holding_values_in_different_Regions_at_Overview_Level')
  Scenario: Check the ISO 3 code format of "Total assets" value and the  2dp format of Overview base region at the Overview allocation region wrapper When owns both positive and negative total holding values in different Regions
    Given I am on the Allocation graphical view
    Then I should see the allocation total assets are displayed in ISO 3 code and 2 d.p. format

  @NotAutomatable
  Scenario: Check the Check the status of Asset Allocation toggle and Region tab at the Overview allocation region wrapper When owns both positive and negative total holding values in different Regions
    Given I am on the Allocation graphical view
    Then  the Asset Allocation toggle is ACTIVE
    And The currency tab becomes the ACTIVE state
  #S3574-AC2-AT4
  #Reason: Cannot check the toggle state
#
#  Scenario: not have holdings in an Region at Overview Level
#    Given I login as type "overview_allocation_one_region_not_have_holdings"
#    When I tap on the Allocation toggle
#    And I tap on Region tab
#    Then I should on the Allocation graphical view
#
#  @S3574-AC3-AT1
#  @DependsOn('not_have_holdings_in_an_Region_at_Overview_Level')
#  Scenario: Check the Overview Allocation Region Graphic mode wrapper UI When not have holdings in an Region
#    Given I am on the Allocation graphical view
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
#  Scenario: Check the Overview allocation Region Graphic UI When not have holdings in an Region
#    Given I am on the Allocation graphical view
#    When I tap on the Allocation toggle
#    And I tap on Region tab
#    Then I should view a graphic
#    And The region is NOT represented on the graphic donut chart
#    And I can NOT see the region in a key below the tab
##  @S3574-AC3-AT2
##  Reason: don't know which region not have holdings
#
#  @S3574-AC3-AT3
#  @DependsOn('not_have_holdings_in_an_Region_at_Overview_Level')
#  Scenario: Check the ISO 3 code format of "Total assets" value and the 2dp format of Overview base region at the Overview allocation region wrapper When not have holdings in an Region
#    Given I am on the Allocation graphical view
#    Then I should see the allocation total assets are displayed in ISO 3 code and 2 d.p. format

  @NotAutomatable
  Scenario: Check the Check the status of Asset Allocation toggle and Region tab at the Overview allocation region wrapper When not have holdings in an Region
    Given I am on the Allocation graphical view
    When I tap on the Allocation toggle
    And I tap on Region tab
    Then the Asset Allocation toggle is ACTIVE
    And The region tab becomes the ACTIVE state
  #S3574-AC3-AT4
  #Reason: Cannot check the toggle state

  @S3574-AC4-AT1
  Scenario: Check Exit Overview Allocation Region Graphic mode and whether the Overview wrapper can keep previous maximised status
  #Background：the overview wrapper is maximised
    Given I login as type "overview_region_has_positive"
    And I tap on the Allocation toggle
    And I tap on Region tab
    When I tap on the Allocation toggle
#    Then The toggle becomes the INACTIVE state
    Then I am returned back to the Overview page
    And the Overview wrapper is maximised
  #Remark: Cannot check the toggle state

  @S3574-AC4-AT2
  Scenario: Check Exit Overview Allocation Region Graphic mode and whether the Overview wrapper can keep previous minifiles status
  #Background：the overview wrapper is minifiled
    Given I login as type "overview_region_has_positive"
    And the Overview wrapper is minifiles
    And I tap on the Allocation toggle
    And I tap on Region tab
    When I tap on the Allocation toggle
#    Then The toggle becomes the INACTIVE state
    Then I am returned back to the Overview page
    And the Overview wrapper should be minifiles
  #Remark: Cannot check the toggle state

  @SIT
  @Sprint18
  Scenario: only holds negative holdings in their Regions at Overview Level
    Given I login as type "overview_region_only_negative"
    When I tap on the Allocation toggle
    And I tap on Region tab
    Then I should on the Allocation graphical view

  @S3574-AC5-AT1
  @DependsOn('only_holds_negative_holdings_in_their_Regions_at_Overview_Level')
  Scenario: Check the Overview Allocation Region Graphic mode wrapper UI When only holds negative holdings in their Regions
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
  @S3574-AC5-AT2
  @DependsOn('only_holds_negative_holdings_in_their_Regions_at_Overview_Level')
  Scenario: Check the Overview allocation Region Graphic UI When only holds negative holdings in their Region
    Given I am on the Allocation graphical view
    Then I should view a graphic following:
      | element name          | element value                                                                      |
      | Graphic               |                                                                                    |
      | Total assets label    | Total assets                                                                       |
      | Total assets value    |                                                                                    |
      | Total assets currency |                                                                                    |
      | graphic includes copy | Negative values not shown                                                          |
      | state copy            | All investment holdings across account(s) are negative. Swipe up for more details. |

  @S3574-AC5-AT3
  @SIT
  @DependsOn('only_holds_negative_holdings_in_their_Regions_at_Overview_Level')
  Scenario: Check the ISO 3 code format of "Total assets" value and the 2dp format of Overview base region at the Overview allocation region wrapper When only holds negative holdings in their Regions at Overview Level
    Given I am on the Allocation graphical view
    Then I should see the allocation total assets are displayed in ISO 3 code and 2 d.p. format

  @NotAutomatable
  Scenario: Check the Check the status of Asset Allocation toggle and Region tab at the Overview allocation region wrapper When not have holdings in an Region
    Given I am on the Allocation graphical view
    When I tap on the Allocation toggle
    Then  the Asset Allocation toggle is ACTIVE
    And I tap on Region tab
    And The asset class tab becomes the ACTIVE state
      #S3574-AC5-AT4
      #Reason: Cannot check the toggle state

  @Sprint17
  @SIT
  @Sprint18
  Scenario: net holdings are negative in their Regions at Overview Level
    Given I login as type "overview_region_positive_and_negative_net_negative"
    When I tap on the Allocation toggle
    And I tap on Region tab
    Then I should on the Allocation graphical view

  @Sprint17
  @S3574-AC6-AT1
  @DependsOn('net_holdings_are_negative_in_their_Regions_at_Overview_Level')
  Scenario: Check the Overview Allocation Region Graphic mode wrapper UI When net holdings are negative in their Regions at Overview Level
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
  @S3574-AC6-AT2
  @DependsOn('net_holdings_are_negative_in_their_Regions_at_Overview_Level')
  Scenario: Check the Overview allocation Region Graphic UI When net holdings are negative in their Regions at Overview Level
    Given I am on the Allocation graphical view
    Then I should view a graphic following:
      | element name          | element value                |
      | Graphic               |                              |
      | Total assets label    | Total assets                 |
      | Total assets value    |                              |
      | Total assets currency |                              |
      | graphic includes copy | Positive exposures displayed |
#      | state copy            | Net investment holdings across account(s) are negative. Swipe up for more details. |

  @S3574-AC6-AT3
  @SIT
  @Sprint17
  @DependsOn('net_holdings_are_negative_in_their_Regions_at_Overview_Level')
  Scenario: Check the ISO 3 code format of "Total assets" value and the 2dp format of Overview base region at the Overview allocation region wrapper When net holdings are negative in their Regions at Overview Level
    Given I am on the Allocation graphical view
    Then I should see the allocation total assets are displayed in ISO 3 code and 2 d.p. format

  @NotAutomatable
  Scenario: Check the Check the status of Asset Allocation toggle and Region tab at the Overview allocation region wrapper When net holdings are negative in their Regions at Overview Level
    Given I am on the Allocation graphical view
    When I tap on the Allocation toggle
    And I tap on Region tab
    Then  the Asset Allocation toggle is ACTIVE
    And The region tab becomes the ACTIVE state
      #S3574-AC6-AT4
      #Reason: Cannot check the toggle state

  @SIT
  @Sprint18
  Scenario: does not have any holdings in any Region at Overview Level
    Given I login as type "overview_region_all_no_holdings"
    When I tap on the Allocation toggle
    And  I tap on Region tab
    Then I should on the Allocation graphical view

  @S3574-AC7-AT1
  @DependsOn('does_not_have_any_holdings_in_any_Region_at_Overview_Level')
  Scenario: Check the Overview Allocation Region Graphic mode wrapper UI Client does not have any holdings in any Region - Edge
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
  @S3574-AC7-AT2
  @DependsOn('does_not_have_any_holdings_in_any_Region_at_Overview_Level')
  Scenario: Check the Overview allocation Region Graphic UI When does not have any holdings in any Region at Overview Level
    Given I am on the Allocation graphical view
    Then I should view a graphic following:
      | element name          | element value                                                              |
      | Graphic               |                                                                            |
      | Total assets label    | Total assets                                                               |
      | Total assets value    | 0.00                                                                       |
      | Total assets currency |                                                                            |
      | state copy            | Exposure by region unavailable as you have no holdings in your account(s). |

  @S3574-AC7-AT3
  @SIT
  @DependsOn('does_not_have_any_holdings_in_any_Region_at_Overview_Level')
  Scenario: Check the ISO 3 code format of "Total assets" value and the  2dp format of Overview base region at the Overview allocation region wrapper When does not have any holdings in any Region at Overview Level
    Given I am on the Allocation graphical view
#    When I tap on the Allocation toggle
#    And I tap on Region tab
    Then I should see the allocation total assets is displayed in 2 d.p. format
    And the allocation total assets base currency value is displayed ISO 3 code

  @NotAutomatable
  Scenario: Check the status of Asset Allocation toggle and Region tab at the Overview allocation region wrapper When not have holdings in an Region
    Given I am on the Allocation graphical view
    When I tap on the Allocation toggle
    Then  the Asset Allocation toggle is ACTIVE
    And I tap on Region tab
    And The region tab becomes the ACTIVE state
      #S3574-AC7-AT4
      #Reason: Cannot check the toggle state

  @S3574-AC7-AT4
  @SIT
  Scenario: Check whether the total asset value at the overview Asset Allocation Region Graphic mode equals the Total asset value at overview wrapper
    Given I login as type "overview_region_only_positive"
    When I tap on the Allocation toggle and remember "Overview" Total asset value
    And I tap on Region tab
    Then I should see total asset value at the Asset Allocation Graphic mode equals the Total asset value at wrapper