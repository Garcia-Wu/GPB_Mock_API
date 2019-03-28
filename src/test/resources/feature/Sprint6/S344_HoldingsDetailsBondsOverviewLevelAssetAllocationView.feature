@Epic_GPBM-1094(Holdings)
@Story_GPBM-2142 @Sprint6_iOS
@Story_GPBM-2143 @Sprint6_aOS
@Sprint19

Feature: Holdings details - Bonds - Overview level - Asset Allocation view

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for overview class Bonds
    Given I login as type "overview_allocation_class_holding_detail_bonds"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S344-AC1-AT1
  @DependsOn('login_in_as_userN_for_overview_class_Bonds')
  Scenario:Check the Overview Asset Class Holding detail page UI for Bonds (part 1)
    Given I am on the allocation holding details
    Then I am taken to a allocation bonds detailed holdings screen displaying the following data:
      | element name                                | element value                                                                                                                                                                                                                       |
      | Holding name value                          |                                                                                                                                                                                                                                     |
      | ISIN value                                  |                                                                                                                                                                                                                                     |
      | "Total value" label                         | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency             |                                                                                                                                                                                                                                     |
      | Total value in portfolio reporting currency |                                                                                                                                                                                                                                     |
      | "Accrued Interest" label                    | Accrued interest                                                                                                                                                                                                                    |
      | Accrued Interest value in holding currency  |                                                                                                                                                                                                                                     |
      | "Nominal Amount" label                      | Nominal amount                                                                                                                                                                                                                      |
      | Nominal Amount value in holding currency    |                                                                                                                                                                                                                                     |
      | "Average Purchase Price" label              | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price value as a %         |                                                                                                                                                                                                                                     |
      | "Last Buy Date" label                       | Last buy date                                                                                                                                                                                                                       |
      | Last Buy Date value                         |                                                                                                                                                                                                                                     |
      | "Indicative Market Price" label             | Indicative market price                                                                                                                                                                                                             |
      | Indicative Market Price value as a %        |                                                                                                                                                                                                                                     |
      | "Market Price Date" label                   | Market price date                                                                                                                                                                                                                   |
      | Market Price Date value                     |                                                                                                                                                                                                                                     |
      | "YTM" label                                 | YTM                                                                                                                                                                                                                                 |
      | YTM value                                   |                                                                                                                                                                                                                                     |
      | "Duration" label                            | Duration                                                                                                                                                                                                                            |
      | Duration value                              |                                                                                                                                                                                                                                     |
      | "Issuer" label                              | Issuer                                                                                                                                                                                                                              |
      | Issuer value                                |                                                                                                                                                                                                                                     |
      | "Rating Moody’s" label                      | Rating Moody’s                                                                                                                                                                                                                      |
      | Rating Moody’s value                        |                                                                                                                                                                                                                                     |
      | "Rating S&P" label                          | Rating S&P                                                                                                                                                                                                                          |
      | "Rating S&P" value                          |                                                                                                                                                                                                                                     |
      | "Country of Risk" label                     | Country of risk                                                                                                                                                                                                                     |
      | Country of Risk value                       |                                                                                                                                                                                                                                     |
      | "Maturity Date" label                       | Maturity date                                                                                                                                                                                                                       |
      | Maturity Date value                         |                                                                                                                                                                                                                                     |
      | "Minimum investment amount" label           | Minimum investment amount                                                                                                                                                                                                           |
      | Minimum Piece value                         |                                                                                                                                                                                                                                     |
      | Disclaimer                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S344-AC1-AT2
  @DependsOn('login_in_as_userN_for_overview_class_Bonds')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Asset Class Holding detail page for Bonds (part 1)
    Given I am on the allocation holding details
    Then I can see ISO 3 code of allocation bonds holdings bonds currency

  @HK @SG @UK
  @S344-AC1-AT3
  @DependsOn('login_in_as_userN_for_overview_class_Bonds')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Market Price Date value/Maturity date value in Overview Asset Class Holding detail page for Bonds (part 1)
    Given I am on the allocation holding details
    Then I can see allocation holdings bonds date value Format is "dd Mmm yyyy"

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for overview subasset Bonds
    Given I login as type "overview_allocation_subasset_holding_detail_bonds"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S344-AC2-AT1
  @DependsOn('login_in_as_userN_for_overview_subasset_Bonds')
  Scenario:Check the Overview Sub-Asset Class Holding detail page UI for Bonds (part 1)
    Given I am on the allocation holding details
    Then I am taken to a allocation bonds detailed holdings screen displaying the following data:
      | element name                                | element value                                                                                                                                                                                                                       |
      | Holding name value                          |                                                                                                                                                                                                                                     |
      | ISIN value                                  |                                                                                                                                                                                                                                     |
      | "Total value" label                         | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency             |                                                                                                                                                                                                                                     |
      | Total value in portfolio reporting currency |                                                                                                                                                                                                                                     |
      | "Accrued Interest" label                    | Accrued interest                                                                                                                                                                                                                    |
      | Accrued Interest value in holding currency  |                                                                                                                                                                                                                                     |
      | "Nominal Amount" label                      | Nominal amount                                                                                                                                                                                                                      |
      | Nominal Amount value in holding currency    |                                                                                                                                                                                                                                     |
      | "Average Purchase Price" label              | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price value as a %         |                                                                                                                                                                                                                                     |
      | "Last Buy Date" label                       | Last buy date                                                                                                                                                                                                                       |
      | Last Buy Date value                         |                                                                                                                                                                                                                                     |
      | "Indicative Market Price" label             | Indicative market price                                                                                                                                                                                                             |
      | Indicative Market Price value as a %        |                                                                                                                                                                                                                                     |
      | "Market Price Date" label                   | Market price date                                                                                                                                                                                                                   |
      | Market Price Date value                     |                                                                                                                                                                                                                                     |
      | "YTM" label                                 | YTM                                                                                                                                                                                                                                 |
      | YTM value                                   |                                                                                                                                                                                                                                     |
      | "Duration" label                            | Duration                                                                                                                                                                                                                            |
      | Duration value                              |                                                                                                                                                                                                                                     |
      | "Issuer" label                              | Issuer                                                                                                                                                                                                                              |
      | Issuer value                                |                                                                                                                                                                                                                                     |
      | "Rating Moody’s" label                      | Rating Moody’s                                                                                                                                                                                                                      |
      | Rating Moody’s value                        |                                                                                                                                                                                                                                     |
      | "Rating S&P" label                          | Rating S&P                                                                                                                                                                                                                          |
      | "Rating S&P" value                          |                                                                                                                                                                                                                                     |
      | "Country of Risk" label                     | Country of risk                                                                                                                                                                                                                     |
      | Country of Risk value                       |                                                                                                                                                                                                                                     |
      | "Maturity Date" label                       | Maturity date                                                                                                                                                                                                                       |
      | Maturity Date value                         |                                                                                                                                                                                                                                     |
      | "Minimum investment amount" label           | Minimum investment amount                                                                                                                                                                                                           |
      | Minimum Piece value                         |                                                                                                                                                                                                                                     |
      | Disclaimer                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S344-AC2-AT2
  @DependsOn('login_in_as_userN_for_overview_subasset_Bonds')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Sub-Asset Class Holding detail page for Bonds (part 1)
    Given I am on the allocation holding details
    Then I can see ISO 3 code of allocation bonds holdings bonds currency

  @HK @SG @UK
  @S344-AC2-AT3
  @DependsOn('login_in_as_userN_for_overview_subasset_Bonds')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Market Price Date value/Maturity date value in Overview Sub-Asset Class Holding detail page for Bonds (part 1)
    Given I am on the allocation holding details
    Then I can see allocation holdings bonds date value Format is "dd Mmm yyyy"

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for overview currency Bonds
    Given I login as type "overview_allocation_currency_holding_detail_bonds"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S344-AC3-AT1
  @DependsOn('login_in_as_userN_for_overview_currency_Bonds')
  Scenario:Check the Overview Currency Holding detail page UI for Bonds (part 1)
    Given I am on the allocation holding details
    Then I am taken to a allocation bonds detailed holdings screen displaying the following data:
      | element name                                | element value                                                                                                                                                                                                                       |
      | Holding name value                          |                                                                                                                                                                                                                                     |
      | ISIN value                                  |                                                                                                                                                                                                                                     |
      | "Total value" label                         | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency             |                                                                                                                                                                                                                                     |
      | Total value in portfolio reporting currency |                                                                                                                                                                                                                                     |
      | "Accrued Interest" label                    | Accrued interest                                                                                                                                                                                                                    |
      | Accrued Interest value in holding currency  |                                                                                                                                                                                                                                     |
      | "Nominal Amount" label                      | Nominal amount                                                                                                                                                                                                                      |
      | Nominal Amount value in holding currency    |                                                                                                                                                                                                                                     |
      | "Average Purchase Price" label              | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price value as a %         |                                                                                                                                                                                                                                     |
      | "Last Buy Date" label                       | Last buy date                                                                                                                                                                                                                       |
      | Last Buy Date value                         |                                                                                                                                                                                                                                     |
      | "Indicative Market Price" label             | Indicative market price                                                                                                                                                                                                             |
      | Indicative Market Price value as a %        |                                                                                                                                                                                                                                     |
      | "Market Price Date" label                   | Market price date                                                                                                                                                                                                                   |
      | Market Price Date value                     |                                                                                                                                                                                                                                     |
      | "YTM" label                                 | YTM                                                                                                                                                                                                                                 |
      | YTM value                                   |                                                                                                                                                                                                                                     |
      | "Duration" label                            | Duration                                                                                                                                                                                                                            |
      | Duration value                              |                                                                                                                                                                                                                                     |
      | "Issuer" label                              | Issuer                                                                                                                                                                                                                              |
      | Issuer value                                |                                                                                                                                                                                                                                     |
      | "Rating Moody’s" label                      | Rating Moody’s                                                                                                                                                                                                                      |
      | Rating Moody’s value                        |                                                                                                                                                                                                                                     |
      | "Rating S&P" label                          | Rating S&P                                                                                                                                                                                                                          |
      | "Rating S&P" value                          |                                                                                                                                                                                                                                     |
      | "Country of Risk" label                     | Country of risk                                                                                                                                                                                                                     |
      | Country of Risk value                       |                                                                                                                                                                                                                                     |
      | "Maturity Date" label                       | Maturity date                                                                                                                                                                                                                       |
      | Maturity Date value                         |                                                                                                                                                                                                                                     |
      | "Minimum investment amount" label           | Minimum investment amount                                                                                                                                                                                                           |
      | Minimum Piece value                         |                                                                                                                                                                                                                                     |
      | Disclaimer                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S344-AC3-AT2
  @DependsOn('login_in_as_userN_for_overview_currency_Bonds')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Currency Holding detail page for Bonds (part 1)
    Given I am on the allocation holding details
    Then I can see ISO 3 code of allocation bonds holdings bonds currency

  @HK @SG @UK
  @S344-AC3-AT3
  @DependsOn('login_in_as_userN_for_overview_currency_Bonds')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Market Price Date value/Maturity date value in Overview Currency Holding detail page for Bonds (part 1)
    Given I am on the allocation holding details
    Then I can see allocation holdings bonds date value Format is "dd Mmm yyyy"

  @UK
  @SIT
  Scenario: login in as userN for overview region Bonds
    Given I login as type "overview_allocation_region_holding_detail_bonds"
    Then I should on the allocation holding details

  @UK
  @S344-AC4-AT1
  @DependsOn('login_in_as_userN_for_overview_region_Bonds')
  Scenario:Check the Overview Region Holding detail page UI for Bonds (part 1)
    Given I am on the allocation holding details
    Then I am taken to a allocation bonds detailed holdings screen displaying the following data:
      | element name                                | element value                                                                                                                                                                                                                       |
      | Holding name value                          |                                                                                                                                                                                                                                     |
      | ISIN value                                  |                                                                                                                                                                                                                                     |
      | "Total value" label                         | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency             |                                                                                                                                                                                                                                     |
      | Total value in portfolio reporting currency |                                                                                                                                                                                                                                     |
      | "Accrued Interest" label                    | Accrued interest                                                                                                                                                                                                                    |
      | Accrued Interest value in holding currency  |                                                                                                                                                                                                                                     |
      | "Nominal Amount" label                      | Nominal amount                                                                                                                                                                                                                      |
      | Nominal Amount value in holding currency    |                                                                                                                                                                                                                                     |
      | "Average Purchase Price" label              | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price value as a %         |                                                                                                                                                                                                                                     |
      | "Last Buy Date" label                       | Last buy date                                                                                                                                                                                                                       |
      | Last Buy Date value                         |                                                                                                                                                                                                                                     |
      | "Indicative Market Price" label             | Indicative market price                                                                                                                                                                                                             |
      | Indicative Market Price value as a %        |                                                                                                                                                                                                                                     |
      | "Market Price Date" label                   | Market price date                                                                                                                                                                                                                   |
      | Market Price Date value                     |                                                                                                                                                                                                                                     |
      | "YTM" label                                 | YTM                                                                                                                                                                                                                                 |
      | YTM value                                   |                                                                                                                                                                                                                                     |
      | "Duration" label                            | Duration                                                                                                                                                                                                                            |
      | Duration value                              |                                                                                                                                                                                                                                     |
      | "Issuer" label                              | Issuer                                                                                                                                                                                                                              |
      | Issuer value                                |                                                                                                                                                                                                                                     |
      | "Rating Moody’s" label                      | Rating Moody’s                                                                                                                                                                                                                      |
      | Rating Moody’s value                        |                                                                                                                                                                                                                                     |
      | "Rating S&P" label                          | Rating S&P                                                                                                                                                                                                                          |
      | "Rating S&P" value                          |                                                                                                                                                                                                                                     |
      | "Country of Risk" label                     | Country of risk                                                                                                                                                                                                                     |
      | Country of Risk value                       |                                                                                                                                                                                                                                     |
      | "Maturity Date" label                       | Maturity date                                                                                                                                                                                                                       |
      | Maturity Date value                         |                                                                                                                                                                                                                                     |
      | "Minimum investment amount" label           | Minimum investment amount                                                                                                                                                                                                           |
      | Minimum Piece value                         |                                                                                                                                                                                                                                     |
      | Disclaimer                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @UK
  @S344-AC4-AT2
  @DependsOn('login_in_as_userN_for_overview_region_Bonds')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Region Holding detail page for Bonds (part 1)
    Given I am on the allocation holding details
    Then I can see ISO 3 code of allocation bonds holdings bonds currency

  @UK
  @S344-AC4-AT3
  @DependsOn('login_in_as_userN_for_overview_region_Bonds')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Market Price Date value/Maturity date value in Overview Region Holding detail page for Bonds (part 1)
    Given I am on the allocation holding details
    Then I can see allocation holdings bonds date value Format is "dd Mmm yyyy"








  @HK @SG @UK
  @SIT
  Scenario: login in as userN for overview class Bonds2
    Given I login as type "overview_allocation_class_holding_detail_bonds2"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S344-AC1-AT1
  @DependsOn('login_in_as_userN_for_overview_class_Bonds2')
  Scenario:Check the Overview Asset Class Holding detail page UI for Bonds (part 2)
    Given I am on the allocation holding details
    Then I am taken to a detailed holdings bonds2 screen displaying the following data:
      | element name                                | element value                                                                                                                                                                                                                       |
      | Holding name value                          |                                                                                                                                                                                                                                     |
      | ISIN value                                  |                                                                                                                                                                                                                                     |
      | "Total value" label                         | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency             |                                                                                                                                                                                                                                     |
      | Total value in portfolio reporting currency |                                                                                                                                                                                                                                     |
      | "Accrued Profit" label                      | Accrued profit                                                                                                                                                                                                                      |
      | Accrued Profit value in holding currency    |                                                                                                                                                                                                                                     |
      | "Nominal Amount" label                      | Nominal amount                                                                                                                                                                                                                      |
      | Nominal Amount value in holding currency    |                                                                                                                                                                                                                                     |
      | "Average Purchase Price" label              | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price value as a %         |                                                                                                                                                                                                                                     |
      | "Last Buy Date" label                       | Last buy date                                                                                                                                                                                                                       |
      | Last Buy Date value                         |                                                                                                                                                                                                                                     |
      | "Indicative Market Price" label             | Indicative market price                                                                                                                                                                                                             |
      | Indicative Market Price value as a %        |                                                                                                                                                                                                                                     |
      | "Market Price Date" label                   | Market price date                                                                                                                                                                                                                   |
      | Market Price Date value                     |                                                                                                                                                                                                                                     |
      | "YTM" label                                 | YTM                                                                                                                                                                                                                                 |
      | YTM value                                   |                                                                                                                                                                                                                                     |
      | "Duration" label                            | Duration                                                                                                                                                                                                                            |
      | Duration value                              |                                                                                                                                                                                                                                     |
      | "Issuer" label                              | Issuer                                                                                                                                                                                                                              |
      | Issuer value                                |                                                                                                                                                                                                                                     |
      | "Rating Moody’s" label                      | Rating Moody’s                                                                                                                                                                                                                      |
      | Rating Moody’s value                        |                                                                                                                                                                                                                                     |
      | "Rating S&P" label                          | Rating S&P                                                                                                                                                                                                                          |
      | "Rating S&P" value                          |                                                                                                                                                                                                                                     |
      | "Country of Risk" label                     | Country of risk                                                                                                                                                                                                                     |
      | Country of Risk value                       |                                                                                                                                                                                                                                     |
      | "Maturity Date" label                       | Maturity date                                                                                                                                                                                                                       |
      | Maturity Date value                         |                                                                                                                                                                                                                                     |
      | "Minimum investment amount" label           | Minimum investment amount                                                                                                                                                                                                           |
      | Minimum Piece value                         |                                                                                                                                                                                                                                     |
      | Disclaimer                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S344-AC1-AT2
  @DependsOn('login_in_as_userN_for_overview_class_Bonds2')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Asset Class Holding detail page for Bonds (part 2)
    Given I am on the allocation holding details
    Then I can see ISO 3 code of holdings bonds2 currency

  @HK @SG @UK
  @S344-AC1-AT3
  @DependsOn('login_in_as_userN_for_overview_class_Bonds2')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Market Price Date value/Maturity date value in Overview Asset Class Holding detail page for Bonds (part 2)
    Given I am on the allocation holding details
    Then I can see holdings bonds2 date value Format is "dd MMM yyyy"

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for overview subasset Bonds2
    Given I login as type "overview_allocation_subasset_holding_detail_bonds2"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S344-AC2-AT1
  @DependsOn('login_in_as_userN_for_overview_subasset_Bonds2')
  Scenario:Check the Overview Sub-Asset Class Holding detail page UI for Bonds (part 2)
    Given I am on the allocation holding details
    Then I am taken to a detailed holdings bonds2 screen displaying the following data:
      | element name                                | element value                                                                                                                                                                                                                       |
      | Holding name value                          |                                                                                                                                                                                                                                     |
      | ISIN value                                  |                                                                                                                                                                                                                                     |
      | "Total value" label                         | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency             |                                                                                                                                                                                                                                     |
      | Total value in portfolio reporting currency |                                                                                                                                                                                                                                     |
      | "Accrued Profit" label                      | Accrued profit                                                                                                                                                                                                                      |
      | Accrued Profit value in holding currency    |                                                                                                                                                                                                                                     |
      | "Nominal Amount" label                      | Nominal amount                                                                                                                                                                                                                      |
      | Nominal Amount value in holding currency    |                                                                                                                                                                                                                                     |
      | "Average Purchase Price" label              | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price value as a %         |                                                                                                                                                                                                                                     |
      | "Last Buy Date" label                       | Last buy date                                                                                                                                                                                                                       |
      | Last Buy Date value                         |                                                                                                                                                                                                                                     |
      | "Indicative Market Price" label             | Indicative market price                                                                                                                                                                                                             |
      | Indicative Market Price value as a %        |                                                                                                                                                                                                                                     |
      | "Market Price Date" label                   | Market price date                                                                                                                                                                                                                   |
      | Market Price Date value                     |                                                                                                                                                                                                                                     |
      | "YTM" label                                 | YTM                                                                                                                                                                                                                                 |
      | YTM value                                   |                                                                                                                                                                                                                                     |
      | "Duration" label                            | Duration                                                                                                                                                                                                                            |
      | Duration value                              |                                                                                                                                                                                                                                     |
      | "Issuer" label                              | Issuer                                                                                                                                                                                                                              |
      | Issuer value                                |                                                                                                                                                                                                                                     |
      | "Rating Moody’s" label                      | Rating Moody’s                                                                                                                                                                                                                      |
      | Rating Moody’s value                        |                                                                                                                                                                                                                                     |
      | "Rating S&P" label                          | Rating S&P                                                                                                                                                                                                                          |
      | "Rating S&P" value                          |                                                                                                                                                                                                                                     |
      | "Country of Risk" label                     | Country of risk                                                                                                                                                                                                                     |
      | Country of Risk value                       |                                                                                                                                                                                                                                     |
      | "Maturity Date" label                       | Maturity date                                                                                                                                                                                                                       |
      | Maturity Date value                         |                                                                                                                                                                                                                                     |
      | "Minimum investment amount" label           | Minimum investment amount                                                                                                                                                                                                           |
      | Minimum Piece value                         |                                                                                                                                                                                                                                     |
      | Disclaimer                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S344-AC2-AT2
  @DependsOn('login_in_as_userN_for_overview_subasset_Bonds2')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Sub-Asset Class Holding detail page for Bonds (part 2)
    Given I am on the allocation holding details
    Then I can see ISO 3 code of holdings bonds2 currency

  @HK @SG @UK
  @S344-AC2-AT3
  @DependsOn('login_in_as_userN_for_overview_subasset_Bonds2')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Market Price Date value/Maturity date value in Overview Sub-Asset Class Holding detail page for Bonds (part 2)
    Given I am on the allocation holding details
    Then I can see holdings bonds2 date value Format is "dd MMM yyyy"

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for overview currency Bonds2
    Given I login as type "overview_allocation_currency_holding_detail_bonds2"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S344-AC3-AT1
  @DependsOn('login_in_as_userN_for_overview_currency_Bonds2')
  Scenario:Check the Overview Currency Holding detail page UI for Bonds (part 2)
    Given I am on the allocation holding details
    Then I am taken to a detailed holdings bonds2 screen displaying the following data:
      | element name                                | element value                                                                                                                                                                                                                       |
      | Holding name value                          |                                                                                                                                                                                                                                     |
      | ISIN value                                  |                                                                                                                                                                                                                                     |
      | "Total value" label                         | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency             |                                                                                                                                                                                                                                     |
      | Total value in portfolio reporting currency |                                                                                                                                                                                                                                     |
      | "Accrued Profit" label                      | Accrued profit                                                                                                                                                                                                                      |
      | Accrued Profit value in holding currency    |                                                                                                                                                                                                                                     |
      | "Nominal Amount" label                      | Nominal amount                                                                                                                                                                                                                      |
      | Nominal Amount value in holding currency    |                                                                                                                                                                                                                                     |
      | "Average Purchase Price" label              | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price value as a %         |                                                                                                                                                                                                                                     |
      | "Last Buy Date" label                       | Last buy date                                                                                                                                                                                                                       |
      | Last Buy Date value                         |                                                                                                                                                                                                                                     |
      | "Indicative Market Price" label             | Indicative market price                                                                                                                                                                                                             |
      | Indicative Market Price value as a %        |                                                                                                                                                                                                                                     |
      | "Market Price Date" label                   | Market price date                                                                                                                                                                                                                   |
      | Market Price Date value                     |                                                                                                                                                                                                                                     |
      | "YTM" label                                 | YTM                                                                                                                                                                                                                                 |
      | YTM value                                   |                                                                                                                                                                                                                                     |
      | "Duration" label                            | Duration                                                                                                                                                                                                                            |
      | Duration value                              |                                                                                                                                                                                                                                     |
      | "Issuer" label                              | Issuer                                                                                                                                                                                                                              |
      | Issuer value                                |                                                                                                                                                                                                                                     |
      | "Rating Moody’s" label                      | Rating Moody’s                                                                                                                                                                                                                      |
      | Rating Moody’s value                        |                                                                                                                                                                                                                                     |
      | "Rating S&P" label                          | Rating S&P                                                                                                                                                                                                                          |
      | "Rating S&P" value                          |                                                                                                                                                                                                                                     |
      | "Country of Risk" label                     | Country of risk                                                                                                                                                                                                                     |
      | Country of Risk value                       |                                                                                                                                                                                                                                     |
      | "Maturity Date" label                       | Maturity date                                                                                                                                                                                                                       |
      | Maturity Date value                         |                                                                                                                                                                                                                                     |
      | "Minimum investment amount" label           | Minimum investment amount                                                                                                                                                                                                           |
      | Minimum Piece value                         |                                                                                                                                                                                                                                     |
      | Disclaimer                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S344-AC3-AT2
  @DependsOn('login_in_as_userN_for_overview_currency_Bonds2')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Currency Holding detail page for Bonds (part 2)
    Given I am on the allocation holding details
    Then I can see ISO 3 code of holdings bonds2 currency

  @HK @SG @UK
  @S344-AC3-AT3
  @DependsOn('login_in_as_userN_for_overview_currency_Bonds2')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Market Price Date value/Maturity date value in Overview Currency Holding detail page for Bonds (part 2)
    Given I am on the allocation holding details
    Then I can see holdings bonds2 date value Format is "dd MMM yyyy"

  @UK
  @SIT
  Scenario: login in as userN for overview region Bonds2
    Given I login as type "overview_allocation_region_holding_detail_bonds2"
    Then I should on the allocation holding details

  @UK
  @S344-AC4-AT1
  @DependsOn('login_in_as_userN_for_overview_region_Bonds2')
  Scenario:Check the Overview Region Holding detail page UI for Bonds (part 2)
    Given I am on the allocation holding details
    Then I am taken to a detailed holdings bonds2 screen displaying the following data:
      | element name                                | element value                                                                                                                                                                                                                       |
      | Holding name value                          |                                                                                                                                                                                                                                     |
      | ISIN value                                  |                                                                                                                                                                                                                                     |
      | "Total value" label                         | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency             |                                                                                                                                                                                                                                     |
      | Total value in portfolio reporting currency |                                                                                                                                                                                                                                     |
      | "Accrued Profit" label                      | Accrued profit                                                                                                                                                                                                                      |
      | Accrued Profit value in holding currency    |                                                                                                                                                                                                                                     |
      | "Nominal Amount" label                      | Nominal amount                                                                                                                                                                                                                      |
      | Nominal Amount value in holding currency    |                                                                                                                                                                                                                                     |
      | "Average Purchase Price" label              | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price value as a %         |                                                                                                                                                                                                                                     |
      | "Last Buy Date" label                       | Last buy date                                                                                                                                                                                                                       |
      | Last Buy Date value                         |                                                                                                                                                                                                                                     |
      | "Indicative Market Price" label             | Indicative market price                                                                                                                                                                                                             |
      | Indicative Market Price value as a %        |                                                                                                                                                                                                                                     |
      | "Market Price Date" label                   | Market price date                                                                                                                                                                                                                   |
      | Market Price Date value                     |                                                                                                                                                                                                                                     |
      | "YTM" label                                 | YTM                                                                                                                                                                                                                                 |
      | YTM value                                   |                                                                                                                                                                                                                                     |
      | "Duration" label                            | Duration                                                                                                                                                                                                                            |
      | Duration value                              |                                                                                                                                                                                                                                     |
      | "Issuer" label                              | Issuer                                                                                                                                                                                                                              |
      | Issuer value                                |                                                                                                                                                                                                                                     |
      | "Rating Moody’s" label                      | Rating Moody’s                                                                                                                                                                                                                      |
      | Rating Moody’s value                        |                                                                                                                                                                                                                                     |
      | "Rating S&P" label                          | Rating S&P                                                                                                                                                                                                                          |
      | "Rating S&P" value                          |                                                                                                                                                                                                                                     |
      | "Country of Risk" label                     | Country of risk                                                                                                                                                                                                                     |
      | Country of Risk value                       |                                                                                                                                                                                                                                     |
      | "Maturity Date" label                       | Maturity date                                                                                                                                                                                                                       |
      | Maturity Date value                         |                                                                                                                                                                                                                                     |
      | "Minimum investment amount" label           | Minimum investment amount                                                                                                                                                                                                           |
      | Minimum Piece value                         |                                                                                                                                                                                                                                     |
      | Disclaimer                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @UK
  @S344-AC4-AT2
  @DependsOn('login_in_as_userN_for_overview_region_Bonds2')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Region Holding detail page for Bonds (part 2)
    Given I am on the allocation holding details
    Then I can see ISO 3 code of holdings bonds2 currency

  @UK
  @S344-AC4-AT3
  @DependsOn('login_in_as_userN_for_overview_region_Bonds2')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Market Price Date value/Maturity date value in Overview Region Holding detail page for Bonds (part 2)
    Given I am on the allocation holding details
    Then I can see holdings bonds2 date value Format is "dd MMM yyyy"