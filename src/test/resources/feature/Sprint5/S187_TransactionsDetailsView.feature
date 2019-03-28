@HK @SG @UK
@Epic_GPBM-1022(Transactions)
@Story_GPBM-1001 @Sprint5_iOS
@Story_GPBM-1363 @Sprint5_aOS

Feature: Transaction details view

  As a Client, I want to view more detail about a transaction than I get in the list view,
  so that I have a complete view of my transactions.

#    Asia：settled base and reporting currency of transaction are DIFFERENT --->4
##    UK:6
  @SIT
  Scenario: settled transaction AND base and reporting currency of transaction are DIFFERENT
    Given I login as type "portfolio_transaction_detail_settled_different"
    Then I should on the transaction detail

  @S187-AC1-AT1
  @DependsOn('settled_transaction_AND_base_and_reporting_currency_of_transaction_are_DIFFERENT')
  Scenario: Check detail of a settled transaction AND base and reporting currency of transaction are DIFFERENT
    Given I am on the transaction detail
    Then I can see the following data regarding the transaction:
      | element region | element name                                      | element value                                                                                                                                                                                                                         |
      | HK_SG          | Status label                                      | Settlement/Value date                                                                                                                                                                                                                 |
      | UK             | Type value                                        |                                                                                                                                                                                                                                       |
      |                | Transaction description value                     |                                                                                                                                                                                                                                       |
      |                | Transaction ID value                              |                                                                                                                                                                                                                                       |
      |                | Trade date value                                  |                                                                                                                                                                                                                                       |
      | UK             | Status label                                      | Settlement date                                                                                                                                                                                                                       |
      |                | Settlement date value                             |                                                                                                                                                                                                                                       |
      |                | Units value                                       |                                                                                                                                                                                                                                       |
      |                | Transaction value in holding currency             |                                                                                                                                                                                                                                       |
      |                | Transaction value in portfolio reference currency |                                                                                                                                                                                                                                       |
      | UK             | Disclaimer                                        | The value of this transaction in base currency is based on latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for information about related fees. |
      | HK_SG          | Disclaimer                                        | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction.                                                                         |

  @S187-AC1-AT2
  @SIT
  @DependsOn('settled_transaction_AND_base_and_reporting_currency_of_transaction_are_DIFFERENT')
  Scenario: Check currency format in settled transaction detail when base and reporting currency of transaction are DIFFERENT
    Given I am on the transaction detail
    Then I can see ISO 3 code of transaction currency DIFFERENT

  @S187-AC1-AT3
  @SIT
  @DependsOn('settled_transaction_AND_base_and_reporting_currency_of_transaction_are_DIFFERENT')
  Scenario: Check date format in settled transaction detail when base and reporting currency of transaction are DIFFERENT
    Given I am on the transaction detail
    Then I can see transaction date value Format is "dd MMM yyyy" settled


#    Asia：settled base and reporting currency of transaction are the SAME --->10
#    UK:9
  @SIT
  Scenario: settled transaction AND base and reporting currency of transaction are the SAME
    Given I login as type "portfolio_transaction_detail_settled_same"
    Then I should on the transaction detail

  @S187-AC2-AT1
  @DependsOn('settled_transaction_AND_base_and_reporting_currency_of_transaction_are_the_SAME')
  Scenario: Check detail of a settled transaction AND base and reporting currency of transaction are the SAME
    Given I am on the transaction detail
    Then I can see the following data regarding the transaction:
      | element region | element name                          | element value         |
      | HK_SG          | Status label                          | Settlement/Value date |
      | UK             | Type value                            |                       |
      |                | Transaction description value         |                       |
      |                | Transaction ID value                  |                       |
      |                | Trade date value                      |                       |
      | UK             | Status label                          | Settlement date       |
      |                | Settlement date value                 |                       |
      |                | Units value                           |                       |
      |                | Transaction value in holding currency |                       |

  @S187-AC2-AT2
  @SIT
  @DependsOn('settled_transaction_AND_base_and_reporting_currency_of_transaction_are_the_SAME')
  Scenario: Check currency format in settled transaction detail when base and reporting currency of transaction are the SAME
    Given I am on the transaction detail
    Then I can see ISO 3 code of transaction currency SAME

  @S187-AC2-AT3
  @SIT
  @DependsOn('settled_transaction_AND_base_and_reporting_currency_of_transaction_are_the_SAME')
  Scenario: Check date format in settled transaction detail when base and reporting currency of transaction are the SAME
    Given I am on the transaction detail
    Then I can see transaction date value Format is "dd MMM yyyy" settled

#    Asia：1
#  UK:2
  @SIT
  Scenario: pending transaction AND base and reporting currency of transaction are DIFFERENT
    Given I login as type "portfolio_transaction_detail_pending_different"
    Then I should on the transaction detail

  @S187-AC3-AT1
  @DependsOn('pending_transaction_AND_base_and_reporting_currency_of_transaction_are_DIFFERENT')
  Scenario: Check detail of a pending transaction AND base and reporting currency of transaction are DIFFERENT
    Given I am on the transaction detail
    Then I can see the following data regarding the transaction:
      | element region | element name                                      | element value                                                                                                                                                                                                                         |
      | UK             | Type value                                        |                                                                                                                                                                                                                                       |
      |                | Transaction description value                     |                                                                                                                                                                                                                                       |
      |                | Transaction ID value                              |                                                                                                                                                                                                                                       |
      |                | Trade date value                                  |                                                                                                                                                                                                                                       |
      | UK             | Status label                                      | Pending                                                                                                                                                                                                                               |
      |                | Units value                                       |                                                                                                                                                                                                                                       |
      |                | Transaction value in holding currency             |                                                                                                                                                                                                                                       |
      |                | Transaction value in portfolio reference currency |                                                                                                                                                                                                                                       |
      |                | Disclaimer                                        | The value of this transaction in base currency is based on latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for information about related fees. |

  @S187-AC3-AT2
  @SIT
  @DependsOn('pending_transaction_AND_base_and_reporting_currency_of_transaction_are_DIFFERENT')
  Scenario: Check currency format in pending transaction detail when base and reporting currency of transaction are DIFFERENT
    Given I am on the transaction detail
    Then I can see ISO 3 code of transaction currency DIFFERENT

  @S187-AC3-AT3
  @SIT
  @DependsOn('pending_transaction_AND_base_and_reporting_currency_of_transaction_are_DIFFERENT')
  Scenario: Check date format in pending transaction detail when base and reporting currency of transaction are DIFFERENT
    Given I am on the transaction detail
    Then I can see transaction date value Format is "dd MMM yyyy" pending

#    Asia：2
#  UK:5
  @SIT
  Scenario: pending transaction AND base and reporting currency of transaction are the SAME
    Given I login as type "portfolio_transaction_detail_pending_same"
    Then I should on the transaction detail

  @S187-AC4-AT1
  @DependsOn('pending_transaction_AND_base_and_reporting_currency_of_transaction_are_the_SAME')
  Scenario: Check detail of a pending transaction AND base and reporting currency of transaction are the SAME
    Given I am on the transaction detail
    Then I can see the following data regarding the transaction:
      | element region | element name                          | element value |
      | UK             | Type value                            |               |
      |                | Transaction description value         |               |
      |                | Transaction ID value                  |               |
      |                | Trade date value                      |               |
      | UK             | Status label                          | Pending       |
      |                | Units value                           |               |
      |                | Transaction value in holding currency |               |

  @S187-AC4-AT2
  @SIT
  @DependsOn('pending_transaction_AND_base_and_reporting_currency_of_transaction_are_the_SAME')
  Scenario: Check currency format in pending transaction detail when base and reporting currency of transaction are the SAME
    Given I am on the transaction detail
    Then I can see ISO 3 code of transaction currency SAME

  @S187-AC4-AT3
  @SIT
  @DependsOn('pending_transaction_AND_base_and_reporting_currency_of_transaction_are_the_SAME')
  Scenario: Check date format in pending transaction detail when base and reporting currency of transaction are the SAME
    Given I am on the transaction detail
    Then I can see transaction date value Format is "dd MMM yyyy" pending

  @S187-AC5-AT1
  Scenario: Check whether client can returns to Transactions list view
    Given I login as type "portfolio_transaction_detail_return"
    And I tap the Transactions button
    When I taps first on a transaction list item
    And I taps on the transaction Back button
    Then I returns to Transactions list view within that portfolio