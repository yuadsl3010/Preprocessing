package com.yzc.src;

import java.util.ArrayList;
import java.util.List;

/**
 * ����������������������ݽṹ
 * @author yzc
 */
public class UseNosieProcessing {
	public int length;
	public List<Double> list= new ArrayList<Double>();
	public int select;
	public int order;
	public List<String[]> data;
	
	/**
	 * @since 2013-8-14
	 * @param _length �û����õĲ��������ڿ�����Ĵ�С
	 * @param _select �û�ѡ��ķ�����0--ƽ��ֵ��1--��ֵ��2--�߽�ֵ
	 * @param _data Դ������
	 * @param _order Դ��������Ҫ�����������������0��ʼ
	 */
	public UseNosieProcessing(String _length, 
								String _select, 
								List<String[]> _data, 
								String _order){
		order = Integer.valueOf(_order);
		data = _data;
		length = Integer.valueOf(_length);
		for (String[] tmpStrS : _data)
			list.add(Double.valueOf(tmpStrS[order]));
		select = Integer.valueOf(_select);
	}
}
