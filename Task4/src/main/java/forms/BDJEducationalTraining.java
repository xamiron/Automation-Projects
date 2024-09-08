package forms;

import elements.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utility.DataReader;
import waits.ExplicitWait;


import java.util.List;

public class BDJEducationalTraining extends BaseForm {
    private final Element educationTrainingButton = new Element(By.cssSelector(".btn.btn-tab-education"));
    private final Element closeButtonPersonal = new Element(By.cssSelector("div[class='btn-form-control'] a[aria-label='Click close to go back to edit resume without saving']"));
    private final Element addNewEducationButton = new Element(By.cssSelector("#btnAdd_aca"));
    private final Element levelOfEduDropdown = new Element(By.cssSelector("#cboEduLevel"));
    private final Element pscFivePass = new Element(By.cssSelector("select#cboEduLevel>option[value='-3']"));
    private final Element jscEightPass = new Element(By.cssSelector("select#cboEduLevel>option[value='-2']"));
    private final Element secondary = new Element(By.cssSelector("select#cboEduLevel>option[value='1']"));
    private final Element higherSecondary = new Element(By.cssSelector("select#cboEduLevel>option[value='2']"));
    private final Element diploma = new Element(By.cssSelector("select#cboEduLevel>option[value='3']"));
    private final Element bachelors = new Element(By.cssSelector("select#cboEduLevel>option[value='4']"));
    private final Element masters = new Element(By.cssSelector("select#cboEduLevel>option[value='5']"));
    private final Element pHD = new Element(By.cssSelector("select#cboEduLevel>option[value='6']"));
    private final Element degreeDropdown = new Element(By.cssSelector("#txtExamTitle"));
    //degree PSC
    private final Element degreePSC = new Element(By.cssSelector("select#txtExamTitle>option[value='PSC']"));
    private final Element degreeEbtedayee = new Element(By.cssSelector("select#txtExamTitle>option[value='Ebtedayee (Madrasah)']"));
    private final Element degreeFivePass = new Element(By.cssSelector("select#txtExamTitle>option[value='5 Pass']"));
    private final Element degreeOthers = new Element(By.cssSelector("select#txtExamTitle>option[value='others']"));
    private final Element degreeOthersText = new Element(By.cssSelector("#hiddenOtherEduType"));
    private final Element degreeErrorText = new Element(By.cssSelector("#txtDegreeTitleErrorMsg"));
    //degree JSC
    private final Element degreeJSC = new Element(By.cssSelector("select#txtExamTitle>option[value='JSC']"));
    private final Element degreeJDC = new Element(By.cssSelector("select#txtExamTitle>option[value='JDC (Madrasah)']"));
    private final Element degreetEightPass = new Element(By.cssSelector("select#txtExamTitle>option[value='8 Pass']"));
    private final Element degreeJSCOther = new Element(By.cssSelector("select#txtExamTitle>option[value='others']"));
    //degree SSC
    private final Element degreeSSC = new Element(By.cssSelector("select#txtExamTitle>option[value='SSC']"));
    private final Element degreeOLevel = new Element(By.cssSelector("select#txtExamTitle>option[value='O Level']"));
    private final Element degreeDakhil = new Element(By.cssSelector("select#txtExamTitle>option[value='Dakhil (Madrasah)']"));
    private final Element degreeSSCVocational = new Element(By.cssSelector("select#txtExamTitle>option[value='SSC (Vocational)']"));
    private final Element degreeSSCOthers = new Element(By.cssSelector("select#txtExamTitle>option[value='others']"));
    //degree HSC
    private final Element degreeHSC = new Element(By.cssSelector("select#txtExamTitle>option[value='HSC']"));
    private final Element degreeAlevel= new Element(By.cssSelector("select#txtExamTitle>option[value='A Level'"));
    private final Element degreeAlim = new Element(By.cssSelector("select#txtExamTitle>option[value='Alim (Madrasah)']"));
    private final Element degreeHSCVocational = new Element(By.cssSelector("select#txtExamTitle>option[value='HSC (Vocation)']"));
    private final Element degreeHSCBMT= new Element(By.cssSelector("select#txtExamTitle>option[value='HSC (BMT)']"));
    private final Element degreeHSCOther =new Element(By.cssSelector("select#txtExamTitle>option[value='others']"));
    //degree diploma
    private final Element degreeDiplomaEngineering = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Engineering']"));
    private final Element degreeDiplomaMedicalTechnology = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Medical Technology']"));
    private final Element degreeDiplomaNursing = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Nursing']"));
    private final Element degreeDiplomaCommerce = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Commerce']"));
    private final Element degreeDiplomaBusinessStudies = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Business Studies']"));
    private final Element degreePostGraduateDiploma = new Element(By.cssSelector("select#txtExamTitle > option[value='Post Graduate Diploma (PGD)']"));
    private final Element degreeDiplomaPathology = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Pathology']"));
    private final Element degreeDiplomaVocational = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma (Vocational)']"));
    private final Element degreeDiplomaHotelManagement = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Hotel Management']"));
    private final Element degreeDiplomaComputer = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Computer']"));
    private final Element degreeDiplomaMechanical = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Mechanical']"));
    private final Element degreeDiplomaRefrigerationAC = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Refrigeration and air Conditioning']"));
    private final Element degreeDiplomaElectrical = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Electrical']"));
    private final Element degreeDiplomaAutomobile = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Automobile']"));
    private final Element degreeDiplomaPower = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Power']"));
    private final Element degreeDiplomaElectronics = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Electronics']"));
    private final Element degreeDiplomaArchitecture = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Architecture']"));
    private final Element degreeDiplomaElectroMedical = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Electro medical']"));
    private final Element degreeDiplomaCivil = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Civil']"));
    private final Element degreeDiplomaMarineEngineering = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Marine Engineering']"));
    private final Element degreeDiplomaMedical = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Medical']"));
    private final Element degreeDiplomaMidwifery = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Midwifery']"));
    private final Element degreeDiplomaMedicalUltrasound = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Medical Ultrasound']"));
    private final Element degreeDiplomaHealthTechnology = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Health Technology and Services']"));
    private final Element degreeDiplomaAgriculture = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Agriculture']"));
    private final Element degreeDiplomaFisheries = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Fisheries']"));
    private final Element degreeDiplomaLivestock = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Livestock']"));
    private final Element degreeDiplomaForestry = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Forestry']"));
    private final Element degreeDiplomaTextileEngineering = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Textile Engineering']"));
    private final Element degreeCertificateMarineTrade = new Element(By.cssSelector("select#txtExamTitle > option[value='Certificate in Marine Trade']"));
    private final Element degreeDiplomaMedicalPhysiotherapy = new Element(By.cssSelector("select#txtExamTitle > option[value='Diploma in Medical Technology (Physiotherapy)']"));
    private final Element degreeDiplomaOthers = new Element(By.cssSelector("select#txtExamTitle > option[value='others']"));
    //board
    private final Element boardSelector = new Element(By.cssSelector("#txtExamBoard"));
    private final Element boardSelect = new Element(By.cssSelector("select#txtExamBoard > option[value='-1']"));
    private final Element boardBarishal = new Element(By.cssSelector("select#txtExamBoard > option[value='6']"));
    private final Element boardChattogram = new Element(By.cssSelector("select#txtExamBoard > option[value='5']"));
    private final Element boardCumilla = new Element(By.cssSelector("select#txtExamBoard > option[value='3']"));
    private final Element boardDhaka = new Element(By.cssSelector("select#txtExamBoard > option[value='1']"));
    private final Element boardDinajpur = new Element(By.cssSelector("select#txtExamBoard > option[value='10']"));
    private final Element boardJashore = new Element(By.cssSelector("select#txtExamBoard > option[value='4']"));
    private final Element boardMymensingh = new Element(By.cssSelector("select#txtExamBoard > option[value='11']"));
    private final Element boardRajshahi = new Element(By.cssSelector("select#txtExamBoard > option[value='2']"));
    private final Element boardSylhet = new Element(By.cssSelector("select#txtExamBoard > option[value='7']"));
    private final Element boardMadrasah = new Element(By.cssSelector("select#txtExamBoard > option[value='8']"));
    private final Element boardTechnical = new Element(By.cssSelector("select#txtExamBoard > option[value='9']"));
    private final Element boardBOU = new Element(By.cssSelector("select#txtExamBoard > option[value='12']"));
    private final Element errorText = new Element(By.cssSelector("#txtBoardErrorMsg"));



    private final Element saveButton = new Element(By.cssSelector("body > div:nth-child(20) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(8) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(3) > div:nth-child(1) > a:nth-child(1)"));

    private static final String educationLevel1 = DataReader.getStringValue("educationLevel", "config");
    private static final String degreeTitle = DataReader.getStringValue("degree","config");
    private static final String board = DataReader.getStringValue("board","config");
    private final String errorMessageText = "Error message is not displayed.";

    public BDJEducationalTraining() {
        super(new Element(By.cssSelector("btn.active.btn-tab-education")));
    }

    public void education() {
        closeButtonPersonal.getElement().click();
        educationTrainingButton.moveToElement();
        educationTrainingButton.getElement().click();
        addNewEducationButton.getElement().click();

        educationDropDown();
        selectEducationLevel();
        degreeDropdown.getElement().click();
        selectDegreeLevel();
        selectBoard();
    }

    public void educationDropDown() {
        WebElement dropdownElement = levelOfEduDropdown.getElement();
        Select dropdown = new Select(dropdownElement);

        List<WebElement> options = dropdown.getOptions();
        for (WebElement option : options) {
            dropdown.selectByVisibleText(option.getText());
//            System.out.println("Selected: " + option.getText());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void selectEducationLevel() {
        Element selectedElement;
        switch (educationLevel1.toLowerCase()) {
            case "psc":
                selectedElement = pscFivePass;
                break;
            case "jsc":
                selectedElement = jscEightPass;
                break;
            case "ssc":
                selectedElement = secondary;
                break;
            case "hsc":
                selectedElement = higherSecondary;
                break;
            case "diploma":
                selectedElement = diploma;
                break;
            case "bachelors":
                selectedElement = bachelors;
                break;
            case "masters":
                selectedElement = masters;
                break;
            case "phd":
                selectedElement = pHD;
                break;
            default:
                throw new IllegalArgumentException("Invalid education level provided: " + educationLevel1);
        }
        selectedElement.getElement().click();
    }

    public void selectDegreeLevel(){
        Element selectedElement;
        if ("psc".equalsIgnoreCase(educationLevel1)) {
            switch (degreeTitle.toLowerCase()) {
                case "psc":
                    selectedElement = degreePSC;
                    break;
                case "ebtedayee":
                    selectedElement = degreeEbtedayee;
                    break;
                case "fivepass":
                    selectedElement = degreeFivePass;
                    break;
                case "others":
                    selectedElement = degreeOthers;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid education level provided: " + degreeTitle);
            }
            //invalid check
            degreeDropdown.getElement().click();
            degreeOthers.getElement().click();
            degreeOthersText.sendKeys("");
            saveButton.click();
            errorPSETextMessage();

            //invalid check
            degreeDropdown.getElement().click();
            degreeOthers.getElement().click();
            degreeOthersText.sendKeys("   ");
            saveButton.click();
            errorPSETextMessage();

            //valid check
            selectedElement.getElement().click();
        }
        else if("jdc".equalsIgnoreCase(educationLevel1)){
            switch (degreeTitle.toLowerCase()){
                case "jsc":
                    selectedElement = degreeJSC;
                    break;
                case "jdc":
                    selectedElement = degreeJDC;
                    break;
                case "eightpass":
                    selectedElement = degreetEightPass;
                    break;
                case "others":
                    selectedElement = degreeJSCOther;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid education level provided: " + degreeTitle);
            }
            //invalid check
            degreeDropdown.getElement().click();
            degreeOthers.getElement().click();
            degreeOthersText.sendKeys("");
            saveButton.click();
            errorPSETextMessage();

            //invalid check
            degreeDropdown.getElement().click();
            degreeOthers.getElement().click();
            degreeOthersText.sendKeys("   ");
            saveButton.click();
            errorPSETextMessage();

            selectedElement.getElement().click();
        }
        else if("ssc".equalsIgnoreCase(educationLevel1)){
            switch (degreeTitle.toLowerCase()){
                case "ssc":
                    selectedElement = degreeSSC;
                    break;
                case "olevel":
                    selectedElement = degreeOLevel;
                    break;
                case "dakhil":
                    selectedElement = degreeDakhil;
                    break;
                case "vocational":
                    selectedElement=degreeSSCVocational;
                    break;
                case "others":
                    selectedElement=degreeSSCOthers;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid education level provided: " + degreeTitle);
            }
            selectedElement.getElement().click();
        }
        else if("hsc".equalsIgnoreCase(educationLevel1)){
            switch (degreeTitle.toLowerCase()){
                case "hsc":
                    selectedElement = degreeHSC;
                    break;
                case "alevel":
                    selectedElement = degreeAlevel;
                    break;
                case "alim":
                    selectedElement = degreeAlim;
                    break;
                case "hscVocational":
                    selectedElement=degreeHSCVocational;
                    break;
                case "hscBMT":
                    selectedElement=degreeHSCBMT;
                    break;
                case "others":
                    selectedElement=degreeHSCOther;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid education level provided: " + degreeTitle);
            }
            selectedElement.getElement().click();
        }
        else if("diploma".equalsIgnoreCase(educationLevel1)){
            switch (degreeTitle.toLowerCase()){
                case "diplomaengineering":
                    selectedElement = degreeDiplomaEngineering;
                    break;
                case "medicaltechnology":
                    selectedElement = degreeDiplomaMedicalTechnology;
                    break;
                case "nursing":
                    selectedElement = degreeDiplomaNursing;
                    break;
                case "commerce":
                    selectedElement = degreeDiplomaCommerce;
                    break;
                case "businessstudies":
                    selectedElement = degreeDiplomaBusinessStudies;
                    break;
                case "graduatediploma":
                    selectedElement = degreePostGraduateDiploma;
                    break;
                case "pathology":
                    selectedElement = degreeDiplomaPathology;
                    break;
                case "vocational":
                    selectedElement = degreeDiplomaVocational;
                    break;
                case "hotelmanagement":
                    selectedElement = degreeDiplomaHotelManagement;
                    break;
                case "computer":
                    selectedElement = degreeDiplomaComputer;
                    break;
                case "mechanical":
                    selectedElement = degreeDiplomaMechanical;
                    break;
                case "refrigerationac":
                    selectedElement = degreeDiplomaRefrigerationAC;
                    break;
                case "electrical":
                    selectedElement = degreeDiplomaElectrical;
                    break;
                case "automobile":
                    selectedElement = degreeDiplomaAutomobile;
                    break;
                case "power":
                    selectedElement = degreeDiplomaPower;
                    break;
                case "electronics":
                    selectedElement = degreeDiplomaElectronics;
                    break;
                case "architecture":
                    selectedElement = degreeDiplomaArchitecture;
                    break;
                case "electromedical":
                    selectedElement = degreeDiplomaElectroMedical;
                    break;
                case "civil":
                    selectedElement = degreeDiplomaCivil;
                    break;
                case "marineengineering":
                    selectedElement = degreeDiplomaMarineEngineering;
                    break;
                case "medical":
                    selectedElement = degreeDiplomaMedical;
                    break;
                case "midwifery":
                    selectedElement = degreeDiplomaMidwifery;
                    break;
                case "medicalultrasound":
                    selectedElement = degreeDiplomaMedicalUltrasound;
                    break;
                case "healthtechnology":
                    selectedElement = degreeDiplomaHealthTechnology;
                    break;
                case "agriculture":
                    selectedElement = degreeDiplomaAgriculture;
                    break;
                case "fisheries":
                    selectedElement = degreeDiplomaFisheries;
                    break;
                case "livestock":
                    selectedElement = degreeDiplomaLivestock;
                    break;
                case "forestry":
                    selectedElement = degreeDiplomaForestry;
                    break;
                case "textiletngineering":
                    selectedElement = degreeDiplomaTextileEngineering;
                    break;
                case "marinetrade":
                    selectedElement = degreeCertificateMarineTrade;
                    break;
                case "medicalphysiotherapy":
                    selectedElement = degreeDiplomaMedicalPhysiotherapy;
                    break;
                case "others":
                    selectedElement = degreeDiplomaOthers;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid education level provided: " + degreeTitle);
            }
            selectedElement.getElement().click();
        }
    }

    public void selectBoard(){
        Element selectedElement;
        switch (board.toLowerCase()) {
            case "barishal":
                selectedElement = boardBarishal;
                break;
            case "chattogram":
                selectedElement = boardChattogram;
                break;
            case "cumilla":
                selectedElement = boardCumilla;
                break;
            case "dhaka":
                selectedElement = boardDhaka;
                break;
            case "dinajpur":
                selectedElement = boardDinajpur;
                break;
            case "jashore":
                selectedElement = boardJashore;
                break;
            case "mymensingh":
                selectedElement = boardMymensingh;
                break;
            case "rajshahi":
                selectedElement = boardRajshahi;
                break;
            case "sylhet":
                selectedElement = boardSylhet;
                break;
            case "madrasah":
                selectedElement = boardMadrasah;
                break;
            case "technical":
                selectedElement = boardTechnical;
                break;
            case "BOU":
                selectedElement = boardBOU;
                break;
            default:
                throw new IllegalArgumentException("Invalid education level provided: " + educationLevel1);
        }
        //invalid check
        boardSelector.getElement().click();
        saveButton.getElement().click();
        errorBoardMessageText();


        //invalid check
        boardSelector.getElement().click();
        boardSelect.getElement().click();
        saveButton.getElement().click();
        errorBoardMessageText();

        //valid click
        selectedElement.getElement().click();
    }

    public void errorBoardMessageText(){
        ExplicitWait.elementToBeVisible(errorText.getLocator());
        Assert.assertTrue(errorText.isDisplayed(), errorMessageText);
    }
    public void errorPSETextMessage(){
        ExplicitWait.elementToBeClickable(degreeErrorText.getLocator());
        Assert.assertTrue(degreeErrorText.isDisplayed(),errorMessageText);
    }
}
