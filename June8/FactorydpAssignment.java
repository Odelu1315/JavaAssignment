package mypack;
interface Vehicle2{
	void travel();
}
class Car2 implements Vehicle2{
	public void travel() {
		System.out.println("Car is travelling");
	}
}
class Bike implements Vehicle2{
	public void travel() {
		System.out.println("Bike is travelling");
	}
}

class Jeep implements Vehicle2{
	public void travel() {
		System.out.println("Jeep is travelling");
	}
}

class VehicleFactory{
	public Vehicle2 getVehicle(String vehicleType) {
		if (vehicleType==null) {
			return null;
		}
		if (vehicleType =="Car") {
			return new Car2();
		}else if (vehicleType=="Bike") {
			return new Bike();
		}else if(vehicleType=="Jeep") {
			return new Jeep();
		}
		return null;
	}
}
public class FactorydpAssignment {

	public static void main(String[] args) {
		VehicleFactory vehicleFactory =new VehicleFactory();
		Vehicle2 vehicle1= vehicleFactory.getVehicle("Car");
		vehicle1.travel();
		Vehicle2 vehicle2=vehicleFactory.getVehicle("Bike");
		vehicle2.travel();
		Vehicle2  vehicle3= vehicleFactory.getVehicle("Jeep");
		vehicle3.travel();

	}

}
