package chatwindow;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.StringTokenizer;

public class readthread extends Thread{
	private BufferedReader reader;
	private Socket socket;
	private client client;
	public readthread(Socket socket,client client) {
		this.socket=socket;
		this.client=client;
		try {
			InputStream input=socket.getInputStream();
			reader=new BufferedReader(new InputStreamReader(input));
			
		}catch(IOException ex) {
			Chatcli.textArea.append("error getting input stream: "+ex.getMessage());
			ex.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public void run() {
		writethread a=new writethread();
		String response=null;
		while(true) {
			
			try {
				
				response=reader.readLine();
				if(response==null) {//已經關閉
					//Chatcli.textArea.append("連線已經關閉 請記得關閉程式");
					socket.close();
					System.exit(0);
					break;
				}
				StringTokenizer stringTokenizer = new StringTokenizer(response, "/@");
				String command = stringTokenizer.nextToken();// 命令
				
				if(command.equals("bigtext1")) {//+"connect user: "
					Chatcli.textArea.append("connect user: "+stringTokenizer.nextToken());
				}
				else if(command.equals("bigtext2")) {
					Chatcli.textArea.append("no other users connected");
				}
				else if(command.equals("bigtext0")) {
					String abc=stringTokenizer.nextToken();
					Chatcli.textArea.append("\n new user connected:"+abc);
					Chatcli.listModel2.addElement(abc);
				}
				else if(command.equals("onlinetext2")) {
					
					Chatcli.listModel2.removeElement(stringTokenizer.nextToken());
				}
				else if(command.equals("onlinetext")) {
					String toke="[";
					String str=stringTokenizer.nextToken();
					String str2="";
					for(int i=0;i<str.length();i++) {
						if(i==0||i==str.length()-1) {
							
						}
						else {
							str2=str2+str.charAt(i);
						}
					}
					String[] arr = str2.split(",") ;
					for(int j=0;j<arr.length;j++) {
						Chatcli.listModel2.addElement(arr[j]);
						System.out.print(arr[j]+"\n");
					}
				}
				else {
					//Chatcli.textArea.append(command+stringTokenizer.nextToken());
					Chatcli.textArea.append("\n"+response);
				}
				//Chatcli.textArea.append("\n"+response);//
				//if(client.getusername()!=null) {
				
				//}
			}catch(IOException ex) {
				Chatcli.textArea.append("error reading from server: "+ex.getMessage()+"\n");
				ex.printStackTrace();
				break;
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
