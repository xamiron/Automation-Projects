package forms;

import elements.Element;
import org.openqa.selenium.By;

public class BDJOtherRelevantInformation extends BaseForm{
    private final Element careerSummary = new Element(By.cssSelector("#txtCareerSummary"));
    private final Element specialQualification = new Element(By.cssSelector("#txtSpecialQualification"));
    private final Element keyWord = new Element(By.cssSelector("#txtKeyword"));
    private final Element saveButton = new Element(By.cssSelector("a[aria-label='Save changes for Other Relevant Information ']"));

    public BDJOtherRelevantInformation() {
        super(new Element(By.cssSelector("label[for='txtCareerSummary']")));
    }

}
