package Population;

public class Healthy extends Person{
	
	private final double coefficientProbability=1.0;
	
	public Person vaccinate() {
		return null;
	}
	
	public double getCProbability() {
		
		return this.coefficientProbability; 
	}

	@Override
	public double contagionProbability() {
		// TODO Auto-generated method stub
		return 0;
	}
}