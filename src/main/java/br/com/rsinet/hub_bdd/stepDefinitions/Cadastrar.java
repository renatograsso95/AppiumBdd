package br.com.rsinet.hub_bdd.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import br.com.rsinet.hub_bdd.excel.Constant;
import br.com.rsinet.hub_bdd.excel.ExcelUtils;
import br.com.rsinet.hub_bdd.excel.takeData;
import br.com.rsinet.hub_bdd.manager.ScreenObjectManager;
import br.com.rsinet.hub_bdd.manager.TestContext;
import br.com.rsinet.hub_bdd.screenObject.CadastroScreen;
import br.com.rsinet.hub_bdd.screenObject.HomeScreen;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.android.AndroidDriver;

public class Cadastrar {
	
	private WebDriver driver;
	private CadastroScreen cadastroScreen;
	private HomeScreen homeScreen;
	private takeData takeData;
	private TestContext testContext;
	
	public Cadastrar(TestContext context) throws Exception {
		testContext = context;
		driver = testContext.getDriverFactory().iniciaApp();
	}
	
	@Dado("^que o usuario tenha entrado no app e clicado na opcao de menu$")
	public void que_o_usuario_tenha_entrado_no_app_e_clicado_na_opcao_de_menu() throws Throwable {
		PageFactory.initElements(driver, this);
		ScreenObjectManager manager = new ScreenObjectManager(driver);
		cadastroScreen = manager.getCadastroScreen();
		homeScreen = manager.getHomeScreen();
		takeData = manager.getPegaMassa();

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");
		
		homeScreen.clicaMenu();
	}
	
	@Quando("^ele clicar no link de login$")
	public void ele_clicar_no_link_de_login() throws Throwable {
		homeScreen.clicaLogin();
	}

	@Quando("^clicar no link de criar uma nova conta$")
	public void clicar_no_link_de_criar_uma_nova_conta() throws Throwable {
		homeScreen.clicaCriarNovaConta();
	}

	@SuppressWarnings("rawtypes")
	@Quando("^o usuario preencher o formulario de cadastro$")
	public void o_usuario_preencher_o_formulario_de_cadastro() throws Throwable {
		cadastroScreen.preencheUserName(takeData.UserName());
		
		cadastroScreen.preencheEmail(takeData.Email());
		
		cadastroScreen.preenchePassword(takeData.Password());
		
		cadastroScreen.preencheConfirmPassword(takeData.ConfirmPassword());

		cadastroScreen.preencheFirstName(takeData.FirstName());
		
		cadastroScreen.preencheLastName(takeData.LastName());
		
		cadastroScreen.RolarTela(0.9, 0.0);
		
		cadastroScreen.preenchePhoneNumber(takeData.Telefone());
		
		cadastroScreen.clicaCountry();	
		
		cadastroScreen.scrollCountry((AndroidDriver) driver, "Brazil");
		
		cadastroScreen.clicaBrazil((AndroidDriver) driver, "Brazil");
		
		cadastroScreen.preencheState(takeData.Estado());
		
		cadastroScreen.preencheAddress(takeData.Endereco());
		
		cadastroScreen.preencheCity(takeData.Cidade());

		cadastroScreen.preenchePostalCode(takeData.Cep());
	}

	@Quando("^clicar na caixa de receber ofertas$")
	public void clicar_na_caixa_de_receber_ofertas() throws Throwable {
		cadastroScreen.clicaCheckOffers();
	}

	@Quando("^ele clicar no botao de registrar$")
	public void ele_clicar_no_botao_de_registrar() throws Throwable {
		cadastroScreen.clicaRegister();
	}

	@Entao("^verifica se o usuario esta logado$")
	public void verifica_se_o_usuario_esta_logado() throws Throwable {
		homeScreen.clicaMenu();
		
		String mensagem = takeData.MenssagemAssertCadastroSucesso();
		String condicao = takeData.UserName();
		
		String pass = homeScreen.pegaLogon().getText();
		
		Assert.assertTrue(pass.equals(condicao), mensagem);
	}

	@Quando("^o usuario preencher o formulario de cadastro com a confirmacao de senha diferente da senha$")
	public void o_usuario_preencher_o_formulario_de_cadastro_com_a_confirmacao_de_senha_diferente_da_senha() throws Throwable {
		cadastroScreen.preencheUserName(takeData.UserName());
		
		cadastroScreen.preencheEmail(takeData.Email());
		
		cadastroScreen.preenchePassword(takeData.Password());
		
		cadastroScreen.preencheConfirmPassword(takeData.ConfirmPasswordErrado());
		
		cadastroScreen.preencheFirstName(takeData.FirstName());
	}

	@Entao("^o usuario nao pode efetuar o registro$")
	public void o_usuario_nao_pode_efetuar_o_registro() throws Throwable {
		String condicao = takeData.CondicaoAssertCadastroErro();
		String mensagem = takeData.MenssagemAssertCadastroErro();
		String pass = cadastroScreen.encontraMsgPassword().getText();
		
		Assert.assertTrue(pass.equals(condicao), mensagem);
	}
	
}