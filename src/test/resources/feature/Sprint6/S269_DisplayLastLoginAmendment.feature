@HK @SG @UK
@Epic_GPBM-459(More_Menu)
@Story_GPBM-1045 @Sprint6_iOS
@Story_GPBM-2060 @Sprint6_aOS

Feature: Display last login (amendment)

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S269-AC1-AT1
  Scenario:Check last login timestamp
    Given I login as type "has_account"
    And I tap on More Menu button
    Then I should see the date and time that they last logged into the Wealth Dashboard on browser OR mobile in the format below:
#    And the date, time and time zone displayed should reflect the location that the user was in during their last login
#    And NOT the location that they are currently in (it may be different)


  @NotAutomatable
  Scenario:Check first login timestamp
    Given I am NOT registered on Wealth Dashboard
    When I completes registration on mobile
    And opens More Menu for the first time
    Then the last login timestamp displayed should be the date and time of registration completion on mobile
#    @S269-AC1-AT2
#  Reason：: the development has not do the register function