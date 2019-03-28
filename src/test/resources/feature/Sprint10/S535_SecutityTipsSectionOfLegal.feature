@HK @SG
@Epic_GPBM-2970(Mandatory_documents)
@Story_GPBM-3242 @Sprint10_iOS
@Story_GPBM-3243 @Sprint10_aOS

Feature: Security Tips section of Legal

  As a client I want to view the Portfolio name,
  so that I can easily differentiate between the accounts

  @S535-AC1-AT1
  Scenario: Check whether I can see the "Security tips" sub menu when I tap "Legal"
    Given I login as type "has_account"
    When I tap on Legal button
    Then I can see the "Security tips" sub menu

  @S535-AC1-AT2
  @DependsOn('Check_whether_I_can_see_the_"Security_tips"_sub_menu_when_I_tap_"Legal"')
  Scenario: Check whether I can be taken to the Security Tips screen when I tap "Security Tips" link
    Given I am on the Legal section
    When I tap "Security Tips" link
    Then I am taken to the Security Tips screen where they can view the latest version of the Security Tips
    #Remark: can't check the html

  @S535-AC1-AT3
  @DependsOn('Check_whether_I_can_be_taken_to_the_Security_Tips_screen_when_I_tap_"Security_Tips"_link')
  Scenario: Check whether I can back to Legal screen when I tap "Legal" Back button at Security Tips Page
    Given I am viewing the Security Tips screen
    When I tap "Legal" back button
    Then I should see the following components on the Legal screen
      | element name            | element value           |
      | Terms and Conditions    | Terms and Conditions    |
      | Privacy Policy          | Privacy Policy          |
      | Accessibility Statement | Accessibility statement |
      | Security Tips           | Security Tips           |