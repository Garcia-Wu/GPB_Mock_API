@UK
@Epic_GPBM-2010(Performance)
@Story_GPBM-3392 @Sprint11_iOS
@Story_GPBM-3393 @Sprint11_aOS

Feature: Remove_Performance_At_Account

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S562-AC1-AT1
  Scenario: Check whether I can not see the Performance in Account wrapper
    Given I login as type "account_no_performance"
    Then I will not view account warpper performance
      | element name                     | element value            |
      | "Performance year to date" label | Performance year to date |
      | Performance icon image           |                          |
      | Performance value                |                          |