@HK @SG @UK
@Epic_GPBM-307
@Story_GPBM-557 @Sprint2_iOS

Feature: View sub-asset class breakdown at Portfolio level

  As a client I want to view my sub-asset allocation within one of my portfolios,
  so that I have a high level view of my investments by sub-asset class

  @NotAutomatable
  Scenario: Check whether the Class&Currency&Region can be fixed/sticky when scroll down the asset class lists.
    Given Client is logged in
    And client is entitled to view one or more portfolios
    And client has invested in one or more securities
    And client is viewing one Portfolio
    When Client taps on Asset Allocation toggle
    And taps "Show Sub-Asset Class" toggle ON within default Asset Class view
    And scroll down the list
    Then I should see Class, Currency and Region tabs are fixed/sticky
  #  S10-AC1-AT1
  #  Reason: cannot check the fixed state or not fixed state of the "Show sub-asset class" toggle

  @NotAutomatable
  Scenario: Check whether the "Show sub-asset class" toggle should NOT be fixed.
    Given Client is logged in
    And client is entitled to view one or more portfolios
    And client has invested in one or more securities
    And client is viewing one Portfolio
    When Client taps on Asset Allocation toggle
    And taps "Show Sub-Asset Class" toggle ON within default Asset Class view
    And scroll down the list
    Then I should see the "Show sub-asset class" toggle should NOT be fixed
  #  S10-AC1-AT2
  #  Reason: cannot check the fixed state or not fixed state of the "Show sub-asset class" toggle

  @NotAutomatable
  Scenario: Check whether the Class&Currency&Region can be fixed/sticky when scroll down the asset class lists.
    Given Client is logged in
    And client is entitled to view one or more portfolios
    And client has invested in one or more securities
    And client is viewing one Portfolio
    When Client taps on Asset Allocation toggle
    And taps "Show Sub-Asset Class" toggle OFF within default Asset Class view
    And scroll down the list
    Then I should see Class, Currency and Region tabs are fixed/sticky
  #  S10-AC1-AT3
  #  Reason: cannot check the fixed state or not fixed state of the "Show sub-asset class" toggle

  @NotAutomatable
  Scenario: Check whether the "Show sub-asset class" toggle should NOT be fixed.
    Given Client is logged in
    And Client is entitled to view one or more portfolios
    And Client has invested in one or more securities
    And Client is viewing one Portfolio
    When Client taps on Asset Allocation toggle
    And taps "Show Sub-Asset Class" toggle OFF within default Asset Class view
    And scroll down the list
    Then I should see the "Show sub-asset class" toggle should NOT be fixed
  #  S10-AC1-AT4
  #  Reason: cannot check the fixed state or not fixed state of the "Show sub-asset class" toggle