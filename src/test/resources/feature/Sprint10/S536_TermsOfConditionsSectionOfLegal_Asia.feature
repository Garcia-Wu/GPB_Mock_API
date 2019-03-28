@HK @SG
@Epic_GPBM-2970(Mandatory_documents)
@Story_GPBM-3244 @Sprint10_iOS
@Story_GPBM-3245 @Sprint10_aOS

Feature: Terms of Conditions section of Legal(Asia)

  As a client I want to view the Portfolio name,
  so that I can easily differentiate between the accounts
  
  Scenario: I am in the Legal section of "More" menu
    Given I login as type "has_account"
    When I tap on More Menu button
    And I tap on Legal button
    Then I should on the Legal section

  @S536-AC1-AT1
  @DependsOn('I_am_in_the_Legal_section_of_"More"_menu')
  Scenario: Check whether Terms and conditions renamed to Terms of service
    Given I am on the Legal section
    Then I am taken to the Legal page with Terms and conditions renamed to "Terms of service"

  @S536-AC1-AT2
  @DependsOn('I_am_in_the_Legal_section_of_"More"_menu')
  Scenario: Check Accessing Terms of service
    Given I am on the Legal section
    When I tap "Terms of service" link
    Then I am taken to the Terms of Conditions screen where they can view the tab of "Terms of Conditions"
    And On the right,they can also view the tab of "Terms of use"
    #Remark: can't check the html

  @S536-AC1-AT3
  Scenario: Check Accessing Terms of Conditions and Terms of use before registration
    Given I am in the registration flow in mobile app
    When "Terms of Conditions" is displayed
    Then I am taken to the Terms of Conditions screen where they can view the tab of "Terms of Conditions"
    And On the right,they can also view the tab of "Terms of use"
    #Remark: can't check the html

  @NotAutomatable
  Scenario: Check the content of "Terms of Conditions" when Tap Terms of Conditions
    Given I am in the Term of service in Legal section
    When I tap "Terms of Conditions" tab
    Then the "Terms of Conditions" tab is active
    And the "Terms of Use" is inactive
    And the content of "Terms of Conditions" will be displayed
    #S536-AC1-AT4
    # Reason: cannot check the tab state

  @NotAutomatable
  Scenario: Check the content of "Terms of Use" when Tap Terms of Use
    Given I am in the Term of service in Legal section
    When I tap "Terms of Use" tab
    Then the "Terms of Use" tab is active
    And the "Terms of Conditions" is inactive
    And the content of "Terms of Use" will be displayed
    #S536-AC1-AT5
    # Reason: cannot check the tab state