import java.io.*;
import java.net.*;
public class Server{
	public static void main(String args[]){
		try{
			ServerSocket ss = new ServerSocket(6666);
			Socket s = ss.accept();
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			String str = din.readLine();
			String[] ip = {"192.168.25.25", "167.12.12.0"};
			String[] mac = {"A8:BE:3F", "K0:OK:FK"};
			for(int i=0; i<ip.length; i++){
				if(str.equals(ip[i])){
					dout.writeBytes(mac[i]+'\n');
					break;
				}
			}
			ss.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}