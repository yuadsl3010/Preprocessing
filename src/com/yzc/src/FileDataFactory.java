package com.yzc.src;

import java.lang.reflect.Constructor;

public class FileDataFactory {

	public FileDataFactory() {
	}

	public static FileData createReader(String _fileName, int _total) {
		String fileExtention = getExtention(_fileName);
		try {
			Class<?> c = Class.forName("com.yzc.itg.Read"
					+ fileExtention);
			Class<?>[] pType = new Class[] { String.class, int.class };
			Constructor<?> con = c.getConstructor(pType);
			return (FileData) con.newInstance(new Object[] { _fileName, _total });
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
