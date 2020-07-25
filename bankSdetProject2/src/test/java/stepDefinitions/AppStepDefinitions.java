package stepDefinitions;

import org.junit.Assert;

import core.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.BankHomePageObj;
import pageObject.MortgageLoanPageObj;
import pageObject.WhatsPageObj;

public class AppStepDefinitions extends Base {
	BankHomePageObj bankHomePage = new BankHomePageObj();
	MortgageLoanPageObj mortgageLoanPageObj = new MortgageLoanPageObj();
	WhatsPageObj whatsPageObj = new WhatsPageObj();

	@Given("^user is on bank homepage$")
	public void user_is_on_bank_homepage() throws Throwable {
		Base.initilizeUrl1();
	}

	@When("^user clicks on Mortgage Loan button$")
	public void user_clicks_on_Mortgage_Loan_button() throws Throwable {
		bankHomePage.clickOnApplyMortgageButton();
	}

	@Then("^user is on mortgage loan page$")
	public void user_is_on_mortgage_loan_page() throws Throwable {

		String actuallPageTitle = driver.getTitle();
		String expectedPageTitle = "Mortgage Loan – TEK SCHOOL";
		Assert.assertEquals(actuallPageTitle, expectedPageTitle);
		logger.info("User is on the Correct Page");

	}

	@Given("^user is on mortgage LoanPage$")
	public void user_is_on_mortgage_loanPage() throws Throwable {
		Base.initilizeUrl2();
	}

	@When("^user clicks on Apply New button$")
	public void user_clicks_on_Apply_New_button() throws Throwable {
		mortgageLoanPageObj.clickOnApplyNowButton();
	}

	@Then("^user goes to whatIsYourGoal page$")
	public void user_goes_to_whatIsYourGoal_page() throws Throwable {
		String actuallPageTitle = driver.getTitle();
		String expectedPageTitle = "What is your goal? – TEK SCHOOL";
		Assert.assertEquals(actuallPageTitle, expectedPageTitle);
	}

	@Given("^user is on whatIsYourGoal page$")
	public void user_is_on_whatIsYourGoal_page() {
		Base.initilizeUrl3();
	}

	@When("^user clicks on I Want to Buy a new Home button$")
	public void user_clicks_on_I_Want_to_Buy_a_new_Home_button() {
		whatsPageObj.clickOnIWantButton();
	}
	@Then("^user see this message '(.+)'$")
	public void user_see_message(String message) {
		Assert.assertTrue(whatsPageObj.getTextM().equals(message));
	}
	

}
