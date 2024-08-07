package forms;

import driver.Browser;
import elements.Element;
import org.openqa.selenium.By;
import waits.ExplicitWait;

import java.util.logging.Logger;

public class BDJHomePage extends BaseForm {
//    private final Element searchTextField = new Element(By.xpath("//div[@class='inner-addon keyword-search']"));
//    private final Element organizationType = new Element(By.xpath("//div[@class='inner-addon categoryCombo hidden-sm hidden-xs']"));
//    private final Element searchButton = new Element(By.xpath("//input[@class='btn btn-default']"));
//    private final Element profileIcon = new Element(By.xpath("//li[@class='dropdown user-details']"));
//    private final Element logOutButton = new Element(By.xpath("//a[@class='btn-signout' and contains(@onclick, 'signOut')]"));
    private final Element searchTextField = new Element(By.cssSelector("div.inner-addon.keyword-search"));
    private final Element organizationType = new Element(By.cssSelector("div.inner-addon.categoryCombo.hidden-sm.hidden-xs"));
    private final Element searchButton = new Element(By.cssSelector("input.btn.btn-default"));
    private final Element profileIcon = new Element(By.cssSelector("li.dropdown.user-details"));
    private final Element logOutButton = new Element(By.cssSelector("a.btn-signout[onclick*='signOut']"));


    private static final Logger logger = Logger.getLogger(BDJHomePage.class.getName());

    public BDJHomePage() {
        super(new Element(By.xpath("//h2[@role='heading']")));
    }

    public void moveCursorToProfileIcon(){
        ExplicitWait.elementToBeClickable(profileIcon.getLocator());
        profileIcon.moveToElement();
        logger.info("Cursor moved to Profile Icon");
    }

    public void clickOnProfileIcon(){
        ExplicitWait.elementToBeClickable(profileIcon.getLocator());
        profileIcon.click();
        logger.info("Profile icon is clicked");
    }

    public void clickOnSignOutButton(){
        ExplicitWait.elementToBeClickable(logOutButton.getLocator());
        logOutButton.click();
        logger.info("Sign Out button is clicked");
    }
}
