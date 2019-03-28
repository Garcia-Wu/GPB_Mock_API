@HK @SG @UK
@Epic_GPBM-1094(Holdings)
@Story_GPBM-1733 @Sprint5_iOS
@Story_GPBM-1818 @Sprint5_aOS

Feature: Holdings details - Holdings details - Interest Rate Swaps
  As a Client I want to see a detailed view regarding my Interest rate swap holdings,
  so that I can see all related information about the particular holding.

  @SIT
  Scenario: login in as userM for GPBM1733
    Given I login as type "portfolio_holding_detail_interest_rate_swaps"
    Then I should on the Portfolios Holdings Details level


  @S215-AC1-AT1
  @DependsOn('login_in_as_userM_for_GPBM1733')
  Scenario:Check the UI of Holdings detail page for Interest rate swaps
    Given I am on the Portfolios Holdings Details level
#    When I taps on a holding in the holdings list which belongs to one of the following sub-asset classes:
#  Interest Rate Swap - 43
    Then I am taken to a detailed holdings interest rate swaps screen displaying the following data:
      | element name                                 | element value                                                                                                                                                                                                                       |
      | Holding name value                           |                                                                                                                                                                                                                                     |
      | ISIN value                                   |                                                                                                                                                                                                                                     |
      | "Total value" label                         | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency             |                                                                                                                                                                                                                                     |
      | Market value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | "Expiry date" label                          | Expiry date                                                                                                                                                                                                                         |
      | Expiry date value                            |                                                                                                                                                                                                                                     |
      | "Notional amount" label                      | Notional amount                                                                                                                                                                                                                     |
      | Notional amount value                        |                                                                                                                                                                                                                                     |
#      | "Fixed rate" label                           | Fixed rate                                                                                                                                                   |
#      | Fixed rate value (%)                         |                                                                                                                                                              |
      | "Indicative price" label                     | Indicative price                                                                                                                                                                                                                    |
      | Indicative price value in holding currency   |                                                                                                                                                                                                                                     |
      | "Indicative price date" label                | Indicative price date                                                                                                                                                                                                               |
      | Indicative price date value                  |                                                                                                                                                                                                                                     |
      | Disclaimer                                   | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @S215-AC1-AT2
  @SIT
  @DependsOn('login_in_as_userM_for_GPBM1733')
  Scenario:Check the ISO 3 format of holding currency and portfolio reference currency in Holdings detail page for Interest rate swaps
    Given I am on the Portfolios Holdings Details level
    Then I should see the holdings interest rate swaps following ISO 3 format datas:holding currency、portfolio reference currency、Market value in holding currency、Market value in portfolio reference currency、Indicative price value in holding currency

  @S215-AC1-AT3
  @SIT
  @DependsOn('login_in_as_userM_for_GPBM1733')
  Scenario:Check the dd Mmm yyyy format of Indicative Price Date value and Expiry date value in Holdings detail page for Interest rate swaps
    Given I am on the Portfolios Holdings Details level
    Then I should see the holdings interest rate swaps following datas:Indicative Price Date、Expiry date
