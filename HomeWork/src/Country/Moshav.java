package Country;

import java.lang.Math;

public class Moshav extends Settlement {
	
	
	public RamzorColor calculateRamzorGrade() {
		
		double c = 0.3 + 3 * (Math.pow(((Math.pow(1.2, super.calculateRamzorGrade().getRamzorColor())) * (super.contagiousPercent()-0.35) ),5));
		
		RamzorColor rc = null;
		
		return rc.getName(c);
	}
	
}
