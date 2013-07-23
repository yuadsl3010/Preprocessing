package com.yzc.main;

import java.util.ArrayList;
import java.util.List;

import com.yzc.func.Integration;
import com.yzc.func.MissingValue;
import com.yzc.src.Missing;


public class DO {
	public static void main(String[] args){
		Integration itg = new Integration();
		List<String[]> data = new ArrayList<String[]>();
		data = itg.getData("C:\\Users\\yzc\\Desktop\\暑假\\预处理小组工作报告\\预处理小组工作报告\\杨金彪工作总结\\杨金彪工作总结\\Test.xls", 5);
		System.out.println("done!");
	}
}
