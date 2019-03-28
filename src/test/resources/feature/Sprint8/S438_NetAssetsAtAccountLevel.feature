@HK @SG
@Epic_GPBM-460(Liabilities)
@Story_GPBM-2327 @Sprint8_iOS
@Story_GPBM-2819 @Sprint8_aOS

Feature: Net Assets at Account level

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @SIT
  Scenario: Net Assets at Account level
    Given I login as type "account_has_net_assert"
    Then I should on the Account level

  @S438-AC1-AT1
  @DependsOn('Net_Assets_at_Account_level')
  Scenario:Check the UI of Net Assets at Account level
    Given I am on the Account level
    Then I should see the follow element on account net assets:
      | element name        | element value      |
      | header "Net assets" | Net account assets |
#      | Net assets currency |                    |
      | Net assets value    |                    |

  @S438-AC1-AT2
  @SIT
  @DependsOn('Net_Assets_at_Account_level')
  Scenario:Check the format of the value for the account net assets they own within the account is displayed,which will be 18 characters max,including commas and decimal point
    Given I am on the Account level
    Then I should see the value for the net assets they own within the account is displayed,which will be 18 characters max,including commas and decimal point

  @S438-AC1-AT3
  @SIT
  @DependsOn('Net_Assets_at_Account_level')
  Scenario:Check whether the account net assets base currency is displayed in ISO 3 code format
    Given I am on the Account level
    Then I should see the account net assets base currency is displayed in ISO 3 code format

  @S438-AC1-AT4
  @SIT
  @DependsOn('Net_Assets_at_Account_level')
  Scenario:Check whether Account Net Assets = Account Assets - Account liabilities
    Given I am on the Account level
    Then I should see that Account Net Assets = Account Total Assets - Account liabilities

  @S438-AC1-AT5
  Scenario:Check whether Account Net Assets will be changed when I swap the pips
    Given I login as type "account_swap_left_net_assert_changed"
    When I swap left the pips for account net assets
    Then I should see the Account Net Assets will be changed

  @S438-AC1-AT6
  Scenario:Check whether I can not see a Account Net assets label or figure displayed when client has no liabilities
    Given I login as type "account_no_net_assert"
#    And I tap last item of Accounts list
    Then I should not see a Net assets label or figure displayed

  @S438-AC1-AT7
  Scenario:Check whether I can not see a Account Net assets label or figure displayed 0.00
    Given I login as type "account_net_assert_zero"
#    And I tap four item of Accounts list
    Then I should see a Account Net assets label or figure displayed "0.00"