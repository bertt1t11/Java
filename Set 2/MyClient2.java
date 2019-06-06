import java.net.*;
import java.io.*;

class MyClient2 {
	public static void main(String args[]) throws Exception {
		Socket s = new Socket("192.168.1.13", 3333); //localhostass

		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("INSTRUCTIONS");
		System.out.println("::::: Look in 'C:\\Program Files\\Java\\jdk-12.0.1\\bin' for MyServer2.java");
		System.out.println(":::::   on i7 PC for server...run server first! (ie java myserver2.java)");
		System.out.println("");
		System.out.println("CLIENT: Enter a Message when it is your turn (type 'stop' to exit).");
		System.out.print(">");
		String str = "", str2 = "";
		while (!str.equals("stop")) {
			str = br.readLine();
			System.out.println("MESSAGE SENT");
			dout.writeUTF(str);
			dout.flush();
			str2 = din.readUTF();
			System.out.println("Server says: " + str2);
			System.out.print(">");
		}

		dout.close();
		s.close();
	}
}