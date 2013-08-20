package com.yzc.src;

import java.util.List;

/**
 * 数据变换部分数据聚集的数据结构
 * @author yzc
 */
public class UseGather {
	public List<String[]> data;
	public int[] needGather;
	public String SUM = "SUM";
	public String AVER = "AVER";
	
	/**
	 * @since 2013-8-14
	 * @param _data 需进行数据聚集的数据流
	 * @param _needGather 保存进行数据聚集的数据位置的数组，从0开始
	 */
	public UseGather(List<String[]> _data, 
			String[] _needGather){
		needGather = new int[_needGather.length];
		data = _data;
		for (int i = 0; i < _needGather.length; i++)
			needGather[i] = Integer.valueOf(_needGather[i]);
	}
}
