@Epic_GPBM-1094(Holdings)
@Story_GPBM-3011 @Sprint6_iOS
@Story_GPBM-3010 @Sprint6_aOS

Feature: Holdings details - Metal ounces - Portfolio level - Asset Allocation view

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio class Metal ounces
    Given I login as type "portfolio_allocation_class_holding_detail_metal_ounces"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S392-AC1-AT1
  @DependsOn('login_in_as_userN_for_portfolio_class_Metal_ounces')
  Scenario:Check the Portfolio Asset Class Holding detail page UI for Metal ounces
    Given I am on the allocation holding details
#  - Metal Ounces - 59
    Then I am taken to a detailed allocation Metal ounces holdings screen displaying the following data:
      | element name                                 | element value                                                                                                                                                                                                                       |
      | Holding name value                           |                                                                                                                                                                                                                                     |
      | Reference value                              |                                                                                                                                                                                                                                     |
      | "Quantity" label                             | Quantity                                                                                                                                                                                                                            |
      | Quantity value                               |                                                                                                                                                                                                                                     |
      | "Total value" label                         | Total value                                                                                                                                                                                                                        |
      | Market value in PORTFOLIO reference currency |                                                                                                                                                                                                                                     |
      | "Disclaimer" label                           | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S392-AC1-AT2
  @DependsOn('login_in_as_userN_for_portfolio_class_Metal_ounces')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Asset Class Holding detail page for Metal ounces
    Given I am on the allocation holding details
    Then I should see the allocation Metal ounces following datas format:ISO 3

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio subasset Metal ounces
    Given I login as type "portfolio_allocation_subasset_holding_detail_metal_ounces"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S392-AC2-AT1
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Metal_ounces')
  Scenario:Check the Portfolio Sub-Asset Class Holding detail page UI for Metal ounces
    Given I am on the allocation holding details
#  - Metal Ounces - 59
    Then I am taken to a detailed allocation Metal ounces holdings screen displaying the following data:
      | element name                                 | element value                                                                                                                                                                                                                       |
      | Holding name value                           |                                                                                                                                                                                                                                     |
      | Reference value                              |                                                                                                                                                                                                                                     |
      | "Quantity" label                             | Quantity                                                                                                                                                                                                                            |
      | Quantity value                               |                                                                                                                                                                                                                                     |
      | "Total value" label                         | Total value                                                                                                                                                                                                                        |
      | Market value in PORTFOLIO reference currency |                                                                                                                                                                                                                                     |
      | "Disclaimer" label                           | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S392-AC2-AT2
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Metal_ounces')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Sub-Asset Class Holding detail page for Metal ounces
    Given I am on the allocation holding details
    Then I should see the allocation Metal ounces following datas format:ISO 3

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio currency Metal ounces
    Given I login as type "portfolio_allocation_currency_holding_detail_metal_ounces"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S392-AC3-AT1
  @DependsOn('login_in_as_userN_for_portfolio_currency_Metal_ounces')
  Scenario:Check the Portfolio Currency Holding detail page UI for Metal ounces
    Given I am on the allocation holding details
#  - Metal Ounces - 59
    Then I am taken to a detailed allocation Metal ounces holdings screen displaying the following data:
      | element name                                 | element value                                                                                                                                                                                                                       |
      | Holding name value                           |                                                                                                                                                                                                                                     |
      | Reference value                              |                                                                                                                                                                                                                                     |
      | "Quantity" label                             | Quantity                                                                                                                                                                                                                            |
      | Quantity value                               |                                                                                                                                                                                                                                     |
      | "Total value" label                         | Total value                                                                                                                                                                                                                        |
      | Market value in PORTFOLIO reference currency |                                                                                                                                                                                                                                     |
      | "Disclaimer" label                           | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S392-AC3-AT2
  @DependsOn('login_in_as_userN_for_portfolio_currency_Metal_ounces')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Currency Holding detail page for Metal ounces
    Given I am on the allocation holding details
    Then I should see the allocation Metal ounces following datas format:ISO 3

  @UK
  @SIT
  Scenario: login in as userN for portfolio region Metal ounces
    Given I login as type "portfolio_allocation_region_holding_detail_metal_ounces"
    Then I should on the allocation holding details

  @UK
  @S392-AC4-AT1
  @DependsOn('login_in_as_userN_for_portfolio_region_Metal_ounces')
  Scenario:Check the Portfolio Region Holding detail page UI for Metal ounces
    Given I am on the allocation holding details
#  - Metal Ounces - 59
    Then I am taken to a detailed allocation Metal ounces holdings screen displaying the following data:
      | element name                                 | element value                                                                                                                                                                                                                       |
      | Holding name value                           |                                                                                                                                                                                                                                     |
      | Reference value                              |                                                                                                                                                                                                                                     |
      | "Quantity" label                             | Quantity                                                                                                                                                                                                                            |
      | Quantity value                               |                                                                                                                                                                                                                                     |
      | "Total value" label                         | Total value                                                                                                                                                                                                                        |
      | Market value in PORTFOLIO reference currency |                                                                                                                                                                                                                                     |
      | "Disclaimer" label                           | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @UK
  @S392-AC4-AT2
  @DependsOn('login_in_as_userN_for_portfolio_region_Metal_ounces')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Region Holding detail page for Metal ounces
    Given I am on the allocation holding details
    Then I should see the allocation Metal ounces following datas format:ISO 3