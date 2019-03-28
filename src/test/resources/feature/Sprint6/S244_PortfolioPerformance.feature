@UK
@Epic_GPBM-2010(Performance)
@Story_GPBM-2008 @Sprint6_iOS
@Story_GPBM-2268 @Sprint6_aOS

Feature: Portfolio Performance

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S244-AC1-AT1
  Scenario:Check the Performance  UI in Portfolio wrapper when the performance value and TWRR % figure is positive
    Given I login as type "portfolio_performance_is_positive"
    Then I should view the portfolio 2 following information:
      | element name                      | element value            |
      | Performance label                 | Performance year to date |
      | an information icon               |                          |
      | Performance value with a symbol + |                          |
      | TWRR % figure with a symbol +     |                          |
      | Portfolio reference currency      |                          |

  @S244-AC1-AT2
  Scenario:Check the Performance  UI in Portfolio wrapper when the performance value and TWRR % figure is negative
    Given I login as type "portfolio_performance_is_negative"
    Then I should view the portfolio 1 following information:
      | element name                      | element value            |
      | Performance label                 | Performance year to date |
      | an information icon               |                          |
      | Performance value with a symbol - |                          |
      | TWRR % figure with a symbol -     |                          |
      | Portfolio reference currency      |                          |

  @SIT
  Scenario: portfolio performance
    Given I login as type "portfolio_performance_is_positive"
    Then I should on the Portfolios level

   @S244-AC1-AT3
  @SIT
  @DependsOn('portfolio_performance')
  Scenario:Check the ISO 3 format of performance currency in Portfolio wrapper
    Given I am on the Portfolios level
    Then I should see the portfolio following datas: ISO 3 format of performance currency

  @S244-AC1-AT4
  @SIT
  @DependsOn('portfolio_performance')
  Scenario:Check the 2dp format of performance value and TWRR % figure in Portfolio wrapper
    Given I am on the Portfolios level
    Then I should see the portfolio following datas: 2dp format of performance value、2dp format of TWRR % figure

  @S244-AC1-AT6
  @SIT
  @DependsOn('portfolio_performance')
  Scenario:Check the portfolio wrapper performance corresponding overlay performance
    Given I am on the Portfolios level
    When I tap portfolios performance
    Then I should see portfolio wrapper performance corresponding overlay performance

  @S244-AC1-AT5
  Scenario:Check whether there is no + symbol or - symbol when the TWRR % figure is 0.00% and Perfermance value is 0.00
    Given I login as type "portfolio_performance_is_zero"
    Then the portfolio Performance value is 0.00
    And I should see portfolio there is no + symbol or - symbol before the TWRR % figure and Perfermance value