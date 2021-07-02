
import java.awt.EventQueue;
import java.nio.file.Paths;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JList;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
public class Ftpwin {

	public static JFrame frame;
	public static JTextField textField;
	public static JSplitPane splitPane;
	public static JScrollPane scrollPane;
	public static JScrollPane scrollPane_1;
	public static Label label;
	public static Label label_1;
	public static JSplitPane splitPane_1;
	public static JPanel panel_1;
	public static JMenu menu;
	public static JMenu type1;
	public static int select1=0;
	public static String t=System.getProperty("user.dir");
	public static String t2="\\";
	//public static ftp ftp1=new ftp();
	public static JMenuItem mItem1;
	public static JMenuItem mItem2;
	public static JMenuItem mItem3;
	public static JMenuItem mItem4;
	public static JMenuItem mItem5;
	public static JMenuItem mItem6;
	public static JMenuItem mItem7;
	public static JMenuItem mItem8;
	public static JMenuItem mItem9;
	public static JMenuItem mItem10;
	public static JMenuItem mItem11;
	public static JMenuItem mItem12;
	public static JMenuBar menuBar;
	public static boolean flag=false;
	public DefaultListModel<String> listModel;
	public DefaultListModel<String> listModel2;
	
	/**
	 * Launch the application.
	 */
	Socket ctrlSocket;
	 public PrintWriter ctrlOutput;
	 public BufferedReader ctrlInput;
	 //public ftp f;
	 final int CTRLPORT = 21 ;
	 private JPanel panel_2;
	 private JTextField textField_1;
	 private JTextField textField_2;
	 public static JList list_2;
	 private JPanel panel;
	 public static JList list_1;
	 private JButton btnc;
	 private JPanel panel_3;
	 public static JTextArea textArea_2;
	 private Label label_3;


	 public void openConnection(String host)
	  throws IOException,UnknownHostException
	 {
	  ctrlSocket = new Socket(host, CTRLPORT);
	  ctrlOutput = new PrintWriter(ctrlSocket.getOutputStream());
	  ctrlInput
	   = new BufferedReader(new InputStreamReader
	        (ctrlSocket.getInputStream()));
	 }


	 public void closeConnection()
	  throws IOException
	 {
	  ctrlSocket.close() ;
	 }


	 public void showMenu()
	 {
	  System.out.println(">Command?") ;
	  System.out.print("1 login") ;
	  System.out.print("2 ls") ;
	  System.out.print(" 3 cd") ;
	  System.out.print(" 4 get") ;
	  System.out.print(" 5 put") ;
	  System.out.print(" 6 ascii") ;
	  System.out.print(" 7 binary") ;
	  System.out.print(" 8 delete") ;
	  System.out.print(" 9 remove") ;
	  System.out.print(" A MKD") ;
	  System.out.print(" B PWD") ;
	  System.out.print(" C NLST") ;
	  System.out.println(" D quit") ;
	 }

	 
	 public String getCommand()
	 {
	  String buf = "" ;
	  BufferedReader lineread
	   = new BufferedReader(new InputStreamReader(System.in)) ;

	  while(buf.length() != 1){
	   try{
	    buf = lineread.readLine() ;
	   }catch(Exception e)
	   {
	    e.printStackTrace();
	    System.exit(1);
	   }
	  }
	  return (buf) ;
	 }


	 public void doLogin()
	 {
	  String loginName = "" ;
	  String password = "" ;
	  BufferedReader lineread
	   = new BufferedReader(new InputStreamReader(System.in)) ;
	  try{
	  // System.out.println("輸入名稱") ;
	  // loginName = lineread.readLine() ;
	   //loginName ="localhost";
	   loginName= textField_2.getText();
	   ctrlOutput.println("USER "+loginName) ;
	   ctrlOutput.flush() ;

	   //System.out.println("輸入密碼") ;
	  // password = lineread.readLine() ;
	   //password ="123";
	   password= textField_1.getText();
	   ctrlOutput.println("PASS " + password) ;
	   ctrlOutput.flush() ;
	   
	  }catch(Exception e)
	  {
	   e.printStackTrace();
	   System.exit(1);
	  }
	 }


	 public void doQuit()
	 {
	  try{
	   ctrlOutput.println("QUIT ") ;
	   ctrlOutput.flush() ;
	  }catch(Exception e)
	  {
	   e.printStackTrace();
	   System.exit(1);
	  }
	 }


	 public void doCd()
	 {
	  String dirName = "" ;
	  BufferedReader lineread
	   = new BufferedReader(new InputStreamReader(System.in)) ;

	  try{
	  // System.out.println("輸入目錄") ;
	   //dirName = lineread.readLine() ;
	   dirName =textField.getText();
	   ctrlOutput.println("CWD " + dirName) ;// CWD命令
	   ctrlOutput.flush() ;
	  }catch(Exception e)
	  {
	   e.printStackTrace();
	   System.exit(1);
	  }
	 }


	 public void doLs()
	 {
	 // try{
	   int n ;
	   byte[] buff = new byte[1024] ;
	   try{
	  Socket dataSocket = dataConnection("LIST") ;
	   
	   BufferedInputStream dataInput
	    = new BufferedInputStream(dataSocket.getInputStream()) ;
	   
	   String a="";
	   while((n = dataInput.read(buff)) > 0){
	    System.out.write(buff,0,n) ;
	    
	    for (int i=0; i<buff.length; i++) {
	        a=a+((char)buff[i]);
	    }
	 
	    //listModel2.addElement(a);
	    
	   }
	   textArea_2.append(a);
	   //list_2= new JList(listModel2);
	   dataSocket.close() ;
	  }catch(Exception e)
	  {
	   e.printStackTrace();
	   System.exit(1);
	  }
	   /*String folderPath2 = "C:\\";//資料夾路徑
       StringBuffer fileList2 = new StringBuffer();
           try{
              java.io.File folder2 = new java.io.File(folderPath);
              String[] list2 = folder2.list();          
                        for(int i = 0; i < list2.length; i++){
                            //textArea.append(list[i]+"\n");
                       	 listModel2.addElement(list2[i]);
                       }
                        //list_1= new JList(listModel);
               }catch(Exception e){
                     System.out.println("'"+folderPath2+"'此資料夾不存在");
               }
       System.out.println(fileList2);
	   */
	 }
	 

	 public Socket dataConnection(String ctrlcmd)
	 {
	  String cmd = "PORT " ; 
	  int i ;
	  Socket dataSocket = null ;
	  try{
	   //byte[] address = InetAddress.getLocalHost().getAddress() ;
	   byte[] address = InetAddress.getByName("localhost").getAddress() ;//添加+防火牆
	   ServerSocket serverDataSocket = new ServerSocket(0,1) ;
	   
	   for(i = 0; i < 4; ++i)
	    cmd = cmd + (address[i] & 0xff) + "," ;
	   cmd = cmd + (((serverDataSocket.getLocalPort()) / 256) & 0xff)
	       + ","
	       + (serverDataSocket.getLocalPort() & 0xff) ;
	   
	   ctrlOutput.println(cmd) ;
	   ctrlOutput.flush() ;
	   
	   ctrlOutput.println(ctrlcmd) ;
	   ctrlOutput.flush() ;
	  
	   dataSocket = serverDataSocket.accept() ;
	   serverDataSocket.close() ;
	  }catch(Exception e)
	  {
	   e.printStackTrace();
	   System.exit(1);
	  }
	  return dataSocket ;
	 }

	 
	 public void doAscii()
	 {
	  try{
	   ctrlOutput.println("TYPE A") ;
	   ctrlOutput.flush() ;
	  }catch(Exception e)
	  {
	   e.printStackTrace();
	   System.exit(1);
	  }
	 }


	 public void doBinary()
	 {
	  try{
	   ctrlOutput.println("TYPE I") ;
	   ctrlOutput.flush() ;
	  }catch(Exception e)
	  {
	   e.printStackTrace();
	   System.exit(1);
	  }
	 }

	 public void doGet()
	 {
	  String fileName = "" ;
	  BufferedReader lineread
	   = new BufferedReader(new InputStreamReader(System.in)) ;
	  try{
	   int n ;
	   byte[] buff = new byte[1024] ;
	  
	   //System.out.println("輸入文件名稱") ;
	   //fileName = lineread.readLine() ;
	   //textField.setText("");
	   fileName =textField.getText().toString();
	   fileName=fileName.trim();
	   FileOutputStream outfile = new FileOutputStream(fileName) ;
	   
	   Socket dataSocket = dataConnection("RETR " + fileName) ;
	   BufferedInputStream dataInput
	    = new BufferedInputStream(dataSocket.getInputStream()) ;
	 
	   while((n = dataInput.read(buff)) > 0){
	    outfile.write(buff,0,n) ;
	   }
	   dataSocket.close() ;
	   outfile.close() ;
	  }catch(Exception e)
	  {
	   e.printStackTrace();
	   System.exit(1);
	  }
	 }


	 public void doPut()
	 {
	  String fileName = "" ;
	  BufferedReader lineread
	   = new BufferedReader(new InputStreamReader(System.in)) ;

	  try{
	   int n ;
	   byte[] buff = new byte[1024] ;
	   FileInputStream sendfile = null ;


	   
	   //fileName = lineread.readLine() ;
	   fileName =textField.getText().toString();
	   fileName=fileName.trim();
	   try{
	    sendfile = new FileInputStream(fileName) ;
	   }catch(Exception e){
	    System.out.println("文件不存在") ;
	    return ;
	   }


	   Socket dataSocket = dataConnection("STOR " + fileName) ;
	   OutputStream outstr = dataSocket.getOutputStream() ;

	   while((n = sendfile.read(buff)) > 0){
	    outstr.write(buff,0,n) ;
	   }
	   dataSocket.close() ;
	   sendfile.close() ;
	  }catch(Exception e)
	  {
	   e.printStackTrace();
	   System.exit(1);
	  }
	 }
	 public void doDele()
	 {
		 String fileName = "" ;
		  BufferedReader lineread
		   = new BufferedReader(new InputStreamReader(System.in)) ;
		  try{
		   int n ;
		   byte[] buff = new byte[1024] ;
		  
		   fileName =textField.getText().toString();
		   fileName=fileName.trim();
		   FileOutputStream outfile = new FileOutputStream(fileName) ;
		   ctrlOutput.println("DELE " + fileName) ;// CWD命令
		   ctrlOutput.flush() ;
		   /*Socket dataSocket = dataConnection("DELE " + fileName) ;
		   BufferedInputStream dataInput
		    = new BufferedInputStream(dataSocket.getInputStream()) ;
		 
		   while((n = dataInput.read(buff)) > 0){
		    outfile.write(buff,0,n) ;
		   }
		   dataSocket.close() ;
		   outfile.close() ;*/
		  }catch(Exception e)
		  {
		   e.printStackTrace();
		   System.exit(1);
		  }
	 }
	 public void doRmd()
	 {
	  String dirName = "" ;
	  BufferedReader lineread
	   = new BufferedReader(new InputStreamReader(System.in)) ;
	  try{
	   int n ;
	   byte[] buff = new byte[1024] ;
	  
	   System.out.println("輸入欲刪除之目錄名稱") ;
	   //dirName = lineread.readLine() ;
	   //textField.setText("");
	   dirName =textField.getText().toString();
	   dirName= dirName.trim();
	  
	   ctrlOutput.println("RMD " + dirName) ;// CWD命令
	   ctrlOutput.flush() ;
	  }catch(Exception e)
	  {
	   e.printStackTrace();
	   System.exit(1);
	  }
	 }
	 public void doMkd()
	 {
	  String dirName = "" ;
	  BufferedReader lineread
	   = new BufferedReader(new InputStreamReader(System.in)) ;
	  try{
	   int n ;
	   byte[] buff = new byte[1024] ;
	  
	   System.out.println("輸入欲建立之目錄名稱") ;
	   //dirName = lineread.readLine() ;
	   dirName =textField.getText();
	  /*
	   FileOutputStream outfile = new FileOutputStream(dirName) ;
	   
	   Socket dataSocket = dataConnection("MKD " + dirName) ;
	   BufferedInputStream dataInput
	   = new BufferedInputStream(dataSocket.getInputStream()) ;

	  while((n = dataInput.read(buff)) > 0){
	   outfile.write(buff,0,n) ;
	  }
	  dataSocket.close() ;
	  outfile.close() ;
	  */
	   ctrlOutput.println("MKD " + dirName) ;// CWD命令
	   ctrlOutput.flush() ;
	 }catch(Exception e)
	 {
	  e.printStackTrace();
	  System.exit(1);
	 }
	 }
	 public void doPwd()
	 {
	   int n ;
	   byte[] buff = new byte[1024] ;

	  
	   try{
			  
		   ctrlOutput.println("PWD") ;// PWD命令
		   ctrlOutput.flush() ;
	  }catch(Exception e)
	  {
	   e.printStackTrace();
	   System.exit(1);
	  }
	 }
	 public void doNlst()
	 {
		 int n ;
		   byte[] buff = new byte[1024] ;

		  
		   try{
		   Socket dataSocket = dataConnection("NLST") ;
		   
		   BufferedInputStream dataInput
		    = new BufferedInputStream(dataSocket.getInputStream()) ;
		   
		   String a="";
		   while((n = dataInput.read(buff)) > 0){
		    //System.out.write(buff,0,n) ;
		    for (int i=0; i<buff.length; i++) {
		        a=a+((char)buff[i]);
		    }
		    
		   }
		   //textArea_2.append(a);
		   String[] list=a.split("\n");
		   for(int i = 0; i < list.length; i++){
               //textArea.append(list[i]+"\n");
			   listModel2.addElement(list[i]);
               
          }
		   //listModel2.addElement(a);
		   list_2= new JList(listModel2);
		   dataSocket.close() ;
		  }catch(Exception e3)
		  {
		   e3.printStackTrace();
		   System.exit(1);
		  }
	 }
	 public boolean execCommand(String command)
	 {
	  boolean cont = true ;

	  switch(command){
	  
	  case "1" :
		doLogin();
		break ;
	  case "2" :
	   doLs();
	   break;
	  case "3": 
	   doCd();
	   break ;
	  case "4":
	   doGet();
	   break ;
	  case "5": 
	   doPut();
	   break ;
	  case "6": 
	   doAscii();
	   break;
	  case "7": 
	   doBinary();
	   break;
	  case "8": 
	   doDele();
	   break;
	  case "9": 
	   doRmd();
	   break;
	  case "A": 
	   doMkd();
	   break;
	  case "B": 
	   doPwd();
	   break;
	  case "C": 
	   doNlst();
	   break;
	  case "D": 
	   doQuit() ;
	   cont = false ;
	   break ;
	  default : 
	   System.out.println("請選擇一個號碼") ;
	  }
	  return(cont) ;
	 }


	 public void main_proc()
	  throws IOException
	 {
	  boolean cont = true ;
	  try {
	   //doLogin() ;
	   while(cont){
	   showMenu() ;
	   cont = execCommand(getCommand()) ;
	   }
	  }
	  catch(Exception e){
	   System.err.print(e);
	   System.exit(1);
	  }
	 }
	  public void getFileList(){
		  
	        String folderPath = System.getProperty("user.dir");//資料夾路徑
	        StringBuffer fileList = new StringBuffer();
	            try{
	               java.io.File folder = new java.io.File(folderPath);
	               String[] list = folder.list();          
	                         for(int i = 0; i < list.length; i++){
	                        	 
	                             //textArea.append(list[i]+"\n");
	                        	 listModel.addElement(list[i]);
	                             
	                        }
	                         //list_1= new JList(listModel);
	                }catch(Exception e){
	                	textArea_2.append("'"+folderPath+"'此資料夾不存在"+"\n");
	                }
	                System.out.println(fileList);
	  }
	
	 public void getMsgs(){
	  try {
	   ctrllisten listener = new ctrllisten(ctrlInput) ;
	   Thread listenerthread = new Thread(listener) ;
	   listenerthread.start() ;
	  }catch(Exception e){
	   e.printStackTrace() ;
	   System.exit(1) ;
	  }
	 }

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ftpwin window = new Ftpwin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		 try {
			   Ftpwin f = null;

			   
			   f = new Ftpwin();
			   f.openConnection("127.0.0.1"); 
			   f.getMsgs() ; 
			   //f.main_proc(); 
			   //f.closeConnection() ; 
			   //System.exit(0) ; 
			  }catch(Exception e){
			   e.printStackTrace();
			   System.exit(1);
			  }
		
	}

	/**
	 * Create the application.
	 */
	public Ftpwin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 773, 602);
		frame.setTitle("FTP Client");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.1);
		listModel = new DefaultListModel();
		listModel2 = new DefaultListModel();
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		
		label_1 = new Label("local");
		scrollPane.setColumnHeaderView(label_1);
		
		splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setResizeWeight(0.5);
		scrollPane.setViewportView(splitPane_1);
		
		panel = new JPanel();
		splitPane_1.setLeftComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		//list_1 = new JList();
		
		
		btnc = new JButton("\u56DE\u539F\u672C\u8DEF\u5F91");
		panel.add(btnc, BorderLayout.SOUTH);
		btnc.addActionListener(new ActionListener() {//ls
			public void actionPerformed(ActionEvent e) {
				
				 String folderPath = System.getProperty("user.dir");//資料夾路徑
				 t=System.getProperty("user.dir");
				 System.out.println(System.getProperty("user.dir"));
			        StringBuffer fileList = new StringBuffer();
			        listModel.removeAllElements();
			            try{
			               java.io.File folder = new java.io.File(folderPath);
			               String[] list = folder.list();          
			                         for(int i = 0; i < list.length; i++){
			                        	 
			                             //textArea.append(list[i]+"\n");
			                        	 listModel.addElement(list[i]);
			                             
			                        }
			                         //list_1= new JList(listModel);
			                }catch(Exception e2){
			                	textArea_2.append("/"+folderPath+"'此資料夾不存在"+"\n");
			                }
			                System.out.println(fileList);
			}
		});
		
		
		String folderPath = System.getProperty("user.dir");//資料夾路徑
        StringBuffer fileList = new StringBuffer();
            try{
               java.io.File folder = new java.io.File(folderPath);
               String[] list = folder.list();          
                         for(int i = 0; i < list.length; i++){
                             //textArea.append(list[i]+"\n");
                        	 listModel.addElement(list[i]);
                        }
                         //list_1= new JList(listModel);
                }catch(Exception e){
                	textArea_2.append("'"+folderPath+"'此資料夾不存在"+"\n");
                }
        System.out.println(fileList);
        list_1= new JList(listModel);
        panel.add(list_1, BorderLayout.CENTER);
        
        panel_3 = new JPanel();
        splitPane_1.setRightComponent(panel_3);
        panel_3.setLayout(new BorderLayout(0, 0));
        list_2 = new JList(listModel2);
        panel_3.add(list_2, BorderLayout.CENTER);
        
        label_3 = new Label("client");
        panel_3.add(label_3, BorderLayout.NORTH);
        
        list_2.addMouseListener(new MouseAdapter() {//右上點擊
            @Override
            public void mouseClicked(MouseEvent e) {
            	textField.setText("");
            	String h=(String)list_2.getSelectedValue();
            	textField.setText(h);
            	System.out.println(list_2.getSelectedIndex());
                     
            }
        });
        
        list_1.addMouseListener(new MouseAdapter() {//左上點擊
            @Override
            public void mouseClicked(MouseEvent e) {
            	String folderPath = t+"\\"+(String)list_1.getSelectedValue()+"\\";//資料夾路徑
            	t=t+"\\"+(String)list_1.getSelectedValue()+"\\";//資料夾路徑
                StringBuffer fileList = new StringBuffer();
                listModel.removeAllElements();
                    try{
                       java.io.File folder = new java.io.File(folderPath);
                       String[] list = folder.list();          
                                 for(int i = 0; i < list.length; i++){
                                     //textArea.append(list[i]+"\n");
                                	 listModel.addElement(list[i]);
                                }
                                 //list_1= new JList(listModel);
                        }catch(Exception e1){
                        	textArea_2.append("'"+folderPath+"'此資料夾不存在"+"\n");
                        }
                    //list_1= new JList(listModel);
            }
        });
   
		scrollPane_1 = new JScrollPane();
		splitPane.setRightComponent(scrollPane_1);
		
		panel_1 = new JPanel();
		scrollPane_1.setViewportView(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel_2.setForeground(Color.YELLOW);
		panel_1.add(panel_2, BorderLayout.SOUTH);
		
		textField_2 = new JTextField();//account
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		textField_1 = new JTextField();//password
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u767B\u5165");
		button.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(button);
		
		JLabel label_2 = new JLabel("");
		panel_2.add(label_2);
		//panel.add(menu);
		menuBar = new JMenuBar();
		panel_2.add(menuBar);
		
		menu = new JMenu("\u6307\u4EE4");
		menuBar.add(menu);
		mItem1 = new JMenuItem("ls");
		mItem2 = new JMenuItem("cd");
		mItem3 = new JMenuItem("get");
		mItem4 = new JMenuItem("put");
		
		type1=new JMenu("type");
		mItem5 = new JMenuItem("ascii");
		mItem6 = new JMenuItem("binary");
		type1.add(mItem5);
		type1.add(mItem6);
		mItem7 = new JMenuItem("delete");
		mItem8 = new JMenuItem("RMD");
		mItem9 = new JMenuItem("MKD");
		mItem10 = new JMenuItem("PWD");
		mItem11 = new JMenuItem("NLST");
		mItem12 = new JMenuItem("QUIT");
		menu.add(mItem1);
		menu.add(mItem2);
		menu.add(mItem3);
		menu.add(mItem4);
		menu.add(type1);
		menu.add(mItem7);
		menu.add(mItem8);
		menu.add(mItem9);
		menu.add(mItem10);
		menu.add(mItem11);
		menu.add(mItem12);
		
		mItem1.addActionListener(new ActionListener() {//ls
			public void actionPerformed(ActionEvent e) {
				label_2.setText("ls");
				select1=1;
				textField.setVisible(false);
			}
		});
		mItem2.addActionListener(new ActionListener() {//cd
			public void actionPerformed(ActionEvent e) {
				label_2.setText("cd");
				select1=2;
				textField.setVisible(true);
			}
		});
		mItem3.addActionListener(new ActionListener() {//get
			public void actionPerformed(ActionEvent e) {
				label_2.setText("get");
				select1=3;
				textField.setVisible(true);
			}
		});
		mItem4.addActionListener(new ActionListener() {//put
			public void actionPerformed(ActionEvent e) {
				label_2.setText("put");
				select1=4;
				textField.setVisible(true);
			}
		});
		
		mItem5.addActionListener(new ActionListener() {//ascii
			public void actionPerformed(ActionEvent e) {
				label_2.setText("ascii");
				select1=5;
				textField.setVisible(false);
			}
		});
		mItem6.addActionListener(new ActionListener() {//binary
			public void actionPerformed(ActionEvent e) {
				label_2.setText("binary");
				select1=6;
				textField.setVisible(false);
			}
		});
		mItem7.addActionListener(new ActionListener() {//delete
			public void actionPerformed(ActionEvent e) {
				label_2.setText("delete");
				select1=7;
				textField.setVisible(true);
			}
		});
		mItem8.addActionListener(new ActionListener() {//RMD
			public void actionPerformed(ActionEvent e) {
				label_2.setText("RMD");
				select1=8;
				textField.setVisible(true);
			}
		});
		mItem9.addActionListener(new ActionListener() {//MKD
			public void actionPerformed(ActionEvent e) {
				label_2.setText("MKD");
				select1=9;
				textField.setVisible(true);
			}
		});
		mItem10.addActionListener(new ActionListener() {//PWD輸出當前絕對路徑
			public void actionPerformed(ActionEvent e) {
				label_2.setText("PWD");
				select1=10;
				textField.setVisible(false);
			}
		});
		mItem11.addActionListener(new ActionListener() {//NLST
			public void actionPerformed(ActionEvent e) {
				label_2.setText("NLST");
				select1=11;
				textField.setVisible(false);
			}
		});
		mItem12.addActionListener(new ActionListener() {//QUIT
			public void actionPerformed(ActionEvent e) {
				label_2.setText("QUIT");
				select1=12;
				textField.setVisible(false);
			}
		});
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(textField);
		textField.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("\u9001\u51FA");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(btnNewButton);
		
		label = new Label("server");
		panel_1.add(label, BorderLayout.NORTH);
		label.setAlignment(Label.CENTER);
		
		
		
        
		btnNewButton.addActionListener(new ActionListener() {//送出按鈕
			public void actionPerformed(ActionEvent e) {
				//textField.getText();
				if(select1==1) {
					doLs();
				}
				else if(select1==2) {
					doCd();
					
				}
				else if(select1==3) {
					//ftp1.doGet();
					doGet();
					//doDele();
				}
				else if(select1==4) {
					doPut();
				}
				else if(select1==5) {
					doAscii();
				}
				else if(select1==6) {
					doBinary();
				}
				else if(select1==7) {
					doDele();
				}
				else if(select1==8) {
					doRmd();
				}
				else if(select1==9) {
					doMkd();
				}
				else if(select1==10) {
					doPwd();
				}
				else if(select1==11) {
					 int n ;
					   byte[] buff = new byte[1024] ;
					   try{			   
					   Socket dataSocket = dataConnection("NLST") ;
					   BufferedInputStream dataInput
					    = new BufferedInputStream(dataSocket.getInputStream()) ;
					   listModel2.removeAllElements();
					   String a="";
					   while((n = dataInput.read(buff)) > 0){
					    //System.out.write(buff,0,n) ;
					    for (int i=0; i<buff.length; i++) {
					        a=a+((char)buff[i]);
					    }
					    
					   }
					   //textArea_2.append(a);
					   String[] list=a.split("\n");
					   for(int i = 0; i < list.length; i++){
					   listModel2.addElement(list[i]);
			          }
					   //listModel2.addElement(a);
					   
					  // list_2= new JList(listModel2);
					   dataSocket.close() ;
					  }catch(Exception e3)
					  {
					   e3.printStackTrace();
					   System.exit(1);
					  }
				}
				else if(select1==12) {
					doQuit();
					return;
				}
				
			}
		});
		
		textArea_2 = new JTextArea();
		panel_1.add(textArea_2, BorderLayout.CENTER);
		textField.setVisible(false);
		button.addActionListener(new ActionListener() {//登入按鈕
			public void actionPerformed(ActionEvent e) {
				//ftp1.start();
				doLogin();
				//getFileList();
				menuBar.setVisible(true);
				textField.setVisible(true);
				textField_1.setVisible(false);
				textField_2.setVisible(false);
				button.setVisible(false);
			}
		});
	}
}
