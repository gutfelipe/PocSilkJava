package telas;

import org.junit.Assert;

import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;

public class PaginaDoProduto {
	private Desktop desktop = new Desktop();

	public String NomeDoProdutoum() {
		DomElement batmanArkhamCity = desktop
				.<DomElement>find("//BrowserApplication//BrowserWindow//BDI[@textContents='Batman: Arkham City *'][2]");		
		return batmanArkhamCity.getText();
	}

	public void AdicionarAoCarrinho() {
		desktop.<DomButton>find("//BrowserApplication//BrowserWindow//BUTTON[@textContents='Add to cart']").click();
	}

	public void eContinuar() {
		desktop.<DomLink>find("//BrowserApplication//BrowserWindow//A[@textContents='Continue shopping']").click();
	}

	public String NomeDoProdutodois() {
		DomElement lordOfTheRingsW = desktop
				.<DomElement>find("//BrowserApplication//BrowserWindow//BDI[@textContents='Lord of the Rings: W*'][2]");
		return lordOfTheRingsW.getText();
	}

}
