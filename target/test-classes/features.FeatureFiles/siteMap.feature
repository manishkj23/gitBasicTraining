##====================================================
## ORBIT REGRESSION PACK
##====================================================
Feature: Automation Pack for Orbit - Site Map

  Background: User to Login
    Given I navigate to D&G CC Agent Portal
    When I enter username and password and click Login
    Then I verify the Login is successful

  Scenario Outline: TC#02 - Verify Reassign SP, Deemed Done, Cancel buttons and all other buttons, radio button are present and enabled
    Given I click SiteMap and I enter "<SearchValue>" and click search
    And I verify ASV-LSC dashboard page loaded successfully
    Then I verify all buttons are present and enabled
    Then I verify Date Booked Radio button and MTD auto select or not
    Then I verify Reassign SP DeemedDone Cancel buttons are available
    Examples:
      |SearchValue|
      |ASV   |

  Scenario Outline: TC#03 - Verify two new columns added in the ASV Dashboard as part of SRV 2649
    Given I click SiteMap and I enter "<SearchValue>" and click search
    And I verify ASV-LSC dashboard page loaded successfully
    Then I verify new column added successfully
    Examples:
      |SearchValue|
      |ASV        |

  Scenario Outline: TC#04 - Verify Inflight Repair Report added in D&G Custom Report
    Given I click SiteMap and I enter "<SearchValue>" and click search
    Then I verify D&G Custom Report pop up displayed successfully
    Then I verify Report Type field and dropdown is available
    And I click on Report Type dropdown and verify "<DropdownValue>" is present

    Examples:
      |SearchValue      | DropdownValue           |
      |D&G Custom Report| Inflight Repair Request |

    #======================================== R39 Release scenarios ===============================================
  #===================== SRV-13266 - WB Integration - Prevent claims without appointment being booked===============

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
      | Q2         | What is the problem being experienced?                                                             | Uncontrollable water leak | RadioButton |             |
      | Q3         | Where is the location of the uncontrollable leak?                                                  | Heating Boiler            | RadioButton |             |
      | Q4         | When did the problem occur?                                                                        | Today                     | Date        |             |
      | Q5         | Is there any additional detail you can provide relating to the problem being experienced?          | No                        | RadioButton |             |
      | Q6         | Is there any health or wellbeing reason we need to be made aware of when booking this appointment? | No                        | RadioButton | Q7          |
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


  Scenario Outline: TC#01 - Verify Model and Fault selected from the dropdown for WB in Product confirmation section
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    When I verify the new plan view page displayed
    And I select the Claim Type as "<ClaimType>"
    And I waive off the Excess Pay for New Plan View
    And I enter the contact info for OEM plan
    Then I select the WB "<Model>" & "<Fault>" from the dropdown and click Continue
    When I enter the NPV QA section with below
      | QuestionNo | Question                                                                                           | Answer                   | AnswerType  | SubQuestion |
      | Q1         | Are you reporting a gas leak, can smell gas or suspect carbon monoxide is present?                 | No                       | RadioButton |             |
      | Q2         | Please confirm the type of issue                                                                   | Possible carbon monoxide | RadioButton |             |
      | Q2         | What is the problem being experienced?                                                             | Other problem            | RadioButton | No heating  |
      | Q3         | When did the problem occur?                                                                        | Today                    | Date        |             |
      | Q4         | Is there any additional detail you can provide relating to the problem being experienced?          | No                       | RadioButton |             |
      | Q5         | Is there any health or wellbeing reason we need to be made aware of when booking this appointment? | No                       | RadioButton | Q7          |
    Then I confirm the service option as "<ServiceOption>" for NPV

    Examples:
      | PlanNo     | ClaimType                     | Model                                  | Fault                | ServiceOption                     |
      | HL60004330 | Breakdown (Boiler & Controls) | GREENSTAR 40CDI CONVENTIONAL FSN-GB NG | There is an oil leak | Home Visit (Normal Working Hours) |

  Scenario Outline: TC#01 - Click on Booking Incomplete button for WB
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    When I verify the new plan view page displayed
    Then I click on Booking Incomplete button
    Then I confirm the service option as "<ServiceOption>" for NPV
    Then I click on the WB no availability pop up
    And I enter the additional information for Service Option Message
    Then I click on Confirm Option Details button and verify the pop up

    Examples:
      | PlanNo     | SearchValue       | CompanyName     |  | ServiceOption                     |  |
      | HL60004330 | Service Providers | WORCESTER BOSCH |  | Home Visit (Normal Working Hours) |  |


#================================ SRV-10472 - Dynamic Refresh Upgrade ==============================================

  Scenario Outline: TC#02 - Verify error message displayed and once selected the Dashboard from the dropdown, error message disappear
    Given I click SiteMap and I enter "<SearchValue>" and click on the Dashboard wizard
    And I verify Dashboard Filter Group page loaded successfully
    Then I click on Insert button in Dashboard Filter group
    And I click on Save button in Insert Dashboard Filter Group form
    Then I verify error message appear after I click on Save button
    Then I select the option from Dashboards dropdown
    And I verify error message disappear
    Examples:
      | SearchValue      |
      | Dashboard Filter |

#================================ SRV-13348-Capture correct billing address for WorldPay calls ==============================================



  Scenario Outline: HC001 - Billing address Pop up display for NPV with Excess -  Electrolux
    Given I click create claim and I enter plan number "<PlanNo>" and click search
    Then I verify the new plan view page displayed
    When I select the Claim Type as "Breakdown"
    And I continue for Excess Pay for New Plan View
    And I enter the contact info for OEM plan
#    When I enter the PNC Details and fault data and click continue
    When I enter the PNC Details Fault "<FaultArea>"and "<Fault>" fault data and click continue
    When I enter the QA section with below
      | QuestionNo | Question                                                         | Answer | AnswerType    |
      | Q1         | Is there any reason you can think of to reject this claim?       | No     | RadioButton   |
#      | Q2         | When did your product stop working?                              | Today  | Date          |
#      | Q3         | Please ask the customer for a detailed description of the fault. | Test   | ResponseField |

    Then I confirm the ExcessPayment for New Plan View
    Then I confirm the service option as "<ServiceOption>" for NPV
#    Then I verify the Billing Details pop up displayed
#    And I select the email address radio button as NO in the email address section
#    And I enter the correct email address with "<emailAddress>"
#    Then I select the Billing address radio button as YES in the Billing address section
#    And I verify the address details and enter the address details if not present
#    Then I process the Excess Payment verify the Excess Amount is Paid for NPV

    Examples:
      | PlanNo     | ClaimType | PNC Number | ServiceOption                     | Status                           | ServiceProvider       | FaultArea   | Fault      |  |
      | C1Z0121545 | Breakdown | 948904188  | Home Visit (Normal Working Hours) | Out Card Left - Engineer Delayed | FLYINGTOOLBOX RESPOND | DOOR - Door | Door stuck |  |

 #================================ ORB-112-Access Level Manager ==============================================

  Scenario Outline: TC#03 - Verify new group heading "Access Level Manager" present in Site Map as part of ORB-112
    Given I click SiteMap and I enter "<SearchValue>" and click search and click wizard
    And I verify Access Level Manager board loaded successfully
    And I verify Access Level Manager table present in the grid
    And I verify Edit and Insert buttons are present
    Then I click on Access Level Manager Insert button
    And I verify Insert D&G Access Level pop up displayed
    Then I verify access level dropdown present in the pop up

    Examples:
      | SearchValue              |
      | D&G Access Level Manager |


  #================================ ORB-1079 - Variable PR Offer links ==============================================

  Scenario Outline: TC#04 - Verify new fields added in D&G Client Group in Site Map as part of ORB-1079
    Given I click SiteMap and I enter "<SearchValue>" and click search and click wizard
    And I verify D&G Client Group header loaded successfully
    And I verify D&G Client Group table present in the grid
    And I verify Edit and Insert buttons are present in D&G Client Group table
    Then I click on D&G Client Group Insert button
    And I verify D&G Client Group pop up displayed
    Then I verify new fields are present in the pop up

    Examples:
      | SearchValue       |
      | D&G Client Groups |