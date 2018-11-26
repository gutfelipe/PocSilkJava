package carregarMassa;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CarregarJsonCTValidacaoDeCarrinho {

	String caminhoDir = System.getProperty("user.dir") + "\\src\\massaDeDados\\";

	private String pesquisa1;
	private String pesquisa2;
	
	public CarregarJsonCTValidacaoDeCarrinho() {
		lerJson();
	}

	private void lerJson() {

		JSONObject jsonObject;
		// Cria o parse de tratamento
		JSONParser parser = new JSONParser();
		// Variaveis que irao armazenar os dados do arquivo JSON

		try {
			// Salva no objeto JSONObject o que o parse tratou do arquivo
			jsonObject = (JSONObject) parser.parse(new FileReader(caminhoDir + "MassaCTValidacaoDeCarrinho.json"));

			// Salva nas variaveis os dados retirados do arquivo
			pesquisa1 = (String) jsonObject.get("pesquisa1");
			pesquisa2 = (String) jsonObject.get("pesquisa2");
		}
		// Trata as exceptions que podem ser lançadas no decorrer do processo
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public String getPesquisa1() {
		return pesquisa1;
	}
	
	public String getPesquisa2() {
		return pesquisa2;
	}

}
