@HK @SG @UK
@Epic_GPBM-411(Reporting_Currency_&_Conversion_Rates)
@Story_GPBM-3377 @Sprint11_iOS
@Story_GPBM-3378 @Sprint11_aOS

Feature: Exchange rate error design updates

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

#  Overview level

#  @S560-AC1-AT1
#  Scenario: Check Retrieval of exchange rate date fails in Overview level
#    Given I am viewing "Exchange rates" overlay at Overview level
##    And currency exchange rates are not retrievable from Avaloq
#    When I tap on "Exchange rates" icon
#    Then I should see the following message should be displayed instead of showing the list of exchange rates inrelation to the Reporting/Base currency shown
#  "The latest exchange rates are currently unavailable.Please contact your relationship management team for this information."
#    And an alert icon is displayed

  @S560-AC1-AT2
  Scenario: Check Retrieval of exchange rate date fails in Overview Asset Class holding wrapper
    Given I login as type "overview_class_exchange_rate_no_retrievable_from_Avaloq"
    When I taps on allocation holding "Exchange rates" icon
    Then The following message on allocation holding screen should be displayed instead of showing the list of exchange rates
      | element name              | element value                                                                                                              |
      | Currency Conversion title | Exchange rates                                                                                                             |
      | Base currency title       | Base currency                                                                                                              |
      | the default currency      |                                                                                                                            |
      | 1.0 value                 | 1.0                                                                                                                        |
      | Base national flag        |                                                                                                                            |
      | "X" button                |                                                                                                                            |
      | wrong icon image          |                                                                                                                            |
      | wrong message text        | The latest exchange rates are currently unavailable.Please contact your relationship management team for this information. |

  @S560-AC1-AT3
  Scenario: Check Retrieval of exchange rate date fails in Overview Sub Asset Class holding wrapper
    Given I login as type "overview_subClass_exchange_rate_no_retrievable_from_Avaloq"
    When I taps on allocation holding "Exchange rates" icon
    Then The following message on allocation holding screen should be displayed instead of showing the list of exchange rates
      | element name              | element value                                                                                                              |
      | Currency Conversion title | Exchange rates                                                                                                             |
      | Base currency title       | Base currency                                                                                                              |
      | the default currency      |                                                                                                                            |
      | 1.0 value                 | 1.0                                                                                                                        |
      | Base national flag        |                                                                                                                            |
      | "X" button                |                                                                                                                            |
      | wrong icon image          |                                                                                                                            |
      | wrong message text        | The latest exchange rates are currently unavailable.Please contact your relationship management team for this information. |

  @S560-AC1-AT4
  Scenario: Check Retrieval of exchange rate date fails in Overview Currency holding wrapper
    Given I login as type "overview_currency_exchange_rate_no_retrievable_from_Avaloq"
    When I taps on allocation holding "Exchange rates" icon
    Then The following message on allocation holding screen should be displayed instead of showing the list of exchange rates
      | element name              | element value                                                                                                              |
      | Currency Conversion title | Exchange rates                                                                                                             |
      | Base currency title       | Base currency                                                                                                              |
      | the default currency      |                                                                                                                            |
      | 1.0 value                 | 1.0                                                                                                                        |
      | Base national flag        |                                                                                                                            |
      | "X" button                |                                                                                                                            |
      | wrong icon image          |                                                                                                                            |
      | wrong message text        | The latest exchange rates are currently unavailable.Please contact your relationship management team for this information. |


  @S560-AC1-AT5
  Scenario: Check Retrieval of exchange rate date fails in Overview Region holding wrapper
    Given I login as type "overview_region_exchange_rate_no_retrievable_from_Avaloq"
    When I taps on allocation holding "Exchange rates" icon
    Then The following message on allocation holding screen should be displayed instead of showing the list of exchange rates
      | element name              | element value                                                                                                              |
      | Currency Conversion title | Exchange rates                                                                                                             |
      | Base currency title       | Base currency                                                                                                              |
      | the default currency      |                                                                                                                            |
      | 1.0 value                 | 1.0                                                                                                                        |
      | Base national flag        |                                                                                                                            |
      | "X" button                |                                                                                                                            |
      | wrong icon image          |                                                                                                                            |
      | wrong message text        | The latest exchange rates are currently unavailable.Please contact your relationship management team for this information. |


#  Account level

#  @S560-AC1-AT6
#  Scenario: Check Retrieval of exchange rate date fails in Account level
#    Given I am viewing "Exchange rates" overlay at Account level
##    And currency exchange rates are not retrievable from Avaloq
#    When I tap on "Exchange rates" icon
#    Then I should see the following message should be displayed instead of showing the list of exchange rates inrelation to the Reporting/Base currency shown
#  "The latest exchange rates are currently unavailable.Please contact your relationship management team for this information."
#    And an alert icon is displayed

  @S560-AC1-AT7
  Scenario: Check Retrieval of exchange rate date fails in Account Asset Class holding wrapper
    Given I login as type "account_class_exchange_rate_no_retrievable_from_Avaloq"
    When I taps on allocation holding "Exchange rates" icon
    Then The following message on allocation holding screen should be displayed instead of showing the list of exchange rates
      | element name              | element value                                                                                                              |
      | Currency Conversion title | Exchange rates                                                                                                             |
      | Base currency title       | Base currency                                                                                                              |
      | the default currency      |                                                                                                                            |
      | 1.0 value                 | 1.0                                                                                                                        |
      | Base national flag        |                                                                                                                            |
      | "X" button                |                                                                                                                            |
      | wrong icon image          |                                                                                                                            |
      | wrong message text        | The latest exchange rates are currently unavailable.Please contact your relationship management team for this information. |

  @S560-AC1-AT8
  Scenario: Check Retrieval of exchange rate date fails in Account Sub Asset Class holding wrapper
    Given I login as type "account_subClass_exchange_rate_no_retrievable_from_Avaloq"
    When I taps on allocation holding "Exchange rates" icon
    Then The following message on allocation holding screen should be displayed instead of showing the list of exchange rates
      | element name              | element value                                                                                                              |
      | Currency Conversion title | Exchange rates                                                                                                             |
      | Base currency title       | Base currency                                                                                                              |
      | the default currency      |                                                                                                                            |
      | 1.0 value                 | 1.0                                                                                                                        |
      | Base national flag        |                                                                                                                            |
      | "X" button                |                                                                                                                            |
      | wrong icon image          |                                                                                                                            |
      | wrong message text        | The latest exchange rates are currently unavailable.Please contact your relationship management team for this information. |

  @S560-AC1-AT9
  Scenario: Check Retrieval of exchange rate date fails in Account Currency holding wrapper
    Given I login as type "account_currency_exchange_rate_no_retrievable_from_Avaloq"
    When I taps on allocation holding "Exchange rates" icon
    Then The following message on allocation holding screen should be displayed instead of showing the list of exchange rates
      | element name              | element value                                                                                                              |
      | Currency Conversion title | Exchange rates                                                                                                             |
      | Base currency title       | Base currency                                                                                                              |
      | the default currency      |                                                                                                                            |
      | 1.0 value                 | 1.0                                                                                                                        |
      | Base national flag        |                                                                                                                            |
      | "X" button                |                                                                                                                            |
      | wrong icon image          |                                                                                                                            |
      | wrong message text        | The latest exchange rates are currently unavailable.Please contact your relationship management team for this information. |

  @S560-AC1-AT10
  Scenario: Check Retrieval of exchange rate date fails in Account Region holding wrapper
    Given I login as type "account_region_exchange_rate_no_retrievable_from_Avaloq"
    When I taps on allocation holding "Exchange rates" icon
    Then The following message on allocation holding screen should be displayed instead of showing the list of exchange rates
      | element name              | element value                                                                                                              |
      | Currency Conversion title | Exchange rates                                                                                                             |
      | Base currency title       | Base currency                                                                                                              |
      | the default currency      |                                                                                                                            |
      | 1.0 value                 | 1.0                                                                                                                        |
      | Base national flag        |                                                                                                                            |
      | "X" button                |                                                                                                                            |
      | wrong icon image          |                                                                                                                            |
      | wrong message text        | The latest exchange rates are currently unavailable.Please contact your relationship management team for this information. |

#  Portfolio level

#  @S560-AC1-AT11
#  Scenario: Check Retrieval of exchange rate date fails in Portfolio level
#    Given I am viewing "Exchange rates" overlay at Portfolio level
##    And currency exchange rates are not retrievable from Avaloq
#    When I tap on "Exchange rates" icon
#    Then I should see the following message should be displayed instead of showing the list of exchange rates inrelation to the Reporting/Base currency shown
#  "The latest exchange rates are currently unavailable.Please contact your relationship management team for this information."
#    And an alert icon is displayed

  @S560-AC1-AT12
  Scenario: Check Retrieval of exchange rate date fails in Portfolio Asset Class holding wrapper
    Given I login as type "portfolio_class_exchange_rate_no_retrievable_from_Avaloq"
    When I taps on allocation holding "Exchange rates" icon
    Then The following message on allocation holding screen should be displayed instead of showing the list of exchange rates
      | element name              | element value                                                                                                              |
      | Currency Conversion title | Exchange rates                                                                                                             |
      | Base currency title       | Base currency                                                                                                              |
      | the default currency      |                                                                                                                            |
      | 1.0 value                 | 1.0                                                                                                                        |
      | Base national flag        |                                                                                                                            |
      | "X" button                |                                                                                                                            |
      | wrong icon image          |                                                                                                                            |
      | wrong message text        | The latest exchange rates are currently unavailable.Please contact your relationship management team for this information. |

  @S560-AC1-AT13
  Scenario: Check Retrieval of exchange rate date fails in Portfolio Sub Asset Class holding wrapper
    Given I login as type "portfolio_subClass_exchange_rate_no_retrievable_from_Avaloq"
    When I taps on allocation holding "Exchange rates" icon
    Then The following message on allocation holding screen should be displayed instead of showing the list of exchange rates
      | element name              | element value                                                                                                              |
      | Currency Conversion title | Exchange rates                                                                                                             |
      | Base currency title       | Base currency                                                                                                              |
      | the default currency      |                                                                                                                            |
      | 1.0 value                 | 1.0                                                                                                                        |
      | Base national flag        |                                                                                                                            |
      | "X" button                |                                                                                                                            |
      | wrong icon image          |                                                                                                                            |
      | wrong message text        | The latest exchange rates are currently unavailable.Please contact your relationship management team for this information. |

  @S560-AC1-AT14
  Scenario: Check Retrieval of exchange rate date fails in Portfolio Currency holding wrapper
    Given I login as type "portfolio_currency_exchange_rate_no_retrievable_from_Avaloq"
    When I taps on allocation holding "Exchange rates" icon
    Then The following message on allocation holding screen should be displayed instead of showing the list of exchange rates
      | element name              | element value                                                                                                              |
      | Currency Conversion title | Exchange rates                                                                                                             |
      | Base currency title       | Base currency                                                                                                              |
      | the default currency      |                                                                                                                            |
      | 1.0 value                 | 1.0                                                                                                                        |
      | Base national flag        |                                                                                                                            |
      | "X" button                |                                                                                                                            |
      | wrong icon image          |                                                                                                                            |
      | wrong message text        | The latest exchange rates are currently unavailable.Please contact your relationship management team for this information. |

  @S560-AC1-AT15
  Scenario: Check Retrieval of exchange rate date fails in Portfolio Region holding wrapper
    Given I login as type "portfolio_region_exchange_rate_no_retrievable_from_Avaloq"
    When I taps on allocation holding "Exchange rates" icon
    Then The following message on allocation holding screen should be displayed instead of showing the list of exchange rates
      | element name              | element value                                                                                                              |
      | Currency Conversion title | Exchange rates                                                                                                             |
      | Base currency title       | Base currency                                                                                                              |
      | the default currency      |                                                                                                                            |
      | 1.0 value                 | 1.0                                                                                                                        |
      | Base national flag        |                                                                                                                            |
      | "X" button                |                                                                                                                            |
      | wrong icon image          |                                                                                                                            |
      | wrong message text        | The latest exchange rates are currently unavailable.Please contact your relationship management team for this information. |

#  Overview level
  
#  @S560-AC1-AT16
#  Scenario: Check No currencies to display at Overview level
#    Given I am viewing "Exchange rates" overlay at Overview level
##    And client has no holdings OR last 5 transactions within any of their Accounts
##    And references currency set in Avaloq for all Accounts is "GBP"
##    And references currency set in Avaloq for all Portfolios is "GBP"
#    When I tap on "Exchange rates" icon
#    Then the following message should be displayed instead of showing the list of exchange rates in relation to the Reporting currency shown:
#  "There are no exchange rates to display in relation to your investments."
#    And an alert icon is displayed

  @S560-AC1-AT17
  Scenario: Check No currencies to display at Overview Asset Class holding wrapper
    Given I login as type "overview_class_exchange_rate_no_currencies"
    When I taps on allocation holding "Exchange rates" icon
    Then I should see the following message on allocation holding screen should be displayed instead of showing the list of exchange rates:
      | element name              | element value                                                           |
      | Currency Conversion title | Exchange rates                                                          |
      | Base currency title       | Base currency                                                           |
      | the default currency      |                                                                         |
      | 1.0 value                 | 1.0                                                                     |
      | Base national flag        |                                                                         |
      | "X" button                |                                                                         |
      | wrong icon image          |                                                                         |
      | wrong message text        | There are no exchange rates to display in relation to your investments. |

  @S560-AC1-AT18
  Scenario: Check No currencies to display at Overview Sub Asset Class holding wrapper
    Given I login as type "overview_subClass_exchange_rate_no_currencies"
    When I taps on allocation holding "Exchange rates" icon
    Then I should see the following message on allocation holding screen should be displayed instead of showing the list of exchange rates:
      | element name              | element value                                                           |
      | Currency Conversion title | Exchange rates                                                          |
      | Base currency title       | Base currency                                                           |
      | the default currency      |                                                                         |
      | 1.0 value                 | 1.0                                                                     |
      | Base national flag        |                                                                         |
      | "X" button                |                                                                         |
      | wrong icon image          |                                                                         |
      | wrong message text        | There are no exchange rates to display in relation to your investments. |

  @S560-AC1-AT19
  Scenario: Check No currencies to display at Overview Currency holding wrapper
    Given I login as type "overview_currency_exchange_rate_no_currencies"
    When I taps on allocation holding "Exchange rates" icon
    Then I should see the following message on allocation holding screen should be displayed instead of showing the list of exchange rates:
      | element name              | element value                                                           |
      | Currency Conversion title | Exchange rates                                                          |
      | Base currency title       | Base currency                                                           |
      | the default currency      |                                                                         |
      | 1.0 value                 | 1.0                                                                     |
      | Base national flag        |                                                                         |
      | "X" button                |                                                                         |
      | wrong icon image          |                                                                         |
      | wrong message text        | There are no exchange rates to display in relation to your investments. |

  @S560-AC1-AT20
  Scenario: Check No currencies to display at Overview Region holding wrapper
    Given I login as type "overview_region_exchange_rate_no_currencies"
    When I taps on allocation holding "Exchange rates" icon
    Then I should see the following message on allocation holding screen should be displayed instead of showing the list of exchange rates:
      | element name              | element value                                                           |
      | Currency Conversion title | Exchange rates                                                          |
      | Base currency title       | Base currency                                                           |
      | the default currency      |                                                                         |
      | 1.0 value                 | 1.0                                                                     |
      | Base national flag        |                                                                         |
      | "X" button                |                                                                         |
      | wrong icon image          |                                                                         |
      | wrong message text        | There are no exchange rates to display in relation to your investments. |

#  Account level

#  @S560-AC1-AT21
#  Scenario: Check No currencies to display at Account level
#    Given I am viewing "Exchange rates" overlay at Account level
##    And client has no holdings OR last 5 transactions in any Portfolios within one Account
##    And references currency set in Avaloq for that Accounts is GBP
##    And references currency set in Avaloq for all Portfolios within that Account is GBP
#    When I tap on "Exchange rates" icon
#    Then I should see the following message should be displayed instead of showing the list of exchange rates in relation to the Reporting currency shown:
#  "There are no exchange rates to display in relation to your investments."
#    And an alert icon is displayed

  @S560-AC1-AT22
  Scenario: Check No currencies to display at Account Asset Class holding wrapper
    Given I login as type "account_class_exchange_rate_no_currencies"
    When I taps on allocation holding "Exchange rates" icon
    Then I should see the following message on allocation holding screen should be displayed instead of showing the list of exchange rates:
      | element name              | element value                                                           |
      | Currency Conversion title | Exchange rates                                                          |
      | Base currency title       | Base currency                                                           |
      | the default currency      |                                                                         |
      | 1.0 value                 | 1.0                                                                     |
      | Base national flag        |                                                                         |
      | "X" button                |                                                                         |
      | wrong icon image          |                                                                         |
      | wrong message text        | There are no exchange rates to display in relation to your investments. |

  @S560-AC1-AT23
  Scenario: Check No currencies to display at Account Sub Asset Class holding wrapper
    Given I login as type "account_subClass_exchange_rate_no_currencies"
    When I taps on allocation holding "Exchange rates" icon
    Then I should see the following message on allocation holding screen should be displayed instead of showing the list of exchange rates:
      | element name              | element value                                                           |
      | Currency Conversion title | Exchange rates                                                          |
      | Base currency title       | Base currency                                                           |
      | the default currency      |                                                                         |
      | 1.0 value                 | 1.0                                                                     |
      | Base national flag        |                                                                         |
      | "X" button                |                                                                         |
      | wrong icon image          |                                                                         |
      | wrong message text        | There are no exchange rates to display in relation to your investments. |

  @S560-AC1-AT24
  Scenario: Check No currencies to display at Account Currency holding wrapper
    Given I login as type "account_currency_exchange_rate_no_currencies"
    When I taps on allocation holding "Exchange rates" icon
    Then I should see the following message on allocation holding screen should be displayed instead of showing the list of exchange rates:
      | element name              | element value                                                           |
      | Currency Conversion title | Exchange rates                                                          |
      | Base currency title       | Base currency                                                           |
      | the default currency      |                                                                         |
      | 1.0 value                 | 1.0                                                                     |
      | Base national flag        |                                                                         |
      | "X" button                |                                                                         |
      | wrong icon image          |                                                                         |
      | wrong message text        | There are no exchange rates to display in relation to your investments. |

  @S560-AC1-AT25
  Scenario: Check No currencies to display at Account Region holding wrapper
    Given I login as type "account_region_exchange_rate_no_currencies"
    When I taps on allocation holding "Exchange rates" icon
    Then I should see the following message on allocation holding screen should be displayed instead of showing the list of exchange rates:
      | element name              | element value                                                           |
      | Currency Conversion title | Exchange rates                                                          |
      | Base currency title       | Base currency                                                           |
      | the default currency      |                                                                         |
      | 1.0 value                 | 1.0                                                                     |
      | Base national flag        |                                                                         |
      | "X" button                |                                                                         |
      | wrong icon image          |                                                                         |
      | wrong message text        | There are no exchange rates to display in relation to your investments. |

#  Portfolio level

#  @S560-AC1-AT26
#  Scenario: Check No currencies to display at Portfolio level
#    Given I am viewing "Exchange rates" overlay at Portfolio level
##    And client has no holdings OR last 5 transactions within one Portfolio
##    And references currency set in Avaloq for that Portfolio is GBP
##    And references currency set in Avaloq for the Account that Portfolio belongs to is GBP
#    When I tap on "Exchange rates" icon
#    Then I should see the following message should be displayed instead of showing the list of exchange rates in relation to the Reporting currency shown:
#  "There are no exchange rates to display in relation to your investments."
#    And an alert icon is displayed

  @S560-AC1-AT27
  Scenario: Check No currencies to display at Portfolio Asset Class holding wrapper
    Given I login as type "portfolio_class_exchange_rate_no_currencies"
    When I taps on allocation holding "Exchange rates" icon
    Then I should see the following message on allocation holding screen should be displayed instead of showing the list of exchange rates:
      | element name              | element value                                                           |
      | Currency Conversion title | Exchange rates                                                          |
      | Base currency title       | Base currency                                                           |
      | the default currency      |                                                                         |
      | 1.0 value                 | 1.0                                                                     |
      | Base national flag        |                                                                         |
      | "X" button                |                                                                         |
      | wrong icon image          |                                                                         |
      | wrong message text        | There are no exchange rates to display in relation to your investments. |

  @S560-AC1-AT28
  Scenario: Check No currencies to display at Portfolio Sub Asset Class holding wrapper
    Given I login as type "portfolio_subClass_exchange_rate_no_currencies"
    When I taps on allocation holding "Exchange rates" icon
    Then I should see the following message on allocation holding screen should be displayed instead of showing the list of exchange rates:
      | element name              | element value                                                           |
      | Currency Conversion title | Exchange rates                                                          |
      | Base currency title       | Base currency                                                           |
      | the default currency      |                                                                         |
      | 1.0 value                 | 1.0                                                                     |
      | Base national flag        |                                                                         |
      | "X" button                |                                                                         |
      | wrong icon image          |                                                                         |
      | wrong message text        | There are no exchange rates to display in relation to your investments. |

  @S560-AC1-AT29
  Scenario: Check No currencies to display at Portfolio Currency holding wrapper
    Given I login as type "portfolio_currency_exchange_rate_no_currencies"
    When I taps on allocation holding "Exchange rates" icon
    Then I should see the following message on allocation holding screen should be displayed instead of showing the list of exchange rates:
      | element name              | element value                                                           |
      | Currency Conversion title | Exchange rates                                                          |
      | Base currency title       | Base currency                                                           |
      | the default currency      |                                                                         |
      | 1.0 value                 | 1.0                                                                     |
      | Base national flag        |                                                                         |
      | "X" button                |                                                                         |
      | wrong icon image          |                                                                         |
      | wrong message text        | There are no exchange rates to display in relation to your investments. |

  @S560-AC1-AT30
  Scenario: Check No currencies to display at Portfolio Region holding wrapper
    Given I login as type "portfolio_region_exchange_rate_no_currencies"
    When I taps on allocation holding "Exchange rates" icon
    Then I should see the following message on allocation holding screen should be displayed instead of showing the list of exchange rates:
      | element name              | element value                                                           |
      | Currency Conversion title | Exchange rates                                                          |
      | Base currency title       | Base currency                                                           |
      | the default currency      |                                                                         |
      | 1.0 value                 | 1.0                                                                     |
      | Base national flag        |                                                                         |
      | "X" button                |                                                                         |
      | wrong icon image          |                                                                         |
      | wrong message text        | There are no exchange rates to display in relation to your investments. |