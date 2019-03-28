@HK @SG
@Epic_GPBM-460(Liabilities)
@Story_GPBM-2332 @Sprint8_iOS
@Story_GPBM-2820 @Sprint8_aOS

Feature: Total Liabilities at Portfolio level

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @SIT
  Scenario: Total Liabilities at Portfolio Level
    Given I login as type "portfolio_has_total_liabilities"
    Then I should on the Portfolios level

  @S442-AC1-AT1
  @DependsOn('Total_Liabilities_at_Portfolio_Level')
  Scenario:Check the UI of Total Liabilities at Portfolio Level
    Given I am on the Portfolios level
    Then I should see the follow element on portfolio liabilities:
      | element name               | element value         |
      | header "Total liabilities" | Portfolio liabilities |
      | Total liabilities icon     |                       |
      | Total liabilities value    |                       |

  @S442-AC1-AT2
  @SIT
  @DependsOn('Total_Liabilities_at_Portfolio_Level')
  Scenario:Check the format of the value for the total liabilities they own within the Portfolio is displayed,which will be 17 characters max,including commas and decimal point
    Given I am on the Portfolios level
    Then I should see the value for the total liabilities they own within the Portfolio is displayed,which will be 17 characters max,including commas and decimal point

  @S442-AC1-AT3
  @SIT
  @DependsOn('Total_Liabilities_at_Portfolio_Level')
  Scenario:Check the ISO 3 format of Portfolio base currency
    Given I am on the Portfolios level
    Then I should see the portfolio total liabilities base currency is displayed in ISO 3 code format

  @NotAutomatable
  Scenario:Check whether The Total Liabilities figure should be based on the sum of the "Total in base currency" value for each liability owned by the client within the specific Portfolio
    Given I am see the follow element on portfolio liabilities:
      | element name               | element value         |
      | header "Total liabilities" | Portfolio liabilities |
      | Total liabilities icon     |                       |
      | Total liabilities value    |                       |
    Then I should see that The Total Liabilities figure should be based on the sum of the "Total in base currency" value for each liability owned by the client within the specific Portfolio
    #  S-AC1-AT4
    #  Reason: cannot check the accounts sum total liabilities

  @S442-AC1-AT5
  @DependsOn('Total_Liabilities_at_Portfolio_Level')
  Scenario:Check whether Total Liabilities in Portfolio wrapper will be cahnged when I swap the pips
    Given I am on the Portfolios level
    When I swap left the pips for portfolio total liabilities overlay
    Then I should see the Total Liabilities in Portfolio wrapper will be changed

  @S442-AC1-AT6
  @DependsOn('Total_Liabilities_at_Portfolio_Level')
  Scenario:Check the animation of Portfolio wrapper
    Given I am on the Portfolios level
    When I minifiles the Portfolio wrapper
    Then I should see the External Id/Update time/Portfolio Liabilities/Net portfolio Assets will be fade in and they will be disappeared
    And I should see the portfolio name and Portfolio Assets

  @S442-AC1-AT7
  Scenario:Check whether I can not see a Total Liabilities label,chervon or figure displayed when client has no liabilities on portfolio level
    Given I login as type "portfolio_no_total_liabilities"
#    When I tap four item of Accounts list
#    And I tap last item of Portfolios list
    Then I should not see a Portfolios Total Liabilities label,chervon or figure displayed

  @S442-AC1-AT9
  @DependsOn('Check_whether_I_can_not_see_a_Total_Liabilities_label_chervon_or_figure_displayed_when_client_has_no_liabilities')
  Scenario:Check whether I can not see the Portfolio Liabilities and Net Assets when the Portfolio Liabilities value really data is 0.0000 in backend
    Given I am not see a Portfolios Total Liabilities label,chervon or figure displayed
#    And the Portfolio Liabilities value really data is 0.00000 in backend
    Then I should not see the Portfolio Liabilities and the Net Assets

  @S442-AC1-AT8
  Scenario:Check whether I can see the Portfolio Liabilities is displayed 0.00 when the Portfolio Liabilities value  really data is 0.001 in backend
    Given I login as type "portfolio_total_liabilities_zero"
#    When I tap four item of Accounts list
#    And I taps on 2nd items in Portfolio list
#    And the Portfolio Liabilities value really data is 0.001 in backend
    Then I should see the Portfolio Liabilities is displayed "0.00"
