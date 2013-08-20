package com.yzc.src;

import java.util.List;

/**
 * 数据清理部分空缺值处理的数据结构
 * @author yzc
 */
public class UseMissingValue {
	public int[] parameters;
	public int[] intParameters;
	public String[] strParameters;
	public List<String[]> listParameters;
	
	/**
	 * @since 2013-8-14
	 * @param _parameters 用户指定需要平均值的空缺值的位置的数组，比如哪些空缺值需要用平均值填补，从0开始
	 * @param _intParameters 用户指定需要默认值的空缺值的位置的数组，比如哪些空缺值需要用默认值填补，从0开始
	 * @param _strParameters 用户指定需要默认值的值的数组，比如“未知”，“默认值”
	 * @param _listParameters 数据部分，将数据从源文件中抽取出来
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
