package Country;

import java.awt.Color;

public enum RamzorColor {
	
	Green(0.4),
	Yellow(0.6),
	Orange(0.8),
	Red(1.0);
	
	private double ramzor;
	
	private double transferProbability;
	
	private Color color;
	
	RamzorColor(double ramzorColor) {
		
		this.ramzor=ramzorColor;
		this.getColor();
		this.probTrans();
	
	}
	
	public double probTrans() {
		if (this.color.equals(Color.GREEN))
			this.transferProbability=1;
		else if (this.color.equals(Color.YELLOW))
		this.transferProbability=0.8; 
		else if (this.color.equals(Color.ORANGE))
			this.transferProbability=0.6; 
		else if (this.color.equals(Color.RED))
			this.transferProbability=0.4;
		return this.transferProbability;
	}
	
	public Color getColor() {

		if (this.ramzor <= 0.4) 
			this.color=Color.green;
		else if (this.ramzor  <= 0.6)
			this.color=Color.YELLOW;
		else if (this.ramzor  <= 0.8)
			this.color=Color.ORANGE;
		else
			this.color= Color.RED;
		return color;
	}
	
	public  RamzorColor getName(double rc) {
		
		if (rc <= 0.4)
			return Green;
		else if (rc <= 0.6)
			return Yellow;
		else if (rc <= 0.8)
			return Orange;
		else
			return Red;
	}
	
	
	public double getRamzorColor() {
		return this.ramzor;
	}
	
}
