package br.com.rsinet.hub_bdd.screenObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import br.com.rsinet.hub_bdd.manager.TestContext;

public class CadastroScreen {
	
	private WebDriver driver;
	@SuppressWarnings("unused")
	private TestContext testContext;
	
	public CadastroScreen(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement username;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement email;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement pass;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement confirmPass;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.EditText")
	private WebElement firstName;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.EditText")
	private WebElement lastName;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement phone;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/linearLayoutCountry")
	private WebElement country;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement state;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement adress;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.EditText")
	private WebElement cidade;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[2]/android.widget.EditText")
	private WebElement cep;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/checkBoxRecieveOffers")
	private WebElement oferta;
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/buttonRegister")
	private WebElement registro;
	
	public void preencheUserName(String et_UserName) {
		username.click();
		username.sendKeys(et_UserName);
	}
	
	public void preencheEmail(String et_Email) {
		email.click();		
		email.sendKeys(et_Email);
	}
	
	public void preenchePassword(String et_Password) {
		pass.click();		
		pass.sendKeys(et_Password);
	}
	
	public void preencheConfirmPassword(String et_ConfirmPassword) {
		confirmPass.click();		
		confirmPass.sendKeys(et_ConfirmPassword);
	}
	
	public void preencheFirstName(String et_FirstName) {
		firstName.click();		
		firstName.sendKeys(et_FirstName);
	}
	
	public void preencheLastName(String et_LastName) {
		lastName.click();		
		lastName.sendKeys(et_LastName);
	}
	
	public void preenchePhoneNumber(String et_PhoneNumber) {
		phone.click();		
		phone.sendKeys(et_PhoneNumber);
	}
	
	public void clicaCountry() {
		country.click();
	}
	
	public void clicaBrazil(@SuppressWarnings("rawtypes") AndroidDriver driver, String visibleText) {
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + visibleText + "\")"))
		.click();	
	}
	
	public void preencheState(String et_State) {
		state.click();	
		state.sendKeys(et_State);	
	}
	
	public void preencheAddress(String et_Address) {
		adress.click();	
		adress.sendKeys(et_Address);
	}
	
	public void preencheCity(String et_City) {
		cidade.click();	
		cidade.sendKeys(et_City);
	}
	
	public void preenchePostalCode(String et_Postalode) {
		cep.click();	
		cep.sendKeys(et_Postalode);
	}
	
	public void clicaCheckOffers() {
		oferta.click();
	}
	
	public MobileElement encontraMsgPassword() {
		MobileElement tvPassword = (MobileElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.TextView"));
		return tvPassword;
	}

	public void clicaRegister() {
		registro.click();	
	}
	
	@SuppressWarnings("rawtypes")
	public void RolarTela(double inicio, double fim) throws Exception {
		Dimension size = driver.manage().window().getSize();

		int x = size.width / 2;
		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);
		new TouchAction((PerformsTouchActions) driver).press(PointOption.point(x, start_y))
				.waitAction((WaitOptions.waitOptions(Duration.ofMillis(500))))//
				.moveTo(PointOption.point(x, end_y))//
				.release().perform();

	}
	
	public void scrollCountry(@SuppressWarnings("rawtypes") AndroidDriver driver, String visibleText) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))");
	}
	
}