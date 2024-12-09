import java.io.*;
import java.net.*;
import java.util.*;
public class Client{
	public static int client_port = 789, server_port = 790;
	public static void main(String args[]){
		try{
			DatagramSocket ds = new DatagramSocket(server_port);
			byte[] buffer = new byte[1024];
			System.out.println("Server Waiting ...");
			InetAddress ia = InetAddress.getLocalHost();
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			while(true){
				System.out.println("Client : ");
				String str = in.readLine();
				buffer = str.getBytes();
				DatagramPacket sender = new DatagramPacket(buffer, str.length(), ia, client_port);
				ds.send(sender);
				DatagramPacket receiver = new DatagramPacket(buffer, buffer.length);
				ds.receive(receiver);
				String msg = new String(receiver.getData(), 0, receiver.getLength());
				System.out.println("Server : "+msg);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}