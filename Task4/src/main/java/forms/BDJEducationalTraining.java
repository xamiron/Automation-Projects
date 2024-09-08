package forms;

import elements.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utility.DataReader;


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
    //degree JSC
    private final Element degreeJSC = new Element(By.cssSelector("select#txtExamTitle>option[value='JSC']"));
    private final Element degreeJDC = new Element(By.cssSelector("select#txtExamTitle>option[value='JDC (Madrasah)']"));
    private final Element degreetEightPass = new Element(By.cssSelector("select#txtExamTitle>option[value='8 Pass']"));
    private final Element degreeJSCOther = new Element(By.cssSelector("select#txtExamTitle>option[value='others']"));
    //degree SSC
    private final Element degreeSSC = new Element(By.cssSelector("select#txtExamTitle>option[value='others']"));
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

    private static final String educationLevel1 = DataReader.getStringValue("educationLevel", "config");
    private static final String degreeTitle = DataReader.getStringValue("degree","config");

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
    }

}
