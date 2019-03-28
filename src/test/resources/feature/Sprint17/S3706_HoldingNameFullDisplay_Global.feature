@Epic_GPBM-1094(Holdings)
@Story_GPBM-3706 @Sprint17_iOS
@Story_GPBM-3727 @Sprint17_aOS

Feature: Holding name full display - Global

  As a client, I would like to see the holding full name in the app,
  so I can identify the holding I am looking at.

  @HK @SG @UK
  @SIT
  Scenario: I am on the overview allocation holding detail screen for GPBM-1094
    Given I login as type "overview_class_has_positive"
    When I tap on the Allocation toggle
    And I tap first item of class list
    And I tap first item of allocation holding list
    Then I should on the allocation holding details

  @HK @SG @UK
  @SIT
  @3706-AC1-AT1
  @DependsOn('I_am_on_the_overview_allocation_holding_detail_screen_for_GPBM-1094')
  Scenario: Check the back button name in the overview allocation holding detail page
    Given I am on the allocation holding details
    Then I can see the holding detail back button label is "Overview"

  @HK @SG @UK
  @SIT
  @3706-AC1-AT2
  @DependsOn('I_am_on_the_overview_allocation_holding_detail_screen_for_GPBM-1094')
  Scenario: Check whether I can back to the overview allocation holding list view page when I tap the back button in holding detail page
    Given I am on the allocation holding details
    When I tap the holding detail back button
    Then I should on the allocation holding list

  @HK @SG @UK
  @SIT
  Scenario: I am on the account allocation holding detail screen for GPBM-1094
    Given I login as type "account_currency_has_positive"
    When I tap on the Allocation toggle
    And I tap on Currency tab
    And I tap first item of currency list
    And I tap first item of allocation holding list
    Then I should on the allocation holding details

  @HK @SG @UK
  @SIT
  @3706-AC2-AT1
  @DependsOn('I_am_on_the_account_allocation_holding_detail_screen_for_GPBM-1094')
  Scenario: Check the back button name in the account allocation holding detail page
    Given I am on the allocation holding details
    Then I can see the holding detail back button label of the current Account name

  @HK @SG @UK
  @SIT
  @3706-AC2-AT2
  @DependsOn('I_am_on_the_account_allocation_holding_detail_screen_for_GPBM-1094')
  Scenario: Check whether I can back to the account allocation holding list view page when I tap the back button in holding detail page
    Given I am on the allocation holding details
    When I tap the holding detail back button
    Then I should on the allocation holding list

  @UK
  @SIT
  Scenario: I am on the portfolio allocation holding detail screen for GPBM-1094
    Given I login as type "portfolio_region_has_positive"
    When I tap on the Allocation toggle
    And I tap on Region tab
    And I tap first item of region list
    And I tap first item of allocation holding list
    Then I should on the allocation holding details

  @UK
  @SIT
  @3706-AC3-AT1
  @DependsOn('I_am_on_the_portfolio_allocation_holding_detail_screen_for_GPBM-1094')
  Scenario: Check the back button name in the portfolio allocation holding detail page
    Given I am on the allocation holding details
    Then I can see the holding detail back button label of the current Portfolio name

  @UK
  @SIT
  @3706-AC3-AT2
  @DependsOn('I_am_on_the_portfolio_allocation_holding_detail_screen_for_GPBM-1094')
  Scenario: Check whether I can back to the portfolio allocation holding list view page when I tap the back button in holding detail page
    Given I am on the allocation holding details
    When I tap the holding detail back button
    Then I should on the allocation holding list
