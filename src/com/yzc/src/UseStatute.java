package com.yzc.src;

import java.util.List;

/**
 * 数据规约部分属性选择处理的数据结构
 * @author yzc
 */
public class UseStatute {
	public List<String[]> data;
	public String[] attribute;
	public String path;
	
	/**
	 * @since 2013-8-14
	 * @param _data 存储数据的列表
	 * @param _attribute 存储attribute的取值
	 * @param _path 存储arff文件路径
	 */
	public UseStatute(List<String[]> _data, String _attribute, String _path){
		data = _data;
		attribute = _attribute.split(";");
		path = _path.substring(0, _path.indexOf(".")) + ".arff";
	}
}
