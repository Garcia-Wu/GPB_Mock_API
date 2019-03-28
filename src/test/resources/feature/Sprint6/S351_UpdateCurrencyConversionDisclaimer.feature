@HK @SG @UK
@Epic_GPBM-411(Reporting_Currency_&_Conversion_Rates)
@Story_GPBM-2253 @Sprint6_iOS
@Story_GPBM-2254 @Sprint6_aOS

Feature: Currency Conversion (update disclaimer)

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S351-AC1-AT1
  Scenario:Check disclaimer in Overview currency conversion
    Given I login as type "overview_currency_conversation_overlay_no_wrong_message"
    When I tap on overview "Currency Conversion" icon
    Then they should see the overview following disclaimer:
      | element name | element value                                                                                                                                                  |
      | disclaimer   | Exchange rates are rounded to 4 decimal places and are based on a daily rate set by HSBC. They should not be used in isolation to make investment decisions. |

  @S351-AC1-AT2
  Scenario:Check disclaimer in Account currency conversion
    Given I login as type "account_currency_conversation_overlay_no_wrong_message"
    When I tap on account "Currency Conversion" icon
    Then they should see the account following disclaimer:
      | element name | element value                                                                                                                                                  |
      | disclaimer   | Exchange rates are rounded to 4 decimal places and are based on a daily rate set by HSBC. They should not be used in isolation to make investment decisions. |

  @S351-AC1-AT3
  Scenario:Check disclaimer in Portfolio currency conversion
    Given I login as type "portfolio_currency_conversation_overlay_no_wrong_message"
    When I tap on portfolio "Currency Conversion" icon
    Then they should see the portfolio following disclaimer:
      | element name | element value                                                                                                                                                  |
      | disclaimer   | Exchange rates are rounded to 4 decimal places and are based on a daily rate set by HSBC. They should not be used in isolation to make investment decisions. |
