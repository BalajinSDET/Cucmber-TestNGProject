package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public class Job_Provider_SignInPage {

    public WebDriver driver;

    public Job_Provider_SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    private By SignInText = By.xpath("//h4[contains(text(),'Sign in')]");
    private By EmailId = By.xpath("//input[@type='email']");
    private By Password = By.xpath("//input[@type='password']");
    private By SignInBtn = By.xpath("//button[@type='submit']");

 

    public boolean Verify_SignInPage() {
        //  HighlightingElement(driver,driver.findElement(SignInText));
        //   explicitWait( SignInText);
        return driver.findElement(SignInText).isDisplayed();
    }

    public void EnterEmailId(String email) {
       //  HighlightingElement( driver,driver.findElement(EmailId));
        driver.findElement(EmailId).click();
        driver.findElement(EmailId).sendKeys(email);

    }

    public void EnterPassword(String password) {
     //   HighlightingElement( driver,driver.findElement(Password));
        driver.findElement(Password).click();
        driver.findElement(Password).sendKeys(password);

    }

    public OTP_VerificationPage ClickSignInButton() throws InterruptedException {
    //    HighlightingElement( driver, driver.findElement(SignInBtn));
        System.out.println("sign in button is " + driver.findElement(SignInBtn).isDisplayed());
        driver.findElement(SignInBtn).click();
        return new OTP_VerificationPage(driver);
    }
}
