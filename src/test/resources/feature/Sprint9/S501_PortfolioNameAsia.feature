@HK @SG
@Epic_GPBM-410(My_Portfolio)
@Story_GPBM-2919 @Sprint9_iOS
@Story_GPBM-3141 @Sprint9_aOS

Feature: Portfolio names - Asia

  As a client I want to view the Portfolio name,
  so that I can easily differentiate between the accounts

  Scenario: I am view the portfolio list for GPBM-2919
    Given I login as User
      | element name | element value |
      | Name         | userM         |
    When I tap first item of Accounts list
    Then I should on the Account level

  @S501-AC1-AT1
  @DependsOn('I_am_view_the_portfolio_list_for_GPBM-2919')
  Scenario: Check the Discretionary name in portfolio list
    Given I am on the Account level
    Then I can see the following components for discretionary portfolio:
      | element name         | element value |
      | Portfolio name       |               |
      | Portfolio type       | Discretionary |
      | Portfolio identifier |               |

  @S501-AC1-AT2
  @DependsOn('I_am_view_the_portfolio_list_for_GPBM-2919')
  Scenario: Check the Advisory name in portfolio list
    Given I am on the Account level
    Then I can see the following components for Advisory portfolio:
      | element name         | element value |
      | Portfolio name       | Advisory      |
      | Portfolio type       |               |
      | Portfolio identifier |               |

  @S501-AC1-AT4
  @DependsOn('I_am_view_the_portfolio_list_for_GPBM-2919')
  Scenario: Check the Advisory name in portfolio list when I swipe left or right the account wrapper pips
    Given I am on the Account level
    When I swipe left 1th to other account
    Then I should see the Advisory portfolio item include:
      | element name         | element value |
      | Portfolio name       | Advisory      |
      | Portfolio type       |               |
      | Portfolio identifier |               |

  @S501-AC1-AT3
  @DependsOn('I_am_view_the_portfolio_list_for_GPBM-2919')
  Scenario: Check the Discretionary name in portfolio list when I swipe left or right the account wrapper pips
    Given I am on the Account level
    When I swipe left 1th to other account
#    And I slip the portfolio list to the specific portfolio item which is Discretionary portfolio item
    Then I should see the Discretionary portfolio item include:
      | element name         | element value |
      | Portfolio name       |               |
      | Portfolio type       | Discretionary |
      | Portfolio identifier |               |

  Scenario: I am view the Discretionary portfolio wrapper for GPBM-2919
    Given I login as User
      | element name | element value |
      | Name         | userM         |
    When I tap first item of Accounts list
    And I tap second item of Portfolios list
    Then I should on the Portfolios level

  @S501-AC1-AT5
  @DependsOn('I_am_view_the_Discretionary_portfolio_wrapper_for_GPBM-2919')
  Scenario: Check the Discretionary name in portfolio wrapper
    Given I am on the Portfolios level
    Then I can see the following components in Discretionary portfolio wrapper on 2th item:
      | element name   | element value |
      | portfolio name |               |

  @S501-AC1-AT6
  @DependsOn('I_am_view_the_Discretionary_portfolio_wrapper_for_GPBM-2919')
  Scenario: Check the Discretionary name in portfolio wrapper when I swipe left or right the portfolio wrapper pips
    Given I am on the Portfolios level
    When I swipe left 2th to other portfolio
    Then I can see the following components in Discretionary portfolio wrapper on 4th item:
      | element name   | element value |
      | portfolio name |               |

  @S501-AC1-AT9
  @Const(action="click_asset_overlay_close_button")
  @DependsOn('I_am_view_the_Discretionary_portfolio_wrapper_for_GPBM-2919')
  Scenario: Check the Discretionary name in Portfolio assets overlay in portfolio wrapper
    Given I am on the Portfolios level
    When I tap 4th portfolio total asset
    Then I can see the following components for Discretionary portfolio overlay:
      | element name   | element value |
      | portfolio name |               |

  @S501-AC1-AT13
  @Const(action="click_liability_overlay_close_button")
  @DependsOn('I_am_view_the_Discretionary_portfolio_wrapper_for_GPBM-2919')
  Scenario: Check the Discretionary name in Liability overlay in portfolio wrapper
    Given I am on the Portfolios level
    When I tap Portfolio Total Liabilities
    Then I can see the following components for Discretionary portfolio Liability overlay:
      | element name   | element value |
      | portfolio name |               |

  @S501-AC1-AT10
  @Const(action="click_asset_overlay_close_button")
  @DependsOn('I_am_view_the_Discretionary_portfolio_wrapper_for_GPBM-2919')
  Scenario: Check the Discretionary name in Portfolio assets overlay in portfolio wrapper when I swipe left or right the portfolio wrapper pips
    Given I am on the Portfolios level
    When I swipe right 2th to other portfolio
    And I tap 2th portfolio total asset
    Then I can see the following components for Discretionary portfolio overlay:
      | element name   | element value |
      | portfolio name |               |

  @S501-AC1-AT14
  @DependsOn('I_am_view_the_Discretionary_portfolio_wrapper_for_GPBM-2919')
  Scenario: Check the Discretionary name in Liability overlay in portfolio wrapper when I swipe left or right the portfolio wrapper pips
    Given I am on the Portfolios level
    When I tap Portfolio Total Liabilities
    Then I can see the following components for Discretionary portfolio Liability overlay:
      | element name   | element value |
      | portfolio name |               |

  Scenario: I am view the Advisory portfolio wrapper for GPBM-2919
    Given I login as User
      | element name | element value |
      | Name         | userM         |
    When I tap first item of Accounts list
    And I tap thirdly item of Portfolios list
    Then I should on the Portfolios level

  @S501-AC1-AT7
  @DependsOn('I_am_view_the_Advisory_portfolio_wrapper_for_GPBM-2919')
  Scenario: Check the Advisory name in portfolio wrapper
    Given I am on the Portfolios level
    Then I can see the following components in Advisory portfolio wrapper on 3th item:
      | element name   | element value |
      | portfolio name | Advisory      |

  @S501-AC1-AT8
  @DependsOn('I_am_view_the_Advisory_portfolio_wrapper_for_GPBM-2919')
  Scenario: Check the Advisory name in portfolio wrapper when I swipe left or right the portfolio wrapper pips
    Given I am on the Portfolios level
    When I swipe left 2th to other portfolio
    Then I can see the following components in Advisory portfolio wrapper on 5th item:
      | element name   | element value |
      | portfolio name | Advisory      |

  @S501-AC1-AT11
  @Const(action="click_asset_overlay_close_button")
  @DependsOn('I_am_view_the_Advisory_portfolio_wrapper_for_GPBM-2919')
  Scenario: Check the Advisory name in Portfolio asset overlay in portfolio wrapper
    Given I am on the Portfolios level
    When I tap 5th portfolio total asset
    Then I can see the following components for Advisory portfolio overlay:
      | element name   | element value |
      | portfolio name | Advisory      |

  @S501-AC1-AT15
  @Const(action="click_liability_overlay_close_button")
  @DependsOn('I_am_view_the_Advisory_portfolio_wrapper_for_GPBM-2919')
  Scenario: Check the Advisory name in Liability overlay in portfolio wrapper
    Given I am on the Portfolios level
    When I tap Portfolio Total Liabilities
    Then I can see the following components for Advisory portfolio Liabilities overlay:
      | element name   | element value |
      | portfolio name | Advisory      |

  @S501-AC1-AT12
  @Const(action="click_asset_overlay_close_button")
  @DependsOn('I_am_view_the_Advisory_portfolio_wrapper_for_GPBM-2919')
  Scenario: Check the Advisory name in Portfolio assets overlay in portfolio wrapper when I swipe left or right the portfolio wrapper pips
    Given I am on the Portfolios level
    When I swipe right 2th to other portfolio
    And I tap 3th portfolio total asset
    Then I can see the following components for Advisory portfolio overlay:
      | element name   | element value |
      | portfolio name | Advisory      |

  @S501-AC1-AT16
  @DependsOn('I_am_view_the_Advisory_portfolio_wrapper_for_GPBM-2919')
  Scenario: Check the Advisory name in Liability overlay in portfolio wrapper when I swipe left or right the portfolio wrapper pips
    Given I am on the Portfolios level
    When I tap Portfolio Total Liabilities
    Then I can see the following components for Advisory portfolio Liabilities overlay:
      | element name   | element value |
      | portfolio name | Advisory      |


  Scenario: I am view the Discretionary portfolio class holding list for GPBM-2919
    Given I login as User
      | element name | element value |
      | Name         | userM         |
    When I tap first item of Accounts list
    And I tap second item of Portfolios list
    And I tap on the Allocation toggle
    And I tap first item of class list at portfolio level
    Then I should on the allocation holding list

  @S501-AC1-AT17
  @DependsOn('I_am_view_the_Discretionary_portfolio_class_holding_list_for_GPBM-2919')
  Scenario: Check the Discretionary name in back button of Portfolio allocation Asset Class holding list view
    Given I am on the allocation holding list
    Then I can see the following components in Discretionary portfolio allocation holding list screen:
      | element name      | element value |
      | back button label |               |

  @S501-AC1-AT23
  @DependsOn('I_am_view_the_Discretionary_portfolio_class_holding_list_for_GPBM-2919')
  Scenario: Check the Discretionary name in back button of portfolio Asset Class holding detail
    Given I am on the allocation holding list
    When I tap 1th item of portfolio allocation holding list
    Then I can see the following components in Discretionary portfolio holding detail screen:
      | element name      | element value |
      | back button label |               |

  Scenario: I am view the Discretionary portfolio sub class holding list for GPBM-2919
    Given I login as User
      | element name | element value |
      | Name         | userM         |
    When I tap first item of Accounts list
    And I tap second item of Portfolios list
    And I tap on the Allocation toggle
    And I tap "Show Sub-Asset Class" toggle of Portfolio level
    And I tap first Sub-Asset class item at portfolio level
    Then I should on the allocation holding list

  @S501-AC1-AT18
  @DependsOn('I_am_view_the_Discretionary_portfolio_sub_class_holding_list_for_GPBM-2919')
  Scenario: Check the Discretionary name in back button of Portfolio allocation Sub Asset Class holding list view
    Given I am on the allocation holding list
    Then I can see the following components in Discretionary portfolio allocation holding list screen:
      | element name      | element value |
      | back button label |               |

  @S501-AC1-AT24
  @DependsOn('I_am_view_the_Discretionary_portfolio_sub_class_holding_list_for_GPBM-2919')
  Scenario: Check the Discretionary name in back button of portfolio Sub Asset Class holding detail
    Given I am on the allocation holding list
    When I tap 1th item of portfolio allocation holding list
    Then I can see the following components in Discretionary portfolio holding detail screen:
      | element name      | element value |
      | back button label |               |


  Scenario: I am view the Discretionary portfolio currency holding list for GPBM-2919
    Given I login as User
      | element name | element value |
      | Name         | userM         |
    When I tap first item of Accounts list
    And I tap second item of Portfolios list
    And I tap on the Allocation toggle
    And I tap Portfolio Currency tab
    And I tap first item of Portfolio currency list
    Then I should on the allocation holding list

  @S501-AC1-AT19
  @DependsOn('I_am_view_the_Discretionary_portfolio_currency_holding_list_for_GPBM-2919')
  Scenario: Check the Discretionary name in back button of Portfolio allocation Currency holding list view
    Given I am on the allocation holding list
    Then I can see the following components in Discretionary portfolio allocation holding list screen:
      | element name      | element value |
      | back button label |               |

  @S501-AC1-AT25
  @DependsOn('I_am_view_the_Discretionary_portfolio_currency_holding_list_for_GPBM-2919')
  Scenario: Check the Discretionary name in back button of portfolio Currency holding detail
    Given I am on the allocation holding list
    When I tap 1th item of portfolio allocation holding list
    Then I can see the following components in Discretionary portfolio holding detail screen:
      | element name      | element value |
      | back button label |               |


  Scenario: I am view the Advisory portfolio class holding list for GPBM-2919
    Given I login as User
      | element name | element value |
      | Name         | userM         |
    When I tap first item of Accounts list
    And I tap thirdly item of Portfolios list
    And I tap on the Allocation toggle
    And I tap first item of class list at portfolio level
    Then I should on the allocation holding list

  @S501-AC1-AT20
  @DependsOn('I_am_view_the_Advisory_portfolio_class_holding_list_for_GPBM-2919')
  Scenario: Check the Advisory name in back button of Portfolio allocation Asset Class holding list view
    Given I am on the allocation holding list
    Then I can see the following components in Advisory portfolio allocation holding list screen:
      | element name      | element value |
      | back button label | Advisory      |

  @S501-AC1-AT27
  @DependsOn('I_am_view_the_Advisory_portfolio_class_holding_list_for_GPBM-2919')
  Scenario: Check the Advisory name in back button of portfolio Asset Class holding detail
    Given I am on the allocation holding list
    When I tap 1th item of portfolio allocation holding list
    Then I can see the following components in Advisory portfolio holding detail screen:
      | element name      | element value |
      | back button label | Advisory      |


  Scenario: I am view the Advisory portfolio sub class holding list for GPBM-2919
    Given I login as User
      | element name | element value |
      | Name         | userM         |
    When I tap first item of Accounts list
    And I tap thirdly item of Portfolios list
    And I tap on the Allocation toggle
    And I tap "Show Sub-Asset Class" toggle of Portfolio level
    And I tap first Sub-Asset class item at portfolio level
    Then I should on the allocation holding list

  @S501-AC1-AT21
  @DependsOn('I_am_view_the_Advisory_portfolio_sub_class_holding_list_for_GPBM-2919')
  Scenario: Check the Advisory name in back button of Portfolio allocation Sub Asset Class holding list view
    Given I am on the allocation holding list
    Then I can see the following components in Advisory portfolio allocation holding list screen:
      | element name      | element value |
      | back button label | Advisory      |

  @S501-AC1-AT28
  @DependsOn('I_am_view_the_Advisory_portfolio_sub_class_holding_list_for_GPBM-2919')
  Scenario: Check the Advisory name in back button of portfolio Sub asset Class holding detail
    Given I am on the allocation holding list
    When I tap 1th item of portfolio allocation holding list
    Then I can see the following components in Advisory portfolio holding detail screen:
      | element name      | element value |
      | back button label | Advisory      |


  Scenario: I am view the Advisory portfolio currency holding list for GPBM-2919
    Given I login as User
      | element name | element value |
      | Name         | userM         |
    When I tap first item of Accounts list
    And I tap thirdly item of Portfolios list
    And I tap on the Allocation toggle
    And I tap Portfolio Currency tab
    And I tap first item of Portfolio currency list
    Then I should on the allocation holding list

  @S501-AC1-AT22
  @DependsOn('I_am_view_the_Advisory_portfolio_currency_holding_list_for_GPBM-2919')
  Scenario: Check the Advisory name in back button of Portfolio allocation Currency holding list view
    Given I am on the allocation holding list
    Then I can see the following components in Advisory portfolio allocation holding list screen:
      | element name      | element value |
      | back button label | Advisory      |

  @S501-AC1-AT29
  @DependsOn('I_am_view_the_Advisory_portfolio_currency_holding_list_for_GPBM-2919')
  Scenario: Check the Advisory name in back button of portfolio Currency holding detail
    Given I am on the allocation holding list
    When I tap 1th item of portfolio allocation holding list
    Then I can see the following components in Advisory portfolio holding detail screen:
      | element name      | element value |
      | back button label | Advisory      |

  @S501-AC1-AT26
  Scenario: Check the Discretionary name in back button of portfolio holding detail
    Given I login as User
      | element name | element value |
      | Name         | userM         |
    When I tap first item of Accounts list
    And I tap second item of Portfolios list
    And I tap 1th item of holdings list
    Then I can see the following components in Discretionary portfolio holding detail screen:
      | element name      | element value |
      | back button label |               |

  @S501-AC1-AT30
  Scenario: Check the Advisory name in back button of portfolio holding detail
    Given I login as User
      | element name | element value |
      | Name         | userM         |
    When I tap first item of Accounts list
    And I tap 5th item of Portfolios list
    And I tap 1th item of holdings list
    Then I can see the following components in Advisory portfolio holding detail screen:
      | element name      | element value |
      | back button label | Advisory      |

  @S501-AC1-AT31
  Scenario: Check the Discretionary name in back button of transaction list
    Given I login as User
      | element name | element value |
      | Name         | userM         |
    When I tap first item of Accounts list
    And I tap second item of Portfolios list
    And I tap the Transactions button
    And I taps first on a transaction list item
    Then I can see the following components in Discretionary portfolio transaction detail screen:
      | element name      | element value |
      | back button label |               |

  @S501-AC1-AT32
  Scenario: Check the Advisory name in back button of transaction list
    Given I login as User
      | element name | element value |
      | Name         | userM         |
    When I tap first item of Accounts list
    And I tap thirdly item of Portfolios list
    And I tap the Transactions button
    And I taps first on a transaction list item
    Then I can see the following components in Advisory portfolio transaction detail screen:
      | element name      | element value |
      | back button label | Advisory      |


