@UK
@Epic_GPBM-2010(Performance)
@Story_GPBM-2247 @Sprint6_iOS
@Story_GPBM-2264 @Sprint6_aOS

Feature: Close Overlay Performance

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  # remove in sprint19 UK
  @NotAutomatable
  @S248-AC1-AT1
  Scenario:Check whether I can close the Overview Performance Overlay when I tap "X"
    Given I login as type "overview_performance_is_positive"
    And I tap overview performance
    When I taps on "x" top right of overview performance overlay
    Then I should see the overview performance overlay is closed

#  update in sprint 10
#  @S248-AC1-AT2
#  @DependsOn('login_in_as_userM_for_overview_close_performance_overlay')
#  Scenario:Check whether I can close the Overview Performance Overlay when I tap anywhere on the screen outside of the overlay frame
#    Given I am on the overview performance overlay
#    When I tap overview performance
#    And I taps anywhere on the screen outside of the overview performance overlay frame
#    Then I should see the overview performance overlay is closed

  # remove in sprint19 UK
  @NotAutomatable
  @S248-AC2-AT1
  Scenario:Check whether I can close the Account Performance Overlay when I tap "X"
    Given I login as type "account_performance_is_positive"
    And I tap account performance
    When I taps on "x" top right of account performance overlay
    Then I should see the account performance overlay is closed

#  update in sprint 10
#  @S248-AC2-AT2
#  @DependsOn('login_in_as_userM_for_account_close_performance_overlay')
#  Scenario:Check whether I can close the Account Performance Overlay when I tap anywhere on the screen outside of the overlay frame
#    Given I am on the account performance overlay
#    When I tap account performance
#    And I taps anywhere on the screen outside of the account performance overlay frame
#    Then I should see the account performance overlay is closed

  @S248-AC3-AT1
  Scenario:Check whether I can close the Portfolio Performance Overlay when I tap "X"
    Given I login as type "portfolio_performance_is_positive"
    And I tap portfolios performance
    When client taps on "x" top right of portfolios performance overlay
    Then I should see the portfolios performance overlay is closed

#  update in sprint 10
#  @S248-AC3-AT2
#  @DependsOn('login_in_as_userM_for_portfolios_close_performance_overlay')
#  Scenario:Check whether I can close the Portfolio Performance Overlay when I tap anywhere on the screen outside of the overlay frame
#    Given I am on the portfolios performance overlay
#    When I tap portfolios performance
#    And I taps anywhere on the screen outside of the portfolios performance overlay frame
#    Then I should see the portfolios performance overlay is closed