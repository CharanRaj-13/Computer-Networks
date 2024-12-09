import java.io.*;
import java.net.*;
import java.util.*;
public class Client{
	public static final int service_port = 13;
	public static void main(String args[]){
		if(args.length != 1){
			String d = new Date().toString();	
			System.out.println(d);
			return;
		}
		String hostname = args[0];
		try{
			Socket s = new Socket(hostname, service_port);
			System.out.println("Connection Established");
			s.setSoTimeout(2000);
			BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
			System.out.println("Result : "+reader.readLine());
			s.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}