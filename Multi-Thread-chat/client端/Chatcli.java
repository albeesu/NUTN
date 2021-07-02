package chatwindow;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;

public class Chatcli {

	public static JFrame frame;
	public static JTextField sendtext;
	public static JTextField textname;
	public static JTextArea textArea;
	public static JList online;
	public static int one=0;
	public static JButton send;
	public static DefaultListModel listModel2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chatcli window = new Chatcli();
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
	public Chatcli() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		Panel panel = new Panel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		sendtext = new JTextField();
		panel.add(sendtext);
		sendtext.setColumns(10);
		
		send = new JButton("Send");//送出訊息按鈕
		listModel2 = new DefaultListModel();
		panel.add(send);
		
		JButton btnClear = new JButton("clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");//清空畫面
				
			}
			
		});
		panel.add(btnClear);
		
		Panel panel_1 = new Panel();
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		Label label = new Label("\u804A\u5929\u5BA4(client)");
		panel_1.add(label);
		
		textname = new JTextField();//名稱框
		panel_1.add(textname);
		textname.setColumns(10);
		
		JButton button = new JButton("\u540D\u7A31\u78BA\u8A8D");
		button.addActionListener(new ActionListener() {//名字按鈕
			public void actionPerformed(ActionEvent e) {
				//傳送名字
				String name=textname.getText();
				//online.append(name);
				writethread.username=name;
				client chatclient=new client("localhost",1234);
				chatclient.execute();
				
				
			}
		});
		panel_1.add(button);
		
		textArea = new JTextArea();//訊息
		textArea.setEditable(false);
		textArea.setBackground(Color.PINK);
		textArea.append("\n enter your name on top textarea and click 名稱確認\n");
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
		
		Panel panel_2 = new Panel();
		frame.getContentPane().add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		online = new JList(listModel2);//在線列表
		online.setBackground(Color.WHITE);
		panel_2.add(online);
		
		Panel panel_3 = new Panel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		
		Label label_3 = new Label("\u4E0A\u7DDA\u5217\u8868");
		panel_3.add(label_3);
		
		
	}

}
