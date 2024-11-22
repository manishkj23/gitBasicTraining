package com.test.steps;

import com.test.pages.CCAgent_OLDUI.LoginPage;
import com.test.pages.CCAgent_OLDUI.smartmockio.MockAPI;
import com.test.utils.BasePage;
import com.test.utils.CommonUtils;
import com.test.utils.OrbitUtils.GetContractDetails.GCDTemplate;
import com.test.utils.OrbitUtils.JsonBuilder;
import com.test.utils.SeleniumHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

public class MockserverSteps {
    private BasePage base;
    private LoginPage loginPage;
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private MockAPI mockAPI;
    private JsonBuilder jsonBuilder;
    private CommonUtils commonUtils;


    private static final Logger LOGGER = LoggerFactory.getLogger(LoginStepDef.class);

    public MockserverSteps(BasePage basePage,
                           SeleniumHelper seleniumHelper,
                           MockAPI mockAPI,
                           JsonBuilder jsonBuilder,
                           CommonUtils commonUtils) {
        this.base = basePage;
        this.loginPage = loginPage;
        this.seleniumHelper = seleniumHelper;
        this.driver = basePage.getDriver();
        this.mockAPI = mockAPI;
        this.jsonBuilder = jsonBuilder;
        this.commonUtils = commonUtils;

    }


    @Given("^I login to Mockserver$")
    public void iLoginToMockserver() {
        mockAPI.loginToMockServer();
        Assert.assertTrue("Failed to Login to Mockserver", mockAPI.isSmartMockDashboardPageLoaded());
    }


    @When("^I enter the \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\" details and save Mock$")
    public void iEnterTheAndDetails(String imei, String make, String model, String fmip, String isBlocked, String crimeRefNo, String urlPath) {
        String jsonResponseString = null;
        String jsonResponseString1 = null;
        String crimeref = crimeRefNo;

        if (crimeref.isEmpty()) {
            crimeref = "false";
        }
        try {
            if ("TRUE" == isBlocked) {
                jsonResponseString = jsonBuilder.getJsonStringFromFile("createmock_blocked_true.json");
            } else {
                jsonResponseString = jsonBuilder.getJsonStringFromFile("createmock_blocked_false.json");
            }
            ;
            jsonResponseString1 = mockAPI.beutifyJsonString(jsonResponseString.replace("${IMEI}", imei).replace("${MODEL}", model).replace("${MAKE}", make).replace("${FMIPSTATUS}", fmip).replace("${CRIMEREFNO}", crimeref));
            mockAPI.createMockApi(urlPath, jsonResponseString1);

        } catch (Exception e) {
            e.printStackTrace();
        }
//        Assert.assertTrue("Failed to save Response ", mockAPI.isRespnseDataPastedOnTheTextArea(jsonResponseString1));

    }

    @Then("^I verify the Mock is saved successfully$")
    public void iVerifyTheMockIsSavedSuccessfully() {
        base.softAssert.assertTrue(mockAPI.isResponseSaved(), "Failed to check the saved Response msg popup ");
    }


    @Given("^I get the token$")
    public void iGetTheToken() {

        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        String secKey = "-----BEGIN RSA PRIVATE KEY-----\n" +
                "MIIEogIBAAKCAQEAxCfaqaV4vgczySKpLWlNQAy0lcsRtFvOvmKrHOteoEm6aKQi\n" +
                "P4r4/U5mKOiM5uHDzV83Nm+rGGGuySwezyIVcscHTgxHX9mIcdGnZcqK1XsSmdAT\n" +
                "oZfeapHSE1jzhLELag4LKsHWnxKH+mOhj0yy6LsWWB+Nccvek6Y7kKkVJXYj4Kf3\n" +
                "7PItnNN9A+M1sG6b4kwAGYCCm9kZW16Ad36YVhIG/VFmmrwAxnOiqK5gD3Wzf/DF\n" +
                "5bjjfEYl8hPhgrBtrSrE6vy/qn4Nsv18iHDuFKWgSqEW4DUsjtoiDl+7OXJO85xC\n" +
                "0O1LckvgeXqXNyaIr//NktBn+NlWnREAyIH3EwIDAQABAoIBAB3srpEe61KiKqZO\n" +
                "oVyKKfzRc2M+vY60StAEoXIh/ieZ19RK5eanvuB162PmRkiavJJCKlwloQZxMIcE\n" +
                "MhcLbhY6gsTHXsQinYwvncgLpC55Phc1BSmrz4SWhmPpOA1QLRua1N1LAQD3hMMQ\n" +
                "G/+OheS3VetPtPZdUbFYtNGW2eEC5n7ITat+UjrT9XxAVVNbnq/Ay0KP6UblEO21\n" +
                "2IHoE8jdOwm8PHrTvMtHozZtXno3VM25xEO29/H+zCWFEuqHOcUYOmhxZMZY5hiT\n" +
                "MPqNBdFVigHk23jPsNKQD8zjse/rNkSxMpXFWjum4c90D/1SUDsjuaooy4POR9nM\n" +
                "DciPfIECgYEA6I/uSk3v40STPAHnJulmTg1kIMnp4SqAGGPwJVVnIigG/N2Q3iEU\n" +
                "RB0uGzK32myMqVqpLk6Zb4w4o+ZrXtS8DASJ/61Y2Y82vuW9UUPttL4VM7EXMgW9\n" +
                "t12um9WUFt2Wqj9OcvjO0R43gk/SYLKeaLf3EBP23oW92OBtbHJpLuECgYEA1+yj\n" +
                "2d86EMFHQv/jvmKi2vuvaaVwH+lTEWKYI1ICbBE8qi65W7CzXxL1X1yMPNN2Z63/\n" +
                "FCWcAUDX8D3qWw2PfVrxLuvp7FxgB/C01l4eICIxSt3h1pL/opvrtQDwIj5U2m0i\n" +
                "qQCGiXYA3thw3nOtAflDqaD+xmz3pxzdj2eG6HMCgYAyGFbnEJS86tegVHSbUClm\n" +
                "ZMINwhCsHQCMwHJJSHU3yVGABKYhAxUfev2khC9QUJOYI1xQCkRI3/aPb6HvQnnj\n" +
                "SNMFDS0XaB8NzeUS7UP17AAbK2losA3mwrpK/R2yMzcyIwLeBzRdnVmtq04Q4Ej5\n" +
                "G6+Peg1yb3KuleFcO+TmYQKBgCfrI8+fqUh3swj77crAyYLajO9nGneL10Obiqzc\n" +
                "+H2qIiEESlhdLowhISPkJDkKjxVT4ZiD63d/2WwcxjrXIvP14CjgjHqaCVbudUA8\n" +
                "Xi1qpNpGcv4MZx5U3Rq1da+e/mjzTDkaU8UN/9MzCIrXr+BxiMTPcsqUUqSefYeJ\n" +
                "iDNpAoGAfeqPmMn/MJWoRxzgyGEq2OJ+g0fjJ/x2d2EfU/CN48FIepnpMPl8wukv\n" +
                "mOpEs7qsQqW7HoiIvdFyksO7I/h4wzUpIE7Me8vDU1BMCF+eF8ejcsi1Gahh5an3\n" +
                "QnCpMI2ElJH50ufR9V2aX4nFg59uS0cN+o1wbUrUZLzcpiVO93c=\n" +
                "-----END RSA PRIVATE KEY-----";
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secKey);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId("3MVG9T992fY2Y4vsn2ku33rWZp5.XamokujaxFca2OxCFOvcoettAna0DYNk0GFT2DCW6wonXmrQm5GE3n9gR")
                .setIssuedAt(now)
                .setSubject("tester")
                .setIssuer("orbit@integrator.orbit.fulluat")
                .signWith(signatureAlgorithm, signingKey);

        //if it has been specified, let's add the expiration
        long ttlMillis = 10;
        if (ttlMillis > 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

    }
    @Given("I get getContractDetails API Details")
    public void iGetGetContractDetailsAPIDetails() {
        try {
            GCDTemplate gcd = commonUtils.getContractDetails("A","ALG","0004179");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
