##====================================================
## ORBIT REGRESSION PACK
##====================================================
Feature: Automation Pack for Orbit - Capture Beko Fault Code scenario

  Background: User to Login
    Given I navigate to D&G CC Agent Portal
    When I enter username and password and click Login
    Then I verify the Login is successful

  Scenario Outline: Reselect an appointment with different SP for Whirlpool Plan
    Given I click create claim and I enter BEKO plan number "<PlanNo>" and click search
    Then I Verify the "<PlanNo>" details displayed in Plan & Product Details
    When I select the product for BEKO "<PlanNo>" and click the claim type "<ClaimType>"
    Then I verify the claim type selected and Confirm Product Details section displayed
    Then I select the Model from the dropdown in Product details section for the respective OEM
    Then I select the Fault option from the Beko fault description Dropdown
    And I Click on Create Request Button
    Then I verify the Claim Created successfully
    When I enter the QA section with below tree for Beko plan
      | QuestionNo | Question                                                         | Answer | AnswerType    |
      | Q1         | Is there any reason you can think of to reject this claim?       | No     | RadioButton   |
      | Q2         | When did your product stop working?                              | Today  | Date          |
      | Q3         | Please ask the customer for a detailed description of the fault. | Test   | ResponseField |
    Then I verify claim is Accepted successfully
#    Then I click service option and verify service optionsPage loaded
#    When I confirm the service option as "<ServiceOption>" and enter the additional information
#    And I select the Available Appointment if exist and confirm appointment
#    Then I Book with an Appointment and confirm appointment
#    Then I verify claim on Checkout Process Page
#    Then I verify the Appointment booked successfully from the Review claim section

    Examples:
      | PlanNo     | ClaimType |
      | 6QT0274323 | Breakdown |