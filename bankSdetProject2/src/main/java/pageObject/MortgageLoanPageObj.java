package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class MortgageLoanPageObj extends Base {
	public MortgageLoanPageObj() {

		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//span[text()='APPLY NOW']")
	private WebElement applyNowButton;

	public void clickOnApplyNowButton() {
		applyNowButton.click();
	}
	
}
