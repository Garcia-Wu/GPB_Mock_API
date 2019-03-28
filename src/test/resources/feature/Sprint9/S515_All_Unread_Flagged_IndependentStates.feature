@UK @HK @SG
@Epic_GPBM-364(Documents)
#@Story_GPBM-3114 @Sprint9_iOS
@Story_GPBM-3122 @Sprint9_aOS
@NotAutomatable
# cannot check the filter states
Feature: All/Unread/Flagged independent states

  As a bank we don't want the client to be able to filter by All,Unresd and Flagged at the same time,
  so that the list of documents displayed to the user is useful for them

  @S515-AC1-AT1
  Scenario: Check change All filter from ACTIVE to INACTIVE when I tap on "Unread" filter
    Given I am viewing documents screen
    When I tap on "All" filter to show all documents
    And I tap "Unread" filter
    Then I should see the "All" filter should change from ACTIVE to INACTIVE state
    And I should see the "Unread" filter applied should change from INACTIVE to ACTIVE state

  @S515-AC1-AT2
  Scenario: Check change All filter from ACTIVE to INACTIVE when I tap on "Flagged" filter
    Given I am viewing documents screen
    When I tap on "All" filter to show all documents
    And I taps "Flagged" filter
    Then I should see the "All" filter should change from ACTIVE to INACTIVE state
    And I should see the "Flagged" filter applied should change from INACTIVE to ACTIVE state


  @S515-AC1-AT3
  Scenario: Check change Unread filter from ACTIVE to INACTIVE when I tap on "All" filter
    Given I am viewing documents screen
    When I tap on "Unread" filter to show all documents
    And I tap "All" filter
    Then I should see the "Unread" filter should change from ACTIVE to INACTIVE state
    And the new filter applied should change from INACTIVE to ACTIVE state

  @S515-AC1-AT4
  Scenario: Check change Unread filter from ACTIVE to INACTIVE when I tap on "Flagged" filter
    Given I am viewing documents screen
    When I tap on "Unread" filter to show all documents
    And I tap "Flagged" filter
    Then I should see the "Unread" filter should change from ACTIVE to INACTIVE state
    And I should see the "Flagged" filter applied should change from INACTIVE to ACTIVE state

  @S515-AC1-AT5
  Scenario: Check change Flagged filter from ACTIVE to INACTIVE when I tap on "All" filter
    Given I am viewing documents screen
    When I tap on "Flagged" filter to show all documents
    And I tap "All" filter
    Then I should see the "Flagged" filter should change from ACTIVE to INACTIVE state
    And I should see the "All" filter applied should change from INACTIVE to ACTIVE state

  @S515-AC1-AT6
  Scenario: Check change Flagged filter from ACTIVE to INACTIVE when I tap on "Unread" filter
    Given I am viewing documents screen
    When I tap on "Flagged" filter to show all documents
    And I tap "Unread" filter
    Then I should see the "Flagged" filter should change from ACTIVE to INACTIVE state
    And I should see the "Unread" filter applied should change from INACTIVE to ACTIVE state


  @S515-AC1-AT7
  Scenario: Check I can see default "All" document list when I am viewing "Flagged" document list and back to More Menu and then enter into Document screen
    Given I am viewing "Flagged" Document list
    When I click "More Menu" back button
    And I click "Document" tab
    Then I should see "All" tab is ACTIVE
    And I should see "All" Document list will displayed


  @S515-AC1-AT8
  Scenario: Check I can see default "All" document list when I am viewing "Unread" document list and back to More Menu and then enter into Document screen
    Given I am viewing "Unread" Document list
    When I click "More Menu" back button
    And I click "Document" tab
    Then I should see "All" tab is ACTIVE
    And I should see "All" Document list will displayed

