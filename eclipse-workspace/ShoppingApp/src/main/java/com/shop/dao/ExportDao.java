package com.shop.dao;

import com.shop.dao.ProductDao;
import com.shop.model.Product;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ExportDao {

	private void writeHeaderLine(Sheet sheet) {

		Row headerRow = sheet.createRow(0);

		Cell headerCell = headerRow.createCell(0);
		headerCell.setCellValue("ID");

		headerCell = headerRow.createCell(1);
		headerCell.setCellValue("PRODUCT NAME");

		headerCell = headerRow.createCell(2);
		headerCell.setCellValue("TYPE");

		headerCell = headerRow.createCell(3);
		headerCell.setCellValue("PRICE");

		headerCell = headerRow.createCell(4);
		headerCell.setCellValue("QUANTITY");

		headerCell = headerRow.createCell(5);
		headerCell.setCellValue("CARTID");
	}

	public void exportInExcel() throws FileNotFoundException {
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("Prodotti");
		writeHeaderLine(sheet);
		ProductDao p = new ProductDao();
		List<Product> list = p.getAllProducts();
		int i = 1;

		for (Product r : list) {

			Cell cell;
			String id = String.valueOf(r.getId());
			String tipo = String.valueOf(r.getType().getType());
			String price = String.valueOf(r.getPrice());
			String quan = String.valueOf(r.getQuantity());
			String cId = String.valueOf(r.getCart().getId());
			Row row = sheet.createRow(i);
			cell = row.createCell(0);
			cell.setCellValue(id);
			cell = row.createCell(1);
			cell.setCellValue(r.getName());
			cell = row.createCell(2);
			cell.setCellValue(tipo);
			cell = row.createCell(3);
			cell.setCellValue(price);
			cell = row.createCell(4);
			cell.setCellValue(quan);
			cell = row.createCell(5);
			cell.setCellValue(cId);
			i++;
		}
		OutputStream file = new FileOutputStream("C:\\Users\\chiar\\OneDrive\\Desktop\\ProductsTable.xls");
		try {
			wb.write(file);
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
