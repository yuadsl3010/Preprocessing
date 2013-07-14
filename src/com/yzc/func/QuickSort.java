package com.yzc.func;

public class QuickSort{
	public void sort(double[] arg0, int arg1, int arg2){//arg1:left;arg2:right
		int p = arg1;
		double key = arg0[p];
		int left = arg1;
		int right = arg2;
		while(left < right){
			while(right > p && arg0[right] > key)
				right--;
			if(right > p){
				double tmp = arg0[right];
				arg0[right] = arg0[p];
				arg0[p] = tmp;
			}
		}
	}
}
