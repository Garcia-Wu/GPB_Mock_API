@HK @SG
@Epic_GPBM-2970(Mandatory_documents)
@Story_GPBM-3561 @Sprint17_iOS
@Story_GPBM-3632 @Sprint17_aOS

Feature: Show disclaimer at the bottom of the Glossary of Terms - Asia

  As a Product owner, I want to ensure that clients are displayed their localised legal documents,
  so that they understand the conditions of the service

  @S3561-AC1-AT1
  Scenario: Check whether disclaimer at the bottom of the Glossary of Terms is correct
    Given I login as type "has_account"
    When I tap on More Menu button
    And I tap on Glossary of terms
    And I slide to the bottom of the Glossary of Terms screen
    Then I should see the following message on the Glossary of Terms screen
      | element name       | element value                                                                                                                                                                                                                       |
      | disclaimer message | If there are any inconsistencies between these terms and the Bank’s Standard Terms and Conditions, the Standard Terms and Conditions shall prevail. This page shall be updated when required as determined by HSBC Private Banking. |