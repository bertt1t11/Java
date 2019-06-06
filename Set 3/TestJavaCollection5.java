
//Map Example: Generic (New Style)
import java.util.*;

class TestJavaCollection5 {
	public static void main(String args[]) {
		System.out.println("");
		System.out.println("Map");
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(100, "Amit");
		map.put(101, "Vijay");
		map.put(102, "Rahul");
		map.put(104, "Vijay");
		map.put(103, "Vijay");
		map.put(106, "Shit");
		map.put(105, "Blow");
		map.put(107, "No Ron");
		map.put(108, "Ron");
		map.put(108, "Ron"); // duplicate not added (or added as overright/edit?)
		map.put(109, "Santa");
		//Elements can traverse in any order  
		for (Map.Entry m : map.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
		System.out.println("");
		System.out.println("Map Example: comparingByKey()");
		//Returns a Set view of the mappings contained in this map        
		map.entrySet()
				//Returns a sequential Stream with this collection as its source  
				.stream()
				//Sorted according to the provided Comparator  
				.sorted(Map.Entry.comparingByKey())
				//Performs an action for each element of this stream  
				.forEach(System.out::println);
		//Returns a Set view of the mappings contained in this map    

		System.out.println("");
		System.out.println("comparingByKey() in Descending Order");
		map.entrySet()
				//Returns a sequential Stream with this collection as its source  
				.stream()
				//Sorted according to the provided Comparator  
				.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
				//Performs an action for each element of this stream  
				.forEach(System.out::println);
		System.out.println("");
		System.out.println("comparingByValue()");
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

		System.out.println("");
		System.out.println("Hashtable Example: putIfAbsent()");
		Hashtable<Integer, String> Hmap = new Hashtable<Integer, String>();
		Hmap.put(100, "Amit");
		Hmap.put(102, "Ravi");
		Hmap.put(101, "Vijay");
		Hmap.put(103, "Rahul");
		System.out.println("Initial Hmap: " + Hmap);
		//Inserts, as the specified pair is unique  
		Hmap.putIfAbsent(104, "Gaurav");
		System.out.println("Updated Hmap: " + Hmap);
		//Returns the current value, as the specified pair already exist  
		Hmap.putIfAbsent(101, "Vijay");
		System.out.println("Updated Hmap: " + Hmap);

		System.out.println("");
		System.out.println("EnumSet Example");
		Set<days> set = EnumSet.of(days.TUESDAY, days.WEDNESDAY);
		// Traversing elements  
		Iterator<days> iter = set.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());

		}
		Set<days> set1 = EnumSet.allOf(days.class);
		System.out.println("Week Days:" + set1);
		Set<days> set2 = EnumSet.noneOf(days.class);
		System.out.println("Week Days:" + set2);

		System.out.println("");
		System.out.println("EnumSet Example");
		//create and populate enum map  
		EnumMap<Days, String> Emap = new EnumMap<Days, String>(Days.class);
		Emap.put(Days.Monday, "1");
		Emap.put(Days.Tuesday, "2");
		Emap.put(Days.Wednesday, "3");
		Emap.put(Days.Thursday, "4");
		// print the map  
		for (Map.Entry m : Emap.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
		System.out.println("");
		System.out.println("Collections Example");
		List<String> list = new ArrayList<String>();
		list.add("C");
		list.add("Core Java");
		list.add("Advance Java");
		System.out.println("Initial collection value:" + list);
		Collections.addAll(list, "Servlet", "JSP");
		System.out.println("After adding elements collection value:" + list);
		String[] strArr = { "C#", ".Net" };
		Collections.addAll(list, strArr);
		System.out.println("After adding array collection value:" + list);

		System.out.println("");
		System.out.println("Collections Example min/max");
		List<Integer> XlistX = new ArrayList<Integer>();
		XlistX.add(46);
		XlistX.add(67);
		XlistX.add(24);
		XlistX.add(16);
		XlistX.add(8);
		XlistX.add(12);
		System.out.println("Value of maximum element from the collection: " + Collections.max(XlistX));
		System.out.println("Value of minimum element from the collection: " + Collections.min(XlistX));

		System.out.println("");
		System.out.println("sort string objects Example");
		ArrayList<String> al = new ArrayList<String>();
		al.add("Viru");
		al.add("Saurav");
		al.add("Mukesh");
		al.add("Tahir");

		Collections.sort(al);
		Iterator itr = al.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println("");
		System.out.println("Comparable Example");
		ArrayList<Student> alX = new ArrayList<Student>();
		alX.add(new Student(101, "Vijay", 23));
		alX.add(new Student(106, "Ajay", 27));
		alX.add(new Student(105, "Jai", 21));

		Collections.sort(alX);
		for (Student st : alX) {
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}
	}

	// create an enum  (in class)
	public enum Days {
		Monday, Tuesday, Wednesday, Thursday
	};

}

enum days {
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

class Student implements Comparable<Student> {
	int rollno;
	String name;
	int age;

	Student(int rollno, String name, int age) {
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}

	public int compareTo(Student st) {
		if (age == st.age)
			return 0;
		else if (age > st.age)
			return 1;
		else
			return -1;
	}
}

/*		This is the Old way of doing this
//Non-generic  
import java.util.*;

public class MapExample1 {
	public static void main(String[] args) {
		Map map = new HashMap();
		//Adding elements to map  
		map.put(1, "Amit");
		map.put(5, "Rahul");
		map.put(2, "Jai");
		map.put(6, "Amit");
		//Traversing Map  
		Set set = map.entrySet();//Converting to Set so that we can traverse  
		Iterator itr = set.iterator();
		while (itr.hasNext()) {
			//Converting to Map.Entry so that we can get key and value separately  
			Map.Entry entry = (Map.Entry) itr.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}
*/