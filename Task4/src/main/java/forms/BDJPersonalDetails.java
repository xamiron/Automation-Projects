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
    private final Element fNameErrorMessage = new Element(By.cssSelector("#fnameErrorMsg"));
    private final Element lastName = new Element(By.cssSelector("#txtLastName"));
    private final Element editButton = new Element(By.cssSelector("button[aria-label='Click on Edit to fill up personal details']"));
    private final Element lNameErrorMessage = new Element(By.cssSelector("#lnameErrorMsg"));
    private final Element fatherName= new Element(By.cssSelector("#txtFName"));
    private final Element fatherErrorText= new Element(By.cssSelector("#fhrErrorMsg"));
    private final Element motherName= new Element(By.cssSelector("#txtMName"));
    private final Element motherErrorText = new Element(By.cssSelector("#mhrErrorMsg"));

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
        firstName.sendKeysWithDelay("Ava'r.y-a");
        saveButton.getElement().click();
    }

    public void lastName(){
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // invalid numeric character
        editButton.getElement().click();
        lastName.sendKeysWithDelay("0123");
        saveButton.getElement().click();
        errorLastNameMessateText();

        //invalid special character
        lastName.getElement().click();
        lastName.getElement().clear();
        lastName.sendKeysWithDelay(DataReader.getStringValue("specialCharacter", "TestData"));
        saveButton.getElement().click();
        errorLastNameMessateText();

        //invalid maxCharacter
        lastName.getElement().clear();
        lastName.sendKeysWithDelay(DataReader.getStringValue("maxCharacter", "TestData"));
        saveButton.getElement().click();
        errorLastNameMessateText();

        //valid empty name
        lastName.getElement().click();
        lastName.getElement().clear();
        saveButton.getElement().click();

        // valid white-space character
        editButton.getElement().click();
        lastName.getElement().clear();
        lastName.sendKeysWithDelay("   ");
        saveButton.getElement().click();

        //valid name
        editButton.getElement().click();
        lastName.getElement().clear();
        lastName.sendKeysWithDelay("Mondal");
        saveButton.getElement().click();
    }

    public void fatherName(){
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // invalid numeric character
        editButton.getElement().click();
        fatherName.getElement().click();
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay("11a231");
        saveButton.click();
        errorFatherNameMessateText();

        // invalid special character
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay(DataReader.getStringValue("specialCharacter", "TestData"));
        saveButton.click();
        errorFatherNameMessateText();

        // invalid max character
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay(DataReader.getStringValue("maxCharacter", "TestData"));
        saveButton.click();
        errorFatherNameMessateText();

        // valid empty
        fatherName.getElement().clear();
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // valid white space
        editButton.getElement().click();
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay("  ");
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // valid name
        editButton.getElement().click();
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay("fatherName");
        saveButton.click();
    }

    public void motherName(){
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // invalid numeric character
        editButton.click();
        ExplicitWait.presenceOfElementLocated(motherErrorText.getLocator());
        motherName.click();
        motherName.getElement().clear();
        motherName.sendKeysWithDelay("1234586");
        saveButton.click();
        erroMotherMessageText();

        // invalid special character
        motherName.getElement().clear();
        motherName.sendKeysWithDelay(DataReader.getStringValue("specialCharacter", "TestData"));
        saveButton.click();
        erroMotherMessageText();

        // invalid max character
        motherName.getElement().clear();
        motherName.sendKeysWithDelay(DataReader.getStringValue("maxCharacter", "TestData"));
        saveButton.click();
        erroMotherMessageText();

        // valid empty
        motherName.getElement().clear();
        motherName.sendKeysWithDelay("");
        saveButton.click();

        // valid white space
        editButton.click();
        motherName.getElement().clear();
        motherName.sendKeysWithDelay(" ");
        saveButton.click();


        // valid name
        editButton.click();
        motherName.getElement().clear();
        motherName.sendKeysWithDelay("motherName");
        saveButton.click();
    }

    private void errorMessageText() {
        ExplicitWait.elementToBeVisible(fNameErrorMessage.getLocator());
        Assert.assertTrue(fNameErrorMessage.isDisplayed(), errorMessageText);
    }
    private void errorLastNameMessateText(){
        ExplicitWait.elementToBeVisible(lNameErrorMessage.getLocator());
        Assert.assertTrue(lNameErrorMessage.isDisplayed(), errorMessageText);
    }
    private void errorFatherNameMessateText(){
        ExplicitWait.elementToBeVisible(fatherErrorText.getLocator());
        Assert.assertTrue(fatherErrorText.isDisplayed(), errorMessageText);
    }
    private void erroMotherMessageText(){
        ExplicitWait.elementToBeVisible(motherErrorText.getLocator());
        Assert.assertTrue(fatherErrorText.isDisplayed(), errorMessageText);
    }


}
