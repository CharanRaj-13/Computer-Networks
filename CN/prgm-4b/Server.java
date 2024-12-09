import java.io.*;
import java.net.*;
public class Server{
	public static void main(String args[]){
		try{
			DatagramSocket ds = new DatagramSocket(6666);
			byte[] senddata = new byte[1024];
			byte[] receivedata = new byte[1024];
			DatagramPacket receiver = new DatagramPacket(receivedata, receivedata.length);
			ds.receive(receiver);
			InetAddress ia = receiver.getAddress();
			int port = receiver.getPort();
			String str = new String(receiver.getData(), 0, receiver.getLength());	
			String str1 = str.trim();
			String[] ip = {"192.168.25.25", "167.12.12.0"};
			String[] mac = {"A8:BE:3F", "K0:OK:FK"};
			for(int i=0; i<ip.length; i++){
				if(str1.equals(mac[i])){
					senddata = ip[i].getBytes();
					DatagramPacket sender = new DatagramPacket(senddata, senddata.length, ia, port);
					ds.send(sender);
					break;
				}
			}
		}
		catch(Exception e){
			System.out.println(e);
		}	
	}
}