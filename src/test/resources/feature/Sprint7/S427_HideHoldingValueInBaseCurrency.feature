@Epic_GPBM-1094(Holdings)
@Story_GPBM-2642 @Sprint7_iOS
@Story_GPBM-2643 @Sprint7_aOS

Feature: Hide holding value in base currency
  As a Client I want to see a detailed view regarding my Derivative holdings,
  so that I can see all related information about the particular holding.

  @HK @SG @UK
  @S427-AC1-AT1
  Scenario:Check the holding values within Overview Asset Class holding details
    Given I login as type "overview_allocation_class_holding_same_currency"
    Then I should not see the value of that holding in base currency
    And only see the value of that holding in holding currency

  @HK @SG @UK
  @S427-AC1-AT2
  Scenario:Check the holding values within Overview Sub-Asset Class holding details
    Given I login as type "overview_allocation_subClass_holding_same_currency"
    Then I should not see the value of that holding in base currency
    And only see the value of that holding in holding currency

  @HK @SG @UK
  @S427-AC1-AT3
  Scenario:Check the holding values within Overview Currency holding details
    Given I login as type "overview_allocation_currency_holding_same_currency"
    Then I should not see the value of that holding in base currency
    And only see the value of that holding in holding currency

  @UK
  @S427-AC1-AT4
  Scenario:Check the holding values within Overview Region holding details
    Given I login as type "overview_allocation_region_holding_same_currency"
    Then I should not see the value of that holding in base currency
    And only see the value of that holding in holding currency

  @HK @SG @UK
  @S427-AC2-AT1
  Scenario:Check the holding values within Account Asset Class holding details
    Given I login as type "account_allocation_class_holding_same_currency"
    Then I should not see the value of that holding in base currency
    And only see the value of that holding in holding currency

  @HK @SG @UK
  @S427-AC2-AT2
  Scenario:Check the holding values within Account Sub-Asset Class holding details
    Given I login as type "account_allocation_subClass_holding_same_currency"
    Then I should not see the value of that holding in base currency
    And only see the value of that holding in holding currency

  @HK @SG @UK
  @S427-AC2-AT3
  Scenario:Check the holding values within Account Currency holding details
    Given I login as type "account_allocation_currency_holding_same_currency"
    Then I should not see the value of that holding in base currency
    And only see the value of that holding in holding currency

  @UK
  @S427-AC2-AT4
  Scenario:Check the holding values within Account Region holding details
    Given I login as type "account_allocation_region_holding_same_currency"
    Then I should not see the value of that holding in base currency
    And only see the value of that holding in holding currency

  @HK @SG @UK
  @S427-AC3-AT1
  Scenario:Check the holding values within Portfolio Asset Class holding details
    Given I login as type "portfolio_allocation_class_holding_same_currency"
    Then I should not see the value of that holding in base currency
    And only see the value of that holding in holding currency

  @HK @SG @UK
  @S427-AC3-AT2
  Scenario:Check the holding values within Portfolio Sub-Asset Class holding details
    Given I login as type "portfolio_allocation_subClass_holding_same_currency"
    Then I should not see the value of that holding in base currency
    And only see the value of that holding in holding currency

  @HK @SG @UK
  @S427-AC3-AT3
  Scenario:Check the holding values within Portfolio Currency holding details
    Given I login as type "portfolio_allocation_currency_holding_same_currency"
    Then I should not see the value of that holding in base currency
    And only see the value of that holding in holding currency

  @UK
  @S427-AC3-AT4
  Scenario:Check the holding values within Portfolio Region holding details
    Given I login as type "portfolio_allocation_region_holding_same_currency"
    Then I should not see the value of that holding in base currency
    And only see the value of that holding in holding currency

  @HK @SG @UK
  @S427-AC3-AT5
  Scenario:Check the holding values within Portfolio holding details
    Given I login as type "portfolio_holding_same_currency"
    Then I should not see the value of that holding in base currency
    And only see the value of that holding in holding currency