package com.yzc.src;

public class Nosie implements Comparable{
	public int order;
	public double value;
	public Nosie(int arg0, double arg1){
		order = arg0;
		value = arg1;
	}
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		Nosie tmp = (Nosie) arg0;
		int result = value < tmp.value ? -1 : 1;
		return result;
	}
}
