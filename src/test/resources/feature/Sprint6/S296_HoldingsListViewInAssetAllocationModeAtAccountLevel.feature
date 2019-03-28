@UK
@Epic_GPBM-1094(Holdings)
@Story_GPBM-2078 @Sprint6_iOS
@Story_GPBM-2079 @Sprint6_aOS

Feature: Holdings list view in Asset Allocation mode at Account level

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

#  Precious Metal - 32
#  Equities - 12
#  Preferred Shares - 33
#  Equities (Islamic Products) - 80
#  Interest Rates Linked Notes - 24
#  Fixed Income Structured Products - 37
#  Credit Linked Notes - 6
#  Equity Linked Notes - 13
#  Hedge Fund Linked Notes - 2
#  Commodity Linked Notes - 63
#  Forex Linked Notes - 17
#  Other Structured Products - 29
#  Fund Linked Notes - 76
#  Forex Linked Structured Notes - 77
#  Other Structured Products (Islamic Products) - 84
#  Currency Options - 52
#  Options on Fixed Income - 49
#  Credit Linked OTC Derivatives - 9
#  Interest Linked OTC Derivatives - 23
#  Equity Options - 50
#  Future Options - 51
#  Metal Options - 53
#  Commodity Linked OTC Derivatives - 4
#  Other OTC Derivatives - 28
#  Fund Linked OTC Derivatives - 75
#  Warrant on Fixed Income - 40
#  Equity Warrant - 39
#  Other Warrant - 30
#  Short Term Investments - 36
#  Bank notes - 54
#  Time Deposits - 61
#  Fiduciary Deposits - 62
#  Bonds - 8
#  Preferred Bonds - 79
#  Convertible Bonds - 6
#  Money Market Mutual Funds - 25
#  Money Market Mutual Funds (Islamic Products) - 88
#  Convertible Bonds Mutual Funds - 7
#  Fixed Income Mutual Funds - 16
#  Convertible Bonds Mutual Funds (Islamic Products) - 87
#  Fixed Income Mutual Funds (Islamic Products) - 86
#  Equity Mutual Fund - 15
#  Equity Mutual Fund (Islamic Products) - 85
#  Commodity Funds - 5
#  Commodity Funds (Islamic Products) - 81
#  Other Mutual Funds - 27
#  Other Mutual Funds (Islamic Products) - 89
#  Hedge Funds - 1
#  Hedge Funds (Islamic Products) - 90
#  Futures on Forex - 22
#  Futures on Fixed Income - 21
#  Futures on Equity - 20
#  Futures on Commodities - 19
#  Foreign Exchange - 48

  @SIT
  Scenario: class holdings which holdings AND P/L figure is relevant And holding ccy is DIFFERENT to account reference currency
    Given I login as type "account_allocation_class_holding_list_has_pl_and_ccy_different"
    Then I should see the allocation holding list

  @HK @SG @UK
  @S296-AC1-AT1
  @DependsOn('class_holdings_which_holdings_AND_P/L_figure_is_relevant_And_holding_ccy_is_DIFFERENT_to_account_reference_currency')
  Scenario:Check class holdings which holdings AND P/L figure is relevant And holding ccy is DIFFERENT to account reference currency
    Given I am see the allocation holding list
    Then I can see a list of accounts allocation holdings with the following details when P/L figure is relevant And holding ccy is DIFFERENT

  @HK @SG @UK
  @S296-AC1-AT2
  @SIT
  @DependsOn('class_holdings_which_holdings_AND_P/L_figure_is_relevant_And_holding_ccy_is_DIFFERENT_to_account_reference_currency')
  Scenario:Check ISO 3 code format in Accounts Class holdings when P/L figure is relevant And holding ccy is DIFFERENT
    Given I see a list of accounts allocation holdings with the following details when P/L figure is relevant And holding ccy is DIFFERENT
    Then I can see ISO 3 code of accounts allocation holding currency and ISO 3 code of ACCOUNT reference currency when P/L figure is relevant And holding ccy is DIFFERENT

  @SIT
  Scenario: currency holdings which holdings AND P/L figure is relevant And holding ccy is DIFFERENT to account reference currency
    Given I login as type "account_allocation_currency_holding_list_has_pl_and_ccy_different"
    Then I should see the allocation holding list

  @HK @SG @UK
  @S296-AC2-AT1
  @DependsOn('currency_holdings_which_holdings_AND_P/L_figure_is_relevant_And_holding_ccy_is_DIFFERENT_to_account_reference_currency')
  Scenario:Check currency holdings which holdings AND P/L figure is relevant And holding ccy is DIFFERENT to account reference currency
    Given I am see the allocation holding list
    Then I can see a list of accounts allocation holdings with the following details when P/L figure is relevant And holding ccy is DIFFERENT

  @HK @SG @UK
  @S296-AC2-AT2
  @SIT
  @DependsOn('currency_holdings_which_holdings_AND_P/L_figure_is_relevant_And_holding_ccy_is_DIFFERENT_to_account_reference_currency')
  Scenario:Check ISO 3 code format in Accounts Currency holdings when P/L figure is relevant And holding ccy is DIFFERENT
    Given I see a list of accounts allocation holdings with the following details when P/L figure is relevant And holding ccy is DIFFERENT
    Then I can see ISO 3 code of accounts allocation holding currency and ISO 3 code of ACCOUNT reference currency when P/L figure is relevant And holding ccy is DIFFERENT

  @SIT
  Scenario: Region holdings which holdings AND P/L figure is relevant And holding ccy is DIFFERENT to account reference currency
    Given I login as type "account_allocation_region_holding_list_has_pl_and_ccy_different"
    Then I should see the allocation holding list

  @UK
  @S296-AC3-AT1
  @DependsOn('Region_holdings_which_holdings_AND_P/L_figure_is_relevant_And_holding_ccy_is_DIFFERENT_to_account_reference_currency')
  Scenario:Check Region holdings which holdings AND P/L figure is relevant And holding ccy is DIFFERENT to account reference currency
    Given I am see the allocation holding list
#    And I tap first item of Account region list
    Then I can see a list of accounts allocation holdings with the following details when P/L figure is relevant And holding ccy is DIFFERENT

  @UK
  @S296-AC3-AT2
  @SIT
  @DependsOn('Region_holdings_which_holdings_AND_P/L_figure_is_relevant_And_holding_ccy_is_DIFFERENT_to_account_reference_currency')
  Scenario:Check ISO 3 code format in Account Region holdings when P/L figure is NOT relevant AND holding ccy is DIFFERENT
    Given I see a list of accounts allocation holdings with the following details when P/L figure is relevant And holding ccy is DIFFERENT
    Then I can see ISO 3 code of accounts allocation holding currency and ISO 3 code of ACCOUNT reference currency when P/L figure is relevant And holding ccy is DIFFERENT

  @SIT
  Scenario: Class holdings which holdings AND P/L figure is NOT relevant AND holding ccy is DIFFERENT to account reference currency
    Given I login as type "account_allocation_class_holding_list_no_pl_and_ccy_different"
    Then I should see the allocation holding list

  @HK @SG @UK
  @S296-AC4-AT1
  @DependsOn('Class_holdings_which_holdings_AND_P/L_figure_is_NOT_relevant_AND_holding_ccy_is_DIFFERENT_to_account_reference_currency')
  Scenario:Check Class holdings which holdings AND P/L figure is NOT relevant AND holding ccy is DIFFERENT to account reference currency
    Given I am see the allocation holding list
    Then I can see a list of accounts allocation holdings with the following details when P/L figure is NOT relevant AND holding ccy is DIFFERENT

  @HK @SG @UK
  @S296-AC4-AT2
  @SIT
  @DependsOn('Class_holdings_which_holdings_AND_P/L_figure_is_NOT_relevant_AND_holding_ccy_is_DIFFERENT_to_account_reference_currency')
  Scenario:Check ISO 3 code format in Accounts class holdings when holdings And  P/L figure is NOT relevant
    Given I see a list of accounts allocation holdings with the following details when P/L figure is NOT relevant AND holding ccy is DIFFERENT
    Then I can see ISO 3 code of accounts allocation holding currency and ISO 3 code of ACCOUNT reference currency when P/L figure is NOT relevant AND holding ccy is DIFFERENT

  @SIT
  Scenario: Currency holdings which holdings AND P/L figure is NOT relevant AND holding ccy is DIFFERENT to account reference currency
    Given I login as type "account_allocation_currency_holding_list_no_pl_and_ccy_different"
    Then I should see the allocation holding list

  @HK @SG @UK
  @S296-AC5-AT1
  @DependsOn('Currency_holdings_which_holdings_AND_P/L_figure_is_NOT_relevant_AND_holding_ccy_is_DIFFERENT_to_account_reference_currency')
  Scenario:Check Currency holdings which holdings AND P/L figure is NOT relevant AND holding ccy is DIFFERENT to account reference currency
    Given I am see the allocation holding list
    Then I can see a list of accounts allocation holdings with the following details when P/L figure is NOT relevant AND holding ccy is DIFFERENT

  @HK @SG @UK
  @S296-AC5-AT2
  @SIT
  @DependsOn('Currency_holdings_which_holdings_AND_P/L_figure_is_NOT_relevant_AND_holding_ccy_is_DIFFERENT_to_account_reference_currency')
  Scenario:Check ISO 3 code format in Accounts currency holdings when holdings And P/L figure is NOT relevant
    Given I see a list of accounts allocation holdings with the following details when P/L figure is NOT relevant AND holding ccy is DIFFERENT
    Then I can see ISO 3 code of accounts allocation holding currency and ISO 3 code of ACCOUNT reference currency when P/L figure is NOT relevant AND holding ccy is DIFFERENT

  @SIT
  Scenario: Region holdings which holdings AND P/L figure is NOT relevant AND holding ccy is DIFFERENT to account reference currency
    Given I login as type "account_allocation_region_holding_list_no_pl_and_ccy_different"
    Then I should see the allocation holding list

  @UK
  @S296-AC6-AT1
  @DependsOn('Region_holdings_which_holdings_AND_P/L_figure_is_NOT_relevant_AND_holding_ccy_is_DIFFERENT_to_account_reference_currency')
  Scenario:Check Region holdings which holdings AND P/L figure is NOT relevant AND holding ccy is DIFFERENT to account reference currency
    Given I am see the allocation holding list
    Then I can see a list of accounts allocation holdings with the following details when P/L figure is NOT relevant AND holding ccy is DIFFERENT

  @UK
  @S296-AC6-AT2
  @SIT
  @DependsOn('Region_holdings_which_holdings_AND_P/L_figure_is_NOT_relevant_AND_holding_ccy_is_DIFFERENT_to_account_reference_currency')
  Scenario:Check ISO 3 code format in Accounts Region holdings when holdings And P/L figure is NOT relevant
    Given I see a list of accounts allocation holdings with the following details when P/L figure is NOT relevant AND holding ccy is DIFFERENT
    Then I can see ISO 3 code of accounts allocation holding currency and ISO 3 code of ACCOUNT reference currency when P/L figure is NOT relevant AND holding ccy is DIFFERENT
