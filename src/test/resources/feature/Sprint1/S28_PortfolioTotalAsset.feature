@HK @SG @UK
@Epic_GPBM-410(My_Portfolio)
@Story_GPBM-409 @Sprint1_iOS
@Story_GPBM-797 @Sprint1_aOS

Feature: Total Assets at Portfolio level

  As a client I want to be able to see the total value of the assets I own within each of my Portfolios,
  so that I know the total value of my investments per portfolio at any given time.

  userE: has one account
  userM: has some account

  @SIT
  Scenario: login in as userE for GPBM409
    Given I login as type "portfolio_total_assets_no_zero"
#    When I tap first item of Accounts list
#    And I tap first item of Portfolios list
    Then I should on the Portfolios level

  @S28-AC1-AT1
  @DependsOn('login_in_as_userE_for_GPBM409')
  Scenario: Check the Portfolio Level Screen UI when Client has invested in one or more securities
    Given I am on the Portfolios level
    Then I should see the following UI Elements on the Portfolios Level
      | element name       | element value    |
      | back button        |                  |
      | Total Assets title | Portfolio assets |
#      | info icon          |               |
      | Total Assets value |                  |
#      | Currency label     |               |
      | Portfolio name     |                  |
      | Portfolio id       |                  |
      | Holding lists      |                  |
      | Allocation Toggle  |                  |

  @S28-AC1-AT3
  @SIT
  @DependsOn('login_in_as_userE_for_GPBM409')
  Scenario: Check the format of Total assets at Portfolio Level Screen
    Given I am on the Portfolios level
    Then I should see the value for the "Total assets" the client owns within that Portfolio is displayed in full to 2dp, which will be 18 characters max


  @S28-AC1-AT4
  @SIT
  @DependsOn('login_in_as_userE_for_GPBM409')
  Scenario: Check the format of Total assets at Portfolio Level Screen when Client has invested in one or more securities
    Given I am on the Portfolios level
    Then I should see the portfolios reporting currency is displayed in ISO3 code format

  @S28-AC1-AT2
  @DependsOn('login_in_as_userE_for_GPBM409')
  Scenario: Check the overlay at Portfolio Level Screen UI when Client has invested in one or more securities
    Given I am on the Portfolios level
    When I click on the Portfolio Total Assets value
    Then I should see a link to an portfolios overlay showing how this value has been calculated is displayed

  @SIT
  Scenario: login in as userM for GPBM409
    Given I login as type "portfolio_total_assets_zero"
#    When I tap fourth item of Accounts List
#    And I tap 16th item of Portfolios list
    Then I should on the Portfolios level

  @S28-AC1-AT5
  @DependsOn('login_in_as_userM_for_GPBM409')
  Scenario: Check if not invested in  any securities when Client has not invested in any securities within a specific Portfolio
    Given I am on the Portfolios level
    Then I should see the following UI Elements on the Portfolios Level
      | element name       | element value    |
      | Total Assets title | Portfolio assets |
#      | info icon16          |               |
      | Total Assets value |                  |
#      | Currency label16     |               |
      | Portfolio name     |                  |
      | Portfolio id       |                  |
#      | Holding lists        |               |
      | Allocation Toggle  |                  |

  @S28-AC1-AT7
  @DependsOn('login_in_as_userM_for_GPBM409')
  Scenario: Check the format of Total assets at Portfolio Level Screen(current reporting currency)
    Given I am on the Portfolios level
    Then I should see a value of "0.00" for the "Total assets" they own within that portfolio total assets is displayed


  @S28-AC1-AT8
  @SIT
  @DependsOn('login_in_as_userM_for_GPBM409')
  Scenario: Check the format of Total assets at Portfolio Level Screen(reporting currency)
    Given I am on the Portfolios level
    Then I should see the portfolios reporting currency16 is displayed in ISO3 code format


  @S28-AC1-AT6
  @DependsOn('login_in_as_userM_for_GPBM409')
  Scenario: Check the overlay at Portfolio Level Screen when Client has not invested in any securities within a specific Portfolio
    Given I am on the Portfolios level
    When I click on the Portfolio Total Assets value
    Then I should see a link to an portfolios overlay showing how this value has been calculated is displayed
