package forms;

import elements.Element;
import org.openqa.selenium.By;
import org.testng.Assert;
import waits.ExplicitWait;

public class BDJPersonalDetails extends BaseForm{
    private final Element firstName = new Element(By.cssSelector("#txtFirstName"));
    private final Element saveButton = new Element(By.cssSelector("body > div:nth-child(19) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(11) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > form:nth-child(3) > div:nth-child(2) > div:nth-child(1) > a:nth-child(1)"));
    private final Element emptyErrorMessage = new Element(By.cssSelector("#fnameErrorMsg"));


    private final String errorMessageText = "Error message is not displayed.";
    public BDJPersonalDetails(){
        super(new Element(By.cssSelector("button[aria-label='Click Personal section to add or edit your personal information in resume']")));
    }

    public void firstName(){
        ExplicitWait.elementToBeClickable(firstName.getLocator());

        //empty name
        firstName.getElement().clear();
        saveButton.getElement().click();
        ExplicitWait.elementToBeVisible(emptyErrorMessage.getLocator());
        Assert.assertTrue(emptyErrorMessage.isDisplayed(), errorMessageText);
    }

}
