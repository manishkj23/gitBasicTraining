package com.test.steps;

import com.test.pages.CCAgentUI_NPV.CCAgentUI_CCV.PlanWriteOff;
import com.test.pages.CCAgentUI_NPV.HomePageNPV;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WriteOffStepDef {
    private static final Logger LOGGER = LoggerFactory.getLogger(WriteOffStepDef.class);

    public WriteOffStepDef(PlanWriteOff planWriteOff) {

        this.planWriteOff = planWriteOff;
    }

    PlanWriteOff planWriteOff;



}