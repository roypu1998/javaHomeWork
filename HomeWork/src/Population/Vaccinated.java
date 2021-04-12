package Population;

import java.math.*;

public class Vaccinated extends Person {

	private double coefficientProbability ;
	
	private long vaccinationTime;
	
	public long getVaccinationTime() {
		return vaccinationTime;
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
		// TODO Auto-generated method stub
		return 0;
	}
	
}