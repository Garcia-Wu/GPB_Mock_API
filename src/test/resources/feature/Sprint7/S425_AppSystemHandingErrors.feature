@HK @SG @UK
#@Epic_GPBM-1094(App_System_Handing_Errorsy)
@Story_GPBM-2409 @Sprint7_iOS
@Story_GPBM-2410 @Sprint7_aOS

Feature: App System Handing Errors
  As a Client I want to see a detailed view regarding my Derivative holdings,
  so that I can see all related information about the particular holding.



  @NotAutomatable
  Scenario:Check the error message when system errors occurresulting from a "Gateway Timeout"
    Given I login as type "Gateway Timeout"
    Then display the following Gateway Timeout error message screen:
      | element name     | element value                                            |
      | Page Title       | Unexpected error                                         |
      | More Information | An unexpected error has occurred.Please try again later. |
    And include a CTA "Return to log on" within error message screen allowing the user to be redirected to the login screen
    And log user out of the app when Gateway Timeout
    #  @S425-AC1-AT1
    #  Reason: can't check the error message when system errors Gateway Timeout


  @NotAutomatable
  Scenario:Check the error message when system errors occurresulting from poor or insufficient network connectivity
    Given I am viewing any screen
    When one or more system errors occurresulting from poor or insufficient network connectivity
    Then display the following error message screen:
      | element name     | element value                                                                                                            |
      | Page Title       | Connectivity issue                                                                                                       |
      | More Information | Your device has an insufficient internet connection.Please ensure you have WiFi or mobile network coverage and try again |
    And include a CTA "Return to log on" within error message screen allowing the user to be redirected to the login screen
    And log user out of the app
#  @S425-AC1-AT2
#  Reason: can't check the error message when system errors occurresulting from poor or insufficient network connectivity

  @NotAutomatable
  Scenario:Check the error message when system errors occurresulting frome a back-end error casued by /FIX Server error(xAPI layer)/Partial xAPI failure(xAPI layer)/Full xAPI failure(xAPI layer)/xAPI operates logic errors(xAPI layer)
    Given I am viewing any screen
    When one or more system errors occurresulting frome a back - end error casued by:
#  -FIX Server error(xAPI layer)
#  -Partial xAPI failure(xAPI layer)
#  -Full xAPI failure(xAPI layer)
#  -xAPI operates logic errors(xAPI layer)
    Then display the following error message scrren:
#  Page Title:Unexpected error
#  More Information:An unexpected error has occurred.Please try again later.
    And include a CTA "Return to log on" within error message screen allowing the user to be redirected to the login screen
    And log user out of the app
#  @S425-AC1-AT3
#  Reason: can't check the error message

  @NotAutomatable
  Scenario:Check the error message when system errors occurresulting frome a back-end error casued by /FIX Server error(xAPI layer)/Partial xAPI failure(xAPI layer)/Full xAPI failure(xAPI layer)/xAPI operates logic errors(xAPI layer)
    Given I am viewing any screen
    When one oe more system errors occurresulting form a back - end caused by:
#  -FIX Server error(xAPI layer)
#  -Partial xAPI failure(xAPI layer)
#  -Full xAPI failure(xAPI layer)
#  -xAPI operates logic errors(xAPI layer)
    Then display the following error message scrren:
#  Page Title:Unexpected error
#  More Information:An unexpected error has occurred.Please try again later.
    And include a CTA "Return to log on" within error message screen allowing the user to be redirected to the login screen
    And log user out of the app
#  @S425-AC1-AT4
#  Reason: can't check the error message

  @NotAutomatable
  Scenario:Check the error message when system errors occurresulting form "Incorrect URL/parameters"
    Given I am viewing any screen
    When one oe more system errors occurresulting form "Incorrect URL/parameters"
    Then display the following error message scrren:
#  Page Title:Unexpected error
#  More Information:An unexpected error has occurred.Please try again later.
    And include a CTA "Return to log on" within error message screen allowing the user to be redirected to the login screen
    And log user out of the app
#  @S425-AC1-AT5
#  Reason: can't check the error message

  @NotAutomatable
  Scenario:Check the error message when system errors occurresulting form a "back-end FIX server error"
    Given I am viewing any screen
    When one oe more system errors occurresulting form a "back - end FIX server error"
    Then display the following error message scrren:
#  Page Title:Unexpected error
#  More Information:An unexpected error has occurred.Please try again later.
    And include a CTA "Return to log on" within error message screen allowing the user to be redirected to the login screen
    And log user out of the app
#  @S425-AC1-AT6
#  Reason: can't check the error message

  @NotAutomatable
  Scenario:Check the error message when system errors occurresulting form "any other back-end errors"
    Given I am viewing any screen
    When one oe more system errors occurresulting form "any other back - end errors"
    Then display the following error message scrren:
#  Page Title:Unexpected error
#  More Information:An unexpected error has occurred.Please try again later.
    And include a CTA "Return to log on" within error message screen allowing the user to be redirected to the login screen
    And log user out of the app
#  @S425-AC1-AT7
#  Reason: can't check the error message

  @NotAutomatable
  Scenario:Check the error message when system experiences an error cused by any of the following Gateway Timeout(FE)/No NetWork(FE)/Partial xAPI Failure(FE)/Full xAPI Failure(FE)/Incorrect URL/Parameters(BE)/FIX Server errors(BE)/Any other errors(BE)
    Given the error message screen is display containing the CTA when the system experiences an error cused by any of the following:
#  -Gateway Timeout(FE)
#  -No NetWork(FE)
#  -Partial xAPI Failure(FE)
#  -Full xAPI Failure(FE)
#  -Incorrect URL/Parameters(BE)
#  -FIX Server errors(BE)
#  -Any other errors(BE)
    When client taps on the CTA within the error message screen
    Then redirect client to the application login screen
    And the login screen is displayed
#  @S425-AC1-AT8
#  Reason: can't check the error message