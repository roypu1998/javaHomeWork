package Country;

import Population.Healthy;
import Population.Person;

public class Map {
	
	private Settlement [] settlements;
	

	public Settlement[] getSettlements() {
		return settlements;
	}
	
	public int Size() {
		return this.settlements.length;
	}
	
	public void setSize(int size) {
		
		this.settlements=new Settlement[size];
	}

	public void updateSettelments(Settlement sett,int index) {
		
		this.getSettlements()[index]=sett;
		
	}
	
	public void printSett() {
		System.out.println("hey2");
		for(int i=0; i<this.getSettlements().length; i++)
			System.out.println(this.getSettlements()[i]);
	}

	public Settlement at(int rowIndex) {

		return this.settlements[rowIndex];
	}
	
	/*
	 * public String toString() { return
	 * "Map {settelment= "+this.settlements.toString()+"}";
	 * 
	 * }
	 */
	
	
	
}
