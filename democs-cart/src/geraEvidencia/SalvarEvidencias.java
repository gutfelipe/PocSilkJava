package geraEvidencia;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class SalvarEvidencias {

	HashMap<String, String> caminhoDirEDescricaoStep = new HashMap<String, String>();

	String caminhoDir = System.getProperty("user.dir") + "\\evidencias\\";
	String cenario = "";
	String ct;
	int numeroPrint;

	public SalvarEvidencias(String casoDeTeste) {
		ct = casoDeTeste;
		numeroPrint = 0;
	}

	public void takeScreenshot(String step) throws IOException, HeadlessException, AWTException {
		String caminhoCompleto = String.format("%s%s-%s.png", caminhoDir, ct, numeroPrint);

		caminhoDirEDescricaoStep.put(caminhoCompleto, step);

		BufferedImage image = new Robot()
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image, "png", new File(caminhoCompleto).getCanonicalFile());

		numeroPrint++;
	}

	public void gerarEvidencia() throws DocumentException, MalformedURLException, IOException, InterruptedException {
		Document document = new Document();
		document.setPageSize(PageSize.LETTER.rotate()); // paisagem

		PdfWriter.getInstance(document, new FileOutputStream(caminhoDir + ct + ".pdf"));
		document.open();

		document.add(new Paragraph(ct));

		// Se você tiver um recuo de capítulo
		int indentation = 0;

		for (String caminho : caminhoDirEDescricaoStep.keySet()) {
			String step = caminhoDirEDescricaoStep.get(caminho);

			document.add(new Paragraph(step));

			Image image = Image.getInstance(caminho);

			float scaler = ((document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin()
					- indentation) / image.getWidth()) * 100;

			image.scalePercent(scaler);

			document.add(image);
			document.add(Chunk.NEXTPAGE);
		}
		document.close();
	}
}
