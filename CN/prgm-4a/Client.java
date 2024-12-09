import java.io.*;
import java.net.*;
public class Client{
	public static void main(String args[]){
		try{
			Socket s = new Socket("localhost", 6666);
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Your IP Address : ");
			String str = in.readLine();
			dout.writeBytes(str+'\n');
			String str1 = din.readLine();
			System.out.println("Your MAC Address : "+str1);
			s.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}