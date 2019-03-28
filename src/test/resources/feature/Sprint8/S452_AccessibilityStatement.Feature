@HK @SG
@Epic_GPBM-459(More_Menu)
@Story_GPBM-2744 @Sprint7_iOS
@Story_GPBM-2745 @Sprint7_aOS

Feature: Accessibility Statement

  As a client I want to be reminded that i will be logged out of the app if i tap on a hyperlink within the privacy policy, so that I have the choice to remain logged in or not

  @NotAutomatable
  Scenario: Check the pop up UI in Accessibility Statement
    Given client is viewing the accessibility statement screen
    When client taps on a hyperlink to apple's accessibility page within the copy
    Then a pop up with the following copy is displayed:
      | element name    | element value                                                  |
      | hyerlink pop up | You are about to be logged out of the HSBC Private Banking app |
      | CTA "OK"        | OK                                                             |
      | CTA "Cancel"    | Cancel                                                         |
    And the client is not shown a "Don't show me again" check box
#   @S452-AC1-AT1
#   Reason: can't click hyperlink to apple's accessibility page

  @NotAutomatable
  Scenario: Check confirm request in Accessibility Statement
    Given client has tapped on the hyperlink within the accessibility statement screen
    When client taps OK
    Then client is logged out of app
    And app closes
    And browser automatically opens in Safari with the URL:  http://www.apple.com/accessibility/
#   @S452-AC1-AT2
#   Reason: can't click hyperlink to apple's accessibility page

  @NotAutomatable
  Scenario: Cancel login request Check cancel login request in Accessibility Statement	"Given client has tapped on the hyperlink within the accessibility statement
    When client taps Cancel
    Then client remains on the accessibility statement screen
    And the log out warning overlay is closed
#   @S452-AC1-AT3
#   Reason: can't click hyperlink to apple's accessibility page
