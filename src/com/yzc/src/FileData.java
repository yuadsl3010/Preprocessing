package com.yzc.src;

import java.util.List;

//���ݼ��ɲ��ֵĳ�����
public abstract class FileData {
	protected String filePath;
	protected Object reader;
	protected int total;
	
	/*
	 * Parameters
	 * _filePath:�ļ�·��
	 * _total:�ļ����ݵ�����
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
