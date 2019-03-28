@Epic_GPBM-1094(Holdings)
@Story_GPBM-2122 @Sprint6_iOS
@Story_GPBM-2123 @Sprint6_aOS

Feature: Holdings details - Funds - Overview level - Asset Allocation view

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for overview class Funds1
    Given I login as type "overview_allocation_class_holding_detail_funds_part_1"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S326-AC1-AT1
  @DependsOn('login_in_as_userN_for_overview_class_Funds1')
  Scenario:Check the Overview Asset Class Holding detail page UI for Funds (part 1)
    Given I am on the allocation holding details
#  Money Market Mutual Funds - 25
#  Money Market Mutual Funds (Islamic Products) - 88
#  Convertible Bonds Mutual Funds - 7
#  Fixed Income Mutual Funds - 16
#  Convertible Bonds Mutual Funds (Islamic Products) - 87
#  Fixed Income Mutual Funds (Islamic Products) - 86
#  Equity Mutual Fund - 15
#  Equity Mutual Fund (Islamic Products) - 85
#  Commodity Funds - 5
#  Commodity Funds (Islamic Products) - 81
#  Other Mutual Funds - 27
#  Other Mutual Funds (Islamic Products) - 89
#  Hedge Funds - 1
#  Hedge Funds (Islamic Products) - 90
    Then I am taken to a detailed allocation Funds1 holdings screen displaying the following data:
      | element name                                            | element value                                                                                                                                                                                                                       |
      | Holding name value                                      |                                                                                                                                                                                                                                     |
      | ISIN value                                              |                                                                                                                                                                                                                                     |
      | "Units" label                                           | Units                                                                                                                                                                                                                               |
      | Units value                                             |                                                                                                                                                                                                                                     |
      | "Total value" label                                    | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency                        |                                                                                                                                                                                                                                     |
      | Market value in OVERVIEW reference currency             |                                                                                                                                                                                                                                     |
      | "Unrealised P/L" label                                  | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised Profit/Loss based on holding currency as a % |                                                                                                                                                                                                                                     |
      | "Average purchase price" label                          | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price value                            |                                                                                                                                                                                                                                     |
      | "Last purchase date" label                              | Last purchase date                                                                                                                                                                                                                  |
      | Last purchase Date value                                |                                                                                                                                                                                                                                     |
      | "Market price" label                                    | Market price                                                                                                                                                                                                                        |
      | Market price value                                      |                                                                                                                                                                                                                                     |
      | "Market price date" label                               | Market price date                                                                                                                                                                                                                   |
      | Market price date value                                 |                                                                                                                                                                                                                                     |
      | "Sector" label                                          | Sector                                                                                                                                                                                                                              |
      | Sector value                                            |                                                                                                                                                                                                                                     |
      | Disclaimer                                              | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S326-AC1-AT2
  @DependsOn('login_in_as_userN_for_overview_class_Funds1')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Asset Class Holding detail page for Funds (part 1)
    Given I am on the allocation holding details
    Then I should see the allocation Funds1 following datas format: ISO 3

  @HK @SG @UK
  @S326-AC1-AT3
  @DependsOn('login_in_as_userN_for_overview_class_Funds1')
  Scenario:Check the dd Mmm yyyy format of Last buy Date value/Market Price Date value in Overview Asset Class Holding detail page for Funds (part 1)
    Given I am on the allocation holding details
    Then I should see the allocation Funds1 following data:Market Price Date value (format: dd Mmm yyyy)、Last buy Date value (format: dd Mmm yyyy)

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for overview subasset Funds1
    Given I login as type "overview_allocation_subasset_holding_detail_funds_part_1"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S326-AC2-AT1
  @DependsOn('login_in_as_userN_for_overview_subasset_Funds1')
  Scenario:Check the Overview Sub-Asset Class Holding detail page UI for Funds (part 1)
    Given I am on the allocation holding details
#  Money Market Mutual Funds - 25
#  Money Market Mutual Funds (Islamic Products) - 88
#  Convertible Bonds Mutual Funds - 7
#  Fixed Income Mutual Funds - 16
#  Convertible Bonds Mutual Funds (Islamic Products) - 87
#  Fixed Income Mutual Funds (Islamic Products) - 86
#  Equity Mutual Fund - 15
#  Equity Mutual Fund (Islamic Products) - 85
#  Commodity Funds - 5
#  Commodity Funds (Islamic Products) - 81
#  Other Mutual Funds - 27
#  Other Mutual Funds (Islamic Products) - 89
#  Hedge Funds - 1
#  Hedge Funds (Islamic Products) - 90
    Then I am taken to a detailed allocation Funds1 holdings screen displaying the following data:
      | element name                                            | element value                                                                                                                                                                                                                       |
      | Holding name value                                      |                                                                                                                                                                                                                                     |
      | ISIN value                                              |                                                                                                                                                                                                                                     |
      | "Units" label                                           | Units                                                                                                                                                                                                                               |
      | Units value                                             |                                                                                                                                                                                                                                     |
      | "Total value" label                                    | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency                        |                                                                                                                                                                                                                                     |
      | Market value in OVERVIEW reference currency             |                                                                                                                                                                                                                                     |
      | "Unrealised P/L" label                                  | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised Profit/Loss based on holding currency as a % |                                                                                                                                                                                                                                     |
      | "Average purchase price" label                          | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price value                            |                                                                                                                                                                                                                                     |
      | "Last purchase date" label                              | Last purchase date                                                                                                                                                                                                                  |
      | Last purchase Date value                                |                                                                                                                                                                                                                                     |
      | "Market price" label                                    | Market price                                                                                                                                                                                                                        |
      | Market price value                                      |                                                                                                                                                                                                                                     |
      | "Market price date" label                               | Market price date                                                                                                                                                                                                                   |
      | Market price date value                                 |                                                                                                                                                                                                                                     |
      | "Sector" label                                          | Sector                                                                                                                                                                                                                              |
      | Sector value                                            |                                                                                                                                                                                                                                     |
      | Disclaimer                                              | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S326-AC2-AT2
  @DependsOn('login_in_as_userN_for_overview_subasset_Funds1')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Sub-Asset Class Holding detail page for Funds (part 1)
    Given I am on the allocation holding details
    Then I should see the allocation Funds1 following datas format: ISO 3

  @HK @SG @UK
  @S326-AC2-AT3
  @DependsOn('login_in_as_userN_for_overview_subasset_Funds1')
  Scenario:Check the dd Mmm yyyy format of Last buy Date value/Market Price Date value in Overview Sub-Asset Class Holding detail page for Funds (part 1)
    Given I am on the allocation holding details
    Then I should see the allocation Funds1 following data:Market Price Date value (format: dd Mmm yyyy)、Last buy Date value (format: dd Mmm yyyy)

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for overview currency Funds1
    Given I login as type "overview_allocation_currency_holding_detail_funds_part_1"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S326-AC3-AT1
  @DependsOn('login_in_as_userN_for_overview_currency_Funds1')
  Scenario:Check the Overview Currency Holding detail page UI for Funds (part 1)
    Given I am on the allocation holding details
#  Money Market Mutual Funds - 25
#  Money Market Mutual Funds (Islamic Products) - 88
#  Convertible Bonds Mutual Funds - 7
#  Fixed Income Mutual Funds - 16
#  Convertible Bonds Mutual Funds (Islamic Products) - 87
#  Fixed Income Mutual Funds (Islamic Products) - 86
#  Equity Mutual Fund - 15
#  Equity Mutual Fund (Islamic Products) - 85
#  Commodity Funds - 5
#  Commodity Funds (Islamic Products) - 81
#  Other Mutual Funds - 27
#  Other Mutual Funds (Islamic Products) - 89
#  Hedge Funds - 1
#  Hedge Funds (Islamic Products) - 90
    Then I am taken to a detailed allocation Funds1 holdings screen displaying the following data:
      | element name                                            | element value                                                                                                                                                                                                                       |
      | Holding name value                                      |                                                                                                                                                                                                                                     |
      | ISIN value                                              |                                                                                                                                                                                                                                     |
      | "Units" label                                           | Units                                                                                                                                                                                                                               |
      | Units value                                             |                                                                                                                                                                                                                                     |
      | "Total value" label                                    | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency                        |                                                                                                                                                                                                                                     |
      | Market value in OVERVIEW reference currency             |                                                                                                                                                                                                                                     |
      | "Unrealised P/L" label                                  | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised Profit/Loss based on holding currency as a % |                                                                                                                                                                                                                                     |
      | "Average purchase price" label                          | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price value                            |                                                                                                                                                                                                                                     |
      | "Last purchase date" label                              | Last purchase date                                                                                                                                                                                                                  |
      | Last purchase Date value                                |                                                                                                                                                                                                                                     |
      | "Market price" label                                    | Market price                                                                                                                                                                                                                        |
      | Market price value                                      |                                                                                                                                                                                                                                     |
      | "Market price date" label                               | Market price date                                                                                                                                                                                                                   |
      | Market price date value                                 |                                                                                                                                                                                                                                     |
      | "Sector" label                                          | Sector                                                                                                                                                                                                                              |
      | Sector value                                            |                                                                                                                                                                                                                                     |
      | Disclaimer                                              | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S326-AC3-AT2
  @DependsOn('login_in_as_userN_for_overview_currency_Funds1')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Currency Holding detail page for Funds (part 1)
    Given I am on the allocation holding details
    Then I should see the allocation Funds1 following datas format: ISO 3

  @HK @SG @UK
  @S326-AC3-AT3
  @DependsOn('login_in_as_userN_for_overview_currency_Funds1')
  Scenario:Check the dd Mmm yyyy format of Last buy Date value/Market Price Date value in Overview Currency Holding detail page for Funds (part 1)
    Given I am on the allocation holding details
    Then I should see the allocation Funds1 following data:Market Price Date value (format: dd Mmm yyyy)、Last buy Date value (format: dd Mmm yyyy)

  @UK
  @SIT
  Scenario: login in as userN for overview region Funds1
    Given I login as type "overview_allocation_region_holding_detail_funds_part_1"
    Then I should on the allocation holding details

  @UK
  @S326-AC4-AT1
  @DependsOn('login_in_as_userN_for_overview_region_Funds1')
  Scenario:Check the Overview Region Holding detail page UI for Funds (part 1)
    Given I am on the allocation holding details
#  Money Market Mutual Funds - 25
#  Money Market Mutual Funds (Islamic Products) - 88
#  Convertible Bonds Mutual Funds - 7
#  Fixed Income Mutual Funds - 16
#  Convertible Bonds Mutual Funds (Islamic Products) - 87
#  Fixed Income Mutual Funds (Islamic Products) - 86
#  Equity Mutual Fund - 15
#  Equity Mutual Fund (Islamic Products) - 85
#  Commodity Funds - 5
#  Commodity Funds (Islamic Products) - 81
#  Other Mutual Funds - 27
#  Other Mutual Funds (Islamic Products) - 89
#  Hedge Funds - 1
#  Hedge Funds (Islamic Products) - 90
    Then I am taken to a detailed allocation Funds1 holdings screen displaying the following data:
      | element name                                            | element value                                                                                                                                                                                                                       |
      | Holding name value                                      |                                                                                                                                                                                                                                     |
      | ISIN value                                              |                                                                                                                                                                                                                                     |
      | "Units" label                                           | Units                                                                                                                                                                                                                               |
      | Units value                                             |                                                                                                                                                                                                                                     |
      | "Total value" label                                    | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency                        |                                                                                                                                                                                                                                     |
      | Market value in OVERVIEW reference currency             |                                                                                                                                                                                                                                     |
      | "Unrealised P/L" label                                  | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised Profit/Loss based on holding currency as a % |                                                                                                                                                                                                                                     |
      | "Average purchase price" label                          | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price value                            |                                                                                                                                                                                                                                     |
      | "Last purchase date" label                              | Last purchase date                                                                                                                                                                                                                  |
      | Last purchase Date value                                |                                                                                                                                                                                                                                     |
      | "Market price" label                                    | Market price                                                                                                                                                                                                                        |
      | Market price value                                      |                                                                                                                                                                                                                                     |
      | "Market price date" label                               | Market price date                                                                                                                                                                                                                   |
      | Market price date value                                 |                                                                                                                                                                                                                                     |
      | "Sector" label                                          | Sector                                                                                                                                                                                                                              |
      | Sector value                                            |                                                                                                                                                                                                                                     |
      | Disclaimer                                              | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @UK
  @S326-AC4-AT2
  @DependsOn('login_in_as_userN_for_overview_region_Funds1')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Region Holding detail page for Funds (part 1)
    Given I am on the allocation holding details
    Then I should see the allocation Funds1 following datas format: ISO 3

  @UK
  @S326-AC4-AT3
  @DependsOn('login_in_as_userN_for_overview_region_Funds1')
  Scenario:Check the dd Mmm yyyy format of Last buy Date value/Market Price Date value in Overview Region Holding detail page for Funds (part 1)
    Given I am on the allocation holding details
    Then I should see the allocation Funds1 following data:Market Price Date value (format: dd Mmm yyyy)、Last buy Date value (format: dd Mmm yyyy)

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for overview class Funds2
    Given I login as type "overview_allocation_class_holding_detail_funds_part_2"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S326-AC5-AT1
  @DependsOn('login_in_as_userN_for_overview_class_Funds2')
  Scenario:Check the Overview Asset Class  Holding detail page UI for Funds (part 2)
    Given I am on the allocation holding details
#  Discretionary Mandates - 1
    Then I am taken to a detailed allocation Funds2 holdings screen displaying the following data:
      | element name                                 | element value                                                                                                                                                                                                                       |
      | Holding name value                           |                                                                                                                                                                                                                                     |
      | ISIN value                                   |                                                                                                                                                                                                                                     |
      | "Total value" label                         | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency             |                                                                                                                                                                                                                                     |
      | Market value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | "Market price" label                         | Market price                                                                                                                                                                                                                        |
      | Market price value in holding currency       |                                                                                                                                                                                                                                     |
      | "Market price date" label                    | Market price date                                                                                                                                                                                                                   |
      | Market price date value                      |                                                                                                                                                                                                                                     |
      | "Amount" label                               | Amount                                                                                                                                                                                                                              |
      | Amount value                                 |                                                                                                                                                                                                                                     |
      | "Last purchase date" label                   | Last purchase date                                                                                                                                                                                                                  |
      | Last purchase date value                     |                                                                                                                                                                                                                                     |
      | "Sector" label                               | Sector                                                                                                                                                                                                                              |
      | Sector value                                 |                                                                                                                                                                                                                                     |
      | Disclaimer                                   | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S326-AC5-AT2
  @DependsOn('login_in_as_userN_for_overview_class_Funds2')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Asset Class Holding detail page for Funds (part 2)
    Given I am on the allocation holding details
    Then I should see the allocation Funds2 following datas format: ISO 3

  @HK @SG @UK
  @S326-AC5-AT3
  @DependsOn('login_in_as_userN_for_overview_class_Funds2')
  Scenario:Check the dd Mmm yyyy format of Last buy Date value/Market Price Date value in Overview Asset Class Holding detail page for Funds (part 2)
    Given I am on the allocation holding details
    Then I should see the allocation Funds2 following datas:Market Price Date value (format: dd Mmm yyyy)、Last buy Date value (format: dd Mmm yyyy)

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for overview subasset Funds2
    Given I login as type "overview_allocation_subasset_holding_detail_funds_part_2"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S326-AC6-AT1
  @DependsOn('login_in_as_userN_for_overview_subasset_Funds2')
  Scenario:Check the Overview Sub-Asset Class Holding detail page UI for Funds (part 2)
    Given I am on the allocation holding details
#  Discretionary Mandates - 1
    Then I am taken to a detailed allocation Funds2 holdings screen displaying the following data:
      | element name                                 | element value                                                                                                                                                                                                                       |
      | Holding name value                           |                                                                                                                                                                                                                                     |
      | ISIN value                                   |                                                                                                                                                                                                                                     |
      | "Total value" label                         | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency             |                                                                                                                                                                                                                                     |
      | Market value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | "Market price" label                         | Market price                                                                                                                                                                                                                        |
      | Market price value in holding currency       |                                                                                                                                                                                                                                     |
      | "Market price date" label                    | Market price date                                                                                                                                                                                                                   |
      | Market price date value                      |                                                                                                                                                                                                                                     |
      | "Amount" label                               | Amount                                                                                                                                                                                                                              |
      | Amount value                                 |                                                                                                                                                                                                                                     |
      | "Last purchase date" label                   | Last purchase date                                                                                                                                                                                                                  |
      | Last purchase date value                     |                                                                                                                                                                                                                                     |
      | "Sector" label                               | Sector                                                                                                                                                                                                                              |
      | Sector value                                 |                                                                                                                                                                                                                                     |
      | Disclaimer                                   | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S326-AC6-AT2
  @DependsOn('login_in_as_userN_for_overview_subasset_Funds2')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Sub-Asset Class Holding detail page for Funds (part 2)
    Given I am on the allocation holding details
    Then I should see the allocation Funds2 following datas format: ISO 3

  @HK @SG @UK
  @S326-AC6-AT3
  @DependsOn('login_in_as_userN_for_overview_subasset_Funds2')
  Scenario:Check the dd Mmm yyyy format of Last buy Date value/Market Price Date value in Overview Sub-Asset Class Holding detail page for Funds (part 2)
    Given I am on the allocation holding details
    Then I should see the allocation Funds2 following datas:Market Price Date value (format: dd Mmm yyyy)、Last buy Date value (format: dd Mmm yyyy)

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for overview currency Funds2
    Given I login as type "overview_allocation_currency_holding_detail_funds_part_2"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S326-AC7-AT1
  @DependsOn('login_in_as_userN_for_overview_currency_Funds2')
  Scenario:Check the Overview Currency Holding detail page UI for Funds (part 2)
    Given I am on the allocation holding details
#  Discretionary Mandates - 1
    Then I am taken to a detailed allocation Funds2 holdings screen displaying the following data:
      | element name                                 | element value                                                                                                                                                                                                                       |
      | Holding name value                           |                                                                                                                                                                                                                                     |
      | ISIN value                                   |                                                                                                                                                                                                                                     |
      | "Total value" label                         | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency             |                                                                                                                                                                                                                                     |
      | Market value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | "Market price" label                         | Market price                                                                                                                                                                                                                        |
      | Market price value in holding currency       |                                                                                                                                                                                                                                     |
      | "Market price date" label                    | Market price date                                                                                                                                                                                                                   |
      | Market price date value                      |                                                                                                                                                                                                                                     |
      | "Amount" label                               | Amount                                                                                                                                                                                                                              |
      | Amount value                                 |                                                                                                                                                                                                                                     |
      | "Last purchase date" label                   | Last purchase date                                                                                                                                                                                                                  |
      | Last purchase date value                     |                                                                                                                                                                                                                                     |
      | "Sector" label                               | Sector                                                                                                                                                                                                                              |
      | Sector value                                 |                                                                                                                                                                                                                                     |
      | Disclaimer                                   | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S326-AC7-AT2
  @DependsOn('login_in_as_userN_for_overview_currency_Funds2')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Currency Holding detail page for Funds (part 2)
    Given I am on the allocation holding details
    Then I should see the allocation Funds2 following datas format: ISO 3

  @HK @SG @UK
  @S326-AC7-AT3
  @DependsOn('login_in_as_userN_for_overview_currency_Funds2')
  Scenario:Check the dd Mmm yyyy format of Last buy Date value/Market Price Date value in Overview Currency Holding detail page for Funds (part 2)
    Given I am on the allocation holding details
    Then I should see the allocation Funds2 following datas:Market Price Date value (format: dd Mmm yyyy)、Last buy Date value (format: dd Mmm yyyy)

  @UK
  @SIT
  Scenario: login in as userN for overview region Funds2
    Given I login as type "overview_allocation_region_holding_detail_funds_part_2"
    Then I should on the allocation holding details

  @UK
  @S326-AC8-AT1
  @DependsOn('login_in_as_userN_for_overview_region_Funds2')
  Scenario:Check the Overview Region Holding detail page UI for Funds (part 2)
    Given I am on the allocation holding details
#  Discretionary Mandates - 1
    Then I am taken to a detailed allocation Funds2 holdings screen displaying the following data:
      | element name                                 | element value                                                                                                                                                                                                                       |
      | Holding name value                           |                                                                                                                                                                                                                                     |
      | ISIN value                                   |                                                                                                                                                                                                                                     |
      | "Total value" label                         | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency             |                                                                                                                                                                                                                                     |
      | Market value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | "Market price" label                         | Market price                                                                                                                                                                                                                        |
      | Market price value in holding currency       |                                                                                                                                                                                                                                     |
      | "Market price date" label                    | Market price date                                                                                                                                                                                                                   |
      | Market price date value                      |                                                                                                                                                                                                                                     |
      | "Amount" label                               | Amount                                                                                                                                                                                                                              |
      | Amount value                                 |                                                                                                                                                                                                                                     |
      | "Last purchase date" label                   | Last purchase date                                                                                                                                                                                                                  |
      | Last purchase date value                     |                                                                                                                                                                                                                                     |
      | "Sector" label                               | Sector                                                                                                                                                                                                                              |
      | Sector value                                 |                                                                                                                                                                                                                                     |
      | Disclaimer                                   | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @UK
  @S326-AC8-AT2
  @DependsOn('login_in_as_userN_for_overview_region_Funds2')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Region Holding detail page for Funds (part 2)
    Given I am on the allocation holding details
    Then I should see the allocation Funds2 following datas format: ISO 3

  @UK
  @S326-AC8-AT3
  @DependsOn('login_in_as_userN_for_overview_region_Funds2')
  Scenario:Check the dd Mmm yyyy format of Last buy Date value/Market Price Date value in Overview Region Holding detail page for Funds (part 2)
    Given I am on the allocation holding details
    Then I should see the allocation Funds2 following datas:Market Price Date value (format: dd Mmm yyyy)、Last buy Date value (format: dd Mmm yyyy)