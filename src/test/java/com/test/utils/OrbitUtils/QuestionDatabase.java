package com.test.utils.OrbitUtils;

import com.test.utils.BasePage;
import com.test.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionDatabase {

    private BasePage base;
    private WebDriver driver;
    private static SeleniumHelper seleniumHelper;

    public QuestionDatabase(BasePage base, SeleniumHelper seleniumHelper) {
        this.base = base;
        this.driver = base.getDriver();
        this.seleniumHelper = seleniumHelper;
    }

//*[@id="icqQuestion"][contains(.,'Please select whether your appliance')]


    public void category1Questionaire(String question, String ref){
        HashMap<String, Map<String,Map<String,String>>> questions = new HashMap<>();
        //questions.put("Are you reporting a gas leak, can smell gas or suspect carbon monoxide is present?",Map.of("M1",Map.of("RADIOBUTTON","No")));
        //questions.put("Are you reporting a gas leak, can smell gas or suspect carbon monoxide is present?",Map.of("M2",Map.of("RADIOBUTTON","Yes")));
        //questions.put("Are you reporting a gas leak, can smell gas or suspect carbon monoxide is present?",Map.of("RADIOBUTTON","No"));
        //questions.put("What is the problem being experienced?", Map.of("RADIOBUTTON","Uncontrollable Water Leak"));
        //questions.put("Where is the location of the uncontrollable leak?", Map.of("RADIOBUTTON","Heating Boiler"));
        //questions.put("When did the problem occur?", Map.of("DATE",seleniumHelper.getCurrentDate().substring(0,2)));
        //questions.put("Is there any additional detail you can provide relating to the problem being experienced?", Map.of("MULTI","Yes"));
        //questions.put("Is there any health or wellbeing reason we need to be made aware of when booking this appointment?", Map.of("RADIOBUTTON","No"));

        for (String i : questions.keySet()) {
            if( i.contains(question)) {
                System.out.println("Question: " + i + " Type: " + questions.get(i).keySet().toString() + " Answer: " + questions.get(i).values().toString());
            }
        }
    }

    public void category1Questionaire1(String question, String ref){
        List<QaCategory> qaList = new ArrayList<>();
        qaList.add(new QaCategory("M1", "When did your product stop working?", "DATE", seleniumHelper.getCurrentDate().substring(0,2)));
        qaList.add(new QaCategory("M1", "Is there any detail the engineer should be aware of prior to or on the appointment date?", "RESPONSE", "Yes"));
        qaList.add(new QaCategory("M1/M4/M5/M6", "Are you reporting a gas leak, can smell gas or suspect carbon monoxide is present?", "RADIOBUTTON", "No"));
        qaList.add(new QaCategory("M2/M3", "Are you reporting a gas leak, can smell gas or suspect carbon monoxide is present?", "RADIOBUTTON", "Yes"));

//        qaList.stream().forEach(qa->);
    }

    private static void quesionAndAnswers(String ques) {
        HashMap<String, Map<String,String>> questions = new HashMap<String, Map<String,String>>();
//        questions.put("When did your product stop working?",Map.of("DATE",seleniumHelper.getCurrentDate().substring(0,2)));
//        questions.put("Is there any detail the engineer should be aware of prior to or on the appointment date?", Map.of("RESPONSE","Yes"));
//        questions.put("Is there any reason you can think of to reject this claim?", "No");
//        questions.put("Please ask the customer for a detailed description of the fault.", "Test");
//        questions.put("When did the breakdown occur?", seleniumHelper.getCurrentDate().substring(0,2));
//        questions.put(" What is the problem being experienced?", "Microphone Fault");

        for (String i : questions.keySet()) {
            if( i.contains(ques)) {
                System.out.println("Question: " + i + " Type: " + questions.get(i).keySet() + " Answer: " + questions.get(i).values());
            }
        }
    }

    public void getData(String Qa){

        quesionAndAnswers(Qa);
    }

    public void getData1(String Qa, String ref){

        category1Questionaire(Qa,ref);
    }
}