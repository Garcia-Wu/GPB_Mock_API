@Epic_GPBM-1094(Holdings)
@Story_GPBM-2103 @Sprint6_iOS
@Story_GPBM-2101 @Sprint6_aOS

Feature: Holdings details - Interest Rate Swaps - Account level - Asset Allocation view

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for account class Interest Rate Swaps
    Given I login as type "account_allocation_class_holding_detail_interest_rate_swaps"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S315-AC1-AT1
  @DependsOn('login_in_as_userN_for_account_class_Interest_Rate_Swaps')
  Scenario: Check the Account Asset Class Holding detail page UI for Interest Rate Swaps
    Given I am on the allocation holding details
    Then I am taken to a allocation Interest Rate Swaps detailed holdings screen displaying the following data:
      | element name                               | element value                                                                                                                                                                                                                       |
      | Holding name value                         |                                                                                                                                                                                                                                     |
      | ISIN value                                 |                                                                                                                                                                                                                                     |
      | "Total value" label                       | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency           |                                                                                                                                                                                                                                     |
      | Market value in ACCOUNT reference currency |                                                                                                                                                                                                                                     |
      | "Expiry date" label                        | Expiry date                                                                                                                                                                                                                         |
      | Expiry date value                          |                                                                                                                                                                                                                                     |
      | "Notional amount" label                    | Notional amount                                                                                                                                                                                                                     |
      | Notional amount value                      |                                                                                                                                                                                                                                     |
#      | "Fixed rate" label                           | Fixed rate                                                                                                                                                   |
#      | Fixed rate value (%)                         |                                                                                                                                                              |
      | "Indicative price" label                   | Indicative price                                                                                                                                                                                                                    |
      | Indicative price value in holding currency |                                                                                                                                                                                                                                     |
      | "Indicative price date" label              | Indicative price date                                                                                                                                                                                                               |
      | Indicative price date value                |                                                                                                                                                                                                                                     |
      | Disclaimer                                 | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S315-AC1-AT2
  @DependsOn('login_in_as_userN_for_account_class_Interest_Rate_Swaps')
  Scenario:Check the ISO 3 code of Account reference currency in Account Asset Class Holding detail page for Interest Rate Swaps
    Given I am on the allocation holding details
    Then I should see the allocation holdings interest rate swaps following ISO 3 format datas:holding currency、portfolio reference currency、Notional amount value

  @HK @SG @UK
  @S315-AC1-AT3
  @DependsOn('login_in_as_userN_for_account_class_Interest_Rate_Swaps')
  Scenario:Check the dd Mmm yyyy format of Indicative Price Date value/Expiry date value in Account Asset Class Holding detail page for Interest Rate Swaps
    Given I am on the allocation holding details
    Then I should see the allocation Interest Rate Swaps date format dd MMM yyyy

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for account subasset Interest Rate Swaps
    Given I login as type "account_allocation_subasset_holding_detail_interest_rate_swaps"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S315-AC2-AT1
  @DependsOn('login_in_as_userN_for_account_subasset_Interest_Rate_Swaps')
  Scenario:Check the Account Sub-Asset Class Holding detail page UI for Interest Rate Swaps
    Given I am on the allocation holding details
    Then I am taken to a allocation Interest Rate Swaps detailed holdings screen displaying the following data:
      | element name                               | element value                                                                                                                                                                                                                       |
      | Holding name value                         |                                                                                                                                                                                                                                     |
      | ISIN value                                 |                                                                                                                                                                                                                                     |
      | "Total value" label                       | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency           |                                                                                                                                                                                                                                     |
      | Market value in ACCOUNT reference currency |                                                                                                                                                                                                                                     |
      | "Expiry date" label                        | Expiry date                                                                                                                                                                                                                         |
      | Expiry date value                          |                                                                                                                                                                                                                                     |
      | "Notional amount" label                    | Notional amount                                                                                                                                                                                                                     |
      | Notional amount value                      |                                                                                                                                                                                                                                     |
#      | "Fixed rate" label                           | Fixed rate                                                                                                                                                   |
#      | Fixed rate value (%)                         |                                                                                                                                                              |
      | "Indicative price" label                   | Indicative price                                                                                                                                                                                                                    |
      | Indicative price value in holding currency |                                                                                                                                                                                                                                     |
      | "Indicative price date" label              | Indicative price date                                                                                                                                                                                                               |
      | Indicative price date value                |                                                                                                                                                                                                                                     |
      | Disclaimer                                 | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S315-AC2-AT2
  @DependsOn('login_in_as_userN_for_account_subasset_Interest_Rate_Swaps')
  Scenario:Check the ISO 3 code of Account reference currency in Account Sub-Asset Class Holding detail page for Interest Rate Swaps
    Given I am on the allocation holding details
    Then I should see the allocation holdings interest rate swaps following ISO 3 format datas:holding currency、portfolio reference currency、Notional amount value

  @HK @SG @UK
  @S315-AC2-AT3
  @DependsOn('login_in_as_userN_for_account_subasset_Interest_Rate_Swaps')
  Scenario:Check the dd Mmm yyyy format of Indicative Price Date value/Expiry date value in Account Sub-Asset Class Holding detail page for Interest Rate Swaps
    Given I am on the allocation holding details
    Then I should see the allocation Interest Rate Swaps date format dd MMM yyyy

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for account currency Interest Rate Swaps
    Given I login as type "account_allocation_currency_holding_detail_interest_rate_swaps"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S315-AC3-AT1
  @DependsOn('login_in_as_userN_for_account_currency_Interest_Rate_Swaps')
  Scenario:Check the Account Currency  Holding detail page UI for Interest Rate Swaps
    Given I am on the allocation holding details
    Then I am taken to a allocation Interest Rate Swaps detailed holdings screen displaying the following data:
      | element name                               | element value                                                                                                                                                                                                                       |
      | Holding name value                         |                                                                                                                                                                                                                                     |
      | ISIN value                                 |                                                                                                                                                                                                                                     |
      | "Total value" label                       | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency           |                                                                                                                                                                                                                                     |
      | Market value in ACCOUNT reference currency |                                                                                                                                                                                                                                     |
      | "Expiry date" label                        | Expiry date                                                                                                                                                                                                                         |
      | Expiry date value                          |                                                                                                                                                                                                                                     |
      | "Notional amount" label                    | Notional amount                                                                                                                                                                                                                     |
      | Notional amount value                      |                                                                                                                                                                                                                                     |
#      | "Fixed rate" label                           | Fixed rate                                                                                                                                                   |
#      | Fixed rate value (%)                         |                                                                                                                                                              |
      | "Indicative price" label                   | Indicative price                                                                                                                                                                                                                    |
      | Indicative price value in holding currency |                                                                                                                                                                                                                                     |
      | "Indicative price date" label              | Indicative price date                                                                                                                                                                                                               |
      | Indicative price date value                |                                                                                                                                                                                                                                     |
      | Disclaimer                                 | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S315-AC3-AT2
  @DependsOn('login_in_as_userN_for_account_currency_Interest_Rate_Swaps')
  Scenario:Check the ISO 3 code of Account reference currency in Account Currency Holding detail page for Interest Rate Swaps
    Given I am on the allocation holding details
    Then I should see the allocation holdings interest rate swaps following ISO 3 format datas:holding currency、portfolio reference currency、Notional amount value

  @HK @SG @UK
  @S315-AC3-AT3
  @DependsOn('login_in_as_userN_for_account_currency_Interest_Rate_Swaps')
  Scenario:Check the dd Mmm yyyy format of Indicative Price Date value/Expiry date value in Account Currency Holding detail page for Interest Rate Swaps
    Given I am on the allocation holding details
    Then I should see the allocation Interest Rate Swaps date format dd MMM yyyy

  @UK
  @SIT
  Scenario: login in as userN for account region Interest Rate Swaps
    Given I login as type "account_allocation_region_holding_detail_interest_rate_swaps"
    Then I should on the allocation holding details

  @UK
  @S315-AC4-AT1
  @DependsOn('login_in_as_userN_for_account_region_Interest_Rate_Swaps')
  Scenario:Check the Account Region  Holding detail page UI for Interest Rate Swaps
    Given I am on the allocation holding details
    Then I am taken to a allocation Interest Rate Swaps detailed holdings screen displaying the following data:
      | element name                               | element value                                                                                                                                                                                                                       |
      | Holding name value                         |                                                                                                                                                                                                                                     |
      | ISIN value                                 |                                                                                                                                                                                                                                     |
      | "Total value" label                       | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency           |                                                                                                                                                                                                                                     |
      | Market value in ACCOUNT reference currency |                                                                                                                                                                                                                                     |
      | "Expiry date" label                        | Expiry date                                                                                                                                                                                                                         |
      | Expiry date value                          |                                                                                                                                                                                                                                     |
      | "Notional amount" label                    | Notional amount                                                                                                                                                                                                                     |
      | Notional amount value                      |                                                                                                                                                                                                                                     |
#      | "Fixed rate" label                           | Fixed rate                                                                                                                                                   |
#      | Fixed rate value (%)                         |                                                                                                                                                              |
      | "Indicative price" label                   | Indicative price                                                                                                                                                                                                                    |
      | Indicative price value in holding currency |                                                                                                                                                                                                                                     |
      | "Indicative price date" label              | Indicative price date                                                                                                                                                                                                               |
      | Indicative price date value                |                                                                                                                                                                                                                                     |
      | Disclaimer                                 | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @UK
  @S315-AC4-AT2
  @DependsOn('login_in_as_userN_for_account_region_Interest_Rate_Swaps')
  Scenario:Check the ISO 3 code of Account reference currency in Account Region Holding detail page for Interest Rate Swaps
    Given I am on the allocation holding details
    Then I should see the allocation holdings interest rate swaps following ISO 3 format datas:holding currency、portfolio reference currency、Notional amount value

  @UK
  @S315-AC4-AT3
  @DependsOn('login_in_as_userN_for_account_region_Interest_Rate_Swaps')
  Scenario:Check the dd Mmm yyyy format of Indicative Price Date value/Expiry date value in Account Region Holding detail page for Interest Rate Swaps
    Given I am on the allocation holding details
    Then I should see the allocation Interest Rate Swaps date format dd MMM yyyy
