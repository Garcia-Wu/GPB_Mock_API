@HK @SG @UK
@Epic_GPBM-1094(Holdings)
@Story_GPBM-1727 @Sprint5_iOS
@Story_GPBM-1740 @Sprint5_aOS

Feature: Holding detail - Precious metals
  As a Client I want to see a detailed view regarding my Precious metal holdings,
  so that I can see all related information about the particular holding.

  @SIT
  Scenario: login in as userM for GPBM1727
    Given I login as type "portfolio_holding_detail_precious_metals"
    Then I should on the Portfolios Holdings Details level

  @S209-AC1-AT1
  @DependsOn('login_in_as_userM_for_GPBM1727')
  Scenario:Check the UI of Holding detail page for Precious metal investment
    Given I am on the Portfolios Holdings Details level
#    When I taps on a holding in the holdings list which belongs to the folllwing sub-asset class:
#  Precious Metal - 32
    Then I am taken to a Precious metals detailed holdings screen displaying the following data:
      | element name                                                 | element value                                                                                                                                                                                                                       |
      | Holding name value                                           |                                                                                                                                                                                                                                     |
      | ISIN value                                                   |                                                                                                                                                                                                                                     |
      | “Quantity” label                                             | Quantity                                                                                                                                                                                                                            |
      | “Quantity” value                                             |                                                                                                                                                                                                                                     |
      | "Unrealised P/L" label                                       | Unrealised P/L                                                                                                                                                                                                                      |
      | Unrealised Profit/Loss value in holding currency as a%       |                                                                                                                                                                                                                                     |
      | “Total value” label                                       | Market value                                                                                                                                                                                                                        |
      | Market value in holding currency                             |                                                                                                                                                                                                                                     |
      | Market value in portfolio reference currency within braclets |                                                                                                                                                                                                                                     |
      | "Average purchase price" label                               | Average purchase price                                                                                                                                                                                                              |
      | Average purchase price value in holding currency             |                                                                                                                                                                                                                                     |
      | “Last purchase date” label                                   | Last purchase date                                                                                                                                                                                                                  |
      | Last purchase date value                                     |                                                                                                                                                                                                                                     |
      | "Market price" label                                         | Market price                                                                                                                                                                                                                        |
      | Market price value in holding currency                       |                                                                                                                                                                                                                                     |
      | "Market price date" label                                    | Market price date                                                                                                                                                                                                                   |
      | Market price date value                                      |                                                                                                                                                                                                                                     |
      | Disclaimer                                                   | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @S209-AC1-AT2
  @SIT
  @DependsOn('login_in_as_userM_for_GPBM1727')
  Scenario:Check the ISO 3 format of holding currency and portfolio reference currency in Holdings detail page for Precious metal investments
    Given I am on the Portfolios Holdings Details level
    Then I should see the holdings precious metals following ISO 3 format datas:holding currency、reference currency、Unrealised Profit/Loss value、Market Price value、Average Purchase Price value


  @S209-AC1-AT3
  @SIT
  @DependsOn('login_in_as_userM_for_GPBM1727')
  Scenario:Check the dd Mmm yyyy format of Last Purchase Date value and Market Price Date value in Holdings detail page for Precious metal investments
    Given I am on the Portfolios Holdings Details level
    Then I should see the holdings precious metals date following datas:Last purchase date、Market price date
