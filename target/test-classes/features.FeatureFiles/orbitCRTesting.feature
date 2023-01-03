##====================================================
## ORBIT CR Testing PACK
##====================================================
Feature: Automation Pack for Orbit - Whirlpool Rebooking and Reselecting SP scenario

  Background: User to Login
    Given I navigate to D&G CC Agent Portal
    When I enter username and password and click Login
    Then I verify the Login is successful

############################################# 1st Scenario working fine ##########################################################################################
  Scenario Outline: Rebook an appointment with same Service Provider for Whirlpool Plan in Old UI
    Given I enter claim number "<ClaimNo>" and click search button for Whirlpool OEM
    Then I Verify the Review Claim Page displayed for the given claimID
    Then I click on Dairy Appointment from the Review Claim page
    And I click on Find New Appointment button to Rebook Reselect an appointment
    And I verify Find New Appointment pop up with the calendar displayed
    Then I select the Available date and specific timeslot and click on Confirm Rebooking button
    And I click on Confirm button in Confirm Rebooking Pop up box
    Then I verify the status of the job changed to "<JobStatus>"
    Then I click on Dairy Appointment from the Review Claim page
    And I verify the old Appointment updated with status "<AppointmentStatus>"
    Examples:
      | ClaimNo  | AppointmentStatus  | JobStatus               |
      | 10007895 | Customer Request   | 1ST FIELD CALL ARRANGED |

############################################# 2nd Scenario ##########################################################################################

  Scenario Outline: Reselect an appointment with different SP for Whirlpool Plan in Old UI
    Given I enter claim number "<ClaimNo>" and click search button for Whirlpool OEM
    Then I Verify the Review Claim Page displayed for the given claimID
    Then I click on Dairy Appointment from the Review Claim page
    And I click on Find New Appointment button to Rebook or Reselect an appointment
    And I verify Find New Appointment pop up with the calendar displayed
    Then I click on Search Other Service Provider button and select the Available date from the Field Call Calendar
    And I select the Service Provider radio button to reselect an appointment and click on Rebook button
    Then I verify Alert pop up and click on Yes button in Confirmation Alert pop up box
    And I verify the new Appointment booked with different Service provider from the Review claim section
    Then I verify the status of the Job "<ReselectJobStatus>" after Reselection
    Then I verify that the new claim ID created and compared with the old ClaimID "<ClaimNo>"
    Then I verify the old claim "<ClaimNo>" updated with status "<ReviewClaimStatus>" from the Review Claim section
    And I verify the old claim closed with updated status as "<AppointmentJobStatus>" under Diary Appointment
    Examples:
      | ClaimNo  | ReviewClaimStatus | AppointmentJobStatus      | ReselectJobStatus       |
      | 11111607 | JOB REASSIGNED    | Claim Closed - Reassigned | 1ST FIELD CALL ARRANGED |

############################################# 3rd Scenario working fine ##########################################################################################

  Scenario Outline: Cancel an appointment of Whirlpool Plan in New Review Claim UI
    Given I enter claim number "<ClaimNo>" and click search button for Whirlpool OEM
    Then I Verify the Booking Overview Page displayed for the given claimID
    Then I click on Repair Information tab and verify page loaded successfully
    Then I click and select a row having open appointment on the claim
    Then I click on Cancel button to cancel an appointment
    And I click on Yes button in cancel confirmation pop up
    Then I verify Cancel Appointment pop up loaded successfully
    Then I select the Completion Status from the drop down and enter notes
    And I click on Confirm button to cancel an appointment
    Then I verify the order cancelled pop up displayed successfully
    Then I verify the Appointment Completion Status column updated with "<AppointmentCompletionStatus>"

    Examples:
      | ClaimNo  | AppointmentCompletionStatus |
      | 73443    | Customer Request            |

############################################# 4th Scenario working fine ##########################################################################################
  Scenario Outline: Rebook an appointment of Whirlpool Plan in New Review Claim UI
    Given I enter claim number "<ClaimNo>" and click search button for Whirlpool OEM
    Then I Verify the Booking Overview Page displayed for the given claimID
    Then I click on Repair Information tab and verify page loaded successfully
    Then I click and select a row having open appointment on the claim
    And I click on Find New Appointment button to Rebook or Reselect an appointment
    And I verify Find New Appointment pop up with the calendar displayed
    Then I select the Available date and specific timeslot and click on Confirm Rebooking button
    And I click on Confirm button in Confirm Rebooking Pop up box
    Then I verify the status of the job changed to "<JobStatus>"
    Then I click on Repair Information tab and verify page loaded successfully
    And I verify the Appointment updated with new status "<AppointmentStatus>"

    Examples:
      | ClaimNo  | AppointmentStatus | JobStatus               |
      | 60909    | Customer Request  | 1ST FIELD CALL ARRANGED |

############################################# 5th Scenario working fine ##########################################################################################
  Scenario Outline: Reselect an appointment of Whirlpool Plan in New Review Claim UI
    Given I enter claim number "<ClaimNo>" and click search button for Whirlpool OEM
    Then I Verify the Booking Overview Page displayed for the given claimID
    Then I click on Repair Information tab and verify page loaded successfully
    Then I click and select a row having open appointment on the claim
    And I click on Find New Appointment button to Rebook or Reselect an appointment
    And I verify Find New Appointment pop up with the calendar displayed
    Then I click on Search Other Service Provider button and select the date from the Field Call Calendar
    Then I click on the Service Provider radio button to reselect an appointment and click on Rebook button
    Then I verify Alert pop up and click on Yes button in Confirmation Alert pop up box
    And I verify the new Appointment booked with different Service provider in Repair Information section
    Then I verify the status of the job changed to "<ReselectJobStatus>" in Booking Overview
    Then I verify the new claim ID created and compared with the old ClaimID "<ClaimNo>"
    Then I click on D&G Logo and navigate to Orbit homepage
    Given I enter claim number "<ClaimNo>" and click search button for Whirlpool OEM
    Then I verify the old claim number "<ClaimNo>" updated with status "<OldClaimIdStatus>" in Booking Overview page
    Then I click on Repair Information tab and verify page loaded successfully
    And I verify the old claim closed with updated status as "<AppointmentJobStatus>" under Appointment

    Examples:
      | ClaimNo  | OldClaimIdStatus | AppointmentJobStatus      | ReselectJobStatus       |
      | 73298    | JOB REASSIGNED   | Claim Closed - Reassigned | 1ST FIELD CALL ARRANGED |

############################################# 6th Scenario working fine ###################################################################################

  Scenario Outline: Validate the status of the old claim ID after job reassigned to different service provider in new UI.
    Given I enter claim number "<ClaimNo>" and click search button for Whirlpool OEM
    Then I Verify the Booking Overview Page displayed for the given claimID
    Then I verify the old claim number "<ClaimNo>" updated with status "<OldClaimIdStatus>" in Booking Overview page
    Then I click on Repair Information tab and verify page loaded successfully
    And I verify the old claim closed with updated status as "<AppointmentJobStatus>" under Appointment
    Examples:
      | ClaimNo  | OldClaimIdStatus | AppointmentJobStatus    |
      | 73298    | JOB REASSIGNED | Claim Closed - Reassigned |

###############################################################################################################################
############################################# 7th Scenario ##################################################################
  Scenario Outline: Create a new claim with Pay & Claim option while Rebook an appointment
    Given I enter Plan number "<PlanNo>" and click search button in Track Repair or Claim
#    Then I click on the checkbox present in the first row of the grid
#    And I click on View Job Details button
    Then I click on the open claim no in the Plan History section
    And I click on the Open Claim button in the Inflight Repair Summary
    Then I verify Review Claim Page displayed
    Then I Verify the Booking Overview Page displayed for the given claimID
    Then I click on Repair Information tab and verify page loaded successfully
    Then I click and select a row having open appointment on the claim
    And I click on Find New Appointment button to Rebook or Reselect an appointment
    And I verify Find New Appointment pop up with the calendar displayed
    Then I click on Search Other Service Providers and Continue and Pay Claim button
    And I click on the Customer has confirmed to the Pay and Claim Options checkbox
    Then I click on Yes button in Confirm Pop Up to confirm Pay And Claim
    Then I verify Pay and Claim confirmation page displayed

    Examples:
      | PlanNo     |
      | C1Z0121211 |


    ############################################# 8th Scenario ##################################################################
  Scenario Outline: Make a payment from WorldPay Credit Card - Customer Contact
    Given I enter Plan number "<PlanNo>" and click search button in Track Repair or Claim
    Then I click on the checkbox present in the first row of the grid
    And I click on View Job Details button
    Then I verify Review Claim Page displayed
    Then I Verify the Booking Overview Page displayed for the given claimID
    Then I click on Repair Information tab and verify page loaded successfully
    Then I click and select a row having open appointment on the claim
    And I click on Find New Appointment button to Rebook or Reselect an appointment
    And I verify Find New Appointment pop up with the calendar displayed
    Then I click on Search Other Service Providers and Continue and Pay Claim button
    And I click on the Customer has confirmed to the Pay and Claim Options checkbox
    Then I click on Yes button in Confirm Pop Up to confirm Pay And Claim
    Then I verify Pay and Claim confirmation page displayed

    Examples:
      | PlanNo     |
      | C1Z0121211 |


############################################# 9th Scenario ##################################################################

  Scenario Outline: Verify Appointment card button is present in the Diary Appointment section in Repair Information tab for Whirlpool plans
    Given I enter Plan number "<PlanNo>" and click search button in Track Repair or Claim
#    Then I click on the checkbox present in the first row of the grid
#    And I click on View Job Details button
    Then I click on the open claim no in the Plan History section
    And I click on the Open Claim button in the Inflight Repair Summary
    Then I verify Review Claim Page displayed
    Then I Verify the Booking Overview Page displayed for the given claimID
    Then I click on Repair Information tab and verify page loaded successfully
    Then I click and select a row having open appointment on the claim
    And I verify Appointment Card button is present when appointment date is for current date

    Examples:
      | PlanNo     |
      | 4HH0484682 |

  Scenario Outline: Verify Appointment Information Unavailable pop up display when Engineer is near to the
  Calling Customer address and CC agent clicks on Appointment Card Button for Whirlpool plans
    Given I enter Plan number "<PlanNo>" and click search button in Track Repair or Claim
#    Then I click on the checkbox present in the first row of the grid
#    And I click on View Job Details button
    Then I click on the open claim no in the Plan History section
    And I click on the Open Claim button in the Inflight Repair Summary
    Then I verify Review Claim Page displayed
    Then I Verify the Booking Overview Page displayed for the given claimID
    Then I click on Repair Information tab and verify page loaded successfully
    Then I click and select a row having open appointment on the claim
    And I verify Appointment Card button is present when appointment date is for current date
    Then I click on Appointment Card button in Diary Appointment section
    And I verify Appointment Information Unavailable pop up display

    Examples:
      | PlanNo     |
      | 4HH0484682 |

  Scenario Outline: Verify Engineer Tracking Information displayed in Appointment Card pop up for Whirlpool plans
    Given I enter Plan number "<PlanNo>" and click search button in Track Repair or Claim
#    Then I click on the checkbox present in the first row of the grid
#    And I click on View Job Details button
    Then I click on the open claim no in the Plan History section
    And I click on the Open Claim button in the Inflight Repair Summary
    Then I verify Review Claim Page displayed
    Then I Verify the Booking Overview Page displayed for the given claimID
    Then I click on Repair Information tab and verify page loaded successfully
    Then I click and select a row having open appointment on the claim
    And I verify Appointment Card button is present when appointment date is for current date
    Then I click on Appointment Card button in Diary Appointment section
    And I verify Engineer Tracking information displayed in Appointment Card pop up


    Examples:
      | PlanNo     |
      | 4HH0484683 |

 ############################################# 9th Scenario ##################################################################

  Scenario Outline: TC#01 - Verify new pop up for the WB plan when appointment is not selected: New indicator set to YES
    Given I click SiteMap and I enter "<SearchValue>" and click on the wizard
    And I verify Service Provider page loaded successfully
    Then I enter "<CompanyName>" in the Company Name column in Service Provider grid
    And I select the first row in the Service Provider grid and click on Edit button
    Then I verify the new Indicator present in Update Service Provider
    Then I click on YES radio button to set the new indicator and save it
    Then I click on D&G Logo and navigate to Orbit homepage
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I verify the new plan view page displayed
    When I select the Claim Type as "<ClaimType>"
#    And I continue for Excess Pay for New Plan View
    And I waive off the Excess Pay for New Plan View
    And I enter the contact info
    Then I select the WB "<Model>" & "<Fault>" from the dropdown and click Continue
    When I enter the NPV QA section with below
      | QuestionNo | Question                                                                                           | Answer                    | AnswerType  | SubQuestion |
      | Q1         | Are you reporting a gas leak, can smell gas or suspect carbon monoxide is present?                 | No                        | RadioButton |             |
      | Q2         | What is the problem being experienced?                                                             | Uncontrollable Water Leak | RadioButton |             |
      | Q3         | Where is the location of the uncontrollable leak?                                                  | Heating Boiler            | RadioButton |             |
      | Q4         | When did the problem occur?                                                                        | Today                     | Date        |             |
      | Q5         | Is there any additional detail you can provide relating to the problem being experienced?          | No                        | RadioButton |             |
      | Q6         | Is there any health or wellbeing reason we need to be made aware of when booking this appointment? | No                        | RadioButton |             |
    Then I confirm the service option as "<ServiceOption>" for NPV
    Then I click on the WB no availability pop up
    And I enter the additional information for Service Option Message
    Then I click on Confirm Option Details button and verify the pop up
    Given I click SiteMap and I enter "<SearchValue>" and click on the wizard
    And I verify Service Provider page loaded successfully
    Then I enter "<CompanyName>" in the Company Name column in Service Provider grid
    And I select the first row in the Service Provider grid and click on Edit button
    Then I verify the new Indicator present in Update Service Provider
    Then I click on NO radio button to set the new indicator and save it

    Examples:
      | SearchValue       | CompanyName     | PlanNo     | ClaimType                     | Model                                  | Fault                | ServiceOption                     |  |
      | Service Providers | WORCESTER BOSCH | HL60006371 | Breakdown (Boiler & Controls) | GREENSTAR 40CDI CONVENTIONAL FSN-GB NG | There is an oil leak | Home Visit (Normal Working Hours) |  |

