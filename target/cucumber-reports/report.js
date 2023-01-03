$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features.FeatureFiles/InflightCustomerInteractionHistory.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "##\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d"
    },
    {
      "line": 2,
      "value": "## ORBIT REGRESSION PACK NEW PLAN VIEW - UAT"
    },
    {
      "line": 3,
      "value": "##\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d"
    }
  ],
  "line": 4,
  "name": "Automation for Orbit Regression Pack : NPV - Inflight Repair Workflow - SRV-11318 Inflight Repair Contact View - Customer Interaction History",
  "description": "",
  "id": "automation-for-orbit-regression-pack-:-npv---inflight-repair-workflow---srv-11318-inflight-repair-contact-view---customer-interaction-history",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 11,
  "name": "TC#01 - Verify Customer Interaction History with Vulnerabilities - No",
  "description": "",
  "id": "automation-for-orbit-regression-pack-:-npv---inflight-repair-workflow---srv-11318-inflight-repair-contact-view---customer-interaction-history;tc#01---verify-customer-interaction-history-with-vulnerabilities---no",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 12,
  "name": "I search the claim for the Plan \"\u003cPlanNo\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "I click the recent Claim number on plan history section",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "I verify the Inflight Repair Summary screen launch",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "I verify the Customer Interaction History section launch",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "I verify RA Data Agent Input and Open Claim button displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "I click on the Inflight Repair Workflow link to verify the Interaction History",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "I verify the Workflow Details have Started,Finished,Duration labels and matches the duration value",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "I verify all the labels are present under RA Data",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "I verify review claim page open in new tab after clicking on Open claim button",
  "keyword": "Then "
});
formatter.examples({
  "line": 22,
  "name": "",
  "description": "",
  "id": "automation-for-orbit-regression-pack-:-npv---inflight-repair-workflow---srv-11318-inflight-repair-contact-view---customer-interaction-history;tc#01---verify-customer-interaction-history-with-vulnerabilities---no;",
  "rows": [
    {
      "cells": [
        "PlanNo",
        "ClaimType",
        "ModelNumber"
      ],
      "line": 23,
      "id": "automation-for-orbit-regression-pack-:-npv---inflight-repair-workflow---srv-11318-inflight-repair-contact-view---customer-interaction-history;tc#01---verify-customer-interaction-history-with-vulnerabilities---no;;1"
    },
    {
      "cells": [
        "BH20052675",
        "Breakdown",
        "Television"
      ],
      "line": 24,
      "id": "automation-for-orbit-regression-pack-:-npv---inflight-repair-workflow---srv-11318-inflight-repair-contact-view---customer-interaction-history;tc#01---verify-customer-interaction-history-with-vulnerabilities---no;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 6,
  "name": "User to Login",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "I navigate to D\u0026G CC Agent Portal",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I enter username and password and click Login for New Plan View",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I verify the Login is successful",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDef.iNavigateToDGCCAgentPortal()"
});
formatter.result({
  "duration": 14075783400,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDef.iEnterUsernameAndPasswordAndClickLoginNPV()"
});
formatter.result({
  "duration": 31102292300,
  "error_message": "java.lang.AssertionError: Timeout waiting for Page Load Request to complete.\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat com.test.utils.SeleniumHelper.waitForPageLoaded(SeleniumHelper.java:140)\r\n\tat com.test.steps.LoginStepDef.iEnterUsernameAndPasswordAndClickLoginNPV(LoginStepDef.java:91)\r\n\tat ✽.When I enter username and password and click Login for New Plan View(src/test/resources/features.FeatureFiles/InflightCustomerInteractionHistory.feature:8)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "OrbitHomePageStepDef.iVerifyTheLoginIsSuccessful()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 24,
  "name": "TC#01 - Verify Customer Interaction History with Vulnerabilities - No",
  "description": "",
  "id": "automation-for-orbit-regression-pack-:-npv---inflight-repair-workflow---srv-11318-inflight-repair-contact-view---customer-interaction-history;tc#01---verify-customer-interaction-history-with-vulnerabilities---no;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 12,
  "name": "I search the claim for the Plan \"BH20052675\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "I click the recent Claim number on plan history section",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "I verify the Inflight Repair Summary screen launch",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "I verify the Customer Interaction History section launch",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "I verify RA Data Agent Input and Open Claim button displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "I click on the Inflight Repair Workflow link to verify the Interaction History",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "I verify the Workflow Details have Started,Finished,Duration labels and matches the duration value",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "I verify all the labels are present under RA Data",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "I verify review claim page open in new tab after clicking on Open claim button",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "BH20052675",
      "offset": 33
    }
  ],
  "location": "OrbitHomePageStepDef.iSearchTheClaimForThePlan(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "NPVHomePageStepDef.i_click_the_recent_claim_number_on_plan_history_section()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "NPVHomePageStepDef.i_verify_the_inflight_repair_summary_screen_launch()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "NPVHomePageStepDef.i_verify_the_customer_interaction_history_section_launch()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "NPVHomePageStepDef.i_verify_ra_data_agent_input_and_open_claim_button_displayed()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "NPVHomePageStepDef.i_click_on_the_inflight_repair_workflow_link_to_verify_the_interaction_history()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "NPVHomePageStepDef.i_verify_the_workflow_details_have_startedfinishedduration_fields()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "NPVHomePageStepDef.i_verify_all_the_labels_are_present_under_ra_data()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "NPVHomePageStepDef.i_verify_review_claim_page_open_in_new_tab_after_clicking_on_open_claim_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenarioOutline({
  "line": 26,
  "name": "TC#02 - Verify Toolbox displayed in Inflight Repair Summary screen.",
  "description": "",
  "id": "automation-for-orbit-regression-pack-:-npv---inflight-repair-workflow---srv-11318-inflight-repair-contact-view---customer-interaction-history;tc#02---verify-toolbox-displayed-in-inflight-repair-summary-screen.",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 27,
  "name": "I search the claim for the Plan \"\u003cPlanNo\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "I click the recent Claim number on plan history section",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "I verify the Inflight Repair Summary screen launch",
  "keyword": "Then "
});
formatter.step({
  "line": 30,
  "name": "I verify the Customer Interaction History section launch",
  "keyword": "And "
});
formatter.step({
  "line": 31,
  "name": "I verify RA Data Agent Input and Open Claim button displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "I click on the Inflight Repair Workflow link to verify the Interaction History",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "I verify the Workflow Details have Started,Finished,Duration labels and matches the duration value",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "I verify all the labels are present under RA Data",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "I verify review claim page open in new tab after clicking on Open claim button",
  "keyword": "Then "
});
formatter.examples({
  "line": 37,
  "name": "",
  "description": "",
  "id": "automation-for-orbit-regression-pack-:-npv---inflight-repair-workflow---srv-11318-inflight-repair-contact-view---customer-interaction-history;tc#02---verify-toolbox-displayed-in-inflight-repair-summary-screen.;",
  "rows": [
    {
      "cells": [
        "PlanNo",
        "ClaimType",
        "ModelNumber"
      ],
      "line": 38,
      "id": "automation-for-orbit-regression-pack-:-npv---inflight-repair-workflow---srv-11318-inflight-repair-contact-view---customer-interaction-history;tc#02---verify-toolbox-displayed-in-inflight-repair-summary-screen.;;1"
    },
    {
      "cells": [
        "BH20052675",
        "Breakdown",
        "Television"
      ],
      "line": 39,
      "id": "automation-for-orbit-regression-pack-:-npv---inflight-repair-workflow---srv-11318-inflight-repair-contact-view---customer-interaction-history;tc#02---verify-toolbox-displayed-in-inflight-repair-summary-screen.;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 6,
  "name": "User to Login",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "I navigate to D\u0026G CC Agent Portal",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I enter username and password and click Login for New Plan View",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I verify the Login is successful",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDef.iNavigateToDGCCAgentPortal()"
});
formatter.result({
  "duration": 7740037400,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDef.iEnterUsernameAndPasswordAndClickLoginNPV()"
});
formatter.result({
  "duration": 31077513500,
  "status": "passed"
});
formatter.match({
  "location": "OrbitHomePageStepDef.iVerifyTheLoginIsSuccessful()"
});
formatter.result({
  "duration": 3175003400,
  "status": "passed"
});
formatter.scenario({
  "line": 39,
  "name": "TC#02 - Verify Toolbox displayed in Inflight Repair Summary screen.",
  "description": "",
  "id": "automation-for-orbit-regression-pack-:-npv---inflight-repair-workflow---srv-11318-inflight-repair-contact-view---customer-interaction-history;tc#02---verify-toolbox-displayed-in-inflight-repair-summary-screen.;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 27,
  "name": "I search the claim for the Plan \"BH20052675\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "I click the recent Claim number on plan history section",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "I verify the Inflight Repair Summary screen launch",
  "keyword": "Then "
});
formatter.step({
  "line": 30,
  "name": "I verify the Customer Interaction History section launch",
  "keyword": "And "
});
formatter.step({
  "line": 31,
  "name": "I verify RA Data Agent Input and Open Claim button displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "I click on the Inflight Repair Workflow link to verify the Interaction History",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "I verify the Workflow Details have Started,Finished,Duration labels and matches the duration value",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "I verify all the labels are present under RA Data",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "I verify review claim page open in new tab after clicking on Open claim button",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "BH20052675",
      "offset": 33
    }
  ],
  "location": "OrbitHomePageStepDef.iSearchTheClaimForThePlan(String)"
});
formatter.result({
  "duration": 95414413600,
  "status": "passed"
});
formatter.match({
  "location": "NPVHomePageStepDef.i_click_the_recent_claim_number_on_plan_history_section()"
});
formatter.result({
  "duration": 6892814600,
  "status": "passed"
});
formatter.match({
  "location": "NPVHomePageStepDef.i_verify_the_inflight_repair_summary_screen_launch()"
});
formatter.result({
  "duration": 3008785200,
  "status": "passed"
});
formatter.match({
  "location": "NPVHomePageStepDef.i_verify_the_customer_interaction_history_section_launch()"
});
formatter.result({
  "duration": 4126319100,
  "status": "passed"
});
formatter.match({
  "location": "NPVHomePageStepDef.i_verify_ra_data_agent_input_and_open_claim_button_displayed()"
});
formatter.result({
  "duration": 10915240400,
  "status": "passed"
});
formatter.match({
  "location": "NPVHomePageStepDef.i_click_on_the_inflight_repair_workflow_link_to_verify_the_interaction_history()"
});
formatter.result({
  "duration": 6143117300,
  "status": "passed"
});
formatter.match({
  "location": "NPVHomePageStepDef.i_verify_the_workflow_details_have_startedfinishedduration_fields()"
});
formatter.result({
  "duration": 18253491800,
  "status": "passed"
});
formatter.match({
  "location": "NPVHomePageStepDef.i_verify_all_the_labels_are_present_under_ra_data()"
});
formatter.result({
  "duration": 5838105800,
  "status": "passed"
});
formatter.match({
  "location": "NPVHomePageStepDef.i_verify_review_claim_page_open_in_new_tab_after_clicking_on_open_claim_button()"
});
formatter.result({
  "duration": 8317290100,
  "status": "passed"
});
});