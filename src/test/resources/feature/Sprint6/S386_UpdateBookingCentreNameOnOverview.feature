@HK @SG @UK
@Epic_GPBM-411(update_booking_centre_name_on_Overview)
@Story_GPBM-2058 @Sprint6_iOS
@Story_GPBM-2059 @Sprint6_aOS

Feature: update booking centre name on Overview

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  @S386-AC1-AT1
  Scenario:Check booking centre name on Overview
    Given I login as type "uk_account"
    Then below the welcome message they should see the following label "UK Accounts"
#  Note: this is an update from label "United Kingdom"