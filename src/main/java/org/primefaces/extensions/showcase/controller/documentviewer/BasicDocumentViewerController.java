package org.primefaces.extensions.showcase.controller.documentviewer;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@Named
@SessionScoped
public class BasicDocumentViewerController implements Serializable {

	private static final long serialVersionUID = 1L;

    private StreamedContent content;

	public void onPrerender(ComponentSystemEvent event) {

		try {

			ByteArrayOutputStream out = new ByteArrayOutputStream();

			Document document = new Document();
			PdfWriter.getInstance(document, out);
			document.open();

			for (int i = 0; i < 50; i++) {
				document.add(new Paragraph("All work and no play makes Jack a dull boy"));
			}

			document.close();
			content = new DefaultStreamedContent(new ByteArrayInputStream(out.toByteArray()), "application/pdf");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public StreamedContent getContent() {
		return content;
	}

	public void setContent(StreamedContent content) {
		this.content = content;
	}
}
