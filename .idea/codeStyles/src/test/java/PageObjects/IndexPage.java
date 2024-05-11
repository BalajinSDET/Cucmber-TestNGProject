package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

	private WebDriver driver;

	public IndexPage(WebDriver driver) {
		this.driver=driver;
		 PageFactory.initElements(driver, this);
	}

	private  By IHPLOGO = By.xpath("//a[@class]//*[@src='/static/media/humanLogo.98dd5966.png']");
	private  By loginAsJobProvider = By.xpath("//h4[contains(text(),'LOGIN AS JOB PROVIDER')]");
	private  By loginAsJobSeeker = By.xpath("//h4[contains(text(),'LOGIN AS JOBSEEKER')]");

	public String getIndexPageTitle() {
		return driver.getTitle();
	}

	public boolean VerifyIhpLogo() throws InterruptedException {
		return driver.findElement(IHPLOGO).isDisplayed();
	}

	public void Click_LoginAsJobProvider() {
		driver.findElement(loginAsJobProvider).click();
	}

	public void Click_LoginAsJobSeeker() {
		driver.findElement(loginAsJobSeeker).click();
	}

}
