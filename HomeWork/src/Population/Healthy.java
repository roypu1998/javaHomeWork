package Population;

import Country.Settlement;
import Location.Point;
import Virus.IVirus;

public class Healthy extends Person{
	
	
	private final double coefficientProbability=1.0;
	
	public Healthy(int age,Point p,Settlement s){
		
		super(age,p,s);
	}
	
	public Person vaccinate() {
		return null;
	}
	
	public double getCProbability() {
		
		return this.coefficientProbability; 
	}

	@Override
	public double contagionProbability() {
		// TODO Auto-generated method stub
		return 0.002;
	}
}