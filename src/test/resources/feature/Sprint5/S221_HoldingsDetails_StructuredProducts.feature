@HK @SG @UK
@Epic_GPBM-1094(Holdings)
@Story_GPBM-1731 @Sprint5_iOS
@Story_GPBM-1817 @Sprint5_aOS
@Sprint19

Feature: Holdings details - Structured Products

  As a Client I want to see a detailed view regarding my Structured Products holdings,
  so that I can see all related information about the particular holding.

  @SIT
  Scenario: login in as userM for GPBM1731
    Given I login as type "portfolio_holding_detail_structured_products_part_1"
    Then I should on the Portfolios Holdings Details level

  @SIT
  @S221-AC1-AT1
  @DependsOn('login_in_as_userM_for_GPBM1731')
  Scenario: Check Holdings detail page for Structured Products
    Given I am on the Portfolios Holdings Details level
#    When Client taps on a holding in the holdings list which belongs to one of the following sub-asset classes:
#Interest Rates Linked Notes - 24
#Fixed Income Structured Products - 37
#Credit Linked Notes - 6
    Then I am taken to a Structured Products part1 detailed holdings screen displaying the following data:
      | element name                                             | element value                                                                                                                                                                                                                       |
      | Holding name value                                       |                                                                                                                                                                                                                                     |
      | ISIN value                                               |                                                                                                                                                                                                                                     |
      | Total value label                                        | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency                          |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency              |                                                                                                                                                                                                                                     |
      | Unrealised P/L                                           | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised profit/loss % value based on holding currency |                                                                                                                                                                                                                                     |
      | "Accrued Interest" label                                 | Accrued interest                                                                                                                                                                                                                    |
      | Accrued Interest value in holding currency               |                                                                                                                                                                                                                                     |
      | Nominal Amount label                                     | Nominal amount                                                                                                                                                                                                                      |
      | Nominal Amount value                                     |                                                                                                                                                                                                                                     |
      | Maturity Date label                                      | Maturity date                                                                                                                                                                                                                       |
      | Maturity Date value                                      |                                                                                                                                                                                                                                     |
      | Average Purchase Price label                             | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price % value                           |                                                                                                                                                                                                                                     |
      | Last Buy Date label                                      | Last buy date                                                                                                                                                                                                                       |
      | Last Buy Date value                                      |                                                                                                                                                                                                                                     |
      | Indicative Price label                                   | Indicative price                                                                                                                                                                                                                    |
      | Indicative Price (%) value                               |                                                                                                                                                                                                                                     |
      | Indicative Price Date label                              | Indicative price date                                                                                                                                                                                                               |
      | Indicative Price Date value                              |                                                                                                                                                                                                                                     |
      | Issuer                                                   | Issuer                                                                                                                                                                                                                              |
      | Issuer value                                             |                                                                                                                                                                                                                                     |
      | Rating Moody’s                                           | Rating Moody’s                                                                                                                                                                                                                      |
      | Rating Moody’s value                                     |                                                                                                                                                                                                                                     |
      | Rating S&P                                               | Rating S&P                                                                                                                                                                                                                          |
      | Rating S&P value                                         |                                                                                                                                                                                                                                     |
      | Disclaimer                                               | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |


  @SIT
  @S221-AC1-AT2
  @DependsOn('login_in_as_userM_for_GPBM1731')
  Scenario: Check date format in Holding detail page for Structured Products
    Given I am on the Portfolios Holdings Details level
    Then I can see Structured Products part1 detailed date value Format is "dd MMM yyyy"

  @SIT
  @S221-AC1-AT3
  @DependsOn('login_in_as_userM_for_GPBM1731')
  Scenario: Check data format in Holding detail page for Structured Products Part 1
    Given I am on the Portfolios Holdings Details level
    Then I should see the structured products following currency format:ISO 3


  @SIT
  Scenario: login in as userM for structured products part 2
    Given I login as type "portfolio_holding_detail_structured_products_part_2"
    Then I should on the Portfolios Holdings Details level

  @S221-AC2-AT1
  @DependsOn('login_in_as_userM_for_structured_products_part_2')
  Scenario: Check the Holdings detail page for Structured Products part 2
    Given I am on the Portfolios Holdings Details level

#    When Client taps on a holding in the holdings list which belongs to one of the following sub-asset classes:
#      Equity Linked Notes - 13
#      Hedge Fund Linked Notes - 2
#      Commodity Linked Notes - 63
#      Forex Linked Notes - 17
#      Other Structured Products - 29
#      Fund Linked Notes - 76
#      Forex Linked Structured Notes - 77
#      Other Structured Products (Islamic Products) - 84

    Then I am taken to a Structured Products part2 detailed holdings screen displaying the following data:
      | element name                                             | element value                                                                                                                                                                                                                       |
      | Holding name value                                       |                                                                                                                                                                                                                                     |
      | ISIN value                                               |                                                                                                                                                                                                                                     |
      | Total value label                                        | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency                          |                                                                                                                                                                                                                                     |
      | Total value in portfolio reference currency              |                                                                                                                                                                                                                                     |
      | Unrealised P/L                                           | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised profit/loss % value based on holding currency |                                                                                                                                                                                                                                     |
      | Nominal Amount label                                     | Nominal amount                                                                                                                                                                                                                      |
      | Nominal Amount value                                     |                                                                                                                                                                                                                                     |
      | Maturity Date label                                      | Maturity date                                                                                                                                                                                                                       |
      | Maturity Date value                                      |                                                                                                                                                                                                                                     |
      | Average Purchase Price label                             | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price % value                           |                                                                                                                                                                                                                                     |
      | Last Buy Date label                                      | Last buy date                                                                                                                                                                                                                       |
      | Last Buy Date value                                      |                                                                                                                                                                                                                                     |
      | Indicative Price label                                   | Indicative price                                                                                                                                                                                                                    |
      | Indicative Price (%) value                               |                                                                                                                                                                                                                                     |
      | Indicative Price Date label                              | Indicative price date                                                                                                                                                                                                               |
      | Indicative Price Date value                              |                                                                                                                                                                                                                                     |
      | Issuer                                                   | Issuer                                                                                                                                                                                                                              |
      | Issuer value                                             |                                                                                                                                                                                                                                     |
      | Rating Moody’s                                           | Rating Moody’s                                                                                                                                                                                                                      |
      | Rating Moody’s value                                     |                                                                                                                                                                                                                                     |
      | Rating S&P                                               | Rating S&P                                                                                                                                                                                                                          |
      | Rating S&P value                                         |                                                                                                                                                                                                                                     |
      | Disclaimer                                               | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @S221-AC2-AT2
  @SIT
  @DependsOn('login_in_as_userM_for_structured_products_part_2')
  Scenario: Check date format in Holding detail page for Structured Products Part 2
    Given I am on the Portfolios Holdings Details level
    Then I can see Structured Products part2 detailed date value Format is "dd MMM yyyy"

  @S221-AC2-AT3
  @SIT
  @DependsOn('login_in_as_userM_for_structured_products_part_2')
  Scenario: Check data format in Holding detail page for Structured Products Part 2
    Given I am on the Portfolios Holdings Details level
    Then I should see the structured products following currency format:ISO 3
