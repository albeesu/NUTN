package neural;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class neuralwindow {

	private JFrame frmPso;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	public static int iepoch=1000;
	public static int particle=20;
	public static double[][] weight=new double[particle][9];//由上到下及左到右的權重線 共九個
	public static double x0=1.0,x1,x2,a0=1.0,a1,a2,a3,y;//神經元
	public static double[][] train= {{0.0,0.0,0.0},{1.0,1.0,0.0},{1.0,0.0,1.0},{0.0,1.0,1.0}};
	public static double c1=2,c2=2,w=2;//pso計算相關
	public static double[] vt1=new double[particle];
	public static double[] vt=new double[particle];
	public static double vmax=2,vmin=-2;
	public static double[][] pbest=new double[particle][9];
	public static double[] gbest=new double[9];
	public static double[] l2=new double[particle];
	public static double bestl2=1000000000;
	public static double tempa3=1.0;
	public static int epoch=0;
	public static ArrayList<Double> arr = new ArrayList<Double>(); 
	public static int flag=0;
	public static int count=0;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					neuralwindow window = new neuralwindow();
					window.frmPso.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public neuralwindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPso = new JFrame();
		frmPso.setTitle("PSO");
		frmPso.setResizable(false);
		frmPso.setBounds(100, 100, 732, 572);
		frmPso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPso.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(227, 55, 136, 29);
		frmPso.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u8FED\u4EE3\u6B21\u6578(Epoch)");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel.setBounds(44, 56, 157, 26);
		frmPso.getContentPane().add(lblNewLabel);
		
		JLabel lblpartical = new JLabel("\u7C92\u5B50\u6578\u91CF(Partical)");
		lblpartical.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblpartical.setBounds(44, 106, 157, 26);
		frmPso.getContentPane().add(lblpartical);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(227, 105, 136, 29);
		frmPso.getContentPane().add(textField_1);
		
		JLabel lblw = new JLabel("\u6B0A\u91CDw");
		lblw.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblw.setBounds(44, 155, 157, 26);
		frmPso.getContentPane().add(lblw);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(227, 154, 136, 29);
		frmPso.getContentPane().add(textField_2);
		
		JLabel lblc = new JLabel("\u6B0A\u91CDc1");
		lblc.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblc.setBounds(44, 201, 157, 26);
		frmPso.getContentPane().add(lblc);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(227, 200, 136, 29);
		frmPso.getContentPane().add(textField_3);
		
		JLabel lblc_2 = new JLabel("\u6B0A\u91CDc2");
		lblc_2.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblc_2.setBounds(44, 251, 157, 26);
		frmPso.getContentPane().add(lblc_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(227, 250, 136, 29);
		frmPso.getContentPane().add(textField_4);
		
		JButton btnStart = new JButton("\u8A13\u7DF4");
		btnStart.setBounds(156, 351, 111, 31);
		frmPso.getContentPane().add(btnStart);
		
		JLabel lblNewLabel_1 = new JLabel("\u8B8A\u91CF");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(44, 303, 71, 23);
		frmPso.getContentPane().add(lblNewLabel_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(110, 301, 91, 26);
		frmPso.getContentPane().add(textField_5);
		
		JLabel lblNewLabel_1_1 = new JLabel("~");
		lblNewLabel_1_1.setBounds(225, 303, 71, 23);
		frmPso.getContentPane().add(lblNewLabel_1_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(260, 300, 103, 26);
		frmPso.getContentPane().add(textField_6);
		
		JLabel lblGbest = new JLabel("gbest");
		lblGbest.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblGbest.setBounds(552, 16, 71, 23);
		frmPso.getContentPane().add(lblGbest);
		textField.setText("1000");//迭代次數
		textField_1.setText("20");//粒子數量
		textField_2.setText("2");//w
		textField_3.setText("2");//c1
		textField_4.setText("2");//c2
		textField_5.setText("-2");//vmin
		textField_6.setText("2");//vmax
		
		JLabel lblNewLabel_2 = new JLabel("\u8A2D\u5B9A");
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(187, 14, 157, 26);
		frmPso.getContentPane().add(lblNewLabel_2);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setText("0");
		textField_7.setColumns(10);
		textField_7.setBounds(562, 55, 136, 29);
		frmPso.getContentPane().add(textField_7);
		
		JLabel lblWeight = new JLabel("weight1(x0a1)");
		lblWeight.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblWeight.setBounds(441, 55, 111, 29);
		frmPso.getContentPane().add(lblWeight);
		
		JLabel lblWeight_6 = new JLabel("weight2(x1a1)");
		lblWeight_6.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblWeight_6.setBounds(441, 108, 106, 29);
		frmPso.getContentPane().add(lblWeight_6);
		
		JLabel lblWeight_1 = new JLabel("weight3(x2a1)");
		lblWeight_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblWeight_1.setBounds(441, 157, 106, 29);
		frmPso.getContentPane().add(lblWeight_1);
		
		JLabel lblWeight_2 = new JLabel("weight4(x0a2)");
		lblWeight_2.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblWeight_2.setBounds(441, 203, 106, 29);
		frmPso.getContentPane().add(lblWeight_2);
		
		JLabel lblWeight_3 = new JLabel("weight5(x1a2)");
		lblWeight_3.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblWeight_3.setBounds(441, 253, 106, 29);
		frmPso.getContentPane().add(lblWeight_3);
		
		JLabel lblWeight_4 = new JLabel("weight6(x2a2)");
		lblWeight_4.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblWeight_4.setBounds(441, 303, 106, 29);
		frmPso.getContentPane().add(lblWeight_4);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setText("0");
		textField_8.setColumns(10);
		textField_8.setBounds(562, 105, 136, 29);
		frmPso.getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setText("0");
		textField_9.setColumns(10);
		textField_9.setBounds(562, 154, 136, 29);
		frmPso.getContentPane().add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setText("0");
		textField_10.setColumns(10);
		textField_10.setBounds(562, 200, 136, 29);
		frmPso.getContentPane().add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setText("0");
		textField_11.setColumns(10);
		textField_11.setBounds(562, 250, 136, 29);
		frmPso.getContentPane().add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setText("0");
		textField_12.setColumns(10);
		textField_12.setBounds(562, 303, 136, 29);
		frmPso.getContentPane().add(textField_12);
		
		JLabel lblWeight_4_1 = new JLabel("weight7(a0a3)");
		lblWeight_4_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblWeight_4_1.setBounds(441, 352, 106, 29);
		frmPso.getContentPane().add(lblWeight_4_1);
		
		textField_13 = new JTextField();
		textField_13.setText("0");
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBounds(562, 352, 136, 29);
		frmPso.getContentPane().add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setText("0");
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		textField_14.setBounds(562, 395, 136, 29);
		frmPso.getContentPane().add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setText("0");
		textField_15.setEditable(false);
		textField_15.setColumns(10);
		textField_15.setBounds(562, 437, 136, 29);
		frmPso.getContentPane().add(textField_15);
		
		JLabel lblWeight_4_1_1 = new JLabel("weight8(a1a3)");
		lblWeight_4_1_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblWeight_4_1_1.setBounds(441, 398, 106, 29);
		frmPso.getContentPane().add(lblWeight_4_1_1);
		
		JLabel lblWeight_4_1_1_1 = new JLabel("weight9(a2a3)");
		lblWeight_4_1_1_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblWeight_4_1_1_1.setBounds(441, 437, 106, 29);
		frmPso.getContentPane().add(lblWeight_4_1_1_1);
		
		textField_16 = new JTextField();
		textField_16.setText("1");
		textField_16.setColumns(10);
		textField_16.setBounds(166, 397, 91, 26);
		frmPso.getContentPane().add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setText("1");
		textField_17.setColumns(10);
		textField_17.setBounds(272, 396, 91, 26);
		frmPso.getContentPane().add(textField_17);
		
		JLabel lblNewLabel_1_2 = new JLabel("\u8F38\u5165(X1\u3001X2)");
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(44, 397, 118, 23);
		frmPso.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("\u8F38\u51FA");
		lblNewLabel_1_2_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(83, 484, 118, 23);
		frmPso.getContentPane().add(lblNewLabel_1_2_1);
		
		textField_18 = new JTextField();
		textField_18.setText("0");
		textField_18.setEditable(false);
		textField_18.setColumns(10);
		textField_18.setBounds(227, 481, 136, 29);
		frmPso.getContentPane().add(textField_18);
		
		JButton btnStart_1 = new JButton("START");
		btnStart_1.setBounds(156, 435, 111, 31);
		frmPso.getContentPane().add(btnStart_1);
		btnStart.addActionListener(new ActionListener() {//訓練按鈕
			public void actionPerformed(ActionEvent e) {
				flag=1;
				iepoch=Integer.parseInt(textField.getText());//迭代次數
				particle=Integer.parseInt(textField_1.getText());//粒子數量
				w=Double.parseDouble(textField_2.getText());//w
				c1=Double.parseDouble(textField_3.getText());//c1
				c2=Double.parseDouble(textField_4.getText());//c2
				vmin=Double.parseDouble(textField_5.getText());//vmin
				vmax=Double.parseDouble(textField_6.getText());//vmax
				arr.clear();
				bestl2=1000000000;
				pbest=new double[particle][9];
				gbest=new double[9];
				l2=new double[particle];
				weight=new double[particle][9];
				vt1=new double[particle];
				vt=new double[particle];
				tempa3=1.0;
				epoch=0;
				count=0;
				//for(int o=0;o<100;o++) {
					ran();
					while(epoch<iepoch&&count<100){
//						if(count>100) {
//							break;
//						}
						epoch=epoch+1;
						pso();
					}
				
				
				System.out.println(arr.get(arr.size()-1));
				textField_7.setText(String.valueOf(gbest[0]));
				textField_8.setText(String.valueOf(gbest[1]));
				textField_9.setText(String.valueOf(gbest[2]));
				textField_10.setText(String.valueOf(gbest[3]));
				textField_11.setText(String.valueOf(gbest[4]));
				textField_12.setText(String.valueOf(gbest[5]));
				textField_13.setText(String.valueOf(gbest[6]));
				textField_14.setText(String.valueOf(gbest[7]));
				textField_15.setText(String.valueOf(gbest[8]));
				XYLineChart_AWT chart=new XYLineChart_AWT();
				chart.setVisible(true);
			}
		});
		btnStart_1.addActionListener(new ActionListener() {//測試按鈕
			
			public void actionPerformed(ActionEvent e) {
				double test1=Double.parseDouble(textField_16.getText());
				double test2=Double.parseDouble(textField_17.getText());
				a1=gbest[0]+test1*gbest[1]+test2*gbest[2];
				a1=sigmoid(a1);
				a2=gbest[3]+test1*gbest[4]+test2*gbest[5];
				a2=sigmoid(a2);
				a3=gbest[6]+gbest[7]*a1+gbest[8]*a2;//輸出
				a3=sigmoid(a3);
				textField_18.setText(String.valueOf(a3));
				System.out.println(a3);
			}
			
		});
	}
	
	
	//=====================pso============================
	public static void pso() {
		for(int i=0;i<particle;i++) {
			for(int j=0;j<4;j++) {
				a1=weight[i][0]+train[j][0]*weight[i][1]+train[j][1]*weight[i][2];
				a1=sigmoid(a1);
				a2=weight[i][3]+train[j][0]*weight[i][4]+train[j][1]*weight[i][5];
				a2=sigmoid(a2);
				a3=weight[i][6]+weight[i][7]*a1+weight[i][8]*a2;//輸出
				a3=sigmoid(a3);
				tempa3=tempa3+(a3-train[j][2])*(a3-train[j][2]);//fitness 使用L2
			}
			if(epoch==1) {//把pbest設置為現在位置
				l2[i]=Math.pow(tempa3, 0.5);
				for(int k=0;k<9;k++) {
					pbest[i][k]=weight[i][k];
				}
			}
			else {
				if(tempa3<l2[i]) {
					l2[i]=tempa3;
					for(int k=0;k<9;k++) {
						pbest[i][k]=weight[i][k];
					}
				}
			}
			tempa3=0.0;
		}
		
		for(int i=0;i<particle;i++) {//確定gbest 就是過往跟現在 "最好的" 成績
			if(l2[i]<bestl2) {
				bestl2=l2[i];
				for(int k=0;k<9;k++) {
					double a=weight[i][k];
					gbest[k]=a;
				}
			}
		}
		if(arr.size()>1) {
			double sub=arr.get(arr.size()-1);
			sub=sub-bestl2;
			if(sub<0.001) {
				count=count+1;
			}
			else {
				count=0;
			}
		}
		
		arr.add(bestl2);
		
		for(int i=0;i<particle;i++) {
			for(int j=0;j<9;j++) {
				vt[i]=w*vt[i]+c1*Math.random()*(pbest[i][j]-weight[i][j])+c2*Math.random()*(gbest[j]-weight[i][j]);//上個時間+自己認為最佳+群體認為最佳
				if(vt[i]>vmax) {
					vt[i]=vmax;
				}
				if(vt[i]<vmin) {
					vt[i]=vmin;
				}
				weight[i][j]=weight[i][j]+vt[i];
			}
		}
		
	}
	//=====================random============================
	public static void ran() {//random
		for(int i=0;i<particle;i++) {
			for(int j=0;j<9;j++) {
				weight[i][j]=(Math.random()*10);
			}
		}
	}
	public static double sigmoid(double z) {//random
		z=1.0/(1.0+Math.exp(-z));
		return z;
	}

}
