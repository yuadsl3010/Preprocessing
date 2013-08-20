package com.yzc.func;

import java.util.HashMap;
import java.util.Map;

import com.yzc.src.UseGather;

//���ݱ任���ֵ����ݾۼ�
public class Gather {
	public Gather(){
		
	}
	
	/**
	 * @since 2013-8-14
	 * @throws ��
	 * @param data ���ݸ�ʽΪUseGather
	 * @return ���ؾ����ۼ��Ľ������ֱ�ӵ���
	 * Map<String,String[]>
	 */
	public Map<String, String[]> getResult(UseGather data){
		int i = 0;
		String tmpSUM[] = new String[data.needGather.length];
		for (int tmpI = 0; tmpI < tmpSUM.length; tmpI++)
			tmpSUM[tmpI] = "0";
		for (String[] tmpStrS : data.data){
			int j = 0;
			for (int tmpInt : data.needGather){
				tmpSUM[j] = String.valueOf(Float.valueOf(tmpSUM[j]) + 
						Float.valueOf(tmpStrS[tmpInt]));
				j++;
			}
			i++;
		}
		Map<String, String[]> result = new HashMap<String, String[]>();
		String tmpAVER[] = new String[data.needGather.length];
		int j = 0;
		for (String tmpStr : tmpSUM){
			tmpAVER[j] = String.valueOf(Float.valueOf(tmpStr) / i);
			j++;
		}
		result.put(data.SUM, tmpSUM);
		result.put(data.AVER, tmpAVER);
		return result;
	}
}
