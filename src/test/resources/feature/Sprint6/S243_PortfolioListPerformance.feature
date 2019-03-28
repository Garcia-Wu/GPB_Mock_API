@UK
@Epic_GPBM-2010(Performance)
@Story_GPBM-1998 @Sprint6_iOS
@Story_GPBM-2267 @Sprint6_aOS

Feature: Portfolio List Performance

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S243-AC1-AT2
  Scenario:Check the performance UI in Portfolio list when TWRR % figure is negative
    Given I login as type "portfolio_list_performance_has_negative"
    Then I should see the portfolio list specific item following datas: a downward pointing chevron、TWRR % figure with a symbol -

  @S243-AC1-AT1
  Scenario:Check the performance UI in Portfolio list when TWRR % figure is positive
    Given I login as type "portfolio_list_performance_has_positive"
    Then I should see the portfolio list specific item following datas: a upward pointing chevron、a positive TWRR % figure

  @S243-AC1-AT3
  @SIT
  Scenario:Check the 2dp format of TWRR % figure in portfolio list
    Given I login as type "portfolio_list_has_deserved_item"
    Then I should see the portfolio list total all item following datas: TWRR % figure are recorded as % to 2.d.p

  @S243-AC1-AT4
  Scenario:Check portfolio list whether there is no - symbol and no chevron when the TWRR % figure is 0.00%
    Given I login as type "portfolio_list_performance_has_zero"
    Then the portfolio list specific item TWRR % figure is 0.00%
    And I should see portfolio list specific item is no - symbol and no chevron