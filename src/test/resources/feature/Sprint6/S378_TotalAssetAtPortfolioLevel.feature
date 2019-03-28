@HK @SG @UK
@Epic_GPBM-410(My_Portfolio)
@Story_GPBM-2257 @Sprint6_iOS
@Story_GPBM-2258 @Sprint6_aOS

Feature: Total asset at Portfolio Level

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S378-AC1-AT1
  Scenario:Check the Portfolio assets title in Portfolio wrapper
    Given I login as type "portfolio_has_holdings"
    Then I should see portfolios a header "Portfolio assets" is displayed instead of "Total assets"