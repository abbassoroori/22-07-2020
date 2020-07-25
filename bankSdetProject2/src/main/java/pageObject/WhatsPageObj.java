package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class WhatsPageObj extends Base {
	public WhatsPageObj() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//span[text()='I want to buy a new home']")
	private WebElement iWantBuyHomeButton;

	public void clickOnIWantButton() {
		iWantBuyHomeButton.click();
	}

	@FindBy(how = How.XPATH, using = "//h3[text()='Glad to meet you here!']")
	private WebElement message;

	public String getTextM() {
		String textMessage = message.getText();
		return textMessage;
	}
	

}
