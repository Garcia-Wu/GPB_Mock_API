@UK
@Epic_GPBM-1022(Transactions)
@Story_GPBM-1345 @Sprint4_iOS
@Story_GPBM-1358 @Sprint3_aOS

Feature:Access Transaction filter(update filter options)

  As a Client, I want to be able to filter the transactions I am currently viewing by Type.

  @S115-AC1-AT1
  Scenario: Check the Access Transaction filter in the transaction list view
    Given I login as type "transactions_type_has_all"
    When I tap the Transactions button
    And I tap on Transactions filter labelled "Type"
    Then I should see the following filter list of values in Transactions filter:
      | element name        | element value  |
      | OK button           | Apply          |
      | All Type            | All            |
      | Purchase Type       | Purchases      |
      | Sales Type          | Sales          |
      | Cash movements Type | Cash movements |

  @NotAutomatable
  Scenario: Check whether the transaction filter is NOT an endless loop
    When dummy
#    S115-AC1-AT2
#    Reason: Cannot check endless loop

  @NotAutomatable
  Scenario: Check the transaction list when I select filter "Purchases"
    Given I login as type "transactions_purchases_has_6_item"
    And I tap the Transactions button
    When I tap on Transactions filter labelled "Type"
    And I select filter "Purchases" type
    Then I should see all "Purchases" type transaction list will be listed for list number are 6
#  @S115-AC1-AT3
#  reason: There are no unique identifier to distinguish types.

  @NotAutomatable
  Scenario: Check the transaction list when I select filter "Sales"
    Given I login as type "transactions_sales_has_6_item"
    And I tap the Transactions button
    When I tap on Transactions filter labelled "Type"
    And I select filter "Sales" type
    Then I should see all "Sales" type transaction list will be listed for list number are 6
#  @S115-AC1-AT4
#  reason: There are no unique identifier to distinguish types.

  @NotAutomatable
  Scenario: Check the transaction list when I select filter "Cash movements"
    Given I login as type "transactions_cash_movements_has_9_item"
    And I tap the Transactions button
    When I tap on Transactions filter labelled "Type"
    And I select filter "Cash movements" type
    Then I should see all "Cash movements" type transaction list will be listed for list number are 9
#  @S115-AC1-AT5
#  reason: There are no unique identifier to distinguish types.