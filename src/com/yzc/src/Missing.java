package com.yzc.src;

import java.util.List;

//数据清理部分的空缺值处理数据结构
public class Missing {
	public int[] parameters;
	public int[] intParameters;
	public String[] strParameters;
	public List<String[]> listParameters;
	
	/*parameters
	 * arg0:用户指定需要平均值的空缺值的位置的数组，比如哪些空缺值需要用平均值填补，从0开始
	 * arg1:用户指定需要默认值的空缺值的位置的数组，比如哪些空缺值需要用默认值填补，从0开始
	 * arg2:用户指定需要默认值的值的数组，比如“未知”，“默认值”
	 * arg3:数据部分，将数据从源文件中抽取出来
	 * */
	public Missing(int[] arg0, int[] arg1, String[] arg2, List<String[]> arg3){
		parameters = arg0;
		intParameters = arg1;
		strParameters = arg2;
		listParameters = arg3;
	}
}
