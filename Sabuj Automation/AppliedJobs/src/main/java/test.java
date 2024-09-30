import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class test {

    public static void main(String[] args) {
        // Path to the adblocker extension
        String adblockerPath = "src/main/resources/uBlock-Origin-Chrome-Web-Store.crx";

        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(adblockerPath));
        WebDriver driver = new ChromeDriver(options);

        // Maximize the window and set up WebDriverWait
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        try {
            // Navigate to bdjobs.com
            driver.get("https://mybdjobs.bdjobs.com/mybdjobs/signin.asp?q=cab");

            // Login process
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("TXTUSERNAME")));
            usernameField.sendKeys("vb9@gmil.vom");

            WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-success.btn-signin")));
            nextButton.click();

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("TXTPASS")));
            passwordField.sendKeys("12345678");

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Sign in']"))).click();
            Thread.sleep(2000);

            // Wait for and close the pop-up if it appears
            try {
                WebElement popUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='modal-content vinstruction'] button[type='button']")));
                if (popUpButton.isDisplayed()) {
                    popUpButton.click();  // Close the pop-up
                }
            } catch (TimeoutException ignored) {
                System.out.println("No pop-up appeared.");
            }

            // Navigate to Applied Jobs section
            WebElement ActivityMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[id='myActivitiesMenu'] i[class='icon-angle-down']")));
            ActivityMenu.click();
            Thread.sleep(2000);

            WebElement Appliedjobs = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".icon-applied")));
            Appliedjobs.click();
            Thread.sleep(2000);

            // Filtering jobs based on dates and company name
            WebElement FromDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fromDate")));
            FromDateField.sendKeys("05/01/2024");

            WebElement ToDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toDate")));
            ToDateField.sendKeys("30/09/2024");

            WebElement CompanyName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("compName")));
            CompanyName.sendKeys("Bdjobs");

            WebElement SearchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#search")));
            SearchButton.click();

            // Iterate through dropdown options
            WebElement selectElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtsSelect")));
            Select selectDropdown = new Select(selectElement);

            for (WebElement option : selectDropdown.getOptions()) {
                if (option.getAttribute("value").isEmpty()) {
                    continue;  // Skip empty options
                }

                selectDropdown.selectByVisibleText(option.getText());
                System.out.println("Selected option: " + option.getText());

                // Click search after each selection
                WebElement SearchButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#search")));
                SearchButton1.click();

                Thread.sleep(2000);  // Delay for observation
                selectDropdown.selectByIndex(0);  // Clear selection by selecting the first (empty) option
            }

            // Clear the search fields and refresh the page
            FromDateField.clear();
            ToDateField.clear();
            CompanyName.clear();
            driver.navigate().refresh();

            // Click on the job title link after refreshing
            WebElement JobTitle = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[id='1'] a[class='ajtlnk']")));
            JobTitle.click();
            Thread.sleep(2000);

            // Switch to the newly opened tab and close it
            String originalWindow = driver.getWindowHandle();
            for (String windowHandle : driver.getWindowHandles()) {
                if (!originalWindow.equals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

            driver.close();  // Close the newly opened tab
            driver.switchTo().window(originalWindow);  // Switch back to the original tab

            driver.navigate().refresh();  // Refresh the original tab

            // Interact with the SMS icon
            WebElement SmsIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[id='1'] span[class='icon-send-message isndmsg']")));
            SmsIcon.click();
            Thread.sleep(2000);

            // Close the SMS modal
            WebElement CloseIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cancel.chatclose.icon-times-o")));
            CloseIcon.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
