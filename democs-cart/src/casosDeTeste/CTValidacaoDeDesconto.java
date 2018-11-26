package casosDeTeste;

import org.junit.Before;

import com.borland.silktest.jtf.BrowserBaseState;
import com.borland.silktest.jtf.Desktop;
import org.junit.Test;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.itextpdf.text.DocumentException;

import func.FuncValidarDesconto;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.junit.Assert;

public class CTValidacaoDeDesconto {
	private Desktop desktop = new Desktop();

	@Before
	public void baseState() {
		// Go to web page 'http://demo.cs-cart.com/'
		BrowserBaseState baseState = new BrowserBaseState();
		baseState.execute(desktop);
	}

	@Test
	public void validarDesconto()
			throws HeadlessException, IOException, AWTException, DocumentException, InterruptedException {
		FuncValidarDesconto funcValidarDesconto = new FuncValidarDesconto();

		funcValidarDesconto.validarHome("Step 1 Acessar Home");

		funcValidarDesconto.clicarEmSales("Step 2 Clicar em SALES");

		funcValidarDesconto.validaDesconto("Step 3 Validar desconto");

	}

}
