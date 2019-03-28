@Epic_GPBM-1022(Transactions)
@Story_GPBM-1157 @Sprint4_iOS
@Story_GPBM-1355 @Sprint3_aOS

Feature:Transactions list view ORDERING LOGIC

  As a Client, I want to view a list of my transactions within a selected Portfolio in a logical order,
  so that I can see a history of my portfolio activity.

  @HK @SG @UK
  @S114-AC1-AT1
  @SIT
  Scenario: Check the sequence of transaction list when transaction list items are less than 15
    Given I login as type "transactions_list_has_12_less_than_15"
#    When I tap first item of Accounts list
#    And I taps on 2nd items in Portfolio list
    And I tap the Transactions button
    Then I should see that transactions are ordered initially by trade date (recent first - oldest date last), then order by Transaction Type value (a-z), last order by Transaction Description value (a-z) for list

  @HK @SG @UK
  @S114-AC1-AT2
  @SIT
  Scenario: Check the sequence of transaction list when transaction list items are more than 15
    Given I login as type "transactions_list_has_22_more_than_15"
#    When I tap first item of Accounts list
#    And I tap first item of Portfolios list
    And I tap the Transactions button
    Then I should see that transactions are ordered initially by trade date (recent first - oldest date last), then order by Transaction Type value (a-z), last order by Transaction Description value (a-z) for list

  @UK
  @S114-AC1-AT3
  @SIT
  Scenario: Check the sequence of transaction list which type is "Sales"
    Given I login as type "transactions_sales_has_6_item"
#    When I tap first item of Accounts list
#    And I tap first item of Portfolios list
    And I tap the Transactions button
    And I tap on Transactions filter labelled "Type"
    And I select filter "Sales" type
#    Then I should see all "Sales" type transaction list will be listed for list number are 6
#  reason: There are no unique identifier to distinguish types.
    Then I should see that transactions are ordered initially by trade date (recent first - oldest date last), then order by Transaction Type value (a-z), last order by Transaction Description value (a-z) for list

  @UK
  @S114-AC1-AT4
  @SIT
  Scenario: Check the sequence of transaction list which type is "Purchases"
    Given I login as type "transactions_purchases_has_6_item"
#    When I tap first item of Accounts list
#    And I tap first item of Portfolios list
    And I tap the Transactions button
    And I tap on Transactions filter labelled "Type"
    And I select filter "Purchases" type
#    Then I should see all "Purchases" type transaction list will be listed for list number are 6
#  reason: There are no unique identifier to distinguish types.
    And I should see that transactions are ordered initially by trade date (recent first - oldest date last), then order by Transaction Type value (a-z), last order by Transaction Description value (a-z) for list

  @UK
  @S114-AC1-AT5
  @SIT
  Scenario: Check the sequence of transaction list which type is "Cash movements"
    Given I login as type "transactions_cash_movements_has_9_item"
#    When I tap first item of Accounts list
#    And I tap first item of Portfolios list
    And I tap the Transactions button
    And I tap on Transactions filter labelled "Type"
    And I select filter "Cash movements" type
#    Then I should see all "Cash movements" type transaction list will be listed for list number are 9
#  reason: There are no unique identifier to distinguish types.
    And I should see that transactions are ordered initially by trade date (recent first - oldest date last), then order by Transaction Type value (a-z), last order by Transaction Description value (a-z) for list


  @HK @SG @UK
  @S114-AC1-AT6
  @SIT
  Scenario: Check the sequence of transaction list when I swipe left or right pips
    Given I login as type "transactions_list_left_item_has_13"
#    When I tap first item of Accounts list
#    And I tap first item of Portfolios list
    And I tap the Transactions button
    And I swipe left the portfolio screen
    Then I should see that transactions are ordered initially by trade date (recent first - oldest date last), then order by Transaction Type value (a-z), last order by Transaction Description value (a-z) for list
