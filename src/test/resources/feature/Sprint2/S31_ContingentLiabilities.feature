@HK @SG @UK
@Epic_GPBM-458(Contingent_Liabilities)
@Story_GPBM-581 @Sprint2_iOS
@Story_GPBM-1051 @Sprint2_aOS

Feature: Portfolio without Contingent Liabilities

  As a client I do not want to have access to a Contingent Liabilities section within my Portfolio
  if I don’t have any outstanding commitments to invest, so that I only see portfolio data that reflects my current investment exposure.


  @S31-AC1-AT1
  Scenario: client owns a portfolio which has no Contingent Liabilities relating to Real Estate and/or Private Equity funds
    Given I login as User
      | element name | element value |
      | Name         | userE         |
      | Password     | 123           |
    When I tap first item of Accounts list
    And I tap fourth item of Portfolios list
    Then I should not see the Contingent Liabilities tab

  @NotAutomatable
  Scenario: Check whether the bar will appear when Client has no remaining Contingent Liabilities
    When dummy

  #  @S31-AC1-AT2
  #  Reason: not has one correspondence profile


