import java.io.*;
import java.net.*;
public class Server{
	public static void main(String args[]){
		try{
			DatagramSocket ds = new DatagramSocket(9999);
			byte[] senddata = new byte[1024];
			byte[] receivedata = new byte[1024];	
			while(true){
				DatagramPacket receiver = new DatagramPacket(receivedata, receivedata.length);
				ds.receive(receiver);
				String received_msg = new String(receiver.getData(), 0, receiver.getLength());
				System.out.println("Received : "+received_msg);
				InetAddress ia = receiver.getAddress();
				int port = receiver.getPort();
				String ackmsg = "Ack : "+received_msg;
				senddata = ackmsg.getBytes();
				DatagramPacket sender = new DatagramPacket(senddata, senddata.length, ia, port);
				ds.send(sender);
				System.out.println("Sent : "+ackmsg);
			}	
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}