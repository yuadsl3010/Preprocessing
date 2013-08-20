package com.yzc.func;

import java.io.File;
import java.util.List;

import com.yzc.src.FileData;
import com.yzc.src.FileDataFactory;
import com.yzc.src.UseIntegration;

//数据集成部分
public class Integration {
	public Integration() {

	}

	/**
	 * @since 2013-8-14
	 * @throws 无
	 * @param data 数据格式为UseIntegration
	 * @return 集成之后的源数据流
	 * List<String[]>
	 */
	public List<String[]> getData(UseIntegration data) {
		File file = new File(data.filePath);
		FileData fdf = FileDataFactory.createReader(data);
		if (null == fdf)
			System.out.println("文件" + file.getName() + "的类型尚未被集成，无法抽取数据");
		else
			return fdf.getData();
		return null;
	}
}
