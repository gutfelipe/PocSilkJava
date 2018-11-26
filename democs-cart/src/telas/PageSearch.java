package telas;

import org.junit.Assert;

import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomTextField;
import org.junit.Test;

public class PageSearch {
	private Desktop desktop = new Desktop();

	public void clicaPrimeiroProduto() {
		desktop.<DomLink>find("//BrowserApplication//BrowserWindow//A[@textContents='Batman: Arkham City *'][2]")
		.click();		
	}

	public void clicarSegundoProduto() {
		desktop.<DomLink>find("//BrowserApplication//BrowserWindow//A[@textContents='Lord of the Rings: W*']").click();
	}

	public String recuperaValorDesconto() {
		DomElement save = desktop
				.<DomElement>find("//BrowserApplication//BrowserWindow//SPAN[@textContents='Save 41%']");
		return save.getText();
	}

	public String recuperaValorAntigo() {
		DomElement valorAntigo = desktop
				.<DomElement>find("//BrowserApplication//BrowserWindow//SPAN[@id='sec_list_price_148']");
		return valorAntigo.getText();
	}

	public String recuperaValorComDesconto() {
		DomElement valorComDesconto = desktop
				.<DomElement>find("//BrowserApplication//BrowserWindow//SPAN[@textContents='130.00']");
		return valorComDesconto.getText();
	}

}


