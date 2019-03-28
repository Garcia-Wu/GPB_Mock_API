@HK @SG
@Epic_GPBM-1022(Transactions)
@Story_GPBM-3558 @Sprint17_iOS
@Story_GPBM-3636 @Sprint17_aOS

Feature: Transaction detail disclaimer update - Asia

  As a Product owner, I want to ensure that clients are displayed the acurate transaction detail disclaimer,
  so that it will lead client to the right direction

  # Tested in sprint5 @S187-AC1-AT1
  @NotAutomatable
  @S3558-AC1-AT1
  Scenario: Check the Transaction detail disclaimer update
    Given client login successfully
    When view the transaction detail page
    Then Client is taken to the new copy below "The value of this transaction in base currency is based on the latest available exchange rates, rather than the exchange rate at the time of the transaction."
