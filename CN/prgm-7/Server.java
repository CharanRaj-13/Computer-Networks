import java.io.*;
import java.net.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;
public class Server{
	public static void main(String args[]){
		try{
			ServerSocket ss = new ServerSocket(4000);
			Socket s = ss.accept();
			DataInputStream dis = new DataInputStream(s.getInputStream());
			byte[] imagebytes = new byte[dis.readInt()];
			dis.readFully(imagebytes);

			BufferedImage image = ImageIO.read(new ByteArrayInputStream(imagebytes));
			JFrame frame = new JFrame("Received Image");
			frame.add(new JLabel(new ImageIcon(image)));
			frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}