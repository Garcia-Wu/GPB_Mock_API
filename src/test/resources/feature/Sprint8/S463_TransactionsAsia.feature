@HK @SG
@Epic_GPBM-1022(Transactions)
@Story_GPBM-2771 @Sprint8_iOS
@Story_GPBM-2902 @Sprint8_aOS

Feature: Transactions -  Asia

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  Scenario: I see the transaction for ASIA
    Given I login as type "has_transactions"
#    When I tap first item of Accounts list
#    And I tap thirdly item of Portfolios list
    And I tap the Transactions button
    Then I should on the asia transaction screen

  @S463-AC1-AT1
  @DependsOn('I_see_the_transaction_for_ASIA')
  Scenario:Check whether I can not able to view the transaction filter when I am viewing the transaction list
    Given I am on the asia transaction screen
    Then I am not able to view the transaction filter

  @S463-AC1-AT2
  @DependsOn('I_see_the_transaction_for_ASIA')
  Scenario:Check whether I can not able to view the Pending status label for Pending transactions/the transaction type label when I am viewing the transaction list
    Given I am on the asia transaction screen
    Then I am not able to see the Pending status label for Pending transactions and transaction type label for transaction list number is "5"

  @S463-AC1-AT4
  @DependsOn('I_see_the_transaction_for_ASIA')
  Scenario:Check whether I can not see the Pending status label for Pending transactions/the transaction type label/the Transaction filter when I swap the pips
    Given I am on the asia transaction screen
    When I swipe left to other portfolio
    Then I am not able to view the transaction filter
    And I am not able to see the Pending status label for Pending transactions and transaction type label for transaction list number is "1"

  @S463-AC1-AT3
  Scenario:Check whether I can not able to view the transaction type when I am viewing the transaction detail
    Given I login as type "transactions_has_settled_in_4_item"
#    When I tap first item of Accounts list
#    And I tap first item of Portfolios list
#    And I tap the Transactions button
#    And I tap four item of transaction list
    Then I should see "Settlement/Value date" in transaction detail screen
    And I can not see the Transaction type