package Country;

import Location.Location;
import Population.Vaccinated;

public class Kibbutz extends Settlement {
	
	public Kibbutz (String name, Location location,RamzorColor ramzorColor) {
		super(name,  location, ramzorColor);
	}

	
	public RamzorColor calculateRamzorGrade() {
		
		double c = 0.4 + (Math.pow((Math.pow(1.5, super.calculateRamzorGrade().getRamzorColor())*(super.contagiousPercent()-0.4)),3));
		
		RamzorColor rc = null;
		
		return rc.getName(c);
	}
	
	public boolean equals(Kibbutz k) {
		boolean flag=super.equals(k);
		if(flag) {
			return true;
		}
		return false;
	}
	
	/*
	 * public String toString() { return "Kibbutz "+super.toString();
	 * 
	 * }
	 */
}
