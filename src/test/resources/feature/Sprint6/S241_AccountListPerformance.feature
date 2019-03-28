@UK
@Epic_GPBM-2010(Performance)
@Story_GPBM-2019 @Sprint6_iOS
@Story_GPBM-2265 @Sprint6_aOS
# remove in sprint19 UK
@NotAutomatable

Feature: Account list Performance

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S241-AC1-AT2
  Scenario:Check the performance UI in Account list when TWRR % figure is negative
    Given I login as type "account_list_performance_has_negative"
    Then I should see the account list specific item following datas: a downward pointing chevron、a negative TWRR % figure with a symbol -

  @S241-AC1-AT1
  Scenario:Check the performance UI in Account list when TWRR % figure is positive
    Given I login as type "account_list_performance_has_positive"
    Then I should see the account list specific item following datas: a upward pointing chevron、a positive TWRR % figure

  @S241-AC1-AT3
  @SIT
  Scenario:Check the 2dp format of TWRR % figure in account list
    Given I login as type "account_list_has_deserved_item"
    Then I should see the account list total all item following datas: TWRR % figure are recorded as % to 2.d.p

  @S241-AC1-AT4
  Scenario:Check account list whether there is no - symbol and no chevron when the TWRR % figure is 0.00%
    Given I login as type "account_list_performance_has_zero"
    Then the account list specific item % figure is 0.00%
    And I should see account list specific item there is no - symbol and no chevron