@HK @SG @UK
@Epic_GPBM-1094(Holdings)
@Story_GPBM-1730 @Sprint5_iOS
@Story_GPBM-1749 @Sprint5_aOS

Feature: Holdings details - Equities
  As a Client I want to see a detailed view regarding my Equity holdings,
  so that I can see all related information about the particular holding.

  @SIT
  Scenario: login in as userM for GPBM1730
    Given I login as type "portfolio_holding_detail_equities"
    Then I should on the Portfolios Holdings Details level

  @S208-AC1-AT1
  @DependsOn('login_in_as_userM_for_GPBM1730')
  Scenario:Check the UI of Holdings detail page for Equities
    Given I am on the Portfolios Holdings Details level
#    When I taps on a holding in the holdings list which belongs to one of the following sub-asset classes:
#  Equities - 12
#  Preferred Shares - 33
#  Equities (Islamic Products) - 80
    Then I am taken to a Equities detailed holdings screen displaying the following data:
      | element name                                                  | element value                                                                                                                                                                                                                       |
      | Holdings name                                                 |                                                                                                                                                                                                                                     |
      | "Number of shares" label                                      | Number of shares                                                                                                                                                                                                                    |
      | Number of shares value                                        |                                                                                                                                                                                                                                     |
      | ISIN value                                                    |                                                                                                                                                                                                                                     |
      | "Total value" label                                          | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency                              |                                                                                                                                                                                                                                     |
      | Market value in portfolio reference currency                  |                                                                                                                                                                                                                                     |
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

  @S208-AC1-AT2
  @SIT
  @DependsOn('login_in_as_userM_for_GPBM1730')
  Scenario:Check the ISO 3 format of holding currency and portfolio reference currency in in Holdings detail page for Equities
    Given I am on the Portfolios Holdings Details level
    Then I should see the following ISO 3 format in Equities detail datas:
      | element name                                                   | element value |
      | Market value of ISO 3 code in holding currency                 |               |
      | Market value of ISO 3 code in portfolio reference currency     |               |
      | Average Purchase Price value of ISO 3 code in holding currency |               |

  @S208-AC1-AT3
  @SIT
  @DependsOn('login_in_as_userM_for_GPBM1730')
  Scenario:Check the format of Last Closing Price Date value and Last buy Date value in Holdings detail page for Equities
    Given I am on the Portfolios Holdings Details level
    Then I should see the following date format in Equities detail datas:
      | element name             | element value |
      | Last purchase Date value | dd Mmm yyyy   |
      | Market price Date value  | dd Mmm yyyy   |

