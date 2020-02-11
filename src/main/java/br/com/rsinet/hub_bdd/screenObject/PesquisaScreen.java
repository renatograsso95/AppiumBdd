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

public class PesquisaScreen {

	private WebDriver driver;
	
	public PesquisaScreen(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewProductQuantity")
	private WebElement quantidadeProduto;

	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")
	private WebElement quantCompra;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewApply")
	private WebElement btAplica;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/buttonProductAddToCart")
	private WebElement addCarrinho;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/imageViewCart")
	private WebElement carrinhoCompra;

	private MobileElement findProduto(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		MobileElement encontraPorduto = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.RelativeLayout[@content-desc=\"Search\"]/android.widget.LinearLayout/android.widget.GridView/android.widget.RelativeLayout/android.widget.ImageView")));
		return encontraPorduto;
	}
	
	public void clickProduto() {
		findProduto(driver).click();
	}
	
	public MobileElement encontraNomeProduto(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		MobileElement encontraNomePorduto = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.Advantage.aShopping:id/textViewProductName")));
		return encontraNomePorduto;
	}
	
	public MobileElement encontraResultadoPesquisa(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		MobileElement encontraResultadoPesquisa = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.Advantage.aShopping:id/textViewNoProductsToShow")));
		return encontraResultadoPesquisa;
	}
	
	private MobileElement encontraProdutoCategoria(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		MobileElement encontraPordutoCategoria = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.RelativeLayout[@content-desc=\"Speakers\"]/android.widget.LinearLayout/android.widget.GridView/android.widget.RelativeLayout[3]/android.widget.ImageView")));
		return encontraPordutoCategoria;
	}
	
	public void escolheProduto() {
		encontraProdutoCategoria(driver).click();
	}
	
	public void clicaQuantidadeProduto() {
		quantidadeProduto.click();
	}
	
	public void preencheQuantidadeCompra() {
		quantCompra.click();
		quantCompra.clear();
		quantCompra.sendKeys("11");
	}
	
	public void clicaAplicaQuantidade() {
		btAplica.click();
	}
	
	public void clicaAdicionarAoCarrinho() {
		addCarrinho.click();
	}
	
	public void clicaCarrinhoDeCompras() {
		carrinhoCompra.click();
	}
	
	public MobileElement encontraQuantidadeComprada() {
		MobileElement encontraQuantidadeDeCompra = (MobileElement) driver.findElement(By.id("com.Advantage.aShopping:id/textViewCartQuantity"));
		return encontraQuantidadeDeCompra;
	}
}

