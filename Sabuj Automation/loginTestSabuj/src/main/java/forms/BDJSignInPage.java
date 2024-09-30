package forms;

import elements.Element;
import org.testng.Assert;
import utility.DataReader;
import utility.RandomStringGenerator;
import utility.threadSleep;
import org.openqa.selenium.By;
import waits.ExplicitWait;

public class BDJSignInPage extends BaseForm {
    private final Element signInDropdownButton = new Element(By.xpath("//li[@class='hidden-xs soca']"));
    private final Element signInButton = new Element(By.xpath("//li[@class='hidden-xs soca open']//div[@class='cart-mbdj-r']//a[@class='btn slu-btn' and contains(text(), 'Sign in')]"));
    private final Element userNameTextField = new Element(By.xpath("//input[@class='form-control br-b']"));
    private final Element continueButton = new Element(By.xpath("//div[@class='col-sm-12']//input[@class='btn btn-success btn-signin']"));
    private final Element passwordTextField = new Element(By.xpath("//input[@class='form-control br-b']"));
    private final Element signInButtonPassword = new Element(By.xpath("//input[@type='submit']"));
    private final Element errorMessage = new Element(By.xpath("//span[@id='errorMessage' and contains(text(), 'Please enter Username, Email or Mobile No.')]"));
    //private final Element getErrorMessage2 = new Element(By.xpath("//span[@id='errorMessage' and contains(text(), \"Couldn't find your Bdjobs account.Click\")]"));
    private final Element getErrorMessage2 = new Element(By.xpath("//span[@id='errorMessage']"));
    private final Element getErrorMessagePassword = new Element(By.xpath("//span[@class='text-danger' and contains(text(), 'Please enter Password.')]"));
    private final Element getErrorMessagePassword2 = new Element(By.xpath("//span[@class='text-danger' and contains(text(), 'Wrong password. Try again or click Forgot password to reset it.')]"));

    RandomStringGenerator generator = new RandomStringGenerator();
    String randomString = generator.generateRandomString(10);
    String randomString2 = generator.generateRandomString(150);
    String errorMessageText = "Error message is not displayed.";

    public BDJSignInPage() {
        super(new Element(By.xpath("//h2[@role='heading']")));
    }

    public void moveCursorSignInDropdown() {
        signInDropdownButton.moveToElement();
    }

    public void clickDropdownOnSignInButton() {
        ExplicitWait.elementToBeClickable(signInDropdownButton.getLocator());
        signInDropdownButton.click();
    }

    public void clickOnSignInButton() {
        ExplicitWait.elementToBeClickable(signInButton.getLocator());
        signInButton.click();
    }

    public void sendingUsernameInEmailField() {
        ExplicitWait.elementToBeClickable(userNameTextField.getLocator());

        //without any value
        continueButton.click();
        threadSleep.threadsleep(1000);
        Assert.assertTrue(errorMessage.isDisplayed(), errorMessageText);

        //invalid value using ten characters
        userNameTextField.getElement().sendKeys(randomString);
        threadSleep.threadsleep(1000);
        continueButton.click();
        threadSleep.threadsleep(1000);
        Assert.assertTrue(getErrorMessage2.isDisplayed(), errorMessageText);

        //invalid value using 101 characters
        userNameTextField.getElement().clear();
        userNameTextField.getElement().sendKeys(randomString2);
        threadSleep.threadsleep(1000);
        continueButton.click();
        threadSleep.threadsleep(1000);
        Assert.assertTrue(getErrorMessage2.isDisplayed(), errorMessageText);

        //valid username
        userNameTextField.getElement().clear();
        userNameTextField.getElement().sendKeys(DataReader.getStringValue("userName", "TestData"));
        threadSleep.threadsleep(1000);
        continueButton.click();
        threadSleep.threadsleep(1000);
    }

    public void sendingPasswordInPasswordField() {
        ExplicitWait.elementToBeClickable(passwordTextField.getLocator());

        //without any value
        signInButtonPassword.click();
        threadSleep.threadsleep(1000);
        Assert.assertTrue(getErrorMessagePassword.isDisplayed(), errorMessageText);

        //Invalid Password
        passwordTextField.getElement().sendKeys(randomString);
        threadSleep.threadsleep(1000);
        signInButtonPassword.click();
        threadSleep.threadsleep(1000);
        Assert.assertTrue(getErrorMessagePassword2.isDisplayed(), errorMessageText);
        threadSleep.threadsleep(1000);

        //Valid Password
        passwordTextField.getElement().clear();
        passwordTextField.getElement().sendKeys(DataReader.getStringValue("password", "TestData"));
        threadSleep.threadsleep(1000);
        signInButtonPassword.click();
        threadSleep.threadsleep(1000);
    }
}
