##====================================================
## ORBIT REGRESSION PACK - NEW PLAN VIEW
##====================================================
Feature: Orbit Automation Regression Pack - New Plan View

  Background: User to Login
    Given I navigate to D&G CC Agent Portal
    When I enter username and password and click Login for New Plan View
    Then I verify the Login is successful

  @NPV_001 @UATNPV
  Scenario Outline: TC#NPV1 - Create a Claim with Service Option Manual Referral (Manually Sign)
    Given I click create claim and I enter plan number "<PlanNo>" to search for Plan View
    When I select the Claim Type as "Breakdown"
    And I enter the contact info
#    When I click continue with product confirmation
    When I enter the QA section with below
      | QuestionNo | Question                                                         | Answer | AnswerType    |
      | Q1         | Is there any reason you can think of to reject this claim?       | No     | RadioButton   |
      | Q2         | When did your product stop working?                              | Today  | Date          |
      | Q3         | Please ask the customer for a detailed description of the fault. | Test   | ResponseField |
    Then I confirm the service option as "<ServiceOption>" for New Plan View
    And I enter the additional information for Service Option Message
#    And I Book without an Appointment and confirm appointment for "<ServiceProvider>" in New Plan View
    Examples:
      | PlanNo     | ClaimType | ServiceOption   |
      | MNR0000001 | Breakdown | Manual Referral |

  @NPV_002 @UATNPV
  Scenario Outline: TC#NPV2 - Confirm Claim Booking with out an Appointment - Waive Excess
    Given I click create claim and I enter plan number "<PlanNo>" to search for Plan View
    Then I verify the new plan view page displayed
    When I select the Claim Type as "Breakdown"
    And I waive off the Excess Pay for New Plan View
    And I enter the contact info
    When I enter the PNC Details and fault data and click continue
    When I enter the QA section with below
      | QuestionNo | Question                                                         | Answer | AnswerType    |
      | Q1         | Is there any reason you can think of to reject this claim?       | No     | RadioButton   |
      | Q2         | When did your product stop working?                              | Today  | Date          |
      | Q3         | Please ask the customer for a detailed description of the fault. | Test   | ResponseField |
#    Then I verify the claim is accepted on the plan view page
    Then I confirm the service option as "<ServiceOption>" for New Plan View
    And I enter the additional information for Service Option Message
    And I Book without an Appointment and confirm appointment for "<ServiceProvider>" in New Plan View
    Then I verify the Booking Confirmed Page is displayed for "<ClaimType>" and "<ServiceProvider>"
    Examples:
      | PlanNo          | ClaimType | ServiceOption                     | Status                           | PNC Number | ServiceProvider       |
      | CREATE_NEW_PLAN | Breakdown | Home Visit (Normal Working Hours) | Out Card Left - Engineer Delayed | 948904188  | FLYINGTOOLBOX RESPOND |

#  @NPV_003 @UATNPV
#  Scenario Outline: TC#003 - Mobile Journey with Baby plan and Jiffy Bag option
#    Given I setup the hook for Recipero "<ClaimType>" "<Make>" and "<Model>"
#    When I click create claim and I enter plan number "<PlanNo>" to search for Plan View
#    Then I verify the new plan view page displayed
#    When I select the Claim Type as "<ClaimType>"
#    And I waive off the Excess Pay for New Plan View
#    And I enter the contact info
#    When I perform the product confirmation section for Mobile for NPV
#    When I enter the NPV QA section with below
#      | QuestionNo | Question                                            | Answer                           | AnswerType    | SubQuestion |
#      | Q3         | Please select date of incident                      | Today                            | Date          |             |
#      | Q10        | Is the device lost or stolen?                       | Lost                             | RadioButton   |             |
#      | Q11        | Was a 3rd party involved?                           | No                               | RadioButton   |             |
#      | Q12        | Was the device in the customers possession?         | Yes                              | RadioButton   |             |
#      | Q13        | Are you claiming for your mobile phone only?        | Yes                              | RadioButton   |             |
#      | Q14        | Are there any other details which would be helpful? | Loss Claim for the Recipero Test | ResponseField |             |
#      | Q15        | Declaration                                         | Yes                              | RadioButton   |             |
#    And I revert the Recipero hook to the live URL
#    Then I confirm the service option as "<ServiceOption>" for New Plan View
#    And I enter the additional information for all Service Option Message
#    And I confirm appointment booking for "<ServiceProvider>" in New Plan View for Mobile
#    Then I verify the Booking Confirmed Page is displayed for "<ClaimType>" and "<ServiceProvider>"
#    And I navigate to Claim Page on New Plan View
#    When I verify the recipero page displyed
#    Examples:
#      | PlanNo     | ClaimType | ServiceOption | Make   | Model   | ServiceProvider |
#      | DBS0011553 | Loss      | Jiffy Bag     | Huawei | P30 PRO | SBE             |

  @NPV_004  @NPV_003 @UATNPV
  Scenario Outline: TC#NPV4 : Mobile Journey with Baby plan and Jiffy Bag - Collect Excess payment
    Given I setup the hook for Recipero "<ClaimType>" "<Make>" and "<Model>"
    When I click create claim and I enter plan number "<PlanNo>" to search for Plan View
    Then I verify the new plan view page displayed
    When I select the Claim Type as "<ClaimType>"
    And I continue for Excess Pay for New Plan View
    And I enter the contact info
    When I perform the product confirmation section for Mobile for NPV
    When I enter the NPV QA section with below
      | QuestionNo | Question                                            | Answer                           | AnswerType    | SubQuestion |
      | Q3         | Please select date of incident                      | Today                            | Date          |             |
      | Q10        | Is the device lost or stolen?                       | Lost                             | RadioButton   |             |
      | Q11        | Was a 3rd party involved?                           | No                               | RadioButton   |             |
      | Q12        | Was the device in the customers possession?         | Yes                              | RadioButton   |             |
      | Q13        | Are you claiming for your mobile phone only?        | Yes                              | RadioButton   |             |
      | Q14        | Are there any other details which would be helpful? | Loss Claim for the Recipero Test | ResponseField |             |
      | Q15        | Declaration                                         | Yes                              | RadioButton   |             |
    And I revert the Recipero hook to the live URL
    Then I confirm the ExcessPayment for New Plan View
    When I confirm the service option as "<ServiceOption>" for New Plan View with Excess
    Then I process the Excess Payment verify the Excess Amount is Paid for NPV
    And I enter the additional information for all Service Option Message
    And I confirm appointment booking for "<ServiceProvider>" in New Plan View for Mobile
    Then I verify the Booking Confirmed Page is displayed for "<ClaimType>" and "<ServiceProvider>"
    And I navigate to Claim Page on New Plan View
    When I verify the recipero page displyed
    Examples:
      | PlanNo     | ClaimType | ServiceOption | Make   | Model   | ServiceProvider |
      | DBS0004127 | Loss      | Jiffy Bag     | Huawei | P30 PRO | SBE             |


  @NPV_039 @UATNPV
  Scenario Outline: TC#39 & TC#28 - Create a Claim with Appliance Type TV & Check "TV size" option is displayed for selection
    Given I click create claim and I enter plan number "<PlanNo>" to search for Plan View
    Then I verify the new plan view page displayed
    When I select the Claim Type as "<ClaimType>"
    And I enter the contact info
    Then I enter "<ModelNumber>" on the product confirmation section for Television for NPV
    When I enter the QA section with below
      | QuestionNo | Question                                                         | Answer | AnswerType    |
      | Q1         | Is there any reason you can think of to reject this claim?       | No     | RadioButton   |
      | Q2         | When did your product stop working?                              | Today  | Date          |
      | Q3         | Please ask the customer for a detailed description of the fault. | Test   | ResponseField |
    Then I confirm the service option as "<ServiceOption>" for New Plan View
    And I enter the additional information for Service Option Message
    And I Book without an Appointment and confirm appointment for "<ServiceProvider>" in New Plan View
    Then I verify the Booking Confirmed Page is displayed for "<ClaimType>" and "<ServiceProvider>"

    Examples:
      | PlanNo     | ClaimType | ModelNumber | ServiceOption                     | ServiceProvider       |
      | T3G0009960 | Breakdown | Television  | Home Visit (Normal Working Hours) | FLYINGTOOLBOX RESPOND |


  @NPV_006 @UATNPV
  Scenario Outline: TC#07 & TC#09 - Create a Claim with Appliance Type Cooker/Hob & Check "Fuel Type" option is displayed for selection - Accidental Damage
    Given I click create claim and I enter plan number "<PlanNo>" to search for Plan View
    Then I verify the new plan view page displayed
    When I select the Claim Type as "<ClaimType>"
    And I enter the contact info
    Then I enter "<ModelNumber>" on the product confirmation section for Cooker for NPV
    When I enter the PNC Details and fault data and click continue
    When I enter the QA section with below
      | QuestionNo | Question                                                                                 | Answer                  | AnswerType    |
      | Q1         | Please select whether your appliance installation type is free standing or built in      | Freestanding/Standalone | RadioButton   |
      | Q2         | When did the damage to your product occur?                                               | Today                   | Date          |
      | Q3         | What caused the damage?                                                                  | Accidentally hit        | RadioButton   |
      | Q4         | Please describe the fault                                                                | Accidentally hit        | ResponseField |
      | Q5         | Is there any detail the engineer should be aware of prior to or on the appointment date? | Accidentally hit        | ResponseField |
    Then I confirm the service option as "<ServiceOption>" for New Plan View
    And I enter the additional information for Service Option Message
    And I select the Available Appointment if exist and confirm appointment
    Then I verify the Booking Confirmed Page is displayed for "<ClaimType>" and "<ServiceProvider>"
    Examples:
      | PlanNo     | ClaimType                 | ModelNumber     | ServiceOption                     | PNC Number | ServiceProvider             |
      | A4D0080208 | Damage Caused by Accident | ELECTRIC COOKER | Home Visit (Normal Working Hours) | 948904188  | Pacifica Appliance Services |


  @NPV_018 @UATNPV
  Scenario Outline: TC#18 - Create CAT1 Vulnerability claim Scottish Power Manufacturer
    Given I click create claim and I enter plan number "<PlanNo>" to search for Plan View
    When I verify the new plan view page displayed
    And I select the Claim Type as "<ClaimType>"
    And I waive off the Excess Pay for New Plan View
    And I enter the contact info
    Then I enter "<ModelNumber>" on the product confirmation section for Heating for NPV
    When I enter the NPV QA section with below
      | QuestionNo | Question                           | Answer                    | AnswerType    | SubQuestion |
      | Q1         | Do you have a gas leak?            | No                        | RadioButton   |             |
      | Q2         | Please select your problem         | Uncontrollable water leak | RadioButton   |             |
      | Q3         | What is the location of the leak?  | Heating Boiler            | RadioButton   |             |
      | Q4         | When did the problem occur?        | Today                     | Date          |             |
      | Q5         | Any other details you can give us? | Automation                | ResponseField |             |
      | Q6         | Health or wellbeing?               | No                        | RadioButton   | Q7          |
      | Q7         | Health or wellbeing?               | No                        | ResponseField |             |
    Then I confirm the service option as "<ServiceOption>" for New Plan View
    And I enter the additional information for Service Option Message
    And I select the Available Appointment if exist and confirm appointment
    Then I verify the Booking Confirmed Page is displayed for "<ClaimType>" and "<ServiceProvider>"
    Examples:
      | PlanNo     | ClaimType | ModelNumber | ServiceOption | Status      | ServiceProvider       |
      | VJC0085408 | Breakdown | Chaffoteaux | Category 1    | Parts Delay | FLYINGTOOLBOX RESPOND |


  @NPV_020 @UATNPV
  Scenario Outline: TC#20 - Complete a repair booking
    Given I click create claim and I enter plan number "<PlanNo>" to search for Plan View
    Then I verify the new plan view page displayed
    When I select the Claim Type as "Breakdown"
    And I waive off the Excess Pay for New Plan View
    And I enter the contact info
    When I enter the PNC Details and fault data and click continue
    When I enter the NPV QA section with below
      | QuestionNo | Question                                                         | Answer | AnswerType    |
      | Q1         | Is there any reason you can think of to reject this claim?       | No     | RadioButton   |
      | Q2         | When did your product stop working?                              | Today  | Date          |
      | Q3         | Please ask the customer for a detailed description of the fault. | Test   | ResponseField |
    Then I confirm the service option as "<ServiceOption>" for New Plan View
    And I enter the additional information for Service Option Message
    And I Book without an Appointment and confirm appointment for "<ServiceProvider>" in New Plan View
    Then I verify the Booking Confirmed Page is displayed for "<ClaimType>" and "<ServiceProvider>"
    And I navigate to D&G Repairer Portal
    When I enter repairer username and password and click Login
    Then I search for a claim using "<PlanNo>" and search for WrittenOff
    Then I complete the DiaryAppointment with outcome as "<Status>"
    Then I confirm the Labour and charge for completing the claim with status as "<Status>"
    And I navigate to D&G CC Agent Portal
    When I enter username and password and click Login for New Plan View
    Then I Verify the Job Completed Status in Orbit is Successful for the Plan for NPV "<PlanNo>" and "REPAIR COMPLETED"
    Then I verify the new status's are logged in ORB NPV under Request Authorisation, when changes are made to RP
    Then I verify the Job status in ORB NPV under Request Authorisation matched to RP as "REPAIR COMPLETED"
    And I Confirm that system notes display correctly and user can add a note in ORB NPV
    And I Confirm user is able to Run and generate a claim report

    Examples:
      | PlanNo          | ClaimType | ServiceOption                     | Status                   | PNC Number | ServiceProvider       |
      | CREATE_NEW_PLAN | Breakdown | Home Visit (Normal Working Hours) | Callout / Visit Complete | 948904188  | FLYINGTOOLBOX RESPOND |

  @NPV_019 @ASVCLAIM
  Scenario Outline: TC#18 - Create an Annual service Claim and complete the repair booking
    Given I click create claim and I enter plan number "<PlanNo>" to search for Plan View for "Heating"
    When I verify the new plan view page displayed
    And I select the Claim Type as "<ClaimType>"
    And I waive off the Excess Pay for New Plan View
    And I enter the contact info
    Then I enter "<ModelNumber>" on the product confirmation section for Heating for NPV
    When I enter the NPV QA section with below
      | QuestionNo | Question                                        | Answer         | AnswerType  | SubQuestion |
      | Q1         | Please confirm the type of appointment required | Annual Service | RadioButton |             |
    Then I confirm the service option as "<ServiceOption>" for New Plan View
    And I enter the additional information for all Service Option Message
    And I Book without an Appointment and confirm appointment for "<ServiceProvider>" in New Plan View
    Then I verify the Booking Confirmed Page is displayed for "<ClaimType>" and "<ServiceProvider>"
    And I navigate to D&G Repairer Portal
    When I enter repairer username and password and click Login
    Then I search for a claim using "<PlanNo>" and search for WrittenOff
    Then I complete the DiaryAppointment with outcome as "<Status>"
    Then I complete job for ASV "<Status>" with serial number updated
    And I navigate to D&G CC Agent Portal
    When I enter username and password and click Login for New Plan View
    Then I Verify the Job Completed Status in Orbit is Successful for the Plan for NPV "<PlanNo>" and "REPAIR COMPLETED"
    Examples:
      | PlanNo | ClaimType      | ModelNumber             | ServiceOption  | Status                   | ServiceProvider       |
      | CRT    | Annual Service | Combination Boiler-Gold | Annual Service | Callout / Visit Complete | FLYINGTOOLBOX RESPOND |
#      | HQP0001770 | Annual Service | Combination Boiler-Gold | Annual Service | Callout / Visit Complete | FLYINGTOOLBOX RESPOND |


  @WIP2 @NPV_020
  Scenario Outline: Create a Accessory Only Claim Claim with Appliance Type TV
    Given I click create claim and I enter plan number "<PlanNo>" to search for Plan View
    Then I verify the new plan view page displayed
    When I select the Claim Type as "<ClaimType>"
    And I enter the contact info
    Then I enter "<ModelNumber>" on the product confirmation section for Television for NPV
    When I enter the NPV QA section with below
      | QuestionNo | Question                                                   | Answer          | AnswerType        | SubQuestion |
      | Q1         | Is there any reason you can think of to reject this claim? | Mark            | RadioButton       | Q2          |
      | Q2         | Is there any reason you can think of to reject this claim? | Testdata        | ResponseField     |             |
      | Q3         | Accessory                                                  | Manual,MarkTest | AccessoryDropdown |             |
    Then I confirm the service option as "<ServiceOption>" for New Plan View
    And I enter the additional information for Service Option Message
    And I Book without an Appointment and confirm appointment for "<ServiceProvider>" in New Plan View
    Then I verify the Booking Confirmed Page is displayed for "<ClaimType>" and "<ServiceProvider>"

    Examples:
      | PlanNo     | ClaimType | ModelNumber | ServiceOption                     | ServiceProvider       |
      | L1R0093915 | Breakdown | Television  | Home Visit (Normal Working Hours) | FLYINGTOOLBOX RESPOND |

  @NPV_028 @UATNPV
  Scenario Outline: TC#28 - Validate customer communications
    Given I navigate to Booking Overview Page for the Open Claim for Plan "<PlanNo>"
    Then  I verify the NPV CustomerCommunications messages are generated
    Examples:
      | PlanNo     | ClaimType | ModelNumber | ServiceOption | Status      | ServiceProvider       |
      | VJC0085408 | Breakdown | Chaffoteaux | Category 1    | Parts Delay | FLYINGTOOLBOX RESPOND |


  @NPV_024 @UATNPV
  Scenario Outline: TC#24 - Create a claim with plan already attached to a claim
    Given I click create claim and I enter plan number "<PlanNo>" to search for Plan View
    Then I verify the new plan view page displayed
    When I select the Claim Type as "Breakdown"
    And I waive off the Excess Pay for New Plan View
    And I enter the contact info
    When I enter the PNC Details and fault data and click continue
    When I enter the NPV QA section with below
      | QuestionNo | Question                                                         | Answer | AnswerType    |
      | Q1         | Is there any reason you can think of to reject this claim?       | No     | RadioButton   |
      | Q2         | When did your product stop working?                              | Today  | Date          |
      | Q3         | Please ask the customer for a detailed description of the fault. | Test   | ResponseField |
    Then I confirm the service option as "<ServiceOption>" for New Plan View
    And I enter the additional information for Service Option Message
    And I Book without an Appointment and confirm appointment for "<ServiceProvider>" in New Plan View
    Then I verify the Booking Confirmed Page is displayed for "<ClaimType>" and "<ServiceProvider>"
    And I navigate to D&G CC Agent Portal
    When I enter username and password and click Login for New Plan View
    Then I verify the Login is successful
    And I click create claim and I enter plan number "<PlanNo>" to search for Plan View
    Then I verify the new plan view page displayed
    And I select the Claim Type as "Breakdown" and verify claim already exist

    Examples:
      | PlanNo          | ClaimType | ServiceOption                     | ServiceProvider       |
      | CREATE_NEW_PLAN | Breakdown | Home Visit (Normal Working Hours) | FLYINGTOOLBOX RESPOND |


  @NPV_037 @UATNPV
  Scenario Outline: TC#37 - Complete a Diary Appointment
    Given I create a Claim from API for "<PlanNo>"
    When Im on the D&G Repairer Portal
    Then I search for a claim using "<PlanNo>" and search for Repairer
    Then I complete the DiaryAppointment with outcome as "<Status>"
    Then I Verify the Job Completed Status in Diary Appiontment Section in RP is Successful for "<Status>"
    And  I navigate to D&G CC Agent Portal
    When I enter username and password and click Login for New Plan View
    Then I Verify the Job Completed Status in Orbit is Successful for the Plan for NPV "<PlanNo>" and "<JobStatus>"

    Examples:
      | PlanNo | ClaimType | ServiceOption                     | Status                                 | PNC Number | ServiceProvider       | JobStatus           |
      | CRT    | Breakdown | Home Visit (Normal Working Hours) | Out Card Left - Engineer Delayed       | 948904188  | FLYINGTOOLBOX RESPOND | OUT CARD LEFT       |
      | CRT    | Breakdown | Home Visit (Normal Working Hours) | Parts Delay                            | 948904188  | FLYINGTOOLBOX RESPOND | FIELD CALL REQUIRED |
      | CRT    | Breakdown | Home Visit (Normal Working Hours) | Customer Request                       | 948904188  | FLYINGTOOLBOX RESPOND | FIELD CALL REQUIRED |
      | CRT    | Breakdown | Home Visit (Normal Working Hours) | Out Card Left - Customer not available | 948904188  | FLYINGTOOLBOX RESPOND | OUT CARD LEFT       |

  @NPV_049 @UATNPV
  Scenario: NPV#49 - Verify the Report Generator has displayed and able to click run
    Given I Confirm user is able to Run and generate a claim report
    When  I download the file to target folder

  @NPV_021 @UATNPV
  Scenario Outline: NPV#21 - Create a Claim with Claim outcome as Claim Rejected
    Given I click create claim and I enter plan number "<PlanNo>" to search for Plan View
    When I verify the new plan view page displayed
    And I select the Claim Type as "<ClaimType>"
    And I waive off the Excess Pay for New Plan View
    And I enter the contact info
    Then I enter "<ModelNumber>" on the product confirmation section for Heating for NPV
    When I enter the NPV QA section with below
      | QuestionNo | Question                                                                           | Answer               | AnswerType  |
      | Q1         | Are you reporting a gas leak, can smell gas or suspect carbon monoxide is present? | Yes                  | RadioButton |
      | Q2         | Please confirm the type of issue                                                   | Unknown smell of gas | Multi       |
    Then I verify claim is in Rejected status
    Examples:
      | PlanNo     | ClaimType | ModelNumber |
      | VJP0000215 | Breakdown | Chaffoteaux |

  @NPV_029 @UATNPV @NPVTEST
  Scenario Outline: NPV#29 - Plan within the manufacturer's warranty is prompted with a message - Breakdown
    Given I enter plan number "<PlanNo>" to search for Plan View
    When I verify the new plan view page displayed
    Then I select the Claim Type as "<ClaimType>" and verify Plan is InWarranty
    Examples:
      | PlanNo     | ClaimType | ModelNumber | ServiceOption                     |
      | KBC0008858 | Breakdown | Television  | Home Visit (Normal Working Hours) |

  @NPV_030_1 @UATNPV @NPVTEST1
  Scenario Outline: TC#NPV001 - Plan Written Off Wizard
    Given I click the PlanWriteOff Button on the Header menu
    When I verify the PlanWriteOff Page is now displayed
    Then I write off the "<PlanNo>" with the write off status as "<WriteOffStatus>" for "<OEM>"
    Then I verify the Plan has been written off Successfully
    Examples:
      | PlanNo          | WriteOffStatus         | OEM       |
      | CREATE_NEW_PLAN | UNIT WRITTEN OFF - BER | WHIRLPOOL |

  @NPV_030 @NPV_036 @UATNPV
  Scenario Outline: NPV#30, NPV#36 - Verify Repairer Portal can set a claim to "PNLA Write-Off"
    Given I click create claim and I enter plan number "<PlanNo>" to search for Plan View
    Then I verify the new plan view page displayed
    When I select the Claim Type as "Breakdown"
    And I waive off the Excess Pay for New Plan View
    And I enter the contact info
    When I enter the PNC Details and fault data and click continue
    When I enter the NPV QA section with below
      | QuestionNo | Question                                                         | Answer | AnswerType    |
      | Q1         | Is there any reason you can think of to reject this claim?       | No     | RadioButton   |
      | Q2         | When did your product stop working?                              | Today  | Date          |
      | Q3         | Please ask the customer for a detailed description of the fault. | Test   | ResponseField |
    Then I confirm the service option as "<ServiceOption>" for New Plan View
    And I enter the additional information for all Service Option Message
    And I Book without an Appointment and confirm appointment for "<ServiceProvider>" in New Plan View
    Then I verify the Booking Confirmed Page is displayed for "<ClaimType>" and "<ServiceProvider>"
    When I navigate to D&G Repairer Portal
    When I enter repairer username and password and click Login
    Then I search for a claim using "<PlanNo>" and search for WrittenOff
    Then I complete the DiaryAppointment with outcome as "<Status>"
    And I confirm the Labour and Parts section for "<WrittenOffStatus>"
    Then I Verify the Job Completed Status in RP is Successful for "<WrittenOffStatus>"
    And  I navigate to D&G CC Agent Portal
    When I enter username and password and click Login for New Plan View
    Then I Verify the Job Completed Status in Orbit is Successful for the Plan for NPV "<PlanNo>" and "<AdditionalStatusIfExist>"
    Examples:
      | PlanNo | ClaimType | ModelNumber | ServiceOption                     | Status       | PNC Number | WrittenOffStatus   | AdditionalStatusIfExist            | ServiceProvider       |
      | CRT    | Breakdown | Chaffoteaux | Home Visit (Normal Working Hours) | Parts Needed | 948904188  | WRITTEN OFF - PNLA | WRITTEN OFF - PNLA,PR - OFFER SENT | FLYINGTOOLBOX RESPOND |

  @NPV_031 @WIP @UATNPV @NPVTEST1
  Scenario Outline: TC#31 - Verify Repairer Portal can set a claim to "BER Write-Off"
    Given I click create claim and I enter plan number "<PlanNo>" to search for Plan View
    Then I verify the new plan view page displayed
    When I select the Claim Type as "Breakdown"
    And I waive off the Excess Pay for New Plan View
    And I enter the contact info
    When I enter the PNC Details and fault data and click continue
    When I enter the NPV QA section with below
      | QuestionNo | Question                                                         | Answer | AnswerType    |
      | Q1         | Is there any reason you can think of to reject this claim?       | No     | RadioButton   |
      | Q2         | When did your product stop working?                              | Today  | Date          |
      | Q3         | Please ask the customer for a detailed description of the fault. | Test   | ResponseField |
    Then I confirm the service option as "<ServiceOption>" for New Plan View
    And I enter the additional information for all Service Option Message
    And I Book without an Appointment and confirm appointment for "<ServiceProvider>" in New Plan View
    Then I verify the Booking Confirmed Page is displayed for "<ClaimType>" and "<ServiceProvider>"
    When I navigate to Booking Overview Page for the Open Claim for Plan "<PlanNo>"
    Then I process the Claim to WrittenOff with the status as "<WrittenOffStatus>" and "<AdditionalStatusIfExist>" in NPV
    Then I Verify the job status for NPV "<PlanNo>" and "<AdditionalStatusIfExist>"
    Examples:
      | PlanNo | ClaimType | ModelNumber | ServiceOption                     | Status       | PNC Number | WrittenOffStatus  | AdditionalStatusIfExist            | ServiceProvider       |
      | CRT    | Breakdown | Chaffoteaux | Home Visit (Normal Working Hours) | Parts Needed | 948904188  | WRITTEN OFF - BER | WRITTEN OFF - BER, PR - OFFER SENT | FLYINGTOOLBOX RESPOND |

  @NPV_032 @UATNPV
  Scenario Outline: NPV#32 - Verify Repairer Portal can set a claim to "PART ETA Write-Off"
    Given I click create claim and I enter plan number "<PlanNo>" to search for Plan View
    Then I verify the new plan view page displayed
    When I select the Claim Type as "Breakdown"
    And I waive off the Excess Pay for New Plan View
    And I enter the contact info
    When I enter the PNC Details and fault data and click continue
    When I enter the NPV QA section with below
      | QuestionNo | Question                                                         | Answer | AnswerType    |
      | Q1         | Is there any reason you can think of to reject this claim?       | No     | RadioButton   |
      | Q2         | When did your product stop working?                              | Today  | Date          |
      | Q3         | Please ask the customer for a detailed description of the fault. | Test   | ResponseField |
    Then I confirm the service option as "<ServiceOption>" for New Plan View
    And I enter the additional information for all Service Option Message
    And I Book without an Appointment and confirm appointment for "<ServiceProvider>" in New Plan View
    Then I verify the Booking Confirmed Page is displayed for "<ClaimType>" and "<ServiceProvider>"
    When I navigate to D&G Repairer Portal
    When I enter repairer username and password and click Login
    Then I search for a claim using "<PlanNo>" and search for WrittenOff
    Then I complete the DiaryAppointment with outcome as "<Status>"
    And I confirm the Labour and Parts section for "<WrittenOffStatus>"
    Then I Verify the Job Completed Status in RP is Successful for "<WrittenOffStatus>"
    And  I navigate to D&G CC Agent Portal
    When I enter username and password and click Login for New Plan View
    Then I Verify the Job Completed Status in Orbit is Successful for the Plan for NPV "<PlanNo>" and "<AdditionalStatusIfExist>"
    Examples:
      | PlanNo | ClaimType | ModelNumber | ServiceOption                     | Status        | PNC Number | WrittenOffStatus       | AdditionalStatusIfExist | ServiceProvider       |
      | CRT    | Breakdown |             | Home Visit (Normal Working Hours) | TBC Completed | 948904188  | WRITTEN OFF - PART ETA | PR - OFFER SENT         | FLYINGTOOLBOX RESPOND |

  @NPV_034 @UATNPV
  Scenario Outline: Write off from Authorization Panel
    Given I create a Claim from API for "<PlanNo>"
    When I navigate to Booking Overview Page for the Open Claim for Plan "<PlanNo>"
    And I perform the Write off from writeoffauthorization panel for "<WrittenOffStatus>" and RA Status "<RAStatus>"
    Then I Verify the job status for NPV "<PlanNo>" and "<WrittenOffStatus>"
    Examples:
      | PlanNo | WrittenOffStatus            | RAStatus                         |
      | CRT    | WRITTEN OFF - UNREPAIRABLE  | UNIT WRITTEN OFF - UNREPAIRABLE  |
      | CRT    | WRITTEN OFF - GOGW          | UNIT WRITTEN OFF - GOGW          |
      | CRT    | WRITTEN OFF - CUSTOMER CARE | UNIT WRITTEN OFF - CUSTOMER CARE |
      | CRT    | WRITTEN OFF - PLEDGE        | UNIT WRITTEN OFF - PLEDGE        |

  @NPV_039 @UATNPV @NPVTEST
  Scenario Outline: NPV#39 - Plan is Cancelled
    Given I enter plan number "<PlanNo>" to search for Plan View
    When I verify the new plan view page displayed
    Then I select the Claim Type as "<ClaimType>" and verify Plan is Cancelled
    Examples:
      | PlanNo     | ClaimType                 | ModelNumber | ServiceOption                     |
      | 2VX0086677 | Breakdown                 | Television  | Home Visit (Normal Working Hours) |
      | 2VX0086677 | Damage Caused by Accident | Television  | Home Visit (Normal Working Hours) |

  @NPV_040 @UATNPV @NPVTEST
  Scenario Outline: NPV#40 - Plan is Lapsed
    Given I enter plan number "<PlanNo>" to search for Plan View
    When I verify the new plan view page displayed
    Then I select the Claim Type as "<ClaimType>" and verify Plan is Lapsed
    Examples:
      | PlanNo     | ClaimType                 | ModelNumber | ServiceOption                     |
      | NKS0066884 | Breakdown                 | Television  | Home Visit (Normal Working Hours) |
      | NKS0066884 | Damage Caused by Accident | Television  | Home Visit (Normal Working Hours) |

  @NPV_033 @UATNPV
  Scenario Outline: NPV#33 - Verify Repairer Portal can set a claim to "Unrepairable Write-Off"
    Given I create a Claim from API for "<PlanNo>"
    When I navigate to D&G Repairer Portal
    When I enter repairer username and password and click Login
    Then I search for a claim using "<PlanNo>" and search for WrittenOff
    Then I complete the DiaryAppointment with outcome as "<Status>"
    And I confirm the Labour and Parts section for "<WrittenOffStatus>"
    Then I Verify the Job Completed Status in RP is Successful for "<WrittenOffStatus>"
    And  I navigate to D&G CC Agent Portal
    When I enter username and password and click Login for New Plan View
    Then I Verify the Job Completed Status in Orbit is Successful for the Plan for NPV "<PlanNo>" and "<WrittenOffStatus>"

    Examples:
      | PlanNo | ClaimType | ModelNumber | ServiceOption                     | Status       | PNC Number | WrittenOffStatus           | AdditionalStatusIfExist | ServiceProvider       |
      | CRT    | Breakdown |             | Home Visit (Normal Working Hours) | Parts Needed | 948904188  | WRITTEN OFF - UNREPAIRABLE | PR - OFFER SENT         | FLYINGTOOLBOX RESPOND |
