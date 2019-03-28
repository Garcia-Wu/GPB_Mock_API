@UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-3576 @Sprint15_iOS
@Story_GPBM-3620 @Sprint15_aOS

Feature: Region graphical view at Portfolio Level

  As a Client I want to be able to graphically view my exposure to different regions within a portfolio, regarding my positive asset holdings
  So that I can instantly gain an understanding of the key information regarding my region exposure

  @SIT
  Scenario: only owns positive total holding values for their Allocation Region at Portfolio Level
    Given I login as type "portfolio_region_only_positive"
    When I tap on the Allocation toggle
    And I tap on Region tab
    Then I should on the Allocation graphical view

#  Scenario 1: Client only owns positive total holding values for their Regions
  @S3576-AC1-AT1
  @DependsOn('only_owns_positive_total_holding_values_for_their_Allocation_Region_at_Portfolio_Level')
  Scenario: Check the Portfolio Allocation Region Graphic mode wrapper UI When only owns positive total holding values for their Regions
    Given I am on the Allocation graphical view
    Then I should see the wrapper above the graphic contains the following:
      | element region | element name            | element value    |
      |                | Asset allocation label  | Asset allocation |
      |                | Name label              |                  |
      |                | Region Or ID            |                  |
      |                | Portfolio Back button   |                  |
      |                | Asset Class             | Asset class      |
      |                | Currency                | Currency         |
      | UK             | Region                  | Region           |
      |                | More menu icon          |                  |
      |                | Asset Allocation toggle |                  |

  @S3576-AC1-AT2
  @DependsOn('only_owns_positive_total_holding_values_for_their_Allocation_Region_at_Portfolio_Level')
  Scenario: Check the Portfolio allocation Region Graphic UI When only owns positive total holding values for their Regions
    Given I am on the Allocation graphical view
    Then I should view a graphic following:
      | element name       | element value    |
      | Graphic            |                  |
      | Total assets label | Portfolio assets |
      | Total assets value |                  |
      | key                |                  |

  @S3576-AC1-AT3
  @SIT
  @DependsOn('only_owns_positive_total_holding_values_for_their_Allocation_Region_at_Portfolio_Level')
  Scenario: Check the ISO 3 code format of "Portfolio assets" value and the  2dp format of Portfolio base region at the Portfolio allocation region wrapper When only owns positive total holding values for their Regions
    Given I am on the Allocation graphical view
    Then I should see the allocation total assets are displayed in ISO 3 code and 2 d.p. format

  #  remark：can not test the allocation toggle/region tab status
  @NotAutomatable
#  @S3576-AC1-AT4
  Scenario: Check the Check the status of Asset Allocation toggle and Region tab at the Portfolio allocation region wrapper When only owns positive total holding values for their Regions
    Then the Asset Allocation toggle is ACTIVE
    And The region tab becomes the ACTIVE state

#  Scenario 2: Client owns both positive and negative total holding values in different Regions
  @SIT
  @Sprint18
  Scenario: owns both positive and negative total holding values in different Allocation Region at Portfolio Level
    Given I login as type "portfolio_region_positive_and_negative_net_positive"
    When I tap on the Allocation toggle
    And I tap on Region tab
    Then I should on the Allocation graphical view

  @S3576-AC2-AT1
  @DependsOn('owns_both_positive_and_negative_total_holding_values_in_different_Allocation_Region_at_Portfolio_Level')
  Scenario: Check the Portfolio Allocation Region Graphic mode wrapper UI When owns both positive and negative total holding values in different Regions
    Given I am on the Allocation graphical view
    Then I should see the wrapper above the graphic contains the following:
      | element region | element name            | element value    |
      |                | Asset allocation label  | Asset allocation |
      |                | Name label              |                  |
      |                | Region Or ID            |                  |
      |                | Portfolio Back button   |                  |
      |                | Asset Class             | Asset class      |
      |                | Currency                | Currency         |
      | UK             | Region                  | Region           |
      |                | More menu icon          |                  |
      |                | Asset Allocation toggle |                  |

  @Sprint18
  @S3576-AC2-AT2
  @DependsOn('owns_both_positive_and_negative_total_holding_values_in_different_Allocation_Region_at_Portfolio_Level')
  Scenario: Check the Portfolio allocation Region Graphic UI When owns both positive and negative total holding values in different Regions
    Given I am on the Allocation graphical view
    Then I should view a graphic following:
      | element name          | element value                |
      | Graphic               |                              |
      | Total assets label    | Portfolio assets             |
      | Total assets value    |                              |
      | graphic includes copy | Positive exposures displayed |
      | key                   |                              |

  @S3576-AC2-AT3
  @SIT
  @DependsOn('owns_both_positive_and_negative_total_holding_values_in_different_Allocation_Region_at_Portfolio_Level')
  Scenario: Check the ISO 3 code format of "Portfolio assets" value and the  2dp format of Portfolio base region at the Portfolio allocation region wrapper When owns both positive and negative total holding values in different Regions
    Given I am on the Allocation graphical view
    Then I should see the allocation total assets are displayed in ISO 3 code and 2 d.p. format

  #  remark：can not test the allocation toggle/region tab status
  @NotAutomatable
  @S3576-AC2-AT4
  Scenario: Check the Check the status of Asset Allocation toggle and Region tab at the Portfolio allocation region wrapper When owns both positive and negative total holding values in different Regions
    Then  the Asset Allocation toggle is ACTIVE
    And The region tab becomes the ACTIVE state by default

#  Scenario 3: Client does not have holdings in a Region
#  Scenario: not have holdings in an Region at Portfolio Level
#    Given I login as type "portfolio_one_region_not_have_holdings"
#    When I tap on the Allocation toggle
#    And I tap on Region tab
#    Then I should on the Allocation graphical view
#
#  @S3576-AC3-AT1
#  @DependsOn('not_have_holdings_in_an_Region_at_Portfolio_Level')
#  Scenario: Check the Portfolio Allocation Region Graphic mode wrapper UI When not have holdings in an Region
#    Given I am on the allocation holding list
#    Then I should see the wrapper above the graphic contains the following:
#      | element region | element name            | element value    |
#      |                | Asset allocation label  | Asset allocation |
#      |                | Name label            |                  |
#      |                | Region Or ID            |                  |
#      |                | Asset Class             | Asset class           |
#      |                | Currency                | Currency         |
#      | UK             | Region                  | Region           |
#      |                | More menu icon          |                  |
#      |                | Asset Allocation toggle |                  |
#
#  #  Reason: don't know which asset class not have holdings
#  @NotAutomatable
#  @S3576-AC3-AT2
#  Scenario: Check the Portfolio allocation Region Graphic UI When not have holdings in an Region
#    Then I should view a graphic
#    And The region which does not have holdings is NOT represented on the graphic donut chart
#    And I can NOT see the region which does not have holdings in a key below the tab
#
#  @S3576-AC3-AT3
#  @DependsOn('not_have_holdings_in_an_Region_at_Portfolio_Level')
#  Scenario: Check the ISO 3 code format of "Portfolio assets" value and the  2dp format of Portfolio base region at the Portfolio allocation region wrapper When not have holdings in an Region
#    Given I am on the allocation holding list
#    Then I should see the allocation total assets are displayed in ISO 3 code and 2 d.p. format
#
#  #  remark：can not test the allocation toggle/region tab status
#  @NotAutomatable
#  @S3576-AC3-AT4
#  Scenario: Check the Check the status of Asset Allocation toggle and Region tab at the Portfolio allocation region wrapper When not have holdings in an Region
#    Then  the Asset Allocation toggle is ACTIVE
#    And The region tab becomes the ACTIVE state

#  Scenario 4: Exit Asset Allocation Graphic mode via toggle
  @S3576-AC4-AT1
  Scenario: Check Exit Portfolio Allocation Region Graphic mode and whether the Portfolio wrapper can keep previous maximised status
    Given I login as type "more_portfolio"
    And I tap first item of Portfolios list
    And I tap on the Allocation toggle
    And I tap on Region tab
    When I tap on the Allocation toggle
    Then I am returned back to the Portfolio page
    And the Portfolio wrapper should be maximised

  @S3576-AC4-AT2
  Scenario: Check Exit Portfolio Allocation Region Graphic mode and whether the Portfolio wrapper can keep previous minifiles status
    Given I login as type "more_portfolio"
    And I tap first item of Portfolios list
    And the Portfolio wrapper is minimised
    And I tap on the Allocation toggle
    And I tap on Region tab
    When I tap on the Allocation toggle
    Then I am returned back to the Portfolio page
    And the Portfolio wrapper is minimised


#  Scenario 5: Exit Asset Allocation Graphic mode via breadcrumb
  @S3576-AC5-AT1
  Scenario: Check Exit Portfolio Allocation Region Graphic mode via breadcrumb and whether the Account wrapper can keep previous maximised status
#  Background：the Account wrapper is maximised
    Given I login as type "more_portfolio"
    And I tap first item of Portfolios list
    And I tap on the Allocation toggle
    And I tap on Region tab
    When I tap on the portfolio breadcrumb (back button)
#    Then The toggle becomes the INACTIVE state
    Then I am returned back to the Account page
    And the Account wrapper should be maximised

  @S3576-AC5-AT2
  Scenario: Check Exit Portfolio Allocation Region Graphic mode via breadcrumb and whether the Account wrapper can keep previous minifiles status
#  Background：the Account wrapper is minifiled
    Given I login as type "more_portfolio"
    And the Account wrapper is minifiles
    And I tap first item of Portfolios list
    And I tap on the Allocation toggle
    And I tap on Region tab
    When I tap on the portfolio breadcrumb (back button)
#    Then The toggle becomes the INACTIVE state
    Then I am returned back to the Account page
    And the Account wrapper should be minifiles

  @SIT
  @Sprint18
  Scenario: only holds negative holdings in their Regions at Portfolio Level
    Given I login as type "portfolio_region_only_negative"
    When I tap on the Allocation toggle
    And I tap on Region tab
    Then I should on the Allocation graphical view

#  Scenario 6: Client only holds negative holdings in their Regions - Edge
  @S3576-AC6-AT1
  @DependsOn('only_holds_negative_holdings_in_their_Regions_at_Portfolio_Level')
  Scenario: Check the Portfolio Allocation Region Graphic mode wrapper UI When only holds negative holdings in their Regions
    Given I am on the Allocation graphical view
    Then I should see the wrapper above the graphic contains the following:
      | element region | element name            | element value    |
      |                | Asset allocation label  | Asset allocation |
      |                | Name label              |                  |
      |                | Region Or ID            |                  |
      |                | Portfolio Back button   |                  |
      |                | Asset Class             | Asset class      |
      |                | Currency                | Currency         |
      | UK             | Region                  | Region           |
      |                | More menu icon          |                  |
      |                | Asset Allocation toggle |                  |

  @Sprint18
  @S3576-AC6-AT2
  @DependsOn('only_holds_negative_holdings_in_their_Regions_at_Portfolio_Level')
  Scenario: Check the Portfolio allocation Region Graphic UI When only holds negative holdings in their Regions
    Given I am on the Allocation graphical view
    Then I should view a graphic following:
      | element name          | element value                                                                          |
      | Graphic               |                                                                                        |
      | Total assets label    | Portfolio assets                                                                       |
      | Total assets value    |                                                                                        |
      | graphic includes copy | Negative values not shown                                                              |
      | state copy            | All investment holdings within this portfolio are negative. Swipe up for more details. |

  @S3576-AC6-AT3
  @SIT
  @DependsOn('only_holds_negative_holdings_in_their_Regions_at_Portfolio_Level')
  Scenario: Check the ISO 3 code format of "Portfolio assets" value and the  2dp format of Portfolio base region at the Portfolio allocation region wrapper When only holds negative holdings in their Regions
    Given I am on the Allocation graphical view
    Then I should see the allocation total assets are displayed in ISO 3 code and 2 d.p. format

  #  remark：can not test the allocation toggle/region tab status
  @NotAutomatable
  @S3576-AC6-AT4
  Scenario: Check the Check the status of Asset Allocation toggle and Region tab at the Portfolio allocation region wrapper When only holds negative holdings in their Regions
    Then  the Asset Allocation toggle is ACTIVE
    And I tap on Region tab
    And The region tab becomes the ACTIVE state

  @Sprint17
  @SIT
  @Sprint18
  Scenario: net holdings are negative in their Regions at Portfolio Level
    Given I login as type "portfolio_region_positive_and_negative_net_negative"
    When I tap on the Allocation toggle
    And I tap on Region tab
    Then I should on the Allocation graphical view

#  Scenario 7: Client's net holdings are negative - Edge
  @Sprint17
  @S3576-AC7-AT1
  @DependsOn('net_holdings_are_negative_in_their_Regions_at_Portfolio_Level')
  Scenario: Check the Portfolio Allocation Region Graphic mode wrapper UI When net holdings are negative
    Given I am on the Allocation graphical view
    Then I should see the wrapper above the graphic contains the following:
      | element region | element name            | element value    |
      |                | Asset allocation label  | Asset allocation |
      |                | Name label              |                  |
      |                | Region Or ID            |                  |
      |                | Portfolio Back button   |                  |
      |                | Asset Class             | Asset class      |
      |                | Currency                | Currency         |
      | UK             | Region                  | Region           |
      |                | More menu icon          |                  |
      |                | Asset Allocation toggle |                  |

  @Sprint17
  @Sprint18
  @S3576-AC7-AT2
  @DependsOn('net_holdings_are_negative_in_their_Regions_at_Portfolio_Level')
  Scenario: Check the Portfolio allocation Region Graphic UI When net holdings are negative
    Given I am on the Allocation graphical view
    Then I should view a graphic following:
      | element name          | element value                |
      | Graphic               |                              |
      | Total assets label    | Portfolio assets             |
      | Total assets value    |                              |
      | graphic includes copy | Positive exposures displayed |
#      | state copy            | Net investment holdings within this portfolio are negative. Swipe up for more details. |

  @S3576-AC7-AT3
  @SIT
  @Sprint17
  @DependsOn('net_holdings_are_negative_in_their_Regions_at_Portfolio_Level')
  Scenario: Check the ISO 3 code format of "Portfolio assets" value and the 2dp format of Portfolio base region at the Portfolio allocation region wrapper When net holdings are negative
    Given I am on the Allocation graphical view
    Then I should see the allocation total assets are displayed in ISO 3 code and 2 d.p. format

  #  remark：can not test the allocation toggle/region tab status
  @NotAutomatable
  @S3576-AC7-AT4
  Scenario: Check the Check the status of Asset Allocation toggle and Region tab at the Portfolio allocation region wrapper When net holdings are negative
    Then  the Asset Allocation toggle is ACTIVE
    And The region tab becomes the ACTIVE state

  @SIT
  @Sprint18
  Scenario: not have any holdings in any Region at Portfolio Level
    Given I login as type "portfolio_region_all_no_holdings"
    When I tap on the Allocation toggle
    And I tap on Region tab
    Then I should on the Allocation graphical view

#  Scenario 8: Client does not have any holdings in any Region - Edge
  @S3576-AC8-AT1
  @DependsOn('not_have_any_holdings_in_any_Region_at_Portfolio_Level')
  Scenario: Check the Portfolio Allocation Region Graphic mode wrapper UI Client does not have any holdings in any Region - Edge
    Given I am on the Allocation graphical view
    Then I should see the wrapper above the graphic contains the following:
      | element region | element name            | element value    |
      |                | Asset allocation label  | Asset allocation |
      |                | Name label              |                  |
      |                | Region Or ID            |                  |
      |                | Portfolio Back button   |                  |
      |                | Asset Class             | Asset class      |
      |                | Currency                | Currency         |
      | UK             | Region                  | Region           |
      |                | More menu icon          |                  |
      |                | Asset Allocation toggle |                  |

  @Sprint18
  @S3576-AC8-AT2
  @DependsOn('not_have_any_holdings_in_any_Region_at_Portfolio_Level')
  Scenario: Check the Portfolio allocation Region Graphic UI When not have holdings in an Region
    Given I am on the Allocation graphical view
    Then I should view a graphic following:
      | element name       | element value                                                              |
      | Graphic            |                                                                            |
      | Total assets label | Portfolio assets                                                           |
      | Total assets value | 0.00                                                                       |
      | state copy         | Exposure by region unavailable as there are no holdings in your portfolio. |

  @S3576-AC8-AT3
  @SIT
  @DependsOn('not_have_any_holdings_in_any_Region_at_Portfolio_Level')
  Scenario: Check the ISO 3 code format of "Portfolio assets" value and the  2dp format of Portfolio base region at the Portfolio allocation region wrapper When not have holdings in an Region
    Given I am on the Allocation graphical view
    Then I should see the allocation total assets is displayed in 2 d.p. format
    And the allocation total assets base currency value is displayed ISO 3 code

  #  remark：can not test the allocation toggle/region tab status
  @NotAutomatable
  @S3576-AC8-AT4
  Scenario: Check the status of Asset Allocation toggle and Region tab at the Portfolio allocation region wrapper When not have holdings in an Region
    Given I am at Portfolio level
    When I tap on the Allocation toggle
    Then  the Asset Allocation toggle is ACTIVE
    And I tap on Region tab
    And The Currency tab becomes the ACTIVE state

  @S3576-AC8-AT5
  @SIT
  Scenario: Check whether the Total asset value at the Portfolio Asset Allocation Region Graphic mode equals the Total asset value at Portfolio wrapper
    Given I login as type "portfolio_region_only_positive"
    When I tap on the Allocation toggle and remember "Portfolio" Total asset value
    And I tap on Region tab
    Then I should see total asset value at the Asset Allocation Graphic mode equals the Total asset value at wrapper