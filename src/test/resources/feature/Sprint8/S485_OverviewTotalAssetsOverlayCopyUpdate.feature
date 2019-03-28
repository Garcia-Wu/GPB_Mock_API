@Epic_GPBM-367(My_Overview)
@Story_GPBM-1833 @Sprint8_iOS
@Story_GPBM-1836 @Sprint8_aOS

Feature: Overview Total Assets Overlay COPY UPDATE

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @NotAutomatable
  Scenario:Check the Overview Total Assets Overlay COPY UPDATE
    Given I am viewing Overview Total Assets Overlay
    Then I should see the following copy is displayed:
      | element name | element value                                                                                                                                                                                                  |
      | message      | "This figure represens the total value of your current holdings across all of your UK accounts as at the "Update" date displayed. It does not include any commitments to invest or loans"(copy to be approved) |
#  @S485-AC1-AT1
# This Scenario is completed in S27-AC1-AT1

  @HK @SG @UK
  @S485-AC1-AT2
  @SIT
  Scenario:Check the Overview Total Assets equal to the Overview Total Assets Overlay
    Given I login as type "has_account"
    When I click on the overview Total Assets value
    Then I should see the Overview Total Assets equal to the Overview Total Assets Overlay