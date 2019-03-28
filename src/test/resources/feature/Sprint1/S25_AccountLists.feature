@HK @SG @UK
@Epic_GPBM-367(My_Overview)
@Story_GPBM-405 @Sprint1_iOS
@Story_GPBM-788 @Sprint1_aOS

Feature: Account lists

  As a Client I want to see a list of active Accounts that I own,
  so that I have a high-level view of the investments I hold with the bank grouped by mandate.

  userN: has 2 account

  @SIT
  Scenario: login userN for GPBM405
    Given I login as type "has_account"
    Then I should on the Overview screen

  @S25-AC1-AT1
  @DependsOn('login_userN_for_GPBM405')
  Scenario: Check the data of Account lists
    Given I am on the Overview screen
    Then I should see the following UI Elements on the account list
      | element name                | element value |
      | Account header              | Accounts      |
      | Account name                |               |
      | Account Id                  |               |
      | accountListTotalAssetsTxt_0 |               |
#      | Performance figure          |               |

  @S25-AC1-AT2
  @SIT
  @DependsOn('login_userN_for_GPBM405')
  Scenario: Check the format of Total asset value at Account lists
    Given I am on the Overview screen
    Then I should see account list Total assets (value in reporting currency to 2dp)

  @S25-AC1-AT3
  @SIT
  @DependsOn('login_userN_for_GPBM405')
  Scenario: Check the  sequence of Total assets at Account lists
    Given I am on the Overview screen
    Then I should see the accounts list are ordered by Total Assets value (largest first, smallest last and then in alphabetical order based on first letter of Account Name value)