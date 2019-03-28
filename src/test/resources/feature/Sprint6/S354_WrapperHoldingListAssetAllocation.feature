@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-2190 @Sprint6_iOS
@Story_GPBM-2191 @Sprint6_aOS

Feature: Wrapper Holding list Asset allocation

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.


  #  Overview Class
  @UK
  @SIT
  Scenario: Asset Class Holding wrapper at Overview
    Given I login as type "overview_has_allocation_class_holdings"
    Then I should see the allocation holding list

  @HK @SG @UK
  @S354-AC1-AT1
  @DependsOn('Asset_Class_Holding_wrapper_at_Overview')
  Scenario:Check the Asset Class Holding wrapper UI at Overview
    Given I am see the allocation holding list
    Then I should see the allocation Holding wrapper following information displayed:
      | element name       | element value |
      | Back button        | Overview      |
      | Name value         |               |
      | Total assets value |               |
#      | GBP                      |               |
#      | Currency conversion icon |               |
      | More menu icon     |               |
      | Holdings label     | Holdings      |

  @HK @SG @UK
  @S354-AC1-AT2
  @SIT
  @DependsOn('Asset_Class_Holding_wrapper_at_Overview')
  Scenario:Check the GBP ISO 3 code in Overview Asset Class Holding wrapper
    Given I am see the allocation holding list
    Then I should see overview holding wrapper GBP ISO 3 code

  #   Overview Sub class
  @UK
  @SIT
  Scenario: Sub-Asset Class Holding wrapper at Overview
    Given I login as type "overview_has_allocation_subClass_holdings"
    Then I should see the allocation holding list

  @HK @SG @UK
  @S354-AC2-AT1
  @DependsOn('Sub-Asset_Class_Holding_wrapper_at_Overview')
  Scenario:Check the Sub-Asset Class Holding wrapper UI at Overview
    Given I am see the allocation holding list
    Then I should see the allocation Holding wrapper following information displayed:
      | element name       | element value |
      | Back button        | Overview      |
      | Name value         |               |
      | Total assets value |               |
#      | GBP                      |               |
#      | Currency conversion icon |               |
      | More menu icon     |               |
      | Holdings label     |               |

  @HK @SG @UK
  @S354-AC2-AT2
  @SIT
  @DependsOn('Sub-Asset_Class_Holding_wrapper_at_Overview')
  Scenario:Check the GBP ISO 3 code in Overview Sub-Asset Class Holding wrapper
    Given I am see the allocation holding list
    Then I should see overview holding wrapper GBP ISO 3 code

  #  Overview  Currency
  @UK
  @SIT
  Scenario: Currency Holding wrapper at Overview
    Given I login as type "overview_has_allocation_currency_holdings"
    Then I should see the allocation holding list

  @HK @SG @UK
  @S354-AC3-AT1
  @DependsOn('Currency_Holding_wrapper_at_Overview')
  Scenario:Check the Currency Holding wrapper UI at Overview
    Given I am see the allocation holding list
    Then I should see the allocation Holding wrapper following information displayed:
      | element name       | element value |
      | Back button        | Overview      |
      | Name value         |               |
      | Total assets value |               |
#      | GBP                      |               |
#      | Currency conversion icon |               |
      | More menu icon     |               |
      | Holdings label     | Holdings      |

  @HK @SG @UK
  @S354-AC3-AT2
  @SIT
  @DependsOn('Currency_Holding_wrapper_at_Overview')
  Scenario:Check the GBP ISO 3 code in Overview Currency Holding wrapper
    Given I am see the allocation holding list
    Then I should see overview holding wrapper GBP ISO 3 code

  #  Overview  Region
  @UK
  @SIT
  Scenario: Region Holding wrapper at Overview
    Given I login as type "overview_has_allocation_region_holdings"
    Then I should see the allocation holding list

  @UK
  @S354-AC4-AT1
  @DependsOn('Region_Holding_wrapper_at_Overview')
  Scenario:Check the Region Holding wrapper UI at Overview
    Given I login as type "overview_has_allocation_region_holdings"
    Then I should see the allocation Holding wrapper following information displayed:
      | element name       | element value |
      | Back button        | Overview      |
      | Name value         |               |
      | Total assets value |               |
#      | GBP                      |               |
#      | Currency conversion icon |               |
      | More menu icon     |               |
      | Holdings label     | Holdings      |

  @UK
  @S354-AC4-AT2
  @SIT
  @DependsOn('Region_Holding_wrapper_at_Overview')
  Scenario:Check the GBP ISO 3 code in Overview Region Holding wrapper
    Given I am see the allocation holding list
    Then I should see overview holding wrapper GBP ISO 3 code

  #    Account Class
  @HK @SG @UK
  @S354-AC5-AT1
  Scenario:Check the Asset Class Holding wrapper UI at Account
    Given I login as type "account_has_allocation_class_holdings"
    Then I should see the allocation Holding wrapper following information displayed:
      | element name       | element value |
      | Back button        |               |
      | Name value         |               |
      | Total assets value |               |
#      | account reference currency                                           |               |
#      | Currency conversion icon |               |
      | More menu icon     |               |
      | Holdings label     | Holdings      |


   #  Account  Subclass
  @HK @SG @UK
  @S354-AC6-AT1
  Scenario:Check the Sub-Asset Class Holding wrapper UI at Account
    Given I login as type "account_has_allocation_subClass_holdings"
    Then I should see the allocation Holding wrapper following information displayed:
      | element name       | element value |
      | Back button        |               |
      | Name value         |               |
      | Total assets value |               |
#      | account reference currency                                           |               |
#      | Currency conversion icon |               |
      | More menu icon     |               |
      | Holdings label     | Holdings      |


  #  Account  Currency
  @UK
  @SIT
  Scenario: Currency Holding wrapper at Account
    Given I login as type "account_has_allocation_currency_holdings"
    Then I should see the allocation holding list

  @HK @SG @UK
  @S354-AC7-AT1
  @DependsOn('Currency_Holding_wrapper_at_Account')
  Scenario:Check the Currency Holding wrapper UI at Account
    Given I am see the allocation holding list
    Then I should see the allocation Holding wrapper following information displayed:
      | element name       | element value |
      | Back button        |               |
      | Name value         |               |
      | Total assets value |               |
#      | account reference currency                                           |               |
#      | Currency conversion icon |               |
      | More menu icon     |               |
      | Holdings label     | Holdings      |

  @HK @SG @UK
  @S354-AC7-AT2
  @SIT
  @DependsOn('Currency_Holding_wrapper_at_Account')
  Scenario:Check the ISO 3 code of account reference currency in Account Currency Holding wrapper
    Given I am see the allocation holding list
    Then I should see account holding wrapper ISO 3 code of account reference currency

#  Account  Region
  @UK
  @SIT
  Scenario: Region Holding wrapper at Account
    Given I login as type "account_has_allocation_region_holdings"
    Then I should see the allocation holding list

  @UK
  @S354-AC8-AT1
  @DependsOn('Region_Holding_wrapper_at_Account')
  Scenario:Check the Region Holding wrapper UI at Account
    Given I am see the allocation holding list
    Then I should see the allocation Holding wrapper following information displayed:
      | element name       | element value |
      | Back button        |               |
      | Name value         |               |
      | Total assets value |               |
#      | account reference currency                                           |               |
#      | Currency conversion icon |               |
      | More menu icon     |               |
      | Holdings label     | Holdings      |

  @UK
  @S354-AC8-AT2
  @SIT
  @DependsOn('Region_Holding_wrapper_at_Account')
  Scenario:Check the ISO 3 code of account reference currency in Account Region Holding wrapper
    Given I am see the allocation holding list
    Then I should see account holding wrapper ISO 3 code of account reference currency


# Portfolio Class
  @UK
  @SIT
  Scenario: Asset Class Holding wrapper at Portfolio
    Given I login as type "portfolio_has_allocation_class_holdings"
    Then I should see the allocation holding list

  @HK @SG @UK
  @S354-AC9-AT1
  @DependsOn('Asset_Class_Holding_wrapper_at_Portfolio')
  Scenario:Check the Asset Class Holding wrapper UI at Portfolio
    Given I am see the allocation holding list
    Then I should see the allocation Holding wrapper following information displayed:
      | element name       | element value |
      | Back button        |               |
      | Name value         |               |
      | Total assets value |               |
#      | portfolio reference currency                                             |               |
#      | Currency conversion icon |               |
      | More menu icon     |               |
      | Holdings label     | Holdings      |

  @HK @SG @UK
  @S354-AC9-AT2
  @SIT
  @DependsOn('Asset_Class_Holding_wrapper_at_Portfolio')
  Scenario:Check the ISO 3 code of portfolio reference currency in Portfolio Asset Class Holding wrapper
    Given I am see the allocation holding list
    Then I should see portfolio holding wrapper ISO 3 code of portfolio reference currency


#  Portfolio  Sub class
  @UK
  @SIT
  Scenario: Sub-Asset Class Holding wrapper at Portfolio
    Given I login as type "portfolio_has_allocation_subClass_holdings"
    Then I should see the allocation holding list

  @HK @SG @UK
  @S354-AC10-AT1
  @DependsOn('Sub-Asset_Class_Holding_wrapper_at_Portfolio')
  Scenario:Check the Sub-Asset Class Holding wrapper UI at Portfolio
    Given I am see the allocation holding list
    Then I should see the allocation Holding wrapper following information displayed:
      | element name       | element value |
      | Back button        |               |
      | Name value         |               |
      | Total assets value |               |
#      | portfolio reference currency                                             |               |
#      | Currency conversion icon |               |
      | More menu icon     |               |
      | Holdings label     | Holdings      |

  @HK @SG @UK
  @S354-AC10-AT2
  @SIT
  @DependsOn('Sub-Asset_Class_Holding_wrapper_at_Portfolio')
  Scenario:Check the ISO 3 code of portfolio reference currency in Portfolio Sub-Asset Class Holding wrapper
    Given I am see the allocation holding list
    Then I should see portfolio holding wrapper ISO 3 code of portfolio reference currency

  #   Portfolio Currency
  @UK
  @SIT
  Scenario: Currency Holding wrapper at Portfolio
    Given I login as type "portfolio_has_allocation_currency_holdings"
    Then I should see the allocation holding list

  @HK @SG @UK
  @S354-AC11-AT1
  @DependsOn('Currency_Holding_wrapper_at_Portfolio')
  Scenario:Check the Currency Holding wrapper UI at Portfolio
    Given I am see the allocation holding list
    Then I should see the allocation Holding wrapper following information displayed:
      | element name       | element value |
      | Back button        |               |
      | Name value         |               |
      | Total assets value |               |
#      | portfolio reference currency                                             |               |
#      | Currency conversion icon |               |
      | More menu icon     |               |
      | Holdings label     | Holdings      |

  @HK @SG @UK
  @S354-AC11-AT2
  @SIT
  @DependsOn('Currency_Holding_wrapper_at_Portfolio')
  Scenario:Check the ISO 3 code of portfolio reference currency in Portfolio Currency Holding wrapper
    Given I am see the allocation holding list
    Then I should see portfolio holding wrapper ISO 3 code of portfolio reference currency

# Portfolio  Region
  @UK
  @S354-AC12-AT1
  Scenario:Check the Region Holding wrapper UI at Portfolio
    Given I login as type "portfolio_has_allocation_region_holdings"
    Then I should see the allocation Holding wrapper following information displayed:
      | element name       | element value |
      | Back button        |               |
      | Name value         |               |
      | Total assets value |               |
#      | portfolio reference currency |               |
#      | Currency conversion icon |               |
      | More menu icon     |               |
      | Holdings label     | Holdings      |