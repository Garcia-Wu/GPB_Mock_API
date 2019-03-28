@HK @SG
@Epic_GPBM-2970(Mandatory_documents)
@Story_GPBM-3242 @Sprint10_iOS
@Story_GPBM-3243 @Sprint10_aOS

Feature: Empty state - Portfolio list

  As a client I want to view the Portfolio name,
  so that I can easily differentiate between the accounts

  @S533-AC1-AT1
  Scenario: Check the Accessing Privacy of Security and Terms of use
    Given I login as type "has_account"
    When I tap on More Menu button
    And I tap on Legal button
    And I tap "Privacy Policy" link
    Then I am taken to the Privacy Policy screen where they can view the clear header of "Privacy policy"

  #Remark: can't check the html