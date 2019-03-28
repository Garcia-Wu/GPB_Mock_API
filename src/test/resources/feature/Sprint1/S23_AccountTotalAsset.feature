@HK @SG @UK
@Epic_GPBM-368(My_Account)
@Story_GPBM-408 @Sprint1_iOS
@Story_GPBM-989 @Sprint1_aOS

Feature: Total Assets at Account level

  As a client I want to be able to see the total value of the assets I own within each of my Accounts,
  so that I know the total value of my investments per mandate at any given time

  @SIT
  Scenario: login in userM for GPBM408
    Given I login as type "account_total_assets_no_zero"
    Then I should on the Account level

  @S23-AC1-AT1
  @DependsOn('login_in_userM_for_GPBM408')
  Scenario: Check the Account Level Screen UI for Total assets
    Given I am on the Account level
    Then I should see the following UI Elements on the Accounts Level
      | element name         | element value  |
      | Total assets title   | Account assets |
#      | info icon            |               |
      | Total assets amount  |                |
#      | currency label       |               |
      | Account name         |                |
      | Account id           |                |
      | Allocation Toggle    |                |
      | Portfolios header    | Portfolios     |
      | Portfolio lists      |                |
      | back overview button |                |
      | menu icon            |                |

  @S23-AC1-AT3
  @SIT
  @DependsOn('login_in_userM_for_GPBM408')
  Scenario: Check the format of "Total assets" at Account Level Screen
    Given I am on the Account level
    Then I should see the value for the "Total assets" the client owns within that Account is displayed in full to 2 d.p., which will be 18 characters max

  @S23-AC1-AT4
  @SIT
  @DependsOn('login_in_userM_for_GPBM408')
  Scenario: Check the "Total assets" value and the format of "Total assets" value
    Given I am on the Account level
#    Then I should see the "Total assets" value is displayed based on the reporting currency currently selected.
    Then I should see the accounts reporting currency is displayed in ISO3 code format


  @S23-AC1-AT2
  @DependsOn('login_in_userM_for_GPBM408')
  @Const(action="close_Overlay_In_Account_Level")
  Scenario: Check the overlay at Account Level Screen
    Given I am on the Account level
    And I tap on the account total assets value
    Then I should see a link to an account overlay showing how this value has been calculated is displayed

  @NotInMock
  @S23-AC1-AT5
  @SIT
  @DependsOn('login_in_userM_for_GPBM408')
  Scenario: Check  whether the Total asset value at the Account Level Overlay equals the sum of each Portfolio asset value
    Given I am on the Account level
    Then I should see the accounts Total asset value at the Account Level Overlay equals the sum of each Portfolio asset value


  @SIT
  Scenario: login in userM not invested for GPBM408
    Given I login as type "account_total_assets_zero"
    Then I should on the Account level

  @S23-AC1-AT6
  @DependsOn('login_in_userM_not_invested_for_GPBM408')
  Scenario: Check the Account Level Screen UI if not invested in any securities within a specific Account
    Given I am on the Account level
#    When I tap 16th item of Accounts List
    Then I should see the following UI Elements on the Accounts Level
      | element name         | element value  |
      | Total assets title   | Account assets |
#      | info icon          |               |
      | Total assets amount  |                |
#      | currency label     |               |
      | Account name         |                |
      | Account id           |                |
      | Allocation Toggle    |                |
      | Portfolios header    | Portfolios     |
#      | Portfolio lists15      |               |
      | back overview button |                |
      | menu icon            |                |

  @S23-AC1-AT8
  @DependsOn('login_in_userM_not_invested_for_GPBM408')
  Scenario: Check the format of "Total assets" at Account Level Screen if not invested in any securities within a specific Account
    Given I am on the Account level
#    When I tap 16th item of Accounts List
    Then I should see a value of "0.00" for the "Total assets" they own within that Account is displayed

  @S23-AC1-AT9
  @SIT
  @DependsOn('login_in_userM_not_invested_for_GPBM408')
  Scenario: Check if not invested in any securities within a specific Account  the "Total assets" value and the format of "Total assets" value
    Given I am on the Account level
#    When I tap 16th item of Accounts List
#    Then I should see the "Total assets" value is displayed based on the reporting currency currently selected.
    Then I should see the accounts reporting currency is displayed in ISO3 code format

  @S23-AC1-AT7
  @DependsOn('login_in_userM_not_invested_for_GPBM408')
#  @Const(action="back_overView_level_in_overlay")
  Scenario: Check the overlay at Account Level Screen if not invested in any securities within a specific Account
    Given I am on the Account level
#    When I tap 16th item of Accounts List
    When I tap on the account total assets value
    Then I should see a link to an account overlay showing how this value has been calculated is displayed