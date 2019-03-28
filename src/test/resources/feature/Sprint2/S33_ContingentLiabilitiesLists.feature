@HK @SG @UK
@Epic_GTMB-458(Contingent_Liabilities)
@Story_GTMB-578 @Sprint2_iOS
@Story_GTMB-1055 @Sprint2_aOS

Feature: Initial list view of Contingent Liabilities

  As a client I want to see a condensed view of each commitment I have made to invest in a Private Equity or Real state fund,
  so that I understand my remaining commitments at first glance

  @S33-AC1-AT1
  Scenario: Check the Portfolio Contingent Liabilities lists
    Given I login as User
      | element name | element value |
      | Name         | userE         |
      | Password     | 123           |
    When I tap first item of Accounts list
    And I tap first item of Portfolios list
    And I tap on the Contingent Liabilities tab
    Then I should see the following Ui Elements on Contingent Liabilities List screen
      | element name                       | element value        |
      | Description                        |                      |
      | header                             | Remaining commitment |
      | Remaining commitment               |                      |
      | Percentage of commitment remaining |                      |

  @S33-AC1-AT2
  @DependsOn('Check_the_Portfolio_Contingent_Liabilities_lists')
  Scenario: Check the ISO 3 code format of the Commitment Remaining value
    Given I am on the Contingent Liabilities Screen
    Then I should see ISO 3 code of base currency on Contingent Liabilities List screen
      | element name         | element value |
      | commitment remaining |               |

  @S33-AC1-AT3
  @DependsOn('Check_the_ISO_3_code_format_of_the_Commitment_Remaining_value')
  Scenario: Check the Percentage of commitment remaining value
    Given I am on the Contingent Liabilities Screen
    Then I should see Percentage of commitment remaining value on Contingent Liabilities List screen
      | element name         | element value |
      | commitment remaining |               |

  @S33-AC1-AT4
  @DependsOn('Check_the_Percentage_of_commitment_remaining_value')
  Scenario: Check the Initial commitments value and the Remaining commitments value shown to 2 decimal places
    Given I am on the Contingent Liabilities Screen
    Then I should see the following value format to 2 decimal places
      | element name          | element value |
      | Initial commitments   |               |
      | Remaining commitments |               |

  @S33-AC1-AT5
  @DependsOn('Check_the_Initial_commitments_value_and_the_Remaining_commitments_value_shown_to_2_decimal_places')
  Scenario: Check the sequence of the Remaining commitments value
    Given I am on the Contingent Liabilities Screen
    Then I should see the list is ordered by Remaining Commitment value largest first, smallest last


