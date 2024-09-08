package forms;

import elements.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    private final Element privacyNoActive = new Element(By.cssSelector("label.btn.btn-primary.active[for='PwdoptYes']"));
    private final Element privacyYes= new Element(By.cssSelector("label[for='PwdoptYes']"));
    private final Element privacyYesActive = new Element(By.cssSelector("label.btn.btn-primary.btn-grey.active[for='PwdoptNo']"));

    WebDriver driver;
    private final String errorMessageText = "Error message is not displayed.";

    public BDJDisability_Information() {
        super(new Element(By.cssSelector("label[for='txtDisabilityId']")));
        this.driver = driver;

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
        errorAlternateEmailMessageText();

        //invalid special character
        nidTextField.getElement().clear();
        nidTextField.sendKeysWithDelay("@#$%^&*()_+");
        saveButton.getElement().click();
//        errorAlternateEmaiLMessageText();

        //invalid character
        editButton.getElement().click();
        nidTextField.getElement().clear();
        nidTextField.sendKeysWithDelay("abcead");
        saveButton.getElement().click();
        errorAlternateEmailMessageText();


        //valid
        nidTextField.getElement().clear();
        nidTextField.sendKeysWithDelay("1234567891");
        saveButton.getElement().click();



    }

//    public void showResume() {
//        // Click the edit button to modify privacy settings
//        editButton.getElement().click();
//
//        // Check if the "No" radio button is selected
//        if (privacyNoActive.getElement().isSelected()) {
//            // If "No" is selected, click the "Yes" option
//            privacyYes.getElement().click();
//        } else if (privacyYesActive.getElement().isSelected()) {
//            // If "Yes" is selected, click the "No" option
//            privacyNo.getElement().click();
//        }
//
//        // Save the changes
//        saveButton.getElement().click();
//    }


    public void togglePrivacyOption() {
        try {
            editButton.getElement().click();
            System.out.println("Clicked on edit button.");

            WebElement currentSelection = driver.findElement(By.id("spanDisabilityIsShown"));
            String currentText = currentSelection.getText().trim();
            System.out.println("Current selection: " + currentText);

            Element yesOption = new Element(By.cssSelector("label.btn.btn-primary[for='PwdoptYes']"));
            Element noOption = new Element(By.cssSelector("label.btn.btn-primary.btn-grey[for='PwdoptNo']"));

            if (currentText.equals("Yes")) {
                noOption.getElement().click();
                System.out.println("Clicked on No option.");
            } else if (currentText.equals("No")) {
                yesOption.getElement().click();
                System.out.println("Clicked on Yes option.");
            }

            saveButton.getElement().click();
            System.out.println("Clicked on save button.");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
    

    private void errorAlternateEmailMessageText(){
        ExplicitWait.elementToBeVisible(nidTextErrorMessage.getLocator());
        Assert.assertTrue(nidTextErrorMessage.isDisplayed(), errorMessageText);
    }

}
