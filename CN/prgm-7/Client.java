import java.io.*;
import java.net.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;
public class Client{
	public static void main(String args[]){
		try{
			Socket s = new Socket("localhost", 4000);
			BufferedImage image = ImageIO.read(new File("img2.jpg"));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "jpg", baos);
			byte[] imagebytes = baos.toByteArray();
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeInt(imagebytes.length);
			dout.write(imagebytes);
			System.out.println("Image Sent to Server");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}