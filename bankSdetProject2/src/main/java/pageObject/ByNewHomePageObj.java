package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import core.Base;

public class ByNewHomePageObj extends Base {
	public ByNewHomePageObj() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = "input[name='Firstname']")
	private WebElement fName;
	@FindBy(how = How.ID, using = "Lastname")
	private WebElement lName;
	@FindBy(how = How.NAME, using = "Number")
	private WebElement number;
	@FindBy(how = How.NAME, using = "Phonetype")
	private WebElement pType;
	@FindBy(how = How.XPATH, using = "(//input[@type='email'])[1]")
	private WebElement email;
	@FindBy(how = How.NAME, using = "Confirmemail")
	private WebElement cEmail;
	@FindBy(how = How.NAME, using = "Address")
	private WebElement address;
	@FindBy(how = How.NAME, using = "Zipcode")
	private WebElement zipcode;
	@FindBy(how = How.NAME, using = "ssn")
	private WebElement socialSN;
	@FindBy(how = How.NAME, using = "DOB")
	private WebElement dOB;
	@FindBy(how = How.NAME, using = "education")
	private WebElement edu;
	@FindBy(how = How.NAME, using = "maritalstatus")
	private WebElement maritalS;
	@FindBy(how = How.CSS, using = "input[value='U.S. citizen']")
	private WebElement citizen;
	@FindBy(how = How.CSS, using = "input[value='Dual citizenship with U.S.']")
	private WebElement dualCitizen;
	@FindBy(how = How.CSS, using = "input[value='Not a U.S. citizen']")
	private WebElement notCitizen;
	@FindBy(how = How.CSS, using = "input[value='Non-permanent resident alien']")
	private WebElement nonPermanent;
	@FindBy(how = How.XPATH, using = "(//input[@name='dependents'])[1]")
	private WebElement yesDep;
	@FindBy(how = How.XPATH, using = "(//input[@name='dependents'])[2]")
	private WebElement noDep;
	@FindBy(how = How.XPATH, using = "(//input[@name='military'])[1]")
	private WebElement yesMilit;
	@FindBy(how = How.XPATH, using = "(//input[@name='military'])[2]")
	private WebElement noMilit;
	@FindBy(how = How.XPATH, using = "//input[@name='agreement[]']")
	private WebElement agree;
	@FindBy(how = How.XPATH, using = "//input[@value='Send Application']")
	private WebElement sendApp;
	@FindBy(how = How.XPATH, using = "((//div[text()='Thank you for your message. It has been sent.'])[1]")
	private WebElement message2;

	public void enterFName(String firstName) {
		fName.sendKeys(firstName);
	}

	public void enterLName(String lastName) {
		lName.sendKeys(lastName);
	}

	public void enterPhoneNum(String pNum) {
		number.sendKeys(pNum);
	}

	public void selectphoneType(String value) {
		Select select = new Select(pType);
		select.selectByValue(value);
	}

	public void enterAddress(String addres) {
		address.sendKeys(addres);
	}

	public void enterConfirmEmail(String cEmailAdd) {
		cEmail.sendKeys(cEmailAdd);
	}

	public void enterEmail(String emailAdd) {
		email.sendKeys(emailAdd);
	}

	public void enterZipcode(String zCode) {
		zipcode.sendKeys(zCode);
	}

	public boolean isSelectedUSCZen() {
		boolean isSelectedUSCZ = citizen.isSelected();
		return isSelectedUSCZ;
	}

	public boolean isSelectedDual() {
		boolean dualCZ = dualCitizen.isSelected();
		return dualCZ;
	}

	public boolean isSelectedNonCZ() {
		boolean nonCZ = notCitizen.isSelected();
		return nonCZ;
	}

	public boolean isSelectedNonPerm() {
		boolean nonPerm = nonPermanent.isSelected();
		return nonPerm;
	}

	public void clickOnCZ() {
		citizen.click();
	}

	public void clickOnDual() {
		dualCitizen.click();
	}

	public void clickOnNonCZ() {
		notCitizen.click();
	}

	public void clickOnNonpe() {
		nonPermanent.click();
	}

	public void enterSSN(String sSN) {
		socialSN.sendKeys(sSN);
	}

	public void enterDOB(String dOBs) {
		dOB.sendKeys(dOBs);
	}

	public void selectEdu(String edus) {
		Select select = new Select(edu);
		select.selectByValue(edus);
	}

	public void selectMil(String miliStu) {
		Select select = new Select(maritalS);
		select.deselectByValue(miliStu);
	}

	public boolean isSelectedYesDep() {
		boolean yesDepend = yesDep.isSelected();
		return yesDepend;
	}

	public boolean isSelectedNoDep() {
		boolean noDepend = noDep.isSelected();
		return noDepend;
	}

	public boolean isSelectedYesMili() {
		boolean yesMiliStu = yesMilit.isSelected();
		return yesMiliStu;
	}

	public boolean isSelectedNoMili() {
		boolean noMiliStu = noMilit.isSelected();
		return noMiliStu;
	}

	public boolean isSelectedAgree() {
		boolean agreeM = agree.isSelected();
		return agreeM;
	}

	public void clickOnYedDep() {
		yesDep.click();
	}

	public void clickOnNoDep() {
		noDep.click();
	}

	public void clickOnYesMili() {
		yesMilit.click();
	}

	public void clickOnNoMili() {
		noMilit.click();
	}

	public void clickOnSendApp() {
		sendApp.click();
	}

	public boolean isDisplyMessage2() {
		boolean messageApp = message2.isDisplayed();
		return messageApp;
	}

}
