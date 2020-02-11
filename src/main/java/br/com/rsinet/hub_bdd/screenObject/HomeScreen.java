package br.com.rsinet.hub_bdd.screenObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;

public class HomeScreen {
	
	private WebDriver driver;
	
	public HomeScreen(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewMenuUser")
	private WebElement loginIcon;
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewDontHaveAnAccount")
	private WebElement btCriarConta;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/editTextSearch")
	private WebElement btBarraPesquisa;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/imageViewSearch")
	private WebElement btLupa;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[4]/android.widget.ImageView")
	private WebElement speaker;

	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[3]/android.widget.EditText")
	private WebElement userLogin;

	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[4]/android.widget.EditText")
	private WebElement userPass;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/buttonLogin")
	private WebElement btLogin;

	private MobileElement findMenu(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		MobileElement encontraMenu = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.Advantage.aShopping:id/imageViewMenu")));
		return encontraMenu;
	}
	
	public void clicaMenu() {
		findMenu(driver).click();
	}
	
	public void clicaLogin() {
		loginIcon.click();
	}
	
	public void clicaCriarNovaConta() {
		btCriarConta.click();
	}
	
	public MobileElement pegaLogon() {
		MobileElement pegaLogon = (MobileElement) driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser"));
		return pegaLogon;
	}
	
	public void preencheBarraPesquisa(String et_BarraPesquisa) {
		btBarraPesquisa.click();
		btBarraPesquisa.sendKeys(et_BarraPesquisa);
	}
	
	public void clicaLupa() {
		btLupa.click();
	}
	
	public void clicaCategoriaSpeakers() {
		speaker.click();
	}
	
	public void preencheUserLogin(String et_UserLogin) {
		userLogin.click();
		userLogin.sendKeys(et_UserLogin);
	}
	
	public void preenchePasswordLogin(String et_PasswordLogin) {
		userPass.click();
		userPass.sendKeys(et_PasswordLogin);
	}
	
	public void clicaBtLogin() {
		btLogin.click();
	}
	
	private MobileElement encontraNoBt(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		MobileElement encontraNoBt = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[1]")));
		return encontraNoBt;
	}
	
	public void clicaNoBt() throws InterruptedException {
		encontraNoBt(driver).click();
	}
	
	
}