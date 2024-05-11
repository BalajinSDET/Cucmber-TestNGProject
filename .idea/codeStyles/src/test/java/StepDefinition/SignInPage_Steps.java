package StepDefinition;

import org.testng.Assert;

import Factory.BrowserFactory;
import PageObjects.IndexPage;
import PageObjects.Job_Provider_SignInPage;
import PageObjects.OTP_VerificationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInPage_Steps {
	private IndexPage ip = new IndexPage(BrowserFactory.getDriver());
	private Job_Provider_SignInPage jpsip = new Job_Provider_SignInPage(BrowserFactory.getDriver());
	private OTP_VerificationPage otpvp = new OTP_VerificationPage(BrowserFactory.getDriver());
	


	@Given("User is enter the Ihp website URL")
	public void userIsEnterTheIhpWebsiteURL() throws InterruptedException {
		System.out.println("Launched the URL....Start test execution");
		Assert.assertTrue(ip.VerifyIhpLogo());
	}


	@When("The user should able to click on the Login as Job Provider button in the HomePage")
	public void the_user_should_able_to_click_on_the_login_as_job_provider_button_in_the_home_page() throws InterruptedException {
		ip.Click_LoginAsJobProvider();
	}


	@Then("User should navigated to the sign in page")
	public void userShouldNavigatedToTheSignInPage() {
		Assert.assertTrue(jpsip.Verify_SignInPage());
	}

	@And("The user enter their Email Id as {string} and Password as {string}")
	public void theUserEnterTheirEmailIdAsAndPasswordAs(String email, String password) throws InterruptedException {
		jpsip.EnterEmailId(email);
		jpsip.EnterPassword(password);
	}

	@When("User clicks on the sign in button")
	public void userClicksOnTheSignInButton() throws InterruptedException {
		jpsip.ClickSignInButton();
	}

	@And("User should navigated to the KYC Verification")
	public void userShouldNavigatedToTheKYCVerification() throws InterruptedException {
		Assert.assertTrue(otpvp.verifyKYCPage());
	}

	@And("User clicks the email verification radio button and then user clicks the submit button")
	public void userClicksTheEmailVerificationRadioButtonAndThenUserClicksTheSubmitButton() throws InterruptedException {
		otpvp.ClickEmailRadioBtn();
		otpvp.ClickSubmitBtnOnKycPage();
		otpvp.EnterOTP();
		otpvp.ClickAndVerifyOTPSubmitBtn();
	}

	@Then("User navigates to the dashboard page of the Ihp project successfully")
	public void userNavigatesToTheDashboardPageOfTheIhpProjectSuccessfully() {
		System.out.println("Landed dashboard page");
	}


}
