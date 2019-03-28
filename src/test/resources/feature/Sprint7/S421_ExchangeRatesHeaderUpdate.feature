@Epic_GPBM-411(Reporting_Currency_&_Conversion_Rates)
@Story_GPBM-2346 @Sprint7_iOS
@Story_GPBM-2347 @Sprint7_aOS

Feature: Exchange rates (header update)
  As a Client I want to see a detailed view regarding my Derivative holdings,
  so that I can see all related information about the particular holding.

  @HK @SG @UK
  @S421-AC1-AT1
  Scenario:Check whether I can see a header “Exchange rates”when I taps on "Exchange rates" icon at Overview wrapper
    Given I login as type "has_account"
    When I tap on overview "Currency Conversion" icon
    Then I should see a header "Exchange rates" NOT "Currency Conversion"

  @HK @SG @UK
  @S421-AC1-AT2
  Scenario:Check whether I can see a header “Exchange rates”when I taps on "Exchange rates" icon at Overview Asset Class Holding wrapper
    Given I login as type "overview_has_allocation_class_holdings"
    When I tap on holding list "Currency Conversion" icon
    Then I should see a header "Exchange rates" NOT "Currency Conversion"

  @HK @SG @UK
  @S421-AC1-AT3
  Scenario:Check whether I can see a header “Exchange rates”when I taps on "Exchange rates" icon at Overview Sub-Asset Class Holding wrapper
    Given I login as type "overview_has_allocation_subClass_holdings"
    When I tap on holding list "Currency Conversion" icon
    Then I should see a header "Exchange rates" NOT "Currency Conversion"

  @HK @SG @UK
  @S421-AC1-AT4
  Scenario:Check whether I can see a header “Exchange rates”when I taps on "Exchange rates" icon at Overview Currency Holding wrapper
    Given I login as type "overview_has_allocation_currency_holdings"
    When I tap on holding list "Currency Conversion" icon
    Then I should see a header "Exchange rates" NOT "Currency Conversion"

  @UK
  @S421-AC1-AT5
  Scenario:Check whether I can see a header “Exchange rates”when I taps on "Exchange rates" icon at Overview Region Holding wrapper
    Given I login as type "overview_has_allocation_region_holdings"
    When I tap on holding list "Currency Conversion" icon
    Then I should see a header "Exchange rates" NOT "Currency Conversion"

  @HK @SG @UK
  @S421-AC2-AT1
  Scenario:Check whether I can see a header “Exchange rates”when I taps on "Exchange rates" icon at Account wrapper
    Given I login as type "more_account_has_portfolio_list"
    When I tap on account "Currency Conversion" icon
    Then I should see a header "Exchange rates" NOT "Currency Conversion"

  @HK @SG @UK
  @S421-AC2-AT2
  Scenario:Check whether I can see a header “Exchange rates”when I taps on "Exchange rates" icon at Account Asset Class Holding wrapper
    Given I login as type "account_has_allocation_class_holdings"
    When I tap on holding list "Currency Conversion" icon
    Then I should see a header "Exchange rates" NOT "Currency Conversion"

  @HK @SG @UK
  @S421-AC2-AT3
  Scenario:Check whether I can see a header “Exchange rates”when I taps on "Exchange rates" icon at Account Sub-Asset Class Holding wrapper
    Given I login as type "account_has_allocation_subClass_holdings"
    When I tap on holding list "Currency Conversion" icon
    Then I should see a header "Exchange rates" NOT "Currency Conversion"

  @HK @SG @UK
  @S421-AC2-AT4
  Scenario:Check whether I can see a header “Exchange rates”when I taps on "Exchange rates" icon at Account Currency Holding wrapper
    Given I login as type "account_has_allocation_currency_holdings"
    When I tap on holding list "Currency Conversion" icon
    Then I should see a header "Exchange rates" NOT "Currency Conversion"

  @UK
  @S421-AC2-AT5
  Scenario:Check whether I can see a header “Exchange rates”when I taps on "Exchange rates" icon at Account Region Holding wrapper
    Given I login as type "account_has_allocation_region_holdings"
    When I tap on holding list "Currency Conversion" icon
    Then I should see a header "Exchange rates" NOT "Currency Conversion"

  @HK @SG @UK
  @S421-AC3-AT1
  Scenario:Check whether I can see a header “Exchange rates”when I taps on "Exchange rates" icon at Portfolio wrapper
    Given I login as type "portfolio_has_holdings"
    When I tap on portfolio "Currency Conversion" icon
    Then I should see a header "Exchange rates" NOT "Currency Conversion"

  @HK @SG @UK
  @S421-AC3-AT2
  Scenario:Check whether I can see a header “Exchange rates”when I taps on "Exchange rates" icon at Portfolio Asset Class Holding wrapper
    Given I login as type "portfolio_has_allocation_class_holdings"
    When I tap on holding list "Currency Conversion" icon
    Then I should see a header "Exchange rates" NOT "Currency Conversion"

  @HK @SG @UK
  @S421-AC3-AT3
  Scenario:Check whether I can see a header “Exchange rates”when I taps on "Exchange rates" icon at Portfolio Sub-Asset Class Holding wrapper
    Given I login as type "portfolio_has_allocation_subClass_holdings"
    When I tap on holding list "Currency Conversion" icon
    Then I should see a header "Exchange rates" NOT "Currency Conversion"

  @HK @SG @UK
  @S421-AC3-AT4
  Scenario:Check whether I can see a header “Exchange rates”when I taps on "Exchange rates" icon at Portfolio Currency Holding wrapper
    Given I login as type "portfolio_has_allocation_currency_holdings"
    When I tap on holding list "Currency Conversion" icon
    Then I should see a header "Exchange rates" NOT "Currency Conversion"


  @UK
  @S421-AC3-AT5
  Scenario:Check whether I can see a header “Exchange rates”when I taps on "Exchange rates" icon at Portfolio Region Holding wrapper
    Given I login as type "portfolio_has_allocation_region_holdings"
    When I tap on holding list "Currency Conversion" icon
    Then I should see a header "Exchange rates" NOT "Currency Conversion"