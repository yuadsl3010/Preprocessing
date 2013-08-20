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
	private JTextField jtf1;//����Դ·��
	private JTextField jtf2;//��ȱֵ����1
	private JTextField jtf3;//��ȱֵ����2
	private JTextField jtf4;//��ȱֵ����3
	private JTextField jtf5;//��������1
	private JTextField jtf6;//��������2
	private JTextField jtf7;//��������4
	private JTextField jtf8;//�쳣�����1
	private JTextField jtf9;//�쳣�����2
	private JTextField jtf10;//�쳣�����3
	private JTextField jtf11;//�쳣�����5
	private JTextField jtf12;//�쳣�����6
	private JTextField jtf13;//���ݾۼ�����2
	private JTextField jtf14;//���ݹ�Լ����2
	private JTextField jtf15;//����Դ����
	private JButton jbtn1;
	public Test(int w, int h){
        setSize(w, h);
		setTitle("Javaд������Ǹ����ߣ�");
        Container con = getContentPane();
        con.setLayout(new FlowLayout(FlowLayout.LEFT));
        JPanel jp1 = new JPanel();
        jp1.setLayout(new GridLayout(70, 3));
        jp1.add(new JLabel("���ݼ���"));
        jp1.add(new JLabel());
        jp1.add(new JLabel());
        jtf1 = new JTextField();
        jtf1.setText("��ѡ������Դ�ļ�");
        jtf1.setText("E:\\Test.xlsx");
        jtf1.setEditable(false);
        jbtn1 = new JButton("���");
        jbtn1.addActionListener(this);	
        jp1.add(jtf1);
        jp1.add(jbtn1);
        jp1.add(new JLabel());
        jp1.add(new JLabel("1.������Դ���ֶθ���---eg--- 10"));
        jtf15 = new JTextField();
        jtf15.setText("11");
        jp1.add(jtf15);
        jp1.add(new JLabel());
        jp1.add(new JLabel("��������"));
        jp1.add(new JLabel());
        jp1.add(new JLabel());
        jp1.add(new JLabel("��ȱֵ�������������"));
        jp1.add(new JLabel());
        jp1.add(new JLabel());
        jp1.add(new JLabel("1.��Ҫ��ƽ��ֵ������0��ʼ---eg--- 0,2,4"));
        jtf2 = new JTextField();
        jtf2.setText("1,3,4,5,6");
        jp1.add(jtf2);
        jp1.add(new JLabel());
        jp1.add(new JLabel("2.��Ҫ��Ĭ��ֵ������0��ʼ---eg--- 0,2,4"));
        jtf3 = new JTextField();
        jtf3.setText("0,2");
        jp1.add(jtf3);
        jp1.add(new JLabel());
        jp1.add(new JLabel("3.����Ĭ��ֵ---eg--- δ֪,Ĭ��,NULL"));
        jtf4 = new JTextField();
        jtf4.setText("δ֪,Ĭ������");
        jp1.add(jtf4);
        jp1.add(new JLabel());
        jp1.add(new JLabel("�����������������"));
        jp1.add(new JLabel());
        jp1.add(new JLabel());
        jp1.add(new JLabel("1.�����С---eg--- 4"));
        jtf5 = new JTextField();
        jtf5.setText("3");
        jp1.add(jtf5);
        jp1.add(new JLabel());
        jp1.add(new JLabel("2.����ѡ��0--ƽ��ֵ��1--��ֵ��2--�߽�ֵ---eg--- 1"));
        jtf6 = new JTextField();
        jtf6.setText("1");
        jp1.add(jtf6);
        jp1.add(new JLabel());
        jp1.add(new JLabel("3.��Ҫ����������У���0��ʼ�����У�---eg--- 1"));
        jtf7 = new JTextField();
        jtf7.setText("9");
        jp1.add(jtf7);
        jp1.add(new JLabel());
        jp1.add(new JLabel("�쳣�����������(���ڼ�֦���쳣����)��"));
        jp1.add(new JLabel());
        jp1.add(new JLabel());
        jp1.add(new JLabel("1.��������Ŀ,Ԥ�ƿ��ܻ���ֶ��ٵĹ�����---eg--- 3"));
        jtf8 = new JTextField();
        jtf8.setText("3");
        jp1.add(jtf8);
        jp1.add(new JLabel());
        jp1.add(new JLabel("2.ÿ����Ľ�����,ȷ��һ�����ж����ھӲŲ��ǹ�����---eg--- 3"));
        jtf9 = new JTextField();
        jtf9.setText("3");
        jp1.add(jtf9);
        jp1.add(new JLabel());
        jp1.add(new JLabel("3.���ü�֦�����������ķ�ֵ,����Ϊ����ʱ�����ھӣ�ֻ�ǳ����ģ������㷨�����ݻ��𽥱仯��---eg--- 3.25"));
        jtf10 = new JTextField();
        jtf10.setText("3.25");
        jp1.add(jtf10);
        jp1.add(new JLabel());
        jp1.add(new JLabel("4.������������X����ţ���0��ʼ---eg--- 1"));
        jtf11 = new JTextField();
        jtf11.setText("7");
        jp1.add(jtf11);
        jp1.add(new JLabel());
        jp1.add(new JLabel("5.������������y����ţ���0��ʼ---eg--- 3"));
        jtf12 = new JTextField();
        jtf12.setText("8");
        jp1.add(jtf12);
        jp1.add(new JLabel());
        jp1.add(new JLabel("���ݱ任"));
        jp1.add(new JLabel());
        jp1.add(new JLabel());
        jp1.add(new JLabel("���ݾۼ�����������"));
        jp1.add(new JLabel());
        jp1.add(new JLabel());
        jp1.add(new JLabel("1.��Ҫ�������ݾۼ����У���0��ʼ---eg--- 0,3,4"));
        jtf13 = new JTextField();
        jtf13.setText("3,4,5,6");
        jp1.add(jtf13);
        jp1.add(new JLabel());
        JButton jbtn2 = new JButton("��ʼ");
        jbtn2.addActionListener(this);
        jp1.add(jbtn2);
        jp1.add(new JLabel("���ݹ�Լ"));
        jp1.add(new JLabel());
        jp1.add(new JLabel());
        jp1.add(new JLabel("1.�������и������������ֵ���࣬���ϸ���ѭ��ʽ�淶---eg--- " +
        		"age {'10-19','20-29','30-39','40-49','50-59','60-69','70-79','80-89','90-99'};" +
        		"menopause {'lt40','ge40','premeno'};" +
        		"node-caps {'yes','no'};" +
        		"'Class' {'no-recurrence-events','recurrence-events'}"));
        jtf14 = new JTextField();
        jtf14.setText("'���' real;" +
        		"'ѧ��' real;" +
        		"'�Ա�' {'��','Ů','Ĭ������'};" +
        		"'����1' real;" +
        		"'����2' real;" +
        		"'����3' real;" +
        		"'����' real;" +
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

	//��һ����example����
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getActionCommand().equals("���")){
			JFileChooser jf = new JFileChooser("����Դѡ��");
			jf.setDialogTitle("���...");
			int result = jf.showOpenDialog(getContentPane());
			jf.setVisible(true);
			File selectedFile = null;
			if (result == JFileChooser.APPROVE_OPTION) {
			    selectedFile = jf.getSelectedFile();
			    if (selectedFile.exists()) {
			    	jtf1.setText(selectedFile.getAbsolutePath());
			    } else {
			    	jtf1.setText("Ī��ѡ���ˣ������ԣ�");
			    }
			} else if (result == JFileChooser.CANCEL_OPTION) {
			    
			} else if (result == JFileChooser.ERROR_OPTION) {
			    
			}
		}//��jbtn1��ť�¼�
		else if (arg0.getActionCommand().equals("��ʼ")){
			System.out.println("��ʼԤ����...");
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
			System.out.println("�����ۼ�֮������ݣ�");
			String[] tmpStrS = jtf13.getText().split(",");
			for (int i = 0; i < tmpStrS.length; i++){
				System.out.println("SUM_" + tmpStrS[i] + " = " + tmpdata.get("SUM")[i]);
				System.out.println("AVER_" + tmpStrS[i] + " = " + tmpdata.get("AVER")[i]);
			}/*��δ����Ǽ���쳣��ģ��ͺ�������ݹ�Լ��Щ��ͻ������ע�͵���
			UseOutlier uo = new UseOutlier(
					jtf8.getText(),
					jtf9.getText(),
					jtf10.getText(),
					data,
					jtf11.getText(),
					jtf12.getText());
			data = new Outlier().getResult(uo);
			System.out.println("�������ݣ�");*/
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
