@HK @SG @UK
@Epic_GPBM-1094(Holdings)
@Story_GPBM-1735 @Sprint5_iOS
@Story_GPBM-1819 @Sprint5_aOS

Feature: Holdings details - Futures
  As a Client I want to see a detailed view regarding my Futures,
  so that I can see all related information about the particular holding.

  @SIT
  Scenario: login in as userM for GPBM1735
    Given I login as type "portfolio_holding_detail_futures"
    Then I should on the Portfolios Holdings Details level

  @S216-AC1-AT1
  @DependsOn('login_in_as_userM_for_GPBM1735')
  Scenario:Check the Holdings detail page for Futures
    Given I am on the Portfolios Holdings Details level
#    When Client taps on a holding in the holding list which belongs to one of  the following sub-asset classes
#  Futures on Fixed - 22
#  Futures on Fixed Incone - 21
#  Futures on Equity - 20
#  Futures on Commodies - 19
    Then I am taken to detailed holdings futures screen displaying the following data:
      | element name                                        | element value                                                                                                                                                                                                                       |
      | Holding name                                        |                                                                                                                                                                                                                                     |
      | ISIN value                                          |                                                                                                                                                                                                                                     |
      | "Number of contracts" label                         | Number of contracts                                                                                                                                                                                                                 |
      | Number of contracts value                           |                                                                                                                                                                                                                                     |
      | "Expiry date" label                                 | Expiry date                                                                                                                                                                                                                         |
      | Expiry date value                                   |                                                                                                                                                                                                                                     |
      | "Unrealised P/L" label                              | P/L                                                                                                                                                                                                                                 |
      | Profit/Loss value based on holding currency as a %  |                                                                                                                                                                                                                                     |
      | "Average transaction price" label                   | Average transaction price                                                                                                                                                                                                           |
      | Average transaction price value in holding currency |                                                                                                                                                                                                                                     |
      | "Last transaction date" label                       | Last transaction date                                                                                                                                                                                                               |
      | Last transaction date value                         |                                                                                                                                                                                                                                     |
      | "Last contract price" label                         | Last contract price                                                                                                                                                                                                                 |
      | Last contract price value in holding currency       |                                                                                                                                                                                                                                     |
      | "Indicative contract price date" label              | Indicative contract price date                                                                                                                                                                                                      |
      | Indicative contract price date value                |                                                                                                                                                                                                                                     |
      | Disclaimer                                          | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |


  @S216-AC1-AT2
  @SIT
  @DependsOn('login_in_as_userM_for_GPBM1735')
  Scenario:Check currency format in Holdings detail page for Futures
    Given I am on the Portfolios Holdings Details level
    Then I should see ISO 3 code of holding futures currency

  @S216-AC1-AT3
  @SIT
  @DependsOn('login_in_as_userM_for_GPBM1735')
  Scenario:Check date format in Holding detail page for Futures
    Given I am on the Portfolios Holdings Details level
    Then I should see the holdings futures following datas
