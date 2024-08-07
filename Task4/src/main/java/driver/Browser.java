package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.DataReader;

import java.io.File;
import java.util.logging.Logger;

public class Browser {

	private static WebDriver driver;
	private static final String browserName = DataReader.getStringValue("browser", "config");
	private static final Logger logger = Logger.getLogger(Browser.class.getName());
	private static final String adblockerPath = "src/main/resources/uBlock Origin - Chrome Web Store 1.59.0.0.crx";

	public static WebDriver initialize() {
		// Singleton method
		if (driver == null) {
			switch (browserName.toLowerCase()) {
				case "chrome":
					try {
						WebDriverManager.chromedriver().setup();
						ChromeOptions options = new ChromeOptions();
						options.addExtensions(new File(adblockerPath));
						driver = new ChromeDriver(options);
						logger.info("Initialized ChromeDriver with Adblocker.");
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
						ChromeOptions options = new ChromeOptions();
						options.addExtensions(new File(adblockerPath));
						driver = new ChromeDriver(options);
						logger.info("Initialized ChromeDriver with Adblocker as default.");
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
