@HK @SG @UK
@Epic_GPBM-1094(Holdings)
@Story_GPBM-2151 @Sprint6_iOS
@Story_GPBM-2150 @Sprint6_aOS

Feature: Holdings list view

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  holding list 2: P/L is negative AND holding ccy is DIFFERENT
  holding list 3: P/L is positive AND holding ccy is DIFFERENT
  holding list 5: P/L is positive AND holding ccy is SAME
  holding list 8: P/L is negative AND holding ccy is SAME

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

#  overview level
  @SIT
  Scenario: P/L is positive AND holding ccy is DIFFERENT to Overview reference currency
    Given I login as type "overview_allocation_currency_holding_list_pl_positive_and_ccy_different"
    Then I should see the allocation holding list

  @S293-AC1-AT1
  @DependsOn('P/L_is_positive_AND_holding_ccy_is_DIFFERENT_to_Overview_reference_currency')
  Scenario: Check P/L is positive AND holding ccy is DIFFERENT to Overview reference currency
    Given I am on the allocation holding list
    Then I can see a list of overview allocation holdings with the following details when P/L is positive AND holding ccy is DIFFERENT

  @S293-AC1-AT2
  @SIT
  @DependsOn('P/L_is_positive_AND_holding_ccy_is_DIFFERENT_to_Overview_reference_currency')
  Scenario: Check ISO 3 code format in Overview holdings when P/L is positive AND holding ccy is DIFFERENT to Overview reference currency
    Given I am on the allocation holding list
    Then I can see ISO 3 code of overview allocation holding currency、Overview reference currency

  @SIT
  Scenario: P/L is negative AND holding ccy is DIFFERENT to Overview reference currency
    Given I login as type "overview_allocation_currency_holding_list_pl_negative_and_ccy_different"
    Then I should see the allocation holding list

  @S293-AC4-AT1
  @DependsOn('P/L_is_negative_AND_holding_ccy_is_DIFFERENT_to_Overview_reference_currency')
  Scenario: Check P/L is negative AND holding ccy is DIFFERENT to Overview reference currency
    Given I am on the allocation holding list
    Then I can see a list of overview allocation holdings with the following details when P/L is negative AND holding ccy is DIFFERENT

  @S293-AC4-AT2
  @SIT
  @DependsOn('P/L_is_negative_AND_holding_ccy_is_DIFFERENT_to_Overview_reference_currency')
  Scenario: Check ISO 3 code format in Overview holdings when P/L is negative AND holding ccy is DIFFERENT to Overview reference currency
    Given I am on the allocation holding list
    Then I can see ISO 3 code of overview allocation holding currency、Overview reference currency when P/L is negative AND holding ccy is DIFFERENT

  @SIT
  Scenario: P/L is positive AND holding ccy is the SAME to Overview reference currency
    Given I login as type "overview_allocation_currency_holding_list_pl_positive_and_ccy_same"
    Then I should see the allocation holding list

  @S293-AC7-AT1
  @DependsOn('P/L_is_positive_AND_holding_ccy_is_the_SAME_to_Overview_reference_currency')
  Scenario: Check P/L is positive AND holding ccy is the SAME to Overview reference currency
    Given I am on the allocation holding list
    Then I can see a list of overview allocation holdings with the following details when P/L is positive AND holding ccy is the SAME

  @S293-AC7-AT2
  @SIT
  @DependsOn('P/L_is_positive_AND_holding_ccy_is_the_SAME_to_Overview_reference_currency')
  Scenario: Check ISO 3 code format in Overview holdings when P/L is positive AND holding ccy is the SAME to Overview reference currency
    Given I am on the allocation holding list
    Then I can see ISO 3 code of overview allocation holding currency when P/L is positive AND holding ccy is the SAME

  @SIT
  Scenario: P/L is negative AND holding ccy is the SAME to Overview reference currency
    Given I login as type "overview_allocation_currency_holding_list_pl_negative_and_ccy_same"
    Then I should see the allocation holding list

  @S293-AC10-AT1
  @DependsOn('P/L_is_negative_AND_holding_ccy_is_the_SAME_to_Overview_reference_currency')
  Scenario: Check P/L is negative AND holding ccy is the SAME to Overview reference currency
    Given I am on the allocation holding list
    Then I can see a list of overview allocation holdings with the following details When P/L is negative AND holding ccy is the SAME

  @S293-AC10-AT2
  @SIT
  @DependsOn('P/L_is_negative_AND_holding_ccy_is_the_SAME_to_Overview_reference_currency')
  Scenario:Check ISO 3 code format in Overview holdings when P/L is negative AND holding ccy is the SAME to Overview reference currency
    Given I am on the allocation holding list
    Then I can see ISO 3 code of overview allocation holding currency When P/L is negative AND holding ccy is the SAME

    #  account level
  @SIT
  Scenario: P/L is positive AND holding ccy is DIFFERENT to Account reference currency
    Given I login as type "account_allocation_currency_holding_list_pl_positive_and_ccy_different"
    Then I should see the allocation holding list

  @S293-AC2-AT1
  @DependsOn('P/L_is_positive_AND_holding_ccy_is_DIFFERENT_to_Account_reference_currency')
  Scenario:Check P/L is positive AND holding ccy is DIFFERENT to Account reference currency
    Given I am on the allocation holding list
    Then I can see a list of account allocation holdings with the following details when P/L is positive AND holding ccy is DIFFERENT

  @S293-AC2-AT2
  @SIT
  @DependsOn('P/L_is_positive_AND_holding_ccy_is_DIFFERENT_to_Account_reference_currency')
  Scenario:Check ISO 3 code format in Account holdings when P/L is positive AND holding ccy is DIFFERENT to Account reference currency
    Given I am on the allocation holding list
    Then I can see ISO 3 code of account allocation holding currency、Account reference currency

  @SIT
  Scenario: P/L is negative AND holding ccy is DIFFERENT to Account reference currency
    Given I login as type "account_allocation_currency_holding_list_pl_negative_and_ccy_different"
    Then I should see the allocation holding list

  @S293-AC5-AT1
  @DependsOn('P/L_is_negative_AND_holding_ccy_is_DIFFERENT_to_Account_reference_currency')
  Scenario:Check P/L is negative AND holding ccy is DIFFERENT to Account reference currency
    Given I am on the allocation holding list
    Then I can see a list of account allocation holdings with the following details when P/L is negative AND holding ccy is DIFFERENT

  @S293-AC5-AT2
  @SIT
  @DependsOn('P/L_is_negative_AND_holding_ccy_is_DIFFERENT_to_Account_reference_currency')
  Scenario:Check ISO 3 code format in Account holdings when P/L is negative AND holding ccy is DIFFERENT to Account reference currency
    Given I am on the allocation holding list
    Then I can see ISO 3 code of account allocation holding currency、Account reference currency when P/L is negative AND holding ccy is DIFFERENT

  @SIT
  Scenario:P/L is positive AND holding ccy is the SAME to Account reference currency
    Given I login as type "account_allocation_currency_holding_list_pl_positive_and_ccy_same"
    Then I should see the allocation holding list

  @S293-AC8-AT1
  @DependsOn('P/L_is_positive_AND_holding_ccy_is_the_SAME_to_Account_reference_currency')
  Scenario:Check P/L is positive AND holding ccy is the SAME to Account reference currency
    Given I am on the allocation holding list
    Then I can see a list of account allocation holdings with the following details when P/L is positive AND holding ccy is the SAME

  @S293-AC8-AT2
  @SIT
  @DependsOn('P/L_is_positive_AND_holding_ccy_is_the_SAME_to_Account_reference_currency')
  Scenario:Check ISO 3 code format in Account holdings when  P/L is positive AND holding ccy is the SAME to Account reference currency
    Given I am on the allocation holding list
    Then I can see ISO 3 code of account allocation holding currency when P/L is positive AND holding ccy is the SAME

  @SIT
  Scenario:P/L is negative AND holding ccy is the SAME to Account reference currency
    Given I login as type "account_allocation_currency_holding_list_pl_negative_and_ccy_same"
    Then I should see the allocation holding list

  @S293-AC11-AT1
  @DependsOn('P/L_is_negative_AND_holding_ccy_is_the_SAME_to_Account_reference_currency')
  Scenario:Check P/L is negative AND holding ccy is the SAME to Account reference currency
    Given I am see the allocation holding list
    Then I can see a list of account allocation holdings with the following details when P/L is negative AND holding ccy is the SAME

  @S293-AC11-AT2
  @SIT
  @DependsOn('P/L_is_negative_AND_holding_ccy_is_the_SAME_to_Account_reference_currency')
  Scenario:Check ISO 3 code format in Account holdings when P/L is negative AND holding ccy is the SAME to Account reference currency
    Given I am on the allocation holding list
    Then I can see ISO 3 code of account allocation holding currency when P/L is negative AND holding ccy is the SAME

#  portfolio level
  @SIT
  Scenario: P/L is positive AND holding ccy is DIFFERENT to Portfolio reference currency
    Given I login as type "portfolio_allocation_currency_holding_list_pl_positive_and_ccy_different"
    Then I should see the allocation holding list

  @S293-AC3-AT1
  @DependsOn('P/L_is_positive_AND_holding_ccy_is_DIFFERENT_to_Portfolio_reference_currency')
  Scenario:Check P/L is positive AND holding ccy is DIFFERENT to Portfolio reference currency
    Given I am on the allocation holding list
    Then I can see a list of portfolio allocation holdings with the following details when P/L is positive AND holding ccy is DIFFERENT

  @S293-AC3-AT2
  @SIT
  @DependsOn('P/L_is_positive_AND_holding_ccy_is_DIFFERENT_to_Portfolio_reference_currency')
  Scenario:Check ISO 3 code format in Portfolio holdings when P/L is positive AND holding ccy is DIFFERENT to Portfolio reference currency
    Given I am on the allocation holding list
    Then I can see ISO 3 code of portfolio allocation holding currency、portfolio reference currency

  @SIT
  Scenario: P/L is negative AND holding ccy is DIFFERENT to Portfolio reference currency
    Given I login as type "portfolio_allocation_currency_holding_list_pl_negative_and_ccy_different"
    Then I should see the allocation holding list

  @S293-AC6-AT1
  @DependsOn('P/L_is_negative_AND_holding_ccy_is_DIFFERENT_to_Portfolio_reference_currency')
  Scenario:Check P/L is negative AND holding ccy is DIFFERENT to Portfolio reference currency
    Given I am on the allocation holding list
    Then Client can see a list of portfolio allocation holdings with the following details when P/L is negative AND holding ccy is DIFFERENT

  @S293-AC6-AT2
  @SIT
  @DependsOn('P/L_is_negative_AND_holding_ccy_is_DIFFERENT_to_Portfolio_reference_currency')
  Scenario:Check ISO 3 code format in Portfolio holdings when P/L is negative AND holding ccy is DIFFERENT to Portfolio reference currency
    Given I am on the allocation holding list
    Then I can se ISO 3 code of portfolio allocation holding currency、portfolio reference currency when P/L is negative AND holding ccy is DIFFERENT

  @SIT
  Scenario: P/L is positive AND holding ccy is the SAME to Portfolio reference currency
    Given I login as type "portfolio_allocation_currency_holding_list_pl_positive_and_ccy_same"
    Then I should see the allocation holding list

  @S293-AC9-AT1
  @DependsOn('P/L_is_positive_AND_holding_ccy_is_the_SAME_to_Portfolio_reference_currency')
  Scenario:Check P/L is positive AND holding ccy is the SAME to Portfolio reference currency
    Given I am on the allocation holding list
    Then I can see a list of portfolio allocation holdings with the following details when P/L is positive AND holding ccy is the SAME

  @S293-AC9-AT2
  @SIT
  @DependsOn('P/L_is_positive_AND_holding_ccy_is_the_SAME_to_Portfolio_reference_currency')
  Scenario:Check ISO 3 code format in Portfolio holdings when P/L is positive AND holding ccy is the SAME to Portfolio reference currency
    Given I am on the allocation holding list
    Then I can see ISO 3 code of portfolio allocation holding currency when P/L is positive AND holding ccy is the SAME

  @SIT
  Scenario:Check P/L is negative AND holding ccy is the SAME to Portfolio reference currency
    Given I login as type "portfolio_allocation_currency_holding_list_pl_negative_and_ccy_same"
    Then I should see the allocation holding list

  @S293-AC12-AT1
  @DependsOn('Check_P/L_is_negative_AND_holding_ccy_is_the_SAME_to_Portfolio_reference_currency')
  Scenario:Check P/L is negative AND holding ccy is the SAME to Portfolio reference currency
    Given I am on the allocation holding list
    Then I can see a list of portfolio allocation holdings with the following details when P/L is negative AND holding ccy is the SAME

  @S293-AC12-AT2
  @SIT
  @DependsOn('Check_P/L_is_negative_AND_holding_ccy_is_the_SAME_to_Portfolio_reference_currency')
  Scenario:Check ISO 3 code format in Portfolio holdings when P/L is negative AND holding ccy is the SAME to Portfolio reference currency
    Given I am on the allocation holding list
    Then I can see ISO 3 code of portfolio allocation holding currency when P/L is negative AND holding ccy is the SAME

  @S293-AC13-AT1
  Scenario:Check Client has no holdings
    Given I login as type "no_holding"
    When I tap on portfolio "Holdings" tab
    Then I should see the following message under the Contingent liabilities is displayed:
      | element name           | element value                                          |
      | Holdings title         | There are no holdings available within this portfolio. |
      | Android Holdings title | There are no holdings available within this portfolio. |
