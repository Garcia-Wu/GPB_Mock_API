@UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-400 @Sprint1_iOS
@Story_GPBM-764 @Sprint1_aOS
@NotAutomatable

Feature: Holdings per Region at Account level

  As a client I want to see the individual holdings that make up my exposure to each geographical region within each Account,
  so that I know which holdings to review in order to change my regional exposure as desired

  @S17-AC1-AT1
  Scenario: Check a list of holdings within that Asset Region at Account Level Screen
    Given I login as type "account_has_region"
#    When I tap first item of Accounts list
    And I tap on the Allocation toggle
    And I tap Account Region button
    And I tap first item of Account region list
    Then I should see a list of holdings that they own within that Region for that Account