@HK @SG
@Epic_GPBM-459(More_menu)
@Story_GPBM-562 @Sprint4_iOS
@Story_GPBM-1370 @Sprint3_aOS

Feature: Link to KRC

  As a client I want to be able to access the KRC website via the mobile app,
  so that I can view related investment content without needing to exit the app and open a browser separately

  Scenario: login userE for GPBM562
    Given I login as type "has_account"
    When I tap on More Menu button
    And I tap on ‘Knowledge & Research Centre’ More Menu item
    Then I should on the KRC page

  @S120-AC1-AT1
  @DependsOn('login_userE_for_GPBM562')
  Scenario: Check the KRC website page screen UI
    Given I am on the KRC page
    Then I should see an introduction to KRC and a Log on CTA directing the client to the KRC website:
      | element name          | element value                                                                         |
      | KRC back button       |                                                                                       |
      | head title label      | Knowledge & Research Centre                                                           |
      | Background image      |                                                                                       |
      | Background image text | Connect to the best of HSBC’s investment thinking                                     |
      | exclusive image       |                                                                                       |
      | exclusive label       | Exclusive investment content and topical market trends from industry specialists      |
      | comment image         |                                                                                       |
      | comment label         | Commentaries on Macroeconomics, Currencies, Equities and Fixed Income                 |
      | investment image      |                                                                                       |
      | investment label      | Make more informed investment decisions with information at your fingertips           |
      | register label        | Contact your Relationship Manager to register                                         |
      | login button          | Login to Knowledge & Research Centre                                                  |
      | foot label            | Visiting Knowledge & Research Centre will log you out of the HSBC Private Banking app |

  @S120-AC6-AT1
  @DependsOn('login_userE_for_GPBM562')
  Scenario: Check whether I can return to main More Menu page when I tap "Back" on KRC screen
    Given I am on the KRC page
    When I tap “Back” in KRC screen
    Then I return to main More Menu container

  Scenario: login userE for overlay of Logining CTA at the KRC website page
    Given I login as type "has_account"
    When I tap on More Menu button
    And I tap on ‘Knowledge & Research Centre’ More Menu item
    And I tap on Login CTA in KRC screen
    Then I should on the overlay of Logining CTA at the KRC website page

  @S120-AC2-AT1
  @DependsOn('login_userE_for_overlay_of_Logining_CTA_at_the_KRC_website_page')
  Scenario: Check the overlay of Logining CTA at the KRC website page
    Given I am on the overlay of Logining CTA at the KRC website page
    Then I am shown the following warning overlay:
      | element name                 | element value                                                  |
      | overlay title                | You are about to be logged out of the HSBC Private Banking App |
      | "Don't show me again" button | Don’t show me again                                            |
      | "OK" button                  | OK                                                             |
      | IOS "Cancel" button          | Cancel                                                         |
      | Android "Cancel" button      | CANCEL                                                         |

    #Remark: cannot check the background color

  @NotAutomatable
  Scenario: Check whether I can open in Safari with KRC URL when I tap login CTA
    When dummy

  #  S120-AC3-AT1
  #  Reason: Cannot check the browser

  @NotAutomatable
  Scenario: Check whether  I can open in Safari with KRC URL when I tap "Don't show me again" and "OK"
    When dummy

  #  S120-AC3-AT2
  #  Reason: Cannot check the browser

  @S120-AC4-AT1
  @Const(action="tap_on_KRC_login_button")
  @DependsOn('login_userE_for_overlay_of_Logining_CTA_at_the_KRC_website_page')
  Scenario: Check whether the overlay can be closed when I tap "Cancel" CTA
    Given I am on the overlay of Logining CTA at the KRC website page
    When I tap “Cancel” on KRC overlay
    Then I remain on the KRC screen
    And login warning overlay is closed

  @S120-AC4-AT2
  @DependsOn('login_userE_for_overlay_of_Logining_CTA_at_the_KRC_website_page')
  Scenario: Check the overlay can be closed when I select "Don't show me again" and tap "Cancel"
    Given I am on the overlay of Logining CTA at the KRC website page
    When I select "Don't show me again"
    And I tap “Cancel” on KRC overlay
    Then I remain on the KRC screen
    And login warning overlay is closed


  @NotAutomatable
#  Background: suggest I have selected " Don't show me again" and tap "OK" or "Cancel"
  Scenario: Check whether the warning overlay is NOT shown
    When dummy

  #  S120-AC5-AT1
  #  Reason: Cannot check the browser

  @NotAutomatable
#  Background: suggest I have selected " Don't show me again" and tap "OK" or "Cancel" and relaunch app
  Scenario: Check whether the warning overlay is NOT shown after I kill the app
    When dummy

  #  S120-AC5-AT2
  #  Reason: Cannot check the browser

  @NotAutomatable
#  Background: suggest I have selected " Don't show me again" and tap "OK" or "Cancel" and logout，and then I login in app
  Scenario: Check whether the warning overlay is NOT shown after logout
    When dummy

  #  S120-AC5-AT3
  #  Reason: Cannot check the browser

  @NotAutomatable
  Scenario: Check the KRC URL
    When dummy

  #  S120-AC5-AT4
  #  Reason: Cannot check the browser




