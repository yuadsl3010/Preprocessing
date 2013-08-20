package com.yzc.func;

import java.io.File;
import java.util.List;

import com.yzc.src.FileData;
import com.yzc.src.FileDataFactory;
import com.yzc.src.UseIntegration;

//���ݼ��ɲ���
public class Integration {
	public Integration() {

	}

	/**
	 * @since 2013-8-14
	 * @throws ��
	 * @param data ���ݸ�ʽΪUseIntegration
	 * @return ����֮���Դ������
	 * List<String[]>
	 */
	public List<String[]> getData(UseIntegration data) {
		File file = new File(data.filePath);
		FileData fdf = FileDataFactory.createReader(data);
		if (null == fdf)
			System.out.println("�ļ�" + file.getName() + "��������δ�����ɣ��޷���ȡ����");
		else
			return fdf.getData();
		return null;
	}
}
