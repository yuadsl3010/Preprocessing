package com.yzc.src;

import java.util.List;

/**
 * ���ݹ�Լ��������ѡ��������ݽṹ
 * @author yzc
 */
public class UseStatute {
	public List<String[]> data;
	public String[] attribute;
	public String path;
	
	/**
	 * @since 2013-8-14
	 * @param _data �洢���ݵ��б�
	 * @param _attribute �洢attribute��ȡֵ
	 * @param _path �洢arff�ļ�·��
	 */
	public UseStatute(List<String[]> _data, String _attribute, String _path){
		data = _data;
		attribute = _attribute.split(";");
		path = _path.substring(0, _path.indexOf(".")) + ".arff";
	}
}
