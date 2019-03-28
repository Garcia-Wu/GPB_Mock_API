@HK @SG
@Epic_GPBM-460(Liabilities)
@Story_GPBM-2405 @Sprint8_iOS
@Story_GPBM-2837 @Sprint8_aOS

Feature: Liabilities detailed view

  As a client I want to be able to see a detailed view of each of the liabilities I own, so that I have a view of all of the individual details for each of my loans

  @SIT
  Scenario: Detailed view from portfolio list AND loan ccy and portfolio base ccy SAME
    Given I login as type "portfolio_liabilities_list_ccy_and_base_ccy_same"
#    And I tap first item of Accounts list
#    And I tap first item of Portfolios list
    And I tap on portfolio "Liabilities" tab
    When I taps on a liability list item which has the same currency as the portfolio base currency
    Then I should on the liability detail view

  @S448-AC1-AT1
  @DependsOn('Detailed_view_from_portfolio_list_AND_loan_ccy_and_portfolio_base_ccy_SAME')
  Scenario: Check Detailed view from portfolio list AND loan ccy and portfolio base ccy SAME
    Given I am on the liability detail view
    Then I should see the following liability detail view headers:
      | element name                | element value |
      | Liability Description value |               |
      | Liability type value        | Call loan     |
    And the following details displayed regarding the individual liability:
      | element name                                            | element value                                                                                                                                                     |
      | Principal header                                        | Principal                                                                                                                                                         |
      | Principal value in the currency of the liability        |                                                                                                                                                                   |
      | Accrued interest header                                 | Accrued interest                                                                                                                                                  |
      | Accrued interest value in the currency of the liability |                                                                                                                                                                   |
      | Total header                                            | Total                                                                                                                                                             |
      | Total in loan currency value                            |                                                                                                                                                                   |
      | explain                                                 | Praesent porttitor consectetur metus vel sagittis. Morbi sed risus velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae. |
    And all liability values are displayed as negative figures using a minus sign

  @S448-AC1-AT2
  @SIT
  @DependsOn('Detailed_view_from_portfolio_list_AND_loan_ccy_and_portfolio_base_ccy_SAME')
  Scenario: Check ISO 3 code of liability currency
    Given I am on the liability detail view
    Then I should see ISO 3 code of liability currency and loan currency

  @SIT
  Scenario: Detailed view from portfolio list AND loan ccy and portfolio base ccy DIFFERENT
    Given I login as type "portfolio_liabilities_list_ccy_and_base_ccy_different"
#    And I tap first item of Accounts list
#    And I tap first item of Portfolios list
    And I tap on portfolio "Liabilities" tab
    When I taps on a liability list item which has a different currency to the portfolio base currency for Fixed loan
    Then I should on the liability detail view

  @S448-AC2-AT1
  @DependsOn('Detailed_view_from_portfolio_list_AND_loan_ccy_and_portfolio_base_ccy_DIFFERENT')
  Scenario:Check Detailed view from portfolio list AND loan ccy and portfolio base ccy DIFFERENT
    Given I am on the liability detail view
    Then I should see the following liability detail view headers:
      | element name                | element value |
      | Liability Description value |               |
      | Liability type value        | Fixed loan    |
    And the following details displayed regarding the individual liability:
      | element name                                            | element value                                                                                                                                                     |
      | Principal header                                        | Principal                                                                                                                                                         |
      | Principal value in the currency of the liability        |                                                                                                                                                                   |
      | Accrued interest header                                 | Accrued interest                                                                                                                                                  |
      | Accrued interest value in the currency of the liability |                                                                                                                                                                   |
      | Total header                                            | Total                                                                                                                                                             |
      | Total in loan currency value                            |                                                                                                                                                                   |
      | Total in portfolio base currency value in brackets      |                                                                                                                                                                   |
      | explain                                                 | Praesent porttitor consectetur metus vel sagittis. Morbi sed risus velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae. |
    And all liability values are displayed as negative figures using a minus sign

  @S448-AC2-AT2
  @SIT
  @DependsOn('Detailed_view_from_portfolio_list_AND_loan_ccy_and_portfolio_base_ccy_DIFFERENT')
  Scenario: Check ISO 3 code of liability currency when loan ccy and portfolio base ccy DIFFERENT
    Given I am on the liability detail view
    Then I should see ISO 3 code of liability currency and portfolio base currency

  @S448-AC2-AT3
  @DependsOn('Detailed_view_from_portfolio_list_AND_loan_ccy_and_portfolio_base_ccy_DIFFERENT')
  Scenario: Check whether can return to list view
    Given I am on the liability detail view
    When I taps on the back button labelled with Portfolio name value
    Then I should return to the liability list view within that portfolio