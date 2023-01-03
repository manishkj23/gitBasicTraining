package com.test.utils;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;

import static io.restassured.RestAssured.given;
import static io.restassured.config.XmlConfig.xmlConfig;

public class CommonUtils {

    private BasePage base;
    private SeleniumHelper seleniumHelper;
    private WebDriver driver;

    private final static String ESBCREATECONTRACT_ENDPOINT = "https://uatws.domesticandgeneral.com";
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

    public String createContractApiCall() throws Exception {

        String filePath = "/src/test/resources/TestDatafile/CreateContract.xml";
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + filePath);
        RestAssured.baseURI="https://uatwebsvcs.domesticandgeneral.com";

        Response response=given()
                .header("Content-Type", "text/xml")
                .config(RestAssured.config().xmlConfig(xmlConfig().with().namespaceAware(true)))
                .and()
                .body(IOUtils.toString(fs,"UTF-8"))
                .when()
                .post("/APAC/contractServicesWeb/2/createContractService")
                .then()
                .statusCode(200)
                .and()
                .log().all()
                .extract().response();

        return seleniumHelper.searchStringRegex("<SchemeCode>(.*?)<\\/SchemeCode>",response.asString()) + seleniumHelper.searchStringRegex("<Reference>(.*?)<\\/Reference>",response.asString());
    }

    public String createContractApiCallForElux() throws Exception {

        String filePath = "/src/test/resources/TestDatafile/CreateContract_6YV.xml";
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + filePath);
        RestAssured.baseURI="https://uatwebsvcs.domesticandgeneral.com";

        Response response=given()
                .header("Content-Type", "text/xml")
                .config(RestAssured.config().xmlConfig(xmlConfig().with().namespaceAware(true)))
                .and()
                .body(IOUtils.toString(fs,"UTF-8"))
                .when()
                .post("/APAC/contractServicesWeb/2/createContractService")
                .then()
                .statusCode(200)
                .and()
                .log().all()
                .extract().response();

        return seleniumHelper.searchStringRegex("<SchemeCode>(.*?)<\\/SchemeCode>",response.asString()) + seleniumHelper.searchStringRegex("<Reference>(.*?)<\\/Reference>",response.asString());
    }

    public String createContractApiCallForWhirlpool() throws Exception {

        String filePath = "/src/test/resources/TestDatafile/CreateContract_3BA.xml";
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + filePath);
        RestAssured.baseURI="https://uatwebsvcs.domesticandgeneral.com";

        Response response=given()
                .header("Content-Type", "text/xml")
                .config(RestAssured.config().xmlConfig(xmlConfig().with().namespaceAware(true)))
                .and()
                .body(IOUtils.toString(fs,"UTF-8"))
                .when()
                .post("/APAC/contractServicesWeb/2/createContractService")
                .then()
                .statusCode(200)
                .and()
                .log().all()
                .extract().response();

        return seleniumHelper.searchStringRegex("<SchemeCode>(.*?)<\\/SchemeCode>",response.asString()) + seleniumHelper.searchStringRegex("<Reference>(.*?)<\\/Reference>",response.asString());
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

}