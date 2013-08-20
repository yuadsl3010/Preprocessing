package com.yzc.main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.yzc.func.Gather;
import com.yzc.func.Integration;
import com.yzc.func.MissingValue;
import com.yzc.func.NosieProcessing;
import com.yzc.func.Outlier;
import com.yzc.func.Statute;
import com.yzc.src.UseGather;
import com.yzc.src.UseIntegration;
import com.yzc.src.UseMissingValue;
import com.yzc.src.UseNosieProcessing;
import com.yzc.src.UseOutlier;
import com.yzc.src.UseStatute;

public class Test extends JFrame implements ActionListener{
	private JTextField jtf1;//数据源路径
	private JTextField jtf2;//空缺值参数1
	private JTextField jtf3;//空缺值参数2
	private JTextField jtf4;//空缺值参数3
	private JTextField jtf5;//噪声参数1
	private JTextField jtf6;//噪声参数2
	private JTextField jtf7;//噪声参数4
	private JTextField jtf8;//异常点参数1
	private JTextField jtf9;//异常点参数2
	private JTextField jtf10;//异常点参数3
	private JTextField jtf11;//异常点参数5
	private JTextField jtf12;//异常点参数6
	private JTextField jtf13;//数据聚集参数2
	private JTextField jtf14;//数据规约参数2
	private JTextField jtf15;//数据源项数
	private JButton jbtn1;
	public Test(int w, int h){
        setSize(w, h);
		setTitle("Java写界面就是个杯具！");
        Container con = getContentPane();
        con.setLayout(new FlowLayout(FlowLayout.LEFT));
        JPanel jp1 = new JPanel();
        jp1.setLayout(new GridLayout(70, 3));
        jp1.add(new JLabel("数据集成"));
        jp1.add(new JLabel());
        jp1.add(new JLabel());
        jtf1 = new JTextField();
        jtf1.setText("请选择数据源文件");
        jtf1.setText("E:\\Test.xlsx");
        jtf1.setEditable(false);
        jbtn1 = new JButton("浏览");
        jbtn1.addActionListener(this);	
        jp1.add(jtf1);
        jp1.add(jbtn1);
        jp1.add(new JLabel());
        jp1.add(new JLabel("1.该数据源的字段个数---eg--- 10"));
        jtf15 = new JTextField();
        jtf15.setText("11");
        jp1.add(jtf15);
        jp1.add(new JLabel());
        jp1.add(new JLabel("数据清理"));
        jp1.add(new JLabel());
        jp1.add(new JLabel());
        jp1.add(new JLabel("空缺值处理参数调整："));
        jp1.add(new JLabel());
        jp1.add(new JLabel());
        jp1.add(new JLabel("1.需要用平均值填补的项，从0开始---eg--- 0,2,4"));
        jtf2 = new JTextField();
        jtf2.setText("1,3,4,5,6");
        jp1.add(jtf2);
        jp1.add(new JLabel());
        jp1.add(new JLabel("2.需要用默认值填补的项，从0开始---eg--- 0,2,4"));
        jtf3 = new JTextField();
        jtf3.setText("0,2");
        jp1.add(jtf3);
        jp1.add(new JLabel());
        jp1.add(new JLabel("3.设置默认值---eg--- 未知,默认,NULL"));
        jtf4 = new JTextField();
        jtf4.setText("未知,默认中性");
        jp1.add(jtf4);
        jp1.add(new JLabel());
        jp1.add(new JLabel("噪声处理参数调整："));
        jp1.add(new JLabel());
        jp1.add(new JLabel());
        jp1.add(new JLabel("1.分箱大小---eg--- 4"));
        jtf5 = new JTextField();
        jtf5.setText("3");
        jp1.add(jtf5);
        jp1.add(new JLabel());
        jp1.add(new JLabel("2.方法选择，0--平均值；1--中值；2--边界值---eg--- 1"));
        jtf6 = new JTextField();
        jtf6.setText("1");
        jp1.add(jtf6);
        jp1.add(new JLabel());
        jp1.add(new JLabel("3.需要噪声处理的列，从0开始（单列）---eg--- 1"));
        jtf7 = new JTextField();
        jtf7.setText("9");
        jp1.add(jtf7);
        jp1.add(new JLabel());
        jp1.add(new JLabel("异常点检测参数调整(基于剪枝的异常点检测)："));
        jp1.add(new JLabel());
        jp1.add(new JLabel());
        jp1.add(new JLabel("1.孤立点数目,预计可能会出现多少的孤立点---eg--- 3"));
        jtf8 = new JTextField();
        jtf8.setText("3");
        jp1.add(jtf8);
        jp1.add(new JLabel());
        jp1.add(new JLabel("2.每个点的近邻数,确定一个点有多少邻居才不是孤立点---eg--- 3"));
        jtf9 = new JTextField();
        jtf9.setText("3");
        jp1.add(jtf9);
        jp1.add(new JLabel());
        jp1.add(new JLabel("3.采用剪枝策略所初定的阀值,距离为多少时算作邻居（只是初定的，根据算法的推演会逐渐变化）---eg--- 3.25"));
        jtf10 = new JTextField();
        jtf10.setText("3.25");
        jp1.add(jtf10);
        jp1.add(new JLabel());
        jp1.add(new JLabel("4.数据流中坐标X的序号，从0开始---eg--- 1"));
        jtf11 = new JTextField();
        jtf11.setText("7");
        jp1.add(jtf11);
        jp1.add(new JLabel());
        jp1.add(new JLabel("5.数据流中坐标y的序号，从0开始---eg--- 3"));
        jtf12 = new JTextField();
        jtf12.setText("8");
        jp1.add(jtf12);
        jp1.add(new JLabel());
        jp1.add(new JLabel("数据变换"));
        jp1.add(new JLabel());
        jp1.add(new JLabel());
        jp1.add(new JLabel("数据聚集参数调整："));
        jp1.add(new JLabel());
        jp1.add(new JLabel());
        jp1.add(new JLabel("1.需要进行数据聚集的列，从0开始---eg--- 0,3,4"));
        jtf13 = new JTextField();
        jtf13.setText("3,4,5,6");
        jp1.add(jtf13);
        jp1.add(new JLabel());
        JButton jbtn2 = new JButton("开始");
        jbtn2.addActionListener(this);
        jp1.add(jbtn2);
        jp1.add(new JLabel("数据规约"));
        jp1.add(new JLabel());
        jp1.add(new JLabel());
        jp1.add(new JLabel("1.数据流中各个数据项的数值分类，请严格遵循格式规范---eg--- " +
        		"age {'10-19','20-29','30-39','40-49','50-59','60-69','70-79','80-89','90-99'};" +
        		"menopause {'lt40','ge40','premeno'};" +
        		"node-caps {'yes','no'};" +
        		"'Class' {'no-recurrence-events','recurrence-events'}"));
        jtf14 = new JTextField();
        jtf14.setText("'序号' real;" +
        		"'学号' real;" +
        		"'性别' {'男','女','默认中性'};" +
        		"'大物1' real;" +
        		"'大物2' real;" +
        		"'大物3' real;" +
        		"'大物' real;" +
        		"X real;" +
        		"Y real;" +
        		"Nosie real;" +
        		"Test real");
        jp1.add(jtf14);
        jp1.add(new JLabel());
        JScrollPane ScrollPane=new JScrollPane(jp1);
        ScrollPane.setPreferredSize(new Dimension(w-60,h-60));
        con.setBackground(Color.LIGHT_GRAY);
        con.add(ScrollPane);
        setVisible(true); 
        pack();
	}

	//这一段是example代码
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getActionCommand().equals("浏览")){
			JFileChooser jf = new JFileChooser("数据源选择");
			jf.setDialogTitle("点击...");
			int result = jf.showOpenDialog(getContentPane());
			jf.setVisible(true);
			File selectedFile = null;
			if (result == JFileChooser.APPROVE_OPTION) {
			    selectedFile = jf.getSelectedFile();
			    if (selectedFile.exists()) {
			    	jtf1.setText(selectedFile.getAbsolutePath());
			    } else {
			    	jtf1.setText("莫名选错了，再试试！");
			    }
			} else if (result == JFileChooser.CANCEL_OPTION) {
			    
			} else if (result == JFileChooser.ERROR_OPTION) {
			    
			}
		}//是jbtn1按钮事件
		else if (arg0.getActionCommand().equals("开始")){
			System.out.println("开始预处理...");
			UseIntegration ui = new UseIntegration(jtf1.getText(), jtf15.getText());
			List<String[]> data = new Integration().getData(ui);
			UseMissingValue umv = new UseMissingValue(
					jtf2.getText().split(","),
					jtf3.getText().split(","),
					jtf4.getText().split(","),
					data);
			data = new MissingValue().getResult(umv);
			UseNosieProcessing unp = new UseNosieProcessing(
					jtf5.getText(),
					jtf6.getText(),
					data,
					jtf7.getText());
			data = new NosieProcessing().getResult(unp);
			UseGather ug = new UseGather(data, jtf13.getText().split(","));
			Map<String, String[]> tmpdata = new Gather().getResult(ug);
			System.out.println("经过聚集之后的数据：");
			String[] tmpStrS = jtf13.getText().split(",");
			for (int i = 0; i < tmpStrS.length; i++){
				System.out.println("SUM_" + tmpStrS[i] + " = " + tmpdata.get("SUM")[i]);
				System.out.println("AVER_" + tmpStrS[i] + " = " + tmpdata.get("AVER")[i]);
			}/*这段代码是检测异常点的，和后面的数据规约有些冲突，所以注释掉了
			UseOutlier uo = new UseOutlier(
					jtf8.getText(),
					jtf9.getText(),
					jtf10.getText(),
					data,
					jtf11.getText(),
					jtf12.getText());
			data = new Outlier().getResult(uo);
			System.out.println("最后的数据：");*/
			for (String[] tmpStrSZ : data){
				for (String tmpStr : tmpStrSZ)
					System.out.print(tmpStr + "\t");
				System.out.print("\r\n");
			}
			UseStatute us = new UseStatute(
					data,
					jtf14.getText(),
					jtf1.getText());
			Statute ss = new Statute();
			try {
				ss.getResult(us);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
