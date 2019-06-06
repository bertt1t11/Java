import java.io.*;
import java.util.*;

//Let's see an example to serialize an ArrayList object 
// and then deserialize it.
class TestJavaCollection3 {

	public static void main(String[] args) {
		System.out.println("");
		System.out.println("SECTION: Serialize an ArrayList object");
		ArrayList<String> al = new ArrayList<String>();
		al.add("Ravi");
		al.add("Vijay");
		al.add("Ajay");

		try {
			//Serialization  
			FileOutputStream fos = new FileOutputStream("file");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(al);
			fos.close();
			oos.close();
			//Deserialization  
			FileInputStream fis = new FileInputStream("file");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList list = (ArrayList) ois.readObject();
			System.out.println(list);
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("");
		System.out.println("SECTION: ArrayList example to add elements");
		System.out.println("Initial list of elements: " + al);
		//Adding elements to the end of the list  
		al.add("Shit");
		al.add("Goat");
		al.add("Fucker");
		System.out.println("After invoking add(E e) method: " + al);
		//Adding an element at the specific position  
		al.add(1, "Gaurav");
		System.out.println("After invoking add(int index, E element) method: " + al);

		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("Sonoo");
		al2.add("Hanumat");
		//Adding second list elements to the first list  
		al.addAll(al2);
		System.out.println("After invoking addAll(Collection<? extends E> c) method: " + al);

		ArrayList<String> al3 = new ArrayList<String>();
		al3.add("John");
		al3.add("Rahul");
		//Adding second list elements to the first list at specific position  
		al.addAll(1, al3);
		System.out.println("After invoking addAll(int index, Collection<? extends E> c) method: " + al);

		System.out.println("");
		System.out.println("SECTION: ArrayList example to remove elements");
		al.add("Ravi");
		al.add("Vijay");
		al.add("Ajay");
		al.add("Anuj");
		al.add("Gaurav");
		System.out.println("Initial list of elements: " + al);
		System.out.println("An initial list of elements: " + al);
		//Removing specific element from arraylist  
		al.remove("Vijay");
		System.out.println("After invoking remove(object) method: " + al);
		//Removing element on the basis of specific position  
		al.remove(0);
		System.out.println("After invoking remove(index) method: " + al);

		//Creating another arraylist  
		ArrayList<String> al2b = new ArrayList<String>();
		al2b.add("Ravi");
		al2b.add("Hanumat");
		//Adding new elements to arraylist  
		al.addAll(al2b);
		System.out.println("Updated list : " + al);
		//Removing all the new elements from arraylist  
		al.removeAll(al2b);
		System.out.println("After invoking removeAll() method: " + al);
		//Removing elements on the basis of specified condition  
		al.removeIf(str -> str.contains("Ajay")); //Here, we are using Lambda expression   
		System.out.println("After invoking removeIf() method: " + al);
		//Removing all the elements available in the list  
		al.clear();
		System.out.println("After invoking clear() method: " + al);

		System.out.println("");
		System.out.println("");
		System.out.println("SECTION: ArrayList example of retainAll() method");
		System.out.println("Retains only the elements in this list that are ");
		System.out.println("contained in the specified collection. In other words, removes ");
		System.out.println("from this list all of its elements that are not contained in the specified collection.");
		System.out.println("");
		al.add("Ravi"); //
		al.add("Vijay");
		al.add("Ajay");
		ArrayList<String> al2c = new ArrayList<String>();
		al2c.add("Ravi");
		al2c.add("Hanumat");
		al.retainAll(al2c);
		System.out.println("iterating the elements after retaining the elements of al2c");
		Iterator itr = al.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println("");
		System.out.println("SECTION: ArrayList example of isEmpty() method");
		System.out.println("List contents: " + al);
		System.out.println("Is ArrayList Empty: " + al.isEmpty());
		al.add("Ravi");
		al.add("Vijay");
		al.add("Ajay");
		System.out.println("After Insertion");
		System.out.println("List contents: " + al);
		System.out.println("Is ArrayList Empty: " + al.isEmpty());
		al.clear();
		System.out.println("List contents: " + al);
		System.out.println("Is ArrayList Empty: " + al.isEmpty());

		System.out.println("");
		System.out.println("SECTION: ArrayList example of set() and get() method");
		al.add("Ravi");
		al.add("Vijay");
		al.add("Ajay");
		System.out.println("List contents: " + al);
		System.out.println("Before update: " + al.get(1));
		//Updating an element at specific position  
		al.set(1, "Gaurav");
		System.out.println("After update: " + al.get(1));
		System.out.println("List contents: " + al);

		System.out.println("");
		System.out.println("SECTION: ArrayList Example: Book");
		//Creating list of Books  
		List<Book> list = new ArrayList<Book>(); // First use of 'list' believe it or not!
		//Creating Books  
		Book b1 = new Book(101, "Let us C", "Yashwant Kanetkar", "BPB", 8);
		Book b2 = new Book(102, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
		Book b3 = new Book(103, "Operating System", "Galvin", "Wiley", 6);
		//Adding Books to list  
		list.add(b1);
		list.add(b2);
		list.add(b3);
		//Traversing list  
		for (Book b : list) {
			System.out.println(b.id + " " + b.name + " " + b.author + " " + b.publisher + " " + b.quantity);
		}

		System.out.println("");
		System.out.println("SECTION: Linked List Example");
		LinkedList<String> ll = new LinkedList<String>();
		ll.add("Ravi");
		ll.add("Vijay");
		ll.add("Ajay");
		//Traversing the list of elements in reverse order  
		Iterator i = ll.descendingIterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}

		System.out.println("");
		System.out.println("SECTION: List Interface");
		List<String> ali = new ArrayList<String>();
		ali.add("Amit");
		ali.add("Vijay");
		ali.add("Kumar");
		ali.add(1, "Sachin");
		System.out.println("An element at 2nd position: " + ali.get(2));
		for (String s : ali) {
			System.out.println(s);
		}

		System.out.println("");
		System.out.println("SECTION: ListIterator Interface");
		al.add("Amit");
		al.add("Vijay");
		al.add("Kumar");
		al.add(1, "Sachin");
		ListIterator<String> itrL = al.listIterator();
		System.out.println("Traversing elements in forward direction");
		while (itrL.hasNext()) {

			System.out.println("index:" + itrL.nextIndex() + " value:" + itrL.next());
		}
		System.out.println("Traversing elements in backward direction");
		while (itrL.hasPrevious()) {

			System.out.println("index:" + itrL.previousIndex() + " value:" + itrL.previous());
		}
		ArrayList<String> listXX = new ArrayList<String>();

		System.out.println("");
		System.out.println("SECTION: HashSet from another Collection");
		listXX.add("Ravi");
		listXX.add("Vijay");
		listXX.add("Ajay");

		HashSet<String> set = new HashSet(listXX);
		set.add("Gaurav");
		Iterator<String> i2 = set.iterator();
		while (i2.hasNext()) {
			System.out.println(i2.next());
		}

		System.out.println("");
		System.out.println("SECTION: TreeSet Example");
		TreeSet<String> Tset = new TreeSet<String>();
		Tset.add("A");
		Tset.add("B");
		Tset.add("C");
		Tset.add("D");
		Tset.add("E");
		System.out.println("Initial Set: " + Tset);
		System.out.println("Reverse Set: " + Tset.descendingSet());
		System.out.println("Head Set: " + Tset.headSet("C", true));
		System.out.println("SubSet: " + Tset.subSet("A", false, "E", true));
		System.out.println("TailSet: " + Tset.tailSet("C", false));

	}
}

class Book {
	int id;
	String name, author, publisher;
	int quantity;

	public Book(int id, String name, String author, String publisher, int quantity) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
	}
}