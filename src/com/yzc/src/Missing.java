package com.yzc.src;

import java.util.List;

//���������ֵĿ�ȱֵ�������ݽṹ
public class Missing {
	public int[] parameters;
	public int[] intParameters;
	public String[] strParameters;
	public List<String[]> listParameters;
	
	/*parameters
	 * arg0:�û�ָ����Ҫƽ��ֵ�Ŀ�ȱֵ��λ�õ����飬������Щ��ȱֵ��Ҫ��ƽ��ֵ�����0��ʼ
	 * arg1:�û�ָ����ҪĬ��ֵ�Ŀ�ȱֵ��λ�õ����飬������Щ��ȱֵ��Ҫ��Ĭ��ֵ�����0��ʼ
	 * arg2:�û�ָ����ҪĬ��ֵ��ֵ�����飬���硰δ֪������Ĭ��ֵ��
	 * arg3:���ݲ��֣������ݴ�Դ�ļ��г�ȡ����
	 * */
	public Missing(int[] arg0, int[] arg1, String[] arg2, List<String[]> arg3){
		parameters = arg0;
		intParameters = arg1;
		strParameters = arg2;
		listParameters = arg3;
	}
}
