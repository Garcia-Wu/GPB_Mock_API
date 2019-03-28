@Epic_GPBM-1094(Holdings)
@Story_GPBM-2137 @Sprint6_iOS
@Story_GPBM-2138 @Sprint6_aOS

Feature: Holdings details - Private Equity & Real Estate Funds - Overview level - Asset Allocation view

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for overview class Private Equity Funds
    Given I login as type "overview_allocation_class_holding_detail_private_equity_and_real_estate_funds"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S338-AC1-AT1
  @DependsOn('login_in_as_userN_for_overview_class_Private_Equity_Funds')
  Scenario:Check the Overview Asset Class Holding detail page UI for Private Equity and Real Estate
    Given I am on the allocation holding details
    Then I am taken to a allocation Private Equity Funds detailed holdings screen displaying the following data:
      | element name                                 | element value                                                                                                                                                                                                                       |
      | Holding name value                           |                                                                                                                                                                                                                                     |
      | ISIN value                                   |                                                                                                                                                                                                                                     |
      | Total value label                           | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency             |                                                                                                                                                                                                                                     |
      | Market value in OVERVIEW reference currency  |                                                                                                                                                                                                                                     |
      | Initial Commitment label                     | Initial commitment                                                                                                                                                                                                                  |
      | Initial Commitment value in holding currency |                                                                                                                                                                                                                                     |
      | Disclaimer                                   | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S338-AC1-AT2
  @DependsOn('login_in_as_userN_for_overview_class_Private_Equity_Funds')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Asset Class Holding detail page for Private Equity and Real Estate
    Given I am on the allocation holding details
    Then I should see the allocation Private Equity Funds holding currency and account reference currency format ISO 3 code

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for overview subasset Private Equity Funds
    Given I login as type "overview_allocation_subasset_holding_detail_private_equity_and_real_estate_funds"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S338-AC2-AT1
  @DependsOn('login_in_as_userN_for_overview_subasset_Private_Equity_Funds')
  Scenario:Check the Overview Sub-Asset Class Holding detail page UI for Private Equity and Real Estate
    Given I am on the allocation holding details
    Then I am taken to a allocation Private Equity Funds detailed holdings screen displaying the following data:
      | element name                                 | element value                                                                                                                                                                                                                       |
      | Holding name value                           |                                                                                                                                                                                                                                     |
      | ISIN value                                   |                                                                                                                                                                                                                                     |
      | Total value label                           | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency             |                                                                                                                                                                                                                                     |
      | Market value in OVERVIEW reference currency  |                                                                                                                                                                                                                                     |
      | Initial Commitment label                     | Initial commitment                                                                                                                                                                                                                  |
      | Initial Commitment value in holding currency |                                                                                                                                                                                                                                     |
      | Disclaimer                                   | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S338-AC2-AT2
  @DependsOn('login_in_as_userN_for_overview_subasset_Private_Equity_Funds')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Sub-Asset Class Holding detail page for Private Equity and Real Estate
    Given I am on the allocation holding details
    Then I should see the allocation Private Equity Funds holding currency and account reference currency format ISO 3 code

  @HK @SG @UK
  @SIT
  Scenario: login in as userN for overview currency Private Equity Funds
    Given I login as type "overview_allocation_currency_holding_detail_private_equity_and_real_estate_funds"
    Then I should on the allocation holding details

  @HK @SG @UK
  @S338-AC3-AT1
  @DependsOn('login_in_as_userN_for_overview_currency_Private_Equity_Funds')
  Scenario:Check the Overview Currency Holding detail page UI for Private Equity and Real Estate
    Given I am on the allocation holding details
    Then I am taken to a allocation Private Equity Funds detailed holdings screen displaying the following data:
      | element name                                 | element value                                                                                                                                                                                                                       |
      | Holding name value                           |                                                                                                                                                                                                                                     |
      | ISIN value                                   |                                                                                                                                                                                                                                     |
      | Total value label                           | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency             |                                                                                                                                                                                                                                     |
      | Market value in OVERVIEW reference currency  |                                                                                                                                                                                                                                     |
      | Initial Commitment label                     | Initial commitment                                                                                                                                                                                                                  |
      | Initial Commitment value in holding currency |                                                                                                                                                                                                                                     |
      | Disclaimer                                   | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @HK @SG @UK
  @S338-AC3-AT2
  @DependsOn('login_in_as_userN_for_overview_currency_Private_Equity_Funds')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Currency Holding detail page for Private Equity and Real Estate
    Given I am on the allocation holding details
    Then I should see the allocation Private Equity Funds holding currency and account reference currency format ISO 3 code

  @UK
  @SIT
  Scenario: login in as userN for overview region Private Equity Funds
    Given I login as type "overview_allocation_region_holding_detail_private_equity_and_real_estate_funds"
    Then I should on the allocation holding details

  @UK
  @S338-AC4-AT1
  @DependsOn('login_in_as_userN_for_overview_region_Private_Equity_Funds')
  Scenario:Check the Overview Region  Holding detail page UI for Private Equity and Real Estate
    Given I am on the allocation holding details
    Then I am taken to a allocation Private Equity Funds detailed holdings screen displaying the following data:
      | element name                                 | element value                                                                                                                                                                                                                       |
      | Holding name value                           |                                                                                                                                                                                                                                     |
      | ISIN value                                   |                                                                                                                                                                                                                                     |
      | Total value label                           | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency             |                                                                                                                                                                                                                                     |
      | Market value in OVERVIEW reference currency  |                                                                                                                                                                                                                                     |
      | Initial Commitment label                     | Initial commitment                                                                                                                                                                                                                  |
      | Initial Commitment value in holding currency |                                                                                                                                                                                                                                     |
      | Disclaimer                                   | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @UK
  @S338-AC4-AT2
  @DependsOn('login_in_as_userN_for_overview_region_Private_Equity_Funds')
  Scenario:Check the ISO 3 code of Overview reference currency/holding currency in Overview Region Holding detail page for Private Equity and Real Estate
    Given I am on the allocation holding details
    Then I should see the allocation Private Equity Funds holding currency and account reference currency format ISO 3 code