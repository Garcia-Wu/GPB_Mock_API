@Epic_GPBM-1094(Holdings)
@Story_GPBM-2085 @Sprint6_iOS
@Story_GPBM-2118 @Sprint6_aOS

Feature: Holdings details - Equities - Account level - Asset Allocation view

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for account class Equities
    Given I login as type "account_allocation_class_holding_detail_equities"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S299-AC1-AT1
  @DependsOn('login_in_as_userN_for_account_class_Equities')
  Scenario:Check the Accout Asset Class Holding detail page UI for Equities
    Given I am on the allocation holding details
#  Equities - 12
#  Preferred Shares - 33
#  Equities (Islamic Products) - 80
    Then I am taken to a detailed allocation Equities holdings screen displaying the following data:
      | element name                                                  | element value                                                                                                                                                                                                                       |
      | Holdings name                                                 |                                                                                                                                                                                                                                     |
      | "Number of shares" label                                      | Number of shares                                                                                                                                                                                                                    |
      | Number of shares value                                        |                                                                                                                                                                                                                                     |
      | ISIN value                                                    |                                                                                                                                                                                                                                     |
      | "Total value" label                                           | Total value                                                                                                                                                                                                                         |
      | Market value in holding currency                              |                                                                                                                                                                                                                                     |
      | Market value in ACCOUNT reference currency                    |                                                                                                                                                                                                                                     |
      | "Unrealised P/L" label                                        | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised Profit/Loss value as a % based on holding currency |                                                                                                                                                                                                                                     |
      | "Average Purchase Price" label                                | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price value in holding currency              |                                                                                                                                                                                                                                     |
      | "Last closing price" label                                    | Last closing price                                                                                                                                                                                                                  |
      | Last closing price value                                      |                                                                                                                                                                                                                                     |
      | "Last closing price date" label                               | Last closing price date                                                                                                                                                                                                             |
      | Last closing price date value                                 |                                                                                                                                                                                                                                     |
      | "Sector" label                                                | Sector                                                                                                                                                                                                                              |
      | Sector value                                                  |                                                                                                                                                                                                                                     |
      | "Last purchase date" label                                    | Last purchase date                                                                                                                                                                                                                  |
      | Last buy Date value                                           |                                                                                                                                                                                                                                     |
      | "Country" label                                               | Country                                                                                                                                                                                                                             |
      | Country value                                                 |                                                                                                                                                                                                                                     |
      | Disclaimer label                                              | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S299-AC1-AT2
  @DependsOn('login_in_as_userN_for_account_class_Equities')
  Scenario:Check the ISO 3 code of Account reference currency in Account Asset Class Holding detail page for Equities
    Given I am on the allocation holding details
    Then I should see the allocation Equities following data format ISO3

  @HK @SG @UK
  @S299-AC1-AT3
  @DependsOn('login_in_as_userN_for_account_class_Equities')
  Scenario:Check the dd Mmm yyyy format of Last Closing Price Date value/Last buy Date value  in Account Asset Class Holding detail page for Equities
    Given I am on the allocation holding details
    Then I should see the allocation Equities following data:Last closing price date value (format: dd Mmm yyyy)、Last purchase date value (format: dd Mmm yyyy)

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for account subasset Equities
    Given I login as type "account_allocation_subasset_holding_detail_equities"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S299-AC2-AT1
  @DependsOn('login_in_as_userN_for_account_subasset_Equities')
  Scenario:Check the Accout Sub-Asset Class Holding detail page UI for Equities
    Given I am on the allocation holding details
#  Equities - 12
#  Preferred Shares - 33
#  Equities (Islamic Products) - 80
    Then I am taken to a detailed allocation Equities holdings screen displaying the following data:
      | element name                                                  | element value                                                                                                                                                                                                                       |
      | Holdings name                                                 |                                                                                                                                                                                                                                     |
      | "Number of shares" label                                      | Number of shares                                                                                                                                                                                                                    |
      | Number of shares value                                        |                                                                                                                                                                                                                                     |
      | ISIN value                                                    |                                                                                                                                                                                                                                     |
      | "Total value" label                                           | Total value                                                                                                                                                                                                                         |
      | Market value in holding currency                              |                                                                                                                                                                                                                                     |
      | Market value in ACCOUNT reference currency                    |                                                                                                                                                                                                                                     |
      | "Unrealised P/L" label                                        | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised Profit/Loss value as a % based on holding currency |                                                                                                                                                                                                                                     |
      | "Average Purchase Price" label                                | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price value in holding currency              |                                                                                                                                                                                                                                     |
      | "Last closing price" label                                    | Last closing price                                                                                                                                                                                                                  |
      | Last closing price value                                      |                                                                                                                                                                                                                                     |
      | "Last closing price date" label                               | Last closing price date                                                                                                                                                                                                             |
      | Last closing price date value                                 |                                                                                                                                                                                                                                     |
      | "Sector" label                                                | Sector                                                                                                                                                                                                                              |
      | Sector value                                                  |                                                                                                                                                                                                                                     |
      | "Last purchase date" label                                    | Last purchase date                                                                                                                                                                                                                  |
      | Last buy Date value                                           |                                                                                                                                                                                                                                     |
      | "Country" label                                               | Country                                                                                                                                                                                                                             |
      | Country value                                                 |                                                                                                                                                                                                                                     |
      | Disclaimer label                                              | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S299-AC2-AT2
  @DependsOn('login_in_as_userN_for_account_subasset_Equities')
  Scenario:Check the ISO 3 code of Account reference currency in Account Sub-Asset Class Holding detail page for Equities
    Given I am on the allocation holding details
    Then I should see the allocation Equities following data format ISO3

  @HK @SG @UK
  @S299-AC2-AT3
  @DependsOn('login_in_as_userN_for_account_subasset_Equities')
  Scenario:Check the dd Mmm yyyy format of Last Closing Price Date value/Last buy Date value  in Account Sub-Asset Class Holding detail page for Equities
    Given I am on the allocation holding details
    Then I should see the allocation Equities following data:Last closing price date value (format: dd Mmm yyyy)、Last purchase date value (format: dd Mmm yyyy)

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for account currency Equities
    Given I login as type "account_allocation_currency_holding_detail_equities"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S299-AC3-AT1
  @DependsOn('login_in_as_userN_for_account_currency_Equities')
  Scenario:Check the Accout Currency Holding detail page UI for Equities
    Given I am on the allocation holding details
#  Equities - 12
#  Preferred Shares - 33
#  Equities (Islamic Products) - 80
    Then I am taken to a detailed allocation Equities holdings screen displaying the following data:
      | element name                                                  | element value                                                                                                                                                                                                                       |
      | Holdings name                                                 |                                                                                                                                                                                                                                     |
      | "Number of shares" label                                      | Number of shares                                                                                                                                                                                                                    |
      | Number of shares value                                        |                                                                                                                                                                                                                                     |
      | ISIN value                                                    |                                                                                                                                                                                                                                     |
      | "Total value" label                                           | Total value                                                                                                                                                                                                                         |
      | Market value in holding currency                              |                                                                                                                                                                                                                                     |
      | Market value in ACCOUNT reference currency                    |                                                                                                                                                                                                                                     |
      | "Unrealised P/L" label                                        | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised Profit/Loss value as a % based on holding currency |                                                                                                                                                                                                                                     |
      | "Average Purchase Price" label                                | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price value in holding currency              |                                                                                                                                                                                                                                     |
      | "Last closing price" label                                    | Last closing price                                                                                                                                                                                                                  |
      | Last closing price value                                      |                                                                                                                                                                                                                                     |
      | "Last closing price date" label                               | Last closing price date                                                                                                                                                                                                             |
      | Last closing price date value                                 |                                                                                                                                                                                                                                     |
      | "Sector" label                                                | Sector                                                                                                                                                                                                                              |
      | Sector value                                                  |                                                                                                                                                                                                                                     |
      | "Last purchase date" label                                    | Last purchase date                                                                                                                                                                                                                  |
      | Last buy Date value                                           |                                                                                                                                                                                                                                     |
      | "Country" label                                               | Country                                                                                                                                                                                                                             |
      | Country value                                                 |                                                                                                                                                                                                                                     |
      | Disclaimer label                                              | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S299-AC3-AT2
  @DependsOn('login_in_as_userN_for_account_currency_Equities')
  Scenario:Check the ISO 3 code of Account reference currency in Account Currency Holding detail page for Equities
    Given I am on the allocation holding details
    Then I should see the allocation Equities following data format ISO3

  @HK @SG @UK
  @S299-AC3-AT3
  @DependsOn('login_in_as_userN_for_account_currency_Equities')
  Scenario:Check the dd Mmm yyyy format of Last Closing Price Date value/Last buy Date value  in Account Currency Holding detail page for Equities
    Given I am on the allocation holding details
    Then I should see the allocation Equities following data:Last closing price date value (format: dd Mmm yyyy)、Last purchase date value (format: dd Mmm yyyy)

  @UK
  @SIT
  Scenario: login in as userN for account region Equities
    Given I login as type "account_allocation_region_holding_detail_equities"
    Then I should on the allocation holding details

  @UK
  @S299-AC4-AT1
  @DependsOn('login_in_as_userN_for_account_region_Equities')
  Scenario:Check the Accout Region Holding detail page UI for Equities
    Given I am on the allocation holding details
#  Preferred Shares - 33
#  Equities (Islamic Products) - 80
    Then I am taken to a detailed allocation Equities holdings screen displaying the following data:
      | element name                                                  | element value                                                                                                                                                                                                                       |
      | Holdings name                                                 |                                                                                                                                                                                                                                     |
      | "Number of shares" label                                      | Number of shares                                                                                                                                                                                                                    |
      | Number of shares value                                        |                                                                                                                                                                                                                                     |
      | ISIN value                                                    |                                                                                                                                                                                                                                     |
      | "Total value" label                                           | Total value                                                                                                                                                                                                                         |
      | Market value in holding currency                              |                                                                                                                                                                                                                                     |
      | Market value in ACCOUNT reference currency                    |                                                                                                                                                                                                                                     |
      | "Unrealised P/L" label                                        | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised Profit/Loss value as a % based on holding currency |                                                                                                                                                                                                                                     |
      | "Average Purchase Price" label                                | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price value in holding currency              |                                                                                                                                                                                                                                     |
      | "Last closing price" label                                    | Last closing price                                                                                                                                                                                                                  |
      | Last closing price value                                      |                                                                                                                                                                                                                                     |
      | "Last closing price date" label                               | Last closing price date                                                                                                                                                                                                             |
      | Last closing price date value                                 |                                                                                                                                                                                                                                     |
      | "Sector" label                                                | Sector                                                                                                                                                                                                                              |
      | Sector value                                                  |                                                                                                                                                                                                                                     |
      | "Last purchase date" label                                    | Last purchase date                                                                                                                                                                                                                  |
      | Last buy Date value                                           |                                                                                                                                                                                                                                     |
      | "Country" label                                               | Country                                                                                                                                                                                                                             |
      | Country value                                                 |                                                                                                                                                                                                                                     |
      | Disclaimer label                                              | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @UK
  @S299-AC4-AT2
  @DependsOn('login_in_as_userN_for_account_region_Equities')
  Scenario:Check the ISO 3 code of Account reference currency in Account Region Holding detail page for Equities
    Given I am on the allocation holding details
    Then I should see the allocation Equities following data format ISO3

  @UK
  @S299-AC4-AT3
  @DependsOn('login_in_as_userN_for_account_region_Equities')
  Scenario:Check the dd Mmm yyyy format of Last Closing Price Date value/Last buy Date value  in Account Region Holding detail page for Equities
    Given I am on the allocation holding details
    Then I should see the allocation Equities following data:Last closing price date value (format: dd Mmm yyyy)、Last purchase date value (format: dd Mmm yyyy)