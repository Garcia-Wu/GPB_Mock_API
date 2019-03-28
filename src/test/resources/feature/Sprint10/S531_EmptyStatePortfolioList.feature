@UK @HK @SG
@Epic_GPBM-368(My_Account)
@Story_GPBM-3205 @Sprint10_iOS
@Story_GPBM-3206 @Sprint10_aOS

Feature: Empty state - Portfolio list

  As a client I want to view the Portfolio name,
  so that I can easily differentiate between the accounts

  @S531-AC1-AT1
  Scenario: Check the tipMessage in Portfolio list when there are no portfolios for that account
    Given I login as type "no_portfolio"
    Then I should see the following empty state copy in portfolio list view:"There are no portfolios to display within this account."
