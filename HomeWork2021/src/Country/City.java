package Country;

public class City extends Settlement {

	public RamzorColor calculateRamzorGrade() {
		
		double c = 0.2 *(Math.pow(4, 1.25*super.contagiousPercent()));
		
		RamzorColor rc = null;
		
		return rc.getName(c);
	}
}
