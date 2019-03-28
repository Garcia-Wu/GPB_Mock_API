@HK @SG @UK
@Epic_GPBM-1094(Holdings)
@Story_GPBM-1810 @Sprint5_iOS
@Story_GPBM-1729 @Sprint5_aOS

Feature: Holdings details - Metal ounces
  As a Client I want to see a detailed view regarding my metal ounces holdings,
  so that I can see all related information about the particular holding.

  @SIT
  Scenario: login in as userM for GPBM1810
    Given I login as type "portfolio_holding_detail_metal_ounces"
    Then I should on the Portfolios Holdings Details level

  @S212-AC1-AT1
  @DependsOn('login_in_as_userM_for_GPBM1810')
  Scenario:Check the UI of Holdings detail page for metal ounces
    Given I am on the Portfolios Holdings Details level
#    When I taps on a holding in the holdings list which belongs to one of the following sub-asset classes:
#  Metal Ounces - 59
    Then I am taken to a detailed holdings metal ounces screen displaying the following data:
      | element name                                 | element value                                                                                                                                                                                                                       |
      | Holding name value                           |                                                                                                                                                                                                                                     |
      | Any reference value                          |                                                                                                                                                                                                                                     |
      | "Quantity" label                             | Quantity                                                                                                                                                                                                                            |
      | Quantity value                               |                                                                                                                                                                                                                                     |
      | "Total value" label                         | Total value                                                                                                                                                                                                                        |
      | Market value in portfolio reference currency |                                                                                                                                                                                                                                     |
      | "Disclaimer" label                           | The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction. Please refer to your transaction advice for related fees information. |


  @S212-AC1-AT2
  @SIT
  @DependsOn('login_in_as_userM_for_GPBM1810')
  Scenario:Check the ISO 3 format of portfolio reference currency in Holdings detail page for metal ounces
    Given I am on the Portfolios Holdings Details level
    Then I should see the holdings metal ounces following ISO 3 format datas:holding currency、portfolio reference currency

