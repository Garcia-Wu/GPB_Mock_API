@HK @SG @UK
@Epic_GPBM-1094(Holdings)
@Story_GPBM-1090 @Sprint3_iOS
@Story_GPBM-1367 @Sprint3_aOS

Feature: Client has no Holdings

  As a client I want to see the individual holdings that make up my exposure to each geographical region within each Account,
  so that I know which holdings to review in order to change my regional exposure as desired

  @S80-AC1-AT1
  Scenario: Check the following message when there are no holdings and no Contingent liabilities
    Given I login as type "no_holding"
#    When I tap four item of Accounts list
#    And I tap last item of Portfolios list
    And I tap on portfolio "Holdings" tab
    Then I should see the following message under the holdings is displayed:
      | element name           | element value                                          |
      | Holdings title         | There are no holdings available within this portfolio. |
      | Android Holdings title | There are no holdings available within this portfolio. |
#      | Holdings content       | Lorem ipsum dolor sit amet, consectetur adiposcing elit. Ut lobortis et nunc et vulputate. |
    And no holdings are displayed

#  Contingent liabilities remove
#  @S80-AC1-AT2
#  Scenario: Check the following message at the Holding page in Portfolio Level when there is no any holdings but has the Contingent liabilities
#    Given I login as User
#      | element name | element value |
#      | Name         | userF         |
#    When I tap first item of Accounts list
#    And I tap thirdly item of Portfolios list
#    And I tap on portfolio "Holdings" tab
#    Then I should see the following message under the Contingent liabilities is displayed:
#      | element name           | element value                                          |
#      | Holdings title         | There are no holdings available within this portfolio. |
#      | Android Holdings title | There are no holdings available within this portfolio. |
##      | Holdings content       | Lorem ipsum dolor sit amet, consectetur adiposcing elit. Ut lobortis et nunc et vulputate. |
#    And no holdings are displayed
##    And I should see Contingent liabilities bar is displayed
##    update sprint 6 Hide Contingent Liabilities in Portfolio

