@HK @SG @UK
@Epic_GPBM-368(My_Account)
@Story_GPBM-2255 @Sprint6_iOS
@Story_GPBM-2256 @Sprint6_aOS

Feature: Total asset at Account Level

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S379-AC1-AT1
  Scenario:Check the Account assets title in Account wrapper
    Given I login as type "more_portfolio"
    Then I should see account a header "Account assets" is displayed instead of Total assets