import java.io.*;
import java.net.*;
import java.util.*;
public class Server{
	public static void main(String args[]){
		try{
			DatagramSocket ds = new DatagramSocket(1234);
			byte[] senddata = new byte[1024];
			byte[] receivedata = new byte[1024];
			String ip[] = {"192.168.100.121", "245.245.123.12"};
			String host[] = {"google.com", "youtube.com"};
			DatagramPacket receiver = new DatagramPacket(receivedata, receivedata.length);
			ds.receive(receiver);
			String str = new String(receiver.getData(), 0 ,receiver.getLength());
			InetAddress ia = receiver.getAddress();
			int port = receiver.getPort();
			String str1 = str.trim();
			for(int i=0; i<ip.length; i++){
				if(str1.equals(host[i])){
					senddata = ip[i].getBytes();
					DatagramPacket sender = new DatagramPacket(senddata, senddata.length, ia, port);
					ds.send(sender);
					break;
				}
			}
			ds.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}