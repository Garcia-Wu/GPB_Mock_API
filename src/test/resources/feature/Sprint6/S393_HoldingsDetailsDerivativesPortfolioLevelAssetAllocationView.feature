@Epic_GPBM-1094(Holdings)
@Story_GPBM-3014 @Sprint6_iOS
@Story_GPBM-3013 @Sprint6_aOS

Feature: Holdings details - Derivatives - Portfolio level - Asset Allocation view

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio class Derivatives1
    Given I login as type "portfolio_allocation_class_holding_detail_derivatives_part_1"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S393-AC1-AT1
  @DependsOn('login_in_as_userN_for_portfolio_class_Derivatives1')
  Scenario:Check the Portfolio Asset Class Holding detail page UI for Derivatives (part 1)
    Given I am on the allocation holding details
#  Currency Options - 52
#  Options on Fixed Income - 49
#  Credit Linked OTC Derivatives - 9
#  Interest Linked OTC Derivatives - 23
#  Equity Options - 50
#  Future Options - 51
#  Metal Options - 53
#  Commodity Linked OTC Derivatives - 4
#  Other OTC Derivatives - 28
#  Fund Linked OTC Derivatives - 75
    Then I am taken to a detailed allocation Derivatives1 holdings screen displaying the following data:
      | element name                                      | element value                                                                                                                                                                                                                       |
      | Holding name value                                |                                                                                                                                                                                                                                     |
      | ISIN value                                        |                                                                                                                                                                                                                                     |
      | "Quantity" label                                  | Quantity                                                                                                                                                                                                                            |
      | Quantity value                                    |                                                                                                                                                                                                                                     |
      | "Expiry date" label                               | Expiry date                                                                                                                                                                                                                         |
      | Expiry date value                                 |                                                                                                                                                                                                                                     |
      | "Total value" (label)                            | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency                  |                                                                                                                                                                                                                                     |
      | Market value in PORTFOLIO reference currency      |                                                                                                                                                                                                                                     |
      | "Unrealised P/L" label                            | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised Profit/Loss value                      |                                                                                                                                                                                                                                     |
      | "Average option premium" label                    | Average option premium                                                                                                                                                                                                              |
      | Average option premium value                      |                                                                                                                                                                                                                                     |
      | "Last transaction date" label                     | Last transaction date                                                                                                                                                                                                               |
      | Last transaction date value                       |                                                                                                                                                                                                                                     |
      | "Indicative market price" label                   | Indicative market price                                                                                                                                                                                                             |
      | Indicative market price value in holding currency |                                                                                                                                                                                                                                     |
      | "Indicative market price date" label              | Indicative market price date                                                                                                                                                                                                        |
      | Indicative market price date value                |                                                                                                                                                                                                                                     |
      | Disclaimer                                        | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S393-AC1-AT2
  @DependsOn('login_in_as_userN_for_portfolio_class_Derivatives1')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Asset Class Holding detail page for Derivatives (part 1)
    Given I am on the allocation holding details
    Then I should see the allocation Derivatives1 following datas format:ISO 3

  @HK @SG @UK
  @S393-AC1-AT3
  @DependsOn('login_in_as_userN_for_portfolio_class_Derivatives1')
  Scenario:Check the dd Mmm yyyy format of Expiry Date value/Last Transaction Date value/Indicative Market Price Date value in Portfolio Asset Class Holding detail page for Derivatives (part 1)
    Given I am on the allocation holding details
    Then I should see the allocation Derivatives1 following date format:dd MMM yyyy

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio subasset Derivatives1
    Given I login as type "portfolio_allocation_subasset_holding_detail_derivatives_part_1"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S393-AC2-AT1
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Derivatives1')
  Scenario:Check the Portfolio Sub-Asset Class Holding detail page UI for Derivatives (part 1)
    Given I am on the allocation holding details
#  Currency Options - 52
#  Options on Fixed Income - 49
#  Credit Linked OTC Derivatives - 9
#  Interest Linked OTC Derivatives - 23
#  Equity Options - 50
#  Future Options - 51
#  Metal Options - 53
#  Commodity Linked OTC Derivatives - 4
#  Other OTC Derivatives - 28
#  Fund Linked OTC Derivatives - 75
    Then I am taken to a detailed allocation Derivatives1 holdings screen displaying the following data:
      | element name                                      | element value                                                                                                                                                                                                                       |
      | Holding name value                                |                                                                                                                                                                                                                                     |
      | ISIN value                                        |                                                                                                                                                                                                                                     |
      | "Quantity" label                                  | Quantity                                                                                                                                                                                                                            |
      | Quantity value                                    |                                                                                                                                                                                                                                     |
      | "Expiry date" label                               | Expiry date                                                                                                                                                                                                                         |
      | Expiry date value                                 |                                                                                                                                                                                                                                     |
      | "Total value" (label)                            | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency                  |                                                                                                                                                                                                                                     |
      | Market value in PORTFOLIO reference currency      |                                                                                                                                                                                                                                     |
      | "Unrealised P/L" label                            | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised Profit/Loss value                      |                                                                                                                                                                                                                                     |
      | "Average option premium" label                    | Average option premium                                                                                                                                                                                                              |
      | Average option premium value                      |                                                                                                                                                                                                                                     |
      | "Last transaction date" label                     | Last transaction date                                                                                                                                                                                                               |
      | Last transaction date value                       |                                                                                                                                                                                                                                     |
      | "Indicative market price" label                   | Indicative market price                                                                                                                                                                                                             |
      | Indicative market price value in holding currency |                                                                                                                                                                                                                                     |
      | "Indicative market price date" label              | Indicative market price date                                                                                                                                                                                                        |
      | Indicative market price date value                |                                                                                                                                                                                                                                     |
      | Disclaimer                                        | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S393-AC2-AT2
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Derivatives1')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Sub-Asset Class Holding detail page for Derivatives (part 1)
    Given I am on the allocation holding details
    Then I should see the allocation Derivatives1 following datas format:ISO 3

  @HK @SG @UK
  @S393-AC2-AT3
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Derivatives1')
  Scenario:Check the dd Mmm yyyy format of Expiry Date value/Last Transaction Date value/Indicative Market Price Date value in Portfolio Sub-Asset Class Holding detail page for Derivatives (part 1)
    Given I am on the allocation holding details
    Then I should see the allocation Derivatives1 following date format:dd MMM yyyy

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio currency Derivatives1
    Given I login as type "portfolio_allocation_currency_holding_detail_derivatives_part_1"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S393-AC3-AT1
  @DependsOn('login_in_as_userN_for_portfolio_currency_Derivatives1')
  Scenario:Check the Portfolio Currency Holding detail page UI for Derivatives (part 1)
    Given I am on the allocation holding details
#  Currency Options - 52
#  Options on Fixed Income - 49
#  Credit Linked OTC Derivatives - 9
#  Interest Linked OTC Derivatives - 23
#  Equity Options - 50
#  Future Options - 51
#  Metal Options - 53
#  Commodity Linked OTC Derivatives - 4
#  Other OTC Derivatives - 28
#  Fund Linked OTC Derivatives - 75
    Then I am taken to a detailed allocation Derivatives1 holdings screen displaying the following data:
      | element name                                      | element value                                                                                                                                                                                                                       |
      | Holding name value                                |                                                                                                                                                                                                                                     |
      | ISIN value                                        |                                                                                                                                                                                                                                     |
      | "Quantity" label                                  | Quantity                                                                                                                                                                                                                            |
      | Quantity value                                    |                                                                                                                                                                                                                                     |
      | "Expiry date" label                               | Expiry date                                                                                                                                                                                                                         |
      | Expiry date value                                 |                                                                                                                                                                                                                                     |
      | "Total value" (label)                            | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency                  |                                                                                                                                                                                                                                     |
      | Market value in PORTFOLIO reference currency      |                                                                                                                                                                                                                                     |
      | "Unrealised P/L" label                            | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised Profit/Loss value                      |                                                                                                                                                                                                                                     |
      | "Average option premium" label                    | Average option premium                                                                                                                                                                                                              |
      | Average option premium value                      |                                                                                                                                                                                                                                     |
      | "Last transaction date" label                     | Last transaction date                                                                                                                                                                                                               |
      | Last transaction date value                       |                                                                                                                                                                                                                                     |
      | "Indicative market price" label                   | Indicative market price                                                                                                                                                                                                             |
      | Indicative market price value in holding currency |                                                                                                                                                                                                                                     |
      | "Indicative market price date" label              | Indicative market price date                                                                                                                                                                                                        |
      | Indicative market price date value                |                                                                                                                                                                                                                                     |
      | Disclaimer                                        | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S393-AC3-AT2
  @DependsOn('login_in_as_userN_for_portfolio_currency_Derivatives1')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Currency Holding detail page for Derivatives (part 1)
    Given I am on the allocation holding details
    Then I should see the allocation Derivatives1 following datas format:ISO 3

  @HK @SG @UK
  @S393-AC3-AT3
  @DependsOn('login_in_as_userN_for_portfolio_currency_Derivatives1')
  Scenario:Check the dd Mmm yyyy format of Expiry Date value/Last Transaction Date value/Indicative Market Price Date value in Portfolio Currency Holding detail page for Derivatives (part 1)
    Given I am on the allocation holding details
    Then I should see the allocation Derivatives1 following date format:dd MMM yyyy

  @UK
  @SIT
  Scenario: login in as userN for portfolio region Derivatives1
    Given I login as type "portfolio_allocation_region_holding_detail_derivatives_part_1"
    Then I should on the allocation holding details

  @UK
  @S393-AC4-AT1
  @DependsOn('login_in_as_userN_for_portfolio_region_Derivatives1')
  Scenario:Check the Portfolio Region Holding detail page UI for Derivatives (part 1)
    Given I am on the allocation holding details
#  Currency Options - 52
#  Options on Fixed Income - 49
#  Credit Linked OTC Derivatives - 9
#  Interest Linked OTC Derivatives - 23
#  Equity Options - 50
#  Future Options - 51
#  Metal Options - 53
#  Commodity Linked OTC Derivatives - 4
#  Other OTC Derivatives - 28
#  Fund Linked OTC Derivatives - 75
    Then I am taken to a detailed allocation Derivatives1 holdings screen displaying the following data:
      | element name                                      | element value                                                                                                                                                                                                                       |
      | Holding name value                                |                                                                                                                                                                                                                                     |
      | ISIN value                                        |                                                                                                                                                                                                                                     |
      | "Quantity" label                                  | Quantity                                                                                                                                                                                                                            |
      | Quantity value                                    |                                                                                                                                                                                                                                     |
      | "Expiry date" label                               | Expiry date                                                                                                                                                                                                                         |
      | Expiry date value                                 |                                                                                                                                                                                                                                     |
      | "Total value" (label)                            | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency                  |                                                                                                                                                                                                                                     |
      | Market value in PORTFOLIO reference currency      |                                                                                                                                                                                                                                     |
      | "Unrealised P/L" label                            | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised Profit/Loss value                      |                                                                                                                                                                                                                                     |
      | "Average option premium" label                    | Average option premium                                                                                                                                                                                                              |
      | Average option premium value                      |                                                                                                                                                                                                                                     |
      | "Last transaction date" label                     | Last transaction date                                                                                                                                                                                                               |
      | Last transaction date value                       |                                                                                                                                                                                                                                     |
      | "Indicative market price" label                   | Indicative market price                                                                                                                                                                                                             |
      | Indicative market price value in holding currency |                                                                                                                                                                                                                                     |
      | "Indicative market price date" label              | Indicative market price date                                                                                                                                                                                                        |
      | Indicative market price date value                |                                                                                                                                                                                                                                     |
      | Disclaimer                                        | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @UK
  @S393-AC4-AT2
  @DependsOn('login_in_as_userN_for_portfolio_region_Derivatives1')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Region Holding detail page for Derivatives (part 1)
    Given I am on the allocation holding details
    Then I should see the allocation Derivatives1 following datas format:ISO 3

  @UK
  @S393-AC4-AT3
  @DependsOn('login_in_as_userN_for_portfolio_region_Derivatives1')
  Scenario:Check the dd Mmm yyyy format of Expiry Date value/Last Transaction Date value/Indicative Market Price Date value in Portfolio Region Holding detail page for Derivatives (part 1)
    Given I am on the allocation holding details
    Then I should see the allocation Derivatives1 following date format:dd MMM yyyy

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio class Derivatives2
    Given I login as type "portfolio_allocation_class_holding_detail_derivatives_part_2"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S393-AC5-AT1
  @DependsOn('login_in_as_userN_for_portfolio_class_Derivatives2')
  Scenario:Check the Portfolio Asset Class Holding detail page UI for Derivatives (part 2)
    Given I am on the allocation holding details
#  Warrant on Fixed Income - 40
#  Equity Warrant - 39
#  Other Warrant - 30
    Then I am taken to a detailed allocation Derivatives2 holdings screen displaying the following data:
      | element name                                      | element value                                                                                                                                                                                                                       |
      | Holding name value                                |                                                                                                                                                                                                                                     |
      | ISIN value                                        |                                                                                                                                                                                                                                     |
      | "Total value" label                              | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency                  |                                                                                                                                                                                                                                     |
      | Market value in PORTFOLIO reference currency      |                                                                                                                                                                                                                                     |
      | "Unrealised P/L" label                            | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised Profit/Loss value                      |                                                                                                                                                                                                                                     |
      | "Notional amount" label                           | Notional amount                                                                                                                                                                                                                     |
      | Notional amount value                             |                                                                                                                                                                                                                                     |
      | "Maturity date" label                             | Maturity date                                                                                                                                                                                                                       |
      | Maturity date value                               |                                                                                                                                                                                                                                     |
      | "Average premium paid" label                      | Average premium paid                                                                                                                                                                                                                |
      | Average premium paid value                        |                                                                                                                                                                                                                                     |
      | "Last purchase date" label                        | Last purchase date                                                                                                                                                                                                                  |
      | Last purchase date value                          |                                                                                                                                                                                                                                     |
      | "Indicative market price" label                   | Indicative market price                                                                                                                                                                                                             |
      | Indicative market price value in holding currency |                                                                                                                                                                                                                                     |
      | "Indicative market price date" label              | Indicative market price date                                                                                                                                                                                                        |
      | Indicative market price date value                |                                                                                                                                                                                                                                     |
      | Disclaimer                                        | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S393-AC5-AT2
  @DependsOn('login_in_as_userN_for_portfolio_class_Derivatives2')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Asset Class Holding detail page for Derivatives (part 2)
    Given I am on the allocation holding details
    Then I should see the allocation Derivatives2 following datas format:ISO 3

  @HK @SG @UK
  @S393-AC5-AT3
  @DependsOn('login_in_as_userN_for_portfolio_class_Derivatives2')
  Scenario:Check the dd Mmm yyyy format of Maturity Date value/Last Purchase Date value/Indicative Market Price Date value in Portfolio Asset Class Holding detail page for Derivatives (part 2)
    Given I am on the allocation holding details
    Then I should see the allocation Derivatives2 following date format:dd MMM yyyy

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio subasset Derivatives2
    Given I login as type "portfolio_allocation_subasset_holding_detail_derivatives_part_2"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S393-AC6-AT1
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Derivatives2')
  Scenario:Check the Portfolio Sub-Asset Class Holding detail page UI for Derivatives (part 2)
    Given I am on the allocation holding details
#  Warrant on Fixed Income - 40
#  Equity Warrant - 39
#  Other Warrant - 30
    Then I am taken to a detailed allocation Derivatives2 holdings screen displaying the following data:
      | element name                                      | element value                                                                                                                                                                                                                       |
      | Holding name value                                |                                                                                                                                                                                                                                     |
      | ISIN value                                        |                                                                                                                                                                                                                                     |
      | "Total value" label                              | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency                  |                                                                                                                                                                                                                                     |
      | Market value in PORTFOLIO reference currency      |                                                                                                                                                                                                                                     |
      | "Unrealised P/L" label                            | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised Profit/Loss value                      |                                                                                                                                                                                                                                     |
      | "Notional amount" label                           | Notional amount                                                                                                                                                                                                                     |
      | Notional amount value                             |                                                                                                                                                                                                                                     |
      | "Maturity date" label                             | Maturity date                                                                                                                                                                                                                       |
      | Maturity date value                               |                                                                                                                                                                                                                                     |
      | "Average premium paid" label                      | Average premium paid                                                                                                                                                                                                                |
      | Average premium paid value                        |                                                                                                                                                                                                                                     |
      | "Last purchase date" label                        | Last purchase date                                                                                                                                                                                                                  |
      | Last purchase date value                          |                                                                                                                                                                                                                                     |
      | "Indicative market price" label                   | Indicative market price                                                                                                                                                                                                             |
      | Indicative market price value in holding currency |                                                                                                                                                                                                                                     |
      | "Indicative market price date" label              | Indicative market price date                                                                                                                                                                                                        |
      | Indicative market price date value                |                                                                                                                                                                                                                                     |
      | Disclaimer                                        | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S393-AC6-AT2
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Derivatives2')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Sub-Asset Class Holding detail page for Derivatives (part 2)
    Given I am on the allocation holding details
    Then I should see the allocation Derivatives2 following datas format:ISO 3

  @HK @SG @UK
  @S393-AC6-AT3
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Derivatives2')
  Scenario:Check the dd Mmm yyyy format of Maturity Date value/Last Purchase Date value/Indicative Market Price Date value in Portfolio Sub-Asset Class Holding detail page for Derivatives (part 2)
    Given I am on the allocation holding details
    Then I should see the allocation Derivatives2 following date format:dd MMM yyyy

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio currency Derivatives2
    Given I login as type "portfolio_allocation_currency_holding_detail_derivatives_part_2"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S393-AC7-AT1
  @DependsOn('login_in_as_userN_for_portfolio_currency_Derivatives2')
  Scenario:Check the Portfolio Currency Holding detail page UI for Derivatives (part 2)
    Given I am on the allocation holding details
#  Warrant on Fixed Income - 40
#  Equity Warrant - 39
#  Other Warrant - 30
    Then I am taken to a detailed allocation Derivatives2 holdings screen displaying the following data:
      | element name                                      | element value                                                                                                                                                                                                                       |
      | Holding name value                                |                                                                                                                                                                                                                                     |
      | ISIN value                                        |                                                                                                                                                                                                                                     |
      | "Total value" label                              | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency                  |                                                                                                                                                                                                                                     |
      | Market value in PORTFOLIO reference currency      |                                                                                                                                                                                                                                     |
      | "Unrealised P/L" label                            | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised Profit/Loss value                      |                                                                                                                                                                                                                                     |
      | "Notional amount" label                           | Notional amount                                                                                                                                                                                                                     |
      | Notional amount value                             |                                                                                                                                                                                                                                     |
      | "Maturity date" label                             | Maturity date                                                                                                                                                                                                                       |
      | Maturity date value                               |                                                                                                                                                                                                                                     |
      | "Average premium paid" label                      | Average premium paid                                                                                                                                                                                                                |
      | Average premium paid value                        |                                                                                                                                                                                                                                     |
      | "Last purchase date" label                        | Last purchase date                                                                                                                                                                                                                  |
      | Last purchase date value                          |                                                                                                                                                                                                                                     |
      | "Indicative market price" label                   | Indicative market price                                                                                                                                                                                                             |
      | Indicative market price value in holding currency |                                                                                                                                                                                                                                     |
      | "Indicative market price date" label              | Indicative market price date                                                                                                                                                                                                        |
      | Indicative market price date value                |                                                                                                                                                                                                                                     |
      | Disclaimer                                        | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S393-AC7-AT2
  @DependsOn('login_in_as_userN_for_portfolio_currency_Derivatives2')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Currency Holding detail page for Derivatives (part 2)
    Given I am on the allocation holding details
    Then I should see the allocation Derivatives2 following datas format:ISO 3

  @HK @SG @UK
  @S393-AC7-AT3
  @DependsOn('login_in_as_userN_for_portfolio_currency_Derivatives2')
  Scenario:Check the dd Mmm yyyy format of Maturity Date value/Last Purchase Date value/Indicative Market Price Date value in Portfolio Currency Holding detail page for Derivatives (part 2)
    Given I am on the allocation holding details
    Then I should see the allocation Derivatives2 following date format:dd MMM yyyy

  @UK
  @SIT
  Scenario: login in as userN for portfolio region Derivatives2
    Given I login as type "portfolio_allocation_region_holding_detail_derivatives_part_2"
    Then I should on the allocation holding details

  @UK
  @S393-AC8-AT1
  @DependsOn('login_in_as_userN_for_portfolio_region_Derivatives2')
  Scenario:Check the Portfolio Region Holding detail page UI for Derivatives (part 2)
    Given I am on the allocation holding details
#  Warrant on Fixed Income - 40
#  Equity Warrant - 39
#  Other Warrant - 30
    Then I am taken to a detailed allocation Derivatives2 holdings screen displaying the following data:
      | element name                                      | element value                                                                                                                                                                                                                       |
      | Holding name value                                |                                                                                                                                                                                                                                     |
      | ISIN value                                        |                                                                                                                                                                                                                                     |
      | "Total value" label                              | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency                  |                                                                                                                                                                                                                                     |
      | Market value in PORTFOLIO reference currency      |                                                                                                                                                                                                                                     |
      | "Unrealised P/L" label                            | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised Profit/Loss value                      |                                                                                                                                                                                                                                     |
      | "Notional amount" label                           | Notional amount                                                                                                                                                                                                                     |
      | Notional amount value                             |                                                                                                                                                                                                                                     |
      | "Maturity date" label                             | Maturity date                                                                                                                                                                                                                       |
      | Maturity date value                               |                                                                                                                                                                                                                                     |
      | "Average premium paid" label                      | Average premium paid                                                                                                                                                                                                                |
      | Average premium paid value                        |                                                                                                                                                                                                                                     |
      | "Last purchase date" label                        | Last purchase date                                                                                                                                                                                                                  |
      | Last purchase date value                          |                                                                                                                                                                                                                                     |
      | "Indicative market price" label                   | Indicative market price                                                                                                                                                                                                             |
      | Indicative market price value in holding currency |                                                                                                                                                                                                                                     |
      | "Indicative market price date" label              | Indicative market price date                                                                                                                                                                                                        |
      | Indicative market price date value                |                                                                                                                                                                                                                                     |
      | Disclaimer                                        | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @UK
  @S393-AC8-AT2
  @DependsOn('login_in_as_userN_for_portfolio_region_Derivatives2')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Region Holding detail page for Derivatives (part 2)
    Given I am on the allocation holding details
    Then I should see the allocation Derivatives2 following datas format:ISO 3

  @UK
  @S393-AC8-AT3
  @DependsOn('login_in_as_userN_for_portfolio_region_Derivatives2')
  Scenario:Check the dd Mmm yyyy format of Maturity Date value/Last Purchase Date value/Indicative Market Price Date value in Portfolio Region Holding detail page for Derivatives (part 2)
    Given I am on the allocation holding details
    Then I should see the allocation Derivatives2 following date format:dd MMM yyyy