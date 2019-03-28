@HK @SG @UK
@Epic_GPBM-367(My_Overview)
@Story_GPBM-407 @Sprint1_iOS
@Story_GPBM-791 @Sprint1_aOS

Feature: Total Assets at Overview level

  As a client I want to be able to see the total value of the assets I own within all of my Accounts at Overview level,
  so that I know the total value of my investments at any given time.

  userE: has 1 account


  @S26-AC1-AT1
  Scenario: Check the Overview Level Screen UI
    Given I login as type "overview_total_assets_no_zero"
    Then I should see the following UI Elements on the account list
      | element name        | element value |
      | Total assets title  | Total assets  |
#      | Total assets icon  |               |
      | Total assets amount |               |
#      | currency label     |               |
      | Greeting message    |               |
      | Country             |               |
      | Account list        |               |
      | Account header      | Accounts      |
      | Allocation Toggle   |               |
      | Menu icon           |               |

  @SIT
  Scenario: login in as userE for GPBM407
    Given I login as type "overview_total_assets_no_zero"
    Then I should see the account list

  @S26-AC1-AT3
  @SIT
  @DependsOn('login_in_as_userE_for_GPBM407')
  Scenario: Check the length of Total assets at Overview Level Screen
    Given I see the account list
    Then I should see the value for the overview "Total assets" they own within all of the accounts is displayed, which will be 18 characters max

  @S26-AC1-AT4
  @SIT
  @DependsOn('login_in_as_userE_for_GPBM407')
  Scenario: Check the format of Total assets at Overview Level Screen(reporting currency)
    Given I see the account list
    Then I should see the overview reporting currency is displayed in ISO 3 code format

  @S26-AC1-AT5
  @SIT
  @DependsOn('login_in_as_userE_for_GPBM407')
  Scenario: Check the format of Total assets at Overview Level Screen(current reporting currency )
    Given I see the account list
    Then I should see the overview Total Assets value is shown in full to 2dp

  @S26-AC1-AT6
  @SIT
  @DependsOn('login_in_as_userE_for_GPBM407')
  Scenario: Check  whether the Total asset value at the overview Level Overlay equals the sum of total asset value for each account the user has permissions
    Given I see the account list
    Then I should see the overview Total asset value at the overview level Overlay equals the sum of all assets(markValue)in reporting currency

  @S26-AC1-AT2
  @DependsOn('login_in_as_userE_for_GPBM407')
  Scenario: Check the overlay at Overview Level Screen UI
    Given I see the account list
    When I click on the overview Total Assets value(has investment)
    Then I should see a link to an overview overlay showing how this value has been calculated is displayed


  @S26-AC1-AT7
  Scenario: Check Overview Level Screen UI if not invested in any securities
    Given I login as type "overview_total_assets_zero"
    Then I should see the following UI Elements on the account list
      | element name       | element value |
      | Total assets title | Total assets  |
#      | Total assets icon  |               |
      | Total assets amount |               |
#      | currency label     |               |
      | Greeting message   |               |
      | Country            |               |
#      | Account list      |               |
      | Account header     | Accounts      |
      | Allocation Toggle  |               |
      | Menu icon          |               |

  @SIT
  Scenario: login as default for GPBM407
    Given I login as type "overview_total_assets_zero"
    Then I should see the account list

  @S26-AC1-AT9
  @DependsOn('login_as_default_for_GPBM407')
  Scenario: Check the format of Total assets at Overview Level Screen(current reporting currency)
    Given I see the account list
    Then I should see a value of "0.00" for the "Total assets" they own within all of the accounts is displayed

  @S26-AC1-AT10
  @SIT
  @DependsOn('login_as_default_for_GPBM407')
  Scenario: Check the format of Total assetrs at Overview Level Screen(reporting currency)
    Given I see the account list
    Then I should see the overview reporting currency is displayed in ISO 3 code format

  @S26-AC1-AT8
  @DependsOn('login_as_default_for_GPBM407')
  Scenario: Check the overlay at Overview Level Screen UI if not invested in any securities
    Given I should see the account list
    When I click on the overview Total Assets value
    Then I should see a link to an overview overlay showing how this value has been calculated is displayed