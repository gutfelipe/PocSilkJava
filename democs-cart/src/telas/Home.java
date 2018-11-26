package telas;

import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.xbrowser.DomElement;

public class Home {
	private Desktop desktop = new Desktop();

	public String validarHome() {
		DomElement demoStorePanel = desktop.<DomElement>find("demo_cscart_com.BrowserWindow.Demo store panel");
		return demoStorePanel.getText();
	}
	
}
