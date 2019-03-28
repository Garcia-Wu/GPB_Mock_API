@Epic_GPBM-1094(Holdings)
@Story_GPBM-3022 @Sprint6_iOS
@Story_GPBM-3021 @Sprint6_aOS
@Sprint19

Feature: Holdings details - Deposits - Portfolio level - Asset Allocation view

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio class Deposits1
    Given I login as type "portfolio_allocation_class_holding_detail_deposits"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S397-AC1-AT1
  @DependsOn('login_in_as_userN_for_portfolio_class_Deposits1')
  Scenario:Check the Portfolio Asset Class Holding detail page UI for Deposits
    Given I am on the allocation holding details
    Then I am taken to a allocation Deposits1 detailed holdings deposits1 screen displaying the following data:
      | element name                                | element value                                                                                                                                                                                                                       |
      | Holding name value                          |                                                                                                                                                                                                                                     |
      | Reference value                             |                                                                                                                                                                                                                                     |
      | Total value label                           | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency             |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | Accrued Interest label                      | Accrued interest                                                                                                                                                                                                                    |
      | Accrued Interest value in holding currency  |                                                                                                                                                                                                                                     |
#      | Amount At Maturity label                     | Amount At Maturity                                                                                                                                           |
#      | Amount At Maturity value in holding currency |                                                                                                                                                              |
      | Balance label                               | Balance                                                                                                                                                                                                                             |
      | Balance value                               |                                                                                                                                                                                                                                     |
      | Maturity Date label                         | Maturity date                                                                                                                                                                                                                       |
      | Maturity date value                         |                                                                                                                                                                                                                                     |
      | Disclaimer                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S397-AC1-AT2
  @DependsOn('login_in_as_userN_for_portfolio_class_Deposits1')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Asset Class Holding detail page for Deposits
    Given I am on the allocation holding details
    Then I can see ISO 3 code of allocation holdings deposits1 currency

  @HK @SG @UK
  @S397-AC1-AT3
  @DependsOn('login_in_as_userN_for_portfolio_class_Deposits1')
  Scenario:Check the dd Mmm yyyy format of Maturity date value in Portfolio Asset Class Holding detail page for Deposits
    Given I am on the allocation holding details
    Then I can see allocation holdings deposits1 date value Format is "dd MMM yyyy"

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio subasset Deposits1
    Given I login as type "portfolio_allocation_subasset_holding_detail_deposits"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S397-AC2-AT1
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Deposits1')
  Scenario:Check the Portfolio Sub-Asset Class Holding detail page UI for Deposits
    Given I am on the allocation holding details
    Then I am taken to a allocation Deposits1 detailed holdings deposits1 screen displaying the following data:
      | element name                                | element value                                                                                                                                                                                                                       |
      | Holding name value                          |                                                                                                                                                                                                                                     |
      | Reference value                             |                                                                                                                                                                                                                                     |
      | Total value label                           | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency             |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | Accrued Interest label                      | Accrued interest                                                                                                                                                                                                                    |
      | Accrued Interest value in holding currency  |                                                                                                                                                                                                                                     |
#      | Amount At Maturity label                     | Amount At Maturity                                                                                                                                           |
#      | Amount At Maturity value in holding currency |                                                                                                                                                              |
      | Balance label                               | Balance                                                                                                                                                                                                                             |
      | Balance value                               |                                                                                                                                                                                                                                     |
      | Maturity Date label                         | Maturity date                                                                                                                                                                                                                       |
      | Maturity date value                         |                                                                                                                                                                                                                                     |
      | Disclaimer                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S397-AC2-AT2
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Deposits1')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Sub-Asset Class Holding detail page for Deposits
    Given I am on the allocation holding details
    Then I can see ISO 3 code of allocation holdings deposits1 currency

  @HK @SG @UK
  @S397-AC2-AT3
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Deposits1')
  Scenario:Check the dd Mmm yyyy format of Maturity date value in Portfolio Sub-Asset Class Holding detail page for Deposits
    Given I am on the allocation holding details
    Then I can see allocation holdings deposits1 date value Format is "dd MMM yyyy"

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio currency Deposits1
    Given I login as type "portfolio_allocation_currency_holding_detail_deposits"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S397-AC3-AT1
  @DependsOn('login_in_as_userN_for_portfolio_currency_Deposits1')
  Scenario:Check the Portfolio Currency Holding detail page UI for Deposits
    Given I am on the allocation holding details
    Then I am taken to a allocation Deposits1 detailed holdings deposits1 screen displaying the following data:
      | element name                                | element value                                                                                                                                                                                                                       |
      | Holding name value                          |                                                                                                                                                                                                                                     |
      | Reference value                             |                                                                                                                                                                                                                                     |
      | Total value label                           | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency             |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | Accrued Interest label                      | Accrued interest                                                                                                                                                                                                                    |
      | Accrued Interest value in holding currency  |                                                                                                                                                                                                                                     |
#      | Amount At Maturity label                     | Amount At Maturity                                                                                                                                           |
#      | Amount At Maturity value in holding currency |                                                                                                                                                              |
      | Balance label                               | Balance                                                                                                                                                                                                                             |
      | Balance value                               |                                                                                                                                                                                                                                     |
      | Maturity Date label                         | Maturity date                                                                                                                                                                                                                       |
      | Maturity date value                         |                                                                                                                                                                                                                                     |
      | Disclaimer                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S397-AC3-AT2
  @DependsOn('login_in_as_userN_for_portfolio_currency_Deposits1')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Currency Holding detail page for Deposits
    Given I am on the allocation holding details
    Then I can see ISO 3 code of allocation holdings deposits1 currency

  @HK @SG @UK
  @S397-AC3-AT3
  @DependsOn('login_in_as_userN_for_portfolio_currency_Deposits1')
  Scenario:Check the dd Mmm yyyy format of Maturity date value in Portfolio Currency Holding detail page for Deposits
    Given I am on the allocation holding details
    Then I can see allocation holdings deposits1 date value Format is "dd MMM yyyy"

  @UK
  @SIT
  Scenario: login in as userN for portfolio region Deposits1
    Given I login as type "portfolio_allocation_region_holding_detail_deposits"
    Then I should on the allocation holding details

  @UK
  @S397-AC4-AT1
  @DependsOn('login_in_as_userN_for_portfolio_region_Deposits1')
  Scenario:Check the Portfolio Region Holding detail page UI for Deposits
    Given I am on the allocation holding details
    Then I am taken to a allocation Deposits1 detailed holdings deposits1 screen displaying the following data:
      | element name                                | element value                                                                                                                                                                                                                       |
      | Holding name value                          |                                                                                                                                                                                                                                     |
      | Reference value                             |                                                                                                                                                                                                                                     |
      | Total value label                           | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency             |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | Accrued Interest label                      | Accrued interest                                                                                                                                                                                                                    |
      | Accrued Interest value in holding currency  |                                                                                                                                                                                                                                     |
#      | Amount At Maturity label                     | Amount At Maturity                                                                                                                                           |
#      | Amount At Maturity value in holding currency |                                                                                                                                                              |
      | Balance label                               | Balance                                                                                                                                                                                                                             |
      | Balance value                               |                                                                                                                                                                                                                                     |
      | Maturity Date label                         | Maturity date                                                                                                                                                                                                                       |
      | Maturity date value                         |                                                                                                                                                                                                                                     |
      | Disclaimer                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @UK
  @S397-AC4-AT2
  @DependsOn('login_in_as_userN_for_portfolio_region_Deposits1')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Region Holding detail page for Deposits
    Given I am on the allocation holding details
    Then I can see ISO 3 code of allocation holdings deposits1 currency

  @UK
  @S397-AC4-AT3
  @DependsOn('login_in_as_userN_for_portfolio_region_Deposits1')
  Scenario:Check the dd Mmm yyyy format of Maturity date value in Portfolio Region Holding detail page for Deposits
    Given I am on the allocation holding details
    Then I can see allocation holdings deposits1 date value Format is "dd MMM yyyy"

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio class Deposits2
    Given I login as type "portfolio_allocation_class_holding_detail_deposits2"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S397-AC5-AT1
  @DependsOn('login_in_as_userN_for_portfolio_class_Deposits2')
  Scenario:Check the Portfolio Asset Class Holding detail page UI for Short Term Investments
    Given I am on the allocation holding details
    Then I am taken to a allocation detailed holdings deposits2 screen displaying the following data:
      | element name                                       | element value                                                                                                                                                                                                                       |
      | Holding name value                                 |                                                                                                                                                                                                                                     |
      | Reference value                                    |                                                                                                                                                                                                                                     |
      | Total value label                                  | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency                    |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency        |                                                                                                                                                                                                                                     |
      | Unrealised P/L label                               | Unrealised P/L                                                                                                                                                                                                                      |
      | Profit/Loss value as a % based on holding currency |                                                                                                                                                                                                                                     |
      | Accrued Interest label                             | Accrued interest                                                                                                                                                                                                                    |
      | Accrued Interest value in holding currency         |                                                                                                                                                                                                                                     |
      | Balance label                                      | Balance                                                                                                                                                                                                                             |
      | Balance value                                      |                                                                                                                                                                                                                                     |
      | Average Price label                                | Average price                                                                                                                                                                                                                       |
      | Average Price value in holding currency            |                                                                                                                                                                                                                                     |
      | Last Purchase Date                                 | Last purchase date                                                                                                                                                                                                                  |
      | Last Purchase Date value                           |                                                                                                                                                                                                                                     |
#      | Amount At Maturity label                           | Amount At Maturity                                                                                                                                           |
#      | Amount At Maturity value in holding currency       |                                                                                                                                                              |
      | Maturity Date label                                | Maturity date                                                                                                                                                                                                                       |
      | Maturity date value                                |                                                                                                                                                                                                                                     |
      | Disclaimer                                         | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S397-AC5-AT2
  @DependsOn('login_in_as_userN_for_portfolio_class_Deposits2')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Asset Class Holding detail page for Short Term Investments
    Given I am on the allocation holding details
    Then I can see ISO 3 code of allocation holdings deposits2 currency

  @HK @SG @UK
  @S397-AC5-AT3
  @DependsOn('login_in_as_userN_for_portfolio_class_Deposits2')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Maturity date value in Portfolio Asset Class Holding detail page for Short Term Investments
    Given I am on the allocation holding details
    Then I can see allocation holdings deposits2 date value Format is "dd MMM yyyy"

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio subasset Deposits2
    Given I login as type "portfolio_allocation_subasset_holding_detail_deposits2"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S397-AC6-AT1
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Deposits2')
  Scenario:Check the Portfolio Sub-Asset Class Holding detail page UI for Short Term Investments
    Given I am on the allocation holding details
    Then I am taken to a allocation detailed holdings deposits2 screen displaying the following data:
      | element name                                       | element value                                                                                                                                                                                                                       |
      | Holding name value                                 |                                                                                                                                                                                                                                     |
      | Reference value                                    |                                                                                                                                                                                                                                     |
      | Total value label                                  | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency                    |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency        |                                                                                                                                                                                                                                     |
      | Unrealised P/L label                               | Unrealised P/L                                                                                                                                                                                                                      |
      | Profit/Loss value as a % based on holding currency |                                                                                                                                                                                                                                     |
      | Accrued Interest label                             | Accrued interest                                                                                                                                                                                                                    |
      | Accrued Interest value in holding currency         |                                                                                                                                                                                                                                     |
      | Balance label                                      | Balance                                                                                                                                                                                                                             |
      | Balance value                                      |                                                                                                                                                                                                                                     |
      | Average Price label                                | Average price                                                                                                                                                                                                                       |
      | Average Price value in holding currency            |                                                                                                                                                                                                                                     |
      | Last Purchase Date                                 | Last purchase date                                                                                                                                                                                                                  |
      | Last Purchase Date value                           |                                                                                                                                                                                                                                     |
#      | Amount At Maturity label                           | Amount At Maturity                                                                                                                                           |
#      | Amount At Maturity value in holding currency       |                                                                                                                                                              |
      | Maturity Date label                                | Maturity date                                                                                                                                                                                                                       |
      | Maturity date value                                |                                                                                                                                                                                                                                     |
      | Disclaimer                                         | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S397-AC6-AT2
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Deposits2')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Sub-Asset Class Holding detail page for Short Term Investments
    Given I am on the allocation holding details
    Then I can see ISO 3 code of allocation holdings deposits2 currency

  @HK @SG @UK
  @S397-AC6-AT3
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Deposits2')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Maturity date value in Portfolio Sub-Asset Class Holding detail page for Short Term Investments
    Given I am on the allocation holding details
    Then I can see allocation holdings deposits2 date value Format is "dd MMM yyyy"

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio currency Deposits2
    Given I login as type "portfolio_allocation_currency_holding_detail_deposits2"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S397-AC7-AT1
  @DependsOn('login_in_as_userN_for_portfolio_currency_Deposits2')
  Scenario:Check the Portfolio Currency Holding detail page UI for Short Term Investments
    Given I am on the allocation holding details
    Then I am taken to a allocation detailed holdings deposits2 screen displaying the following data:
      | element name                                       | element value                                                                                                                                                                                                                       |
      | Holding name value                                 |                                                                                                                                                                                                                                     |
      | Reference value                                    |                                                                                                                                                                                                                                     |
      | Total value label                                  | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency                    |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency        |                                                                                                                                                                                                                                     |
      | Unrealised P/L label                               | Unrealised P/L                                                                                                                                                                                                                      |
      | Profit/Loss value as a % based on holding currency |                                                                                                                                                                                                                                     |
      | Accrued Interest label                             | Accrued interest                                                                                                                                                                                                                    |
      | Accrued Interest value in holding currency         |                                                                                                                                                                                                                                     |
      | Balance label                                      | Balance                                                                                                                                                                                                                             |
      | Balance value                                      |                                                                                                                                                                                                                                     |
      | Average Price label                                | Average price                                                                                                                                                                                                                       |
      | Average Price value in holding currency            |                                                                                                                                                                                                                                     |
      | Last Purchase Date                                 | Last purchase date                                                                                                                                                                                                                  |
      | Last Purchase Date value                           |                                                                                                                                                                                                                                     |
#      | Amount At Maturity label                           | Amount At Maturity                                                                                                                                           |
#      | Amount At Maturity value in holding currency       |                                                                                                                                                              |
      | Maturity Date label                                | Maturity date                                                                                                                                                                                                                       |
      | Maturity date value                                |                                                                                                                                                                                                                                     |
      | Disclaimer                                         | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S397-AC7-AT2
  @DependsOn('login_in_as_userN_for_portfolio_currency_Deposits2')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Currency Holding detail page for Short Term Investments
    Given I am on the allocation holding details
    Then I can see ISO 3 code of allocation holdings deposits2 currency

  @HK @SG @UK
  @S397-AC7-AT3
  @DependsOn('login_in_as_userN_for_portfolio_currency_Deposits2')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Maturity date value in Portfolio Currency Holding detail page for Short Term Investments
    Given I am on the allocation holding details
    Then I can see allocation holdings deposits2 date value Format is "dd MMM yyyy"

  @UK
  @SIT
  Scenario: login in as userN for portfolio region Deposits2
    Given I login as type "portfolio_allocation_region_holding_detail_deposits2"
    Then I should on the allocation holding details

  @UK
  @S397-AC8-AT1
  @DependsOn('login_in_as_userN_for_portfolio_region_Deposits2')
  Scenario:Check the Portfolio Region Holding detail page UI for Short Term Investments
    Given I am on the allocation holding details
    Then I am taken to a allocation detailed holdings deposits2 screen displaying the following data:
      | element name                                       | element value                                                                                                                                                                                                                       |
      | Holding name value                                 |                                                                                                                                                                                                                                     |
      | Reference value                                    |                                                                                                                                                                                                                                     |
      | Total value label                                  | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency                    |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency        |                                                                                                                                                                                                                                     |
      | Unrealised P/L label                               | Unrealised P/L                                                                                                                                                                                                                      |
      | Profit/Loss value as a % based on holding currency |                                                                                                                                                                                                                                     |
      | Accrued Interest label                             | Accrued interest                                                                                                                                                                                                                    |
      | Accrued Interest value in holding currency         |                                                                                                                                                                                                                                     |
      | Balance label                                      | Balance                                                                                                                                                                                                                             |
      | Balance value                                      |                                                                                                                                                                                                                                     |
      | Average Price label                                | Average price                                                                                                                                                                                                                       |
      | Average Price value in holding currency            |                                                                                                                                                                                                                                     |
      | Last Purchase Date                                 | Last purchase date                                                                                                                                                                                                                  |
      | Last Purchase Date value                           |                                                                                                                                                                                                                                     |
#      | Amount At Maturity label                           | Amount At Maturity                                                                                                                                           |
#      | Amount At Maturity value in holding currency       |                                                                                                                                                              |
      | Maturity Date label                                | Maturity date                                                                                                                                                                                                                       |
      | Maturity date value                                |                                                                                                                                                                                                                                     |
      | Disclaimer                                         | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @UK
  @S397-AC8-AT2
  @DependsOn('login_in_as_userN_for_portfolio_region_Deposits2')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Region Holding detail page for Short Term Investments
    Given I am on the allocation holding details
    Then I can see ISO 3 code of allocation holdings deposits2 currency

  @UK
  @S397-AC8-AT3
  @DependsOn('login_in_as_userN_for_portfolio_region_Deposits2')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Maturity date value in Portfolio Region Holding detail page for Short Term Investments
    Given I am on the allocation holding details
    Then I can see allocation holdings deposits2 date value Format is "dd MMM yyyy"

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio class Deposits3
    Given I login as type "portfolio_allocation_class_holding_detail_deposits3"
    Then I should on the allocation holding details

#    Scenario: Viewing Holdings detail page for Call deposits
  @HK @SG @UK
  @S397-AC9-AT1
  @DependsOn('login_in_as_userN_for_portfolio_class_Deposits3')
  Scenario:Check the Portfolio Asset Class Holding detail page UI for Call deposits
    Given I am on the allocation holding details
    Then I am taken to a allocation deposits3 detailed holdings screen displaying the following data:
      | element name                                | element value                                                                                                                                                                                                                       |
      | Holding name value                          |                                                                                                                                                                                                                                     |
      | Reference value                             |                                                                                                                                                                                                                                     |
      | Total value label                           | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency             |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | Accrued Interest label                      | Accrued interest                                                                                                                                                                                                                    |
      | Accrued Interest value in holding currency  |                                                                                                                                                                                                                                     |
      | Balance label                               | Balance                                                                                                                                                                                                                             |
      | Balance value                               |                                                                                                                                                                                                                                     |
      | Disclaimer                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S397-AC9-AT2
  @DependsOn('login_in_as_userN_for_portfolio_class_Deposits3')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Asset Class Holding detail page for Call deposits
    Given I am on the allocation holding details
    Then I can see ISO 3 code of allocation holdings deposits3 currency

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio subasset Deposits3
    Given I login as type "portfolio_allocation_subasset_holding_detail_deposits3"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S397-AC10-AT1
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Deposits3')
  Scenario:Check the Portfolio Sub-Asset Class Holding detail page UI for Call deposits
    Given I am on the allocation holding details
    Then I am taken to a allocation deposits3 detailed holdings screen displaying the following data:
      | element name                                | element value                                                                                                                                                                                                                       |
      | Holding name value                          |                                                                                                                                                                                                                                     |
      | Reference value                             |                                                                                                                                                                                                                                     |
      | Total value label                           | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency             |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | Accrued Interest label                      | Accrued interest                                                                                                                                                                                                                    |
      | Accrued Interest value in holding currency  |                                                                                                                                                                                                                                     |
      | Balance label                               | Balance                                                                                                                                                                                                                             |
      | Balance value                               |                                                                                                                                                                                                                                     |
      | Disclaimer                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S397-AC10-AT2
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Deposits3')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Sub-Asset Class Holding detail page for Call deposits
    Given I am on the allocation holding details
    Then I can see ISO 3 code of allocation holdings deposits3 currency

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio currency Deposits3
    Given I login as type "portfolio_allocation_currency_holding_detail_deposits3"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S397-AC11-AT1
  @DependsOn('login_in_as_userN_for_portfolio_currency_Deposits3')
  Scenario:Check the Portfolio Currency Holding detail page UI for Call deposits
    Given I am on the allocation holding details
    Then I am taken to a allocation deposits3 detailed holdings screen displaying the following data:
      | element name                                | element value                                                                                                                                                                                                                       |
      | Holding name value                          |                                                                                                                                                                                                                                     |
      | Reference value                             |                                                                                                                                                                                                                                     |
      | Total value label                           | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency             |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | Accrued Interest label                      | Accrued interest                                                                                                                                                                                                                    |
      | Accrued Interest value in holding currency  |                                                                                                                                                                                                                                     |
      | Balance label                               | Balance                                                                                                                                                                                                                             |
      | Balance value                               |                                                                                                                                                                                                                                     |
      | Disclaimer                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S397-AC11-AT2
  @DependsOn('login_in_as_userN_for_portfolio_currency_Deposits3')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Currency Holding detail page for Call deposits
    Given I am on the allocation holding details
    Then I can see ISO 3 code of allocation holdings deposits3 currency

  @UK
  @SIT
  Scenario: login in as userN for portfolio region Deposits3
    Given I login as type "portfolio_allocation_region_holding_detail_deposits3"
    Then I should on the allocation holding details

  @UK
  @S397-AC12-AT1
  @DependsOn('login_in_as_userN_for_portfolio_region_Deposits3')
  Scenario:Check the Portfolio Region Holding detail page UI for Call deposits
    Given I am on the allocation holding details
    Then I am taken to a allocation deposits3 detailed holdings screen displaying the following data:
      | element name                                | element value                                                                                                                                                                                                                       |
      | Holding name value                          |                                                                                                                                                                                                                                     |
      | Reference value                             |                                                                                                                                                                                                                                     |
      | Total value label                           | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency             |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | Accrued Interest label                      | Accrued interest                                                                                                                                                                                                                    |
      | Accrued Interest value in holding currency  |                                                                                                                                                                                                                                     |
      | Balance label                               | Balance                                                                                                                                                                                                                             |
      | Balance value                               |                                                                                                                                                                                                                                     |
      | Disclaimer                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @UK
  @S397-AC12-AT2
  @DependsOn('login_in_as_userN_for_portfolio_region_Deposits3')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Region Holding detail page for Call deposits
    Given I am on the allocation holding details
    Then I can see ISO 3 code of allocation holdings deposits3 currency

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio class Deposits4
    Given I login as type "portfolio_allocation_class_holding_detail_deposits4"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S397-AC13-AT1
  @DependsOn('login_in_as_userN_for_portfolio_class_Deposits4')
  Scenario:Check the Portfolio Asset Class Holding detail page UI for Murabaha Deposits
    Given I am on the allocation holding details
    Then I am taken to a allocation deposits4 detailed holdings screen displaying the following data:
      | element name                                | element value                                                                                                                                                                                                                       |
      | Holding name value                          |                                                                                                                                                                                                                                     |
      | ISIN value                                  |                                                                                                                                                                                                                                     |
      | Total value label                           | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency             |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | Accrued Profit label                        | Accrued profit                                                                                                                                                                                                                      |
      | Accrued Profit value in holding currency    |                                                                                                                                                                                                                                     |
      | Balance label                               | Balance                                                                                                                                                                                                                             |
      | Balance value                               |                                                                                                                                                                                                                                     |
#      | Amount At Maturity label                     | mount At Maturity                                                                                                                                            |
#      | Amount At Maturity value in holding currency |                                                                                                                                                              |
      | Maturity Date label                         | Maturity date                                                                                                                                                                                                                       |
      | Maturity date value                         |                                                                                                                                                                                                                                     |
      | Average Price label                         | Average price                                                                                                                                                                                                                       |
      | Average Price value in holding currency     |                                                                                                                                                                                                                                     |
      | Last Purchase Date                          | Last purchase date                                                                                                                                                                                                                  |
      | Last Purchase Date value                    |                                                                                                                                                                                                                                     |
      | Disclaimer                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S397-AC13-AT2
  @DependsOn('login_in_as_userN_for_portfolio_class_Deposits4')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Asset Class Holding detail page for Murabaha Deposits
    Given I am on the allocation holding details
    Then I can see ISO 3 code of allocation holdings deposits4 currency

  @HK @SG @UK
  @S397-AC13-AT3
  @DependsOn('login_in_as_userN_for_portfolio_class_Deposits4')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Maturity date value in Portfolio Asset Class Holding detail page for Murabaha Deposits
    Given I am on the allocation holding details
    Then I can see allocation holdings deposits4 date value Format is "dd MMM yyyy"

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio subasset Deposits4
    Given I login as type "portfolio_allocation_subasset_holding_detail_deposits4"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S397-AC14-AT1
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Deposits4')
  Scenario:Check the Portfolio Sub-Asset Class Holding detail page UI for Murabaha Deposits
    Given I am on the allocation holding details
    Then I am taken to a allocation deposits4 detailed holdings screen displaying the following data:
      | element name                                | element value                                                                                                                                                                                                                       |
      | Holding name value                          |                                                                                                                                                                                                                                     |
      | ISIN value                                  |                                                                                                                                                                                                                                     |
      | Total value label                           | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency             |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | Accrued Profit label                        | Accrued profit                                                                                                                                                                                                                      |
      | Accrued Profit value in holding currency    |                                                                                                                                                                                                                                     |
      | Balance label                               | Balance                                                                                                                                                                                                                             |
      | Balance value                               |                                                                                                                                                                                                                                     |
#      | Amount At Maturity label                     | mount At Maturity                                                                                                                                            |
#      | Amount At Maturity value in holding currency |                                                                                                                                                              |
      | Maturity Date label                         | Maturity date                                                                                                                                                                                                                       |
      | Maturity date value                         |                                                                                                                                                                                                                                     |
      | Average Price label                         | Average price                                                                                                                                                                                                                       |
      | Average Price value in holding currency     |                                                                                                                                                                                                                                     |
      | Last Purchase Date                          | Last purchase date                                                                                                                                                                                                                  |
      | Last Purchase Date value                    |                                                                                                                                                                                                                                     |
      | Disclaimer                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S397-AC14-AT2
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Deposits4')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Sub-Asset Class Holding detail page for Murabaha Deposits
    Given I am on the allocation holding details
    Then I can see ISO 3 code of allocation holdings deposits4 currency

  @HK @SG @UK
  @S397-AC14-AT3
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Deposits4')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Maturity date value in Portfolio Sub-Asset Class Holding detail page for Murabaha Deposits
    Given I am on the allocation holding details
    Then I can see allocation holdings deposits4 date value Format is "dd MMM yyyy"

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio currency Deposits4
    Given I login as type "portfolio_allocation_currency_holding_detail_deposits4"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S397-AC15-AT1
  @DependsOn('login_in_as_userN_for_portfolio_currency_Deposits4')
  Scenario:Check the Portfolio Currency Holding detail page UI for Murabaha Deposits
    Given I am on the allocation holding details
    Then I am taken to a allocation deposits4 detailed holdings screen displaying the following data:
      | element name                                | element value                                                                                                                                                                                                                       |
      | Holding name value                          |                                                                                                                                                                                                                                     |
      | ISIN value                                  |                                                                                                                                                                                                                                     |
      | Total value label                           | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency             |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | Accrued Profit label                        | Accrued profit                                                                                                                                                                                                                      |
      | Accrued Profit value in holding currency    |                                                                                                                                                                                                                                     |
      | Balance label                               | Balance                                                                                                                                                                                                                             |
      | Balance value                               |                                                                                                                                                                                                                                     |
#      | Amount At Maturity label                     | mount At Maturity                                                                                                                                            |
#      | Amount At Maturity value in holding currency |                                                                                                                                                              |
      | Maturity Date label                         | Maturity date                                                                                                                                                                                                                       |
      | Maturity date value                         |                                                                                                                                                                                                                                     |
      | Average Price label                         | Average price                                                                                                                                                                                                                       |
      | Average Price value in holding currency     |                                                                                                                                                                                                                                     |
      | Last Purchase Date                          | Last purchase date                                                                                                                                                                                                                  |
      | Last Purchase Date value                    |                                                                                                                                                                                                                                     |
      | Disclaimer                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S397-AC15-AT2
  @DependsOn('login_in_as_userN_for_portfolio_currency_Deposits4')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Currency Holding detail page for Murabaha Deposits
    Given I am on the allocation holding details
    Then I can see ISO 3 code of allocation holdings deposits4 currency

  @HK @SG @UK
  @S397-AC15-AT3
  @DependsOn('login_in_as_userN_for_portfolio_currency_Deposits4')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Maturity date value in Portfolio Currency Holding detail page for Murabaha Deposits
    Given I am on the allocation holding details
    Then I can see allocation holdings deposits4 date value Format is "dd MMM yyyy"

  @UK
  @SIT
  Scenario: login in as userN for portfolio region Deposits4
    Given I login as type "portfolio_allocation_region_holding_detail_deposits4"
    Then I should on the allocation holding details

  @UK
  @S397-AC16-AT1
  @DependsOn('login_in_as_userN_for_portfolio_region_Deposits4')
  Scenario:Check the Portfolio Region Holding detail page UI for Murabaha Deposits
    Given I am on the allocation holding details
    Then I am taken to a allocation deposits4 detailed holdings screen displaying the following data:
      | element name                                | element value                                                                                                                                                                                                                       |
      | Holding name value                          |                                                                                                                                                                                                                                     |
      | ISIN value                                  |                                                                                                                                                                                                                                     |
      | Total value label                           | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency             |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | Accrued Profit label                        | Accrued profit                                                                                                                                                                                                                      |
      | Accrued Profit value in holding currency    |                                                                                                                                                                                                                                     |
      | Balance label                               | Balance                                                                                                                                                                                                                             |
      | Balance value                               |                                                                                                                                                                                                                                     |
#      | Amount At Maturity label                     | mount At Maturity                                                                                                                                            |
#      | Amount At Maturity value in holding currency |                                                                                                                                                              |
      | Maturity Date label                         | Maturity date                                                                                                                                                                                                                       |
      | Maturity date value                         |                                                                                                                                                                                                                                     |
      | Average Price label                         | Average price                                                                                                                                                                                                                       |
      | Average Price value in holding currency     |                                                                                                                                                                                                                                     |
      | Last Purchase Date                          | Last purchase date                                                                                                                                                                                                                  |
      | Last Purchase Date value                    |                                                                                                                                                                                                                                     |
      | Disclaimer                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @UK
  @S397-AC16-AT2
  @DependsOn('login_in_as_userN_for_portfolio_region_Deposits4')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Region Holding detail page for Murabaha Deposits
    Given I am on the allocation holding details
    Then I can see ISO 3 code of allocation holdings deposits4 currency

  @UK
  @S397-AC16-AT3
  @DependsOn('login_in_as_userN_for_portfolio_region_Deposits4')
  Scenario:Check the dd Mmm yyyy format of Last Buy Date value/Maturity date value in Portfolio Region Holding detail page for Murabaha Deposits
    Given I am on the allocation holding details
    Then I can see allocation holdings deposits4 date value Format is "dd MMM yyyy"
