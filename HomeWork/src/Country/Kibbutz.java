package Country;

import Location.Location;

public class Kibbutz extends Settlement {
	
	public Kibbutz (String name, Location location,RamzorColor ramzorColor) {
		super(name,  location, ramzorColor);
	}

	
	public RamzorColor calculateRamzorGrade() {
		
		double c = 0.4 + (Math.pow((Math.pow(1.5, super.calculateRamzorGrade().getRamzorColor())*(super.contagiousPercent()-0.4)),3));
		
		RamzorColor rc = null;
		
		return rc.getName(c);
	}
	
	/*
	 * public String toString() { return "Kibbutz "+super.toString();
	 * 
	 * }
	 */
}
