package telas;

import org.junit.Assert;

import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;

public class Cart{
	private Desktop desktop = new Desktop();


	public boolean validarCarrinho(String item1, String item2) {
		String carrinho1, carrinho2;
		
		DomLink lordOfTheRingsWA = desktop
				.<DomLink>find("//BrowserApplication//BrowserWindow//A[@textContents='Lord of the Rings: W*']");
		carrinho1 = lordOfTheRingsWA.getText();

		DomLink batmanArkhamCityA = desktop
				.<DomLink>find("//BrowserApplication//BrowserWindow//A[@textContents='Batman: Arkham City *']");
		carrinho2 = batmanArkhamCityA.getText();
		
		if ((item1.equals(carrinho2)) && (item2.equals(carrinho1))) {
			return true;
		}
		else return false;
	}



	
	
}


