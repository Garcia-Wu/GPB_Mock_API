@HK @SG @UK
@Epic_GPBM-368(My_Account)
@Story_GPBM-406 @Sprint1_iOS
@Story_GPBM-975 @Sprint1_aOS

Feature: Portfolio list

  As a Client I want to see a list of Portfolios that I own within each Account,
  so that I have a high level view of the investments I hold with the bank grouped by Account.

#  And I have permission to view one or more Portfolios
#  And I am viewing Overview screen
  @S22-AC1-AT1
  Scenario: Check the Portfolio lists data
    Given I login as type "more_account_has_portfolio_list"
#    When I taps on 2nd items in Accounts list
    Then I should see the portfolio lists following data portfolio name、portfolio number、management type、total assets value

  @SIT
  Scenario: login in userM for GPBM406
    Given I login as type "more_account_has_portfolio_list"
#    When I taps on 2nd items in Accounts list
    Then I should on the Account level

  @S22-AC1-AT2
  @SIT
  @DependsOn('login_in_userM_for_GPBM406')
  Scenario: Check the format of Total Assets
    Given I am on the Account level
    Then I should see portfolio total assets (value in reporting currency to 2 d.p.)

  @NotInMock
  @S22-AC1-AT3
  @SIT
  @DependsOn('login_in_userM_for_GPBM406')
  Scenario: Check the sequence of Total Assets at Account Level
    Given I am on the Account level
    Then I should see the portfolios list are ordered by Total Assets value (largest first, smallest last and then in alphabetical order based on first letter of Portfolio Name value)

  @NotAutomatable
  Scenario: Check the closed or dormant portfolios
    Given  I logged in
    And I am linked to Portfolios in Avaloq that are closed or dormant
    When I am on the Overview screen
    Then I should see the header "Portfolios"
    And I should not see these closed or dormant portfolios within the list of active portfolios
#   S22-AC1-AT4
#   Reason:not has Avaloq data