package com.yzc.func;

import java.io.FileWriter;
import java.util.Random;

import weka.attributeSelection.AttributeSelection;
import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.GreedyStepwise;
import weka.classifiers.Evaluation;
import weka.classifiers.meta.AttributeSelectedClassifier;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;

import com.yzc.src.UseStatute;

//数据规约部分的属性选择
public class Statute {
	public Statute() {

	}

	/**
	 * @since 2013-8-14
	 * @throws 无
	 * @param path 数据格式为UseStatute
	 * @return 返回经过属性选择之后相关度较大的属性数组
	 * @throws Exception
	 * String[]
	 */
	public String[] getResult(UseStatute path) throws Exception {
		String tmpPath = useData(path);
		DataSource source = new DataSource(tmpPath);
	    Instances data = source.getDataSet();
	    if (data.classIndex() == -1)
	      data.setClassIndex(data.numAttributes() - 1);

	    // 1. meta-classifier
	    //useClassifier(data);

	    // 2. filter
	    //useFilter(data);

	    // 3. low-level
	    int tmpInt[] = useLowLevel(data);
	    String[] tmpStr = new String[tmpInt.length];
	    for (int i = 0; i < tmpInt.length; i++)
	    	tmpStr[i] = String.valueOf(tmpInt[i]);
	    return tmpStr;
	}
	
	protected static String useData(UseStatute path) throws Exception{
		FileWriter fw = null;
		fw = new FileWriter(path.path);
		fw.write("@relation Pre-processing\r\n");
        for (int i = 0; i < path.attribute.length; i++)
            fw.write("@attribute " + path.attribute[i] + "\r\n");   
        fw.write("@data\r\n");
        for (int i = 0; i < path.data.size(); i++){
        	for (int j = 0; j < path.data.get(i).length - 1; j++)
        		fw.write("'" + path.data.get(i)[j] + "',");
        	fw.write("'" + path.data.get(i)[path.data.get(i).length - 1] + "'\r\n");
        }
        fw.close();
        return path.path;
	}
	/**
	   * uses the meta-classifier
	   */
	  protected static void useClassifier(Instances data) throws Exception {
	    System.out.println("\n1. Meta-classfier");
	    AttributeSelectedClassifier classifier = new AttributeSelectedClassifier();
	    CfsSubsetEval eval = new CfsSubsetEval();
	    GreedyStepwise search = new GreedyStepwise();
	    search.setSearchBackwards(true);
	    J48 base = new J48();
	    classifier.setClassifier(base);
	    classifier.setEvaluator(eval);
	    classifier.setSearch(search);
	    Evaluation evaluation = new Evaluation(data);
	    evaluation.crossValidateModel(classifier, data, 10, new Random(1));
	    System.out.println(evaluation.toSummaryString());
	  }

	  /**
	   * uses the filter
	   */
	  protected static void useFilter(Instances data) throws Exception {
	    System.out.println("\n2. Filter");
	    weka.filters.supervised.attribute.AttributeSelection filter = new weka.filters.supervised.attribute.AttributeSelection();
	    CfsSubsetEval eval = new CfsSubsetEval();
	    GreedyStepwise search = new GreedyStepwise();
	    search.setSearchBackwards(true);
	    filter.setEvaluator(eval);
	    filter.setSearch(search);
	    filter.setInputFormat(data);
	    Instances newData = Filter.useFilter(data, filter);
	    System.out.println(newData);
	  }

	  /**
	   * uses the low level approach
	   */
	  protected static int[] useLowLevel(Instances data) throws Exception {
	    System.out.println("\n3. Low-level");
	    AttributeSelection attsel = new AttributeSelection();
	    CfsSubsetEval eval = new CfsSubsetEval();
	    GreedyStepwise search = new GreedyStepwise();
	    search.setSearchBackwards(true);
	    attsel.setEvaluator(eval);
	    attsel.setSearch(search);
	    attsel.SelectAttributes(data);
	    int[] indices = attsel.selectedAttributes();
	    System.out.println("selected attribute indices (starting with 0):\n" + Utils.arrayToString(indices));
	    return indices;
	    //System.out.println("selected attribute indices (starting with 0):\n" + Utils.arrayToString(indices));
	  }
}
