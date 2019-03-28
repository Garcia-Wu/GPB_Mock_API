@NotAutomatable
@HK @SG @UK
@Epic_GPBM-459(More_Menu)
@Story_GPBM-606 @Sprint6_iOS
@Story_GPBM-2167 @Sprint6_aOS

Feature: Privacy Policy section of Legal

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  Scenario: login userE for GPBM606
    Given I login as type "has_account"
    When I tap on More Menu button
    And I tap on Legal button
    And I tap "Terms & Conditions" link
    Then I should on the Privacy Policy section

  @S265-AC1-AT1
  @DependsOn('login_userE_for_GPBM606')
  Scenario: Check Accessing Privacy Policy
    Given I am on the Privacy Policy section
    Then I should taken to the Privacy Policy screen where they can view the latest version of the Privacy Poliy
      | element name      | element value                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
      | back legal button | Legal                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
      | title             | Privacy policy                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
      | ios content       | This website https://pbgb.d2c.seic.com (the “Site”) provides a portal, or gateway, to the investment services offered by HSBC Private Bank (UK) Limited. HSBC Private Bank (UK) Limited is a public limited company registered in England and Wales under Company Register Number 499482 and with its registered office at 8 Canada Square, London, E14 5HQ, UK. For the purpose of the General Data Protection Regulation (the “Regulation”), the data controller is HSBC Private Bank (UK) Limited (‘we’, ‘us’ and ‘our’).We recognise the importance of respecting your information and maintaining its confidentiality. This policy (together with the Site Terms and Conditions and any other documents referred to in it) sets out how we collect and process your information in connection with the Site (the “Privacy Policy”). Please read the following carefully to understand our practices regarding your information and how we will treat it.This Privacy Policy does not apply to the information that we collect in connection with our.      |
      | aos content       | This website https://pbgb.d2c.seic.com (the “Site”) provides a portal, or gateway, to the investment services offered by HSBC Private Bank (UK) Limited. HSBC Private Bank (UK) Limited is a public limited company registered in England and Wales under Company Register Number 499482 and with its registered office at 8 Canada Square, London, E14 5HQ, UK. For the purpose of the General Data Protection Regulation (the “Regulation”), the data controller is HSBC Private Bank (UK) Limited (‘we’, ‘us’ and ‘our’).   We recognise the importance of respecting your information and maintaining its confidentiality. This policy (together with the Site Terms and Conditions and any other documents referred to in it) sets out how we collect and process your information in connection with the Site (the “Privacy Policy”). Please read the following carefully to understand our practices regarding your information and how we will treat it.   This Privacy Policy does not apply to the information that we collect in connection with our |

  @S265-AC1-AT2
  @DependsOn('login_userE_for_GPBM606')
  Scenario: Check Exiting Privacy Policy
    Given I am on the Privacy Policy section
    When I tap "Legal" back button
    Then I should see the Legal screen with Terms and Conditions, Privacy Policy and Accessibility Statement links