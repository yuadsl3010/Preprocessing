package com.yzc.src;

import java.util.List;

/**
 * ���ݱ任�������ݾۼ������ݽṹ
 * @author yzc
 */
public class UseGather {
	public List<String[]> data;
	public int[] needGather;
	public String SUM = "SUM";
	public String AVER = "AVER";
	
	/**
	 * @since 2013-8-14
	 * @param _data ��������ݾۼ���������
	 * @param _needGather ����������ݾۼ�������λ�õ����飬��0��ʼ
	 */
	public UseGather(List<String[]> _data, 
			String[] _needGather){
		needGather = new int[_needGather.length];
		data = _data;
		for (int i = 0; i < _needGather.length; i++)
			needGather[i] = Integer.valueOf(_needGather[i]);
	}
}
