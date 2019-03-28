@HK @SG @UK
@Epic_GPBM-410(My_Portfolio)
@Story_GPBM-2289 @Sprint7_iOS
@Story_GPBM-2292 @Sprint7_aOS

Feature: Total Assets at Portfolio level (ISO 3 design update)
  As a Client I want to see a detailed view regarding my Derivative holdings,
  so that I can see all related information about the particular holding.

  @S418-AC1-AT1
  @SIT
  Scenario:Check the ISO 3 code adjacent to Portfolio assets figure at Portfolio level
    Given I login as type "more_portfolio"
    When I tap first item of Portfolios list
    Then I should see the Portfolio assets value is displayed based on the Portfolio reference currency "JPY"
    And the ISO 3 code of the portfolio reference currency is displayed adjacent to the Portfolio assets figure.