@UK
@Epic_GPBM-364(Documents)
@Story_GPBM-3065 @Sprint10_aOS
@Story_GPBM-2911 @Sprint10_iOS

# ALL: Cannot check the filter status
Feature: Filter by Account(UK)

  As a client I want to view the Portfolio name,
  so that I can easily differentiate between the account

#  Scenario1:Open "Filter"
  @S532-AC1-AT1
  Scenario: Check the UI of Accounts list by the "Filter" component
    Given I login as type "document_has_account_filter"
    When I tap on More Menu button
    And I tap on the "Documents" more menu tab
    And I tap on the document filter btn
    Then a list of accounts that the client is entitled to view online is displayed with the following information:Account name value
#    And all accounts are selected by default
    And I should see the list of accounts has a header "Account"

  @S532-AC1-AT2
  Scenario: Check whether I see other Accounts list and the Categories list when I slip down the Accounts list for some distance
    Given I login as type "document_account_num_more_than_5"
    When I tap on More Menu button
    And I tap on the "Documents" more menu tab
    And I tap on the document filter btn
    And I tap on the filter header "Account"
    And I slip down the Accounts list for some distance
    Then I should see other document Accounts list below
    And I can see the Categories list

  @NotAutomatable
# cannot check the filter states
  @S532-AC1-AT3
  Scenario: Check whether "All" sub-filter is INACTIVE and "None" sub-filter is ACTIVE when I Re-login the APP and view the document screen
    Given I am Re-login the APP
    And I am viewing document screen
    When I tap "Filter" component
    And I expand the Accounts list
    And I expand the Categories list
    Then I should see the "All" sub-filter adjacent to Accounts list is INACTIVE
    And the "None" sub-filter adjacent to Accounts list is ACTIVE
    And the "All" sub-filter adjacent to Gategories list is INACTIVE
    And the "None" sub-filter adjacent to Gategories list is ACTIVE

#  Scenario2:Filter by one or more Accounts
  @S532-AC1-AT4
  Scenario: Check whether all documents related to the account(s) that I have selected should be displayed
    Given I login as type "document_account_num_more_than_1_less_than_6"
    When I tap on More Menu button
    And I tap on the "Documents" more menu tab
    And I tap on the document filter btn
    And I tap the first account filter button
    And closes the filter by tapping "X"
    Then I should only see all documents related to the account(s) that I have selected should be displayed
    And the "Filter" component should indicate that a filter has been "Filter applied"

  @NotAutomatable
# cannot check the filter states
  @S532-AC1-AT5
  Scenario: Check whether the "All" and "None" sub-filters is ACTIVE when a part of accounts in the list of accounts have been selected
    Given I am viewing Accounts list screen
    And a part of accounts in the list of accounts have been selected
    Then I should see the the "All" sub-filter is ACTIVE
    And the "None" sub-filter is ACTIVE


  @NotAutomatable
# cannot check the filter states
#  Background:
#  1、a part of accounts in the list of accounts have been selected
#  2、"All" sub-filter is ACTIVE
#  3、"None" sub-filter is ACTIVE
  @S532-AC1-AT6
  Scenario: Check whether all accounts in the list of accounts will not be selected when I tap "None" sub-filter
    Given I am viewing Accounts list filter
    And the "All" sub-filter is ACTIVE
    And the "None" sub-filter is ACTIVE
    When I tap "None" sub-filter
    Then I should see all accounts in the list of accounts will not be selected

  @NotAutomatable
# cannot check the filter states
#  Background:
#  1、a part of accounts in the list of accounts have been selected
#  2、"All" sub-filter is ACTIVE
#  3、"None" sub-filter is ACTIVE
  @S532-AC1-AT7
  Scenario: Check whether all accounts in the list of accounts will be selected when I tap "All" sub-filter
    Given I am vieiwng Accounts list filter
    And the "All" sub-filter is ACTIVE
    And the "None" sub-filter is ACTIVE
    When I tap "All" sub-filter
    Then I should see all accounts in the list of accounts will be selected

  @NotAutomatable
# cannot check the filter states， Check in AT4
#  Background: Step1
#  1、a part of accounts in the list of accounts have been selected
#  2、"All" sub-filter is ACTIVE
#  3、"None" sub-filter is ACTIVE
  @S532-AC1-AT8
  Scenario: Check whether all documents related to the account(s) that I have selected should be displayed
    Given I am viewing Accounts list filter
    And the "All" sub-filter is ACTIVE
    And the "None" sub-filter is ACTIVE
    When I tap "X" button to back to "All" Document list
    Then I should only see all documents related to the account(s) that I have selected should be displayed


  Scenario: a part of accounts in the list of accounts have been selected
    Given I login as type "document_account_num_more_than_1_less_than_6"
    When I tap on More Menu button
    And I tap on the "Documents" more menu tab
    And I tap on the document filter btn
    And I tap the first account filter button
    And closes the filter by tapping "X"
    Then I should on the document list screen

#  background: base on Step1
#  1、a part of accounts in the list of accounts have been selected
#  2、"All" sub-filter is ACTIVE
#  3、"None" sub-filter is ACTIVE
#  4、I come back to "All" Document list
  @S532-AC1-AT9
  @DependsOn('a_part_of_accounts_in_the_list_of_accounts_have_been_selected')
  Scenario: Check whether unread documents related to the account(s) that I have selected should be displayed
    Given I am on the document list screen
    When I tap on the document component labelled "Unread"
    Then I should only see unread documents related to the account(s) that I have selected should be displayed

#  Background:  base on Step1
#  1、a part of accounts in the list of accounts have been selected
#  2、"All" sub-filter is ACTIVE
#  3、"None" sub-filter is ACTIVE
#  4、I come back to "All" Document list
  @S532-AC1-AT10
  @DependsOn('a_part_of_accounts_in_the_list_of_accounts_have_been_selected')
  Scenario: Check whether flagged documents related to the account(s) that I have selected should be displayed
    Given I am on the document list screen
    When I tap "Flagged" Filter
    Then I should only see flagged documents related to the account(s) that I have selected should be displayed

  @NotAutomatable
# cannot check the filter states， Check in AT9
#  Background: Step1
#  1、a part of accounts in the list of accounts have been selected
#  2、"All" sub-filter is ACTIVE
#  3、"None" sub-filter is ACTIVE
  @S532-AC1-AT11
  Scenario: Check whether unread documents related to the account(s) that I have selected should be displayed
    Given I am viewing Accounts list filter
    And the "All" sub-filter is ACTIVE
    And the "None" sub-filter is ACTIVE
    When I tap "X" button to back to "Unread" Document list
    Then I should only see unread documents related to the account(s) that I have selected should be displayed

#  background：base on Step1
#  1、a part of accounts in the list of accounts have been selected
#  2、"All" sub-filter is ACTIVE
#  3、"None" sub-filter is ACTIVE
#  4、I come back to "Unread" Document list
  @S532-AC1-AT12
  @DependsOn('a_part_of_accounts_in_the_list_of_accounts_have_been_selected')
  Scenario: Check whether all document list related to the account(s) that I have selected should be displayed
    Given I am on the document list screen
    When I tap on the document component labelled "Unread"
    And I tap on the document "All" Filter
    Then I should only see all documents related to the account(s) that I have selected should be displayed

#  background：base on Step1
#  1、a part of accounts in the list of accounts have been selected
#  2、"All" sub-filter is ACTIVE
#  3、"None" sub-filter is ACTIVE
#  4、I come back to "Unread" Document list
  @S532-AC1-AT13
  @DependsOn('a_part_of_accounts_in_the_list_of_accounts_have_been_selected')
  Scenario: Check whether flagged document list related to the account(s) that I have selected should be displayed
    Given I am on the document list screen
    When I tap on the document component labelled "Unread"
    And I tap "Flagged" Filter
    Then I should only see flagged documents related to the account(s) that I have selected should be displayed

  @NotAutomatable
# cannot check the filter states， Check in AT9
#  Background: Step1
#  1、a part of accounts in the list of accounts have been selected
#  2、"All" sub-filter is ACTIVE
#  3、"None" sub-filter is ACTIVE
  @S532-AC1-AT14
  Scenario: Check whether flagged documents related to the account(s) that I have selected should be displayed
    Given I am viewing Accounts list filter
    And the "All" sub-filter is ACTIVE
    And the "None" sub-filter is ACTIVE
    When I tap "X" button to back to "Flagged" Document list
    Then I should only see flagged documents related to the account(s) that I have selected should be displayed

#  background：base on Step1
#  1、a part of accounts in the list of accounts have been selected
#  2、"All" sub-filter is ACTIVE
#  3、"None" sub-filter is ACTIVE
#  4、I come back to "Flagged" Document list
  @S532-AC1-AT15
  @DependsOn('a_part_of_accounts_in_the_list_of_accounts_have_been_selected')
  Scenario: Check whether all document related to the account(s) that I have selected should be displayed
    Given I am on the document list screen
    When I tap "Flagged" Filter
    And I tap on the document "All" Filter
    Then I should only see all documents related to the account(s) that I have selected should be displayed

#  background：base on Step1
#  1、a part of accounts in the list of accounts have been selected
#  2、"All" sub-filter is ACTIVE
#  3、"None" sub-filter is ACTIVE
#  4、I come back to "Flagged" Document list
  @S532-AC1-AT16
  @DependsOn('a_part_of_accounts_in_the_list_of_accounts_have_been_selected')
  Scenario: Check whether unread document list related to the account(s) that I have selected should be displayed
    Given I am on the document list screen
    When I tap "Flagged" Filter
    And I tap on the document component labelled "Unread"
    Then I should only see unread documents related to the account(s) that I have selected should be displayed

  @NotAutomatable
# cannot check the filter states，and displayed all document list
#  Scenario3:Re-select all accounts
  @S532-AC1-AT17
  Scenario: Check whether I can Re-select all accounts when I tap "All" filter adjacent to the Accounts list
    Given client is logged in
    And Client has one or more documents
    And one or more Accounts are NOT selected within the Accounts filter list
    When Client taps the "Filter" component
    And taps "All" filter adjacent to the Accounts list
    And close the filter
    Then all documents related to all of the accounts displayed should be visible in the document list
    And the "Filter" component should indicate that a filter has been applied
    And the filter applied should presist during that session only
    And the "None" filter adjacent to the account list within the main filter should be in an ACTIVE state
    And the filter applied should presist during that session only
    And the "All" filter adjacent to the account list within the main filter should be in an INACTIVE state


  @NotAutomatable
# cannot check the filter states
#  Scenario4:"All" accounts filter default status
  @S532-AC1-AT18
  Scenario: Check whether the "All" filter adjacent to the account list should be inactive by default
    Given I am Re-login the APP
    And I am viewing document screen
    When taps on "Filter" component
    And views the Accounts list
#  The the "All" filter adjacent to the account list should be inactive by default


  @NotAutomatable
# cannot check the filter states
#  Scenario5:"All" accounts filter active status
  @S532-AC1-AT19
  Scenario: Check whether the "All" filter adjacent to the account list should be tappable(active state)
    Given I am vieiwng document screen
    And one or more Accounts are not selected within the Accounts list filter
    When taps on "Filter" component
    And views the Accounts list
#  The the "All" filter adjacent to the account list should be tappable(active state)


  @NotAutomatable
# cannot check the filter states
#  Scenario6:"None" accounts filter default status
  @S532-AC1-AT20
  Scenario: Check whether the "None" filter adjacent to the account list should be active by default
    Given I am Re-login the APP
    And I am vieiwng document screen
    When taps on "Filter" component
    And views the Accounts list
#  The the "None" filter adjacent to the account list should be active by default


  @NotAutomatable
# cannot check the filter states
#  Scenario7:"None" accounts filter inactive status
  @S532-AC1-AT21
  Scenario: Check whether the "None" filter adjacent to the account list should be tappable(inactive state)
    Given I am viewing document screen
    And zero Accounts are selected within the Accounts list filter
    When taps on "Filter" component
    And views the Accounts list
#  The the "None" filter adjacent to the account list should be tappable(inactive state)

#  Scenario8:De-select all accounts
#  Background:
#  Step1：
#    Given client is logged in
#    And client has one or more documents
#    And one or more Accounts are selected within the Account filter list
#    When client taps the "Filter" component
#    And taps "None" filter adjacent to the Accounts list
#    And close the filter
#    Then no documents should be displayed
#    And the following message should be displayed instead of the documents list:
#  "There are no documents to display with these filters applied.Please contact your ... (TBC) for historic documents"
#    And the "Filter" component should indicate that a filter has been applied
  @NotAutomatable
# cannot check the filter states
  @S532-AC1-AT22
  Scenario: Check the no document tipMessage in "All" Document list and the session of "Filter" component and the status of "None" and "All" sub-filters
    When client re-opens documents screen within the same session
    Then the filter applied should persist during that session only
    And the "None" filter adjacent to the account list within the main filter should be in an INACTIVE state
    And the "All" filter adjacent to the account list within the main filter should be in an ACTIVE state

#  Background: base on Step1
#  1、De-select all accounts
#  2、"All" Document list 中不存在documents
  Scenario: no document displayed in ALL document list
    Given I login as type "document_account_num_more_than_1_less_than_6"
    When I tap on More Menu button
    And I tap on the "Documents" more menu tab
    And I tap on the document filter btn
    And I tap on the account "None" button
    And closes the filter by tapping "X"
    Then I should on the document list screen

  @S532-AC1-AT23
  @DependsOn('no_document_displayed_in_ALL_document_list')
  Scenario: Check the no document tipMessage in "All" Document list when "All" document list has no document to display
    Given I am on the document list screen
    When I tap on the document "All" Filter
    Then no documents should be displayed
    And the following message should be displayed instead of the documents list:
      | element name   | element value                                                            |
      | top message    | There are no documents to display with the filter applied.               |
      | bottom message | Please contact your relationship management team for historic documents. |
    And the "Filter" component should indicate that a filter has been "Filter applied"

  @S532-AC1-AT24
  @DependsOn('no_document_displayed_in_ALL_document_list')
  Scenario: Check the no document tipMessage in "Unread" Document list when "All" document list has no document to display
    Given I am on the document list screen
    When I tap on the document component labelled "Unread"
    Then no documents should be displayed
    And the following message should be displayed instead of the documents list:
      | element name   | element value                                                            |
      | top message    | There are no unread documents to display with the filter applied.        |
      | bottom message | Please contact your relationship management team for historic documents. |
    And the "Filter" component should indicate that a filter has been "Filter applied"


#  Background: base on Step1
#  1、De-select all accounts
#  2、"All" Document list 中不存在documents
  @S532-AC1-AT25
  @DependsOn('no_document_displayed_in_ALL_document_list')
  Scenario: Check the no document tipMessage in "Flagged" Document list when "All" document list has no document to display
    Given I am on the document list screen
    When I tap "Flagged" Filter
    Then no documents should be displayed
    And the following message should be displayed instead of the documents list:
      | element name   | element value                                                            |
      | top message    | There are no flagged documents to display with the filter applied.       |
      | bottom message | Please contact your relationship management team for historic documents. |

#  Scenario9:Client filters by account AND no documents displayed AND exits documents screen
  @S532-AC1-AT26
  Scenario: Check whether the Filter component will be default when there are no document in All document list and Filter Applied and I re_open All document list
    Given I login as type "document_has_account_filter_no_document"
    When I tap on More Menu button
    And I tap on the "Documents" more menu tab
    And I tap on the document filter btn
    And I Adjust the filter to leave only accounts with no corresponding documents
    And closes the filter by tapping "X"
    And I exits documents screen
    And I tap on the "Documents" more menu tab
    Then all documents available should be displayed
#    And "All" adjacent to "Unread" filter should be in-an ACTIVE state
#    And all accounts should be selected in the main "Filter"
#    And "All" filter adjacent to accounts list in main filter should be in an INACTIVE state
#    And "None" filter adjacent to accounts list in main filter should be in an ACTIVE state
    And the "Filter" component should indicate that a filter has been "Filter"

  @S532-AC1-AT27
  Scenario: Check whether the Filter component will be default when there are no document in Unread document list and Filter Applied and I re_open All document list
    Given I login as type "document_has_account_filter_no_document"
    When I tap on More Menu button
    And I tap on the "Documents" more menu tab
    And I tap on the document component labelled "Unread"
    And I tap on the document filter btn
    And I Adjust the filter to leave only accounts with no corresponding documents
    And closes the filter by tapping "X"
    And I exits documents screen
    And I tap on the "Documents" more menu tab
    Then all documents available should be displayed
#    And "All" adjacent to "Unread" filter should be in-an ACTIVE state
#    And all accounts should be selected in the main "Filter"
#    And "All" filter adjacent to accounts list in main filter should be in an INACTIVE state
#    And "None" filter adjacent to accounts list in main filter should be in an ACTIVE state
    And the "Filter" component should indicate that a filter has been "Filter"

  @S532-AC1-AT28
  Scenario: Check whether the Filter component will be default when there are no document in Flagged document list and Filter Applied and I re_open All document list
    Given I login as type "document_has_account_filter_no_document"
    When I tap on More Menu button
    And I tap on the "Documents" more menu tab
    And I tap "Flagged" Filter
    And I tap on the document filter btn
    And I Adjust the filter to leave only accounts with no corresponding documents
    And closes the filter by tapping "X"
    And I exits documents screen
    And I tap on the "Documents" more menu tab
    Then all documents available should be displayed
#    And "All" adjacent to "Unread" filter should be in-an ACTIVE state
#    And all accounts should be selected in the main "Filter"
#    And "All" filter adjacent to accounts list in main filter should be in an INACTIVE state
#    And "None" filter adjacent to accounts list in main filter should be in an ACTIVE state
    And the "Filter" component should indicate that a filter has been "Filter"

  @NotAutomatable
# cannot check the filter states
  @S532-AC1-AT29
  Scenario: Check whether the Filter component will be default when there are no document in Unread document list and Filter Applied and I re_open "Filter" component
    Given client is logged in
    And client is on Unread documents screen
    And NOT all account(s) are selected
    And NOT all categories are selected
    And no Unread documents are available for the account(s) and categories selected
    And it should be apparent that a filter has been applied to the main "Filter"
    When client taps on "Filter" component
    Then I should see all accounts should be selected in the main "Filter"
    And I should see all categories should be selected in the main "Filter"
    And "All" filter adjacent to accounts list in main filter should be in an INACTIVE state
    And "None" filter adjacent to accounts list in main filter should be in an ACTIVE state
    And "All" filter adjacent to categories list in main filter should be in an INACTIVE state
    And "None" filter adjacent to categories list in main filter should be in an ACTIVE state

    When I taps on "X" to exit the main filter
    Then it should not be apparent that a filter has been applied to the main "Filter"
    And the Unread documents are available for the account(s) and categories selected will be displayed

  @NotAutomatable
# cannot check the filter states
  @S532-AC1-AT30
  Scenario: Check whether the Filter component will be default when there are no document in Flagged document list and Filter Applied and I re_open "Filter" component
    Given client is logged in
    And client is on Flagged documents screen
    And NOT all account(s) are selected
    And NOT all categories are selected
    And no Flagged documents are available for the account(s) and categories selected
    And it should be apparent that a filter has been applied to the main "Filter"
    When client taps on "Filter" component
    Then I should see all accounts should be selected in the main "Filter"
    And I should see all categories should be selected in the main "Filter"
    And "All" filter adjacent to accounts list in main filter should be in an INACTIVE state
    And "None" filter adjacent to accounts list in main filter should be in an ACTIVE state
    And "All" filter adjacent to categories list in main filter should be in an INACTIVE state
    And "None" filter adjacent to categories list in main filter should be in an ACTIVE state

    When I taps on "X" to exit the main filter
    Then it should not be apparent that a filter has been applied to the main "Filter"
    And the Flagged documents are available for the account(s) and categories selected will be displayed

  @NotAutomatable
# cannot check the filter states
  @S532-AC1-AT31
  Scenario: Check whether the Filter component will be default when there are no document in All document list and Filter Applied and I re_open "Filter" component
    Given client is logged in
    And client is on All documents screen
    And NOT all account(s) are selected
    And NOT all categories are selected
    And no All documents are available for the account(s) and categories selected
    And it should be apparent that a filter has been applied to the main "Filter"
    When client taps on "Filter" component
    Then I should see all accounts should be selected in the main "Filter"
    And I should see all categories should be selected in the main "Filter"
    And "All" filter adjacent to accounts list in main filter should be in an INACTIVE state
    And "None" filter adjacent to accounts list in main filter should be in an ACTIVE state
    And "All" filter adjacent to categories list in main filter should be in an INACTIVE state
    And "None" filter adjacent to categories list in main filter should be in an ACTIVE state

    When I taps on "X" to exit the main filter
    Then it should not be apparent that a filter has been applied to the main "Filter"
    And the All documents are available for the account(s) and categories selected will be displayed

  @NotAutomatable
  @S532-AC1-AT32
  Scenario: Check whether the Unread count and Flagged count will be changed when I change the Accounts list and Categories list and view the All document list
    Given I am vieiwng All document list
    And it should be apparent that a filter has been applied to the main "Filter"
    When I tap on "Filter" component
    And change the Accounts list selected
    And change the Categories list selected
    And tap on "X" to exit the main filter
    Then I should see the All document list will displayed followed by the Accounts list and Categories list that I have selected
    And the Unread count will be changed followed by the Accounts list and Categories list that I have selected
    And the Flagged count will be changed followed by the Accounts list and Categories list that I have selected

  @NotAutomatable
  @S532-AC1-AT33
  Scenario: Check whether the Unread count and Flagged count will be changed when I change the Accounts list and Categories list and view the Unread document list
    Given I am vieiwng Unread document list
    And it should be apparent that a filter has been applied to the main "Filter"
    When I tap on "Filter" component
    And change the Accounts list selected
    And change the Categories list selected
    And tap on "X" to exit the main filter
    Then I should see the Unread document list will displayed followed by the Accounts list and Categories list that I have selected
    And the Unread count will be changed followed by the Accounts list and Categories list that I have selected
    And the Flagged count will be changed followed by the Accounts list and Categories list that I have selected

  @NotAutomatable
  @S532-AC1-AT34
  Scenario: Check whether the Unread count and Flagged count will be changed when I change the Accounts list and Categories list and view the All document list
    Given I am vieiwng Flagged document list
    And it should be apparent that a filter has been applied to the main "Filter"
    When I tap on "Filter" component
    And change the Accounts list selected
    And change the Categories list selected
    And tap on "X" to exit the main filter
    Then I should see the Flagged document list will displayed followed by the Accounts list and Categories list that I have selected
    And the Unread count will be changed followed by the Accounts list and Categories list that I have selected
    And the Flagged count will be changed followed by the Accounts list and Categories list that I have selected

    # Tested in AT23-25
##  Scenario10:No documents to display
#  @S532-AC1-AT35
#  Scenario: Check the no document tipMessage in "All"  document list when I applied filter
##  Step1：
#    Given client is logged in
#    And the accounts that are selected within the main "Filter" do not have any documents associsted with them in the EDMS
#    When client exits the "Filter" menu by tapping "X"
#    Then client should see the following message displayed instead of a documents list:
##  "There are no documents to displayed with the filter applied.Please contact you ...(TBC) for historic documents"
#    And the "Filter" component should indicate that a filter has been applied
#
#  @S532-AC1-AT36
#  Scenario: Check the no document tipMessage in "Unread"  document list when I applied filter
##  Background：base on Step1
##  1、the accounts that are selected within the main "Filter" do not have any docuemnts associsted with them in the EDMS
#
#    Given I am vieiwng the "All" Document list
#    And I can see the following message displayed instead of a documents list:
##  "There are no documents to displayed with the filter applied.Please contact you ...(TBC) for historic documents"
#    When I tap "Unread" filter
#    Then I should see following message displayed instead of a documents list:
##  "There are no documents to displayed with the filter applied.Please contact you ...(TBC) for historic documents"
#
#  @S532-AC1-AT37
#  Scenario: Check the no document tipMessage in "Flagged"  document list when I applied filter
##  Background：base on Step1
##  1、the accounts that are selected within the main "Filter" do not have any docuemnts associsted with them in the EDMS
#
#    Given I am viewing the "All" Document list
#    And I can see the following message displayed instead of a documents list:
##  "There are no documents to displayed with the filter applied.Please contact you ...(TBC) for historic documents"
#    When I tap "Flagged" filter
#    Then I should see following message displayed instead of a documents list:
##  "There are no documents to displayed with the filter applied.Please contact you ...(TBC) for historic documents"

#  Scenario11:No accounts to display
  @S532-AC1-AT38
  Scenario: Check the no accounts tipMessage in the Accounts list
    Given I login as type "document_no_has_account_filter"
    When I tap on More Menu button
    And I tap on the "Documents" more menu tab
    And I tap on the document filter btn
    Then I should see the following message instead of an accounts list
      | element name | element value |
      | tip message  | No accounts   |

#  Scenario12:Client only has 1 account
  @S532-AC1-AT39
  Scenario: Check whether the only one account can not be able to de-select the account in the accounts list and selected default when client only has 1 account
    Given I login as type "document_account_num_more_only_1"
    When I tap on More Menu button
    And I tap on the "Documents" more menu tab
    And I tap on the document filter btn
    Then "All" and "None" sub-filters should be hidden adjacent to the Account header
#    And the Account listed should be selected
#    And client should NOT be able to de-select the account

#  Scenario13:Client only has <= 5 accounts
  @S532-AC1-AT40
  Scenario: Check whether the Accounts list section expanded by default when client only has <= 5 accounts
    Given I login as type "document_account_num_more_than_1_less_than_6"
    When I tap on More Menu button
    And I tap on the "Documents" more menu tab
    And I tap on the document filter btn
    Then I should see Accounts list is expand
    And I should see Account name value
    And I should see the list of accounts has a header "Account"
#    And I should see all accounts are selected by default
#    And I should see the "All" sub-filter is Inactive
#    And the "None" sub-filter is active

  Scenario: Login to a user with five document accounts
    Given I login as type "document_account_num_more_than_5"
    When I tap on More Menu button
    And I tap on the "Documents" more menu tab
    And I tap on the document filter btn
    Then I should on the document filter screen

#  Scenario14:Client only has > 5 accounts
  @S532-AC1-AT41
  @DependsOn('Login_to_a_user_with_five_document_accounts')
  Scenario: Check whether the Accounts list section collapse by default when client only has > 5 accounts
    Given I am on the document filter screen
    Then I should see documents Accounts list is collapse

  @S532-AC1-AT42
  @DependsOn('Login_to_a_user_with_five_document_accounts')
  Scenario: Check whether the Account list will be display account name and header "Account"
    Given I am on the document filter screen
    When I expand document Accounts filter list
    Then I should see Account name value
    And I should see the list of accounts has a header "Account"
#    And I should see all accounts are selected by default

#  Scenario15:Expand Accounts section
  @S532-AC1-AT43
  @DependsOn('Login_to_a_user_with_five_document_accounts')
  Scenario: Check whether the Accounts list section will be expanded when I tap on chervon facing down adjacent to Accounts header
    Given I am on the document filter screen
    When I expand document Accounts filter list
    Then the Accounts section should expand to show all of the clients accounts

#  Scenario16:Collapse Accounts section
  @S532-AC1-AT44
  @DependsOn('Login_to_a_user_with_five_document_accounts')
  Scenario: Check whether the Accounts list section will be collapsed when I tap on chervon facing up adjacent to Accounts header
    Given I am on the document filter screen
    When I expand document Accounts filter list
    And I collapse document Accounts filter list
    Then the Accounts section should collapse to show all of the clients accounts

  @NotAutomatable
# cannot check the filter states
#  Scenario17:选完filter之后，当用户退出登录，再重新登录的时候，不会记住filter选中的那些条件
  @S532-AC1-AT45
  Scenario: Check whether the "Filter" component will not keep previous record that I have slected the Accounts list and Gategories list before I log out the app
#  Background:
#    Given I am vieiwng Document screen
#    When I tap "Filter" component
#    And I tap on one ore more accounts in the list of accounts
#    And I tap "X" button to exit accounts list screen
#    And I log out the app
    Given I am Re-login the APP
    And I am viewing document screen
    When I tap "Filter" component
    Then I should see all account list will be selected default
    And it will not keep previous record that I have slected the Accounts list and Gategories list before I log out the app
    And it should not be apparent that a filter has been applied to the main "Filter"

  @NotAutomatable
# cannot check the filter states
  @S532-AC1-AT46
  Scenario: Check whether the "Filter" component will not keep previous record that I have slected the Accounts list and Gategories list when I back to More menu screen and  do not log out the app
#  Background:
#    Given I am vieiwng Docuemnts list screen
#    When I tap "Filter" component
#    And I tap on one ore more accounts in the list of accounts
#    And I tap on one ore more gategories in the list of gategories
#    And I tap "X" button to exit accounts/gategories list screen
#    And back to More menu screen
#    And I do not log out the app
    Given I am vieiwng More menu screen
    When I tap "Document"
    And I tap "Filter" component
    Then I should see it will keep previous record that I have slected the Accounts list and Gategories list before I log out the app
    And the "Filter" component should indicate that a filter has been applied
