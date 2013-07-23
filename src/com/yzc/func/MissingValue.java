package com.yzc.func;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yzc.src.Missing;

public class MissingValue {
	private Map<Integer, String> myData = new HashMap<Integer, String>();
	private Map<Integer, List<Integer>> modify = new HashMap<Integer, List<Integer>>();
	private int[] args;
	private double[] average;
	private int[] total;
	private List<String[]> data;
	public MissingValue() {

	}

	public void init(Missing arg0) {
		args = arg0.parameters;
		average = new double[args.length];
		total = new int[args.length];
		for(int i = 0; i < arg0.intParameters.length; i++)
			myData.put(arg0.intParameters[i], arg0.strParameters[i]);
		data = arg0.listParameters;
	}

	public List<String[]> clean() {
		String tmpString[];
		List<Integer> tmpList = new ArrayList<Integer>();
		try {
			for (int i = 0; i < args.length; i++) {
				average[i] = 0;
				total[i] = 0;
				modify.put(args[i], new ArrayList<Integer>());
			}
			for (int tmpI = 0; tmpI < data.size(); tmpI++) {
				tmpString = data.get(tmpI);
				for (int i = 0; i < tmpString.length; i++){
					if(tmpString[i].length() == 0){
						if(myData.containsKey(i))
							tmpString[i] = myData.get(i);
						else
							modify.get(i).add(tmpI);
					}
				}
				for (int i = 0; i < args.length; i++) {
					if (tmpString[args[i]].length() == 0)
						continue;
					else {
						average[i] += Integer.valueOf(tmpString[args[i]]);
						total[i]++;
					}
				}
			}
			for (int i = 0; i < args.length; i++)
				myData.put(args[i], String.valueOf(average[i] / total[i]));
			for (int i = 0; i < args.length; i++){
				tmpList = modify.get(args[i]);
				for (int tmpInt : tmpList){
					tmpString = data.get(tmpInt);
					tmpString[args[i]] = myData.get(args[i]);
					data.set(tmpInt, tmpString);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
