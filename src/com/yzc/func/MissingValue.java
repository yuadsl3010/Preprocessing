package com.yzc.func;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yzc.src.UseMissingValue;

//数据清理部分的空缺值处理
public class MissingValue {
	private Map<Integer, String> myData = new HashMap<Integer, String>();
	private Map<Integer, List<Integer>> modify = new HashMap<Integer, List<Integer>>();
	private int[] args;
	private double[] average;
	private int[] total;
	private List<String[]> result;
	public MissingValue() {

	}

	/**
	 * @since 2013-8-14
	 * @throws 无
	 * @param data 数据格式为UseMissingValue
	 * @return 返回经过空缺值处理的数据流
	 * List<String[]>
	 */
	public List<String[]> getResult(UseMissingValue data) {
		args = data.parameters;
		average = new double[args.length];
		total = new int[args.length];
		for(int i = 0; i < data.intParameters.length; i++)
			myData.put(data.intParameters[i], data.strParameters[i]);
		result = data.listParameters;
		return clean();
	}

	private List<String[]> clean() {
		String tmpString[];
		List<Integer> tmpList = new ArrayList<Integer>();
		try {
			for (int i = 0; i < args.length; i++) {
				average[i] = 0;
				total[i] = 0;
				modify.put(args[i], new ArrayList<Integer>());
			}
			for (int tmpI = 0; tmpI < result.size(); tmpI++) {
				tmpString = result.get(tmpI);
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
					tmpString = result.get(tmpInt);
					tmpString[args[i]] = myData.get(args[i]);
					result.set(tmpInt, tmpString);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
