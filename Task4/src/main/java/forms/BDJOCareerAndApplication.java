package forms;

import elements.Element;
import org.openqa.selenium.By;
import org.testng.Assert;
import waits.ExplicitWait;

public class BDJOCareerAndApplication extends BaseForm{
    private final Element careerAndAppDropdown = new Element(By.cssSelector("#headingThree"));
    private final Element editButton = new Element(By.cssSelector("button[aria-label='Click on Edit to fill up career and application information']"));
    private final Element objectveTextField = new Element(By.cssSelector("#txtObjective"));
    private final Element saveButton = new Element(By.cssSelector("a[aria-label='CLick to save information Application Information']"));
    private final Element objectiveErrorMessage = new Element(By.cssSelector("#txtObjectiveErrorMsg"));

    private final String errorMessageText = "Error message is not displayed.";

    public BDJOCareerAndApplication() {
        super(new Element(By.cssSelector("#headingThree")));
    }

    public void careerObjective(){
        ExplicitWait.elementToBeClickable(careerAndAppDropdown.getLocator());
        careerAndAppDropdown.getElement().click();

        //invalid objective
        ExplicitWait.elementToBeVisible(editButton.getLocator());
        editButton.getElement().click();
        ExplicitWait.elementToBeVisible(objectveTextField.getLocator());
        objectveTextField.getElement().clear();
        saveButton.getElement().click();
        errorObjectiveTextField();

        //invalid whitespace
//        ExplicitWait.elementToBeVisible(objectveTextField.getLocator());
//        objectveTextField.getElement().clear();
//        objectveTextField.sendKeysWithDelay(" ");
//        saveButton.getElement().click();
//        errorObjectiveTextField();
    }

    private void errorObjectiveTextField(){
        ExplicitWait.elementToBeClickable(objectiveErrorMessage.getLocator());
        Assert.assertTrue(objectiveErrorMessage.isDisplayed(),errorMessageText);
    }
}