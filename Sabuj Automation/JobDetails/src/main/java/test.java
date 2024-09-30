import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;
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
            usernameField.sendKeys("bdjobst@gmail.com");

            WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-success.btn-signin")));
            nextButton.click();

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("TXTPASS")));
            passwordField.sendKeys("123456789");

            WebElement finalLoginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-success.btn-signin.btn-block")));
            finalLoginButton.click();

            WebElement keywordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtKeyword")));
            Thread.sleep(5000);
            keywordField.sendKeys("SQA");

            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-default[value='Search']")));
            searchButton.click();

            String mainWindowHandle = driver.getWindowHandle();
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));

            Set<String> allWindowHandles = driver.getWindowHandles();
            for (String handle : allWindowHandles) {
                if (!handle.equals(mainWindowHandle)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }

            // Click On Job Title
            WebElement jobTitleElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[aria-label='browse jobs section'] div:nth-child(3) div:nth-child(1) div:nth-child(1) div:nth-child(2) div:nth-child(1) div:nth-child(2) div:nth-child(1)")));
            jobTitleElement.click();

            wait.until(ExpectedConditions.numberOfWindowsToBe(3));
            allWindowHandles = driver.getWindowHandles();
            for (String handle : allWindowHandles) {
                if (!handle.equals(mainWindowHandle)) {
                    driver.switchTo().window(handle);
                }
            }
/*
            // Get BdJobs Pro
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".get_pro"))).click();
            Thread.sleep(2000);

            // Close the current tab
            driver.close();

*/

            // Click the Shortlist button
            WebElement shortlistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btnoutline")));
            shortlistButton.click();
            Thread.sleep(10000);

            //Click on remove button
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btnoutline.shorlisted"))).click();
            Thread.sleep(5000);

            //Click on Requirements button
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div:nth-child(45) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(2)"))).click();
            Thread.sleep(2000);

            //Click on Responsibilities button
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div:nth-child(45) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(3)"))).click();
            Thread.sleep(2000);

            //Click on Salary & Benefits button
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div:nth-child(45) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(4)"))).click();
            Thread.sleep(2000);

            //Click on Company Information button
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div:nth-child(45) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(5)"))).click();
            Thread.sleep(2000);

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div:nth-child(45) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(6)"))).click();
            Thread.sleep(2000);

            //Click On Follow Button
            wait.until(ExpectedConditions.elementToBeClickable(By.id("btnImg"))).click();
            Thread.sleep(2000);

            //Click On Follow Button
            wait.until(ExpectedConditions.elementToBeClickable(By.id("btnImg"))).click();
            Thread.sleep(3000);

            //Click on Report Button
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".icon-exclamation-triangle.rpticn"))).click();
            Thread.sleep(3000);

            //Click on Close Button
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cboxClose[tabindex='0']"))).click();
            Thread.sleep(3000);


            //Click on Apply Now Button
            WebElement applyNowButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.applynow.printPreviewHide[onclick='formSubmit()']")));
            applyNowButton.click();

            // Click On add more limit button
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.addmorelimit"))).click();

            // Click on Browser Back Button
            driver.navigate().back();
            driver.navigate().back();

            //Click on Apply Now Button
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.applynow.printPreviewHide[onclick='formSubmit()']"))).click();

            WebElement salaryField = wait.until(ExpectedConditions.elementToBeClickable(By.id("txtExpectedSalary")));
            // Wait for 1 second before sending keys
            Thread.sleep(1000);
            salaryField.sendKeys("@#$%^&*");
            WebElement appBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.app-btn[type='button']")));
            appBtn.click();

            salaryField.clear();
            salaryField.sendKeys("tgrig");
            Thread.sleep(5000);
            appBtn.click();

            salaryField.clear();
            salaryField.sendKeys("y010abckklllgljjggjjjlllyf");
            Thread.sleep(5000);
            appBtn.click();

            salaryField.clear();
            salaryField.sendKeys("15000");
            Thread.sleep(5000);
            appBtn.click();

            //Click On Undo Application
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".undo__btn"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='btn btn-default btn-danger-delete']"))).click();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
