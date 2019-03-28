@Epic_GPBM-1094(Holdings)
@Story_GPBM-2120 @Sprint6_iOS
@Story_GPBM-2121 @Sprint6_aOS

Feature: Holdings details  - Precious metals - Overview level - Asset Allocation view

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for overview class Precious metals
    Given I login as type "overview_allocation_class_holding_detail_precious_metals"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S324-AC1-AT1
  @DependsOn('login_in_as_userN_for_overview_class_Precious_metals')
  Scenario:Check the Overview Asset Class Holding detail page UI for Precious metals
    Given I am on the allocation holding details
#  Precious Metal - 32
    Then I am taken to a detailed allocation Precious metals holdings screen displaying the following data:
      | element name                                           | element value                                                                                                                                                                                                                       |
      | Holding name value                                     |                                                                                                                                                                                                                                     |
      | ISIN value                                             |                                                                                                                                                                                                                                     |
      | “Quantity” label                                       | Quantity                                                                                                                                                                                                                            |
      | “Quantity” value                                       |                                                                                                                                                                                                                                     |
      | "Unrealised P/L" label                                 | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised Profit/Loss value in holding currency as a% |                                                                                                                                                                                                                                     |
      | “Total value” label                                    | Total value                                                                                                                                                                                                                         |
      | Market value in holding currency                       |                                                                                                                                                                                                                                     |
      | Market value in OVERVIEW reference currency            |                                                                                                                                                                                                                                     |
      | "Average purchase price" label                         | Average purchase price                                                                                                                                                                                                              |
      | Average purchase price value in holding currency       |                                                                                                                                                                                                                                     |
      | “Last purchase date” label                             | Last purchase date                                                                                                                                                                                                                  |
      | Last purchase date value                               |                                                                                                                                                                                                                                     |
      | "Market price" label                                   | Market price                                                                                                                                                                                                                        |
      | Market price value in holding currency                 |                                                                                                                                                                                                                                     |
      | "Market price date" label                              | Market price date                                                                                                                                                                                                                   |
      | Market price date value                                |                                                                                                                                                                                                                                     |
      | Disclaimer                                             | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S324-AC1-AT2
  @DependsOn('login_in_as_userN_for_overview_class_Precious_metals')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Asset Class Holding detail page for Precious metals
    Given I am on the allocation holding details
    Then I should see the allocation Precious metals following datas format ISO3

  @HK @SG @UK
  @S324-AC1-AT3
  @DependsOn('login_in_as_userN_for_overview_class_Precious_metals')
  Scenario:Check the dd Mmm yyyy format of Last Purchase Date value/Market Price Date value in Overview Asset Class Holding detail page for Precious metals
    Given I am on the allocation holding details
    Then I should see the allocation Precious metals following datas:Last Purchase Date value (format: dd Mmm yyyy)、Market Price Date value (format: dd Mmm yyyy)

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for overview subasset Precious metals
    Given I login as type "overview_allocation_subasset_holding_detail_precious_metals"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S324-AC2-AT1
  @DependsOn('login_in_as_userN_for_overview_subasset_Precious_metals')
  Scenario:Check the Overview Sub-Asset Class Holding detail page UI for Precious metals
    Given I am on the allocation holding details
#  Precious Metal - 32
    Then I am taken to a detailed allocation Precious metals holdings screen displaying the following data:
      | element name                                           | element value                                                                                                                                                                                                                       |
      | Holding name value                                     |                                                                                                                                                                                                                                     |
      | ISIN value                                             |                                                                                                                                                                                                                                     |
      | “Quantity” label                                       | Quantity                                                                                                                                                                                                                            |
      | “Quantity” value                                       |                                                                                                                                                                                                                                     |
      | "Unrealised P/L" label                                 | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised Profit/Loss value in holding currency as a% |                                                                                                                                                                                                                                     |
      | “Total value” label                                    | Total value                                                                                                                                                                                                                         |
      | Market value in holding currency                       |                                                                                                                                                                                                                                     |
      | Market value in OVERVIEW reference currency            |                                                                                                                                                                                                                                     |
      | "Average purchase price" label                         | Average purchase price                                                                                                                                                                                                              |
      | Average purchase price value in holding currency       |                                                                                                                                                                                                                                     |
      | “Last purchase date” label                             | Last purchase date                                                                                                                                                                                                                  |
      | Last purchase date value                               |                                                                                                                                                                                                                                     |
      | "Market price" label                                   | Market price                                                                                                                                                                                                                        |
      | Market price value in holding currency                 |                                                                                                                                                                                                                                     |
      | "Market price date" label                              | Market price date                                                                                                                                                                                                                   |
      | Market price date value                                |                                                                                                                                                                                                                                     |
      | Disclaimer                                             | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S324-AC2-AT2
  @DependsOn('login_in_as_userN_for_overview_subasset_Precious_metals')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Sub-Asset Class Holding detail page for Precious metals
    Given I am on the allocation holding details
    Then I should see the allocation Precious metals following datas format ISO3

  @HK @SG @UK
  @S324-AC2-AT3
  @DependsOn('login_in_as_userN_for_overview_subasset_Precious_metals')
  Scenario:Check the dd Mmm yyyy format of Last Purchase Date value/Market Price Date value in Overview Sub-Asset Class Holding detail page for Precious metals
    Given I am on the allocation holding details
    Then I should see the allocation Precious metals following datas:Last Purchase Date value (format: dd Mmm yyyy)、Market Price Date value (format: dd Mmm yyyy)

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for overview currency Precious metals
    Given I login as type "overview_allocation_currency_holding_detail_precious_metals"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S324-AC3-AT1
  @DependsOn('login_in_as_userN_for_overview_currency_Precious_metals')
  Scenario:Check the Overview Currency Holding detail page UI for Precious metals
    Given I am on the allocation holding details
#  Precious Metal - 32
    Then I am taken to a detailed allocation Precious metals holdings screen displaying the following data:
      | element name                                           | element value                                                                                                                                                                                                                       |
      | Holding name value                                     |                                                                                                                                                                                                                                     |
      | ISIN value                                             |                                                                                                                                                                                                                                     |
      | “Quantity” label                                       | Quantity                                                                                                                                                                                                                            |
      | “Quantity” value                                       |                                                                                                                                                                                                                                     |
      | "Unrealised P/L" label                                 | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised Profit/Loss value in holding currency as a% |                                                                                                                                                                                                                                     |
      | “Total value” label                                    | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency                       |                                                                                                                                                                                                                                     |
      | Market value in OVERVIEW reference currency            |                                                                                                                                                                                                                                     |
      | "Average purchase price" label                         | Average purchase price                                                                                                                                                                                                              |
      | Average purchase price value in holding currency       |                                                                                                                                                                                                                                     |
      | “Last purchase date” label                             | Last purchase date                                                                                                                                                                                                                  |
      | Last purchase date value                               |                                                                                                                                                                                                                                     |
      | "Market price" label                                   | Market price                                                                                                                                                                                                                        |
      | Market price value in holding currency                 |                                                                                                                                                                                                                                     |
      | "Market price date" label                              | Market price date                                                                                                                                                                                                                   |
      | Market price date value                                |                                                                                                                                                                                                                                     |
      | Disclaimer                                             | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S324-AC3-AT2
  @DependsOn('login_in_as_userN_for_overview_currency_Precious_metals')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Currency Holding detail page for Precious metals
    Given I am on the allocation holding details
    Then I should see the allocation Precious metals following datas format ISO3

  @HK @SG @UK
  @S324-AC3-AT3
  @DependsOn('login_in_as_userN_for_overview_currency_Precious_metals')
  Scenario:Check the dd Mmm yyyy format of Last Purchase Date value/Market Price Date value in Overview Currency Holding detail page for Precious metals
    Given I am on the allocation holding details
    Then I should see the allocation Precious metals following datas:Last Purchase Date value (format: dd Mmm yyyy)、Market Price Date value (format: dd Mmm yyyy)

  @UK
  @SIT
  Scenario: login in as userN for overview region Precious metals
    Given I login as type "overview_allocation_region_holding_detail_precious_metals"
    Then I should on the allocation holding details

  @UK
  @S324-AC4-AT1
  @DependsOn('login_in_as_userN_for_overview_region_Precious_metals')
  Scenario:Check the Overview Region Holding detail page UI for Precious metals
    Given I am on the allocation holding details
#  Precious Metal - 32
    Then I am taken to a detailed allocation Precious metals holdings screen displaying the following data:
      | element name                                           | element value                                                                                                                                                                                                                       |
      | Holding name value                                     |                                                                                                                                                                                                                                     |
      | ISIN value                                             |                                                                                                                                                                                                                                     |
      | “Quantity” label                                       | Quantity                                                                                                                                                                                                                            |
      | “Quantity” value                                       |                                                                                                                                                                                                                                     |
      | "Unrealised P/L" label                                 | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised Profit/Loss value in holding currency as a% |                                                                                                                                                                                                                                     |
      | “Total value” label                                    | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency                       |                                                                                                                                                                                                                                     |
      | Market value in OVERVIEW reference currency            |                                                                                                                                                                                                                                     |
      | "Average purchase price" label                         | Average purchase price                                                                                                                                                                                                              |
      | Average purchase price value in holding currency       |                                                                                                                                                                                                                                     |
      | “Last purchase date” label                             | Last purchase date                                                                                                                                                                                                                  |
      | Last purchase date value                               |                                                                                                                                                                                                                                     |
      | "Market price" label                                   | Market price                                                                                                                                                                                                                        |
      | Market price value in holding currency                 |                                                                                                                                                                                                                                     |
      | "Market price date" label                              | Market price date                                                                                                                                                                                                                   |
      | Market price date value                                |                                                                                                                                                                                                                                     |
      | Disclaimer                                             | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @UK
  @S324-AC4-AT2
  @DependsOn('login_in_as_userN_for_overview_region_Precious_metals')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Region Holding detail page for Precious metals
    Given I am on the allocation holding details
    Then I should see the allocation Precious metals following datas format ISO3

  @UK
  @S324-AC4-AT3
  @DependsOn('login_in_as_userN_for_overview_region_Precious_metals')
  Scenario:Check the dd Mmm yyyy format of Last Purchase Date value/Market Price Date value in Overview Region Holding detail page for Precious metals
    Given I am on the allocation holding details
    Then I should see the allocation Precious metals following datas:Last Purchase Date value (format: dd Mmm yyyy)、Market Price Date value (format: dd Mmm yyyy)
