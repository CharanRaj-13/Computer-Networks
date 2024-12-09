import java.io.*;
import java.net.*;
import java.util.*;
public class Client{
	public static void main(String args[]){
		try{
			InetAddress ia = InetAddress.getLocalHost();
			int port = 6666;
			Socket s = new Socket(ia, port);
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			DataInputStream din = new DataInputStream(s.getInputStream());
			PrintStream ps = new PrintStream(s.getOutputStream());
			while(true){
				System.out.println("Client : ");
				String line = in.readLine();
				ps.println(line);
				System.out.println("Server : "+din.readLine());
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}