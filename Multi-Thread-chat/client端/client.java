package chatwindow;


import java.io.IOException;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.util.Scanner;

public class client extends Thread{
private String hostname;
private int port;
private String username;
	public client(String hostname,int port) {
		this.hostname=hostname;
		this.port=port;
		// TODO Auto-generated constructor stub
	}
	public void execute() {
		try {
			Socket socket=new Socket(hostname,port);
			Chatcli.textArea.append("connected to the chat server\n");
			
			new readthread(socket,this).start();
			new writethread(socket,this).start();
		}catch(UnknownHostException ex) {
			Chatcli.textArea.append("\nserver not found" +ex.getMessage());
		}catch(IOException ex) {
			Chatcli.textArea.append("\nI/O error:"+ex.getMessage());
		}
	}
	
	void setusername(String username) {
		this.username=username;
	}
	String getusername() {
		return this.username;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		client chatclient=new client("localhost",1234);
		chatclient.execute();
	}

}

