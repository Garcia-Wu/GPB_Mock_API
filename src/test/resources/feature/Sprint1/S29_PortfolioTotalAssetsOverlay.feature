@HK @SG @UK
@Epic_GTMB-410
@Story_GTMB-469 @Sprint1_iOS
@Story_GPBM-800 @Sprint1_aOS

Feature: Portfolio Total Assets Overlay

  As a client I want to be able to access further information regarding the value I am shown for the Total Assets of my Portfolio,
  so that I understand how this figure is calculated.

# Reason: can not check the effect of overlay appears is full of screen
#  Scenario: Check the Accessing Portfolio Assets overlay at Portfolio Level
#    Given Client is logged in
#    And client is viewing one of their Portfolios
#    When client taps on the tab-able area around the Portfolio Assets figure
#    Then an overlay appears is full of screen
#    And the data is shown as it is

  @SIT
  Scenario: login userE for GPBM469
    Given I login as type "portfolio_total_assets_no_zero"
#    When I tap first item of Accounts list
#    And I tap first item of Portfolios list
    When I click on the Portfolio Total Assets value
    Then I should on the global overlay screen

  @S29-AC1-AT1
  @DependsOn('login_userE_for_GPBM469')
  Scenario: Check whether the portfolio total asset overlay appears
    Given I am on the global overlay screen
    Then I should see a link to an portfolios overlay showing how this value has been calculated is displayed

  @S29-AC1-AT2
  @DependsOn('login_userE_for_GPBM469')
  Scenario: Check the overlay at Portfolio Level Screen UI
    Given I am on the global overlay screen
    Then I should see the following data in portfolio total asset overlay:
      | element region | element name             | element value                                                                                                                                                                                                                         |
      |                | overlay title            | Portfolio assets                                                                                                                                                                                                                      |
      |                | overlay name             |                                                                                                                                                                                                                                       |
      |                | overlay content          |                                                                                                                                                                                                                                       |
      |                | overlay calculated       | How is this calculated?                                                                                                                                                                                                               |
      | UK             | overlay calculated value | This figure represents the total value of your current holdings across all of your UK accounts, one account or one portfolio, depending on the level you are at. It does not include the value of any commitments to invest or loans. |
#      | HK             | overlay calculated value | This figure represents the total value of your current holdings across all of your HK accounts, one account or one portfolio, depending on the level you are at. It does not include the value of any commitments to invest or loans. |
#      | SG             | overlay calculated value | This figure represents the total value of your current holdings across all of your SG accounts, one account or one portfolio, depending on the level you are at. It does not include the value of any commitments to invest or loans. |
      | HK             | overlay calculated value | This figure represents the total value of your current holdings across all of your Hong Kong accounts,one account or one portfolio,denpending on the level you are at. It does not include the value of any liabilities               |
      | SG             | overlay calculated value | This figure represents the total value of your current holdings across all of your Singapore accounts,one account or one portfolio,denpending on the level you are at.it does not include the value of any liabilities                |
      |                | close button             |                                                                                                                                                                                                                                       |

  @S29-AC1-AT3
  @SIT
  @DependsOn('login_userE_for_GPBM469')
  Scenario: Check the format of Total asset at Portfolio Level Screen
    Given I am on the global overlay screen
    Then I should see Total Assets value for the Portfolio overlay in current reporting currency to 2 d.p.

  @S29-AC1-AT4
  @SIT
  @DependsOn('login_userE_for_GPBM469')
  Scenario: Check the format of exporting Currency ISO
    Given I am on the global overlay screen
    Then I should see Total Assets value for the Portfolio overlay in exporting Currency ISO 3 code

  @S29-AC1-AT5
  @DependsOn('login_userE_for_GPBM469')
  Scenario: Check whether the overlay can be closed or back into focus when client taps on close button of overlay within the Portfolio level
    Given I am on the global overlay screen
    When I tap on close button of portfolio overlay
    Then I should see the main Portfolio screen should come back into focus
    And the portfolio overlay is closed

#  update in sprint 9
#  @S29-AC1-AT6
#  @DependsOn('login_userE_for_GPBM469')
#  Scenario: Check whether the overlay can be closed or back into focus when taps anywhere on the screen outside of the overlay frame within Portfolio Level Screen
#    Given I am on the global overlay screen
#    When I taps anywhere on the screen outside of the portfolio overlay frame
#    Then I should see the main Portfolio screen should come back into focus
#    And the portfolio overlay is closed
