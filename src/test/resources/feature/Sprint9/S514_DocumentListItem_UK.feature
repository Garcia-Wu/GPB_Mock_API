@UK @HK @SG
@Epic_GPBM-364(Documents)
#@Story_GPBM-3114 @Sprint9_iOS
@Story_GPBM-3064 @Sprint9_aOS

Feature: Document list item (UK)

  As a client I want to see certain information displayed for each document published to my app,
  so that I have all relavant details about each documents at a glance

  Scenario: I am viewing the Document Screen for GPBM-3064
    Given I login as type "document_account_num_more_than_5"
    When I tap on More Menu button
    And I tap on the "Documents" more menu tab
    Then The default Documents list view should be displayed

  @S514-AC1-AT3
  @DependsOn('I_am_viewing_the_Document_Screen_for_GPBM-3064')
  Scenario: Check the 1 decimal place format of Document file size value in "All" Document list
    Given I am viewing the Documents list view
    Then I should see that the Document file size value in megabytes shown as "mb" 1 d.p.

  @S514-AC1-AT1
  @DependsOn('I_am_viewing_the_Document_Screen_for_GPBM-3064')
  Scenario: Check Details to display for Advices documents
    Given I am viewing the Documents list view
    When I view a list item representing one document which belongs to "Advice" categories
    Then I should see the following information within that list item for advice categories:
      | element name                                        | element value |
      | Document category value                             | Advice        |
#      | Document sub-category value                         | Cash          |
      | Document name value                                 |               |
      | Account name value                                  |               |
#      | Flag icon                                           |               |
      | Document file size value in megabytes shown as "mb" |               |

  @S514-AC1-AT4
  @DependsOn('I_am_viewing_the_Document_Screen_for_GPBM-3064')
  Scenario: Check Details to display for Communications
    Given I am viewing the Documents list view
    When I view a list item representing one document which belongs to "Communication" categories
    Then I should see the following information within that list item for communication categories:
      | element name                                        | element value |
      | Document sub-category value                         | Communication |
      | Document name value                                 |               |
      | Account name value                                  |               |
#      | Flag icon                                           |               |
      | Document file size value in megabytes shown as "mb" |               |
    And Document category value is NOT displayed

  @S514-AC1-AT2
  @DependsOn('I_am_viewing_the_Document_Screen_for_GPBM-3064')
  Scenario: Check Details to display for Statements documents
    Given I am viewing the Documents list view
    When I view a list item representing one document which belongs to "Statement" categories
    Then I should see the following information within that list item for statement categories:
      | element name                                        | element value |
      | Document category value                             | Statement     |
#      | Document sub-category value                         | Cash          |
      | Document name value                                 |               |
      | Account name value                                  |               |
#      | Flag icon                                           |               |
      | Document file size value in megabytes shown as "mb" |               |

  @S514-AC1-AT5
  @DependsOn('I_am_viewing_the_Document_Screen_for_GPBM-3064')
  Scenario: Check the 1 decimal place format of Document file size value in "Unread" Document list
    Given I am viewing the Documents list view
    When I tap on the document component labelled "Unread"
    Then I should see that the Document file size value in megabytes shown as "mb" 1 d.p.

  @NotAutomatable
  Scenario: Check display date of publication
    Given I am viewing the Documents screen
    And I have one or more documents in the documents list
    Then I should see all documents published on the same date (based on system generation date) listed beneath a date header labelled with the date value
  # S514-AC1-AT6
  # Reason: cannot check the date

  @S514-AC1-AT8
  Scenario: Check dd Month yyyy date format in Document screen if > day 9
    Given I login as type "document_has_day_more_than_9"
    When I tap on More Menu button
    And I tap on the "Documents" more menu tab
    And I slip to the date day > 9 document item
    Then I should see the date format dd Month yyyy when date > day 9

  @S514-AC1-AT7
  Scenario: Check d Month yyyy date format in Document screen if < day 10
    Given I login as type "document_has_day_less_than_10"
    When I tap on More Menu button
    And I tap on the "Documents" more menu tab
    And I slip to the date day < 10 document item
    Then I should see the date format d Month yyyy when date < day 10

  @NotAutomatable
  Scenario: Check Date header is sticky
    Given I am viewing the documents screen
    And I have one or more document in the documents list
    When I slip up the list
    Then I should see the date header is sticky beneath Document title
  # S514-AC1-AT9
  # Reason: cannot check header is sticky beneath Document title

  @NotAutomatable
  Scenario: Check Date header can be replaced
    Given I am viewing the documents screen
    And I have one or more document in the documents list
    When I slip up the list
    Then I should see the date header can be replace
    And I should see the next date header is sticky beneath Document title
  # S514-AC1-AT10
  # Reason: cannot check header is sticky beneath Document title