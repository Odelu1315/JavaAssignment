package mypack;
interface Vehicle{
	void drive();
}

interface Car extends Vehicle{
	void speed();
}

class Mercedes implements Car{
	public void drive() {
		System.out.println("the vehicle is moving");
	}
	public void speed() {
		System.out.println("the car moving with high speed");
		
	}
	public void brand() {
		System.out.println("Its Mercedes");
	}
}


public class assignment {

	public static void main(String[] args) {
		Mercedes m= new Mercedes();
		m.drive();
		m.speed();
		m.brand();
			}

}
