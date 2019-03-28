@HK @SG @UK
@Epic_GPBM-385(global_App_Rules)
@Story_GPBM-1043 @Sprint3_iOS

Feature: List lazy loading

  As a client I want to see the individual holdings that make up my exposure to each geographical region within each Account,
  so that I know which holdings to review in order to change my regional exposure as desired

  # 以下情况是item<15的情况

  # Overview---Account list

#  @S79-AC1-AT1
#  Scenario: Check the lazy loading of Account list at Overview Level when list contains > 15 items
#    Given I am viewing the Account list at Overview Level
#    When I reach the 15th item within the Account list at Overview Level
#    And I continue to load the list by swipe up the Account list at Overview Level
#    Then I will see the next 15 list items are displayed below
#
#  @S79-AC1-AT2
#  Scenario: Check whether the Account list can keep previously loaded when I go back to Account list at Overview Level from Account Level
#    Given I am viewing the Account list at Overview Level
#    When I swipe up to reaches the 15th item within Account list at Overview Level
#    And I continue to lazy load next 15 item by swiping up the Account list at Overview Level
#    And I tap the Nth (N>15) item within Account list at Overview Level
#    And I go back to the Overview Level
#    Then I should see the Nth item and the Account list at Overview Level previously loaded (16th-30th)
#
#    # Overview---Asset Class list
#  @S79-AC1-AT3
#  Scenario: Check the lazy loading of Asset Class list at Overview Level when list contains > 15 items
#    Given I am viewing the Asset Class list at Overview Level
#    When I reach the 15th item within the Asset Class list at Overview Level
#    And I continue to load the list by swipe up the Asset Class list at Overview Level
#    Then I will see the next 15 list items are displayed below
#
#  @S79-AC1-AT4
#  Scenario: Check whether the Asset Class list can keep previously loaded when I go back to Asset Class list at Overview Level from Asset Class list Holding page
#    Given I am viewing the Asset Class list at Allocation Overview
#    When I swipe up to reaches the 15th item within Asset Class list at Allocation Overview
#    And I continue to lazy load next 15 item by swiping up the Asset Class list at Allocation Overview
#    And I taps the Nth (N>15) item within Asset Class list at Allocation Overview
#    And I go back to the Allocation Overview
#    Then I should see the Nth item and the Asset Class at Allocation Overview list previously loaded (16th-30th)
#
#    # Overview---Sub Asset Class list
#  @S79-AC1-AT5
#  Scenario: Check the lazy loading of Sub Asset Class list at Overview Level when list contains > 15 items
#    Given I am viewing the Sub Asset Class list at Overview Level
#    When I reach the 15th item within the Sub Asset Class list at Overview Level
#    And I continue to load the list by swipe up the Sub Asset Class list at Overview Level
#    Then I will see the next 15 list items are displayed below
#
#  @S79-AC1-AT6
#  Scenario: Check whether the Sub-Asset Class list can keep previously loaded when I go back to Sub-Asset Class list at Overview Level from Sub-Asset Class list Holding page
#    Given I am viewing the Sub-Asset Class list at Allocation Overview
#    When I swipe up to reach the 15th item within Sub-Asset Class list at Allocation Overview
#    And I continue to lazy load next 15 item by swiping up the Sub-Asset Class list at Allocation Overview
#    And I taps the Nth (N>15) item within Sub-Asset Class list at Allocation Overview
#    And I go back to the Allocation Overview
#    Then I should see the Nth item and the Sub-Asset Class list at Allocation Overview previously loaded (16th-30th)
#
#    # Overview---Asset Region list
#  @S79-AC1-AT7
#  Scenario: Check the lazy loading of Asset Region list at Overview Level when list contains > 15 items
#    Given I am viewing the Asset Region list at Overview Level
#    When I reach the 15th item within the Asset Region list at Overview Level
#    And I continue to load the list by swipe up the Asset Region list at Overview Level
#    Then I will see the next 15 list items are displayed below
#
#
#  @S79-AC1-AT8
#  Scenario: Check whether the Asset Region list can keep previously loaded when I go back to Asset Region list at Overview Level from Asset Region list Holding page
#    Given I am viewing the Asset Region list at Allocation Overview
#    When I swipe up to reaches the 15th item within Asset Region list at Allocation Overview
#    And I continue to lazy load next 15 item by swiping up the Asset Region list
#    And I tap the Nth (N>15) item within Asset Region list at Allocation Overview
#    And I go back to the Allocation Overview
#    Then I should see the Nth item and the Asset Region list at Allocation Overview previously loaded (16th-30th)
#
#    # Account---Portfolio list
#  @S79-AC1-AT9
#  Scenario: Check the lazy loading of Portfolio list at Account Level when list contains > 15 items
#    Given I am viewing the Portfolio list at Account Level
#    When I reach the 15th item within the Portfolio list at Account Level
#    And I continue to load the list by swipe up the Portfolio list at Account Level
#    Then I will see the next 15 list items are displayed below
#
#  @S79-AC1-AT10
#  Scenario: Check whether the Portfolio list can be refreshed when reopen the Portfolio list at Account Level
#    Given I am viewing the Account list at Overview Level
#    And I tap the Nth item within Account list at Overview Level
#    When I swipe up to reaches the 15th item within Portfolio list at Account Level
#    And I continue to lazy load next 15 item by swiping up the Portfolio list at Account Level
#    And I come back to the Overview Level
#    And I tap the Nth item within Account list at Overview Level again
#    Then client should see the Portfolio list at Account Level display the 1st to 15th item default
#
#  @S79-AC1-AT11
#  Scenario: Check whether the Portfolio list can keep previously loaded when I go back to Holding list at Account Level from Portfolio Level
#    Given I am viewing the Portfolio list at Account Level
#    When I swipe up to reaches the 15th item within Portfolio list at Account Level
#    And I continue to lazy load next 15 item by swiping up the Portfolio list at Account Level
#    And I tap the Nth (N>15) item within Portfolio list at Account Level
#    And I go back to the Account Level
#    Then I should see the Nth item and the Portfolio list at Account Level previously loaded (16th-30th)
#
#    # Account---Asset Class list
#
#  @S79-AC1-AT12
#  Scenario: Check the lazy loading of Asset Class list at Account Level when list contains > 15 items
#    Given I am viewing the Asset Class list at Account Level
#    When I reach the 15th item within the Asset Class list at Account Level
#    And I continue to load the list by swipe up the Asset Class list at Account Level
#    Then I will see the next 15 list items are displayed below
#
#  @S79-AC1-AT13
#  Scenario: Check whether the Asset Class list can be refreshed when reopen the Asset Class list at Account Level
#    Given I am viewing the Account list at Overview Level
#    And I tap the Nth item within Account list at Overview Level
#    And I tap the Allocation Toggle ON
#    When I swipe up to reaches the 15th item within Asset Class list at Allocation Account
#    And I continue to lazy load next 15 item by swiping up the Asset Class list at Allocation Account
#    And I come back to the Overview Level
#    And I tap the Nth item within Account list at Overview Level again
#    And I tap the Allocation Toggle ON again
#    Then client should see the Asset Class list at Account Level display the 1st to 15th item default
#
#  @S79-AC1-AT14
#
#  Scenario: Check whether the Asset Class list can keep previously loaded when I go back to Asset Class list at Account Level from Asset Class list Holding page
#    Given I am viewing the Asset Class list at Account Level
#    When I swipe up to reaches the 15th item within Asset Class list at Account Level
#    And I continue to lazy load next 15 item by swiping up the Asset Class list at Account Level
#    And I tap the Nth (N>15) item within Asset Class list at Account Level
#    And I go back to the Account Level
#    Then I should see the Nth item and the Asset Class list at Account Level previously loaded (16th-30th)
#
#    # Account---Sub-Asset Class list
#
#  @S79-AC1-AT15
#  Scenario: Check the lazy loading of Sub-Asset Class list at Account Level when list contains > 15 items
#    Given I am viewing the Sub Asset Class list at Account Level
#    When I reach the 15th item within the Sub Asset Class list at Account Level
#    And I continue to load the list by swipe up the Sub Asset Class list at Account Level
#    Then I will see the next 15 list items are displayed below
#
#  @S79-AC1-AT16
#  Scenario: Check whether the Sub-Asset Class list can be refreshed when reopen the Sub-Asset Region list at Account Level
#    Given I am viewing the Account list at Overview Level
#    And I tap the Nth item within Account list at Overview Level
#    And I tap the Allocation Toggle ON
#    And I tap the Show Sub-Asset Class Toggle ON
#    When I swipe up to reaches the 15th item within Sub-Asset Class list at Account Level
#    And I continue to lazy load next 15 item by swiping up the Asset Class list at Account Level
#    And I come back to the Overview Level
#    And I tap the Nth item within Account list at Overview Level again
#    And I tap the Allocation Toggle ON again
#    And I tap the Show Sub-Asset Class Toggle ON again
#    Then I should see the Sub-Asset Class list at Account Level display the 1st to 15th item default
#
#  @S79-AC1-AT17
#  Scenario: Check whether the Sub-Asset Class list can keep previously loaded when I go back to Sub-Asset Class list at Account Level from Asset Region list Holding page
#    Given I am viewing the Sub-Asset Class list at Account Level
#    When I swipe up to reaches the 15th item within Sub-Asset Class list at Account Level
#    And I continue to lazy load next 15 item by swiping up the Sub-Asset Class list at Account Level
#    And I tap the Nth (N>15) item within Sub-Asset Class list at Account Level
#    And I go back to the Account Level
#    Then I should see the Nth item and the Sub-Asset Class list at Account Level previously loaded (16th-30th)
#
#    # Account---Asset Region list
#
#  @S79-AC1-AT18
#  Scenario: Check the lazy loading of Asset Region list at Account Level when list contains > 15 items
#    Given I am viewing the Asset Region list at Account Level
#    When I reach the 15th item within the Asset Region list at Account Level
#    And I continue to load the list by swipe up the Asset Region list at Account Level
#    Then I will see the next 15 list items are displayed below
#
#  @S79-AC1-AT19
#  Scenario: Check whether the Asset Region list can be refreshed when reopen the Asset Region list at Account Level
#    Given I am viewing the Account list at Overview Level
#    And I tap the Nth item within Account list at Overview Level
#    And I tap the Allocation Toggle ON
#    And I tap the Region tab at Account Level
#    When I swipe up to reaches the 15th item within Asset Region list at Account Level
#    And I continue to lazy load next 15 item by swiping up the Asset Region list
#    And I come back to the Overview Level
#    And I tap the Nth item within Account list at Overview Level again
#    And I tap the Allocation Toggle ON again
#    Then I should see the Asset Region list at Account Level display the 1st to 15th item default
#
#  @S79-AC1-AT20
#  Scenario: Check whether the Asset Region list can keep previously loaded when I go back to Asset Region list at Account Level from Asset Region list Holding page
#    Given I am viewing the Asset Region list at Account Level
#    When I swipe up to reaches the 15th item within Asset Region list at Account Level
#    And I continue to lazy load next 15 item by swiping up the Asset Region list at Account Level
#    And I tap the Nth (N>15) item within Region list at Account Level
#    And I go back to the Account Level
#    Then I should see the Nth item and the Asset Region list at Account Level previously loaded (16th-30th)






    # Portfolio---Holding list
    # app no has holding data
  #First item of Portfolios list: has >= 30 holding item

#  @S79-AC1-AT21
#  Scenario: Check the lazy loading of Holding list at Portfolio Level when list contains > 15 items
#    Given I login as User
#      | element name | element value |
#      | Name         | userE         |
#    And I tap first item of Accounts list
#    And I tap first item of Portfolios list
#    When I reach the 15th item within the Holding list at Portfolio Level
#    And I continue to load the list by swipe up the Holding list at Portfolio Level
#    Then I will see the next 15 holding list items are displayed below
#
#
#  @S79-AC1-AT23
#  @DependsOn('Check_the_lazy_loading_of_Holding_list_at_Portfolio_Level_when_list_contains_>_15_items')
#  Scenario: Check whether the Holding list can keep previously loaded when I go back to Holding list at Portfolio Level from Holding list detail page
#    Given I am viewing the Holding list are thirty item at Portfolio Level
#    When I tap the 20th item within Holding list at Portfolio Level
#    And I go back to the Portfolio Level
#    Then I should see the 20th item and the Holding list at Portfolio Level previously loaded (16th-30th)
#
#  @S79-AC1-AT22
#  Scenario: Check whether the Holding list can be refreshed when reopen the Holding list at Portfolio Level
#    Given I login as User
#      | element name | element value |
#      | Name         | userE         |
#    And I tap first item of Accounts list
#    And I tap first item of Portfolios list
#    When I reach the 15th item within the Holding list at Portfolio Level
#    And I continue to load the list by swipe up the Holding list at Portfolio Level
#    And I come back to the Account Level
#    And I tap first item of Portfolios list again
#    Then I should see the Holding list display the 1st to 15th item default


    # Portfolio---Asset Class list

#  @S79-AC1-AT24
#  Scenario: Check the lazy loading of Asset Class list at Portfolio Level when list contains > 15 items
#    Given I am viewing the Asset Class list at Portfolio Level
#    When I reach the 15th item within the Asset Class list at Portfolio Level
#    And I continue to load the list by swipe up the Asset Class list at Portfolio Level
#    Then I will see the next 15 list items are displayed below
#
#
#  @S79-AC1-AT25
#  Scenario: Check whether the Asset Class list can be refreshed when reopen the Asset Class list at Portfolio Level
#    Given I am viewing the Portfolio list at Account Level
#    And I tap the Nth item within Portfolio list at Account Level
#    And I taps the Allocation Toggle ON
#    When I swipe up to reaches the 15th item within Asset Class list at Allocation Portfolio
#    And I continue to lazy load next 15 item by swiping up the Asset Class list at Allocation Portfolio
#    And I come back to the Account Level
#    And I tap the Nth item within Portfolio list at Account Level again
#    And I tap the Allocation Toggle ON again
#    Then I should see the Asset Class list display the 1st to 15th item default
#
#  @S79-AC1-AT26
#  Scenario: Check whether the Asset Class list can keep previously loaded when I go back to Asset Class list at Portfolio Level from Asset Class list Holding page
#    Given I am viewing the Asset Class list at Portfolio Level
#    When I swipe up to reaches the 15th item within Asset Class list at Portfolio Level
#    And I continue to lazy load next 15 item by swiping up the Asset Class list at Portfolio Level
#    And I tap the Nth (N>15) item within Asset Class list at Portfolio Level
#    And I go back to the Portfolio Level
#    Then I should see the Nth item and the Asset Class list at Portfolio Level previously loaded (16th-30th)
#
#    # Portfolio---Sub-Asset Class list
#
#  @S79-AC1-AT27
#  Scenario: Check the lazy loading of Sub-Asset Class list at Portfolio Level when list contains > 15 items
#    Given I am viewing the Sub Asset Class list at Portfolio Level
#    When I reach the 15th item within the Sub Asset Class list at Portfolio Level
#    And I continue to load the list by swipe up the Sub Asset Class list at Portfolio Level
#    Then I will see the next 15 list items are displayed below
#
#
#  @S79-AC1-AT28
#  Scenario: Check whether the Sub-Asset list can be refreshed when reopen the Sub-Asset list at Portfolio Level
#    Given I am viewing the Portfolio list at Account Level
#    And I tap the Nth item within Portfolio list at Account Level
#    And I tap the Allocation Toggle ON
#    And I tap the Show Sub-Asset Class Toggle ON
#    When I swipe up to reaches the 15th item within Sub-Asset Class list at Portfolio Level
#    And I continue to lazy load next 15 item by swiping up the Sub-Asset Class list at Portfolio Level
#    And I come back to the Account Level
#    And I tap the Nth item within Portfolio list at Account Level again
#    And I tap the Allocation Toggle ON again
#    And I tap the Show Sub-Asset Class Toggle ON again
#    Then I should see the Sub-Asset Class list at Portfolio Level display the 1st to 15th item default
#
#  @S79-AC1-AT29
#  Scenario: Check whether the Sub-Asset list can keep previously loaded when I go back to Sub-Asset list at Portfolio Level from Sub-Asset list Holding page
#    Given I am viewing the Sub-Asset Class list at Portfolio Level
#    When I swipe up to reaches the 15th item within Sub-Asset Class list at Portfolio Level
#    And I continue to lazy load next 15 item by swiping up the Sub-Asset Class list at Portfolio Level
#    And I tap the Nth (N>15) item within Sub-Asset Class list at Portfolio Level
#    And I go back to the Portfolio Level
#    Then I should see the Nth item and the Sub-Asset Class list previously loaded (16th-30th)
#
#    # Portfolio---Asset Region list
#
#  @S79-AC1-AT30
#  Scenario: Check the lazy loading of Asset Region list at Portfolio Level when list contains > 15 items
#    Given I am viewing the Asset Region list at Portfolio Level
#    When I reach the 15th item within the Asset Region list at Portfolio Level
#    And I continue to load the list by swipe up the Asset Region list at Portfolio Level
#    Then I will see the next 15 list items are displayed below
#
#
#  @S79-AC1-AT31
#  Scenario: Check whether the Asset Region list can be refreshed when reopen the Asset Region list at Portfolio Level
#    Given I am viewing the Portfolio list at Account Level
#    And I tap the Nth item within Portfolio list at Account Level
#    And I tap the Allocation Toggle ON
#    And I tap the Region tab at Portfolio Level
#    When I swipe up to reaches the 15th item within Asset Region list at Portfolio Level
#    And I continue to lazy load next 15 item by swiping up the Asset Region list at Portfolio Level
#    And I come back to the Account Level
#    And I tap the Nth item within Portfolio list at Account Level again
#    And I tap the Allocation Toggle ON again
#    Then I should see the Asset Region list at Portfolio Level display the 1st to 15th item default
#
#  @S79-AC1-AT32
#  Scenario: Check whether the Asset Region list can keep previously loaded when I go back to Asset Region list at Portfolio Level from Asset Region list Holding page
#    Given I am viewing the Asset Region list at Portfolio Level
#    When I swipe up to reaches the 15th item within Asset Region list at Portfolio Level
#    And I continue to lazy load next 15 item by swiping up the Asset Region list at Portfolio Level
#    And I tap the Nth (N>15) item within Asset Region list at Portfolio Level
#    And I go back to the Portfolio Level
#    Then I should see the Nth item and the Asset Region list at Portfolio Level previously loaded (16th-30th)
#
#
#
#
#
#   # 以下情况是item<15的情况
#
#  @S79-AC1-AT33
#  Scenario: Check the lazy loading of Account list at Overview Level when list contains <= 15 items
#    Given I am viewing the Account list at Overview Level
#    When I reach the last item within the Account list at Overview Level
#    And I continue to load the list by swipe up the Account list at Overview Level
#    Then I will see there are no more items will be displayed below
#
#
#  @S79-AC1-AT34
#  Scenario: Check the lazy loading of Asset Class list at Overview Level when list contains <= 15 items
#    Given I am viewing the Asset Class list at Overview Level
#    When I reach the last item within the Asset Class list at Overview Level
#    And I continue to load the list by swipe up the Asset Class list at Overview Level
#    Then I will see there are no more items will be displayed below
#
#
#  @S79-AC1-AT35
#  Scenario: Check the lazy loading of Sub Asset Class list at Overview Level when list contains <= 15 items
#    Given I am viewing the Sub Asset Class list at Overview Level
#    When I reach the last item within the Sub Asset Class list at Overview Level
#    And I continue to load the list by swipe up the Sub Asset Class list at Overview Level
#    Then I will see there are no more items will be displayed below
#
#
#  @S79-AC1-AT36
#  Scenario: Check the lazy loading of Asset Currency list at Overview Level when list contains <= 15 items
#    Given I am viewing the Asset Currency list at Overview Level
#    When I reach the last item within the Asset Currency list at Overview Level
#    And I continue to load the list by swipe up the Asset Currency list at Overview Level
#    Then I will see there are no more items will be displayed below
#
#
#  @S79-AC1-AT37
#  Scenario: Check the lazy loading of Asset Region list at Overview Level when list contains <= 15 items
#    Given I am viewing the Asset Region list at Overview Level
#    When I reach the last item within the Asset Region list at Overview Level
#    And I continue to load the list by swipe up the Asset Region list at Overview Level
#    Then I will see there are no more items will be displayed below
#
#
#  @S79-AC1-AT38
#  Scenario: Check the lazy loading of Portfolio list at Account Level when list contains <= 15 items
#    Given I am viewing the Portfolio list at Account Level
#    When I reach the last item within the Portfolio list at Account Level
#    And I continue to load the list by swipe up the Portfolio list at Account Level
#    Then I will see there are no more items will be displayed below
#
#
#  @S79-AC1-AT39
#  Scenario: Check the lazy loading of Asset Class list at Account Level when list contains <= 15 items
#    Given I am viewing the Asset Class list at Account Level
#    When I reach the last item within the Asset Class list at Account Level
#    And I continue to load the list by swipe up the Asset Class list at Account Level
#    Then I will see there are no more items will be displayed below
#
#
#  @S79-AC1-AT40
#  Scenario: Check the lazy loading of Sub Asset Class list at Account Level when list contains <= 15 items
#    Given I am viewing the Sub Asset Class list at Account Level
#    When I reach the last item within the Sub Asset Class list at Account Level
#    And I continue to load the list by swipe up the Sub Asset Currency list at Account Level
#    Then I will see there are no more items will be displayed below
#
#
#  @S79-AC1-AT41
#  Scenario: Check the lazy loading of Asset Currency list at Account Level when list contains <= 15 items
#    Given I am viewing the Asset Currency list at Account Level
#    When I reach the last item within the Asset Currency list at Account Level
#    And I continue to load the list by swipe up the Asset Currency list at Account Level
#    Then I will see there are no more items will be displayed below
#
#
#  @S79-AC1-AT42
#  Scenario: Check the lazy loading of Asset Region list at Account Level when list contains <= 15 items
#    Given I am viewing the Asset Region list at Account Level
#    When I reach the last item within the Asset Region list at Account Level
#    And I continue to load the list by swipe up the Asset Region list at Account Level
#    Then I will see there are no more items will be displayed below
#
#
#  @S79-AC1-AT43
#  Scenario: Check the lazy loading of Holding list at Portfolio Level when list contains <= 15 items
#    Given I am viewing the Holding list at Portfolio Level
#    When I reach the last item within the Holding list at Portfolio Level
#    And I continue to load the list by swipe up the Holding list at Portfolio Level
#    Then I will see there are no more items will be displayed below
#
#
#  @S79-AC1-AT44
#  Scenario: Check the lazy loading of Asset Class list at Portfolio Level when list contains <= 15 items
#    Given I am viewing the Asset Class list at Portfolio Level
#    When I reach the last item within the Asset Class list at Portfolio Level
#    And I continue to load the list by swipe up the Asset Class list at Portfolio Level
#    Then I will see there are no more items will be displayed below
#
#
#  @S79-AC1-AT45
#  Scenario: Check the lazy loading of Sub Asset Class list at Portfolio Level when list contains <= 15 items
#    Given I am viewing the Sub Asset Class list at Portfolio Level
#    When I reach the last item within the Sub Asset Class list at Portfolio Level
#    And I continue to load the list by swipe up the Sub Asset Class list at Portfolio Level
#    Then I will see there are no more items will be displayed below
#
#
#  @S79-AC1-AT46
#  Scenario: Check the lazy loading of Asset Currency list at Portfolio Level when list contains <= 15 items
#    Given I am viewing the Asset Currency list at Portfolio Level
#    When I reach the last item within the Asset Currency list at Portfolio Level
#    And I continue to load the list by swipe up the Asset Currency list at Portfolio Level
#    Then I will see there are no more items will be displayed below
#
#
#  @S79-AC1-AT47
#  Scenario: Check the lazy loading of Asset Region list at Portfolio Level when list contains <= 15 items
#    Given I am viewing the Asset Region list at Portfolio Level
#    When I reach the last item within the Asset Region list at Portfolio Level
#    And I continue to load the list by swipe up the Asset Region list at Portfolio Level
#    Then I will see there are no more items will be displayed below


  # Transaction  list item >15 items
  # (transaction list >= 30)
  @S79-AC1-AT48
  Scenario: Check the lazy loading of Transaction list at Portfolio Level when list contains > 15 items
    Given I login as User
      | element name | element value |
      | Name         | userE         |
    When I tap first item of Accounts list
    And I tap first item of Portfolios list
    And I tap the Transactions button
    And I reach the 15th item within the Transaction list at Portfolio Level
    And I continue to load the list by swipe up the Transaction list at Portfolio Level
    Then I will see the next 15 transaction list items are displayed below

  @S79-AC1-AT49
  @DependsOn('Check_the_lazy_loading_of_Transaction_list_at_Portfolio_Level_when_list_contains_>_15_items')
  Scenario: Check whether the Transaction list can be refreshed when reopen the Transaction list at Portfolio Level
    Given I am viewing the Transaction list has thirty item at Portfolio Level
    When I come back to the Account Level
    And I tap first item of Portfolios list again
    And I tap the Transactions button
    Then I should see the Transaction list at Portfolio Level display the 1st to 15th item default

  @S79-AC1-AT50
  Scenario: Check whether the Transaction list can keep previously loaded when I go back to Transaction list at Portfolio Level from Contingent liability list detail
    Given I login as User
      | element name | element value |
      | Name         | userE         |
    When I tap first item of Accounts list
    And I tap first item of Portfolios list
    And I tap the Transactions button
    And I reach the 15th item within the Transaction list at Portfolio Level
    And I continue to load the list by swipe up the Transaction list at Portfolio Level
    And I tap on portfolio "Holdings" tab
    And I tap on the Contingent Liabilities tab
    And I go back to the Portfolio Level
    And I tap the Transactions button
    Then I should see the Transaction list previously loaded (16th-30th)




# Contingent liabilities list item >15 items
  # (Contingent liabilities list >= 30)
#  @S79-AC1-AT51
#  Scenario: Check the lazy loading of Contingent liabilities list when list contains > 15 items
#    Given I login as User
#      | element name | element value |
#      | Name         | userE         |
#    When I tap first item of Accounts list
#    And I tap first item of Portfolios list
#    And I tap on the Contingent Liabilities tab
#    And I reach the 15th item within the Contingent liabilities list
#    And I continue to load the list by swipe up the Contingent liabilities list
#    Then I will see the next 15 Contingent liabilities items are displayed below
#
#  @S79-AC1-AT52
#  @DependsOn('Check_the_lazy_loading_of_Contingent_liabilities_list_when_list_contains_>_15_items')
#  Scenario: Check whether the Contingent liability list can be refreshed when reopen the Contingent liability list at Portfolio Level
#    Given I am viewing the Contingent liabilities list has thirty item
#    When I come back to the Portfolio Level
#    And I tap the Contingent liability bar again
#    Then I should see the Contingent liability list display the 1st to 15th item default
#
#  @S79-AC1-AT53
#  Scenario: Check whether the Contingent liability list can keep previously loaded when I go back to Contingent liability list at Portfolio Level from Contingent liability detail
#    Given I login as User
#      | element name | element value |
#      | Name         | userE         |
#    When I tap first item of Accounts list
#    And I tap first item of Portfolios list
#    And I tap on the Contingent Liabilities tab
#    And I reach the 15th item within the Contingent liabilities list
#    And I continue to load the list by swipe up the Contingent liabilities list
#    And I tap the 20th item within Contingent liability list
#    And I go back to the Contingent liability list Level
#    Then I should see the 20th item and the Contingent liability list previously loaded (16th-30th)
#
#    # Transaction  list item <=15 items
#  @S79-AC1-AT54
#  Scenario: Check the lazy loading of Transaction list at Portfolio Level when list contains <= 15 items
#    Given I am viewing the Transaction list at Portfolio Level
#    When I swipes up to scroll down the Transaction list at Portfolio Level
#    And I reach the last item in the Transaction list at Portfolio Level
#    Then there are no more items will be displayed below
#
## Contingent liabilities list item <=15 items
#  @S79-AC1-AT55
#  Scenario: Check the lazy loading of Contingent liabilities list when list contains <= 15 items
#    Given I am viewing the Contingent liabilities list
#    When I swipes up to scroll down the Contingent liabilities list
#    And I reach the last item in the Contingent liabilities list
#    Then there are no more items will be displayed below









