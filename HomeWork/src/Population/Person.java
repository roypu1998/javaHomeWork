package Population;
import Country.*;
import Location.*;
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
		Sick s=new Sick();
		s.setAge(this.age);
		s.setLocation(this.location);
		s.setSettlement(this.settlement);
		s.setVirus(virus);
		s.setContagiousTime(0);
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