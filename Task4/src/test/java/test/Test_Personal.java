package test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import driver.Browser;
import elements.Element;
import forms.BDJApplyJob;
import forms.BDJHomePage;
import forms.BDJPersonalDetails;
import forms.BDJSignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utility.DataReader;
import utility.ExtentManager;
import waits.ExplicitWait;

import java.lang.reflect.Method;
import java.util.Set;

public class Test_Personal {
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
    public void personalDetails(){
        BDJPersonalDetails bdjPersonalDetails = new BDJPersonalDetails();

        boolean isPersonalDetailsDisplayed= bdjPersonalDetails.isFormOpen();
        test.log(Status.INFO, "Check if Personal Details page loaded");
        Assert.assertTrue(isPersonalDetailsDisplayed, "Personal Details page is not opened");
        test.log(Status.PASS, "Personal Details Page is opened");

        bdjPersonalDetails.firstName();
        test.log(Status.PASS, "First Name entered");

//        bdjPersonalDetails.lastName();
//        test.log(Status.PASS, "Last Name entered");
//
//        bdjPersonalDetails.fatherName();
//        test.log(Status.PASS, "Father Name entered");
//
//        bdjPersonalDetails.motherName();
//        test.log(Status.PASS, "Mother Name entered");
//
//        bdjPersonalDetails.dob();
//        test.log(Status.PASS, "DOB entered");
//
//        bdjPersonalDetails.gender();
//        test.log(Status.PASS, "Gender selected");
//
//        bdjPersonalDetails.religion();
//        test.log(Status.PASS, "Religion is selected");
//
//        bdjPersonalDetails.maritalStatus();
//        test.log(Status.PASS, "MaritalStatus is selected");
//
//        bdjPersonalDetails.nationality();
//        test.log(Status.PASS, "Nationality entered");
//
//        bdjPersonalDetails.nID();
//        test.log(Status.PASS, "NID is entered");
//
//        bdjPersonalDetails.passport();
//        test.log(Status.PASS, "Passport is entered");
//
//        bdjPersonalDetails.passportIssuedDate();
//        test.log(Status.PASS, "Passport Issued date is entered");
//
//        bdjPersonalDetails.primaryNumber();
//        test.log(Status.PASS, "Primary is entered");
//
//        bdjPersonalDetails.secondaryNumber();
//        test.log(Status.PASS, "Secondary is entered");
//
//        bdjPersonalDetails.emergencyNumber();
//        test.log(Status.PASS, "Emergency is entered");

//        bdjPersonalDetails.primaryEmail();
//        test.log(Status.PASS, "Primary email is entered");

        bdjPersonalDetails.alternateEmail();
        test.log(Status.PASS, "Alternate email is entered");

        bdjPersonalDetails.bloodGroup();
        test.log(Status.PASS, "Blood Group is selected.");
    }

    @Test(priority = 3)
    public void addressDetails(){
    }


    @AfterClass
    public void cleanUp() {
//        if (driver != null) {
//            driver.quit();
//        }
        ExtentManager.flush();
    }
}
