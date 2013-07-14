package com.yzc.main;

import java.util.List;

import com.yzc.func.NosieProcessing;
import com.yzc.func.Outlier;
import com.yzc.src.Axis;

public class DO {
	public static void main(String[] args){
		NosieProcessing np = new NosieProcessing();
		np.init(4);
		np.insert(1);
		np.insert(1);
		np.insert(2);
		np.insert(1);
		np.insert(3);
		np.insert(4);
		np.insert(5);
		np.insert(6);
		np.insert(1);
		np.insert(2);
		np.insert(1);
		np.nosieProcessing(2);
	}
}
