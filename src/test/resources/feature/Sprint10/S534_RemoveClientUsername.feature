@UK @HK @SG
@Epic_GPBM-459(More_Menu)
@Story_GPBM-3236 @Sprint10_iOS
@Story_GPBM-3241 @Sprint10_aOS

Feature: Remove client username

  As a client I want to view the Portfolio name,
  so that I can easily differentiate between the accounts

  @S534-AC1-AT1
  Scenario: Check whether the username will be removed in More menu page
    Given I login as type "has_account"
    When I tap on More Menu button
    Then I am not able to view their username, I can instead view - "HSBC Private Banking"