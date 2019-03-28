@UK
@Epic_GPBM-1022(Transactions)
@Story_GPBM-1003 @Sprint3_iOS
@Story_GPBM-1360 @Sprint3_aOS

Feature: Apply Transactions filter (FEES TO BE WRITTEN)

  As a Client, I want to be able to clearly distinguish my security movement transactions so I can only see securities transactions

  userF:All Transactions list

  Scenario: Client Login in Portfolios level
    Given I login as type "transactions_type_has_all"
#    When I tap first item of Accounts list
#    And I tap first item of Portfolios list
    And I tap the Transactions button
    Then I see the transaction list

  @S77-AC1-AT1
  @DependsOn('Client_Login_in_Portfolios_level')
  Scenario: Check whether the Purchases filter can be kept for the entire app session
    Given I see the transaction list
    When I tap the head title
    And I select filter "Purchases" type
    And I save first and two item element
    Then The filter is applied for the Transactions list within that individual portfolio for the entire app session at Purchases

  @S77-AC1-AT2
  @DependsOn('Client_Login_in_Portfolios_level')
  Scenario: Check whether the Sales filter can be kept for the entire app session
    Given I see the transaction list
    When I tap the head title
    And I select filter "Sales" type
    And I save first and two item element
    Then The filter is applied for the Transactions list within that individual portfolio for the entire app session at Sales

    # update for sprint4
#  @S77-AC1-AT3
#  @DependsOn('Client_Login_in_Portfolios_level')
#  Scenario: Check whether the Fees filter can be kept for the entire app session
#    Given I see the transaction list
#    When I tap the head title
#    And I select "Fees" filter
#    And I save first and two item element
#    Then The filter is applied for the Transactions list within that individual portfolio for the entire app session at Fees
#
#  @S77-AC1-AT4
#  @DependsOn('Client_Login_in_Portfolios_level')
#  Scenario: Check whether the Income filter can be kept for the entire app session
#    Given I see the transaction list
#    When I tap the head title
#    And I select "Income" filter
#    And I save first and two item element
#    Then The filter is applied for the Transactions list within that individual portfolio for the entire app session at Income

  @S77-AC1-AT5
  @DependsOn('Client_Login_in_Portfolios_level')
  Scenario: Check whether the selected filter can be kept after slide left or right
    Given I see the transaction list
    When I tap the head title
    And I select filter "Purchases" type
    And I slide right to the next item
    And I slide left to previous item
    Then I should see the filter type is Purchases

  @S77-AC1-AT6
  @DependsOn('Client_Login_in_Portfolios_level')
  Scenario: Check whether the selected Purchases filter can be kept when enter session again
    Given I see the transaction list
    When I tap the head title
    And I select filter "Purchases" type
    And I tap Back button at portfolio level
    And I tap first item of Portfolios list
    And I tap the Transactions button
    Then I should see the filter type is Purchases

  @S77-AC1-AT7
  @DependsOn('Client_Login_in_Portfolios_level')
  Scenario: Check whether the selected Cash movements filter can be kept when enter session again
    Given I see the transaction list
    When I tap the head title
    And I select filter "Cash movements" type
    And I tap Back button at portfolio level
    And I tap first item of Portfolios list
    And I tap the Transactions button
    Then I should see the filter type is Cash movements

# AC2

  @S77-AC2-AT1
  @DependsOn('Client_Login_in_Portfolios_level')
  Scenario: Check whether the All filter can be kept for the entire app session
    Given I see the transaction list
    When I tap the head title
    And I select filter "All" type
    And I save first and two item element
    Then I should see the filter is applied for the Transactions list within that portfolio for the entire app session at All

# AC3

  @S77-AC3-AT1
  @DependsOn('Client_Login_in_Portfolios_level')
  Scenario: Check the list of all transactions in All filter
    Given I see the transaction list
    Then I should see a list of all transactions within that portfolio are displayed

  @S77-AC3-AT2
  @DependsOn('Client_Login_in_Portfolios_level')
  Scenario: Check the negative values at the list of all transaction in All filter
    Given I see the transaction list
    Then I should see negative values are displayed using a minus sign before the value

  @S77-AC3-AT3
  Scenario: Check the list of all transaction in All filter
    Given I login as type "transactions_type_has_all"
#    When I tap first item of Accounts list
#    And I tap first item of Portfolios list
    And I tap the Transactions button
#    And I tap the head title
    And "All" filter option is already applied by default
    Then I should see a list of all transactions within that portfolio are displayed

  @S77-AC3-AT4
  @DependsOn('Check_the_list_of_all_transaction_in_All_filter')
  Scenario: Check the negative values at the list of all transactions in All filter
    Given I see the transaction list
    Then I should see negative values are displayed using a minus sign before the value

# AC4

  @S77-AC4-AT1
  Scenario: Check the following message in all filter when taps all filter option and OK button
    Given I login as type "no_transactions"
#    When I tap four item of Accounts list
#    And I tap last item of Portfolios list
    And I tap the Transactions button
    Then I should see the following message is displayed in the transactions tab:
      | element name           | element value                                              |
      | UK transaction content | There are no transactions available within this portfolio. |
      | transaction content    | There are no transactions available within this portfolio. |

  # update for sprint4
#  @S77-AC4-AT2
#  @DependsOn('Check_the_following_message_in_all_filter_when_taps_all_filter_option_and_OK_button')
#  Scenario: Check the following message in all filter when all  filter option is already applied by default
#    Given I should not see Transactions list
#    When I tap the head title
#    And I select filter "All" type
#    Then I should see the following message is displayed
#      | element name | element value                                                                                                |
#      | Title        | There are no transactions available within this Portfolio.                                                   |
#      | Description  | Please note, transactions that have settled prior to the release of your new Wealth Dashboard are not shown. |
#
    # AC6

  @S77-AC6-AT1
  Scenario: Check the following message in Purchases filter when taps Purchases filter option and OK button
    Given I login as type "transactions_type_no_purchases"
#    When I tap four item of Accounts list
#    And I tap fourth item of Portfolios list
    And I tap the Transactions button
    When I tap the head title
    And I select filter "Purchases" type
    Then I should see the following message is displayed
      | element name               | element value                                                           |
      | Title                      | There are no transactions of this type available within this portfolio. |
      | UK transaction content     | There are no transactions available of this type within this portfolio. |
      | UK transaction description | Please refer to your transaction advices to view historic transactions. |
#      | Description  | Please note, transactions that have settled prior to the release of your new Wealth Dashboard are not shown. |

    # AC8
  @S77-AC8-AT1
  Scenario: Check the following message in Sales filter when taps Sales filter option and OK button
    Given I login as type "transactions_type_no_sales"
    And I tap the Transactions button
    When I tap the head title
    And I select filter "Sales" type
    Then I should see the following message is displayed
      | element name               | element value                                                           |
      | Title                      | There are no transactions of this type available within this portfolio. |
      | UK transaction content     | There are no transactions available of this type within this portfolio. |
      | UK transaction description | Please refer to your transaction advices to view historic transactions. |
#
  @reTest
  @S77-AC10-AT1
  Scenario: Check the following message in Cash movements filter when taps Sales filter option and OK button
    Given I login as type "transactions_type_no_cash_movements"
    And I tap the Transactions button
    When I tap the head title
    And I select filter "Cash movements" type
    Then I should see the following message is displayed
      | element name               | element value                                                           |
      | Title                      | There are no transactions of this type available within this portfolio. |
      | UK transaction content     | There are no transactions available of this type within this portfolio. |
      | UK transaction description | Please refer to your transaction advices to view historic transactions. |
#      | Description  | Please note, transactions that have settled prior to the release of your new Wealth Dashboard are not shown. |


#      update for sprint4
#  @S77-AC12-AT1
#  @DependsOn('Check_the_following_message_in_all_filter_when_taps_all_filter_option_and_OK_button')
#  Scenario: Check the following message in Fees filter when taps Fees filter option and OK button
#    Given I should not see Transactions list
#    When I tap the head title
#    And I select "Fees" filter
#    Then I should see the following message is displayed
#      | element name | element value                                                                                                |
#      | Title        | There are no transactions of this type available within this portfolio.                                      |
#      | Description  | Please note, transactions that have settled prior to the release of your new Wealth Dashboard are not shown. |
#
#    # AC10
#
#  @S77-AC10-AT1
#  @DependsOn('Check_the_following_message_in_all_filter_when_taps_all_filter_option_and_OK_button')
#  Scenario: Check the following message in Income filter when taps Income filter option and OK button
#    Given I should not see Transactions list
#    When I tap the head title
#    And I select "Income" filter
#    Then I should see the following message is displayed
#      | element name | element value                                                                                                |
#      | Title        | There are no transactions of this type available within this portfolio.                                      |
#      | Description  | Please note, transactions that have settled prior to the release of your new Wealth Dashboard are not shown. |


# AC5
  @NotAutomatable
  Scenario: Check the list of all transactions in Purchases filter
    Given I login as type "transactions_purchases_has_6_item"
#    When I tap first item of Accounts list
#    And I tap first item of Portfolios list
    And I tap the Transactions button
    And I tap the head title
    And I select filter "Purchases" type
    Then I should see all "Purchases" type transaction list will be listed for list number are 6
#  @S77-AC5-AT1
#  reason: There are no unique identifier to distinguish types.

  @S77-AC5-AT2
  Scenario: Check the negative values at the list of all transactions in Purchases filter
    Given I login as type "transactions_purchases_first_item_negative"
    And I tap the Transactions button
    When I tap the head title
    And I select filter "Purchases" type
    Then I should see Purchases first item negative values are displayed using a minus sign before the value

# AC7
  @NotAutomatable
  Scenario: Check the list of all transactions in Sales filter
    Given I login as type "transactions_sales_has_6_item"
    And I tap the Transactions button
    When I tap the head title
    And I select filter "Sales" type
    Then I should see all "Sales" type transaction list will be listed for list number are 6
#  @S77-AC7-AT1
#  reason: There are no unique identifier to distinguish types.

  @S77-AC7-AT2
  Scenario: Check the negative values at the list of all transactions in Sales filter
    Given I login as type "transactions_sales_second_item_negative"
    And I tap the Transactions button
    When I tap the head title
    And I select filter "Sales" type
    Then I should see Sales second item negative values are displayed using a minus sign before the value

  @NotAutomatable
  Scenario: Check the list of all transactions in Cash movements filter
    Given I login as type "transactions_cash_movements_has_9_item"
    And I tap the Transactions button
    When I tap the head title
    And I select filter "Cash movements" type
    Then I should see all "Cash movements" type transaction list will be listed for list number are 9
#  @S77-AC11-AT1
#  reason: There are no unique identifier to distinguish types.


  @S77-AC11-AT2
  Scenario: Check the negative values at the list of all transactions in Cash movements filter
    Given I login as type "transactions_cash_movements_second_item_negative"
    And I tap the Transactions button
    When I tap the head title
    And I select filter "Cash movements" type
    Then I should see Cash movements second item negative values are displayed using a minus sign before the value


  # update for sprint4

#  @S77-AC11-AT1
#  @DependsOn('Check_the_list_of_all_transactions_in_Purchases_filter')
#  Scenario: Check the list of all transactions in Fees filter
#    Given I see the transaction list
#    When I tap the head title
#    And I select "Fees" filter
#    Then I should see four item of transactions list of "Fees" filter are displayed
#      | element name      | element value                                                   |
#      | Transaction Type  | Fees4 GBP                                                       |
#      | Description value | Transaction Description: This is the fees description, pleas... |
#      | Trade date        | 31 May 2018                                                     |
#      | status    | Pending                                                         |
#      | Transaction value | -10,000.00                                                      |
#      | base currency     | GBP                                                             |
#
#
#  @S77-AC11-AT2
#  @Const(action="transactions_scroll_to_top")
#  @DependsOn('Check_the_list_of_all_transactions_in_Purchases_filter')
#  Scenario: Check the negative values at the list of all transactions in Fees filter
#    Given I see the transaction list
#    Then I should see Fees four item negative values are displayed using a minus sign before the value
#
## AC9
#
#  @S77-AC9-AT1
#  @DependsOn('Check_the_list_of_all_transactions_in_Purchases_filter')
#  Scenario: Check the list of all transactions in Income filter
#    Given I see the transaction list
#    When I tap the head title
#    And I select "Income" filter
#    Then I should see four item of transactions list of "Income" filter are displayed
#      | element name      | element value                                                   |
#      | Transaction Type  | Income4 GBP                                                     |
#      | Description value | Transaction Description: This is the income description, ple... |
#      | Trade date        | 31 May 2018                                                     |
#      | Transaction value | -10,000.00                                                      |
#      | base currency     | GBP                                                             |
#
#
#  @S77-AC9-AT2
#  @DependsOn('Check_the_list_of_all_transactions_in_Purchases_filter')
#  Scenario: Check the negative values at the list of all transactions in Income filter
#    Given I see the transaction list
#    Then I should see Income four item negative values are displayed using a minus sign before the value
