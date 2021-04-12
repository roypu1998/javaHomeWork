package Country;

import Population.Healthy;
import Population.Person;

public class Map {
	
	private Settlement [] settlements;
	

	public Settlement[] getSettlements() {
		return settlements;
	}
	
	public void setSize(int size) {
		
		this.settlements=new Settlement[size];
	}

	public void updateSettelments(Settlement sett,int index) {
		
		this.getSettlements()[index]=sett;
		
	}
	
	
	
	
	
	
}
