package func;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Assert;

import com.itextpdf.text.DocumentException;

import geraEvidencia.SalvarEvidencias;
import telas.Cabecalho;
import telas.Home;
import telas.PageSearch;

public class FuncValidarDesconto {
	SalvarEvidencias evidenciar = new SalvarEvidencias("CT - Validacao De Desconto");

	public void validarHome(String descricaoStep)
			throws HeadlessException, IOException, AWTException, DocumentException, InterruptedException {
		try {
			Home home = new Home();
			String acesso = home.validarHome();
			Assert.assertEquals("Demo store panel", acesso);
		} catch (AssertionError e) {
			catchAssertionError(descricaoStep, e);
			throw e;
		} catch (Exception i) {
			catchException(descricaoStep, i);
			throw i;
		}

	}

	public void clicarEmSales(String descricaoStep)
			throws HeadlessException, IOException, AWTException, DocumentException, InterruptedException {
		try {
			Cabecalho cabecalho = new Cabecalho();
			cabecalho.clicarSales();
		} catch (AssertionError e) {
			catchAssertionError(descricaoStep, e);
			throw e;
		} catch (Exception i) {
			catchException(descricaoStep, i);
			throw i;
		}
	}

	public void validaDesconto(String descricaoStep)
			throws HeadlessException, IOException, AWTException, DocumentException, InterruptedException {
		try {
			PageSearch pageSearch = new PageSearch();
			String valorDoDesconto = pageSearch.recuperaValorDesconto();
			String valorAntigo = pageSearch.recuperaValorAntigo();
			String valorComDesconto = pageSearch.recuperaValorComDesconto();

			assertTrue(
					String.format("ao aplicar o do desconto %s no valor antigo %s, os valores não batem !!",
							valorDoDesconto, valorAntigo, valorComDesconto),
					validaValores(valorDoDesconto, valorAntigo, valorComDesconto));
		} catch (AssertionError e) {
			catchAssertionError(descricaoStep, e);
			throw e;
		} catch (Exception i) {
			catchException(descricaoStep, i);
			throw i;
		}
	}

	private boolean validaValores(String valorDoDesconto, String valorAntigo, String valorComDesconto) {
		int porcentagemDesconto = Integer.parseInt(valorDoDesconto.replace("Save ", "").replace("%", ""));

		double dValorAntigo = Double.parseDouble(valorAntigo);

		double valorDODesconto = (dValorAntigo * porcentagemDesconto) / 100;

		if (Double.toString((Math.round((dValorAntigo - valorDODesconto) * 100) / 100d)).equals(valorComDesconto)) {
			return true;
		}
		return false;
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
