package com.yzc.src;

//坐标数据结构
public class Axis{
	public int order;
	public double x;
	public double y;
	/**
	 * @since 2013-8-14
	 * @param arg0 坐标X
	 * @param arg1 坐标Y
	 * @param _order 序号
	 */
	public Axis(double arg0, double arg1, int _order){
		x = arg0;
		y = arg1;
		order = _order;
	}
}
