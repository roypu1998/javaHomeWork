package Population;

import Country.Settlement;
import Location.Point;
import Virus.*;

public class Convalescent extends Person {
	
	private final double coefficientProbability=0.2;
	
	private IVirus virus;
	
	public Convalescent(int age,Point p,Settlement s,IVirus vir){
		
		super(age,p,s);
		
		this.virus=vir;
	}
	
	public double contagionProbability() {
		return this.coefficientProbability; 
		}
	
	public boolean equals(Convalescent c) {
		boolean flag=super.equals(c);
		if(flag) {
			return true;
		}
		return false;
	}
		/*
		 * public String toString() { return
		 * "Convalescent {age= "+super.getAge()+" location= "+super.getLocation().
		 * toString()+ " settlement= "+ super.getSettlement().toString()+
		 * "coefficientProbability= "+ this.coefficientProbability+ " virus= "+
		 * this.virus.toString()+"}"; }
		 */
	
	
	
}