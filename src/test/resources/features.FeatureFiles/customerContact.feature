##====================================================
## ORBIT CR Testing PACK
##====================================================
Feature: Automation Pack for Orbit - WorkQ Task created via - Customer Contact scenario

  Background: User to Login
    Given I navigate to D&G CC Agent Portal
    When I enter username and password and click Login
    Then I verify the Login is successful

############################################# 1st Scenario working fine ##########################################################################################
  Scenario Outline: Verify WorkQ Task created via - Customer Contact and Mark Completed via MyWorkQ task for the below scenario
  Plan Change > Credit Card Payment > WorldPay Credit Card Payments

    Given I enter Plan number "<PlanNo>" and click search button in Track Repair or Claim
    Then I click on Customer Contact button in plan view page
    When I enter the Customer Contact QA section with below
      | QuestionNo | Question                                                                                               | Answer              | AnswerType  | SubQuestion |
      | Q1         | What is the Customer calling for?                                                                      | Plan Change         | RadioButton |             |
      | Q2         | Which of the following would you like to complete? TEST SENTENCE LENGTH PLEASE IGNORE TEXT IN ALL CAPS | Credit Card Payment | RadioButton |             |
    Then I verify Q&A section display for WorldPay Credit Card Payment
    And I verify Value to Collect textbox having amount greater than zero and click on Next Button in WorldPay QA
    Then I click on Next button in WorldPay QA section
    Then I click on Take Payment and enter Billing details and Confirm in Payment Due pop up
    And I enter the card details in the WorldPay Card Payment page
    And I verify the WorkQ task Alert confirmation pop up displayed
    Then I click on the WorkQ Task tab in the Plan History section
    And I verify the WorkQ task created via customer contact present in MyWorkQ Task and mark it completed


    Examples:
      | PlanNo     |
      | C1Z0123373 |


    ############################################# 1st Scenario working fine ##########################################################################################
  Scenario Outline: Verify the task reference value in WorkQ task and compare it with Plan History
    Given I enter Plan number "<PlanNo>" and click search button in Track Repair or Claim
    Then I click on the WorkQ Task tab in the Plan History section
    And I verify the WorkQ task created via customer contact present in MyWorkQ Task and mark it completed

    When I enter the Customer Contact QA section with below
      | QuestionNo | Question                           | Answer              | AnswerType  | SubQuestion |
      | Q1         | What type of query is it?          | Plan Admin          | RadioButton |             |
      | Q2         | What does the Customer need to do? | Credit Card Payment | RadioButton |             |
      |            |

    Examples:
      | PlanNo     |
      | C1Z0123373 |