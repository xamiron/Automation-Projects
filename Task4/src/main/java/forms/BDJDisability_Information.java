package forms;

import elements.Element;
import org.openqa.selenium.By;
import org.testng.Assert;
import waits.ExplicitWait;

public class BDJDisability_Information extends BaseForm{
    private final Element disabilityDropDown = new Element(By.cssSelector("button[data-target='#collapseSix']"));
    private final Element editButton = new Element(By.cssSelector("button[aria-label='Click on Edit to fill up person with disability details']"));
    private final Element noRadioButton = new Element(By.cssSelector("body > div:nth-child(19) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(11) > div:nth-child(1) > div:nth-child(11) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > fieldset:nth-child(1) > label:nth-child(3)"));
    private final Element yesRadioButton = new Element(By.cssSelector("body > div:nth-child(19) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(11) > div:nth-child(1) > div:nth-child(11) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > fieldset:nth-child(1) > label:nth-child(2)"));
    private final Element noIdMessage = new Element(By.cssSelector("#no_id_step_msg"));
    private final Element closeButton = new Element(By.cssSelector("form[id='personalForm'] a[aria-label='Click close to go back to edit resume without saving']"));
    private final Element personalButton = new Element(By.cssSelector("button[data-target='#collapseOne']"));
    private final Element saveButton = new Element(By.cssSelector("body > div:nth-child(19) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(11) > div:nth-child(1) > div:nth-child(11) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(4) > div:nth-child(1) > button:nth-child(1)"));
    private final Element nidTextField = new Element(By.cssSelector("#txtDisabilityId"));
    private final Element nidTextErrorMessage = new Element(By.cssSelector("#txtDisibilityIdErrorMsg"));
    private final Element privacyNo = new Element(By.cssSelector("label[for='PwdoptNo']"));
    private final Element privacyYes= new Element(By.cssSelector("label[for='PwdoptYes']"));


    private final String errorMessageText = "Error message is not displayed.";

    public BDJDisability_Information() {
        super(new Element(By.cssSelector("label[for='txtDisabilityId']")));
    }

    public void noIdCheck() {
        closeButton.getElement().click();
        personalButton.getElement().click();
        disabilityDropDown.scrollUntilElementIsVisible();
        ExplicitWait.elementToBeClickable(disabilityDropDown.getLocator());
        disabilityDropDown.getElement().click();

        //no disability check
        ExplicitWait.elementToBeClickable(editButton.getLocator());
        editButton.getElement().click();
        noRadioButton.getElement().click();
        noIdMessage.getElement().click();
        saveButton.getElement().click();

        //edit button
        ExplicitWait.elementToBeVisible(editButton.getLocator());
        editButton.getElement().click();
        yesRadioButton.getElement().click();
        nidTextField.sendKeysWithDelay("");
        saveButton.getElement().click();
        errorAlternateEmaiLMessageText();

        //invalid special character
        nidTextField.getElement().clear();
        nidTextField.sendKeysWithDelay("@#$%^&*()_+");
        saveButton.getElement().click();
        errorAlternateEmaiLMessageText();

        //invalid character
        nidTextField.getElement().clear();
        nidTextField.sendKeysWithDelay("abcead");
        saveButton.getElement().click();
        errorAlternateEmaiLMessageText();



        nidTextField.getElement().clear();
        nidTextField.sendKeysWithDelay("1234567891");
        //saveButton.getElement().click();


        //privacy if yes
        if (privacyNo.getElement().isSelected()) {
            privacyYes.click();
        } else if (privacyYes.getElement().isSelected()) {

            privacyNo.click();
        }
        saveButton.getElement().click();
    }

    private void errorAlternateEmaiLMessageText(){
        ExplicitWait.elementToBeVisible(nidTextErrorMessage.getLocator());
        Assert.assertTrue(nidTextErrorMessage.isDisplayed(), errorMessageText);
    }

}
