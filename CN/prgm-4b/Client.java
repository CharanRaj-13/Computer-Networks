import java.io.*;
import java.net.*;
public class Client{
	public static void main(String args[]){
		try{
			DatagramSocket ds = new DatagramSocket();
			InetAddress ia = InetAddress.getByName("localhost");
			int port = 6666;
			byte[] senddata = new byte[1024];
			byte[] receivedata = new byte[1024];
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter your MAC Address : ");
			String str = in.readLine();
			senddata = str.getBytes();
			DatagramPacket sender = new DatagramPacket(senddata, senddata.length, ia, port);
			ds.send(sender);
			DatagramPacket receiver = new DatagramPacket(receivedata, receivedata.length);
			ds.receive(receiver);
			String str1 = new String(receiver.getData(), 0 ,receiver.getLength());
			System.out.println("Your IP Address : "+str1.trim());	
			ds.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}