@HK @SG @UK
@Epic_GPBM-1094(Holdings)
@Story_GPBM-1737 @Sprint5_iOS
@Story_GPBM-1967 @Sprint5_aOS
@Sprint19

Feature: Holdings details - Deposits

  As a Client I want to see a detailed view regarding my Deposit holdings,
  so that I can see all related information about the particular holding.

  @SIT
  Scenario: login in as userM for GPBM1737
    Given I login as type "portfolio_holding_detail_deposits"
    Then I should on the Portfolios Holdings Details level

  @S219-AC1-AT1
  @DependsOn('login_in_as_userM_for_GPBM1737')
  Scenario: Check Holdings detail page for Deposits
    Given I am on the Portfolios Holdings Details level
#    When Client taps on a holding in the holdings list which belongs to one of the following sub-asset classes:
#    Bank notes - 54
#    Time Deposits - 61
#    Fiduciary Deposits - 62
    Then I am taken to a detailed holdings deposits1 screen displaying the following data:
      | element name                                | element value                                                                                                                                                                                                                       |
      | Holding name value                          |                                                                                                                                                                                                                                     |
      | Reference value                             |                                                                                                                                                                                                                                     |
      | Total value label                           | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency             |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | Accrued Interest label                      | Accrued interest                                                                                                                                                                                                                    |
      | Accrued Interest value in holding currency  |                                                                                                                                                                                                                                     |
#      | Amount At Maturity label                     | Amount At Maturity                                                                                                                                           |
#      | Amount At Maturity value in holding currency |                                                                                                                                                              |
      | Balance label                               | Balance                                                                                                                                                                                                                             |
      | Balance value                               |                                                                                                                                                                                                                                     |
      | Maturity Date label                         | Maturity date                                                                                                                                                                                                                       |
      | Maturity date value                         |                                                                                                                                                                                                                                     |
      | Disclaimer                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @S219-AC1-AT2
  @SIT
  @DependsOn('login_in_as_userM_for_GPBM1737')
  Scenario: Check date format in Holdings detail page for Deposits
    Given I am on the Portfolios Holdings Details level
    Then I can see deposits1 date value Format is "dd MMM yyyy"

  @S219-AC1-AT3
  @SIT
  @DependsOn('login_in_as_userM_for_GPBM1737')
  Scenario: Check currency format in Holdings detail page for Deposits
    Given I am on the Portfolios Holdings Details level
    Then I can see ISO 3 code of holdings deposits1 currency

  @SIT
  Scenario: login in as userM for deposits2
    Given I login as type "portfolio_holding_detail_deposits2"
    Then I should on the Portfolios Holdings Details level

  @S219-AC2-AT1
  @DependsOn('login_in_as_userM_for_deposits2')
  Scenario: Check Holdings detail page for Short term investments
    Given I am on the Portfolios Holdings Details level
#    When Client taps on a Holdingsng in the holdings list which belongs to one of the following sub-asset classes:
#      Short Term Investments - 36
    Then I am taken to a detailed holdings deposits2 screen displaying the following data:
      | element name                                       | element value                                                                                                                                                                                                                       |
      | Holding name value                                 |                                                                                                                                                                                                                                     |
      | Reference value                                    |                                                                                                                                                                                                                                     |
      | Total value label                                  | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency                    |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency        |                                                                                                                                                                                                                                     |
      | Unrealised P/L label                               | Unrealised P/L                                                                                                                                                                                                                      |
      | Profit/Loss value as a % based on holding currency |                                                                                                                                                                                                                                     |
      | Accrued Interest label                             | Accrued interest                                                                                                                                                                                                                    |
      | Accrued Interest value in holding currency         |                                                                                                                                                                                                                                     |
      | Balance label                                      | Balance                                                                                                                                                                                                                             |
      | Balance value                                      |                                                                                                                                                                                                                                     |
      | Average Price label                                | Average price                                                                                                                                                                                                                       |
      | Average Price value in holding currency            |                                                                                                                                                                                                                                     |
      | Last Purchase Date                                 | Last purchase date                                                                                                                                                                                                                  |
      | Last Purchase Date value                           |                                                                                                                                                                                                                                     |
#      | Amount At Maturity label                           | Amount At Maturity                                                                                                                                           |
#      | Amount At Maturity value in holding currency       |                                                                                                                                                              |
      | Maturity Date label                                | Maturity date                                                                                                                                                                                                                       |
      | Maturity date value                                |                                                                                                                                                                                                                                     |
      | Disclaimer                                         | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @S219-AC2-AT2
  @SIT
  @DependsOn('login_in_as_userM_for_deposits2')
  Scenario:  Check date format in Holdings detail page for Short term investments
    Given I am on the Portfolios Holdings Details level
    Then I can see holdings deposits2 date value Format is "dd MMM yyyy"

  @S219-AC2-AT3
  @SIT
  @DependsOn('login_in_as_userM_for_deposits2')
  Scenario: Check currency format in Holdings detail page for Short term investments
    Given I am on the Portfolios Holdings Details level
    Then I can see ISO 3 code of holdings deposits2 currency


  @SIT
  Scenario: login in as userM for deposits3
    Given I login as type "portfolio_holding_detail_deposits3"
    Then I should on the Portfolios Holdings Details level

  @S219-AC3-AT1
  @DependsOn('login_in_as_userM_for_deposits3')
  Scenario: Check Holdings detail page for Deposits (Call)
    Given I am on the Portfolios Holdings Details level
#    When Client taps on a holding in the holdings list which belongs to one of the following sub-asset classes:
#Call Deposits - 57
    Then I am taken to a detailed holdings deposits3 screen displaying the following data:
      | element name                                | element value                                                                                                                                                                                                                       |
      | Holding name value                          |                                                                                                                                                                                                                                     |
      | Reference value                             |                                                                                                                                                                                                                                     |
      | Total value label                           | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency             |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | Accrued Interest label                      | Accrued interest                                                                                                                                                                                                                    |
      | Accrued Interest value in holding currency  |                                                                                                                                                                                                                                     |
      | Balance label                               | Balance                                                                                                                                                                                                                             |
      | Balance value                               |                                                                                                                                                                                                                                     |
      | Disclaimer                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

#    Deposits (Call) not have date
#  @S219-AC3-AT2
#  @DependsOn('login_in_as_userM_for_deposits3')
#  Scenario: Check date format in Holdings detail page for Deposits (Call)
#    Given I am on the Portfolios Holdings Details level
#    Then I can see holdings deposits3 date value Format is "dd MMM yyyy"

  @S219-AC3-AT3
  @SIT
  @DependsOn('login_in_as_userM_for_deposits3')
  Scenario: Check currency format in Holdings detail page for Deposits (Call)
    Given I am on the Portfolios Holdings Details level
    Then I can see ISO 3 code of holdings deposits3 currency

  @SIT
  Scenario: login in as userM for deposits4
    Given I login as type "portfolio_holding_detail_deposits4"
    Then I should on the Portfolios Holdings Details level

  @S219-AC4-AT1
  @DependsOn('login_in_as_userM_for_deposits4')
  Scenario: Check Holdings detail page for Deposits (Islamic products)
    Given I am on the Portfolios Holdings Details level
#    When Client taps on a holding in the holdings list which belongs to one of the following sub-asset classes:
#    Murabaha Deposits (Islamic products) - 26
    Then I am taken to a detailed holdings deposits4 screen displaying the following data:
      | element name                                | element value                                                                                                                                                                                                                       |
      | Holding name value                          |                                                                                                                                                                                                                                     |
      | ISIN value                                  |                                                                                                                                                                                                                                     |
      | Total value label                           | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency             |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | Accrued Profit label                        | Accrued profit                                                                                                                                                                                                                      |
      | Accrued Profit value in holding currency    |                                                                                                                                                                                                                                     |
      | Balance label                               | Balance                                                                                                                                                                                                                             |
      | Balance value                               |                                                                                                                                                                                                                                     |
#      | Amount At Maturity label                     | mount At Maturity                                                                                                                                            |
#      | Amount At Maturity value in holding currency |                                                                                                                                                              |
      | Maturity Date label                         | Maturity date                                                                                                                                                                                                                       |
      | Maturity date value                         |                                                                                                                                                                                                                                     |
      | Average Price label                         | Average price                                                                                                                                                                                                                       |
      | Average Price value in holding currency     |                                                                                                                                                                                                                                     |
      | Last Purchase Date                          | Last purchase date                                                                                                                                                                                                                  |
      | Last Purchase Date value                    |                                                                                                                                                                                                                                     |
      | Disclaimer                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @S219-AC4-AT2
  @SIT
  @DependsOn('login_in_as_userM_for_deposits4')
  Scenario: Check date format in Holdings detail page for Murabaha Deposits (Islamic products)
    Given I am on the Portfolios Holdings Details level
    Then I can see holdings deposits4 date value Format is "dd MMM yyyy"

  @S219-AC4-AT3
  @SIT
  @DependsOn('login_in_as_userM_for_deposits4')
  Scenario: Check currency format in Holdings detail page for Deposits (Islamic products)
    Given I am on the Portfolios Holdings Details level
    Then I can see ISO 3 code of holdings deposits4 currency