@NotAutomatable
# Reason：This function has been modified in sprint14 or sprint15
@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-310 @Sprint1_iOS
@Story_GPBM-714 @Sprint1_aOS

Feature: View asset class breakdown at Overview level

  As a client I want to view my asset allocation across all of my accounts,
  so that I have a high level view of my investments by asset class

  userE: show sub class user
  userD: not invested in class user

  @S1-AC1-AT1
  Scenario: Check the Overview Screen UI
    Given I login as type "overview_has_class"
    Then I should see the following components
      | element name              | element value |
      | Greeting message          |               |
      | Country                   |               |
      | Total assets title        | Total assets  |
      | Total assets amount       |               |
      | Allocation button default |               |
      | Account list              |               |
      | Menu icon                 |               |

  Scenario: login userE for GPBM310
    Given I login as type "overview_has_class"
    When I tap on the Allocation toggle
    Then I should on the Overview screen

  @S1-AC1-AT2
  @DependsOn('login_userE_for_GPBM310')
  Scenario: Check the Overview Allocation Screen UI
    Given I am on the Overview screen
    Then I should see the following components on Overview Screen
      | element region | element name                    | element value |
      |                | Greeting message                |               |
      |                | Country                         |               |
      |                | Total assets title              | Total assets  |
      |                | Total assets amount             |               |
      |                | Allocation button active        |               |
      |                | Class Tab                       | Class         |
      |                | Currency Tab                    | Currency      |
      | UK             | Region Tab                      | Region        |
      |                | Show Sub-Asset Class toggle off |               |
      |                | Menu icon                       |               |

  @S1-AC1-AT3
  @DependsOn('login_userE_for_GPBM310')
  Scenario: Check the status of Allocation $ Class $ Show Sub-Asset Class
    Given I am on the Overview screen
    Then I should see the following states:
      | element name                | states   |
      | Allocation Toggle           | active   |
      | Class Tab                   | active   |
      | Show Sub-Asset Class Toggle | inactive |


  @S1-AC1-AT4
  @DependsOn('login_userE_for_GPBM310')
  Scenario: Check the data for each asset class they are invested in
    Given I am on the Overview screen
    Then I should see the following data in Overview class list
      | element name            | element value |
      | Asset Class name        |               |
      | Total asset             |               |
      | Total assets percentage |               |

  @NotAutomatable
  Scenario: Check the processing bar status
    When dummy

  #  S1-AC1-AT5
  #  Reason: cannot check the processing bar status

# object ID有问题
  @S1-AC1-AT6
  @DependsOn('login_userE_for_GPBM310')
  Scenario: Check the sequence of Total Asset value
    Given I am on the Overview screen
    Then I should see the asset classes are ordered by Total Asset value - largest to smallest
#  IOS: Because we can't get the object id
#  @S1-AC1-AT6
#  @DependsOn('login_userE_for_GPBM310')


  @S1-AC1-AT7
  Scenario: Check if not invested in a specific Asset Class.
    Given I login as type "overview_no_class"
    When I tap on the Allocation toggle
    Then I should not see that Class listed
