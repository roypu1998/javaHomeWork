/*
 * 
 * */

package Simulation;
import IO.SimulationFile;
public class Main {
	
	public static void main(String args[]) {
	
		SimulationFile sf=new SimulationFile();
		
		sf.ReadFile();
		
		int size=sf.getSett().getSettlements().length;

		System.out.println("The Lenght Of Settlement Array Is : "+size);
		
		for(int i=0; i<size; i++)
			System.out.println(sf.getSett().getSettlements()[i]);
		
		
	}
	
	
	
	
	

}
