package forms;

import elements.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import waits.ExplicitWait;
import java.util.List;
import java.util.Random;

public class BDJAddressDetails extends BaseForm {
    private final Element addressDetailsDropdown = new Element(By.cssSelector("button.btn.collapsed[data-target='#collapseTwo']"));
    private final Element editButton = new Element(By.cssSelector("button#addressEditBtn"));
    private final Element insideButton = new Element(By.cssSelector("#radioPrsn1"));
    private final Element outsideButton = new Element(By.cssSelector("label.radio-inline > input.outside[name='presentLocation'][value='1']"));
    private final Element districtDropDown = new Element(By.cssSelector("#present_district"));
    private final Element thanaDropDown = new Element(By.cssSelector("#present_thana"));
    private final Element postOfficeDropDown = new Element(By.cssSelector("#present_p_office"));
    private final Element countryDropDown = new Element(By.cssSelector("#present_country_list"));
    private final Element houseTextField = new Element(By.cssSelector("#present_Village"));

    public BDJAddressDetails() {
        super(new Element(By.cssSelector("button.btn.collapsed[data-target='#collapseTwo']")));
    }

    public void presentAddress() {
        ExplicitWait.elementToBeVisible(addressDetailsDropdown.getLocator());

        // Click on the dropdown to open address section
        addressDetailsDropdown.click();
        editButton.click();

        // Test for inside Bangladesh
        insideButton.click();
        fillInsideBangladeshAddress();

        // Test for outside Bangladesh
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
