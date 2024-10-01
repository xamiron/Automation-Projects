import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
/*
            // Wait for the pop-up close button to appear
            WebElement popUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='modal-content vinstruction'] button[type='button']")));

            // Ensure that the element is visible and enabled before clicking
            if (popUpButton.isDisplayed() && popUpButton.isEnabled()) {
                popUpButton.click(); // Native Selenium click
            } else {
                System.out.println("Pop-up close button is not clickable!");
            }

 */
            // Wait and click the EmailCv icon
            WebElement EmailCv = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i[class='icon-send-email']")));
            Thread.sleep(3000);
            EmailCv.click();

            //Clear Previous Test
            WebElement MyEmail = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#txtUserEmail")));
            Thread.sleep(3000);
            MyEmail.clear();

            //Click on Send Cv Button
            WebElement SendCv = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
            SendCv.click();
            Thread.sleep(2000);

            //Click on Pop-Up Ok button
            WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='jconfirm-buttons'] button[type='button']")));
            okButton.click();
            Thread.sleep(2000);

///Test Case
            MyEmail.sendKeys("ahf@hkg");
            SendCv.click();
            //SendCv.sendKeys("bdj@gmail");
            //okButton.click();
            okButton.click();

          /*


            // Write your Email
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#txtUserEmail"))).sendKeys("bdjobs.qa@gmail.com");
            Thread.sleep(2000);



            //Write Company Email
           WebElement CpMail= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#txtCompanyEmail")));
           CpMail.sendKeys("bdjobs.qa@gmail.com");
           Thread.sleep(2000);

            //Write Email Subject
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#txtMailSubject"))).sendKeys("Demo Test Account");

            //Type Message
           wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#txtApplication"))).sendKeys("Hello This is Test SMS");

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))).click();
            driver.navigate().back();
            Thread.sleep(1000);

            // Click on Radio button2
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#icon1"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))).click();
            driver.navigate().back();
            Thread.sleep(1000);

            // Click on Radio button3
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#icon2"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))).click();
            Thread.sleep(1000);
            driver.navigate().back();

      

*/


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
