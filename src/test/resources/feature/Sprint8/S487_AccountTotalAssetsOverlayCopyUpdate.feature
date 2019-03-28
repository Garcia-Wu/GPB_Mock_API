@HK @SG @UK
@Epic_GPBM-368(My_Account)
@Story_GPBM-1839 @Sprint8_iOS
@Story_GPBM-1840 @Sprint8_aOS

Feature: Account Total Assets Overlay COPY UPDATE

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @NotAutomatable
  Scenario:Check the Account Total Assets Overlay COPY UPDATE
    Given I am viewing Account Total Assets Overlay
    Then I should see the following copy is shown:
      | element name | element value                                                                                                                                                                                                |
      | message      | "This figure represens the total value of your current holdings across all of your Portfolios within this Account as at the "Update" date displayed. It does not include any commitments to invest or loans" |
#  @S487-AC1-AT1
# This Scenario is completed in S24-AC1-AT1

  @S487-AC1-AT2
  @SIT
  Scenario:Check the Account Total Assets equal to the Account Total Assets Overlay
    Given I login as type "more_portfolio"
    When I taps on the account total assets value
    Then I should see the Account Total Assets equal to the Account Total Assets Overlay