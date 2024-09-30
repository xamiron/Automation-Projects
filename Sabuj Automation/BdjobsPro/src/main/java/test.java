import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class test {
    public static void main(String[] args) {
        String adblockerPath = "src/main/resources/uBlock-Origin-Chrome-Web-Store.crx";
        WebDriverManager.chromedriver().setup();
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(adblockerPath));
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            driver.get("https://bdjobs.com");

            WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.hidden-xs.soca>a")));
            loginLink.click();

            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cart-mbdj-r>.btn-wraper>.btn.slu-btn")));
            loginButton.click();

            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("TXTUSERNAME")));
            usernameField.sendKeys("avary");

            WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-success.btn-signin")));
            nextButton.click();

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("TXTPASS")));
            passwordField.sendKeys("12345678");

            WebElement finalLoginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-success.btn-signin.btn-block")));
            finalLoginButton.click();
            Thread.sleep(2000);

            //Click on MyBdjobs
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".mybdjobs[rel='noopener']"))).click();
            Thread.sleep(2000);

            String mainWindowHandle = driver.getWindowHandle();
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));

            Set<String> allWindowHandles = driver.getWindowHandles();
            for (String handle : allWindowHandles) {
                if (!handle.equals(mainWindowHandle)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }
            // Click on BdJobs Pro
            try {
                // Try clicking the first element
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-primary.upb[href='https://mybdjobs.bdjobs.com/mybdjobs/package-info_fhm.asp']"))).click();
                Thread.sleep(2000);
            } catch (TimeoutException e) {
                // If the first element is not found or clickable, go to the else block
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-target='#renewModal']"))).click();
                Thread.sleep(2000);
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#repurchasepmt"))).click();
                Thread.sleep(2000);
            }

            //Click on collapse indicator One
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='pro-img'] h3"))).click();
            Thread.sleep(2000);
            //Click on collapse indicator off
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='pro-img'] h3"))).click();
            Thread.sleep(2000);

            //Click on Quarterly Button
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div:nth-child(12) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > section:nth-child(2) > div:nth-child(1) > div:nth-child(1) > button:nth-child(2)"))).click();
            Thread.sleep(2000);
            //Click on Yearly  Button
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div:nth-child(12) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > section:nth-child(2) > div:nth-child(1) > div:nth-child(1) > button:nth-child(3)"))).click();
            Thread.sleep(2000);
            //Click on Monthly  Button
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div:nth-child(12) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > section:nth-child(2) > div:nth-child(1) > div:nth-child(1) > button:nth-child(1)"))).click();
            Thread.sleep(1000);

            // Check Monthly Package Details
            wait.until(ExpectedConditions.elementToBeClickable(By.id("package1"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("package2"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("package3"))).click();

            //Click on Quarterly Button
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div:nth-child(12) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > section:nth-child(2) > div:nth-child(1) > div:nth-child(1) > button:nth-child(2)"))).click();
            Thread.sleep(1000);
            // Check Quarterly Package Details
            wait.until(ExpectedConditions.elementToBeClickable(By.id("package1"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("package2"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("package3"))).click();

            //Click on Yearly  Button
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div:nth-child(12) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > section:nth-child(2) > div:nth-child(1) > div:nth-child(1) > button:nth-child(3)"))).click();
            Thread.sleep(2000);

            // Check Yearly Package Details
            wait.until(ExpectedConditions.elementToBeClickable(By.id("package1"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("package2"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("package3"))).click();
            Thread.sleep(1000);

            // Handle following limits are on a per-month basis clicks
            for (int i = 3; i <= 21; i += 2) {
                String cssSelector = String.format("section[class='package-price'] div:nth-child(%d) a:nth-child(1)", i);
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                Thread.sleep(1000);
            }


            // Click on the Monthly  button after handling all links panels
            WebElement MonthlyButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div:nth-child(12) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > section:nth-child(2) > div:nth-child(1) > div:nth-child(1) > button:nth-child(1)")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MonthlyButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", MonthlyButton);
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("package1"))).click();
            Thread.sleep(1000);

            // Click on Proceed To Payment Button
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))).click();
/*
            // Click on radio yes/ no button
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for='radio-two']"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for='radio-one']"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for='radio-two']"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#btnPayOnline"))).click();
            Thread.sleep(1000);
*/

            // Check all payment method Bkash, Card & others  button clickable or not
            WebElement card =  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='cardssec'] div[class='crdstitle']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  card);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", card);
            Thread.sleep(2000);

            WebElement Other =  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='otherssec'] div[class='crdstitle']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  Other);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Other);
            Thread.sleep(2000);

            // Pro buy-point  proceed with Bkash option
            WebElement Bkash = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='bkashsec'] div[class='crdstitle']")));
            // Scroll Bkash option into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Bkash);
            // Click Bkash option using JavaScript
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Bkash);
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#btnPayOnline"))).click();
            Thread.sleep(1000);

            // Click on Browser Back Button
            driver.navigate().back();
            // Click on Browser Back Button
            driver.navigate().back();

            driver.get(driver.getCurrentUrl());

            // Loop through and click each FAQ panel to open and close
            List<WebElement> faqPanels = driver.findElements(By.cssSelector(".panel-group .panel-heading.faq_title"));
            for (WebElement panel : faqPanels) {
                // Scroll the element into view
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", panel);
                Thread.sleep(1000); // Adjust the sleep duration as needed

                // Click the element using JavaScript
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", panel);
                Thread.sleep(1000); // Adjust the sleep duration as needed

                // Close the panel (click again)
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", panel);
                Thread.sleep(1000); // Adjust the sleep duration as needed
            }
            // Refresh the url
            driver.get(driver.getCurrentUrl());



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
