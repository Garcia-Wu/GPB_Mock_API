@Epic_GPBM-1094(Holdings)
@Story_GPBM-2126 @Sprint6_iOS
@Story_GPBM-2127 @Sprint6_aOS
@Sprint19

Feature: Holdings details - Structured Products - Overview level - Asset Allocation view

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for overview class structured products2
    Given I login as type "overview_allocation_class_holding_detail_structured_products_part_2"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S330-AC1-AT1
  @DependsOn('login_in_as_userN_for_overview_class_structured_products2')
  Scenario:Check the Overview Asset Class Holding detail page UI for structured products (part 2)
    Given I am on the allocation holding details
#  Equity Linked Notes - 13
#  Hedge Fund Linked Notes - 2
#  Commodity Linked Notes - 63
#  Forex Linked Notes - 17
#  Other Structured Products - 29
#  Fund Linked Notes - 76
#  Forex Linked Structured Notes - 77
#  Other Structured Products (Islamic Products) - 84
    Then I am taken to a detailed allocation structured products holdings screen displaying the following data:
      | element name                                             | element value                                                                                                                                                                                                                       |
      | Holding name value                                       |                                                                                                                                                                                                                                     |
      | ISIN value                                               |                                                                                                                                                                                                                                     |
      | Total value label                                        | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency                          |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency              |                                                                                                                                                                                                                                     |
      | Unrealised P/L                                           | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised profit/loss % value based on holding currency |                                                                                                                                                                                                                                     |
      | Nominal Amount label                                     | Nominal amount                                                                                                                                                                                                                      |
      | Nominal Amount value                                     |                                                                                                                                                                                                                                     |
      | Maturity Date label                                      | Maturity date                                                                                                                                                                                                                       |
      | Maturity Date value                                      |                                                                                                                                                                                                                                     |
      | Average Purchase Price label                             | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price % value                           |                                                                                                                                                                                                                                     |
      | Last Buy Date label                                      | Last buy date                                                                                                                                                                                                                       |
      | Last Buy Date value                                      |                                                                                                                                                                                                                                     |
      | Indicative Price label                                   | Indicative price                                                                                                                                                                                                                    |
      | Indicative Price (%) value                               |                                                                                                                                                                                                                                     |
      | Indicative Price Date label                              | Indicative price date                                                                                                                                                                                                               |
      | Indicative Price Date value                              |                                                                                                                                                                                                                                     |
      | Issuer                                                   | Issuer                                                                                                                                                                                                                              |
      | Issuer value                                             |                                                                                                                                                                                                                                     |
      | Rating Moody’s                                           | Rating Moody’s                                                                                                                                                                                                                      |
      | Rating Moody’s value                                     |                                                                                                                                                                                                                                     |
      | Rating S&P                                               | Rating S&P                                                                                                                                                                                                                          |
      | Rating S&P value                                         |                                                                                                                                                                                                                                     |
      | Disclaimer                                               | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S330-AC1-AT2
  @DependsOn('login_in_as_userN_for_overview_class_structured_products2')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Asset Class Holding detail page for structured products (part 2)
    Given I am on the allocation holding details
    Then I should see the allocation structured products following datas format:ISO 3

  @HK @SG @UK
  @S330-AC1-AT3
  @DependsOn('login_in_as_userN_for_overview_class_structured_products2')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Indicative Price Date value/Maturity Date value in Overview Asset Class Holding detail page for structured products (part 2)
    Given I am on the allocation holding details
    Then I should see the allocation structured products following date format:dd MMM yyyy

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for overview subasset structured products2
    Given I login as type "overview_allocation_subasset_holding_detail_structured_products_part_2"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S330-AC2-AT1
  @DependsOn('login_in_as_userN_for_overview_subasset_structured_products2')
  Scenario:Check the Overview Sub-Asset Class  Holding detail page UI for structured products (part 2)
    Given I am on the allocation holding details
#  Equity Linked Notes - 13
#  Hedge Fund Linked Notes - 2
#  Commodity Linked Notes - 63
#  Forex Linked Notes - 17
#  Other Structured Products - 29
#  Fund Linked Notes - 76
#  Forex Linked Structured Notes - 77
#  Other Structured Products (Islamic Products) - 84
    Then I am taken to a detailed allocation structured products holdings screen displaying the following data:
      | element name                                             | element value                                                                                                                                                                                                                       |
      | Holding name value                                       |                                                                                                                                                                                                                                     |
      | ISIN value                                               |                                                                                                                                                                                                                                     |
      | Total value label                                        | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency                          |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency              |                                                                                                                                                                                                                                     |
      | Unrealised P/L                                           | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised profit/loss % value based on holding currency |                                                                                                                                                                                                                                     |
      | Nominal Amount label                                     | Nominal amount                                                                                                                                                                                                                      |
      | Nominal Amount value                                     |                                                                                                                                                                                                                                     |
      | Maturity Date label                                      | Maturity date                                                                                                                                                                                                                       |
      | Maturity Date value                                      |                                                                                                                                                                                                                                     |
      | Average Purchase Price label                             | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price % value                           |                                                                                                                                                                                                                                     |
      | Last Buy Date label                                      | Last buy date                                                                                                                                                                                                                       |
      | Last Buy Date value                                      |                                                                                                                                                                                                                                     |
      | Indicative Price label                                   | Indicative price                                                                                                                                                                                                                    |
      | Indicative Price (%) value                               |                                                                                                                                                                                                                                     |
      | Indicative Price Date label                              | Indicative price date                                                                                                                                                                                                               |
      | Indicative Price Date value                              |                                                                                                                                                                                                                                     |
      | Issuer                                                   | Issuer                                                                                                                                                                                                                              |
      | Issuer value                                             |                                                                                                                                                                                                                                     |
      | Rating Moody’s                                           | Rating Moody’s                                                                                                                                                                                                                      |
      | Rating Moody’s value                                     |                                                                                                                                                                                                                                     |
      | Rating S&P                                               | Rating S&P                                                                                                                                                                                                                          |
      | Rating S&P value                                         |                                                                                                                                                                                                                                     |
      | Disclaimer                                               | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S330-AC2-AT2
  @DependsOn('login_in_as_userN_for_overview_subasset_structured_products2')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Sub-Asset Class Holding detail page for structured products (part 2)
    Given I am on the allocation holding details
    Then I should see the allocation structured products following datas format:ISO 3

  @HK @SG @UK
  @S330-AC2-AT3
  @DependsOn('login_in_as_userN_for_overview_subasset_structured_products2')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Indicative Price Date value/Maturity Date value in Overview Sub-Asset Class Holding detail page for structured products (part 2)
    Given I am on the allocation holding details
    Then I should see the allocation structured products following date format:dd MMM yyyy

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for overview currency structured products2
    Given I login as type "overview_allocation_currency_holding_detail_structured_products_part_2"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S330-AC3-AT1
  @DependsOn('login_in_as_userN_for_overview_currency_structured_products2')
  Scenario:Check the Overview Currency  Holding detail page UI for structured products (part 2)
    Given I am on the allocation holding details
#  Equity Linked Notes - 13
#  Hedge Fund Linked Notes - 2
#  Commodity Linked Notes - 63
#  Forex Linked Notes - 17
#  Other Structured Products - 29
#  Fund Linked Notes - 76
#  Forex Linked Structured Notes - 77
#  Other Structured Products (Islamic Products) - 84
    Then I am taken to a detailed allocation structured products holdings screen displaying the following data:
      | element name                                             | element value                                                                                                                                                                                                                       |
      | Holding name value                                       |                                                                                                                                                                                                                                     |
      | ISIN value                                               |                                                                                                                                                                                                                                     |
      | Total value label                                        | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency                          |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency              |                                                                                                                                                                                                                                     |
      | Unrealised P/L                                           | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised profit/loss % value based on holding currency |                                                                                                                                                                                                                                     |
      | Nominal Amount label                                     | Nominal amount                                                                                                                                                                                                                      |
      | Nominal Amount value                                     |                                                                                                                                                                                                                                     |
      | Maturity Date label                                      | Maturity date                                                                                                                                                                                                                       |
      | Maturity Date value                                      |                                                                                                                                                                                                                                     |
      | Average Purchase Price label                             | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price % value                           |                                                                                                                                                                                                                                     |
      | Last Buy Date label                                      | Last buy date                                                                                                                                                                                                                       |
      | Last Buy Date value                                      |                                                                                                                                                                                                                                     |
      | Indicative Price label                                   | Indicative price                                                                                                                                                                                                                    |
      | Indicative Price (%) value                               |                                                                                                                                                                                                                                     |
      | Indicative Price Date label                              | Indicative price date                                                                                                                                                                                                               |
      | Indicative Price Date value                              |                                                                                                                                                                                                                                     |
      | Issuer                                                   | Issuer                                                                                                                                                                                                                              |
      | Issuer value                                             |                                                                                                                                                                                                                                     |
      | Rating Moody’s                                           | Rating Moody’s                                                                                                                                                                                                                      |
      | Rating Moody’s value                                     |                                                                                                                                                                                                                                     |
      | Rating S&P                                               | Rating S&P                                                                                                                                                                                                                          |
      | Rating S&P value                                         |                                                                                                                                                                                                                                     |
      | Disclaimer                                               | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S330-AC3-AT2
  @DependsOn('login_in_as_userN_for_overview_currency_structured_products2')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Currency Holding detail page for structured products (part 2)
    Given I am on the allocation holding details
    Then I should see the allocation structured products following datas format:ISO 3

  @HK @SG @UK
  @S330-AC3-AT3
  @DependsOn('login_in_as_userN_for_overview_currency_structured_products2')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Indicative Price Date value/Maturity Date value in Overview Currency Holding detail page for structured products (part 2)
    Given I am on the allocation holding details
    Then I should see the allocation structured products following date format:dd MMM yyyy

  @UK
  @SIT
  Scenario: login in as userN for overview region structured products2
    Given I login as type "overview_allocation_region_holding_detail_structured_products_part_2"
    Then I should on the allocation holding details

  @UK
  @S330-AC4-AT1
  @DependsOn('login_in_as_userN_for_overview_region_structured_products2')
  Scenario:Check the Overview Region  Holding detail page UI for structured products (part 2)
    Given I am on the allocation holding details
#  Equity Linked Notes - 13
#  Hedge Fund Linked Notes - 2
#  Commodity Linked Notes - 63
#  Forex Linked Notes - 17
#  Other Structured Products - 29
#  Fund Linked Notes - 76
#  Forex Linked Structured Notes - 77
#  Other Structured Products (Islamic Products) - 84
    Then I am taken to a detailed allocation structured products holdings screen displaying the following data:
      | element name                                             | element value                                                                                                                                                                                                                       |
      | Holding name value                                       |                                                                                                                                                                                                                                     |
      | ISIN value                                               |                                                                                                                                                                                                                                     |
      | Total value label                                        | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency                          |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency              |                                                                                                                                                                                                                                     |
      | Unrealised P/L                                           | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised profit/loss % value based on holding currency |                                                                                                                                                                                                                                     |
      | Nominal Amount label                                     | Nominal amount                                                                                                                                                                                                                      |
      | Nominal Amount value                                     |                                                                                                                                                                                                                                     |
      | Maturity Date label                                      | Maturity date                                                                                                                                                                                                                       |
      | Maturity Date value                                      |                                                                                                                                                                                                                                     |
      | Average Purchase Price label                             | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price % value                           |                                                                                                                                                                                                                                     |
      | Last Buy Date label                                      | Last buy date                                                                                                                                                                                                                       |
      | Last Buy Date value                                      |                                                                                                                                                                                                                                     |
      | Indicative Price label                                   | Indicative price                                                                                                                                                                                                                    |
      | Indicative Price (%) value                               |                                                                                                                                                                                                                                     |
      | Indicative Price Date label                              | Indicative price date                                                                                                                                                                                                               |
      | Indicative Price Date value                              |                                                                                                                                                                                                                                     |
      | Issuer                                                   | Issuer                                                                                                                                                                                                                              |
      | Issuer value                                             |                                                                                                                                                                                                                                     |
      | Rating Moody’s                                           | Rating Moody’s                                                                                                                                                                                                                      |
      | Rating Moody’s value                                     |                                                                                                                                                                                                                                     |
      | Rating S&P                                               | Rating S&P                                                                                                                                                                                                                          |
      | Rating S&P value                                         |                                                                                                                                                                                                                                     |
      | Disclaimer                                               | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @UK
  @S330-AC4-AT2
  @DependsOn('login_in_as_userN_for_overview_region_structured_products2')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Region Holding detail page for structured products (part 2)
    Given I am on the allocation holding details
    Then I should see the allocation structured products following datas format:ISO 3

  @UK
  @S330-AC4-AT3
  @DependsOn('login_in_as_userN_for_overview_region_structured_products2')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Indicative Price Date value/Maturity Date value in Overview Region Holding detail page for structured products (part 2)
    Given I am on the allocation holding details
    Then I should see the allocation structured products following date format:dd MMM yyyy






  @HK @SG @UK
  @SIT
  Scenario: login in as userN for overview class structured products1
    Given I login as type "overview_allocation_class_holding_detail_structured_products_part_1"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S330-AC1-AT1
  @DependsOn('login_in_as_userN_for_overview_class_structured_products1')
  Scenario:Check the Overview Asset Class Holding detail page UI for structured products (part 1)
    Given I am on the allocation holding details
    Then I am taken to a Structured Products part1 detailed holdings screen displaying the following data:
      | element name                                             | element value                                                                                                                                                                                                                       |
      | Holding name value                                       |                                                                                                                                                                                                                                     |
      | ISIN value                                               |                                                                                                                                                                                                                                     |
      | Total value label                                        | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency                          |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency              |                                                                                                                                                                                                                                     |
      | Unrealised P/L                                           | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised profit/loss % value based on holding currency |                                                                                                                                                                                                                                     |
      | "Accrued Interest" label                                 | Accrued interest                                                                                                                                                                                                                    |
      | Accrued Interest value in holding currency               |                                                                                                                                                                                                                                     |
      | Nominal Amount label                                     | Nominal amount                                                                                                                                                                                                                      |
      | Nominal Amount value                                     |                                                                                                                                                                                                                                     |
      | Maturity Date label                                      | Maturity date                                                                                                                                                                                                                       |
      | Maturity Date value                                      |                                                                                                                                                                                                                                     |
      | Average Purchase Price label                             | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price % value                           |                                                                                                                                                                                                                                     |
      | Last Buy Date label                                      | Last buy date                                                                                                                                                                                                                       |
      | Last Buy Date value                                      |                                                                                                                                                                                                                                     |
      | Indicative Price label                                   | Indicative price                                                                                                                                                                                                                    |
      | Indicative Price (%) value                               |                                                                                                                                                                                                                                     |
      | Indicative Price Date label                              | Indicative price date                                                                                                                                                                                                               |
      | Indicative Price Date value                              |                                                                                                                                                                                                                                     |
      | Issuer                                                   | Issuer                                                                                                                                                                                                                              |
      | Issuer value                                             |                                                                                                                                                                                                                                     |
      | Rating Moody’s                                           | Rating Moody’s                                                                                                                                                                                                                      |
      | Rating Moody’s value                                     |                                                                                                                                                                                                                                     |
      | Rating S&P                                               | Rating S&P                                                                                                                                                                                                                          |
      | Rating S&P value                                         |                                                                                                                                                                                                                                     |
      | Disclaimer                                               | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S330-AC1-AT2
  @DependsOn('login_in_as_userN_for_overview_class_structured_products1')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Asset Class Holding detail page for structured products (part 1)
    Given I am on the allocation holding details
    Then I should see the structured products following currency format:ISO 3

  @HK @SG @UK
  @S330-AC1-AT3
  @DependsOn('login_in_as_userN_for_overview_class_structured_products1')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Indicative Price Date value/Maturity Date value in Overview Asset Class Holding detail page for structured products (part 1)
    Given I am on the allocation holding details
    Then I can see Structured Products part1 detailed date value Format is "dd MMM yyyy"

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for overview subasset structured products1
    Given I login as type "overview_allocation_subasset_holding_detail_structured_products_part_1"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S330-AC2-AT1
  @DependsOn('login_in_as_userN_for_overview_subasset_structured_products1')
  Scenario:Check the Overview Sub-Asset Class  Holding detail page UI for structured products (part 1)
    Given I am on the allocation holding details
    Then I am taken to a Structured Products part1 detailed holdings screen displaying the following data:
      | element name                                             | element value                                                                                                                                                                                                                       |
      | Holding name value                                       |                                                                                                                                                                                                                                     |
      | ISIN value                                               |                                                                                                                                                                                                                                     |
      | Total value label                                        | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency                          |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency              |                                                                                                                                                                                                                                     |
      | Unrealised P/L                                           | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised profit/loss % value based on holding currency |                                                                                                                                                                                                                                     |
      | "Accrued Interest" label                                 | Accrued interest                                                                                                                                                                                                                    |
      | Accrued Interest value in holding currency               |                                                                                                                                                                                                                                     |
      | Nominal Amount label                                     | Nominal amount                                                                                                                                                                                                                      |
      | Nominal Amount value                                     |                                                                                                                                                                                                                                     |
      | Maturity Date label                                      | Maturity date                                                                                                                                                                                                                       |
      | Maturity Date value                                      |                                                                                                                                                                                                                                     |
      | Average Purchase Price label                             | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price % value                           |                                                                                                                                                                                                                                     |
      | Last Buy Date label                                      | Last buy date                                                                                                                                                                                                                       |
      | Last Buy Date value                                      |                                                                                                                                                                                                                                     |
      | Indicative Price label                                   | Indicative price                                                                                                                                                                                                                    |
      | Indicative Price (%) value                               |                                                                                                                                                                                                                                     |
      | Indicative Price Date label                              | Indicative price date                                                                                                                                                                                                               |
      | Indicative Price Date value                              |                                                                                                                                                                                                                                     |
      | Issuer                                                   | Issuer                                                                                                                                                                                                                              |
      | Issuer value                                             |                                                                                                                                                                                                                                     |
      | Rating Moody’s                                           | Rating Moody’s                                                                                                                                                                                                                      |
      | Rating Moody’s value                                     |                                                                                                                                                                                                                                     |
      | Rating S&P                                               | Rating S&P                                                                                                                                                                                                                          |
      | Rating S&P value                                         |                                                                                                                                                                                                                                     |
      | Disclaimer                                               | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S330-AC2-AT2
  @DependsOn('login_in_as_userN_for_overview_subasset_structured_products1')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Sub-Asset Class Holding detail page for structured products (part 1)
    Given I am on the allocation holding details
    Then I should see the structured products following currency format:ISO 3

  @HK @SG @UK
  @S330-AC2-AT3
  @DependsOn('login_in_as_userN_for_overview_subasset_structured_products1')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Indicative Price Date value/Maturity Date value in Overview Sub-Asset Class Holding detail page for structured products (part 1)
    Given I am on the allocation holding details
    Then I can see Structured Products part1 detailed date value Format is "dd MMM yyyy"

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for overview currency structured products1
    Given I login as type "overview_allocation_currency_holding_detail_structured_products_part_1"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S330-AC3-AT1
  @DependsOn('login_in_as_userN_for_overview_currency_structured_products1')
  Scenario:Check the Overview Currency  Holding detail page UI for structured products (part 1)
    Given I am on the allocation holding details
    Then I am taken to a Structured Products part1 detailed holdings screen displaying the following data:
      | element name                                             | element value                                                                                                                                                                                                                       |
      | Holding name value                                       |                                                                                                                                                                                                                                     |
      | ISIN value                                               |                                                                                                                                                                                                                                     |
      | Total value label                                        | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency                          |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency              |                                                                                                                                                                                                                                     |
      | Unrealised P/L                                           | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised profit/loss % value based on holding currency |                                                                                                                                                                                                                                     |
      | "Accrued Interest" label                                 | Accrued interest                                                                                                                                                                                                                    |
      | Accrued Interest value in holding currency               |                                                                                                                                                                                                                                     |
      | Nominal Amount label                                     | Nominal amount                                                                                                                                                                                                                      |
      | Nominal Amount value                                     |                                                                                                                                                                                                                                     |
      | Maturity Date label                                      | Maturity date                                                                                                                                                                                                                       |
      | Maturity Date value                                      |                                                                                                                                                                                                                                     |
      | Average Purchase Price label                             | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price % value                           |                                                                                                                                                                                                                                     |
      | Last Buy Date label                                      | Last buy date                                                                                                                                                                                                                       |
      | Last Buy Date value                                      |                                                                                                                                                                                                                                     |
      | Indicative Price label                                   | Indicative price                                                                                                                                                                                                                    |
      | Indicative Price (%) value                               |                                                                                                                                                                                                                                     |
      | Indicative Price Date label                              | Indicative price date                                                                                                                                                                                                               |
      | Indicative Price Date value                              |                                                                                                                                                                                                                                     |
      | Issuer                                                   | Issuer                                                                                                                                                                                                                              |
      | Issuer value                                             |                                                                                                                                                                                                                                     |
      | Rating Moody’s                                           | Rating Moody’s                                                                                                                                                                                                                      |
      | Rating Moody’s value                                     |                                                                                                                                                                                                                                     |
      | Rating S&P                                               | Rating S&P                                                                                                                                                                                                                          |
      | Rating S&P value                                         |                                                                                                                                                                                                                                     |
      | Disclaimer                                               | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S330-AC3-AT2
  @DependsOn('login_in_as_userN_for_overview_currency_structured_products1')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Currency Holding detail page for structured products (part 1)
    Given I am on the allocation holding details
    Then I should see the structured products following currency format:ISO 3

  @HK @SG @UK
  @S330-AC3-AT3
  @DependsOn('login_in_as_userN_for_overview_currency_structured_products1')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Indicative Price Date value/Maturity Date value in Overview Currency Holding detail page for structured products (part 1)
    Given I am on the allocation holding details
    Then I can see Structured Products part1 detailed date value Format is "dd MMM yyyy"

  @UK
  @SIT
  Scenario: login in as userN for overview region structured products1
    Given I login as type "overview_allocation_region_holding_detail_structured_products_part_1"
    Then I should on the allocation holding details

  @UK
  @S330-AC4-AT1
  @DependsOn('login_in_as_userN_for_overview_region_structured_products1')
  Scenario:Check the Overview Region  Holding detail page UI for structured products (part 1)
    Given I am on the allocation holding details
    Then I am taken to a Structured Products part1 detailed holdings screen displaying the following data:
      | element name                                             | element value                                                                                                                                                                                                                       |
      | Holding name value                                       |                                                                                                                                                                                                                                     |
      | ISIN value                                               |                                                                                                                                                                                                                                     |
      | Total value label                                        | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency                          |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency              |                                                                                                                                                                                                                                     |
      | Unrealised P/L                                           | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised profit/loss % value based on holding currency |                                                                                                                                                                                                                                     |
      | "Accrued Interest" label                                 | Accrued interest                                                                                                                                                                                                                    |
      | Accrued Interest value in holding currency               |                                                                                                                                                                                                                                     |
      | Nominal Amount label                                     | Nominal amount                                                                                                                                                                                                                      |
      | Nominal Amount value                                     |                                                                                                                                                                                                                                     |
      | Maturity Date label                                      | Maturity date                                                                                                                                                                                                                       |
      | Maturity Date value                                      |                                                                                                                                                                                                                                     |
      | Average Purchase Price label                             | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price % value                           |                                                                                                                                                                                                                                     |
      | Last Buy Date label                                      | Last buy date                                                                                                                                                                                                                       |
      | Last Buy Date value                                      |                                                                                                                                                                                                                                     |
      | Indicative Price label                                   | Indicative price                                                                                                                                                                                                                    |
      | Indicative Price (%) value                               |                                                                                                                                                                                                                                     |
      | Indicative Price Date label                              | Indicative price date                                                                                                                                                                                                               |
      | Indicative Price Date value                              |                                                                                                                                                                                                                                     |
      | Issuer                                                   | Issuer                                                                                                                                                                                                                              |
      | Issuer value                                             |                                                                                                                                                                                                                                     |
      | Rating Moody’s                                           | Rating Moody’s                                                                                                                                                                                                                      |
      | Rating Moody’s value                                     |                                                                                                                                                                                                                                     |
      | Rating S&P                                               | Rating S&P                                                                                                                                                                                                                          |
      | Rating S&P value                                         |                                                                                                                                                                                                                                     |
      | Disclaimer                                               | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @UK
  @S330-AC4-AT2
  @DependsOn('login_in_as_userN_for_overview_region_structured_products1')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Region Holding detail page for structured products (part 1)
    Given I am on the allocation holding details
    Then I should see the structured products following currency format:ISO 3

  @UK
  @S330-AC4-AT3
  @DependsOn('login_in_as_userN_for_overview_region_structured_products1')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Indicative Price Date value/Maturity Date value in Overview Region Holding detail page for structured products (part 1)
    Given I am on the allocation holding details
    Then I can see Structured Products part1 detailed date value Format is "dd MMM yyyy"