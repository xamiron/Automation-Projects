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

//	public void sendKeysWithDelay(String keys) {
//		for (char c : keys.toCharArray()) {
//			this.getElement().sendKeys(Character.toString(c));
//			try {
//				Thread.sleep(1000); // Adjust the delay as needed
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}

	public void sendKeysWithDelay(CharSequence... keysToSend) {
		WebElement element = getElement();
		element.sendKeys(keysToSend);

		// Wait for 3 seconds after sending the keys
		try {
			Thread.sleep(3000);  // 3000 milliseconds = 3 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
