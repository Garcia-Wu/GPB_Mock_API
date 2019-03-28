@Epic_GPBM-1094(Holdings)
@Story_GPBM-3024 @Sprint6_iOS
@Story_GPBM-3023 @Sprint6_aOS
@Sprint19

Feature: Holdings details - Bonds - Portfolio level - Asset Allocation view

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio class Bonds
    Given I login as type "portfolio_allocation_class_holding_detail_bonds"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S398-AC1-AT1
  @DependsOn('login_in_as_userN_for_portfolio_class_Bonds')
  Scenario:Check the Portfolio Asset Class Holding detail page UI for Bonds (part 1)
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
  @S398-AC1-AT2
  @DependsOn('login_in_as_userN_for_portfolio_class_Bonds')
  Scenario:Check the ISO 3 code of Portfolio reference currency/holding currency in Portfolio Asset Class Holding detail page for Bonds (part 1)
    Given I am on the allocation holding details
    Then I can see ISO 3 code of allocation bonds holdings bonds currency

  @HK @SG @UK
  @S398-AC1-AT3
  @DependsOn('login_in_as_userN_for_portfolio_class_Bonds')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Market Price Date value/Maturity date value in Portfolio Asset Class Holding detail page for Bonds (part 1)
    Given I am on the allocation holding details
    Then I can see allocation holdings bonds date value Format is "dd Mmm yyyy"

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio subasset Bonds
    Given I login as type "portfolio_allocation_subasset_holding_detail_bonds"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S398-AC2-AT1
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Bonds')
  Scenario:Check the Portfolio Sub-Asset Class Holding detail page UI for Bonds (part 1)
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
  @S398-AC2-AT2
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Bonds')
  Scenario:Check the ISO 3 code of Portfolio reference currency/holding currency in Portfolio Sub-Asset Class Holding detail page for Bonds (part 1)
    Given I am on the allocation holding details
    Then I can see ISO 3 code of allocation bonds holdings bonds currency

  @HK @SG @UK
  @S398-AC2-AT3
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Bonds')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Market Price Date value/Maturity date value in Portfolio Sub-Asset Class Holding detail page for Bonds (part 1)
    Given I am on the allocation holding details
    Then I can see allocation holdings bonds date value Format is "dd Mmm yyyy"

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio currency Bonds
    Given I login as type "portfolio_allocation_currency_holding_detail_bonds"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S398-AC3-AT1
  @DependsOn('login_in_as_userN_for_portfolio_currency_Bonds')
  Scenario:Check the Portfolio Currency Holding detail page UI for Bonds (part 1)
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
  @S398-AC3-AT2
  @DependsOn('login_in_as_userN_for_portfolio_currency_Bonds')
  Scenario:Check the ISO 3 code of Portfolio reference currency/holding currency in Portfolio Currency Holding detail page for Bonds (part 1)
    Given I am on the allocation holding details
    Then I can see ISO 3 code of allocation bonds holdings bonds currency

  @HK @SG @UK
  @S398-AC3-AT3
  @DependsOn('login_in_as_userN_for_portfolio_currency_Bonds')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Market Price Date value/Maturity date value in Portfolio Currency Holding detail page for Bonds (part 1)
    Given I am on the allocation holding details
    Then I can see allocation holdings bonds date value Format is "dd Mmm yyyy"

  @UK
  @SIT
  Scenario: login in as userN for portfolio region Bonds
    Given I login as type "portfolio_allocation_region_holding_detail_bonds"
    Then I should on the allocation holding details

  @UK
  @S398-AC4-AT1
  @DependsOn('login_in_as_userN_for_portfolio_region_Bonds')
  Scenario:Check the Portfolio Region Holding detail page UI for Bonds (part 1)
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
  @S398-AC4-AT2
  @DependsOn('login_in_as_userN_for_portfolio_region_Bonds')
  Scenario:Check the ISO 3 code of Portfolio reference currency/holding currency in Portfolio Region Holding detail page for Bonds (part 1)
    Given I am on the allocation holding details
    Then I can see ISO 3 code of allocation bonds holdings bonds currency

  @UK
  @S398-AC4-AT3
  @DependsOn('login_in_as_userN_for_portfolio_region_Bonds')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Market Price Date value/Maturity date value in Portfolio Region Holding detail page for Bonds (part 1)
    Given I am on the allocation holding details
    Then I can see allocation holdings bonds date value Format is "dd Mmm yyyy"









  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio class Bonds2
    Given I login as type "portfolio_allocation_class_holding_detail_bonds2"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S398-AC1-AT1
  @DependsOn('login_in_as_userN_for_portfolio_class_Bonds2')
  Scenario:Check the Portfolio Asset Class Holding detail page UI for Bonds (part 2)
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
  @S398-AC1-AT2
  @DependsOn('login_in_as_userN_for_portfolio_class_Bonds2')
  Scenario:Check the ISO 3 code of Portfolio reference currency/holding currency in Portfolio Asset Class Holding detail page for Bonds (part 2)
    Given I am on the allocation holding details
    Then I can see ISO 3 code of holdings bonds2 currency

  @HK @SG @UK
  @S398-AC1-AT3
  @DependsOn('login_in_as_userN_for_portfolio_class_Bonds2')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Market Price Date value/Maturity date value in Portfolio Asset Class Holding detail page for Bonds (part 2)
    Given I am on the allocation holding details
    Then I can see holdings bonds2 date value Format is "dd MMM yyyy"

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio subasset Bonds2
    Given I login as type "portfolio_allocation_subasset_holding_detail_bonds2"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S398-AC2-AT1
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Bonds2')
  Scenario:Check the Portfolio Sub-Asset Class Holding detail page UI for Bonds (part 2)
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
  @S398-AC2-AT2
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Bonds2')
  Scenario:Check the ISO 3 code of Portfolio reference currency/holding currency in Portfolio Sub-Asset Class Holding detail page for Bonds (part 2)
    Given I am on the allocation holding details
    Then I can see ISO 3 code of holdings bonds2 currency

  @HK @SG @UK
  @S398-AC2-AT3
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Bonds2')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Market Price Date value/Maturity date value in Portfolio Sub-Asset Class Holding detail page for Bonds (part 2)
    Given I am on the allocation holding details
    Then I can see holdings bonds2 date value Format is "dd MMM yyyy"

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio currency Bonds2
    Given I login as type "portfolio_allocation_currency_holding_detail_bonds2"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S398-AC3-AT1
  @DependsOn('login_in_as_userN_for_portfolio_currency_Bonds2')
  Scenario:Check the Portfolio Currency Holding detail page UI for Bonds (part 2)
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
  @S398-AC3-AT2
  @DependsOn('login_in_as_userN_for_portfolio_currency_Bonds2')
  Scenario:Check the ISO 3 code of Portfolio reference currency/holding currency in Portfolio Currency Holding detail page for Bonds (part 2)
    Given I am on the allocation holding details
    Then I can see ISO 3 code of holdings bonds2 currency

  @HK @SG @UK
  @S398-AC3-AT3
  @DependsOn('login_in_as_userN_for_portfolio_currency_Bonds2')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Market Price Date value/Maturity date value in Portfolio Currency Holding detail page for Bonds (part 2)
    Given I am on the allocation holding details
    Then I can see holdings bonds2 date value Format is "dd MMM yyyy"

  @UK
  @SIT
  Scenario: login in as userN for portfolio region Bonds2
    Given I login as type "portfolio_allocation_region_holding_detail_bonds2"
    Then I should on the allocation holding details

  @UK
  @S398-AC4-AT1
  @DependsOn('login_in_as_userN_for_portfolio_region_Bonds2')
  Scenario:Check the Portfolio Region Holding detail page UI for Bonds (part 2)
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
  @S398-AC4-AT2
  @DependsOn('login_in_as_userN_for_portfolio_region_Bonds2')
  Scenario:Check the ISO 3 code of Portfolio reference currency/holding currency in Portfolio Region Holding detail page for Bonds (part 2)
    Given I am on the allocation holding details
    Then I can see ISO 3 code of holdings bonds2 currency

  @UK
  @S398-AC4-AT3
  @DependsOn('login_in_as_userN_for_portfolio_region_Bonds2')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Market Price Date value/Maturity date value in Portfolio Region Holding detail page for Bonds (part 2)
    Given I am on the allocation holding details
    Then I can see holdings bonds2 date value Format is "dd MMM yyyy"