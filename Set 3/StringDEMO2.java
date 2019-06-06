import java.text.SimpleDateFormat;
import java.util.Date;

public class StringDEMO2 {
	public static void main(String[] args) throws Exception {

		String sDate11 = "31/12/1998";
		Date date11 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate11);
		System.out.println(sDate11 + "\t" + date11);
		System.out.println("---------------------------");

		String sDate1 = "31/12/1998";
		String sDate2 = "31-Dec-1998";
		String sDate3 = "12 31, 1998";
		String sDate4 = "Thu, Dec 31 1998";
		String sDate5 = "Thu, Dec 31 1998 23:37:50";
		String sDate6 = "31-Dec-1998 23:37:50";
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MMM-yyyy");
		SimpleDateFormat formatter3 = new SimpleDateFormat("MM dd, yyyy");
		SimpleDateFormat formatter4 = new SimpleDateFormat("E, MMM dd yyyy");
		SimpleDateFormat formatter5 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
		SimpleDateFormat formatter6 = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		Date date1 = formatter1.parse(sDate1);
		Date date2 = formatter2.parse(sDate2);
		Date date3 = formatter3.parse(sDate3);
		Date date4 = formatter4.parse(sDate4);
		Date date5 = formatter5.parse(sDate5);
		Date date6 = formatter6.parse(sDate6);
		System.out.println(sDate1 + "\t" + date1);
		System.out.println(sDate2 + "\t" + date2);
		System.out.println(sDate3 + "\t" + date3);
		System.out.println(sDate4 + "\t" + date4);
		System.out.println(sDate5 + "\t" + date5);
		System.out.println(sDate6 + "\t" + date6);

		String str = "Welcome to Javatpoint portal";
		for (int i = 0; i <= str.length() - 1; i++) {
			if (i % 2 != 0) {
				System.out.println("Char at " + i + " place " + str.charAt(i));
			}
		}
		String s1 = "java by javatpoint";
		System.out.println(s1.endsWith("t"));
		System.out.println(s1.endsWith("point"));

		String name = "sonoo";
		String sf1 = String.format("name is %s", name);
		String sf2 = String.format("value is %f", 32.33434);
		String sf3 = String.format("value is %32.12f", 144.33434);//returns 12 char fractional part filling with 0  

		System.out.println(sf1);
		System.out.println(sf2);
		System.out.println(sf3);

		String str1 = String.format("%d", 101); // Integer value  
		String str2 = String.format("%s", "Amar Singh"); // String value  
		String str3 = String.format("%f", 101.0054); // Float value  
		String str4 = String.format("%x", 31401); // Hexadecimal value  
		String str5 = String.format("%c", 'c'); // Char value  
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);
		System.out.println(str5);

		str1 = String.format("%d", 101);
		str2 = String.format("|%10d|", 101); // Specifying length of integer  
		str3 = String.format("|%-10d|", 101); // Left-justifying within the specified width  
		str4 = String.format("|% d|", 101);
		str5 = String.format("|%010d|", 101); // Filling with zeroes  
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);
		System.out.println(str5);

		s1 = "ABCDEFG"; // Returns ASCII values of characters
		byte[] barr = s1.getBytes();
		for (int i = 0; i < barr.length; i++) {
			System.out.println(barr[i]);
		}
		String s2 = new String(barr);
		System.out.println(s2);

		str = new String("hello javatpoint how r u");
		char[] ch = new char[10];
		try {
			str.getChars(6, 16, ch, 0);
			System.out.println(ch);
		} catch (Exception ex) {
			System.out.println(ex);
		}

		s1 = "this is index of example";
		//passing substring  
		int index1 = s1.indexOf("is");//returns the index of is substring  
		int index2 = s1.indexOf("index");//returns the index of index substring  
		System.out.println(index1 + "  " + index2);//2 8  

		//passing substring with from index  
		int index3 = s1.indexOf("is", 4);//returns the index of is substring after 4th index  
		System.out.println(index3);//5 i.e. the index of another is  

		//passing char value  
		int index4 = s1.indexOf('s');//returns the index of s char value  
		System.out.println(index4);//3  

		String joinString1 = String.join("-", "welcome", "to", "javatpoint");
		System.out.println(joinString1);

		String S1 = "this is index of example";//there are 2 's' characters in this sentence  
		int Index1 = S1.lastIndexOf('s');//returns last index of 's' char value  
		System.out.println(Index1);//6  

		str = "oooooo-hhhh-oooooo";
		String rs = str.replace("h", "s"); // Replace 'h' with 's'  
		System.out.println(rs);
		rs = rs.replace("s", "h"); // Replace 's' with 'h'  
		System.out.println(rs);

		s1 = "java string split method by javatpoint";
		String[] words = s1.split("\\s");//splits the string based on whitespace  
		//using java foreach loop to print elements of string array  
		for (String w : words) {
			System.out.println(w);
		}

		s1 = "welcome to split world";
		System.out.println("returning words:");
		for (String w : s1.split("\\s", 0)) {
			System.out.println(w);
		}
		System.out.println("returning words:");
		for (String w : s1.split("\\s", 1)) {
			System.out.println(w);
		}
		System.out.println("returning words:");
		for (String w : s1.split("\\s", 2)) {
			System.out.println(w);
		}

		str = "Javatpointtt";
		System.out.println("Returning words:");
		String[] arr = str.split("t", 0);
		for (String w : arr) {
			System.out.println(w);
		}
		System.out.println("Split array length: " + arr.length);

		s1 = "javatpoint";
		System.out.println(s1.substring(2, 4));//returns va  
		System.out.println(s1.substring(2));//returns vatpoint 

		char[] ch1 = s1.toCharArray();
		for (int i = 0; i < ch1.length; i++) {
			System.out.print(ch1[i]);
		}
		System.out.println();
		System.out.println(str.toUpperCase());

		boolean b1 = true;
		byte b2 = 11;
		short sh = 12;
		int i = 13;
		long l = 14L;
		float f = 15.5f;
		double d = 16.5d;
		char chr[] = { 'j', 'a', 'v', 'a' };
		StringDEMO2 obj = new StringDEMO2();
		String s111 = String.valueOf(b1);
		String s211 = String.valueOf(b2);
		String s3 = String.valueOf(sh);
		String s4 = String.valueOf(i);
		String s5 = String.valueOf(l);
		String s6 = String.valueOf(f);
		String s7 = String.valueOf(d);
		String s8 = String.valueOf(chr);
		String s9 = String.valueOf(obj);
		System.out.println(s111);
		System.out.println(s211);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);
		System.out.println(s6);
		System.out.println(s7);
		System.out.println(s8);
		System.out.println(s9);
	}
}