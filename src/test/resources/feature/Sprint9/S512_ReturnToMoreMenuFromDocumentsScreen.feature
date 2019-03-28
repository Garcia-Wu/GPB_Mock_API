@UK @HK @SG
@Epic_GPBM-364(Documents)
#@Story_GPBM-3114 @Sprint9_iOS
@Story_GPBM-3052 @Sprint9_aOS

Feature: Return to More menu from Documents screen

  As a client I want to be return More menu after viewing my documents,
  so that I can view the rest of the app

  @S512-AC1-AT1
  Scenario: Check whether I can view Document list when I tap on the Documents more menu tab
    Given I login as type "has_account"
    When I tap on More Menu button
    And I tap on the "Documents" more menu tab
    Then The default Documents list view should be displayed

  @S512-AC1-AT2
  @DependsOn('Check_whether_I_can_view_Document_list_when_I_tap_on_the_Documents_more_menu_tab')
  Scenario: Check return to More menu from Documents screen
    Given I am viewing the Documents list view
    When I tap on the back button labelled "Menu" in documents screen
    Then I should return to the More menu page