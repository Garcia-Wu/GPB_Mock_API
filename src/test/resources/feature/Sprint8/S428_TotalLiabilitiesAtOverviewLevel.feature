@HK @SG
@Epic_GPBM-460(Liabilities)
@Story_GPBM-791 @Sprint8_iOS
@Story_GPBM-2817 @Sprint8_aOS

Feature: Total Liabilities at Overview level

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @SIT
  Scenario: Total Liabilities at Overview Level
    Given I login as type "overview_has_total_liabilities"
    Then I should on the Overview screen

  @S428-AC1-AT1
  @DependsOn('Total_Liabilities_at_Overview_Level')
  Scenario:Check the UI of Total Liabilities at Overview Level
    Given I am on the Overview screen
    Then I should see the follow element on overview liabilities:
      | element name               | element value     |
      | header "Total liabilities" | Total liabilities |
      | Total liabilities icon     |                   |
      | Total liabilities value    |                   |

  @S428-AC1-AT2
  @SIT
  @DependsOn('Total_Liabilities_at_Overview_Level')
  Scenario:Check the format of the value for the total liabilities they own within all of their accounts is displayed,which will be 17 characters max,including commas and decimal point
    Given I am on the Overview screen
    Then I should see the value for the total liabilities will be 17 characters max

  @S428-AC1-AT3
  @SIT
  @DependsOn('Total_Liabilities_at_Overview_Level')
  Scenario:Check the ISO 3 format of Overview base currency(USD)
    Given I am on the Overview screen
    Then I should see the Overview base currency is displayed in ISO 3 code format


  @NotAutomatable
  Scenario:Check whether The Total Liabilities figure should be based on the sum of the "Total in base currency" value for each liability owned by the client within all  of  their Accounts
    Given I am see the follow element on overview liabilities:
      | element name               | element value     |
      | header "Total liabilities" | Total liabilities |
      | Total liabilities icon     |                   |
      | Total liabilities value    |                   |
    Then I should see The Total Liabilities figure should be based on the sum of the "Total in base currency" value for each liability owned by the client within all of their Accounts

    #  S-AC1-AT4
    #  Reason: cannot check the accounts sum total liabilities

  @S428-AC1-AT5
  @DependsOn('Total_Liabilities_at_Overview_Level')
  Scenario:Check the animation of Overview wrapper
    Given I am on the Overview screen
    When I minifiles the Overview wrapper
    Then I should see the Welcome Message/Country/Update time/Total Liabilities/Net Assets will be fade and they will be disappeared
    And I should see the customer name and Total Assets

  @S428-AC1-AT6
  Scenario:Check whether I can not see a Total Liabilities label,chervon or figure displayed when client has no liabilities on overview level
    Given I login as type "overview_no_total_liabilities"
    Then the client should NOT see a Total Liabilities label,chervon or figure displayed

  @S428-AC1-AT7
  Scenario:Check whether I can see the Total Liabilities is displayed 0.00 when the Total Liabilities value  really data is 0.001 in backend
    Given I login as type "overview_total_liabilities_zero"
#    And the Total Liabilities value really data is 0.001 in backend
    Then I should see the Total Liabilities is displayed "0.00"

  @S428-AC1-AT8
  Scenario:Check whether I can not see the Total Liabilities and Net Assets when the Total Liabilities value really data is 0.0000 in backend
    Given I login as type "overview_no_total_liabilities"
#    And the Total Liabilities value  really data is 0.00000 in backend
    Then I should not see the Total Liabilities and the Net Assets in overview level