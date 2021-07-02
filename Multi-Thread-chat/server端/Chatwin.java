package chatwindow;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.TextArea;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Chatwin {
	private ServerSocket serverSocket;
	private JFrame frame;
	private static JTextField portinput;
	public static JTextArea contextArea;
	public static JButton btnNewButton;
	public static JList textArea;
	public static DefaultListModel listModel;
	/**
	 * Create the application.
	 */
	public Chatwin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("\u591A\u4EBA\u804A\u5929\u5BA4");
		panel.add(label);
		
		JLabel lblPort = new JLabel("port");
		panel.add(lblPort);
		
		portinput = new JTextField();
		panel.add(portinput);
		portinput.setColumns(10);
		
		
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel label_2 = new JLabel("\u5728\u7DDA\u5217\u8868");
		panel_1.add(label_2, BorderLayout.NORTH);
		listModel = new DefaultListModel();
		textArea = new JList(listModel);
		textArea.setBackground(Color.ORANGE);
		panel_1.add(textArea, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel label_3 = new JLabel("\u8A0A\u606F");
		panel_3.add(label_3, BorderLayout.NORTH);
		
		contextArea = new JTextArea();
		contextArea.setEditable(false);
		contextArea.setForeground(Color.black);
		panel_3.add(contextArea, BorderLayout.CENTER);
		
		JButton btnNewButton_1 = new JButton("\u7D50\u675F");
		btnNewButton_1.addActionListener(new ActionListener() {//結束按鈕
			public void actionPerformed(ActionEvent e) {
				System.exit(0);// 退出程式
			}
		});
		panel_3.add(btnNewButton_1, BorderLayout.SOUTH);
		
		JButton button = new JButton("\u6E05\u7A7A\u8A0A\u606F");//清空按鈕
		panel_3.add(button, BorderLayout.EAST);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contextArea.setText("");//清空畫面
				
			}
			
		});
		portinput.setText("1234");
		btnNewButton = new JButton("\u555F\u52D5");
		btnNewButton.addActionListener(new ActionListener() {//port按鈕
			public void actionPerformed(ActionEvent arg0) {
				
				port = Integer.parseInt(portinput.getText());
				serverthread sthread2 = new serverthread(serverSocket, port);
				sthread2.start();
			}
			
		});
		panel.add(btnNewButton);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);// 退出程式
			}
		});
	}
	
	/**
	 * Launch the application.
	 */
	private Set<serverthread> sthread=new HashSet<>();;
	private int port;
	private Set<String> usernames=new HashSet<>();
	private Set<userthread> userthreads=new HashSet<>();
	public Chatwin(int port) {
		this.port=port;
		// TODO Auto-generated constructor stub
	}
	
	
	public static void main(String[] args) {
		new Chatwin();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chatwin window = new Chatwin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	
	
	
	

	



	
}
