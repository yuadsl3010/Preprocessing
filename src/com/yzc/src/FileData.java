package com.yzc.src;

import java.util.List;

//数据集成部分的抽象类
public abstract class FileData {
	protected String filePath;
	protected Object reader;
	protected int total;
	
	/*
	 * Parameters
	 * _filePath:文件路径
	 * _total:文件数据的列数
	 */
	/**
	 * @since 2013-8-14
	 * @param data
	 */
	public FileData(UseIntegration data) {
		filePath = data.filePath;
		total = data.total;
		setReader();
	}
	public abstract List<String[]> getData();
	protected abstract void close() throws Exception;
	protected abstract void setReader();
}
