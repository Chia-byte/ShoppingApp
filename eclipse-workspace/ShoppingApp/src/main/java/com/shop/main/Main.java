package com.shop.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.shop.dao.CartDao;
import com.shop.dao.ExportDao;
import com.shop.model.Product;

public class Main {

	public static EntityManagerFactory emf;
	public static EntityManager em = getEntityManager();

	private static EntityManager getEntityManager() {
		if (null == emf) {
			emf = Persistence.createEntityManagerFactory("ShoppingApp");
		}
		return emf.createEntityManager();
	}

	public static void main(String[] args) throws IOException {
		String dest = "C:\\Users\\chiar\\OneDrive\\Desktop\\Products.pdf";
		PdfWriter writer = new PdfWriter(dest);
		PdfDocument pdfDoc = new PdfDocument(writer);
		Document document = new Document(pdfDoc);
		float[] pointColumnWidths = { 200F, 200F, 200F, 200F, 200F, 200F };
		Table table = new Table(pointColumnWidths);
		em.getTransaction().begin();
		table.addCell(new Cell().add(new Paragraph("ID")));
		table.addCell(new Cell().add(new Paragraph("NOME PRODOTTO")));
		table.addCell(new Cell().add(new Paragraph("TIPO")));
		table.addCell(new Cell().add(new Paragraph("PREZZO")));
		table.addCell(new Cell().add(new Paragraph("QUANTITA")));
		table.addCell(new Cell().add(new Paragraph("ID CARRELLO")));
		List<Product> listap = (List<Product>) em.createQuery("SELECT p FROM Product p").getResultList();
		for (Product p : listap) {
			table.addCell(new Cell().add(new Paragraph(String.valueOf(p.getId()))));
			table.addCell(new Cell().add(new Paragraph(p.getName())));
			table.addCell(new Cell().add(new Paragraph(p.getType().getType())));
			table.addCell(new Cell().add(new Paragraph(String.valueOf(p.getPrice()))));
			table.addCell(new Cell().add(new Paragraph(String.valueOf(p.getQuantity()))));
			table.addCell(new Cell().add(new Paragraph(String.valueOf(p.getCart().getId()))));

		}
		document.add(table);
		document.close();
		em.getTransaction().commit();
		ExportDao ex = new ExportDao();
		ex.exportInExcel();
	}

}