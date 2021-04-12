package Population;

import Virus.*;

public class Convalescent extends Person {
	
	private final double coefficientProbability=0.2;
	
	private IVirus virus;
	
	public double contagionProbability() {
		return this.coefficientProbability; 

	}
}