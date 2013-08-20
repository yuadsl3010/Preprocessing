package com.yzc.itg;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.yzc.src.FileData;
import com.yzc.src.UseIntegration;

public class ReadXLSX extends FileData {

	public ReadXLSX(UseIntegration data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @since 2013-8-14
	 * @throws нч
	 * @see com.yzc.src.FileData#getData()
	 */
	@Override
	public List<String[]> getData() {
		// TODO Auto-generated method stub
		XSSFWorkbook tmpReader = (XSSFWorkbook) reader;
		List<String[]> tmpList = new ArrayList<String[]>();
		XSSFSheet sheet;
		String[] tmpStr;
		try {
			for (int sheetN = 0; sheetN < tmpReader.getNumberOfSheets(); sheetN++) {
				sheet = tmpReader.getSheetAt(sheetN);
				if (sheet == null)
					continue;
				for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
					tmpStr = new String[total];
					XSSFRow xRow = sheet.getRow(i);
					if (xRow == null)
						continue;
					for (int j = 0; j < total; j++){
						XSSFCell xCell = xRow.getCell(j);
						if(xCell == null){
							tmpStr[j] = "";
							continue;
						}
						xCell.setCellType(Cell.CELL_TYPE_STRING);
						tmpStr[j] = xRow.getCell(j).getStringCellValue();
					}
					tmpList.add(tmpStr);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmpList;
	}

	@Override
	protected void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Reader is closing...");
	}

	@Override
	protected void setReader() {
		// TODO Auto-generated method stub
		try {
			reader = (XSSFWorkbook) new XSSFWorkbook(new FileInputStream(filePath));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
