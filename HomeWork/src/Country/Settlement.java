package Country;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Location.*;
import Population.*;
import Simulation.Clock;
import Virus.BritishVariant;
import Virus.ChineseVariant;
import Virus.IVirus;
import Virus.SouthAfricanVariant;

public class Settlement {
	
	private String name;
	
	Random rand= new Random();	
	
	private int vacineNum=0, countDeath=0,maxPpl;
	
	private Location location;
	
	private List<Person> people, notSickPpl;
	
	private List<Sick> SickPpl;
	
	private RamzorColor ramzorColor;
	
	private List <Settlement> connectedAreas;
	
	public Settlement (String name, Location location,RamzorColor ramzorColor) {
		this.name=name;
		this.location=location;
		this.people=new ArrayList<>();
		this.notSickPpl= new ArrayList<>();
		this.SickPpl= new ArrayList<>();
		this.ramzorColor=ramzorColor;
		this.connectedAreas= new ArrayList<>();
	}
	
	
	public Settlement RandConnectedArea() {
		int x= rand.nextInt(this.connectedAreas.size());
		return this.connectedAreas.get(x);
	}
	
	public List<Person> getNotSickPpl() {
		return notSickPpl;
	}

	public IVirus getRandVirus() {
		String [] virusNames={"BritishVariant", "ChineseVariant", "SouthAfricaVariant"};
		int random= rand.nextInt(3);
		switch (random){
		case 0: return BritishVariant.get_instance();
		case 1: return ChineseVariant.get_instance();
		case 2: return SouthAfricanVariant.get_instance();
		}
		return null;
		
	}
	public void setNotSickPpl(List<Person> notSickPpl) {
		this.notSickPpl = notSickPpl;
	}

	public List<Settlement> getConnectedAreas() {
		return connectedAreas;
	}

	public void setConnectedAreas(List<Settlement> connectedAreas) {
		this.connectedAreas = connectedAreas;
	}
	
	public void addConnectedAreas(Settlement s) {
		this.connectedAreas.add(s);
	}
	
	public int getCountDeath() {
		return this.countDeath;
	}
	
	public List<Sick> getSickPpl() {
		return SickPpl;
	}

	public void setSickPpl(List<Sick> sickPpl) {
		SickPpl = sickPpl;
	}
	
	public int VaccinatedAmount() {
		int amount=0;
		for (Person p: this.people) {
			if (p instanceof Vaccinated)
				amount++;
		}
		
		return amount;
		
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
		this.ramzorColor=this.ramzorColor.getName(this.ramzorColor.getRamzorColor());
		return this.ramzorColor;
	}

	public void setRamzorColor(RamzorColor ramzorColor) {
		this.ramzorColor = ramzorColor;
	}

	
	public RamzorColor calculateRamzorGrade() {
		
		return this.ramzorColor;
	}
	
	public double contagiousPercent() {
		int sickPeople = this.SickPpl.size();
		return (double)sickPeople/this.people.size();
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
		
		if(p instanceof Sick)
			this.getSickPpl().add((Sick) p);
		else {
			this.getNotSickPpl().add(p);
		}
		this.getPeople().add(p);
		
		return true;	
	}
	

	public boolean addSickPerson() {
		
		Sick sc;
				
		int numOfPpl, sickPpl;
			
		numOfPpl=this.getPeople().size();
			
		sickPpl=(int) (numOfPpl*0.001);
						
		int x ;
		
		for (int i=0; i<sickPpl;i++) {
			
			x= rand.nextInt(numOfPpl);
				
			Person p=this.getPeople().get(x);
				
			sc= new Sick(p.getAge(),p.getLocation(),p.getSettlement(),Clock.now(), p.getSettlement().getRandVirus());
				
			this.getNotSickPpl().remove(p);
			this.getPeople().remove(p);
			this.getPeople().add(sc);
			this.getSickPpl().add(sc);
		}
		
		return true;	
	}
	
	public int getVacineNum() {
		return vacineNum;
	}

	public void setVacineNum(int vacineNum) {
		this.vacineNum += vacineNum;
	}

	public void setCountDeath(int countDeath) {
		this.countDeath += countDeath;
	}

	public boolean transferPerson(Person p, Settlement s) {
				
		double prob= this.ramzorColor.probTrans()*s.ramzorColor.probTrans();
		
		double x= rand.nextDouble();
		
		if (this.getPeople().size()+1>this.maxPpl)

			return false;
		
		if (prob>x) {

			p.getSettlement().getPeople().remove(p);
			
			if(p instanceof Sick) {
				s.SickPpl.add((Sick) p);
				p.getSettlement().getSickPpl().remove(p);
			}
			else {
				s.notSickPpl.add(p);
				p.getSettlement().getNotSickPpl().remove(p);

			}
			s.people.add(p);
			
			return true;

		}
		else
			return false;
	}
	
	public void printPeople() {
		
		System.out.println(this.getPeople());
	}
	
		public void setMax() {
		this.maxPpl=(int) (this.getPeople().size()*1.3);
	}

	public boolean equals(Settlement s) {
		boolean flag=super.equals(s);
		for(int i=0;i<s.getSickPpl().size();i++) {
			flag=(s.getSickPpl().get(i)==this.getSickPpl().get(i));
		}
		for(int i=0;i<s.getNotSickPpl().size();i++) {
			flag=(s.getNotSickPpl().get(i)==this.getNotSickPpl().get(i));
		}
		for(int i=0;i<s.getPeople().size();i++) {
			flag=(s.getPeople().get(i)==this.getPeople().get(i));
		}
		for(int i=0;i<s.getConnectedAreas().size();i++) {
			flag=(s.getConnectedAreas().get(i)==this.getConnectedAreas().get(i));
		}
		if(this.countDeath==s.countDeath&& this.location==s.location && this.maxPpl==s.maxPpl
				&& this.name== s.name&& this.vacineNum==s.vacineNum&& this.ramzorColor==s.ramzorColor && flag) {
			return true;
		}
		return false;
	}	
	/*
	 * public String toString() { return "Settlement {name= "
	 * +this.name+" location= "+this.location.toString()
	 * +" ramzorColor= "+this.ramzorColor +" people= "+this.people.toString()+"}"; }
	 */


}