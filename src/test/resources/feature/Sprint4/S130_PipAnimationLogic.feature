@Epic_GPBM-385(Global_Interactions_and_Animations)
@Story_GPBM-1420 @Story_GPBM-1422 @Story_GPBM-1424 @Sprint4_iOS
@Story_GPBM-1425 @Sprint4-aOS

Feature:Pip animation Logic
  As a user I want to know that I can swipe left or right to scroll througt a list of items,
  so that I know I don't need to return to a vertical list view to view multiple records

#  contingent liabilities remove update
#  @HK @SG @UK
#  @S78-AC1-AT3
#  Scenario:Check whether the holding list will be changed when I swipe left or right to the Nth portfolio which has no holdings but has contingent liabilities
#    Given I login as User
#      | element name | element value |
#      | Name         | userE         |
#      | password     | 123           |
#    When I tap first item of Accounts list
#    And I tap first item of Portfolios list
#    And I scroll left 2 times on the portfolio "Holdings" page
##    Update for sprint6
##    Then I can see the contingent liability bar
#    Then I should see the following message under the holdings is displayed:
#      | element name           | element value                                          |
#      | Holdings title         | There are no holdings available within this portfolio. |
#      | Android Holdings title | There are no holdings available within this portfolio. |

#    Update for sprint6
#  @S78-AC1-AT30
#  @DependsOn('Check_whether_the_holding_list_will_be_changed_when_I_swipe_left_or_right_to_the_Nth_portfolio_which_has_no_holdings_but_has_contingent_liabilities')
#  Scenario: Check whether I can swipe the pips from 1st to the last one continuously when the total Contingent liability list item is N
#    Given I see the following message under the holdings is displayed:
#      | element name           | element value                                           |
#      | Holdings title         | There are no holdings available within  this Portfolio.  |
#      | Android Holdings title | There are no holdings available within this Portfolio.  |
#    When I am on the Contingent liability list view
#    And I tap first item of contingent liabilities list
#    Then I can swipe the pips from 1st to the last one continuously within Contingent liability detail

  #    And the total account list item is N
  #    And the Nth portfolio has no holdings and no contingent liabilities
  @HK @SG @UK
  @S78-AC1-AT4
  Scenario: Check whether the holding list will be changed when I swipe left or right to the Nth portfolio which has no holdings and no contingent liabilities
    Given I login as type "holding_list_left_2_item_no_holding"
    And I scroll left 2 times on the portfolio "Holdings" page
    Then I should see the following message under the holdings is displayed:
      | element name           | element value                                          |
      | Holdings title         | There are no holdings available within this portfolio. |
      | Android Holdings title | There are no holdings available within this portfolio. |

  @HK @SG @UK
  @S78-AC2-AT29
  Scenario: Check whether account name and account number and total assets value will be changed when I slide the pips left or right on  Account wrapper
    Given I login as type "account_wrapper_left_1_item_change"
    When I tap first item of Accounts list
    And I swipe left to other account on "Wrapper" tab
    Then I should see the account name and account number and total assets value and updated time in the account wrapper will be changed

  @HK @SG @UK
  @S78-AC1-AT6
  Scenario: Check whether I can swipe the pips from 1st to the last one continuously when the total account list item is N
    Given I login as type "account_list_has_deserved_item"
    Then I can swipe the pips from 1st to the last one continuously within account wrapper

  @NotAutomatable
  Scenario: Check whether the portfolio list will be changed when I swipe left or right to another account
    Given I see the account list
    When I tap first item of Accounts list
    And I swipe right 1 times to another account on "Account" tab
    Then I can see the loading icon and loadong lists label
    And I can see the related content in the Portfolio list
    # S78-AC1-AT5
    # Reason: cannot check the loading

  @HK @SG @UK
  @S78-AC1-AT7
  Scenario: Check whether the Asset Class list will be changed when I swipe left or right to another account
    Given I login as type "account_class_left_1_item_change"
    And I tap the Account Allocation Toggle ON
    And I swipe left to other account on "Class" tab
    Then I can see the related content in the Asset Class list


#  Background：I have tap the Nth account Sub asset Class Toggle ON
  @NotAutomatable
  @HK @SG @UK
  @S78-AC1-AT9
  Scenario: Check whether the Sub Asset Class list will be changed when I swipe left or right to another account
    Given I login as type "more_than_3_account_list_has_sub_class"
    And I tap the Account Allocation Toggle ON
    And I tap "Show Sub-Asset Class" toggle of Accounts level
    And I tap the Back Button of Accounts Level
    And I tap first item of Accounts list
    And I tap the Account Allocation Toggle ON
    And I swipe left to the 2th account within account wrapper
    Then I can see the 1th account's Sub asset Class Toggle is ON


  #    the Nth account has no Class
  @HK @SG @UK
  @S78-AC1-AT8
  Scenario: Check the following message in Asset Class list at Account Allocation when I swipe left or right to another account
    Given I login as type "account_class_left_2_item_no_class"
#    And I tap the Account Allocation Toggle ON
    And I swipe left to the 2th account within account wrapper
    And I tap the Account Allocation Toggle ON
    Then I should see the following UI Elements on the Accounts Class tab
      | element region | element name  | element value                                                                        |
      | HK_SG          | class content | Exposure by Asset Class is unavailable as there are no holdings within this Account. |
      | UK             | class content | Exposure by asset class is unavailable as there are no holdings within this account. |

  @HK @SG @UK
  @S78-AC1-AT11
  Scenario: Check whether the Asset Currency list will be changed when I swipe left or right to another account
    Given I login as type "account_currency_left_1_item_change"
    And I tap the Account Allocation Toggle ON
    And I tap on "Currency" tab of Account Level
    And I swipe left to other account on "Currency" tab
    Then I can see the related content in the Asset Currency list

#    the 16th portfolio has no Currency
  @HK @SG @UK
  @S78-AC1-AT12
  Scenario: Check the following message in Asset Currency list at Account Allocation when I swipe left or right to another account
    Given I login as type "account_region_left_2_item_no_regin"
    And I swipe left to the 2th account within account wrapper
    And I tap the Account Allocation Toggle ON
    And I tap on "Currency" tab of Account Level
    Then I should see the following UI Elements on the Accounts Currency tab
      | element region | element name     | element value                                                                     |
      | HK_SG          | currency content | Exposure by Currency is unavailable as there are no holdings within this Account. |
      | UK             | currency content | Exposure by asset class unavailable as there are no holdings in your account.        |

  @NotAutomatable
  @UK
  @S78-AC1-AT13
  Scenario: Check whether the Asset Region list will be changed when I swipe left or right to another account
    Given I login as type "account_region_left_1_item_change"
    And I tap the account Allocation Toggle ON
    And I tap on "Region" tab of Account Level
    And I swipe left to other account on "Region" tab
    Then I can see the related content in the Asset Region list

#     the 16th portfolio has no Region
  @UK
  @S78-AC1-AT14
  Scenario: Check the following message in Asset Region list at Account Allocation when I swipe left or right to another account
    Given I login as type "account_region_left_2_item_no_regin"
    And I tap the account Allocation Toggle ON
    And I tap on "Region" tab of Account Level
    And I swipe left to the 2th account within account wrapper
    Then I should see the following UI Elements on the Accounts Region tab
      | element region | element name   | element value                                                                   |
      | HK_SG          | region content | Exposure by Region is unavailable as there are no holdings within this Account. |
      | UK             | region content | Exposure by region is unavailable as there are no holdings within this account. |

  #    Background：If there is a lag in loading another account
  @NotAutomatable
  Scenario:  Check whether I can see the loading icon and loading lists title and animation when there is a lag in loading another account
    Given I see the account list
    When I tap first item of Accounts list
    And I swipe left 2 times to another account on "Account" tab
    Then I can see the Loading icon and loading lists title
    # S78-AC1-AT31
    # Reason: cannot check the loading

  #    Background：If there is no lag in loading another account
  @HK @SG @UK
  @S78-AC1-AT33
  Scenario: Check whether I can see the loading animation when there is no lag in loading another account
    Given I login as type "portfolio_list_left_1_item_change"
#    When I tap first item of Accounts list
    And I swipe left to other account on "Account" tab
    Then I can see the related content in the Portfolio list

  @HK @SG @UK
  @S78-AC2-AT28
  Scenario: Check whether the Account Overlay is related to that Account
    Given I login as type "account_total_assets_left_1_item_change"
    And I swipe left to other account on "Total Assets" tab
    And I tap on the account total assets value
    Then I should see account Overlay relating to that item

#    portfolio
  @HK @SG @UK
  @S78-AC1-AT17
  Scenario: Check whether I can swipe the pips from 1st to the last one continuously when the total portfolio list item is N
    Given I login as type "portfolio_list_has_deserved_item_at_pip"
    Then I can swipe the pips from 1st to the last one continuously within portfolio wrapper

  @HK @SG @UK
  @S78-AC2-AT27
  Scenario: Check whether portfolio name and portfolio number and total assets value will be changed when I slide the pips left or right on  Portfolio wrapper
    Given I login as type "portfolio_wrapper_left_1_item_change"
    And I scroll left 1 times on the portfolio "Wrapper" page
    Then I should see the portfolio name and portfolio number and total assets value and updated time and in the portfolio wrapper will be changed


    #    Background：I have tap the Nth portfolio Sub asset Class Toggle ON
#Sub Asset Class有数据
  @NotAutomatable
  @HK @SG @UK
  @S78-AC1-AT20
  Scenario: Check whether the Sub Asset Class list will be changed when I swipe left or right to another portfolio
    Given I login as type "more_than_3_portfolio_list_has_sub_class"
    And I tap on Asset Allocation toggle
#    And I tap "Show Sub-Asset Class" toggle of Portfolio level
    And I come back to the Account Level
    And I tap first item of Portfolios list
    And I scroll left 2 times on the portfolio "Class" page
    And I tap on Asset Allocation toggle
    Then I can see the 3rd portfolio's Sub asset Class Toggle is ON


#   I click Transaction tap
  @HK @SG @UK
  @S78-AC1-AT15
  Scenario: Check whether the transaction list will be changed when I swipe left or right to another portfolio
    Given I login as type "transaction_list_left_1_item_change"
    And I click the Portfolios Transactions tab
    And I scroll left 1 times on the portfolio "Transaction" page
    Then I can see the related content in the portfolios "Transaction" tab

#     there are no transaction list in the Nth portfolio
#  第四个account、第16个Portfolios
  @HK @SG @UK
  @S78-AC1-AT16
  Scenario: Check I can see the following message when I swipe left or right to the Nth portfolio which has no transaction
    Given I login as type "transaction_list_left_2_item_no_transaction"
    And I click the Portfolios Transactions tab
    And I scroll left 2 times on the portfolio "Transaction" page
    Then I should see the following message is displayed in the transactions tab:
      | element name           | element value                                              |
      | UK transaction content | There are no transactions available within this portfolio. |
      | transaction content    | There are no transactions available within this portfolio. |

    #    Background：If there is a lag in loading another portfolio
  @NotAutomatable
  Scenario:  Check whether I can see the loading icon and loading lists title and animation when there is a lag in loading another portfolio
    Given I am on the Account level
    When I tap 14th item of Portfolios list
    And I click the Portfolios Transactions tab
    And I scroll left 2 times on the portfolio "Transaction" page
    Then I can see the Loading icon and loading lists title
    # S78-AC1-AT34
    # Reason: cannot check the loading

    #    Background：If there is a lag in loading another portfolio,and I swipe to another portfolio,and I can can see the Loading icon and loading lists title
  @NotAutomatable
  Scenario: Check whether I can see the loading animation when there is a lag in loading another portfolio
    Given I am on the Account level
    When I tap first item of Portfolios list
    And I can see the Loading icon and loading lists title
    Then the new transaction list  is loaded successfully
    # S78-AC1-AT35
    # Reason: cannot check the loading

  @HK @SG @UK
  @S78-AC1-AT18 @regression
  Scenario: Check whether the Asset Class list will be changed when I swipe left or right to another portfolio
    Given I login as type "portfolio_class_left_1_item_change"
    And I scroll left 1 times on the portfolio "Class" page
    And I taps the Allocation Toggle ON in Portfolio level
    And I taps the Class tap in Portfolio level
    And I taps the Allocation Toggle ON in Portfolio level
    Then I can see the related content in the portfolios "Class" tab

#        And the Nth portfolio has no Class
  @HK @SG @UK
  @S78-AC1-AT19
  Scenario: Check the following message in Asset Class list at Portfolio Allocation when I swipe left or right to another portfolio
    Given I login as type "portfolio_class_left_2_item_no_class"
#    And I taps the Allocation Toggle ON in Portfolio level
#    And I taps the Class tap in Portfolio level
#    And I taps the Allocation Toggle ON in Portfolio level
    And I scroll left 2 times on the portfolio "Class" page
    And I taps the Allocation Toggle ON in Portfolio level
    Then I should see the following UI Elements on the Portfolios Class tab
      | element region | element name  | element value                                                                          |
      | HK_SG          | class content | Exposure by Asset Class is unavailable as there are no holdings within this Portfolio. |
      | UK             | class content | Exposure by asset class unavailable as there are no holdings in your portfolio.        |

  @HK @SG @UK
  @S78-AC1-AT22 
  Scenario: Check whether the Asset Currency list will be changed when I swipe left or right to another portfolio
    Given I login as type "portfolio_currency_left_1_item_change"
    And I scroll left 1 times on the portfolio "Currency" page
    And I taps the Allocation Toggle ON in Portfolio level
    And I taps the Currency tap in Portfolio level
    Then I can see the related content in the portfolios "Currency" tab

#     the Nth portfolio has no Currency
  @HK @SG @UK
  @S78-AC1-AT23
  Scenario: Check the following message in Asset Currency list at Portfolio Allocation when I swipe left or right to another portfolio
    Given I login as type "portfolio_currency_left_2_item_no_currency"
    And I scroll left 2 times on the portfolio "Currency" page
    And I taps the Allocation Toggle ON in Portfolio level
    And I taps the Currency tap in Portfolio level
    Then I should see the following UI Elements on the Portfolio Currency tab
      | element region | element name     | element value                                                                       |
      | HK_SG          | currency content | Exposure by Currency is unavailable as there are no holdings within this Portfolio. |
      | UK             | currency content | Exposure by currency unavailable as there are no holdings in your portfolio.        |

  @UK
  @S78-AC1-AT24
  Scenario: Check whether the Asset Region list will be changed when I swipe left or right to another portfolio
    Given I login as type "portfolio_region_left_1_item_change"
    And I scroll left 1 times on the portfolio "Region" page
    And I taps the Allocation Toggle ON in Portfolio level
    And I taps the Region tap in Portfolio level
    Then I can see the related content in the portfolios "Region" tab

#the Nth portfolio has no Region
  @UK
  @S78-AC1-AT25
  Scenario: Check the following message in Asset Region list at Portfolio Allocation when I swipe left or right to another portfolio
    Given I login as type "portfolio_region_left_2_item_no_regin"
    And I scroll left 2 times on the portfolio "Region" page
    And I taps the Allocation Toggle ON in Portfolio level
    And I taps the Region tap in Portfolio level
    Then I should see the following UI Elements on the Portfolio Region tab
      | element region | element name   | element value                                                                     |
      | HK_SG          | region content | Exposure by Region is unavailable as there are no holdings within this Portfolio. |
      | UK             | region content | Exposure by region unavailable as there are no holdings in your portfolio.   |

  @UK
  Scenario: on the transactions list
    Given I login as type "transactions_type_has_all"
    And I click the Portfolios Transactions tab and transactions head title
    And I select filter "Purchases" type
    Then I should see the transactions list within a selected portfolio

  @UK
  @S78-AC1-AT2
  @DependsOn('on_the_transactions_list')
  Scenario: Check whether the selected filter can be kept when enter session again on the pip logic
    Given I see the transactions list within a selected portfolio
    When I come back to the Account Level
    And I tap first item of Portfolios list
    And I click the Portfolios Transactions tab
    Then I should see the filter type is "Purchase"

  @UK
  @S78-AC1-AT1
  @DependsOn('on_the_transactions_list')
  Scenario: Check whether the selected filter can be kept after slide left or right on the pip logic
    Given I see the transactions list within a selected portfolio
    When I slide right to the next item
    And I slide left to previous item
    Then I should see the filter type is "Purchase"

  @HK @SG @UK
  @S78-AC2-AT26
  Scenario: Check whether the Portfolio Overlay is related to that Portfolio
    Given I login as type "portfolio_total_assets_left_1_item_change"
    And I scroll left 1 times on the portfolio "Total Assets" page
    And I tap on the Protfolio assets value2
    Then I should see Overlay relating to that item on portfolio level

#       Background：If there is no lag in loading another account
  @HK @SG @UK
  @S78-AC1-AT36
  Scenario: Check whether I can see the loading animation when there is no lag in loading another portfolio
    Given I login as type "holding_list_left_1_item_change"
    And I scroll left 1 times on the portfolio "Holdings" page
    Then I can see the related content in the portfolios "Holdings" tab


    #    Background：If there is a lag in loading another account,and I swipe to another account,and I can can see the Loading icon and loading lists title
  @NotAutomatable
  Scenario:  Check whether I can see the loading animation when there is a lag in loading another account
    When dummy
    # S78-AC1-AT32
    # Reason: cannot check the opacity
