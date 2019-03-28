@Epic_GPBM-1094(Holdings)
@Story_GPBM-3016 @Sprint6_iOS
@Story_GPBM-3015 @Sprint6_aOS

Feature: Holdings details - Direct Investments (Private Equity), Promemoria and Other - Portfolio level - Asset Allocation view

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio class Direct Investments
    Given I login as type "portfolio_allocation_class_holding_detail_direct_investments_(Private_Equity)_promemoria_and_other"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S394-AC1-AT1
  @DependsOn('login_in_as_userN_for_portfolio_class_Direct_Investments')
  Scenario:Check the Portfolio Asset Class Holding detail page UI for Direct Investments (Private Equity), Promemoria and Other
    Given I am on the allocation holding details
    Then I am taken to a allocation Direct Investments detailed holdings screen displaying the following data:
      | element name                                       | element value                                                                                                                                                                                                                       |
      | Holding name value                                 |                                                                                                                                                                                                                                     |
      | Reference value                                    |                                                                                                                                                                                                                                     |
      | "Total amount" label                               | Total amount                                                                                                                                                                                                                        |
      | Total amount value in holding currency             |                                                                                                                                                                                                                                     |
      | Total amount value in PORTFOLIO reference currency |                                                                                                                                                                                                                                     |
      | Disclaimer                                         | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S394-AC1-AT2
  @DependsOn('login_in_as_userN_for_portfolio_class_Direct_Investments')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Asset Class Holding detail page for Direct Investments
    Given I am on the allocation holding details
    Then I should see the allocation holdings direct investments following ISO 3 format datas:holding currency、portfolio reference currency

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio subasset Direct Investments
    Given I login as type "portfolio_allocation_subasset_holding_detail_direct_investments_(Private_Equity)_promemoria_and_other"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S394-AC2-AT1
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Direct_Investments')
  Scenario:Check the Portfolio Sub-Asset Class Holding detail page UI for Direct Investments (Private Equity), Promemoria and Other
    Given I am on the allocation holding details
    Then I am taken to a allocation Direct Investments detailed holdings screen displaying the following data:
      | element name                                       | element value                                                                                                                                                                                                                       |
      | Holding name value                                 |                                                                                                                                                                                                                                     |
      | Reference value                                    |                                                                                                                                                                                                                                     |
      | "Total amount" label                               | Total amount                                                                                                                                                                                                                        |
      | Total amount value in holding currency             |                                                                                                                                                                                                                                     |
      | Total amount value in PORTFOLIO reference currency |                                                                                                                                                                                                                                     |
      | Disclaimer                                         | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S394-AC2-AT2
  @DependsOn('login_in_as_userN_for_portfolio_subasset_Direct_Investments')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Sub-Asset Class Holding detail page for Direct Investments
    Given I am on the allocation holding details
    Then I should see the allocation holdings direct investments following ISO 3 format datas:holding currency、portfolio reference currency

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for portfolio currency Direct Investments
    Given I login as type "portfolio_allocation_currency_holding_detail_direct_investments_(Private_Equity)_promemoria_and_other"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S394-AC3-AT1
  @DependsOn('login_in_as_userN_for_portfolio_currency_Direct_Investments')
  Scenario:Check the Portfolio Currency  Holding detail page UI for Direct Investments (Private Equity), Promemoria and Other
    Given I am on the allocation holding details
    Then I am taken to a allocation Direct Investments detailed holdings screen displaying the following data:
      | element name                                       | element value                                                                                                                                                                                                                       |
      | Holding name value                                 |                                                                                                                                                                                                                                     |
      | Reference value                                    |                                                                                                                                                                                                                                     |
      | "Total amount" label                               | Total amount                                                                                                                                                                                                                        |
      | Total amount value in holding currency             |                                                                                                                                                                                                                                     |
      | Total amount value in PORTFOLIO reference currency |                                                                                                                                                                                                                                     |
      | Disclaimer                                         | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S394-AC3-AT2
  @DependsOn('login_in_as_userN_for_portfolio_currency_Direct_Investments')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Currency Holding detail page for Direct Investments
    Given I am on the allocation holding details
    Then I should see the allocation holdings direct investments following ISO 3 format datas:holding currency、portfolio reference currency

  @UK
  @SIT
  Scenario: login in as userN for portfolio region Direct Investments
    Given I login as type "portfolio_allocation_region_holding_detail_direct_investments_(Private_Equity)_promemoria_and_other"
    Then I should on the allocation holding details

  @UK
  @S394-AC4-AT1
  @DependsOn('login_in_as_userN_for_portfolio_region_Direct_Investments')
  Scenario:Check the Portfolio Region  Holding detail page UI for Direct Investments (Private Equity), Promemoria and Other
    Given I am on the allocation holding details
    Then I am taken to a allocation Direct Investments detailed holdings screen displaying the following data:
      | element name                                       | element value                                                                                                                                                                                                                       |
      | Holding name value                                 |                                                                                                                                                                                                                                     |
      | Reference value                                    |                                                                                                                                                                                                                                     |
      | "Total amount" label                               | Total amount                                                                                                                                                                                                                        |
      | Total amount value in holding currency             |                                                                                                                                                                                                                                     |
      | Total amount value in PORTFOLIO reference currency |                                                                                                                                                                                                                                     |
      | Disclaimer                                         | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @UK
  @S394-AC4-AT2
  @DependsOn('login_in_as_userN_for_portfolio_region_Direct_Investments')
  Scenario:Check the ISO 3 code of Portfolio reference currency in Portfolio Region Holding detail page for Direct Investments
    Given I am on the allocation holding details
    Then I should see the allocation holdings direct investments following ISO 3 format datas:holding currency、portfolio reference currency