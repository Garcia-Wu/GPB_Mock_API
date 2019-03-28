@NotAutomatable
# Tested in sprint15 and sprint14 Class\Currency\Region Graphical view at Overview\Account\Region
@HK @SG @UK
@Epic_GPBM-307(Asset_Allocation)
@Story_GPBM-3677 @Sprint17_iOS
@Story_GPBM-3678 @Sprint17_aOS

Feature: Graphical view - Correction to negative net assets scenario

  This user story is to correct the Scenario "Client's net holdings are negative - Edge" from all the Asset Allocation "graphical view" user stories (e.g. GPBM-3477), because it was incorrectly written.
  While the BDD style scenario below considers the case of Asset Class at Overview level, it is important that this user story applies to:
  
#  Scenario - Client's net holdings are negative - Edge*
  @S3677-AC1-AT1
  Scenario: Client's net holdings are negative at overview asset class
  Given I am at Overview level
  And the wrapper is maximised
  And I am entitled to view one or more accounts
  And my "Total Assets" are negative across my accounts
  When I tap on the Asset Allocation toggle
  Then I can view a graphic with a representation of the total value of my holdings for only my POSITIVE Asset Classes, as a proportion of my total asset value (this follows a rule to display the 7 highest value Asset Classes before grouping any remaining into “Others” if there are more than 8 asset classes or insufficient product information)
  And my negative Asset Classes are NOT represented on the graphic
  And the graphic includes "Total assets" label and "Total assets" value in Overview base currency, across all my accounts, which is NEGATIVE
  And Overview base currency ISO 3 code
  And I can view only my POSITIVE asset classes in a key below the tab which matches the asset classes represented in the graphic
  And my negative Asset Classes are NOT shown in the key
  And the graphic includes copy "positive exposures displayed" to state that negative holdings are present and must be viewed in the list
  And the wrapper above the graphic contains the following:
#  "Asset allocation" label
#  Asset Allocation toggle in ACTIVE state
#  Salutation, Firstname, Lastname
#  <Region> Accounts - e.g. "UK Accounts"
#  Tabs for Asset Class, Currency and Region  - (Only "Asset Class" and "Currency" tabs for Asia)

  @S3677-AC1-AT2
  Scenario: Client's net holdings are negative at overview currency
  Given I am at Overview level
  And the wrapper is maximised
  And I am entitled to view one or more accounts
  And my "Total Assets" are negative across my accounts
  When I tap on the Asset Allocation toggle
  Then I can view a graphic with a representation of the total value of my holdings for only my POSITIVE Currency, as a proportion of my total asset value (this follows a rule to display the 7 highest value Currency before grouping any remaining into “Others” if there are more than 8 asset classes or insufficient product information)
  And my negative Currency are NOT represented on the graphic
  And the graphic includes "Total assets" label and "Total assets" value in Overview base currency, across all my accounts, which is NEGATIVE
  And Overview base currency ISO 3 code
  And I can view only my POSITIVE asset classes in a key below the tab which matches the asset classes represented in the graphic
  And my negative Currency are NOT shown in the key
  And the graphic includes copy "positive exposures displayed" to state that negative holdings are present and must be viewed in the list
  And the wrapper above the graphic contains the following:
#  "Asset allocation" label
#  Asset Allocation toggle in ACTIVE state
#  Salutation, Firstname, Lastname
#  <Region> Accounts - e.g. "UK Accounts"
#  Tabs for Asset Class, Currency and Region  - (Only "Asset Class" and "Currency" tabs for Asia)

  @S3677-AC1-AT3
  Scenario: Client's net holdings are negative at overview region
  Given I am at Overview level
  And the wrapper is maximised
  And I am entitled to view one or more accounts
  And my "Total Assets" are negative across my accounts
  When I tap on the Asset Allocation toggle
  Then I can view a graphic with a representation of the total value of my holdings for only my POSITIVE Region, as a proportion of my total asset value (this follows a rule to display the 7 highest value Region before grouping any remaining into “Others” if there are more than 8 asset classes or insufficient product information)
  And my negative Region are NOT represented on the graphic
  And the graphic includes "Total assets" label and "Total assets" value in Overview base currency, across all my accounts, which is NEGATIVE
  And Overview base currency ISO 3 code
  And I can view only my POSITIVE asset classes in a key below the tab which matches the asset classes represented in the graphic
  And my negative Region are NOT shown in the key
  And the graphic includes copy "positive exposures displayed" to state that negative holdings are present and must be viewed in the list
  And the wrapper above the graphic contains the following:
#  "Asset allocation" label
#  Asset Allocation toggle in ACTIVE state
#  Salutation, Firstname, Lastname
#  <Region> Accounts - e.g. "UK Accounts"
#  Tabs for Asset Class, Currency and Region  - (Only "Asset Class" and "Currency" tabs for Asia)

  @S3677-AC2-AT1
  Scenario: Client's net holdings are negative at account asset class
  Given I am at Overview level
  And the wrapper is maximised
  And I am entitled to view one or more accounts
  And my "Total Assets" are negative across my accounts
  When I tap on the Asset Allocation toggle
  Then I can view a graphic with a representation of the total value of my holdings for only my POSITIVE Asset Classes, as a proportion of my total asset value (this follows a rule to display the 7 highest value Asset Classes before grouping any remaining into “Others” if there are more than 8 asset classes or insufficient product information)
  And my negative Asset Classes are NOT represented on the graphic
  And the graphic includes "Total assets" label and "Total assets" value in Overview base currency, across all my accounts, which is NEGATIVE
  And Overview base currency ISO 3 code
  And I can view only my POSITIVE asset classes in a key below the tab which matches the asset classes represented in the graphic
  And my negative Asset Classes are NOT shown in the key
  And the graphic includes copy "positive exposures displayed" to state that negative holdings are present and must be viewed in the list
  And the wrapper above the graphic contains the following:
#  "Asset allocation" label
#  Asset Allocation toggle in ACTIVE state
#  Salutation, Firstname, Lastname
#  <Region> Accounts - e.g. "UK Accounts"
#  Tabs for Asset Class, Currency and Region  - (Only "Asset Class" and "Currency" tabs for Asia)

  @S3677-AC2-AT2
  Scenario: Client's net holdings are negative at account currency
  Given I am at Overview level
  And the wrapper is maximised
  And I am entitled to view one or more accounts
  And my "Total Assets" are negative across my accounts
  When I tap on the Asset Allocation toggle
  Then I can view a graphic with a representation of the total value of my holdings for only my POSITIVE Currency, as a proportion of my total asset value (this follows a rule to display the 7 highest value Currency before grouping any remaining into “Others” if there are more than 8 asset classes or insufficient product information)
  And my negative Currency are NOT represented on the graphic
  And the graphic includes "Total assets" label and "Total assets" value in Overview base currency, across all my accounts, which is NEGATIVE
  And Overview base currency ISO 3 code
  And I can view only my POSITIVE asset classes in a key below the tab which matches the asset classes represented in the graphic
  And my negative Currency are NOT shown in the key
  And the graphic includes copy "positive exposures displayed" to state that negative holdings are present and must be viewed in the list
  And the wrapper above the graphic contains the following:
#  "Asset allocation" label
#  Asset Allocation toggle in ACTIVE state
#  Salutation, Firstname, Lastname
#  <Region> Accounts - e.g. "UK Accounts"
#  Tabs for Asset Class, Currency and Region  - (Only "Asset Class" and "Currency" tabs for Asia)

  @S3677-AC2-AT3
  Scenario: Client's net holdings are negative at account region
  Given I am at Overview level
  And the wrapper is maximised
  And I am entitled to view one or more accounts
  And my "Total Assets" are negative across my accounts
  When I tap on the Asset Allocation toggle
  Then I can view a graphic with a representation of the total value of my holdings for only my POSITIVE Region, as a proportion of my total asset value (this follows a rule to display the 7 highest value Region before grouping any remaining into “Others” if there are more than 8 asset classes or insufficient product information)
  And my negative Region are NOT represented on the graphic
  And the graphic includes "Total assets" label and "Total assets" value in Overview base currency, across all my accounts, which is NEGATIVE
  And Overview base currency ISO 3 code
  And I can view only my POSITIVE asset classes in a key below the tab which matches the asset classes represented in the graphic
  And my negative Region are NOT shown in the key
  And the graphic includes copy "positive exposures displayed" to state that negative holdings are present and must be viewed in the list
  And the wrapper above the graphic contains the following:
#  "Asset allocation" label
#  Asset Allocation toggle in ACTIVE state
#  Salutation, Firstname, Lastname
#  <Region> Accounts - e.g. "UK Accounts"
#  Tabs for Asset Class, Currency and Region  - (Only "Asset Class" and "Currency" tabs for Asia)

  @S3677-AC3-AT1
  Scenario: Client's net holdings are negative at portfolio asset class
  Given I am at Overview level
  And the wrapper is maximised
  And I am entitled to view one or more accounts
  And my "Total Assets" are negative across my accounts
  When I tap on the Asset Allocation toggle
  Then I can view a graphic with a representation of the total value of my holdings for only my POSITIVE Asset Classes, as a proportion of my total asset value (this follows a rule to display the 7 highest value Asset Classes before grouping any remaining into “Others” if there are more than 8 asset classes or insufficient product information)
  And my negative Asset Classes are NOT represented on the graphic
  And the graphic includes "Total assets" label and "Total assets" value in Overview base currency, across all my accounts, which is NEGATIVE
  And Overview base currency ISO 3 code
  And I can view only my POSITIVE asset classes in a key below the tab which matches the asset classes represented in the graphic
  And my negative Asset Classes are NOT shown in the key
  And the graphic includes copy "positive exposures displayed" to state that negative holdings are present and must be viewed in the list
  And the wrapper above the graphic contains the following:
#  "Asset allocation" label
#  Asset Allocation toggle in ACTIVE state
#  Salutation, Firstname, Lastname
#  <Region> Accounts - e.g. "UK Accounts"
#  Tabs for Asset Class, Currency and Region  - (Only "Asset Class" and "Currency" tabs for Asia)

  @S3677-AC3-AT2
  Scenario: Client's net holdings are negative at portfolio currency
  Given I am at Overview level
  And the wrapper is maximised
  And I am entitled to view one or more accounts
  And my "Total Assets" are negative across my accounts
  When I tap on the Asset Allocation toggle
  Then I can view a graphic with a representation of the total value of my holdings for only my POSITIVE Currency, as a proportion of my total asset value (this follows a rule to display the 7 highest value Currency before grouping any remaining into “Others” if there are more than 8 asset classes or insufficient product information)
  And my negative Currency are NOT represented on the graphic
  And the graphic includes "Total assets" label and "Total assets" value in Overview base currency, across all my accounts, which is NEGATIVE
  And Overview base currency ISO 3 code
  And I can view only my POSITIVE asset classes in a key below the tab which matches the asset classes represented in the graphic
  And my negative Currency are NOT shown in the key
  And the graphic includes copy "positive exposures displayed" to state that negative holdings are present and must be viewed in the list
  And the wrapper above the graphic contains the following:
#  "Asset allocation" label
#  Asset Allocation toggle in ACTIVE state
#  Salutation, Firstname, Lastname
#  <Region> Accounts - e.g. "UK Accounts"
#  Tabs for Asset Class, Currency and Region  - (Only "Asset Class" and "Currency" tabs for Asia)

  @S3677-AC3-AT3
  Scenario: Client's net holdings are negative at portfolio region
  Given I am at Overview level
  And the wrapper is maximised
  And I am entitled to view one or more accounts
  And my "Total Assets" are negative across my accounts
  When I tap on the Asset Allocation toggle
  Then I can view a graphic with a representation of the total value of my holdings for only my POSITIVE Region, as a proportion of my total asset value (this follows a rule to display the 7 highest value Region before grouping any remaining into “Others” if there are more than 8 asset classes or insufficient product information)
  And my negative Region are NOT represented on the graphic
  And the graphic includes "Total assets" label and "Total assets" value in Overview base currency, across all my accounts, which is NEGATIVE
  And Overview base currency ISO 3 code
  And I can view only my POSITIVE asset classes in a key below the tab which matches the asset classes represented in the graphic
  And my negative Region are NOT shown in the key
  And the graphic includes copy "positive exposures displayed" to state that negative holdings are present and must be viewed in the list
  And the wrapper above the graphic contains the following:
#  "Asset allocation" label
#  Asset Allocation toggle in ACTIVE state
#  Salutation, Firstname, Lastname
#  <Region> Accounts - e.g. "UK Accounts"
#  Tabs for Asset Class, Currency and Region  - (Only "Asset Class" and "Currency" tabs for Asia)



