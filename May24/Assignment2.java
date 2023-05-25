package mypack;

interface Budget{
	void mileage();
}
interface Luxury{
	void price();
}

interface both extends Budget,Luxury{
	
}

class Nano implements Budget{
	public void mileage() {
		System.out.println("class nanooo");
		System.out.println("Nano car provides good mileage");
	}
}

class RangeRover implements Luxury{
	public void price() {
		System.out.println("class RangeRover");
		System.out.println("High  Price");
	}
}

class Hondacity implements both{
	public void mileage() {
		System.out.println("class hondacity");
		System.out.println("honda  city gives ggod mileage");
	}
	public void price() {
		System.out.println("hondacity price in budget");
	}
	
}

public class Assignment2 {

	public static void main(String[] args) {
		Nano n =new Nano();
		RangeRover r =new RangeRover();
		Hondacity h = new Hondacity();
		
		n.mileage();
		r.price();
		h.mileage();
		h.price();
		

	}

}
