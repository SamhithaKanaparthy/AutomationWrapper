package com.liberate.automation.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/***
 * Class to load data from Excel Data sheet present in in Resources directory
 * with name "DataSheet.xlsx"<br>
 * Data should be available in 'sheet1' and first column will be the field name
 * and 2nd column will be data value.
 * 
 * 
 *
 */
public class ExcelDataDriver {
	private static File file;
	private static FileInputStream inputStream;
	private static XSSFWorkbook workBook;
	private static XSSFSheet sheet;

	static boolean initialized = false;

	static {
		try {
			file = new File("Resources//DataSheet.xlsx");
			inputStream = new FileInputStream(file);

			workBook = new XSSFWorkbook(inputStream);
		} catch (IOException e) {
			initialized = false;
			e.printStackTrace();
		}

		initialized = true;
	}

	private ExcelDataDriver() {
		// Disabling constructor
	}

	/***
	 * Method to load data from Excel Data sheet present in in Resources directory
	 * with name "DataSheet.xlsx" as HashMap<br>
	 * Data from 'sheet1' will be retrieved as a HashMap where first column will be
	 * the key and 2nd column will be value.
	 * 
	 * @return a HashMap with variable data
	 */
	public static Map<String, String> loadData() {
		Map<String, String> dataMap = new HashedMap<>();

		String key, value;
		int count = 0;

		sheet = workBook.getSheet("DataSheet");

		while (true) {
			try {
				sheet.getRow(count).getCell(0).setCellType(CellType.STRING);
				key = sheet.getRow(count).getCell(0).getStringCellValue().trim();
			} catch (NumberFormatException ex) {
				key = sheet.getRow(count).getCell(0).getNumericCellValue() + "";
			} catch (Exception e) {
				key = "";
			}
			try {
				sheet.getRow(count).getCell(1).setCellType(CellType.STRING);
				value = sheet.getRow(count).getCell(1).getStringCellValue().trim();
			} catch (NumberFormatException ex) {
				value = sheet.getRow(count).getCell(1).getNumericCellValue() + "";
			} catch (Exception e) {
				value = "";
			}

			count++;
			if (key.equals(""))
				break;
			else
				dataMap.put(key, value);
		}

		return dataMap;
	}
}
