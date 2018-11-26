package casosDeTeste;

import org.junit.Before;
import org.junit.Test;

import com.borland.silktest.jtf.BrowserBaseState;
import com.borland.silktest.jtf.Desktop;

import func.FuncValidarCarrinho;
import com.itextpdf.text.DocumentException;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import com.borland.silktest.jtf.xbrowser.BrowserApplication;

public class CTValidacaoDeCarrinho {
	private Desktop desktop = new Desktop();

	@Before
	public void baseState() {
		// Go to web page 'http://demo.cs-cart.com/'
		BrowserBaseState baseState = new BrowserBaseState();
		baseState.execute(desktop);
		BrowserApplication app = desktop.find("//BrowserApplication");
		app.maximize();
	}
	
	@Test
	public void validarCarrinho() throws HeadlessException, IOException, AWTException, DocumentException, InterruptedException {
		FuncValidarCarrinho funcValidarCarrinho = new FuncValidarCarrinho();

		funcValidarCarrinho.acessarHome(
				"Step 1.       Acessar o site: http://demo.cs-cart.com/");

		funcValidarCarrinho.pesquisarPor( 
				"Step 2.       No campo “Procurar Produtos” pesquise usando o valor “Batman”.");

		funcValidarCarrinho.clicarPrimeiroProduto(
				"Step 3.       No resultado da pesquisa clique em um dos resultados apresentados.");
		
		funcValidarCarrinho.adicionarCarrinhoPrimeiro(
				"Step 4.       Na tela do produto pressione o botão “Adicionar ao carrinho”.");
	
		funcValidarCarrinho.pesquisarPor( 
				"Step 5.       Repita os passos 2 a 4, pesquisando pelo item “PS3”.");
		funcValidarCarrinho.clicarSegundoProduto(
				"Step5.1");
		funcValidarCarrinho.adicionarCarrinhoSegundo(
				"Step5.2");

		funcValidarCarrinho.validarCarrinho(
				"Step 6.         Valide no carrinho de compras se os produtos foram adicionados com sucesso.");


		funcValidarCarrinho.gerarEvidencia();	
	}

}