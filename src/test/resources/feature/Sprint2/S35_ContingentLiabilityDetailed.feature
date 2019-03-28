@HK @SG @UK
@Epic_GPBM-458(Contingent_Liabilities)
@Story_GPBM-579 @Sprint2_iOS
@Story_GPBM-1059 @Sprint2_aOS

Feature: Detailed view of a Contingent Liability

  As a client I want to see a detailed view of each commitment I have made to invest in a Private Equity or Real state fund,
  so that I have a complete view of my initial and remaining commitment

  @S35-AC1-AT1
  Scenario:Check the Contingent Liabilities lists Detail UI
    Given I login as User
      | element name | element value |
      | Name         | userE         |
      | Password     | 123           |
    When I tap first item of Accounts list
    And I tap first item of Portfolios list
    And I tap on the Contingent Liabilities tab
    And I tap first item of contingent liabilities list
    Then I should see the following components on Contingent Liabilities detail
      | element name                           | element value |
      | Description value                      |               |
      | Initial Commitment                     |               |
      | Initial commitment value               |               |
      | Initial commitment value in brackets   |               |
      | Remaining title                        |               |
      | Remaining commitment value             |               |
      | Remaining commitment value in brackets |               |
      | Disclaimers                            |               |


  @S35-AC1-AT2
  @DependsOn('Check_the_Contingent_Liabilities_lists_Detail_UI')
  Scenario: Check the format of ISO 3 code
    Given I am on the Contingent Liabilities Detail Screen
    Then I should see the following data for ISO 3 code all
      | element name                                     | element value |
      | reporting currency in Initial commitment value   |               |
      | base currency in Initial commitment value        |               |
      | reporting currency in Remaining commitment value |               |
      | base currency in Remaining commitment value      |               |


  @S35-AC1-AT3
  @DependsOn('Check_the_format_of_ISO_3_code')
  Scenario: Check the format of Opening date value
    Given I am on the Contingent Liabilities Detail Screen
    Then I should see Opening date value (format dd month yyyy)


  @S35-AC1-AT4
  @DependsOn('Check_the_format_of_Opening_date_value')
  Scenario: Check the Percentage of data
    Given I am on the Contingent Liabilities Detail Screen
    Then I should see Percentage of commitment remaining value

  @S35-AC1-AT5
  @DependsOn('Check_the_Percentage_of_data')
  Scenario: Check the format of 2 decimal places
    Given I am on the Contingent Liabilities Detail Screen
    Then I should see the following data for 2 decimal places
      | element name          | element value |
      | Initial commitments   |               |
      | Remaining commitments |               |


  @NotAutomatable
  Scenario: Check the detailed view of each Contingent Liability when swipe pips left or right
    When dummy

  #  @S35-AC1-AT6
  #  I should  see a Horizontal bar reflecting the remaining % value
  #  Renson:Will not be able to detect the length of the picture


  @S35-AC1-AT7
  @DependsOn('Check_the_format_of_2_decimal_places')
  Scenario: Check the detailed view of each Contingent Liability when swipe pips left or right
    Given I am on the Contingent Liabilities Detail Screen
    When I swipe left to see the detailed view of each Contingent Liability
    And I check element not display on the first detailed view
    And I swipe right to see the detailed view of each Contingent Liability
    Then I check element isDisplay on the first detailed view


#  @S35-AC1-AT8
#  @DependsOn('Check_the_detailed_view_of_each_Contingent_Liability_when_swipe_pips_left_or-right')
#  Scenario:Check whether the pips can never ending loop
#    Given I am on the Contingent Liabilities Detail Screen
#    When I swipe left or right to see the detailed view of each Contingent Liability
#    Then I should be able to swipe through the views in a never ending loop


  @S35-AC1-AT9
  Scenario: Check the Contingent Liabilities lists Detail UI other
    Given I login as User
      | element name | element value |
      | Name         | userE         |
      | Password     | 123           |
    When I tap first item of Accounts list
    And I taps on 2nd items in Portfolio list
    And I tap on the Contingent Liabilities tab
    And I tap first item of contingent liabilities list
    Then I should see the following components on Contingent Liabilities detail as user
      | element name               | element value |
      | Description value          |               |
      | Initial Commitment         |               |
      | Initial commitment value   |               |
      | Remaining title            |               |
      | Remaining commitment value |               |
      | Disclaimers                |               |

  @S35-AC1-AT10
  @DependsOn('Check_the_Contingent_Liabilities_lists_Detail_UI_other')
  Scenario: Check the format of ISO 3 code other
    Given I am on the Contingent Liabilities Detail Screen
    Then I should see the following data for ISO 3 code other
      | element name                                | element value |
      | base currency in Initial commitment value   |               |
      | base currency in Remaining commitment value |               |


  @S35-AC1-AT11
  @DependsOn('Check_the_format_of_ISO_3_code_other')
  Scenario: Check the format of Opening date value other
    Given I am on the Contingent Liabilities Detail Screen
    Then I should see Opening date value (format dd month yyyy)



  @S35-AC1-AT12
  @DependsOn('Check_the_format_of_Opening_date_value_other')
  Scenario: Check the Percentage of commitment remaining values
    Given I am on the Contingent Liabilities Detail Screen
    Then I should see Percentage of commitment remaining value


  @NotAutomatable
  Scenario: Check the horizontal bar reflecting the remaining % value
    When dummy

  #  @S35-AC1-AT13
  #  I should  see a Horizontal bar reflecting the remaining % value
  #  Renson:Will not be able to detect the length of the picture
