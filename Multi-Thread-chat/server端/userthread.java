package chatwindow;

import java.io.*;
import java.net.*;
import java.util.*;
public class userthread  extends Thread{
private Socket socket;
private serverthread server;
private PrintWriter write;
public String[] arr;
public static int a1=0;
public String username2;
	public userthread(Socket socket,serverthread serverthread){
		this.socket=socket;
		this.server=serverthread;
		// TODO Auto-generated constructor stub
	}
	public void run() {
		try {
			InputStream input=socket.getInputStream();
			BufferedReader reader=new BufferedReader(new InputStreamReader(input));
			
			OutputStream output=socket.getOutputStream();
			write=new PrintWriter(output,true);
			
			printusers();
			
			String username=reader.readLine();
			server.addusername(username);
			username2= username;
			String serverMessage="bigtext0@"+username;//new user connected: 
			server.broadcast(serverMessage, this);
			server.addusername2(username);
			String clientmessage;
			do {
				clientmessage=reader.readLine();
				serverMessage="["+username+"]:"+clientmessage;
				server.broadcast(serverMessage, this);
			}while(!clientmessage.equals("bye"));
			
			server.removeuser(username, this);
			socket.close();
			
			serverMessage="onlinetext2@"+username;//"has quitted"
			server.broadcast(serverMessage, this);
	
		}catch(IOException ex) {
			Chatwin.contextArea.append("error in userthread:" +ex.getMessage());
			ex.printStackTrace();
		}
	}
	void printusers() {
		if(server.hasdusers()) {
			write.println("bigtext1@"+server.getusernames());//+"connect user: "
			write.println("onlinetext@"+server.getusernames());
		}
		else {
			write.println("bigtext2@"+"no other users connected");
		}
	}
	
	void sendMessage(String message) {
		write.println(message);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
