package telas;

import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomTextField;

public class Cabecalho {
	private Desktop desktop = new Desktop();

	public void preencherPesquisa(String conteudo) {
		desktop.<DomTextField>find("//BrowserApplication//BrowserWindow//INPUT[@id='search_input']").setText(conteudo);
	}
	
	public void clicarCampoPesquisa() {
		desktop.<DomTextField>find("//BrowserApplication//BrowserWindow//INPUT[@id='search_input']").click();
	}
	
	public void clicarBotaoPesquisar() {
		desktop.<DomElement>find("//BrowserApplication//BrowserWindow//I[@class='ty-icon-search']").click();
	}

	public void clicarMyCart() {
		desktop.<DomElement>find("//BrowserApplication//BrowserWindow//I[@class='ty-minicart__icon ty*']").click();
	}

	public void viewMyCart() {
		desktop.<DomLink>find("//BrowserApplication//BrowserWindow//A[@textContents='View cart']").click();		
	}

	public void clicarSales() {
		desktop.<DomLink>find("//BrowserApplication//BrowserWindow//A[@textContents='Sales']").click();
		
	}

}