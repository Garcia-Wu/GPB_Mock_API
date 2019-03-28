@NotAutomatable
# Reason：This function has been modified in sprint14 or sprint15
@UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-316 @Sprint1_iOS
@Story_GPBM-722 @Sprint1_aOS

Feature: View asset breakdown by Region at Overview level

  As a client I want to see which geographic regions I have invested my money in,
  so that I can make decisions regarding my investments based on regional factors that may influence capital gains

  userE: show sub class user
  userD: not invested in region user

  Scenario: login userE for GPBM316
    Given I login as type "overview_has_region"
    When I tap on the Allocation toggle
    And I tap on "Region" tab
    Then I should on the Overview screen

  @S3-AC1-AT1
  @DependsOn('login_userE_for_GPBM316')
  Scenario: check Overview Region UI.
    Given I am on the Overview screen
    Then I should see the following components when the region tab is active:
      | element name             | element value |
      | Greeting message         |               |
      | Country                  |               |
      | Total assets title       | Total assets  |
#      | Total assets icon        |               |
      | Total assets amount      |               |
#      | Total assets currency    |               |
      | Allocation button active |               |
      | Class Tab                | Class         |
      | Currency Tab             | Currency      |
      | Region Tab               | Region        |
    And I should see the Card list of different asset region

  @S3-AC1-AT2
  @DependsOn('login_userE_for_GPBM316')
  Scenario: Check the status of Allocation $ Region.
    Given I am on the Overview screen
    Then I should see the following states when tap Region Tab
      | element name      | states |
      | Allocation Toggle | active |
      | Region Tab        | active |


  @S3-AC1-AT3
  @DependsOn('login_userE_for_GPBM316')
  Scenario: Check the data of each asset Region they are invested in.
    Given I am on the Overview screen
    Then I should see the Region name
    And Region item Total asset value in reporting currency (ISO 3 format) selected to 2 d.p.
    And Region item Total asset value as a % of all assets owned to 2 d.p.

  @NotAutomatable
  Scenario: Check the horizontal bar.
    Given I am on the Overview level screen
    Then I should see a horizontal bar representing % of assets owned
  # S2-AC1-AT14
  # Reason: cannot check the bar

  @S3-AC1-AT5
  @DependsOn('login_userE_for_GPBM316')
  Scenario: Check the Sequence of the Regions By Total Assets.
    Given I am on the Overview screen
    Then I should see the regions are ordered by Total Asset value - largest to smallest

  @S3-AC1-AT6
  Scenario: Check if not invested in a specific Region.
    Given I login as type "overview_no_region"
    When I tap on the Allocation toggle
    And I tap on "Region" tab
    Then I should not see that Region listed