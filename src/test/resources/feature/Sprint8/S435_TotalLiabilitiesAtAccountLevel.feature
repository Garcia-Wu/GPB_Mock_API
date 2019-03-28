@HK @SG
@Epic_GPBM-460(Liabilities)
@Story_GPBM-2322 @Sprint8_iOS
@Story_GPBM-2823 @Sprint8_aOS

Feature: Total Liabilities at Account level

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @SIT
  Scenario: Total Liabilities at Account Level
    Given I login as type "account_has_total_liabilities"
    Then I should on the Account level

  @S435-AC1-AT1
  @DependsOn('Total_Liabilities_at_Account_Level')
  Scenario:Check the UI of Total Liabilities at Account Level
    Given I am on the Account level
    Then I should see the follow element on account liabilities:
      | element name               | element value       |
      | header "Total liabilities" | Account liabilities |
      | Total liabilities icon     |                     |
      | Total liabilities value    |                     |

  @S435-AC1-AT2
  @SIT
  @DependsOn('Total_Liabilities_at_Account_Level')
  Scenario:Check the format of Total Liabilities value which will be 17 characters max and including commas and decimal point
    Given I am on the Account level
    Then I should see the value for the Total Liabilities they own within the account is displayed,which will be 17 characters max,including commas and decimal point

  @S435-AC1-AT3
  @SIT
  @DependsOn('Total_Liabilities_at_Account_Level')
  Scenario:Check the ISO 3 format of Account base currency
    Given I am on the Account level
    Then I should see the account liabilities base currency is displayed in ISO 3 code format

  @NotAutomatable
  Scenario:Check whether The Total Liabilities figure should be based on the sum of the "Total in base currency" value for each liability owned by the client within the specific Account
    Given I am see the follow element on account liabilities:
      | element name               | element value       |
      | header "Total liabilities" | Account liabilities |
      | Total liabilities icon     |                     |
      | Total liabilities value    |                     |
    Then I should see The Total Liabilities figure should be based on the sum of the "Total in base currency" value for each liability owned by the client within the specific Account
    #  S-AC1-AT4
    #  Reason: cannot check the accounts sum total liabilities


  @S435-AC1-AT5
  @DependsOn('Total_Liabilities_at_Account_Level')
  Scenario:Check whether Total Liabilities in Account wrapper will be changed when I swap the pips
    Given I am on the Account level
    When I swap left the pips for account total liabilities overlay
    Then I should see the Account Total Liabilities in Account wrapper will be changed

  @S435-AC1-AT6
  @DependsOn('Total_Liabilities_at_Account_Level')
  Scenario:Check the animation of Account wrapper
    Given I am on the Account level
    When I minifiles the Account wrapper
    Then I should see the Account name/External Id/Update time/Account Liabilities/Net account Assets will be fade in and they will be disappeared
    And I should see the account name and Account Assets

  @S435-AC1-AT7
  Scenario:Check whether I can not see a Total Liabilities label chervon or figure displayed when client has no liabilities
    Given I login as type "account_no_total_liabilities"
#    When I tap last item of Accounts list
    Then I should not see a Total Liabilities label,chervon or figure displayed

  @S435-AC1-AT9
  @DependsOn('Check_whether_I_can_not_see_a_Total_Liabilities_label_chervon_or_figure_displayed_when_client_has_no_liabilities')
  Scenario:Check whether I can not see the Account Liabilities and Net Assets when the Account Liabilities value really data is 0.0000 in backend
    Given I am not see a Total Liabilities label,chervon or figure displayed
#    And the Account Liabilities value  really data is 0.00000 in backend
    Then I should not see the Account Liabilities and the Net Assets

  @S435-AC1-AT8
  Scenario:Check whether I can see the Account Liabilities is displayed 0.00 when the Account Liabilities value  really data is 0.001 in backend
    Given I login as type "account_total_liabilities_zero"
    And I taps on 2nd items in Accounts list
#    And the Account Liabilities value really data is 0.001 in backend
    Then I should see the Account Liabilities is displayed "0.00"