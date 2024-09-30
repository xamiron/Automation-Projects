package test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import driver.Browser;
import elements.Element;
import forms.BDJHomePage;
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

public class Test2 {
    private final Element userNameTextField = new Element(By.cssSelector("input.form-control.br-b"));
    private final Element gmailSignInButton = new Element(By.cssSelector(".btn.btn-block.btn-social.g_id_signin"));

    WebDriver driver;
    private ExtentTest test;

    @BeforeClass
    public void setup() {
        driver = Browser.initialize();
        if (driver != null) {
            driver.manage().window().maximize();
            driver.get(DataReader.getStringValue("url", "config"));
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

        boolean isLoginPageDisplayed = signInPage.isFormOpen();

        test.log(Status.INFO, "Check if login page is displayed");
        Assert.assertTrue(isLoginPageDisplayed, "Login Page is not opened");
        test.log(Status.PASS, "Login Page is opened");

        signInPage.moveCursorSignInDropdown();
        test.log(Status.PASS, "Moved cursor to Sign In Dropdown");

        signInPage.clickDropdownOnSignInButton();
        test.log(Status.PASS, "Clicked on Sign In Dropdown button");

        signInPage.clickOnSignInButton();
        test.log(Status.PASS, "Clicked on Sign In button");

        signInPage.sendingUsernameInEmailField();
        test.log(Status.PASS, "Entered username");

        signInPage.sendingPasswordInPasswordField();
        test.log(Status.PASS, "Entered password");

        bdjHomePage.moveCursorToProfileIcon();
        test.log(Status.PASS, "Moved cursor to Profile Icon");

        bdjHomePage.clickOnProfileIcon();
        test.log(Status.PASS, "Clicked on Profile Icon");

        bdjHomePage.clickOnSignOutButton();
        test.log(Status.PASS, "Clicked on Sign Out button");
    }

    @Test(priority = 2)
    public void LinkedInNewLogin() {
        BDJSignInPage signInPage = new BDJSignInPage();
        BDJHomePage bdjHomePage = new BDJHomePage();

        signInPage.moveCursorSignInDropdown();
        test.log(Status.PASS, "Moved cursor to Sign In Dropdown 2");

        signInPage.clickDropdownOnSignInButton();
        test.log(Status.PASS, "Clicked on Sign In Dropdown button 2");

        signInPage.clickOnSignInButton();
        test.log(Status.PASS, "Clicked on Sign In button 2");

        signInPage.linkedInloginNewUser();
        test.log(Status.PASS, "Opened LinkedIn button");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Largest Job Site in Bangladesh, Search Jobs | Bdjobs.com";
        Assert.assertEquals(expectedTitle, actualTitle);

        bdjHomePage.moveCursorToProfileIcon();
        test.log(Status.PASS, "Moved cursor to Profile Icon");

        bdjHomePage.clickOnProfileIcon();
        test.log(Status.PASS, "Clicked on Profile Icon");

        bdjHomePage.clickOnSignOutButton();
        test.log(Status.PASS, "Clicked on Sign Out button");
    }

    @Test(priority = 3)
    public void LinkedIn_OLDUser() {
        BDJSignInPage signInPage = new BDJSignInPage();
        BDJHomePage bdjHomePage = new BDJHomePage();

        signInPage.moveCursorSignInDropdown();
        test.log(Status.PASS, "Moved cursor to Sign In Dropdown 2");

        signInPage.clickDropdownOnSignInButton();
        test.log(Status.PASS, "Clicked on Sign In Dropdown button 2");

        signInPage.clickOnSignInButton();
        test.log(Status.PASS, "Clicked on Sign In button 2");

        signInPage.linkedInloginOLDUser();
        test.log(Status.PASS, "Opened LinkedIn button");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Largest Job Site in Bangladesh, Search Jobs | Bdjobs.com";
        Assert.assertEquals(expectedTitle, actualTitle);

        bdjHomePage.moveCursorToProfileIcon();
        test.log(Status.PASS, "Moved cursor to Profile Icon");

        bdjHomePage.clickOnProfileIcon();
        test.log(Status.PASS, "Clicked on Profile Icon");

        bdjHomePage.clickOnSignOutButton();
        test.log(Status.PASS, "Clicked on Sign Out button");
    }

    @Test(priority = 4)
    public void gmail_NewUser(){
        BDJSignInPage signInPage = new BDJSignInPage();
        BDJHomePage bdjHomePage = new BDJHomePage();

        //sign up
        signInPage.moveCursorSignInDropdown();
        test.log(Status.PASS, "Moved cursor to Sign In Dropdown 2");

        signInPage.clickDropdownOnSignInButton();
        test.log(Status.PASS, "Clicked on Sign In Dropdown button 2");

        signInPage.clickOnSignInButton();
        test.log(Status.PASS, "Clicked on Sign In button 2");

        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window ID is : " + parentWindow);

        ExplicitWait.elementToBeClickable(userNameTextField.getLocator());
        gmailSignInButton.click();

        Set<String> allWindow = driver.getWindowHandles();

        int count = allWindow.size();
        System.out.println("Total Window : " + count);
        //gmail Popup
        for(String child:allWindow)
        {
            if(!parentWindow.equalsIgnoreCase(child))
            {
                driver.switchTo().window(child);
                //driver.manage().window().maximize();

                signInPage.gamilLoginNewUser();
                test.log(Status.PASS, "Clicked on Gmail button");
            }
        }
        driver.switchTo().window(parentWindow);

        //Logout
        bdjHomePage.moveCursorToProfileIcon();
        test.log(Status.PASS, "Moved cursor to Profile Icon");

        bdjHomePage.clickOnProfileIcon();
        test.log(Status.PASS, "Clicked on Profile Icon");

        bdjHomePage.clickOnSignOutButton();
        test.log(Status.PASS, "Clicked on Sign Out button");
    }

    @AfterClass
    public void cleanUp() {
//        if (driver != null) {
//            driver.quit();
//        }
        ExtentManager.flush();
    }
}
