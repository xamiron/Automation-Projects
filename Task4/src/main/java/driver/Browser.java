package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.DataReader;

import java.util.logging.Logger;

public class Browser {

	private static WebDriver driver;
	private static final String browserName = DataReader.getStringValue("browser", "config");
	private static final Logger logger = Logger.getLogger(Browser.class.getName());

	public static WebDriver initialize() {
		// Singleton method
		if (driver == null) {
			switch (browserName.toLowerCase()) {
				case "chrome":
					try {
						WebDriverManager.chromedriver().setup();
						driver = new ChromeDriver();
						logger.info("Initialized ChromeDriver as default.");
						// Set the path to your Chrome user data directory
//						options.addArguments("user-data-dir=C:\\Users\\Z3TSU\\AppData\\Local\\Google\\Chrome\\User Data");
//						options.addArguments("profile-directory=Profile 1"); // Specify the profile directory
//						options.addArguments("--disable-blink-features=AutomationControlled");
						//options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
//						//options.addArguments("--incognito");
//						options.addArguments("--disable-blink-features=AutomationControlled");
//						options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
//						options.addArguments("--start-maximized");
//						options.addArguments("--disable-infobars");
//						options.addArguments("--disable-extensions");
//						options.addArguments("--disable-gpu");
//						options.addArguments("--no-sandbox");
//						options.addArguments("--disable-dev-shm-usage");

//						options.addArguments("--disable-blink-features=AutomationControlled");
//						options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
//						options.addArguments("--headless");
//						options.addArguments("--start-maximized");
//						options.addArguments("--disable-infobars");
//						options.addArguments("--disable-extensions");
//						options.addArguments("--disable-gpu");
//						options.addArguments("--no-sandbox");
//						options.addArguments("--disable-dev-shm-usage");
						//driver = new ChromeDriver(options);
						//.info("Initialized ChromeDriver with custom options.");
					} catch (Exception e) {
						logger.severe("Failed to initialize ChromeDriver: " + e.getMessage());
						e.printStackTrace();
					}
					break;
				case "firefox":
					try {
						WebDriverManager.firefoxdriver().setup();
						driver = new FirefoxDriver();
						logger.info("Initialized FirefoxDriver.");
					} catch (Exception e) {
						logger.severe("Failed to initialize FirefoxDriver: " + e.getMessage());
						e.printStackTrace();
					}
					break;
				case "edge":
					try {
						WebDriverManager.edgedriver().setup();
						driver = new EdgeDriver();
						logger.info("Initialized EdgeDriver.");
					} catch (Exception e) {
						logger.severe("Failed to initialize EdgeDriver: " + e.getMessage());
						e.printStackTrace();
					}
					break;
				default:
					// Set a default browser (e.g., Chrome) when the browserName is not recognized.
					try {
						WebDriverManager.chromedriver().setup();
						driver = new ChromeDriver();
						logger.info("Initialized ChromeDriver as default.");
					} catch (Exception e) {
						logger.severe("Failed to initialize default ChromeDriver: " + e.getMessage());
						e.printStackTrace();
					}
					break;
			}
		}
		return driver;
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			initialize();
		}
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
			logger.info("Closed and nullified WebDriver instance.");
		}
	}
}
