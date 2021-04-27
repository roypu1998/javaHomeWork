package Population;

import Country.Settlement;
import Location.Point;
import Simulation.Clock;
import Virus.IVirus;

public class Healthy extends Person{
	
	
	private final double coefficientProbability=1.0;
	
	public Healthy(int age,Point p,Settlement s){
		
		super(age,p,s);
	}
	
	public Person vaccinate() {
		Clock c=new Clock();
		Vaccinated vac= new Vaccinated(this.getAge(),this.getLocation(),this.getSettlement(),this.coefficientProbability,c.now());
		this.getSettlement().addPerson(vac);
		this.getSettlement().getPeople().remove(this);
		return vac;

	}
	
	public double getCProbability() {
		
		return this.coefficientProbability; 
	}

	@Override
	public double contagionProbability() {
		return 0.002;
	}
	
	/*
	 * public String toString() { return
	 * "Healthy {age= "+super.getAge()+" location= "+super.getLocation().toString()+
	 * " settlement= "+ super.getSettlement().toString()+
	 * "coefficientProbability= "+ this.coefficientProbability+"}"; }
	 */
}