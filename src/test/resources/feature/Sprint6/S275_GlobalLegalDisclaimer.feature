@Epic_GPBM-459(More_Menu)
@Story_GPBM-483 @Sprint6_iOS
@Story_GPBM-2152 @Sprint6_aOS

Feature: Global legal overlay calculated value

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

#  Reason: can not check the effect of overlay appears is full of screen
#  Scenario: Check the Access link to legal overlay calculated value when I tap on "tap here" link to legal overlay calculated value in the bottom of Account list
#    Given client is logged in
#    When client taps on "tap here" link to legal overlay calculated value in the bottom of Account list
#    Then client will see an overlay showing the overlay calculated value text in full screen

#  Reason: can not check the effect of overlay appears is full of screen
#  Scenario: Check the Access link to legal overlay calculated value when I tap on "tap here" link to legal overlay calculated value in the bottom of Portfolio list
#    Given client is logged in
#    When client taps on "tap here" link to legal overlay calculated value in the bottom of portfolio list
#    Then client will see an overlay showing the overlay calculated value text in full screen

#  Reason: can not check the effect of overlay appears is full of screen
#  Scenario: Check the Access link to legal overlay calculated value when I tap on "tap here" link to legal overlay calculated value in the bottom of holding list
#    Given client is logged in
#    When client taps on "tap here" link to legal overlay calculated value in the bottom of holding list
#    Then client will see an overlay showing the overlay calculated value text in full screen

#  Reason: can not check the effect of overlay appears is full of screen
#  Scenario: Check the Access link to legal overlay calculated value when I tap on "tap here" link to legal overlay calculated value in the bottom of transaction list
#    Given client is logged in
#    When client taps on "tap here" link to legal overlay calculated value in the bottom of transaction list
#    Then client will see an overlay showing the overlay calculated value text in full screen

#  Reason: can not check the effect of overlay appears is full of screen
#  Scenario: Check the Access link to legal overlay calculated value when I tap on "tap here" link to legal overlay calculated value in the bottom of liability list
#    Given client is logged in
#    When client taps on "tap here" link to legal overlay calculated value in the bottom of liability list
#    Then client will see an overlay showing the overlay calculated value text in full screen

# Read the disclaimer update to Disclaimer for copy update UK
  ###############   Account list overlay calculated value   ################
  @HK @SG @UK
  @S275-AC1-AT1
  Scenario:Check the overlay calculated value at the end of account list at Overview level
    Given I login as type "has_account"
    Then I can see the "SG_HK_UK" Overview following link to a legal overlay calculated value:"Read the disclaimer_Read the disclaimer_Disclaimer"
    And I taps on overview "tap here" link to legal overlay calculated value
#    And "tap here" is a hyperlink to a full screen takeover showing the overlay calculated value text

  @HK @SG @UK
  @S275-AC1-AT2
  @DependsOn('Check_the_overlay_calculated_value_at_the_end_of_account_list_at_Overview_level')
  Scenario:Check Access link to legal overlay calculated value within the bottom of account list
    Given I am on the overview performance overlay
    Then I will see a full screen takeover showing the following global legal UI
      | element region | element name    | element value                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
      |                | overlay title   | Disclaimer                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
      | UK             | overlay content | This is not an official valuation from your Custodian(s) and is for information purposes only. It is in addition to your regular valuations as required by the Financial Conduct Authority. In the event that values contained herein are different from those shown on your regular statement provided by your Custodian(s), those supplied by your Custodian(s) will prevail. The value of investments can go down in value as well as up, so you could get back less than you invest. Past performance is not a reliable indicator of future performance. If you have any questions regarding any of the information contained within this app, please contact your relationship management team. HSBC Private Bank (UK) Limited is authorised by the Prudential Regulation Authority and regulated by the Financial Conduct Authority and the Prudential Regulation Authority.  |
      | HK             | overlay content | This is not an official valuation from your Custodian(s) and is for information purposes only. It is in addition to your regular valuations as required by the Financial Conduct Authority. In the event that values contained herein are different from those shown on your regular statement provided by your Custodian(s), those supplied by your Custodian(s) will prevail. The value of investments can go down in value as well as up, so you could get back less than you invest. Past performance is not a reliable indicator of future performance. If you have any questions regarding any of the information contained within this app, please contact your relationship management team. HSBC Private Bank (HK) Limited is authorised by the Prudential Regulation Authority and regulated by the Financial Conduct Authority and the Prudential Regulation Authority. |
      | SG             | overlay content | This is not an official valuation from your Custodian(s) and is for information purposes only. It is in addition to your regular valuations as required by the Financial Conduct Authority. In the event that values contained herein are different from those shown on your regular statement provided by your Custodian(s), those supplied by your Custodian(s) will prevail. The value of investments can go down in value as well as up, so you could get back less than you invest. Past performance is not a reliable indicator of future performance. If you have any questions regarding any of the information contained within this app, please contact your relationship management team. HSBC Private Bank (SG) Limited is authorised by the Prudential Regulation Authority and regulated by the Financial Conduct Authority and the Prudential Regulation Authority. |
      |                | close button    |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |

  @HK @SG @UK
  @S275-AC1-AT3
  @DependsOn('Check_the_overlay_calculated_value_at_the_end_of_account_list_at_Overview_level')
  Scenario:Check Exit legal Overview overlay calculated value screen
    Given I am on the disclaimer overlay
    When I tap on close button in global legal overlay calculated value
    Then I should return to the screen they were on when they tapped "tap here" to access the overview legal overlay calculated value screen


  ###############   Portfolio list overlay calculated value   ################
  @HK @SG @UK
  @S275-AC2-AT1
  Scenario:Check the overlay calculated value at the end of Portfolio list at Account level
    Given I login as type "has_account"
    When I tap first item of Accounts list
    And I am viewing the end of Portfolio list
    Then I can see the "SG_HK_UK" Account following link to a legal overlay calculated value:"Read the disclaimer_Read the disclaimer_Disclaimer"
    And I taps on account "tap here" link to legal overlay calculated value
#    And "tap here" is a hyperlink to a full screen takeover showing the overlay calculated value text

  @HK @SG @UK
  @S275-AC2-AT2
  @DependsOn('Check_the_overlay_calculated_value_at_the_end_of_Portfolio_list_at_Account_level')
  Scenario:Check Access link to legal overlay calculated value within the bottom of portfolio list
    Given I am on the disclaimer overlay
    Then I will see a full screen takeover showing the following global legal UI
      | element region | element name    | element value                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
      |                | overlay title   | Disclaimer                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |
      | UK             | overlay content | This is not an official valuation from your Custodian(s) and is for information purposes only. It is in addition to your regular valuations as required by the Financial Conduct Authority. In the event that values contained herein are different from those shown on your regular statement provided by your Custodian(s), those supplied by your Custodian(s) will prevail. The value of investments can go down in value as well as up, so you could get back less than you invest. Past performance is not a reliable indicator of future performance. If you have any questions regarding any of the information contained within this app, please contact your relationship management team. HSBC Private Bank (UK) Limited is authorised by the Prudential Regulation Authority and regulated by the Financial Conduct Authority and the Prudential Regulation Authority. |
      | HK             | overlay content | This is not an official valuation from your Custodian(s) and is for information purposes only. It is in addition to your regular valuations as required by the Financial Conduct Authority. In the event that values contained herein are different from those shown on your regular statement provided by your Custodian(s), those supplied by your Custodian(s) will prevail. The value of investments can go down in value as well as up, so you could get back less than you invest. Past performance is not a reliable indicator of future performance. If you have any questions regarding any of the information contained within this app, please contact your relationship management team. HSBC Private Bank (HK) Limited is authorised by the Prudential Regulation Authority and regulated by the Financial Conduct Authority and the Prudential Regulation Authority. |
      | SG             | overlay content | This is not an official valuation from your Custodian(s) and is for information purposes only. It is in addition to your regular valuations as required by the Financial Conduct Authority. In the event that values contained herein are different from those shown on your regular statement provided by your Custodian(s), those supplied by your Custodian(s) will prevail. The value of investments can go down in value as well as up, so you could get back less than you invest. Past performance is not a reliable indicator of future performance. If you have any questions regarding any of the information contained within this app, please contact your relationship management team. HSBC Private Bank (SG) Limited is authorised by the Prudential Regulation Authority and regulated by the Financial Conduct Authority and the Prudential Regulation Authority. |
      |                | close button    |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |

  @HK @SG @UK
  @S275-AC2-AT3
  @DependsOn('Check_the_overlay_calculated_value_at_the_end_of_Portfolio_list_at_Account_level')
  Scenario:Check Exit Account legal overlay calculated value screen
    Given I am on the disclaimer overlay
    When I tap on close button in global legal overlay calculated value
    Then I should return to the screen they were on when they tapped "tap here" to portfolio list access the legal overlay calculated value screen

  ###############   Portfolio holding list overlay calculated value   ################
  @HK @SG @UK
  @S275-AC3-AT1
  Scenario:Check the overlay calculated value at the end of holding list at Portfolio level
    Given I login as type "more_portfolio"
    And I tap first item of Portfolios list
    And I am viewing the end of Holding list
    Then I can see the "SG_HK_UK" Holding list following link to a legal overlay calculated value:"Read the disclaimer_Read the disclaimer_Disclaimer"
    And I taps on portfolio holding list "tap here" link to legal overlay calculated value
#    And "tap here" is a hyperlink to a full screen takeover showing the overlay calculated value text

  @HK @SG @UK
  @S275-AC3-AT2
  @DependsOn('Check_the_overlay_calculated_value_at_the_end_of_holding_list_at_Portfolio_level')
  Scenario:Check Access link to legal overlay calculated value within the bottom of portfolio holding list
    Given I am on the disclaimer overlay
    Then I will see a full screen takeover showing the following global legal UI
      | element region | element name    | element value                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
      |                | overlay title   | Disclaimer                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
      | UK             | overlay content | This is not an official valuation from your Custodian(s) and is for information purposes only. It is in addition to your regular valuations as required by the Financial Conduct Authority. In the event that values contained herein are different from those shown on your regular statement provided by your Custodian(s), those supplied by your Custodian(s) will prevail. The value of investments can go down in value as well as up, so you could get back less than you invest. Past performance is not a reliable indicator of future performance. If you have any questions regarding any of the information contained within this app, please contact your relationship management team. HSBC Private Bank (UK) Limited is authorised by the Prudential Regulation Authority and regulated by the Financial Conduct Authority and the Prudential Regulation Authority. |
      | HK             | overlay content | This is not an official valuation from your Custodian(s) and is for information purposes only. It is in addition to your regular valuations as required by the Financial Conduct Authority. In the event that values contained herein are different from those shown on your regular statement provided by your Custodian(s), those supplied by your Custodian(s) will prevail. The value of investments can go down in value as well as up, so you could get back less than you invest. Past performance is not a reliable indicator of future performance. If you have any questions regarding any of the information contained within this app, please contact your relationship management team. HSBC Private Bank (HK) Limited is authorised by the Prudential Regulation Authority and regulated by the Financial Conduct Authority and the Prudential Regulation Authority. |
      | SG             | overlay content | This is not an official valuation from your Custodian(s) and is for information purposes only. It is in addition to your regular valuations as required by the Financial Conduct Authority. In the event that values contained herein are different from those shown on your regular statement provided by your Custodian(s), those supplied by your Custodian(s) will prevail. The value of investments can go down in value as well as up, so you could get back less than you invest. Past performance is not a reliable indicator of future performance. If you have any questions regarding any of the information contained within this app, please contact your relationship management team. HSBC Private Bank (SG) Limited is authorised by the Prudential Regulation Authority and regulated by the Financial Conduct Authority and the Prudential Regulation Authority. |
      |                | close button    |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |

  @HK @SG @UK
  @S275-AC3-AT3
  @DependsOn('Check_the_overlay_calculated_value_at_the_end_of_holding_list_at_Portfolio_level')
  Scenario:Check Exit portfolio holding list legal overlay calculated value screen
    Given I am on the disclaimer overlay
    When I tap on close button in global legal overlay calculated value
    Then I should return to the screen they were on when they tapped "tap here" to portfolio holding list access the legal overlay calculated value screen
    
    
  ###############   Portfolio transaction list overlay calculated value   ################
  @HK @SG @UK
  @S275-AC4-AT1
  Scenario:Check the overlay calculated value at the end of Transaction list at Portfolio level
    Given I login as type "more_portfolio"
    When I tap first item of Portfolios list
    And I tap the Transactions button
    And I am viewing the end of Transaction list at Portfolio level
    Then I can see the "SG_HK_UK" Transaction list following link to a legal overlay calculated value:"Read the disclaimer_Read the disclaimer_Disclaimer"
    And I taps on portfolio transactions list "tap here" link to legal overlay calculated value
#    And "tap here" is a hyperlink to a full screen takeover showing the overlay calculated value text

  @HK @SG @UK
  @S275-AC4-AT2
  @DependsOn('Check_the_overlay_calculated_value_at_the_end_of_Transaction_list_at_Portfolio_level')
  Scenario:Check Access link to legal overlay calculated value within the bottom of portfolio transaction list
    Given I am on the disclaimer overlay
    Then I will see a full screen takeover showing the following global legal UI
      | element region | element name    | element value                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
      |                | overlay title   | Disclaimer                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
      | UK             | overlay content | This is not an official valuation from your Custodian(s) and is for information purposes only. It is in addition to your regular valuations as required by the Financial Conduct Authority. In the event that values contained herein are different from those shown on your regular statement provided by your Custodian(s), those supplied by your Custodian(s) will prevail. The value of investments can go down in value as well as up, so you could get back less than you invest. Past performance is not a reliable indicator of future performance. If you have any questions regarding any of the information contained within this app, please contact your relationship management team. HSBC Private Bank (UK) Limited is authorised by the Prudential Regulation Authority and regulated by the Financial Conduct Authority and the Prudential Regulation Authority. |
      | HK             | overlay content | This is not an official valuation from your Custodian(s) and is for information purposes only. It is in addition to your regular valuations as required by the Financial Conduct Authority. In the event that values contained herein are different from those shown on your regular statement provided by your Custodian(s), those supplied by your Custodian(s) will prevail. The value of investments can go down in value as well as up, so you could get back less than you invest. Past performance is not a reliable indicator of future performance. If you have any questions regarding any of the information contained within this app, please contact your relationship management team. HSBC Private Bank (HK) Limited is authorised by the Prudential Regulation Authority and regulated by the Financial Conduct Authority and the Prudential Regulation Authority. |
      | SG             | overlay content | This is not an official valuation from your Custodian(s) and is for information purposes only. It is in addition to your regular valuations as required by the Financial Conduct Authority. In the event that values contained herein are different from those shown on your regular statement provided by your Custodian(s), those supplied by your Custodian(s) will prevail. The value of investments can go down in value as well as up, so you could get back less than you invest. Past performance is not a reliable indicator of future performance. If you have any questions regarding any of the information contained within this app, please contact your relationship management team. HSBC Private Bank (SG) Limited is authorised by the Prudential Regulation Authority and regulated by the Financial Conduct Authority and the Prudential Regulation Authority. |
      |                | close button    |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |

  @HK @SG @UK
  @S275-AC4-AT3
  @DependsOn('Check_the_overlay_calculated_value_at_the_end_of_Transaction_list_at_Portfolio_level')
  Scenario:Check Exit portfolio transaction list legal overlay calculated value screen
    Given I am on the disclaimer overlay
    When I tap on close button in global legal overlay calculated value
    Then I should return to the screen they were on when they tapped "tap here" to portfolio transaction list access the legal overlay calculated value screen



  ###############   Portfolio liability list overlay calculated value   ################
  @HK @SG
  @S275-AC5-AT1
  Scenario:Check the overlay calculated value at the end of Liability list at Portfolio level
    Given I login as type "more_portfolio"
    When I tap first item of Portfolios list
    And I tap on portfolio "Liabilities" tab
    And I am viewing the end of Liability list at Portfolio level
    Then I can see the "SG_HK_UK" Liability list following link to a legal overlay calculated value:"Read the disclaimer_Read the disclaimer_Disclaimer"
    And I taps on portfolio liabilities list "tap here" link to legal overlay calculated value
#    And "tap here" is a hyperlink to a full screen takeover showing the overlay calculated value text

  @HK @SG
  @S275-AC5-AT2
  @DependsOn('Check_the_overlay_calculated_value_at_the_end_of_Liability_list_at_Portfolio_level')
  Scenario:Check Access link to legal overlay calculated value within the bottom of portfolio liability list
    Given I am on the disclaimer overlay
    Then I will see a full screen takeover showing the following global legal UI
      | element region | element name    | element value                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
      |                | overlay title   | Disclaimer                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
      | UK             | overlay content | This is not an official valuation from your Custodian(s) and is for information purposes only. It is in addition to your regular valuations as required by the Financial Conduct Authority. In the event that values contained herein are different from those shown on your regular statement provided by your Custodian(s), those supplied by your Custodian(s) will prevail. The value of investments can go down in value as well as up, so you could get back less than you invest. Past performance is not a reliable indicator of future performance. If you have any questions regarding any of the information contained within this app, please contact your relationship management team. HSBC Private Bank (UK) Limited is authorised by the Prudential Regulation Authority and regulated by the Financial Conduct Authority and the Prudential Regulation Authority. |
      | HK             | overlay content | This is not an official valuation from your Custodian(s) and is for information purposes only. It is in addition to your regular valuations as required by the Financial Conduct Authority. In the event that values contained herein are different from those shown on your regular statement provided by your Custodian(s), those supplied by your Custodian(s) will prevail. The value of investments can go down in value as well as up, so you could get back less than you invest. Past performance is not a reliable indicator of future performance. If you have any questions regarding any of the information contained within this app, please contact your relationship management team. HSBC Private Bank (HK) Limited is authorised by the Prudential Regulation Authority and regulated by the Financial Conduct Authority and the Prudential Regulation Authority. |
      | SG             | overlay content | This is not an official valuation from your Custodian(s) and is for information purposes only. It is in addition to your regular valuations as required by the Financial Conduct Authority. In the event that values contained herein are different from those shown on your regular statement provided by your Custodian(s), those supplied by your Custodian(s) will prevail. The value of investments can go down in value as well as up, so you could get back less than you invest. Past performance is not a reliable indicator of future performance. If you have any questions regarding any of the information contained within this app, please contact your relationship management team. HSBC Private Bank (SG) Limited is authorised by the Prudential Regulation Authority and regulated by the Financial Conduct Authority and the Prudential Regulation Authority. |
      |                | close button    |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |

  @HK @SG
  @S275-AC5-AT3
  @DependsOn('Check_the_overlay_calculated_value_at_the_end_of_Liability_list_at_Portfolio_level')
  Scenario:Check Exit portfolio liability list legal overlay calculated value screen
    Given I am on the disclaimer overlay
    When I tap on close button in global legal overlay calculated value
    Then I should return to the screen they were on when they tapped "tap here" to portfolio liability access the legal overlay calculated value screen


# update in Sprint10
#  @S275-AC3-AT2
#  Scenario:Check Exit link to legal overlay calculated value when I tap anywhere on the screen outside of the global legal overlay calculated value
#    Given I login as User
#      | element name | element value |
#      | Name         | userE         |
#      | password     | 123           |
#    When I taps on "tap here" link to legal overlay calculated value
#    And I tap on any where in global legal overlay calculated value
#    Then I should return to the screen they were on when they tapped "tap here" to access the legal overlay calculated value screen