package Country;

import Population.Healthy;
import Population.Person;

public class Map implements Iterator{
	
	private Settlement [] settlements;
	

	public Settlement[] getSettlements() {
		return settlements;
	}
	
	
	public int Size() {
		return this.settlements.length;
	}
	

	@Override
	public void updateSettelments(Settlement sett,int index) {
		this.getSettlements()[index]=sett;
		
	}

	@Override
	public Settlement at(int rowIndex) {
		return this.settlements[rowIndex];
	}

	
	public void setSize(int size) {	
			this.settlements=new Settlement[size];
	}
	
	/*
	 * public String toString() { return
	 * "Map {settelment= "+this.settlements.toString()+"}";
	 * 
	 * }
	 */
	
	
	
}
