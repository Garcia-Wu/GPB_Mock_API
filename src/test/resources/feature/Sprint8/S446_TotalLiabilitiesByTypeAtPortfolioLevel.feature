@HK @SG
@Epic_GPBM-460(Liabilities)
@Story_GPBM-2398 @Sprint8_iOS
@Story_GPBM-2835 @Sprint8_aOS

Feature: Total Liabilities by Type at Portfolio level

  As a client I want to be able to see the total value of the liabilities I own within each of my Portfolios by Type, so that I understand my liabilities by type

  @S446-AC1-AT1
  Scenario: Check Show Group by liability type toggle
    Given I login as type "portfolio_has_group_by_liability_type"
    When I tap on portfolio "Liabilities" tab
    Then I should see a toggle above the liabilities list labelled "Group by liability type"
    And the default state of this toggle should be INACTIVE every time the user starts a new app session

  @S446-AC1-AT2
  @SIT
  @DependsOn('Check_Show_Group_by_liability_type_toggle')
  Scenario: Check whether the liabilities list order by portfolio base currency value "Given client is viewing the libiltiy list
    Given I am see a toggle above the liabilities list labelled "Group by liability type"
    Then the liabilities should be ordered by base currency of the portfolio value (largest absolute value first,smallest last )

  @S446-AC1-AT3
  @SIT
  Scenario: Check hide "Group by liability type" toggle
    Given I login as type "portfolio_hide_group_by_liability_type"
    When I tap on portfolio "Liabilities" tab
    Then show a sub-header labelled with the liability type value and sum total of all liabilities in portfolio base currency value for that type when "Group by liability type" toggle hide

  @S446-AC1-AT4
  @SIT
  Scenario: Check Turn on Group by liability type toggle Given Client is logged in
    Given I login as type "portfolio_has_group_by_liability_type"
    When I tap on portfolio "Liabilities" tab
    And I tap on liabilities toggle on
    Then the Group by liability type toggle should became ACTIVE
    And the liabilities list should be grouped by Type
    And at the top of each grouping of liabilities should be a sub-header labelled with liability Type value and sum total of all liabilities in portfolio base currency value for that type

#    header 排序
  @S446-AC1-AT5
  @SIT
  @DependsOn('Check_Turn_on_Group_by_liability_type_toggle_Given_Client_is_logged_in')
  Scenario: Check whether the type order by the sum total of all liabilities "Given client is viewing the libiltiy list
    Given the "Group by liability type toggle" is ACTIVE
    Then the types should be ordered by the sum total of all liabilities in portfolio base currency within each type(Largest absolute value first, smallest last)

#    子类排序
  @S446-AC1-AT6
  @SIT
  @DependsOn('Check_Turn_on_Group_by_liability_type_toggle_Given_Client_is_logged_in')
  Scenario: Check whether the liabilities within each type order Total in base currency of the portfolio value
    Given the "Group by liability type toggle" is ACTIVE
    Then the liabilities within each type should be ordered by Total in base currency of the portfolio value (largest absolute value first,smallest last )

  @S446-AC1-AT7
  @DependsOn('Check_Turn_on_Group_by_liability_type_toggle_Given_Client_is_logged_in')
  Scenario: Check the Group by liability type toggle is not a sticky header in the list
    Given the "Group by liability type toggle" is ACTIVE
    Then the Group by liability type toggle should NOT be a sticky header in the list

  @S446-AC1-AT8
  @DependsOn('Check_Turn_on_Group_by_liability_type_toggle_Given_Client_is_logged_in')
  Scenario: Check turn off Group by liability type toggle Given Client is logged in
    Given the "Group by liability type toggle" is ACTIVE
    When I tap on portfolio "Liabilities" tab off
    Then The toggle should become INACTIVE
    And the list of liabilities should return to the default state where all liabilities are listed by Total in base currency of the Portfolio value
    And liabilities listed should NOT be grouped by Type in that portfolio

  @S446-AC1-AT9
  @DependsOn('Check_turn_off_Group_by_liability_type_toggle_Given_Client_is_logged_in')
  Scenario: Check the Group by liability type toggle is not a sticky header in the list when the toggle is inactive
    Given the "Group by liability type toggle" is INACTIVE
    Then the Group by liability type toggle should NOT be a sticky header in the list

  @S446-AC1-AT10
  Scenario: Check whether the status of toggle can be remember
    Given I login as type "portfolio_has_group_by_liability_type"
    And I tap first item of Accounts list
    And I tap first item of Portfolios list
    And I tap on portfolio "Liabilities" tab
    And I tap on liabilities toggle on
    And I swipe left to other portfolio
    When I swipe right the top pips
    Then the Group by liability type toggle should became ACTIVE

  @S446-AC1-AT11
  Scenario:Check whether the status of toggle can be remember when return from Account level
    Given I login as type "portfolio_has_group_by_liability_type"
    And I tap first item of Accounts list
    And I tap first item of Portfolios list
    And I tap on portfolio "Liabilities" tab
    And I tap on liabilities toggle on
    And I come back to the Account Level
    And I tap first item of Portfolios list
    And I tap on portfolio "Liabilities" tab
    Then the Group by liability type toggle should became ACTIVE

  @S446-AC1-AT12
  @DependsOn('Check_whether_the_status_of_toggle_can_be_remember_when_return_from_Account_level')
  Scenario: Check whether the status of toggle can be remember when back from detail view
    Given the "Group by liability type toggle" is ACTIVE
    When I select first sub liability to go to the detail view
    And I taps on the back button labelled with Portfolio name value
    Then the Group by liability type toggle should became ACTIVE

  @S446-AC1-AT13
  Scenario: Check the liability list can be change when swap the pips
    Given I login as type "portfolio_swap_left_liability_list_changed"
#    And I tap first item of Accounts list
#    And I taps on 2nd items in Portfolio list
#    And I tap on portfolio "Liabilities" tab
    When I swipe left to other portfolio for liability list
    Then I should see the liability list will be changed
#    And the content is relavent to that Portfolio