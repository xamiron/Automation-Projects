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

public class Test_Disability {
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
        bdjApplyPage.editProfile();
    }

    @Test(priority = 2)
    public void Careerandinformation() {
        BDJDisability_Information bdjDisability_information = new BDJDisability_Information();

        bdjDisability_information.noIdCheck();
    }


    @AfterMethod
    public void cleanUp() {
//        if (driver != null) {
//            driver.quit();
//        }
        ExtentManager.flush();
    }
}