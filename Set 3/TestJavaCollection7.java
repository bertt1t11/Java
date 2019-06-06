import java.util.*;
import java.io.*;

public class TestJavaCollection7 {
	public static void main(String[] args) throws Exception {
		FileReader reader = new FileReader("db.properties");

		Properties p = new Properties();
		p.load(reader);

		System.out.println(p.getProperty("user"));
		System.out.println(p.getProperty("password"));

		System.out.println("");
		p = System.getProperties();
		Set set = p.entrySet();

		Iterator itr = set.iterator();
		while (itr.hasNext()) {
			Map.Entry entry = (Map.Entry) itr.next();
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		System.out.println("");
		p = new Properties();
		p.setProperty("name", "Sonoo Jaiswal");
		p.setProperty("email", "sonoojaiswal@javatpoint.com");

		p.store(new FileWriter("info.properties"), "Javatpoint Properties Example");

	}
}

/*
File contains
    user=system  
	password=oracle  
*/