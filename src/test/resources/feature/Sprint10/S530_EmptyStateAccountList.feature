@UK @HK @SG
@Epic_GPBM-367(My_Overview)
@Story_GPBM-3203 @Sprint10_iOS
@Story_GPBM-3204 @Sprint10_aOS

Feature: Empty state - Account list

  As a client I want to view the Portfolio name,
  so that I can easily differentiate between the accounts

  @S530-AC1-AT1
  Scenario: Check the tipMessage in Account list when there are no accounts for that customer
    Given I login as type "no_account"
    Then I should see the following empty state copy in account list view:"There are no accounts to display."