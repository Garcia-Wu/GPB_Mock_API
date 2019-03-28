@Epic_GPBM-1094(Holdings)
@Story_GPBM-3009 @Sprint6_iOS
@Story_GPBM-3008 @Sprint6_aOS

Feature: Holdings details - Current Accounts, Blocked Current Accounts - Portfolio level - Asset Allocation view

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio class Current Accounts
    Given I login as type "portfolio_allocation_class_holding_detail_current_accounts_blocked_current_accounts"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S391-AC1-AT1
  @DependsOn('login_in_as_userN_for_portfolio_class_Current_Accounts')
  Scenario:Check the Portfolio Asset Class Holding detail page UI for Current Accounts
    Given I am on the allocation holding details
    Then I am taken to a detailed allocation Current Accounts holdings screen displaying the following data:
      | element name                                                  | element value                                                                                                                                                                                                                       |
      | Holding name value                                            |                                                                                                                                                                                                                                     |
      | Any reference values                                          |                                                                                                                                                                                                                                     |
      | "Balance" label                                               | Balance                                                                                                                                                                                                                             |
      | Balance value in holding currency                             |                                                                                                                                                                                                                                     |
      | Balance value in PORTFOLIO reference currency within brackets |                                                                                                                                                                                                                                     |
      | Disclaimer                                                    | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S391-AC1-AT2
  @DependsOn('login_in_as_userN_for_portfolio_class_Current_Accounts')
  Scenario:Check the ISO 3 code of Portfolio reference currency/holding currency in Portfolio Asset Class Holding detail page for Current Accounts
    Given I am on the allocation holding details
    Then I should see the allocation Current Accounts following datas format:ISO 3

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio subasset Current Accounts
    Given I login as type "portfolio_allocation_subasset_holding_detail_current_accounts_blocked_current_accounts"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S391-AC2-AT1
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Current_Accounts')
  Scenario:Check the Portfolio Sub-Asset Class Holding detail page UI for Current Accounts
    Given I am on the allocation holding details
    Then I am taken to a detailed allocation Current Accounts holdings screen displaying the following data:
      | element name                                                  | element value                                                                                                                                                                                                                       |
      | Holding name value                                            |                                                                                                                                                                                                                                     |
      | Any reference values                                          |                                                                                                                                                                                                                                     |
      | "Balance" label                                               | Balance                                                                                                                                                                                                                             |
      | Balance value in holding currency                             |                                                                                                                                                                                                                                     |
      | Balance value in PORTFOLIO reference currency within brackets |                                                                                                                                                                                                                                     |
      | Disclaimer                                                    | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S391-AC2-AT2
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Current_Accounts')
  Scenario:Check the ISO 3 code of Portfolio reference currency/holding currency in Portfolio Sub-Asset Class Holding detail page for Current Accounts
    Given I am on the allocation holding details
    Then I should see the allocation Current Accounts following datas format:ISO 3

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio currency Current Accounts
    Given I login as type "portfolio_allocation_currency_holding_detail_current_accounts_blocked_current_accounts"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S391-AC3-AT1
  @DependsOn('login_in_as_userN_for_portfolio_currency_Current_Accounts')
  Scenario:Check the Portfolio Currency Holding detail page UI for Current Accounts
    Given I am on the allocation holding details
    Then I am taken to a detailed allocation Current Accounts holdings screen displaying the following data:
      | element name                                                  | element value                                                                                                                                                                                                                       |
      | Holding name value                                            |                                                                                                                                                                                                                                     |
      | Any reference values                                          |                                                                                                                                                                                                                                     |
      | "Balance" label                                               | Balance                                                                                                                                                                                                                             |
      | Balance value in holding currency                             |                                                                                                                                                                                                                                     |
      | Balance value in PORTFOLIO reference currency within brackets |                                                                                                                                                                                                                                     |
      | Disclaimer                                                    | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S391-AC3-AT2
  @DependsOn('login_in_as_userN_for_portfolio_currency_Current_Accounts')
  Scenario:Check the ISO 3 code of Portfolio reference currency/holding currency in Portfolio Currency Holding detail page for Current Accounts
    Given I am on the allocation holding details
    Then I should see the allocation Current Accounts following datas format:ISO 3

  @UK
  @SIT
  Scenario: login in as userN for portfolio region Current Accounts
    Given I login as type "portfolio_allocation_region_holding_detail_current_accounts_blocked_current_accounts"
    Then I should on the allocation holding details

  @UK
  @S391-AC4-AT1
  @DependsOn('login_in_as_userN_for_portfolio_region_Current_Accounts')
  Scenario:Check the Portfolio Region Holding detail page UI for Current Accounts
    Given I am on the allocation holding details
    Then I am taken to a detailed allocation Current Accounts holdings screen displaying the following data:
      | element name                                                  | element value                                                                                                                                                                                                                       |
      | Holding name value                                            |                                                                                                                                                                                                                                     |
      | Any reference values                                          |                                                                                                                                                                                                                                     |
      | "Balance" label                                               | Balance                                                                                                                                                                                                                             |
      | Balance value in holding currency                             |                                                                                                                                                                                                                                     |
      | Balance value in PORTFOLIO reference currency within brackets |                                                                                                                                                                                                                                     |
      | Disclaimer                                                    | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @UK
  @S391-AC4-AT2
  @DependsOn('login_in_as_userN_for_portfolio_region_Current_Accounts')
  Scenario:Check the ISO 3 code of Portfolio reference currency/holding currency in Portfolio Region Holding detail page for Current Accounts
    Given I am on the allocation holding details
    Then I should see the allocation Current Accounts following datas format:ISO 3