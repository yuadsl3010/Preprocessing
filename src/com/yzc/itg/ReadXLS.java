package com.yzc.itg;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jxl.Sheet;
import jxl.Workbook;
import com.yzc.src.FileData;
import com.yzc.src.UseIntegration;

public class ReadXLS extends FileData {
	
	public ReadXLS(UseIntegration data) {
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
		Workbook tmpReader = (Workbook) reader;
		Sheet sheet;
		List<String[]> tmpList = new ArrayList<String[]>();
		String[] tmpStr;
		try{
			for(int sheetN = 0; sheetN < tmpReader.getNumberOfSheets(); sheetN++){
				sheet = tmpReader.getSheet(sheetN);
				if(sheet == null)
					continue;
				for(int i = 0; i < sheet.getRows(); i++){
					tmpStr = new String[total];
					for(int j = 0; j < total; j++)
						tmpStr[j] = sheet.getCell(j, i).getContents();
					if(tmpStr.length == 0)
						continue;
					tmpList.add(tmpStr);
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return tmpList;
	}

	@Override
	protected void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Reader is closing...");
		((Workbook) reader).close();
	}

	@Override
	protected void setReader() {
		// TODO Auto-generated method stub
		try{
			reader = (Workbook) Workbook.getWorkbook(new File(filePath));
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
