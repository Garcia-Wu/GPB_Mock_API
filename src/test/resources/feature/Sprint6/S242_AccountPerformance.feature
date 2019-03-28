@UK
@Epic_GPBM-2010(Performance)
@Story_GPBM-2000 @Sprint6_iOS
@Story_GPBM-2266 @Sprint6_aOS
# remove in sprint19 UK
@NotAutomatable

Feature: Account Performance

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S242-AC1-AT1
  Scenario:Check the Performance UI in Account wrapper when the performance value and TWRR % figure is positive
    Given I login as type "account_performance_is_positive"
    Then I should see the account 2 following information:
      | element name                      | element value            |
      | Performance label                 | Performance year to date |
      | an information icon               |                          |
      | Performance value with a symbol + |                          |
      | TWRR % figure with a symbol +     |                          |
      | Account reference currency        |                          |

  @S242-AC1-AT2
  Scenario:Check the Performance UI in Account wrapper when the performance value and TWRR % figure is negative
    Given I login as type "account_performance_is_negative"
    Then I should see the account 1 following information:
      | element name                      | element value            |
      | Performance label                 | Performance year to date |
      | an information icon               |                          |
      | Performance value with a symbol - |                          |
      | TWRR % figure with a symbol -     |                          |
      | Account reference currency        |                          |

  @SIT
  Scenario: account performance
    Given I login as type "account_performance_is_positive"
    Then I should on the Account level

  @S242-AC1-AT3
  @SIT
  @DependsOn('account_performance')
  Scenario:Check the ISO 3 format of performance value and perfermance rate
    Given I am on the Account level
    Then I should see the account following datas: ISO 3 format of performance currency

  @S242-AC1-AT4
  @SIT
  @DependsOn('account_performance')
  Scenario:Check the 2dp format of performance value and TWRR % figure in account
    Given I am on the Account level
    Then I should see the account following datas: 2dp format of performance value、2dp format of TWRR % figure

  @S242-AC1-AT6
  @SIT
  @DependsOn('account_performance')
  Scenario:Check the account wrapper performance corresponding overlay performance
    Given I am on the Account level
    When I tap account performance
    Then I should see account wrapper performance corresponding overlay performance

  @S242-AC1-AT5
  Scenario:Check whether there is no + symbol or - symbol when the account TWRR % figure is 0.00% and account Performance value is 0.00
    Given I login as type "account_performance_is_zero"
    Then the account TWRR % figure is 0.00
    And the account Performance value is 0.00
    And I should see there is no + symbol or - symbol before the TWRR % figure and Performance value
