package network;
import java.io.*;
import java.text.DecimalFormat;
import java.net.*;
import java.util.*;
public class tcp extends Thread{
	private Socket client;
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
	public tcp(Socket c) {
		this.client = c;
		}

		public void run() {
		try {
		BufferedReader in = new BufferedReader(new InputStreamReader(
		client.getInputStream()));
		PrintWriter out = new PrintWriter(client.getOutputStream());
		String message = in.readLine();
		int numMessages=0;
		System.out.println(message);
		
		int c1;
		while(!message.equals("***close***")){
			c1=0;
			String[] arr = message.split(",") ;
			c1=0;
			for(int i=0;i<arr.length;i++) {
				if(!isNumeric(arr[i])) {
					c1=1;
				}
			}
			if(c1==0) {//判斷是否為數字(是)
				int[] arr2=new int[arr.length];
				for(int i=0;i<arr.length;i++) {
					arr2[i]=Integer.parseInt(arr[i]);
				} 
				Arrays.sort(arr2);
				String str="";
				str=str+arr2[0];
				for(int i=1;i<arr.length;i++) {
					str=str+","+arr2[i];
				}
				int x=0;
				int mul=1;
				double average=0;
				for(int i=0;i<arr.length;i++) {
					x=x+arr2[i];
					mul=mul*arr2[i];
				}
				DecimalFormat df = new DecimalFormat("##.00");
				average= ((double)x/(double)arr.length);
				average = Double.parseDouble(df.format(average));
				System.out.println("Message received.");
				numMessages++;
				out.println("Message"+numMessages+"\n Sorting:"+ str +"\n"+" addition:"+x+"\n multiplication:"+mul+"\n average:"+average);
				out.flush();
				message=in.readLine();
				numMessages=0;
				System.out.println(message);
			}
			if(c1==1) {
				out.flush();
				message=in.readLine();
				numMessages=0;
			}
		}
		client.close();
		} catch (IOException ex) {
		}
		finally {
		}
		}
		
		public static void main(String[] args) throws IOException {
			System.out.println("Opening port...");
			ServerSocket server = new ServerSocket(1234);
			while (true) {
				tcp mc = new tcp(server.accept());
				mc.start();
			}
		}
}
