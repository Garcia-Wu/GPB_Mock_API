@HK @SG
@Epic_GPBM-460(Liabilities)
@Story_GPBM-2316 @Sprint8_iOS
@Story_GPBM-2818 @Sprint8_aOS

Feature: Net Assets at Overview level

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @SIT
  Scenario: Net Assets at Overview level
    Given I login as type "overview_has_net_assert"
    Then I should on the Overview screen

  @S432-AC1-AT1
  @DependsOn('Net_Assets_at_Overview_level')
  Scenario:Check the UI of Net Assets at Overview level
    Given I am on the Overview screen
    Then I should see the follow element on overview net assets:
      | element name        | element value |
      | header "Net assets" | Net assets    |
#      | Net assets currency |               |
      | Net assets value    |               |

  @S432-AC1-AT2
  @SIT
  @DependsOn('Net_Assets_at_Overview_level')
  Scenario:Check the format of the value for the overview net assets they own within all of their accounts is displayed,which will be 18 characters max,including commas and decimal point,e.g. 999,999,999,999,99
    Given I am on the Overview screen
    Then I should see the value for the net assets they own within all of their accounts is displayed,which will be 18 characters max,including commas and decimal point

  @S432-AC1-AT3
  @SIT
  @DependsOn('Net_Assets_at_Overview_level')
  Scenario:Check whether the overview net assets base currency is displayed in ISO 3 code format
    Given I am on the Overview screen
    Then I should see the overview net assets base currency is displayed in ISO 3 code format

  @S432-AC1-AT4
  @SIT
  @DependsOn('Net_Assets_at_Overview_level')
  Scenario:Check whether the Net Assets = Total Assets(overview value) - Total Liabilities(overview value)
    Given I am on the Overview screen
    Then I should see that Net Assets = Total Assets(overview value) - Total Liabilities(overview value)

  @S432-AC1-AT5
  Scenario:Check whether I can not see a overview Net assets label or figure displayed when client has no liabilities
    Given I login as type "overview_no_net_assert"
    Then I should not see a overview Net assets label or figure displayed

  @S432-AC1-AT6
  Scenario:Check whether I can see a overview Net assets label or figure displayed 0.00
    Given I login as type "overview_net_assert_zero"
    Then I should see a overview Net assets label or figure displayed "0.00"