package com.yzc.src;

/**
 * 数据集成部分的数据结构
 * @author yzc
 */
public class UseIntegration {
	public String filePath;
	public int total;
	
	/**
	 * @since 2013-8-14
	 * @param _filePath 文件路径
	 * @param _total 文件数据列数
	 */
	public UseIntegration(String _filePath, String _total){
		filePath = _filePath;
		total = Integer.valueOf(_total);
	}
}
