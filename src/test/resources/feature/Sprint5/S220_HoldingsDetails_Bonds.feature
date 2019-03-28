@HK @SG @UK
@Epic_GPBM-1094(Holdings)
@Story_GPBM-1732 @Sprint5_iOS
@Story_GPBM-1915 @Sprint5_aOS
@Sprint19

Feature: Holdings details - Bonds

  As a Client I want to see a detailed view regarding my Bond holdings,
  so that I can see all related information about the particular holding.

  @SIT
  Scenario: login in as userM for GPBM1732
    Given I login as type "portfolio_holding_detail_bonds"
    Then I should on the Portfolios Holdings Details level

  @S220-AC1-AT1
  @DependsOn('login_in_as_userM_for_GPBM1732')
  Scenario: Check Holdings detail page for Bonds
    Given I am on the Portfolios Holdings Details level
#    When Client taps on a holding in the holdings list which belongs to one of the following sub-asset classes:
#    Bonds - 8
#    Preferred Bonds - 79
#    Convertible Bonds - 6
    Then I am taken to a detailed holdings bonds screen displaying the following data:
      | element name                                | element value                                                                                                                                                                                                                       |
      | Holding name value                          |                                                                                                                                                                                                                                     |
      | ISIN value                                  |                                                                                                                                                                                                                                     |
      | "Total value" label                         | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency             |                                                                                                                                                                                                                                     |
      | Total value in portfolio reporting currency |                                                                                                                                                                                                                                     |
      | "Accrued Interest" label                    | Accrued interest                                                                                                                                                                                                                    |
      | Accrued Interest value in holding currency  |                                                                                                                                                                                                                                     |
      | "Nominal Amount" label                      | Nominal amount                                                                                                                                                                                                                      |
      | Nominal Amount value in holding currency    |                                                                                                                                                                                                                                     |
      | "Average Purchase Price" label              | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price value as a %         |                                                                                                                                                                                                                                     |
      | "Last Buy Date" label                       | Last buy date                                                                                                                                                                                                                       |
      | Last Buy Date value                         |                                                                                                                                                                                                                                     |
      | "Indicative Market Price" label             | Indicative market price                                                                                                                                                                                                             |
      | Indicative Market Price value as a %        |                                                                                                                                                                                                                                     |
      | "Market Price Date" label                   | Market price date                                                                                                                                                                                                                   |
      | Market Price Date value                     |                                                                                                                                                                                                                                     |
      | "YTM" label                                 | YTM                                                                                                                                                                                                                                 |
      | YTM value                                   |                                                                                                                                                                                                                                     |
      | "Duration" label                            | Duration                                                                                                                                                                                                                            |
      | Duration value                              |                                                                                                                                                                                                                                     |
      | "Issuer" label                              | Issuer                                                                                                                                                                                                                              |
      | Issuer value                                |                                                                                                                                                                                                                                     |
      | "Rating Moody’s" label                      | Rating Moody’s                                                                                                                                                                                                                      |
      | Rating Moody’s value                        |                                                                                                                                                                                                                                     |
      | "Rating S&P" label                          | Rating S&P                                                                                                                                                                                                                          |
      | "Rating S&P" value                          |                                                                                                                                                                                                                                     |
      | "Country of Risk" label                     | Country of risk                                                                                                                                                                                                                     |
      | Country of Risk value                       |                                                                                                                                                                                                                                     |
      | "Maturity Date" label                       | Maturity date                                                                                                                                                                                                                       |
      | Maturity Date value                         |                                                                                                                                                                                                                                     |
      | "Minimum investment amount" label           | Minimum investment amount                                                                                                                                                                                                           |
      | Minimum Piece value                         |                                                                                                                                                                                                                                     |
      | Disclaimer                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @S220-AC1-AT2
  @SIT
  @DependsOn('login_in_as_userM_for_GPBM1732')
  Scenario: Check currency format in Holdings detail page for Bonds
    Given I am on the Portfolios Holdings Details level
    Then I can see ISO 3 code of holdings bonds currency

  @S220-AC1-AT3
  @SIT
  @DependsOn('login_in_as_userM_for_GPBM1732')
  Scenario: Check date format in Holdings detail page Holdings detail page for Bonds
    Given I am on the Portfolios Holdings Details level
    Then I can see holdings bonds date value Format is "dd Mmm yyyy"

  Scenario: login in as userM for bonds2
    Given I login as type "portfolio_holding_detail_bonds2"
    Then I should on the Portfolios Holdings Details level

  @S220-AC2-AT1
  @DependsOn('login_in_as_userM_for_bonds2')
  Scenario: Check Holdings detail page for Bonds AND Type = SINK
    Given I am on the Portfolios Holdings Details level
#          Bonds - 8
#          Preferred Bonds - 79
#          Convertible Bonds - 6
#    And the Type of the bond = "SINK"
#    When Client taps on a holding in the holdings list that meets this criteria
    Then I am taken to a detailed holdings bonds2 screen displaying the following data:
      | element name                                | element value                                                                                                                                                                                                                       |
      | Holding name value                          |                                                                                                                                                                                                                                     |
      | ISIN value                                  |                                                                                                                                                                                                                                     |
      | "Total value" label                         | Total value                                                                                                                                                                                                                         |
      | Total value in holding currency             |                                                                                                                                                                                                                                     |
      | Total value in portfolio reporting currency |                                                                                                                                                                                                                                     |
      | "Accrued Profit" label                      | Accrued profit                                                                                                                                                                                                                      |
      | Accrued Profit value in holding currency    |                                                                                                                                                                                                                                     |
      | "Nominal Amount" label                      | Nominal amount                                                                                                                                                                                                                      |
      | Nominal Amount value in holding currency    |                                                                                                                                                                                                                                     |
      | "Average Purchase Price" label              | Average purchase price                                                                                                                                                                                                              |
      | Average Purchase Price value as a %         |                                                                                                                                                                                                                                     |
      | "Last Buy Date" label                       | Last buy date                                                                                                                                                                                                                       |
      | Last Buy Date value                         |                                                                                                                                                                                                                                     |
      | "Indicative Market Price" label             | Indicative market price                                                                                                                                                                                                             |
      | Indicative Market Price value as a %        |                                                                                                                                                                                                                                     |
      | "Market Price Date" label                   | Market price date                                                                                                                                                                                                                   |
      | Market Price Date value                     |                                                                                                                                                                                                                                     |
      | "YTM" label                                 | YTM                                                                                                                                                                                                                                 |
      | YTM value                                   |                                                                                                                                                                                                                                     |
      | "Duration" label                            | Duration                                                                                                                                                                                                                            |
      | Duration value                              |                                                                                                                                                                                                                                     |
      | "Issuer" label                              | Issuer                                                                                                                                                                                                                              |
      | Issuer value                                |                                                                                                                                                                                                                                     |
      | "Rating Moody’s" label                      | Rating Moody’s                                                                                                                                                                                                                      |
      | Rating Moody’s value                        |                                                                                                                                                                                                                                     |
      | "Rating S&P" label                          | Rating S&P                                                                                                                                                                                                                          |
      | "Rating S&P" value                          |                                                                                                                                                                                                                                     |
      | "Country of Risk" label                     | Country of risk                                                                                                                                                                                                                     |
      | Country of Risk value                       |                                                                                                                                                                                                                                     |
      | "Maturity Date" label                       | Maturity date                                                                                                                                                                                                                       |
      | Maturity Date value                         |                                                                                                                                                                                                                                     |
      | "Minimum investment amount" label           | Minimum investment amount                                                                                                                                                                                                           |
      | Minimum Piece value                         |                                                                                                                                                                                                                                     |
      | Disclaimer                                  | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @S220-AC2-AT2
  @DependsOn('login_in_as_userM_for_bonds2')
  Scenario: Check currency format in Holdings detail page for Bonds AND Type = SINK
    Given I am on the Portfolios Holdings Details level
    Then I can see ISO 3 code of holdings bonds2 currency

  @S220-AC2-AT3
  @DependsOn('login_in_as_userM_for_bonds2')
  Scenario: Check date format in Holdings detail page for Bonds AND Type = SINK
    Given I am on the Portfolios Holdings Details level
    Then I can see holdings bonds2 date value Format is "dd MMM yyyy"