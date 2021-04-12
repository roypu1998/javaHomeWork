package Country;

public class Kibbutz extends Settlement {
	
	public RamzorColor calculateRamzorGrade() {
		
		double c = 0.4 + (Math.pow((Math.pow(1.5, super.calculateRamzorGrade().getRamzorColor())*(super.contagiousPercent()-0.4)),3));
		
		RamzorColor rc = null;
		
		return rc.getName(c);
	}

}
