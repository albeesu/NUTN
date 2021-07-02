package chatwindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Console;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class writethread extends Thread{
	private Socket socket;
	private client chatclient;
	private PrintWriter writer;
	public static String text;
	public static String username;
	public writethread(Socket socket,client chatclient) {
		this.socket=socket;
		this.chatclient=chatclient;
		// TODO Auto-generated constructor stub
		try {
			OutputStream output=socket.getOutputStream();
			writer=new PrintWriter(output,true);
		}catch(IOException ex) {
			Chatcli.textArea.append("error get output stream"+ex.getMessage());
			ex.printStackTrace();
		}
	}
	public writethread() {
		
	}
	@SuppressWarnings("unchecked")
	public void run() {
		//Scanner ina=new Scanner(System.in);//輸入
		//System.out.println("\n enter your name:");
		//String username=ina.nextLine(); //注意
		
		chatclient.setusername(username);
		writer.println(username);
		Chatcli.listModel2.addElement(username);
		//Chatcli.online.append("\n "+username);
		//Chatcli.textArea.append("["+username+"]:");
		Chatcli.send.addActionListener(new ActionListener() {//送出訊息按鈕
			public void actionPerformed(ActionEvent e) {
					
					text=Chatcli.sendtext.getText();
					Chatcli.textArea.append("\n["+username+"]:"+text);
					writer.println(text);
				
			}
		});
		//text=ina.nextLine()"; //注意
		//writer.println(text);
		
		//try {
		//	socket.close();
		//}catch(IOException ex) {
		//	System.out.println("error write to server: "+ex.getMessage());
		//}
		Chatcli.frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					socket.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);// 退出程式
				
			}
		});
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
