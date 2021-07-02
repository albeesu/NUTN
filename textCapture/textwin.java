package text;

import java.awt.EventQueue;

import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.util.regex.*;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
public class textwin {

	public JFrame frame;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public static String search;
	public static String first;
	public static String second;
	public static String thr;
	public static int a;
	public static int b;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					textwin window = new textwin();
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
	public textwin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 995, 564);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JButton button_2 = new JButton("\u6E05\u9664");
		panel.add(button_2);
		
		JLabel label = new JLabel("\u6B32\u64F7\u53D6\u5B57\u4E32");
		panel.add(label);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label2 = new JLabel("\u8D77\u59CB\u4F4D\u5740");
		panel.add(label2);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("\u7D42\u6B62\u4F4D\u5740");
		panel.add(label_1);
		
		textField_2 = new JTextField();
		panel.add(textField_2);
		textField_2.setColumns(10);
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton button_1 = new JButton("\u6E05\u9664\u5168\u90E8");
		panel_1.add(button_1, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
				
			JTextArea textArea_1 = new JTextArea();
			scrollPane.setViewportView(textArea_1);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			splitPane.setLeftComponent(scrollPane_1);
			
			JTextArea textArea = new JTextArea();
			scrollPane_1.setViewportView(textArea);
			textArea.setWrapStyleWord(true);
		
		
		JButton button = new JButton("\u9001\u51FA");
		panel.add(button);
		button.addActionListener(new ActionListener() {//搜尋按鈕
			public void actionPerformed(ActionEvent e) {
				textArea_1.setText("");
				search=textField.getText();
				first=textField_1.getText();
				second=textField_2.getText();
				a=Integer.parseInt(first);
				b=Integer.parseInt(second);
				thr=textArea.getText();
				System.out.println (search);
				
				
				String str = thr;
				Pattern p = Pattern.compile(search,Pattern.CASE_INSENSITIVE);
				Matcher m = p.matcher(str);
				// case 1
				while (m.find()) {
					//System.out.println (m.start()+1);
					//System.out.println (thr.charAt(m.start()+1));
					String content="";
					int num=b-a+1;//幾個數字
					for(int i=a;i<b;i++) {
						content=content+thr.charAt(m.start()+i);
					}
					textArea_1.append(content+"\n");
					
				}
				
//				for(int k=0;k<thr.length();k++) {
//					
//				}
//				if(thr.toLowerCase().contains(search.toLowerCase())) {
//					int x=thr.toLowerCase().indexOf(search.toLowerCase());
//					//number=appearNumber(bodytext.toLowerCase(),searchword.toLowerCase());
//					String content="";
//					int num=b-a+1;//幾個數字
//					for(int i=0;i<num;i++) {
//						content=content+thr.charAt(x+i);
//					}
//				}
				
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				textArea_1.setText("");
			}
		});
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		
	}

}
//if(bodytext.toLowerCase().contains(searchword.toLowerCase())) {
//	int x=bodytext.toLowerCase().indexOf(searchword.toLowerCase());
//	number=appearNumber(bodytext.toLowerCase(),searchword.toLowerCase());
//	content="";
//	for(int i=0;i<10;i++) {
//		content=content+bodytext.charAt(x+i);
//	}
//}
