@HK @SG @UK
@Epic_GPBM-1094(Holdings)
@Story_GPBM-1700 @Sprint5_iOS
@Story_GPBM-1739 @Sprint5_aOS

Feature: Holdings details - Current Accounts, Blocked Current Accounts
  As a Client I want to see a detailed view regarding my current account and blocked current account holdings,
  so that I can see all related information about the particular holding.

  @SIT
  Scenario: login in as userM for GPBM1700
    Given I login as type "portfolio_holding_detail_current_accounts_blocked_current_accounts"
    Then I should on the Portfolios Holdings Details level

  @S211-AC1-AT1
  @DependsOn('login_in_as_userM_for_GPBM1700')
  Scenario:Check the UI of Holdings detail page for current accounts or blocked current accounts
    Given I am on the Portfolios Holdings Details level
#    When I taps on a holding in the holdings list which belongs to one of the following sub-asset classes:
#  Current accounts - 58
#  Blocked current accounts - 60
    Then I am taken to a detailed holdings current accounts screen displaying the following data:
      | element name                                                  | element value                                                                                                                                                                                                                       |
      | Holding name value                                            |                                                                                                                                                                                                                                     |
      | Any reference values                                          |                                                                                                                                                                                                                                     |
      | "Balance" label                                               | Balance                                                                                                                                                                                                                             |
      | Balance value in holding currency                             |                                                                                                                                                                                                                                     |
      | Balance value in portfolio reference currency within brackets |                                                                                                                                                                                                                                     |
      | Disclaimer                                                    | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |


  @S211-AC1-AT2
  @SIT
  @DependsOn('login_in_as_userM_for_GPBM1700')
  Scenario:Check the ISO 3 format of holding currency and portfolio reference currency in Holdings detail page for current accounts or blocked current accounts
    Given I am on the Portfolios Holdings Details level
    Then I should see the holdings current accounts, blocked current accounts following ISO 3 format datas:holding currency、reference currency、Balance value in holding currency、Balance value in portfolio reference currency