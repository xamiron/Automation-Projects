package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Element extends BaseElement {

	public Element(By locator) {
		super(locator);
	}
	public boolean isEnabled() {
		WebElement element = getElement();  // Assuming getElement() retrieves the underlying WebElement
		return element.isEnabled();
	}
	public List<WebElement> findElements(By by) {
		WebElement element = getElement();  // Retrieve the underlying WebElement
		return element.findElements(by);    // Use the WebElement's findElements method
	}

	// Add the sendKeys method to expose WebElement's sendKeys
	public void sendKeys(CharSequence... keysToSend) {
		WebElement element = getElement();
		element.sendKeys(keysToSend);  // Delegate to WebElement's sendKeys method
	}

	public boolean isEmpty() {
		WebElement element = getElement();
		// Check if the element has no text and no child elements
		return element.getText().trim().isEmpty() && element.findElements(By.xpath("./*")).isEmpty();
	}
}
