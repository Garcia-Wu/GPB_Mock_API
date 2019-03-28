@UK @HK @SG
@Epic_GPBM-364(Documents)
#@Story_GPBM-3114 @Sprint9_iOS
@Story_GPBM-3056 @Sprint9_aOS

Feature: All/Unread document filter

  As a client,I want to be able to apply a quick filter view between all documents and those that are unread,
  so that I can find my documents more easily

  @S513-AC1-AT1
  Scenario: Check whether the All document list is default displayed when I click Document tab in More menu page
    Given I login as type "document_has_unread_item"
    When I tap on More Menu button
    And I tap on the "Documents" more menu tab
    Then I should see the following components in document screen:
      | element name | element value |
      | All tab      | All           |
      | Unread tab   | Unread        |
      | Flagged tab  | Flagged       |
#    And "All" tab should be in an ACTIVE state by default
    And I should see all documents are displayed by default (read and unread)

#    Remark: cannot check the tab state


  @S513-AC1-AT2
  @DependsOn('Check_whether_the_All_document_list_is_default_displayed_when_I_click_Document_tab_in_More_menu_page')
  Scenario: Check the disclaimer in the bottom of "All" filter list
    Given I am viewing default Document screen
    When I slip to the bottom of "All" Document list
    Then I should see the following disclaimer in document list bottom:
      | element name | element value                                                            |
      | disclaimer   | Please contact your relationship management team for historic documents. |

  @NotAutomatable
  Scenario: Check only show "Unread" Document list
    Given I am viewing default Document screen
    When I tap on the document component labelled "Unread"
    Then I can see Documents which have NOT yet been opened should be displayed
    And the "Unread" component  should be in an ACTIVE state
    And the "View all" component should be in an INACTIVE state
    And only unread documents should be displayed until the user ends the current app session
  # S513-AC1-AT3
  # Reason: cannot check the tab state and document item type

  @NotAutomatable
  Scenario: Check show All documents
    Given I am viewing "Unread" Document list
    When I tap on the component "All"
    Then I should see all documents should be displayed
    And the "Unread" component should be in an INACTIVE state
#    And any filter applied within the main "Filter" component should be removed
    And the "All" component should be in an ACTIVE state
  # S513-AC1-AT4
  # Reason: cannot check the tab state and document item type

  @S513-AC1-AT5
  @DependsOn('Check_whether_the_All_document_list_is_default_displayed_when_I_click_Document_tab_in_More_menu_page')
  Scenario: Check show unread count
    Given I am viewing default Document screen
    Then I should see a count adjacent to the label indicating the number of unread documents

  @S513-AC1-AT6
  @DependsOn('Check_whether_the_All_document_list_is_default_displayed_when_I_click_Document_tab_in_More_menu_page')
  Scenario: Check whether count will be reduced by -1 when I click the unread document in "Unread" document list
    Given I am viewing default Document screen
    When I tap on the document component labelled "Unread"
    And I click one of the "Unread" document item which I have not click before
    Then I should see the unread count should reduce by -1