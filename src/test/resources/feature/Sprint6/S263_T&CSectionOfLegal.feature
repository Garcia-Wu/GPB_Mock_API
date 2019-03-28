@NotAutomatable
@HK @SG @UK
@Epic_GPBM-459(More_Menu)
@Story_GPBM-569 @Sprint6_iOS
@Story_GPBM-2074 @Sprint6_aOS

Feature: T&Cs section of Legal

  As a Client I want to see a detailed view regarding my Direct Investments (Private Equity),
  Promemoria and Other yes holdings, so that I can see all related information about the particular holding.

  Scenario: login userE for GPBM569
    Given I login as type "has_account"
    When I tap on More Menu button
    And I tap on Legal button
    And I tap "Terms & Conditions" link
    Then I should on the Terms & Conditions section

  @S263-AC1-AT1
  @DependsOn('login_userE_for_GPBM569')
  Scenario:Check Accessing T&Cs
    Given I am on the Terms & Conditions section
    Then I should taken to the Terms and Conditions screen where they can view the latest version of the T&Cs they have accepted
      | element name      | element value                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |
      | back legal button | Legal                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
      | title             | Terms and conditions                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
      | ios content       | PLEASE READ THESE TERMS AND CONDITIONS CAREFULLY BEFORE APPLYING TO ACCESS, NOMINATING A USER FOR AND/OR USING, THIS SITE INCLUDING THE APPLICATIONS WHICH YOU CAN ACCESS VIA THIS SITE (collectively this website http://pbgbd2c.seic.com and the underlying applications which you can access via this website shall be referred to as the “Site”).By using this  Site, you signify your agreement to these terms and conditions and if you are using this Site on behalf of any other accountholder(s) (including, without limitation, any other individual(s), a partnership, a company or any other legal entity), you are confirming that you have full authority to bind that person to these terms and conditions. If you do not agree to these terms and conditions, please do not use the Site.• References to ‘Terms and Conditions’ are references to these terms and conditions, as amended from time to time.                           |
      | aos content       | Please read these terms and conditions carefully before applying to Access, nominating a user for and/or using, the website and/or app including the applications which you can access via the website and/or app (Collectively this website https://www.privatebanking.hsbc.co.uk/online-investments/, the mobile app and the underlying applications which you can access via the website and mobile app shall be referred to as the “Digital Services”). By using these Digital Services, you signify your agreement to these terms and conditions and if you are using these Digital Services on behalf of any other accountholder(s) (including, without limitation, any other individual(s), a partnership, a company or any other legal entity), you are confirming that you have full authority to bind that person to these terms and conditions. If you do not agree to these terms and conditions, please do not use the Digital Services. |

  @S263-AC1-AT2
  @DependsOn('login_userE_for_GPBM569')
  Scenario:Check Exiting T&Cs
    Given I am on the Terms & Conditions section
    When I tap "Legal" back button
    Then I should see the Legal screen with Terms and Conditions, Privacy Policy and Accessibility Statement links