@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-3650 @Sprint17_iOS
@Story_GPBM-3675 @Sprint17_aOS
@Sprint18

Feature: Treatment when positive and negative holdings sum to 0

  As a bank We do not want to show any asset class, currency or region in the asset allocation graphical view that has net holdings summing to 0
  So that users are not confused by the graphic

#  Scenario 2 - Graphical view - All Asset classes/Regions/Currencies net to 0
#  Background:
#  I have both positive and negative total holdings for ALL my Asset Classes/Currencies/Regions
#   the positive and negative holdings for each of my Asset Classes/Currencies/Regions sum to 0
  @HK @SG @UK
  @S3650-AC1-AT1
  Scenario: Check All Asset classes net to 0 at overview level
    Given I login as type "overview_all_asset_class_net_zero"
    When I tap on the Allocation toggle and remember "Overview" base currency
    Then the base currency same as overview wrapper base currency,and key would usually be displayed,there is copy:
      | element name      | element value                                                                            |
      | state copy prefix | All investment holdings in exposed asset classes across account(s) have a net value of 0 |
      | state copy suffix | . Swipe up for more details.                                                             |

  @HK @SG @UK
  @S3650-AC1-AT2
  Scenario: Check All Currency net to 0 at overview level
    Given I login as type "overview_all_currency_net_zero"
    When I tap on the Allocation toggle and remember "Overview" base currency
    And I tap on Currency tab
    Then the base currency same as overview wrapper base currency,and key would usually be displayed,there is copy:
      | element name      | element value                                                                         |
      | state copy prefix | All investment holdings in exposed currencies across account(s) have a net value of 0 |
      | state copy suffix | . Swipe up for more details.                                                          |

  @UK
  @S3650-AC1-AT3
  Scenario: Check All Region net to 0 at overview level
    Given I login as type "overview_all_region_net_zero"
    When I tap on the Allocation toggle and remember "Overview" base currency
    And I tap on Region tab
    Then the base currency same as overview wrapper base currency,and key would usually be displayed,there is copy:
      | element name      | element value                                                                      |
      | state copy prefix | All investment holdings in exposed regions across account(s) have a net value of 0 |
      | state copy suffix | . Swipe up for more details.                                                       |

  @HK @SG @UK
  @S3650-AC2-AT1
  Scenario: Check All Asset classes net to 0 at account level
    Given I login as type "account_all_asset_class_net_zero"
    When I tap on the Allocation toggle and remember "Account" base currency
    Then the base currency same as overview wrapper base currency,and key would usually be displayed,there is copy:
      | element name      | element value                                                                              |
      | state copy prefix | All investment holdings in exposed asset classes within this account have a net value of 0 |
      | state copy suffix | . Swipe up for more details.                                                               |

  @HK @SG @UK
  @S3650-AC2-AT2
  Scenario: Check All Currency net to 0 at account level
    Given I login as type "account_all_currency_net_zero"
    When I tap on the Allocation toggle and remember "Account" base currency
    And I tap on Currency tab
    Then the base currency same as overview wrapper base currency,and key would usually be displayed,there is copy:
      | element name      | element value                                                                           |
      | state copy prefix | All investment holdings in exposed currencies within this account have a net value of 0 |
      | state copy suffix | . Swipe up for more details.                                                            |

  @UK
  @S3650-AC2-AT3
  Scenario: Check All Region net to 0 at account level
    Given I login as type "account_all_region_net_zero"
    When I tap on the Allocation toggle and remember "Account" base currency
    And I tap on Region tab
    Then the base currency same as overview wrapper base currency,and key would usually be displayed,there is copy:
      | element name      | element value                                                                        |
      | state copy prefix | All investment holdings in exposed regions within this account have a net value of 0 |
      | state copy suffix | . Swipe up for more details.                                                         |

  @HK @SG @UK
  @S3650-AC3-AT1
  Scenario: Check All Asset classes net to 0 at portfolio level
    Given I login as type "portfolio_all_asset_class_net_zero"
    When I tap on the Allocation toggle and remember "Portfolio" base currency
    Then the base currency same as overview wrapper base currency,and key would usually be displayed,there is copy:
      | element name      | element value                                                                                |
      | state copy prefix | All investment holdings in exposed asset classes within this portfolio have a net value of 0 |
      | state copy suffix | . Swipe up for more details.                                                                 |

  @HK @SG @UK
  @S3650-AC3-AT2
  Scenario: Check All Currency net to 0 at portfolio level
    Given I login as type "portfolio_all_currency_net_zero"
    When I tap on the Allocation toggle and remember "Portfolio" base currency
    And I tap on Currency tab
    Then the base currency same as overview wrapper base currency,and key would usually be displayed,there is copy:
      | element name      | element value                                                                             |
      | state copy prefix | All investment holdings in exposed currencies within this portfolio have a net value of 0 |
      | state copy suffix | . Swipe up for more details.                                                              |

  @UK
  @S3650-AC3-AT3
  Scenario: Check All Region net to 0 at portfolio level
    Given I login as type "portfolio_all_region_net_zero"
    When I tap on the Allocation toggle and remember "Portfolio" base currency
    And I tap on Region tab
    Then the base currency same as overview wrapper base currency,and key would usually be displayed,there is copy:
      | element name      | element value                                                                          |
      | state copy prefix | All investment holdings in exposed regions within this portfolio have a net value of 0 |
      | state copy suffix | . Swipe up for more details.                                                           |
