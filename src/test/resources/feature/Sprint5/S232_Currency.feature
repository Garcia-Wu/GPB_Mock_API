@HK @SG @UK
@Epic_GPBM-411(Reporting_Currency_&_Conversion_Rates)
@Story_GPBM-2035 @Sprint5_iOS
@Story_GPBM-2037 @Sprint5_aOS

Feature: Currency

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @SIT
  Scenario: login userE for Conversation overlay UI at Overview Level
    Given I login as type "overview_currency_conversation_overlay_no_wrong_message"
    When I tap on overview "Currency Conversion" icon
    Then I should on the Conversation overlay

  @S232-AC1-AT1
  @DependsOn('login_userE_for_Conversation_overlay_UI_at_Overview_Level')
  Scenario:Check the Conversation overlay UI at Overview Level
    Given I am on the Conversation overlay
    Then I should see the following datas in Conversation overlay:
      | element name                | element value                                                                                        |
      | Currency Conversion title   | Exchange rates                                                                                       |
      | Exchange rates copy content | These exchange rates reflect your holding currencies and are used to calculate all values displayed. |
      | Base currency title         | Base currency                                                                                        |
      | the default currency        |                                                                                                      |
      | 1.0 value                   | 1.0                                                                                                  |
      | Base national flag          |                                                                                                      |
      | "X" button                  |                                                                                                      |
    And a list of each currencies and national flag
    And GPB is NOT shown in the currency list

  @S232-AC1-AT2
  @DependsOn('login_userE_for_Conversation_overlay_UI_at_Overview_Level')
  Scenario:Check whether the latest available exchange rate for each currency compared to GPB shown to 4 decimal places in Currency Conversation overlay at Overview Level
    Given I am on the Conversation overlay
    Then the latest available exchange rate for each currency compared to GPB shown to 4 decimal places

  @S232-AC1-AT3
  @SIT
  @DependsOn('login_userE_for_Conversation_overlay_UI_at_Overview_Level')
  Scenario:Check whether the list of currencies are displayed in alphabetical order in Currency Conversation overlay at Overview Level
    Given I am on the Conversation overlay
    Then I should see the list of currencies are displayed in alphabetical order

  @S232-AC1-AT4
  @SIT
  @DependsOn('login_userE_for_Conversation_overlay_UI_at_Overview_Level')
  Scenario:Check the ISO 3 format of reporting currency in Currency Conversation overlay at Overview Level
    Given I am on the Conversation overlay
    Then I should see Conversation overlay currency in ISO 3 code

  @S232-AC1-AT34
  @DependsOn('login_userE_for_Conversation_overlay_UI_at_Overview_Level')
  Scenario:Check the Disclaimer in Currency Conversation overlay at Overview Level
    Given I am on the Conversation overlay
    Then I should see the overview Conversion overlay following disclaimer:
      | element name       | element value                                                                                                                                                |
      | disclaimer Message | Exchange rates are rounded to 4 decimal places and are based on a daily rate set by HSBC. They should not be used in isolation to make investment decisions. |
    # Remark: cannot check the time zone

  @S232-AC1-AT13
  @DependsOn('login_userE_for_Conversation_overlay_UI_at_Overview_Level')
  Scenario:Check whether the Currency Conversation overlay at Overview level will be closed when I tap on "X"
    Given I am on the Conversation overlay
    When I tap on "X" button in currency Conversation overlay
    Then I should see the Currency Conversion overlay should be closed
#  remove date in sprint 6
#  @S232-AC1-AT35
#  @DependsOn('login_userE_for_Conversation_overlay_UI_at_Overview_Level')
#  Scenario:Check the format of time zone at Overview Level
#    Given I am on the Conversation overlay
#    Then I should see Conversation overlay Updated: dd Mmm yyyy, hh:mm (12 hour clock) Time Zone

  @SIT
  Scenario: login userE for Conversation overlay UI at Account Level
    Given I login as type "account_currency_conversation_overlay_no_wrong_message"
    When I tap on account "Currency Conversion" icon
    Then I should on the Conversation overlay

  @S232-AC1-AT5
  @DependsOn('login_userE_for_Conversation_overlay_UI_at_Account_Level')
  Scenario:Check the Conversation overlay UI at Account Level
    Given I am on the Conversation overlay
    Then I should see the following datas in Conversation overlay:
      | element name                | element value                                                                                                            |
      | Currency Conversion title   | Exchange rates                                                                                                           |
      | Exchange rates copy content | These exchange rates reflect your holding currencies within this account and are used to calculate all values displayed. |
      | Base currency title         | Base currency of account                                                                                                 |
      | the default currency        |                                                                                                                          |
      | 1.0 value                   | 1.0                                                                                                                      |
      | Base national flag          |                                                                                                                          |
      | "X" button                  |                                                                                                                          |
    And a list of each currencies and national flag
    And GPB is NOT shown in the currency list

  @S232-AC1-AT6
  @DependsOn('login_userE_for_Conversation_overlay_UI_at_Account_Level')
  Scenario:Check whether the latest available exchange rate for each currency compared to the Account reference currency shown to 4 decimal places in Currency Conversation overlay at Account Level
    Given I am on the Conversation overlay
    And the latest available exchange rate for each currency compared to GPB shown to 4 decimal places

  @S232-AC1-AT7
  @SIT
  @DependsOn('login_userE_for_Conversation_overlay_UI_at_Account_Level')
  Scenario:Check whether the list of currencies are displayed in alphabetical order in Currency Conversation overlay at Account Level
    Given I am on the Conversation overlay
    Then I should see the list of currencies are displayed in alphabetical order

  @S232-AC1-AT8
  @SIT
  @DependsOn('login_userE_for_Conversation_overlay_UI_at_Account_Level')
  Scenario:Check the ISO 3 format of reporting currency in Currency Conversation overlay at Account Level
    Given I am on the Conversation overlay
    Then I should see Conversation overlay currency in ISO 3 code

  @S232-AC1-AT36
  @DependsOn('login_userE_for_Conversation_overlay_UI_at_Account_Level')
  Scenario:Check the Disclaimer in Currency Conversation overlay at Account Level
    Given I am on the Conversation overlay
    Then I should see the overview Conversion overlay following disclaimer:
      | element name       | element value                                                                                                                                                |
      | disclaimer Message | Exchange rates are rounded to 4 decimal places and are based on a daily rate set by HSBC. They should not be used in isolation to make investment decisions. |
    # Remark: cannot check the time zone

  @S232-AC1-AT14
  @DependsOn('login_userE_for_Conversation_overlay_UI_at_Account_Level')
  Scenario:Check whether the Currency Conversation overlay at Account level will be closed when I tap on "X"
    Given I am on the Conversation overlay
    When I tap on "X" button in currency Conversation overlay
    Then I should see the Currency Conversion overlay should be closed

#  remove date in sprint 6
#  @S232-AC1-AT37
#  @DependsOn('login_userE_for_Conversation_overlay_UI_at_Account_Level')
#  Scenario:Check the format of time zone at Account Level
#    Given I am on the Conversation overlay
#    Then I should see Conversation overlay Updated: dd Mmm yyyy, hh:mm (12 hour clock) Time Zone

  @SIT
  Scenario: login userE for Conversation overlay UI at Portfolio Level
    Given I login as type "portfolio_currency_conversation_overlay_no_wrong_message"
    When I tap on portfolio "Currency Conversion" icon
    Then I should on the Conversation overlay

  @S232-AC1-AT9
  @DependsOn('login_userE_for_Conversation_overlay_UI_at_Portfolio_Level')
  Scenario:Check the Conversation overlay UI at Portfolio Level
    Given I am on the Conversation overlay
    Then I should see the following datas in Conversation overlay:
      | element name                | element value                                                                                                              |
      | Currency Conversion title   | Exchange rates                                                                                                             |
      | Exchange rates copy content | These exchange rates reflect your holding currencies within this portfolio and are used to calculate all values displayed. |
      | Base currency title         | Base currency of portfolio                                                                                                 |
      | the default currency        |                                                                                                                            |
      | 1.0 value                   | 1.0                                                                                                                        |
      | Base national flag          |                                                                                                                            |
      | "X" button                  |                                                                                                                            |
    And a list of each currencies and national flag
    And GPB is NOT shown in the currency list

  @S232-AC1-AT10
  @DependsOn('login_userE_for_Conversation_overlay_UI_at_Portfolio_Level')
  Scenario:Check whether the latest available exchange rate for each currency compared to the Portfolio reference currency shown to 4 decimal places in Currency Conversation overlay at Portfolio Level
    Given I am on the Conversation overlay
    And the latest available exchange rate for each currency compared to GPB shown to 4 decimal places

  @S232-AC1-AT11
  @SIT
  @DependsOn('login_userE_for_Conversation_overlay_UI_at_Portfolio_Level')
  Scenario:Check whether the list of currencies are displayed in alphabetical order in Currency Conversation overlay at Portfolio Level
    Given I am on the Conversation overlay
    Then I should see the list of currencies are displayed in alphabetical order

  @S232-AC1-AT12
  @SIT
  @DependsOn('login_userE_for_Conversation_overlay_UI_at_Portfolio_Level')
  Scenario:Check the ISO 3 format of reporting currency in Currency Conversation overlay at Portfolio Level
    Given I am on the Conversation overlay
    Then I should see Conversation overlay currency in ISO 3 code

  @S232-AC1-AT38
  @DependsOn('login_userE_for_Conversation_overlay_UI_at_Portfolio_Level')
  Scenario:Check the Disclaimer in Currency Conversation overlay at Portfolio Level
    Given I am on the Conversation overlay
    Then I should see the overview Conversion overlay following disclaimer:
      | element name       | element value                                                                                                                                                |
      | disclaimer Message | Exchange rates are rounded to 4 decimal places and are based on a daily rate set by HSBC. They should not be used in isolation to make investment decisions. |
    # Remark: cannot check the time zone

  @S232-AC1-AT15
  @DependsOn('login_userE_for_Conversation_overlay_UI_at_Portfolio_Level')
  Scenario:Check whether the Currency Conversation overlay at Portfolio level will be closed when I tap on "X"
    Given I am on the Conversation overlay
    When I tap on "X" button in currency Conversation overlay
    Then I should see the Currency Conversion overlay should be closed

#  remove date in sprint 6
#  @S232-AC1-AT39
#  @DependsOn('Check_the_Conversation_overlay_UI_at_Portfolio_Level')
#  Scenario:Check the format of time zone at Portfolio Level
#    Given I am on the Conversation overlay
#    Then I should see Conversation overlay Updated: dd Mmm yyyy, hh:mm (12 hour clock) Time Zone

  @NotAutomatable
  Scenario:Check the tipMessage at Overview Level when Retrieval of exchange rate data based on client exposure fails
    When dummy

    #  S-AC1-AT16
    #  Reason: cannot check the Latest available exchange rate

  @NotAutomatable
  Scenario:Check the tipMessage at Account Level when Retrieval of exchange rate data based on client exposure fails
    When dummy

    #  S-AC1-AT17
    #  Reason: cannot check the Latest available exchange rate

  @NotAutomatable
  Scenario:Check the tipMessage at Portfolio Level when Retrieval of exchange rate data based on client exposure fails
    When dummy

    #  S-AC1-AT18
    #  Reason: cannot check the Latest available exchange rate

#  update for sprint11 remove wrong title text
  @S232-AC1-AT19
  Scenario:Check the tipMessage at Overview Level when currency exchange rates are not retrievable from Avaloq
    Given I login as type "overview_currency_conversation_overlay_no_retrievable_from_Avaloq"
    When I tap on overview "Currency Conversion" icon
    Then I should see the following message in Currency Conversion at Overview level:
      | element name              | element value                                                                                                              |
#      | wrong title text      | Currencies unavailable                                                                                                      |
      | Currency Conversion title | Exchange rates                                                                                                             |
      | Base currency title       | Base currency                                                                                                              |
      | the default currency      |                                                                                                                            |
      | 1.0 value                 | 1.0                                                                                                                        |
      | Base national flag        |                                                                                                                            |
      | "X" button                |                                                                                                                            |
      | wrong icon image          |                                                                                                                            |
      | wrong message text        | The latest exchange rates are currently unavailable.Please contact your relationship management team for this information. |


  @S232-AC1-AT20
  Scenario:Check the tipMessage at Account Level when currency exchange rates are not retrievable from Avaloq
    Given I login as type "account_currency_conversation_overlay_no_retrievable_from_Avaloq"
    And I tap on account "Currency Conversion" icon
    Then I should see the following message in Currency Conversion at Account level:
      | element name              | element value                                                                                                              |
#      | wrong title text      | Currencies unavailable                                                                                                      |
      | Currency Conversion title | Exchange rates                                                                                                             |
      | Base currency title       | Base currency of account                                                                                                   |
      | the default currency      |                                                                                                                            |
      | 1.0 value                 | 1.0                                                                                                                        |
      | Base national flag        |                                                                                                                            |
      | "X" button                |                                                                                                                            |
      | wrong icon image          |                                                                                                                            |
      | wrong message text        | The latest exchange rates are currently unavailable.Please contact your relationship management team for this information. |


  @S232-AC1-AT21
  Scenario:Check the tipMessage at Portfolio Level when currency exchange rates are not retrievable from Avaloq
    Given I login as type "portfolio_currency_conversation_overlay_no_retrievable_from_Avaloq"
    And I tap on portfolio "Currency Conversion" icon
    Then I should see the following message in Currency Conversion at portfolio level:
      | element name              | element value                                                                                                              |
#      | wrong title text      | Currencies unavailable                                                                                                      |
      | Currency Conversion title | Exchange rates                                                                                                             |
      | Base currency title       | Base currency of portfolio                                                                                                 |
      | the default currency      |                                                                                                                            |
      | 1.0 value                 | 1.0                                                                                                                        |
      | Base national flag        |                                                                                                                            |
      | "X" button                |                                                                                                                            |
      | wrong icon image          |                                                                                                                            |
      | wrong message text        | The latest exchange rates are currently unavailable.Please contact your relationship management team for this information. |

  @NotAutomatable
  Scenario:Check the Conversation overlay UI at Overview Level(1) when there are no currencies to display
    When dummy

    #  S-AC1-AT22
    #  Reason: cannot check not have a reference currency set in Avaloq

  @NotAutomatable
  @S232-AC1-AT23
  Scenario:Check the ISO 3 format of reporting currency in Currency Conversation overlay at Overview Level(1) when there are no currencies to display
    When dummy

    #  S-AC1-AT23
    #  Reason: cannot check not have a reference currency set in Avaloq

  @SIT
  Scenario: login userF for Conversation overlay UI at Overview Level
    Given  I login as type "overview_currency_conversation_overlay_no_currencies"
    When I tap on overview "Currency Conversion" icon
    Then I should on the Conversation overlay

  @S232-AC1-AT24
  @DependsOn('login_userF_for_Conversation_overlay_UI_at_Overview_Level')
  Scenario: Check the Conversation overlay UI at Overview Level(2) when there are no currencies to display
    Given I am on the Conversation overlay
    Then I should see the following message in Conversation overlay UI at Overview Level(2) when there are no currencies to display:
      | element name              | element value                                                           |
      | Currency Conversion title | Exchange rates                                                          |
      | Base currency title       | Base currency                                                           |
      | the default currency      |                                                                         |
      | 1.0 value                 | 1.0                                                                     |
      | Base national flag        |                                                                         |
      | "X" button                |                                                                         |
#      | wrong title text      | Conversion rates unavailable                                              |
      | wrong icon image          |                                                                         |
      | wrong message text        | There are no exchange rates to display in relation to your investments. |

  @S232-AC1-AT25
  @SIT
  @DependsOn('login_userF_for_Conversation_overlay_UI_at_Overview_Level')
  Scenario:Check the ISO 3 format of reporting currency in Currency Conversation overlay at Overview Level(2) when there are no currencies to display
    Given I am on the Conversation overlay
    Then I should see Conversation overlay currency in ISO 3 code with no currency list


  @NotAutomatable
  Scenario:Check the Conversation overlay UI at Account Level(1) when there are no currencies to display
    When dummy

    #  S-AC1-AT26
    #  Reason: cannot check not have a reference currency set in Avaloq

  @NotAutomatable
  Scenario:Check the ISO 3 format of reporting currency in Currency Conversation overlay at Account Level(1) when there are no currencies to display
    When dummy

    #  S-AC1-AT27
    #  Reason: cannot check not have a reference currency set in Avaloq

  @SIT
  Scenario: login userF for Conversation overlay UI at Account Level
    Given  I login as type "account_currency_conversation_overlay_no_currencies"
    And I tap on account "Currency Conversion" icon
    Then I should on the Conversation overlay

  @S232-AC1-AT28
  @DependsOn('login_userF_for_Conversation_overlay_UI_at_Account_Level')
  Scenario:Check the Conversation overlay UI at Account Level(2) when there are no currencies to display
    Given I am on the Conversation overlay
    Then I should see the following message in Conversation overlay UI at Account Level(2) when there are no currencies to display:
      | element name              | element value                                                           |
      | Currency Conversion title | Exchange rates                                                          |
      | Base currency title       | Base currency of account                                                |
      | the default currency      |                                                                         |
      | 1.0 value                 | 1.0                                                                     |
      | Base national flag        |                                                                         |
      | "X" button                |                                                                         |
#      | wrong title text      | Conversion rates unavailable                                              |
      | wrong icon image          |                                                                         |
      | wrong message text        | There are no exchange rates to display in relation to your investments. |

  @S232-AC1-AT29
  @SIT
  @DependsOn('login_userF_for_Conversation_overlay_UI_at_Account_Level')
  Scenario:Check the ISO 3 format of reporting currency in Currency Conversation overlay at Account Level(2) when there are no currencies to display
    Given I am on the Conversation overlay
    Then I should see Conversation overlay currency in ISO 3 code with no currency list


  @NotAutomatable
  Scenario:Check the Conversation overlay UI at Portfolio Level(1) when there are no currencies to display
    When dummy

    #  S-AC1-AT30
    #  Reason: cannot check not have a reference currency set in Avaloq

  @NotAutomatable
  Scenario:Check the ISO 3 format of reporting currency in Currency Conversation overlay at Portfolio Level(1) when there are no currencies to display
    When dummy

    #  S-AC1-AT31
    #  Reason: cannot check not have a reference currency set in Avaloq

  @SIT
  Scenario: login userF for Conversation overlay UI at Portfolio Level
    Given  I login as type "portfolio_currency_conversation_overlay_no_currencies"
    And I tap on portfolio "Currency Conversion" icon
    Then I should on the Conversation overlay

  @S232-AC1-AT32
  @DependsOn('login_userF_for_Conversation_overlay_UI_at_Portfolio_Level')
  Scenario:Check the Conversation overlay UI at Portfolio Level(2) when there are no currencies to display
    Given I am on the Conversation overlay
    Then I should see the following message in Conversation overlay UI at Portfolio Level(2) when there are no currencies to display:
      | element name              | element value                                                           |
      | Currency Conversion title | Exchange rates                                                          |
      | Base currency title       | Base currency                                                           |
      | the default currency      |                                                                         |
      | 1.0 value                 | 1.0                                                                     |
      | Base national flag        |                                                                         |
      | "X" button                |                                                                         |
#      | wrong title text      | Conversion rates unavailable                                              |
      | wrong icon image          |                                                                         |
      | wrong message text        | There are no exchange rates to display in relation to your investments. |

  @S232-AC1-AT33
  @SIT
  @DependsOn('login_userF_for_Conversation_overlay_UI_at_Portfolio_Level')
  Scenario:Check the ISO 3 format of reporting currency in Currency Conversation overlay at Portfolio Level(2) when there are no currencies to display
    Given I am on the Conversation overlay
    Then I should see Conversation overlay currency in ISO 3 code with no currency list