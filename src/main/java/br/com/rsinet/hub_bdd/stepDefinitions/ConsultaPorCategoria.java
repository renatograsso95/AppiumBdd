package br.com.rsinet.hub_bdd.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import br.com.rsinet.hub_bdd.excel.Constant;
import br.com.rsinet.hub_bdd.excel.ExcelUtils;
import br.com.rsinet.hub_bdd.manager.ScreenObjectManager;
import br.com.rsinet.hub_bdd.manager.TestContext;
import br.com.rsinet.hub_bdd.screenObject.HomeScreen;
import br.com.rsinet.hub_bdd.screenObject.PesquisaScreen;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

import br.com.rsinet.hub_bdd.excel.takeData;

public class ConsultaPorCategoria {
	
	private WebDriver driver;
	private HomeScreen homeScreen;
	private takeData takeData;
	private PesquisaScreen pesquisaScreen;
	private TestContext testContext;
	
	public ConsultaPorCategoria(TestContext context) throws Exception {
		testContext = context;
		driver = testContext.getDriverFactory().initDriver();
	}
	
	@Dado("^que o usuario tenha entrado no app e efetue o login$")
	public void que_o_usuario_tenha_entrado_no_app_e_efetue_o_login() throws Throwable {
		PageFactory.initElements(driver, this);
		ScreenObjectManager manager = new ScreenObjectManager(driver);
		homeScreen = manager.getHomeScreen();
		takeData = manager.getPegaMassa();
		pesquisaScreen = manager.getPesquisaScreen();
		
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");
		
		homeScreen.clicaMenu();
		
		homeScreen.clicaLogin();
		
		homeScreen.preencheUser(takeData.UserName());
		homeScreen.preenchePass(takeData.Password());
		
		homeScreen.clicaBtLogin();
		
	}

	@Quando("^ele selecionar a categoria do produto desejado$")
	public void ele_selecionar_a_categoria_do_produto_desejado() throws Throwable {
		homeScreen.clickSpeaker();
	}

	@Quando("^clicar no produto desejado$")
	public void clicar_no_produto_desejado() throws Throwable {
		pesquisaScreen.escolheProduto();
	}

	@Entao("^verifica se o produto correto foi selecionado$")
	public void verifica_se_o_produto_correto_foi_selecionado() throws Throwable {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "PesquisaCat");
		
		String condicao = takeData.CondicaoAssertMassaSucesso();
		String mensagem = takeData.MenssagemAssertMassaSucesso();
		
		String pass = pesquisaScreen.encontraNomeProduto(driver).getText();
		Assert.assertTrue(pass.equals(condicao), mensagem);
	}

	@Quando("^ele alterar a quantidade de produtos para compra acima do aceitavel no carrinho$")
	public void ele_alterar_a_quantidade_de_produtos_para_compra_acima_do_aceitavel_no_carrinho() throws Throwable {
		pesquisaScreen.clicaQuantidadeProduto();
		pesquisaScreen.preencheQuantidadeCompra();
		pesquisaScreen.clicaAplicaQuantidade();
	}

	@Quando("^clicar no botao de adicionar produto ao carrinho$")
	public void clicar_no_botao_de_adicionar_produto_ao_carrinho() throws Throwable {
		pesquisaScreen.clicaAdicionarAoCarrinho();
	}

	@Quando("^clicar no carrinho de compras$")
	public void clicar_no_carrinho_de_compras() throws Throwable {
		pesquisaScreen.clicaCarrinhoDeCompras();
	}

	@Entao("^checar se a quantidade de produtos solicitada corresponde a quantidade no carrinho$")
	public void checar_se_a_quantidade_de_produtos_solicitada_corresponde_a_quantidade_no_carrinho() throws Throwable {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "PesquisaCat");
		
		String condicao = takeData.CondicaoAssertMassaErro();
		String mensagem = takeData.MenssagemAssertMassaErro();
		
		String pass = pesquisaScreen.encontraQuantidadeComprada().getText();
		Assert.assertTrue(pass.equals(condicao), mensagem);
	}
	
}