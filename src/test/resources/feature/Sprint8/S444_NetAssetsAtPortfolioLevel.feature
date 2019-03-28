@HK @SG
@Epic_GPBM-460(Liabilities)
@Story_GPBM-2337 @Sprint8_iOS
@Story_GPBM-2821 @Sprint8_aOS

Feature: Net Assets at Portfolio level

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @SIT
  Scenario: Net Assets at Portfolio level
    Given I login as type "portfolio_has_net_assert"
    Then I should on the Portfolios level
    
  @S444-AC1-AT1
  @DependsOn('Net_Assets_at_Portfolio_level')
  Scenario:Check the UI of Net Assets at Portfolio level
    Given I am on the Portfolios level
    Then I should see the follow element on portfolio net assets:
      | element name        | element value        |
      | header "Net assets" | Net portfolio assets |
      | Net assets currency |                      |
      | Net assets value    |                      |

  @S444-AC1-AT2
  @SIT
  @DependsOn('Net_Assets_at_Portfolio_level')
  Scenario:Check the format of the value for the net assets they own within the Portfolio is displayed which will be 17 characters max,including commas and decimal point
    Given I am on the Portfolios level
    Then I should see the value for the net assets they own within the Portfolio is displayed which will be 17 characters max,including commas and decimal point

  @S444-AC1-AT3
  @SIT
  @DependsOn('Net_Assets_at_Portfolio_level')
  Scenario:Check whether the portfolio net assets base currency is displayed in ISO 3 code format
    Given I am on the Portfolios level
    Then I should see the portfolio net assets base currency is displayed in ISO 3 code format

  @S444-AC1-AT4
  @SIT
  @DependsOn('Net_Assets_at_Portfolio_level')
  Scenario:Check whether Net portfolio Assets = Portfolio Assets - Portfolio liabilities
    Given I am on the Portfolios level
    Then I should see that Net portfolio Assets = Portfolio Assets - Portfolio liabilities

  @S444-AC1-AT5
  @DependsOn('Net_Assets_at_Portfolio_level')
  Scenario:Check whether Portfolio Net Assets will be changed when I swap the pips
    Given I login as type "portfolio_swap_left_net_assert_changed"
    When I swap left the pips for portfolio net assets
    Then I should see the Portfolio Net Assets will be changed

  @S444-AC1-AT6
  Scenario:Check whether I can not see a Portfolios Net assets label or figure displayed when client has no liabilities
    Given I login as type "portfolio_no_net_assert"
    And I tap four item of Accounts list
    And I tap last item of Portfolios list
    Then I should not see a Portfolios Net assets label or figure displayed

  @S444-AC1-AT7
  Scenario:Check whether I can not see a Portfolios Net assets label or figure displayed 0.00
    Given I login as type "portfolio_net_assert_zero"
    And I tap four item of Accounts list
    And I tap fourth item of Portfolios list
    Then I should see a Portfolios Net assets label or figure displayed "0.00"