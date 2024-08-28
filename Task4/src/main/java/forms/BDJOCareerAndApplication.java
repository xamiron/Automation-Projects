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
    private final Element alterErrorMessage = new Element(By.cssSelector("#alertDiv_cai"));
    //presentSalary
    private final Element presentSalaryTextField = new Element(By.cssSelector("#txtPresentSalary"));
    private final Element presentSalaryDigitErrorText = new Element(By.cssSelector("#txtPrsnSalaryErrorMsg"));
    //permanenSalary
    private final Element expectedSalaryTextField = new Element(By.cssSelector("#txtExpectedSalary"));
    private final Element expectedSalaryDigitErrorText = new Element(By.cssSelector("#txtExpectedSalaryErrorMsg"));

    private static final String ErrorMessageText = "Error message is not displayed.";

    public BDJOCareerAndApplication() {
        super(new Element(By.cssSelector("#headingThree")));
    }

    public void dropdown(){
        ExplicitWait.elementToBeClickable(careerAndAppDropdown.getLocator());
        careerAndAppDropdown.getElement().click();
    }

    public void careerObjective(){
        //invalid objective
        ExplicitWait.elementToBeVisible(editButton.getLocator());
        editButton.getElement().click();
        ExplicitWait.elementToBeVisible(objectveTextField.getLocator());
        objectveTextField.getElement().clear();
        ExplicitWait.elementToBeVisible(saveButton.getLocator());
        saveButton.getElement().click();
        errorObjectiveTextField();

       //invalid whiteSpace
        ExplicitWait.elementToBeVisible(objectveTextField.getLocator());
        objectveTextField.getElement().clear();
        objectveTextField.sendKeysWithDelay(" ");
        saveButton.getElement().click();
        errorObjectiveTextField();

        //invalid bangla character
        ExplicitWait.elementToBeVisible(objectveTextField.getLocator());
        objectveTextField.getElement().clear();
        objectveTextField.sendKeysWithDelay("হাসিব");
        saveButton.getElement().click();
        errorObjectiveTextFieldTwo();

        //invalid max character check
        ExplicitWait.elementToBeVisible(objectveTextField.getLocator());
        objectveTextField.getElement().clear();
        objectveTextField.sendKeysWithDelay("Objective details of objective.Objective details of objective.Objective details of objective.Objective details of objective.Objective details of objective.Objective details of objective.Objective details of objective.Objective details of objective.Oba");
        ExplicitWait.elementToBeVisible(objectiveErrorMessage.getLocator());
        errorObjectiveTextField();

       // Valid objective
        ExplicitWait.elementToBeVisible(objectveTextField.getLocator());
        objectveTextField.getElement().clear();
        objectveTextField.sendKeysWithDelay("Objective details of objective.");
        saveButton.click();
    }

    public void presentSalary(){
        ExplicitWait.elementToBeClickable(editButton.getLocator());
        editButton.click();

        //invalid salary greater than 10 digit
        ExplicitWait.elementToBeClickable(presentSalaryTextField.getLocator());
        presentSalaryTextField.sendKeysWithDelay("1234567891");
        saveButton.click();
        errorPresentSalaryTextField();

        //invalid 0
        ExplicitWait.elementToBeClickable(presentSalaryTextField.getLocator());
        presentSalaryTextField.getElement().clear();
        presentSalaryTextField.sendKeysWithDelay("0");
        saveButton.click();
        errorPresentSalaryTextField();

        //invalid 999
        ExplicitWait.elementToBeClickable(presentSalaryTextField.getLocator());
        presentSalaryTextField.getElement().clear();
        presentSalaryTextField.sendKeysWithDelay("999");
        saveButton.click();
        errorPresentSalaryTextField();

        //Valid 1000
        ExplicitWait.elementToBeClickable(presentSalaryTextField.getLocator());
        presentSalaryTextField.getElement().clear();
        presentSalaryTextField.sendKeysWithDelay("1000");
        saveButton.click();
    }

    public void expectedSalary(){
        ExplicitWait.elementToBeClickable(editButton.getLocator());
        editButton.click();

        ExplicitWait.elementToBeClickable(expectedSalaryTextField.getLocator());
        if(presentSalaryTextField.isEmpty()){
            presentSalary();
        }

        //invalid expected salary
        expectedSalaryTextField.sendKeysWithDelay("999");
        saveButton.getElement().click();
        errorExpectedSalaryTextField();
    }

    private void errorObjectiveTextField(){
        ExplicitWait.elementToBeClickable(objectiveErrorMessage.getLocator());
        Assert.assertTrue(objectiveErrorMessage.isDisplayed(), ErrorMessageText);
    }
    private void errorObjectiveTextFieldTwo(){
        ExplicitWait.elementToBeClickable(alterErrorMessage.getLocator());
        Assert.assertTrue(alterErrorMessage.isDisplayed(), ErrorMessageText);
    }
    private void errorPresentSalaryTextField(){
        ExplicitWait.elementToBeClickable(presentSalaryDigitErrorText.getLocator());
        Assert.assertTrue(presentSalaryDigitErrorText.isDisplayed(), ErrorMessageText);
    }
    private void errorExpectedSalaryTextField(){
        ExplicitWait.elementToBeClickable(expectedSalaryDigitErrorText.getLocator());
        Assert.assertTrue(expectedSalaryDigitErrorText.isDisplayed(), ErrorMessageText);
    }
}