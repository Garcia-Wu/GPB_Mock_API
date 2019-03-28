@NotAutomatable
# Reason：This function has been modified in sprint14 or sprint15
@UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-317 @Sprint1_iOS
@Story_GPBM-734 @Sprint1_aOS

Feature: View asset breakdown by Region at Account level

  As a client I want to see which geographic regions I have invested my money in within one Account,
  so that I can make decisions regarding my investments based on regional factors that may influence investment performance

  Scenario: login userE for GPBM317
    Given I login as type "account_has_region"
#    When I tap first item of Accounts list
    When I tap default Accounts Allocation toggle
    And I tap Account Region button
    Then I should on the Account level

  @S7-AC1-AT1
  @DependsOn('login_userE_for_GPBM317')
  Scenario: Check the Account Level Screen UI of Allocation Region
    Given I am on the Account level
    Then I should see the following UI Elements on the Accounts Region Level
      | element name             | element value  |
      | Account name             |                |
      | Account id               |                |
      | Total assets title       | Account assets |
#      | info icon                |               |
      | Total assets amount      |                |
#      | currency label           |               |
      | Allocation button active |                |
      | Class tab                | Class          |
      | Currency tab             | Currency       |
      | Region tab               | Region         |
    And I should see the Card list of different Accounts Region Level


  @S7-AC1-AT2
  @DependsOn('login_userE_for_GPBM317')
  Scenario: Check the statues of Allocation Region
    Given I am on the Account level
    Then I should see the Region tab is active

  @S7-AC1-AT3
  @DependsOn('login_userE_for_GPBM317')
  Scenario: Check the data of each Asset Region they are invested in
    Given I am on the Account level
    When I scroll to first Item of Region list
    Then I check the first item of Region list：Region name、Total asset value 2dp format、Total asset 2dp format percentage

  @NotAutomatable
  Scenario: Check the horizontal bar
  # S7-AC1-AT4
  # Reason: cannot check the bar

  @S7-AC1-AT5
  @DependsOn('login_userE_for_GPBM317')
  Scenario: Check the sequence of the Asset Region By Total Assets
    Given I am on the Account level
    Then I should see the regions are ordered by Total Asset value - largest (first) to smallest (last), then by alphabetical order

  @S7-AC1-AT6
  Scenario: Check the Region Lists
    Given I login as type "account_no_region"
#    When I tap 16th item of Accounts List
    And I tap default Accounts Allocation toggle
    And I tap Account Region button
    Then I should not see that Region listed of Accounts level

