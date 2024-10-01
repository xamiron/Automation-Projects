import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class test {

    public static void main(String[] arg) {
        // Set up ChromeOptions to include the ad blocker extension
        ChromeOptions options = new ChromeOptions();
        String adblockerPath = "src/main/resources/uBlock-Origin-Chrome-Web-Store.crx";

        // Validate if the extension file exists before adding it to ChromeOptions
        File extensionFile = new File(adblockerPath);

        if (extensionFile.exists() && extensionFile.isFile()) {
            options.addExtensions(extensionFile);
        }

        // Initialize WebDriver with ChromeOptions
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.manage().window().maximize();

            // Navigate to the SignIn page
            driver.get("https://mybdjobs.bdjobs.com/mybdjobs/signin.asp");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

            // Enter username
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='TXTUSERNAME']")));
            usernameField.sendKeys("renmondal");

            // Click Continue button
            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Continue']")));
            continueButton.click();

            // Enter password
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='TXTPASS']")));
            passwordField.sendKeys("12345678");

            // Click Sign in button
            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Sign in']")));
            signInButton.click();

            // Wait for the Manage Profile dropdown to be clickable and click it
            WebElement manageProfileDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='manageResumeMenu']")));
            manageProfileDropdown.click();

            // Wait for the Dashboard link to be visible and clickable
            WebElement dashboardLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Dashboard']")));
            dashboardLink.click();



            //will click on personalized cv
            WebElement customizedcv = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#tab-personaliz")));
            customizedcv.click();
            Thread.sleep(2000);

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bactbtn"))).click();//view button click
            Thread.sleep(2000);

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='icon-video-help-o']"))).click(); //video icon click
            Thread.sleep(400);

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Close']"))).click(); //cross icon click
            Thread.sleep(200);





        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // Close the browser after execution
            if (driver != null) {
                //driver.quit();
            }
        }
    }
}
