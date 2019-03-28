@Epic_GPBM-1094(Holdings)
@Story_GPBM-2094 @Sprint6_iOS
@Story_GPBM-2093 @Sprint6_aOS

Feature: Holdings details - Current Accounts, Blocked Current Accounts - Account level - Asset Allocation view

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for account class Current Accounts
    Given I login as type "account_allocation_class_holding_detail_current_accounts_blocked_current_accounts"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S307-AC1-AT1
  @DependsOn('login_in_as_userN_for_account_class_Current_Accounts')
  Scenario:Check the Account Asset Class Holding detail page UI for Current Accounts
    Given I am on the allocation holding details
#  - Current accounts - 58
#  - Blocked current accounts - 60
    Then I am taken to a detailed allocation Current Accounts holdings screen displaying the following data:
      | element name                                                | element value                                                                                                                                                                                                                       |
      | Holding name value                                          |                                                                                                                                                                                                                                     |
      | Any reference values                                        |                                                                                                                                                                                                                                     |
      | "Balance" label                                             | Balance                                                                                                                                                                                                                             |
      | Balance value in holding currency                           |                                                                                                                                                                                                                                     |
      | Balance value in ACCOUNT reference currency within brackets |                                                                                                                                                                                                                                     |
      | Disclaimer                                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S307-AC1-AT2
  @DependsOn('login_in_as_userN_for_account_class_Current_Accounts')
  Scenario:Check the ISO 3 code of Account reference currency/holding currency in Account Asset Class Holding detail page for Current Accounts
    Given I am on the allocation holding details
    Then I should see the allocation Current Accounts following datas format:ISO 3

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for account subasset Current Accounts
    Given I login as type "account_allocation_subasset_holding_detail_current_accounts_blocked_current_accounts"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S307-AC2-AT1
  @DependsOn('login_in_as_userN_for_account_subasset_Current_Accounts')
  Scenario:Check the Account Sub-Asset Class Holding detail page UI for Current Accounts
    Given I am on the allocation holding details
#  - Current accounts - 58
#  - Blocked current accounts - 60
    Then I am taken to a detailed allocation Current Accounts holdings screen displaying the following data:
      | element name                                                | element value                                                                                                                                                                                                                       |
      | Holding name value                                          |                                                                                                                                                                                                                                     |
      | Any reference values                                        |                                                                                                                                                                                                                                     |
      | "Balance" label                                             | Balance                                                                                                                                                                                                                             |
      | Balance value in holding currency                           |                                                                                                                                                                                                                                     |
      | Balance value in ACCOUNT reference currency within brackets |                                                                                                                                                                                                                                     |
      | Disclaimer                                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S307-AC2-AT2
  @DependsOn('login_in_as_userN_for_account_subasset_Current_Accounts')
  Scenario:Check the ISO 3 code of Account reference currency/holding currency in Account Sub-Asset Class Holding detail page for Current Accounts
    Given I am on the allocation holding details
    Then I should see the allocation Current Accounts following datas format:ISO 3

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for account currency Current Accounts
    Given I login as type "account_allocation_currency_holding_detail_current_accounts_blocked_current_accounts"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S307-AC3-AT1
  @DependsOn('login_in_as_userN_for_account_currency_Current_Accounts')
  Scenario:Check the Account Currency Holding detail page UI for Current Accounts
    Given I am on the allocation holding details
#  - Current accounts - 58
#  - Blocked current accounts - 60
    Then I am taken to a detailed allocation Current Accounts holdings screen displaying the following data:
      | element name                                                | element value                                                                                                                                                                                                                       |
      | Holding name value                                          |                                                                                                                                                                                                                                     |
      | Any reference values                                        |                                                                                                                                                                                                                                     |
      | "Balance" label                                             | Balance                                                                                                                                                                                                                             |
      | Balance value in holding currency                           |                                                                                                                                                                                                                                     |
      | Balance value in ACCOUNT reference currency within brackets |                                                                                                                                                                                                                                     |
      | Disclaimer                                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S307-AC3-AT2
  @DependsOn('login_in_as_userN_for_account_currency_Current_Accounts')
  Scenario:Check the ISO 3 code of Account reference currency/holding currency in Account Currency Holding detail page for Current Accounts
    Given I am on the allocation holding details
    Then I should see the allocation Current Accounts following datas format:ISO 3

  @UK
  @SIT
  Scenario: login in as userN for account region Current Accounts
    Given I login as type "account_allocation_region_holding_detail_current_accounts_blocked_current_accounts"
    Then I should on the allocation holding details

  @UK
  @S307-AC4-AT1
  @DependsOn('login_in_as_userN_for_account_region_Current_Accounts')
  Scenario:Check the Account Region Holding detail page UI for Current Accounts
    Given I am on the allocation holding details
#  - Current accounts - 58
#  - Blocked current accounts - 60
    Then I am taken to a detailed allocation Current Accounts holdings screen displaying the following data:
      | element name                                                | element value                                                                                                                                                                                                                       |
      | Holding name value                                          |                                                                                                                                                                                                                                     |
      | Any reference values                                        |                                                                                                                                                                                                                                     |
      | "Balance" label                                             | Balance                                                                                                                                                                                                                             |
      | Balance value in holding currency                           |                                                                                                                                                                                                                                     |
      | Balance value in ACCOUNT reference currency within brackets |                                                                                                                                                                                                                                     |
      | Disclaimer                                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @UK
  @S307-AC4-AT2
  @DependsOn('login_in_as_userN_for_account_region_Current_Accounts')
  Scenario:Check the ISO 3 code of Account reference currency/holding currency in Account Region Holding detail page for Current Accounts
    Given I am on the allocation holding details
    Then I should see the allocation Current Accounts following datas format:ISO 3