import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;  // Missing import added here

public class Dashboard {

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

            // Wait for the Change button and click it
            WebElement changeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Change']")));
            changeButton.click();

            // Navigate back after interaction
            driver.navigate().back();
            Thread.sleep(2000);
            WebElement bdjobsCvcount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='pcv-legend']//span[contains(text(),'3')]")));
            bdjobsCvcount.click();
            driver.navigate().back();

            WebElement bdjobsCv = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='tab-bdjresume']")));
            bdjobsCv.click();

            Thread.sleep(2000);
            WebElement viewbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://mybdjobs.bdjobs.com/mybdjobs/masterview.asp'][normalize-space()='View']")));
            viewbutton.click();
            Thread.sleep(5000);

            driver.navigate().back();
            Thread.sleep(2000);

            WebElement editbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bdjreswrap']//a[@class='veactbtned'][normalize-space()='Edit']")));
            editbutton.click();
            Thread.sleep(2000);
            driver.navigate().back();

            WebElement personaldetails = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Personal Details']")));
            personaldetails.click();
            Thread.sleep(2000);
            driver.navigate().back();

            WebElement professionalqualification = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Professional Qualification']")));
            professionalqualification.click();
            Thread.sleep(2000);
            driver.navigate().back();

            WebElement academicqualification = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Academic Qualification']")));
            academicqualification.click();
            Thread.sleep(2000);
            driver.navigate().back();

            WebElement Experience = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Academic Qualification']")));
            Experience.click();
            Thread.sleep(2000);
            driver.navigate().back();

            WebElement experience = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Experience']")));
            experience.click();
            Thread.sleep(2000);
            driver.navigate().back();


            WebElement reference = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Reference']")));
            reference.click();
            Thread.sleep(2000);
            driver.navigate().back();

            WebElement training = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Training']")));
            training.click();
            Thread.sleep(2000);
            driver.navigate().back();

            WebElement specialization = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Specialization']")));
            specialization.click();
            Thread.sleep(2000);
            driver.navigate().back();

            WebElement photograph = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Photograph']")));
            photograph.click();
            Thread.sleep(2000);
            driver.navigate().back();

            WebElement videoCV = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='tab-vdeoresume']")));
            videoCV.click();

            try {
                WebElement videopopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='videoTutorialCloseBtn']//span[@aria-hidden='true'][normalize-space()='×']")));
                videopopup.click();
                System.out.println("Video popup closed successfully.");
            } catch (Exception  e) {
                System.out.println("The video popup was not found within the timeout period.");
            }


            Thread.sleep(2000);

            //will click 3rd question
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Your long term career objective. Where you want to')]"))).click();
            driver.navigate().back();
            Thread.sleep(2000);

            //will click 2nd question
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Talk about your experience (if any), your skills a')]"))).click();
            driver.navigate().back();

            //will click 1st question
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Introduce yourself, including your education.']"))).click();
            driver.navigate().back();
            Thread.sleep(2000);

            // Navigate to Personalized CV section
            WebElement personalizedcv = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='tab-personaliz']")));
            personalizedcv.click();
            Thread.sleep(2000);

            // Check if "View" button is present in Personalized CV section
            List<WebElement> viewButtonList = driver.findElements(By.xpath("//a[@class='bactbtn']"));
            if (viewButtonList.size() > 0) {
                // If the "View" button is present, continue with the rest of the code
                WebElement viewButton = viewButtonList.get(0);
                viewButton.click(); // Click "View" button
                Thread.sleep(2000);

                // Click the video icon
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='icon-video-help-o']"))).click();
                Thread.sleep(400);

                // Close the video popup
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Close']"))).click();
                Thread.sleep(200);

                // Click Download button
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Download']"))).click();
                Thread.sleep(2000);

                // Click Delete button and confirm deletion
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Delete']"))).click();
                Thread.sleep(2000);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Yes, delete']"))).click();
                Thread.sleep(2000);

                driver.navigate().back();
            } else {
                System.out.println("View button not found in the personalized CV section.");
            }

            List<WebElement> uploadButtonList = driver.findElements(By.xpath("//a[normalize-space()='Upload Personalized Resume']"));
            // Check if the "Upload" button is present
            if (uploadButtonList != null && !uploadButtonList.isEmpty()) {
                try {
                    // If the "Upload" button is present, continue with the rest of the code
                    WebElement uploadButton = uploadButtonList.get(0);  // Get the first "Upload" button
                    uploadButton.click();  // Click the "Upload" button
                    Thread.sleep(2000);    // Wait for 2 seconds
                    System.out.println("Upload button clicked successfully.");

                    WebElement upload_file = driver.findElement(By.xpath("//input[@id='Upload_File']"));

                    upload_file.sendKeys("C:/User/subrina/Downloads/Update Test iD Ren test baby.pdf");

                } catch (Exception e) {
                    System.out.println("Error occurred while clicking the Upload button: " + e.getMessage());
                    e.printStackTrace();
                }


            } else {
                System.out.println("No upload button found.");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // Close the browser after execution
            if (driver != null) {
                // driver.quit();
            }
        }


    }
}
