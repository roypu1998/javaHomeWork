package Population;

import java.math.*;

import Country.Settlement;
import Location.Point;
import Simulation.Clock;
import Virus.IVirus;

public class Vaccinated extends Person {

	private double coefficientProbability ;
	
	private long vaccinationTime;
	
	public Vaccinated(int age,Point p,Settlement s,double coeff,long vacc){
		
		super(age,p,s);
		this.coefficientProbability=coeff;
		this.vaccinationTime= new Clock().now();
	}
	
	public long getVaccinationTime() {		
		return this.vaccinationTime;
	}


	public double getCoefficientProbability() {
		return coefficientProbability;
	}
	
	public void setCoefficientProbability() {
		
		long t=new Clock().calcTime(this.vaccinationTime);
		
		if( t < 21L) 
			
			this.coefficientProbability=Math.min(1, 0.56 + 0.15*(Math.sqrt(21L-t)));
		else
			this.coefficientProbability=Math.max(0.5, 1.05/(t-14L));
		
	}

	@Override
	public double contagionProbability() {
		Clock c= new Clock();
		long t=this.getVaccinationTime();
		double v;
		if (t<21) {
			v=Math.min(1.0, 0.56+(0.15*(Math.sqrt(21-t))));
		}
		else {
			v=Math.max(0.05, (1.05/(t-14)));
		}
		return v;
	}
	
	public boolean equals(Vaccinated v) {
		boolean flag=super.equals(v);
		if(this.coefficientProbability==v.coefficientProbability&& this.vaccinationTime==v.vaccinationTime &&flag) {
			return true;
		}
		return false;
	}
	/*
	 * public String toString() { return
	 * "Vaccinated {age= "+super.getAge()+" location= "+super.getLocation().toString
	 * ()+ " settlement= "+ super.getSettlement().toString()+
	 * "coefficientProbability= "+ this.coefficientProbability+
	 * " vaccinationTime= "+ this.vaccinationTime+"}"; }
	 */
}