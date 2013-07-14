package com.yzc.cp;

import java.util.Comparator;

import com.yzc.src.Axis;

public class AxisComparator implements Comparator<Axis> {
	private Axis point;
	public AxisComparator(Axis arg0){
		point = arg0;
	}
	@Override
	public int compare(Axis arg0, Axis arg1) {
		// TODO Auto-generated method stub
		double val1 = Math.sqrt(Math.pow(arg0.x - point.x, 2) + Math.pow(arg0.y - point.y, 2));
		double val2 = Math.sqrt(Math.pow(arg1.x - point.x, 2) + Math.pow(arg1.y - point.y, 2));
		return val1 < val2 ? 1 : (val1 == val2 ? 0 : -1);
	}

}
