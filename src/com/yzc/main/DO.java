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
		data = itg.getData("C:\\Users\\yzc\\Desktop\\���\\Ԥ����С�鹤������\\Ԥ����С�鹤������\\���빤���ܽ�\\���빤���ܽ�\\Test.xls", 5);
		System.out.println("done!");
	}
}
