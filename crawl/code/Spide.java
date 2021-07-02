package spider;

import java.awt.EventQueue;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Color;

public class Spide {

	private JFrame frame;
	private JTextArea textField;
	public static JButton  button;
	public static JButton  button_1;
	public static JButton  button_2;
	public static JButton  button_3;
	public static JButton  button_4;
	public static JTextArea textArea;
	public static JLabel label;
	public static JLabel label_1;
	public static long t1;
	public static int select1;
	/**
	 * Launch the application.
	 */
	
	static public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Spide window = new Spide();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Spide() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("�����j�M");
		frame.setBounds(100, 100, 712, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		textField = new JTextArea();//��J��m
		textField.setColumns(10);
		panel.add(textField);
		
		//textField = new JTextField();
		//panel.add(textField);
		
		//textField.setColumns(10);
		JMenu menufilefa = new JMenu("���O");  
		JMenu menufile = new JMenu("�q�l��"); 
		JMenuItem mItem1 = new JMenuItem("�p�X�q�l��"); 
		menufile.add(mItem1);
		JMenuItem mItem2 = new JMenuItem("�ګ��i�S�s�D"); 
		menufile.add(mItem2);
		JMenu menufile2 = new JMenu("youtube"); 
		JMenuItem mItem3 = new JMenuItem("youtube"); 
		menufile2.add(mItem3);
		JMenu menufile3 = new JMenu("�Q�װ�"); 
		JMenuItem mItem4 = new JMenuItem("BBS PTT"); 
		menufile3.add(mItem4);
		JMenuItem mItem8 = new JMenuItem("dcard"); 
		menufile3.add(mItem8);
		JMenu menufile4 = new JMenu("��T��");
		JMenuItem mItem5 = new JMenuItem("����ʬ�"); 
		menufile4.add(mItem5);
		JMenu menufile5 = new JMenu("�ʪ�����");
		JMenuItem mItem6 = new JMenuItem("�S���ʪ�"); 
		menufile5.add(mItem6);
		JMenuItem mItem7 = new JMenuItem("yahoo�ʪ�"); 
		menufile5.add(mItem7);
		JMenuBar menuBar = new JMenuBar();
		menufilefa.add(menufile);
		menufilefa.add(menufile5);
		menufilefa.add(menufile3);
		menufilefa.add(menufile4);
		menufilefa.add(menufile2);
		
		menuBar.add(menufilefa);
		panel.add(menuBar);
	
		mItem1.addActionListener(new ActionListener() {//�q�l��
			public void actionPerformed(ActionEvent e) {
				label_1.setText("�ۥѹq�l��");
				select1=1;
				Main.url="https://udn.com/news/breaknews/1";//�p�X���ɳ�
			}
		});
		mItem2.addActionListener(new ActionListener() {//�ګ��i�S�s�D
			public void actionPerformed(ActionEvent e) {
				label_1.setText("�ګ��i�S�s�D");
				select1=2;
				Main.url="https://gnn.gamer.com.tw/";
			}
		});
		mItem3.addActionListener(new ActionListener() {//youtube
			public void actionPerformed(ActionEvent e) {
				label_1.setText("youtube");
				select1=3;
				Main.url="https://www.youtube.com/?gl=TW&hl=zh-tw";
			}
		});
		mItem4.addActionListener(new ActionListener() {//BBS PTT
			public void actionPerformed(ActionEvent e) {
				label_1.setText("BBS PTT");
				select1=4;
				Main.url="http://www.ptt.cc/bbs/index.html";//ptt
				
			}
		});
		mItem8.addActionListener(new ActionListener() {//dcard
			public void actionPerformed(ActionEvent e) {
				label_1.setText("Dcard");
				select1=8;
				Main.url="https://www.dcard.tw/f";//
				
			}
		});
		mItem5.addActionListener(new ActionListener() {//����ʬ�
			public void actionPerformed(ActionEvent e) {
				label_1.setText("����ʬ�");
				select1=5;
				Main.url="http://en.wikipedia.org/";
				
			}
		});
		mItem6.addActionListener(new ActionListener() {//momo�ʪ�����
			public void actionPerformed(ActionEvent e) {
				label_1.setText("�S���ʪ�����");
				select1=6;
				Main.url="https://www.ruten.com.tw/";
				
			}
		});
		mItem7.addActionListener(new ActionListener() {//yahoo�ʪ�����
			public void actionPerformed(ActionEvent e) {
				label_1.setText("yahoo�ʪ�����");
				select1=7;
				Main.url="https://tw.buy.yahoo.com/";
				
			}
		});
		JButton button = new JButton("\u641C\u5C0B");
		button.setBackground(new Color(72, 209, 204));
		panel.add(button);
		
		label_1 = new JLabel("\u7DB2\u7AD9");//����
		panel.add(label_1);
		button.addActionListener(new ActionListener() {//�j�M���s
			public void actionPerformed(ActionEvent e) {
				
				t1= System.currentTimeMillis();
				System.out.println("�}�l�ɶ�"+t1);//�]�w�_�l�ɶ�
				textArea.setText("");
				spider.num=1;
				try {
					label.setText("�Ĥ@��");
					Main.search=textField.getText();
					Main spide=new Main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		button_1 = new JButton("\u7B2C\u4E00\u9801");//�Ĥ@��
		button_1.setBackground(new Color(176, 224, 230));
		panel_1.add(button_1);
		
		button_2 = new JButton("\u4E0A\u4E00\u9801");//�W�@��
		button_2.setBackground(new Color(240, 255, 255));
		panel_1.add(button_2);
		
		label = new JLabel("\u7B2C \u9801");//�ĴX��
		label.setForeground(new Color(255, 255, 255));
		panel_1.add(label);
		
		button_3 = new JButton("\u4E0B\u4E00\u9801");//�U�@��
		button_3.setBackground(new Color(240, 255, 255));
		panel_1.add(button_3);
		
		button_4 = new JButton("\u6700\u5F8C\u4E00\u9801");//�̫�@��
		button_4.setBackground(new Color(176, 224, 230));
		panel_1.add(button_4);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		frame.getContentPane().add(scrollPane_1, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane_1.setViewportView(textArea);
		
		
		 Spide.button_1.addActionListener(new ActionListener() {//�Ĥ@�����s
				public void actionPerformed(ActionEvent e) {
					System.out.println(spider.num);
					Spide.textArea.setText("");
					spider.num=1;
					Spide.label.setText("�Ĥ@��");
					for(int i=0;i<spider.data.size();i++) {
						
						database newdata2 = spider.data.get(i);//���
						Spide.textArea.append("\n"+(i+1)+":");
		            	newdata2.getname();
		            	if(i>8) {
		            		break;
		            	}
					}
					
				}
			});
		    Spide.button_2.addActionListener(new ActionListener() {//�W�@�����s
				public void actionPerformed(ActionEvent e) {
					System.out.println(spider.num);
					if(spider.num==1) {
						Spide.textArea.setText("");
						spider.num=1;
						Spide.label.setText("�Ĥ@��");
						for(int i=0;i<spider.data.size();i++) {
							database newdata2 = spider.data.get(i);//���
							Spide.textArea.append("\n"+(i+1)+":");
			            	newdata2.getname();
			            	if(i>8) {
			            		break;
			            	}
			            	
						}
					}
					
					else if(spider.num==2) {//�L�b�ĤG���n�^��Ĥ@��
						Spide.textArea.setText("");
						spider.num=1;
						Spide.label.setText("�Ĥ@��");
						for(int i=0;i<spider.data.size();i++) {
							database newdata2 = spider.data.get(i);//���
							Spide.textArea.append("\n"+(i+1)+":");
			            	newdata2.getname();
			            	if(i>8) {
			            		break;
			            	}
			            	
						}
						}
					else if(spider.num==3) {//�L�b�ĤT���n�^��ĤG��
							Spide.textArea.setText("");
							Spide.label.setText("�ĤG��");
							spider.num=2;
							int y=0;
							for(int i=10;i<20;i++) {
							database newdata2 = spider.data.get(i);//���
							Spide.textArea.append("\n"+(i+1)+":");
			            	newdata2.getname();
			            	
			            		if(y>9) {
			            			break;
			            		}
							}
						}
						
				}
			});
		    Spide.button_3.addActionListener(new ActionListener() {//�U�@�����s
				public void actionPerformed(ActionEvent e) {
					System.out.println(spider.num);
					int kk=0;
					if(spider.num==1&&spider.data.size()>10&&kk==0) {
						
						Spide.textArea.setText("");
						spider.num=2;
						Spide.label.setText("�ĤG��");
						int y=0;
						for(int i=10;i<spider.data.size();i++) {
							y++;
							database newdata2 = spider.data.get(i);//���
							Spide.textArea.append("\n"+(i+1)+":");
			            	newdata2.getname();
			            	if(y>9) {
			            		break;
			            	}
						}
						kk=1;
					}
					else if(spider.num==2&&spider.data.size()>20&&kk==0) {//�L�b�ĤG���n��ĤT��
						Spide.textArea.setText("");
						spider.num=3;
						Spide.label.setText("�ĤT��");
						int y=0;
						for(int i=20;i<spider.data.size()-1;i++) {
							database newdata2 = spider.data.get(i);//���
							Spide.textArea.append("\n"+(i+1)+":");
			            	newdata2.getname();
			            	if(y>9) {
			            		break;
			            	}
			            	
						}
						kk=1;
					}
					
				
				}
				
			});
		    Spide.button_4.addActionListener(new ActionListener() {//�̫�@�����s
				public void actionPerformed(ActionEvent e) {
					System.out.println(spider.num);
					if(spider.data.size()>20) {
					Spide.textArea.setText("");
					spider.num=3;
					Spide.label.setText("�ĤT��");
					for(int i=20;i<spider.data.size()-1;i++) {
						database newdata2 = spider.data.get(i);//���
						Spide.textArea.append("\n"+(i+1)+":");
		            	newdata2.getname();
		            
					}
					}
					else if(spider.data.size()>0&&spider.data.size()<=10) {
						Spide.textArea.setText("");
						spider.num=1;
						Spide.label.setText("�Ĥ@��");
						for(int i=0;i<spider.data.size();i++) {
							database newdata2 = spider.data.get(i);//���
							Spide.textArea.append("\n"+(i+1)+":");
			            	newdata2.getname();
			            
						}
					}
					else if(spider.data.size()>10&&spider.data.size()<=20) {
						Spide.textArea.setText("");
						spider.num=2;
						Spide.label.setText("�ĤG��");
						for(int i=10;i<spider.data.size();i++) {
							database newdata2 = spider.data.get(i);//���
							Spide.textArea.append("\n"+(i+1)+":");
			            	newdata2.getname();
			            
						}
						}
				}
			});
	}

}
