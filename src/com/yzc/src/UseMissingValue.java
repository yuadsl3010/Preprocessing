package com.yzc.src;

import java.util.List;

/**
 * ���������ֿ�ȱֵ��������ݽṹ
 * @author yzc
 */
public class UseMissingValue {
	public int[] parameters;
	public int[] intParameters;
	public String[] strParameters;
	public List<String[]> listParameters;
	
	/**
	 * @since 2013-8-14
	 * @param _parameters �û�ָ����Ҫƽ��ֵ�Ŀ�ȱֵ��λ�õ����飬������Щ��ȱֵ��Ҫ��ƽ��ֵ�����0��ʼ
	 * @param _intParameters �û�ָ����ҪĬ��ֵ�Ŀ�ȱֵ��λ�õ����飬������Щ��ȱֵ��Ҫ��Ĭ��ֵ�����0��ʼ
	 * @param _strParameters �û�ָ����ҪĬ��ֵ��ֵ�����飬���硰δ֪������Ĭ��ֵ��
	 * @param _listParameters ���ݲ��֣������ݴ�Դ�ļ��г�ȡ����
	 */
	public UseMissingValue(String[] _parameters,
							String[] _intParameters, 
							String[] _strParameters,
							List<String[]> _listParameters){
		parameters = new int[_parameters.length];
		intParameters = new int[_intParameters.length];
		strParameters = new String[_strParameters.length];
		for (int i = 0; i < _parameters.length; i++)
			parameters[i] = Integer.valueOf(_parameters[i]);
		for (int i = 0; i < _intParameters.length; i++)
			intParameters[i] = Integer.valueOf(_intParameters[i]);
		strParameters = _strParameters;
		listParameters = _listParameters;
	}
}
