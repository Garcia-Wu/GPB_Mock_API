@UK
@Epic_GPBM-2010(Performance)
@Story_GPBM-3114 @Sprint9_iOS
@Story_GPBM-3150 @Sprint9_aOS
@NotAutomatable
# This story update in S247_OverlaysPerformance.feature
Feature: Performance overlay template - Account and Portfolio level - UK

  As a client,I want to be able to access the definition of both TWRR and Profit/Loss,
  so that I understand all the figures displayed to me

  
  @S506-AC1-AT1
  Scenario: Check the UI of UK Overview Performance overlay when the Cash value is negative
    Given I am viewing Overview Performance overlay
    And the Cash value is negative
    Then I will see an overlay which includes:
      | element name                                                | element value |
      | "Performance  year to date" title                           |               |
      | Overview (to represent the level)                           |               |
      | Profit/Loss label                                           |               |
      | Cash value is displayed as a negative figure using a - sign |               |
      | base currency                                               |               |
      | Profit/Loss definition                                      |               |

  @S506-AC1-AT2
  Scenario: Check the UI of UK Overview Performance overlay when the Cash value is positive
    Given I am viewing Overview Performance overlay
    And the Cash value is positive
    Then I will see an overlay which includes:
      | element name                                                | element value |
      | "Performance  year to date" title                           |               |
      | Overview (to represent the level)                           |               |
      | Profit/Loss label                                           |               |
      | Cash value is displayed as a positive figure using a + sign |               |
      | base currency                                               |               |
      | Profit/Loss definition                                      |               |

  @S506-AC1-AT3
  Scenario: Check the UI of UK Overview Performance overlay when the Cash value is 0.00
    Given I am viewing Overview Performance overlay
    And the Cash value is 0.00
    Then I will see an overlay which includes:
      | element name                      | element value |
      | "Performance  year to date" title |               |
      | Overview (to represent the level) |               |
      | Profit/Loss label                 |               |
      | Cash value without any +/- sign   |               |
      | base currency                     |               |
      | Profit/Loss definition            |               |

  @S506-AC1-AT4
  Scenario: Check the ISO 3 format of Cash value in Overview Performance overlay
    Given I am viewing the Overview Performance overlay
    Then I should see the Cash value in ISO 3 format

  @S506-AC1-AT5
  Scenario: Check the UI of UK Account Performance overlay when the Cash value is negative
    Given I am viewing Account Performance overlay
    And the Cash value is negative
    Then I will see an overlay which includes:
      | element name                                                | element value |
      | "Performance  year to date" title                           |               |
      | Account ID                                                  |               |
      | Profit/Loss label                                           |               |
      | Cash value is displayed as a negative figure using a - sign |               |
      | base currency                                               |               |
      | Profit/Loss definition                                      |               |
      | TWRR label                                                  |               |
      | TWRR%                                                       |               |
      | TWRR Definition                                             |               |

  @S506-AC1-AT6
  Scenario: Check the UI of UK Account Performance overlay when the Cash value is positive
    Given I am viewing Account Performance overlay
    And the Cash value is positive
    Then I will see an overlay which includes:
      | element name                                                | element value |
      | "Performance  year to date" title                           |               |
      | Account ID                                                  |               |
      | Profit/Loss label                                           |               |
      | Cash value is displayed as a positive figure using a + sign |               |
      | base currency                                               |               |
      | Profit/Loss definition                                      |               |
      | TWRR label                                                  |               |
      | TWRR%                                                       |               |
      | TWRR Definition                                             |               |

  @S506-AC1-AT7
  Scenario: Check the UI of UK Account Performance overlay when the Cash value is 0.00
    Given I am viewing Account Performance overlay
    And the Cash value is 0.00
    Then I will see an overlay which includes:
      | element name                      | element value |
      | "Performance  year to date" title |               |
      | Account ID                        |               |
      | Profit/Loss label                 |               |
      | Cash value without any +/- sign   |               |
      | base currency                     |               |
      | Profit/Loss definition            |               |
      | TWRR label                        |               |
      | TWRR%                             |               |
      | TWRR Definition                   |               |

  @S506-AC1-AT8
  Scenario: Check the ISO 3 format of Cash value in Account Performance overlay
    Given I am viewing the Account Performance overlay
    Then I should see the Cash value in ISO 3 format

  @S506-AC1-AT9
  Scenario: Check the UI of UK Portfolio Performance overlay when the Cash value is negative
    Given I am viewing Portfolio Performance overlay
    And the Cash value is negative
    Then I will see an overlay which includes:
      | element name                                                | element value |
      | "Performance  year to date" title                           |               |
      | Portfolio ID                                                |               |
      | Profit/Loss label                                           |               |
      | Cash value is displayed as a positive figure using a - sign |               |
      | base currency                                               |               |
      | Profit/Loss definition                                      |               |
      | TWRR label                                                  |               |
      | TWRR Definition                                             |               |

  @S506-AC1-AT10
  Scenario: Check the UI of UK Portfolio Performance overlay when the Cash value is positive
    Given I am viewing Portfolio Performance overlay
    And the Cash value is positive
    Then I will see an overlay which includes:
      | element name                                                | element value |
      | "Performance  year to date" title                           |               |
      | Portfolio ID                                                |               |
      | Profit/Loss label                                           |               |
      | Cash value is displayed as a positive figure using a + sign |               |
      | base currency                                               |               |
      | Profit/Loss definition                                      |               |
      | TWRR label                                                  |               |
      | TWRR%                                                       |               |
      | TWRR Definition                                             |               |

  @S506-AC1-AT11
  Scenario: Check the UI of UK Portfolio Performance overlay when the Cash value is 0.00
    Given I am viewing Portfolio Performance overlay
    And the Cash value is 0.00
    Then I will see an overlay which includes:
      | element name                      | element value |
      | "Performance  year to date" title |               |
      | Portfolio ID                      |               |
      | Profit/Loss label                 |               |
      | Cash value without any +/- sign   |               |
      | base currency                     |               |
      | Profit/Loss definition            |               |
      | TWRR label                        |               |
      | TWRR%                             |               |
      | TWRR Definition                   |               |

  @S506-AC1-AT12
  Scenario: Check the ISO 3 format of Cash value in Portfolio Performance overlay
    Given I am viewing the Portfolio Performance overlay
    Then I should see the Cash value in ISO 3 format"