package startemail;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JRadioButton;
import javax.swing.JList;
import java.awt.TextArea;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.SwingConstants;

public class email {
	public static DefaultListModel<String> listModel2;
	private JFrame frame;
	public static JTextField textField;//帳號
	public static JPasswordField textField_1;//密碼
	public static JTextField textField_2;//收信人信箱
	public static JLabel label_3;
	public static JTextArea textArea;
	public static JButton button_1;
	public static JButton button_3;
	public static JButton button;
	public static JList list;
	public static String youremail="";
	public static int select=0;
	public static String listtext="";
	public static String ans="";
	public static String listselect="";
	public static TextArea textArea_1 ;
	public static String[] many;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					email window = new email();
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
	public email() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setBounds(50, 50, 1139, 611);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setTitle("郵件收發系統");
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		listModel2 = new DefaultListModel();
		
		JLabel label_5 = new JLabel("\u4F3A\u670D\u5668");
		panel.add(label_5);
		
		textField_4 = new JTextField();
		panel.add(textField_4);
		textField_4.setColumns(10);
		JLabel label = new JLabel("\u5E33\u865F");
		panel.add(label);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5BC6\u78BC");
		panel.add(label_1);
		
		textField_1 = new JPasswordField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u767B\u5165");//登入
		panel.add(button);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		splitPane.setLeftComponent(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.NORTH);
		
		JLabel label_2 = new JLabel("\u6536\u4FE1\u4EBA\u4FE1\u7BB1(\u591A\u4EBA\u4FE1\u7BB1\u8ACB\u52A0#)");
		panel_3.add(label_2);
		
		textField_2 = new JTextField();
		panel_3.add(textField_2);
		textField_2.setColumns(20);
		
		button_3 = new JButton("\u767B\u51FA");
		panel.add(button_3);
		
		label_3 = new JLabel("\u767B\u5165\u72C0\u614B");
		panel.add(label_3);
		label_3.setText("狀態");
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6, BorderLayout.NORTH);
		
		JLabel label_4 = new JLabel("\u4E3B\u65E8:");
		panel_6.add(label_4);
		
		textField_3 = new JTextField();//主旨
		panel_6.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		panel_4.add(panel_9, BorderLayout.SOUTH);
		
		button_1 = new JButton("\u9001\u51FA\u4FE1\u4EF6");
		panel_9.add(button_1);
		
		JButton button_6 = new JButton("\u6E05\u9664");
		panel_9.add(button_6);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_4.add(scrollPane_1, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		textArea.setToolTipText("\u8ACB\u5728\u7D50\u5C3E\u52A0\u5165\u53E5\u865F(.)");
		button_1.addActionListener(new ActionListener() {//左邊送出按鈕
			public void actionPerformed(ActionEvent e) {
				many=textField_2.getText().split("#");
				
				youremail=textField_2.getText();
				
				String h="";
				String[] a=h.split("");
				mainproc(a);
				
			}
		});
		
		JPanel panel_2 = new JPanel();
		splitPane.setRightComponent(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.NORTH);
		ButtonGroup buttonGroup = new ButtonGroup();
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("list");
		panel_5.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("retrive");
		panel_5.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("delete");
		panel_5.add(rdbtnNewRadioButton_2);
		JButton button_2 = new JButton("\u9001\u51FA");
		panel_5.add(button_2);
		buttonGroup.add(rdbtnNewRadioButton);
		buttonGroup.add(rdbtnNewRadioButton_1);
		buttonGroup.add(rdbtnNewRadioButton_2);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.3);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel_2.add(splitPane_1, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane_1.setLeftComponent(scrollPane);
		
		list = new JList(listModel2);
		scrollPane.setViewportView(list);
		
		JPanel panel_7 = new JPanel();
		splitPane_1.setRightComponent(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		textArea_1 = new TextArea();
		panel_7.add(textArea_1, BorderLayout.CENTER);
		textArea_1.setBackground(Color.WHITE);
		textArea_1.setEditable(false);
		
		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8, BorderLayout.SOUTH);
		
		JButton button_4 = new JButton("\u56DE\u8986");
		panel_8.add(button_4);
		
		JButton button_5 = new JButton("\u8F49\u5BC4");
		panel_8.add(button_5);
		list.addMouseListener(new MouseAdapter() {//右上點擊
	        @Override
	        public void mouseClicked(MouseEvent e) {
	           
	            listselect=(String)list.getSelectedValue();
	            String[] an=listselect.split(" ");
	            ans=an[0];
	            System.out.println(ans);
	            select=1;
				try {
					talk() ;
					update() ;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}   
	        }
	    });
		button_2.addActionListener(new ActionListener() {//右邊送出按鈕
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnNewRadioButton.isSelected()) {
					select=0;
					System.out.println(select);
					try {
						talk() ;
						update() ;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}   
		           
				}
				else if(rdbtnNewRadioButton_1.isSelected()) {
					select=1;
					System.out.println(select);
					try {
						talk() ;
						update() ;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}   
				}
				else if(rdbtnNewRadioButton_2.isSelected()) {
					select=2;
					System.out.println(select);
					try {
						talk() ;
						update() ;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}   
				}
			}
		});
		button_3.setVisible(false);
		button_3.addActionListener(new ActionListener() {//登出按鈕
			public void actionPerformed(ActionEvent e) {
				try {
					label_3.setText("未登入");
					button.setVisible(true);
					button_3.setVisible(false);
					listModel2.removeAllElements();
					textArea.setText("");
					textArea_1.setText("");
					getSingleLine("QUIT");
					pop.close(); 
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}   
		        
		        System.out.println("關閉連線");
				
			}
		});
		button_4.addActionListener(new ActionListener() {//回覆按鈕
			public void actionPerformed(ActionEvent e) {
				textField_2.setText("");
				textField_3.setText("");
				textArea.setText("");
				textArea.append("\n\n---------- Forwarded message ---------\n");
				textArea.append(textArea_1.getText());
				int ijk=textArea_1.getText().indexOf("Return-Path: <");
				//System.out.print(ijk);
				//bodytext.charAt(x+i);
				String content="";
				for(int i=ijk+14;i<textArea_1.getText().length();i++) {
					if(textArea_1.getText().charAt(i)!='>') {
						content=content+textArea_1.getText().charAt(i);
					}
					else {
						textField_2.setText("");
						textField_2.setText(content);
						break;
					}
				}
				
			}
		});
		button_5.addActionListener(new ActionListener() {//轉寄按鈕
			public void actionPerformed(ActionEvent e) {
				textField_2.setText("");
				textField_3.setText("");
				textArea.setText("");
				textArea.append("\n\n---------- Forwarded message ---------\n");
				textArea.append(textArea_1.getText());
				
			}
		});
		button_6.addActionListener(new ActionListener() {//清除按鈕
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		button.addActionListener(new ActionListener() {//登入按鈕
			public void actionPerformed(ActionEvent e) {
				//smtp.login();
				email.label_3.setText("已登入");
				button_3.setVisible(true);
				try {
					authorization() ;
					talk() ;   
		            update() ;
		            button.setVisible(false);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}   
			}
		});
	}
	//smtp
	final int SMTP_PORT=25;
	public static String smtp_server="";
	public static String my_email_addr="";
	public static String my_email_password="";
	public void sendcommandandresultcheck(Socket smtp,BufferedReader smtp_in,PrintWriter smtp_out,String command,int success_code)throws IOException{
		smtp_out.print(command+ "\r\n");
		smtp_out.flush();
		System.out.println("send>"+command);
		resultcheck(smtp,smtp_in,smtp_out,success_code);
	}
	public static void resultcheck(Socket smtp,BufferedReader smtp_in,PrintWriter smtp_out,int success_code) throws IOException {
		
		String res=smtp_in.readLine();
		System.out.println("recv>"+res);
		if(Integer.parseInt(res.substring(0,3))!=success_code) {
			smtp.close();
			throw new RuntimeException(res);
		}
	}
	public void send (String subject,String[] to,String[] msgs) throws IOException {
		//Socket smtp=new Socket(smtp_server,SMTP_PORT);//"stumail.nutn.edu.tw", 25
		Socket smtp=new Socket("stumail.nutn.edu.tw", 25);
		encode = new Base64();
		in = new BufferedReader(new InputStreamReader(smtp.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(smtp.getOutputStream()));
 
		BufferedReader smtp_in=new BufferedReader(new InputStreamReader(smtp.getInputStream()));
		PrintWriter smtp_out=new PrintWriter(smtp.getOutputStream());
		
		resultcheck(smtp,smtp_in,smtp_out,220);
		String myname=InetAddress.getLocalHost().getHostName();
		
		sendcommandandresultcheck(smtp,smtp_in,smtp_out,"HELO "+myname,250);
		
		sendcommandandresultcheck(smtp,smtp_in,smtp_out,"MAIL FROM:"+my_email_addr,250);
		sendCMD("AUTH LOGIN");
		if (getResult() == 334) {
			System.out
					.println("user is auth,palese send username and password");
		} else {
			System.err.println("auth fail.");
			label_3.setText("授權錯誤");
			
		}
 
		sendCMD(encode.encode(my_email_addr.getBytes()));
		if (getResult() == 334) {
			System.out.println("auth username.");
		} else {
			System.err.println("username is error.");
			label_3.setText("帳號錯誤");
		}
 
		sendCMD(encode.encode(my_email_password.getBytes()));
		if (getResult() == 235) {
			System.out.println("password right.");
			//button.setVisible(false);
			button_3.setVisible(true);
	}
		else {
			System.err.println("password is error.");
			label_3.setText("密碼錯誤");
		}
	
		for(int p=0;p<many.length;p++) {
		sendcommandandresultcheck(smtp,smtp_in,smtp_out,"RCPT TO:"+many[p],250);
		}
		//認證
		sendcommandandresultcheck(smtp,smtp_in,smtp_out,"DATA",354);
		String from=textField_4.getText();
		sendCMD("FROM: " + from);
		sendCMD("TO: " + to);
		smtp_out.print("Subject:"+textField_3.getText()+"\r\n");
		System.out.println("send>"+"Subject:"+textField_3.getText());
		smtp_out.print("\r\n");
		for(int i=0;i<msgs.length;i++) {
			smtp_out.print(msgs[i]+"\r\n");
			System.out.println("send>"+msgs[i]);
		sendcommandandresultcheck(smtp,smtp_in,smtp_out,"\r\n",250);
		
		sendCMD("QUIT");
		}
		smtp.close();
		
	}
	
	public void setaddress() {
		String buf="";
		BufferedReader lineared=new BufferedReader(new InputStreamReader(System.in));
		boolean cont=true;
		try {
			while(cont) {
				System.out.println("請輸入郵件伺服器位址:");
				smtp_server=textField_4.getText();
				System.out.println("請輸入你的電子郵件位址:");
				my_email_addr=textField.getText();
				System.out.println("請輸入你的電子郵件密碼:");
				my_email_password=textField_1.getText();
				System.out.println("郵件伺服器位址:"+smtp_server);
				System.out.println("你的電子郵件位址:"+my_email_addr);
				
				cont=false;
				
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	public String[] setmsgs() {
		String buf="";
		BufferedReader lineared=new BufferedReader(new InputStreamReader(System.in));
		boolean cont=true;
		Vector msgs_list=new Vector();
		String[] msgs=null;
		try {
			System.out.println("請輸入要發送的訊息");
			System.out.println("(用句號結束)");
			buf=textArea.getText();
			msgs_list.addElement(buf);
			cont=false;
			msgs=new String[msgs_list.size()];
			msgs_list.copyInto(msgs);
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		return(msgs);
	}
	public void mainproc(String[] args) {
		String usage="java Mail[-s subject]to-addr...";
		String subject="";
		Vector to_list=new Vector();
		for(int i=0;i<args.length;i++) {
			if("-s".equals(args[i])) {
				i++;
				subject=args[i];
			}
			else {
				to_list.addElement(args[i]);
			}
		}
		if(to_list.size()>0) {
			try {
				String[] to=new String[to_list.size()];
				to_list.copyInto(to);
				setaddress();
				String[] msgs=setmsgs();
				send(subject,to,msgs);
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		else {
			System.out.println("usage: "+usage);
		}
		
	}
	//認證
	public static Socket s = null;
	public static BufferedReader in = null;
	public static BufferedWriter out = null;
	static Base64 encode;
	public static void init() throws UnknownHostException, IOException {
		 
		s = new Socket(textField_4.getText(), 25);// get connection
 
		encode = new Base64();
 
		in = new BufferedReader(new InputStreamReader(s.getInputStream()));
 
		out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
 
		if (getResult() == 220) {
			System.out.println("connection ok.");
		} else {
			System.err.println("connection to failed.");
		}
 
		sendCMD("HELO " + smtp_server);
		if (getResult() == 250)
			System.out.println("service is register.");
		else {
			System.err.println("to register fail.");
 
		}
	}


	 private static void sendCMD(String cmd) throws IOException {
			out.write(cmd);
			out.newLine();
			out.flush();
	}
	public static void sendauth() throws IOException {
		if(smtp_server==null) {
			return;
		}
		int response = 0;
		//傳送認證指令至server
		//response= sendCmd("AUTH LOGIN", "");
		sendCMD("AUTH LOGIN");
		if (getResult() == 334) {
			System.out
					.println("user is auth,palese send username and password");
		} else {
			System.err.println("auth fail.");
			label_3.setText("授權錯誤");
		}
 
		sendCMD(encode.encode(my_email_addr.getBytes()));
		if (getResult() == 334) {
			System.out.println("auth username.");
		} else {
			System.err.println("username is error.");
			label_3.setText("帳號錯誤");
		}
 
		sendCMD(encode.encode(my_email_password.getBytes()));
		if (getResult() == 235) {
			System.out.println("password right.");
			button.setVisible(false);
			button_3.setVisible(true);
		}
		else {
			System.err.println("password is error.");
			label_3.setText("密碼錯誤");
		}
		
	}
	private static int getResult() throws IOException {
		 
		String line = in.readLine();
		System.out.println("from service msg:"+line);
		System.out.println(line.split("\\s")[0]);
		int status = 0;
		if (line != null) {
 
			StringTokenizer st = new StringTokenizer(line, " ");
 
			status = Integer.parseInt(st.nextToken());
 
		}
 
		return status;
	}

//smtp
	

	
//pop
	final int POP_PORT = 110;
    BufferedReader pop_in = null ;   
    PrintWriter pop_out = null ;
    Socket pop = null ;   
    private JTextField textField_3;
    private static JTextField textField_4;
    
    public void talk()   
        throws IOException   
    {   
        String buf = "" ;   
        BufferedReader lineread 
            = new BufferedReader(new InputStreamReader(System.in)) ;   
        boolean cont = true ;   
        while(cont){ 
            if(select==0) getLines("LIST") ;
            else if(select==1) {   
               
                String[] temp=listselect.split(" ");
                buf=temp[0];
                System.out.println("buf:"+buf);
                getLines("RETR " + buf) ;   
            } 
            else if(select==2){   
         
            	String[] temp=listselect.split(" ");
                buf=temp[0];
                getSingleLine("DELE " + buf) ;   
            } 
   
            cont=false;
        }   
    }   
    public void getLines(String command)   
        throws IOException   
    {   
    	
    	textArea_1.setText("");;
    	listtext="";
        boolean cont = true ;  
        String buf = null ;   
        pop_out.print(command +"\r\n");   
        pop_out.flush() ;  
        String res = pop_in.readLine();//讀取回覆
    
        if (!("+OK".equals(res.substring(0,3)))){   
            pop.close();
            throw new RuntimeException(res);   
        }   
 
        if(select==0) {
        	listModel2.removeAllElements();
        	while(cont){  
        		buf = pop_in.readLine();  
        		listtext=listtext+buf+"#";
        		if(".".equals(buf)) cont = false ;  
        	}   
        }
        else if(select==1) {
        	while(cont){  
        		final Base64 encoder = new Base64();
        		final Base64 decoder = new Base64();
        		buf = pop_in.readLine();  
        		textArea_1.append(buf);
        		textArea_1.append("\n");
        		if(".".equals(buf)) cont = false ;  
        	} 
        }
    }
    public static String toStringHex2(String s) {
	       byte[] baKeyword = new byte[s.length() / 2];
	       for (int i = 0; i < baKeyword.length; i++) {
	        try {
	         baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
	        } catch (Exception e) {
	         e.printStackTrace();
	        }
	       }
	       try {
	        s = new String(baKeyword, "utf-8");// UTF-16le:Not
	       } catch (Exception e1) {
	        e1.printStackTrace();
	       }
	       return s;
	    }
    public void listenter(String a) {
    	String[] liststr=a.split("#");
		   for(int i = 0; i < liststr.length; i++){
			   listModel2.addElement(liststr[i]);
    }
    }
    public void getSingleLine(String command)   
        throws IOException   
    {   
        pop_out.print(command +"\r\n");   
        pop_out.flush() ;   
        System.out.println(command) ;   
        String res = pop_in.readLine();
        System.out.println(res) ;   
        System.out.println("已刪除") ;
        if (!("+OK".equals(res.substring(0,3)))){   
        	label_3.setText("帳號或密碼錯誤");
        	button_3.setVisible(false);
            pop.close();
            throw new RuntimeException(res);   
        }   
    }
    public void authorization()   
        throws IOException   
    {   
        String buf = "" ;
        BufferedReader lineread   
            = new BufferedReader(new InputStreamReader(System.in)) ;   
        boolean cont = true ;   
        String pop_server = null ;   
        String username = null ;   
        String password = null ;   
   
          
        while(cont){ 
            System.out.println("請輸入POP的伺服器位址:") ;    
            pop_server=textField_4.getText();
            System.out.println("POP伺服器位址:");
            System.out.println(pop_server);   
            cont = false;
        }   
      
        pop = new Socket(pop_server, POP_PORT);   
        pop_in = new BufferedReader(new InputStreamReader(pop.getInputStream()));   
        pop_out = new PrintWriter(pop.getOutputStream());   
         
        String res = pop_in.readLine();
        System.out.println(res) ;   
       
        if (!("+OK".equals(res.substring(0,3)))){   
            pop.close();
            throw new RuntimeException(res);   
        }   
   
         
        cont = true ;   
        while(cont){  
            System.out.println("請輸入username:") ;     
            username=textField.getText();
            System.out.println("請輸入password:") ; 
            password =textField_1.getText();   
            System.out.println("username:"+ username) ;   
            System.out.println("password:"+ password) ;   
            System.out.println("以上輸入是否正確(Y/N)") ;   
            cont = false;
        }   
        getSingleLine("USER " + username) ; 
        getSingleLine("PASS " + password) ;
        
    }
    public void update()   
        throws IOException   
    {   
        // QUIT   
        listenter(listtext);
        System.out.println(listtext);
    }
    
   
    public void popmainproc(String[] args)   
        throws IOException   
    {   
        if(args.length == 0)   
                {   
            authorization() ;   
            talk() ;   
            update() ;   
        }   
                else   
                {   
            System.out.println("usage: java Pop ");   
        }   
    }   
     
  
}
