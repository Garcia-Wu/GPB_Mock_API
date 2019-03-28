@HK @SG @UK
@Epic_GPBM-459(More_Menu)
@Story_GPBM-561 @Sprint6_iOS
@Story_GPBM-2073 @Sprint6_aOS

Feature: Legal section overview

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  Scenario: login userE for GPBM561
    Given I login as type "has_account"
    When I tap on More Menu button
    And I tap on Legal button
    Then I should on the Legal section

  @S262-AC1-AT1
  @DependsOn('login_userE_for_GPBM561')
  Scenario: Check accessing Legal section of More Menu
    Given I am on the Legal section
    Then I should see legal section with the following links:
      | element name            | element value           |
      | Legal title             | Legal                   |
      | Back button             | Menu                    |
      | Terms and Conditions    | Terms & Conditions      |
      | Privacy Policy          | Privacy policy          |
      | Accessibility Statement | Accessibility statement |

  @S262-AC1-AT2
  @DependsOn('login_userE_for_GPBM561')
  Scenario: Check exiting Legal section of More Menu
    Given I am on the Legal section
    When I tap "Menu" back button on Legal section
    Then I should see the More menu container
