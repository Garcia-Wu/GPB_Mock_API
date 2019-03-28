@HK @SG @UK
@Epic_GPBM-368(My_Account)
@Story_GPBM-470 @Sprint1_iOS
@Story_GPBM-785 @Sprint1_aOS

Feature: Account Total Assets Overlay

  As a client I want to be able to access further information regarding the value I am shown for the Total Assets of my Account,
  so that I understand how this figure is calculated.


  # Reason: can not check the effect of overlay appears is full of screen
#  Scenario: Check the Accessing Account Assets overlay at Account Level
#    Given Client is logged in
#    And client is viewing one of their Accounts
#    When client taps on the tab-able area around the Account Assets figure
#    Then an overlay appears is full of screen
#    And the data is shown as it is

  @SIT
  Scenario: login userE for GPBM470
    Given I login as type "account_total_assets_no_zero"
    And I taps on the account total assets value
    Then I should on the global overlay screen

  @S24-AC1-AT1
  @DependsOn('login_userE_for_GPBM470')
  Scenario: Check the data of overlay at Account Level Screen
    Given I am on the global overlay screen
    Then I should see the account total assets data is show
      | element region | element name             | element value                                                                                                                                                                                                                         |
      |                | overlay title            | Account assets                                                                                                                                                                                                                        |
      |                | overlay name             |                                                                                                                                                                                                                                       |
      |                | overlay content          |                                                                                                                                                                                                                                       |
      |                | overlay calculated       | How is this calculated?                                                                                                                                                                                                               |
      | UK             | overlay calculated value | This figure represents the total value of your current holdings across all of your UK accounts, one account or one portfolio, depending on the level you are at. It does not include the value of any commitments to invest or loans. |
#      | HK             | overlay calculated value | This figure represents the total value of your current holdings across all of your HK accounts, one account or one portfolio, depending on the level you are at. It does not include the value of any commitments to invest or loans. |
#      | SG             | overlay calculated value | This figure represents the total value of your current holdings across all of your SG accounts, one account or one portfolio, depending on the level you are at. It does not include the value of any commitments to invest or loans. |
      | HK             | overlay calculated value | This figure represents the total value of your current holdings across all of your Hong Kong accounts,one account or one portfolio,denpending on the level you are at. It does not include the value of any liabilities               |
      | SG             | overlay calculated value | This figure represents the total value of your current holdings across all of your Singapore accounts,one account or one portfolio,denpending on the level you are at.it does not include the value of any liabilities                |
      |                | close button             |                                                                                                                                                                                                                                       |

  @S24-AC1-AT2
  @SIT
  @DependsOn('login_userE_for_GPBM470')
  Scenario: Check the format of Total assets value at the overlay within Account Level Screen(current reporting currency)
    Given I am on the global overlay screen
    Then I should see Total Assets value for the Account in current reporting currency to 2dp

  @S24-AC1-AT3
  @SIT
  @DependsOn('login_userE_for_GPBM470')
  Scenario: Check the format of Total assets value at the overlay within Account Level Screen(Reporting Currency)
    Given I am on the global overlay screen
    Then I should see Account Reporting Currency ISO 3 code

  @S24-AC1-AT4
  @DependsOn('login_userE_for_GPBM470')
  Scenario: Check whether the overlay can be closed or back into focus when client taps on "x" top right of overlay within Account Level Screen
    Given I am on the global overlay screen
    When I taps on close button of account overlay
    Then I should see the Account Total Assets overlay is closed

#  update in sprint 9
#  @S24-AC1-AT5
#  Scenario: Check whether the overlay can be closed or back into focus when taps anywhere on the screen outside of the overlay frame within Account Level Screen
#    Given I login as User
#      | Name     | userM  |
#      | password | 123456 |
#    When I tap first item of Accounts list
#    And I taps on the account total assets value
#    And I tap anywhere on the screen outside of the account overlay frame
#    Then I should see the Account Total Assets overlay is closed
