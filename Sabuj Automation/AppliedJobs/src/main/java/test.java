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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));  // Increased timeout

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

            // Wait for the pop-up close button to appear
            WebElement popUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='modal-content vinstruction'] button[type='button']")));

            // Ensure that the element is visible and enabled before clicking
            if (popUpButton.isDisplayed() && popUpButton.isEnabled()) {
                popUpButton.click(); // Native Selenium click
            } else {
                System.out.println("Pop-up close button is not clickable!");
            }

            WebElement ActivityMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[id='myActivitiesMenu'] i[class='icon-angle-down']")));
            ActivityMenu.click();
            Thread.sleep(2000);
            WebElement Appliedjobs = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".icon-applied")));
            Appliedjobs.click();
            Thread.sleep(2000);

            WebElement FromDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fromDate")));
            FromDateField.sendKeys("05/01/2024");

            WebElement ToDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toDate")));
            ToDateField.sendKeys("05/01/2024");
            Thread.sleep(1000);

            WebElement CompanyName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("compName")));
            CompanyName.sendKeys("Bdjobs");
            Thread.sleep(2000);

            WebElement SearchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#search")));
            SearchButton.click();
            Thread.sleep(2000);

            // Handle the select dropdown and iterate over each option
            WebElement selectElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtsSelect")));
            Select selectDropdown = new Select(selectElement);

            // Loop through all options in the select dropdown
            for (WebElement option : selectDropdown.getOptions()) {
                String optionText = option.getText();

                // Skip empty options or group labels (optgroup)
                if (option.getAttribute("value").isEmpty()) {
                    continue;
                }

                // Select the option
                selectDropdown.selectByVisibleText(optionText);
                System.out.println("Selected option: " + optionText);

                // Click the search button after selecting each option
                WebElement SearchButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#search")));
                SearchButton1.click();

                // Add a delay for better observation of actions
                Thread.sleep(2000);

                // Clear the previous selection
                selectDropdown.selectByIndex(0);  // Clear selection by selecting the first (empty) option
            }

            //Clear all previous search

            WebElement FromDateField1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fromDate")));
            FromDateField1.clear();
            Thread.sleep(2000);

            WebElement ToDateField2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toDate")));
            ToDateField2.clear();
            Thread.sleep(1000);

            WebElement CompanyName2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("compName")));
            CompanyName2.clear();
            Thread.sleep(2000);

            WebElement SearchButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#search")));
            SearchButton2.clear();
            Thread.sleep(2000);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
