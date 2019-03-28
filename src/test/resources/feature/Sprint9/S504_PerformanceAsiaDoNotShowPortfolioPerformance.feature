@HK @SG
@Epic_GPBM-2010(Performance)
@Story_GPBM-3092 @Sprint9_iOS
@Story_GPBM-3142 @Sprint9_aOS

Feature: Performance - Asia - Do not show Portfolio performance

  As a bank I want to be able to suppress the performance figure of defined Portfolis,
  so that clients cannot view these figures on our digital channels

  Scenario: I am view the portfolio wrapper for GPBM-3092
    Given I login as type "portfolio__no_show_performance_asia"
#    When I tap four item of Accounts list
#    And I tap last item of Portfolios list
    Then I should on the Portfolios level

  @S504-AC1-AT1
  @DependsOn('I_am_view_the_portfolio_wrapper_for_GPBM-3092')
  Scenario: Check whether I can not view Performance in the Portfolio wrapper when the Portfolio has a marker to suppress the performance value
    Given I am on the Portfolios level
    Then I can not view Performance in the Portfolio wrapper

  @S504-AC1-AT2
  @DependsOn('I_am_view_the_portfolio_wrapper_for_GPBM-3092')
  Scenario: Check whether I can not view Performance in the Portfolio wrapper when the Portfolio has a marker to suppress the performance value when I swipe left or right the portfolio wrapper pips
    Given I am on the Portfolios level
    When I swipe right 1th to other portfolio
    And I swipe left 1th to other portfolio
    Then I can not view Performance in the Portfolio wrapper


  Scenario: I am view the portfolio list for GPBM-3092
    Given I login as type "portfolio_list_no_show_performance_asia"
    When I tap four item of Accounts list
    Then I should on the Account level

  @S504-AC1-AT3
  @DependsOn('I_am_view_the_portfolio_list_for_GPBM-3092')
  Scenario: Check whether Portfolio will not display a performance figure in the Portfolio list when the Portfolio has a marker to suppress the performance value
    Given I am on the Account level
    When I slide up to the last portfolio item
    Then I should see that proper number of portfolio item will not display a performance figure in the Portfolio list (under the Account page)

  @S504-AC1-AT4
  @DependsOn('I_am_view_the_portfolio_list_for_GPBM-3092')
  Scenario: Check whether Portfolio will not display a performance figure in the Portfolio list when the Portfolio has a marker to suppress the performance value when I swipe left or right the account wrapper pips
    Given I am on the Account level
    When I swipe right 1th to other account
    And I swipe left 1th to other portfolio
    Then I should see that proper number of portfolio item will not display a performance figure in the Portfolio list (under the Account page)