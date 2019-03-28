@UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-401 @Sprint1_iOS
@Story_GPBM-767 @Sprint1_aOS
@NotAutomatable

Feature: Holdings per Region at Overview level

  As a client I want to see the individual holdings that make up my exposure to each geographical region across all of my Accounts,
  so that I know which holdings to review in order to change my regional exposure as desired

  @S18-AC1-AT1
  Scenario: Check a list of holdings within that Asset Region at Overview Level Screen
    Given I login as type "overview_has_region"
    When I tap on the Allocation toggle
    And I tap on "Region" tab
    And I tap first item of Overview region list
    Then I should see a list of holdings that they own within that Region for that Overview