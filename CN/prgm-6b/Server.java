import java.io.*;
import java.net.*;
import java.util.*;
public class Server{
	public static int client_port = 789, server_port = 790;
	public static void main(String args[]){
		try{
			DatagramSocket ds = new DatagramSocket(client_port);
			byte[] buffer = new byte[1024];
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			InetAddress ia = InetAddress.getLocalHost();
			while(true){
				DatagramPacket receiver = new DatagramPacket(buffer, buffer.length);
				ds.receive(receiver);
				String msg = new String(receiver.getData(), 0, receiver.getLength());
				System.out.println("Client : "+msg);
				System.out.println("Server : ");
				String line = in.readLine();
				if(line.equals("end"))
					break;
				buffer = line.getBytes();
				DatagramPacket sender = new DatagramPacket(buffer, line.length(), ia, server_port);
				ds.send(sender);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}