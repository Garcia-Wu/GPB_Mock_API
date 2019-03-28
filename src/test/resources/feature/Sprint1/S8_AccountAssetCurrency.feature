@NotAutomatable
# Reason：This function has been modified in sprint14 or sprint15
@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-320 @Sprint1_iOS
@Story_GPBM-737 @Sprint1_aOS

Feature: View asset currency breakdown at Account level

  As a client I want to view an Account summary of my assets grouped by currency,
  so that I know which currencies I am invested in

  Scenario: login userE for GPBM320
    Given I login as type "account_currency_list_less_than_9"
#    When I tap first item of Accounts list
    And I tap default Accounts Allocation toggle
    And I tap on "Currency" tab of Account Level
    Then I should on the Account level

  @S8-AC1-AT1
  @DependsOn('login_userE_for_GPBM320')
  Scenario: Check the Account Level Screen ui
    Given I am on the Account level
    Then I should see the following UI Elements on the Accounts Class Level
      | element region | element name             | element value  |
      |                | Account name             |                |
      |                | Account id               |                |
      |                | Total assets title       | Account assets |
#      | info icon                |               |
      |                | Total assets amount      |                |
#      | currency label           |               |
      |                | Allocation button active |                |
      |                | Class tab                | Class          |
      |                | Currency tab             | Currency       |
      | UK             | Region tab               | Region         |


  @S8-AC1-AT2
  @DependsOn('login_userE_for_GPBM320')
  Scenario: Check the statues of Allocation $ Currency
    Given I am on the Account level
    Then I check Allocation and Currency Button state

  @S8-AC1-AT3
  @DependsOn('login_userE_for_GPBM320')
  Scenario: Check the data of each Asset Currency they are invested in
    Given I am on the Account level
    Then I check the first item data of Currency list：Currency name、Total asset ISO3 value、Total asset 2dp report currency value、Total asset 2dp percentage value

  @NotAutomatable
  Scenario: Check the horizontal bar at Currency tab under breakdown Account Level when securities purchased in <9 currencies
  # S8-AC1-AT4
  # Reason: cannot check the state of Allocation&Class

  @S8-AC1-AT5
  @DependsOn('login_userE_for_GPBM320')
  Scenario: Check the sequence of the Asset Currency By Total Assets at Currency tab under breakdown Account Level
    Given I am on the Account level
    Then I should see the currencies are ordered by Total Asset value - largest (first) to smallest (last), then by alphabetical order

  Scenario: login userH for GPBM320
    Given I login as type "account_currency_list_greater_than_8"
#    When I tap 3th item of Accounts list
    And I tap default Accounts Allocation toggle
    And I tap on "Currency" tab of Account Level
    Then I should on the Account level

  @S8-AC1-AT6
  @DependsOn('login_userH_for_GPBM320')
  Scenario: Check the More Currency Account Level Screen UI
    Given I am on the Account level
    Then I should see the following UI Elements on the Accounts Currency Level
      | element region | element name             | element value  |
      |                | Account name             |                |
      |                | Account id               |                |
      |                | Total assets title       | Account assets |
#      | info icon3                |               |
      |                | Total assets amount      |                |
#      | currency label3           |               |
      |                | Allocation button active |                |
      |                | Class tab                | Class          |
      |                | Currency tab             | Currency       |
      | UK             | Region tab               | Region         |
      |                | back overview button     |                |
      |                | menu icon                |                |


  @S8-AC1-AT7
  @DependsOn('login_userH_for_GPBM320')
  Scenario: Check the statues of Allocation $ Currency when securities purchased in >8 currencies
    Given I am on the Account level
    Then I check Allocation Button state and more Currency state


  @S8-AC1-AT8
  @DependsOn('login_userH_for_GPBM320')
  Scenario: Check the data of "Other" in each Currency that they are invested in
    Given I am on the Account level
    Then I should see the eight item Currency List
      | element name                     | element value |
      | Other label                      | Other         |
      | Total asset ISO3 format value    |               |
      | Total asset 2dp format value     |               |
      | Total asset 2dp percentage value |               |

  @NotAutomatable
  Scenario: Check the horizontal bar at Currency tab under breakdown Account Level when securities purchased in >8 currencies
  # S8-AC1-AT9
  # Reason: cannot check the state of Allocation&Class

  @S8-AC1-AT10
  @DependsOn('login_userH_for_GPBM320')
  Scenario: Check whether the "Other" category is on the bottom
    Given I am on the Account level
    When I scroll down to the bottom on the Accounts Currency Level
    Then I should see ‘Other’ category is always at the bottom of the list, even if its combined total has a higher value than 1 or more of the 7 currencies already listed

  @S8-AC1-AT11
  Scenario: Check if not invested in a specific Currency
    Given I login as type "account_no_currency"
#    When I tap 16th item of Accounts List
    And I tap default Accounts Allocation toggle
    And I tap on "Currency" tab of Account Level
    Then I should not see that currency listed on the Accounts Level

