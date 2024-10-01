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
    private final Element editButton2 = new Element(By.cssSelector("button.btn.edit-btn[aria-label='Edit Personal Details']"));
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
    private final Element primaryNumberField = new Element(By.cssSelector("input#txtMobile.form-control.from-control-login.aria-disabled:not([readonly])\n"));
    private final Element primaryNumberDisabled = new Element(By.cssSelector("input#txtMobile.form-control.from-control-login.aria-disabled[readonly]"));
    private final Element primaryNumberFieldErrorText = new Element(By.cssSelector("#txtMob1ErrorMsg"));
    private final Element secondNumberField = new Element(By.cssSelector("#txtPhone_H"));
    private final Element secondNumberFieldErrorText = new Element(By.cssSelector("#txtPhoneHmeErrorMsg"));
    private final Element emergencyNumberField = new Element(By.cssSelector("#txtPhone_Off"));
    private final Element emergencyNumberErrorText = new Element(By.cssSelector("#txtPhoneoffErrorMsg"));
    private final Element emergencyNumberNotPresent = new Element(By.cssSelector("label[for='txtPhone_Off']"));
    private final Element countryDropdownSelector = new Element(By.cssSelector("#txtCountryCode"));
    private final Element countryBangladesh= new Element(By.cssSelector("select#txtCountryCode> option[value='88']"));
    private final Element primaryEmailField= new Element(By.cssSelector("input#txtEmail1.form-control.aria-disabled:not([readonly])"));
    private final Element primaryEmailDisabled = new Element(By.cssSelector("input#txtEmail1.form-control.aria-disabled[readonly]"));
    private final Element changeUserIDField = new Element(By.xpath("//span[normalize-space()='Change User Id']"));
    private final Element primaryEmailFieldErrorText = new Element(By.cssSelector("#txtemail1ErrorMsg"));
    private final Element alternateEmailField = new Element(By.cssSelector("#txtEmail2"));
    private final Element alternateEmailFieldErrorText = new Element(By.cssSelector("#altMailErrorMsg"));
    private final Element alternateEmailNotPresent = new Element(By.cssSelector("label[for='txtEmail2']"));
    private final Element bloodSelector= new Element(By.cssSelector("#txtBloodGroup"));
    private final Element bloodGroupNotPresent = new Element(By.cssSelector("label[for='txtBloodGroup']"));
    private final Element bloodSelect = new Element(By.cssSelector("select#txtBloodGroup> option[value='-1']"));
    private final Element bloodAPos = new Element(By.cssSelector("select#txtBloodGroup> option[value='A+']"));
    private final Element bloodANeg = new Element(By.cssSelector("select#txtBloodGroup> option[value='A-']"));
    private final Element bloodBPos= new Element(By.cssSelector("select#txtBloodGroup> option[value='B+']"));
    private final Element bloodBNeg = new Element(By.cssSelector("select#txtBloodGroup> option[value='B-']"));
    private final Element bloodOPos= new Element(By.cssSelector("select#txtBloodGroup> option[value='O+']"));
    private final Element bloodONeg= new Element(By.cssSelector("select#txtBloodGroup> option[value='O-']"));
    private final Element bloodABPos=new Element(By.cssSelector("select#txtBloodGroup> option[value='AB+']"));
    private final Element bloodABNeg = new Element(By.cssSelector("select#txtBloodGroup> option[value='AB-']"));
    //upload elements
    private final Element uploadPhotoButton = new Element(By.cssSelector("a[type='button']"));
    private final Element choosePhoto = new Element(By.cssSelector("//input[@id='imageFile']"));
    private final Element changePhoto = new Element(By.xpath("//button[@id='changePhoto']"));
    private final Element uploadPhoto = new Element(By.xpath("//button[@id='uploadPhoto']"));

    private final String errorMessageText = "Error message is not displayed.";

    public BDJPersonalDetails(){
        super(new Element(By.cssSelector("button[aria-label='Click Personal section to add or edit your personal information in resume']")));
    }

    public void uploadImage(){
        editButton();
        ExplicitWait.elementToBeClickable(uploadPhotoButton.getLocator());
        uploadPhotoButton.getElement().click();

        // Check if the "Change Photo" button is displayed and clickable
        if (choosePhoto.getElement().isDisplayed()) {
            choosePhoto.getElement().click();
        }
        // If "Change Photo" is not visible, check for the "Upload Photo" button
        else if (uploadPhoto.getElement().isDisplayed()) {
            uploadPhoto.getElement().click();
        }
    }

    //tc wise done
    public void firstName(){
        ExplicitWait.elementToBeClickable(firstName.getLocator());

        String originalName = firstName.getElement().getAttribute("value");

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
        editButton();
        firstName.getElement().clear();
        firstName.getElement().click();
        firstName.sendKeysWithDelay("Avarya     ");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        // valid combination
        editButton();
        firstName.getElement().clear();
        firstName.getElement().click();
        firstName.sendKeysWithDelay("ASSDcadfa");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        //valid white space left
        editButton();
        firstName.getElement().clear();
        firstName.getElement().click();
        firstName.sendKeysWithDelay("qwert");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        //valid white space left
        editButton();
        firstName.getElement().clear();
        firstName.getElement().click();
        firstName.sendKeysWithDelay("asdfasdfadgfazsdcvfasdfdfffffffffffffffffggggggggg");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        //valid white space left
        editButton();
        firstName.getElement().clear();
        firstName.getElement().click();
        firstName.sendKeysWithDelay("AVDFCD");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        //valid white space left
        editButton();
        firstName.getElement().clear();
        firstName.getElement().click();
        firstName.sendKeysWithDelay("asfadgaf");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        // valid combination
        editButton();
        firstName.getElement().clear();
        firstName.getElement().click();
        firstName.sendKeysWithDelay("Avarya");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        // Restore the original name
        editButton();
        firstName.getElement().clear();
        firstName.sendKeys(originalName);
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
    }

    //tc wise done
    public void lastName(){
        // valid empty name
        editButton();
        String originalName = lastName.getElement().getAttribute("value");
        lastName.getElement().clear();
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        // invalid whiteSpace
        editButton();
        lastName.getElement().clear();
        lastName.sendKeysWithDelay(" ");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        // invalid specialCharacter
        editButton();
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
        editButton();
        lastName.getElement().clear();
        lastName.getElement().click();
        lastName.sendKeysWithDelay("Avarya     ");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        // valid combination
        editButton();
        lastName.getElement().clear();
        lastName.getElement().click();
        lastName.sendKeysWithDelay("ASSDcadfa");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        //valid white space left
        editButton();
        lastName.getElement().clear();
        lastName.getElement().click();
        lastName.sendKeysWithDelay("qwert");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        //valid white space left
        editButton();
        lastName.getElement().clear();
        lastName.getElement().click();
        lastName.sendKeysWithDelay("asdfasdfadgfazsdcvfasdfdfffffffffffffffffggggggggg");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        //valid white space left
        editButton();
        lastName.getElement().clear();
        lastName.getElement().click();
        lastName.sendKeysWithDelay("AVDFCD");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        //valid white space left
        editButton();
        lastName.getElement().clear();
        lastName.getElement().click();
        lastName.sendKeysWithDelay("asfadgaf");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        // valid combination
        editButton();
        lastName.getElement().clear();
        lastName.getElement().click();
        lastName.sendKeysWithDelay("Internal Test Account for My Bdjobs");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        // Restore the original name
        editButton();
        lastName.getElement().clear();
        lastName.sendKeys(originalName);
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

    }

    //tc wise done
    public void fatherName(){

        // invalid numeric character
        editButton();
        String originalName = fatherName.getElement().getAttribute("value");
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
        editButton();
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay("  ");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // valid white space
        editButton();
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay("ASSDcadfa");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // valid white space
        editButton();
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay("AVDFCD");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // valid white space
        editButton();
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay("asfadgaf");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());


        // valid white space before character
        editButton();
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay("        abcdes");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // valid white space before character
        editButton();
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay("qwert");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // valid name
        editButton();
        fatherName.getElement().clear();
        fatherName.sendKeysWithDelay("fatherName");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();

        // Restore the original name
        editButton();
        fatherName.getElement().clear();
        fatherName.sendKeys(originalName);
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

    }
    public void motherName(){

        // invalid numeric character
        editButton();
        String originalName = motherName.getElement().getAttribute("value");
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
        editButton();
        motherName.getElement().clear();
        motherName.sendKeysWithDelay("  ");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // valid white space
        editButton();
        motherName.getElement().clear();
        motherName.sendKeysWithDelay("ASSDcadfa");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // valid white space
        editButton();
        motherName.getElement().clear();
        motherName.sendKeysWithDelay("AVDFCD");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // valid white space
        editButton();
        motherName.getElement().clear();
        motherName.sendKeysWithDelay("asfadgaf");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());


        // valid white space before character
        editButton();
        motherName.getElement().clear();
        motherName.sendKeysWithDelay("        abcdes");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // valid white space before character
        editButton();
        motherName.getElement().clear();
        motherName.sendKeysWithDelay("qwert");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();
        ExplicitWait.presenceOfElementLocated(editButton.getLocator());

        // valid name
        editButton();
        motherName.getElement().clear();
        motherName.sendKeysWithDelay("motherName");
        saveButton.scrollUntilElementIsVisible();
        saveButton.click();

        // Restore the original name
        editButton();
        motherName.getElement().clear();
        motherName.sendKeys(originalName);
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
    }

    //tc wise done
    public void dob(){
        //invalid empty name
        editButton();
        String originalName = dob.getElement().getAttribute("value");
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

        // Restore the original name
        editButton();
        dob.getElement().clear();
        dob.sendKeys(originalName);
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

    }

    //tc wise done
    public void gender() {
        try {
            // invalid gender Select
            editButton();
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
            editButton();
            genderOptionOther.getElement().click();
            Thread.sleep(2000);
            saveButton.getElement().click();

            // valid gender Female
            editButton();
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
            editButton();
            religionSelector.getElement().click();
            religionSelect.getElement().click();
            Thread.sleep(2000);
            saveButton.getElement().click();

            editButton();
            religionSelector.getElement().click();
            religionBuddhism.getElement().click();
            Thread.sleep(2000);
            saveButton.getElement().click();

            editButton();
            religionSelector.getElement().click();
            religionChristianity.getElement().click();
            Thread.sleep(2000);
            saveButton.getElement().click();

            editButton();
            religionSelector.getElement().click();
            religionHinduism.getElement().click();
            Thread.sleep(2000);
            saveButton.getElement().click();

            editButton();
            religionSelector.getElement().click();
            religionIslam.getElement().click();
            Thread.sleep(2000);
            saveButton.getElement().click();

            editButton();
            religionSelector.getElement().click();
            religionJainism.getElement().click();
            Thread.sleep(2000);
            saveButton.getElement().click();

            editButton();
            religionSelector.getElement().click();
            religionJudaism.getElement().click();
            Thread.sleep(2000);
            saveButton.getElement().click();

            editButton();
            religionSelector.getElement().click();
            religionSikhism.getElement().click();
            Thread.sleep(2000);
            saveButton.getElement().click();

            editButton();
            religionSelector.getElement().click();
            religionOthers.getElement().click();
            Thread.sleep(2000);
            saveButton.getElement().click();

            editButton();
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
            editButton();
            maritalSelector.getElement().click();
            maritalSelect.getElement().click();
            Thread.sleep(1000);
            saveButton.getElement().click();
            errorMaritalStatusMessageText();

            maritalSelector.getElement().click();
            maritalMarried.getElement().click();
            Thread.sleep(1000);
            saveButton.getElement().click();

            editButton();
            maritalSelector.getElement().click();
            maritalUnmarried.getElement().click();
            Thread.sleep(1000);
            saveButton.getElement().click();

            editButton();
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
        editButton();
        String originalName = nationalityField.getElement().getAttribute("value");
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

        //invalid numeric character
        nationalityField.getElement().click();
        nationalityField.getElement().clear();
        nationalityField.sendKeysWithDelay("145.4545");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorNationalityMessageText();

        //invalid numeric character
        nationalityField.getElement().click();
        nationalityField.getElement().clear();
        nationalityField.sendKeysWithDelay("1,234.568");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorNationalityMessageText();

        //invalid numeric character
        nationalityField.getElement().click();
        nationalityField.getElement().clear();
        nationalityField.sendKeysWithDelay("east wes(){}*");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        errorNationalityMessageText();

        //invalid numeric character
        nationalityField.getElement().click();
        nationalityField.getElement().clear();
        nationalityField.sendKeysWithDelay("<p>east west;</p>");
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

        //valid
        nationalityField.getElement().click();
        nationalityField.getElement().clear();
        nationalityField.sendKeysWithDelay("    asfafasf");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        //valid
        editButton();
        nationalityField.getElement().click();
        nationalityField.getElement().clear();
        nationalityField.sendKeysWithDelay("AVDFCD");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        //valid 50 character
        editButton();
        nationalityField.getElement().click();
        nationalityField.getElement().clear();
        nationalityField.sendKeysWithDelay("asdfasdfadgfazsdcvfasdfdfffffffffffffffffggggggggg");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        //valid
        editButton();
        nationalityField.getElement().click();
        nationalityField.getElement().clear();
        nationalityField.sendKeysWithDelay("qwert");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        //valid
        editButton();
        nationalityField.getElement().click();
        nationalityField.getElement().clear();
        nationalityField.sendKeysWithDelay("asfadgaf");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        //valid
        editButton();
        nationalityField.getElement().click();
        nationalityField.getElement().clear();
        nationalityField.sendKeysWithDelay("AVDFCD");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        //valid
        editButton();
        nationalityField.getElement().click();
        nationalityField.getElement().clear();
        nationalityField.sendKeysWithDelay("ASSDcadfa");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        //valid nationality
        editButton();
        nationalityField.getElement().clear();
        nationalityField.sendKeysWithDelay("Bangladeshi");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        // Restore the original name
        editButton();
        nationalityField.getElement().clear();
        nationalityField.sendKeys(originalName);
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();


    }
    public void nID(){
        //invalid alphabet
        editButton();
        String originalName = nationalIDField.getElement().getAttribute("value");
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
//        editButton();
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
        editButton();
        nationalIDField.getElement().clear();
        nationalIDField.sendKeysWithDelay("   ");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();


        //valid nid 18 character
        editButton();
        nationalIDField.getElement().clear();
        nationalIDField.sendKeysWithDelay("12345678912345678");
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        // Restore the original name
        editButton();
        nationalIDField.getElement().clear();
        nationalIDField.sendKeys(originalName);
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
    }

    //tc wise done
    public void passport(){
        editButton();
//        String originalName = passportIssueDate.getElement().getAttribute("value");
        passportIssueDate.getElement().clear();

        //invalid passport
        passportField.getElement().clear();
        passportField.sendKeysWithDelay("!$");
        saveButton.getElement().click();
        errorPassportMessageText();

        //invalid passport
        passportField.getElement().clear();
        passportField.sendKeysWithDelay("    005465132165");
        saveButton.getElement().click();
        errorPassportMessageText();

        //invalid passport
        passportField.getElement().clear();
        passportField.sendKeysWithDelay("01234567891234567891");
        saveButton.getElement().click();
        errorPassportIssuedDateMessageText();

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

        //invalid white space
        passportField.getElement().clear();
        passportField.sendKeysWithDelay("    ");
        saveButton.getElement().click();
        errorPassportMessageText();

//        //invalid white space
//        passportField.getElement().clear();
//        passportField.sendKeysWithDelay("qwert");
//        saveButton.getElement().click();
//        errorPassportMessageText();

        //invalid white space
        passportField.getElement().clear();
        passportField.sendKeysWithDelay("145.4545");
        saveButton.getElement().click();
        errorPassportMessageText();

        //invalid white space
        passportField.getElement().clear();
        passportField.sendKeysWithDelay("1,234.568");
        saveButton.getElement().click();
        errorPassportMessageText();

        //invalid white space
        passportField.getElement().clear();
        passportField.sendKeysWithDelay("qwert");
        saveButton.getElement().click();
         errorPassportIssuedDateMessageText();

        //invalid white space
        passportField.getElement().clear();
        passportField.sendKeysWithDelay("AVDFCD");
        saveButton.getElement().click();
         errorPassportIssuedDateMessageText();

        //invalid white space
        passportField.getElement().clear();
        passportField.sendKeysWithDelay("east wes(){}*");
        saveButton.getElement().click();
        errorPassportMessageText();

        //invalid white space
        passportField.getElement().clear();
        passportField.sendKeysWithDelay("ASSDcadfa");
        saveButton.getElement().click();
        errorPassportIssuedDateMessageText();

        //invalid white space
        passportField.getElement().clear();
        passportField.sendKeysWithDelay(" <p>east west;</p>");
        saveButton.getElement().click();
        errorPassportMessageText();

        //valid white space
        passportField.getElement().clear();
        passportField.sendKeysWithDelay("12458641");
        saveButton.getElement().click();
        errorPassportIssuedDateMessageText();

        //Valid date entry
        passportField.getElement().clear();
        passportField.sendKeysWithDelay("     145458645245          ");
        saveButton.getElement().click();
        errorPassportMessageText();

        //Valid date entry
        passportField.getElement().clear();
        passportField.sendKeysWithDelay(" aswfasfdasf           ");
        saveButton.getElement().click();
        errorPassportMessageText();

        //Valid date entry
        passportField.getElement().clear();
        passportField.sendKeysWithDelay("12345678");
        saveButton.getElement().click();

//        // Restore the original name
//        editButton();
//        passportField.getElement().clear();
//        passportField.sendKeys(originalName);
//        saveButton.scrollUntilElementIsVisible();
//        saveButton.getElement().click();

    }
    public void passportIssuedDate(){
        //invalid empty date
//        editButton();
//        String originalName = passportIssueDate.getElement().getAttribute("value");
        passportIssueDate.getElement().clear();
        passportIssueDate.sendKeysWithDelay("");
        saveButton.click();
        errorPassportIssuedDateMessageText();

        //invalid white space
        passportIssueDate.getElement().clear();
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

//        // Restore the original name
//        editButton();
//        passportIssueDate.getElement().clear();
//        passportIssueDate.sendKeys(originalName);
//        saveButton.scrollUntilElementIsVisible();
//        saveButton.getElement().click();

    }

    //tc wise done
    public void primaryNumber(){
        if(primaryNumberDisabled.isNotPresent()){
        //invalid empty entry
        editButton();
        String originalName = primaryNumberField.getElement().getAttribute("value");
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

        //invalid white space
        countryDropdownSelector.getElement().click();
        countryBangladesh.getElement().click();
        primaryNumberField.getElement().clear();
        primaryNumberField.sendKeysWithDelay("005465132165");
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

        //invalid Character
        countryDropdownSelector.getElement().click();
        countryBangladesh.getElement().click();
        primaryNumberField.getElement().clear();
        primaryNumberField.sendKeysWithDelay("12458641");
        saveButton.getElement().click();
        errorPrimaryNumberMessageText();

        //invalid Character
        countryDropdownSelector.getElement().click();
        countryBangladesh.getElement().click();
        primaryNumberField.getElement().clear();
        primaryNumberField.sendKeysWithDelay("qwert");
        saveButton.getElement().click();
        errorPrimaryNumberMessageText();

        //invalid Character
        countryDropdownSelector.getElement().click();
        countryBangladesh.getElement().click();
        primaryNumberField.getElement().clear();
        primaryNumberField.sendKeysWithDelay("145.4545");
        saveButton.getElement().click();
        errorPrimaryNumberMessageText();

        //invalid Character
        countryDropdownSelector.getElement().click();
        countryBangladesh.getElement().click();
        primaryNumberField.getElement().clear();
        primaryNumberField.sendKeysWithDelay("1,234.568");
        saveButton.getElement().click();
        errorPrimaryNumberMessageText();

        //invalid Character
        countryDropdownSelector.getElement().click();
        countryBangladesh.getElement().click();
        primaryNumberField.getElement().clear();
        primaryNumberField.sendKeysWithDelay("AVDFCD");
        saveButton.getElement().click();
        errorPrimaryNumberMessageText();

        //invalid Character
        countryDropdownSelector.getElement().click();
        countryBangladesh.getElement().click();
        primaryNumberField.getElement().clear();
        primaryNumberField.sendKeysWithDelay("asfadgaf");
        saveButton.getElement().click();
        errorPrimaryNumberMessageText();

        //invalid Character
        countryDropdownSelector.getElement().click();
        countryBangladesh.getElement().click();
        primaryNumberField.getElement().clear();
        primaryNumberField.sendKeysWithDelay("east wes(){}*");
        saveButton.getElement().click();
        errorPrimaryNumberMessageText();

        //invalid Character
        countryDropdownSelector.getElement().click();
        countryBangladesh.getElement().click();
        primaryNumberField.getElement().clear();
        primaryNumberField.sendKeysWithDelay("ASSDcadfa");
        saveButton.getElement().click();
        errorPrimaryNumberMessageText();

        //invalid Character
        countryDropdownSelector.getElement().click();
        countryBangladesh.getElement().click();
        primaryNumberField.getElement().clear();
        primaryNumberField.sendKeysWithDelay("<p>east west;</p>");
        saveButton.getElement().click();
        errorPrimaryNumberMessageText();


        //invalid Character
        countryDropdownSelector.getElement().click();
        countryBangladesh.getElement().click();
        primaryNumberField.getElement().clear();
        primaryNumberField.sendKeysWithDelay("      145458645245          ");
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
        primaryNumberField.sendKeysWithDelay("01516051683");
        saveButton.getElement().click();

        // Restore the original name
        editButton();
        countryDropdownSelector.getElement().click();
        countryBangladesh.getElement().click();
        primaryNumberField.getElement().clear();
        primaryNumberField.sendKeys(originalName);
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

        }

    }
    public void secondaryNumber(){
        //invalid digits
        editButton();
        String originalName = secondNumberField.getElement().getAttribute("value");
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
        editButton();
        secondNumberField.getElement().clear();
        saveButton.getElement().click();

        //invalid white space
        editButton();
        secondNumberField.getElement().clear();
        secondNumberField.sendKeysWithDelay("  ");
        saveButton.getElement().click();

        // Restore the original name
        editButton();
        secondNumberField.getElement().clear();
        secondNumberField.sendKeys(originalName);
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();

    }
    public void emergencyNumber(){
        if(emergencyNumberNotPresent.isPresent()){
        //Max character
        editButton.click();
        String originalName = emergencyNumberField.getElement().getAttribute("value");
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

//        //invalid Value
//        emergencyNumberField.getElement().clear();
//        emergencyNumberField.sendKeysWithDelay("      0132165464");
//        saveButton.getElement().click();
//        errorEmergencyMessageText();

        //invalid character
        emergencyNumberField.getElement().clear();
        emergencyNumberField.sendKeysWithDelay("qwert");
        saveButton.getElement().click();
        errorEmergencyMessageText();

        //invalid character
        emergencyNumberField.getElement().clear();
        emergencyNumberField.sendKeysWithDelay("145.4545");
        saveButton.getElement().click();
        errorEmergencyMessageText();

        //invalid character
        emergencyNumberField.getElement().clear();
        emergencyNumberField.sendKeysWithDelay("1,234.568");
        saveButton.getElement().click();
        errorEmergencyMessageText();

        //invalid character
        emergencyNumberField.getElement().clear();
        emergencyNumberField.sendKeysWithDelay("AVDFCD");
        saveButton.getElement().click();
        errorEmergencyMessageText();

        //invalid character
        emergencyNumberField.getElement().clear();
        emergencyNumberField.sendKeysWithDelay("asfadgaf");
        saveButton.getElement().click();
        errorEmergencyMessageText();

        //invalid character
        emergencyNumberField.getElement().clear();
        emergencyNumberField.sendKeysWithDelay("<p>east west;</p>");
        saveButton.getElement().click();
        errorEmergencyMessageText();

//        //invalid character
//        emergencyNumberField.getElement().clear();
//        emergencyNumberField.sendKeysWithDelay("     145458645245          ");
//        saveButton.getElement().click();
//        errorEmergencyMessageText();

        //invalid character
        emergencyNumberField.getElement().clear();
        emergencyNumberField.sendKeysWithDelay(" east wes(){}*");
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
        editButton();
        emergencyNumberField.getElement().clear();
        emergencyNumberField.sendKeysWithDelay("123");
        saveButton.getElement().click();

        //invalid white space
        editButton();
        emergencyNumberField.getElement().clear();
        emergencyNumberField.sendKeysWithDelay("  ");
        saveButton.getElement().click();

        //valid digits
        editButton();
        emergencyNumberField.getElement().clear();
        emergencyNumberField.sendKeysWithDelay("01666666667");
        saveButton.getElement().click();

        //valid digits
        editButton();
        emergencyNumberField.getElement().clear();
        emergencyNumberField.sendKeysWithDelay("123456789123456");
        saveButton.getElement().click();

        //valid digits
        editButton();
        emergencyNumberField.getElement().clear();
        emergencyNumberField.sendKeysWithDelay("12458641");
        saveButton.getElement().click();

        // Restore the original name
        editButton();
        emergencyNumberField.getElement().clear();
        emergencyNumberField.sendKeys(originalName);
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        }
    }

    //tc wise done
    public void primaryEmail(){
        if(primaryEmailDisabled.isNotPresent()){
        //invalid email a
        editButton();
        String originalName = primaryEmailField.getElement().getAttribute("value");
        primaryEmailField.getElement().clear();
        primaryEmailField.sendKeysWithDelay("qwert");
        saveButton.getElement().click();
        errorPrimaryEmailMessageText();

        //invalid special character
        primaryEmailField.getElement().clear();
        primaryEmailField.sendKeysWithDelay("@#%!@#$%^&*()_");
        saveButton.getElement().click();
        errorPrimaryEmailMessageText();

//        //taking as valid ISSUE
//        primaryEmailField.getElement().clear();
//        primaryEmailField.sendKeysWithDelay("");
//        saveButton.getElement().click();
//        errorPrimaryEmailMessageText();

//        //taking as valid ISSUE
//         primaryEmailField.getElement().clear();
//         primaryEmailField.sendKeysWithDelay("       abc@mail.com");
//         saveButton.getElement().click();
//         errorPrimaryEmailMessageText();

         //invalid  character
         primaryEmailField.getElement().clear();
         primaryEmailField.sendKeysWithDelay("12458641");
         saveButton.getElement().click();
         errorPrimaryEmailMessageText();

         //invalid  character
         primaryEmailField.getElement().clear();
         primaryEmailField.sendKeysWithDelay("@#%!@#$%^&*()_");
         saveButton.getElement().click();
         errorPrimaryEmailMessageText();

         //invalid  character
         primaryEmailField.getElement().clear();
         primaryEmailField.sendKeysWithDelay("145.4545");
         saveButton.getElement().click();
         errorPrimaryEmailMessageText();

         //invalid  character
         primaryEmailField.getElement().clear();
         primaryEmailField.sendKeysWithDelay("1,234.568");
         saveButton.getElement().click();
         errorPrimaryEmailMessageText();

         //invalid  character
         primaryEmailField.getElement().clear();
         primaryEmailField.sendKeysWithDelay("AVDFCD");
         saveButton.getElement().click();
         errorPrimaryEmailMessageText();

         //invalid  character
         primaryEmailField.getElement().clear();
         primaryEmailField.sendKeysWithDelay("asfadgaf");
         saveButton.getElement().click();
         errorPrimaryEmailMessageText();

         //invalid  character
         primaryEmailField.getElement().clear();
         primaryEmailField.sendKeysWithDelay("ASSDcadfa");
         saveButton.getElement().click();
         errorPrimaryEmailMessageText();

         //invalid  character
         primaryEmailField.getElement().clear();
         primaryEmailField.sendKeysWithDelay("      145458645245          ");
         saveButton.getElement().click();
         errorPrimaryEmailMessageText();

         //invalid  character
         primaryEmailField.getElement().clear();
         primaryEmailField.sendKeysWithDelay("14787856445          ");
         saveButton.getElement().click();
         errorPrimaryEmailMessageText();

         //invalid  character
         primaryEmailField.getElement().clear();
         primaryEmailField.sendKeysWithDelay("<p>east west;</p>");
         saveButton.getElement().click();
         errorPrimaryEmailMessageText();


            //invalid  character
         primaryEmailField.getElement().clear();
         primaryEmailField.sendKeysWithDelay("east wes(){}*");
         saveButton.getElement().click();
         errorPrimaryEmailMessageText();

        //invalid special character
        primaryEmailField.getElement().clear();
        primaryEmailField.sendKeysWithDelay("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbb");
        saveButton.getElement().click();
        errorPrimaryEmailMessageText();

//        //invalid special character
//        primaryEmailField.getElement().clear();
//        primaryEmailField.sendKeysWithDelay("asdasdagsfagsdfkghgggggggggggggggggddadag@mail.com");
//        saveButton.getElement().click();
//        errorPrimaryEmailMessageText();

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
//        editButton();
//        primaryEmailField.getElement().clear();
//        saveButton.getElement().click();

        //valid email
//        editButton();
        primaryEmailField.getElement().clear();
        primaryEmailField.sendKeysWithDelay("bdjobst@gmail.com");
        saveButton.getElement().click();

        // Restore the original name
        editButton();
        primaryEmailField.getElement().clear();
        primaryEmailField.sendKeys(originalName);
        saveButton.scrollUntilElementIsVisible();
        saveButton.getElement().click();
        }
    }
    //tc wise done
    public void alternateEmail(){
        if(alternateEmailNotPresent.isPresent()) {
            //invalid email a
            editButton();
            String originalName = alternateEmailField.getElement().getAttribute("value");
            alternateEmailField.getElement().clear();
            alternateEmailField.sendKeysWithDelay("a");
            saveButton.getElement().click();
            errorAlternateEmailMessageText();

            //invalid special character
            alternateEmailField.getElement().clear();
            alternateEmailField.sendKeysWithDelay("@#%!@#$%^&*()_");
            saveButton.getElement().click();
            errorAlternateEmailMessageText();

            //invalid special character
            alternateEmailField.getElement().clear();
            alternateEmailField.sendKeysWithDelay("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbb");
            saveButton.getElement().click();
            errorAlternateEmailMessageText();

            //invalid date character
            alternateEmailField.getElement().clear();
            alternateEmailField.sendKeysWithDelay("8/18/2024");
            saveButton.getElement().click();
            errorAlternateEmailMessageText();

            //invalid date character -->
            alternateEmailField.getElement().clear();
            alternateEmailField.sendKeysWithDelay("        abc@mail.com");
            saveButton.getElement().click();

            //invalid date character -->
            editButton();
            alternateEmailField.getElement().clear();
            alternateEmailField.sendKeysWithDelay("12458641");
            saveButton.getElement().click();
            errorAlternateEmailMessageText();

            //invalid date character -->
            alternateEmailField.getElement().clear();
            alternateEmailField.sendKeysWithDelay("145.4545");
            saveButton.getElement().click();
            errorAlternateEmailMessageText();

            //invalid date character -->
            alternateEmailField.getElement().clear();
            alternateEmailField.sendKeysWithDelay("1,234.568");
            saveButton.getElement().click();
            errorAlternateEmailMessageText();

            //invalid date character -->
            alternateEmailField.getElement().clear();
            alternateEmailField.sendKeysWithDelay("east wes(){}*");
            saveButton.getElement().click();
            errorAlternateEmailMessageText();

            //invalid date character -->
            alternateEmailField.getElement().clear();
            alternateEmailField.sendKeysWithDelay("<p>east west;</p>");
            saveButton.getElement().click();
            errorAlternateEmailMessageText();

            //valid empty
            alternateEmailField.getElement().clear();
            alternateEmailField.sendKeysWithDelay("");
            saveButton.getElement().click();

            //valid white space
            editButton();
            alternateEmailField.getElement().clear();
            saveButton.getElement().click();

            //valid white space -->
            editButton();
            alternateEmailField.getElement().clear();
            alternateEmailField.sendKeysWithDelay("asdasdagsfagsdfkghgggggggggggggggggddadag@mail.com");
            saveButton.getElement().click();

            //valid white space -->
            editButton();
            alternateEmailField.getElement().clear();
            alternateEmailField.sendKeysWithDelay("AVDFCD");
            saveButton.getElement().click();
            errorAlternateEmailMessageText();

            //valid white space -->
            alternateEmailField.getElement().clear();
            alternateEmailField.sendKeysWithDelay("      145458645245          ");
            saveButton.getElement().click();
            errorAlternateEmailMessageText();

            //valid white space -->
            alternateEmailField.getElement().clear();
            alternateEmailField.sendKeysWithDelay("asfadgaf");
            saveButton.getElement().click();
            errorAlternateEmailMessageText();

            //valid white space -->
            alternateEmailField.getElement().clear();
            alternateEmailField.sendKeysWithDelay("ASSDcadfa");
            saveButton.getElement().click();
            errorAlternateEmailMessageText();

            //valid email
            alternateEmailField.getElement().clear();
            alternateEmailField.sendKeysWithDelay("khckgc@ff.vv");
            saveButton.getElement().click();

            // Restore the original name
            editButton();
            alternateEmailField.getElement().clear();
            alternateEmailField.sendKeys(originalName);
            saveButton.scrollUntilElementIsVisible();
            saveButton.getElement().click();
        }
    }

    //tc wise done
    public void bloodGroup(){
        if(bloodGroupNotPresent.isPresent()) {
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
    private void errorAlternateEmailMessageText(){
        ExplicitWait.elementToBeVisible(alternateEmailFieldErrorText.getLocator());
        Assert.assertTrue(alternateEmailFieldErrorText.isDisplayed(), errorMessageText);
    }

//    private void editButton(){
//        if(editButton.isPresent()){
//            ExplicitWait.elementToBeClickable(editButton.getLocator());
//            editButton.scrollUntilElementIsVisible();
//            editButton.getElement().click();
//        }else {
//            ExplicitWait.elementToBeClickable(editButton2.getLocator());
//            editButton2.scrollUntilElementIsVisible();
//            editButton2.getElement().click();
//        }
//    }

    private void editButton(){
        if(editButton.isPresent()){
            ExplicitWait.elementToBeClickable(editButton.getLocator());
            editButton.scrollUntilElementIsVisible();
            editButton.getElement().click();
        }else {
            ExplicitWait.elementToBeClickable(editButton2.getLocator());
            editButton2.scrollUntilElementIsVisible();
            editButton2.getElement().click();
        }
    }

}
