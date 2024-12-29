package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class demo {

    public static void main(String[] args) {
        // Path to the adblocker extension
        String adblockerPath = "src/main/resources/uBlock-Origin-Chrome-Web-Store.crx";

        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(adblockerPath));
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        /// Maximize the window
        driver.manage().window().maximize();

        try {
            // Navigate to bdjobs.com
            driver.get("https://mybdjobs.bdjobs.com/mybdjobs/signin.asp?q=cab");

            // Login process
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("TXTUSERNAME")));
            usernameField.sendKeys("avary");
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-success.btn-signin"))).click();

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("TXTPASS")));
            passwordField.sendKeys("12345678");
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Sign in']"))).click();

            closePopupIfVisible(driver, wait);
            driver.navigate().refresh();

            // Invalid date searches
            invalidDateSearch(driver, wait, "2024", "");
            invalidDateSearch(driver, wait, "Adigkkjhgjhghjghjgjhgjhgjjhj", "");
            invalidDateSearch(driver, wait, "20.20.2050", "");

            // Invalid "To Date" searches
            invalidDateSearch(driver, wait, "", "2024");
            invalidDateSearch(driver, wait, "", "gtrhtjhyjyjhyj");
            invalidDateSearch(driver, wait, "", "htjsa245.5.35");

            // Search by invalid and valid dates
            dateSearch(driver, wait, "05/01/2024", "09/01/2024");
            invalidDateSearch(driver, wait, "2024", "05");
            invalidDateSearch(driver, wait, "greirtrkhj", "gbjtnjk");

            // Search by company name
            companyNameSearch(driver, wait, "12345678954555");
            companyNameSearch(driver, wait, "@&*%$");
            companyNameSearch(driver, wait, "grhgdiaaaaaaaaaaaieutwi");
            companyNameSearch(driver, wait, "Hossain Group of Industriess");

            // Apply select filter
            applySelectFilter(driver, wait);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the driver
            driver.quit();
        }
    }

    // Method to close pop-up if visible
    private static void closePopupIfVisible(WebDriver driver, WebDriverWait wait) {
        try {
            WebElement popUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='jconfirm-buttons'] button[type='button']")));
            popUpButton.click();
        } catch (TimeoutException ignored) {
            // Pop-up did not appear, ignore
        }
    }

    // Method to perform an invalid date search
    private static void invalidDateSearch(WebDriver driver, WebDriverWait wait, String fromDate, String toDate) {
        WebElement fromDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fromDate")));
        WebElement toDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toDate")));
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#search")));

        fromDateField.clear();
        fromDateField.sendKeys(fromDate);
        toDateField.clear();
        toDateField.sendKeys(toDate);
        searchButton.click();
        closePopupIfVisible(driver, wait);
    }

    // Method to perform a valid date search
    private static void dateSearch(WebDriver driver, WebDriverWait wait, String fromDate, String toDate) {
        WebElement fromDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fromDate")));
        WebElement toDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toDate")));
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#search")));

        fromDateField.clear();
        fromDateField.sendKeys(fromDate);
        toDateField.clear();
        toDateField.sendKeys(toDate);
        searchButton.click();
    }

    // Method to perform a company name search
    private static void companyNameSearch(WebDriver driver, WebDriverWait wait, String companyName) {
        WebElement companyNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("compName")));
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#search")));

        companyNameField.clear();
        companyNameField.sendKeys(companyName);
        searchButton.click();
        closePopupIfVisible(driver, wait);
    }

    // Method to apply a filter in the select dropdown
    private static void applySelectFilter(WebDriver driver, WebDriverWait wait) {
        Select select = new Select(driver.findElement(By.id("txtStatus")));
        for (WebElement option : select.getOptions()) {
            select.selectByVisibleText(option.getText());
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#search"))).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-spinner"))); // Wait for loading
        }
    }
}
