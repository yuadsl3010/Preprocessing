package com.yzc.src;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据清理部分异常点处理的数据结构
 * @author yzc
 */
public class UseOutlier {
	public List<Axis> listD = new ArrayList<Axis>();
	public int n, k;
	public double cutOff;
	public List<String[]> data;
	public int intX, intY;
	
	/**
	 * @since 2013-8-14
	 * @param _n 孤立点数目
	 * @param _k 每个点的近邻数
	 * @param _cutOff 采用剪枝策略所初定的阀值
	 * @param _data 存储数据的列表
	 * @param _intX 数据流中坐标X的序号，从0开始
	 * @param _intY 数据流中坐标y的序号，从0开始
	 */
	public UseOutlier(String _n, String _k, String _cutOff, List<String[]> _data, String _intX, String _intY){
		n = Integer.valueOf(_n);
		k = Integer.valueOf(_k);
		cutOff = Double.valueOf(_cutOff);
		data = _data;
		intX = Integer.valueOf(_intX);
		intY = Integer.valueOf(_intY);
		for (int i = 0; i < _data.size(); i++)
			listD.add(new Axis(Double.valueOf(_data.get(i)[intX]),
					Double.valueOf(_data.get(i)[intY]),
					i));
	}
}
