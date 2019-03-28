@HK @SG @UK
@Epic_GPBM-1022(Transactions)
@Story_GPBM-997 @Sprint5_iOS
@Story_GPBM-1362 @Sprint5_aOS

Feature: Transactions detailed view access

  As a Client, I want to view a detailed transaction in a selected Portfolio,
  so that I can review a specific transaction.

  @S186-AC1-AT1
  Scenario: Check whether can view a detailed transaction in a selected Portfolio
    Given I login as type "has_transactions"
    Then I am taken to this transaction detailed view

