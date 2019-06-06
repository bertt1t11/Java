//Java Program to understand the working of string concatenation operator  
public class StringToIntExample1 {
	public static void main(String args[]) {
		//Declaring String variable  
		String s = "200";
		//Converting String into int using Integer.parseInt()  
		int i = Integer.parseInt(s);
		System.out.println(s + 100);//200100, because "200"+100, here + is a string concatenation operator  
		System.out.println(i + 100);//300, because 200+100, here + is a binary plus operator  
		i = 200;
		s = String.format("%d", i);
		System.out.println(s);
		s = "9990449935";
		long l = Long.parseLong(s);
		System.out.println(l);

		s = "23.6";
		float f = Float.parseFloat("23.6");
		System.out.println(f);
		f = 12.3F;//F is the suffix for float  
		s = String.valueOf(f);
		System.out.println(s);

		double d = 89.7;
		s = Double.toString(d);
		System.out.println(s);

		s = "hello";
		char c = s.charAt(0);//returns h  
		System.out.println("1st character is: " + c);

		String s1 = "hello Fucker";
		char[] ch = s1.toCharArray();
		for (i = 0; i < ch.length; i++) {
			System.out.println("char at " + i + " index is: " + ch[i]);

			char c3 = 'M';
			String s3 = Character.toString(c3);
			System.out.println("String is: " + s3);

			s = "hello";
			Object obj = s;
			System.out.println(obj);

			i = 200;
			l = i;
			System.out.println(l);
			i = 100;
			l = new Long(i);//first way  
			Long l2 = Long.valueOf(i);//second way  
			System.out.println(l);
			System.out.println(l2);

			l = 500;
			i = (int) l;
			System.out.println(i);

			i = 200;
			d = i;
			System.out.println(d);

			i = 100;
			d = new Double(i);//first way  
			Double d2 = Double.valueOf(i);//second way  
			System.out.println(d);
			System.out.println(d2);

			d = 10.5;
			i = (int) d;
			System.out.println(i);

			char c1 = 'a';
			char c2 = '1';
			int a = c1;
			int b = c2;
			System.out.println(a);
			System.out.println(b);
			c = '1';
			a = Character.getNumericValue(c);
			System.out.println(a);

			a = 65;
			c = (char) a;
			System.out.println(a);

			String binaryString = "1010";
			int decimal = Integer.parseInt(binaryString, 2);
			System.out.println(decimal);

			System.out.println(Integer.parseInt("1010", 2));
			System.out.println(Integer.parseInt("10101", 2));
			System.out.println(Integer.parseInt("11111", 2));

			System.out.println("Decimal of 1010 is: " + getDecimal(1010));
			System.out.println("Decimal of 10101 is: " + getDecimal(10101));
			System.out.println("Decimal of 11111 is: " + getDecimal(11111));

			System.out.println(Integer.toBinaryString(10));
			System.out.println(Integer.toBinaryString(21));
			System.out.println(Integer.toBinaryString(31));

			System.out.println(Integer.parseInt("a", 16));
			System.out.println(Integer.parseInt("f", 16));
			System.out.println(Integer.parseInt("121", 16));

			System.out.println(Integer.toHexString(10));
			System.out.println(Integer.toHexString(15));
			System.out.println(Integer.toHexString(289));

			System.out.println("Hexadecimal of 10 is: " + toHex(10));
			System.out.println("Hexadecimal of 15 is: " + toHex(15));
			System.out.println("Hexadecimal of 289 is: " + toHex(289));

		}
	}

	public static int getDecimal(int binary) {
		int decimal = 0;
		int n = 0;
		while (true) {
			if (binary == 0) {
				break;
			} else {
				int temp = binary % 10;
				decimal += temp * Math.pow(2, n);
				binary = binary / 10;
				n++;
			}
		}
		return decimal;
	}

	public static String toHex(int decimal) {
		int rem;
		String hex = "";
		char hexchars[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		while (decimal > 0) {
			rem = decimal % 16;
			hex = hexchars[rem] + hex;
			decimal = decimal / 16;
		}
		return hex;
	}
}