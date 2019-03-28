@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-402 @Sprint1_iOS
@Story_GPBM-770 @Sprint1_aOS
@NotAutomatable

Feature: Holdings per Currency at Overview level

  As a client I want to see the individual holdings that make up my exposure to each currency across all of my Accounts,
  so that I know which holdings to review in order to change my currency exposure as desired

  @S19-AC1-AT1
  Scenario: Check a list of holdings within that Asset Currency at Overview Level Screen
    Given I login as type "overview_currency_list_less_than_9"
    When I tap on the Allocation toggle
    And I tap on Currency tab
    And I tap first item of Overview currency list
    Then I should see a list of holdings that they own within that currency for that Overview