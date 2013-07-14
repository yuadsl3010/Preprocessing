package com.yzc.func;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.yzc.cp.AxisComparator;
import com.yzc.src.Axis;

public class Outlier {
	
	public Outlier(){
		
	}
	
	private List<Axis> listD = new ArrayList<Axis>();	//�������ݼ�
	private int n, k, lenListD = 0;	//�������û����õĲ��� n����������Ŀ��k��ÿ����Ľ�������
	//lenListDΪlistD�ļ�����
	private double cutOff;	//���ü�֦�����������ķ�ֵ
	
	public void init(int arg0, int arg1, int arg2){
		n = arg0;
		k = arg1;
		cutOff = arg2;
	}
	
	public void insert(Axis arg0){
		listD.add(arg0);
	}
	
	//Bay����Ļ��ڼ�֦���쳣�����㷨
	public List<Axis> findOutlier(){
		List<Axis> listB = new ArrayList<Axis>();
		List<Axis> listO = new ArrayList<Axis>();
		while(null != (listB = getNextBlock(5))){
			List<Axis> listN = new ArrayList<Axis>();
			for(int i = 0; i < listD.size(); i++){
				for(int j = 0; j < listB.size(); j++){
					if(listB.get(j).equals(listD.get(i)))
							continue;
					if(listN.size() < k || distance(listD.get(i), listB.get(j)) < maxDist(listB.get(j), listN)){
						listN = closest(listB.get(j), union(listN, listD.get(i)), k);
						double tmpScore = score(listN, listB.get(j));
						if(tmpScore < cutOff)
							listB.remove(j);
					}
				}
			}
			listO = top(union(listB, listO), n);
			if(listO.size() > 0){
				int i = 0;
				double[] outlierScore = new double[listO.size()];
				for(Axis axis : listO){
					List<Axis> tmpList = new ArrayList<Axis>();
					tmpList = closest(axis, listD, k);
					outlierScore[i] = score(tmpList, axis);
					i++;
				}
				cutOff = minScore(outlierScore);
			}
		}
		return listO;
	}
	
	//�Ӽ�����˳��ȡ��һ����ʵ����arg0������������������Ĭ��Ϊ1
	private List<Axis> getNextBlock(int arg0){
		List<Axis> tmpList = new ArrayList<Axis>();
		if((lenListD + arg0) > listD.size() && lenListD < listD.size()){
			for(int i = lenListD; i < listD.size(); i++)
				tmpList.add(listD.get(lenListD));
			lenListD = listD.size();
			return tmpList;
		}
		else if(lenListD == listD.size())
			return null;
		for(int i = 0; i < arg0; i++)
			tmpList.add(listD.get(i + lenListD));
		lenListD += arg0;
		return tmpList;
	}
	
	//��ʵ���������
	private double distance(Axis arg0, Axis arg1){
		return Math.sqrt(Math.pow(arg0.x - arg1.x, 2) + Math.pow(arg0.y - arg1.y, 2));
	}
	
	//��������ʵ����Զ�ľ���
	private double maxDist(Axis arg0, List<Axis> arg1){
		double result = 0;
		for(int i = 0; i < arg1.size(); i++)
			result = distance(arg0, arg1.get(i)) > result ? distance(arg0, arg1.get(i)) : result;
		return result;
	}
	
	//��������ʵ�������ʵ������
	private List<Axis> closest(Axis arg0, List<Axis> arg1, int arg2){
		List<Axis> tmpList = new ArrayList<Axis>();
		Axis[] tmpAxis = new Axis[arg1.size()];
		Axis[] result = new Axis[arg2];
		for(int i = 0; i < arg1.size(); i++){
			tmpAxis[i] = arg1.get(i);
		}
		Arrays.sort(tmpAxis, new AxisComparator(arg0));
		for(int i = 0; i < (arg2 > tmpAxis.length ? tmpAxis.length : arg2); i++)
			tmpList.add(tmpAxis[i]);
		return tmpList;
	}
	
	//����һ��������һ��ʵ��/���ϵĲ���
	private List<Axis> union(List<Axis> arg0, Axis arg1){
		if(arg0.size() == 0){
			List<Axis> result = new ArrayList<Axis>();
			result.add(arg1);
			return result;
		}
		for(Axis axis : arg0){
			if(axis.equals(arg1))
				return arg0;
		}
		arg0.add(arg1);
		return arg0;
	}
	
	private List<Axis> union(List<Axis> arg0, List<Axis> arg1){
		if(arg0.size() == 0)
			return arg1;
		else if(arg1.size() == 0)
			return arg0;
		for(Axis axis1 : arg0){
			for(int i = 0; i < arg1.size(); i++){
				if(axis1.equals(arg1.get(i)))
					break;
				else if(i == arg1.size() - 1)
					arg1.add(axis1);
			}
		}
		return arg1;
	}
	
	//�÷ֺ���
	private double score(List<Axis> arg0, Axis arg1){
		double maxX = arg1.x, minX = arg1.x, maxY = arg1.y, minY = arg1.y;
		for(Axis axis : arg0){
			maxX = maxX > axis.x ? maxX : axis.x;
			minX = minX < axis.x ? minX : axis.x;
			maxY = maxY > axis.y ? maxY : axis.y;
			minY = minY < axis.y ? minY : axis.y;
		}
		double valX, valY, oDist = 0;
		for(Axis axis : arg0){
			valX = Math.pow(Math.abs((arg1.x - axis.x)/* / (maxX - minX)*/), 2);
			valY = Math.pow(Math.abs((arg1.y - axis.y)/* / (maxY - minY)*/), 2);
			oDist = Math.sqrt(valX + valY);
		}
		double result = oDist / arg0.size();
		return result;
	}
	
	//���Ʒ��ع�����ĸ���
	private List<Axis> top(List<Axis> arg0, int arg1){
		if(arg0.size() == 0)
			return arg0;
		List<Axis> result = new ArrayList<Axis>();
		for(int i = 0; i < (arg1 > arg0.size() ? arg0.size() : arg1); i++)
			result.add(arg0.get(i));
		return result;
	}

	//���ع���������С�ĵ÷�
	private double minScore(double[] arg0){
		Arrays.sort(arg0);
		return arg0[0];
	}
}
