package func;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.MalformedURLException;
import telas.Cabecalho;
import telas.Cart;
import telas.Home;
import telas.PageSearch;
import telas.PaginaDoProduto;
import org.junit.Assert;
import com.itextpdf.text.DocumentException;

import carregarMassa.CarregarJsonCTValidacaoDeCarrinho;
import geraEvidencia.SalvarEvidencias;

public class FuncValidarCarrinho {

	private String item1;
	private String item2;
	SalvarEvidencias evidenciar = new SalvarEvidencias("CT - Validacao De Carrinho");
	int numero = 1;

	public void validarCarrinho(String descricaoStep)
			throws HeadlessException, IOException, AWTException, DocumentException, InterruptedException {
		try {
			Cabecalho cabecalho = new Cabecalho();
			Cart cart = new Cart();
			cabecalho.clicarMyCart();
			cabecalho.viewMyCart();
			assertTrue(cart.validarCarrinho(item1, item2));
			evidenciar.takeScreenshot(descricaoStep);
		} catch (AssertionError e) {
			catchAssertionError(descricaoStep, e);
			throw e;
		} catch (Exception i) {
			catchException(descricaoStep, i);
			throw i;
		}
	}

	public void acessarHome(String descricaoStep)
			throws HeadlessException, IOException, AWTException, DocumentException, InterruptedException {
		try {
			Home home = new Home();
			String acesso = home.validarHome();
			Assert.assertEquals("Demo store panel", acesso);
			evidenciar.takeScreenshot(descricaoStep);
		} catch (AssertionError e) {
			catchAssertionError(descricaoStep, e);
			throw e;
		} catch (Exception i) {
			catchException(descricaoStep, i);
			throw i;
		}
	}

	public void pesquisarPor(String descricaoStep)
			throws HeadlessException, IOException, AWTException, DocumentException, InterruptedException {
		try {
			Cabecalho cabecalho = new Cabecalho();
			CarregarJsonCTValidacaoDeCarrinho massaValidarCarrinho = new CarregarJsonCTValidacaoDeCarrinho();
			
			cabecalho.clicarCampoPesquisa();
			if (numero == 1) {
				cabecalho.preencherPesquisa(massaValidarCarrinho.getPesquisa1());				
			}else {
				cabecalho.preencherPesquisa(massaValidarCarrinho.getPesquisa2());								
			}
			cabecalho.clicarBotaoPesquisar();
			evidenciar.takeScreenshot(descricaoStep);
			numero++;
		} catch (Exception i) {
			catchException(descricaoStep, i);
			throw i;
		}
	}

	public void clicarPrimeiroProduto(String descricaoStep)
			throws HeadlessException, IOException, AWTException, DocumentException, InterruptedException {
		try {
			PageSearch pageSearch = new PageSearch();
			pageSearch.clicaPrimeiroProduto();
			evidenciar.takeScreenshot(descricaoStep);
		} catch (AssertionError e) {
			catchAssertionError(descricaoStep, e);
			throw e;
		} catch (Exception i) {
			catchException(descricaoStep, i);
			throw i;
		}
	}

	public void adicionarCarrinhoPrimeiro(String descricaoStep)
			throws HeadlessException, IOException, AWTException, DocumentException, InterruptedException {
		try {
			PaginaDoProduto paginaDoProduto = new PaginaDoProduto();
			item1 = paginaDoProduto.NomeDoProdutoum();
			paginaDoProduto.AdicionarAoCarrinho();
			paginaDoProduto.eContinuar();
			evidenciar.takeScreenshot(descricaoStep);
		} catch (AssertionError e) {
			catchAssertionError(descricaoStep, e);
			throw e;
		} catch (Exception i) {
			catchException(descricaoStep, i);
			throw i;
		}
	}

	public void clicarSegundoProduto(String descricaoStep)
			throws HeadlessException, IOException, AWTException, DocumentException, InterruptedException {
		try {
			PageSearch pageSearch = new PageSearch();
			pageSearch.clicarSegundoProduto();
			evidenciar.takeScreenshot(descricaoStep);
		} catch (AssertionError e) {
			catchAssertionError(descricaoStep, e);
			throw e;
		} catch (Exception i) {
			catchException(descricaoStep, i);
			throw i;
		}
	}

	public void adicionarCarrinhoSegundo(String descricaoStep)
			throws HeadlessException, IOException, AWTException, DocumentException, InterruptedException {
		try {
			PaginaDoProduto paginaDoProduto = new PaginaDoProduto();
			item2 = paginaDoProduto.NomeDoProdutodois();
			paginaDoProduto.AdicionarAoCarrinho();
			paginaDoProduto.eContinuar();
			evidenciar.takeScreenshot(descricaoStep);
		} catch (AssertionError e) {
			catchAssertionError(descricaoStep, e);
			throw e;
		} catch (Exception i) {
			catchException(descricaoStep, i);
			throw i;
		}
	}

	public void gerarEvidencia() throws MalformedURLException, DocumentException, IOException, InterruptedException {
		try {
			evidenciar.gerarEvidencia();
		} catch (Exception e) {
			throw e;
		}
	}

	private void catchException(String descricaoStep, Exception i)
			throws HeadlessException, IOException, AWTException, DocumentException, InterruptedException {
		evidenciar.takeScreenshot(String.format("%s \n %s", descricaoStep, i.getMessage()));
		gerarEvidencia();
	}

	private void catchAssertionError(String descricaoStep, AssertionError e)
			throws HeadlessException, IOException, AWTException, DocumentException, InterruptedException {
		evidenciar.takeScreenshot(String.format("%s \n %s", descricaoStep, e.toString()));
		gerarEvidencia();
	}
}
