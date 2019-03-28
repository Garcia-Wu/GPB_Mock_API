@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-404 @Sprint1_iOS
@Story_GPBM-776 @Sprint1_aOS
@NotAutomatable

Feature: Holdings per Currency at Portfolio level

  As a client I want to see the individual holdings that make up my exposure to each currency within each Portfolio,
  so that I know which holdings to review in order to change my currency exposure as desired

  @S21-AC1-AT1
  Scenario: Check a list of holdings within that Asset Currency at Portfolio Level Screen
    Given I login as type "portfolio_currency_list_less_than_9"
#    When I tap first item of Accounts list
#    And I tap first item of Portfolios list
    And I tap on the Allocation toggle
    And I tap Portfolio Currency tab
    And I swipe up from the bottom of the allocation graphic page
    And I tap first item of Portfolio currency list
    Then I should see a list of holdings that they own within that currency for that Portfolio