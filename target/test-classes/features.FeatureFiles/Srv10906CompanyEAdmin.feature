##====================================================
## Orbit SRV 10906 - Company E Admin Plans Pop up - SIT
##====================================================
Feature: Automation Pack for SRV 10906 - Company E Admin Plans - SIT

  Background: User to Login
    Given I navigate to D&G CC Agent Portal
    When I enter username and password and click Login
    Then I verify the Login is successful
 #   And I verify the orbit logo displayed

  Scenario Outline: SCN#001 - Verify Direct Referral Pop up message displaying SP Contact Details and URL
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I verify Direct Referral pop up message displayed with SP name and Contact Details
    Then I click on Go to Referral button to navigate to respective OEM website

    Examples:
      | PlanNo     | ClaimType |
      | MNS0002456 | Breakdown |

  Scenario Outline: SCN#002 - Verify OEM website page open after clicking on Go to URL in Direct Referral Pop up.
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I verify Direct Referral pop up message displayed with SP name and Contact Details
    Then I click on Go to Referral button to navigate to respective OEM website

    Examples:
      | PlanNo     | ClaimType |
      | MNS0002456 | Breakdown |