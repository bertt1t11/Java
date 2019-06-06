
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

	{ // Using instance initializer block instead of constructor
		nbrOfBicycles++;
		System.out.println("Used an Instance Initializer Block for Bicycle to increment nbrOfBicycles.");
	}

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
		System.out.println("Motorcycle Properties Display ------------");
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
	}

	void callSuperDisplayFunction() {
		DisplayMotorcycleProperties();
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
		MotorBike.overrideTest(); // You can call base class static method here 
		// But of course static methods can ONLY access static properties LOL
		// This works in constructors since they are static also (and not inherited)
		//		even though they arent necessarily declared as such.
	}

	public void Ride() { // over rode this without using @override
		System.out.println("Riding My BITCHIN Chopper...");
		timesRidden++;
	}

	void DisplayMotorcycleProperties() {
		System.out.println("Chopper Properties Display ------------");
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
	}
}

public class InterfaceDEMO1 {

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
		System.out.println("Now to call regualr display f(x)!!!!!!!!!!");
		myChopper3.DisplayMotorcycleProperties();
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
		myBicycle2.DisplayTimesRidden();
		myChopper.DisplayTimesRidden();

	}
}