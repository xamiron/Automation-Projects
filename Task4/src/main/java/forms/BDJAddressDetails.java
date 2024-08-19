package forms;

import elements.BaseElement;
import elements.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import waits.ExplicitWait;
import java.util.List;
import java.util.Random;

import static waits.ExplicitWait.threadWait;

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
    private final Element houseTextField = new Element(By.cssSelector("#present_Village"));
    private final Element disableCheckBox = new Element(By.cssSelector("#same_address"));
    private final Element disabled = new Element(By.cssSelector(".disable-area.disable"));
    private final Element enabled = new Element(By.cssSelector(".disable-area"));
    private final Element saveButton = new Element(By.cssSelector("#addressSaveBtn"));

    public BDJAddressDetails() {
        super(new Element(By.cssSelector("button.btn.collapsed[data-target='#collapseTwo']")));
    }

    public void presentAddress() {
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
}
