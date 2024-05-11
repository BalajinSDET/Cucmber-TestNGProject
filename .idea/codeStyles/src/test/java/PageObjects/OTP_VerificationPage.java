package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.OtpReader;



//import static utils.TestBase.getDriver;

public class OTP_VerificationPage {
    public WebDriver driver;

    public OTP_VerificationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By verifyHeading = By.xpath("//div[contains(text(),'OTP Verification')]");
    By emailRBtn = By.xpath("//input[@value='email']");
    By submitBtn = By.xpath("//button[contains (text(),'Submit')]");
    By enterOTP = By.xpath("//input[@placeholder='Enter OTP']");
    By VerifyOTPSubmitBtn = By.xpath("//h5[contains(text(),'Submit ')]");


    public boolean verifyKYCPage() {

       // explicitWait(driver, driver.findElement(verifyHeading));
        return driver.findElement(verifyHeading).isDisplayed();
    }

    public void ClickEmailRadioBtn() {
        driver.findElement(emailRBtn).click();
    }

    public void ClickSubmitBtnOnKycPage() {
        driver.findElement(submitBtn).click();
    }

    public void EnterOTP() {
        String otp = OtpReader.getOtp();
        driver.findElement(enterOTP).sendKeys(otp);
    }

    public void ClickAndVerifyOTPSubmitBtn() {
        driver.findElement(VerifyOTPSubmitBtn).click();
    }
}
