package forms;

import elements.Element;
import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import waits.ExplicitWait;
import java.util.List;
import java.util.Random;

public class BDJAddressDetails extends BaseForm {
    private final Element closeButton = new Element(By.cssSelector("div[class='btn-form-control'] a[aria-label='Click close to go back to edit resume without saving']"));
    private final Element personalButton = new Element(By.cssSelector("button[class='btn']"));
    private final Element addressDetailsDropdown = new Element(By.cssSelector("#headingTwo"));
    private final Element editButton = new Element(By.cssSelector("button#addressEditBtn"));
    private final Element insideButton = new Element(By.cssSelector("#radioPrsn1"));
    private final Element outsideButton = new Element(By.cssSelector("label.radio-inline > input.outside[name='presentLocation'][value='1']"));
    private final Element districtDropDown = new Element(By.cssSelector("#present_district"));
    private final Element thanaDropDown = new Element(By.cssSelector("#present_thana"));
    private final Element postOfficeDropDown = new Element(By.cssSelector("#present_p_office"));
    private final Element countryDropDown = new Element(By.cssSelector("#present_country_list"));
    private final Element countrySelect = new Element(By.cssSelector("select#present_country_list > option[value='-1']"));
    private final Element countryAfganistan = new Element(By.cssSelector("select#present_country_list > option[value='101']"));
    private final Element countryErrorText = new Element(By.cssSelector("#txtpresnContryErrorMsg"));
    private final Element houseTextField = new Element(By.cssSelector("#present_Village"));
    private final Element houseTextFieldErrorText = new Element(By.cssSelector("#txtpresnVillErrorMsg"));
    private final Element disableCheckBox = new Element(By.cssSelector("#same_address"));
    private final Element disabled = new Element(By.cssSelector(".disable-area.disable"));
    private final Element enabled = new Element(By.cssSelector(".disable-area"));
    private final Element checkboxbutton = new Element(By.cssSelector("div[class='checkbox btn-form-control'] label"));
    private final Element boxNotVisible = new Element(By.cssSelector(".disable-area"));
    private final Element boxVisible = new Element(By.cssSelector(".disable-area.disable"));
    private final Element saveButton = new Element(By.cssSelector("#addressSaveBtn"));
// all selected element
    //====================================
// all selected element
    private final Element districtSelect = new Element(By.cssSelector("select#present_district > option[value='-1']"));
    private final Element districtBrahmanbaria = new Element(By.cssSelector("select#present_district > option[value='1']"));
    private final Element districtBagerhat = new Element(By.cssSelector("select#present_district > option[value='2']"));
    private final Element districtBandarban = new Element(By.cssSelector("select#present_district > option[value='3']"));
    private final Element districtBarishal = new Element(By.cssSelector("select#present_district > option[value='4']"));
    private final Element districtBhola = new Element(By.cssSelector("select#present_district > option[value='5']"));
    private final Element districtBogura = new Element(By.cssSelector("select#present_district > option[value='6']"));
    private final Element districtBarguna = new Element(By.cssSelector("select#present_district > option[value='7']"));
    private final Element districtChandpur = new Element(By.cssSelector("select#present_district > option[value='8']"));
    private final Element districtChapainawabganj = new Element(By.cssSelector("select#present_district > option[value='9']"));
    private final Element districtChattogram = new Element(By.cssSelector("select#present_district > option[value='10']"));
    private final Element districtChuadanga = new Element(By.cssSelector("select#present_district > option[value='11']"));
    private final Element districtCumilla = new Element(By.cssSelector("select#present_district > option[value='12']"));
    private final Element districtCoxsBazar = new Element(By.cssSelector("select#present_district > option[value='13']"));
    private final Element districtDhaka = new Element(By.cssSelector("select#present_district > option[value='14']"));
    private final Element districtDinajpur = new Element(By.cssSelector("select#present_district > option[value='15']"));
    private final Element districtFaridpur = new Element(By.cssSelector("select#present_district > option[value='16']"));
    private final Element districtFeni = new Element(By.cssSelector("select#present_district > option[value='17']"));
    private final Element districtGaibandha = new Element(By.cssSelector("select#present_district > option[value='18']"));
    private final Element districtGazipur = new Element(By.cssSelector("select#present_district > option[value='19']"));
    private final Element districtGopalganj = new Element(By.cssSelector("select#present_district > option[value='20']"));
    private final Element districtHabiganj = new Element(By.cssSelector("select#present_district > option[value='21']"));
    private final Element districtJamalpur = new Element(By.cssSelector("select#present_district > option[value='22']"));
    private final Element districtJashore = new Element(By.cssSelector("select#present_district > option[value='23']"));
    private final Element districtJhalakathi = new Element(By.cssSelector("select#present_district > option[value='24']"));
    private final Element districtJhenaidah = new Element(By.cssSelector("select#present_district > option[value='25']"));
    private final Element districtJoypurhat = new Element(By.cssSelector("select#present_district > option[value='26']"));
    private final Element districtKhagrachhari = new Element(By.cssSelector("select#present_district > option[value='27']"));
    private final Element districtKhulna = new Element(By.cssSelector("select#present_district > option[value='28']"));
    private final Element districtKishoreganj = new Element(By.cssSelector("select#present_district > option[value='29']"));
    private final Element districtKurigram = new Element(By.cssSelector("select#present_district > option[value='30']"));
    private final Element districtKushtia = new Element(By.cssSelector("select#present_district > option[value='31']"));
    private final Element districtLalmonirhat = new Element(By.cssSelector("select#present_district > option[value='32']"));
    private final Element districtLaksmipur = new Element(By.cssSelector("select#present_district > option[value='33']"));
    private final Element districtMadaripur = new Element(By.cssSelector("select#present_district > option[value='34']"));
    private final Element districtMagura = new Element(By.cssSelector("select#present_district > option[value='35']"));
    private final Element districtManikganj = new Element(By.cssSelector("select#present_district > option[value='36']"));
    private final Element districtMeherpur = new Element(By.cssSelector("select#present_district > option[value='37']"));
    private final Element districtMoulvibazar = new Element(By.cssSelector("select#present_district > option[value='38']"));
    private final Element districtMunshiganj = new Element(By.cssSelector("select#present_district > option[value='39']"));
    private final Element districtMymensingh = new Element(By.cssSelector("select#present_district > option[value='40']"));
    private final Element districtNaogaon = new Element(By.cssSelector("select#present_district > option[value='41']"));
    private final Element districtNarail = new Element(By.cssSelector("select#present_district > option[value='42']"));
    private final Element districtNarayanganj = new Element(By.cssSelector("select#present_district > option[value='43']"));
    private final Element districtNarsingdi = new Element(By.cssSelector("select#present_district > option[value='44']"));
    private final Element districtNatore = new Element(By.cssSelector("select#present_district > option[value='45']"));
    private final Element districtNetrokona = new Element(By.cssSelector("select#present_district > option[value='46']"));
    private final Element districtNilphamari = new Element(By.cssSelector("select#present_district > option[value='47']"));
    private final Element districtNoakhali = new Element(By.cssSelector("select#present_district > option[value='48']"));
    private final Element districtPabna = new Element(By.cssSelector("select#present_district > option[value='49']"));
    private final Element districtPanchagarh = new Element(By.cssSelector("select#present_district > option[value='50']"));
    private final Element districtPatuakhali = new Element(By.cssSelector("select#present_district > option[value='51']"));
    private final Element districtPirojpur = new Element(By.cssSelector("select#present_district > option[value='52']"));
    private final Element districtRajbari = new Element(By.cssSelector("select#present_district > option[value='53']"));
    private final Element districtRajshahi = new Element(By.cssSelector("select#present_district > option[value='54']"));
    private final Element districtRangamati = new Element(By.cssSelector("select#present_district > option[value='55']"));
    private final Element districtRangpur = new Element(By.cssSelector("select#present_district > option[value='56']"));
    private final Element districtSatkhira = new Element(By.cssSelector("select#present_district > option[value='57']"));
    private final Element districtShariatpur = new Element(By.cssSelector("select#present_district > option[value='58']"));
    private final Element districtSherpur = new Element(By.cssSelector("select#present_district > option[value='59']"));
    private final Element districtSirajganj = new Element(By.cssSelector("select#present_district > option[value='60']"));
    private final Element districtSunamganj = new Element(By.cssSelector("select#present_district > option[value='61']"));
    private final Element districtSylhet = new Element(By.cssSelector("select#present_district > option[value='62']"));
    private final Element districtTangail = new Element(By.cssSelector("select#present_district > option[value='63']"));
    private final Element districtThakurgaon = new Element(By.cssSelector("select#present_district > option[value='64']"));
    private final Element districtErrorText = new Element(By.cssSelector("#txtpresnDistrictErrorMsg"));
//Select Thana 1129
    private final Element selectThana = new Element(By.cssSelector("select#present_thana>option[value='-1']"));
    private final Element selectThanaAkhaura = new Element(By.cssSelector("select#present_thana>option[value='1107']"));
    private final Element selectThanaBagerhatSadar = new Element(By.cssSelector("select#present_thana>option[value='1129']"));
    private final Element selectThanaErrorText= new Element(By.cssSelector("#presenttxtThanaErrorMsg"));
//Select Post Office
    private final Element selectPO = new Element(By.cssSelector("select#present_p_office > option[value='-1']"));
    private final Element selectPOAlikadam = new Element(By.cssSelector("select#present_p_office > option[value='2501']"));
    private final Element selectPOAkhaura =  new Element(By.cssSelector("select#present_p_office > option[value='1923']"));
//Permanent selector
    private final Element permanentDistrictDropDown = new Element(By.cssSelector("#permanent_district"));
    private final Element permanentDistrictSelect = new Element(By.cssSelector("select#permanent_district > option[value='-1']"));
    private final Element permanentBrahmanbaria = new Element(By.cssSelector("select#permanent_district > option[value='1']"));
    private final Element permanentThanaDropdown = new Element(By.cssSelector("#permanent_thana"));
    private final Element permanentThanaSelect = new Element(By.cssSelector("select#permanent_thana > option[value='-1']"));
    private final Element permanentAkhauraSelect= new Element(By.cssSelector("select#permanent_thana > option[value='1107']"));
    private final Element permanentPODropdown = new Element(By.cssSelector("#permanent_p_office"));
    private final Element permanentVillageField = new Element(By.cssSelector("#permanent_Village"));
    private final Element permanentInsideBangladesh = new Element(By.cssSelector("#radiopermanentLocation1"));
    private final Element permanentOutsideBangladesh= new Element(By.cssSelector("#radiopermanentLocation2"));
    private final Element permanentCountryDropdown = new Element(By.cssSelector("#permanent_country_list"));
    private final Element permanentDistrictErrorText = new Element(By.cssSelector("#txtprmtDistrictErrorMsg"));
    private final Element permanentThanaErrorText = new Element(By.cssSelector("#permanenttxtThanaErrorMsg"));
    private final Element permanentVillageFieldErrorText = new Element(By.cssSelector("#txtprmtVillErrorMsg"));
    private final Element permanentAkauraPOSelect = new Element(By.cssSelector("select#permanent_p_office > option[value='1923']"));
    private final Element permanentPOSelect= new Element(By.cssSelector("select#permanent_p_office > option[value='-1']"));
    private final Element permanenetVillageFieldText = new Element(By.cssSelector("#permanent_Village"));
    private final Element permanentCountryDropDown = new Element(By.cssSelector("#permanent_country_list"));
    private final Element permanentCountrySelect = new Element(By.cssSelector("select#permanent_country_list>option[value='-1']"));
    private final Element permanentCountryErrorText = new Element(By.cssSelector("#txtprmtContryErrorMsg"));
    private final Element permanentCountryAfganistanSelector = new Element(By.cssSelector("select#permanent_country_list>option[value='101']"));
    private final Element permanentCountryTextField = new Element(By.cssSelector("#permanent_Village"));
    private final Element permanentVillageErrorText = new Element(By.cssSelector("#txtprmtVillErrorMsg"));
    private final Element presentAddressField = new Element(By.cssSelector("div[class='form-group'] span[class='label']"));
    private final Element permanentAddressField = new Element(By.cssSelector("div[class='title-wrap'] span[class='label'] "));
    //present outside bangladesh
    private final Element presentAfganistan= new Element(By.cssSelector("select[id='present_country_list'] option[value='101']"));
    private final Element permanentGazipur = new Element(By.cssSelector("select[id='permanent_district'] option[value='19']"));
    private final Element permanentGazipurShadar= new Element(By.cssSelector("option[value='1279']"));
    private final Element permanentBOF= new Element(By.cssSelector("option[value='2290']"));

    private final String errorMessageText = "Error message is not displayed.";


    public BDJAddressDetails() {
        super(new Element(By.cssSelector("button.btn.collapsed[data-target='#collapseTwo']")));
    }

    public void presentAddressAllCheck() {
        ExplicitWait.elementToBeClickable(closeButton.getLocator());
        closeButton.getElement().click();
        personalButton.getElement().click();

        //threadWait();
        //ExplicitWait.presenceOfElementLocated(addressDetailsDropdown.getLocator());
        addressDetailsDropdown.scrollUntilElementIsVisible();
        addressDetailsDropdown.getElement().click();
        ExplicitWait.elementToBeClickable(editButton.getLocator());
        editButton.getElement().click();

        try {
            if (enabled.isDisplayed()) {
                disableCheckBox.getElement().click();
            }
        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("Element not found or not clickable: " + e.getMessage());
        }

        // Test inside Bangladesh
        ExplicitWait.elementToBeClickable(insideButton.getLocator());
        insideButton.click();
        fillInsideBangladeshAddress();

        // Test outside Bangladesh
        ExplicitWait.elementToBeClickable(outsideButton.getLocator());
        outsideButton.click();
        fillOutsideBangladeshAddress();

        try {
            if (enabled.isDisplayed()) {
                disableCheckBox.getElement().click();
            }
        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("Element not found or not clickable: " + e.getMessage());
        }

    }
    public void permanentAddressAllChecking() {
        ExplicitWait.elementToBeClickable(closeButton.getLocator());
        closeButton.getElement().click();
        personalButton.getElement().click();

        addressDetailsDropdown.scrollUntilElementIsVisible();
        addressDetailsDropdown.getElement().click();
        ExplicitWait.elementToBeClickable(editButton.getLocator());
        editButton.getElement().click();

        try {
            if (disabled.isDisplayed()) {
                disableCheckBox.getElement().click();
            }else{
                System.out.println("Element not found or not clickable.");
            }
        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("Element not found or not clickable: " + e.getMessage());
        }

        // Test inside Bangladesh
        ExplicitWait.elementToBeClickable(insideButton.getLocator());
        insideButton.click();
        permanentInsideBangladesh.click();
        fillInsideBangladeshAddressPermanent();

        ExplicitWait.elementToBeClickable(permanentOutsideBangladesh.getLocator());
        permanentOutsideBangladesh.click();
        fillOutsideBangladeshAddressPermanent();
    }

    // _=OLD=_
//    public void presentAddressIndividualInsideBangladesh() {
//        ExplicitWait.elementToBeClickable(closeButton.getLocator());
//        closeButton.getElement().click();
//        personalButton.getElement().click();
//
//        addressDetailsDropdown.scrollUntilElementIsVisible();
//        addressDetailsDropdown.getElement().click();
//        ExplicitWait.elementToBeClickable(editButton.getLocator());
//        editButton.getElement().click();
//
//        insideButton.getElement().click();
//
//        //invalid district
//        districtDropDown.getElement().click();
//        districtSelect.getElement().click();
//        saveButton.getElement().click();
//        errorDistrictMessageText();
//
//        //Valid district
//        districtDropDown.getElement().click();
//        districtBagerhat.getElement().click();
//        saveButton.getElement().click();
//
//        //invalid thana
//        thanaDropDown.getElement().click();
//        selectThana.getElement().click();
//        saveButton.getElement().click();
//        errorThanaMessageText();
//
//        //valid thana
//        thanaDropDown.getElement().click();
//        selectThana.getElement().click();
//        selectThanaBagerhatSadar.getElement().click();
//        saveButton.getElement().click();
//
//        //invalid but accepting
//        editButton.getElement().click();
//        postOfficeDropDown.getElement().click();
//        selectPO.getElement().click();
//        saveButton.getElement().click();
//
//        //valid
//        editButton.getElement().click();
//        postOfficeDropDown.getElement().click();
//        selectPOAlikadam.getElement().click();
//        saveButton.getElement().click();
//
//        //invalid text name
//        editButton.getElement().click();
//        houseTextField.getElement().clear();
//        houseTextField.sendKeysWithDelay("");
//        saveButton.getElement().click();
//        errorVillageMessageText();
//
//        //invalid special character
//        houseTextField.getElement().clear();
//        houseTextField.sendKeysWithDelay("!@#$%^&*()_");
//        saveButton.getElement().click();
//        errorVillageMessageText();
//
//        //invalid special character
//        houseTextField.getElement().clear();
//        houseTextField.sendKeysWithDelay("!@#$%^&*()_");
//        saveButton.getElement().click();
//        errorVillageMessageText();
//
//        //invalid special character
//        houseTextField.getElement().clear();
//        houseTextField.sendKeysWithDelay("!@ba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba1");
//        saveButton.getElement().click();
//        errorVillageMessageText();
//
//        //valid special character
//        houseTextField.getElement().clear();
//        houseTextField.sendKeysWithDelay("Dhaka, rayer bazar");
//        saveButton.getElement().click();
//    }

    public void presentAddressIndividualInsideBangladesh() {
        ExplicitWait.elementToBeClickable(closeButton.getLocator());
        closeButton.getElement().click();
        personalButton.getElement().click();

        //Dropdown button
        addressDetailsDropdown.scrollUntilElementIsVisible();
        addressDetailsDropdown.getElement().click();
        ExplicitWait.elementToBeClickable(editButton.getLocator());
        editButton.getElement().click(); //Edit button


        //present and permanent address visible check
        boolean presentAddress = presentAddressField.isDisplayed();
        Assert.assertTrue(presentAddress,"Present Address is not displayed.");
        boolean permanentAddress = permanentAddressField.isPresent();
        Assert.assertTrue(permanentAddress,"Parmanent Address is not displayed.");

        //Two radio button check
        boolean insideBangladeshBullet = insideButton.isPresent();
        Assert.assertTrue(insideBangladeshBullet,"Inside Bangladesh is not displayed.");
        boolean outsideBangladeshBullet = outsideButton.isPresent();
        Assert.assertTrue(outsideBangladeshBullet,"Outside Bangladesh is not displayed.");

        insideButton.click();
        sleep();

        //district dropdown check
        districtDropDown.getElement().click();
        sleep();
        ExplicitWait.presenceOfElementLocated(districtBrahmanbaria.getLocator());
        districtBrahmanbaria.getElement().click();
        Assert.assertTrue(districtBrahmanbaria.isDisplayed(),"Dropdown options are not visible after clicking.");

        //thana dropdown check
        thanaDropDown.getElement().click();
        sleep();
        ExplicitWait.presenceOfElementLocated(selectThanaAkhaura.getLocator());
        selectThanaAkhaura.getElement().click();
        Assert.assertTrue(selectThanaAkhaura.isDisplayed(),"Thana is not present");

        //PO dropdown check
        postOfficeDropDown.getElement().click();
        sleep();
        ExplicitWait.presenceOfElementLocated(selectPOAkhaura.getLocator());
        Assert.assertTrue(selectPOAkhaura.isDisplayed(),"Dropdown options are not visible after clicking.");

        if(boxVisible.isPresent()) {
            checkboxbutton.getElement().click();
        }

        // valid House No/Road/Village
        districtDropDown.getElement().click();
        districtBrahmanbaria.getElement().click();
        selectThanaAkhaura.getElement().click();
        selectPOAkhaura.getElement().click();
        houseTextField.getElement().clear();
        houseTextField.sendKeys("      30, banasree, block B");
        sleep();
        disableCheckBox.getElement().click();
        saveButton.getElement().click();
        Assert.assertTrue(editButton.isDisplayed(),"Edit button is not displayed.");

        //valid 150 character
        editButton.getElement().click();
        houseTextField.getElement().clear();
        houseTextField.sendKeys("asdasdagsfagsdfkghgggggggggggggggggddadag mail.com asdasdagsfagsdfkghgggggggggggggggggddadag mail.comasdasdagsfagsdfkghgggggggggggggggggddadag mail.co");
        saveButton.getElement().click();
        Assert.assertTrue(editButton.isDisplayed(),"Edit button is not displayed.");

        //valid only character
        editButton.getElement().click();
        houseTextField.getElement().clear();
        houseTextField.sendKeys("123456");
        saveButton.getElement().click();
        Assert.assertTrue(editButton.isDisplayed(),"Edit button is not displayed.");

        //valid only alphabets character
        editButton.getElement().click();
        houseTextField.getElement().clear();
        houseTextField.sendKeys("qwert");
        saveButton.getElement().click();
        Assert.assertTrue(editButton.isDisplayed(),"Edit button is not displayed.");

        //valid Decimal character
        editButton.getElement().click();
        houseTextField.getElement().clear();
        houseTextField.sendKeys("145.45");
        saveButton.getElement().click();
        Assert.assertTrue(editButton.isDisplayed(),"Edit button is not displayed.");

        //Formated number character
        editButton.getElement().click();
        houseTextField.getElement().clear();
        houseTextField.sendKeys("1,234.568");
        saveButton.getElement().click();
        Assert.assertTrue(editButton.isDisplayed(),"Edit button is not displayed.");

        //Uppercase alphabets character
        editButton.getElement().click();
        houseTextField.getElement().clear();
        houseTextField.sendKeys("AVDFCD");
        saveButton.getElement().click();
        Assert.assertTrue(editButton.isDisplayed(),"Edit button is not displayed.");

        //lowercase alphabets character
        editButton.getElement().click();
        houseTextField.getElement().clear();
        houseTextField.sendKeys("asfadgaf");
        saveButton.getElement().click();
        Assert.assertTrue(editButton.isDisplayed(),"Edit button is not displayed.");

        //Alphanumeric character
        editButton.getElement().click();
        houseTextField.getElement().clear();
        houseTextField.sendKeys("east wes(){}*");
        saveButton.getElement().click();
        errorVillageMessageText();

        //upper and lowercase character
        houseTextField.getElement().clear();
        houseTextField.sendKeys("ASSDcadfa");
        saveButton.getElement().click();
        Assert.assertTrue(editButton.isDisplayed(),"Edit button is not displayed.");

        //HTML, jscript character
        editButton.getElement().click();
        houseTextField.getElement().clear();
        houseTextField.sendKeys("<p>east west;</p>");
        saveButton.getElement().click();
        errorVillageMessageText();

        //HTML, jscript character
        houseTextField.getElement().clear();
        houseTextField.sendKeys("<p>east west;</p>");
        saveButton.getElement().click();
        errorVillageMessageText();

        //invalid empty check
        houseTextField.getElement().clear();
        saveButton.getElement().click();
        errorVillageMessageText();

        //Trailing spaces and leading spaces
        houseTextField.getElement().click();
        houseTextField.sendKeys("      145458645245          ");
        saveButton.getElement().click();
        Assert.assertTrue(editButton.isDisplayed(),"Edit button is not displayed.");

        //invalid check
        editButton.getElement().click();
        houseTextField.getElement().clear();
        houseTextField.sendKeys("@");
        saveButton.getElement().click();
        errorVillageMessageText();

        //invalid special character check
        houseTextField.getElement().clear();
        houseTextField.sendKeys("~!@#$%^&*()_+");
        saveButton.getElement().click();
        errorVillageMessageText();

        //Valid special character check
        houseTextField.getElement().clear();
        houseTextField.sendKeys(".-#, ");
        saveButton.getElement().click();
        Assert.assertTrue(editButton.isDisplayed(),"Edit button is not displayed.");

        //valid address
        editButton.getElement().click();
        houseTextField.getElement().clear();
        houseTextField.sendKeys("Building: Arial Kha, House: 182, Flat: 6/c, Dhanmondi, Dhaka-1209");
        saveButton.getElement().click();
        Assert.assertTrue(editButton.isDisplayed(),"Edit button is not displayed.");
    }

    public void presentAddressIndividualOutsideBangladesh(){
        ExplicitWait.elementToBeClickable(editButton.getLocator());
        editButton.getElement().click();
        outsideButton.getElement().click();

        //Country option
        Assert.assertTrue(countryDropDown.isDisplayed(),"Country option not visible");
        countryDropDown.getElement().click();

        //invalid country name
        countryDropDown.getElement().click();
        Assert.assertTrue(presentAfganistan.isDisplayed(),"Country no displayed");
        countrySelect.getElement().click();
        saveButton.getElement().click();
        errorCountryMessageText();

        //valid country
        countryDropDown.getElement().click();
        countryAfganistan.getElement().click();
        saveButton.getElement().click();

        //invalid text name
        editButton.getElement().click();
        houseTextField.getElement().clear();
        houseTextField.sendKeysWithDelay("");
        saveButton.getElement().click();
        errorVillageMessageText();

        //valid  character
        houseTextField.getElement().clear();
        houseTextField.sendKeysWithDelay("      New market, Kolkata");
        saveButton.getElement().click();

        //valid character
        editButton.getElement().click();
        houseTextField.getElement().clear();
        houseTextField.sendKeysWithDelay("asdasdagsfagsdfkghgggggggggggggggggddadag mail.com asdasdagsfagsdfkghgggggggggggggggggddadag mail.comasdasdagsfagsdfkghgggggggggggggggggddadag mail.co");
        saveButton.getElement().click();

        //valid  character
        editButton.getElement().click();
        houseTextField.getElement().clear();
        houseTextField.sendKeysWithDelay("123456");
        saveButton.getElement().click();

        //valid character
        editButton.getElement().click();
        houseTextField.getElement().clear();
        houseTextField.sendKeysWithDelay("qwert");
        saveButton.getElement().click();

        //valid character
        editButton.getElement().click();
        houseTextField.getElement().clear();
        houseTextField.sendKeysWithDelay("145.45");
        saveButton.getElement().click();

        //valid character
        editButton.getElement().click();
        houseTextField.getElement().clear();
        houseTextField.sendKeysWithDelay("1,234.568");
        saveButton.getElement().click();

        //valid character
        editButton.getElement().click();
        houseTextField.getElement().clear();
        houseTextField.sendKeysWithDelay(" AVDFCD");
        saveButton.getElement().click();

        //valid character
        editButton.getElement().click();
        houseTextField.getElement().clear();
        houseTextField.sendKeysWithDelay(" asfadgaf");
        saveButton.getElement().click();

        //valid character
        editButton.getElement().click();
        houseTextField.getElement().clear();
        houseTextField.sendKeysWithDelay("east wes(){}*");
        saveButton.getElement().click();
        errorVillageMessageText();

        //valid character
        houseTextField.getElement().clear();
        houseTextField.sendKeysWithDelay("ASSDcadfa");
        saveButton.getElement().click();

        //valid character
        editButton.getElement().click();
        houseTextField.getElement().clear();
        houseTextField.sendKeysWithDelay(" <p>east west;</p>");
        saveButton.getElement().click();
        errorVillageMessageText();

        //valid character
        houseTextField.getElement().clear();
        houseTextField.sendKeysWithDelay("      145458645245          ");
        saveButton.getElement().click();

        //valid character
        editButton.getElement().click();
        houseTextField.getElement().clear();
        houseTextField.sendKeysWithDelay(" 1.253       ");
        saveButton.getElement().click();

        //valid character
        editButton.getElement().click();
        houseTextField.getElement().clear();
        houseTextField.sendKeysWithDelay("Building: Arial Kha, House: 182, Flat: 6/c, Dhanmondi, Dhaka-1209");
        saveButton.getElement().click();
        Assert.assertTrue(editButton.isDisplayed(),"Edit button is not displayed.");
    }

    public void permanentAddressIndividualInsideBangladesh(){
        ExplicitWait.elementToBeClickable(editButton.getLocator());
        editButton.getElement().click();

        if(boxNotVisible.isPresent()) {
            checkboxbutton.getElement().click();
        }

        if (permanentVillageField.isEmpty()) {
            permanentVillageField.getElement().clear();
            permanentVillageField.sendKeysWithDelay("Building: Arial Kha, House: 182, Flat: 6/c, Dhanmondi, Dhaka-1209");
        }
        permanentInsideBangladesh.getElement().click();

        permanentThanaDropdown.getElement().click();
        permanentThanaSelect.getElement().click();
        permanentPODropdown.getElement().click();
        permanentPOSelect.getElement().click();

        //district dropdown check
        permanentDistrictDropDown.getElement().click();
        permanentDistrictSelect.getElement().click();
        saveButton.getElement().click();
        errorPermanentDistrictMessageText();

        permanentDistrictDropDown.getElement().click();
        sleep();
        ExplicitWait.presenceOfElementLocated(permanentGazipur.getLocator());
        permanentGazipur.getElement().click();
        Assert.assertTrue(permanentGazipur.isDisplayed(),"Dropdown options are not visible after clicking.");

        //thana dropdown check
        permanentThanaDropdown.getElement().click();
        sleep();
        ExplicitWait.presenceOfElementLocated(permanentGazipurShadar.getLocator());
        permanentGazipurShadar.getElement().click();
        Assert.assertTrue(permanentGazipurShadar.isDisplayed(),"Thana is not present");

        //Po Dropdown Check
        permanentPODropdown.getElement().click();
        sleep();
        ExplicitWait.presenceOfElementLocated(permanentBOF.getLocator());
        Assert.assertTrue(permanentBOF.isDisplayed(),"Dropdown options are not visible after clicking.");

        // valid House No/Road/Village
        permanentDistrictDropDown.getElement().click();
        permanentGazipur.getElement().click();
        permanentThanaDropdown.getElement().click();
        permanentGazipurShadar.getElement().click();
        permanentPODropdown.getElement().click();
        permanentBOF.getElement().click();
        permanentVillageField.getElement().clear();
        permanentVillageField.sendKeys("      30, banasree, block B");
        sleep();
        disableCheckBox.getElement().click();
        saveButton.getElement().click();
        Assert.assertTrue(editButton.isDisplayed(),"Edit button is not displayed.");

        //valid 150 character
        sleep();
        editButton.getElement().click();
        permanentVillageField.getElement().clear();
        permanentVillageField.sendKeys("asdasdagsfagsdfkghgggggggggggggggggddadag mail.com asdasdagsfagsdfkghgggggggggggggggggddadag mail.comasdasdagsfagsdfkghgggggggggggggggggddadag mail.co");
        saveButton.getElement().click();
        Assert.assertTrue(editButton.isDisplayed(),"Edit button is not displayed.");


//        //invalid district
//        permanentDistrictDropDown.getElement().click();
//        permanentDistrictSelect.getElement().click();
//        saveButton.getElement().click();
//        errorPermanentDistrictMessageText();
//
//        //Valid district
//        permanentDistrictDropDown.getElement().click();
//        permanentBrahmanbaria.getElement().click();
//        saveButton.getElement().click();
//
//        //invalid thana
//        permanentThanaDropdown.getElement().click();
//        permanentThanaSelect.getElement().click();
//        saveButton.getElement().click();
//        errorThanaDistrictMessageText();
////
//        //valid thana
//        permanentThanaDropdown.getElement().click();
//        permanentAkhauraSelect.getElement().click();
//        saveButton.getElement().click();
////
//        //invalid but accepting
//        editButton.getElement().click();
//        permanentPODropdown.getElement().click();
//        permanentPOSelect.getElement().click();
//        permanenetVillageFieldText.getElement().clear();
//        saveButton.getElement().click();
//        errorPermanentVillageMessageText();
//
//        //valid
//        permanentPODropdown.getElement().click();
//        permanentAkauraPOSelect.getElement().click();
//        permanenetVillageFieldText.getElement().clear();
//        saveButton.getElement().click();
//        errorPermanentVillageMessageText();
//
//        //invalid text name
//        permanenetVillageFieldText.getElement().clear();
//        permanenetVillageFieldText.sendKeysWithDelay("");
//        saveButton.getElement().click();
//        errorPermanentVillageMessageText();
//
//        //invalid white space
//        permanenetVillageFieldText.getElement().clear();
//        permanenetVillageFieldText.sendKeysWithDelay("  ");
//        saveButton.getElement().click();
//        errorPermanentVillageMessageText();
//
//        //invalid special character
//        permanenetVillageFieldText.getElement().clear();
//        permanenetVillageFieldText.sendKeysWithDelay("!@#$%^&*()_");
//        saveButton.getElement().click();
//        errorPermanentVillageMessageText();
//
//        //invalid max character
//        permanenetVillageFieldText.getElement().clear();
//        permanenetVillageFieldText.sendKeysWithDelay("!@ba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba1");
//        saveButton.getElement().click();
//        errorPermanentVillageMessageText();
//
//        //valid special character
//        permanenetVillageFieldText.getElement().clear();
//        permanenetVillageFieldText.sendKeysWithDelay("Dhaka, rayer bazar 2");
//        saveButton.getElement().click();
    }

    public void permanentAddressIndividualOutsideBangladesh(){
        try {
            if (closeButton.isDisplayed()) {
                closeButton.getElement().click();
                personalButton.getElement().click();
            }
        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("Element not found or not clickable: " + e.getMessage());
        }

        addressDetailsDropdown.scrollUntilElementIsVisible();
        addressDetailsDropdown.getElement().click();
        ExplicitWait.elementToBeClickable(editButton.getLocator());
        editButton.getElement().click();

        try {
            if (disabled.isDisplayed()) {
                ExplicitWait.elementToBeVisible(disableCheckBox.getLocator());
                disableCheckBox.getElement().click();
            }
        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("Element not found or not clickable: " + e.getMessage());
        }
        try {
            if (houseTextField.isEmpty()) {
                houseTextField.getElement().clear();
                houseTextField.sendKeysWithDelay("Dhaka, rayer bazar");
            }
        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("Element not found or not clickable: " + e.getMessage());
        }
        permanentOutsideBangladesh.getElement().click();


        //invalid country name
        permanentCountryDropDown.getElement().click();
        permanentCountrySelect.getElement().click();
        saveButton.getElement().click();
        errorPermanentCountryMessageText();

        //valid country
        permanentCountryDropDown.getElement().click();
        permanentCountryAfganistanSelector.getElement().click();
        saveButton.getElement().click();

        //invalid text name
        editButton.getElement().click();
        permanentCountryTextField.getElement().clear();
        permanentCountryTextField.sendKeysWithDelay("");
        saveButton.getElement().click();
        errorPermanentCountryTextField();

        //invalid special character
        permanentCountryTextField.getElement().clear();
        permanentCountryTextField.sendKeysWithDelay("!@#$%^&*()_");
        saveButton.getElement().click();
        errorPermanentCountryTextField();

        //invalid special character
        permanentCountryTextField.getElement().clear();
        permanentCountryTextField.sendKeysWithDelay("!@#$%^&*()_");
        saveButton.getElement().click();
        errorPermanentCountryTextField();

        //invalid special character
        permanentCountryTextField.getElement().clear();
        permanentCountryTextField.sendKeysWithDelay("!@ba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba  aba1");
        saveButton.getElement().click();
        errorPermanentCountryTextField();

        //valid special character
        permanentCountryTextField.getElement().clear();
        permanentCountryTextField.sendKeysWithDelay("Dhaka, rayer bazar");
        saveButton.getElement().click();
    }

    private void fillInsideBangladeshAddress() {
        // Iterate through all districts
        List<WebElement> districts = districtDropDown.findElements(By.tagName("option"));
        for (int i = 1; i < districts.size(); i++) {  // Start from 1 to skip "Select District"
            districts.get(i).click();
            ExplicitWait.elementToBeVisible(thanaDropDown.getLocator());

            // Iterate through all thanas based on district
            List<WebElement> thanas = thanaDropDown.findElements(By.tagName("option"));
            for (int j = 1; j < thanas.size(); j++) {  // Start from 1 to skip "Select Thana"
                thanas.get(j).click();
                ExplicitWait.elementToBeVisible(postOfficeDropDown.getLocator());

                // Iterate through all post offices based on thana
                List<WebElement> postOffices = postOfficeDropDown.findElements(By.tagName("option"));
                for (int k = 1; k < postOffices.size(); k++) {  // Start from 1 to skip "Select P.O"
                    postOffices.get(k).click();

                    // Provide a random string for the house no/road/village field
                    houseTextField.getElement().clear();
                    houseTextField.sendKeys(generateRandomString());
                    saveButton.getElement().click();
                    editButton.getElement().click();
                }
            }
        }
    }

    private void fillInsideBangladeshAddressPermanent() {
        // Iterate through all districts
        List<WebElement> districts = permanentDistrictDropDown.findElements(By.tagName("option"));
        for (int i = 1; i < districts.size(); i++) {  // Start from 1 to skip "Select District"
            districts.get(i).click();
            ExplicitWait.elementToBeVisible(permanentThanaDropdown.getLocator());

            // Iterate through all thanas based on district
            List<WebElement> thanas = permanentThanaDropdown.findElements(By.tagName("option"));
            for (int j = 1; j < thanas.size(); j++) {  // Start from 1 to skip "Select Thana"
                thanas.get(j).click();
                ExplicitWait.elementToBeVisible(permanentPODropdown.getLocator());

                // Iterate through all post offices based on thana
                List<WebElement> postOffices = permanentPODropdown.findElements(By.tagName("option"));
                for (int k = 1; k < postOffices.size(); k++) {  // Start from 1 to skip "Select P.O"
                    postOffices.get(k).click();

                    // Provide a random string for the house no/road/village field
                    permanentVillageField.getElement().clear();
                    permanentVillageField.sendKeys(generateRandomString());
                    saveButton.getElement().click();
                    editButton.getElement().click();
                }
            }
        }
    }

    private void fillOutsideBangladeshAddress() {
        // Iterate through all countries
        List<WebElement> countries = countryDropDown.findElements(By.tagName("option"));
        for (int i = 1; i < countries.size(); i++) {  // Start from 1 to skip "Select Country"
            countries.get(i).click();

            // Provide a random string for the house no/road/village field
            houseTextField.getElement().clear();
            houseTextField.sendKeys(generateRandomString());
            saveButton.getElement().click();
            editButton.getElement().click();
        }
    }

    private void fillOutsideBangladeshAddressPermanent(){
        List<WebElement> countries = permanentCountryDropdown.findElements(By.tagName("option"));
        for (int i = 1; i < countries.size(); i++) {
            countries.get(i).click();

            permanentVillageField.getElement().clear();
            permanentVillageField.sendKeys(generateRandomString());
            saveButton.getElement().click();
            editButton.getElement().click();
        }
    }

    private String generateRandomString() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            randomString.append(characters.charAt(random.nextInt(characters.length())));
        }
        return randomString.toString();
    }

    private void errorDistrictMessageText(){
        ExplicitWait.elementToBeVisible(districtErrorText.getLocator());
        Assert.assertTrue(districtErrorText.isDisplayed(), errorMessageText);
    }
    private void errorThanaMessageText(){
        ExplicitWait.elementToBeClickable(selectThanaErrorText.getLocator());
        Assert.assertTrue(thanaDropDown.isDisplayed(), errorMessageText);
    }
    private void errorVillageMessageText(){
        ExplicitWait.elementToBeClickable(houseTextFieldErrorText.getLocator());
        Assert.assertTrue(houseTextFieldErrorText.isDisplayed(), errorMessageText);
    }
    private void errorCountryMessageText(){
        ExplicitWait.elementToBeClickable(countryErrorText.getLocator());
        Assert.assertTrue(countryErrorText.isDisplayed(), errorMessageText);
    }
    private void errorPermanentDistrictMessageText(){
        ExplicitWait.elementToBeVisible(permanentDistrictErrorText.getLocator());
        Assert.assertTrue(permanentDistrictErrorText.isDisplayed(), errorMessageText);
    }
    private void errorThanaDistrictMessageText(){
        ExplicitWait.elementToBeVisible(permanentThanaErrorText.getLocator());
        Assert.assertTrue(permanentThanaErrorText.isDisplayed(), errorMessageText);
    }
    private void errorPermanentVillageMessageText(){
        ExplicitWait.elementToBeVisible(permanentVillageFieldErrorText.getLocator());
        Assert.assertTrue(permanentVillageFieldErrorText.isDisplayed(), errorMessageText);
    }
    private void errorPermanentCountryMessageText(){
        ExplicitWait.elementToBeClickable(permanentCountryErrorText.getLocator());
        Assert.assertTrue(permanentCountryErrorText.isDisplayed(), errorMessageText);
    }
    private void errorPermanentCountryTextField(){
        ExplicitWait.elementToBeClickable(permanentVillageErrorText.getLocator());
        Assert.assertTrue(permanentVillageErrorText.isDisplayed(),errorMessageText);
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
