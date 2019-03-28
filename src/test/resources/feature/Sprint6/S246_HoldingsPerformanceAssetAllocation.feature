@UK
@Epic_GPBM-2010(Performance)
@Story_GPBM-2080 @Sprint6_iOS
@Story_GPBM-2271 @Sprint6_aOS

Feature: Holdings performance Asset Allocation

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

#  Overview   Class
  @S246-AC1-AT1
  Scenario:Check the Performance UI in Overview Asset Class Holding list when there is a upward pointing chevron
    Given I login as type "overview_allocation_class_holding_has_positive"
    Then I can view the allocation specific item holding following information:a upward pointing chevron、a positive % figure

  @S246-AC1-AT2
  Scenario:Check the Performance UI in Overview Asset Class Holding list when there is a downward pointing chevron
    Given I login as type "overview_allocation_class_holding_has_negative"
    Then I can view the allocation specific item holding following information:a downward pointing chevron、a negative % figure with a symbol -

  @S246-AC1-AT4
  Scenario:Check Overview Asset Class whether there is no - symbol and no chevron when the % figure is 0.00%
    Given I login as type "overview_allocation_class_holding_has_zero"
    Then the allocation specific item holding % figure is 0.00%
    And I should see allocation specific item holding there is no - symbol and no chevron

  @S246-AC1-AT3
  @SIT
  Scenario:Check the 2dp format of % figure in Overview Asset Class Holding list
    Given I login as type "overview_allocation_class_holding_has_deserved_item"
    Then I can view the allocation holding total all item following information:2dp format of % figure

#  Overview   SubClass
  @S246-AC2-AT1
  Scenario:Check the Performance UI in Overview Sub-Asset Class Holding list when there is a upward pointing chevron
    Given I login as type "overview_allocation_subClass_holding_has_positive"
    Then I can view the allocation specific item holding following information:a upward pointing chevron、a positive % figure

  @S246-AC2-AT2
  Scenario:Check the Performance UI in Overview Sub-Asset Class Holding list when there is a downward pointing chevron
    Given I login as type "overview_allocation_subClass_holding_has_negative"
    Then I can view the allocation specific item holding following information:a downward pointing chevron、a negative % figure with a symbol -

  @S246-AC2-AT4
  Scenario:Check Overview SubAsset Class whether there is no - symbol and no chevron when the % figure is 0.00%
    Given I login as type "overview_allocation_subClass_holding_has_zero"
    Then the allocation specific item holding % figure is 0.00%
    And I should see allocation specific item holding there is no - symbol and no chevron

  @S246-AC2-AT3
  @SIT
  Scenario:Check the 2dp format of % figure in Overview SubAsset Class Holding list
    Given I login as type "overview_allocation_subClass_holding_has_deserved_item"
    Then I can view the allocation holding total all item following information:2dp format of % figure

#  Overview   Currency
  @S246-AC3-AT1
  Scenario:Check the Performance UI in Overview Currency Holding list when there is a upward pointing chevron
    Given I login as type "overview_allocation_currency_holding_has_positive"
    Then I can view the allocation specific item holding following information:a upward pointing chevron、a positive % figure

  @S246-AC3-AT2
  Scenario:Check the Performance UI in Overview Currency Holding list when there is a downward pointing chevron
    Given I login as type "overview_allocation_currency_holding_has_negative"
    Then I can view the allocation specific item holding following information:a downward pointing chevron、a negative % figure with a symbol -

  @S246-AC3-AT4
  Scenario:Check Overview Currency whether there is no - symbol and no chevron when the % figure is 0.00%
    Given I login as type "overview_allocation_currency_holding_has_zero"
    Then the allocation specific item holding % figure is 0.00%
    And I should see allocation specific item holding there is no - symbol and no chevron

  @S246-AC3-AT3
  @SIT
  Scenario:Check the 2dp format of % figure in Overview Currency Holding list
    Given I login as type "overview_allocation_currency_holding_has_deserved_item"
    Then I can view the allocation holding total all item following information:2dp format of % figure

#  Overview   Region
  @S246-AC4-AT1
  Scenario:Check the Performance UI in Overview Region Holding list when there is a upward pointing chevron
    Given I login as type "overview_allocation_region_holding_has_positive"
    Then I can view the allocation specific item holding following information:a upward pointing chevron、a positive % figure

  @S246-AC4-AT2
  Scenario:Check the Performance UI in Overview Region Holding list when there is a downward pointing chevron
    Given I login as type "overview_allocation_region_holding_has_negative"
    Then I can view the allocation specific item holding following information:a downward pointing chevron、a negative % figure with a symbol -

  @S246-AC4-AT4
  Scenario:Check Overview Region whether there is no - symbol and no chevron when the % figure is 0.00%
    Given I login as type "overview_allocation_region_holding_has_zero"
    Then the allocation specific item holding % figure is 0.00%
    And I should see allocation specific item holding there is no - symbol and no chevron

  @S246-AC4-AT3
  @SIT
  Scenario:Check the 2dp format of % figure in Overview Region Holding list
    Given I login as type "overview_allocation_region_holding_has_deserved_item"
    Then I can view the allocation holding total all item following information:2dp format of % figure

# Account Class
  @S246-AC5-AT1
  Scenario:Check the Performance UI in Account Asset Class Holding list when there is a upward pointing chevron
    Given I login as type "account_allocation_class_holding_has_positive"
    Then I can view the allocation specific item holding following information:a upward pointing chevron、a positive % figure

  @S246-AC5-AT2
  Scenario:Check the Performance UI in Account Asset Class Holding list when there is a downward pointing chevron
    Given I login as type "account_allocation_class_holding_has_negative"
    Then I can view the allocation specific item holding following information:a downward pointing chevron、a negative % figure with a symbol -

  @S246-AC5-AT4
  Scenario:Check Account Asset Class whether there is no - symbol and no chevron when the % figure is 0.00%
    Given I login as type "account_allocation_class_holding_has_zero"
    Then the allocation specific item holding % figure is 0.00%
    And I should see allocation specific item holding there is no - symbol and no chevron

  @S246-AC5-AT3
  @SIT
  Scenario:Check the 2dp format of % figure in Account Asset Class Holding list
    Given I login as type "account_allocation_class_holding_has_deserved_item"
    Then I can view the allocation holding total all item following information:2dp format of % figure

#  Account  Subclass
  @S246-AC6-AT1
  Scenario:Check the Performance UI in Account Sub-Asset Class Holding list when there is a upward pointing chevron
    Given I login as type "account_allocation_subClass_holding_has_positive"
    Then I can view the allocation specific item holding following information:a upward pointing chevron、a positive % figure

  @S246-AC6-AT2
  Scenario:Check the Performance UI in Account Sub-Asset Class Holding list when there is a downward pointing chevron
    Given I login as type "account_allocation_subClass_holding_has_negative"
    Then I can view the allocation specific item holding following information:a downward pointing chevron、a negative % figure with a symbol -

  @S246-AC6-AT4
  Scenario:Check Account SubAsset Class whether there is no - symbol and no chevron when the % figure is 0.00%
    Given I login as type "account_allocation_subClass_holding_has_zero"
    Then the allocation specific item holding % figure is 0.00%
    And I should see allocation specific item holding there is no - symbol and no chevron

  @S246-AC6-AT3
  @SIT
  Scenario:Check the 2dp format of % figure in Account SubAsset Class Holding list
    Given I login as type "account_allocation_subClass_holding_has_deserved_item"
    Then I can view the allocation holding total all item following information:2dp format of % figure

#  Account  Currency
  @S246-AC7-AT1
  Scenario:Check the Performance UI in Account Currency Holding list when there is a upward pointing chevron
    Given I login as type "account_allocation_currency_holding_has_positive"
    Then I can view the allocation specific item holding following information:a upward pointing chevron、a positive % figure

  @S246-AC7-AT2
  Scenario:Check the Performance UI in Account Currency Holding list when there is a downward pointing chevron
    Given I login as type "account_allocation_currency_holding_has_negative"
    Then I can view the allocation specific item holding following information:a downward pointing chevron、a negative % figure with a symbol -

  @S246-AC7-AT4
  Scenario:Check Account Currency whether there is no - symbol and no chevron when the % figure is 0.00%
    Given I login as type "account_allocation_currency_holding_has_zero"
    Then the allocation specific item holding % figure is 0.00%
    And I should see allocation specific item holding there is no - symbol and no chevron

  @S246-AC7-AT3
  @SIT
  Scenario:Check the 2dp format of % figure in Account Currency Holding list
    Given I login as type "account_allocation_currency_holding_has_deserved_item"
    Then I can view the allocation holding total all item following information:2dp format of % figure

#  Account  Region
  @S246-AC8-AT1
  Scenario:Check the Performance UI in Account Region Holding list when there is a upward pointing chevron
    Given I login as type "account_allocation_region_holding_has_positive"
    Then I can view the allocation specific item holding following information:a upward pointing chevron、a positive % figure

  @S246-AC8-AT2
  Scenario:Check the Performance UI in Account Region Holding list when there is a downward pointing chevron
    Given I login as type "account_allocation_region_holding_has_negative"
    Then I can view the allocation specific item holding following information:a downward pointing chevron、a negative % figure with a symbol -

  @S246-AC8-AT4
  Scenario:Check Account Region whether there is no - symbol and no chevron when the % figure is 0.00%
    Given I login as type "account_allocation_region_holding_has_zero"
    Then the allocation specific item holding % figure is 0.00%
    And I should see allocation specific item holding there is no - symbol and no chevron

  @S246-AC8-AT3
  @SIT
  Scenario:Check the 2dp format of % figure in Account Region Holding list
    Given I login as type "account_allocation_region_holding_has_deserved_item"
    Then I can view the allocation holding total all item following information:2dp format of % figure

# Portfolio Class
  @S246-AC9-AT1
  Scenario:Check the Performance UI in Portfolio Asset Class Holding list when there is a upward pointing chevron
    Given I login as type "portfolio_allocation_class_holding_has_positive"
    Then I can view the allocation specific item holding following information:a upward pointing chevron、a positive % figure

  @S246-AC9-AT2
  Scenario:Check the Performance UI in Portfolio Asset Class Holding list when there is a downward pointing chevron
    Given I login as type "portfolio_allocation_class_holding_has_negative"
    Then I can view the allocation specific item holding following information:a downward pointing chevron、a negative % figure with a symbol -

  @S246-AC9-AT4
  Scenario:Check Portfolio Asset Class whether there is no - symbol and no chevron when the % figure is 0.00%
    Given I login as type "portfolio_allocation_class_holding_has_zero"
    Then the allocation specific item holding % figure is 0.00%
    And I should see allocation specific item holding there is no - symbol and no chevron

  @S246-AC9-AT3
  @SIT
  Scenario:Check the 2dp format of % figure in Portfolio Asset Class Holding list
    Given I login as type "portfolio_allocation_class_holding_has_deserved_item"
    Then I can view the allocation holding total all item following information:2dp format of % figure

#   Portfolio Sub class
  @S246-AC10-AT1
  Scenario:Check the Performance UI in Portfolio Sub-Asset Class Holding list when there is a upward pointing chevron
    Given I login as type "portfolio_allocation_subClass_holding_has_positive"
    Then I can view the allocation specific item holding following information:a upward pointing chevron、a positive % figure

  @S246-AC10-AT2
  Scenario:Check the Performance UI in Portfolio Sub-Asset Class Holding list when there is a downward pointing chevron
    Given I login as type "portfolio_allocation_subClass_holding_has_negative"
    Then I can view the allocation specific item holding following information:a downward pointing chevron、a negative % figure with a symbol -

  @S246-AC10-AT4
  Scenario:Check Portfolio SubAsset Class whether there is no - symbol and no chevron when the % figure is 0.00%
    Given I login as type "portfolio_allocation_subClass_holding_has_zero"
    Then the allocation specific item holding % figure is 0.00%
    And I should see allocation specific item holding there is no - symbol and no chevron

  @S246-AC10-AT3
  @SIT
  Scenario:Check the 2dp format of % figure in Portfolio SubAsset Class Holding list
    Given I login as type "portfolio_allocation_subClass_holding_has_deserved_item"
    Then I can view the allocation holding total all item following information:2dp format of % figure

#   Portfolio Currency
  @S246-AC11-AT1
  Scenario:Check the Performance UI in Portfolio Currency Holding list when there is a upward pointing chevron
    Given I login as type "portfolio_allocation_currency_holding_has_positive"
    Then I can view the allocation specific item holding following information:a upward pointing chevron、a positive % figure

  @S246-AC11-AT2
  Scenario:Check the Performance UI in Portfolio Currency Holding list when there is a downward pointing chevron
    Given I login as type "portfolio_allocation_currency_holding_has_negative"
    Then I can view the allocation specific item holding following information:a downward pointing chevron、a negative % figure with a symbol -

  @S246-AC11-AT4
  Scenario:Check Portfolio Currency whether there is no - symbol and no chevron when the % figure is 0.00%
    Given I login as type "portfolio_allocation_currency_holding_has_zero"
    Then the allocation specific item holding % figure is 0.00%
    And I should see allocation specific item holding there is no - symbol and no chevron

  @S246-AC11-AT3
  @SIT
  Scenario:Check the 2dp format of % figure in Portfolio Currency Holding list
    Given I login as type "portfolio_allocation_currency_holding_has_deserved_item"
    Then I can view the allocation holding total all item following information:2dp format of % figure

#  Portfolio  Region
  @S246-AC12-AT1
  Scenario:Check the Performance UI in Portfolio Region Holding list when there is a upward pointing chevron
    Given I login as type "portfolio_allocation_region_holding_has_positive"
    Then I can view the allocation specific item holding following information:a upward pointing chevron、a positive % figure

  @S246-AC12-AT2
  Scenario:Check the Performance UI in Portfolio Region Holding list when there is a downward pointing chevron
    Given I login as type "portfolio_allocation_region_holding_has_negative"
    Then I can view the allocation specific item holding following information:a downward pointing chevron、a negative % figure with a symbol -

  @S246-AC12-AT4
  Scenario:Check Portfolio Region whether there is no - symbol and no chevron when the % figure is 0.00%
    Given I login as type "portfolio_allocation_region_holding_has_zero"
    Then the allocation specific item holding % figure is 0.00%
    And I should see allocation specific item holding there is no - symbol and no chevron

  @S246-AC12-AT3
  @SIT
  Scenario:Check the 2dp format of % figure in Portfolio Region Holding list
    Given I login as type "portfolio_allocation_region_holding_has_deserved_item"
    Then I can view the allocation holding total all item following information:2dp format of % figure