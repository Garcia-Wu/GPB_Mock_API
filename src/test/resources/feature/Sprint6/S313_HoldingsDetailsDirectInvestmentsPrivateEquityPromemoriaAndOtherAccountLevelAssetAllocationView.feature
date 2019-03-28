@Epic_GPBM-1094(Holdings)
@Story_GPBM-2100 @Sprint6_iOS
@Story_GPBM-2099 @Sprint6_aOS

Feature: Holdings details - Direct Investments (Private Equity), Promemoria and Other - Account level - Asset Allocation view

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for account class Direct Investments
    Given I login as type "account_allocation_class_holding_detail_direct_investments_(Private_Equity)_promemoria_and_other"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S313-AC1-AT1
  @DependsOn('login_in_as_userN_for_account_class_Direct_Investments')
  Scenario:Check the Account Asset Class Holding detail page UI for Direct Investments (Private Equity), Promemoria and Other
    Given I am on the allocation holding details
    Then I am taken to a allocation Direct Investments detailed holdings screen displaying the following data:
      | element name                                       | element value                                                                                                                                                                                                                       |
      | Holding name value                                 |                                                                                                                                                                                                                                     |
      | Reference value                                    |                                                                                                                                                                                                                                     |
      | "Total amount" label                               | Total amount                                                                                                                                                                                                                        |
      | Total amount value in holding currency             |                                                                                                                                                                                                                                     |
      | Total amount value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | Disclaimer                                         | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S313-AC1-AT2
  @DependsOn('login_in_as_userN_for_account_class_Direct_Investments')
  Scenario:Check the ISO 3 code of Account reference currency in Account Asset Class Holding detail page for Direct Investments
    Given I am on the allocation holding details
    Then I should see the allocation holdings direct investments following ISO 3 format datas:holding currency、portfolio reference currency

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for account subasset Direct Investments
    Given I login as type "account_allocation_subasset_holding_detail_direct_investments_(Private_Equity)_promemoria_and_other"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S313-AC2-AT1
  @DependsOn('login_in_as_userN_for_account_subasset_Direct_Investments')
  Scenario:Check the Account Sub-Asset Class Holding detail page UI for Direct Investments (Private Equity), Promemoria and Other
    Given I am on the allocation holding details
    Then I am taken to a allocation Direct Investments detailed holdings screen displaying the following data:
      | element name                                       | element value                                                                                                                                                                                                                       |
      | Holding name value                                 |                                                                                                                                                                                                                                     |
      | Reference value                                    |                                                                                                                                                                                                                                     |
      | "Total amount" label                               | Total amount                                                                                                                                                                                                                        |
      | Total amount value in holding currency             |                                                                                                                                                                                                                                     |
      | Total amount value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | Disclaimer                                         | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S313-AC2-AT2
  @DependsOn('login_in_as_userN_for_account_subasset_Direct_Investments')
  Scenario:Check the ISO 3 code of Account reference currency in Account Sub-Asset Class Holding detail page for Direct Investments
    Given I am on the allocation holding details
    Then I should see the allocation holdings direct investments following ISO 3 format datas:holding currency、portfolio reference currency

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for account currency Direct Investments
    Given I login as type "account_allocation_currency_holding_detail_direct_investments_(Private_Equity)_promemoria_and_other"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S313-AC3-AT1
  @DependsOn('login_in_as_userN_for_account_currency_Direct_Investments')
  Scenario:Check the Account Currency  Holding detail page UI for Direct Investments (Private Equity), Promemoria and Other
    Given I am on the allocation holding details
    Then I am taken to a allocation Direct Investments detailed holdings screen displaying the following data:
      | element name                                       | element value                                                                                                                                                                                                                       |
      | Holding name value                                 |                                                                                                                                                                                                                                     |
      | Reference value                                    |                                                                                                                                                                                                                                     |
      | "Total amount" label                               | Total amount                                                                                                                                                                                                                        |
      | Total amount value in holding currency             |                                                                                                                                                                                                                                     |
      | Total amount value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | Disclaimer                                         | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S313-AC3-AT2
  @DependsOn('login_in_as_userN_for_account_currency_Direct_Investments')
  Scenario:Check the ISO 3 code of Account reference currency in Account Currency Holding detail page for Direct Investments
    Given I am on the allocation holding details
    Then I should see the allocation holdings direct investments following ISO 3 format datas:holding currency、portfolio reference currency

  @UK
  @SIT
  Scenario: login in as userN for account region Direct Investments
    Given I login as type "account_allocation_region_holding_detail_direct_investments_(Private_Equity)_promemoria_and_other"
    Then I should on the allocation holding details

  @UK
  @S313-AC4-AT1
  @DependsOn('login_in_as_userN_for_account_region_Direct_Investments')
  Scenario:Check the Account Region  Holding detail page UI for Direct Investments (Private Equity), Promemoria and Other
    Given I am on the allocation holding details
    Then I am taken to a allocation Direct Investments detailed holdings screen displaying the following data:
      | element name                                       | element value                                                                                                                                                                                                                       |
      | Holding name value                                 |                                                                                                                                                                                                                                     |
      | Reference value                                    |                                                                                                                                                                                                                                     |
      | "Total amount" label                               | Total amount                                                                                                                                                                                                                        |
      | Total amount value in holding currency             |                                                                                                                                                                                                                                     |
      | Total amount value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | Disclaimer                                         | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @UK
  @S313-AC4-AT2
  @DependsOn('login_in_as_userN_for_account_region_Direct_Investments')
  Scenario:Check the ISO 3 code of Account reference currency in Account Region Holding detail page for Direct Investments
    Given I am on the allocation holding details
    Then I should see the allocation holdings direct investments following ISO 3 format datas:holding currency、portfolio reference currency