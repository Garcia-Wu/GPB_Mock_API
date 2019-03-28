@UK
@Epic_GTMB-459(More_menu)
@Story_GPBM-2997 @Sprint9_iOS
@Story_GPBM-2998 @Sprint9_aOS

Feature: Hide link to KRC in More Menu for UK clients

  As a bank we do not want to give UK (only) clients access to the KRC website via the app,
  so that Legal issues can be resolve before we allow UK clients access to the site

  @S500-AC1-AT1
  Scenario: Check whether KRC tab will be hidden when client has accounts in the UK
    Given I login as type "has_account"
    When I tap on More Menu button
    Then I should not see the KRC tab as it is hidden