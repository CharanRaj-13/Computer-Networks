import java.io.*;
import java.util.*;
import java.net.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
public class Server{
	public static void main(String args[])throws IOException{
		int port = 13;
		if(args.length > 0)
			port = Integer.parseInt(args[0]);
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.socket().bind(new InetSocketAddress(port));
		CharsetEncoder encoder = Charset.forName("US-ASCII").newEncoder();	
		for(;;){
			SocketChannel sc = ssc.accept();
			String date = new Date().toString() + "\r\n";
			ByteBuffer response = encoder.encode(CharBuffer.wrap(date));
			sc.write(response);
			sc.close();
		}
	}
}