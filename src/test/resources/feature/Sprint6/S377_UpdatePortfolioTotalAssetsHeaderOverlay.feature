@HK @SG @UK
@Epic_GPBM-410(My_Portfolio)
@Story_GPBM-2260 @Sprint6_iOS
@Story_GPBM-2261 @Sprint6_aOS

Feature: Portfolio Total Assets Overlay(header update)

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S377-AC1-AT1
  Scenario:Check the Account assets title in Portfolio Overlay
    Given I login as type "portfolio_has_holdings"
    And I click on the Portfolio Total Assets value
    Then I should see the "Portfolio assets" title in Portfolio asset Overlay
