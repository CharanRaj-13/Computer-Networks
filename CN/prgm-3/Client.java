import java.io.*;
import java.net.*;
public class Client{
	public static void main(String args[]){
		try{
			DatagramSocket ds = new DatagramSocket();
			byte[] senddata = new byte[1024];
			byte[] receivedata = new byte[1024];
			InetAddress ia = InetAddress.getByName("localhost");
			int port = 9999;
			String[] messages = {"Frame1", "Frame2", "Frame3", "Frame4"};
			for(String message : messages){
				senddata = message.getBytes();
				DatagramPacket sender = new DatagramPacket(senddata, senddata.length, ia, port);
				ds.send(sender);
				System.out.println("Sent : "+message);
				Thread.sleep(1000);
				DatagramPacket receiver = new DatagramPacket(receivedata, receivedata.length);
				ds.receive(receiver);
				String ackmsg = new String(receiver.getData(), 0, receiver.getLength());
				System.out.println("Received : "+ackmsg);
				Thread.sleep(1000);
			}
			ds.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}