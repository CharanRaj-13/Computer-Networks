import java.io.*;
import java.net.*;
import java.util.*;
public class Server{
	public static void main(String args[]){
		try{
			ServerSocket ss = new ServerSocket(6666);
			Socket s = ss.accept();
			DataInputStream din = new DataInputStream(s.getInputStream());
			PrintStream ps = new PrintStream(s.getOutputStream());
			while(true){
				String line = din.readLine();
				ps.println(line);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}	
	}
}