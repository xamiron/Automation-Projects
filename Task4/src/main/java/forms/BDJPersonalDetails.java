package forms;

import elements.Element;
import org.openqa.selenium.By;
import org.testng.Assert;
import utility.DataReader;
import waits.ExplicitWait;

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
    private final Element dob= new Element(By.cssSelector("#txtBirthDate"));
    private final Element dobErrorText= new Element(By.cssSelector("#dobErrorMsg"));
    private final Element genderSelector= new Element(By.cssSelector("#cboGender"));
    private final Element genderSelectorErrorText= new Element(By.cssSelector("#gdrErrorMsg"));
    private final Element genderOptionSelect= new Element(By.cssSelector("select#cboGender > option[value='-1']"));
    private final Element genderOptionMale = new Element(By.cssSelector("select#cboGender > option[value='M']"));
    private final Element genderOptionFemale= new Element(By.cssSelector("select#cboGender > option[value='F']"));
    private final Element genderOptionOther= new Element(By.cssSelector("select#cboGender > option[value='O']"));
    private final Element religionSelector = new Element(By.cssSelector("#txtReligion"));
   // private final Element getReligionSelectorErrorText= new Element(By.cssSelector(""));
    private final Element religionSelect = new Element(By.cssSelector("select#txtReligion > option[value='-1']"));
    private final Element religionBuddhism=  new Element(By.cssSelector("select#txtReligion > option[value='Buddhism']"));
    private final Element religionChristianity = new Element(By.cssSelector("select#txtReligion > option[value='Christianity']"));
    private final Element religionHinduism= new Element(By.cssSelector("select#txtReligion > option[value='Hinduism']"));
    private final Element religionIslam = new Element(By.cssSelector("select#txtReligion > option[value='Islam']"));
    private final Element religionJainism = new Element(By.cssSelector("select#txtReligion > option[value='Jainism']"));
    private final Element religionJudaism = new Element(By.cssSelector("select#txtReligion > option[value='Judaism']"));
    private final Element religionSikhism = new Element(By.cssSelector("select#txtReligion > option[value='Sikhism']"));
    private final Element religionOthers = new Element(By.cssSelector("select#txtReligion > option[value='Others']"));



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
        firstName.sendKeysWithDelay("Avarya");
        saveButton.getElement().click();
    }

    public void lastName(){
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // invalid numeric character
        editButton.getElement().click();
        lastName.sendKeysWithDelay("0123");
        saveButton.getElement().click();
        errorLastNameMessageText();

        //invalid special character
        lastName.getElement().click();
        lastName.getElement().clear();
        lastName.sendKeysWithDelay(DataReader.getStringValue("specialCharacter", "TestData"));
        saveButton.getElement().click();
        errorLastNameMessageText();

        //invalid maxCharacter
        lastName.getElement().clear();
        lastName.sendKeysWithDelay(DataReader.getStringValue("maxCharacter", "TestData"));
        saveButton.getElement().click();
        errorLastNameMessageText();

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
        errorFatherNameMessageText();

        // invalid special character
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay(DataReader.getStringValue("specialCharacter", "TestData"));
        saveButton.click();
        errorFatherNameMessageText();

        // invalid max character
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay(DataReader.getStringValue("maxCharacter", "TestData"));
        saveButton.click();
        errorFatherNameMessageText();

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
        editButton.getElement().click();
        motherName.getElement().click();
        motherName.getElement().clear();
        motherName.sendKeysWithDelay("1234586");
        saveButton.getElement().click();
        errorMotherMessageText();

        // invalid special character
        motherName.getElement().clear();
        motherName.sendKeysWithDelay(DataReader.getStringValue("specialCharacter", "TestData"));
        saveButton.getElement().click();
        errorMotherMessageText();

        // invalid max character
        motherName.getElement().clear();
        motherName.sendKeysWithDelay(DataReader.getStringValue("maxCharacter", "TestData"));
        saveButton.getElement().click();
        errorMotherMessageText();

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

    public void dob(){
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        //invalid empty name
        editButton.getElement().click();
        dob.getElement().click();
        dob.getElement().clear();
        saveButton.click();
        errorDobErrorMessageText();

        //invalid white space
        dob.getElement().clear();
        dob.sendKeysWithDelay("  ");
        saveButton.click();
        errorDobErrorMessageText();

        //invalid character
        dob.getElement().clear();
        dob.sendKeysWithDelay("abc");
        saveButton.click();
        errorDobErrorMessageText();

        //invalid numeric character
        dob.getElement().clear();
        dob.sendKeysWithDelay("123");
        saveButton.click();
        errorDobErrorMessageText();


        //invalid special character
        dob.getElement().clear();
        dob.sendKeysWithDelay(DataReader.getStringValue("specialCharacter", "TestData"));
        saveButton.click();
        errorDobErrorMessageText();

        //ivalid bangla character
        dob.getElement().clear();
        dob.sendKeysWithDelay("হাসিব");
        saveButton.click();
        errorDobErrorMessageText();

        //invalid max character
        dob.getElement().clear();
        dob.sendKeysWithDelay(DataReader.getStringValue("maxCharacter", "TestData"));
        saveButton.click();
        errorDobErrorMessageText();

        //valid dob
        dob.getElement().clear();
        dob.sendKeysWithDelay(DataReader.getStringValue("dob","TestData"));
        saveButton.click();
    }
    public void gender() {
        try {
            // invalid gender Select
            editButton.getElement().click();
            genderSelector.getElement().click();
            genderOptionSelect.click();
            Thread.sleep(2000);
            saveButton.getElement().click();
            errorGenderMEssageText();

            // valid gender Male
            genderSelector.getElement().click();
            genderOptionMale.getElement().click();
            Thread.sleep(2000);
            saveButton.getElement().click();

            // valid gender Other
            editButton.getElement().click();
            genderOptionOther.getElement().click();
            Thread.sleep(2000);
            saveButton.getElement().click();

            // valid gender Female
            editButton.getElement().click();
            genderOptionFemale.getElement().click();
            Thread.sleep(2000);
            saveButton.getElement().click();
        } catch (InterruptedException e) {
            // Handle the exception (log it or rethrow it)
            e.printStackTrace();
        }
    }

    public void gender() {
        try {
        } catch (InterruptedException e) {
            // Handle the exception (log it or rethrow it)
            e.printStackTrace();
        }
    }


    private void errorMessageText() {
        ExplicitWait.elementToBeVisible(fNameErrorMessage.getLocator());
        Assert.assertTrue(fNameErrorMessage.isDisplayed(), errorMessageText);
    }
    private void errorLastNameMessageText(){
        ExplicitWait.elementToBeVisible(lNameErrorMessage.getLocator());
        Assert.assertTrue(lNameErrorMessage.isDisplayed(), errorMessageText);
    }
    private void errorFatherNameMessageText(){
        ExplicitWait.elementToBeVisible(fatherErrorText.getLocator());
        Assert.assertTrue(fatherErrorText.isDisplayed(), errorMessageText);
    }
    private void errorMotherMessageText(){
        ExplicitWait.elementToBeVisible(motherErrorText.getLocator());
        Assert.assertTrue(motherErrorText.isDisplayed(), errorMessageText);
    }
    private void errorDobErrorMessageText(){
        ExplicitWait.elementToBeVisible(dobErrorText.getLocator());
        Assert.assertTrue(dobErrorText.isDisplayed(), errorMessageText);
    }
    private void errorGenderMEssageText(){
        ExplicitWait.elementToBeVisible(genderSelectorErrorText.getLocator());
        Assert.assertTrue(genderSelectorErrorText.isDisplayed(), errorMessageText);
    }

}
