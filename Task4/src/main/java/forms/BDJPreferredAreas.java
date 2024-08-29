package forms;

import elements.Element;
import org.openqa.selenium.By;

public class BDJPreferredAreas extends BaseForm{
    private final Element dropdownButton = new Element(By.cssSelector("button[class='btn']"));
    private final Element editButton = new Element(By.cssSelector("button[aria-label='Click on Edit to fill up preferred areas information']"));

    public BDJPreferredAreas() {
        super(new Element(By.cssSelector("label[aria-label='Preferred Job Categories']")));
    }


}
