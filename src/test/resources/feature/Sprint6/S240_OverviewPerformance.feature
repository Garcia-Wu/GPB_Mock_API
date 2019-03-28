@UK
@Epic_GPBM-2010(Performance)
@Story_GPBM-2005 @Sprint6_iOS
@Story_GPBM-2270 @Sprint6_aOS
# remove in sprint19 UK
@NotAutomatable

Feature: Overview-Performance

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S240-AC1-AT1
  Scenario:Check the Performance UI in Overview wrapper when the performance value is positive
    Given I login as type "overview_performance_is_positive"
    Then I shuold view the overview 1 following information:
      | element name                      | element value            |
      | Performance label                 | Performance year to date |
      | Performance value with a symbol + |                          |
      | Reporting currency                |                          |

  @S240-AC1-AT2
  Scenario:Check the Performance UI in Overview wrapper when the performance value is negative
    Given I login as type "overview_performance_is_negative"
    Then I shuold view the overview 2 following information:
      | element name                      | element value            |
      | Performance label                 | Performance year to date |
      | Performance value with a symbol - |                          |
      | Reporting currency                |                          |

  @SIT
  Scenario: overview performance
    Given I login as type "overview_performance_is_positive"
    Then I should on the Overview screen

  @S240-AC1-AT3
  @SIT
  @DependsOn('overview_performance')
  Scenario:Check the ISO 3 format of performance currency
    Given I am on the Overview screen
    Then I should see the ISO 3 format of overview performance currency

  @S240-AC1-AT4
  @SIT
  @DependsOn('overview_performance')
  Scenario:Check the 2dp format of performance value
    Given I am on the Overview screen
    Then I should see the 2dp format of overview performance value

  @S240-AC1-AT6
  @SIT
  @DependsOn('overview_performance')
  Scenario:Check the overview wrapper performance corresponding overlay performance
    Given I am on the Overview screen
    When I tap overview performance
    Then I should see overview wrapper performance corresponding overlay performance

  @S240-AC1-AT5
  Scenario:Check whether there is no + symbol or - symbol when the Performance value is 0.00
    Given I login as type "overview_performance_is_zero"
    And the overview Performance value is 0.00
    Then I should see overview there is no + symbol or - symbol before the Performance value