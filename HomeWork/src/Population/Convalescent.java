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
}