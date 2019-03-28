@HK @SG @UK
@Epic_GPBM-367(My_Overview)
@Story_GPBM-471 @Sprint1_iOS
@Story_GPBM-794 @Sprint1_aOS

Feature: Overview Total Assets Overlay

  As a client I want to be able to access further information regarding the value I am shown for the Total Assets within all of my Accounts,
  so that I understand how this figure is calculated.

  userE: has 1 account

# Reason: can not check the effect of overlay appears is full of screen
#  Scenario: Check the Accessing Total Assets overlay at Overview level
#    Given Client is logged in
#    And client is viewing Overview screen
#    When client taps on the tab-able area around the Total Assets figure
#    Then an overlay appears is full of screen
#    And the data is shown as it is

  @SIT
  Scenario: login in as userN for GPBM471
    Given I login as type "overview_total_assets_no_zero"
    When I click on the overview Total Assets value
    Then I should on the global overlay screen

  @S27-AC1-AT1
  @DependsOn('login_in_as_userN_for_GPBM471')
  Scenario: Check the data of overlay at Overview Level Screen
    Given I am on the global overlay screen
    Then I should see the following overview overlay UI
      | element region | element name             | element value                                                                                                                                                                                                                         |
      |                | overlay title            | Total assets                                                                                                                                                                                                                          |
      |                | overlay content          |                                                                                                                                                                                                                                       |
      |                | overlay name             | Overview                                                                                                                                                                                                                              |
      |                | overlay calculated       | How is this calculated?                                                                                                                                                                                                               |
      | UK             | overlay calculated value | This figure represents the total value of your current holdings across all of your UK accounts, one account or one portfolio, depending on the level you are at. It does not include the value of any commitments to invest or loans. |
#      | HK             | overlay calculated value | This figure represents the total value of your current holdings across all of your HK accounts, one account or one portfolio, depending on the level you are at. It does not include the value of any commitments to invest or loans. |
#      | SG             | overlay calculated value | This figure represents the total value of your current holdings across all of your SG accounts, one account or one portfolio, depending on the level you are at. It does not include the value of any commitments to invest or loans. |
      | HK             | overlay calculated value | This figure represents the total value of your current holdings across all of your Hong Kong accounts,one account or one portfolio,denpending on the level you are at. It does not include the value of any liabilities               |
      | SG             | overlay calculated value | This figure represents the total value of your current holdings across all of your Singapore accounts,one account or one portfolio,denpending on the level you are at.it does not include the value of any liabilities                |
      |                | close button             |                                                                                                                                                                                                                                       |

  @S27-AC1-AT2
  @SIT
  @DependsOn('login_in_as_userN_for_GPBM471')
  Scenario: Check the format of Total assets value at the overlay within Overview Level Screen(current reporting currency)
    Given I am on the global overlay screen
    Then I should see Overview Total Assets value for the account in current reporting currency to 2dp

  @S27-AC1-AT3
  @SIT
  @DependsOn('login_in_as_userN_for_GPBM471')
  Scenario: Check the format of Total assets value at the overlay within Overview Level Screen(reporting currency)
    Given I am on the global overlay screen
    Then I should see the Overview Overlay Reporting Currency ISO3 code format

  @S27-AC1-AT4
  @DependsOn('login_in_as_userN_for_GPBM471')
  Scenario: Check whether the overlay can be closed or back into focus when client taps on "x" top right of overlay within the Overview level
    Given I am on the global overlay screen
    When I tap on close button of overview overlay
    Then I should see the Overview Total Assets overlay is closed

#  update in sprint 9
#  @S27-AC1-AT5
#  @DependsOn('login_in_as_userN_for_GPBM471')
#  Scenario: Check whether the overlay can be closed or back into focus when taps anywhere on the screen outside of the overlay frame within Overview Level Screen
#    Given I am on the Overview screen
#    When I tap anywhere on the screen outside of the overview overlay frame
#    Then I should see the Overview Total Assets overlay is closed
