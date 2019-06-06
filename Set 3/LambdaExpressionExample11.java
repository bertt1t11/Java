import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.script.*;
import java.io.*;

class Product {
	int id;
	String name;
	float price;

	public Product(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
}

public class LambdaExpressionExample11 {
	public static void main(String[] args) throws Exception {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "Samsung A5", 17000f));
		list.add(new Product(3, "Iphone 6S", 65000f));
		list.add(new Product(2, "Sony Xperia", 25000f));
		list.add(new Product(4, "Nokia Lumia", 15000f));
		list.add(new Product(5, "Redmi4 ", 26000f));
		list.add(new Product(6, "Lenevo Vibe", 19000f));

		// using lambda to filter data  
		Stream<Product> filtered_data = list.stream().filter(p -> p.price > 20000);

		// using lambda to iterate through collection  
		filtered_data.forEach(product -> System.out.println(product.name + ": " + product.price));

		// Lambda expression without return keyword.  
		Addable ad1 = (a, b) -> (a + b);
		System.out.println(ad1.add(10, 20));

		// Lambda expression with return keyword.    
		Addable ad2 = (int a, int b) -> {
			return (a + b);
		};
		System.out.println(ad2.add(100, 200));

		System.out.println("");
		// Creating script engine  
		ScriptEngine ee = new ScriptEngineManager().getEngineByName("Nashorn");
		// Reading Nashorn file  
		ee.eval(new FileReader("hello.js"));

		byte b1 = 0b101; // Using b0, The b can be lower or upper case  
		byte b2 = 0B101; // Using B0  
		System.out.println("----------Binary Literal in Byte----------------");
		System.out.println("b1 = " + b1);
		System.out.println("b2 = " + b2);

		// Binary literal in short type  
		short s1 = 0b101; // Using b0, The b can be lower or upper case  
		short s2 = 0B101; // Using B0  
		System.out.println("----------Binary Literal in Short----------------");
		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);

		// Binary literal in int type  
		int i1 = 0b101; // Using b0, The b can be lower or upper case  
		int i2 = 0B101; // Using B0  
		System.out.println("----------Binary Literal in Integer----------------");
		System.out.println("i1 = " + i1);
		System.out.println("i2 = " + i2);

		// Binary literal in long type  
		long l1 = 0b0000011111100001; // Using b0, The b can be lower or upper case  
		long l2 = 0B0000011111100001; // Using B0  
		System.out.println("----------Binary Literal in Long----------------");
		System.out.println("l1 = " + l1);
		System.out.println("l2 = " + l2);

		System.out.println("");
		MyGen<Integer> m = new MyGen<Integer>();
		m.add(2);
		//m.add("vivek");//Compile time error  
		System.out.println(m.get());

		System.out.println("");
		Integer[] intArray = { 10, 20, 30, 40, 50 };
		Character[] charArray = { 'J', 'A', 'V', 'A', 'T', 'P', 'O', 'I', 'N', 'T' };

		System.out.println("Printing Integer Array");
		printArray(intArray);

		System.out.println("Printing Character Array");
		printArray(charArray);

		System.out.println("");
		List<Rectangle> list1 = new ArrayList<Rectangle>();
		list1.add(new Rectangle());

		List<Circle> list2 = new ArrayList<Circle>();
		list2.add(new Circle());
		list2.add(new Circle());

		drawShapes(list1);
		drawShapes(list2);
	}

	public static <E> void printArray(E[] elements) {
		for (E element : elements) {
			System.out.println(element);
		}
		System.out.println();
	}

	//creating a method that accepts only child class of Shape  
	public static void drawShapes(List<? extends Shape> lists) {
		for (Shape s : lists) {
			s.draw();//calling method of Shape class by child class instance  
		}

	}
}

interface Addable {
	int add(int a, int b);
}

class MyGen<T> {
	T obj;

	void add(T obj) {
		this.obj = obj;
	}

	T get() {
		return obj;
	}
}

abstract class Shape {
	abstract void draw();
}

class Rectangle extends Shape {
	void draw() {
		System.out.println("drawing rectangle");
	}
}

class Circle extends Shape {
	void draw() {
		System.out.println("drawing circle");
	}
}