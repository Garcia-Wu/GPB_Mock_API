@HK @SG
@Epic_GPBM-2010(Performance)
@Story_GPBM-3093 @Sprint9_iOS
@Story_GPBM-3145 @Sprint9_aOS

Feature: Holdings - Asia - Performance

  As a client,I want to be able to view the unrealised profit/loss value on my holding lists,
  so that I can see how my holdings are performing

  @S511-AC1-AT1
  Scenario: Check whether I must view an unrealised profit/loss amount in the purchase currency of the holding when the holding template includes a Performance
    Given I login as type "holding_list_first_has_performance_asia"
    Then I must view an unrealised profit/loss amount in the purchase currency of the portfolio holding

  @S511-AC1-AT2
  Scenario: Check whether I must view an unrealised profit/loss amount in the purchase currency of the holding when the holding template includes a Performance when I swipe left or right the portfolio wrapper pips
    Given I login as type "holding_list_swipe_left_first_has_performance_asia"
    When I swipe left to other portfolio
    Then I must view an unrealised profit/loss amount in the purchase currency of the portfolio holding

  @S511-AC1-AT3
  Scenario: Check whether I must not view a performance value when the holding template does not include a Performance value
    Given I login as type "holding_list_first_no_performance_asia"
    Then I must not view a performance value of the portfolio holding

  @S511-AC1-AT4
  Scenario: Check whether I must not view a performance value when the holding template does not include a Performance value when I swipe left or right the portfolio wrapper pips
    Given I login as type "holding_list_swipe_left_first_no_performance_asia"
    When I swipe left to other portfolio
    Then I must not view a performance value of the portfolio holding


  @S511-AC1-AT5
  Scenario: Check whether I must view an unrealised profit/loss amount in the purchase currency of the holding when I drill into Overview allocation Asset Class Holding list
    Given I login as type "overview_allocation_class_holding_list_second_has_performance_asia"
#    When I tap first item of class list
    Then I must view an unrealised profit/loss amount in the purchase currency of the allocation holding

  @S511-AC1-AT14
  Scenario: Check whether I must not view a performance value when I drill into the Overview allocation Asset Class Holdings list
    Given I login as type "overview_allocation_class_holding_list_first_no_performance_asia"
#    When I tap first item of class list
    Then I must not view a performance value at the allocation holding

  @S511-AC1-AT6
  Scenario: Check whether I must view an unrealised profit/loss amount in the purchase currency of the holding when I drill into Overview allocation Sub Asset Class Holding list
    Given I login as type "overview_allocation_subclass_holding_list_second_has_performance_asia"
#    When I tap on "Show Sub-Asset Class" toggle
#    And I tap first Sub-Asset class item at overview screen
    Then I must view an unrealised profit/loss amount in the purchase currency of the allocation holding

  @S511-AC1-AT15
  Scenario: Check whether I must not view a performance value when I drill into the Overview allocation Sub Asset Class Holdings list
    Given I login as type "overview_allocation_subclass_holding_list_first_no_performance_asia"
#    When I tap on overview "Show Sub-Asset Class" toggle to ON
#    And I tap first Sub-Asset class item at overview screen
    Then I must not view a performance value at the allocation holding

  @S511-AC1-AT7
  Scenario: Check whether I must view an unrealised profit/loss amount in the purchase currency of the holding when I drill into Overview allocation Currency Holding list
    Given I login as type "overview_allocation_currency_holding_list_second_has_performance_asia"
#    When I tap Overview Currency tab
#    And I tap first item of Overview currency list
    Then I must view an unrealised profit/loss amount in the purchase currency of the allocation holding

  @S511-AC1-AT16
  Scenario: Check whether I must not view a performance value when I drill into the Overview allocation Currency Holdings list
    Given I login as type "overview_allocation_currency_holding_list_first_no_performance_asia"
#    When I tap Overview Currency tab
#    And I tap first item of Overview currency list
    Then I must not view a performance value at the allocation holding
    
  @S511-AC1-AT8
  Scenario: Check whether I must view an unrealised profit/loss amount in the purchase currency of the holding when I drill into Account allocation Asset Class Holding list
    Given I login as type "account_allocation_class_holding_list_second_has_performance_asia"
#    When I tap first item of class list at account level
    Then I must view an unrealised profit/loss amount in the purchase currency of the allocation holding

  @S511-AC1-AT17
  Scenario: Check whether I must not view a performance value when I drill into the Account allocation Asset Class Holdings list
    Given I login as type "account_allocation_class_holding_list_first_no_performance_asia"
#    When I tap first item of class list at account level
    Then I must not view a performance value at the allocation holding

  @S511-AC1-AT9
  Scenario: Check whether I must view an unrealised profit/loss amount in the purchase currency of the holding when I drill into Account allocation Sub Asset Class Holding list
    Given I login as type "account_allocation_subclass_holding_list_second_has_performance_asia"
#    When I tap on "Show Sub-Asset Class" toggle of Accounts level
#    And I tap first Sub-Asset class item at account level
    Then I must view an unrealised profit/loss amount in the purchase currency of the allocation holding

  @S511-AC1-AT18
  Scenario: Check whether I must not view a performance value when I drill into the Account allocation Sub Asset Class Holdings list
    Given I login as type "account_allocation_subclass_holding_list_first_no_performance_asia"
#    When I tap on account "Show Sub-Asset Class" toggle to ON
#    And I tap first Sub-Asset class item at account level
    Then I must not view a performance value at the allocation holding

  @S511-AC1-AT10
  Scenario: Check whether I must view an unrealised profit/loss amount in the purchase currency of the holding when I drill into Account allocation Currency Holding list
    Given I login as type "account_allocation_currency_holding_list_second_has_performance_asia"
#    When I tap on "Currency" tab of Account Level
#    And I tap first item of currency list
    Then I must view an unrealised profit/loss amount in the purchase currency of the allocation holding

  @S511-AC1-AT19
  Scenario: Check whether I must not view a performance value when I drill into the Account allocation Currency Holdings list
    Given I login as type "account_allocation_currency_holding_list_first_no_performance_asia"
#    When I tap on "Currency" tab of Account Level
#    And I tap first item of currency list
    Then I must not view a performance value at the allocation holding

  @S511-AC1-AT11
  Scenario: Check whether I must view an unrealised profit/loss amount in the purchase currency of the holding when I drill into Portfolio allocation Asset Class Holding list
    Given I login as type "portfolio_allocation_class_holding_list_second_has_performance_asia"
#    When I tap first item of class list at portfolio level
    Then I must view an unrealised profit/loss amount in the purchase currency of the allocation holding

  @S511-AC1-AT20
  Scenario: Check whether I must not view a performance value when I drill into the Portfolio allocation Asset Class Holdings list
    Given I login as type "portfolio_allocation_class_holding_list_first_no_performance_asia"
#    When I tap first item of class list at portfolio level
    Then I must not view a performance value at the allocation holding

  @S511-AC1-AT12
  Scenario: Check whether I must view an unrealised profit/loss amount in the purchase currency of the holding when I drill into Portfolio allocation Sub Asset Class Holding list
    Given I login as type "portfolio_allocation_subclass_holding_list_second_has_performance_asia"
#    When I tap on "Show Sub-Asset Class" toggle of Accounts level
#    And I tap first Sub-Asset class item at account level
    Then I must view an unrealised profit/loss amount in the purchase currency of the allocation holding

  @S511-AC1-AT21
  Scenario: Check whether I must not view a performance value when I drill into the Portfolio allocation Sub Asset Class Holdings list
    Given I login as type "portfolio_allocation_subclass_holding_list_first_no_performance_asia"
#    When I tap on portfolio "Show Sub-Asset Class" toggle to ON
#    And I tap first Sub-Asset class item at account level
    Then I must not view a performance value at the allocation holding

  @S511-AC1-AT13
  Scenario: Check whether I must view an unrealised profit/loss amount in the purchase currency of the holding when I drill into Portfolio allocation Currency Holding list
    Given I login as type "portfolio_allocation_currency_holding_list_second_has_performance_asia"
#    When I tap Portfolio Currency tab
#    And I tap first item of Portfolio currency list
    Then I must view an unrealised profit/loss amount in the purchase currency of the allocation holding

  @S511-AC1-AT22
  Scenario: Check whether I must not view a performance value when I drill into the Portfolio allocation Currency Holdings list
    Given I login as type "portfolio_allocation_currency_holding_list_first_no_performance_asia"
#    When I tap Portfolio Currency tab
#    And I tap first item of Portfolio currency list
    Then I must not view a performance value at the allocation holding
