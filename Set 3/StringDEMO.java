
import java.util.StringTokenizer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringDEMO {

	public void TryThis() {
		String s = "hello";
		System.out.println(s.substring(0, 2));//he  
	}

	public static String concatWithString() {
		String t = "Java";
		for (int i = 0; i < 10000; i++) {
			t = t + "Tpoint";
		}
		return t;
	}

	public static String concatWithStringBuffer() {
		StringBuffer sb = new StringBuffer("Java");
		for (int i = 0; i < 10000; i++) {
			sb.append("Tpoint");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String s1 = "Sachin";
		String s2 = "Sachin";
		String s3 = new String("Sachin");
		String s4 = "Saurav";

		System.out.println(s1.equals(s2));//true  
		System.out.println(s1.equals(s3));//true  
		System.out.println(s1.equals(s4));//false  
		System.out.println(s1 == s2);//true (because both refer to same instance)  
		System.out.println("s1 = s3?" + (s1 == s3));//false(because s3 refers to instance created in nonpool)  

		s2 = "SACHIN";
		System.out.println(s1.equals(s2));//false  
		System.out.println(s1.equalsIgnoreCase(s2));//true  
		System.out.println("--------------------");
		String ss1 = "Sachin";
		String ss2 = "Sachin";
		String ss3 = "Ratan";
		System.out.println(ss1.compareTo(ss2));//0  
		System.out.println(ss1.compareTo(ss3));//1(because ss1 > ss3)  
		System.out.println(ss3.compareTo(ss1));//-1(because ss3 < ss1 )  

		/*
		In java, String concatenation is implemented through the 
		StringBuilder (or StringBuffer) class and its append method. 
		String concatenation operator produces a new string by 
		appending the second operand onto the end of the first 
		operand. The string concatenation operator can concat not 
		only string but primitive values also. For Example:
		*/
		String s = 50 + 30 + "Sachin" + 40 + 40;
		System.out.println(s);//80Sachin4040  
		s2 = "Tendulkar";
		s3 = s1.concat(s2);
		System.out.println(s3);//Sachin Tendulkar  

		{ // i guess this doesnt work in java
			//String s = "hello";
			s = "hello";
			System.out.println(s.substring(0, 2));//he  
		}
		StringDEMO Sdmo = new StringDEMO();
		Sdmo.TryThis();

		/*  Guess you cant declare method in main...
		static void Sdar() {
			String s="hello";  
			System.out.println(s.substring(0,2));//he  
		}
		*/
		s = "SachinTendulkar";
		System.out.println(s.substring(6));//Tendulkar  
		System.out.println(s.substring(0, 6));//Sachin  
		System.out.println(s.toUpperCase());//SACHIN  
		System.out.println(s.toLowerCase());//sachin  
		s = "  Sachin  ";
		System.out.println(s);//"  Sachin  " 
		System.out.println(s.trim());//"Sachin"  
		s = "Sachin";
		System.out.println(s.startsWith("Sa"));//true  
		System.out.println(s.endsWith("n"));//true 
		System.out.println(s.charAt(0));//S  
		System.out.println(s.charAt(3));//h 
		System.out.println(s.length());//6  

		/*
		Java String intern() method
		
		A pool of strings, initially empty, is maintained privately 
		by the class String.
		
		When the intern method is invoked, if the pool already contains a 
		string equal to this String object as determined by the 
		equals(Object) method, then the string from the pool is 
		returned. Otherwise, this String object is added to the pool 
		and a reference to this String object is returned.
		REMEMBER, this 'pool' applies to literals, not true variables...
		*/
		String ns = new String("Sachin");
		String ns2 = ns.intern();
		System.out.println(ns2);//Sachin  
		// This valueOf doesnt look too useful
		int a = 10;
		s = String.valueOf(a);
		System.out.println(s + 10);

		s1 = "Java is a programming language. Java is a platform. Java is an Island.";
		String replaceString = s1.replace("Java", "SpasKava");//replaces all occurrences of "Java" to "Kava"    
		System.out.println(replaceString);

		// Stringbuffer section... not sure how useful this Is
		StringBuffer sb = new StringBuffer("Hello ");
		sb.append("Java");//now original string is changed  
		System.out.println(sb);//prints Hello Java  
		sb.insert(1, "Java");//now original string is changed  
		System.out.println(sb);//prints HJavaello  

		sb = new StringBuffer("Hello");
		sb.replace(1, 3, "Java");
		System.out.println(sb);//prints HJavalo  
		sb = new StringBuffer("Hello");
		sb.delete(1, 3);
		System.out.println(sb);//prints Hlo  
		sb = new StringBuffer("Hello You Fucker");
		sb.reverse();
		System.out.println(sb);//prints olleH 

		sb = new StringBuffer();
		System.out.println(sb.capacity());//default 16  
		sb.append("Hello");
		System.out.println(sb.capacity());//now 16  
		sb.append("java is my favourite language");
		System.out.println(sb.capacity());//now (16*2)+2=34 i.e (oldcapacity*2)+2  

		//StringBuffer ensureCapacity() method
		sb = new StringBuffer();
		System.out.println(sb.capacity());//default 16  
		sb.append("Hello");
		System.out.println(sb.capacity());//now 16  
		sb.append("java is my favourite language");
		System.out.println(sb.capacity());//now (16*2)+2=34 i.e (oldcapacity*2)+2  
		sb.ensureCapacity(10);//now no change  
		System.out.println(sb.capacity());//now 34  
		sb.ensureCapacity(50);//now (34*2)+2  
		System.out.println(sb.capacity());//now 70  	

		//StringBuilder section.... pretty much same as StringBuffer
		// and used the same so I wont repeat them here
		StringBuilder sb1 = new StringBuilder("Hello ");
		sb1.append("Java");//now original string is changed  
		System.out.println(sb1);//prints Hello Java  

		// Compare string with Stringbuffer
		long startTime = System.currentTimeMillis();
		concatWithString();
		System.out.println("Time taken by Concating with String: " + (System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		concatWithStringBuffer();
		System.out.println("Time for Concating with StringBuffer: " + (System.currentTimeMillis() - startTime) + "ms");

		/* Hashcode test of string vs Stringbuffer
		As you can see in the program given below, String returns new hashcode 
		value when you concat string but StringBuffer returns same.
		*/
		System.out.println("Hashcode test of String:");
		String str = "java";
		System.out.println(str.hashCode());
		str = str + "tpoint";
		System.out.println(str.hashCode());

		System.out.println("Hashcode test of StringBuffer:");
		StringBuffer sbfr = new StringBuffer("java");
		System.out.println(sbfr.hashCode());
		sbfr.append("tpoint");
		System.out.println(sbfr.hashCode());

		/*Java Program to demonstrate the performance of StringBuffer and StringBuilder classes.*/
		startTime = System.currentTimeMillis();
		StringBuffer sbf = new StringBuffer("Java");
		for (int i = 0; i < 500000; i++) {
			sbf.append("Tpoint");
		}
		System.out.println("Time taken by StringBuffer: " + (System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		StringBuilder sb2 = new StringBuilder("Java");
		for (int i = 0; i < 500000; i++) {
			sb2.append("Tpoint");
		}
		System.out.println("Time taken by StringBuilder: " + (System.currentTimeMillis() - startTime) + "ms");

		// String Tokenizer Example
		StringTokenizer st = new StringTokenizer("my name is khan", " ");
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		st = new StringTokenizer("my,name,is,khan");

		// printing next token  
		System.out.println("Next token is : " + st.nextToken(","));
		/*
				public static void main(String[] args)throws Exception {
					String sDate1="31/12/1998";  
					Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
					System.out.println(sDate1+"\t"+date1);  
				}
		*/

	}
}