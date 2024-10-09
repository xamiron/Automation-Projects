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

import static org.bouncycastle.asn1.crmf.SinglePubInfo.web;

public class pro {

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
            usernameField.sendKeys("avary)");

            WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-success.btn-signin")));
            nextButton.click();

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("TXTPASS")));
            passwordField.sendKeys("12345678");

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Sign in']"))).click();
            Thread.sleep(3000);

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
            ToDateField.sendKeys("09/01/2024");

            WebElement CompanyName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("compName")));
            CompanyName.sendKeys("Bdjobs");

            WebElement SearchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#search")));
            SearchButton.click();
            Thread.sleep(2000);


            FromDateField.clear();
            ToDateField.clear();
            CompanyName.clear();
            /// Invalid Date & Company Name
            FromDateField.sendKeys("2024");
            Thread.sleep(2000);
            ToDateField.sendKeys("05");
            Thread.sleep(2000);
            CompanyName.sendKeys("@&*%$");
            Thread.sleep(2000);
            SearchButton.click();

            FromDateField.clear();
            ToDateField.clear();
            CompanyName.clear();
            /// Invalid Date & Company Name
            FromDateField.sendKeys("greirtrkhj");
            Thread.sleep(2000);
            ToDateField.sendKeys("gbjtnjk");
            Thread.sleep(2000);
            CompanyName.sendKeys("WFR#$@~!798609");
            Thread.sleep(2000);
            SearchButton.click();

            FromDateField.clear();
            ToDateField.clear();
            CompanyName.clear();


            ////// Iterate through dropdown options
            WebElement selectElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtsSelect")));
            Select selectDropdown = new Select(selectElement);

            for (WebElement option : selectDropdown.getOptions()) {
                if (option.getAttribute("value").isEmpty()) {
                    continue;  // Skip empty options
                }

                selectDropdown.selectByVisibleText(option.getText());
                System.out.println("Selected option: " + option.getText());

                // Click on search button after each selection
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
            Thread.sleep(4000);

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



            try {
                // Interact with the SMS icon
                WebElement SmsIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[id='1'] span[class='icon-send-message isndmsg']")));
                SmsIcon.click();
                Thread.sleep(2000);

                // Try to interact with the SMS input field and proceed with sending a message
                WebElement TypeSms = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#msginput")));
                TypeSms.sendKeys("");  // Initial empty input


                WebElement SendSms = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='icon-send-email']")));
                SendSms.click();
                Thread.sleep(2000);


                WebElement OkBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='jconfirm-buttons'] button[type='button']")));
                OkBtn.click();


                // Send a test message if everything was successful so far
                TypeSms.sendKeys("Hello This is Test Message!");
                SendSms.click();

                //OkBtn.click();

            } catch (TimeoutException e) {
                // If any step in the try block fails, handle it by closing the chat
                System.out.println("Element not found or action failed, closing the chat.");

                // Click the close icon if the input field or other elements weren't found
                WebElement CrossIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cancel.chatclose.icon-times-o")));
                CrossIcon.click();
                Thread.sleep(2000);
            }

            driver.navigate().refresh();  // Refresh the original tab

            //click on Boost icon
            WebElement BoostIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[id='boostdiv3'] span[class='icon-boost']")));
            BoostIcon.click();
            Thread.sleep(2000);
            WebElement CloseButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".visitbdjp")));
            CloseButton.click();




           /*

            //Expected Salary Section
            try {
                WebElement Esalary = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='edit'] span[class='icon-edit icon']")));
                Esalary.click();
                Thread.sleep(2000);  // Adding a delay after the click action
            } catch (TimeoutException e) {
                System.out.println("Expected Salary field not found.");
            }

            // Clear Expected Salary
            WebElement EsalaryClear = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#expSalary0")));
            EsalaryClear.clear();
            Thread.sleep(2000);
            WebElement Canacle = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='write-amo-wrap salary-edit'] a[class='btn cancel']")));
            Canacle.click();
            Thread.sleep(2000);

            //Salary Section Empty
            WebElement Esalary1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='edit'] span[class='icon-edit icon']")));
            Esalary1.click();
            Thread.sleep(2000);
            EsalaryClear.clear();
            Thread.sleep(2000);
            EsalaryClear.sendKeys("");
            Thread.sleep(2000);
            WebElement ESave = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='write-amo-wrap salary-edit'] button[type='submit']")));
            ESave.click();
            Thread.sleep(4000);

            // Switch to the alert
            Alert alert = driver.switchTo().alert();
            // Click the OK button
            alert.accept();
            driver.navigate().refresh();
            Thread.sleep(4000);


            // Enter Valid Salary
            WebElement Esalary2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='edit'] span[class='icon-edit icon']")));
            Esalary2.click();
            Thread.sleep(2000);
            WebElement EsalaryClear2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#expSalary0")));
            EsalaryClear2.clear();
            Thread.sleep(2000);
            WebElement EsalaryEnter = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#expSalary0")));
            EsalaryEnter.sendKeys("29000");
            Thread.sleep(2000);
            WebElement ESave2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='write-amo-wrap salary-edit'] button[type='submit']")));
            ESave2.click();
            Thread.sleep(4000);

     try {
                WebElement nyetButton = driver.findElement(By.id("nyet-btn2"));
                nyetButton.click();
            } catch (NoSuchElementException e) {
                System.out.println("button not found.");
            }


*/




        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
