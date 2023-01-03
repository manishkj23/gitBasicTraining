##====================================================
## Orbit Health Checks - SIT
##====================================================
Feature: Automation Pack for Orbit Health Checks - SIT

  Background: User to Login
    Given I navigate to D&G CC Agent Portal
    When I enter username and password and click Login
    Then I verify the Login is successful
    And I verify the orbit logo displayed


  @HC001_SIT @SIT-EnvironmentHealthCheck
  Scenario Outline: HC#001 - Verify the Calendar Availability for FlyingToolBoxRespond with Electrolux Service Provider
    Given I click create claim and I enter plan number "<PlanNo>" and click search for WrittenOff
    Then I Verify the "<PlanNo>" details displayed for WrittenOff
    When I select the product for WrittenOff "<PlanNo>" and click the claim type "<ClaimType>"
    Then I enter the Product details section "<PNC Number>" and serial number details
    And I click create request button for Goods
#    And I waive off the Excess Pay
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                                                                 | Answer                  | AnswerType    |
#      | Q1         | Is there any reason you can think of to reject this claim?                          | No                      | RadioButton   |
      | Q1         | Please select whether your appliance installation type is free standing or built in      | Freestanding/Standalone | RadioButton   |
      | Q2         | Please describe the fault                                                                | Test                    | ResponseField |
      | Q3         | Is there any detail the engineer should be aware of prior to or on the appointment date? | Test                    | ResponseField |
#      | Q2         | When did your product stop working?                                                      | Today                   | Date          |
#      | Q3         | Please ask the customer for a detailed description of the fault.                    | Test                    | ResponseField |
    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>"
    Then I verify the Calendar dates are available
    Then I Verify the Calendar displayed for "<ServiceProvider>"

    Examples:
      | PlanNo | ClaimType | ServiceOption                     | PNC Number | ServiceProvider                            |
      | 6YV0020630    | Breakdown | Home Visit (Normal Working Hours) | 948904188  | FLYINGTOOLBOX RESPOND,WE REPAIR APPLIANCES |


  @HC002_SIT @SIT-EnvironmentHealthCheck
  Scenario Outline: HC#002 - Verify the Calendar Availability for BAXI Service Provider
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I Verify the "<PlanNo>" details displayed
    And I verify the "<PlanNo>" is in Live Status
    When I select the product "<PlanNo>" and click the claim type "<ClaimType>"
    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
    Then I enter "<ModelNumber>" on the product confirmation section
#    Then I enter the Model Number in Product details section for Boiler
    And I click create request button for Heating Goods
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                                                                           | Answer     | AnswerType    | SubQuestion |
      | Q1         | Please re-confirm your problem                                                                     | Water leak | RadioButton   |             |
      | Q2         | Where is the leak coming from?                                                                     | TEST       | ResponseField |             |
      | Q3         | Is there any health or wellbeing reason we need to be made aware of when booking this appointment? | No         | RadioButton   |             |
      | Q4         | As the engineer will have heavy tools and equipment to carry                                       | Yes        | RadioButton   |             |
      | Q5         | To protect your belongings and make it easier for the engineer to undertake the repair             | Yes        | RadioButton   |             |

    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>"
    Then I verify the Calendar dates are available
    Then I Verify the Calendar displayed for "<ServiceProvider>"

    Examples:
      | PlanNo     | ClaimType | ModelNumber             | ServiceOption                     | ServiceProvider       |
      | KBC0008857 | Breakdown | Combination Boiler-Gold | Home Visit (Normal Working Hours) | BAXI CUSTOMER SUPPORT |


  @HC003_SIT  @SIT-EnvironmentHealthCheck
  Scenario Outline: HC#003 - Verify the Calendar Availability for WHIRLPOOL Service Provider
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I Verify the "<PlanNo>" details displayed
    When I select the product "<PlanNo>" and click the claim type "<ClaimType>"
    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
    Then I enter "<ProductType>" on the product confirmation section
    Then I enter the Model Number in Product details section
    And I click create request button for Goods
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                  | Answer                 | AnswerType    | SubQuestion |
      | Q1         | When did the incident occur?              | Today                  | Date          |             |
      | Q2         | How did the incident occur?               | Fell/Dropped           | Dropdown      | Q3          |
      | Q3         | Description of how the incident occurred? | Fell/Dropped           | ResponseField |             |
      | Q4         | Where did the incident occur?             | Policy Holders Address | RadioButton   | Q5          |
      | Q5         | Please confirm the plan holders address   | Policy Holders Address | ResponseField |             |
    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>"
    Then I verify the Calendar dates are available
    Then I Verify the Calendar displayed for "<ServiceProvider>"
#    Then I cancel the claim for "<PlanNo>" claim type "<ClaimType>"

    Examples:
      | PlanNo     | ClaimType                 | ServiceOption                     | ServiceProvider            | ProductType |
      | 4OH0093069 | Damage Caused by Accident | Home Visit (Normal Working Hours) | WHIRLPOOL UK APPLIANCE LTD | GAS COOKER  |

  @HC004_SIT @WIP @HC @SIT-EnvironmentHealthCheck
  Scenario Outline: HC#004 - Verify the Calendar Availability for Vokera Service Provider
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I Verify the "<PlanNo>" details displayed
    And I verify the "<PlanNo>" is in Live Status
    When I select the product "<PlanNo>" and click the claim type "<ClaimType>"
    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
    Then I enter the Model Number in Product details section for Boiler
    And I click create request button for Heating Goods
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                                                                           | Answer     | AnswerType    | SubQuestion |
      | Q1         | Please re-confirm your problem                                                                     | Water leak | RadioButton   |             |
      | Q2         | Where is the leak coming from?                                                                     | Boiler     | RadioButton   |             |
      | Q3         | Is there any health or wellbeing reason we need to be made aware of when booking this appointment? | Yes        | RadioButton   | Q4          |
      | Q4         | Is there any health or wellbeing reason we need to be made aware of when booking this appointment? | TEST       | ResponseField |             |
      | Q5         | As the engineer will have heavy tools and equipment to carry,                                      | Yes        | RadioButton   |             |
      | Q6         | Please can you confirm the fuel of your boiler?                                                    | LPG        | RadioButton   |             |
      | Q7         | Please can you confirm the location of your boiler?                                                | Test       | ResponseField |             |
      | Q8         | To protect your belongings and make it easier                                                      | Yes        | RadioButton   |             |

    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>"
    Then I verify the Calendar dates are available
    Then I Verify the Calendar displayed for "<ServiceProvider>"
#    Then I cancel the claim for "<PlanNo>" claim type "<ClaimType>"

    Examples:
      | PlanNo     | ClaimType                   | ServiceOption | ServiceProvider |
      | VB30003213 | Breakdown (Boiler & System) | Home Visit    | Vokera          |


  @HC005_SIT @WIP @HC @NA
  Scenario Outline: HC#005 - Verify the Calendar Availability for Hoover Candy Service Provider
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I Verify the "<PlanNo>" details displayed
    And I verify the "<PlanNo>" is in Live Status
    When I select the product "<PlanNo>" and click the claim type "<ClaimType>"
    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
    And I click create request button
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                  | Answer | AnswerType    | SubQuestion |
      | Q1         | When did the fault occur? | Today  | Date          |             |
      | Q2         | Tell us about the fault   | Test   | ResponseField |             |

    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>"
    Then I verify the Calendar dates are available
    Then I Verify the Calendar displayed for "<ServiceProvider>"
#    Then I cancel the claim for "<PlanNo>" claim type "<ClaimType>"

    Examples:
      | PlanNo     | ClaimType                 | ServiceOption                     | ServiceProvider |
      | VU40008131 | Damage Caused by Accident | Home Visit (Normal Working Hours) | HOOVER CANDY    |


  @NA
  Scenario Outline: HC#006 - Verify the Calendar Availability for GDHA Service Provider
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I Verify the "<PlanNo>" details displayed
    And I verify the "<PlanNo>" is in Live Status
    When I select the product "<PlanNo>" and click the claim type "<ClaimType>"
    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
    Then I enter "<ModelNumber>" on the product confirmation section
#    Then I enter the Model Number in Product details section for Boiler
    And I click create request button for Heating Goods
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                                        | Answer  | AnswerType    | SubQuestion |
      | Q1         | Is there any reason you can think of to reject this claim?      | No      | RadioButton   |             |
      | Q2         | When did your product stop working?                             | Today   | Date          |             |
      | Q3         | Please ask the customer for a detailed description of the fault | Testing | ResponseField |             |

    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>"
    Then I verify the Calendar dates are available
    Then I Verify the Calendar displayed for "<ServiceProvider>"
#    Then I cancel the claim for "<PlanNo>" claim type "<ClaimType>"

    Examples:
      | PlanNo     | ClaimType | ModelNumber | ServiceOption                     | ServiceProvider |
      | A6J0000001 | Breakdown | GAS OVEN    | Home Visit (Normal Working Hours) | GDHA            |


  @HC007_SIT
  Scenario Outline: HC#007 - Verify the Calendar Availability for Electrolux Service Provider
    Given I click create claim and I enter plan number "<PlanNo>" and click search for WrittenOff
    Then I Verify the "<PlanNo>" details displayed for WrittenOff
    When I select the product for WrittenOff "<PlanNo>" and click the claim type "<ClaimType>"
    Then I enter the Product details section "<PNC Number>" and serial number details
    And I click create request button for Goods
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                                         | Answer | AnswerType    |
      | Q1         | Is there any reason you can think of to reject this claim?       | No     | RadioButton   |
      | Q2         | When did your product stop working?                              | Today  | Date          |
      | Q3         | Please ask the customer for a detailed description of the fault. | Test   | ResponseField |
    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>"
    Then I verify the Calendar dates are available
    Then I Verify the Calendar displayed for "<ServiceProvider>"
#    Then I cancel the claim for "<PlanNo>" claim type "<ClaimType>"

    Examples:
      | PlanNo     | ClaimType | ServiceOption                     | PNC Number | ServiceProvider |
      | VU60047782 | Breakdown | Home Visit (Normal Working Hours) | 948904188  | CHEESY REPAIRS  |


  @HC008-SIT
  Scenario Outline: HC#008 - Verify the Calendar Availability for Beko Service Provider
    Then I navigate to jobupdate page for the "<ClaimNo>" for "<ServiceProvider>"
    Then I verify the Calendar dates are available
    Then I Verify the Calendar displayed for "<ServiceProvider>"

    Examples:
      | PlanNo     | ClaimNo  | ServiceProvider |
      | 6QT0259835 | 10001978 | Beko            |
#      | 6QT0259835 | 10001978   | Beko            |

  @HC009 @WIP @NA
  Scenario Outline: HC#009 - Verify the Calendar Availability for Elux Service Provider
    Then I navigate to jobupdate page for the "<ClaimNo>" for "<ServiceProvider>"
    Then I verify the Calendar dates are available
    Then I Verify the Calendar displayed for "<ServiceProvider>"

    Examples:
      | PlanNo     | ClaimNo | ServiceProvider |
      | L4A0000409 | 47549   | CHEESY REPAIRS  |


  @INFLIGHT
  Scenario Outline: Complete a Repair - Whirlpool ANW Plan
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I Verify the "<PlanNo>" details displayed
    And I verify the "<PlanNo>" is in Live Status
    When I select the product "<PlanNo>" and click the claim type "<ClaimType>"
    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
    Then I enter the Model Number in Product details section for Whirlpool
    And I click create request button
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                                         | Answer | AnswerType    | SubQuestion |
      | Q1         | Is there any reason you can think of to reject this claim?       | No     | RadioButton   |             |
      | Q2         | When did your product stop working?                              | Today  | Date          |             |
      | Q3         | Please ask the customer for a detailed description of the fault. | Test   | ResponseField |             |
    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>"
    When I change the ServiceProvider as "<ServiceProvider>"
    And I click confirm option details button
    Then I verify claim on Checkout Process Page
    Then I verify the Appointment booked successfully from the Review claim section
    Given I navigate to D&G Repairer Portal
    When I enter repairer username and password and click Login for Hoover
    Then I search for a claim using "<PlanNo>" and search for WrittenOff
    Then I confirm the Labour and charge for completing the claim
    When I navigate to D&G CC Agent Portal
    When I enter username and password and click Login
    Then I verify the Login is successful
    Then I Verify the Job Status in Orbit is RepairCompleted for the Plan "<PlanNo>" and "REPAIR COMPLETED"

    Examples:
      | PlanNo     | ClaimType | ServiceOption                     | ServiceProvider       |
      | ANW0013402 | Breakdown | Home Visit (Normal Working Hours) | FLYINGTOOLBOX RESPOND |
#      | ANW0013403 | Breakdown | Home Visit (Normal Working Hours) | FLYINGTOOLBOX RESPOND |
#      | ANW0013404 | Breakdown | Home Visit (Normal Working Hours) | FLYINGTOOLBOX RESPOND |
#      | ANW0013405 | Breakdown | Home Visit (Normal Working Hours) | FLYINGTOOLBOX RESPOND |
#      | ANW0013406 | Breakdown | Home Visit (Normal Working Hours) | FLYINGTOOLBOX RESPOND |


  @INFLIGHT2
  Scenario Outline: Complete a Repair - Hoover
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I Verify the "<PlanNo>" details displayed
    And I verify the "<PlanNo>" is in Live Status
    When I select the product "<PlanNo>" and click the claim type "<ClaimType>"
    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
    Then I enter the Model Number in Product details section for Hoover
    And I click create request button
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                                         | Answer | AnswerType    | SubQuestion |
      | Q1         | Is there any reason you can think of to reject this claim?       | No     | RadioButton   |             |
      | Q2         | When did your product stop working?                              | Today  | Date          |             |
      | Q3         | Please ask the customer for a detailed description of the fault. | Test   | ResponseField |             |
    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>"
    When I change the ServiceProvider as "<ServiceProvider>"
    And I click confirm option details button
    Then I verify claim on Checkout Process Page
    Then I verify the Appointment booked successfully from the Review claim section
    Given I navigate to D&G Repairer Portal
    When I enter repairer username and password and click Login for Hoover
    Then I search for a claim using "<PlanNo>" and search for WrittenOff
    Then I confirm the Labour and charge for completing the claim
    When I navigate to D&G CC Agent Portal
    When I enter username and password and click Login
    Then I verify the Login is successful
    Then I Verify the Job Status in Orbit is RepairCompleted for the Plan "<PlanNo>" and "REPAIR COMPLETED"

    Examples:
      | PlanNo     | ClaimType | ServiceOption                     | ServiceProvider |
      | BH20052832 | Breakdown | Home Visit (Normal Working Hours) | HOOVER CANDY    |
      | BH20052834 | Breakdown | Home Visit (Normal Working Hours) | HOOVER CANDY    |
      | BH20052835 | Breakdown | Home Visit (Normal Working Hours) | HOOVER CANDY    |
      | BH20052836 | Breakdown | Home Visit (Normal Working Hours) | HOOVER CANDY    |
      | BH20052837 | Breakdown | Home Visit (Normal Working Hours) | HOOVER CANDY    |


  @INFLIGHT3
  Scenario Outline: Repair in Progress - Hoover
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I Verify the "<PlanNo>" details displayed
    And I verify the "<PlanNo>" is in Live Status
    When I select the product "<PlanNo>" and click the claim type "<ClaimType>"
    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
    Then I enter the Model Number in Product details section for Hoover
    And I click create request button
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                                         | Answer | AnswerType    | SubQuestion |
      | Q1         | Is there any reason you can think of to reject this claim?       | No     | RadioButton   |             |
      | Q2         | When did your product stop working?                              | Today  | Date          |             |
      | Q3         | Please ask the customer for a detailed description of the fault. | Test   | ResponseField |             |
    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>"
    When I change the ServiceProvider as "<ServiceProvider>"
    And I click confirm option details button
    Then I verify claim on Checkout Process Page
    Then I verify the Appointment booked successfully from the Review claim section

    Examples:
      | PlanNo     | ClaimType | ServiceOption                     | ServiceProvider |
      | BH20052832 | Breakdown | Home Visit (Normal Working Hours) | HOOVER CANDY    |
      | BH20052834 | Breakdown | Home Visit (Normal Working Hours) | HOOVER CANDY    |
      | BH20052835 | Breakdown | Home Visit (Normal Working Hours) | HOOVER CANDY    |
      | BH20052836 | Breakdown | Home Visit (Normal Working Hours) | HOOVER CANDY    |
      | BH20052837 | Breakdown | Home Visit (Normal Working Hours) | HOOVER CANDY    |


  @INFLIGHT4-NonGold
  Scenario Outline: TC#WHP_001 - Create a Breakdown Claim for a KENWOOD Plan
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I Verify the "<PlanNo>" details displayed
    When I select the product "<PlanNo>" and click the claim type "<ClaimType>"
    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
    Then I enter the Model Number in Product details section
    And I click create request button for Goods
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                                         | Answer | AnswerType    | SubQuestion |
      | Q1         | Is there any reason you can think of to reject this claim?       | No     | RadioButton   |             |
      | Q2         | When did your product stop working?                              | Today  | Date          |             |
      | Q3         | Please ask the customer for a detailed description of the fault. | Test   | ResponseField |             |
    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>" and enter the additional information
#    Then I select the different ServiceProvider as "<ServiceProvider>"
    And I click confirm option details button
    Then I verify claim on Checkout Process Page
    Then I verify the Appointment booked successfully from the Review claim section
#    Given I navigate to D&G Repairer Portal
#    When I enter repairer username and password and click Login for FTB
#    Then I search for a claim using "<PlanNo>" and search for WrittenOff
#    Then I confirm the Labour and charge for completing the claim
#    When I navigate to D&G CC Agent Portal
#    When I enter username and password and click Login
#    Then I verify the Login is successful
#    Then I Verify the Job Status in Orbit is RepairCompleted for the Plan "<PlanNo>" and "REPAIR COMPLETED"

    Examples:
      | PlanNo     | ClaimType | ServiceOption                     | ServiceProvider       |
      | ANW0013542 | Breakdown | Home Visit (Normal Working Hours) | FLYINGTOOLBOX RESPOND |