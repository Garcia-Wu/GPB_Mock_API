@UK
@Epic_GPBM-459(More_menu)
@Story_GPBM-544 @Sprint2_iOS
@Story_GPBM-1067 @Sprint2_aOS

Feature: Glossary of Terms

  As a client I want to see a glossary of key terms used within my Wealth Dashboard,
  so that I can clarify any questions I might have about the information I am viewing without need to call my RM

  @Sprint19
  @S39-AC1-AT1
  Scenario: Check whether there is a list of investment terms.
    Given I login as type "has_account"
    When I tap on More Menu button
    And I tap on Glossary of terms
    Then I should see a list of investment terms
      | element name                       | element value                     |
      | Accrued interest Label             | Accrued interest                  |
      | Asset allocation Label             | Asset allocation                  |
      | Asset class Label                  | Asset allocation: Asset Class     |
      | Currency (asset allocation) Label  | Asset Allocation: Currency        |
      | Region (asset allocation) Label    | Asset Allocation: Region          |
      | Sub-Class (asset allocation) Label | Asset Allocation: Sub-Asset Class |
      | Base Currency Label                | Base currency                     |
      | Exposure Label                     | Exposure                          |
      | Holding Label                      | Holding                           |
      | Holding currency Label             | Holding currency                  |
      | Investment funds Label             | Investment funds                  |
      | Mandate (Advisory) Label           | Mandate (Advisory)                |
      | Mandate (Discretionary) Label      | Mandate (Discretionary)           |
      | Mandate (External) Label           | Mandate (External)                |
      | Market Price Label                 | Market Price                      |
      | Market Value Label                 | Market Value                      |
      | Overview Label                     | Overview                          |
      | Performance Label                  | Performance                       |
      | Profit/loss Label                  | Profit/loss                       |
      | Settlement date Label              | Settlement date                   |
      | Total Assets Label                 | Total Assets                      |
      | Trade date Label                   | Trade date                        |
      | Transaction currency Label         | Transaction currency              |
      | Units Label                        | Units                             |

  @HK @SG
  Scenario: login userE for GPBM544
    Given I login as type "has_account"
    When I tap on More Menu button
    And I tap on Glossary of terms
    Then I should on the Glossary of terms

  @HK @SG
  @S39-AC1-AT2
  @DependsOn('login_userE_for_GPBM544')
  Scenario: Check whether the term of the glossary can be expanded.
    Given I am on the Glossary of terms
    When I tap on tap area around a term
    Then I should see the card should expand so that the definition of that term becomes visible


  @NotAutomatable
  Scenario: Check whether the adjacent chevron of openning glossary item now points up.
    Then  then I should see the adjacent chevron to the term label should animate so it now points up (default is pointing down)
  #  S39-AC1-AT3
  #  Reason: cannot check the adjacent chevron(the arrow)

  @HK @SG
  @S39-AC1-AT4
  @DependsOn('login_userE_for_GPBM544')
  Scenario: Check if other expanded terms remain expanded when I expand a new term.
    Given I am on the Glossary of terms
    When I tap on tap area around a new term
    Then I should see other expanded terms remain expanded

  @HK @SG
  @S39-AC1-AT5
  @DependsOn('login_userE_for_GPBM544')
  Scenario: Check if the Opening term can be collapse.
    Given I am on the Glossary of terms
    When I tap on tap area around a term again
    Then I should see the card should collapse so that only the glossary term is visible

  @HK @SG
  @S39-AC1-AT6
  @DependsOn('login_userE_for_GPBM544')
  Scenario: Check whether the term label can stay in the same position on the screen when the term was expanded.
    Given I am on the Glossary of terms
    Then I should see the term label should stay in the same position on the screen as it was when the term was expanded

  @NotAutomatable
  Scenario: Check if the adjacent chevron points down.
    Then I should see the adjacent chevron to the term label should animate so it now points down
  #  S39-AC1-AT7
  #  Reason: cannot check the adjacent chevron(the arrow)


  @NotAutomatable
  Scenario: Check whether the scroll bar of the list of the term is exists.
    Given client wants to scroll up or down the list of terms displayed
    When client swipes up or down on the list
    Then I should see a scroll bar appears to indicate that the user can scroll
  #  S39-AC1-AT8
  #  Reason: cannot check the scroll bar


  @HK @SG
  @S39-AC1-AT9
  @DependsOn('login_userE_for_GPBM544')
  Scenario: Check the Menu label top left of Glossary screen.
    Given I am on the Glossary of terms
    When I tap on "Menu" label top left of Glossary screen
    Then I should return to the More menu page


  @HK @SG
  @S39-AC1-AT10
  Scenario: Check whether the bottom of the Glossary terms can automatically move up and display the definition without having to manually scroll.
    Given I login as type "has_account"
    When I tap on More Menu button
    And I tap on Glossary of terms
    And I tap the last term
    Then I should see the definition of the last term expands
    And the list of terms automatically move up to allow enough space for the user to see the whole definition without having to manually scroll

  @Sprint19
  @S39-AC1-AT11
  Scenario: Check Glossary of term message
    Given I login as type "has_account"
    When I tap on More Menu button
    And I tap on Glossary of terms
    Then I should see the term message of all
      | element name           | element value                                                                                                                                                                                                                                                                                                                                                                                           |
      | Glossary of terms0     | Shows the total interest accrued but not yet paid or received.                                                                                                                                                                                                                                                                                                                                          |
      | Glossary of terms1     | Asset allocation describes the process of categorising the investments in your portfolio according to their characteristics, such as asset class, currency and region. The risk and the return associated with a portfolio is related to how much has been invested in each.                                                                                                                            |
      | Glossary of terms2     | An asset class is a group of securities that exhibit similar characteristics, behave similarly in the marketplace, and are subject to the same laws and regulations. Examples of asset classes are Equities (shares), Fixed Income (e.g. Government Bonds) and Alternatives (e.g. Private Equity).                                                                                                      |
      | Glossary of terms3     | The currency exposure of an asset, such as stocks, is the sensitivity of that asset's return, measured in the investor's holding currency, to fluctuations in exchange rates. Investors, as owners of companies and assets, have currency exposure through exchange rate fluctuations.                                                                                                                  |
      | AOSGlossary of terms3  | The currency exposure of an asset, such as stocks, is the sensitivity of that asset’s return, measured in the investor's holding currency, to fluctuations in exchange rates. Investors, as owners of companies and assets, have currency exposure through exchange rate fluctuations.                                                                                                                  |
      | Glossary of terms4     | The regional exposure of an asset, such as stocks, is the sensitivity of that asset’s return to the location within which the asset was purchased.                                                                                                                                                                                                                                                      |
      | Glossary of terms5     | A sub-asset class is a group of securities within the same asset class that exhibit similar characteristics, behave similarly in the marketplace, and are subject to the same laws and regulations. Examples of sub-asset classes are Government Bonds and Corporate Bonds within the class Fixed Income.                                                                                               |
      | Glossary of terms6     | The single currency that you have agreed the value of your investments will be reported in at Account and Portfolio level. Your Overview however, will always be displayed in the local currency to the booking centre within which your Accounts were opened.                                                                                                                                          |
      | Glossary of terms7     | This is the total asset value of your investments in a particular asset class, currency or region. It is expressed as a percentage of one account or portfolio, or all of your accounts, depending on the level of detail you've chosen. 'Positive exposure' means the net value of the particular asset class, currency or region is above 0.                                                          |
      | Glossary of terms8     | An asset that you own, such as shares or bonds (including cash).                                                                                                                                                                                                                                                                                                                                        |
      | Glossary of terms9     | The currency in which an asset was purchased or in which you hold cash.                                                                                                                                                                                                                                                                                                                                 |
      | Glossary of terms10    | Investment funds let you put your money together with other investors to buy a wider range of investments than you would not be able to achieve on your own. Funds are managed by professional fund managers.                                                                                                                                                                                           |
      | Glossary of terms11    | Even when we are not instructed to make investment decisions on your behalf, we can provide guidance to help you develop an asset allocation strategy and investment guidelines. With our comprehensive, consultative approach, we develop an awareness of your financial circumstances and tailor an approach to your needs.                                                                           |
      | AOSGlossary of terms11 | Even when we are not instructed to make investment decisions on your behalf, we can provide guidance to help you develop an asset allocation strategy and investment guidelines. With our comprehensive, consultative approach, we develop an awareness of your financial circumstances and tailor an approach to your needs.                                                                           |
      | Glossary of terms12    | Our investment managers expertly create customised portfolios across all traditional and alternative asset classes. Your diversified, discretionary portfolio may incorporate a mix of HSBC or third-party solutions across the spectrum of asset classes - domestic, international and emerging market fixed income and equities, as well as alternative investments - based on your individual needs. |
      | Glossary of terms13    | When you manage your own investment portfolio you can still benefit from our investment specialists’ global knowledge and views. We also offer a broad range of tools and solutions that can play an important role as you develop your investment strategy.                                                                                                                                            |
      | Glossary of terms14    | The latest available price per unit of an asset.                                                                                                                                                                                                                                                                                                                                                        |
      | Glossary of terms15    | The value of an asset, obtained by multiplying the number of units held by the latest available price per unit.                                                                                                                                                                                                                                                                                         |
      | Glossary of terms16    | The “Overview” shows key valuation information at a summary level for all of the UK investment accounts you are entitled to view; all values at this level are obtained by aggregating your individual account values using a single base currency.                                                                                                                                                     |
      | Glossary of terms17    | This is a measure of your account’s compound rate of growth. It does not take into account money flows so is not affected by withdrawals or contributions. The rate of growth is the geometric mean of the sub-periods’ holding period returns.                                                                                                                                                         |
      | Glossary of terms18    | The Profit/loss value represents the difference between the market valuation of an asset and the initial cost of purchasing it. Note: The profit or loss value should not be used on its own to calculate capital gains tax. Please consult a tax advisor if you require assistance.                                                                                                                    |
      | Glossary of terms19    | The date upon which an asset must be paid for and legal ownership changes.                                                                                                                                                                                                                                                                                                                              |
      | Glossary of terms20    | This figure represents the total value of your current holdings across all of your UK accounts, one Account or one Portfolio, depending on the level you are at. It does not include the value of any commitments to invest or loans.                                                                                                                                                                   |
      | Glossary of terms21    | The date upon which an asset is traded. In the case of buy or sell, the transaction date is the actual date on which units were sold or purchased in the market. For a dividend payment, the transaction date is the date on which the actual dividend payment or units are reflected in the portfolio.                                                                                                 |
      | Glossary of terms22    | The currency in which a transaction was made.                                                                                                                                                                                                                                                                                                                                                           |
      | Glossary of terms23    | The number of units of an asset purchased, e.g. shares.                                                                                                                                                                                                                                                                                                                                                 |
