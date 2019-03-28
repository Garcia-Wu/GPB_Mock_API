@UK
@Epic_GPBM-2010(Performance)
@Story_GPBM-2102 @Sprint6_iOS
@Story_GPBM-2272 @Sprint6_aOS

Feature: Overlays-Performance

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  userE: overview Performance amount value with a symbol +
  userN: overview Performance amount value with a symbol -

  # remove in sprint19 UK
  @NotAutomatable
  @S247-AC1-AT1
  Scenario:Check the Overview Performance Overlay UI when Performance value is positive
    Given I login as type "overview_performance_is_positive"
    When I tap overview performance
    Then I should see the overview performance overlay 1 following datas:
      | element name                             | element value                                                                                                                                                                                                                                                                     |
      | Performance YTD label                    | Performance year to date                                                                                                                                                                                                                                                          |
      | Overview label                           | Overview                                                                                                                                                                                                                                                                          |
      | Profit/loss label                        | Profit / loss                                                                                                                                                                                                                                                                     |
      | Performance amount value with a symbol + |                                                                                                                                                                                                                                                                                   |
      | Overview reporting currency              |                                                                                                                                                                                                                                                                                   |
      | X button                                 |                                                                                                                                                                                                                                                                                   |
      | overlay question                         | How is this calculated?                                                                                                                                                                                                                                                           |
      | overlay answer                           | The profit/loss value represents the difference between the market valuation of an asset and the initial cost of purchasing it. Note: The profit/loss value should not be used on its own to calculate capital gains tax. Please consult a tax adviser if you require assistance. |

  # remove in sprint19 UK
  @NotAutomatable
  @S247-AC1-AT2
  Scenario:Check the Overview Performance Overlay UI when Performance value is negative
    Given I login as type "overview_performance_is_negative"
    Then I should see the overview performance overlay 2 following datas:
      | element name                             | element value                                                                                                                                                                                                                                                                     |
      | Performance YTD label                    | Performance year to date                                                                                                                                                                                                                                                          |
      | Overview label                           | Overview                                                                                                                                                                                                                                                                          |
      | Profit/loss label                        | Profit / loss                                                                                                                                                                                                                                                                     |
      | Performance amount value with a symbol - |                                                                                                                                                                                                                                                                                   |
      | Overview reporting currency              |                                                                                                                                                                                                                                                                                   |
      | X button                                 |                                                                                                                                                                                                                                                                                   |
      | overlay question                         | How is this calculated?                                                                                                                                                                                                                                                           |
      | overlay answer                           | The profit/loss value represents the difference between the market valuation of an asset and the initial cost of purchasing it. Note: The profit/loss value should not be used on its own to calculate capital gains tax. Please consult a tax adviser if you require assistance. |

  # remove in sprint19 UK
  @NotAutomatable
  @SIT
  Scenario: Overview Performance Overlay
    Given I login as type "overview_performance_is_positive"
    When I tap overview performance
    Then I should on the overview performance overlay

  # remove in sprint19 UK
  @NotAutomatable
  @S247-AC1-AT3
  @SIT
  @DependsOn('Overview_Performance_Overlay')
  Scenario:Check the 2dp format of Performance value at Overview Performance Overlay
    Given I am on the overview performance overlay
    Then I should see 2dp format of Performance overlay amount value

  # remove in sprint19 UK
  @NotAutomatable
  @S247-AC1-AT4
  @SIT
  @DependsOn('Overview_Performance_Overlay')
  Scenario:Check the ISO3 format of Performance value at Overview Performance Overlay
    Given I am on the overview performance overlay
    Then I should see ISO3 format of Performance overlay amount value

  # remove in sprint19 UK
  @NotAutomatable
  @S247-AC1-AT5
  Scenario:Check whether there is no + symbol or - symbol when the Performance amount value is 0.00
    Given I login as type "overview_performance_is_zero"
    When I tap overview performance
    And the overview performance overlay amount value is 0.00
    Then I should see there is no + symbol or - symbol before the Performance amount value

  # remove in sprint19 UK
  @NotAutomatable
#    Account
  @Sprint19
  @S247-AC2-AT1
  Scenario:Check the Account Performance Overlay UI when Performance value and Performance rate value is positive
    Given I login as type "account_performance_is_positive"
    When I tap account performance
    Then I should see the account performance overlay 2 following datas:
      | element name                             | element value                                                                                                                                                                                                                                                                     |
      | Performance YTD label                    | Performance year to date                                                                                                                                                                                                                                                          |
      | Account name                             |                                                                                                                                                                                                                                                                                   |
      | Profit/loss label                        | Profit / loss                                                                                                                                                                                                                                                                     |
      | Performance amount value with a symbol + |                                                                                                                                                                                                                                                                                   |
      | Account reporting currency               |                                                                                                                                                                                                                                                                                   |
      | X button                                 |                                                                                                                                                                                                                                                                                   |
      | overlay question                         | How is this calculated?                                                                                                                                                                                                                                                           |
      | overlay answer                           | The profit/loss value represents the difference between the market valuation of an asset and the initial cost of purchasing it. Note: The profit/loss value should not be used on its own to calculate capital gains tax. Please consult a tax adviser if you require assistance. |
      | TWRR % figure with a symbol +            |                                                                                                                                                                                                                                                                                   |
      | Performance label                        | Performance                                                                                                                                                                                                                                                                       |
      | overlay bottom question                  | How is this calculated?                                                                                                                                                                                                                                                           |
      | overlay bottom answer                    | This is a measure of your account's compound rate of growth. It does not take into account money flows so is not affected by withdrawals or contributions. The rate of growth is the geometric mean of the sub-periods' holding period returns.                                   |

  # remove in sprint19 UK
  @NotAutomatable
  @Sprint19
  @S247-AC2-AT2
  Scenario:Check the Account Performance Overlay UI when Performance value and Performance rate value is negative
    Given I login as type "account_performance_is_negative"
    Then I should see the account performance overlay 1 following datas:
      | element name                             | element value                                                                                                                                                                                                                                                                     |
      | Performance YTD label                    | Performance year to date                                                                                                                                                                                                                                                          |
      | Account name                             |                                                                                                                                                                                                                                                                                   |
      | Profit/loss label                        | Profit / loss                                                                                                                                                                                                                                                                     |
      | Performance amount value with a symbol - |                                                                                                                                                                                                                                                                                   |
      | Account reporting currency               |                                                                                                                                                                                                                                                                                   |
      | X button                                 |                                                                                                                                                                                                                                                                                   |
      | overlay question                         | How is this calculated?                                                                                                                                                                                                                                                           |
      | overlay answer                           | The profit/loss value represents the difference between the market valuation of an asset and the initial cost of purchasing it. Note: The profit/loss value should not be used on its own to calculate capital gains tax. Please consult a tax adviser if you require assistance. |
      | TWRR % figure with a symbol -            |                                                                                                                                                                                                                                                                                   |
      | Performance label                        | Performance                                                                                                                                                                                                                                                                       |
      | overlay bottom question                  | How is this calculated?                                                                                                                                                                                                                                                           |
      | overlay bottom answer                    | This is a measure of your account's compound rate of growth. It does not take into account money flows so is not affected by withdrawals or contributions. The rate of growth is the geometric mean of the sub-periods' holding period returns.                                   |

  # remove in sprint19 UK
  @NotAutomatable
  @SIT
  Scenario: account performance overlay
    Given I login as type "account_performance_is_positive"
    When I tap account performance
    Then I should on the account performance overlay

  # remove in sprint19 UK
  @NotAutomatable
  @S247-AC2-AT3
  @SIT
  @DependsOn('account_performance_overlay')
  Scenario:Check the 2dp format of Performance value and Performance rate value at Account Performance Overlay
    Given I am on the account performance overlay
    Then I should see the account performance overlay following datas: 2dp format of Performance value、2dp format of TWRR % figure

  # remove in sprint19 UK
  @NotAutomatable
  @S247-AC2-AT4
  @SIT
  @DependsOn('account_performance_overlay')
  Scenario:Check the ISO3 format of Performance value at Account Performance Overlay
    Given I am on the account performance overlay
    Then I should see the account performance overlay following datas: ISO3 format of Performance value

  # remove in sprint19 UK
  @NotAutomatable
  @S247-AC2-AT5
  Scenario:Check account performance overlay whether there is no + symbol or - symbol when the TWRR % figure is 0.00% and Performance value is 0.00
    Given I login as type "account_performance_is_zero"
    When I tap account performance
    Then the account performance overlay TWRR % figure is 0.00
    And the account performance overlay Performance value is 0.00
    And I should see account performance overlay there is no + symbol or - symbol before the TWRR % figure and Perfermance value


# Portfolio
  @Sprint19
  @S247-AC3-AT1
  Scenario:Check the Portfolio Perfermance Overlay UI when Perfermance value and Perfermance rate value is positive
    Given I login as type "portfolio_performance_is_positive"
    When I tap portfolios performance
    Then I should see the portfolios performance overlay 2 following datas:
      | element name                             | element value                                                                                                                                                                                                                                                                     |
      | Performance YTD label                    | Performance year to date                                                                                                                                                                                                                                                          |
      | Portfolio name                           |                                                                                                                                                                                                                                                                                   |
      | Profit/loss label                        | Profit / loss                                                                                                                                                                                                                                                                     |
      | Performance amount value with a symbol + |                                                                                                                                                                                                                                                                                   |
      | Portfolio reporting currency             |                                                                                                                                                                                                                                                                                   |
      | X button                                 |                                                                                                                                                                                                                                                                                   |
      | overlay question                         | How is this calculated?                                                                                                                                                                                                                                                           |
      | overlay answer                           | The profit/loss value represents the difference between the market valuation of an asset and the initial cost of purchasing it. Note: The profit/loss value should not be used on its own to calculate capital gains tax. Please consult a tax adviser if you require assistance. |
      | TWRR % figure with a symbol +            |                                                                                                                                                                                                                                                                                   |
      | Performance label                        | Performance                                                                                                                                                                                                                                                                       |
      | overlay bottom question                  | How is this calculated?                                                                                                                                                                                                                                                           |
      | overlay bottom answer                    | This is a measure of your account's compound rate of growth. It does not take into account money flows so is not affected by withdrawals or contributions. The rate of growth is the geometric mean of the sub-periods' holding period returns.                                   |

  @Sprint19
  @S247-AC3-AT2
  Scenario:Check the Portfolio Perfermance Overlay UI when Perfermance value and Perfermance rate value is negative
    Given I login as type "portfolio_performance_is_negative"
    When I tap portfolios performance
    Then I should see the portfolios performance overlay 1 following datas:
      | element name                             | element value                                                                                                                                                                                                                                                                     |
      | Performance YTD label                    | Performance year to date                                                                                                                                                                                                                                                          |
      | Portfolio name                           |                                                                                                                                                                                                                                                                                   |
      | Profit/loss label                        | Profit / loss                                                                                                                                                                                                                                                                     |
      | Performance amount value with a symbol - |                                                                                                                                                                                                                                                                                   |
      | Portfolio reporting currency             |                                                                                                                                                                                                                                                                                   |
      | X button                                 |                                                                                                                                                                                                                                                                                   |
      | overlay question                         | How is this calculated?                                                                                                                                                                                                                                                           |
      | overlay answer                           | The profit/loss value represents the difference between the market valuation of an asset and the initial cost of purchasing it. Note: The profit/loss value should not be used on its own to calculate capital gains tax. Please consult a tax adviser if you require assistance. |
      | TWRR % figure with a symbol -            |                                                                                                                                                                                                                                                                                   |
      | Performance label                        | Performance                                                                                                                                                                                                                                                                       |
      | overlay bottom question                  | How is this calculated?                                                                                                                                                                                                                                                           |
      | overlay bottom answer                    | This is a measure of your account's compound rate of growth. It does not take into account money flows so is not affected by withdrawals or contributions. The rate of growth is the geometric mean of the sub-periods' holding period returns.                                   |

  @SIT
  Scenario: portfolios performance overlay
    Given I login as type "portfolio_performance_is_positive"
    When I tap portfolios performance
    Then I should on the portfolios performance overlay

  @S247-AC3-AT3
  @SIT
  @DependsOn('portfolios_performance_overlay')
  Scenario:Check the 2dp format of Performance value and Performance rate value at Portfolio Performance Overlay
    Given I am on the portfolios performance overlay
    Then I should see the portfolios performance overlay following datas: 2dp format of Performance amount value、2dp format of TWRR % figure

  @S247-AC3-AT4
  @SIT
  @DependsOn('portfolios_performance_overlay')
  Scenario:Check the ISO3 format of Performance value at Portfolio Performance Overlay
    Given I am on the portfolios performance overlay
    Then I should see the portfolios performance overlay following datas: ISO3 format of Performance amount value

  @S247-AC3-AT5
  Scenario:Check portfolios performance overlay whether there is no + symbol or - symbol when the TWRR % figure is 0.00% and Performance value is 0.00
    Given I login as type "portfolio_performance_is_zero"
    When I tap portfolios performance
    Then the portfolios performance overlay TWRR % figure is 0.00
    And the portfolios performance overlay Performance value is 0.00
    And I should see portfolios performance overlay there is no + symbol or - symbol before the TWRR % figure and Performance value