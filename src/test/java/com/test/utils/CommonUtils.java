package com.test.utils;

import com.jayway.jsonpath.JsonPath;
import com.test.utils.OrbitUtils.GetContractDetails.GCDTemplate;
import com.test.utils.OrbitUtils.GetPlanDetails.GPDTemplate;
import com.test.utils.OrbitUtils.IMEI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.config.XmlConfig.xmlConfig;


public class CommonUtils {

    private BasePage base;
    private SeleniumHelper seleniumHelper;
    private WebDriver driver;

    //    private final static String ESBCREATECONTRACT_ENDPOINT = "https://uatws.domesticandgeneral.com";
    private final static String ESBCREATECONTRACT_ENDPOINT = "https://uatwebsvcs.domesticandgeneral.com"; //LEGACY ENDPOINT
    public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    public CommonUtils(BasePage base, SeleniumHelper seleniumHelper) {
        this.base = base;
        this.seleniumHelper = seleniumHelper;
        this.driver = base.getDriver();
    }

    public String getScorecardRefValue(String ref) {
        String refCat[] = ref.split(" ", 2);
        return refCat[0].toString();
    }


    public String createContractApiCallForElux() throws Exception {

//        String filePath = "/src/test/resources/TestDatafile/CreateContract_6YV.xml";
        String filePath = "/src/test/resources/TestDatafile/CreateContract_C1Z.xml";
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + filePath);
        RestAssured.baseURI = ESBCREATECONTRACT_ENDPOINT;

        Response response = given()
                .header("Content-Type", "text/xml")
                .header("Authorization", "Bearer " + base.prop.getProperty("ESBCREATECONTRACTTOKEN"))
                .config(RestAssured.config().xmlConfig(xmlConfig().with().namespaceAware(true)))
                .and()
                .body(IOUtils.toString(fs, "UTF-8"))
                .when()
                .post("/EMEA/contractServicesWeb/2/createContractService")
                .then()
                .statusCode(200)
                .and()
                .log().all()
                .extract().response();

        return seleniumHelper.searchStringRegex("<SchemeCode>(.*?)<\\/SchemeCode>", response.asString()) + seleniumHelper.searchStringRegex("<Reference>(.*?)<\\/Reference>", response.asString());
    }

    public String createContractApiCallForEluxWithPNC() throws Exception {

        String filePath = "/src/test/resources/TestDatafile/CreateContract_C1Z_withPNCNumber.xml";
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + filePath);
        RestAssured.baseURI = ESBCREATECONTRACT_ENDPOINT;

        Response response = given()
                .header("Content-Type", "text/xml")
                .header("Authorization", "Bearer " + base.prop.getProperty("ESBCREATECONTRACTTOKEN"))
                .config(RestAssured.config().xmlConfig(xmlConfig().with().namespaceAware(true)))
                .and()
                .body(IOUtils.toString(fs, "UTF-8"))
                .when()
                .post("/EMEA/contractServicesWeb/2/createContractService")
                .then()
                .statusCode(200)
                .and()
//                .log().all()
                .extract().response();

        return seleniumHelper.searchStringRegex("<SchemeCode>(.*?)<\\/SchemeCode>", response.asString()) + seleniumHelper.searchStringRegex("<Reference>(.*?)<\\/Reference>", response.asString());
    }

    public String createContractApiCallForWhirlpool() throws Exception {

        String filePath = "/src/test/resources/TestDatafile/CreateContract_3BA.xml";
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + filePath);
        RestAssured.baseURI = ESBCREATECONTRACT_ENDPOINT;

        Response response = given()
                .header("Content-Type", "text/xml")
                .header("Authorization", "Bearer " + base.prop.getProperty("ESBCREATECONTRACTTOKEN"))
                .config(RestAssured.config().xmlConfig(xmlConfig().with().namespaceAware(true)))
                .and()
                .body(IOUtils.toString(fs, "UTF-8"))
                .when()
                .post("/APAC/contractServicesWeb/2/createContractService")
                .then()
                .statusCode(200)
                .and()
//                .log().all()
                .extract().response();

        return seleniumHelper.searchStringRegex("<SchemeCode>(.*?)<\\/SchemeCode>", response.asString()) + seleniumHelper.searchStringRegex("<Reference>(.*?)<\\/Reference>", response.asString());
    }

    public String createContractFromSchemeCode(String schemeCode) throws Exception {

        String filePath = "/src/test/resources/TestDatafile/CreateContract_" + schemeCode + ".xml";
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + filePath);
        RestAssured.baseURI = ESBCREATECONTRACT_ENDPOINT;

        Response response = given()
                .header("Content-Type", "text/xml")
                .header("Authorization", "Bearer " + base.prop.getProperty("ESBCREATECONTRACTTOKEN"))
                .config(RestAssured.config().xmlConfig(xmlConfig().with().namespaceAware(true)))
                .and()
                .body(IOUtils.toString(fs, "UTF-8"))
                .when()
                .post("/APAC/contractServicesWeb/2/createContractService")
                .then()
                .statusCode(200)
                .and()
//                .log().all()
                .extract().response();

        return seleniumHelper.searchStringRegex("<SchemeCode>(.*?)<\\/SchemeCode>", response.asString()) + seleniumHelper.searchStringRegex("<Reference>(.*?)<\\/Reference>", response.asString());
    }


    public String getOpenClaimNo(String planNo) throws Exception {
        String claimNo = null;
        try {
            RestAssured.baseURI = base.prop.getProperty("salmonAPIURL");

            Response response = given()
                    .relaxedHTTPSValidation()
//                .header("Content-Type", "text/json")
                    .auth()
                    .preemptive()
                    .basic(base.prop.getProperty("SALMONUSER"), base.prop.getProperty("SALMONPASSWORD"))
                    .and()
                    .when()
                    .get("/" + "?t=GetAllClaims&PolicyNumber=" + planNo + "&Source=&CountryCode=&LanguageID=&Channel=&Client=")
                    .then()
                    .statusCode(200)
                    .and()
//                    .log().all()
                    .extract().response();


//            claimNo = JsonPath.parse(response.body().asString()).read("$..PolicyData."+planNo+".ClaimNumber").toString();//.replaceAll("\\D+", "")
            String claimStatus = JsonPath.parse(response.body().asString()).read("$..PolicyData." + planNo + ".ClaimStatus").toString();
            if (claimStatus.toLowerCase().contains("incomplete") || claimStatus.toLowerCase().contains("in progress")
                    || claimStatus.toLowerCase().contains("accepted")
                    || claimStatus.toLowerCase().contains("created")) {
                claimNo = JsonPath.parse(response.body().asString()).read("$..PolicyData." + planNo + ".ClaimNumber").toString().replaceAll("\\D+", "");
            } else {
                claimNo = JsonPath.parse(response.body().asString()).read("$..PolicyData." + planNo + ".ClaimNumber").toString().replaceAll("\\D+", "");
                if (claimNo.isEmpty()) {
                    claimNo = JsonPath.parse(response.body().asString()).read("$..RepairHistory[0]..ClaimNumber").toString().replaceAll("\\D+", "");
                }
            }
            LOGGER.info("==============>>>>>> Current Claim Number :" + claimNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claimNo;
    }

    public boolean cancelAnOpenClaim(String planNo) throws Exception {
        boolean status = false;
        String claimNo = getOpenClaimNo(planNo);
        RestAssured.baseURI = base.prop.getProperty("salmonAPIURL");
        JSONObject requestParams = new JSONObject();

        try {
            if (!claimNo.isEmpty()) {
                requestParams.put("ClaimNumber", claimNo);
                requestParams.put("PolicyNumber", planNo);
                requestParams.put("ClaimCancellationReason", "TEST CLAIMS");
                requestParams.put("Source", "");
                requestParams.put("CountryCode", "GB");
                requestParams.put("LanguageID", "");
                requestParams.put("Channel", "");
                requestParams.put("Client", "");

                Response response = given()
                        .request().body(requestParams)
                        .relaxedHTTPSValidation()
//                .header("Content-Type", "text/json")
                        .auth()
                        .preemptive()
                        .basic(base.prop.getProperty("SALMONUSER"), base.prop.getProperty("SALMONPASSWORD"))
                        .and()
                        .when()
                        .put("/" + "ClaimsAPI/?t=PutClaimCancellation")
                        .then()
//                    .statusCode(200)
                        .and()
                        .log().all()
                        .extract().response();
                if (JsonPath.parse(response.body().asString()).read("$..ResponseDescription").toString().replaceAll("[^a-zA-Z0-9]", "").contains("Success")) {
                    status = true;
                    LOGGER.info("=======>>>>>>> Claim No :" + claimNo + " canceled successfully");
                }
            } else {
//                status = true;
                status = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;

    }

    public void setClipboardContentAndPasteDateToElement(String data, WebElement element) {
        try {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable transferable = new StringSelection(data);
            clipboard.setContents(transferable, null);
            seleniumHelper.actionToPasteData(element);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getClipboardContentToString() {
        String value = null;
        try {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            value = (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public void createPersonAPI() {
        String endpoint = "https://uat02in-dgsvcs.domgen.corp/EMEA/personServicesWeb/2/createPersonService";
        try {
            String filePath = "/src/test/resources/TestDatafile/createPerson.xml";
            FileInputStream fs = null;

            fs = new FileInputStream(System.getProperty("user.dir") + filePath);

            RestAssured.baseURI = "https://uat02in-dgsvcs.domgen.corp";
            RestAssured.useRelaxedHTTPSValidation();
            Response response = given()
                    .header("Content-Type", "text/xml")
                    .config(RestAssured.config().xmlConfig(xmlConfig().with().namespaceAware(true)))
                    .and()
                    .body(IOUtils.toString(fs, "UTF-8"))
                    .when()
                    .post("/EMEA/personServicesWeb/2/createPersonService")
                    .then()
                    .statusCode(200)
                    .and()
                    .log().all()
                    .extract().response();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public IMEI getRandomIMEI(String Manufacturer) throws Exception {
        String make = null;
        IMEI getIMEI = new IMEI();
        Response response = null;
        boolean isMakeFound = false;

        try {
            for (int i = 0; !isMakeFound == true; i++) {

//                RestAssured.baseURI = "https://randommer.io";

                response = RestAssured.given()
                        .relaxedHTTPSValidation()
                        .header("Content-Type", "text/json")
                        .and()
                        .when()
                        .post("https://randommer.io/imei-generator")
                        .then()
                        .statusCode(200)
                        .and()
//                    .log().all()
                        .extract().response();

                make = JsonPath.parse(response.body().asString()).read("$.brand");
                if (make.equalsIgnoreCase(Manufacturer)) {
                    isMakeFound = true;
                }
            }
            getIMEI.MAKE = JsonPath.parse(response.body().asString()).read("$.brand");
            getIMEI.MODEL = JsonPath.parse(response.body().asString()).read("$.model");
            getIMEI.IMEI = JsonPath.parse(response.body().asString()).read("$.imei");
//            LOGGER.info("==============>>>>>> Current Claim Number :" + claimNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getIMEI;
    }

    public String createContractApiCallForASV() throws Exception {

        String filePath = "/src/test/resources/TestDatafile/CreateContract_HQP_Heating.xml";
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + filePath);
        RestAssured.baseURI = ESBCREATECONTRACT_ENDPOINT;

        Response response = given()
                .header("Content-Type", "text/xml")
                .header("Authorization", "Bearer " + base.prop.getProperty("ESBCREATECONTRACTTOKEN"))
                .config(RestAssured.config().xmlConfig(xmlConfig().with().namespaceAware(true)))
                .and()
                .body(IOUtils.toString(fs, "UTF-8"))
                .when()
                .post("/EMEA/contractServicesWeb/2/createContractService")
                .then()
                .statusCode(200)
                .and()
//                .log().all()
                .extract().response();

        return seleniumHelper.searchStringRegex("<SchemeCode>(.*?)<\\/SchemeCode>", response.asString()) + seleniumHelper.searchStringRegex("<Reference>(.*?)<\\/Reference>", response.asString());
    }

    public String createClaimFromAPI(String planNo, String surname, String postCode, String claimTypeID, String manufacturer) throws Exception {
        String verificationID = null;
        String claimNo = null;
        JSONObject requestParams = new JSONObject();

        requestParams.put("PlanNumber", planNo);
        requestParams.put("CustomerSurname", surname);
        requestParams.put("CustomerPostcode", postCode);

        try {
            RestAssured.baseURI = "https://www.skylinecms.co.uk/domgenprelive/RestAPI";
            Response response = given()
                    .relaxedHTTPSValidation()
                    .header("SYNERGYTOKEN", "7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                    .request().body(requestParams)
                    .put("/BookClaim/?m=VerifyClaim")
                    .then()
                    .statusCode(200)
                    .and()
                    .log().all()
                    .extract().response();


            verificationID = JsonPath.parse(response.body().asString()).read("$.VerificationID").toString();
            JSONObject requestParams2 = new JSONObject();
            RestAssured.baseURI = "https://www.skylinecms.co.uk/domgenprelive/RestAPI";
            requestParams2.put("VerificationID", verificationID);
            requestParams2.put("PlanNumber", planNo);
            requestParams2.put("ReportedFault", "This is the reported fault, it is very broken");
            requestParams2.put("ClaimTypeID", claimTypeID);
//            requestParams2.put("Manufacturer", "");
            requestParams2.put("DGAgentNo", "73051001");
            requestParams2.put("ManualRef", "23WCAH");
            requestParams2.put("ServiceOption", "HomeRepair");
            requestParams2.put("AppointmentDate", seleniumHelper.getCurrentDate("yyyy-MM-dd"));
            requestParams2.put("SCJobNo", "373814");
            Response response2 = given()
                    .relaxedHTTPSValidation()
                    .header("SYNERGYTOKEN", "7a6e56ab9a69abbfb99e221d19731b2984fcef12cce95eb15cffe4338ecf5d29")
                    .request().body(requestParams2)
                    .put("/BookClaim/?m=SendClaim")
                    .then()
                    .statusCode(200)
                    .and()
                    .log().all()
                    .extract().response();
            claimNo = JsonPath.parse(response2.body().asString()).read("$.SLNumber").toString();
            LOGGER.info("==============>>>>>> Current Claim Number :" + claimNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claimNo;
    }

    public String createContractApiCallForHoover() throws Exception {

        String filePath = "/src/test/resources/TestDatafile/CreateContract_BH2.xml";
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + filePath);
        RestAssured.baseURI = ESBCREATECONTRACT_ENDPOINT;

        Response response = given()
                .header("Content-Type", "text/xml")
                .header("Authorization", "Bearer " + base.prop.getProperty("ESBCREATECONTRACTTOKEN"))
                .config(RestAssured.config().xmlConfig(xmlConfig().with().namespaceAware(true)))
                .and()
                .body(IOUtils.toString(fs, "UTF-8"))
                .when()
                .post("/EMEA/contractServicesWeb/2/createContractService")
                .then()
                .statusCode(200)
                .and()
//                .log().all()
                .extract().response();

        return seleniumHelper.searchStringRegex("<SchemeCode>(.*?)<\\/SchemeCode>", response.asString()) + seleniumHelper.searchStringRegex("<Reference>(.*?)<\\/Reference>", response.asString());
    }

    public boolean cancelAnOpenClaimWithClaimNo(String planNo, String claimNo) throws Exception {
        boolean status = false;
        RestAssured.baseURI = base.prop.getProperty("salmonAPIURL");
        JSONObject requestParams = new JSONObject();

        try {
            if (!claimNo.isEmpty()) {
                requestParams.put("ClaimNumber", claimNo);
                requestParams.put("PolicyNumber", planNo);
                requestParams.put("ClaimCancellationReason", "TEST CLAIMS");
                requestParams.put("Source", "");
                requestParams.put("CountryCode", "GB");
                requestParams.put("LanguageID", "");
                requestParams.put("Channel", "");
                requestParams.put("Client", "");

                Response response = given()
                        .request().body(requestParams)
                        .relaxedHTTPSValidation()
//                .header("Content-Type", "text/json")
                        .auth()
                        .preemptive()
                        .basic(base.prop.getProperty("SALMONUSER"), base.prop.getProperty("SALMONPASSWORD"))
                        .and()
                        .when()
                        .put("/" + "ClaimsAPI/?t=PutClaimCancellation")
                        .then()
//                    .statusCode(200)
//                    .and()
//                    .log().all()
                        .extract().response();
                if (JsonPath.parse(response.body().asString()).read("$..ResponseDescription").toString().replaceAll("[^a-zA-Z0-9]", "").contains("Success")) {
                    status = true;
                    LOGGER.info("=======>>>>>>> Claim No :" + claimNo + " canceled successfully");
                }
            } else {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;

    }

    public String getOpenClaimsIfNotCancelled(String planNo) throws Exception {
        String claimNo = null;
        try {
            RestAssured.baseURI = base.prop.getProperty("salmonAPIURL");

            Response response = given()
                    .relaxedHTTPSValidation()
//                .header("Content-Type", "text/json")
                    .auth()
                    .preemptive()
                    .basic(base.prop.getProperty("SALMONUSER"), base.prop.getProperty("SALMONPASSWORD"))
                    .and()
                    .when()
                    .get("/" + "?t=GetAllClaims&PolicyNumber=" + planNo + "&Source=&CountryCode=&LanguageID=&Channel=&Client=")
                    .then()
                    .statusCode(200)
                    .and()
//                    .log().all()
                    .extract().response();


//            String claimStatus = JsonPath.parse(response.body().asString()).read("$..RepairHistory[0]..Status").toString().replaceAll("\\D+", "");
            String claimStatus = JsonPath.parse(response.body().asString()).read("$..PolicyData." + planNo + ".ClaimStatus").toString();
            if (claimStatus.toLowerCase().contains("incomplete") || claimStatus.toLowerCase().contains("in progress")
                    || claimStatus.toLowerCase().contains("accepted")
                    || claimStatus.toLowerCase().contains("created")) {
                claimNo = JsonPath.parse(response.body().asString()).read("$..PolicyData." + planNo + ".ClaimNumber").toString().replaceAll("\\D+", "");
            } else {
                claimNo = JsonPath.parse(response.body().asString()).read("$..PolicyData." + planNo + ".ClaimNumber").toString().replaceAll("\\D+", "");
            }
            LOGGER.info("==============>>>>>> Current Claim Number :" + claimNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claimNo;
    }

    public String createContractFor4HHWithCustomDetails(String firstName, String surname, String addressLane1, String postcode) throws Exception {

        String filePath = "/src/test/resources/TestDatafile/CreateContract_4HH_postcode"+".xml";
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + filePath);
        String reqBody = IOUtils.toString(fs,"UTF-8");
        reqBody = replaceParams(reqBody,"FirstName",firstName);
        reqBody = replaceParams(reqBody,"Surname",surname);
        reqBody = replaceParams(reqBody,"AddressLane1",addressLane1);
        reqBody = replaceParams(reqBody,"Postcode",postcode);
        reqBody = replaceParams(reqBody,"Email","testemail@domesticandgeneral.com");
        RestAssured.baseURI = ESBCREATECONTRACT_ENDPOINT;

        Response response = given()
                .header("Content-Type", "text/xml")
                .header("Authorization", "Bearer " + base.prop.getProperty("ESBCREATECONTRACTTOKEN"))
                .config(RestAssured.config().xmlConfig(xmlConfig().with().namespaceAware(true)))
                .and()
                .body(reqBody)
                .when()
                .post("/APAC/contractServicesWeb/2/createContractService")
                .then()
                .statusCode(200)
                .and()
//                .log().all()
                .extract().response();

        return seleniumHelper.searchStringRegex("<SchemeCode>(.*?)<\\/SchemeCode>", response.asString()) + seleniumHelper.searchStringRegex("<Reference>(.*?)<\\/Reference>", response.asString());
    }

    public String createContractForALGWithCustomDetails(String itemC, String manfC) throws Exception {

        String filePath = "/src/test/resources/TestDatafile/CreateContract_ALG"+".xml";
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + filePath);
        String reqBody = IOUtils.toString(fs,"UTF-8");
//        reqBody = replaceParams(reqBody,"firstName",firstName);
//        reqBody = replaceParams(reqBody,"surname",surname);
        reqBody = replaceParams(reqBody,"itemCode",itemC);
        reqBody = replaceParams(reqBody,"manfCode",manfC);
        RestAssured.baseURI = ESBCREATECONTRACT_ENDPOINT;

        Response response = given()
                .header("Content-Type", "text/xml")
                .header("Authorization", "Bearer " + base.prop.getProperty("ESBCREATECONTRACTTOKEN"))
                .config(RestAssured.config().xmlConfig(xmlConfig().with().namespaceAware(true)))
                .and()
                .body(reqBody)
                .when()
                .post("/EMEA/contractServicesWeb/2/createContractService")
                .then()
                .statusCode(200)
                .and()
                .log().all()
                .extract().response();

        return seleniumHelper.searchStringRegex("<SchemeCode>(.*?)<\\/SchemeCode>", response.asString()) + seleniumHelper.searchStringRegex("<Reference>(.*?)<\\/Reference>", response.asString());
    }
    private String replaceParams(String originalString, String stringToFind, String newValue){
        String findString = "$("+stringToFind+")";
        return originalString.replace(findString,newValue);
    }

    public GCDTemplate getContractDetails(String compCode, String schemeCode, String refNo) throws Exception {

        String filePath = "/src/test/resources/TestDatafile/GetContractDetailsRequest"+".xml";
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + filePath);
        String reqBody = IOUtils.toString(fs,"UTF-8");
//        reqBody = replaceParams(reqBody,"firstName",firstName);
//        reqBody = replaceParams(reqBody,"surname",surname);
//        reqBody = replaceParams(reqBody,"compCode",compCode);
        reqBody = replaceParams(reqBody,"schemeCode",schemeCode);
        reqBody = replaceParams(reqBody,"ref",refNo);
        RestAssured.baseURI = ESBCREATECONTRACT_ENDPOINT;

        Response response = given()
                .header("Content-Type", "text/xml")
                .header("Authorization", "Bearer " + base.prop.getProperty("ESBCREATECONTRACTTOKEN"))
                .config(RestAssured.config().xmlConfig(xmlConfig().with().namespaceAware(true)))
                .and()
                .body(reqBody)
                .when()
                .post("/EMEA/contractServicesWeb/2/getContractDetailsService")
                .then()
                .statusCode(200)
                .and()
                .log().all()
                .extract().response();


        GCDTemplate contractDetails;
        return contractDetails = GCDTemplate.builder()
                .companyCode(compCode)
                .schemeCode(schemeCode)
                .reference(refNo)
                .EmailAddr(seleniumHelper.searchStringRegex("<EmailAddr>(.*?)<\\/EmailAddr>", response.asString()))
                .AcceptanceDate(seleniumHelper.searchStringRegex("<AcceptanceDate>(.*?)<\\/AcceptanceDate>", response.asString()))
                .AddressLine1(seleniumHelper.searchStringRegex("<AddressLine1>(.*?)<\\/AddressLine1>", response.asString()))
                .AddressLine2(seleniumHelper.searchStringRegex("<AddressLine2>(.*?)<\\/AddressLine2>", response.asString()))
                .AddressLine3(seleniumHelper.searchStringRegex("<AddressLine3>(.*?)<\\/AddressLine3>", response.asString()))
                .PostalCode(seleniumHelper.searchStringRegex("<PostalCode>(.*?)<\\/PostalCode>", response.asString()))
                .RenewalDate(seleniumHelper.searchStringRegex("<RenewalDate>(.*?)<\\/RenewalDate>", response.asString()))
                .Title(seleniumHelper.searchStringRegex("<Title>(.*?)<\\/Title>", response.asString()))
                .MobTel(seleniumHelper.searchStringRegex("<MobTel>(.*?)<\\/MobTel>", response.asString()))
                .HomeTel(seleniumHelper.searchStringRegex("<HomeTel>(.*?)<\\/HomTel>", response.asString()))
                .Surname(seleniumHelper.searchStringRegex("<Surname>(.*?)<\\/Surname>", response.asString()))
                .FirstName(seleniumHelper.searchStringRegex("<FirstName>(.*?)<\\/FirstName>", response.asString()))
                .build();
    }

    public GPDTemplate getPlanDetails(String schemeCode, String refNo) throws Exception {

        String filePath = "/src/test/resources/TestDatafile/GetPlanDetails"+".xml";
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + filePath);
        String reqBody = IOUtils.toString(fs,"UTF-8");
        reqBody = replaceParams(reqBody,"schemeCode",schemeCode);
        reqBody = replaceParams(reqBody,"ref",refNo);
        RestAssured.baseURI = ESBCREATECONTRACT_ENDPOINT;

        Response response = given()
                .header("Content-Type", "text/xml")
                .header("Authorization", "Bearer " + base.prop.getProperty("ESBCREATECONTRACTTOKEN"))
                .config(RestAssured.config().xmlConfig(xmlConfig().with().namespaceAware(true)))
                .and()
                .body(reqBody)
                .when()
                .post("/2/EMEA/planServicesWeb/PlanService")
                .then()
                .statusCode(200)
                .and()
                .log().all()
                .extract().response();


        GPDTemplate getPlanDetails;
        return getPlanDetails = GPDTemplate.builder()
                .companyCode(seleniumHelper.searchStringRegex("<CompanyCode>(.*?)<\\/CompanyCode>", response.asString()))
                .schemeCode(seleniumHelper.searchStringRegex("<SchemeCode>(.*?)<\\/SchemeCode>", response.asString()))
                .reference(seleniumHelper.searchStringRegex("<ReferenceNumber>(.*?)<\\/ReferenceNumber>", response.asString()))
                .acceptanceDate(seleniumHelper.searchStringRegex("<AcceptanceDate>(.*?)<\\/AcceptanceDate>", response.asString()))
                .renewalDate(seleniumHelper.searchStringRegex("<RenewalDate>(.*?)<\\/RenewalDate>", response.asString()))
                .firstName(seleniumHelper.searchStringRegex("<FirstName>(.*?)<\\/FirstName>", response.asString()))
                .surname(seleniumHelper.searchStringRegex("<Surname>(.*?)<\\/Surname>", response.asString()))
                .addressLine1(seleniumHelper.searchStringRegex("<AddressLine1>(.*?)<\\/AddressLine1>", response.asString()))
                .postCode(seleniumHelper.searchStringRegex("<PostCode>(.*?)<\\/PostCode>", response.asString()))
                .build();
    }
}