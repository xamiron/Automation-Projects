package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

import static org.bouncycastle.asn1.crmf.SinglePubInfo.web;

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
            usernameField.sendKeys("avary");

            WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-success.btn-signin")));
            nextButton.click();

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("TXTPASS")));
            passwordField.sendKeys("12345678");

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Sign in']"))).click();
            Thread.sleep(3000);

            ///Wait for and close the pop-up if it appears
            try {
                WebElement popUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='modal-content vinstruction'] button[type='button']")));
                if (popUpButton.isDisplayed()) {
                    popUpButton.click();  // Close the pop-up
                }
            } catch (TimeoutException ignored) {
                System.out.println("No pop-up appeared.");
            }

            // Navigate to Shortlisted Jobs  section
            WebElement ActivityMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[id='myActivitiesMenu'] i[class='icon-angle-down']")));
            ActivityMenu.click();
            Thread.sleep(2000);

            WebElement TOverview = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".icon-star")));
            TOverview .click();
            Thread.sleep(2000);

            // Filtering Shortlisted Jobs based on dates
            WebElement FromDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fromDate")));
            FromDateField.sendKeys("05/01/2024");
            // Filtering Transaction based on dates
            WebElement ToDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toDate")));
            ToDateField.sendKeys("09/01/2024");
            WebElement SearchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#search")));
            SearchButton.click();
            Thread.sleep(2000);

            FromDateField.clear();
            ToDateField.clear();

            // Invalid Date
            FromDateField.sendKeys("2024");
            Thread.sleep(2000);
            ToDateField.sendKeys("05");
            Thread.sleep(2000);
            SearchButton.click();

            FromDateField.clear();
            Thread.sleep(2000);
            ToDateField.clear();

            /// Invalid Date
            FromDateField.sendKeys("greirtrkhj");
            Thread.sleep(2000);
            ToDateField.sendKeys("gbjtnjk");
            Thread.sleep(2000);
            SearchButton.click();

            FromDateField.clear();
            ToDateField.clear();

            // Search by valid date
            FromDateField.sendKeys("05/01/2023");
            ToDateField.sendKeys("10/22/2024");
            SearchButton.click();
            //Search By Company Name
            WebElement CompanyName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("compName")));
            CompanyName.sendKeys("Bdjobs");
            SearchButton.click();
            Thread.sleep(2000);
            CompanyName.clear();
            CompanyName.sendKeys("@&*%$");
            Thread.sleep(2000);
            SearchButton.click();











        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
