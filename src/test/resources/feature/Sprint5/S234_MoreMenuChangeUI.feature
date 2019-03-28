@HK @SG @UK
@Epic_GPBM-459(More_Menu)
@Story_GPBM-2163 @Sprint5_iOS
@Story_GPBM-2164 @Sprint5_aOS

Feature: More Menu - Change UI
  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S234-AC1-AT1
  Scenario: update the More Menu UI
    Given I login as type "has_account"
    When I tap on More Menu button
    Then I should see the following components on the More Menu Screen
      | element region | element name                      | element value               |
      |                | Username                          |                             |
      |                | Last login time                   |                             |
      |                | Glossary of terms label           | Glossary of terms           |
      |                | Security label                    | Security                    |
      |                | Feedback label                    | Feedback                    |
      |                | Legal label                       | Legal                       |
      | HK_SG          | Knowledge & research Centre label | Knowledge & Research Centre |
      |                | Log Out button                    | Log off                     |
      |                | IOS "X" button                    |                             |
