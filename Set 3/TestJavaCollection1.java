import java.util.*;

class TestJavaCollection1 {
	public static void main(String args[]) {
		System.out.println("List Section.........");
		ArrayList<String> list = new ArrayList<String>();//Creating arraylist  
		list.add("Ravi");//Adding object in arraylist  
		list.add("Vijay");
		list.add("Ravi");
		list.add("Ajay");
		//Traversing list through Iterator  
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		Iterable listItbl; // Base interface
		Collection listCltn1; // 2nd level interface (more moethods)
		List listL; // Final level interface (most methods and includes iterable AND collection methods)
		Collection listCltn = list.subList(0, 2);
		//listItbl		// You can verify the method hiearchy
		//listCltn1.
		//listL.
		System.out.println("");
		LinkedList<String> al = new LinkedList<String>();
		al.add("Ravi");
		al.add("Vijay");
		al.add("Ravi");
		al.add("Ajay");
		al.add("Vijay");
		al.add("Vijay");
		al.add("Vijay");
		Iterator<String> itr2 = al.iterator();
		while (itr2.hasNext()) {
			System.out.println(itr2.next());
		}

		System.out.println("");
		Vector<String> v = new Vector<String>();
		v.add("Ayush");
		v.add("Amit");
		v.add("Ashish");
		v.add("Amit");
		v.add("Garima");
		Iterator<String> itr3 = v.iterator();
		while (itr3.hasNext()) {
			System.out.println(itr3.next());
		}

		System.out.println("");
		Stack<String> stack = new Stack<String>();
		stack.push("Ayush");
		stack.push("Garvit");
		stack.push("Ayush");
		stack.push("Ayush");
		stack.push("Amit");
		stack.push("Ashish");
		stack.push("Garima");
		stack.pop(); // Removes the object at the top of this stack and returns that object as the value of this function.
		Iterator<String> itr4 = stack.iterator();
		while (itr4.hasNext()) {
			System.out.println(itr4.next());
		}

		System.out.println("");
		System.out.println("Queue Section.......");
		PriorityQueue<String> queue = new PriorityQueue<String>();
		queue.add("Amit Sharma");
		queue.add("Vijay Raj");
		queue.add("JaiShankar");
		queue.add("Raj");
		System.out.println("head:" + queue.element());
		System.out.println("head:" + queue.peek());
		System.out.println("iterating the queue elements:");
		Iterator itr5 = queue.iterator();
		while (itr5.hasNext()) {
			System.out.println(itr5.next());
		}
		queue.remove(); // Retrieves and removes the head of this queue. This method differs from poll only in that it throws an exception if this queue is empty.
		queue.poll(); // Removes head of que
		System.out.println("after removing two elements:");
		Iterator<String> itr6 = queue.iterator();
		while (itr6.hasNext()) {
			System.out.println(itr6.next());
		}

		System.out.println("");
		//Creating Deque and adding elements  
		Deque<String> deque = new ArrayDeque<String>();
		deque.add("Gautam");
		deque.add("Karan");
		deque.add("Ajay");
		//Traversing elements  
		for (String str : deque) {
			System.out.println(str);
		}

		System.out.println("");
		System.out.println("Set Section......");
		HashSet<String> set = new HashSet<String>();
		set.add("Ajay");
		set.add("Ravi");
		set.add("Vijay");
		set.add("Ravi");
		set.add("Ajay");
		set.add("Ajay");
		//Traversing elements  
		Iterator<String> itr8 = set.iterator();
		while (itr8.hasNext()) {
			System.out.println(itr8.next());
		}
		System.out.println("4 duplicates automatically removed.");

		System.out.println("");
		LinkedHashSet<String> set2 = new LinkedHashSet<String>();
		set2.add("Ravi");
		set2.add("Vijay");
		set2.add("Ravi");
		set2.add("Fart Head");
		set2.add("Ajay");
		set2.add("the Fart Head");
		set2.add("Fart Head");
		Iterator<String> itr9 = set2.iterator();
		while (itr9.hasNext()) {
			System.out.println(itr9.next());
		}

		System.out.println("");
		//Creating and adding elements  
		TreeSet<String> set3 = new TreeSet<String>();
		set3.add("Ravi");
		set3.add("Vijay");
		set3.add("Ravi");
		set3.add("Ajay");
		//traversing elements  
		Iterator<String> itr10 = set.iterator();
		while (itr10.hasNext()) {
			System.out.println(itr10.next());
		}

		System.out.println("");
		System.out.println("");
		System.out.println("Array List traversing techniques...");
		System.out.println("arraylist...");
		ArrayList<String> listX = new ArrayList<String>();//Creating arraylist    
		listX.add("Ravi");//Adding object in arraylist    
		listX.add("Vijay");
		listX.add("Ravi");
		listX.add("Ajay");
		//Invoking arraylist object   
		System.out.println(listX);

		System.out.println("");
		System.out.println("Traversing list through Iterator");
		//Traversing list through Iterator  (like all above)
		Iterator itr11 = listX.iterator();
		while (itr11.hasNext()) {
			System.out.println(itr11.next());
		}

		System.out.println("");
		System.out.println("Traversing list through for-each loop");
		//Traversing list through for-each loop  
		for (String obj : listX)
			System.out.println(obj);

		System.out.println("Traversing list through List Iterator:");

		//Here, element iterates in reverse order  
		ListIterator<String> list1 = listX.listIterator(listX.size());
		while (list1.hasPrevious()) {
			String str = list1.previous();
			System.out.println(str);
		}
		System.out.println("Traversing list through for loop:");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(listX.get(i));
		}

		System.out.println("Traversing list through forEach() method:");
		//The forEach() method is a new feature, introduced in Java 8.  
		listX.forEach(a -> { //Here, we are using lambda expression  
			System.out.println(a);
		});

		System.out.println("Traversing list through forEachRemaining() method:");
		Iterator<String> itr222 = listX.iterator();
		itr222.forEachRemaining(a -> //Here, we are using lambda expression  
		{
			System.out.println(a);
		});
	}
}
