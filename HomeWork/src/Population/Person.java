package Population;
import Country.*;
import Location.*;
import Simulation.Clock;
import Virus.*;


public abstract class Person {
	
	private int age;
	
	private Point location;
	
	private Settlement settlement;
	
	public abstract double contagionProbability();
	
	public Person(int age, Point p, Settlement sett) {
		
		this.age=age;
		this.location=p;
		this.settlement=sett;
	}
	
	public Person contagion (IVirus virus) {
		Sick s=new Sick(this.age,this.location,this.settlement,Clock.now(),virus);
		return s;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public Settlement getSettlement() {
		return settlement;
	}

	public void setSettlement(Settlement settlement) {
		this.settlement = settlement;
	}
	
	
}