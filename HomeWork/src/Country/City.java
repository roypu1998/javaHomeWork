package Country;

import Location.Location;
import Population.Vaccinated;

public class City extends Settlement {
	
	public City (String name, Location location,RamzorColor ramzorColor) {
		super(name,  location, ramzorColor);
	}

	public RamzorColor calculateRamzorGrade() {
		
		double c = 0.2 *(Math.pow(4, 1.25*super.contagiousPercent()));
		
		RamzorColor rc = null;
		
		return rc.getName(c);
	}
	
	public boolean equals(City c) {
		boolean flag=super.equals(c);
		if(flag) {
			return true;
		}
		return false;
	}
	/*
	 * public String toString() { return "City "+super.toString();
	 * 
	 * }
	 */
}
