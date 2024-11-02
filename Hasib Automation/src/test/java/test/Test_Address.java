package test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import driver.Browser;
import forms.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utility.DataReader;
import utility.ExtentManager;

import java.lang.reflect.Method;

public class Test_Address {
    WebDriver driver;
    private ExtentTest test;

    @BeforeClass
    public void setup() {
        driver = Browser.initialize();
        if (driver != null) {
            driver.manage().window().maximize();
            driver.get(DataReader.getStringValue("urlSign", "config"));
        } else {
            throw new RuntimeException("Driver initialization failed!");
        }
    }

    @BeforeMethod
    public void startTest(Method method) {
        test = ExtentManager.createTest(method.getName(), method.getAnnotation(Test.class).description());
    }

    @Test(priority = 1)
    public void bdjobsLogin() {
        BDJSignInPage signInPage = new BDJSignInPage();
        BDJHomePage bdjHomePage = new BDJHomePage();
        BDJApplyJob bdjApplyPage = new BDJApplyJob();

        boolean isLoginPageDisplayed = bdjApplyPage.isFormOpen();
        test.log(Status.INFO, "Check if login page is displayed");
        Assert.assertTrue(isLoginPageDisplayed, "Login Page is not opened");
        test.log(Status.PASS, "Login Page is opened");

        bdjApplyPage.sendingUsernameInEmailField();
        test.log(Status.PASS, "Entered username");

        bdjApplyPage.sendingPasswordInPasswordField();
        test.log(Status.PASS, "Entered password ");
//        bdjApplyPage.closeAdsIfPresent();
        bdjApplyPage.editProfile();
    }

    @Test(priority = 2)
    public void addressDetails() {
        BDJAddressDetails bdjAddressDetails = new BDJAddressDetails();
        BDJPersonalDetails bdjPersonalDetails = new BDJPersonalDetails(driver);

        boolean isPersonalDetailsDisplayed= bdjPersonalDetails.isFormOpen();
        test.log(Status.INFO, "Check if Personal Details page loaded");
        Assert.assertTrue(isPersonalDetailsDisplayed, "Personal Details page is not opened");
        test.log(Status.PASS, "Personal Details Page is opened");

        boolean isAddressDetailsDisplayed = bdjAddressDetails.isFormOpen();
        test.log(Status.INFO, "Check if Address Details page loaded");
        Assert.assertTrue(isAddressDetailsDisplayed, "Address Details page is not opened");
        test.log(Status.PASS, "Address Details Page is opened");

//        bdjAddressDetails.presentAddressAllCheck();
//        test.log(Status.PASS, "Present Address entered");
//        bdjAddressDetails.permanentAddressAllChecking();
//        test.log(Status.PASS, "Permanent address entered");

        //work from here
        bdjAddressDetails.presentAddressIndividualInsideBangladesh();
        test.log(Status.PASS, "Present address individual entered");
        bdjAddressDetails.presentAddressIndividualOutsideBangladesh();
        test.log(Status.PASS, "Present address outside Bangladesh entered");

        bdjAddressDetails.permanentAddressIndividualInsideBangladesh();
        test.log(Status.PASS, "Permanent Address Individual entered");
//        bdjAddressDetails.permanentAddressIndividualOutsideBangladesh();
//        test.log(Status.PASS, "Permanent Address Individual Outside Bangladesh entered");
    }


    @AfterMethod
    public void cleanUp() {
//        if (driver != null) {
//            driver.quit();
//        }
        ExtentManager.flush();
    }
}