 /*
  * Names : Roi Putterman && Erelle Boubli ;
  * ID's : 314919010 && 324460443 ;
  */

package Simulation;
import java.util.Random;

import Country.*;
import IO.SimulationFile;
import Population.*;
import Virus.*;
import Location.*;
public class Main {
	
	public static void main(String args[]) {
	
		SimulationFile simulationfile=new SimulationFile();
		
		simulationfile.ReadFile();
		IVirus africanVirus=new SouthAfricanVariant();
		Settlement[] sett= simulationfile.getSett().getSettlements();
		int numOfPpl, sickPpl;
		Sick sc;
		

		System.out.println("making 1% of the people sick \n");

		for (int i=0; i<sett.length;i++) {
			numOfPpl=sett[i].getPeople().size();
			sickPpl=(int) (numOfPpl*0.01);
			
			for (int j=0; j<sett[i].getPeople().size();j+=9) {
				Person p=sett[i].getPeople().get(j);
				sc= new Sick(p.getAge(),p.getLocation(),p.getSettlement(),Clock.now(), africanVirus);
				sett[i].getPeople().remove(p);
				sett[i].addPerson(sc);
			}
		}
		Random rand= new Random();
		int numOfIterations =0;
		while (numOfIterations<5) {
			System.out.println("\n"+ numOfIterations+" iteration: \n");
			boolean succes;
			Person p1, p2;
			for (int i=0; i<sett.length;i++) {
				for (int j=0; j<sett[i].getPeople().size();j++) {
					if(sett[i].getPeople().get(j) instanceof Sick) {
						p1=sett[i].getPeople().get(j);
						for (int h=0; h<6;h++) {
							p2=sett[i].getPeople().get(rand.nextInt(sett[i].getPeople().size()));
							System.out.println("old person: " +p2+"\n");
							succes=africanVirus.tryToContagion(p1, p2);
							System.out.println("the person was affected: "+succes+"\n");
							if (succes ==true) {
								sc=new Sick(p2.getAge(),p2.getLocation(),p2.getSettlement(),Clock.now(), africanVirus);
								System.out.println("new sick ppl created: " +sc+"\n");
								sett[i].getPeople().remove(p2);
								sett[i].addPerson(sc);
								System.out.println(sett[i].getPeople());
							}
	
						}
					}
				}
			}
		}
	
		numOfIterations++;
	}
	
	

}
