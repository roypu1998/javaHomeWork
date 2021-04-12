package Country;
import java.util.List;

import Location.*;
import Population.*;

public class Settlement {
	
	private String name;
	
	private Location location;
	
	private List<Person> people;
	
	private RamzorColor ramzorColor;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Person> getPeople() {
		return people;
	}

	public void setPeople(List<Person> people) {
		this.people = people;
	}

	public RamzorColor getRamzorColor() {
		return ramzorColor;
	}

	public void setRamzorColor(RamzorColor ramzorColor) {
		this.ramzorColor = ramzorColor;
	}

	
	public RamzorColor calculateRamzorGrade() {
		
		return this.ramzorColor;
	}
	
	public double contagiousPercent() {
		
		int sickPeople = 0;
		
		for( int i=0; i< this.people.size(); i++) {
			
			if (this.people.get(i) instanceof Sick )
				
				sickPeople++;
		}
		
		return sickPeople/this.people.size();
	}
	
	public Point randomLocation() {}
	
	public boolean addPerson(Person p) {
		
		this.people.add(p);
		
		return true;
	}
	
	public boolean transferPerson(Person p, Settlement s) {
		
		s.people.add(p);
		
		return true;
	}
}