@HK @SG @UK
@Epic_GPBM-1094(Holdings)
@Story_GPBM-1728 @Sprint5_iOS
@Story_GPBM-1814 @Sprint5_aOS

Feature: Holdings details - Direct Investments (Private Equity), Promemoria and Other
  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @SIT
  Scenario: login in as userM for GPBM1728
    Given I login as type "portfolio_holding_detail_direct_investments_(Private_Equity)_promemoria_and_other"
    Then I should on the Portfolios Holdings Details level

  @S214-AC1-AT1
  @DependsOn('login_in_as_userM_for_GPBM1728')
  Scenario:Check the UI of Holdings detail page for Direct Investments (Private Equity), Pro Memoria and Other holdings
    Given I am on the Portfolios Holdings Details level
#    When I taps on a holding in the holdings list which belongs to one of the following sub-asset classes:
#  Direct Investments (Private Equity) - 10
#  Promemoria - 74
#  Others - 31
    Then I am taken to a detailed holdings direct investments screen displaying the following data:
      | element name                                       | element value                                                                                                                                                                                                                       |
      | Holding name value                                 |                                                                                                                                                                                                                                     |
      | Reference value                                    |                                                                                                                                                                                                                                     |
      | "Total amount" label                               | Total amount                                                                                                                                                                                                                        |
      | Total amount value in holding currency             |                                                                                                                                                                                                                                     |
      | Total amount value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | Disclaimer                                         | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |

  @S214-AC1-AT2
  @SIT
  @DependsOn('login_in_as_userM_for_GPBM1728')
  Scenario:Check the ISO 3 format of holding currency and portfolio referebce currency in Holdings detail page for Direct Investments (Private Equity), Pro Memoria and Other holdings
    Given I am on the Portfolios Holdings Details level
    Then I should see the holdings direct investments following ISO 3 format datas:holding currency、portfolio reference currency
