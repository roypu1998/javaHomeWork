package Country;

public enum RamzorColor {
	
	Green(0.4),
	Yellow(0.6),
	Orange(0.8),
	Red(1.0);
	
	private double ramzor;

	RamzorColor(double ramzorColor) {
		
		this.ramzor=ramzorColor;
	}
	
	public  RamzorColor getName(double rc) {
		
		if (rc <= 0.4)
			return this.Green;
		else if (rc <= 0.6)
			return this.Yellow;
		else if (rc <= 0.8)
			return this.Orange;
		else
			return this.Red;
	}
	
	
	public double getRamzorColor() {
		return this.ramzor;
	}
}
