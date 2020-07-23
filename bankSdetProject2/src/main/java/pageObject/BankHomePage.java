package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import core.Base;
import utilty.DBUtility;

public class BankHomePage extends Base {
	public BankHomePage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//span[text()='APPLY FOR A MORTGAGE LOAN']")
	private WebElement applyMortgageButton;

	public void clickOnApplyMortgageButton() {
		applyMortgageButton.click();
	}
}
