@HK @SG @UK
@Epic_GPBM-1094(Holdings)
@Story_GPBM-1738 @Sprint5_iOS
@Story_GPBM-1820 @Sprint5_aOS

Feature: Holdings details - Foreign Exchange(FX)

  As a Client I want to see a detailed view regarding my Foreign Exchange (FX) holdings,
  so that I can see all related information about the particular holding.

  @SIT
  Scenario: login in as userM for GPBM1738
    Given I login as type "portfolio_holding_detail_foreign_exchange(FX)"
    Then I should on the Portfolios Holdings Details level


  @S217-AC1-AT1
  @DependsOn('login_in_as_userM_for_GPBM1738')
  Scenario: Check Holdings detail page for FX
    Given I am on the Portfolios Holdings Details level
#    And I taps on a holding in the holdings list which belongs to one of the following sub-asset classes:
#    Foreign exchange - 48
    Then Client is taken to a detailed holdings foreign exchange screen displaying the following data:
      | element name                                                           | element value                                                                                                                                                                                                                       |
      | Holding name value                                                     |                                                                                                                                                                                                                                     |
      | Reference value                                                        |                                                                                                                                                                                                                                     |
      | Nominal Amount (Buy) label                                             | Buy                                                                                                                                                                                                                                 |
      | Nominal Amount value related to currency purchased in holding currency |                                                                                                                                                                                                                                     |
      | Nominal Amount (Sell) label                                            | Sell                                                                                                                                                                                                                                |
      | Nominal Amount value related to currency sold in holding currency      |                                                                                                                                                                                                                                     |
      | P/L label                                                              | P/L                                                                                                                                                                                                                                 |
      | Profit/Loss value                                                      |                                                                                                                                                                                                                                     |
      | Trade Date label                                                       | Trade date                                                                                                                                                                                                                          |
      | Trade date value                                                       |                                                                                                                                                                                                                                     |
      | Maturity Date label                                                    | Maturity date                                                                                                                                                                                                                       |
      | Maturity date value                                                    |                                                                                                                                                                                                                                     |
      | Deal Exchange Rate label                                               | Deal exchange rate                                                                                                                                                                                                                  |
      | Deal exchange rate value                                               |                                                                                                                                                                                                                                     |
      | Forward Mark to Market label                                           | Forward mark to market                                                                                                                                                                                                              |
      | Forward Mark to Market value                                           |                                                                                                                                                                                                                                     |
      | Disclaimer                                                             | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @S217-AC1-AT2
  @SIT
  @DependsOn('login_in_as_userM_for_GPBM1738')
  Scenario: Check currency format in Holdings detail page for FX
    Given I am on the Portfolios Holdings Details level
    Then I can see ISO 3 code of holdings foreign exchange currency

  @S217-AC1-AT3
  @SIT
  @DependsOn('login_in_as_userM_for_GPBM1738')
  Scenario: Check date format in Holdings detail page for FX
    Given I am on the Portfolios Holdings Details level
    Then I can see holdings foreign exchange date value Format is "dd MMM yyyy"