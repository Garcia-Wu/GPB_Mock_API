@HK @SG @UK
@Epic_GPBM-1094(Holdings)
@Story_GPBM-1734 @Sprint5_iOS
@Story_GPBM-1811 @Sprint5_aOS

Feature: Holdings details - Derivatives
  As a Client I want to see a detailed view regarding my Derivative holdings,
  so that I can see all related information about the particular holding.

  @SIT
  Scenario: login in as userM for GPBM1734
    Given I login as type "portfolio_holding_detail_derivatives_part_1"
    Then I should on the Portfolios Holdings Details level

  @S213-AC1-AT1
  @DependsOn('login_in_as_userM_for_GPBM1734')
  Scenario:Check the UI of Holdings detail page for Derivatives part 1
    Given I am on the Portfolios Holdings Details level
#    When I taps on a holding in the holdings list which belongs to one of the following sub-asset classes:
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
    Then I am taken to a detailed holdings derivatives1 screen displaying the following data:
      | element name                                      | element value                                                                                                                                                                                                                       |
      | Holding name value                                |                                                                                                                                                                                                                                     |
      | ISIN value                                        |                                                                                                                                                                                                                                     |
      | "Quantity" label                                  | Quantity                                                                                                                                                                                                                            |
      | Quantity value                                    |                                                                                                                                                                                                                                     |
      | "Expiry date" label                               | Expiry date                                                                                                                                                                                                                         |
      | Expiry date value                                 |                                                                                                                                                                                                                                     |
      | "Market value" (label)                            | Market value                                                                                                                                                                                                                        |
      | Market value in holding currency                  |                                                                                                                                                                                                                                     |
      | Market value in portfolio reference currency      |                                                                                                                                                                                                                                     |
      | "Unrealised P/L" label                            | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised Profit/Loss value                      |                                                                                                                                                                                                                                     |
      | "Average option premium" label                    | Average option premium                                                                                                                                                                                                              |
      | Average option premium value                      |                                                                                                                                                                                                                                     |
      | "Last transaction date" label                     | Last transaction date                                                                                                                                                                                                               |
      | Last transaction date value                       |                                                                                                                                                                                                                                     |
      | "Indicative market price" label                   | Indicative market price                                                                                                                                                                                                             |
      | Indicative market price value in holding currency |                                                                                                                                                                                                                                     |
      | "Indicative market price date" label              | Indicative market price date                                                                                                                                                                                                        |
      | Indicative market price date value                |                                                                                                                                                                                                                                     |
      | Disclaimer                                        | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |


  @S213-AC1-AT2
  @SIT
  @DependsOn('login_in_as_userM_for_GPBM1734')
  Scenario:Check the ISO  3 format of holding currency and portfolio referebce currency in Holdings detail page for Derivatives part 1
    Given I am on the Portfolios Holdings Details level
    Then I should see the holdings derivatives1 following ISO 3 format data:holding currency、portfolio reference currency、Market value in portfolio reference currency、Indicative market price value in holding currency

  @S213-AC1-AT3
  @SIT
  @DependsOn('login_in_as_userM_for_GPBM1734')
  Scenario:Check the dd Mmm yyyy format of Expiry Date value and Last Transaction Date value and Indicative Market Price Date value  in Holdings detail page for Derivatives part 1
    Given I am on the Portfolios Holdings Details level
    Then I should see the holdings derivatives1 following data:Expiry date value、Last transaction date、Indicative market price date


  @SIT
  Scenario: login in as userM for Derivatives part 2
    Given I login as type "portfolio_holding_detail_derivatives_part_2"
    Then I should on the Portfolios Holdings Details level

  @S213-AC2-AT1
  @DependsOn('login_in_as_userM_for_Derivatives_part_2')
  Scenario:Check the UI of Holdings detail page for Derivatives part 2
    Given I am on the Portfolios Holdings Details level
#    When I taps on a holding in the holdings list which belongs to one of the following sub-asset classes:
#  Warrant on Fixed Income - 40
#  Equity Warrant - 39
#  Other Warrant - 30
    Then I am taken to a detailed holdings derivatives2 screen displaying the following data:
      | element name                                      | element value                                                                                                                                                                                                                       |
      | Holding name value                                |                                                                                                                                                                                                                                     |
      | ISIN value                                        |                                                                                                                                                                                                                                     |
      | "Total value" label                              | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency                  |                                                                                                                                                                                                                                     |
      | Market value in portfolio reference currency      |                                                                                                                                                                                                                                     |
      | "Unrealised P/L" label                            | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised Profit/Loss value                      |                                                                                                                                                                                                                                     |
      | "Notional amount" label                           | Notional amount                                                                                                                                                                                                                     |
      | Notional amount value                             |                                                                                                                                                                                                                                     |
      | "Maturity date" label                             | Maturity date                                                                                                                                                                                                                       |
      | Maturity date value                               |                                                                                                                                                                                                                                     |
      | "Average premium paid" label                      | Average premium paid                                                                                                                                                                                                                |
      | Average premium paid value                        |                                                                                                                                                                                                                                     |
      | "Last purchase date" label                        | Last purchase date                                                                                                                                                                                                                  |
      | Last purchase date value                          |                                                                                                                                                                                                                                     |
      | "Indicative market price" label                   | Indicative market price                                                                                                                                                                                                             |
      | Indicative market price value in holding currency |                                                                                                                                                                                                                                     |
      | "Indicative market price date" label              | Indicative market price date                                                                                                                                                                                                        |
      | Indicative market price date value                |                                                                                                                                                                                                                                     |
      | Disclaimer                                        | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @S213-AC2-AT2
  @SIT
  @DependsOn('login_in_as_userM_for_Derivatives_part_2')
  Scenario:Check the ISO 3 format of holding currency and portfolio referebce currency in Holdings detail page for Derivatives part 2
    Given I am on the Portfolios Holdings Details level
    Then I should see the holdings derivatives2 following ISO 3 format datas:holding currency、portfolio reference currency、Market value in portfolio reference currency、Indicative market price value in holding currency

  @S213-AC2-AT3
  @SIT
  @DependsOn('login_in_as_userM_for_Derivatives_part_2')
  Scenario:Check the dd Mmm yyyy format of Expiry Date value and Last Transaction Date value and Indicative Market Price Date value  in Holdings detail page for Derivatives part 2
    Given I am on the Portfolios Holdings Details level
    Then I should see the holdings derivatives2 following datas:Maturity date、Last purchase date、Indicative market price date

