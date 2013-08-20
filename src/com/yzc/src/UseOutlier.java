package com.yzc.src;

import java.util.ArrayList;
import java.util.List;

/**
 * �����������쳣�㴦������ݽṹ
 * @author yzc
 */
public class UseOutlier {
	public List<Axis> listD = new ArrayList<Axis>();
	public int n, k;
	public double cutOff;
	public List<String[]> data;
	public int intX, intY;
	
	/**
	 * @since 2013-8-14
	 * @param _n ��������Ŀ
	 * @param _k ÿ����Ľ�����
	 * @param _cutOff ���ü�֦�����������ķ�ֵ
	 * @param _data �洢���ݵ��б�
	 * @param _intX ������������X����ţ���0��ʼ
	 * @param _intY ������������y����ţ���0��ʼ
	 */
	public UseOutlier(String _n, String _k, String _cutOff, List<String[]> _data, String _intX, String _intY){
		n = Integer.valueOf(_n);
		k = Integer.valueOf(_k);
		cutOff = Double.valueOf(_cutOff);
		data = _data;
		intX = Integer.valueOf(_intX);
		intY = Integer.valueOf(_intY);
		for (int i = 0; i < _data.size(); i++)
			listD.add(new Axis(Double.valueOf(_data.get(i)[intX]),
					Double.valueOf(_data.get(i)[intY]),
					i));
	}
}
