package forms;

import elements.Element;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import utility.DataReader;
import utility.RandomStringGenerator;
import org.openqa.selenium.By;
import waits.ExplicitWait;

import javax.xml.crypto.Data;
import java.util.Set;
import java.util.logging.Logger;

public class BDJSignInPage extends BaseForm{
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(BDJSignInPage.class);

    //    private final Element signInDropdownButton= new Element(By.xpath("//li[@class='hidden-xs soca']"));
//    private final Element signInButton = new Element(By.xpath("//li[@class='hidden-xs soca open']//div[@class='cart-mbdj-r']//a[@class='btn slu-btn' and contains(text(), 'Sign in')]"));
//    private final Element userNameTextField = new Element(By.xpath("//input[@class='form-control br-b']"));
//    private final Element continueButton = new Element(By.xpath("//div[@class='col-sm-12']//input[@class='btn btn-success btn-signin']"));
//    private final Element passwordTextField = new Element(By.xpath("//input[@class='form-control br-b']"));
//    private final Element signInButtonPassword = new Element(By.xpath("//input[@type='submit']"));
//    private final Element errorMessage = new Element(By.xpath("//span[@id='errorMessage' and contains(text(), 'Please enter Username, Email or Mobile No.')]"));
//    private final Element getErrorMessage2 = new Element(By.xpath("//span[@id='errorMessage']"));
//    private final Element getErrorMessagePassword = new Element(By.xpath("//span[@class='text-danger' and contains(text(), 'Please enter Password.')]"));
//    private final Element getErrorMessagePassword2= new Element(By.xpath("//span[@class='text-danger' and contains(text(), 'Wrong password. Try again or click Forgot password to reset it.')]"));
    private final Element signInDropdownButton = new Element(By.cssSelector("li.hidden-xs.soca"));
    private final Element signInButton = new Element(By.cssSelector(".hidden-xs > .dropdown-menu > .login-form-n > .cart-mbdj > .cart-mbdj-r > .btn-wraper > .btn"));
    private final Element userNameTextField = new Element(By.cssSelector("input.form-control.br-b"));
    private final Element continueButton = new Element(By.cssSelector("div.col-sm-12 input.btn.btn-success.btn-signin"));
    private final Element passwordTextField = new Element(By.cssSelector("input.form-control.br-b"));
    private final Element signInButtonPassword = new Element(By.cssSelector("input[type='submit']"));
    private final Element errorMessage = new Element(By.cssSelector("span#errorMessage[aria-live='assertive']"));
    private final Element getErrorMessage2 = new Element(By.xpath("//span[@id='errorMessage']"));
    private final Element getErrorMessagePassword = new Element(By.xpath("//span[@class='text-danger' and contains(text(), 'Please enter Password.')]"));
    private final Element getErrorMessagePassword2= new Element(By.xpath("//span[@class='text-danger' and contains(text(), 'Wrong password. Try again or click Forgot password to reset it.')]"));
    private final Element linkedInButton = new Element(By.cssSelector("#li_button"));
   // private final Element linkedInLogo= new Element(By.cssSelector("header__logo"));
    private final Element linkedInUserNameButton = new Element(By.cssSelector("#username"));
    private final Element linkedInPasswordButton = new Element(By.cssSelector("#password"));
    private final Element linkedInSignInButton = new Element(By.cssSelector(".btn__primary--large.from__button--floating"));
    private final Element linkedInAllowButton = new Element(By.cssSelector("#oauth__auth-form__submit-btn"));
    private final Element searchField= new Element(By.cssSelector(".search-form #txtKeyword"));
    private final Element card = new Element(By.cssSelector(".card"));
    private final Element gmailSignInButton = new Element(By.cssSelector(".btn.btn-block.btn-social.g_id_signin"));
    private final Element emailField = new Element(By.cssSelector("#identifierId"));
    private final Element nextButton = new Element(By.cssSelector("#identifierNext"));
    private final Element emailPasswordField = new Element(By.cssSelector("input[name='Passwd']"));
    private final Element passNextButton = new Element(By.cssSelector("button[class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 BqKGqe Jskylb TrZEUc lw1w4b'] div[class='VfPpkd-RLmnJb']"));
    private final Element gConfirm = new Element(By.cssSelector("#confirm_yes"));

    Logger logger = Logger.getLogger(getClass().getName());
    RandomStringGenerator generator = new RandomStringGenerator();
    String randomString = generator.generateRandomString(10);
    String randomString2= generator.generateRandomString(150);
    String errorMessageText = "Error message is not displayed.";

    public BDJSignInPage(){
        super(new Element(By.xpath("//h2[@role='heading']")));
    }

    public void moveCursorSignInDropdown() {
        signInDropdownButton.moveToElement();
        logger.info("Cursor moved to Profile Icon");
    }

    public void clickDropdownOnSignInButton(){
        ExplicitWait.elementToBeClickable(signInDropdownButton.getLocator());
        signInDropdownButton.click();
        logger.info("Clicked on Sign In dropdown");
    }

    public void clickOnSignInButton(){
        ExplicitWait.elementToBeClickable(signInButton.getLocator());
        signInButton.click();
        logger.info("Clicked on Sign In button");
    }

    public void sendingUsernameInEmailField() {
        ExplicitWait.elementToBeClickable(userNameTextField.getLocator());

        //without any value
        continueButton.click();
        ExplicitWait.elementToBeVisible(errorMessage.getLocator());
        Assert.assertTrue(errorMessage.isDisplayed(), errorMessageText);
        logger.info("Clicked on Continue button" );

        //invalid value using ten characters
        userNameTextField.getElement().sendKeys(randomString);
        logger.info("Send random string of 10 character" );
        ExplicitWait.elementToBeClickable(continueButton.getLocator());
        continueButton.click();
        logger.info("Clicked on Continue button" );
        ExplicitWait.elementToBeVisible(getErrorMessage2.getLocator());
        Assert.assertTrue(getErrorMessage2.isDisplayed(), errorMessageText);

        //invalid value using 101 characters
        userNameTextField.getElement().clear();
        userNameTextField.getElement().sendKeys(randomString2);
        logger.info("Send random string of 150 character" );
        ExplicitWait.elementToBeClickable(continueButton.getLocator());
        continueButton.click();
        logger.info("Clicked on Continue button" );
        ExplicitWait.elementToBeVisible(getErrorMessage2.getLocator());
        Assert.assertTrue(getErrorMessage2.isDisplayed(), errorMessageText);

        //valid username
        userNameTextField.getElement().clear();
        userNameTextField.getElement().sendKeys(DataReader.getStringValue("userName", "TestData"));
        logger.info("/n Send valid userName from json file" );
        ExplicitWait.elementToBeClickable(continueButton.getLocator());
        continueButton.click();
        logger.info("Clicked on Continue button" );
    }

    public void sendingPasswordInPasswordField() {
        ExplicitWait.elementToBeClickable(passwordTextField.getLocator());

        //without any value
        signInButtonPassword.click();
        ExplicitWait.elementToBeVisible(getErrorMessagePassword.getLocator());
        Assert.assertTrue(getErrorMessagePassword.isDisplayed(), errorMessageText);

        //Invalid Password 10 character
        passwordTextField.getElement().sendKeys(randomString);
        ExplicitWait.elementToBeClickable(signInButtonPassword.getLocator());
        signInButtonPassword.click();
        ExplicitWait.elementToBeVisible(getErrorMessagePassword2.getLocator());
        Assert.assertTrue(getErrorMessagePassword2.isDisplayed(), errorMessageText);

        //Invalid Password 150 character
        passwordTextField.getElement().clear();
        passwordTextField.getElement().sendKeys(randomString2);
        ExplicitWait.elementToBeClickable(signInButtonPassword.getLocator());
        signInButtonPassword.click();
        ExplicitWait.elementToBeVisible(getErrorMessagePassword2.getLocator());
        Assert.assertTrue(getErrorMessagePassword2.isDisplayed(), errorMessageText);

        //Valid Password
        passwordTextField.getElement().clear();
        passwordTextField.getElement().sendKeys(DataReader.getStringValue("password", "TestData"));
        ExplicitWait.elementToBeClickable(signInButtonPassword.getLocator());
        signInButtonPassword.click();
    }

    //LinkedIn mew user --> Worked
    public void linkedInloginNewUser(){
        ExplicitWait.elementToBeClickable(userNameTextField.getLocator());

        linkedInButton.click();
        ExplicitWait.elementToBeClickable(linkedInUserNameButton.getLocator());
        linkedInUserNameButton.getElement().clear();
        linkedInUserNameButton.getElement().sendKeys(DataReader.getStringValue("linkedName", "TestData"));
        ExplicitWait.elementToBeClickable(linkedInPasswordButton.getLocator());
        linkedInPasswordButton.getElement().clear();
        linkedInPasswordButton.getElement().sendKeys(DataReader.getStringValue("linkPass","TestData"));

        ExplicitWait.elementToBeClickable(linkedInSignInButton.getLocator());
        linkedInSignInButton.click();

        ExplicitWait.presenceOfElementLocated(card.getLocator());
        linkedInAllowButton.click();

        ExplicitWait.presenceOfElementLocated(searchField.getLocator());
    }

    public void linkedInloginOLDUser(){
        ExplicitWait.elementToBeClickable(userNameTextField.getLocator());

        linkedInButton.click();
        ExplicitWait.elementToBeClickable(linkedInUserNameButton.getLocator());
        linkedInUserNameButton.getElement().clear();
        linkedInUserNameButton.getElement().sendKeys(DataReader.getStringValue("linkedName", "TestData"));
        ExplicitWait.elementToBeClickable(linkedInPasswordButton.getLocator());
        linkedInPasswordButton.getElement().clear();
        linkedInPasswordButton.getElement().sendKeys(DataReader.getStringValue("linkPass","TestData"));

        ExplicitWait.elementToBeClickable(linkedInSignInButton.getLocator());
        linkedInSignInButton.click();

        ExplicitWait.presenceOfElementLocated(searchField.getLocator());
    }

    //=========================================================//
    //=========================================================//
    public void gamilLoginNewUser() {
        ExplicitWait.presenceOfElementLocated(emailField.getLocator());
        emailField.getElement().sendKeys(DataReader.getStringValue("gmail","TestData"));
        nextButton.click();
        ExplicitWait.presenceOfElementLocated(emailPasswordField.getLocator());
        emailPasswordField.getElement().sendKeys(DataReader.getStringValue("gpassword","TestData"));
        passNextButton.click();

        ExplicitWait.elementToBeClickable(gConfirm.getLocator());
        gConfirm.click();
    }

    public void gamilLoginOldUser(){
        ExplicitWait.elementToBeClickable(userNameTextField.getLocator());

        gmailSignInButton.click();
        emailField.getElement().sendKeys(DataReader.getStringValue("gmail","TestData"));
        nextButton.click();
        emailPasswordField.getElement().sendKeys(DataReader.getStringValue("gpassword","TestData"));
        passNextButton.click();
    }


}
