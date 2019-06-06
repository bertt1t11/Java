
interface Washable {
	public void wash();

	public void washedWith();

	static int timesAllRidden = 0; // in an interface you can define constants
	static int washableObjects = 0; //   but not variable members (properties)
}

interface Rideable {
	static int rideableObjects = 0;
	int maxSpeed = 10; // This too is a constant smh
	int minSpeed = 2; // and they must be initialized as such (no placeholders)
	String riderName = "Name Not Entered";

	public int getTooFast(int startSpeed);

	public int nbrTimesRidden();

	public void Ride();

	public void DisplayTimesRidden();

	public void TestOfInterfaceDummy(int sss);
}

final class Car implements Washable, Rideable { // Car cant be inherited (has a private member also)
	Car() {
		/*
		rideableObjects++;	 // These are defined in interface
		washableObjects++;   // constants only i guess
		*/
		nbrOfCars++;
		System.out.println("Constructor: ridableObjects and washableObjects (" + rideableObjects + ", "
				+ washableObjects + ") are immutable;  CARS = " + nbrOfCars);
	}

	public void TestOfInterfaceDummy(int sss) {
	} // This is a dummy function

	private static int nbrOfCars;
	static int timesRidden;
	String riderName = "Fred OveridesInterface since he is locally defined";

	public void wash() {
		System.out.println("Washing the Car");
	}

	public void washedWith() {
		System.out.println("Plain old water");
	}

	public int nbrTimesRidden() {
		return timesRidden++;
	}

	public int getTooFast(int startSpeed) {
		int outSpeed = 0;
		outSpeed = maxSpeed * startSpeed;
		return outSpeed;
	}

	public void Ride() {
		System.out.println("Riding in the car");
		timesRidden++;
	}

	public void DisplayTimesRidden() {
		System.out.println("I have driven " + timesRidden + " times. I Own " + nbrOfCars);
	}

	void DisplayCarProperties() {
		System.out.println("maximum Speed (immutable): " + maxSpeed);
		System.out.println("times Ridden: " + timesRidden);
		this.wash();
		Ride(); // 'this' is unnecessary  
		System.out.println("rider name (immutable): " + riderName);
		System.out.println("min speed (immutable): " + minSpeed);
		System.out.println("times All Ridden (immutable but locally redefined): " + timesAllRidden);
		System.out.println("washable Objects (immutable): " + washableObjects);
		System.out.println("Private: number of Cars: " + nbrOfCars);
	}
}

class Bicycle implements Washable, Rideable {
	Bicycle() {
		System.out.println("I dont need a Bicycle constructor, here is one anyway");
	}

	// Dont do this 'protected static int nbrOfBicycles = 0;', it will reset counter with each object creation
	protected static int nbrOfBicycles;
	static int timesRidden = 0; //
	String stBicycleColor = "Gold";

	{ // Using instance initializer block instead of constructor
		nbrOfBicycles++;
		System.out.println("Used an Instance Initializer Block for Bicycle to increment nbrOfBicycles.");
	}

	public void TestOfInterfaceDummy(int sss) {
		return;
	} // This is a dummy function

	public void wash() {
		System.out.println("Washing the Bicycle");
	}

	public void washedWith() {
		System.out.println("Soap and water");
	}

	public int nbrTimesRidden() {
		return timesRidden++;
	}

	public int getTooFast(int startSpeed) {
		int outSpeed = 0;
		outSpeed = maxSpeed * startSpeed;
		return outSpeed;
	}

	public void Ride() {
		System.out.println("Riding on the Bicycle...");
		timesRidden++;
	}

	public void DisplayTimesRidden() {
		System.out.println("I have ridden my Bicycle " + timesRidden + " times. I Own " + nbrOfBicycles);
	}

	void DisplayBicycleProperties() {
		System.out.println("Bicycle Properties Display ------------");
		System.out.println("maximum Speed (immutable): " + maxSpeed);
		System.out.println("times Ridden: " + timesRidden);
		this.wash();
		Ride(); // 'this' is unnecessary 
		System.out.println("rider name (immutable): " + riderName);
		System.out.println("min speed (immutable): " + minSpeed);
		System.out.println("times All Ridden (immutable): " + timesAllRidden);
		System.out.println("washable Objects (immutable): " + washableObjects);
		System.out.println("Prrotected: number of Bicycles: " + nbrOfBicycles);
	}

}

class MotorBike implements Rideable {
	MotorBike() { // NEVER put a return type on a constructor, it wont call it
		nbrOfBikes++;
		System.out.println("Used a MotorBike Constructor to increment nbrOfBikes.");
	}

	public void TestOfInterfaceDummy(int sss) {
		//		return;
	} // This is a dummy function

	static int timesRidden = 0;
	protected int recursionStopper = 0;
	protected static int nbrOfBikes;

	public void getNbrOfBikes() {
		System.out.println("Number of motorized bikes: " + nbrOfBikes);
	}

	public void wash() { // kept this from washable inx though it isnt implemented here
		System.out.println("Washing the MotorBike");
		System.out.println("Dont incorporate Washable interface so I didnt 'have' to include this method.");
	}
	// dont need washedWith since dont implement that interface

	public int nbrTimesRidden() {
		return timesRidden++;
	}

	public int getTooFast(int startSpeed) {
		int outSpeed = 0;
		outSpeed = maxSpeed * startSpeed;
		return outSpeed;
	}

	public void Ride() {
		System.out.println("Riding on the Motor Bike...");
		timesRidden++;
	}

	public void DisplayTimesRidden() {
		System.out.println("I have ridden my Motorcycle " + timesRidden + " times. I Own " + nbrOfBikes);
	}

	void DisplayMotorcycleProperties() {
		System.out.println("########################## BEGIN Motorcycle Properties Display ------------");
		System.out.println("maximum Speed (immutable): " + maxSpeed);
		System.out.println("times Ridden: " + timesRidden);
		this.wash();
		Ride(); // 'this' is unnecessary 
		System.out.println("Motorcycle rider name (immutable): " + riderName);
		System.out.println("min speed (immutable): " + minSpeed);
		System.out.println(
				"times All Ridden (immutable): " + "cant show timesAllRidden since Washable inx not implemented.");
		System.out.println(
				"washable Objects (immutable): " + "cant show washableObjects since Washable inx not implemented.");
		System.out.println("Prrotected: number of Bikes: " + nbrOfBikes);
		System.out.println("########################## END Motorcycle Properties Display ------------");
		return;
	}

	void callSuperDisplayFunction() {
		DisplayMotorcycleProperties();
		return; // Put this here to properlly collapse routines (should be here in all methods anyway)
	}

	public static void overrideTest() {
		System.out.println("This is from MotorBike class...");
	}
}

class Chopper extends MotorBike {
	String BikeColor = "Black";
	String DressCode = "Freakish";

	public static void overrideTest() { // Doesnt look like @override is need here either
		System.out.println("This is from Chopper class...");
		MotorBike.overrideTest(); // Anonymous f(x) call - You can call base class static method here 
		// But of course static methods can ONLY access static properties LOL
		// This works in constructors since they are static also (and not inherited)
		//		even though they arent necessarily declared as such.
	}

	public void TestOfInterfaceDummy(int sss) {
		System.out.println("\n" + sss + "<: This is the DUMMY Function.  Dont think it is very");
		System.out.println("useful since you have to put it as a dummy stub in");
		System.out.println("each class.  Too much work for functional upcasting.");
	} // This is a dummy function

	public void Ride() { // over rode this without using @override
		System.out.println("Riding My BITCHIN Chopper...");
		timesRidden++;
	}

	void DisplayMotorcycleProperties2() {
		System.out.println("<><><><><><><><><><><><><><><> BEGIN Chopper Properties Display ------------");
		System.out.println("Color: " + BikeColor);
		System.out.println("Dress Code: " + DressCode);
		System.out.println("Man, " + maxSpeed + " mph is too slow, " + maxSpeed * 12 + " mph is more like it!");
		//this.MotorBike.DisplayBicycleProperties();
		System.out.println("======= NOW FOR BASE CLASS PROPERTIES =======");
		recursionStopper++;
		System.out.println("Recursion preventor count: " + recursionStopper + ", with % 5: " + (recursionStopper % 5));
		if (recursionStopper % 5 < 4) { // would need %6 to test for 5
			callSuperDisplayFunction();
		} else {
			System.out.println(
					"commented out 'recursionStopper = 0;' so it wont go recursive next time this is called...");
			//recursionStopper = 0;
		}
		System.out.println("<><><><><><><><><><><><><><><> END Chopper Properties Display ------------");
		System.out.println("...................DONE.............");
	}
}

public class InterfaceDEMO2 {

	public static void main(String[] args) {
		Car myCar = new Car();
		Bicycle myBicycle = new Bicycle();
		MotorBike myBike = new MotorBike();
		MotorBike myBike2 = new MotorBike();
		Chopper myChopper = new Chopper();
		Chopper myChopper2 = new Chopper();
		Chopper myChopper3 = new Chopper();

		System.out.println("====Car Section <<<<<<<<<");
		myCar.DisplayCarProperties();
		myCar.Ride();
		myCar.getTooFast(25);
		myCar.nbrTimesRidden();
		myCar.wash();
		myCar.washedWith();

		System.out.println("");
		System.out.println("====Bicycle Section <<<<<<<<<");
		myBicycle.DisplayBicycleProperties();
		myBicycle.Ride();
		myBicycle.Ride();
		myBicycle.Ride();
		myBicycle.Ride();
		myBicycle.Ride();
		myCar.getTooFast(2);
		myBicycle.wash();
		myBicycle.nbrTimesRidden();
		myBicycle.washedWith();
		System.out.println(
				"I shouldnt be able to see this protected variable: nbrOfBicycles = " + myBicycle.nbrOfBicycles);
		myBicycle.nbrOfBicycles = 5;
		System.out.println("...Let alone change it: nbrOfBicycles = " + myBicycle.nbrOfBicycles);

		System.out.println("");
		System.out.println("====Bike Section <<<<<<<<<");
		myBike.Ride();
		myBike.DisplayMotorcycleProperties();
		myBike.Ride();
		myBike.getTooFast(77);
		myBike.nbrTimesRidden();
		myBike2.overrideTest();
		myBike.wash();

		System.out.println("");
		System.out.println("====Chopper Section <<<<<<<<<");
		myBike.Ride();
		myBike.Ride();
		myBike.Ride();
		myChopper.Ride();
		myChopper.Ride();
		myChopper.callSuperDisplayFunction();
		System.out.println("...");
		System.out.println("Now to call regualr display f(x)!!!!!!!!!!");
		myChopper3.DisplayMotorcycleProperties2();
		myChopper.Ride();
		myChopper.overrideTest();
		myChopper.wash();
		myChopper.nbrTimesRidden();
		myChopper.getNbrOfBikes();

		System.out.println("");
		System.out.println("====FINAL TALLY <<<<<<<<<");
		myCar.DisplayTimesRidden();
		myBicycle.DisplayTimesRidden();
		myBike.DisplayTimesRidden();
		myChopper.DisplayTimesRidden();
		Chopper myChopper5 = new Chopper();
		Chopper myChopper6 = new Chopper();
		Chopper myChopper7 = new Chopper();
		Chopper myChopper8 = new Chopper();
		Chopper myChopper15;
		System.out.println("Now for an array...");
		Chopper myChoppers[] = new Chopper[15];
		for (int i = 0; i < 15; i++) {
			myChoppers[i] = new Chopper();
		}
		myChoppers[8].Ride();

		System.out.println("");
		System.out.println("====FINAL TALLY <<<<<<<<<");
		Bicycle myBicycle2 = new Bicycle();
		myBicycle2.DisplayTimesRidden();
		myChopper.DisplayTimesRidden();
		myChopper.nbrTimesRidden();
		myChopper.nbrTimesRidden();
		myChopper.nbrTimesRidden();
		myChopper.nbrTimesRidden();
		myChopper.nbrTimesRidden();
		myChopper.nbrTimesRidden();
		myChopper.nbrTimesRidden();
		myChopper.nbrTimesRidden();
		myChopper.nbrTimesRidden();
		Bicycle myBicycles[];
		myBicycles = new Bicycle[37];
		for (int i = 0; i < 37; i++) {
			myBicycles[i] = new Bicycle();
			if ((i % 2) == 0) {
				myBicycles[i].Ride();
			}
			// cant do dat ---> (i < 15) ? myBicycles[i].getTooFast(25) : myBicycles[i].getTooFast(1);
			myBicycles[i].stBicycleColor = (i < 15) ? "Blue" : "White";
		}
		System.out.print("my 10th bike color is: " + myBicycles[10].stBicycleColor);
		System.out.println(", and my 20th bike color is: " + myBicycles[20].stBicycleColor);
		System.out.println("The system name for my 30th bike is: " + myBicycles[30]);

		System.out.println("");
		int a[];
		a = new int[5];
		for (int i = 0; i < 5; i++) {
			a[i] = i * i;
			System.out.print("  a[" + i + "] = " + a[i]);
		}
		System.out.println("");
		myBicycle2.DisplayTimesRidden();
		myChopper.DisplayTimesRidden();

		System.out.println("");
		System.out.println("");
		Rideable myGenTranspo = new Car();
		myGenTranspo.Ride(); // I can access the Rideable methods ONLY as I suspected
		myGenTranspo = new MotorBike();
		myGenTranspo.Ride(); // yup... same here, so interface is total bullshit then

		MotorBike myGenBike = new Chopper(); // upcasting
		myGenBike.callSuperDisplayFunction(); // Just like this can only call functions for Motorbike and not Chopper
		System.out.println("Chopper 3 color = " + myChopper3.BikeColor);
		myChopper3.BikeColor = "Fuck Dis";
		System.out.println("Chopper 3 color = " + myChopper3.BikeColor);
		myGenBike = myChopper3;
		myGenBike.Ride(); // At least it calls the overriden method (since base class version isnt included)
		// Perhpas that is one use for that interface crap in that you can
		//   pick which properties and methods (members) to allow 'common base
		//   pointer' access to???...
		myGenBike.TestOfInterfaceDummy(55);
		//java.awt.Graphics myG = new java.awt.Graphics();
		int myClr = java.awt.color.ColorSpace.TYPE_RGB;
		//java.awt.Graphics2D g2d = new java.awt.Graphics2D().create();
		//System so = new System.out.println();
		java.nio.CharBuffer cbuff;
		java.awt.Graphics2D g2d;

	}
}