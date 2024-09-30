package forms;

import elements.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import utility.DataReader;
import utility.RandomStringGenerator;
import waits.ExplicitWait;

import java.util.logging.Logger;

public class BDJApplyJob extends BaseForm{
    private final Element continueButton = new Element(By.cssSelector("input[value='Continue']"));
    private final Element userNameTextField = new Element(By.cssSelector("input.form-control.br-b"));
    private final Element passwordTextField = new Element(By.cssSelector("input.form-control.br-b"));
    private final Element signInButtonPassword = new Element(By.cssSelector("input[type='submit']"));
    private final Element errorMessage = new Element(By.cssSelector("span#errorMessage[aria-live='assertive']"));
    private final Element getErrorMessage2 = new Element(By.xpath("//span[@id='errorMessage']"));
    private final Element getErrorMessagePassword = new Element(By.xpath("//span[@class='text-danger' and contains(text(), 'Please enter Password.')]"));
    private final Element getErrorMessagePassword2 = new Element(By.xpath("//span[@class='text-danger' and contains(text(), 'Wrong password. Try again or click Forgot password to reset it.')]"));
    private final Element editProfileButton = new Element(By.cssSelector("li.faldes > a[href='https://mybdjobs.bdjobs.com/new_mybdjobs/step_01_view.asp']"));
    private final Element editProfileButton2 = new Element(By.cssSelector("li.faldes a[href='https://mybdjobs.bdjobs.com/new_mybdjobs/b_step_01_view.asp']"));
    private final Element editButton = new Element(By.cssSelector("button.btn.edit-btn[aria-label='Click on Edit to fill up personal details']"));
    private final Element editButton2 = new Element(By.cssSelector("button.btn.edit-btn[aria-label='Edit Personal Details']"));
    private final Element closeAd = new Element(By.cssSelector("div[style='cursor: pointer;'] > svg[viewBox='0 0 48 48']"));
    private final Element closeAd2 = new Element(By.cssSelector("div.ns-n6jyj-e-15 > span.ns-n6jyj-e-16"));

    Logger logger = Logger.getLogger(getClass().getName());
    RandomStringGenerator generator = new RandomStringGenerator();
    String randomString = generator.generateRandomString(10);
    String randomString2 = generator.generateRandomString(150);
    String errorMessageText = "Error message is not displayed.";

    public BDJApplyJob() {
        super(new Element(By.cssSelector("div[class='create-acc']")));
    }

    public void sendingUsernameInEmailField() {
        ExplicitWait.elementToBeClickable(userNameTextField.getLocator());

        // Valid username
        userNameTextField.getElement().clear();
        userNameTextField.getElement().sendKeys(DataReader.getStringValue("userName", "TestData"));
        logger.info("/n Send valid userName from json file");
        ExplicitWait.elementToBeClickable(continueButton.getLocator());
        continueButton.click();
        logger.info("Clicked on Continue button");
    }

    public void sendingPasswordInPasswordField() {
        ExplicitWait.elementToBeClickable(passwordTextField.getLocator());

        // Valid Password
        passwordTextField.getElement().clear();
        passwordTextField.getElement().sendKeys(DataReader.getStringValue("password", "TestData"));
        ExplicitWait.elementToBeClickable(signInButtonPassword.getLocator());
        signInButtonPassword.click();
    }

//    public void editProfile() {
//        ExplicitWait.elementToBeClickable(editProfileButton.getLocator());
//        ExplicitWait.elementToBeClickable(editProfileButton2.getLocator());
//        editProfileButton.scrollUntilElementIsVisible();
//        editProfileButton.getElement().click();
//        ExplicitWait.elementToBeClickable(editButton.getLocator());
//        editButton.getElement().click();
//       // closeAdsIfPresent();
//    }

    public void editProfile() {
        boolean isButton1Clickable = false;
        boolean isButton2Clickable = false;

        try {
            ExplicitWait.elementToBeClickable(editProfileButton.getLocator());
            isButton1Clickable = true; // If no exception is thrown, it's clickable
        } catch (TimeoutException e) {
            System.out.println("Edit Profile Button 1 is not clickable: " + e.getMessage());
        }

        try {
            ExplicitWait.elementToBeClickable(editProfileButton2.getLocator());
            isButton2Clickable = true; // If no exception is thrown, it's clickable
        } catch (TimeoutException e) {
            System.out.println("Edit Profile Button 2 is not clickable: " + e.getMessage());
        }

        // Click the appropriate button if it is clickable
        if (isButton1Clickable) {
            editProfileButton.getElement().click();
        } else if (isButton2Clickable) {
            editProfileButton2.getElement().click();
        }

        if(editButton.isPresent()){
            ExplicitWait.elementToBeClickable(editButton.getLocator());
            editButton.getElement().click();
        }else {
        ExplicitWait.elementToBeClickable(editButton2.getLocator());
        editButton2.getElement().click();
        }
    }


    public void closeAdsIfPresent() {
        try {
            if (closeAd.isDisplayed()) {
                closeAd.getElement().click();
                logger.info("Closed ad pop-up");
            } else if (closeAd2.isDisplayed()) {
                closeAd2.getElement().click();
                logger.info("Closed secondary ad pop-up");
            }
        } catch (NoSuchElementException e) {
            // No ad pop-up found, continue with the script
            logger.info("No ad pop-up found");
        }
    }

}
