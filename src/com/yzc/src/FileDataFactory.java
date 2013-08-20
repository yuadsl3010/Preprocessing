package com.yzc.src;

import java.lang.reflect.Constructor;

//数据集成部分数据类的工厂
public class FileDataFactory {

	public FileDataFactory() {
	}

	/**
	 * @since 2013-8-14
	 * @throws 无
	 * @param data
	 * @return
	 * FileData
	 */
	public static FileData createReader(UseIntegration data) {
		String fileExtention = getExtention(data.filePath);
		try {
			Class<?> c = Class.forName("com.yzc.itg.Read"
					+ fileExtention);
			Class<?>[] pType = new Class[] { UseIntegration.class };
			Constructor<?> con = c.getConstructor(pType);
			return (FileData) con.newInstance(new Object[] { data });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String getExtention(String _fileName) {
		// TODO Auto-generated method stub
		return _fileName.substring(_fileName.indexOf(".") + 1).toUpperCase();
	}
}
