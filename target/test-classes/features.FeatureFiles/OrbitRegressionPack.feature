##====================================================
## ORBIT REGRESSION PACK
##====================================================
Feature: Automation Pack for Orbit Regression Pack

  Background: User to Login
    Given I navigate to D&G CC Agent Portal
    When I enter username and password and click Login
    Then I verify the Login is successful

  @UATNPV @SC01 @Completed @MNR @OrbitRegression @UAT @UAT_S1
  Scenario Outline: TC#01 - Create a Claim with Service Option Manual Referral (Manually Sign)
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    And I verify the "<PlanNo>" is in Live Status
    When I select the product "<PlanNo>" and click the claim type "<ClaimType>"
    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
    And I click create request button
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                                         | Answer | AnswerType    |
      | Q1         | Is there any reason you can think of to reject this claim?       | No     | RadioButton   |
      | Q2         | When did your product stop working?                              | Today  | Date          |
      | Q3         | Please ask the customer for a detailed description of the fault. | Test   | ResponseField |
    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>" and enter the additional information
    And I select the Available Appointment if exist and confirm appointment
    Then I verify claim on Checkout Process Page
    Examples:
      | PlanNo     | ClaimType | ServiceOption   |
      | MNR0000001 | Breakdown | Manual Referral |

  @SC02
    @SC08 @Completed @JIFFYBAG @OrbitRegression @UAT @UAT_S1
  Scenario Outline: TC#02, TC#08 - Create a Claim with Service Option JIFFY BAG
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I Verify the "<PlanNo>" details displayed
    And I verify the "<PlanNo>" is in Live Status
    When I select the product "<PlanNo>" and click the claim type "<ClaimType>"
    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
    And I click create request button
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                       | Answer           | AnswerType  | MultipleAnswer |
      | Q1         | When did the breakdown occur?                  | Today            | Date        |                |
      | Q2         | What is the problem being experienced?         | Microphone Fault | Dropdown    |                |
      | Q3         | Do you wish to report any additional problems? | No               | RadioButton |                |

    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>" and enter the additional information
    And I select the Available Appointment if exist and confirm appointment
    Then I verify claim on Checkout Process Page
    Examples:
      | PlanNo     | ClaimType | FaultCode | ProblemCode | ModelNumber | ServiceOption                     |
      | 6SZ0021701 | Breakdown | LVB004010 | 2542        | WWDC9440    | Send by Post - Jiffy Bag Required |


  @SC03
    @SC12
    @SC23
    @SC24
    @Completed
    @OrbitRegression
    @UAT @UAT_S1 @UATRERUN
  Scenario Outline: TC#03,TC#12,TC#23 & TC#24 - Create a Claim with Service Option Home Visit or Annual Service
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I Verify the "<PlanNo>" details displayed
    And I verify the "<PlanNo>" is in Live Status
    When I select the product "<PlanNo>" and click the claim type "<ClaimType>"
    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
    Then I enter "<ModelNumber>" on the product confirmation section
#    Then I verify the claim type selected and Confirm Product section displayed
#    When I enter Model number "<ModelNumber>" fault code "<FaultCode>" and problem code "<ProblemCode>"
    And I click create request button
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                        | Answer         | AnswerType  |
      | Q1         | Please confirm the type of appointment required | Annual Service | RadioButton |
    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>" and enter the additional information
    Then I verify the Calendar dates are available
    And I select the Available Appointment if exist and confirm appointment
    Then I verify claim on Checkout Process Page
    Then I verify the Appointment booked successfully from the Review claim section
    Examples:
      | PlanNo     | ClaimType      | ModelNumber | ServiceOption | OptionalScenarioText                                           |
      | VJC0080431 | Annual Service | Chaffoteaux | Home Visit    |                                                                |
      | VJC0080431 | Annual Service | Chaffoteaux | Home Visit    | Cancel a Claim / Create a claim with already attached to claim |


  @SC04 @WIP @Test @OrbitRegression @UAT @UAT_S1
  Scenario Outline: TC#04 - Create a Claim with "Excess Pay" Option [Check SP CS date]
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I Verify the "<PlanNo>" details displayed
    And I verify the "<PlanNo>" is in Live Status
    When I select the product "<PlanNo>" and click the claim type "<ClaimType>"
    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
    Then I enter "<ModelNumber>" on the product confirmation section
    And I click create request button for Heating Goods
    And I click process excess payment
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                                                                           | Answer                    | AnswerType  |
      | Q1         | Are you reporting a gas leak, can smell gas or suspect carbon monoxide is present?                 | No                        | RadioButton |
      | Q2         | What is the problem being experienced?                                                             | Uncontrollable Water Leak | RadioButton |
      | Q3         | Where is the location of the uncontrollable leak?                                                  | Heating Boiler            | RadioButton |
      | Q4         | When did the problem occur?                                                                        | Today                     | Date        |
      | Q5         | Is there any additional detail you can provide relating to the problem being experienced?          | No                        | RadioButton |
      | Q6         | Is there any health or wellbeing reason we need to be made aware of when booking this appointment? | No                        | RadioButton |
    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    Then I click process the Excess Payment
    When I confirm the service option as "<ServiceOption>" and confirm
    Then I process the Excess Payment verify the Excess Amount is Paid
    Examples:
      | PlanNo     | ClaimType | ModelNumber | ServiceOption                     |
      | VJC0080650 | Breakdown | Chaffoteaux | Home Visit (Normal Working Hours) |

  @SC05 @WIP @Test @OrbitRegression @UAT
  Scenario Outline: TC#05 - Create a Claim with "Waive Excess" Option
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I Verify the "<PlanNo>" details displayed
    And I verify the "<PlanNo>" is in Live Status
    When I select the product "<PlanNo>" and click the claim type "<ClaimType>"
    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
    Then I enter "<ModelNumber>" on the product confirmation section
    And I click create request button for Heating Goods
    And I waive off the Excess Pay
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                                                                           | Answer                    | AnswerType  |
      | Q1         | Are you reporting a gas leak, can smell gas or suspect carbon monoxide is present?                 | No                        | RadioButton |
      | Q2         | What is the problem being experienced?                                                             | Uncontrollable Water Leak | RadioButton |
      | Q3         | Where is the location of the uncontrollable leak?                                                  | Heating Boiler            | RadioButton |
      | Q4         | When did the problem occur?                                                                        | Today                     | Date        |
      | Q5         | Is there any additional detail you can provide relating to the problem being experienced?          | No                        | RadioButton |
      | Q6         | Is there any health or wellbeing reason we need to be made aware of when booking this appointment? | No                        | RadioButton |
    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    Then I verify the Excess Amount Waived off
    Examples:
      | PlanNo     | ClaimType | ModelNumber |  |
      | VJC0080650 | Breakdown | Chaffoteaux |  |


  @SC06 @SC28 @WIP @Test @OrbitRegression @UAT
  Scenario Outline: TC#06 & TC#28 - Create a Claim with Appliance Type TV & Check "TV size" option is displayed for selection
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I Verify the "<PlanNo>" details displayed
    And I verify the "<PlanNo>" is in Live Status
    When I select the product "<PlanNo>" and click the claim type "<ClaimType>"
    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
    Then I enter "<ModelNumber>" on the product confirmation section for Television
    And I click create request button for Goods
    And I click process excess payment
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                                         | Answer | AnswerType    |
      | Q1         | Is there any reason you can think of to reject this claim?       | No     | RadioButton   |
      | Q2         | When did your product stop working?                              | Today  | Date          |
      | Q3         | Please ask the customer for a detailed description of the fault. | Test   | ResponseField |
    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>" and enter the additional information
    Then I verify the Calendar dates are available
    And I select the Available Appointment if exist and confirm appointment
    Then I verify claim on Checkout Process Page
    Then I verify the Appointment booked successfully from the Review claim section
    Then I verify the CustomerCommunications messages are generated
    Examples:
      | PlanNo     | ClaimType | ModelNumber | ServiceOption                     |
      | T3G0002826 | Breakdown | Television  | Home Visit (Normal Working Hours) |


  @SC07 @SC09 @WIP @Test @OrbitRegression @UAT
  Scenario Outline: TC#07 & TC#09 - Create a Claim with Appliance Type Cooker/Hob & Check "Fuel Type" option is displayed for selection - Accidental Damage
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I Verify the "<PlanNo>" details displayed
    And I verify the "<PlanNo>" is in Live Status
    When I select the product "<PlanNo>" and click the claim type "<ClaimType>"
    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
    Then I enter "<ModelNumber>" on the product confirmation section
    Then I enter the Product details section "<PNC Number>" and serial number details
    And I click create request button for Goods
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                                                                 | Answer                  | AnswerType    |
      | Q1         | Please select whether your appliance installation type is free standing or built in      | Freestanding/Standalone | RadioButton   |
      | Q2         | When did the damage to your product occur?                                               | Today                   | Date          |
      | Q3         | What caused the damage?                                                                  | Accidentally hit        | RadioButton   |
      | Q4         | Please describe the fault                                                                | Accidentally hit        | ResponseField |
      | Q5         | Is there any detail the engineer should be aware of prior to or on the appointment date? | Accidentally hit        | ResponseField |
    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>" and enter the additional information
    Then I verify the Calendar dates are available
    And I select the Available Appointment if exist and confirm appointment
    Then I verify claim on Checkout Process Page
    Then I verify the Appointment booked successfully from the Review claim section

    Examples:
      | PlanNo     | ClaimType                 | ModelNumber     | ServiceOption                     | PNC Number |
      | A4D0080208 | Damage Caused by Accident | ELECTRIC COOKER | Home Visit (Normal Working Hours) | 948904188  |

  @SC10 @WIP @Test @OrbitRegression @UAT
  Scenario Outline: TC#10 - Create a Claim with Claim Type Loss (LT Claim) / Instant PR option
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I Verify the "<PlanNo>" details displayed
    And I verify the "<PlanNo>" is in Live Status
    When I select the product "<PlanNo>" and click the claim type "<ClaimType>"
    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
#    Then I enter "<ModelNumber>" on the product confirmation section
#    Then I enter the Product details section "<PNC Number>" and serial number details
    And I click create request button for Goods
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                                                                                                             | Answer                                | AnswerType    | SubQuestion |
      | Q1         | Have you contacted your network to disable your device using the IMEI?                                                               | Yes                                   | RadioButton   |             |
      | Q2         | If this is a Sky Mobile contract, is the device showing as blocked in STAN?                                                          | Sky Mobile contract - Blocked in STAN | RadioButton   |             |
      | Q3         | When was your phone lost?                                                                                                            | Today                                 | Date          |             |
      | Q4         | Have you checked any tracking devices you have enabled on your phone?                                                                | Yes                                   | RadioButton   |             |
      | Q5         | Was the phone lost in the UK?                                                                                                        | Yes                                   | RadioButton   |             |
      | Q6         | Please give an account of how you lost your phone                                                                                    | Sky Mobile contract - Blocked         | ResponseField |             |
      | Q7         | Did you lose your phone as a result of giving it to a third party to provide a service for you or as a result of selling your phone? | No                                    | RadioButton   |             |
      | Q8         | Were you with your phone at the time?                                                                                                | Yes                                   | RadioButton   |             |
      | Q9         | ** Please confirm contract type **                                                                                                   | Sky Contract Phone                    | RadioButton   | Q10         |
      | Q10        | Please can you confirm the information you have provided is true and to the best of your knowledge?                                  | Yes                                   | Declaration   |             |

    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>" and enter the additional information
#    Then I verify the Calendar dates are available
    And I select the Available Appointment if exist and confirm appointment
    Then I verify claim on Checkout Process Page
    Then I verify the Appointment booked successfully from the Review claim section

    Examples:
      | PlanNo     | ClaimType | ServiceOption       |
      | 6SZ0021699 | Loss      | Instant PR (Direct) |


  @SC11 @WIP @Test @OrbitRegression @UAT
  Scenario Outline: TC#11 - Create a Claim with Claim Type Theft (LT Claim) / Instant PR option
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I Verify the "<PlanNo>" details displayed
    And I verify the "<PlanNo>" is in Live Status
    When I select the product "<PlanNo>" and click the claim type "<ClaimType>"
    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
#    Then I enter "<ModelNumber>" on the product confirmation section
#    Then I enter the Product details section "<PNC Number>" and serial number details
    And I click create request button for Goods
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                                                                                                             | Answer                                | AnswerType    | SubQuestion |
      | Q1         | Have you contacted your network to disable your device using the IMEI?                                                               | Yes                                   | RadioButton   |             |
      | Q2         | If this is a Sky Mobile contract, is the device showing as blocked in STAN?                                                          | Sky Mobile contract - Blocked in STAN | RadioButton   |             |
      | Q3         | When was the phone stolen?                                                                                                           | Today                                 | Date          |             |
      | Q4         | Was the phone stolen in the UK?                                                                                                      | Yes                                   | RadioButton   |             |
      | Q5         | Do you have a crime reference?                                                                                                       | Yes                                   | RadioButton   |             |
      | Q6         | Please give an account of how the incident occurred                                                                                  | Sky Mobile contract - Blocked         | ResponseField |             |
      | Q7         | Where was the phone stolen?                                                                                                          | Outside your home or vehicle          | RadioButton   |             |
      | Q8         | Did you lose your phone as a result of giving it to a third party to provide a service for you or as a result of selling your phone? | No                                    | RadioButton   |             |
      | Q9         | Were you with your phone at the time?                                                                                                | Yes                                   | RadioButton   |             |
      | Q10        | ** Please confirm contract type **                                                                                                   | Sky Contract Phone                    | RadioButton   | Q10         |
      | Q11        | Please can you confirm the information you have provided is true and to the best of your knowledge?                                  | Yes                                   | Declaration   |             |

    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>" and enter the additional information
#    Then I verify the Calendar dates are available
    And I select the Available Appointment if exist and confirm appointment
    Then I verify claim on Checkout Process Page
    Then I verify the Appointment booked successfully from the Review claim section

    Examples:
      | PlanNo     | ClaimType | ServiceOption       |
      | 6SZ0021699 | Theft     | Instant PR (Direct) |

  @SC13 @WIP @Test @OrbitRegression @UAT
  Scenario Outline: TC#13 - Create a Claim with Master Policy (Master Plan#)
    Given I click create claim and I enter plan number "<MasterPlanNo>" and click search
    Then I Verify the "<PlanNo>" details displayed
    And I verify the "<PlanNo>" is in Live Status for MasterPlan
    When I select the product "<PlanNo>" and click the claim type "<ClaimType>"
    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
#    Then I enter "<ModelNumber>" on the product confirmation section
#    Then I enter the Product details section "<PNC Number>" and serial number details
    And I click create request button for Goods
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                                                                                                             | Answer                                | AnswerType    | SubQuestion |
      | Q1         | Have you contacted your network to disable your device using the IMEI?                                                               | Yes                                   | RadioButton   |             |
      | Q2         | If this is a Sky Mobile contract, is the device showing as blocked in STAN?                                                          | Sky Mobile contract - Blocked in STAN | RadioButton   |             |
      | Q3         | When was the phone stolen?                                                                                                           | Today                                 | Date          |             |
      | Q4         | Was the phone stolen in the UK?                                                                                                      | Yes                                   | RadioButton   |             |
      | Q5         | Do you have a crime reference?                                                                                                       | Yes                                   | RadioButton   |             |
      | Q6         | Please give an account of how the incident occurred                                                                                  | Sky Mobile contract - Blocked         | ResponseField |             |
      | Q7         | Where was the phone stolen?                                                                                                          | Outside your home or vehicle          | RadioButton   |             |
      | Q8         | Did you lose your phone as a result of giving it to a third party to provide a service for you or as a result of selling your phone? | No                                    | RadioButton   |             |
      | Q9         | Were you with your phone at the time?                                                                                                | Yes                                   | RadioButton   |             |
      | Q10        | ** Please confirm contract type **                                                                                                   | Sky Contract Phone                    | RadioButton   | Q10         |
      | Q11        | Please can you confirm the information you have provided is true and to the best of your knowledge?                                  | Yes                                   | Declaration   |             |

    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>" and enter the additional information
#    Then I verify the Calendar dates are available
    And I select the Available Appointment if exist and confirm appointment
    Then I verify claim on Checkout Process Page
    Then I verify the Appointment booked successfully from the Review claim section

    Examples:
      | PlanNo     | ClaimType | ServiceOption       | MasterPlanNo |
      | 6SZ0021699 | Theft     | Instant PR (Direct) | 6SV0019819   |


  @SC14 @SC15 @WIP @Test @OrbitRegression @UAT
  Scenario Outline: TC#14 & TC#15- Create a Claim with Baby Policy (Baby Plan#)
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I Verify the "<PlanNo>" details displayed
    And I verify the "<PlanNo>" is in Live Status
    When I select the product "<PlanNo>" and click the claim type "<ClaimType>"
    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
    And I click create request button for Goods
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                                                                                                             | Answer                                | AnswerType    | SubQuestion |
      | Q1         | Have you contacted your network to disable your device using the IMEI?                                                               | Yes                                   | RadioButton   |             |
      | Q2         | If this is a Sky Mobile contract, is the device showing as blocked in STAN?                                                          | Sky Mobile contract - Blocked in STAN | RadioButton   |             |
      | Q3         | When was the phone stolen?                                                                                                           | Today                                 | Date          |             |
      | Q4         | Was the phone stolen in the UK?                                                                                                      | Yes                                   | RadioButton   |             |
      | Q5         | Do you have a crime reference?                                                                                                       | Yes                                   | RadioButton   |             |
      | Q6         | Please give an account of how the incident occurred                                                                                  | Sky Mobile contract - Blocked         | ResponseField |             |
      | Q7         | Where was the phone stolen?                                                                                                          | Outside your home or vehicle          | RadioButton   |             |
      | Q8         | Did you lose your phone as a result of giving it to a third party to provide a service for you or as a result of selling your phone? | No                                    | RadioButton   |             |
      | Q9         | Were you with your phone at the time?                                                                                                | Yes                                   | RadioButton   |             |
      | Q10        | ** Please confirm contract type **                                                                                                   | Sky Contract Phone                    | RadioButton   | Q10         |
      | Q11        | Please can you confirm the information you have provided is true and to the best of your knowledge?                                  | Yes                                   | Declaration   |             |

    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>" and enter the additional information
#    Then I verify the Calendar dates are available
    And I select the Available Appointment if exist and confirm appointment
    Then I verify claim on Checkout Process Page
    Then I verify the Appointment booked successfully from the Review claim section

    Examples:
      | PlanNo     | ClaimType | ServiceOption       |
      | 6SZ0021699 | Theft     | Instant PR (Direct) |

  @SC016 @WIP @OrbitRegression @UAT
  Scenario Outline: TC#16 - Cannot Create a Claim with Policy Status Cancelled (Cancelled Plan#)
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I Verify the "<PlanNo>" details displayed
    And I verify the "<PlanNo>" is "<Claim Status>"
    When I select the product "<PlanNo>" and verify the claim status as "<Claim Status>"
    Examples:
      | PlanNo     | Claim Status |
      | 2VX0086677 | CANCELLED    |

  @SC017 @WIP @OrbitRegression @UAT
  Scenario Outline:TC#17 - Cannot Create a Claim with Policy Status Lapsed (Lapsed Plan#)
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I Verify the "<PlanNo>" details displayed
    And I verify the "<PlanNo>" is "<Claim Status>"
    When I select the product "<PlanNo>" and verify the claim status as "<Claim Status>"
    Examples:
      | PlanNo     | Claim Status |
      | NKS0066884 | LAPSED       |

  @SC18 @WIP @Test @OrbitRegression @UAT
  Scenario Outline: TC#18 - Create a CAT1 Claim with Customer Vulnerability for Scottish Power Manufacturer
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I Verify the "<PlanNo>" details displayed
    And I verify the "<PlanNo>" is in Live Status
    When I select the product "<PlanNo>" and click the claim type "<ClaimType>"
    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
    Then I enter "<ModelNumber>" on the product confirmation section
    And I click create request button for Heating Goods
    And I waive off the Excess Pay
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                                                                           | Answer                    | AnswerType  |
      | Q1         | Are you reporting a gas leak, can smell gas or suspect carbon monoxide is present?                 | No                        | RadioButton |
      | Q2         | What is the problem being experienced?                                                             | Uncontrollable Water Leak | RadioButton |
      | Q3         | Where is the location of the uncontrollable leak?                                                  | Heating Boiler            | RadioButton |
      | Q4         | When did the problem occur?                                                                        | Today                     | Date        |
      | Q5         | Is there any additional detail you can provide relating to the problem being experienced?          | No                        | RadioButton |
      | Q6         | Is there any health or wellbeing reason we need to be made aware of when booking this appointment? | No                        | RadioButton |
    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>" and enter the additional information
#    Then I verify the Calendar dates are available
    And I Book without an Appointment and confirm appointment
    Then I verify claim on Checkout Process Page
    Then I verify the Appointment booked successfully from the Review claim section
    Examples:
      | PlanNo     | ClaimType | ModelNumber | ServiceOption | Status      |
      | VJC0080650 | Breakdown | Chaffoteaux | Category 1    | Parts Delay |

  @SC37 @WIP @Test @OrbitRegression @UAT @UATRERUN
  Scenario Outline: TC#37 - Confirm that closing a CRUD Diary Appointment for "Part delayed","Card left", "Customer Request","Call out visit completed"
    Given I navigate to D&G Repairer Portal
    When I enter repairer username and password and click Login
    Then I search for a claim using "<PlanNo>" and search
    Then I complete the DiaryAppointment with outcome as "<Status>"
#    Then I Verify the Job Completed Status in RP is Successful for "<Status>"
    Then I Verify the Job Completed Status in Diary Appiontment Section in RP is Successful for "<Status>"
    When I navigate to D&G CC Agent Portal
    When I enter username and password and click Login
    Then I verify the Login is successful
    Then I Verify the Job Completed Status in Orbit is Successful for the Plan "<PlanNo>" and "<Status>"
    Examples:
      | PlanNo     | Status                                 |
      | VJC0080650 | Parts Delay                            |
      | VJC0080650 | Customer Request                       |
      | VJC0080650 | Out Card Left - Customer not available |
      | VJC0080650 | Out Card Left - Engineer Delayed       |
#      | VJC0080650 | Callout / Visit Complete               |


  @SC41-49 @WIP @UAT @UATRERUN
  Scenario Outline: TC#41-to-49 - Complete the Repair and Verify the Statuses of the Claim
    Given I click create claim and I enter plan number "<PlanNo>" and click search for WrittenOff
    Then I Verify the "<PlanNo>" details displayed for WrittenOff
    When I select the product for WrittenOff "<PlanNo>" and click the claim type "<ClaimType>"
    Then I enter the Product details section "<PNC Number>" and serial number details
    And I click create request button for Goods
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                                                                 | Answer              | AnswerType    |
      | Q1         | Please select whether your appliance installation type is free standing or built in      | Built-in/Integrated | RadioButton   |
      | Q2         | Please describe the fault                                                                | Test                | ResponseField |
      | Q3         | Is there any detail the engineer should be aware of prior to or on the appointment date? | Test                | ResponseField |
    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>" and enter the additional information
    And I Book without an Appointment and confirm appointment
    Then I verify claim on Checkout Process Page
    Then I verify the Appointment booked successfully from the Review claim section
    Given I navigate to D&G Repairer Portal
    When I enter repairer username and password and click Login
    Then I search for a claim using "<PlanNo>" and search for WrittenOff
    Then I complete the DiaryAppointment with outcome as "<Status>"
    Then I confirm the Labour and charge for completing the claim with status as "<Status>"
    When I navigate to D&G CC Agent Portal
    When I enter username and password and click Login
    Then I verify the Login is successful
    Then I Verify the Job Status in Orbit is RepairCompleted for the Plan "<PlanNo>" and "REPAIR COMPLETED"
    Then I verify the Status Changes are logged in ORB when Status Changes in RP
    Then I verify the new status's are logged in ORB under Request Authorisation, when changes are made to RP
    Then I Confirm that system notes display correctly and user can add a note in ORB
    Then I Confirm that fault code is updated in ORB when updated in RP
    Then I Confirm that workflow status is updated in ORB when updated in RP
    Then I verify and confirm that einvoice cost matches Claim Analysis section
    Then I Confirm that Job Completion status is updated in ORB when updated in RP
    Then I Confirm user is able to Run and generate a claim report
#    Then I Verify the Job Completed Status in Orbit is Successful for the Plan "<PlanNo>" and "<WrittenOffStatus>" for writtenoff
    Examples:
      | PlanNo | ClaimType | ServiceOption                     | Status                   | PNC Number |
      | CRT    | Breakdown | Home Visit (Normal Working Hours) | Callout / Visit Complete | 948904188  |


  @SC20 @WIP @Test @OrbitRegression @UAT @UATRERUN
  Scenario Outline: TC#20 - Create a Claim with Claim outcome as Claim Rejected
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I Verify the "<PlanNo>" details displayed
    And I verify the "<PlanNo>" is in Live Status
    When I select the product "<PlanNo>" and click the claim type "<ClaimType>"
    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
    Then I enter the Product details section for any Model or "<ModelNumber>" and serial number details
    And I click create request button for Goods
    When I enter the QA section with below
      | QuestionNo | Question                       | Answer                                    | AnswerType |
      | Q1         | Please re-confirm your problem | Gas leak, carbon monoxide, smell or fumes | Multi      |
    Then I verify claim is in Rejected status
    Examples:
      | PlanNo     | ClaimType | ModelNumber     |
      | 3UL0001146 | Breakdown | Gold Gas Boiler |

  @SC29 @WIP @Test @OrbitRegression @UAT
  Scenario Outline: TC#29 - Test that good within the manufacturer's warranty is prompted with a message - Breakdown
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I Verify the "<PlanNo>" details displayed
    And I verify the "<PlanNo>" is in Live Status
    When I select the product "<PlanNo>" and click the claim type "<ClaimType>" in warranty period
    Then I verify the Plan is in warranty period
    Examples:
      | PlanNo     | ClaimType | ModelNumber | ServiceOption                     |
      | V4X0008240 | Breakdown | Television  | Home Visit (Normal Working Hours) |

  @SC23 @WIP @Test @OrbitRegression @UAT
  Scenario Outline: TC#23 - Cancel a Claim
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I Verify the "<PlanNo>" details displayed
    And I verify the "<PlanNo>" is in Live Status
    When I select the product "<PlanNo>" and click the claim type "<ClaimType>"
    Then I enter the Model Number in Product details section
    Then I click create request button
    Then I cancel the claim for "<PlanNo>" claim type "<ClaimType>"
    Examples:
      | PlanNo     | ClaimType |
      | 4MF0001830 | Breakdown |

  @SC30 @WIP @UAT
  Scenario Outline: TC#30, TC#36 - Verify Repairer Portal can set a claim to "PNLA Write-Off"
    Given I click create claim and I enter plan number "<PlanNo>" and click search for WrittenOff
    Then I Verify the "<PlanNo>" details displayed for WrittenOff
    When I select the product for WrittenOff "<PlanNo>" and click the claim type "<ClaimType>"
#    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
    Then I enter the Product details section "<PNC Number>" and serial number details
    And I click create request button for Goods
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                                                                 | Answer              | AnswerType    |
      | Q1         | Please select whether your appliance installation type is free standing or built in      | Built-in/Integrated | RadioButton   |
      | Q2         | Please describe the fault                                                                | Test                | ResponseField |
      | Q3         | Is there any detail the engineer should be aware of prior to or on the appointment date? | Test                | ResponseField |
    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>" and enter the additional information
    And I Book without an Appointment and confirm appointment
    Then I verify claim on Checkout Process Page
    Then I verify the Appointment booked successfully from the Review claim section
    Given I navigate to D&G Repairer Portal
    When I enter repairer username and password and click Login
    Then I search for a claim using "<PlanNo>" and search for WrittenOff
    Then I complete the DiaryAppointment with outcome as "<Status>"
    And I confirm the Labour and Parts section for "<WrittenOffStatus>"
    Then I Verify the Job Completed Status in RP is Successful for "<WrittenOffStatus>"
    When I navigate to D&G CC Agent Portal
    When I enter username and password and click Login
    Then I verify the Login is successful
    Then I Verify the Job Status in Orbit is writtenOff for the Plan "<PlanNo>" and "<WrittenOffStatus>"
    Examples:
      | PlanNo | ClaimType | ModelNumber | ServiceOption                     | Status       | PNC Number | WrittenOffStatus   |
      | CRT    | Breakdown | Chaffoteaux | Home Visit (Normal Working Hours) | Parts Needed | 948904188  | WRITTEN OFF - PNLA |

  @SC31 @WIP @UAT
  Scenario Outline: TC#31 - Verify Repairer Portal can set a claim to "BER Write-Off"
    Given I click create claim and I enter plan number "<PlanNo>" and click search for WrittenOff
    Then I Verify the "<PlanNo>" details displayed for WrittenOff
    When I select the product for WrittenOff "<PlanNo>" and click the claim type "<ClaimType>"
#    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
    Then I enter the Product details section "<PNC Number>" and serial number details
    And I click create request button for Goods
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                                                                 | Answer              | AnswerType    |
      | Q1         | Please select whether your appliance installation type is free standing or built in      | Built-in/Integrated | RadioButton   |
      | Q2         | Please describe the fault                                                                | Test                | ResponseField |
      | Q3         | Is there any detail the engineer should be aware of prior to or on the appointment date? | Test                | ResponseField |
    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>" and enter the additional information
    And I Book without an Appointment and confirm appointment
    Then I verify claim on Checkout Process Page
    Then I verify the Appointment booked successfully from the Review claim section
    Then I process the Claim to WrittenOff with the status as "<WrittenOffStatus>"
    Then I Verify the Job Completed Status in Orbit is Successful for the Plan "<PlanNo>" and "<WrittenOffStatus>" for writtenoff in CC Page
    Examples:
      | PlanNo | ClaimType | ModelNumber | ServiceOption                     | Status       | PNC Number | WrittenOffStatus  |
      | CRT    | Breakdown | Chaffoteaux | Home Visit (Normal Working Hours) | Parts Needed | 948904188  | WRITTEN OFF - BER |


  @SC32 @WIP @UAT
  Scenario Outline: TC#32 - Verify Repairer Portal can set a claim to "PART ETA Write-Off"
    Given I click create claim and I enter plan number "<PlanNo>" and click search for WrittenOff
    Then I Verify the "<PlanNo>" details displayed for WrittenOff
    When I select the product for WrittenOff "<PlanNo>" and click the claim type "<ClaimType>"
#    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
    Then I enter the Product details section "<PNC Number>" and serial number details
    And I click create request button for Goods
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                                                                 | Answer              | AnswerType    |
      | Q1         | Please select whether your appliance installation type is free standing or built in      | Built-in/Integrated | RadioButton   |
      | Q2         | Please describe the fault                                                                | Test                | ResponseField |
      | Q3         | Is there any detail the engineer should be aware of prior to or on the appointment date? | Test                | ResponseField |
    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>" and enter the additional information
    And I Book without an Appointment and confirm appointment
    Then I verify claim on Checkout Process Page
    Then I verify the Appointment booked successfully from the Review claim section
    Given I navigate to D&G Repairer Portal
    When I enter repairer username and password and click Login
    Then I search for a claim using "<PlanNo>" and search for WrittenOff
    Then I complete the DiaryAppointment with outcome as "<Status>"
    And I confirm the Labour and Parts section for "<WrittenOffStatus>"
    Then I Verify the Job Completed Status in RP is Successful for "<WrittenOffStatus>"
    When I navigate to D&G CC Agent Portal
    When I enter username and password and click Login
    Then I verify the Login is successful
    Then I Verify the Job Completed Status in Orbit is Successful for the Plan "<PlanNo>" and "<WrittenOffStatus>" for writtenoff
    Examples:
      | PlanNo | ClaimType | ModelNumber | ServiceOption                     | Status        | PNC Number | WrittenOffStatus       |
      | CRT    | Breakdown |             | Home Visit (Normal Working Hours) | TBC Completed | 948904188  | WRITTEN OFF - PART ETA |

  @SC33 @WIP @UAT
  Scenario Outline: TC#33 - Verify Repairer Portal can set a claim to "Unrepairable Write-Off"
    Given I click create claim and I enter plan number "<PlanNo>" and click search for WrittenOff
    Then I Verify the "<PlanNo>" details displayed for WrittenOff
    When I select the product for WrittenOff "<PlanNo>" and click the claim type "<ClaimType>"
#    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
    Then I enter the Product details section "<PNC Number>" and serial number details
    And I click create request button for Goods
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                                                                 | Answer              | AnswerType    |
      | Q1         | Please select whether your appliance installation type is free standing or built in      | Built-in/Integrated | RadioButton   |
      | Q2         | Please describe the fault                                                                | Test                | ResponseField |
      | Q3         | Is there any detail the engineer should be aware of prior to or on the appointment date? | Test                | ResponseField |
    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>" and enter the additional information
    And I Book without an Appointment and confirm appointment
    Then I verify claim on Checkout Process Page
    Then I verify the Appointment booked successfully from the Review claim section
    Given I navigate to D&G Repairer Portal
    When I enter repairer username and password and click Login
    Then I search for a claim using "<PlanNo>" and search for WrittenOff
    Then I complete the DiaryAppointment with outcome as "<Status>"
    And I confirm the Labour and Parts section for "<WrittenOffStatus>"
    Then I Verify the Job Completed Status in RP is Successful for "<WrittenOffStatus>"
    When I navigate to D&G CC Agent Portal
    When I enter username and password and click Login
    Then I verify the Login is successful
    Then I Verify the Job Completed Status in Orbit is Successful for the Plan "<PlanNo>" and "<WrittenOffStatus>" for writtenoff
    Examples:
      | PlanNo | ClaimType | ModelNumber | ServiceOption                     | Status       | PNC Number | WrittenOffStatus           |
      | CRT    | Breakdown |             | Home Visit (Normal Working Hours) | Parts Needed | 948904188  | WRITTEN OFF - UNREPAIRABLE |


  @SC34 @WIP @UAT
  Scenario Outline: TC#34 - Verify Repairer Portal can set a claim to "Write-Off PLEDGE"
    Given I click create claim and I enter plan number "<PlanNo>" and click search for WrittenOff
    Then I Verify the "<PlanNo>" details displayed for WrittenOff
    When I select the product for WrittenOff "<PlanNo>" and click the claim type "<ClaimType>"
#    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
    Then I enter the Product details section "<PNC Number>" and serial number details
    And I click create request button for Goods
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                                                                 | Answer              | AnswerType    |
      | Q1         | Please select whether your appliance installation type is free standing or built in      | Built-in/Integrated | RadioButton   |
      | Q2         | Please describe the fault                                                                | Test                | ResponseField |
      | Q3         | Is there any detail the engineer should be aware of prior to or on the appointment date? | Test                | ResponseField |
    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>" and enter the additional information
    And I Book without an Appointment and confirm appointment
    Then I verify claim on Checkout Process Page
    Then I verify the Appointment booked successfully from the Review claim section
    Then I process the Claim to WrittenOff with the status as "<WrittenOffStatus>"
    Then I Verify the Job Completed Status in Orbit is Successful for the Plan "<PlanNo>" and "<WrittenOffStatus>" for writtenoff in CC Page
    Examples:
      | PlanNo | ClaimType | ModelNumber | ServiceOption                     | Status       | PNC Number | WrittenOffStatus     |
      | CRT    | Breakdown | Chaffoteaux | Home Visit (Normal Working Hours) | Parts Needed | 948904188  | WRITTEN OFF - PLEDGE |

  @SC25 @SC26 @SC27 @WIP @UAT
  Scenario Outline: TC#25, TC#26, TC#27 - Update email address,Home Telephone, Mobile Number via Service Options updates the claim details for length of claim
    Given I click create claim and I enter plan number "<PlanNo>" and click search for WrittenOff
    Then I Verify the "<PlanNo>" details displayed for WrittenOff
    When I select the product for WrittenOff "<PlanNo>" and click the claim type "<ClaimType>"
#    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
    Then I enter the Product details section "<PNC Number>" and serial number details
    And I click create request button for Goods
    Then I verify the Claim Created
    When I enter the QA section with below
      | QuestionNo | Question                                                                                 | Answer              | AnswerType    |
      | Q1         | Please select whether your appliance installation type is free standing or built in      | Built-in/Integrated | RadioButton   |
      | Q2         | Please describe the fault                                                                | Test                | ResponseField |
      | Q3         | Is there any detail the engineer should be aware of prior to or on the appointment date? | Test                | ResponseField |
    Then I verify claim is in Accepted status
    Then I click service option and verify service optionsPage loaded
    When I confirm the service option as "<ServiceOption>" and enter the additional information with "<Email>""<HomeTel>" and "<MobileNo>"
    And I Book without an Appointment and confirm appointment
    Then I verify claim on Checkout Process Page
    Then I verify the Appointment booked successfully from the Review claim section
    Then I click service options tab in homepage
    Then I verify the email "<Email>" is updated successfully
    Then I verify the Contact no "<HomeTel>" is updated successfully
    Then I verify the mobile no "<MobileNo>" is updated successfully
    Examples:
      | PlanNo | ClaimType | ServiceOption                     | PNC Number | Email                        | HomeTel     | MobileNo    |
      | CRT    | Breakdown | Home Visit (Normal Working Hours) | 948904188  | orbit@domesticandgeneral.com | 01604000000 | 07802299909 |


#  @SC21 @SC22 @WIP @Test @OrbitRegression
#  Scenario Outline: TC#21 & TC#22 - Test BAU standard process and, put claim on"Hold", "Revoke" and  complete
#    Given I click create claim and I enter plan number "<PlanNo>" and click search for WrittenOff
#    Then I Verify the "<PlanNo>" details displayed for WrittenOff
#    When I select the product for WrittenOff "<PlanNo>" and click the claim type "<ClaimType>"
#    Then I enter the Product details section "<PNC Number>" and serial number details
#    And I click create request button for Goods
#    Then I verify the Claim Created
#    When I enter the QA section with below
#      | QuestionNo | Question                                                                                 | Answer              | AnswerType    |
#      | Q1         | Please select whether your appliance installation type is free standing or built in      | Built-in/Integrated | RadioButton   |
#      | Q2         | Please describe the fault                                                                | Test                | ResponseField |
#      | Q3         | Is there any detail the engineer should be aware of prior to or on the appointment date? | Test                | ResponseField |
#    Then I verify claim is in Accepted status
#    Then I click service option and verify service optionsPage loaded
#    When I confirm the service option as "<ServiceOption>" and enter the additional information
#    And I Book without an Appointment and put On Hold
#    Then I search for a claim using "<PlanNo>" and search for WrittenOff
#
#    Examples:
#      | PlanNo | ClaimType | ServiceOption                     | Status                   | PNC Number |
#      | CRT    | Breakdown | Home Visit (Normal Working Hours) | Callout / Visit Complete | 948904188  |


#  @SC21 @SC22 @WIP @Test @OrbitRegression
#  Scenario Outline: TC#21 & TC#22 - Test BAU standard process and, put claim on"Hold", "Revoke" and  complete
#    Given I click create claim and I enter plan number "<PlanNo>" and click search
#    Then I Verify the "<PlanNo>" details displayed
#    And I verify the "<PlanNo>" is in Live Status
#    When I select the product "<PlanNo>" and click the claim type "<ClaimType>"
#    Then I verify if has open claim and cancel the claim for "<PlanNo>" claim type "<ClaimType>"
#    Then I enter "<ModelNumber>" on the product confirmation section
#    And I click create request button for Heating Goods
#    And I waive off the Excess Pay
#    Then I verify the Claim Created
#    When I enter the QA section with below
#      | QuestionNo | Question                                                                                           | Answer                    | AnswerType  |
#      | Q1         | Are you reporting a gas leak, can smell gas or suspect carbon monoxide is present?                 | No                        | RadioButton |
#      | Q2         | What is the problem being experienced?                                                             | Uncontrollable Water Leak | RadioButton |
#      | Q3         | Where is the location of the uncontrollable leak?                                                  | Heating Boiler            | RadioButton |
#      | Q4         | When did the problem occur?                                                                        | Today                     | Date        |
#      | Q5         | Is there any additional detail you can provide relating to the problem being experienced?          | No                        | RadioButton |
#      | Q6         | Is there any health or wellbeing reason we need to be made aware of when booking this appointment? | No                        | RadioButton |
#    Then I verify claim is in Accepted status
#    Then I click service option and verify service optionsPage loaded
#    When I confirm the service option as "<ServiceOption>" and enter the additional information
#    Then I verify the Calendar dates are available
#    And I select the Available Appointment if exist and confirm appointment
#    Then I verify claim on Checkout Process Page
#    Then I verify the Appointment booked successfully from the Review claim section
#    Examples:
#      | PlanNo     | ClaimType | ModelNumber | ServiceOption |
#      | VJC0080650 | Breakdown | Chaffoteaux | Category 1    |
