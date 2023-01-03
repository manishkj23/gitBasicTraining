##====================================================
## ORBIT REGRESSION PACK
##====================================================
Feature: Automation Pack for Orbit - Electrolux PNC Pre-populates

  Background: User to Login
    Given I navigate to D&G CC Agent Portal
    When I enter username and password and click Login
    Then I verify the Login is successful

  Scenario Outline: TC#01 - Verify PNC number pre-populates for the existing plan having claim history.
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    And I verify the "<PlanNo>" is in Live Status
    When I select the product "<PlanNo>" and click the claim type "<ClaimType>"
    Then I verify that Number "<PNCNumber>" "<MLCodeNumber>" "<SerialNumber>" pre-populates in the dropdown
    Examples:
      | PlanNo     | ClaimType | ServiceOption                     | PNCNumber  | MLCodeNumber | SerialNumber |
      | C1Z0124269 | Breakdown | Home Visit (Normal Working Hours) | 913102360  | 01           | 365214       |

  Scenario Outline: TC#02 - Select PNC from dropdown
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    And I verify the "<PlanNo>" is in Live Status
    When I select the product "<PlanNo>" and click the claim type "<ClaimType>"
    Then I click on the PNC radio button and select the PNC value from the dropdown
    Examples:
      | PlanNo     | ClaimType |
      | C1Z0126163 | Breakdown |

