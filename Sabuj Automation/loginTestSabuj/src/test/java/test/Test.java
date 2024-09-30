package test;

import driver.Browser;
import forms.BDJHomePage;
import forms.BDJSignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import utility.DataReader;

public class Test {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = Browser.initialize();
        driver.manage().window().maximize();
        driver.get(DataReader.getStringValue("url", "config"));
    }

    @org.testng.annotations.Test
    public void bdjobsLogin() {
        BDJSignInPage signInPage = new BDJSignInPage();
        BDJHomePage bdjHomePage = new BDJHomePage();

        boolean isLoginPageDisplayed = signInPage.isFormOpen();
        Assert.assertTrue(isLoginPageDisplayed, "Login Page is not opened");

        signInPage.moveCursorSignInDropdown();
        signInPage.clickDropdownOnSignInButton();
        signInPage.clickOnSignInButton();
        signInPage.sendingUsernameInEmailField();
        signInPage.sendingPasswordInPasswordField();

        bdjHomePage.moveCursorToProfileIcon();
        bdjHomePage.clickOnProfileIcon();
        bdjHomePage.clickOnSignOutButton();

//        logInPage.clickOnSignInButton2();
    }
}
