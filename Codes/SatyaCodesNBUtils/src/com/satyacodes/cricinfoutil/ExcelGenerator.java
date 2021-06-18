package com.satyacodes.cricinfoutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.scheduling.annotation.Async;



/***
 * 
 * //Name Country Matches Inngs. NotOuts Runs 50s 100s Best Avg Str 1 2 3 4 5 6
 * 7 8 9 10 11
 * 
 * Bow. Inngs Wickets 5Wick Best Avg Str Econ Prof.Id PicUrl 4w // 12 13 14 15
 * 16 17 18 19 20 21
 * 
 * 
 * 
 * 
 * @author KavetiS
 *
 */

public class ExcelGenerator {

	public static void playersExcelGenerator(List<PlayerInfo> playersList, String fileName) throws Exception {

		final String[] columns = { "Name", "Country", "Matches", "Inngs.", "NotOuts", "Runs", " 50s ", "100s ", "Best ",
				"Avg ", "Str ",

				"Bow. Inngs", "Wickets ", "5Wick ", "Best ", "Avg ", " Str", "Econ ", " Prof.Id", "Pic ", "4Wick" };

		// Create a Workbook
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		// Create a Sheet
		Sheet sheet = workbook.createSheet(fileName);

		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		// Create a Row
		Row headerRow = sheet.createRow(0);

		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}

		// Create Other rows and cells with playersList data
		// (float)(Math.round( * 100.0) / 100.0);
		int rowNum = 1;
		for (PlayerInfo player : playersList) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(player.getName());
			row.createCell(1).setCellValue(player.getCountry());
			row.createCell(2).setCellValue(player.getMat());
			row.createCell(3).setCellValue(player.getBatIngs());
			row.createCell(4).setCellValue(player.getNotouts());
			row.createCell(5).setCellValue(player.getRuns());
			row.createCell(6).setCellValue(player.getFiftys());
			row.createCell(7).setCellValue(player.getHundrds());
			row.createCell(8).setCellValue(player.getHigh());
			row.createCell(9).setCellValue((float) (Math.round(player.getBatAvg() * 100.0) / 100.0));
			row.createCell(10).setCellValue((float) (Math.round(player.getBatStr() * 100.0) / 100.0));

			row.createCell(11).setCellValue(player.getBowIngs());
			row.createCell(12).setCellValue(player.getWik());
			row.createCell(13).setCellValue(player.getWik5());
			row.createCell(14).setCellValue(player.getBowBest());
			row.createCell(15).setCellValue((float) (Math.round(player.getBowAvg() * 100.0) / 100.0));
			row.createCell(16).setCellValue((float) (Math.round(player.getBatStr() * 100.0) / 100.0));
			row.createCell(17).setCellValue((float) (Math.round(player.getEcon() * 100.0) / 100.0));

			row.createCell(18).setCellValue(player.getProfileId());
			row.createCell(19).setCellValue(player.getPic());
			row.createCell(20).setCellValue(player.getWik4());

		}

		// Resize all columns to fit the content size
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream(fileName);
		workbook.write(fileOut);
		fileOut.close();
	}

	public static void excelRowToPlayerInfo(String xlsInput, String tableName) throws Exception {

		FileInputStream inputStream = new FileInputStream(new File(xlsInput));

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();
		int i =0;

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			if (nextRow.getRowNum() == 0) {
				System.out.println(" *********** Skipping Column Row[0] From Excel ***************");
				continue; // just skip the rows if row number is 0 or 1
			}

			Iterator<Cell> cellIterator = nextRow.cellIterator();
			PlayerInfo p = new PlayerInfo();

			while (cellIterator.hasNext()) {
				Cell nextCell = cellIterator.next();
				int columnIndex = nextCell.getColumnIndex();
				switch (columnIndex) {
				case 0:
					p.setName(getCellValue(nextCell).toString());
					break;
				case 1:
					p.setCountry(getCellValue(nextCell).toString());
					break;
				case 2:
					p.setMat( (int)Math.round( ((Double) getCellValue(nextCell))) );
					break;
				case 3:
					p.setBatIngs((int)Math.round( (Double) getCellValue(nextCell)) );
					break;
				case 4:
					p.setNotouts((int)Math.round( (Double) getCellValue(nextCell)) );
					break;

				case 5:
					p.setRuns((int)Math.round( (Double) getCellValue(nextCell)) );
					break;
				case 6:
					p.setFiftys((int)Math.round( (Double) getCellValue(nextCell)) );
					break;
				case 7:
					p.setHundrds((int)Math.round( (Double) getCellValue(nextCell)) );
					break;
				case 8:
					p.setHigh((int)Math.round( (Double) getCellValue(nextCell)) );
					break;
				case 9:
					p.setBatAvg(Float.parseFloat(getCellValue(nextCell).toString()));
					break;

				case 10:
					p.setBatStr(Float.parseFloat(getCellValue(nextCell).toString()));
					break;
				case 11:
					p.setBowIngs((int)Math.round( (Double) getCellValue(nextCell)) );
					break;
				case 12:
					p.setWik((int)Math.round( (Double) getCellValue(nextCell)) );
					break;
				case 13:
					p.setWik5((int)Math.round( (Double) getCellValue(nextCell)) );
					break;
				case 14:
					p.setBowBest((getCellValue(nextCell).toString()));
					break;
				case 15:
					p.setBowAvg(Float.parseFloat(getCellValue(nextCell).toString()));
					break;
				case 16:
					p.setBowStr(Float.parseFloat(getCellValue(nextCell).toString()));
					break;
				case 17:
					p.setEcon(Float.parseFloat(getCellValue(nextCell).toString()));
					break;
				case 18:
					p.setProfileId((int)Math.round( (Double) getCellValue(nextCell)) );
					break;

				case 19:
					p.setPic((getCellValue(nextCell).toString()));
					break;

				case 20:
					p.setWik4((int)Math.round( (Double) getCellValue(nextCell)) );
					break;

				}

			}

			i++;
			System.out.println(i+" -->> Saving Player Object : "+p.getProfileId());
			StatsDBMain.savePlayer(p, tableName);
			
			
		}

		inputStream.close();

	}

	private static Object getCellValue(Cell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();

		case Cell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue();

		case Cell.CELL_TYPE_NUMERIC:
			return cell.getNumericCellValue();
		}

		return null;
	}
	
	
	
	
	
	@Async
	public static void playersExcelGeneratorGUI(List<PlayerInfo> playersList, String fileName,JProgressBar progressLabel ) throws Exception {

		final String[] columns = { "Name", "Country", "Matches", "Inngs.", "NotOuts", "Runs", " 50s ", "100s ", "Best ",
				"Avg ", "Str ",

				"Bow. Inngs", "Wickets ", "5Wick ", "Best ", "Avg ", " Str", "Econ ", " Prof.Id", "Pic ", "4Wick" };

		// Create a Workbook
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		// Create a Sheet
		Sheet sheet = workbook.createSheet("Stats");

		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		// Create a Row
		Row headerRow = sheet.createRow(0);

		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}

		// Create Other rows and cells with playersList data
		// (float)(Math.round( * 100.0) / 100.0);
		int rowNum = 1;
		int listSize = playersList.size();
		for (PlayerInfo player : playersList) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(player.getName());
			row.createCell(1).setCellValue(player.getCountry());
			row.createCell(2).setCellValue(player.getMat());
			row.createCell(3).setCellValue(player.getBatIngs());
			row.createCell(4).setCellValue(player.getNotouts());
			row.createCell(5).setCellValue(player.getRuns());
			row.createCell(6).setCellValue(player.getFiftys());
			row.createCell(7).setCellValue(player.getHundrds());
			row.createCell(8).setCellValue(player.getHigh());
			row.createCell(9).setCellValue((float) (Math.round(player.getBatAvg() * 100.0) / 100.0));
			row.createCell(10).setCellValue((float) (Math.round(player.getBatStr() * 100.0) / 100.0));

			row.createCell(11).setCellValue(player.getBowIngs());
			row.createCell(12).setCellValue(player.getWik());
			row.createCell(13).setCellValue(player.getWik5());
			row.createCell(14).setCellValue(player.getBowBest());
			row.createCell(15).setCellValue((float) (Math.round(player.getBowAvg() * 100.0) / 100.0));
			row.createCell(16).setCellValue((float) (Math.round(player.getBatStr() * 100.0) / 100.0));
			row.createCell(17).setCellValue((float) (Math.round(player.getEcon() * 100.0) / 100.0));

			row.createCell(18).setCellValue(player.getProfileId());
			row.createCell(19).setCellValue(player.getPic());
			row.createCell(20).setCellValue(player.getWik4());
			
			progressLabel.setValue((rowNum/listSize)*100);

		}

		// Resize all columns to fit the content size
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream(fileName);
		workbook.write(fileOut);
		fileOut.close();
	}

	public static void main(String[] args) {
		try {
			excelRowToPlayerInfo("cric.xlsx", "odistats");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
