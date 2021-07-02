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
		frame = new JFrame("網路搜尋");
		frame.setBounds(100, 100, 712, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		textField = new JTextArea();//輸入位置
		textField.setColumns(10);
		panel.add(textField);
		
		//textField = new JTextField();
		//panel.add(textField);
		
		//textField.setColumns(10);
		JMenu menufilefa = new JMenu("類別");  
		JMenu menufile = new JMenu("電子報"); 
		JMenuItem mItem1 = new JMenuItem("聯合電子報"); 
		menufile.add(mItem1);
		JMenuItem mItem2 = new JMenuItem("巴哈姆特新聞"); 
		menufile.add(mItem2);
		JMenu menufile2 = new JMenu("youtube"); 
		JMenuItem mItem3 = new JMenuItem("youtube"); 
		menufile2.add(mItem3);
		JMenu menufile3 = new JMenu("討論區"); 
		JMenuItem mItem4 = new JMenuItem("BBS PTT"); 
		menufile3.add(mItem4);
		JMenuItem mItem8 = new JMenuItem("dcard"); 
		menufile3.add(mItem8);
		JMenu menufile4 = new JMenu("資訊區");
		JMenuItem mItem5 = new JMenuItem("維基百科"); 
		menufile4.add(mItem5);
		JMenu menufile5 = new JMenu("購物網站");
		JMenuItem mItem6 = new JMenuItem("露天購物"); 
		menufile5.add(mItem6);
		JMenuItem mItem7 = new JMenuItem("yahoo購物"); 
		menufile5.add(mItem7);
		JMenuBar menuBar = new JMenuBar();
		menufilefa.add(menufile);
		menufilefa.add(menufile5);
		menufilefa.add(menufile3);
		menufilefa.add(menufile4);
		menufilefa.add(menufile2);
		
		menuBar.add(menufilefa);
		panel.add(menuBar);
	
		mItem1.addActionListener(new ActionListener() {//電子報
			public void actionPerformed(ActionEvent e) {
				label_1.setText("自由電子報");
				select1=1;
				Main.url="https://udn.com/news/breaknews/1";//聯合報時報
			}
		});
		mItem2.addActionListener(new ActionListener() {//巴哈姆特新聞
			public void actionPerformed(ActionEvent e) {
				label_1.setText("巴哈姆特新聞");
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
		mItem5.addActionListener(new ActionListener() {//維基百科
			public void actionPerformed(ActionEvent e) {
				label_1.setText("維基百科");
				select1=5;
				Main.url="http://en.wikipedia.org/";
				
			}
		});
		mItem6.addActionListener(new ActionListener() {//momo購物網站
			public void actionPerformed(ActionEvent e) {
				label_1.setText("露天購物網站");
				select1=6;
				Main.url="https://www.ruten.com.tw/";
				
			}
		});
		mItem7.addActionListener(new ActionListener() {//yahoo購物網站
			public void actionPerformed(ActionEvent e) {
				label_1.setText("yahoo購物網站");
				select1=7;
				Main.url="https://tw.buy.yahoo.com/";
				
			}
		});
		JButton button = new JButton("\u641C\u5C0B");
		button.setBackground(new Color(72, 209, 204));
		panel.add(button);
		
		label_1 = new JLabel("\u7DB2\u7AD9");//網站
		panel.add(label_1);
		button.addActionListener(new ActionListener() {//搜尋按鈕
			public void actionPerformed(ActionEvent e) {
				
				t1= System.currentTimeMillis();
				System.out.println("開始時間"+t1);//設定起始時間
				textArea.setText("");
				spider.num=1;
				try {
					label.setText("第一頁");
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
		
		button_1 = new JButton("\u7B2C\u4E00\u9801");//第一頁
		button_1.setBackground(new Color(176, 224, 230));
		panel_1.add(button_1);
		
		button_2 = new JButton("\u4E0A\u4E00\u9801");//上一頁
		button_2.setBackground(new Color(240, 255, 255));
		panel_1.add(button_2);
		
		label = new JLabel("\u7B2C \u9801");//第幾頁
		label.setForeground(new Color(255, 255, 255));
		panel_1.add(label);
		
		button_3 = new JButton("\u4E0B\u4E00\u9801");//下一頁
		button_3.setBackground(new Color(240, 255, 255));
		panel_1.add(button_3);
		
		button_4 = new JButton("\u6700\u5F8C\u4E00\u9801");//最後一頁
		button_4.setBackground(new Color(176, 224, 230));
		panel_1.add(button_4);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		frame.getContentPane().add(scrollPane_1, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane_1.setViewportView(textArea);
		
		
		 Spide.button_1.addActionListener(new ActionListener() {//第一頁按鈕
				public void actionPerformed(ActionEvent e) {
					System.out.println(spider.num);
					Spide.textArea.setText("");
					spider.num=1;
					Spide.label.setText("第一頁");
					for(int i=0;i<spider.data.size();i++) {
						
						database newdata2 = spider.data.get(i);//資料
						Spide.textArea.append("\n"+(i+1)+":");
		            	newdata2.getname();
		            	if(i>8) {
		            		break;
		            	}
					}
					
				}
			});
		    Spide.button_2.addActionListener(new ActionListener() {//上一頁按鈕
				public void actionPerformed(ActionEvent e) {
					System.out.println(spider.num);
					if(spider.num==1) {
						Spide.textArea.setText("");
						spider.num=1;
						Spide.label.setText("第一頁");
						for(int i=0;i<spider.data.size();i++) {
							database newdata2 = spider.data.get(i);//資料
							Spide.textArea.append("\n"+(i+1)+":");
			            	newdata2.getname();
			            	if(i>8) {
			            		break;
			            	}
			            	
						}
					}
					
					else if(spider.num==2) {//他在第二頁要回到第一頁
						Spide.textArea.setText("");
						spider.num=1;
						Spide.label.setText("第一頁");
						for(int i=0;i<spider.data.size();i++) {
							database newdata2 = spider.data.get(i);//資料
							Spide.textArea.append("\n"+(i+1)+":");
			            	newdata2.getname();
			            	if(i>8) {
			            		break;
			            	}
			            	
						}
						}
					else if(spider.num==3) {//他在第三頁要回到第二頁
							Spide.textArea.setText("");
							Spide.label.setText("第二頁");
							spider.num=2;
							int y=0;
							for(int i=10;i<20;i++) {
							database newdata2 = spider.data.get(i);//資料
							Spide.textArea.append("\n"+(i+1)+":");
			            	newdata2.getname();
			            	
			            		if(y>9) {
			            			break;
			            		}
							}
						}
						
				}
			});
		    Spide.button_3.addActionListener(new ActionListener() {//下一頁按鈕
				public void actionPerformed(ActionEvent e) {
					System.out.println(spider.num);
					int kk=0;
					if(spider.num==1&&spider.data.size()>10&&kk==0) {
						
						Spide.textArea.setText("");
						spider.num=2;
						Spide.label.setText("第二頁");
						int y=0;
						for(int i=10;i<spider.data.size();i++) {
							y++;
							database newdata2 = spider.data.get(i);//資料
							Spide.textArea.append("\n"+(i+1)+":");
			            	newdata2.getname();
			            	if(y>9) {
			            		break;
			            	}
						}
						kk=1;
					}
					else if(spider.num==2&&spider.data.size()>20&&kk==0) {//他在第二頁要到第三頁
						Spide.textArea.setText("");
						spider.num=3;
						Spide.label.setText("第三頁");
						int y=0;
						for(int i=20;i<spider.data.size()-1;i++) {
							database newdata2 = spider.data.get(i);//資料
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
		    Spide.button_4.addActionListener(new ActionListener() {//最後一頁按鈕
				public void actionPerformed(ActionEvent e) {
					System.out.println(spider.num);
					if(spider.data.size()>20) {
					Spide.textArea.setText("");
					spider.num=3;
					Spide.label.setText("第三頁");
					for(int i=20;i<spider.data.size()-1;i++) {
						database newdata2 = spider.data.get(i);//資料
						Spide.textArea.append("\n"+(i+1)+":");
		            	newdata2.getname();
		            
					}
					}
					else if(spider.data.size()>0&&spider.data.size()<=10) {
						Spide.textArea.setText("");
						spider.num=1;
						Spide.label.setText("第一頁");
						for(int i=0;i<spider.data.size();i++) {
							database newdata2 = spider.data.get(i);//資料
							Spide.textArea.append("\n"+(i+1)+":");
			            	newdata2.getname();
			            
						}
					}
					else if(spider.data.size()>10&&spider.data.size()<=20) {
						Spide.textArea.setText("");
						spider.num=2;
						Spide.label.setText("第二頁");
						for(int i=10;i<spider.data.size();i++) {
							database newdata2 = spider.data.get(i);//資料
							Spide.textArea.append("\n"+(i+1)+":");
			            	newdata2.getname();
			            
						}
						}
				}
			});
	}

}
