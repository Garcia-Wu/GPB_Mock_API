@UK
@Epic_GPBM-2010(Performance)
@Story_GPBM-2007 @Sprint6_iOS
@Story_GPBM-2269 @Sprint6_aOS

Feature: Holdings Performance-Performance List

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S245-AC1-AT2
  Scenario:Check the Performance UI in Portfolio Holding list when there is a downward pointing chevron
    Given I login as type "portfolio_holding_list_performance_has_negative"
    Then I should view the holdings list specific item following information: a downward pointing chevron、a negative % figure with a symbol -

  @S245-AC1-AT1
  Scenario:Check the Performance UI in Portfolio Holding list when there is a upward pointing chevron
    Given I login as type "portfolio_holding_list_performance_has_positive"
    Then I should view the holdings list specific item following information: a upward pointing chevron、a positive % figure

  @S245-AC1-AT4
  Scenario:Check holdings list whether there is no - symbol and no chevron when the TWRR % figure is 0.00%
    Given I login as type "portfolio_holding_list_performance_has_zero"
    Then the holdings list specific item TWRR % figure is 0.00%
    And I should see holdings list specific item there is no - symbol and no chevron

  @S245-AC1-AT3
  @SIT
  Scenario:Check the 2dp format of TWRR % figure in Portfolio Holding list
    Given I login as type "portfolio_holding_list_performance_has_deserved_item"
    Then I should view the holdings list total all item following datas: 2dp format of TWRR % figure