@NotAutomatable
# Reason：This function has been modified in sprint14 or sprint15
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-360 @Sprint2_iOS
@Story_GPBM-1042 @Sprint2_aOS

Feature: Asset Allocation unavailable

  As a client I want to view an explanation as to why I cannot see my exposure by Asset Class, Currency or Region given I have no holdings to date,
  so that I am not confused as to why I am seeing no data when I tap the Asset Allocation toggle

  @HK @SG @UK
  Scenario: I login as userD for GPBM307
    Given I login as type "no_allocation_on_overview"
    When I tap Asset Overview Allocation toggle
    Then I should see the overview allocation screen

  @HK @SG @UK
  @S30-AC1-AT1
  @DependsOn('I_login_as_userD_for_GPBM307')
  Scenario: Check the message information when client has no holdings at Overview Level Screen Class
    Given I see the overview allocation screen
    Then I should see the following UI Elements on the Overview Class tab
      | element region | element name  | element value                                                                           |
      | HK_SG          | class content | Exposure by Asset Class is unavailable as there are no holdings within your Account(s). |
      | UK             | class content | Exposure by asset class is unavailable as there are no holdings within your account(s). |

  @HK @SG @UK
  @S30-AC1-AT2
  @DependsOn('I_login_as_userD_for_GPBM307')
  Scenario: Check the message information when client has no holdings at Overview Level Screen Currency
    Given I see the overview allocation screen
    When I tap Overview Currency tab
    Then I should see the following UI Elements on the Overview Currency tab
      | element region | element name     | element value                                                                        |
      | HK_SG          | currency content | Exposure by Currency is unavailable as there are no holdings within your Account(s). |
      | UK             | currency content | Exposure by currency is unavailable as there are no holdings within your account(s). |


  @UK
  @S30-AC1-AT3
  @DependsOn('I_login_as_userD_for_GPBM307')
  Scenario: Check the message information when client has no holdings at Overview Level Screen Region
    Given I see the overview allocation screen
    When I tap Overview Region tab
    Then I should see the following UI Elements on the Overview Region tab
      | element region | element name   | element value                                                                      |
      | HK_SG          | region content | Exposure by Region is unavailable as there are no holdings within your Account(s). |
      | UK             | region content | Exposure by region is unavailable as there are no holdings within your account(s). |

  @HK @SG @UK
  Scenario: I login as userH in account level allocation screen for GPBM-307
    Given I login as type "no_allocation_on_account"
#    When I tap last item of Accounts list
    And I tap Accounts Allocation toggle
    Then I should see the account allocation screen

  @HK @SG @UK
  @S30-AC1-AT4
  @DependsOn('I_login_as_userH_in_account_level_allocation_screen_for_GPBM-307')
  Scenario: Check the message information when client has no holdings at Account Level Screen Class
    Given I see the account allocation screen
    Then I should see the following UI Elements on the Accounts Class tab
      | element region | element name  | element value                                                                        |
      | HK_SG          | class content | Exposure by Asset Class is unavailable as there are no holdings within this Account. |
      | UK             | class content | Exposure by asset class is unavailable as there are no holdings within this account. |

  @HK @SG @UK
  @S30-AC1-AT5
  @DependsOn('I_login_as_userH_in_account_level_allocation_screen_for_GPBM-307')
  Scenario: Check the message information when client has no holdings at Account Level Screen Currency
    Given I see the account allocation screen
    When I tap Allocation Currency tab
    Then I should see the following UI Elements on the Accounts Currency tab
      | element region | element name     | element value                                                                     |
      | HK_SG          | currency content | Exposure by Currency is unavailable as there are no holdings within this Account. |
      | UK             | currency content | Exposure by currency is unavailable as there are no holdings within this account. |

  @UK
  @S30-AC1-AT6
  @DependsOn('I_login_as_userH_in_account_level_allocation_screen_for_GPBM-307')
  Scenario: Check the message information when client has no holdings at Account Level Screen Region
    Given I see the account allocation screen
    When I tap Allocation Region tab
    Then I should see the following UI Elements on the Accounts Region tab
      | element region | element name   | element value                                                                   |
      | HK_SG          | region content | Exposure by Region is unavailable as there are no holdings within this Account. |
      | UK             | region content | Exposure by region is unavailable as there are no holdings within this account. |

  @HK @SG @UK
  Scenario: I login as userH in portfolio level allocation screen for GPBM-307
    Given I login as type "no_allocation_on_portfolio"
#    When I tap four item of Accounts list
#    And I tap last item of Portfolios list
    And I tap on the Allocation toggle
    Then I should see the portfolio allocation screen

  @HK @SG @UK
  @S30-AC1-AT7
  @DependsOn('I_login_as_userH_in_portfolio_level_allocation_screen_for_GPBM-307')
  Scenario: Check the message information when client has no holdings at Portfolio Level Screen Class
    Given I see the portfolio allocation screen
    Then I should see the following UI Elements on the Portfolios Class tab
      | element region | element name  | element value                                                                          |
      | HK_SG          | class content | Exposure by Asset Class is unavailable as there are no holdings within this Portfolio. |
      | UK             | class content | Exposure by asset class is unavailable as there are no holdings within this portfolio. |

  @HK @SG @UK
  @S30-AC1-AT8
  @DependsOn('I_login_as_userH_in_portfolio_level_allocation_screen_for_GPBM-307')
  Scenario: Check the message information when client has no holdings at Portfolio Level Screen Currency
    Given I see the portfolio allocation screen
    When I tap Portfolio Currency tab
    Then I should see the following UI Elements on the Portfolio Currency tab
      | element region | element name     | element value                                                                       |
      | HK_SG          | currency content | Exposure by Currency is unavailable as there are no holdings within this Portfolio. |
      | UK             | currency content | Exposure by currency is unavailable as there are no holdings within this portfolio. |

  @UK
  @S30-AC1-AT9
  @DependsOn('I_login_as_userH_in_portfolio_level_allocation_screen_for_GPBM-307')
  Scenario: Check the message information when client has no holdings at Portfolio Level Screen Region
    Given I see the portfolio allocation screen
    When I tap Portfolio Region tab
    Then I should see the following UI Elements on the Portfolio Region tab
      | element region | element name   | element value                                                                     |
      | HK_SG          | region content | Exposure by Region is unavailable as there are no holdings within this Portfolio. |
      | UK             | region content | Exposure by region is unavailable as there are no holdings within this portfolio. |