@HK @SG @UK
@Epic_GPBM-1094(Holdings)
@Story_GPBM-1736 @Sprint5_iOS
@Story_GPBM-1816 @Sprint5_aOS

Feature: Holdings details - Funds
  As a Client I want to see a detailed view regarding my fund holdings,
  so that I can see all related information about the particular holding.

  @SIT
  Scenario: login in as userM for GPBM1736
    Given I login as type "portfolio_holding_detail_funds_part_1"
    Then I should on the Portfolios Holdings Details level


  @S210-AC1-AT1
  @DependsOn('login_in_as_userM_for_GPBM1736')
  Scenario:Check the UI of Holdings detail page for Funds(part 1)
    Given I am on the Portfolios Holdings Details level
#    When I taps on a holding in the holdings list which belongs to one of the following sub-asset classes:
#  Money Market Mutual Funds - 25
#  Money Market Mutual Funds (Islamic Products) - 88
#  Convertible Bonds Mutual Funds - 7
#  Fixed Income Mutual Funds - 16
#  Convertible Bonds Mutual Funds (Islamic Products) - 87
#  Fixed Income Mutual Funds (Islamic Products) - 86
#  Equity Mutual Fund - 15
#  Equity Mutual Fund (Islamic Products) - 85
#  Commodity Funds - 5Commodity Funds (Islamic Products) - 81
#  Other Mutual Funds - 27
#  Other Mutual Funds (Islamic Products) - 89
#  Hedge Funds - 1
#  Hedge Funds (Islamic Products) - 90
    Then I am taken to a detailed holdings funds screen displaying the following data:
      | element name                                            | element value                                                                                                                                                                                                                       |
      | Holding name value                                      |                                                                                                                                                                                                                                     |
      | ISIN value                                              |                                                                                                                                                                                                                                     |
      | "Units" label                                           | Units                                                                                                                                                                                                                               |
      | Units value                                             |                                                                                                                                                                                                                                     |
      | "Total value" label                                    | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency                        |                                                                                                                                                                                                                                     |
      | Market value in portfolio reference currency            |                                                                                                                                                                                                                                     |
      | "Unrealised P/L" label                                  | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised Profit/Loss based on holding currency as a % |                                                                                                                                                                                                                                     |
      | "Average purchase price" label                          | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price value                            |                                                                                                                                                                                                                                     |
      | "Last purchase date" label                              | Last purchase date                                                                                                                                                                                                                  |
      | Last purchase Date value                                |                                                                                                                                                                                                                                     |
      | "Market price" label                                    | Market price                                                                                                                                                                                                                        |
      | Market price value in holding currency                  |                                                                                                                                                                                                                                     |
      | "Market price date" label                               | Market price date                                                                                                                                                                                                                   |
      | Market price date value                                 |                                                                                                                                                                                                                                     |
      | "Sector" label                                          | Sector                                                                                                                                                                                                                              |
      | Sector value                                            |                                                                                                                                                                                                                                     |
      | Disclaimer                                              | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |


  @S210-AC1-AT2
  @SIT
  @DependsOn('login_in_as_userM_for_GPBM1736')
  Scenario:Check the ISO 3 format of holding currency and portfolio references currency in Holdings detail page for Funds(part 1)
    Given I am on the Portfolios Holdings Details level
    Then I should see the holdings funds following ISO 3 format datas:holding currency、reference currency、Market value in holding currency、Market value in portfolio reference currency、Market price value in holding currency


  @S210-AC1-AT3
  @SIT
  @DependsOn('login_in_as_userM_for_GPBM1736')
  Scenario:Check the dd Mmm yyyy format of Market Price Date value  and Last buy Date value in Holdings detail page for Funds(part 1)
    Given I am on the Portfolios Holdings Details level
    Then I should see the holdings funds date following datas:Market Price Date、Last buy Date

  @SIT
  Scenario: login in as userM for Funds part 2
    Given I login as type "portfolio_holding_detail_funds_part_2"
    Then I should on the Portfolios Holdings Details level

  @S210-AC2-AT1
  @DependsOn('login_in_as_userM_for_Funds_part_2')
  Scenario:Check the UI of Holdings detail page for Funds(part 2)
    Given I am on the Portfolios Holdings Details level
#    When I taps on a holding in the holdings list which belongs to one of the following sub-asset classes:
#  Discretionary Mandates - 1
    Then I am taken to a detailed holdings funds part2 screen displaying the following data:
      | element name                                 | element value                                                                                                                                                                                                                       |
      | Holding name value                           |                                                                                                                                                                                                                                     |
      | ISIN value                                   |                                                                                                                                                                                                                                     |
      | "Total value" label                         | Total value                                                                                                                                                                                                                        |
      | Market value in holding currency             |                                                                                                                                                                                                                                     |
      | Market value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | "Market price" label                         | Market price                                                                                                                                                                                                                        |
      | Market price value in holding currency       |                                                                                                                                                                                                                                     |
      | "Market price date" label                    | Market price date                                                                                                                                                                                                                   |
      | Market price date value                      |                                                                                                                                                                                                                                     |
      | "Amount" label                               | Amount                                                                                                                                                                                                                              |
      | Amount value                                 |                                                                                                                                                                                                                                     |
      | "Last purchase date" label                   | Last purchase date                                                                                                                                                                                                                  |
      | Last purchase date value                     |                                                                                                                                                                                                                                     |
      | "Sector" label                               | Sector                                                                                                                                                                                                                              |
      | Sector value                                 |                                                                                                                                                                                                                                     |
      | Disclaimer                                   | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |


  @S210-AC2-AT2
  @SIT
  @DependsOn('login_in_as_userM_for_Funds_part_2')
  Scenario:Check the ISO 3 format of holding currency and portfolio references currency in Holdings detail page for Funds(part 2)
    Given I am on the Portfolios Holdings Details level
    Then I should see the holdings funds part2 following ISO 3 format datas:holding currency、reference currency、Market value in holding currency、Market value in portfolio reference currency、Market price value in holding currency


  @S210-AC2-AT3
  @SIT
  @DependsOn('login_in_as_userM_for_Funds_part_2')
  Scenario:Check the dd Mmm yyyy format of Market Price Date value  and Last buy Date value in Holdings detail page for Funds(part 2)
    Given I am on the Portfolios Holdings Details level
    Then I should see the holdings funds part2 date following datas:Market Price Date、Last buy Date


