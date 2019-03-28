@HK @SG
@Epic_GPBM-460(Liabilities)
@Story_GPBM-2402 @Sprint8_iOS
@Story_GPBM-2836 @Sprint8_aOS

Feature:Liabilities list in Portfolio level

  As a client I want to be able to see each of the liabilities I own within a Portfolio listed, so that I have a view of the individual details for each of my loans

  @S447-AC1-AT2
  Scenario: Check no liabilities tab when Client dose not owns one or more liabilities
    Given I login as type "portfolio_no_liabilities_list"
#    And I tap first item of Accounts list
#    When I tap first item of Portfolios list
    Then I should NOT see a tab labelled "Liabilities" adjacent to Holdings and Transactions tabs

  @S447-AC1-AT1
  @SIT
  Scenario: Check liabilities tab when Client owns one or more liabilities
    Given I login as type "portfolio_liabilities_list_ccy_and_base_ccy_same"
#    When I tap first item of Accounts list
#    And I tap first item of Portfolios list
    When I tap on portfolio "Liabilities" tab
    Then I should see a tab labelled "Liabilities" adjacent to Holdings and Transactions tabs

# liability listed 3：ccy and  base ccy is SAME
  @S447-AC1-AT3
  @DependsOn('Check_liabilities_tab_when_Client_owns_one_or_more_liabilities')
  Scenario: Check Liability list UI when loan ccy and  base ccy is SAME
    Given I am see a tab labelled "Liabilities" adjacent to Holdings and Transactions tabs
    Then I should see the liability listed with the following information displayed:
      | element name                 | element value |
      | Description value            |               |
      | Liability type value         |               |
      | Total in loan currency value |               |
    And "Total" value is shown as a negative value using a minus sign

  @S447-AC1-AT4
  @SIT
  @DependsOn('Check_liabilities_tab_when_Client_owns_one_or_more_liabilities')
  Scenario: Check ISO 3 code of loan currency when loan ccy and  base ccy is SAME
    Given I am see a tab labelled "Liabilities" adjacent to Holdings and Transactions tabs
    Then I should see ISO 3 code of Loan currency for liabilities

  @S447-AC1-AT5
  @SIT
  @DependsOn('Check_liabilities_tab_when_Client_owns_one_or_more_liabilities')
  Scenario: Check liabilities ordering when loan ccy and  base ccy is SAME
    Given I am see a tab labelled "Liabilities" adjacent to Holdings and Transactions tabs
    Then I should see all liabilities within the portfolio are ordered by Total in portfolio base currency value (largest absolute value first, smallest absolute value last) by default

  @S447-AC1-AT11
  Scenario: Check when Total liability value in portfolio base currency is 0.0001
    Given  I login as type "portfolio_liabilities_list_bace_ccy_zero"
#    When Total liability value in portfolio base currency is 0.00001
    When I tap on portfolio "Liabilities" tab
    Then I should see Total liabilities within the portfolio base currency is "0.00"


    # liability listed 1：ccy and  base ccy is DIFFERENT
  @SIT
  Scenario: loan ccy and base ccy is DIFFERENT
    Given I login as type "portfolio_liabilities_list_ccy_and_base_ccy_different"
#    When I tap first item of Accounts list
#    And I tap first item of Portfolios list
    When I tap on portfolio "Liabilities" tab
    Then I should see a tab labelled "Liabilities" adjacent to Holdings and Transactions tabs

  @S447-AC1-AT6
  @DependsOn('loan_ccy_and_base_ccy_is_DIFFERENT')
  Scenario: Check Liability list UI when loan ccy and base ccy is DIFFERENT
    Given I am see a tab labelled "Liabilities" adjacent to Holdings and Transactions tabs
    Then I should see the liability listed with the following information displayed when loan ccy and  base ccy is DIFFERENT:
      | element name                           | element value |
      | Description value                      |               |
      | Liability type value                   |               |
      | Total in loan currency value           |               |
      | Total in portfolio base currency value |               |
    And Total values are shown as a negative values using a minus sign

  @S447-AC1-AT7
  @SIT
  @DependsOn('loan_ccy_and_base_ccy_is_DIFFERENT')
  Scenario: Check ISO 3 code of loan currency and Portfolio base currency when loan ccy and  base ccy is DIFFERENT
    Given I am see a tab labelled "Liabilities" adjacent to Holdings and Transactions tabs
    Then I should see ISO 3 code of Loan currency and Portfolio base currency

#  The at repeated
#  @S447-AC1-AT8
#  Scenario: Check liabilities ordering when loan currency is different from portfolio base currency
#    Given client is viewing liability list
#    Then the client should see all liabilities within the portfolio are ordered by Total in portfolio base currency value (largest absolute value first, smallest absolute value last) by default

  @S447-AC1-AT9
  Scenario: Check no liabilities in portfolio
    Given I login as type "portfolio_no_liabilities_has_message"
#    And I tap four item of Accounts list
#    When I tap last item of Portfolios list
    And I tap on portfolio "Liabilities" tab
    Then I should see the following copy instead of a liabilities list
      | element name         | element value                                             |
      | no liability message | There are no liabilities available within this Portfolio. |

  @NotAutomatable
  Scenario: Check when Total liability value in portfolio base currency is 0.00
    Given client is viewing liability list
    When Total liability value in portfolio base currency is 0.00
    Then the client should not see that liabilities within the portfolio
#  @S447-AC1-AT10
#   Reason：can't check liability value in portfolio base currency is 0.00

