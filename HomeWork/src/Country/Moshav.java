package Country;

import java.lang.Math;

import Location.Location;

public class Moshav extends Settlement {
	
	public Moshav (String name, Location location,RamzorColor ramzorColor) {
		super(name,  location, ramzorColor);
	}

	public RamzorColor calculateRamzorGrade() {
		
		double c = 0.3 + 3 * (Math.pow(((Math.pow(1.2, super.calculateRamzorGrade().getRamzorColor())) * (super.contagiousPercent()-0.35) ),5));
		
		RamzorColor rc = null;
		
		return rc.getName(c);
	}
	
	public String toString() {
		return "Moshav "+super.toString();
				
	}
}
