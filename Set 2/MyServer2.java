import java.net.*;
import java.io.*;

class MyServer2 {
	public static void main(String args[]) throws Exception {
		ServerSocket ss = new ServerSocket(3333);
		Socket s = ss.accept();
		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("SERVER: Enter a Message when it is your turn.");

		String str = "", str2 = "";
		while (!str.equals("stop")) {
			str = din.readUTF();
			System.out.println("client says: " + str);
			System.out.print(">");
			str2 = br.readLine();
			System.out.println("MESSAGE SENT");
			dout.writeUTF(str2);
			dout.flush();
		}
		din.close();
		s.close();
		ss.close();
	}
}