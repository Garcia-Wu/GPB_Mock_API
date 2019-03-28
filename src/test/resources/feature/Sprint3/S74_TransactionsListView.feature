@HK @SG @UK
@Epic_GPBM-1022(Transactions)
@Story_GPBM-993 @Sprint3_iOS
@Story_GPBM-1355 @Sprint3_aOS

Feature: Transactions list view

  As a client I want to see the individual holdings that make up my exposure to each geographical region within each Account,
  so that I know which holdings to review in order to change my regional exposure as desired

  @SIT
  Scenario: login userF for GPBM993
    Given I login as type "transactions_has_pending_in_1_item"
    When I tap the Transactions button
    Then I should on the Portfolios level

  @S74-AC1-AT1
  @DependsOn('login_userF_for_GPBM993')
  Scenario: Check the pending transaction list items
    Given I am on the Portfolios level
    Then I should see specific item transaction list that contain the following details
      | element region | element name      | element value |
      | UK             | Transaction Type  |               |
      |                | Description value |               |
      |                | Trade date        |               |
      | UK             | status            | Pending       |
      |                | Transaction value |               |

  @S74-AC1-AT2
  @SIT
  @DependsOn('login_userF_for_GPBM993')
  Scenario: Check the pending item format of trade date
    Given I am on the Portfolios level
    Then I should see the specific item trade date following the format of DD Mmm YYYY

  @SIT
  Scenario: login userF for settled transaction list items GPBM993
    Given I login as type "transactions_has_settled_in_4_item"
    When I tap the Transactions button
    Then I should on the Portfolios level

  @S74-AC2-AT1
  @DependsOn('login_userF_for_settled_transaction_list_items_GPBM993')
  Scenario: Check the settled transaction list items
    Given I am on the Portfolios level
    Then I should see specific item transaction list that contain the following details
      | element region | element name      | element value |
      | UK             | Transaction Type  |               |
      |                | Description value |               |
      |                | Trade date        |               |
      |                | Transaction value |               |

  @S74-AC2-AT2
  @SIT
  @DependsOn('login_userF_for_settled_transaction_list_items_GPBM993')
  Scenario: Check the settled item format of trade date
    Given I am on the Portfolios level
    Then I should see the specific item trade date following the format of DD Mmm YYYY

  @S74-AC2-AT3
  Scenario: Check whether all transaction are ordered by trade date
    Given I login as type "transactions_type_has_all"
    When I tap the Transactions button
    Then I should see all transactions (pending and settled) are ordered by trade date (default), most recent first, oldest date last for item num is 22