@HK @SG @UK
@Epic_GPBM-459(More_menu)
@Story_GPBM-608 @Sprint2_iOS
@Story_GPBM-1069 @Sprint2_aOS

Feature: Display  Username

  As a client I want to see to see the date and time of when i last logged into the Wealth Dashboard on either browser or mobile,
  so that I know that nobody has accessed my accounts fraudulently since I last logged in

  @S40-AC1-AT1
  Scenario: Check the username within the top of the more menu page
    Given I login as type "has_account"
    When I tap on More Menu button
    Then I should see their Username displayed within the fixed wrapper at the top of the menu