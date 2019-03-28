@HK @SG @UK
@Epic_GPBM-459(More_menu)
@Story_GPBM-566 @Sprint2_iOS
@Story_GPBM-1071 @Sprint2_aOS

Feature: Display last login

  As a client I want to see the data and time of when I last logged into the Wealth Dashboard on either browser or mobile,
  so that I know that nobody has accessed my accounts fraudulently since I last logged in


  @S41-AC1-AT1
  @SIT
  Scenario: Check the format of logining time at the More menu page.
    Given I login as type "has_account"
    When I tap on More Menu button
    Then I should see the format of data and time that they last logged into the Wealth Dashboard on browser OR mobile

  @NotAutomatable
  Scenario: Check the last login timestamp displayed at the More menu page.
    Given client is not registered on Wealth Dashboard
    When client completes registration on mobile
    And opens More Menu for the first time
    Then the last login timestamp displayed should be the date and time of regidtration completion on mobile
  #  S41-AC1-AT2
  #  Reason: the development has not do the register function