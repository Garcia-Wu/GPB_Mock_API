@HK @SG
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-2807 @Sprint8_iOS
@Story_GPBM-2822 @Sprint8_aOS

Feature: Asset exposure - ASIA - No Region view

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S460-AC1-AT1
  Scenario:Check whether I can not able to view the Region tap when I am viewing allocation Assets at the Overview level
    Given I login as type "has_account"
    When I tap Asset Overview Allocation toggle
    Then I can see the Class and Currency tap at overview level
    And I should not see the Region tap at overview level

  @S460-AC1-AT2
  Scenario:Check whether I can not able to view the Region tap when I am viewing allocation Assets at the Account level
    Given I login as type "more_portfolio"
#    When I tap first item of Accounts list
    And I tap on the Allocation toggle
    Then I can see the Class and Currency tap at account level
    And I should not see the Region tap at account level

  @S460-AC1-AT3
  @DependsOn('Check_whether_I_can_not_able_to_view_the_Region_tap_when_I_am_viewing_allocation_Assets_at_the_Account_level')
  Scenario:Check whether I can not able to view the Region tap when I am viewing allocation Assets at the Account level and swap left or right the pips
    Given I am on the Accounts Allocation Screen
    When I swipe left to other account
    Then I can see the Class and Currency tap at account level
    And I should not see the Region tap at account level

  @S460-AC1-AT4
  Scenario:Check whether I can not able to view the Region tap when I am viewing allocation Assets at the Portfolio level
    Given I login as type "has_transactions"
    When I tap first item of Accounts list
    And I tap first item of Portfolios list
    And I tap on the Allocation toggle
    Then I can see the Class and Currency tap at portfolio level
    And I should not see the Region tap at portfolio level

  @S460-AC1-AT5
  @DependsOn('Check_whether_I_can_not_able_to_view_the_Region_tap_when_I_am_viewing_allocation_Assets_at_the_Portfolio_level')
  Scenario:Check whether I can not able to view the Region tap when I am viewing allocation Assets at the Portfolio level and swap left or right the pips
    Given I am on the Portfolios Allocation Screen
    When I swipe left to other portfolio
    Then I can see the Class and Currency tap at portfolio level
    And I should not see the Region tap at portfolio level