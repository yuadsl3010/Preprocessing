package com.yzc.func;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class MissingValue {
	private String splitChar;
	private Map<Integer, String> myData = new HashMap<Integer, String>();
	private int[] args;
	private int[] average;
	private int[] total;
	private String root;
	private int Number;
	public MissingValue() {

	}

	public void init(String arg0, int[] arg1, String arg2, int arg3) {
		root = arg0;
		args = arg1;
		splitChar = arg2;
		average = new int[args.length];
		total = new int[args.length];
		Number = arg3;
	}

	public void insert(int arg0, String arg1) {
		myData.put(arg0, arg1);
	}

	public void clean() {
		String line;
		String tmpString[];
		try {
			for (int i = 0; i < args.length; i++) {
				average[i] = 0;
				total[i] = 0;
			}
			File file = new File(root);
			FileReader in = new FileReader(file);
			BufferedReader bufferReader = new BufferedReader(in);
			while (null != (line = bufferReader.readLine())) {
				tmpString = line.trim().split(splitChar);
				if(tmpString.length != Number){
					String tmpTemp[] = new String[Number];
					for(int i = 0; i < tmpString.length; i++)
						tmpTemp[i] = tmpString[i];
					for(int i = tmpString.length; i < Number; i++)
						tmpTemp[i] = "";
					tmpString = tmpTemp;
				}
				for (int i = 0; i < args.length; i++) {
					if (tmpString[args[i]].length() == 0)
						continue;
					else {
						average[i] += Integer.valueOf(tmpString[args[i]]);
						total[i]++;
					}
				}
			}
			if (bufferReader != null)
				bufferReader.close();
			if (in != null)
				in.close();
			for (int i = 0; i < args.length; i++)
				myData.put(args[i], String.valueOf(average[i] / total[i]));
			FileReader inClean = new FileReader(file);
			BufferedReader inCleanR = new BufferedReader(inClean);
			FileWriter writer = new FileWriter(root.substring(0, root.indexOf('.')) + "_new.txt", true);
			String tmpWrite = "";
			while (null != (line = inCleanR.readLine())){
				tmpWrite = "";
				tmpString = line.trim().split(splitChar);
				if(tmpString.length != Number){
					String tmpTemp[] = new String[Number];
					for(int i = 0; i < tmpString.length; i++)
						tmpTemp[i] = tmpString[i];
					for(int i = tmpString.length; i < Number; i++)
						tmpTemp[i] = "";
					tmpString = tmpTemp;
				}
				for (int i = 0; i < tmpString.length; i++) {
					if (tmpString[i].length() == 0)
						tmpWrite += myData.get(i) + splitChar;
					else
						tmpWrite += tmpString[i] + splitChar;
				}
				writer.write(tmpWrite.substring(0, tmpWrite.length() - 1));
				writer.write("\r\n");
			}
			writer.flush();
			writer.close();
			if (inCleanR != null)
				inCleanR.close();
			if (inClean != null)
				inClean.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
