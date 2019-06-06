
//URLDemo.java  
import java.io.*;
import java.net.*;

public class URLDemo {
	public static void main(String[] args) {
		try {
			// http://www.javatpoint.com/java-tutorial 
			URL url = new URL("https://www.javatpoint.com/URLConnection-class");

			System.out.println("Protocol: " + url.getProtocol());
			System.out.println("Host Name: " + url.getHost());
			System.out.println("Port Number: " + url.getPort());
			System.out.println("File Name: " + url.getFile());
			URLConnection urlcon = url.openConnection();
			InputStream stream = urlcon.getInputStream();
			int i;
			while ((i = stream.read()) != -1) {
				System.out.print((char) i);
			}
			for (int n = 0; n < 20; n++) {
				System.out.println("------------------------------");
			}
			HttpURLConnection huc = (HttpURLConnection) url.openConnection();
			for (int n = 1; n <= 8; n++) {
				System.out.println(huc.getHeaderFieldKey(n) + " = " + huc.getHeaderField(n));
			}
			huc.disconnect();
			InetAddress ip = InetAddress.getByName("www.javatpoint.com"); // url.toString() doesnt work, need address ONLY not url

			System.out.println("Host Name: " + ip.getHostName());
			System.out.println("IP Address: " + ip.getHostAddress());

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}