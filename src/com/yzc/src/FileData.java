package com.yzc.src;

import java.util.List;

public abstract class FileData {
	protected String filePath;
	protected Object reader;
	protected int total;//π≤”–total¡–
	public FileData(String _filePath, int _total) {
		filePath = _filePath;
		total = _total;
		setReader();
	}
	public abstract List<String[]> getData();
	protected abstract void close() throws Exception;
	protected abstract void setReader();
}
