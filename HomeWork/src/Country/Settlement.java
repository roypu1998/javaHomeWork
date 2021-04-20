package Country;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Location.*;
import Population.*;

public class Settlement {
	
	private String name;
	
	private Location location;
	
	private List<Person> people;
	
	private RamzorColor ramzorColor;
	
	public Settlement (String name, Location location,RamzorColor ramzorColor) {
		this.name=name;
		this.location=location;
		this.people=new ArrayList<>();
		this.ramzorColor=ramzorColor;
	}

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
	
	public Point randomLocation() {
		
		int x,y,w,h;
		
		x=this.getLocation().getPosition().getX();	
		y=this.getLocation().getPosition().getY();
		
		w=this.getLocation().getSize().getWidth();
		h=this.getLocation().getSize().getHeight();	
		
		int random_x= (int)Math.floor(Math.random()*((x+w)-x+1)+x);
		int random_y = (int)Math.floor(Math.random()*((y+h)-x+1)+y);
		
		Point p=new Point(random_x,random_y);
		return p;
		
	}
	
	public boolean addPerson(Person p) {
		
		this.getPeople().add(p);
		
		return true;
	}
	
	public boolean transferPerson(Person p, Settlement s) {
		
		s.people.add(p);
		
		return true;
	}
	
	public void printPeople() {
		
		System.out.println(this.getPeople());
	}
	
	public String toString() {
		return "Settlement {name= " +this.name+" location= "
	+this.location.toString()+ " ramzorColor= "+this.ramzorColor
	+" people= "+this.people.toString()+"}";
				
	}
}