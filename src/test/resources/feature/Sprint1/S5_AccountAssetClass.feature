@NotAutomatable
# Reason：This function has been modified in sprint14 or sprint15
@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-312 @Sprint1_iOS
@Story_GPBM-728 @Sprint1_aOS

Feature: View asset class breakdown at Account level

  As a client I want to view my asset allocation within one of my accounts,
  so that I have a high level view of my investments by asset class

  Scenario: login userE for GPBM312
    Given I login as type "account_has_class"
#    When I tap first item of Accounts list
    And I tap default Accounts Allocation toggle
    Then I should on the Account level

  @S5-AC1-AT1
  @DependsOn('login_userE_for_GPBM312')
  Scenario: Check the Accounts Level Screen UI
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
    And I should see the Card list of different asset class list

  @S5-AC1-AT2
  @DependsOn('login_userE_for_GPBM312')
  Scenario: Check the status of Allocation Class
    Given I am on the Account level
    Then The Class Button is selected by default

  @S5-AC1-AT3
  @DependsOn('login_userE_for_GPBM312')
  Scenario: Check the data of each asset Class they are invested in
    Given I am on the Account level
    Then I check the first item of class list:Asset Class name、Total asset value 2dp format and Total asset 2dp format percentage

  @NotAutomatable
  Scenario: Check the horizontal bar.
    When dummy
  # S5-AC1-AT4
  # Reason: cannot check the state of Allocation&Class

  @S5-AC1-AT5
  @DependsOn('login_userE_for_GPBM312')
  Scenario: Check the sequence of the asset Classes By Total Assets.
    Given I am on the Account level
    Then I should see the asset classes are ordered by Total Asset value - largest (first) to smallest (last), then by alphabetical order
    #   IOS :Because we can't get the object id

  @S5-AC1-AT6
  Scenario: Check the Asset Class listed
    Given I login as type "account_no_class"
#    When I tap 16th item of Accounts List
    And I tap default Accounts Allocation toggle
    Then I should not see that Asset Class listed