package forms;

import elements.Element;
import org.openqa.selenium.By;
import waits.ExplicitWait;

public class BDJHomePage extends BaseForm {
    private final Element searchTextField = new Element(By.xpath("//div[@class='inner-addon keyword-search']"));
    private final Element organizationType = new Element(By.xpath("//div[@class='inner-addon categoryCombo hidden-sm hidden-xs']"));
    private final Element searchButton = new Element(By.xpath("//input[@class='btn btn-default']"));
    private final Element profileIcon = new Element(By.xpath("//li[@class='dropdown user-details']"));
    private final Element logOutButton = new Element(By.xpath("//a[@class='btn-signout' and contains(@onclick, 'signOut')]"));

    public BDJHomePage() {
        super(new Element(By.xpath("//h2[@role='heading']")));
    }

    public void moveCursorToProfileIcon() {
        ExplicitWait.elementToBeClickable(profileIcon.getLocator());
        profileIcon.moveToElement();
    }

    public void clickOnProfileIcon() {
        ExplicitWait.elementToBeClickable(profileIcon.getLocator());
        profileIcon.click();
    }

    public void clickOnSignOutButton() {
        ExplicitWait.elementToBeClickable(logOutButton.getLocator());
        logOutButton.click();
    }
}
