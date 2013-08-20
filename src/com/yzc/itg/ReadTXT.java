package com.yzc.itg;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import com.yzc.src.FileData;
import com.yzc.src.UseIntegration;

public class ReadTXT extends FileData {
	private String split = "\t";
	public ReadTXT(UseIntegration data) {
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
		String tmpLine = "";
		RandomAccessFile tmpReader = (RandomAccessFile) reader;
		List<String[]> tmpList = new ArrayList<String[]>();
		String[] tmpStr;
		try {
			while (null != (tmpLine = tmpReader.readLine())) {
				tmpStr = tmpLine.split(split);
				if (tmpStr.length < total){
					String[] tmpStrMod = new String[total];
					for (int i = 0; i < tmpStr.length; i++)
						tmpStrMod[i] = tmpStr[i];
					for (int i = tmpStr.length; i < total; i++)
						tmpStrMod[i] = "";
					tmpList.add(tmpStrMod);
				}
				else
					tmpList.add(tmpStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tmpList;
	}

	@Override
	protected void setReader() {
		// TODO Auto-generated method stub
		try {
			reader = new RandomAccessFile(filePath, "r");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Reader is closing...");
		((RandomAccessFile) reader).close();
	}
}
