package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import driver.Browser;

public abstract class BaseElement {
	private By locator;

	public BaseElement(By locator) {
		this.locator = locator;
	}

	public void click() {
		getElement().click();
	}

	public String getText() {
		return getElement().getText();
	}

	public WebElement getElement() {
		return Browser.getDriver().findElement(locator);
	}

	public By getLocator() {
		return locator;
	}

	public boolean isDisplayed() {
		return getElement().isDisplayed();
	}

	public void scrollUntilElementIsVisible() {
		new Actions(Browser.getDriver()).scrollToElement(getElement()).perform();
	}

	public void moveToElement() {
		WebElement hoverable = Browser.getDriver().findElement(locator);
		new Actions(Browser.getDriver())
				.moveToElement(hoverable)
				.perform();
	}

	public void sendKeysWithDelay(String keys) {
		for (char c : keys.toCharArray()) {
			this.getElement().sendKeys(Character.toString(c));
			try {
				Thread.sleep(50); // Adjust the delay as needed
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
