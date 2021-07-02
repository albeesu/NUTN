package chatwindow;

import java.awt.EventQueue;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class serverthread extends Thread{
	private ServerSocket serverSocket;
	private int port;
	private Set<String> usernames=new HashSet<>();
	private Set<userthread> userthreads=new HashSet<>();
	public serverthread(ServerSocket serverSocket, int port) {
		this.serverSocket = serverSocket;
		this.port = port;
	}
	public void run() {
		excute();
	}
	public void excute() {
		try(ServerSocket seversocket=new ServerSocket(port)){
			Chatwin.contextArea.append("chat server is listening on port"+port);
			while(true) {
				Socket socket=seversocket.accept();
				userthread newuser=new userthread (socket,this);
				userthreads.add(newuser);
				
				newuser.start();
			}
		} catch(IOException ex) {
			Chatwin.contextArea.append("error in the server:"+ex.getMessage());
			ex.printStackTrace();
		}
	
	}
	
	
	void broadcast(String message,userthread excludeuser) {
		for(userthread auser :userthreads) {
			if(auser!=excludeuser) {
				auser.sendMessage(message);
			}
		}
	}
	void addusername(String username) {
		usernames.add(username);
	}
	void addusername2(String username) {
		Chatwin.contextArea.append("\n new user "+username+" connected");
		Chatwin.listModel.addElement(username);
		
	}
	void removeuser(String username,userthread auser) {
		boolean removed=usernames.remove(username);
		if(removed) {
			userthreads.remove(auser);
			Chatwin.contextArea.append("\nthe user "+username+" quitted");
			Chatwin.listModel.removeElement(username);
		}
	}
	Set<String> getusernames(){
		return this.usernames;
	}
	
	boolean hasdusers() {
		return !this.usernames.isEmpty();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
