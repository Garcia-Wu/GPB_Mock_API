@NotAutomatable
@HK @SG @UK
@Epic_GPBM-459(More_Menu)
@Story_GPBM-1191 @Sprint6_iOS
@Story_GPBM-2168 @Sprint6_aOS

Feature: Accessibility Statement

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S267-AC1-AT1
  Scenario: Check Accessing accessibility statement UI
    Given I login as type "has_account"
    And I tap on More Menu button
    And I tap on Legal button
    When I taps "Accessibility Statement" link
    Then I should taken to the accessibility statement screen where they can view the following copy:
      | element name      | element value                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
      | back legal button | Legal                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
      | title             | Accessibility statement                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
      | ios content       | HSBC’s commitment to accessibilityHSBC are committed to making our websites and apps usable by all people, whatever their abilities, technology or preferences. We are actively working to increase the accessibility and usability of this site and, in doing so, endeavour to adhere to accessibility guidelines such as WCAG 2.0 and BS 8878.Adapt your experience to your needsWhile our app has been created to be usable “as is”, many people are likely to get the most accessible experience of using this app by customising their phone or tablet to suit their individual needs - for example: to get the app spoken to them, to change its colour-scheme, or increase the size of its fonts.If that sounds like it would be useful to you, we recommend you visit Apple’s Accessibility page to find out how these customisations (achieved by using accessibility features already on your phone or tablet) might suit you.Limitations of this app’s accessibility[an explanation of your product’s deficiencies, and an idea of when they will be fixed should go here - TBC]If any of these current limitations prevent you from getting the information you need from our site, please call your Customer Services Executive.Please let us know if you have difficulties using this appWe are always looking to improve the accessibility of our app. So, if you find anything in the app difficult to use, please let us know by contacting your Customer Services Executive.All constructive feedback regarding the accessibility or usability of our app is welcome and will be carefully considered.This accessibility statement was last updated on <date> and follows the advice on accessibility statements in British Standard BS 8878.              |
      | aos content       | HSBC’s commitment to accessibility  HSBC are committed to making our websites and apps usable by all people, whatever their abilities, technology or preferences. We are actively working to increase the accessibility and usability of this site and, in doing so, endeavour to adhere to accessibility guidelines such as WCAG 2.0 and BS 8878.  Adapt your experience to your needs  While our app has been created to be usable “as is”, many people are likely to get the most accessible experience of using this app by customising their phone or tablet to suit their individual needs - for example: to get the app spoken to them, to change its colour-scheme, or increase the size of its fonts.   If that sounds like it would be useful to you, we recommend you visit Android’s Accessibility page to find out how these customisations (achieved by using accessibility features already on your phone or tablet) might suit you.  Limitations of this app’s accessibility  [an explanation of your product’s deficiencies, and an idea of when they will be fixed should go here - TBC]   If any of these current limitations prevent you from getting the information you need from our site, please call your Customer Services Executive.  Please let us know if you have difficulties using this app  We are always looking to improve the accessibility of our app. So, if you find anything in the app difficult to use, please let us know by contacting your Customer Services Executive.   All constructive feedback regarding the accessibility or usability of our app is welcome and will be carefully considered.   This accessibility statement was last updated on <date> and follows the advice on accessibility statements in British Standard BS 8878. |

  @NotAutomatable
#  @DependsOn('login_in_for_accessibility_statement')
  Scenario: Check when tap Apple accessibility hyperlink
    Given I am on the Accessibility Statement page
    When I tap on Apple's Accessibility page hyperlink
    Then I should shown the following warning overlay: "You are about to be logged out of the HSBC Private Banking App"
    And a Accessibility Statement CTA "OK"
    And a Accessibility Statement CTA "Cancel"
    And a Accessibility Statement CTA "Don't show me again"
#  @S267-AC2-AT1
#   Reason: can't tap on Apple's Accessibility page hyperlink

  @NotAutomatable
  Scenario: Check confirm opening of Apple's Accessibility page
    Given I have tapped Apple's Accessibility page hyperlink
    When I tap "OK"
    Then I am logged out of app
    And app moves into background of apps on device
    And browser automatically opens in the device's default browser with URL: http://www.apple.com/accessibility/
#  @S267-AC3-AT1
#   can not check : browser automatically opens in the device's default browser with URL: http://www.apple.com/accessibility/

  @NotAutomatable
#  @DependsOn('Check_when_tap_Apple_accessibility_hyperlink')
  Scenario: Check  cancel opening of Apple's Accessibility pag
    Given I am shown the following warning overlay: "You are about to be logged out of the HSBC Private Banking app"
    When I tap 'Cancel' on Apple's Accessibility pag
    Then I remain on the accessibility statement screen
    And accessibility statement warning overlay is closed
#  @S267-AC4-AT1
#   Reason: can't tap on Apple's Accessibility page hyperlink

  @NotAutomatable
  Scenario: Check select "Don't show me again" and tap "OK"
    Given I am on the Accessibility Statement page
    When I select "Don't show me again*
    And I tap OK
    And returns taps on accessibility link on any subsequent occasion
    Then logout warning overlay is NOT shown
    And client browser automatically opens in the device's default browser with URL: http://www.apple.com/accessibility/
    And app closes
    #    @S267-AC5-AT1
#  can not check :And client browser automatically opens in the device's default browser with URL: http://www.apple.com/accessibility/
#    And app closes

  @NotAutomatable
  Scenario: Check select "Don't show me again" and tap Cancel
    Given I login as User
      | element name | element value |
      | Name         | userN         |
      | password     | 123           |
    And I tap on More Menu button
    And I tap on Legal button
    And I taps "Accessibility Statement" link
    And I tap on Apple's Accessibility page hyperlink
    When I select Accessibility "Don't show me again"
    And I tap 'Cancel' on Apple's Accessibility pag
    Then I remain on the accessibility statement screen
    And accessibility statement warning overlay is closed
#   @S267-AC6-AT1
#   Reason: can't tap on Apple's Accessibility page hyperlink

  @NotAutomatable
#  @DependsOn('Check_select_"Don't_show_me_again"_and_tap_Cancel')
  Scenario: Check exiting accessibility statement
    Given I am remain on the accessibility statement screen
    When I tap "Legal" back button
    Then I should see the Legal screen with Terms and Conditions, Privacy Policy and Accessibility Statement links
#    @S267-AC7-AT1
#   Reason: can't tap on Apple's Accessibility page hyperlink