@UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-399 @Sprint1_iOS
@Story_GPBM-761 @Sprint1_aOS
@NotAutomatable

Feature: Holdings by Region at Portfolio level

  As a client I want to see the individual holdings that make up my exposure to each geographical region within each Portfolio,
  so that I know which holdings to review in order to change my regional exposure as desired

  @S16-AC1-AT1
  Scenario: Check a list of holdings within that Asset Region at Portfolio Level Screen
    Given I login as type "portfolio_has_region"
#    When I tap first item of Accounts list
#    And I tap first item of Portfolios list
    And I tap on the Allocation toggle
    And I tap Portfolio Region tab
    And I tap first item of region list
    Then I should see a list of holdings that they own within that Region for that Portfolio