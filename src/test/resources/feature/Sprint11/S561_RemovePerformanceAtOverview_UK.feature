@UK
@Epic_GPBM-2010(Performance)
@Story_GPBM-3375 @Sprint11_iOS
@Story_GPBM-3387 @Sprint11_aOS

Feature: Remove_Performance_At_Overview

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S561-AC1-AT1
  Scenario: Check whether I can not see the Performance in Overview wrapper
    Given I login as type "overview_no_performance"
    Then I will not view overview warpper performance
      | element name                     | element value            |
      | "Performance year to date" label | Performance year to date |
      | Performance icon image           |                          |
      | Performance value                |                          |

  @S561-AC1-AT2
  Scenario: Check whether I can not see the Performance in Overview Account list
    Given I login as type "account_list_no_performance"
    Then I will not the Performance % value in the Account list views
