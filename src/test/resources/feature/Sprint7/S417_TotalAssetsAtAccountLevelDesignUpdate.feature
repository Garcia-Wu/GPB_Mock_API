@HK @SG @UK
@Epic_GPBM-366(My_Account)
@Story_GPBM-2288 @Sprint7_iOS
@Story_GPBM-2291 @Sprint7_aOS

Feature: Total Assets at Account level (ISO 3 design update)
  As a Client I want to see a detailed view regarding my Derivative holdings,
  so that I can see all related information about the particular holding.

  @S417-AC1-AT1
  @SIT
  Scenario:Check the ISO 3 code adjacent to Total Account assets figure at Account level
    Given I login as type "has_account"
    When I tap first item of Accounts list
    Then I should see the Account assets value is displayed based on the Account reference currency "USD"
    And ISO 3 code of the Account reference currency is displayed adjacent to the Account assets value.
