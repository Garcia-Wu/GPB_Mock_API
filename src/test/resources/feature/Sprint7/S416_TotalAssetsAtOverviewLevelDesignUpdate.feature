@HK @SG @UK
@Epic_GPBM-367(My_Overview)
@Story_GPBM-2287 @Sprint7_iOS
@Story_GPBM-2290 @Sprint7_aOS

Feature: Total Assets at Overview level (ISO 3 design update)
  As a Client I want to see a detailed view regarding my Derivative holdings,
  so that I can see all related information about the particular holding.

  @S416-AC1-AT1
  @SIT
  Scenario:Check the ISO 3 code adjacent to Total Assets figure at Overview level
    Given I login as type "has_account"
    Then I should see "UK_HK_SG" Total assets value is displayed based on the reference currency "GBP_USD_USD"
    And The reporting currency is displayed in ISO 3 code format adjacent to the total assets value
