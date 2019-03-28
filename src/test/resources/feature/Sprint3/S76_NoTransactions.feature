@HK @SG @UK
@Epic_GPBM-1022(Transactions)
@Story_GPBM-991 @Sprint3_iOS
@Story_GPBM-1359 @Sprint3_aOS

Feature: Client has no Transactions

  As a client I want to see the individual holdings that make up my exposure to each geographical region within each Account,
  so that I know which holdings to review in order to change my regional exposure as desired

  userN: has no transactions user

  @S76-AC1-AT1
  Scenario: Check the message information when client has no transactions in portfolio
    Given I login as type "no_transactions"
#    When I tap four item of Accounts list
#    And I tap last item of Portfolios list
    And I tap the Transactions button
    Then I should see the following message is displayed in the transactions tab:
      | element name           | element value                                              |
      | UK transaction content | There are no transactions available within this portfolio. |
      | transaction content    | There are no transactions available within this portfolio. |
    And no transactions are displayed


  # Android sprint3 not has pips
#  @S76-AC1-AT2
#  Scenario: Check the following message at the Transactions page in Portfolio Level when there is no any transactions and swipe the top pips
#    Given I login as User
#      | element name | element value |
#      | Name         | userN         |
#    And I tap four item of Accounts list
#    And I tap fifteen item of Portfolios list
#    When I tap the Transactions button
#    And I swipe right the top pips
#    Then I should see the following message is displayed in the transactions tab:
#      | element name        | element value                                                          |
#      | transaction content | There are no transaction available of this type within this Portfolio. |
#    And no transactions are displayed


