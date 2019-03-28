@HK @SG @UK
@Epic_GPBM-459(More_menu)
@Story_GPBM-567 @Sprint2_iOS
@Story_GPBM-1073 @Sprint2_aOS

Feature: Log out

  As a client I want to have the option to actively log out of the Wealth Dashboard rather than just close my app,
  so that I know I am logged out

  @S42-AC1-AT1
  Scenario: Check the function of the Log Out at More Menu page.
    Given I login as type "has_account"
    When I tap on More Menu button
    And I tap on Log Out button
    Then I will return to the login screen

  @S42-AC1-AT2
  #create by yippee
  Scenario: Check the function of the Log Out at More Menu page for cancel logout.
    Given I login as type "has_account"
    When I tap on More Menu button
    And I tap on cancel button of Log Out pop up page
    Then I will return back more menu screen











