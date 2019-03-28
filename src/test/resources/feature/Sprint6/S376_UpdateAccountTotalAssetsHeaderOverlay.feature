@HK @SG @UK
@Epic_GPBM-368(My_Account)
@Story_GPBM-2259 @Sprint6_iOS
@Story_GPBM-2262 @Sprint6_aOS

Feature: Account Total Assets Overlay(header update)

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S376-AC1-AT1
  Scenario:Check the Account assets title in Account Overlay
    Given I login as type "more_portfolio"
    And I taps on the account total assets value
    Then I should see the "Account assets" title in Account asset Overlay