
import java.io.BufferedReader;

public class ctrllisten implements Runnable{
		BufferedReader ctrlinput=null;
		int i=0;
	public ctrllisten(BufferedReader in) {
		// TODO Auto-generated constructor stub
		ctrlinput=in;
	}
	public void run() {
		while(true) {
			try {
				if(Ftpwin.select1==9) {
					Ftpwin.textArea_2.append(ctrlinput.readLine()+"\n");
					//System.out.println(ctrlinput.readLine());
					
				}
				else if(Ftpwin.select1==12) {
					//Ftpwin.textArea_2.append(ctrlinput.readLine()+"\n");
					//System.out.println(ctrlinput.readLine());
					
				}
				else {
					Ftpwin.textArea_2.append(ctrlinput.readLine()+"\n");
					//System.out.println("123");
				//System.out.println(ctrlinput.readLine());
				}
			}catch(Exception e) {
				System.exit(1);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
