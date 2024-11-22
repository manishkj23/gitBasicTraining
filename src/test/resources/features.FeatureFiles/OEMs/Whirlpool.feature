##====================================================
## ORBIT REGRESSION PACK - NEW PLAN VIEW
##====================================================
Feature: Orbit Automation Regression Pack - NPV - WHIRLPOOL

  Background: User to Login
    Given I navigate to new D&G CC Agent Portal
    When I enter username and password and click SignIn for New Plan View
    Then I verify the Login is successful

  @SIT @UAT @WHP @ORBITNPV @OrbitWhirlpoolRegressionPack
  Scenario Outline: TC#01 - Create a Breakdown Claim for a Whirlpool Plan-Indesit

    Given I click create claim and I enter plan number "<PlanNo>" to search for Plan View for "<Make>"
    Then I verify the new plan view page displayed
    When I select the Claim Type as "<ClaimType>"
    And I waive off the Excess Pay for New Plan View
    And I enter the contact info
    Then I select the WHPL model number "<ModelNumber>" from the dropdown
    And I enter the text in WHPL Fault Search box and click on search icon
    And I confirm the appliance is still in usable condition
    And I click continue with product confirmation
    When I enter the NPV QA section with below
      | QuestionNo | Question                                          | Answer | AnswerType    |
      | Q1         | Can you think of any reason to reject this claim? | No     | RadioButton   |
      | Q2         | When did the fault happen?                        | Today  | Date          |
      | Q3         | Comments Box                                      | Test   | ResponseField |
    Then I confirm the service option as "<ServiceOption>" for New Plan View
    And I enter the additional information for Service Option Message
    And I select the Available Appointment if exist and confirm appointment
    Then I verify the Booking Confirmed Page is displayed for "<ClaimType>" and "<ServiceProvider>"
    And I click on Close Window button on Booking Overview Popup

    Examples:
      | PlanNo | Make      | ClaimType | ModelNumber       | ServiceOption                | ServiceProvider |
      | CRT    | WHIRLPOOL | Breakdown | BIWDIL7125UK | Home Visit (Normal Working Hours) | Indesit         |


  @SIT @UAT @WHP @ORBITNPV
  Scenario Outline: TC#02 - Create a Breakdown Claim for a Whirlpool Plan-Hotpoint

    Given I click create claim and I enter plan number "<PlanNo>" to search for Plan View for "<Make>"
    Then I verify the new plan view page displayed
    When I select the Claim Type as "<ClaimType>"
    And I waive off the Excess Pay for New Plan View
    And I enter the contact info
    Then I select the WHPL model number "<ModelNumber>" from the dropdown
    And I enter the text in WHPL Fault Search box and click on search icon
    And I confirm the appliance is still in usable condition
    And I click continue with product confirmation
    When I enter the NPV QA section with below
      | QuestionNo | Question                                          | Answer | AnswerType    |
      | Q1         | Can you think of any reason to reject this claim? | No     | RadioButton   |
      | Q2         | When did the fault happen?                        | Today  | Date          |
      | Q3         | Comments Box                                      | Test   | ResponseField |
    Then I confirm the service option as "<ServiceOption>" for New Plan View
    And I enter the additional information for Service Option Message
    And I select the Available Appointment if exist and confirm appointment for "<ServiceProvider>"
    Then I verify the Booking Confirmed Page is displayed for "<ClaimType>" and "<ServiceProvider>"
    And I click on Close Window button on Booking Overview Popup

    Examples:
      | PlanNo | Make      | ClaimType | ModelNumber       | ServiceOption                | ServiceProvider |
      | CRT    | WHIRLPOOL | Breakdown | BIWDIL7125UK | Home Visit (Normal Working Hours) | Hotpoint        |


  @SIT @UAT @WHP @ORBITNPV
  Scenario Outline: TC#03 - Create a Breakdown Claim for a Whirlpool Plan-Generic model

    Given I click create claim and I enter plan number "<PlanNo>" to search for Plan View for "<Make>"
    Then I verify the new plan view page displayed
    When I select the Claim Type as "<ClaimType>"
    And I waive off the Excess Pay for New Plan View
    And I enter the contact info
    Then I select Use generic model checkbox
    And I select the WHPL model number "<ModelNumber>" from the dropdown
    And I enter the text in WHPL Fault Search box and click on search icon
    And I confirm the appliance is still in usable condition
    And I click continue with product confirmation
    When I enter the NPV QA section with below
      | QuestionNo | Question                                          | Answer | AnswerType    |
      | Q1         | Can you think of any reason to reject this claim? | No     | RadioButton   |
      | Q2         | When did the fault happen?                        | Today  | Date          |
      | Q3         | Comments Box                                      | Test   | ResponseField |
    Then I confirm the service option as "<ServiceOption>" for New Plan View
    And I enter the additional information for Service Option Message
    And I select the Available Appointment if exist and confirm appointment
    Then I verify the Booking Confirmed Page is displayed for "<ClaimType>" and "<ServiceProvider>"
    And I click on Close Window button on Booking Overview Popup

    Examples:
      | PlanNo | Make      | ClaimType | ModelNumber       | ServiceOption                | ServiceProvider |
      | CRT    | WHIRLPOOL | Breakdown | WASHER INDESIT FS | Home Visit (Normal Working Hours) | Indesit        |

  @SIT @UAT @ORBITNPV @WHP @SupriyaCR
  Scenario Outline: TC#04 - Verify Status changed in Orbit CC UI after importing WHPL tracking file

    Given I click create claim and I enter plan number "<PlanNo>" to search for Plan View for "<Make>"
    Then I verify the new plan view page displayed
    When I select the Claim Type as "<ClaimType>"
    And I waive off the Excess Pay for New Plan View
    And I enter the contact info
    Then I select the WHPL model number "<ModelNumber>" from the dropdown
    And I enter the text in WHPL Fault Search box and click on search icon
    And I confirm the appliance is still in usable condition
    And I click continue with product confirmation
    When I enter the NPV QA section with below
      | QuestionNo | Question                                          | Answer | AnswerType    |
      | Q1         | Can you think of any reason to reject this claim? | No     | RadioButton   |
      | Q2         | When did the fault happen?                        | Today  | Date          |
      | Q3         | Comments Box                                      | Test   | ResponseField |
    Then I confirm the service option as "<ServiceOption>" for New Plan View
    And I enter the additional information for Service Option Message
    And I select the Available Appointment if exist and confirm appointment
    Then I verify the Booking Confirmed Page is displayed for "<ClaimType>" and "<ServiceProvider>"
    And I get the Repairer Reference no and Appointment Date
    And I click on Close Window button on Booking Overview Popup
    And I open the WHP Tracking file and update the field "RepairUniqueID"
    And I open the WHP Tracking file and update the field "SchemeCode"
    And I open the WHP Tracking file and update the field "PlanNumber"
    And I open the WHP Tracking file and update the field "RepairType" as "<ClaimType>"
    And I open the WHP Tracking file and update the field "JobCompletionRef" for the Repair Status "<RepairStatus>"
    And I open the WHP Tracking file and update the field "EngineerApptDate"
    And I open the WHP Tracking file and update the field "EngineerApptFromTime"
    And I open the WHP Tracking file and update the field "EngineerApptToTime"
    And I open the WHP Tracking file and update the field "VisitNo"
    And I open the WHP Tracking file and update the field "RepairStatus" as "<RepairStatus>"
    And I open the WHP Tracking file and update the field "RepairStatusChangeReason" as "<RepairStatusChangeReason>"
    And I click SiteMap and I enter "WHP Job Import Wizard" and click search
    And I verify Whirlpool Job Import Wizard popup loaded successfully
    And I upload the WHP Tracking file
    And I re-navigate to D&G CC Agent Portal
    And I search the claim for the Plan "<PlanNo>"
    And I Verify the claim Status in plan history section as "<ClaimStatus>"
    And I open the claim with Status "<ClaimStatus>"
    And I verify the claim status as "<ClaimStatus>"
    And I click on Repair Information tab and verify page loaded successfully
    And I Verify the Appointment Completion Status as "<AppointmentCompletionStatus>"
    And I click on "System Note" tab
    And I Verify the System note with type "Import Repair Status" added as "<RepairNotes>"

    Examples:
      | PlanNo | ClaimType |  ServiceOption                    | ServiceProvider |     ModelNumber   | Make      | RepairStatus | RepairStatusChangeReason |    ClaimStatus    | AppointmentCompletionStatus                 | RepairNotes |
      |   CRT  | Breakdown | Home Visit (Normal Working Hours) |     Indesit     | WASHER INDESIT FS | WHIRLPOOL | COMP         | Test COMP                | REPAIR COMPLETED  | Callout / Visit Complete                    | COMP/AVOI   |
      |   CRT  | Breakdown | Home Visit (Normal Working Hours) |     Indesit     | WASHER INDESIT FS | WHIRLPOOL | ABRT         | Test ABRT                | 29 JOB CANCELLED  | Claim Cancelled - Repair no longer required | CANC/ABRT   |
      |   CRT  | Breakdown | Home Visit (Normal Working Hours) |     Indesit     | WASHER INDESIT FS | WHIRLPOOL | CANC         | Test CANC                | 29 JOB CANCELLED  | Claim Cancelled - Repair no longer required | CANC/ABRT   |
      |   CRT  | Breakdown | Home Visit (Normal Working Hours) |     Indesit     | WASHER INDESIT FS | WHIRLPOOL | OUT          | Test OUT                 | 1ST OUT CARD LEFT |                                             | OUT         |
      |   CRT  | Breakdown | Home Visit (Normal Working Hours) |     Indesit     | WASHER INDESIT FS | WHIRLPOOL | AVOI         | Test AVOI                | REPAIR COMPLETED  |                                             | COMP/AVOI   |


  @SIT @UAT @WHP @ORBITNPV @SupriyaCR
  Scenario Outline: TC#05 - Verify Status changed in Orbit CC UI after importing WHPL tracking file-Write Off

    Given I click create claim and I enter plan number "<PlanNo>" to search for Plan View for "<Make>"
    Then I verify the new plan view page displayed
    When I select the Claim Type as "<ClaimType>"
    And I waive off the Excess Pay for New Plan View
    And I enter the contact info
    Then I select the WHPL model number "<ModelNumber>" from the dropdown
    And I enter the text in WHPL Fault Search box and click on search icon
    And I confirm the appliance is still in usable condition
    And I click continue with product confirmation
    When I enter the NPV QA section with below
      | QuestionNo | Question                                          | Answer | AnswerType    |
      | Q1         | Can you think of any reason to reject this claim? | No     | RadioButton   |
      | Q2         | When did the fault happen?                        | Today  | Date          |
      | Q3         | Comments Box                                      | Test   | ResponseField |
    Then I confirm the service option as "<ServiceOption>" for New Plan View
    And I enter the additional information for Service Option Message
    And I select the Available Appointment if exist and confirm appointment
    Then I verify the Booking Confirmed Page is displayed for "<ClaimType>" and "<ServiceProvider>"
    And I get the Repairer Reference no and Appointment Date
    And I click on Close Window button on Booking Overview Popup
    And I get the Customer details from the Plan View screen
    Then I click on the open claim no in the Plan History section
    And I click on the Open Claim button in the Plan View page
    And I click on Repair Information tab and verify page loaded successfully
    And I get the product purchase date
    And I open the WHP Exchange file and update the field "Customer"
    And I open the WHP Exchange file and update the field "Address"
    And I open the WHP Exchange file and update the field "Postcode"
    And I open the WHP Exchange file and update the field "Mobile Phone"
    And I open the WHP Exchange file and update the field "Current Model"
    And I open the WHP Exchange file and update the field "Purchase Date"
    And I open the WHP Exchange file and update the field "Authority Number"
    And I open the WHP Exchange file and update the field "Policy Number"
    And I open the WHP Exchange file and update the field "Exchange Type" as "<ExchangeType>"
    And I open the WHP Exchange file and update the field "Reason" as "<WriteOffReason>"
    And I open the WHP Exchange file and update the field "Email ID"
    And I click SiteMap and I enter "Whirlpool Write Off Wizard" and click search
    And I verify Whirlpool Write Off Wizard popup loaded successfully
    And I upload the WHP Exchange file
    And I re-navigate to D&G CC Agent Portal
    And I search the claim for the Plan "<PlanNo>"
    And I Verify the claim Status in plan history section as "<ClaimStatus>"
    And I open the claim with Status "<ClaimStatus>"
    And I verify the claim status as "<ClaimStatus>"
    And I click on Repair Information tab and verify page loaded successfully
    And I Verify the Appointment Completion Status as "<AppointmentCompletionStatus>"
    And I click on "System Note" tab
    And I Verify the System note with type "Estimate Notes" added as "<RepairNotes>"

    Examples:
      | PlanNo | ClaimType |  ServiceOption                    | ServiceProvider | ModelNumber  | Make      | ExchangeType |WriteOffReason |           ClaimStatus      | AppointmentCompletionStatus |       RepairNotes      |
      |   CRT  | Breakdown | Home Visit (Normal Working Hours) |     Indesit     | BIWDIL7125UK | WHIRLPOOL |    D&G FULL  |      BER      |PR - WRITE OFF SENT TO PR   |                             | UNIT WRITTEN OFF - BER |
      |   CRT  | Breakdown | Home Visit (Normal Working Hours) |     Indesit     | BIWDIL7125UK | WHIRLPOOL |    D&G FREE  |      PNLA     |PR - WRITE OFF SENT TO PR   |                             | UNIT WRITTEN OFF - PNLA|

  @SIT @UAT @WHP @ORBITNPV @OrbitRegressionPackNPV @NPV001
  Scenario Outline: TC#06 - Plan Written Off Wizard
    Given I click the PlanWriteOff Button on the Header menu
    When I verify the PlanWriteOff Page is now displayed
    Then I write off the "<PlanNo>" with the write off status as "<WriteOffStatus>" for "<OEM>"
    Then I verify the Plan has been written off Successfully

    Examples:
      | PlanNo          | WriteOffStatus         | OEM       |
#     | CREATE_NEW_PLAN | UNIT WRITTEN OFF - BER | WHIRLPOOL |
      |3BA9046213       | UNIT WRITTEN OFF - BER | WHIRLPOOL |

  @SIT @UAT @WHP @ORBITNPV @OrbitRegressionPackNPV @TC#44
  Scenario Outline: TC#07 - WHP Write off Journey - BER
    Given I create a Claim from API for "<PlanNo>" for a manufacturer "<OEM>"
#    Given I create a Claim from API for WHPL "<PlanNo>"
    When I navigate to Booking Overview Page for the Open Claim for Plan "<PlanNo>"
    And I set the fault codes in Repair Section in NPV
    Then I process the Claim to WrittenOff with the status as "<WrittenOffStatus>" and "<AdditionalStatusIfExist>" in NPV
    Then I Verify the job status for NPV "<PlanNo>" and "<AdditionalStatusIfExist>"

    Examples:
      | PlanNo | WrittenOffStatus  | AdditionalStatusIfExist            | OEM       |
#     | CRT    | WRITTEN OFF - BER | WRITTEN OFF - BER, PR - OFFER SENT | WHIRLPOOL |
      |3BA9046214| WRITTEN OFF - BER | WRITTEN OFF - BER, PR - OFFER SENT | WHIRLPOOL |
