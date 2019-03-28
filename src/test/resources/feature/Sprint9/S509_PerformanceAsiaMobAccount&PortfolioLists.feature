@HK @SG
@Epic_GPBM-2010(Performance)
@Story_GPBM-2759 @Sprint9_iOS
@Story_GPBM-3144 @Sprint9_aOS

Feature: Performance - Asia - Mob - Account & Portfolio Lists

  As the Asia business,I only want clients to be able to view their performance figures at the Portfolio level,
  so that we show accurate data

  @S509-AC1-AT1
  Scenario: Check whether I can not view individual performance figures for each account when I am viewing Account list
    Given I login as type "account_list_no_performance"
    Then I can not view individual performance figures for each account of proper number of item

  @S509-AC1-AT2
  Scenario: Check whether I can view individual performance % figures for each portfolio as per UK requirements when I am viewing Portfolio list
    Given I login as type "<portfolio_list_no_show_performance_asia>"
    When I tap first item of Accounts list
    Then I can view individual performance % figures for each portfolio as per UK requirements of proper number of item
