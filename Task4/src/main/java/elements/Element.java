package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Element extends BaseElement {

	public Element(By locator) {
		super(locator);
	}
	public boolean isEnabled() {
		WebElement element = getElement();  // Assuming getElement() retrieves the underlying WebElement
		return element.isEnabled();
	}
}
