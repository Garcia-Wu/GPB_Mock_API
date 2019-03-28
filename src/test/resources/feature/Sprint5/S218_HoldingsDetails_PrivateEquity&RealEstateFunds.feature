@HK @SG @UK
@Epic_GPBM-1094(Holdings)
@Story_GPBM-1729 @Sprint5_iOS
@Story_GPBM-1815 @Sprint5_aOS

Feature: Holdings details - Private Equity & Real Estate Funds

  As a Client I want to see a detailed view regarding my Private Equity or Real Estate fund holdings,
  so that I can see all related information about the particular holding.

  @SIT
  Scenario: login in as userM for GPBM1729
    Given I login as type "portfolio_holding_detail_private_equity_and_real_estate_funds"
    Then I should on the Portfolios Holdings Details level

  @S218-AC1-AT1
  @DependsOn('login_in_as_userM_for_GPBM1729')
  Scenario: Check Holdings detail page for Private Equity and Real Estate funds
    Given I am on the Portfolios Holdings Details level
#    When Client taps on a holding in the holdings list which belongs to one of the following sub-asset classes:

#Private Equity Funds - 18
#Private Equity Funds (Islamic Products) - 82
#Real Estate Funds - 35
#Real Estate Funds (Islamic Products) - 83
    Then I am taken to a detailed holdings private equity and real estate funds screen displaying the following data:
      | element name                                 | element value                                                                                                                                                                                                                       |
      | Holding name value                           |                                                                                                                                                                                                                                     |
      | ISIN value                                   |                                                                                                                                                                                                                                     |
      | Market Value label                           | Market value                                                                                                                                                                                                                        |
      | Market value in holding currency             |                                                                                                                                                                                                                                     |
      | Market value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | Initial Commitment label                     | Initial commitment                                                                                                                                                                                                                  |
      | Initial Commitment value in holding currency |                                                                                                                                                                                                                                     |
      | Disclaimer                                   | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @S218-AC1-AT2
  @SIT
  @DependsOn('login_in_as_userM_for_GPBM1729')
  Scenario: Check currency format in Holdings detail page for Private Equity and Real Estate funds
    Given I am on the Portfolios Holdings Details level
    Then I can see ISO 3 code of holdings private equity and real estate funds currency
