package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import core.Base;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.BankHomePageObj;
import pageObject.ByNewHomePageObj;
import pageObject.MortgageLoanPageObj;
import pageObject.WhatsPageObj;

public class AppStepDefinitions extends Base {
	BankHomePageObj bankHomePage = new BankHomePageObj();
	MortgageLoanPageObj mortgageLoanPageObj = new MortgageLoanPageObj();
	WhatsPageObj whatsPageObj = new WhatsPageObj();
	ByNewHomePageObj byNewHomePageObj = new ByNewHomePageObj();

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
	public void user_is_on_whatIsYourGoal_page()throws Throwable{
		Base.initilizeUrl3();
	}

	@When("^user clicks on I Want to Buy a new Home button$")
	public void user_clicks_on_I_Want_to_Buy_a_new_Home_button()throws Throwable {
		whatsPageObj.clickOnIWantButton();
	}

	@Then("^user see this message '(.+)'$")
	public void user_see_message(String message)throws Throwable {
		Assert.assertTrue(whatsPageObj.getTextM().equals(message));
	}

	@Given("^user is on Buy new Home Application page$")
	public void user_is_on_Buy_new_Home_Application_page() throws Throwable{
		Base.initilizeUrl4();
	}

	@When("^user fills fields by bellow information$")
	public void user_fills_fields_by_bellow_information(DataTable personalInfo) throws Throwable {

		List<Map<String, String>> data = personalInfo.asMaps(String.class, String.class);
		byNewHomePageObj.enterFName(data.get(0).get("firstName"));
		byNewHomePageObj.enterLName(data.get(0).get("lastName"));
		byNewHomePageObj.enterPhoneNum(data.get(0).get("phoneNumber"));
		byNewHomePageObj.enterEmail(data.get(0).get("email"));
		byNewHomePageObj.enterConfirmEmail(data.get(0).get("cEmail"));
		byNewHomePageObj.enterAddress(data.get(0).get("address"));
		byNewHomePageObj.enterZipcode(data.get(0).get("zipCode"));
		byNewHomePageObj.enterSSN(data.get(0).get("ssn"));
		byNewHomePageObj.enterDOB(data.get(0).get("dob"));
		byNewHomePageObj.selectEdu(data.get(0).get("hLEdue"));
		byNewHomePageObj.selectMil(data.get(0).get("miteralS"));
		byNewHomePageObj.selectphoneType(data.get(0).get("phTtpe"));

	}

	@When("^user selects '(.+)'$")
	public void user_selects_CitizenshipStatus(String militariStatus) throws Throwable{
		if (militariStatus.contains("Dual")) {
			if (!byNewHomePageObj.isSelectedDual())

			{
				byNewHomePageObj.clickOnDual();
			}
		} else if (militariStatus.equals("U.S. citizen")) {
			if (!byNewHomePageObj.isSelectedUSCZen()) {
				byNewHomePageObj.clickOnCZ();
			}
		} else if (militariStatus.equals("Not a U.S. citizen")) {
			if (!byNewHomePageObj.isSelectedNonCZ()) {
				byNewHomePageObj.clickOnNonCZ();
			}
		} else if (militariStatus.contains("permanent")) {
			if (!byNewHomePageObj.isSelectedNonPerm()) {
				byNewHomePageObj.clickOnNonpe();
			}
		}
	}

	@When("^user selects '(.+)' dependency$")
	public void user_selects_dependency(String dependency) throws Throwable{
		if (dependency.equalsIgnoreCase("yes")) {
			if (!byNewHomePageObj.isSelectedYesDep()) {
				byNewHomePageObj.clickOnYedDep();
			}
		} else if (dependency.equalsIgnoreCase("no")) {
			if (!byNewHomePageObj.isSelectedNoDep()) {
				byNewHomePageObj.clickOnNoDep();
			}
		}
	}

	@When("^user selects'(.+)' military$")
	public void user_selects_military(String militaryStut)throws Throwable {
		if (militaryStut.equalsIgnoreCase("yes")) {
			if (!byNewHomePageObj.isSelectedYesMili()) {
				byNewHomePageObj.clickOnYesMili();
			}
		} else if (militaryStut.equalsIgnoreCase("no")) {
			if (!byNewHomePageObj.isSelectedNoMili()) {
				byNewHomePageObj.clickOnNoMili();
			}
		}
	}

	@When("^user clicks on agreement checkbox$")
	public void user_clicks_on_agreement_checkbox() throws Throwable{
		if (!byNewHomePageObj.isSelectedAgree()) {
			byNewHomePageObj.clickOnAgree();
		}
	}

	@When("^user clicks on send application$")
	public void user_clicks_on_send_application()throws Throwable {
		byNewHomePageObj.clickOnSendApp();
	}

	@Then("^user See this message'(.+)'$")
	public void user_See_message2(String messageSuccess)throws Throwable {
		Assert.assertTrue(messageSuccess.equals(byNewHomePageObj.getMessage2Text()));
	}

}
