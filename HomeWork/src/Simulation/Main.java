 /*
  * Names : Roi Putterman && Erelle Bubli ;
  * ID's : 314919010 && 324460443 ;
  */

package Simulation;
import Country.*;
import IO.SimulationFile;
import Population.*;
import Virus.*;
import Location.*;
public class Main {
	
	public static void main(String args[]) {
	
		SimulationFile simulationfile=new SimulationFile();
		
		simulationfile.ReadFile();
		
		int size=simulationfile.getSett().getSettlements().length;
		/*
		for(int i=0; i<size; i++)
			System.out.println(simulationfile.getSett().getSettlements()[i]);
			*/		
		Point point1=new Point();
		Point point2=new Point();
		
		point1.setX(20);
		point1.setY(80);

		point2.setX(1);
		point2.setY(2);
		
		Settlement sett=new Settlement();

		Person p1=new Sick(20,point1,simulationfile.getSett().getSettlements()[0],0,new ChineseVariant());
		
		Person p2=new Healthy(28,point2,simulationfile.getSett().getSettlements()[0]);
		
		IVirus virus=new SouthAfricanVariant();
		
		virus.tryToContagion(p1, p2);
		
		
	}
	
	
	
	
	

}
