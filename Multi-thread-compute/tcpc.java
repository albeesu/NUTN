package network;


import java.io.*;
import java.net.*;
import java.util.*;
public class tcpc {
	private static InetAddress host;
	private static final int PORT=1234;//>1024
	public tcpc() {
		// TODO Auto-generated constructor stub
	}
	public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			host=InetAddress.getLocalHost();
		}
		catch(UnknownHostException uhEX) {
			System.out.println("Host ID not found");
			System.exit(1);
		}
		accessServer();
	}
	private static void accessServer() {
		Socket link=null;
		try {
			link=new Socket(host,PORT);
			Scanner input=new Scanner(link.getInputStream());
			PrintWriter output=new PrintWriter(link.getOutputStream(),true);
			Scanner userEntry=new Scanner(System.in);
			String message,message2,message3;
			String response,response2,response3,response4,response5;
		
		do {
			int x=0;
			System.out.print("Enter message: ");
			message=userEntry.nextLine();
			output.println(message);
			if(!message.equals("***close***")) {
				
				String[] arr = message.split(",") ;
				for(int i=0;i<arr.length;i++) {
					if(!isNumeric(arr[i])) {//判斷是否為數字
						x=1;
					}
				}
				if(x!=1) {
					response=input.nextLine();
					System.out.println(" SEVER>"+response);
					response2=input.nextLine();
					System.out.println(response2);
					response3=input.nextLine();
					System.out.println(response3);
					response4=input.nextLine();
					System.out.println(response4);
					response5=input.nextLine();
					System.out.println(response5+"\n");
				}
				else if(x==1) {
					System.out.println(" SEVER>您輸入了非數字，請再輸入一次謝謝!");
				}
			}
		 }while(!message.equals("***close***"));
		}
		catch(IOException ioEX) {
			ioEX.printStackTrace();
		}
		finally {
			try {
				System.out.println("\n* closing connection...*");
				link.close();
			}
			catch(IOException ioEX) {
				System.out.println("unable to disconnect");
				System.exit(1);
			}
		}
	}
}
