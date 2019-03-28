@HK @SG @UK
@Epic_GTMB-459(More_menu)
@Story_GTMB-360 @Sprint2_iOS
@Story_GTMB-1065

Feature: More Menu

  As a client I want to be able to access a menu of additional features that relate my use of the app,
  so that I can perform additional functions outside of viewing my wealth and investment activity.

  @Sprint2_aOS
  Scenario: login userE for GPBM360
    Given I login as type "has_account"
    When I tap on More Menu button
    Then I should on the More Menu

  @Sprint2_aOS
  @S38-AC1-AT1
  @DependsOn('login_userE_for_GPBM360')
  Scenario: Check the More Menu UI
    Given I am on the More Menu
    Then I should see the following components on the More Menu Screen
      | element region | element name                      | element value               |
#      |                | Username                          |                             |
      |                | Last login time                   |                             |
      |                | Glossary of terms label           | Glossary of terms           |
      |                | Security label                    | Security                    |
      |                | Feedback label                    | Feedback                    |
      |                | Legal label                       | Legal                       |
      | HK_SG          | Knowledge & research Centre label | Knowledge & Research Centre |
      |                | Log Out button                    | Log off                     |
      |                | IOS "X" button                    |                             |

#    Update for sprint5
#  @S38-AC1-AT2
#  @DependsOn('login_userE_for_GPBM360')
#  Scenario: Check the statue of Touch ID Toggle
#    Given I am on the More Menu
#    When I tap on Security button
#    And I tap the Touch ID Toggle
#    Then I should see the Touch ID Toggle status is ON

  # android no has this AT
  @IOS
  @S38-AC1-AT3
  @Const(action="tap_on_More_Menu_button")
  @DependsOn('login_userE_for_GPBM360')
  Scenario: Check the way of closing the More Menu by taps "X"
    Given I am on the More Menu
    When I tap on menu "X" button
    Then I should see the More menu will be closed

  @Sprint2_aOS
  @S38-AC1-AT4
  @Const(action="tap_on_More_Menu_button")
  @DependsOn('login_userE_for_GPBM360')
  Scenario: Check the way of closing the More Menu by taps The left blank
    Given I am on the More Menu
    When I tap the left blank
    Then I should see the More menu will be closed

  @Sprint2_aOS
  @S38-AC1-AT5
  @Const(action="tap_on_More_Menu_button")
  @DependsOn('login_userE_for_GPBM360')
  Scenario: Check the way of closing the More Menu by Gestures right
    Given I am on the More Menu
    When I gesture to slide to the right
    Then I should see the More menu will be closed

#   Update for sprint5
#  @S38-AC1-AT6
#  @DependsOn('login_userE_for_GPBM360')
#  Scenario: Check there is a red icon when the document has a message
#    Given I am on the More Menu
#    Then I should see the red icon when the document has a message


