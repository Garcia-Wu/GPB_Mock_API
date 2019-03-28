@HK @SG @UK
@Epic_GPBM-1094(Holdings)
@Story_GPBM-1742 @Sprint5_iOS
@Story_GPBM-1864 @Sprint5_aOS

Feature:Holding list view
  As a Client I want to view a list of my holdings in a selected Portfolio,
  so that I get a high level view of all of my holdings.

  userM: has more account and portfolio

  @SIT
  Scenario: login in as userM for GPBM1420
    Given I login as type "holding_list_has_pl_and_ccy_different"
    And I tap on portfolio "Holdings" tab
    Then I should on the Portfolios level

# holding list ：3
  @S181-AC1-AT1
  @DependsOn('login_in_as_userM_for_GPBM1420')
  Scenario:Check the UI of Holding list when P/L figure is relevant AND holding ccy is DIFFERENT to portfolio reference currency
    Given I am on the Portfolios level
#    And that holding is in one of the following sub-asset classes:
  # Precious Metal - 32
  # Equities - 12
  # Preferred Shares - 33
  # Equities (Islamic Products) - 80
  # Interest Rates Linked Notes - 24
  # Fixed Income Structured Products - 37
  # Credit Linked Notes - 6
  # Equity Linked Notes - 13
  # Hedge Fund Linked Notes - 2
  # Commodity Linked Notes - 63
  # Forex Linked Notes - 17
  # Other Structured Products - 29
  # Fund Linked Notes - 76
  # Forex Linked Structured Notes - 77
  # Other Structured Products (Islamic Products) - 84
  # Currency Options - 52
  # Options on Fixed Income - 49
  # Credit Linked OTC Derivatives - 9
  # Interest Linked OTC Derivatives - 23
  # Equity Options - 50Future Options - 51
  # Metal Options - 53
  # Commodity Linked OTC Derivatives - 4
  # Other OTC Derivatives - 28
  # Fund Linked OTC Derivatives - 75
  # Warrant on Fixed Income - 40
  # Equity Warrant - 39
  # Other Warrant - 30
  # Short Term Investments - 36
  # Bank notes - 54
  # Time Deposits - 61
  # Fiduciary Deposits - 62
  # Bonds - 8Preferred Bonds - 79
  # Convertible Bonds - 6
  # Money Market Mutual Funds - 25
  # Money Market Mutual Funds (Islamic Products) - 88
  # Convertible Bonds Mutual Funds - 7
  # Fixed Income Mutual Funds - 16
  # Convertible Bonds Mutual Funds (Islamic Products) - 87
  # Fixed Income Mutual Funds (Islamic Products) - 86
  # Equity Mutual Fund - 15
  # Equity Mutual Fund (Islamic Products) - 85
  # Commodity Funds - 5Commodity Funds (Islamic Products) - 81
  # Other Mutual Funds - 27
  # Other Mutual Funds (Islamic Products) - 89
  # Hedge Funds - 1
  # Hedge Funds (Islamic Products) - 90
  # Futures on Forex - 22
  # Futures on Fixed Income - 21
  # Futures on Equity - 20
  # Futures on Commodities - 19
  # Foreign Exchange - 48
    Then I can see a list of holdings with the following details displayed


  @S181-AC1-AT2
  @SIT
  @DependsOn('login_in_as_userM_for_GPBM1420')
  Scenario:Check the ISO 3 format of holding currency and portfolio references currency in Holding lists when P/L figure is relevant AND holding ccy is DIFFERENT to portfolio reference currency
    Given I am on the Portfolios level
    Then I should see a list of holdings with the following ISO 3 format data

  @SIT
  Scenario: login in as user for P/L figure is relevant AND holding ccy is SAME to portfolio reference currency
    Given I login as type "holding_list_has_pl_and_ccy_same"
    And I tap on portfolio "Holdings" tab
    Then I should on the Portfolios level

# holding list ：5
  @S181-AC2-AT1
  @DependsOn('login_in_as_user_for_P/L_figure_is_relevant_AND_holding_ccy_is_SAME_to_portfolio_reference_currency')
  Scenario:Check the UI of Holding list when P/L figure is relevant AND holding ccy is the SAME as portfolio reference currency
    Given I am on the Portfolios level
#    And that holding is in one of the following sub-asset classes：
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
    Then I can see a list of holdings with the following details displayed with SAME

  @S181-AC2-AT2
  @SIT
  @DependsOn('login_in_as_user_for_P/L_figure_is_relevant_AND_holding_ccy_is_SAME_to_portfolio_reference_currency')
  Scenario:Check the ISO 3 format of holding currency when P/L figure is relevant AND holding ccy is the SAME as portfolio reference currency
    Given I am on the Portfolios level
    Then I should see the SAME following ISO 3 format data

  @SIT
  Scenario: login in as user for P/L figure is NOT relevant AND holding ccy is DIFFERENT to portfolio reference currency
    Given I login as type "holding_list_no_pl_and_ccy_different"
    And I tap on portfolio "Holdings" tab
    Then I should on the Portfolios level

# holding list ：1
  @S181-AC3-AT1
  @DependsOn('login_in_as_user_for_P/L_figure_is_NOT_relevant_AND_holding_ccy_is_DIFFERENT_to_portfolio_reference_currency')
  Scenario:Check the UI of Holding list when P/L figure is NOT relevant AND holding ccy is DIFFERENT to portfolio reference currency
    Given I am on the Portfolios level
#    And that holding is in one of the following sub-asset classes：
#  Current accounts - 58
#  Blocked current accounts - 60
#  Discretionary Mandates - 1
#  Interest Rate Swap - 43
#  Direct Investments (Private Equity) - 10
#  Promemoria - 74
#  Other - 31
#  Metal Ounces - 59
#  Call Deposit - 57
#  Murabaha Deposits (Islamic products) - 26
#  Private Equity Funds - 18
#  Private Equity Funds(Islamic Products) - 82
#  Real Estate Funds - 35
#  Real Estate Funds(Islamic Produnts) - 83
    Then I can see a list of holdings with the following details displayed when percentage is zero

  @S181-AC3-AT2
  @SIT
  @DependsOn('login_in_as_user_for_P/L_figure_is_NOT_relevant_AND_holding_ccy_is_DIFFERENT_to_portfolio_reference_currency')
  Scenario:Check the ISO 3 format of holding currency when P/L figure is NOT relevant AND holding ccy is DIFFERENT to portfolio reference currency
    Given I am on the Portfolios level
    Then I should see the holdings following ISO 3 format datas when percentage is zero

  @SIT
  Scenario: login in as user for P/L figure is NOT relevant AND holding ccy is the SAME as portfolio reference currency
    Given I login as type "holding_list_no_pl_and_ccy_same"
    When I tap on portfolio "Holdings" tab
    Then I should on the Portfolios level

# holding list ：3
  @S181-AC4-AT1
  @DependsOn('login_in_as_user_for_P/L_figure_is_NOT_relevant_AND_holding_ccy_is_the_SAME_as_portfolio_reference_currency')
  Scenario:Check the UI of Holding list when P/L figure is NOT relevant AND holding ccy is the SAME as portfolio reference currency
    Given I am on the Portfolios level
#    And that holding is in one of the following sub-asset classes：
#  Current accounts - 58
#  Blocked current accounts - 60
#  Discretionary Mandates - 1
#  Interest Rate Swap - 43
#  Direct Investments (Private Equity) - 10
#  Promemoria - 74
#  Other - 31
#  Metal Ounces - 59
#  Call Deposit - 57
#  Murabaha Deposits (Islamic products) - 26
#  Private Equity Funds - 18
#  Private Equity Funds(Islamic Products) - 82
#  Real Estate Funds - 35
#  Real Estate Funds(Islamic Produnts) - 83
    Then I can see a list of holdings with the following details displayed when percentage is zero and SAME

  @S181-AC4-AT2
  @SIT
  @DependsOn('login_in_as_user_for_P/L_figure_is_NOT_relevant_AND_holding_ccy_is_the_SAME_as_portfolio_reference_currency')
  Scenario:Check the ISO 3 format of holding currency when P/L figure is NOT relevant AND holding ccy is the SAME as portfolio reference currency
    Given I am on the Portfolios level
    Then I should see the holdings following ISO 3 format datas when percentage is zero and SAME

  @S181-AC1-AT3
  @SIT
  @DependsOn('login_in_as_user_for_P/L_figure_is_NOT_relevant_AND_holding_ccy_is_the_SAME_as_portfolio_reference_currency')
  Scenario:Check the sequnce of holding list items
    Given I am on the Portfolios level
    Then I should see the holdings list items are ordered largest to smallest based on market value in portfolio references currency

  @S181-AC5-AT1
  Scenario:Check the tipMessage when client has no holdings
    Given I login as type "no_holding"
    Then I should see the following message under the holdings is displayed:
      | element name           | element value                                          |
      | Holdings title         | There are no holdings available within this portfolio. |
      | Android Holdings title | There are no holdings available within this portfolio. |

#  contingent liability bar remove update
#  @S181-AC5-AT2
#  Scenario:Check the tipMessage when client has no holdings but has contingent liability bar
#    Given I login as User
#      | element name | element value |
#      | Name         | userE         |
#    When I tap first item of Accounts list
#    And I tap thirdly item of Portfolios list
#    And I tap on portfolio "Holdings" tab
#    Then I should see the following message under the Contingent liabilities is displayed:
#      | element name           | element value                                          |
#      | Holdings title         | There are no holdings available within this portfolio. |
#      | Android Holdings title | There are no holdings available within this portfolio. |
#    And I should see Contingent liabilities bar is displayed
#    update sprint 6 Hide Contingent Liabilities in Portfolio