package com.yzc.src;

/**
 * ���ݼ��ɲ��ֵ����ݽṹ
 * @author yzc
 */
public class UseIntegration {
	public String filePath;
	public int total;
	
	/**
	 * @since 2013-8-14
	 * @param _filePath �ļ�·��
	 * @param _total �ļ���������
	 */
	public UseIntegration(String _filePath, String _total){
		filePath = _filePath;
		total = Integer.valueOf(_total);
	}
}
