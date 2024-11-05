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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

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
            Thread.sleep(2000);

            try {
                WebElement popUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='modal-content vinstruction'] button[type='button']")));
                if (popUpButton.isDisplayed()) {
                    popUpButton.click();  // Close the pop-up
                }
            } catch (TimeoutException e) {
                // Pop-up is not visible, so we can skip it and proceed
            }
            driver.navigate().refresh();

            // Navigate to EActivityMenu
            WebElement EActivityMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#employeerActivitiesMenu")));
            EActivityMenu.click();
            Thread.sleep(2000);
            WebElement TOverview = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Employer Viewed CV']")));
            TOverview .click();
            Thread.sleep(2000);


            //Search By Invalid From Date
            WebElement FromDateField1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fromDate")));
            FromDateField1.sendKeys("2024");
            WebElement SearchButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#search")));
            SearchButton1.click();
            Thread.sleep(2000);
            WebElement popok1 = wait .until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='jconfirm-buttons'] button[type='button']")));
            Thread.sleep(2000);
            popok1.click();
            Thread.sleep(2000);
            FromDateField1.clear();
            Thread.sleep(2000);

            FromDateField1.sendKeys("Adigkkjhgjhghjghjgjhgjhgjjhj");
            SearchButton1.click();
            Thread.sleep(2000);
            WebElement popok11 = wait .until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='jconfirm-buttons'] button[type='button']")));
            Thread.sleep(2000);
            popok11.click();
            FromDateField1.clear();
            Thread.sleep(2000);

            FromDateField1.sendKeys("20.20.2050");
            SearchButton1.click();
            Thread.sleep(2000);
            popok11.click();
            Thread.sleep(2000);
            FromDateField1.clear();
            Thread.sleep(2000);

            //Search By Invalid To Date

            WebElement ToDateField1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toDate")));
            ToDateField1.sendKeys("2024");
            SearchButton1.click();
            Thread.sleep(2000);
            popok1.click();
            Thread.sleep(2000);
            ToDateField1.clear();

            ToDateField1.sendKeys("gtrhtjhyjyjhyj");
            SearchButton1.click();
            Thread.sleep(2000);
            popok1.click();
            Thread.sleep(2000);
            ToDateField1.clear();

            ToDateField1.sendKeys("htjsa245.5.35");
            SearchButton1.click();
            Thread.sleep(2000);
            popok1.click();
            Thread.sleep(2000);
            ToDateField1.clear();



            // Filtering EViewedCv based on dates
            WebElement FromDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fromDate")));
            FromDateField.sendKeys("05/01/2024");
            // Filtering EViewedCv based on dates
            WebElement ToDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toDate")));
            ToDateField.sendKeys("09/01/2024");
            WebElement SearchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#search")));
            SearchButton.click();
            Thread.sleep(2000);

            FromDateField.clear();
            ToDateField.clear();

            // Invalid Date Search
            FromDateField.sendKeys("2024");
            Thread.sleep(2000);
            ToDateField.sendKeys("05");
            Thread.sleep(2000);
            SearchButton.click();
            WebElement popok = wait .until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='jconfirm-buttons'] button[type='button']")));
            Thread.sleep(2000);
            popok.click();
            Thread.sleep(2000);

            FromDateField.clear();
            Thread.sleep(2000);
            ToDateField.clear();

            /// Invalid Date
            FromDateField.sendKeys("greirtrkhj");
            Thread.sleep(2000);
            ToDateField.sendKeys("gbjtnjk");
            Thread.sleep(2000);
            SearchButton.click();
            WebElement popupok = wait .until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='jconfirm-buttons'] button[type='button']")));
            Thread.sleep(2000);
            popupok.click();

            FromDateField.clear();
            ToDateField.clear();

            // Search by valid date
            FromDateField.sendKeys("05/01/2023");
            ToDateField.sendKeys("10/22/2024");
            SearchButton.click();

            FromDateField.clear();
            ToDateField.clear();

            //Search By Company Name
            WebElement CompanyName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("compName")));
            CompanyName.sendKeys("12345678954555");
            SearchButton.click();
            Thread.sleep(2000);
            CompanyName.clear();
            CompanyName.sendKeys("@&*%$");
            Thread.sleep(2000);
            SearchButton.click();

            CompanyName.clear();
            CompanyName.sendKeys("grhgdiaaaaaaaaaaaieutwi");
            Thread.sleep(2000);
            SearchButton.click();
            CompanyName.clear();

            CompanyName.sendKeys("Hossain Group of Industriess");
            Thread.sleep(2000);
            SearchButton.click();
            driver.navigate().refresh();






        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
