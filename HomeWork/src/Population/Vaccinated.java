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
		this.vaccinationTime=vacc;
	}
	
	public long getVaccinationTime() {
		Clock c=new Clock();
		
		return (c.now()-this.vaccinationTime)/24;
	}

	public void setVaccinationTime(long vaccinationTime) {
		this.vaccinationTime = vaccinationTime;
	}

	public double getCoefficientProbability() {
		return coefficientProbability;
	}
	
	public void setCoefficientProbability() {
		
		if( this.vaccinationTime < 21L) 
			
			this.coefficientProbability=Math.min(1, 0.56 + 0.15*(Math.sqrt(21-this.vaccinationTime)));
		else
			this.coefficientProbability=Math.max(0.5, 1.05/(this.vaccinationTime-14));
		
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
	
	/*
	 * public String toString() { return
	 * "Vaccinated {age= "+super.getAge()+" location= "+super.getLocation().toString
	 * ()+ " settlement= "+ super.getSettlement().toString()+
	 * "coefficientProbability= "+ this.coefficientProbability+
	 * " vaccinationTime= "+ this.vaccinationTime+"}"; }
	 */
}