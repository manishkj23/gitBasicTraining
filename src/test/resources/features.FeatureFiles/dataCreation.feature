##====================================================
## ORBIT REGRESSION PACK
##====================================================
Feature: Automation Pack for Orbit Regression Pack


  Scenario Outline: TC#WHP_001 - Create a Breakdown Claim for a KENWOOD Plan
    Given I navigate to D&G Repairer Portal
    When I enter repairer username and password and click Login for Hotpoint
    Then I search for a claim using "<PlanNo>" and search for WrittenOff
    Then I confirm the Labour and charge for completing the Hotpoint claim

    Examples:
      | PlanNo     | ClaimType | ServiceOption                     |
      | ANW0013542 | Breakdown | Home Visit (Normal Working Hours) |