##====================================================
## ORBIT REGRESSION PACK NEW PLAN VIEW - UAT
##====================================================
Feature: Automation for Orbit Regression Pack : NPV - Inflight Repair Workflow - SRV-11318 Inflight Repair Contact View - Customer Interaction History

  Background: User to Login
    Given I navigate to D&G CC Agent Portal
    When I enter username and password and click Login for New Plan View
    Then I verify the Login is successful

  Scenario Outline: TC#01 - Verify Customer Interaction History with Vulnerabilities - No
    Given I search the claim for the Plan "<PlanNo>"
    When I click the recent Claim number on plan history section
    Then I verify the Inflight Repair Summary screen launch
    And I verify the Customer Interaction History section launch
    Then I verify RA Data Agent Input and Open Claim button displayed
    Then I click on the Inflight Repair Workflow link to verify the Interaction History
    Then I verify the Workflow Details have Started,Finished,Duration labels and matches the duration value
    Then I verify all the labels are present under RA Data
    Then I verify review claim page open in new tab after clicking on Open claim button

    Examples:
      | PlanNo     | ClaimType | ModelNumber |
      | BH20052675 | Breakdown | Television  |

  Scenario Outline: TC#02 - Verify Toolbox displayed in Inflight Repair Summary screen.
    Given I search the claim for the Plan "<PlanNo>"
    When I click the recent Claim number on plan history section
    Then I verify the Inflight Repair Summary screen launch
    And I verify the Customer Interaction History section launch
    Then I verify RA Data Agent Input and Open Claim button displayed
    Then I click on the Inflight Repair Workflow link to verify the Interaction History
    Then I verify the Workflow Details have Started,Finished,Duration labels and matches the duration value
    Then I verify all the labels are present under RA Data
    Then I verify review claim page open in new tab after clicking on Open claim button

    Examples:
      | PlanNo     | ClaimType | ModelNumber |
      | BH20052675 | Breakdown | Television  |