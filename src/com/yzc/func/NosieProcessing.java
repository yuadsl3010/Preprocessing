package com.yzc.func;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.yzc.src.Nosie;

public class NosieProcessing {
	public NosieProcessing(){
		
	}
	
	private int length;	//用户设置的参数，用于控制箱的大小
	private List<Double> list = new ArrayList<Double>();
	
	public void init(int arg0){
		length = arg0;
	}
	
	public void insert(double arg0){
		list.add(arg0);
	}
	
	public void nosieProcessing(int arg0){
		Nosie[] tmpList = new Nosie[list.size()];
		for(int i = 0; i < list.size(); i++)
			tmpList[i] = new Nosie(i, list.get(i));
		Arrays.sort(tmpList);
		int box = (list.size() - list.size() % length) / length + 1;
		switch(arg0){
		case 0:	//平均值
			func1(tmpList, box);
			for(double tmpp : list)
				System.out.print(tmpp + " ");
			System.out.println("Done!");
			break;
		case 1: //中值
			func2(tmpList, box);
			for(double tmpp : list)
				System.out.print(tmpp + " ");
			System.out.println("Done!");
			break;
		case 2: //边界值
			func3(tmpList, box);
			for(double tmpp : list)
				System.out.print(tmpp + " ");
			System.out.println("Done!");
			break;
		}
	}
	
	private void func1(Nosie[] arg0, int arg1){
		double tmpValue;
		for(int i = 0; i < arg1 - 1; i++){
			tmpValue = 0;
			for(int j = 0; j < length; j++)
				tmpValue += arg0[i * length + j].value;
			tmpValue /= length;
			for(int j = 0; j < length; j++)
				list.set(arg0[i * length + j].order, tmpValue);
		}
		tmpValue = 0;
		for(int i = 0; i < list.size() % length; i++){
			tmpValue += arg0[(arg1 - 1) * length + i].value;
		}
		tmpValue /= list.size() % length;
		for(int i = 0; i < list.size() % length; i++){
			list.set(arg0[(arg1 - 1) * length + i].order, tmpValue);
		}
	}
	
	private void func2(Nosie[] arg0, int arg1){
		double tmpValue;
		int mid = 0;
		if(length % 2 == 0)
			mid = length / 2;
		else
			mid = (length + 1) / 2;
		for(int i = 0; i < arg1 - 1; i++){
			tmpValue = arg0[i * length + mid].value;
			for(int j = 0; j < length; j++)
				list.set(arg0[i * length + j].order, tmpValue);
		}
		tmpValue = 0;
		if((list.size() % length) % 2 == 0)
			mid = (list.size() % length) / 2;
		else
			mid = (list.size() % length + 1) / 2;
		tmpValue = arg0[(arg1 - 1) * length + mid].value;
		for(int i = 0; i < list.size() % length; i++)
			list.set(arg0[(arg1 - 1) * length + i].order, tmpValue);
	}
	
	private void func3(Nosie[] arg0, int arg1){
		double tmpValue;
		for(int i = 0; i < arg1 - 1; i++){
			tmpValue = arg0[i * length].value;
			for(int j = 0; j < length; j++)
				list.set(arg0[i * length + j].order, tmpValue);
		}
		tmpValue = arg0[(arg1 - 1) * length].value;
		for(int i = 0; i < list.size() % length; i++){
			list.set(arg0[(arg1 - 1) * length + i].order, tmpValue);
		}
	}
}
