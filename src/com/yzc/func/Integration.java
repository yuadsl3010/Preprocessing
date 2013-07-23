package com.yzc.func;

import java.io.File;
import java.util.List;

import com.yzc.src.FileData;
import com.yzc.src.FileDataFactory;

public class Integration {
	public Integration() {

	}

	public List<String[]> getData(String _filePath, int _total) {
		File file = new File(_filePath);
		FileData fdf = FileDataFactory.createReader(_filePath, _total);
		if (null == fdf)
			System.out.println("文件" + file.getName() + "的类型尚未被集成，无法抽取数据");
		else
			return fdf.getData();
		return null;
	}
}
