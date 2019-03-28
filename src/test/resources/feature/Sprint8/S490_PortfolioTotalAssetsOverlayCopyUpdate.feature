@HK @SG @UK
@Epic_GPBM-410(My_Portfolio)
@Story_GPBM-1838 @Sprint8_iOS
@Story_GPBM-1837 @Sprint8_aOS

Feature: Portfolio Total Assets Overlay COPY UPDATE

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @NotAutomatable
  Scenario:Check the Portfolio Total Assets Overlay COPY UPDATE
    Given I am viewing Portfolio Total Assets Overlay
    Then I should see the following copy is shown:
      | element name | element value                                                                                                                                                                            |
      | message      | "This figure represens the total value of your current holdings within this Portfolio within  as at the "Update" date displayed. It does not include any commitments to invest or loans" |
#  @S490-AC1-AT1
# This Scenario is completed in S29-AC1-AT2

  @S490-AC1-AT2
  @SIT
  Scenario:Check the Portfolio Total Assets equal to the Portfolio Total Assets Overlay
    Given I login as type "portfolio_has_holdings"
    And I click on the Portfolio Total Assets value
    Then I should see the Portfolio Total Assets equal to the Portfolio Total Assets Overlay