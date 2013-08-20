package com.yzc.src;

//数据清理部分的噪声处理中间数据的数据结构
public class Nosie implements Comparable{
	public int order;
	public double value;
	/* 
	 * Parameters
	 * arg0:序号，从0开始
	 * arg1:值
	 */
	public Nosie(int arg0, double arg1){
		order = arg0;
		value = arg1;
	}
	//排序比较器
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		Nosie tmp = (Nosie) arg0;
		int result = value < tmp.value ? -1 : 1;
		return result;
	}
}
