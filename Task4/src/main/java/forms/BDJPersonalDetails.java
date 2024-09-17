package forms;

import elements.Element;
import net.bytebuddy.matcher.ElementMatcher;
import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.By;
import org.testng.Assert;
import utility.DataReader;
import waits.ExplicitWait;

public class BDJPersonalDetails extends BaseForm{
    private final Element firstName = new Element(By.cssSelector("#txtFirstName"));
    private final Element saveButton = new Element(By.xpath("//a[@id='perbtn-save']"));
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
    private final Element maritalSelector = new Element(By.cssSelector("#cboMStatus"));
    private final Element maritalSelect = new Element(By.cssSelector("select#cboMStatus > option[value='-1']"));
    private final Element martialErrorText = new Element(By.cssSelector("#mtsErrorMsg"));
    private final Element maritalUnmarried = new Element(By.cssSelector("select#cboMStatus > option[value='2']"));
    private final Element maritalMarried = new Element(By.cssSelector("select#cboMStatus > option[value='1']"));
    private final Element maritalSingle = new Element(By.cssSelector("select#cboMStatus > option[value='3']"));
    private final Element nationalityField = new Element(By.cssSelector("input#otherNationality"));
    private final Element nationalityErrorText = new Element(By.cssSelector("#otherNationalityErrorMsg"));
    private final Element bangladeshiCheckbox = new Element(By.cssSelector("input#bangladeshi"));
    private final Element nationalIDField= new Element(By.cssSelector("#txtNationalId"));
    private final Element nationalIDFieldErrorText = new Element(By.cssSelector("#nidErrorMsg"));
    private final Element passportField= new Element(By.cssSelector("#passportNo"));
    private final Element passportFieldErrorText= new Element(By.cssSelector("#passNoErrorMsg"));
    private final Element passportIssueDate = new Element(By.cssSelector("input#issueDate"));
    private final Element passportIssueErrorText = new Element(By.cssSelector("#passIssdateErrorMsg"));
    private final Element primaryNumberField = new Element(By.cssSelector("input#txtMobile"));
    private final Element primaryNumberFieldErrorText = new Element(By.cssSelector("#txtMob1ErrorMsg"));
    private final Element secondNumberField = new Element(By.cssSelector("#txtPhone_H"));
    private final Element secondNumberFieldErrorText = new Element(By.cssSelector("#txtPhoneHmeErrorMsg"));
    private final Element emergencyNumberField = new Element(By.cssSelector("#txtPhone_Off"));
    private final Element emergencyNumberErrorText = new Element(By.cssSelector("#txtPhoneoffErrorMsg"));
    private final Element countryDropdownSelector = new Element(By.cssSelector("#txtCountryCode"));
    private final Element countryBangladesh= new Element(By.cssSelector("select#txtCountryCode> option[value='88']"));
    private final Element primaryEmailField= new Element(By.cssSelector("#txtEmail1"));
    private final Element changeUserIDField = new Element(By.xpath("//span[normalize-space()='Change User Id']"));
    private final Element primaryEmailFieldErrorText = new Element(By.cssSelector("#txtemail1ErrorMsg"));
    private final Element alternateEmailField = new Element(By.cssSelector("#txtEmail2"));
    private final Element alternateEmailFieldErrorText = new Element(By.cssSelector("#altMailErrorMsg"));
    private final Element bloodSelector= new Element(By.cssSelector("#txtBloodGroup"));
    private final Element bloodSelect = new Element(By.cssSelector("select#txtBloodGroup> option[value='-1']"));
    private final Element bloodAPos = new Element(By.cssSelector("select#txtBloodGroup> option[value='A+']"));
    private final Element bloodANeg = new Element(By.cssSelector("select#txtBloodGroup> option[value='A-']"));
    private final Element bloodBPos= new Element(By.cssSelector("select#txtBloodGroup> option[value='B+']"));
    private final Element bloodBNeg = new Element(By.cssSelector("select#txtBloodGroup> option[value='B-']"));
    private final Element bloodOPos= new Element(By.cssSelector("select#txtBloodGroup> option[value='O+']"));
    private final Element bloodONeg= new Element(By.cssSelector("select#txtBloodGroup> option[value='O-']"));
    private final Element bloodABPos=new Element(By.cssSelector("select#txtBloodGroup> option[value='AB+']"));
    private final Element bloodABNeg = new Element(By.cssSelector("select#txtBloodGroup> option[value='AB-']"));

    private final String errorMessageText = "Error message is not displayed.";

    public BDJPersonalDetails(){
        super(new Element(By.cssSelector("button[aria-label='Click Personal section to add or edit your personal information in resume']")));
    }

    //tc wise done
    public void firstName(){
        ExplicitWait.elementToBeClickable(firstName.getLocator());

        // invalid empty name
        firstName.getElement().clear();
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorMessageText();

        // invalid whiteSpace
        firstName.getElement().clear();
        firstName.sendKeys(" ");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorMessageText();

        // invalid specialCharacter
        firstName.getElement().clear();
        firstName.sendKeys(DataReader.getStringValue("specialCharacter", "TestData"));
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorMessageText();

        // invalid NumericCharacter
        firstName.getElement().clear();
        firstName.getElement().click();
        firstName.sendKeys("12458641");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorMessageText();

        // invalid maxCharacter
        firstName.getElement().clear();
        firstName.getElement().click();
        firstName.sendKeys(DataReader.getStringValue("maxCharacter", "TestData"));
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorMessageText();

        // invalid maxCharacter
        firstName.getElement().clear();
        firstName.getElement().click();
        firstName.sendKeys("145.4545");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorMessageText();

        // invalid maxCharacter
        firstName.getElement().clear();
        firstName.getElement().click();
        firstName.sendKeys("1,234.568");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorMessageText();

        // invalid maxCharacter
        firstName.getElement().clear();
        firstName.getElement().click();
        firstName.sendKeys("1,234.568");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorMessageText();

        // invalid maxCharacter
        firstName.getElement().clear();
        firstName.getElement().click();
        firstName.sendKeys("east wes(){}*");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorMessageText();

        // invalid maxCharacter
        firstName.getElement().clear();
        firstName.getElement().click();
        firstName.sendKeysWithDelay(" <p>east west;</p>");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorMessageText();

        //valid white space left
        firstName.getElement().clear();
        firstName.getElement().click();
        firstName.sendKeysWithDelay("    Avarya");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        // valid combination
        editButton.getElement().click();
        firstName.getElement().clear();
        firstName.getElement().click();
        firstName.sendKeysWithDelay("Avarya     ");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        // valid combination
        editButton.getElement().click();
        firstName.getElement().clear();
        firstName.getElement().click();
        firstName.sendKeysWithDelay("ASSDcadfa");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        //valid white space left
        editButton.getElement().click();
        firstName.getElement().clear();
        firstName.getElement().click();
        firstName.sendKeysWithDelay("qwert");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        //valid white space left
        editButton.getElement().click();
        firstName.getElement().clear();
        firstName.getElement().click();
        firstName.sendKeysWithDelay("asdfasdfadgfazsdcvfasdfdfffffffffffffffffggggggggg");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        //valid white space left
        editButton.getElement().click();
        firstName.getElement().clear();
        firstName.getElement().click();
        firstName.sendKeysWithDelay("AVDFCD");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        //valid white space left
        editButton.getElement().click();
        firstName.getElement().clear();
        firstName.getElement().click();
        firstName.sendKeysWithDelay("asfadgaf");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        // valid combination
        editButton.getElement().click();
        firstName.getElement().clear();
        firstName.getElement().click();
        firstName.sendKeysWithDelay("Avarya");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
    }

    //tc wise done
    public void lastName(){
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // valid empty name
        editButton.getElement().click();
        lastName.getElement().clear();
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        // invalid whiteSpace
        editButton.scrollUntilElementIsVisible();
        editButton.getElement().click();
        lastName.getElement().clear();
        lastName.sendKeysWithDelay(" ");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        // invalid specialCharacter
        editButton.scrollUntilElementIsVisible();
        editButton.getElement().click();
        lastName.getElement().clear();
        lastName.sendKeysWithDelay(DataReader.getStringValue("specialCharacter", "TestData"));
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorLastNameMessageText();

        // invalid NumericCharacter
        lastName.getElement().clear();
        lastName.getElement().click();
        lastName.sendKeysWithDelay("12458641");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorLastNameMessageText();

        // invalid maxCharacter
        lastName.getElement().clear();
        lastName.getElement().click();
        lastName.sendKeysWithDelay(DataReader.getStringValue("maxCharacter", "TestData"));
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorLastNameMessageText();

        // invalid maxCharacter
        lastName.getElement().clear();
        lastName.getElement().click();
        lastName.sendKeysWithDelay("145.4545");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorLastNameMessageText();

        // invalid maxCharacter
        lastName.getElement().clear();
        lastName.getElement().click();
        lastName.sendKeysWithDelay("1,234.568");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorLastNameMessageText();

        // invalid maxCharacter
        lastName.getElement().clear();
        lastName.getElement().click();
        lastName.sendKeysWithDelay("1,234.568");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorLastNameMessageText();

        // invalid maxCharacter
        lastName.getElement().clear();
        lastName.getElement().click();
        lastName.sendKeysWithDelay("east wes(){}*");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorLastNameMessageText();

        // invalid maxCharacter
        lastName.getElement().clear();
        lastName.getElement().click();
        lastName.sendKeysWithDelay(" <p>east west;</p>");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorLastNameMessageText();

        //valid white space left
        lastName.getElement().clear();
        lastName.getElement().click();
        lastName.sendKeysWithDelay("    Avarya");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        // valid combination
        editButton.getElement().click();
        lastName.getElement().clear();
        lastName.getElement().click();
        lastName.sendKeysWithDelay("Avarya     ");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        // valid combination
        editButton.getElement().click();
        lastName.getElement().clear();
        lastName.getElement().click();
        lastName.sendKeysWithDelay("ASSDcadfa");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        //valid white space left
        editButton.getElement().click();
        lastName.getElement().clear();
        lastName.getElement().click();
        lastName.sendKeysWithDelay("qwert");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        //valid white space left
        editButton.getElement().click();
        lastName.getElement().clear();
        lastName.getElement().click();
        lastName.sendKeysWithDelay("asdfasdfadgfazsdcvfasdfdfffffffffffffffffggggggggg");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        //valid white space left
        editButton.getElement().click();
        lastName.getElement().clear();
        lastName.getElement().click();
        lastName.sendKeysWithDelay("AVDFCD");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        //valid white space left
        editButton.getElement().click();
        lastName.getElement().clear();
        lastName.getElement().click();
        lastName.sendKeysWithDelay("asfadgaf");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        // valid combination
        editButton.getElement().click();
        lastName.getElement().clear();
        lastName.getElement().click();
        lastName.sendKeysWithDelay("Internal Test Account for My Bdjobs");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
    }

    //tc wise done
    public void fatherName(){
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // invalid numeric character
        editButton.getElement().click();
        fatherName.getElement().click();
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay("11a231");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        errorFatherNameMessageText();

        // invalid special character
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay(DataReader.getStringValue("specialCharacter", "TestData"));
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        errorFatherNameMessageText();

        // invalid max character
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay(DataReader.getStringValue("maxCharacter", "TestData"));
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        errorFatherNameMessageText();

        // invalid max character
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay("145.4545");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        errorFatherNameMessageText();

        // invalid max character
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay("1,23.568");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        errorFatherNameMessageText();

        // invalid max character
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay("east wes(){}*");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        errorFatherNameMessageText();

        // invalid max character
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay("<p>east west;</p>");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        errorFatherNameMessageText();

        // valid empty
        fatherName.getElement().clear();
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // valid white space
        editButton.getElement().click();
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay("  ");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // valid white space
        editButton.getElement().click();
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay("ASSDcadfa");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // valid white space
        editButton.getElement().click();
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay("AVDFCD");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // valid white space
        editButton.getElement().click();
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay("asfadgaf");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());


        // valid white space before character
        editButton.getElement().click();
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay("        abcdes");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // valid white space before character
        editButton.getElement().click();
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay("qwert");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // valid name
        editButton.getElement().click();
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay("fatherName");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
    }
    public void motherName(){
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // invalid numeric character
        editButton.getElement().click();
        motherName.getElement().click();
        motherName.getElement().clear();
        motherName.sendKeysWithDelay("11a231");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        errorMotherMessageText();

        // invalid special character
        motherName.getElement().clear();
        motherName.sendKeysWithDelay(DataReader.getStringValue("specialCharacter", "TestData"));
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        errorMotherMessageText();

        // invalid max character
        motherName.getElement().clear();
        motherName.sendKeysWithDelay(DataReader.getStringValue("maxCharacter", "TestData"));
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        errorMotherMessageText();

        // invalid max character
        motherName.getElement().clear();
        motherName.sendKeysWithDelay("145.4545");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        errorMotherMessageText();

        // invalid max character
        motherName.getElement().clear();
        motherName.sendKeysWithDelay("1,23.568");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        errorMotherMessageText();

        // invalid max character
        motherName.getElement().clear();
        motherName.sendKeysWithDelay("east wes(){}*");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        errorMotherMessageText();

        // invalid max character
        motherName.getElement().clear();
        motherName.sendKeysWithDelay("<p>east west;</p>");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        errorMotherMessageText();

        // valid empty
        motherName.getElement().clear();
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // valid white space
        editButton.getElement().click();
        motherName.getElement().clear();
        motherName.sendKeysWithDelay("  ");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // valid white space
        editButton.getElement().click();
        motherName.getElement().clear();
        motherName.sendKeysWithDelay("ASSDcadfa");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // valid white space
        editButton.getElement().click();
        motherName.getElement().clear();
        motherName.sendKeysWithDelay("AVDFCD");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // valid white space
        editButton.getElement().click();
        motherName.getElement().clear();
        motherName.sendKeysWithDelay("asfadgaf");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());


        // valid white space before character
        editButton.getElement().click();
        motherName.getElement().clear();
        motherName.sendKeysWithDelay("        abcdes");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // valid white space before character
        editButton.getElement().click();
        motherName.getElement().clear();
        motherName.sendKeysWithDelay("qwert");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // valid name
        editButton.getElement().click();
        motherName.getElement().clear();
        motherName.sendKeysWithDelay("motherName");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
    }

    //tc wise done
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

        //invalid date pattern
        dob.getElement().clear();
        dob.sendKeysWithDelay("2024/07/01");
        saveButton.click();
        errorDobErrorMessageText();

        //invalid date patter
        dob.getElement().clear();
        dob.sendKeysWithDelay("18/08/2024");
        saveButton.click();
        errorDobErrorMessageText();

        //invalid date smaller 12 to 85 years.
        dob.getElement().clear();
        dob.sendKeysWithDelay("18/08/2019");
        saveButton.click();
        errorDobErrorMessageText();

        //invalid date greater than 85 years.
        dob.getElement().clear();
        dob.sendKeysWithDelay("18/07/1939");
        saveButton.click();
        errorDobErrorMessageText();

        //valid dob
        dob.getElement().clear();
        dob.sendKeysWithDelay(DataReader.getStringValue("dob","TestData"));
        saveButton.click();
    }

    //tc wise done
    public void gender() {
        try {
            // invalid gender Select
            editButton.getElement().click();
            genderSelector.getElement().click();
            genderOptionSelect.click();
            Thread.sleep(2000);
            saveButton.getElement().click();
            errorGenderMessageText();

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

    //tc wise done
    public void religion() {
        try {
            editButton.getElement().click();
            religionSelector.getElement().click();
            religionSelect.getElement().click();
            Thread.sleep(2000);
            saveButton.getElement().click();

            editButton.getElement().click();
            religionSelector.getElement().click();
            religionBuddhism.getElement().click();
            Thread.sleep(2000);
            saveButton.getElement().click();

            editButton.getElement().click();
            religionSelector.getElement().click();
            religionChristianity.getElement().click();
            Thread.sleep(2000);
            saveButton.getElement().click();

            editButton.getElement().click();
            religionSelector.getElement().click();
            religionHinduism.getElement().click();
            Thread.sleep(2000);
            saveButton.getElement().click();

            editButton.getElement().click();
            religionSelector.getElement().click();
            religionIslam.getElement().click();
            Thread.sleep(2000);
            saveButton.getElement().click();

            editButton.getElement().click();
            religionSelector.getElement().click();
            religionJainism.getElement().click();
            Thread.sleep(2000);
            saveButton.getElement().click();

            editButton.getElement().click();
            religionSelector.getElement().click();
            religionJudaism.getElement().click();
            Thread.sleep(2000);
            saveButton.getElement().click();

            editButton.getElement().click();
            religionSelector.getElement().click();
            religionSikhism.getElement().click();
            Thread.sleep(2000);
            saveButton.getElement().click();

            editButton.getElement().click();
            religionSelector.getElement().click();
            religionOthers.getElement().click();
            Thread.sleep(2000);
            saveButton.getElement().click();

            editButton.getElement().click();
            religionSelector.getElement().click();
            religionHinduism.getElement().click();
            Thread.sleep(2000);
            saveButton.getElement().click();

        } catch (InterruptedException e) {
            // Handle the exception (log it or rethrow it)
            e.printStackTrace();
        }
    }

    //tc wise done
    public void maritalStatus() {
        try {
            editButton.getElement().click();
            maritalSelector.getElement().click();
            maritalSelect.getElement().click();
            Thread.sleep(1000);
            saveButton.getElement().click();
            errorMaritalStatusMessageText();

            maritalSelector.getElement().click();
            maritalMarried.getElement().click();
            Thread.sleep(1000);
            saveButton.getElement().click();

            editButton.getElement().click();
            maritalSelector.getElement().click();
            maritalUnmarried.getElement().click();
            Thread.sleep(1000);
            saveButton.getElement().click();

            editButton.getElement().click();
            maritalSelector.getElement().click();
            maritalSingle.getElement().click();
            Thread.sleep(1000);
            saveButton.getElement().click();
        } catch (InterruptedException e) {
            // Handle the exception (log it or rethrow it)
            e.printStackTrace();
        }
    }

    //tc wise done
    public void nationality(){
        //invalid empty space
        editButton.getElement().click();
        disableCheck();
        nationalityField.getElement().clear();
        nationalityField.sendKeysWithDelay("");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorNationalityMessageText();

        //invalid white space
        nationalityField.getElement().click();
        nationalityField.getElement().clear();
        nationalityField.sendKeysWithDelay("  ");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorNationalityMessageText();

        //invalid numeric character
        nationalityField.getElement().click();
        nationalityField.getElement().clear();
        nationalityField.sendKeysWithDelay("14789632");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorNationalityMessageText();

        //invalid special character
        nationalityField.getElement().clear();
        nationalityField.sendKeysWithDelay(DataReader.getStringValue("specialCharacter", "TestData"));
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorNationalityMessageText();

        //invalid max character
        nationalityField.getElement().clear();
        nationalityField.sendKeysWithDelay(DataReader.getStringValue("maxCharacter", "TestData"));
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorNationalityMessageText();

        //valid nationality
        nationalityField.getElement().clear();
        nationalityField.sendKeysWithDelay("Bangladeshi");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

    }
    public void nID(){
        //invalid alphabet
        editButton.getElement().click();
        nationalIDField.getElement().clear();
        nationalIDField.sendKeysWithDelay("abced");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorNIDMessageText();

        //invalid max character
        nationalIDField.getElement().clear();
        nationalIDField.sendKeysWithDelay("aaaaaaaaaaaaaaaaa");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorNIDMessageText();

        //invalid special character
        nationalIDField.getElement().clear();
        nationalIDField.sendKeysWithDelay("~!@#$%^&*()_+}{|/'");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorNIDMessageText();

//        //invalid special character
//        nationalIDField.getElement().clear();
//        nationalIDField.sendKeysWithDelay("12458641");
//        saveButton.scrollUntilElementIsVisible();
//        saveButton.getElement().click();
//        errorNIDMessageText();

//        //invalid special character
//        nationalIDField.getElement().clear();
//        nationalIDField.sendKeysWithDelay("145.4545");
//        saveButton.scrollUntilElementIsVisible();
//        saveButton.getElement().click();
//        errorNIDMessageText();

        //invalid special character
        nationalIDField.getElement().clear();
        nationalIDField.sendKeysWithDelay("1,234.568");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorNIDMessageText();

        //invalid special character
        nationalIDField.getElement().clear();
        nationalIDField.sendKeysWithDelay("<p>east west;</p>");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorNIDMessageText();

        //valid white space
//        editButton.getElement().click();
        nationalIDField.getElement().clear();
        nationalIDField.sendKeysWithDelay("ASSDcadfa");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorNIDMessageText();

        //invalid special character
        nationalIDField.getElement().clear();
        nationalIDField.sendKeysWithDelay("east wes(){}*");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorNIDMessageText();

        //invalid white space
        nationalIDField.getElement().clear();
        nationalIDField.sendKeysWithDelay("AVDFCD");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorNIDMessageText();
        nationalIDField.getElement().clear();
        nationalIDField.sendKeysWithDelay("asfadgaf");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorNIDMessageText();

        //invalid white space
        nationalIDField.getElement().clear();
        nationalIDField.sendKeysWithDelay("   asfafasf");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorNIDMessageText();

        //invalid white space
        nationalIDField.getElement().clear();
        nationalIDField.sendKeysWithDelay("asfafasf   ");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorNIDMessageText();

        //invalid white space
        nationalIDField.getElement().clear();
        nationalIDField.sendKeysWithDelay("qwert");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorNIDMessageText();

        //invalid white space
        nationalIDField.getElement().clear();
        nationalIDField.sendKeysWithDelay("asdfasdfadgfazsdcvfasdfdfffffffffffffffffggggggggg");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorNIDMessageText();

        //valid empty
        nationalIDField.getElement().clear();
        nationalIDField.sendKeysWithDelay("");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        //valid white space
        editButton.getElement().click();
        nationalIDField.getElement().clear();
        nationalIDField.sendKeysWithDelay("   ");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();


        //valid nid 18 character
        editButton.getElement().click();
        nationalIDField.getElement().clear();
        nationalIDField.sendKeysWithDelay("12345678912345678");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
    }

    //tc wise done
    public void passport(){
        editButton.getElement().click();

        passportIssueDate.getElement().clear();
        //invalid passport
        passportField.getElement().clear();
        passportField.sendKeysWithDelay("!$");
        saveButton.getElement().click();
        errorPassportMessageText();

        //invalid bangla text
        passportField.getElement().clear();
        passportField.sendKeysWithDelay("হাসিব");
        saveButton.getElement().click();
        errorPassportMessageText();


        //invalid date entry
        passportField.getElement().clear();
        passportField.sendKeysWithDelay("8/18/2024");
        saveButton.getElement().click();
        errorPassportMessageText();

        //valid white space
        passportField.getElement().clear();
        passportField.sendKeysWithDelay("    ");
        saveButton.getElement().click();
        errorPassportMessageText();

        //valid empty
        passportField.getElement().clear();
        passportField.sendKeysWithDelay("");
        saveButton.getElement().click();


        //Valid date entry
        editButton.getElement().click();
        passportField.getElement().clear();
        passportField.sendKeysWithDelay("12345678");
        saveButton.getElement().click();
    }
    public void passportIssuedDate(){
        //invalid empty date
//        editButton.getElement().click();
        passportIssueDate.sendKeysWithDelay("");
        saveButton.click();
        errorPassportIssuedDateMessageText();

        //invalid white space
        passportIssueDate.sendKeysWithDelay("  ");
        saveButton.click();
        errorPassportIssuedDateMessageText();

        //invalid character
        passportIssueDate.getElement().clear();
        passportIssueDate.sendKeysWithDelay("abc");
        saveButton.click();
        errorPassportIssuedDateMessageText();

        //invalid numeric character
        passportIssueDate.getElement().clear();
        passportIssueDate.sendKeysWithDelay("123");
        saveButton.click();
        errorPassportIssuedDateMessageText();

        //invalid special character
        passportIssueDate.getElement().clear();
        passportIssueDate.sendKeysWithDelay(DataReader.getStringValue("specialCharacter", "TestData"));
        saveButton.click();
        errorPassportIssuedDateMessageText();

        //ivalid bangla character
        passportIssueDate.getElement().clear();
        passportIssueDate.sendKeysWithDelay("হাসিব");
        saveButton.click();
        errorPassportIssuedDateMessageText();

        //invalid max character
        passportIssueDate.getElement().clear();
        passportIssueDate.sendKeysWithDelay(DataReader.getStringValue("maxCharacter", "TestData"));
        saveButton.click();
        errorPassportIssuedDateMessageText();

        //invalid date pattern
        passportIssueDate.getElement().clear();
        passportIssueDate.sendKeysWithDelay("2024/07/01");
        saveButton.click();
        errorPassportIssuedDateMessageText();

        //invalid date patter
        passportIssueDate.getElement().clear();
        passportIssueDate.sendKeysWithDelay("18/08/2024");
        saveButton.click();
        errorPassportIssuedDateMessageText();

        //invalid date smaller 12 to 85 years.
        passportIssueDate.getElement().clear();
        passportIssueDate.sendKeysWithDelay("18/08/2019");
        saveButton.click();
        errorPassportIssuedDateMessageText();

        //invalid date greater than 85 years.
        passportIssueDate.getElement().clear();
        passportIssueDate.sendKeysWithDelay("18/07/1939");
        saveButton.click();
        errorPassportIssuedDateMessageText();

        //valid dob
        passportIssueDate.getElement().clear();
        passportIssueDate.sendKeysWithDelay(DataReader.getStringValue("dob","TestData"));
        saveButton.click();
    }

    //tc wise done
    public void primaryNumber(){
        //invalid empty entry
        editButton.getElement().click();
        countryDropdownSelector.getElement().click();
        countryBangladesh.getElement().click();
        primaryNumberField.getElement().clear();
        saveButton.getElement().click();
        errorPrimaryNumberMessageText();

        //invalid white space
        countryDropdownSelector.getElement().click();
        countryBangladesh.getElement().click();
        primaryNumberField.getElement().clear();
        primaryNumberField.sendKeysWithDelay("  ");
        saveButton.getElement().click();
        errorPrimaryNumberMessageText();

        //invalid digits
        countryDropdownSelector.getElement().click();
        countryBangladesh.getElement().click();
        primaryNumberField.getElement().clear();
        primaryNumberField.sendKeysWithDelay("123");
        saveButton.getElement().click();
        errorPrimaryNumberMessageText();

        //Max character
        countryDropdownSelector.getElement().click();
        countryBangladesh.getElement().click();
        primaryNumberField.getElement().clear();
        primaryNumberField.sendKeysWithDelay("019207840812222");
        saveButton.getElement().click();
        errorPrimaryNumberMessageText();

        //Special Character
        countryDropdownSelector.getElement().click();
        countryBangladesh.getElement().click();
        primaryNumberField.getElement().clear();
        primaryNumberField.sendKeysWithDelay("!@#$%^&*()");
        saveButton.getElement().click();
        errorPrimaryNumberMessageText();

        //invalid dateValue
        countryDropdownSelector.getElement().click();
        countryBangladesh.getElement().click();
        primaryNumberField.getElement().clear();
        primaryNumberField.sendKeysWithDelay("8/18/2024");
        saveButton.getElement().click();
        errorPrimaryNumberMessageText();

        //invalid character
        countryDropdownSelector.getElement().click();
        countryBangladesh.getElement().click();
        primaryNumberField.getElement().clear();
        primaryNumberField.sendKeysWithDelay("abec!23ta");
        saveButton.getElement().click();
        errorPrimaryNumberMessageText();

        //invalid bangla character
        countryDropdownSelector.getElement().click();
        countryBangladesh.getElement().click();
        primaryNumberField.getElement().clear();
        primaryNumberField.sendKeysWithDelay("হাসিব");
        saveButton.getElement().click();
        errorPrimaryNumberMessageText();

        //valid digits
        countryDropdownSelector.getElement().click();
        countryBangladesh.getElement().click();
        primaryNumberField.getElement().clear();
        primaryNumberField.sendKeysWithDelay("01761288821");
        saveButton.getElement().click();
    }
    public void secondaryNumber(){
        //invalid digits
        editButton.getElement().click();
        secondNumberField.getElement().clear();
        secondNumberField.sendKeysWithDelay("123");
        saveButton.getElement().click();
        errorSecondNumberMessageText();

        //Max character
        secondNumberField.getElement().clear();
        secondNumberField.sendKeysWithDelay("01920784081222j");
        saveButton.getElement().click();
        errorSecondNumberMessageText();

        //Special Character
        secondNumberField.getElement().clear();
        secondNumberField.sendKeysWithDelay("!@#$%^&*()");
        saveButton.getElement().click();
        errorSecondNumberMessageText();

        //invalid dateValue
        secondNumberField.getElement().clear();
        secondNumberField.sendKeysWithDelay("8/18/2024");
        saveButton.getElement().click();
        errorSecondNumberMessageText();

        //invalid character
        secondNumberField.getElement().clear();
        secondNumberField.sendKeysWithDelay("abec!23ta");
        saveButton.getElement().click();
        errorSecondNumberMessageText();

        //invalid bangla character
        secondNumberField.getElement().clear();
        secondNumberField.sendKeysWithDelay("হাসিব");
        saveButton.getElement().click();
        errorSecondNumberMessageText();

        //valid digits
        secondNumberField.getElement().clear();
        secondNumberField.sendKeysWithDelay("01761288821");
        saveButton.getElement().click();

        //invalid empty entry
        editButton.getElement().click();
        secondNumberField.getElement().clear();
        saveButton.getElement().click();

        //invalid white space
        editButton.getElement().click();
        secondNumberField.getElement().clear();
        secondNumberField.sendKeysWithDelay("  ");
        saveButton.getElement().click();
    }
    public void emergencyNumber(){
        //Max character
        editButton.click();
        emergencyNumberField.getElement().clear();
        emergencyNumberField.sendKeysWithDelay("01920784081222j");
        saveButton.getElement().click();
        errorEmergencyMessageText();

        //Special Character
        emergencyNumberField.getElement().clear();
        emergencyNumberField.sendKeysWithDelay("!@#$%^&*()");
        saveButton.getElement().click();
        errorEmergencyMessageText();

        //invalid dateValue
        emergencyNumberField.getElement().clear();
        emergencyNumberField.sendKeysWithDelay("8/18/2024");
        saveButton.getElement().click();
        errorEmergencyMessageText();

        //invalid character
        emergencyNumberField.getElement().clear();
        emergencyNumberField.sendKeysWithDelay("abec!23ta");
        saveButton.getElement().click();
        errorEmergencyMessageText();

        //invalid bangla character
        emergencyNumberField.getElement().clear();
        emergencyNumberField.sendKeysWithDelay("হাসিব");
        saveButton.getElement().click();
        errorEmergencyMessageText();

        //invalid empty entry
        emergencyNumberField.getElement().clear();
        saveButton.getElement().click();

        //invalid digits
        editButton.getElement().click();
        emergencyNumberField.getElement().clear();
        emergencyNumberField.sendKeysWithDelay("123");
        saveButton.getElement().click();

        //invalid white space
        editButton.getElement().click();
        emergencyNumberField.getElement().clear();
        emergencyNumberField.sendKeysWithDelay("  ");
        saveButton.getElement().click();

        //valid digits
        editButton.getElement().click();
        emergencyNumberField.getElement().clear();
        emergencyNumberField.sendKeysWithDelay("01666666667");
        saveButton.getElement().click();
    }

    public void primaryEmail(){
        //invalid email a
        editButton.getElement().click();
        changeUserIDField.getElement().click();
        primaryEmailField.getElement().clear();
        primaryEmailField.sendKeysWithDelay("a");
        saveButton.getElement().click();
        errorPrimaryEmailMessageText();

        //invalid special character
        primaryEmailField.getElement().clear();
        primaryEmailField.sendKeysWithDelay("@#%!@#$%^&*()_");
        saveButton.getElement().click();
        errorPrimaryEmailMessageText();

        //invalid special character
        primaryEmailField.getElement().clear();
        primaryEmailField.sendKeysWithDelay("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbb");
        saveButton.getElement().click();
        errorPrimaryEmailMessageText();

        //invalid date character
        primaryEmailField.getElement().clear();
        primaryEmailField.sendKeysWithDelay("8/18/2024");
        saveButton.getElement().click();
        errorPrimaryEmailMessageText();

//        //valid empty
//        primaryEmailField.getElement().clear();
//        primaryEmailField.sendKeysWithDelay("");
//        saveButton.getElement().click();
//
//        //valid white space
//        editButton.getElement().click();
//        primaryEmailField.getElement().clear();
//        saveButton.getElement().click();

        //valid email
//        editButton.getElement().click();
        primaryEmailField.getElement().clear();
        primaryEmailField.sendKeysWithDelay("bdjobst@gmail.com");
        saveButton.getElement().click();
    }

    //tc wise done
    public void alternateEmail(){
        //invalid email a
        editButton.getElement().click();
        alternateEmailField.getElement().clear();
        alternateEmailField.sendKeysWithDelay("a");
        saveButton.getElement().click();
        errorAlternateEmaiLMessageText();

        //invalid special character
        alternateEmailField.getElement().clear();
        alternateEmailField.sendKeysWithDelay("@#%!@#$%^&*()_");
        saveButton.getElement().click();
        errorAlternateEmaiLMessageText();

        //invalid special character
        alternateEmailField.getElement().clear();
        alternateEmailField.sendKeysWithDelay("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbb");
        saveButton.getElement().click();
        errorAlternateEmaiLMessageText();

        //invalid date character
        alternateEmailField.getElement().clear();
        alternateEmailField.sendKeysWithDelay("8/18/2024");
        saveButton.getElement().click();
        errorAlternateEmaiLMessageText();

        //invalid date character -->
        alternateEmailField.getElement().clear();
        alternateEmailField.sendKeysWithDelay("        abc@mail.com");
        saveButton.getElement().click();

        //invalid date character -->
        editButton.getElement().click();
        alternateEmailField.getElement().clear();
        alternateEmailField.sendKeysWithDelay("12458641");
        saveButton.getElement().click();
        errorAlternateEmaiLMessageText();

        //invalid date character -->
        alternateEmailField.getElement().clear();
        alternateEmailField.sendKeysWithDelay("145.4545");
        saveButton.getElement().click();
        errorAlternateEmaiLMessageText();

        //invalid date character -->
        alternateEmailField.getElement().clear();
        alternateEmailField.sendKeysWithDelay("1,234.568");
        saveButton.getElement().click();
        errorAlternateEmaiLMessageText();

        //invalid date character -->
        alternateEmailField.getElement().clear();
        alternateEmailField.sendKeysWithDelay("east wes(){}*");
        saveButton.getElement().click();
        errorAlternateEmaiLMessageText();

        //invalid date character -->
        alternateEmailField.getElement().clear();
        alternateEmailField.sendKeysWithDelay("<p>east west;</p>");
        saveButton.getElement().click();
        errorAlternateEmaiLMessageText();

        //valid empty
        alternateEmailField.getElement().clear();
        alternateEmailField.sendKeysWithDelay("");
        saveButton.getElement().click();

        //valid white space
        editButton.getElement().click();
        alternateEmailField.getElement().clear();
        saveButton.getElement().click();

        //valid white space -->
        editButton.getElement().click();
        alternateEmailField.getElement().clear();
        alternateEmailField.sendKeysWithDelay("asdasdagsfagsdfkghgggggggggggggggggddadag@mail.com");
        saveButton.getElement().click();

        //valid white space -->
        editButton.getElement().click();
        alternateEmailField.getElement().clear();
        alternateEmailField.sendKeysWithDelay("AVDFCD");
        saveButton.getElement().click();
        errorAlternateEmaiLMessageText();

        //valid white space -->
        alternateEmailField.getElement().clear();
        alternateEmailField.sendKeysWithDelay("      145458645245          ");
        saveButton.getElement().click();
        errorAlternateEmaiLMessageText();

        //valid white space -->
        alternateEmailField.getElement().clear();
        alternateEmailField.sendKeysWithDelay("asfadgaf");
        saveButton.getElement().click();
        errorAlternateEmaiLMessageText();

        //valid white space -->
        alternateEmailField.getElement().clear();
        alternateEmailField.sendKeysWithDelay("ASSDcadfa");
        saveButton.getElement().click();
        errorAlternateEmaiLMessageText();

        //valid email
        alternateEmailField.getElement().clear();
        alternateEmailField.sendKeysWithDelay("khckgc@ff.vv");
        saveButton.getElement().click();
    }

    //tc wise done
    public void bloodGroup(){
        //valid select
        editButton.click();
        bloodSelector.click();
        bloodSelect.click();
        saveButton.click();

        //valid A+
        editButton.click();
        bloodSelector.click();
        bloodAPos.click();
        saveButton.click();

        //valid A-
        editButton.click();
        bloodSelector.click();
        bloodANeg.click();
        saveButton.click();

        //valid B+
        editButton.click();
        bloodSelector.click();
        bloodBPos.click();
        saveButton.click();

        //valid B-
        editButton.click();
        bloodSelector.click();
        bloodBNeg.click();
        saveButton.click();

        //valid O+
        editButton.click();
        bloodSelector.click();
        bloodOPos.click();
        saveButton.click();

        //valid O-
        editButton.click();
        bloodSelector.click();
        bloodONeg.click();
        saveButton.click();

        //valid AB+
        editButton.click();
        bloodSelector.click();
        bloodABPos.click();
        saveButton.click();

        //valid AB-
        editButton.click();
        bloodSelector.click();
        bloodABNeg.click();
        saveButton.click();
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
    private void errorGenderMessageText(){
        ExplicitWait.elementToBeVisible(genderSelectorErrorText.getLocator());
        Assert.assertTrue(genderSelectorErrorText.isDisplayed(), errorMessageText);
    }
    private void errorMaritalStatusMessageText(){
        ExplicitWait.elementToBeVisible(martialErrorText.getLocator());
        Assert.assertTrue(martialErrorText.isDisplayed(),errorMessageText);
    }
    private void errorNationalityMessageText(){
        ExplicitWait.elementToBeVisible(nationalityErrorText.getLocator());
        Assert.assertTrue(nationalityErrorText.isDisplayed(), errorMessageText);
    }
    private void disableCheck(){
        if (!nationalityField.isEnabled()) {
            bangladeshiCheckbox.getElement().click();
        }
    }
    private void errorNIDMessageText(){
        ExplicitWait.elementToBeVisible(nationalIDFieldErrorText.getLocator());
        Assert.assertTrue(nationalIDFieldErrorText.isDisplayed(), errorMessageText);
    }
    private void errorPassportMessageText(){
        ExplicitWait.elementToBeVisible(passportFieldErrorText.getLocator());
        Assert.assertTrue(passportFieldErrorText.isDisplayed(), errorMessageText);
    }
    private void errorPassportIssuedDateMessageText(){
        ExplicitWait.elementToBeVisible(passportIssueErrorText.getLocator());
        Assert.assertTrue(passportIssueErrorText.isDisplayed(), errorMessageText);
    }
    private void errorPrimaryNumberMessageText(){
        ExplicitWait.elementToBeVisible(primaryNumberFieldErrorText.getLocator());
        Assert.assertTrue(primaryNumberFieldErrorText.isDisplayed(), errorMessageText);
    }
    private void errorSecondNumberMessageText(){
        ExplicitWait.elementToBeVisible(secondNumberFieldErrorText.getLocator());
        Assert.assertTrue(secondNumberFieldErrorText.isDisplayed(), errorMessageText);
    }
    private void errorEmergencyMessageText(){
        ExplicitWait.elementToBeVisible(emergencyNumberErrorText.getLocator());
        Assert.assertTrue(emergencyNumberErrorText.isDisplayed(), errorMessageText);
    }
    private void errorPrimaryEmailMessageText(){
        ExplicitWait.elementToBeVisible(primaryEmailFieldErrorText.getLocator());
        Assert.assertTrue(primaryEmailFieldErrorText.isDisplayed(), errorMessageText);
    }
    private void errorAlternateEmaiLMessageText(){
        ExplicitWait.elementToBeVisible(alternateEmailFieldErrorText.getLocator());
        Assert.assertTrue(alternateEmailFieldErrorText.isDisplayed(), errorMessageText);
    }

}
