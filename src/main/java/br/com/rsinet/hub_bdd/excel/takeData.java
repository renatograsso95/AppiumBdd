package br.com.rsinet.hub_bdd.excel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class takeData {
	
	@SuppressWarnings("unused")
	private WebDriver driver;
	
	public takeData(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	public String UserName() throws Exception {
		return ExcelUtils.getCellData(1, Constant.userName);
	}
	
	public String Email() throws Exception {
		return ExcelUtils.getCellData (2, Constant.email);
	}
	
	public String Password() throws Exception {
		return ExcelUtils.getCellData(3, Constant.password);
	}
	
	public String ConfirmPassword() throws Exception {
		return ExcelUtils.getCellData(4, Constant.confirmPassword);
	}
	
	public String ConfirmPasswordErrado() throws Exception {
		return ExcelUtils.getCellData(5, Constant.confirmInvalidPassword);
	}
	
	public String FirstName() throws Exception {
		return ExcelUtils.getCellData(6, Constant.firstName);
	}
	
	public String LastName() throws Exception {
		return ExcelUtils.getCellData(7, Constant.lastName);
	}
	
	public String Telefone() throws Exception {
		return ExcelUtils.getCellData(8, Constant.telefone);
	}
	
	public String Pais() throws Exception {
		return ExcelUtils.getCellData(9, Constant.pais);
	}
	
	public String Cidade() throws Exception {
		return ExcelUtils.getCellData(10, Constant.cidade);
	}
	
	public String Endereco() throws Exception {
		return ExcelUtils.getCellData(11, Constant.endereco);
	}
	
	public String Estado() throws Exception {
		return ExcelUtils.getCellData(12, Constant.estado);
	}
	
	public String Cep() throws Exception {
		return ExcelUtils.getCellData(13, Constant.cep);
	}
	
	public String MenssagemAssertCadastroSucesso() throws Exception {
		return ExcelUtils.getCellData(3, Constant.mensagemAssertCadastroSucesso);
	}
	
	public String CondicaoAssertCadastroErro() throws Exception {
		return ExcelUtils.getCellData(1, Constant.condicaoAssertCadastroErro);
	}
	
	public String MenssagemAssertCadastroErro() throws Exception {
		return ExcelUtils.getCellData(2, Constant.mensagemAssertCadastroErro);
	}
	
	//PesquisaBarra
	public String PesquisaNaBarra() throws Exception {
		return ExcelUtils.getCellData(1, Constant.pesquisaBarra);
	}
	
	public String PesquisaNaBarraErro() throws Exception {
		return ExcelUtils.getCellData(5, Constant.pesquisaBarraErro);
	}
	
	public String CondicaoAssertBarra() throws Exception {
		return ExcelUtils.getCellData(1, Constant.condicaoAssertBarra);
	}
	
	public String MenssagemAssertBarra() throws Exception {
		return ExcelUtils.getCellData(2, Constant.mensagemAssertBarra);
	}
	
	//PesquisaCategoria
	public String ClicaNoProduto() throws Exception {
		return ExcelUtils.getCellData(5, Constant.clicaProduto);
	}
	
	public String CondicaoAssertMassaSucesso() throws Exception {
		return ExcelUtils.getCellData(2, Constant.condicaoAssertMassaSucesso);
	}
	
	public String MenssagemAssertMassaSucesso() throws Exception {
		return ExcelUtils.getCellData(1, Constant.mensagemAssertMassaSucesso);
	}
	
	public String CondicaoAssertMassaErro() throws Exception {
		return ExcelUtils.getCellData(4, Constant.condicaoAssertMassaErro);
	}
	
	public String MenssagemAssertMassaErro() throws Exception {
		return ExcelUtils.getCellData(3, Constant.mensagemAssertMassaErro);
	}
	
	public String QuantidadeProduto() throws Exception {
		return ExcelUtils.getCellData(8, Constant.quantidadeCat);
	}
}
