package stepDefinitions;

import org.testng.asserts.SoftAssert;

import core.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.BankHomePage;

public class AppStepDefinitions extends Base {
	BankHomePage bankHomePage = new BankHomePage();

	@Given("^user is on bank homepage$")
	public void user_is_on_bank_homepage()throws Throwable {
		initilizeUrl1();
	}

	@When("^user clicks on Mortgage Loan button$")
	public void user_clicks_on_Mortgage_Loan_button() throws Throwable {
		bankHomePage.clickOnApplyMortgageButton();
	}

	@Then("^$user is on mortgage loan page")
	public void user_is_on_mortgage_loan_page() throws Throwable{
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(driver.getCurrentUrl().equals(Base.getUrl2()));
		logger.info("User is on the Correct Page");

	}
}
