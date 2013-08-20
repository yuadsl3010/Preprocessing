package com.yzc.src;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据清理部分噪声处理的数据结构
 * @author yzc
 */
public class UseNosieProcessing {
	public int length;
	public List<Double> list= new ArrayList<Double>();
	public int select;
	public int order;
	public List<String[]> data;
	
	/**
	 * @since 2013-8-14
	 * @param _length 用户设置的参数，用于控制箱的大小
	 * @param _select 用户选择的方法。0--平均值；1--中值；2--边界值
	 * @param _data 源数据流
	 * @param _order 源数据流需要噪声处理的列数，从0开始
	 */
	public UseNosieProcessing(String _length, 
								String _select, 
								List<String[]> _data, 
								String _order){
		order = Integer.valueOf(_order);
		data = _data;
		length = Integer.valueOf(_length);
		for (String[] tmpStrS : _data)
			list.add(Double.valueOf(tmpStrS[order]));
		select = Integer.valueOf(_select);
	}
}
