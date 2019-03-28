@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-403 @Sprint1_iOS
@Story_GPBM-773 @Sprint1_aOS
@NotAutomatable

Feature: Holdings per Currency at Account level

  As a client I want to see the individual holdings that make up my exposure to each currency within each Account,
  so that I know which holdings to review in order to change my currency exposure as desired

  @S20-AC1-AT1
  Scenario: Check a list of holdings within that Asset Currency at Account Level Screen
    Given I login as type "account_currency_list_less_than_9"
#    When I tap first item of Accounts list
    And I tap on the Allocation toggle
    And I tap the account Allocation Currency Tab
    And I tap first item of currency list
    Then I should see a list of holdings that they own within that Currency for that Account