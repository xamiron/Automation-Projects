package forms;

import elements.Element;
import org.openqa.selenium.By;
import org.testng.Assert;
import waits.ExplicitWait;

public class BDJOCareerAndApplication extends BaseForm{
    private final Element careerAndAppDropdown = new Element(By.cssSelector("#headingThree"));
    private final Element editButton = new Element(By.cssSelector("button[aria-label='Click on Edit to fill up career and application information']"));
   // private final Element editButton = new Element(By.xpath("//button[@aria-label='Click on Edit to fill up career and application information']"));
    private final Element objectiveTextField = new Element(By.cssSelector("#txtObjective"));
    private final Element saveButton = new Element(By.cssSelector("a[aria-label='CLick to save information Application Information']"));
    private final Element objectiveErrorMessage = new Element(By.cssSelector("#txtObjectiveErrorMsg"));
    private final Element alterErrorMessage = new Element(By.cssSelector("#alertDiv_cai"));
    //presentSalary
    private final Element presentSalaryTextField = new Element(By.cssSelector("#txtPresentSalary"));
    private final Element presentSalaryDigitErrorText = new Element(By.cssSelector("#txtPrsnSalaryErrorMsg"));
    //permanenSalary
    private final Element expectedSalaryTextField = new Element(By.cssSelector("#txtExpectedSalary"));
    private final Element expectedSalaryDigitErrorText = new Element(By.cssSelector("#txtExpectedSalaryErrorMsg"));
    //job level
    private final Element entryLevelRadio = new Element(By.cssSelector("label.radio-inline[aria-label='entry level']"));
    private final Element midLevelRadio = new Element(By.cssSelector("label.radio-inline[aria-label='mid level']"));
    private final Element topLevelRadio = new Element(By.cssSelector("label.radio-inline[aria-label='top level']"));
    //job Nature
    private final Element fullTimeRadio = new Element(By.cssSelector("label.radio-inline input[value='Full Time']"));
    private final Element partTimeRadio = new Element(By.cssSelector("label.radio-inline input[value='Part Time']"));
    private final Element ContractRadio = new Element(By.cssSelector("label.radio-inline input[value='Contract']"));
    private final Element internshipRadio = new Element(By.cssSelector("label.radio-inline input[value='Internship']"));
    private final Element freelanceRadio = new Element(By.cssSelector("label.radio-inline input[value='Freelance']"));


    private static final String ErrorMessageText = "Error message is not displayed.";

    public BDJOCareerAndApplication() {
        super(new Element(By.cssSelector("#headingThree")));
    }


    public void careerObjective(){
        ExplicitWait.elementToBeClickable(careerAndAppDropdown.getLocator());
        careerAndAppDropdown.getElement().click();
        ExplicitWait.elementToBeClickable(editButton.getLocator());
        sleep();
        editButton.getElement().click();

        //invalid objective
        ExplicitWait.elementToBeVisible(objectiveTextField.getLocator());
        objectiveTextField.getElement().clear();
        ExplicitWait.elementToBeVisible(saveButton.getLocator());
        saveButton.getElement().click();
        errorObjectiveTextField();

       //invalid whiteSpace
        ExplicitWait.elementToBeVisible(objectiveTextField.getLocator());
        objectiveTextField.getElement().clear();
        objectiveTextField.sendKeysWithDelay(" ");
        saveButton.getElement().click();
        errorObjectiveTextField();

        //invalid bangla character
        ExplicitWait.elementToBeVisible(objectiveTextField.getLocator());
        objectiveTextField.getElement().clear();
        objectiveTextField.sendKeysWithDelay("হাসিব");
        saveButton.getElement().click();
        errorObjectiveTextFieldTwo();

        //invalid max character check
        ExplicitWait.elementToBeVisible(objectiveTextField.getLocator());
        objectiveTextField.getElement().clear();
        objectiveTextField.sendKeysWithDelay("Objective details of objective.Objective details of objective.Objective details of objective.Objective details of objective.Objective details of objective.Objective details of objective.Objective details of objective.Objective details of objective.Oba");
        ExplicitWait.elementToBeVisible(objectiveErrorMessage.getLocator());
        errorObjectiveTextField();

       // Valid objective
        ExplicitWait.elementToBeVisible(objectiveTextField.getLocator());
        objectiveTextField.getElement().clear();
        objectiveTextField.sendKeysWithDelay("Objective details of objective.");
        saveButton.click();
    }

    public void presentSalary(){
//        ExplicitWait.elementToBeClickable(careerAndAppDropdown.getLocator());
//        careerAndAppDropdown.getElement().click();

        ExplicitWait.elementToBeClickable(editButton.getLocator());
        editButton.click();

        //invalid salary greater than 10 digit
        ExplicitWait.elementToBeClickable(presentSalaryTextField.getLocator());
        presentSalaryTextField.getElement().click();
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

    public void expectedSalary() {
//        ExplicitWait.elementToBeClickable(careerAndAppDropdown.getLocator());
//        careerAndAppDropdown.getElement().click();

        ExplicitWait.elementToBeVisible(editButton.getLocator());
        editButton.getElement().click();

        ExplicitWait.elementToBeClickable(expectedSalaryTextField.getLocator());


        expectedSalaryTextField.getElement().clear();

        // Send the invalid expected salary with a slight delay between key presses to simulate human interaction
        expectedSalaryTextField.sendKeysWithDelay("1000000011");
        ExplicitWait.elementToBeClickable(saveButton.getLocator());
        saveButton.click();
        errorExpectedSalaryTextField();

        // valid
        expectedSalaryTextField.getElement().clear();
        expectedSalaryTextField.sendKeysWithDelay("100000000");
        ExplicitWait.elementToBeClickable(saveButton.getLocator());
        saveButton.click();
//        errorExpectedSalaryTextField();
    }

    public void jobLevel(){
        ExplicitWait.elementToBeClickable(editButton.getLocator());
        editButton.getElement().click();

        //entry level
        entryLevelRadio.getElement().click();
        saveButton.getElement().click();

        //mid level
        editButton.getElement().click();
        midLevelRadio.getElement().click();
        saveButton.getElement().click();

        //top level
        editButton.getElement().click();
        topLevelRadio.getElement().click();
        saveButton.getElement().click();
    }

    public void jobNature(){
        ExplicitWait.elementToBeClickable(editButton.getLocator());
        editButton.getElement().click();

        //fulltime
        fullTimeRadio.getElement().click();
        saveButton.getElement().click();

        //partTime
        editButton.getElement().click();
        partTimeRadio.getElement().click();
        saveButton.getElement().click();

        //Contract
        editButton.getElement().click();
        ContractRadio.getElement().click();
        saveButton.getElement().click();

        //internship
        editButton.getElement().click();
        internshipRadio.getElement().click();
        saveButton.getElement().click();

        //Freelance
        editButton.getElement().click();
        freelanceRadio.getElement().click();
        saveButton.getElement().click();
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

    private void sleep() {
        try {
            Thread.sleep(3000); // 3 seconds sleep
        } catch (InterruptedException e) {
            // Handle the exception
            System.out.println("Thread was interrupted: " + e.getMessage());
            Thread.currentThread().interrupt(); // Optional: reset the interrupted status
        }
    }
}