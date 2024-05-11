package StepDefinition;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import Factory.BrowserFactory;
import Utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private BrowserFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;

	
	
	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() throws Throwable {
		String browser = ConfigReader.getBrowserType(); //-- get the browser from testng.xml 
		String browserName = prop.getProperty("browser");
		String url =prop.getProperty("AppURL");
		driverFactory = new BrowserFactory();
		driver = driverFactory.init_driver(browser); //-- read from parameterization on testng.xml
	//	driver = driverFactory.init_driver(browserName); -- read from config.properties file
	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}


}
