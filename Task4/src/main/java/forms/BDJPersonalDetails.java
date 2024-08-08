package forms;

import elements.Element;
import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.By;
import org.testng.Assert;
import utility.DataReader;
import waits.ExplicitWait;

import javax.xml.crypto.Data;
import java.awt.*;

public class BDJPersonalDetails extends BaseForm{
    private final Element firstName = new Element(By.cssSelector("#txtFirstName"));
    private final Element saveButton = new Element(By.cssSelector("body > div:nth-child(19) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(11) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > form:nth-child(3) > div:nth-child(2) > div:nth-child(1) > a:nth-child(1)"));
    private final Element emptyErrorMessage = new Element(By.cssSelector("#fnameErrorMsg"));
    private final Element lastName = new Element(By.cssSelector("#txtLastName"));
    private final Element editButton = new Element(By.cssSelector("button[aria-label='Click on Edit to fill up personal details']"));

    private final String errorMessageText = "Error message is not displayed.";
    public BDJPersonalDetails(){
        super(new Element(By.cssSelector("button[aria-label='Click Personal section to add or edit your personal information in resume']")));
    }

    public void firstName(){
        ExplicitWait.elementToBeClickable(firstName.getLocator());

        // invalid empty name
        firstName.getElement().clear();
        saveButton.getElement().click();
        errorMessageText();

        // invalid whiteSpace
        firstName.getElement().clear();
        firstName.sendKeysWithDelay(" ");
        saveButton.getElement().click();
        errorMessageText();

        // invalid specialCharacter
        firstName.getElement().clear();
        firstName.sendKeysWithDelay(DataReader.getStringValue("specialCharacter", "TestData"));
        saveButton.getElement().click();
        errorMessageText();

        // invalid NumericCharacter
        firstName.getElement().clear();
        firstName.getElement().click();
        firstName.sendKeysWithDelay("0123");
        saveButton.getElement().click();
        errorMessageText();

        // invalid maxCharacter
        firstName.getElement().clear();
        firstName.getElement().click();
        firstName.sendKeysWithDelay(DataReader.getStringValue("maxCharacter", "TestData"));
        saveButton.getElement().click();
        errorMessageText();

        // valid combination
        firstName.getElement().clear();
        firstName.getElement().click();
        firstName.sendKeysWithDelay("Avary.-'a");
        saveButton.getElement().click();
    }

    public void lastName(){
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        editButton.getElement().click();
        ExplicitWait.elementToBeClickable(lastName.getLocator());
        lastName.getElement().click();
        lastName.getElement().clear();
        saveButton.getElement().click();

    }


    private void errorMessageText() {
        ExplicitWait.elementToBeVisible(emptyErrorMessage.getLocator());
        Assert.assertTrue(emptyErrorMessage.isDisplayed(), errorMessageText);
    }

}
